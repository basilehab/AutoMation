package TestCases;

import Base.pages.LoginPage;
import Base.pages.PageBase;
import Base.utils.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class AutomationExercise {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        PageBase base = new PageBase();
        base.openBrowser("https://automationexercise.com");
        driver = base.driver;

        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test
    public void login() {
    }

    @Test
    public void successfulLogin() {
        loginPage.enterUsername("test9090@hotmail.com")
                .enterPassword("test9090")
                .clickLoginButton()
                .assertSuccessfulLogin();
                BrowserActions.takeScreenshot(driver, "After");

    }

    @Test
    public void unSuccessfulLogin() {
        loginPage.enterUsername("test90@hotmail.com")
                .enterPassword("test90")
                .clickLoginButton()
                .assertUnSuccessfulLogin();
                BrowserActions.takeScreenshot(driver, "After");

    }
    @Test
    public void countAndPrintAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + links.size());
    }

    @Test
    public void assertLinksNumber() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        assertEquals("expected number of links", 10, links.size());

        for (WebElement link : links) {
            System.out.println(link.getDomAttribute("href"));
        }
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
