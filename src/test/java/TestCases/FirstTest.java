package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Objects;
import static org.testng.AssertJUnit.assertEquals;


public class FirstTest extends TestBase {
    @BeforeMethod
    public void beforeMethod(){
        //openBrowser("file:///C:/Users/Basel/Downloads/index.html");
        openBrowser("https://automationexercise.com/");
    }

    @Test
    public void TestOne()  {
        System.out.println("Test method One");
        // login
        waitForElement(driver, 10L, By.partialLinkText("login"));
        WebElement email = driver.findElement(By.name("email"));email.sendKeys("test9090@hotmail.com");
        WebElement password = driver.findElement(By.name("email"));password.sendKeys("test9090");
        // Verify logged in
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
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
        assertEquals(147, links.size());
        for (WebElement link : links) {
            System.out.println(link.getDomAttribute("href"));
        }
    }

    @AfterMethod
    public void afterMethod(){
        closeBrowser();
    }
}
