package Base.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver openBrowser(String URL) {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // احذفها لو عايز تشوف التست
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setAcceptInsecureCerts(true);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(URL);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
        return driver;
    }


    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}