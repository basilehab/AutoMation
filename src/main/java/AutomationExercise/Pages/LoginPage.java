package AutomationExercise.Pages;

import AutomationExercise.utils.BrowserActions;
import AutomationExercise.utils.CustomSoftAssertion;
import AutomationExercise.utils.ElementActions;
import AutomationExercise.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    //variables
    private final WebDriver driver;

    //locators --
    private final By email = By.name("email");
    private final By Password = By.name("password");
    private final By LoginButton = By.cssSelector("[data-qa='login-button']");
    private final By AddItemToCart = By.cssSelector("a[data-product-id='1']");
    private final By ContinueShopping = By.cssSelector("button.btn-success.close-modal");
    private final By ErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");

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
    public LoginPage AddToCart1(){
        ElementActions.AddToCart(driver,AddItemToCart);
        return this;
    }
    public LoginPage ConShopping(){
        ElementActions.ContinueShopping1(driver,ContinueShopping);
        return this;
    }
    public String GetErrorMessage(){
        return ElementActions.GetText(driver,ErrorMessage);
    }




    //Validations "testNG -- assertions"


    //1-assert on successful login
    public void AssertSuccessfulLogin(){
        Validations.ValidatePageUrl(driver, "https://automationexercise.com/login");
    }

    public void AssertUnSuccessfulLogin(){
        Validations.ValidateEquals(GetErrorMessage(),"Username and password don't match users in this service","Error message not expected");
    }


    public LoginPage AssertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentTitle(driver),"Automation Exercise - All Products","title not expected");
        //CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentTitle(driver),"Automation Exercise","title not expected"); //assertion fail
        return this;
    }
    public LoginPage AssertLoginPageUrl(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.GetCurrentUrl(driver),"https://automationexercise.com/products","Url not expected");
        return this;
    }
    public LoginPage AssertSuccessfulLogintoProductPage(){
        AssertLoginPageUrl().AssertLoginPageTitle();
        return this;
    }



}
