package Base.driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import static org.testng.Assert.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver openBrowser(String URL) {
        try {
            WebDriver driver = BrowserFactory.getBrowser(System.getProperty("browser", "chrome"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(URL);
            setDriver(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
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
