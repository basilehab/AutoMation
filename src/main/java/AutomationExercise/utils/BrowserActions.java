package AutomationExercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){
    }

    @Step("Navigating to URL: {url}")
    public static void NavigateToWebsite(WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigate to url: ", url);
    }

    //get current url "for assertion"
    @Step("Get current URL")
    public static String GetCurrentUrl(WebDriver driver){
        LogsUtil.info("Current url: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }

    //Get current title
    @Step("Get Page title")
    public static String getCurrentTitle(WebDriver driver){
        LogsUtil.info("Page Title: ", driver.getTitle());
        return driver.getTitle();
    }

    //Refresh Page
    @Step("refreshing the page")
    public static void refreshPage(WebDriver driver){
        LogsUtil.info("Refreshing page.. ");
        driver.navigate().refresh();
    }

    //closing the browser
    @Step("Closing the browser")
    public static void quitTheBrowser(WebDriver driver){
        LogsUtil.info("Closing the browser");
        driver.quit();
    }
}
