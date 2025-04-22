package TestCases;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import java.time.Duration;
import java.util.List;
import java.util.Objects;
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
    Assert.assertEquals(Objects.requireNonNull(driver.getTitle()), "The Internet");
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
    Assert.assertEquals(remainingButtons.size(), 0, "Not all buttons were deleted");
}

    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        closeBrowser();
    }
}