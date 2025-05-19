package TestCases;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import static org.testng.Assert.assertEquals;


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
    for (int i = 0; i < 20; i++) {
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
/*  The Easy way
    //driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    String displayed_message=driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
    Assert.assertNotNull(displayed_message);
    if(displayed_message.contains("Congratulations"))
    {
        System.out.println("Authentication SuccessFull");
    }
    else
    {
        System.out.println("Authentication NOT SuccessFull");
    }
    // extensions
       waitAndClick(driver, 10L, (By.cssSelector("a[href='/basic_auth']")));
    Process p = Runtime.getRuntime().exec("D:\\Authentication.exe");
    p.waitFor(); // Wait for the script to finish

    // Wait for Element to be a present
    WebElement message;
    message = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content p")));
// Get text and normalize whitespace
    String actualText = message.getText().trim();
    String expectedText = "Congratulations! You must have the proper credentials.";
    // Assert with Context Message
    assertEquals(actualText, expectedText, "Authentication success message mismatch");
    System.out.println("actualText is : " + expectedText);

*/
    waitAndClick(driver, 10L, (By.cssSelector("a[href='/basic_auth']")));
    try {
        Robot robot = new Robot();
        robot.setAutoDelay(100); // Auto-add 100 ms delay after every action

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

// Wait for Element to be a present
    WebElement message;
    message = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content p")));
// Get text and normalize whitespace
    String actualText = message.getText().trim();
    String expectedText = "Congratulations! You must have the proper credentials.";
    // Assert with Context Message
    assertEquals(actualText, expectedText, "Authentication success message mismatch");
    System.out.println("actualText is : " + expectedText);
}
@Test
public void TestcaseFour() {
    System.out.println("Test method Four");
    // by img size
    try {
        waitAndClick(driver, 10L, By.cssSelector("a[href='/broken_images']"));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images: " + images.size());

        for (WebElement img : images) {
            // Use JavaScript to check if the image is broken
            Boolean isBroken = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].naturalWidth === 0;", img
            );

            if (Boolean.TRUE.equals(isBroken)) {
                // Get the src for logging (without using getAttribute)
                String src = (String) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].src;", img
                );
                System.out.println("Broken image: " + src);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    /*
    try {
                waitAndClick(driver, 10 L, (By.cssSelector("a[href='/broken_images']")));
                List<WebElement> images = driver.findElements(By.tagName("img"));
                System.out.println("Total images: " + images.size());

                for (WebElement img: images) {
                    String src = img.getAttribute("src");
                    if (src == null || src.isEmpty()) {
                        System.out.println("Image has no source.");
                        continue;
                    }
                    if (src.startsWith("data:image")) {
                        continue; // Skip embedded images
                    }

                    // Resolve relative URLs
                    String currentUrl = driver.getCurrentUrl();
                    URI baseUri = new URI(currentUrl);
                    URI imageUri = baseUri.resolve(src);
                    String imageUrl = imageUri.toString();

                    // Check HTTP status code
                    int statusCode = getStatusCode(imageUrl);
                    if (statusCode != 200) {
                        System.out.println("Broken image: " + imageUrl + " (Status: " + statusCode + ")");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }

        private  int getStatusCode(String url) throws IOException {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getResponseCode();
        }
     */

}
    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        closeBrowser();
    }
}