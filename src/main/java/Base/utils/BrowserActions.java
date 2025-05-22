package Base.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

public class BrowserActions {
    private BrowserActions() {
    }

    public static void navigateToURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void goBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static void goForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(screenshotName, new ByteArrayInputStream(screenshotBytes));
        } catch (Exception e) {
            System.out.println(" Failed to capture screenshot: " + e.getMessage());
        }
    }
}

