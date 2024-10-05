package model;

import javax.swing.*;

public class SettingPane {

    private JLabel billNoLabel;
    private JTextField billNoColumnField;
    private JLabel billDateLabel;
    private JTextField billDateColumnField;
    private JLabel accountNameLabel;
    private JTextField accountNameColumnField;
    private JLabel itemCodeLabel;
    private JTextField itemCodeColumnField;
    private JLabel qtyLabel;
    private JTextField qtyColumnField;
    private JLabel freeQtyLabel;
    private JTextField freeQtyColumnField;
    private JLabel saleRateLabel;
    private JTextField saleRateColumnField;
    private JLabel discountLabel;
    private JTextField discountColumnField;
    private JButton saveButton;


    public JLabel getBillNoLabel() {
        return billNoLabel;
    }

    public void setBillNoLabel(String name) {
        this.billNoLabel = new JLabel(name);
    }

    public JLabel getBillDateLabel() {
        return billDateLabel;
    }

    public void setBillDateLabel(String name) {
        this.billDateLabel = new JLabel(name);
    }

    public JLabel getAccountNameLabel() {
        return accountNameLabel;
    }

    public void setAccountNameLabel(String name) {
        this.accountNameLabel = new JLabel(name);
    }

    public JLabel getItemCodeLabel() {
        return itemCodeLabel;
    }

    public void setItemCodeLabel(String name) {
        this.itemCodeLabel = new JLabel(name);
    }

    public JLabel getQtyLabel() {
        return qtyLabel;
    }

    public void setQtyLabel(String name) {
        this.qtyLabel = new JLabel(name);
    }

    public JLabel getFreeQtyLabel() {
        return freeQtyLabel;
    }

    public void setFreeQtyLabel(String name) {
        this.freeQtyLabel = new JLabel(name);
    }

    public JLabel getSaleRateLabel() {
        return saleRateLabel;
    }

    public void setSaleRateLabel(String name) {
        this.saleRateLabel = new JLabel(name);
    }

    public JLabel getDiscountLabel() {
        return discountLabel;
    }

    public void setDiscountLabel(String name) {
        this.discountLabel = new JLabel(name);
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(String name) {
        this.saveButton = new JButton(name);
    }
    public JTextField getBillNoColumnField() {
        return billNoColumnField;
    }

    public void setBillNoColumnField(int columns) {
        this.billNoColumnField = new JTextField(columns);
    }

    public JTextField getBillDateColumnField() {
        return billDateColumnField;
    }

    public void setBillDateColumnField(int columns) {
        this.billDateColumnField = new JTextField(columns);
    }

    public JTextField getAccountNameColumnField() {
        return accountNameColumnField;
    }

    public void setAccountNameColumnField(int columns) {
        this.accountNameColumnField = new JTextField(columns);
    }

    public JTextField getItemCodeColumnField() {
        return itemCodeColumnField;
    }

    public void setItemCodeColumnField(int columns) {
        this.itemCodeColumnField = new JTextField(columns);
    }

    public JTextField getQtyColumnField() {
        return qtyColumnField;
    }

    public void setQtyColumnField(int columns) {
        this.qtyColumnField = new JTextField(columns);
    }

    public JTextField getFreeQtyColumnField() {
        return freeQtyColumnField;
    }

    public void setFreeQtyColumnField(int columns) {
        this.freeQtyColumnField = new JTextField(columns);
    }

    public JTextField getSaleRateColumnField() {
        return saleRateColumnField;
    }

    public void setSaleRateColumnField(int columns) {
        this.saleRateColumnField = new JTextField(columns);
    }

    public JTextField getDiscountColumnField() {
        return discountColumnField;
    }

    public void setDiscountColumnField(int columns) {
        this.discountColumnField = new JTextField(columns);
    }

}
