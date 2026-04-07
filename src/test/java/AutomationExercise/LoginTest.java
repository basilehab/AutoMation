package AutomationExercise;

import AutomationExercise.Pages.LoginPage;
import AutomationExercise.drivers.DriverManager;
import AutomationExercise.utils.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.sql.ResultSet;

public class LoginTest {

    //variables
    private WebDriver driver;
    File allure_results = new File("test-outputs/allure-results");



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
        ScreenShotsUtils.takeScreenshot("successful-redirection-to-product-page");
    }



    //Configurations

    @BeforeSuite
    public void beforeSuite(){
        FilesUtils.deleteFiles(allure_results);
    }

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
        AllureUtils.attachLogsToAllureReport();
    }

   // @AfterClass
  //  public void afterClass(){
   //     AllureUtils.attachLogsToAllureReport();
  // }

}
