package TestCases;
import Base.pages.PageBase;
import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class AutomationExercise extends PageBase {
    @BeforeMethod (alwaysRun = true)
    public void beforeMethod(){
        openBrowser("https://automationexercise.com/");
    }

    @Test(groups = "login")
    public void TestOne()  {
        System.out.println("Test method One");
        // login
        ElementAction.ClickElement(driver, login);
        ElementAction.SendData(driver, name, "test9090@hotmail.com");
        ElementAction.SendData(driver, password, "test9090");
        ElementAction.ClickElement(driver, loginButton);
        // Verify logged in
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        BrowserActions.takeScreenshot(driver, "After");
    }
    @Test
    public void TestTwo() {
        System.out.println("Test method Two");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        assertEquals(147, links.size());
        for (WebElement link : links) {
            System.out.println(link.getDomAttribute("href"));
        }
    }
    @Test(groups = "login")
    public void TestThree() {
        System.out.println("Test method Three");
        // login
        ElementAction.ClickElement(driver, login);
        ElementAction.SendData(driver, name, "test9090@hotmail.com");
        ElementAction.SendData(driver, password, "test99");
        ElementAction.ClickElement(driver, loginButton);
        // validation
        Assert.assertTrue(ElementAction.GetErrorMassage(driver, loginError), "Logout");
        BrowserActions.takeScreenshot(driver, "After");
    }
    @AfterMethod (alwaysRun = true)
    public void afterMethod(){
        closeBrowser();
    }
}
