package TestCases;

import Base.pages.TheInternetPage;
import Base.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestDriverOption extends TheInternetPage {

    @BeforeMethod(alwaysRun = true)
        public void beforeMethod(){
        openBrowser("https://www.selenium.dev/selenium/web/web-form.html");
    }


        @Test
        public void eightComponents() {

            String title = driver.getTitle();
            assertEquals(title, "Web form");
            System.out.println("Title: " + title);

            WebElement textBox = driver.findElement(By.name("my-text"));
            textBox.sendKeys("Selenium");

            Waits.waitForElementClickable(driver, By.cssSelector("button"));

            assertEquals(
                    Waits.waitForElementVisible(driver, By.id("message")).getText().trim(),
                    "Received!"
            );
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeBrowser();
    }
}
