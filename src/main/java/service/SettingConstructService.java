package service;

import model.SettingPane;

import javax.swing.*;
import java.awt.*;

public class SettingConstructService {

    private SettingPane settingPane;

    public SettingPane getSettingPane() {
        return this.settingPane;
    }

    public JFrame constructFrame() {
        JFrame settingsFrame = new JFrame("Configuration Settings");
        settingsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        SettingPane settingPane = createSettingPane();
        JPanel panel = new JPanel(new GridLayout(9, 2));
        setComponentsPanel(panel, settingPane);
        settingsFrame.getContentPane().add(BorderLayout.CENTER, panel);
        settingsFrame.pack();
        settingsFrame.setVisible(true);
        this.settingPane = settingPane;
        return settingsFrame;
    }

    private SettingPane createSettingPane() {
        SettingPane settingPane = new SettingPane();

        settingPane.setBillNoLabel("Bill No Column:");
        settingPane.setBillNoColumnField(20);

        settingPane.setBillDateLabel("Bill Date Column:");
        settingPane.setBillDateColumnField(20);

        settingPane.setAccountNameLabel("Account Name Column:");
        settingPane.setAccountNameColumnField(20);

        settingPane.setItemCodeLabel("Item Code Column:");
        settingPane.setItemCodeColumnField(20);

        settingPane.setQtyLabel("Quantity Column:");
        settingPane.setQtyColumnField(20);

        settingPane.setFreeQtyLabel("Free Quantity Column:");
        settingPane.setFreeQtyColumnField(20);

        settingPane.setSaleRateLabel("Sale Rate Column:");
        settingPane.setSaleRateColumnField(20);

        settingPane.setDiscountLabel("Discount Column:");
        settingPane.setDiscountColumnField(20);

        settingPane.setSaveButton("Save");
        return settingPane;
    }

    private void setComponentsPanel(JPanel panel, SettingPane settingPane) {
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        panel.add(settingPane.getBillNoLabel());
        panel.add(settingPane.getBillNoColumnField());
        panel.add(settingPane.getBillDateLabel());
        panel.add(settingPane.getBillDateColumnField());
        panel.add(settingPane.getAccountNameLabel());
        panel.add(settingPane.getAccountNameColumnField());
        panel.add(settingPane.getItemCodeLabel());
        panel.add(settingPane.getItemCodeColumnField());
        panel.add(settingPane.getQtyLabel());
        panel.add(settingPane.getQtyColumnField());
        panel.add(settingPane.getFreeQtyLabel());
        panel.add(settingPane.getFreeQtyColumnField());
        panel.add(settingPane.getSaleRateLabel());
        panel.add(settingPane.getSaleRateColumnField());
        panel.add(settingPane.getDiscountLabel());
        panel.add(settingPane.getDiscountColumnField());
        panel.add(settingPane.getSaveButton());
    }
}
