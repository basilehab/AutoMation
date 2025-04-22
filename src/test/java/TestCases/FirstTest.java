package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;
//import java.util.List;

public class FirstTest extends TestBase {
    @BeforeMethod
    public void beforeMethod(){
        //openBrowser("file:///C:/Users/Basel/Downloads/index.html");
        openBrowser("https://automationexercise.com/");
    }

    @Test
    public void TestOne() throws InterruptedException {
        System.out.println("Test method One");
        Thread.sleep(2000);
        String elementText = driver.findElement(By.cssSelector("div.panel-collapse:nth-child(2)")).getText();
        System.out.println("elementText = " + elementText);
    }
    @Test
    public void TestTwo() {
        // Use the explicit wait method to click login
        System.out.println("Test method Two");
        clickWhenReady(driver, 10L, By.cssSelector("a[href='/login']"));

        // Verify we're on login page
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/login"));
    }
    @Test
    public void TestThree() {
        System.out.println("Test method Three");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getDomAttribute("href"));
        }
    }

    @AfterMethod
    public void afterMethod(){
        closeBrowser();
    }
}
