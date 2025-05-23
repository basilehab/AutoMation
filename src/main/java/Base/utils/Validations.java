package Base.utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Validations {
    private Validations() {
    }

    public static void ValidationTrue(boolean condition, String massage) {
        Assert.assertTrue(condition, massage);
    }

    public static void ValidationFalse(boolean condition, String massage) {
        Assert.assertFalse(condition, massage);
    }

    public static void ValidationEqual(String actual, String expected, String massage) {
        Assert.assertEquals(actual, expected, massage);
    }

    public static void ValidationNotEqual(String actual, String expected, String massage) {
        Assert.assertNotEquals(actual, expected, massage);
    }

    public static void ValidationPageUrl(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), expected);
    }
    public static void ValidationPageTitle(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getCurrentTitle(driver), expected);
    }
}

