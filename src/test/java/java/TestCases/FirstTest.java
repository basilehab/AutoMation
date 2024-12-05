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
    //locators
    By searchTextFieldBy = By.xpath("//input[@id='sb_form_qq']");
    By searchButtonBy = By.xpath("//*[@id='search_icon']");

    By returnedResultsBy = By.xpath("//div[@class='b_tpcn']/a");

//    By googleSearchButton = By.xpath("//*[@class='FPdoLc lJ9FBc']//input[1]");
//    By googleSearchField = By.xpath("//textarea[@name='q']");
//    By googleSearchResults = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");


    @BeforeMethod
    public void beforeMethod(){
        openBrowser("https://www.bing.com");
    }


    @Test
    public void TestOne() throws InterruptedException {
        System.out.println("Test method One");
        //Thread.sleep(2000);
        driver.findElement(searchTextFieldBy).sendKeys("Automation Testing ");
        Thread.sleep(2000);
        driver.findElement(searchButtonBy).click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class='b_tpcn']/a"));
        System.out.println("number of search results = " + searchResults.size());
        Assert.assertEquals(searchResults.size() , 10);
        Thread.sleep(2000);
    }

    @Test
    public void TestTwo(){
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
