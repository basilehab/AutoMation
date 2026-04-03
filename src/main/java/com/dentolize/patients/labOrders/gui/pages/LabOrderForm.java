package com.dentolize.patients.labOrders.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LabOrderForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public LabOrderForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.commonLocators = new CommonLocators();
    }

    private final By patient_list = By.id("LabOrderForm_patient");
    //TODO: add branch locator
    private final By branch_list = By.id("");
    private final By labs_list = By.id("LabOrderForm_lab");
    private final By labItem_list = By.id("LabOrderForm_labItem");
    private final By itemName_txtField = By.id("LabOrderForm_name");
    private final By dueDate_txtField = By.id("LabOrderForm_due");
    private final By price_txtField = By.id("LabOrderForm_price");
    private final By quantity_txtField = By.id("LabOrderForm_items");
    private final By shade_list = By.id("LabOrderForm_shade");
    private final By doctor_list = By.id("LabOrderForm_user");
    //TODO: add assigned to locator
    private final By assignedTo_list = By.id("");
    private final By tooth_list = By.id("LabOrderForm_tooth");
    private final By details_txtField = By.id("LabOrderForm_details");
    //TODO: add paid checkbox locator
    private final By paid_checkBx = By.id("");
    private final By received_checkBx = By.id("LabOrderForm_received");
    private final By delivered_checkBx = By.id("LabOrderForm_delivered");
    private final By addToExpenses_checkBx = By.id("LabOrderForm_expense");

    private final By createLabOrder_btn = this.commonLocators.dynamicSubmitButtons("Create");
    private final By updateLabOrder_btn = this.commonLocators.dynamicSubmitButtons("Update");
    private final By deleteLabOrder_btn = this.commonLocators.dynamicButtons("Delete");
    private final By yesConfirmationMessage_btn = this.commonLocators.dynamicButtons("Yes");
    private final By noConfirmationMessage_btn = this.commonLocators.dynamicButtons("No");

    @Step("Select Patient [ {patient} ]")
    public LabOrderForm selectPatient(String patient) {
        driver.element().click(patient_list).type(patient_list, patient).click(this.commonLocators.listOfOptionByName(patient));
        return this;
    }

    @Step("Select Branch [ {branch} ]")
    public LabOrderForm selectLabOrderBranch(String branch) {
        driver.element().click(branch_list).click(this.commonLocators.listOfOptionByName(branch));
        return this;
    }

    @Step("Select Lab [ {lab} ]")
    public LabOrderForm selectLab(String lab) {
        driver.element().click(labs_list).click(this.commonLocators.listOfOptionByName(lab));
        return this;
    }

    @Step("Select Lab Item [ {labItem} ]")
    public LabOrderForm selectLabItem(String labItem) {
        driver.element().click(labItem_list).click(this.commonLocators.listOfOptionByName(labItem));
        return this;
    }

    @Step("Enter Lab Order Name [ {labOrderItem} ]")
    public LabOrderForm enterLabOrderName(String labOrderItem) {
        driver.element().type(itemName_txtField, labOrderItem);
        return this;
    }

    @Step("Enter Lab Order Due Date [ {labOrderDueDate} ]")
    public LabOrderForm selectLabOrderDueDate(String labOrderDueDate) {
        driver.element().click(dueDate_txtField).type(dueDate_txtField, labOrderDueDate + Keys.ENTER);
        return this;
    }

    @Step("Enter Lab Order Price [ {labOrderPrice} ]")
    public LabOrderForm enterLabOrderPrice(String labOrderPrice) {
        driver.element().type(price_txtField, labOrderPrice);
        return this;
    }

    @Step("Enter Lab Order Quantity [ {labOrderQuantity} ]")
    public LabOrderForm enterLabOrderQuantity(String labOrderQuantity) {
        driver.element().type(quantity_txtField, labOrderQuantity);
        return this;
    }

    @Step("Select Shade [ {shade} ]")
    public LabOrderForm selectShade(String shade) {
        driver.element().click(shade_list).click(this.commonLocators.listOfOptionByName(shade));
        return this;
    }

    @Step("Select Doctor [ {doctor} ]")
    public LabOrderForm selectDoctor(String doctor) {
        driver.element().clear(doctor_list).click(doctor_list).type(doctor_list, doctor).click(this.commonLocators.listOfOptionByName(doctor));
        return this;
    }

    @Step("Select Assigned To [ {assignedTo} ]")
    public LabOrderForm selectAssignedTo(String assignedTo) {
        driver.element().click(assignedTo_list).click(this.commonLocators.listOfOptionByName(assignedTo));
        return this;
    }

    @Step("Select Tooth [ {tooth} ]")
    public LabOrderForm selectTooth(String tooth) {
        driver.element().click(tooth_list).click(this.commonLocators.listOfOptionByName(tooth));
        return this;
    }

    @Step("Upload File: [ {imageName} ]")
    public LabOrderForm uploadFile(String imageName) {
        String path = System.getProperty("user.dir") + "/src/test/resources/Uploads/" + imageName;
        driver.element().typeFileLocationForUpload(this.commonLocators.uploadFile_input, path);
        return this;
    }

    @Step("Enter Lab Order Details")
    public LabOrderForm enterLabOrderDetails(String details) {
        driver.element().type(details_txtField, details);
        return this;
    }


    @Step("Check Paid")
    public LabOrderForm checkPaid() {
        driver.element().click(paid_checkBx);
        return this;
    }

    @Step("Check Received")
    public LabOrderForm checkReceived() {
        driver.element().click(received_checkBx);
        return this;
    }

    @Step("Check Delivered")
    public LabOrderForm checkDelivered() {
        driver.element().click(delivered_checkBx);
        return this;
    }

    @Step("Check Add To Expenses")
    public LabOrderForm checkAddToExpenses() {
        driver.element().click(addToExpenses_checkBx);
        return this;
    }

    @Step("Click On [ Create ] button")
    public LabOrderForm clickOnCreateLabOrder_btn() {
        driver.element().click(createLabOrder_btn);
        return this;
    }

    @Step("Click On [ Update ] button")
    public LabOrderForm clickOnUpdateLabOrder_btn() {
        driver.element().click(updateLabOrder_btn);
        return this;
    }

    @Step("Click On [ Delete ] button")
    public LabOrderForm clickOnDeleteLabOrder_btn() {
        driver.element().click(deleteLabOrder_btn).click(yesConfirmationMessage_btn);
        return this;
    }


}
