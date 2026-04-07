package AutomationExercise.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String Allure_results_path = "test-outputs/allure-results";

    private AllureUtils(){
        super();
    }

    public static void attachLogsToAllureReport(){
        try {
            File logFile = FilesUtils.getLatestFile(LogsUtil.Logs_Path);
            if (!logFile.exists()){
                LogsUtil.warn("Log file does not exist: " + LogsUtil.Logs_Path);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("Logs attached to Allure report");
        }catch (Exception e){
            LogsUtil.error("Failed to attach logs to allure report: " + e.getMessage());
        }
    }

    public static void attachScreenShotToAllure(String screenshotName, String screenshotPath){
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        }catch (Exception e){
            LogsUtil.error("Failed to attach screenshot to allure report" + e.getMessage());
        }
    }
}
