package Base.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementAction {
    private ElementAction(){

    }
    public static void SendData(WebDriver driver, By locator , String data){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }
    public static void ClickElement(WebDriver driver, By locator){
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
    public static String getText(WebDriver driver, By by){
        Waits.waitForElementVisible(driver, by);
        return driver.findElement(by).getText();

    }
}
