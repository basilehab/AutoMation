package com.dentolize.settings.automaticTasks.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AutomaticTasksTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public AutomaticTasksTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By newAutomaticTask_btn = this.commonLocators.dynamicButtons("New Item");

    @Step("Click on [ Create new Automatic Task ] button")
    public AutomaticTasksForm clickOnCreateNewAutomaticTask_btn() {
        driver.element().click(newAutomaticTask_btn);
        return new AutomaticTasksForm(driver);
    }

    @Step("Click on [ Update Automatic Task ] button")
    public AutomaticTasksForm clickOnUpdateAutomaticTask_btn(int index) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(index));
        return new AutomaticTasksForm(driver);
    }
}
