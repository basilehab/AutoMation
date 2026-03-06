package AutomationExercise;

import AutomationExercise.Pages.LoginPage;
import AutomationExercise.utils.BrowserActions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    //variables
    private WebDriver driver;



    //Tests
    @Test
    public void SuccessfulLogin(){
        new LoginPage(driver).EnterEmail("salma@123").EnterPassword("122333"); //flaunt pattern
        new LoginPage(driver).ClickOnLogin();
        new LoginPage(driver).AssertSuccessfulLogin();
    }


    //Configurations
    @BeforeMethod
    public void SetUp(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("Start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver();
        //driver = new ChromeDriver();
        new LoginPage(driver).NavigateToLoginPage();    //anonymous object

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
