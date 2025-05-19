package Base;
import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;

    public void openBrowser(String URL)
    {
        try {
            driver = new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } catch (Exception e) {
        throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    public void startChromeDriver(String URL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    public String waitTillVisibility (WebDriver driver, long timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return driver.findElement(locator).getText();
    }

    public void waitAndClick(WebDriver driver, long timeoutInSeconds, By locator) {
        // Define explicit wait with timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForElement(WebDriver driver, long timeoutInSeconds, By locator) {
        // Define explicit wait with timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void closeBrowser()
    {
        driver.quit();
    }
    public void clickWhenReady(WebDriver driver, long timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}

