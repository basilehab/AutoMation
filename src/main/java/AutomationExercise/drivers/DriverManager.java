package AutomationExercise.drivers;

import AutomationExercise.utils.LogsUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager(){
        super();
    }

    @Step("Create driver instance on: {browserName}")
    public static WebDriver createInstance(String BrowserName){
        WebDriver driver = BrowserFactory.getBrowser(BrowserName);
        LogsUtil.info("Driver created on: ",BrowserName);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver(){
        if (driverThreadLocal.get() == null){
            LogsUtil.error("Driver is null");
            fail("driver is null");
        }
        return driverThreadLocal.get();
    }

    private static void setDriver(WebDriver driver) { driverThreadLocal.set(driver);
    }
}
