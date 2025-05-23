package Base.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ElementAction {
    public ElementAction() {

    }

    public static void SendData(WebDriver driver, By locator, String data) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }

    public static void ClickElement(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).click();
    }

    public static void SelectCheckBox(WebDriver driver, By locator) {
        WebElement checkbox = Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public static void RightClick(WebDriver driver, By locator) {
        WebElement RightClick = Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        new Actions(driver)
                .contextClick(RightClick)
                .perform();
    }

    public static String GetText(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return driver.findElement(locator).getText();
    }

    public static boolean GetError(WebDriver driver, By locator) {
        try {
            Waits.waitForElementVisible(driver, locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static WebElement FindElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> FindElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    public static String GetPageTitle(WebDriver driver, By locator) {
        return driver.getTitle();
    }

    public static void RefreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

}
