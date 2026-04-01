package AutomationExercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private ElementActions(){
    }

    //sendkeys
    @Step("Sending data: {data} to the element: {locator}")
    public static void SendData(WebDriver driver, By locator, String data){
        Waits.WaitForElementToBeVisible(driver,locator);
        Scroll.ScrollToElement(driver,locator);
        driver.findElement(locator).sendKeys(data);
        LogsUtil.info("Data entered: ", data, "in the field: ", locator.toString());
    }

    //click
    @Step("Clicking the element: {locator}")
    public static void ClickElement(WebDriver driver, By locator){
        Waits.WaitForElementToBeClickable(driver,locator);
        Scroll.ScrollToElement(driver,locator);
        driver.findElement(locator).click();
        LogsUtil.info("Clicked on the element: ", locator.toString());
    }

    public static void AddToCart(WebDriver driver, By locator){
        Waits.WaitForElementToBePresent(driver,locator);
        Waits.WaitForElementToBeVisible(driver,locator);
        driver.findElement(locator).click();
    }

    public static void ContinueShopping1(WebDriver driver, By locator){
        Waits.WaitForElementToBePresent(driver,locator);
        Waits.WaitForElementToBeVisible(driver,locator);
        driver.findElement(locator).click();
    }

    @Step("Get text from the element: {locator}")
    public static String GetText(WebDriver driver, By locator){
        Waits.WaitForElementToBeVisible(driver, locator);
        Scroll.ScrollToElement(driver, locator);
        LogsUtil.info("Getting text from the element: ", locator.toString(), "Text: ", findTheElement(driver,locator).getText());
        return findTheElement(driver,locator).getText();
    }

    public static WebElement findTheElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }


}
