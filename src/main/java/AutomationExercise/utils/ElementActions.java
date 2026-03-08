package AutomationExercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private ElementActions(){
    }

    //sendkeys
    public static void SendData(WebDriver driver, By locator, String data){
        Waits.WaitForElementToBeVisible(driver,locator);
        Scroll.ScrollToElement(driver,locator);
        driver.findElement(locator).sendKeys(data);
    }

    //click
    public static void ClickElement(WebDriver driver, By locator){
        Waits.WaitForElementToBeClickable(driver,locator);
        Scroll.ScrollToElement(driver,locator);
        driver.findElement(locator).click();
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

    public static String GetText(WebDriver driver, By locator){
        Waits.WaitForElementToBeVisible(driver, locator);
        Scroll.ScrollToElement(driver, locator);
        return findTheElement(driver,locator).getText();
    }

    public static WebElement findTheElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }


}
