package service;

import model.AppComponents;

import javax.swing.*;
import java.awt.*;

public class AppConstructService {

    private AppComponents appComponents;

    public JFrame getAppFrame() {
        JFrame frame = new JFrame("Excel Processor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AppComponents appComponents = createComponents();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new  GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        fillFrameWithComponents(frame, appComponents, gbc);
        this.appComponents = appComponents;
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private void fillFrameWithComponents(JFrame frame, AppComponents appComponents, GridBagConstraints gbc) {

        appComponents.setSeriesNameLabelLayout(gbc);
        frame.add(appComponents.getSeriesNameLabel(), gbc);

        appComponents.setSeriesNameFieldLayout(gbc);
        frame.add(appComponents.getSeriesNameField(), gbc);

        appComponents.setInputFileLabelLayout(gbc);
        frame.add(appComponents.getInputFileLabel(), gbc);

        appComponents.setInputFileFieldLayout(gbc);
        frame.add(appComponents.getInputFileField(), gbc);

        appComponents.setInputFileButtonLayout(gbc);
        frame.add(appComponents.getInputFileButton(), gbc);

        appComponents.setOutputDirLabelLayout(gbc);
        frame.add(appComponents.getOutputDirLabel(), gbc);

        appComponents.setOutputDirFieldLayout(gbc);
        frame.add(appComponents.getOutputDirField(), gbc);

        appComponents.setOutputDirButtonLayout(gbc);
        frame.add(appComponents.getOutputDirButton(), gbc);

        appComponents.setProcessButtonLayout(gbc);
        frame.add(appComponents.getProcessButton(), gbc);

        appComponents.setConfigButtonLayout(gbc);
        frame.add(appComponents.getConfigButton(), gbc);

        appComponents.setAuthorLabelLayout(gbc);
        frame.add(appComponents.getAuthorLabel(), gbc);
    }

    private AppComponents createComponents() {
        AppComponents appComponents = new AppComponents();
        appComponents.setSeriesNameLabel("Enter series name");
        appComponents.setSeriesNameField(50);
        appComponents.setInputFileLabel("Select input file:");
        appComponents.setInputFileField(50);
        appComponents.setInputFileButton("Browse");
        appComponents.setOutputDirLabel("Select output directory:");
        appComponents.setOutputDirField(50);
        appComponents.setOutputDirButton("Browse");
        appComponents.setProcessButton("Process");
        appComponents.setConfigButton("Settings");
        appComponents.setAuthorLabel("-By Shivaya Goel");
        JLabel authorLabel = appComponents.getAuthorLabel();
        authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        authorLabel.setForeground(Color.GRAY);
        return appComponents;
    }

    public AppComponents getAppComponents() {
        return appComponents;
    }
}