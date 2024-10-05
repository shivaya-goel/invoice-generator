import service.*;

import javax.swing.*;

public class ExcelProcessor {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SettingConstructService settingConstructService = new SettingConstructService();
            SettingsService settingsService = new SettingsService(settingConstructService);
            ProcessingService processingService = new ProcessingService(settingsService);
            AppConstructService appConstructService = new AppConstructService();

            MainAppService appService = new MainAppService(processingService, settingsService, appConstructService);

            appService.launchApp();
//            settingsService.openSettings();
        });
    }

}
