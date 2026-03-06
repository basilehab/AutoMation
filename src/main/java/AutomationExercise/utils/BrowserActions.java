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
}
