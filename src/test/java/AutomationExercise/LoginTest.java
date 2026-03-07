package AutomationExercise;

import AutomationExercise.Pages.LoginPage;
import AutomationExercise.utils.BrowserActions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class LoginTest {

    //variables
    private WebDriver driver;



    //Tests
    @Test(priority = 1)
    public void SuccessfulLogin(){
        new LoginPage(driver).EnterEmail("salma@123").EnterPassword("122333"); //flaunt pattern
        new LoginPage(driver).ClickOnLogin();
        new LoginPage(driver).AssertSuccessfulLogin();
    }

    @Test(priority = 2)
    public void AddProductToCart(){
        BrowserActions.NavigateToWebsite(driver,"https://automationexercise.com/products");
        new LoginPage(driver).AddToCart1().ConShopping();
    }



    //Configurations
    @BeforeClass
    public void SetUp(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("Start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver();
        //driver = new ChromeDriver();
        new LoginPage(driver).NavigateToLoginPage();    //anonymous object

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
