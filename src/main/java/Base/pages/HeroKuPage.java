package Base.pages;

import Base.utils.SoftValidation;
import Base.utils.Validations;
import org.openqa.selenium.By;
import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import org.openqa.selenium.WebDriver;

public class HeroKuPage {
    public WebDriver driver;

    public HeroKuPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators AutomationExercise
    public final By login = By.cssSelector("a[href='/login']");
    public final By username = By.name("email");
    public final By password = By.name("password");
    public final By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    public final By errorMassage = By.cssSelector("form[action='/login'] p");
    public final By logout = By.cssSelector("a[href='/logout']");


    // Navigate
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://automationexercise.com/login");
    }

    // Actions
    public HeroKuPage enterUsername(String username) {
        ElementAction.SendData(driver, this.username, username);
        return this;
    }

    public HeroKuPage enterPassword(String password) {
        ElementAction.SendData(driver, this.password, password);
        return this;
    }

    public HeroKuPage clickLoginButton() {
        ElementAction.ClickElement(driver, loginButton);
        return this;
    }

    public String getErrorMassage() {
        return ElementAction.GetText(driver, errorMassage);
    }

    // Validation
    public HeroKuPage assertLoginPage() {
        SoftValidation.softAssertion.assertTrue(ElementAction.GetError(driver, logout), "Logout button not visible, login failed.");
        return this;
    }

    public HeroKuPage assertLoginPageUrl() {
        SoftValidation.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver), "https://automationexercise.com/", "Url is not as expected");
        return this;
    }

    public HeroKuPage assertSuccessfulLoginSoft(){
        assertLoginPage().assertLoginPageUrl();
        return this;
    }

    public HeroKuPage assertUnSuccessfulLogin() {
        Validations.ValidationEqual(getErrorMassage(), "Your email or password is incorrect!", "Error massage is not as expected");
        return this;
    }
    /*
    public HeroKuPage assertSuccessfulLogin() {
        Validations.ValidationTrue(ElementAction.GetError(driver, logout), "Logout button not visible, login failed.");
        return this;
    }
     */
}

