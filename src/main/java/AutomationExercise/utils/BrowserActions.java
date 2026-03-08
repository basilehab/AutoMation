package AutomationExercise.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){
    }

    public static void NavigateToWebsite(WebDriver driver, String url){
        driver.get(url);
    }

    //get current url "for assertion"
    public static String GetCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    //Get current title
    public static String getCurrentTitle(WebDriver driver){
        return driver.getTitle();
    }

    //Refresh Page
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
}
