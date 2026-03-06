package AutomationExercise.Pages;

import AutomationExercise.utils.BrowserActions;
import AutomationExercise.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //variables
    private final WebDriver driver;

    //locators --
    private final By email = By.name("email");
    private final By Password = By.name("password");
    private final By LoginButton = By.cssSelector("[data-qa='login-button']");

    //Constructor to initialize the driver
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    //Navigation
    //navigate to login page
    public void NavigateToLoginPage(){
        BrowserActions.NavigateToWebsite(driver,"https://automationexercise.com/login");
    }



    //Actions -- "functions that will deal with locators" -- [wait, scroll, find, sendkeys and click]
   // public void EnterEmail(String email){
       // driver.findElement(this.email).sendKeys(email);

    public LoginPage EnterEmail(String email1){
        ElementActions.SendData(driver,email,email1);
        return this;
    }
    public LoginPage EnterPassword(String password){
        ElementActions.SendData(driver,this.Password,password);
        return this;
    }
    public void ClickOnLogin(){
        ElementActions.ClickElement(driver,LoginButton);
    }




    //Validations "testNG -- assertions"
    //1-assert on successful login
    public void AssertSuccessfulLogin(){
        Assert.assertEquals(BrowserActions.
                GetCurrentUrl(driver),"https://automationexercise.com/login");
    }



}
