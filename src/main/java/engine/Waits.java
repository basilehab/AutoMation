package engine;

import com.shaft.tools.io.ReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waits {


    /**
     * Implicit wait for the driver instance
     *
     * @param driver  - WebDriver instance
     * @param timeout - timeout in seconds
     */
    public static void implicitWait(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        ReportManager.log("Implicit wait for [ " + timeout + " ] seconds");
    }

    /**
     * Explicit wait for the driver instance for wait elements
     *
     * @param driver - WebDriver instance
     */

    public static WebDriverWait getExplicitWait(WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static WebDriverWait getExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Fluent wait for the driver instance for wait elements
     *
     * @param driver  - WebDriver instance
     * @param timeout - timeout in seconds
     * @param polling - polling in seconds
     * @return FluentWait<WebDriver> - FluentWait instance
     */
    public static FluentWait<WebDriver> getFluentWait(WebDriver driver, int timeout, int polling) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(polling)).ignoring(Exception.class);
    }

    public static FluentWait<WebDriver> getFluentWait(WebDriver driver, int polling) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(polling)).ignoring(Exception.class);
    }

    public static FluentWait<WebDriver> getFluentWait(WebDriver driver) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);
    }

}
