package com.dentolize.settings.sms.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SmsTable {

    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public SmsTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By newSms_btn = commonLocators.dynamicButtons("New SMS");

    @Step("Click on [ Create new Sms ] button")
    public SmsForm clickOnCreateSms_btn() {
        driver.element().click(newSms_btn);
        return new SmsForm(driver);
    }

    @Step("Click on [ Update Sms ] button")
    public SmsForm clickOnUpdateSms_btn(int index) {
        driver.element().click(commonLocators.dynamicUpdateIcon(index));
        return new SmsForm(driver);
    }
}
