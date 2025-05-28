package Base.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

public class BrowserActions {
    private BrowserActions() {
    }
    @Step("navigating to url: {url}")
    public static void navigateToURL(WebDriver driver, String url) {
        LogsUtil.info("navigating to url: " , url);
        driver.get(url);
    }

    public static String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getCurrentTitle(WebDriver driver) {
        return driver.getTitle();
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
}

