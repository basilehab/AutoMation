package Base.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators AutomationExercise
    public final By login = By.cssSelector("a[href='/login']");
    public final By username = By.name("email");
    public final By password = By.name("password");
    public final By loginButton =  By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    public final By errorMassage = By.cssSelector("form[action='/login'] p");
    public final By logout = By.cssSelector("a[href='/logout']");



    // Navigate
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://automationexercise.com/login");
    }

    // Actions
    public LoginPage enterUsername(String username) {
        ElementAction.SendData(driver, this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ElementAction.SendData(driver, this.password, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        ElementAction.ClickElement(driver, loginButton);
        return this;
    }
    public String getErrorMassage(){
        return ElementAction.getText(driver, errorMassage);
    }

    // Validation
    public LoginPage assertUnSuccessfulLogin() {
        Assert.assertEquals(getErrorMassage(), "Your email or password is incorrect!");
        return this;
    }
    public LoginPage assertSuccessfulLogin() {
        Assert.assertTrue(ElementAction.GetError(driver, logout), "Logout button not visible, login failed.");
        return this;
    }
}

