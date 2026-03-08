package AutomationExercise.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){
    }

    public static void ValidateTrue(Boolean condition, String message){
        Assert.assertTrue(condition,message);
    }

    public static void ValidateFalse(Boolean condition, String message){
        Assert.assertFalse(condition,message);
    }

    public static void ValidateEquals(String Actual, String expected, String message){
        Assert.assertEquals(Actual,expected,message);
    }

    public static void ValidateNotEqual(String Actual, String expected, String message){
        Assert.assertNotEquals(Actual,expected,message);
    }

    public static void ValidatePageUrl(WebDriver driver,String expected){
        Assert.assertEquals(BrowserActions.GetCurrentUrl(driver),expected);
    }

    public static void ValidatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentTitle(driver),expected);
    }
}
