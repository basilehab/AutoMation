package AutomationExercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){
    }

    @Step("Validate True")
    public static void ValidateTrue(Boolean condition, String message){
        Assert.assertTrue(condition,message);
    }

    @Step("Validate Flase")
    public static void ValidateFalse(Boolean condition, String message){
        Assert.assertFalse(condition,message);
    }

    @Step("Validate Equals")
    public static void ValidateEquals(String Actual, String expected, String message){
        Assert.assertEquals(Actual,expected,message);
    }

    @Step("Validate Not Equals")
    public static void ValidateNotEqual(String Actual, String expected, String message){
        Assert.assertNotEquals(Actual,expected,message);
    }

    @Step("Validate Page URL: {expected}")
    public static void ValidatePageUrl(WebDriver driver,String expected){
        Assert.assertEquals(BrowserActions.GetCurrentUrl(driver),expected);
    }

    @Step("Validate page title: {expected}")
    public static void ValidatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentTitle(driver),expected);
    }
}
