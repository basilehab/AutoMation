package AutomationExercise.Pages;

import AutomationExercise.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //variables
    private final WebDriver driver;

    //locators --
    private final By email = By.name("email");
    private final By Password = By.name("password");
    private final By LoginButton = By.className("Login");

    //Constructor to initialize the driver
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }



    //Actions -- "functions that will deal with locators" -- [wait, scroll, find, sendkeys and click]
   // public void EnterEmail(String email){
       // driver.findElement(this.email).sendKeys(email);

    public void EnterEmail(String email1){
        ElementActions.SendData(driver,email,email1);
    }
    public void EnterPassword(String password){
        ElementActions.SendData(driver,this.Password,password);
    }
    public void ClickOnLogin(){
        ElementActions.ClickElement(driver,LoginButton);
    }






    //Validations "testNG -- assertions"

}
