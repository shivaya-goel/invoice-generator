package service;

import model.ExcelConfig;
import model.SettingPane;

import javax.swing.*;

public class SettingsService {

    private SettingConstructService constructService;
    private ExcelConfig excelConfig;

    public SettingsService(SettingConstructService constructService) {
        this.constructService = constructService;
    }

    public ExcelConfig getExcelConfig() {
        return this.excelConfig;
    }

    public void openSettings() {
        JFrame settingsFrame = constructService.constructFrame();
        configureButtons(settingsFrame, constructService.getSettingPane());
    }

    public void configureButtons(JFrame settingsFrame, SettingPane settingPane) {
        configureSaveButton(settingsFrame, settingPane);
    }

    private void configureSaveButton(JFrame settingsFrame, SettingPane settingPane) {
        settingPane.getSaveButton().addActionListener(e -> {
            saveSettings(settingsFrame, settingPane);
            settingsFrame.dispose();
        });
    }

    private void saveSettings(JFrame settingsFrame, SettingPane settingPane) {
        ExcelConfig excelConfig = ExcelConfig.builder()
                .billNoColumnField(settingPane.getBillNoColumnField().getText())
                .billDateColumnField(settingPane.getBillDateColumnField().getText())
                .accountNameColumnField(settingPane.getAccountNameColumnField().getText())
                .itemCodeColumnField(settingPane.getItemCodeColumnField().getText())
                .qtyColumnField(settingPane.getQtyColumnField().getText())
                .freeQtyColumnField(settingPane.getFreeQtyColumnField().getText())
                .saleRateColumnField(settingPane.getSaleRateColumnField().getText())
                .discountColumnField(settingPane.getDiscountColumnField().getText())
                .jFrame(settingsFrame)
                .build();
        this.excelConfig = excelConfig;
    }

}
