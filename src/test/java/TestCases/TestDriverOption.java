package TestCases;

import java.time.Duration;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestDriverOption extends TestBase {

    @BeforeMethod(alwaysRun = true)
        public void beforeMethod(){
        startChromeDriver("https://www.selenium.dev/selenium/web/web-form.html");
    }


        @Test
        public void eightComponents() {

            String title = driver.getTitle();
            assertEquals(title, "Web form");
            System.out.println("Title: " + title);

            WebElement textBox = driver.findElement(By.name("my-text"));
            textBox.sendKeys("Selenium");

            waitAndClick(driver, 10L, By.cssSelector("button"));

            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

            String value = message.getText();
            assertEquals(value, "Received!");

        }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeBrowser();
    }
}
