package AutomationExercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    //constructor to prevent any instantiation
    private Waits(){}

    //explicit wait
    //wait for the element until it can be present,visible,clickable

    //1- wait for element to be present
    public static WebElement WaitForElementToBePresent(WebDriver driver, By locator){
        LogsUtil.info("Waiting for element to be present: ", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    //2-wait for the element to be visible
    public static WebElement WaitForElementToBeVisible(WebDriver driver, By locator){
        LogsUtil.info("Waiting for element to be visisble: ", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {
                    WebElement element = WaitForElementToBePresent(driver,locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    //3-wait for the element to be clickable
    public static WebElement WaitForElementToBeClickable(WebDriver driver, By locator){
        LogsUtil.info("Waiting for element to be clickable: ", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {
                    WebElement element = WaitForElementToBeVisible(driver,locator);
                    return element.isEnabled() ? element : null;
                });
    }

}
