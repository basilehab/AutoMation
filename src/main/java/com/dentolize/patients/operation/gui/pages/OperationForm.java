package com.dentolize.patients.operation.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class OperationForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public OperationForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By priceList_list = By.id("OperationsForm_priceList");
    private final By procedure_list = By.id("OperationsForm_procedure");
    private final By details_txtField = By.id("LabOrderForm_details");
    private final By updateOperation_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By deleteOperation_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Enter Lab Order Details")
    public OperationForm enterOperationDetails(String details) {
        driver.element().type(details_txtField, details);
        return this;
    }

    @Step("Click On [ Update ] button")
    public OperationForm clickOnUpdateOperation_btn() {
        driver.element().click(updateOperation_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public OperationForm clickOnDeleteOperation_btn() {
        driver.element().click(deleteOperation_btn).click(yesConfirmationMessage_btn);
        return this;
    }


    public OperationForm selectPatient() {
        driver.element().type(By.xpath("(//span[@class='ant-select-selection-placeholder'][contains(.,'Patient')])[2]"), "Patient");
        return this;
    }

    public OperationForm selectDentist(String cellData) {

        return this;
    }
}
