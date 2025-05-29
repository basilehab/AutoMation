package Base.driver;

import Base.utils.LogsUtil;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;
import io.qameta.allure.Step;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {}

    @Step("Create driver instance on: {browserName}")
    public static WebDriver openBrowser(String browserName) {
            WebDriver driver = BrowserFactory.getBrowser(browserName);
            LogsUtil.info("Driver created on: ", browserName);
            setDriver(driver);
        return getDriver();
    }
    @Step
    public static void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtil.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
