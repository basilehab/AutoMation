package AutomationExercise.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){
    }

    public static void NavigateToWebsite(WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigate to url: ", url);
    }

    //get current url "for assertion"
    public static String GetCurrentUrl(WebDriver driver){
        LogsUtil.info("Current url: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }

    //Get current title
    public static String getCurrentTitle(WebDriver driver){
        LogsUtil.info("Page Title: ", driver.getTitle());
        return driver.getTitle();
    }

    //Refresh Page
    public static void refreshPage(WebDriver driver){
        LogsUtil.info("Refreshing page.. ");
        driver.navigate().refresh();
    }

    //closing the browser
    public static void quitTheBrowser(WebDriver driver){
        LogsUtil.info("Closing the browser");
        driver.quit();
    }
}
