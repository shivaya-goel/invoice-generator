package model;

import exception.JFrameException;

import javax.swing.*;

public class ExcelConfig {

    private int billNoColumn = 6;
    private int billDateColumn = 8;
    private int accountNameColumn = 3;
    private int itemCodeColumn = 10;
    private int qtyColumn = 19;
    private int freeQtyColumn = 20;
    private int saleRateColumn = 14;
    private int discountColumn = 26;

    public ExcelConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public ExcelConfig(ExcelConfig excelConfig) {
        this.billNoColumn = excelConfig.getBillNoColumn();
        this.billDateColumn = excelConfig.getBillDateColumn();
        this.accountNameColumn = excelConfig.getAccountNameColumn();
        this.itemCodeColumn = excelConfig.getItemCodeColumn();
        this.qtyColumn = excelConfig.getQtyColumn();
        this.freeQtyColumn = excelConfig.getFeeQtyColumn();
        this.saleRateColumn = excelConfig.getSaleRateColumn();
        this.discountColumn = excelConfig.getDiscountColumn();
    }

    public int getBillNoColumn() {
        return billNoColumn;
    }

    public void setBillNoColumn(int billNoColumn) {
        this.billNoColumn = billNoColumn;
    }

    public int getBillDateColumn() {
        return billDateColumn;
    }

    public void setBillDateColumn(int billDateColumn) {
        this.billDateColumn = billDateColumn;
    }

    public int getAccountNameColumn() {
        return accountNameColumn;
    }

    public void setAccountNameColumn(int accountNameColumn) {
        this.accountNameColumn = accountNameColumn;
    }

    public int getItemCodeColumn() {
        return itemCodeColumn;
    }

    public void setItemCodeColumn(int itemCodeColumn) {
        this.itemCodeColumn = itemCodeColumn;
    }

    public int getQtyColumn() {
        return qtyColumn;
    }

    public void setQtyColumn(int qtyColumn) {
        this.qtyColumn = qtyColumn;
    }

    public int getFeeQtyColumn() {
        return freeQtyColumn;
    }

    public void setFeeQtyColumn(int feeQtyColumn) {
        this.freeQtyColumn = feeQtyColumn;
    }

    public int getSaleRateColumn() {
        return saleRateColumn;
    }

    public void setSaleRateColumn(int saleRateColumn) {
        this.saleRateColumn = saleRateColumn;
    }

    public int getDiscountColumn() {
        return discountColumn;
    }

    public void setDiscountColumn(int discountColumn) {
        this.discountColumn = discountColumn;
    }

    public static class Builder {

        String billNoText;
        String billDateText;
        String accountNameText;
        String itemCodeText;
        String qtyText;
        String freeQtyText;
        String saleRateText;
        String discountText;
        ExcelConfig excelConfig;
        JFrame jFrame;

        public Builder billNoColumnField(String billNoText) {
            this.billNoText = billNoText;
            return this;
        }

        public Builder billDateColumnField(String billDateText) {
            this.billDateText = billDateText;
            return this;
        }

        public Builder accountNameColumnField(String accountNameText) {
            this.accountNameText = accountNameText;
            return this;
        }

        public Builder itemCodeColumnField(String itemCodeText) {
            this.itemCodeText = itemCodeText;
            return this;
        }

        public Builder qtyColumnField(String qtyText) {
            this.qtyText = qtyText;
            return this;
        }

        public Builder freeQtyColumnField(String freeQtyText) {
            this.freeQtyText = freeQtyText;
            return this;
        }

        public Builder saleRateColumnField(String saleRateText) {
            this.saleRateText = saleRateText;
            return this;
        }

        public Builder discountColumnField(String discountText) {
            this.discountText = discountText;
            return this;
        }

        public Builder jFrame(JFrame jFrame) {
            this.jFrame = jFrame;
            return this;
        }

        public ExcelConfig build() {
            ExcelConfig excelConfig = new ExcelConfig();
            try {
                String billNoText = this.billNoText;
                int columnNo = Integer.parseInt(billNoText);
                excelConfig.setBillNoColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Bill No Column");
            }
            try {
                String billDateText = this.billDateText;
                int columnNo = Integer.parseInt(billDateText);
                excelConfig.setBillDateColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Bill Date Column");
            }
            try {
                String accountNameText = this.accountNameText;
                int columnNo = Integer.parseInt(accountNameText);
                excelConfig.setAccountNameColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Account Name Column");
            }
            try {
                String itemCodeText = this.itemCodeText;
                int columnNo = Integer.parseInt(itemCodeText);
                excelConfig.setItemCodeColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Item Code Column");
            }
            try {
                String qtyText = this.qtyText;
                int columnNo = Integer.parseInt(qtyText);
                excelConfig.setQtyColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Qty Column");
            }
            try {
                String freeQtyText = this.freeQtyText;
                int columnNo = Integer.parseInt(freeQtyText);
                excelConfig.setFeeQtyColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Free Qty Column");
            }
            try {
                String saleRateText = this.saleRateText;
                int columnNo = Integer.parseInt(saleRateText);
                excelConfig.setSaleRateColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Sale Rate Column");
            }
            try {
                String discountText = this.discountText;
                int columnNo = Integer.parseInt(discountText);
                excelConfig.setDiscountColumn(columnNo);
            } catch (Exception e) {
                throw new JFrameException(jFrame, "Invalid Discount Column");
            }
            return excelConfig;
        }
    }
}