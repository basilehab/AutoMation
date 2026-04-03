package com.dentolize.patients.labOrders.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LabOrderTable {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public LabOrderTable(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By labOrderTable = By.xpath("//table[@class='ant-table-fixed']");

    @Step("Click on [ Edit Lab Order ] button")
    public LabOrderForm clickOnEditLabOrder_btn(int LabOrderIndex) {
        driver.element().click(this.commonLocators.dynamicUpdateIcon(LabOrderIndex));
        return new LabOrderForm(driver);
    }
}
