package AutomationExercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {

    private Scroll(){
    }

    //Scroll to element
    @Step("Scrolling to the element: {0}")
    public static void ScrollToElement(WebDriver driver, By locator){
        LogsUtil.info("Scrolling to element: ", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

}
