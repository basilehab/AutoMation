package Base.driver;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver openBrowser(String browserName) {
            WebDriver driver = BrowserFactory.getBrowser(browserName);
            setDriver(driver);
        return getDriver();
    }

    public static void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
