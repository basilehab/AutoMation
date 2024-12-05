package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class TestBase {

    public static ChromeOptions ChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--remote-allow-origins=*");
        options.addExtensions(new File("C:\\Users\\mhefela\\Downloads\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx"));
        return options;
    }
    public static WebDriver driver;


    public void openBrowser(String URL)
    {
        driver = new ChromeDriver(ChromeOption());
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }




    public void closeBrowser()
    {
        driver.quit();
    }



}
