package com.dentolize.authentication.gui.pages;

import com.dentolize.dashboard.gui.pages.HomePage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage {

    private final SHAFT.GUI.WebDriver driver;
    private final By email_txtField = By.xpath("//input[@data-testid='emailField-email']");
    private final By password_txtField = By.id("login_password");

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * navigate to the website URL and open the login page
     *
     * @return self-reference for method chaining
     */
    @Step("Navigate to Login Page")
    public LoginPage navigateTo_loginPage() {
        driver.browser().navigateToURL(new HomePage(driver).baseUrl).getCurrentWindowTitle();
        return this;
    }

    /**
     * login by filling the fields' data and clicking login button
     *
     * @param email    the email of the user
     * @param password the password of the user
     * @return Home Page if login is successful.
     */
    @Step("Enter Email [ {email} ] And password [ {password} ]")
    public HomePage loginViaEmail(String email, String password) {
        driver.element().type(email_txtField, email).type(password_txtField, password + Keys.ENTER);
        return new HomePage(driver);
    }
}
