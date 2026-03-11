package AutomationExercise.drivers;

import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager(){
        super();
    }

    public static WebDriver createInstance(String BrowserName){
        WebDriver driver = BrowserFactory.getBrowser(BrowserName);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver(){
        if (driverThreadLocal.get() == null){
            fail("driver is null");
        }
        return driverThreadLocal.get();
    }

    private static void setDriver(WebDriver driver) { driverThreadLocal.set(driver);
    }
}
