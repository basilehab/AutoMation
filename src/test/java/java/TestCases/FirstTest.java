package java.TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest extends TestBase {
    @BeforeMethod
    public void beforeMethod(){
        openBrowser("https://www.bing.com");
    }

    @Test
    public void TestOne() throws InterruptedException {
        System.out.println("Test method One");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
