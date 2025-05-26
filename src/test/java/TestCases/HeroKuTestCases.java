package TestCases;

import Base.driver.DriverManager;
import Base.pages.HeroKuPage;
import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import Base.utils.SoftValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class HeroKuTestCases {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = DriverManager.openBrowser("chrome");
        new HeroKuPage(driver).navigateToLoginPage();
    }

    @Test
    public void login() {
    }

    @Test
    public void successfulLogin() {
        new HeroKuPage(driver).enterUsername("test9090@hotmail.com")
                .enterPassword("test9090")
                .clickLoginButton()
                .assertSuccessfulLoginSoft();
                BrowserActions.takeScreenshot(driver, "After");

    }

    @Test
    public void unSuccessfulLogin() {
        new HeroKuPage(driver).enterUsername("test90@hotmail.com")
                .enterPassword("test90")
                .clickLoginButton()
                .assertUnSuccessfulLogin();
                BrowserActions.takeScreenshot(driver, "After");

    }
    @Test
    public void countAndPrintAllLinks() {
        List<WebElement> links = ElementAction.FindElements(driver,By.tagName("a"));
        System.out.println("Number of links: " + links.size());
    }

    @Test
    public void assertLinksNumber() {
        List<WebElement> links = ElementAction.FindElements(driver, By.tagName("a"));
        assertEquals("expected number of links", 10, links.size());

        for (WebElement link : links) {
            System.out.println(link.getDomAttribute("href"));
        }
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        DriverManager.closeBrowser();
        SoftValidation.customAssertAll();
    }
}
