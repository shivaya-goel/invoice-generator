package model;

import javax.swing.*;
import java.awt.*;

public class AppComponents {

    private JLabel seriesNameLabel;

    private JTextField seriesNameField;

    private JLabel inputFileLabel;

    private JTextField inputFileField;

    private JButton inputFileButton;

    private JLabel outputDirLabel;

    private JTextField outputDirField;

    private JButton outputDirButton;

    private JButton processButton;

    private JButton configButton;

    private JLabel authorLabel;

    public JLabel getSeriesNameLabel() {
        return seriesNameLabel;
    }

    public void setSeriesNameLabel(String name) {
        this.seriesNameLabel = new JLabel(name);
    }

    public void setSeriesNameLabelLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
    }

    public JTextField getSeriesNameField() {
        return seriesNameField;
    }

    public void setSeriesNameField(int columns) {
        this.seriesNameField = new JTextField(columns);
    }

    public void setSeriesNameFieldLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 1;
    }

    public JLabel getInputFileLabel() {
        return inputFileLabel;
    }

    public void setInputFileLabel(String name) {
        this.inputFileLabel = new JLabel(name);
    }

    public void setInputFileLabelLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 2;
    }

    public JTextField getInputFileField() {
        return inputFileField;
    }

    public void setInputFileField(int columns) {
        this.inputFileField = new JTextField(columns);
    }

    public void setInputFileFieldLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 3;
    }

    public JButton getInputFileButton() {
        return inputFileButton;
    }

    public void setInputFileButton(String name) {
        this.inputFileButton = new JButton(name);
    }

    public void setInputFileButtonLayout(GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = 3;
    }

    public JLabel getOutputDirLabel() {
        return outputDirLabel;
    }

    public void setOutputDirLabel(String name) {
        this.outputDirLabel = new JLabel(name);
    }

    public void setOutputDirLabelLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 4;
    }

    public JTextField getOutputDirField() {
        return outputDirField;
    }

    public void setOutputDirField(int columns) {
        this.outputDirField = new JTextField(columns);
    }

    public void setOutputDirFieldLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 5;
    }

    public JButton getOutputDirButton() {
        return outputDirButton;
    }

    public void setOutputDirButton(String name) {
        this.outputDirButton = new JButton(name);
    }

    public void setOutputDirButtonLayout(GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = 5;
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public void setProcessButton(String name) {
        this.processButton = new JButton(name);
    }

    public void setProcessButtonLayout(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Span across two columns
    }

    public JButton getConfigButton() {
        return configButton;
    }

    public void setConfigButton(String name) {
        this.configButton = new JButton(name);
    }

    public void setConfigButtonLayout(GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = 1;
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public void setAuthorLabel(String name) {
        this.authorLabel = new JLabel(name);
    }

    public void setAuthorLabelLayout(GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;
    }
}
