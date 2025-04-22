package TestCases;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import java.time.Duration;
import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertEquals;

public class SecondTest extends TestBase {
    @BeforeMethod (alwaysRun = true)
    public void beforeMethod(){
        openBrowser("https://the-internet.herokuapp.com/");
    }

@Test(groups = "click")
public void TestcaseOne()  {
    System.out.println("Test method One");
    waitAndClick(driver,10L, (By.cssSelector("a[href='/abtest']")));
    assertEquals(Objects.requireNonNull(driver.getTitle()), "The Internet");
    System.out.println("page title is: " + driver.getTitle());
}
@Test(groups = "click")
public void TestcaseTwo() {
    System.out.println("Test method Two");
    // Navigate to the add/remove elements page
    waitAndClick(driver, 10L, By.cssSelector("a[href='/add_remove_elements/']"));

    // Add 5 elements
    By addElementButton = By.cssSelector(".example > button");
    for (int i = 0; i < 5; i++) {
        waitAndClick(driver, 10L, addElementButton);
    }

    // Get all delete buttons after adding
    List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));

    // Delete all buttons from last to first
    for (int j = deleteButtons.size() - 1; j >= 0; j--) {
        // Refind buttons to avoid staleness
        List<WebElement> currentButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        if (j < currentButtons.size()) {
            currentButtons.get(j).click();
        }
    }

    // Verify no buttons remain
    List<WebElement> remainingButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
    assertEquals(remainingButtons.size(), 0, "Not all buttons were deleted");
}

@Test
public void TestcaseThree() {
    System.out.println("Test method Three");
/*  //The Easy way
    //driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    String displayed_message=driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
    Assert.assertNotNull(displayed_message);
    if(displayed_message.contains("Congratulations"))
    {
        System.out.println("Authentication Successfull");
    }
    else
    {
        System.out.println("Authentication NOT Successfull");
    }
    }
        */
    waitAndClick(driver, 10L, (By.cssSelector("a[href='/basic_auth']")));
    try {
        Robot robot = new Robot();
        robot.setAutoDelay(100); // Auto-add 100ms delay after every action

        //Type UserName
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        //Press Tab
        robot.keyPress(KeyEvent.VK_TAB);
        //Type Password
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_ENTER);

    } catch (AWTException e) {
        Assert.fail("Authentication failed: " + e.getMessage());
    }

// Wait for Element to be present
    WebElement message;
    message = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content p")));
// Get text and normalize whitespace
    String actualText = message.getText().trim();
    String expectedText = "Congratulations! You must have the proper credentials.";
    // Assert with Context Message
    assertEquals(actualText, expectedText, "Authentication success message mismatch");
    System.out.println("actualText is : " + expectedText);

}
    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        closeBrowser();
    }
}