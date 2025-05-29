package TestCases;

import Base.driver.DriverManager;
import Base.pages.HeroKuPage;
import Base.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeroKuTestCases {
    private static final Logger logger = LogManager.getLogger(HeroKuTestCases.class);

    public WebDriver driver;
    File allure_result = new File("target/allure-results");

    @BeforeSuite
    public void BeforeSuite() {
        logger.info("Deleting old Allure result files...");
        FilesUtils.deleteFiles(allure_result);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        logger.info("Opening browser and navigating to login page");
        driver = DriverManager.openBrowser("chrome");
        new HeroKuPage(driver).navigateToLoginPage();
    }

    @Test
    public void login() {
        logger.info("Running placeholder login test");
    }

    @Test
    public void successfulLogin() {
        logger.info("Running successfulLogin test");
        new HeroKuPage(driver).enterUsername("test9090@hotmail.com")
                .enterPassword("test9090")
                .clickLoginButton()
                .assertSuccessfulLoginSoft();
        Screenshots.takeScreenshot(driver, "After");
        logger.info("successfulLogin test completed");
    }

    @Test
    public void unSuccessfulLogin() {
        logger.info("Running unSuccessfulLogin test");
        new HeroKuPage(driver).enterUsername("test90@hotmail.com")
                .enterPassword("test90")
                .clickLoginButton()
                .assertUnSuccessfulLogin();
        Screenshots.takeScreenshot(driver, "After");
        logger.info("unSuccessfulLogin test completed");
    }

    @Test
    public void countAndPrintAllLinks() {
        logger.info("Running countAndPrintAllLinks test");
        List<WebElement> links = ElementAction.FindElements(driver, By.tagName("a"));
        logger.info("Number of links found: {}", links.size());
        System.out.println("Number of links: " + links.size());
    }

    @Test
    public void assertLinksNumber() {
        logger.info("Running assertLinksNumber test");
        List<WebElement> links = ElementAction.FindElements(driver, By.tagName("a"));
        assertEquals("expected number of links", 10, links.size());
        logger.info("Asserted that links count is 10");

        for (WebElement link : links) {
            String href = link.getDomAttribute("href");
            logger.debug("Link href: {}", href);
            System.out.println(href);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Closing browser and asserting soft validations");
        DriverManager.closeBrowser();
        SoftValidation.customAssertAll();
    }

    @AfterClass
    public void afterClass() {
        logger.info("Attaching logs to Allure report");
        AllureUtils.attachLogsToAllureReport();
    }
}
