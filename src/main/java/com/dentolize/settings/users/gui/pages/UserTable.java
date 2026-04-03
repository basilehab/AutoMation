package com.dentolize.settings.users.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UserTable {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public UserTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newUsers_btn = this.commonLocators.dynamicButtons("New User");

    @Step("Click on [ New User ] button")
    public UserForm clickOnNewUser_btn() {
        driver.element().click(newUsers_btn);
        return new UserForm(driver);
    }

    @Step("Click on [ Edit User ] button")
    public UserForm clickOnUpdateUser_btn(int userIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(userIndex));
        return new UserForm(driver);
    }
}
