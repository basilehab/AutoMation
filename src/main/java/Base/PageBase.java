package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {
    public void explicitWait(WebDriver driver , Long duration , By elementLocator){
        Wait<WebDriver> explicitWait = new WebDriverWait(driver , Duration.ofSeconds(duration));

        explicitWait.until(d-> driver.findElement(elementLocator));
    }

    public void fluentWait(WebDriver driver ,int duration, int pollingIntervals , By targetLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(pollingIntervals))
                .ignoring(ElementNotInteractableException.class);

        wait.until(d-> driver.findElement(targetLocator));
    }
}
