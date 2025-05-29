package TestCases;

import Base.driver.DriverManager;
import Base.pages.TheInternetPage;
import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import Base.utils.Screenshots;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class TheInternetTestCases extends TheInternetPage {
    private static final Logger logger = LogManager.getLogger(TheInternetTestCases.class);
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        logger.info("Opening browser and navigating to page");
        driver = DriverManager.openBrowser("chrome");
        new TheInternetPage(driver).navigateToPage();
        Screenshots.takeScreenshot(driver, "After");

    }

    @Test
    public void TestcaseOne()  {
        logger.info("Executing TestcaseOne");
        ElementAction.ClickElement(driver, abTestLink);
        assertEquals(Objects.requireNonNull(driver.getTitle()), "The Internet");
        logger.info("Page title is: {}", driver.getTitle());
        Screenshots.takeScreenshot(driver, "After");

    }

    @Test
    public void TestcaseTwo() {
        logger.info("Executing TestcaseTwo");
        ElementAction.ClickElement(driver, addRemoveLink);

        for (int I = 0; I < 20; I++) {
            ElementAction.ClickElement(driver, addElementButton);
        }

        List<WebElement> deleteButtons = driver.findElements(deleteButton);

        for (int J = deleteButtons.size() - 1; J >= 0; J--) {
            List<WebElement> currentButtons = driver.findElements(deleteButton);
            if (J < currentButtons.size()) {
                currentButtons.get(J).click();
            }
        }

        List<WebElement> remainingButtons = driver.findElements(deleteButton);
        assertEquals(remainingButtons.size(), 0, "Not all buttons were deleted");
        logger.info("All buttons deleted successfully");
    }

    @Test
    public void TestcaseThree() {
        logger.info("Executing TestcaseThree");
        ElementAction.ClickElement(driver, basicAuthLink);
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String displayed_message = driver.findElement(contentMessage).getText();
        Assert.assertNotNull(displayed_message);

        if (displayed_message.contains("Congratulations")) {
            logger.info("Authentication SuccessFull");
        } else {
            logger.warn("Authentication NOT SuccessFull");
        }
        Screenshots.takeScreenshot(driver, "After");
    }

    @Test
    public void TestcaseFour() {
        logger.info("Executing TestcaseFour");
        try {
            ElementAction.ClickElement(driver, brokenImagesLink);
            List<WebElement> images = driver.findElements(By.tagName("img"));
            logger.info("Total images: {}", images.size());

            for (WebElement img : images) {
                Boolean isBroken = (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].naturalWidth === 0;", img);

                if (Boolean.TRUE.equals(isBroken)) {
                    String src = (String) ((JavascriptExecutor) driver).executeScript(
                            "return arguments[0].src;", img);
                    logger.warn("Broken image: {}", src);
                }
            }
        } catch (Exception E) {
            logger.error("Exception in TestcaseFour", E);
        }
        Screenshots.takeScreenshot(driver, "After");
    }

    @Test
    public void TestcaseFive()  {
        logger.info("Executing TestcaseFive");
        ElementAction.ClickElement(driver, checkboxesLink);
        ElementAction.SelectCheckBox(driver, checkbox1);
        Assert.assertTrue(driver.findElement(checkbox1).isSelected());
        ElementAction.SelectCheckBox(driver, checkbox2);
        Assert.assertTrue(driver.findElement(checkbox2).isSelected());
        Screenshots.takeScreenshot(driver, "After");
    }

    @Test
    public void TestcaseSix(){
        logger.info("Executing TestcaseSix");
        ElementAction.ClickElement(driver, contextMenuLink);
        ElementAction.RightClick(driver, contextBox);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        logger.info("Alert text is: {}", alertText);

        Assert.assertEquals(alertText, "You selected a context menu");
        alert.accept();
        Screenshots.takeScreenshot(driver, "After");
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        logger.info("Closing browser after test method");
        DriverManager.closeBrowser();
    }
}
