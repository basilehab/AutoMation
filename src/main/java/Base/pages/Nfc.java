package Base.pages;

import Base.utils.BrowserActions;
import Base.utils.ElementAction;
import Base.utils.SoftValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Driver
public class Nfc {

    public WebDriver driver;

    public Nfc(WebDriver driver) {
        this.driver = driver;
    }
//Locators
    public final By username = By.xpath("/html/body/div/input[1]");
    public final By password = By.xpath("/html/body/div/input[2]");
    public final By loginButton = By.xpath("/html/body/div/button");
    public final By logout = By.xpath("/html/body/div/div[1]/button");

    public Nfc navigateToPage() {
        BrowserActions.navigateToURL(driver, "https://loly-for-accessories.vercel.app/login");
        return this;
    }
//Login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        assertLoginPage();
    }

    public void enterUsername(String username) {
        ElementAction.SendData(driver, this.username, username);
    }

    public void enterPassword(String password) {
        ElementAction.SendData(driver, this.password, password);
    }

    public void clickLoginButton() {
        ElementAction.ClickElement(driver, loginButton);
    }

    public void assertLoginPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logoutButton =
                wait.until(ExpectedConditions.visibilityOfElementLocated(logout));

        SoftValidation.softAssertion.assertTrue(
                logoutButton.isDisplayed(),
                "Logout button is not visible"
        );
    }
}
    /*
   public Nfc() {
   }
   */



