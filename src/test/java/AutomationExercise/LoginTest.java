package AutomationExercise;

import AutomationExercise.Pages.LoginPage;
import AutomationExercise.drivers.DriverManager;
import AutomationExercise.utils.BrowserActions;
import AutomationExercise.utils.CustomSoftAssertion;
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
        new LoginPage(driver).AssertSuccessfulLogin();
    }

    @Test(priority = 2)
    public void AddProductToCart(){
        BrowserActions.NavigateToWebsite(driver,"https://automationexercise.com/products");
        new LoginPage(driver).AddToCart1().ConShopping().AssertSuccessfulLogintoProductPage();
        CustomSoftAssertion.CustomAssertAll();
    }



    //Configurations
    @BeforeClass
    public void SetUp(){
        driver = DriverManager.createInstance("edge");
        //driver = DriverManager.createInstance("chrome");
        //driver = new ChromeDriver();
        new LoginPage(driver).NavigateToLoginPage();    //anonymous object

    }

    @AfterClass
    public void tearDown(){
        BrowserActions.quitTheBrowser(DriverManager.getDriver());
        //CustomSoftAssertion.CustomAssertAll();
    }

}
