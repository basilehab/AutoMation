package Base.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
