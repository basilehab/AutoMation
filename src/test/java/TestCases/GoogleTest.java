package TestCases;

import com.shaft.driver.SHAFT;
import org.testng.annotations.*;

public class GoogleTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test
    public void openGoogle() {
        driver.browser().navigateToURL("https://www.google.com");
        driver.assertThat().browser().title().contains("Google").perform();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}