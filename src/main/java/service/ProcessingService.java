package service;

import exception.JFrameException;
import model.Bill;
import model.ExcelConfig;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProcessingService {

    private SettingsService settingsService;

    public ProcessingService(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    public void saveBillsToExcelFiles(String input, String output, String series) throws IOException {

        if(series.isBlank()) {
            series = "GST";
        }
        System.out.println("Read attempt started");
        List<Bill> Bills = readExcelFile(input, series);
        System.out.println("Read attempt success");
        Map<Integer, List<Bill>> billsByBillNo = groupBillsByAge(Bills);

        for (Map.Entry<Integer, List<Bill>> entry : billsByBillNo.entrySet()) {
            int billNo = entry.getKey();
            List<Bill> products = entry.getValue();
            System.out.println("Export Bill No : " + billNo);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("HUL " + billNo);

            createHeaderRow(sheet);
            populateDataRows(sheet, products);

            String outputFileName = series.toUpperCase() + "-" + billNo + ".xlsx";

            FileOutputStream fos = new FileOutputStream(output + "/" + outputFileName);
            workbook.write(fos);
            fos.close();

            workbook.close();
        }
        System.out.println("Total Bills exported : " + billsByBillNo.size());
    }

    private List<Bill> readExcelFile(String input, String series) {
        List<Bill> listOfBills = new ArrayList<>();

        ExcelConfig excelConfig = settingsService.getExcelConfig();
        if (Objects.isNull(excelConfig)) {
            excelConfig = new ExcelConfig();
        }
        int totalRows = 1;
        Sheet sheet;
        try (FileInputStream fis = new FileInputStream(input)) {
            Workbook workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheetAt(0);
            workbook.close();
        } catch(Exception e) {
            throw new JFrameException(null, "Invalid input file");
        }
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String billNo;
            Date billDate;
            String accountName;
            String itemCode;
            String qty;
            String freeQty;
            String saleRate;
            double discount;

            Bill bill = new Bill();

            try {
                billNo = row.getCell(excelConfig.getBillNoColumn()).getStringCellValue();
                bill.setBillNo(convertBillNo(billNo, series));
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Bill No at row " + totalRows + " and at col " + excelConfig.getBillDateColumn());
            }

            try {
                billDate = row.getCell(excelConfig.getBillDateColumn()).getDateCellValue();
                bill.setBillDate(convertBillDate(billDate));
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Bill Date at row " + totalRows + " and at col " + excelConfig.getBillDateColumn());
            }

            try {
                accountName = row.getCell(excelConfig.getAccountNameColumn()).getStringCellValue();
                bill.setAccountName(accountName);
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Account Name at row " + totalRows + " and at col " + excelConfig.getAccountNameColumn());
            }

            bill.setAgentName(null);
            try {
                itemCode = row.getCell(excelConfig.getItemCodeColumn()).getStringCellValue();
                bill.setItemCode(itemCode);
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Item Code at row " + totalRows + " and at col " + excelConfig.getItemCodeColumn());
            }

            try {
                qty = row.getCell(excelConfig.getQtyColumn()).getStringCellValue();
                bill.setQty(qty);
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Qty at row " + totalRows + " and at col " + excelConfig.getQtyColumn());
            }

            try {
                freeQty = row.getCell(excelConfig.getFeeQtyColumn()).getStringCellValue();
                bill.setFreeQty(freeQty != "0" ? freeQty : null);
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Free Qty at row " + totalRows + " and at col " + excelConfig.getFeeQtyColumn());
            }

            try {
                saleRate = row.getCell(excelConfig.getSaleRateColumn()).getStringCellValue();
                bill.setSaleRate(saleRate);
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Sale Rate at row " + totalRows + " and at col " + excelConfig.getSaleRateColumn());
            }

            bill.setCd(null);
            try {
                discount = row.getCell(excelConfig.getDiscountColumn()).getNumericCellValue();
                bill.setDiscount(String.valueOf(discount));
            } catch (Exception e) {
                totalRows++;
                throw new JFrameException(null, "Invalid Discount at row " + totalRows + " and at col " + excelConfig.getDiscountColumn());
            }

            bill.setCreditNoteAmount(null);

            listOfBills.add(bill);
            totalRows++;
        }
        System.out.println("Total rows read : "+ totalRows);

        return listOfBills;
    }

    private String convertBillDate(Date billDate) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        return outputFormat.format(billDate);
    }

    private Integer convertBillNo(String billNo, String seriesName) {
        String bill = billNo.replace(seriesName, "");
        return Integer.parseInt(bill);
    }

    private Map<Integer, List<Bill>> groupBillsByAge(List<Bill> Bills) {
        Map<Integer, List<Bill>> billsByBillNo = new HashMap<>();

        for (Bill bill : Bills) {
            Integer billNo = bill.getBillNo();
            List<Bill> billsWithSameId = billsByBillNo.getOrDefault(billNo, new ArrayList<>());
            billsWithSameId.add(bill);
            billsByBillNo.put(billNo, billsWithSameId);
        }
        return billsByBillNo;
    }

    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);

        Cell billNo = headerRow.createCell(0);
        billNo.setCellValue("BILL NO");

        Cell billDate = headerRow.createCell(1);
        billDate.setCellValue("BILL DATE");

        Cell accountName = headerRow.createCell(2);
        accountName.setCellValue("ACCOUNT NAME");

        Cell agentName = headerRow.createCell(3);
        agentName.setCellValue("AGENT NAME");

        Cell itemCode = headerRow.createCell(4);
        itemCode.setCellValue("ITEMCODE");

        Cell qty = headerRow.createCell(5);
        qty.setCellValue("QTY");

        Cell freeQty = headerRow.createCell(6);
        freeQty.setCellValue("FREE QTY");

        Cell saleRate = headerRow.createCell(7);
        saleRate.setCellValue("SALE RATE");

        Cell cd = headerRow.createCell(8);
        cd.setCellValue("CD%");

        Cell discountRs = headerRow.createCell(9);
        discountRs.setCellValue("DISCOUNT RS.");

        Cell crNoteAmt = headerRow.createCell(10);
        crNoteAmt.setCellValue("CR NOTE AMT");
    }

    private void populateDataRows(Sheet sheet, List<Bill> Bills) {
        int rowNum = 1;

        for (Bill bill : Bills) {
            Row row = sheet.createRow(rowNum++);

            Cell billNo = row.createCell(0);
            billNo.setCellValue(bill.getBillNo());

            Cell billDate = row.createCell(1);
            billDate.setCellValue(bill.getBillDate());

            Cell accountName = row.createCell(2);
            accountName.setCellValue(bill.getAccountName());

            Cell agentName = row.createCell(3);
            agentName.setCellValue(bill.getAgentName());

            Cell itemCode = row.createCell(4);
            itemCode.setCellValue(bill.getItemCode());

            Cell qty = row.createCell(5);
            qty.setCellValue(bill.getQty());

            Cell freeQty = row.createCell(6);
            freeQty.setCellValue(bill.getFreeQty());

            Cell saleRate = row.createCell(7);
            saleRate.setCellValue(bill.getSaleRate());

            Cell cd = row.createCell(8);
            cd.setCellValue(bill.getCd());

            Cell discountRs = row.createCell(9);
            discountRs.setCellValue(bill.getDiscount());

            Cell crNoteAmt = row.createCell(10);
            crNoteAmt.setCellValue(bill.getCreditNoteAmount());
        }
    }

}
