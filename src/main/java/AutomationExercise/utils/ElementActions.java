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

}
