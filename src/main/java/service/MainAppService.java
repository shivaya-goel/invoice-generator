package service;

import exception.JFrameException;
import model.AppComponents;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainAppService {

    private ProcessingService processingService;
    private SettingsService settingsService;
    private AppConstructService appConstructService;

    public MainAppService(ProcessingService processingService, SettingsService settingsService, AppConstructService appConstructService) {
        this.processingService = processingService;
        this.settingsService = settingsService;
        this.appConstructService = appConstructService;
    }

    public void launchApp() {
        JFrame appFrame = appConstructService.getAppFrame();
        configureButtons(appFrame, appConstructService.getAppComponents());
    }

    private void configureButtons(JFrame frame, AppComponents appComponents) {
        configureInputFileButton(frame, appComponents);
        configureOutputDirButton(frame, appComponents);
        configureProcessButton(frame, appComponents);
        configureSettingsButton(frame, appComponents);
    }

    private void configureInputFileButton(JFrame frame, AppComponents appComponents) {
        appComponents.getInputFileButton().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                appComponents.getInputFileField().setText(selectedFile.getAbsolutePath());
            }
        });
    }

    private void configureOutputDirButton(JFrame frame, AppComponents appComponents) {
        appComponents.getOutputDirButton().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                appComponents.getOutputDirField().setText(selectedFile.getAbsolutePath());
            }
        });
    }

    private void configureProcessButton(JFrame frame, AppComponents appComponents) {
        appComponents.getProcessButton().addActionListener(e -> {
            String inputFile = appComponents.getInputFileField().getText();
            String outputDir = appComponents.getOutputDirField().getText();
            String seriesName = appComponents.getSeriesNameField().getText();
            try {
                processingService.saveBillsToExcelFiles(inputFile, outputDir, seriesName);
                JOptionPane.showMessageDialog(frame, "File processing completed!");
            } catch (IOException ex) {
                throw new JFrameException(frame, "Failure in converting files");
            }
        });
    }

    private void configureSettingsButton(JFrame frame, AppComponents appComponents) {
        appComponents.getConfigButton().addActionListener(e -> {
            settingsService.openSettings();
        });
    }

}
