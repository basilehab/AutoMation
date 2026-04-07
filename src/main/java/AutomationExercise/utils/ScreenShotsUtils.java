package AutomationExercise.utils;

import AutomationExercise.drivers.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenShotsUtils {

    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots/";

    private ScreenShotsUtils(){
        super();
    }

    public static void takeScreenshot(String screenshotName){
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + ".png");
            FileUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenShotToAllure(screenshotName, screenshotFile.getPath());
        }catch (Exception e){
            LogsUtil.error("Failed to take screenshot: " + e.getMessage());
        }

    }

}
