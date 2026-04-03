package com.dentolize.patients.info.gui.pages;

import com.dentolize.patients.appointments.gui.AppointmentForm;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import components.CommonLocators;
import components.ConfirmationMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static components.CommonLocators.getByTestId;
import static components.CommonLocators.getInputByTestId;

public class PatientForm {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public PatientForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        commonLocators = new CommonLocators();
    }

    private final By patientReferenceId_txtField = getByTestId("patientForm-referenceId");
    private final By patientFirstName_txtField = getByTestId("patientForm-firstName");
    private final By patientLastName_txtField = getByTestId("patientForm-lastName");
    private final By patientPhoneNumber_numericField = getByTestId("patientForm-phoneNumber");
    private final By patientPhoneNumber2_numericField = getByTestId("patientForm-phoneNumber2");
    private final By country_searchList = getInputByTestId("patientForm-country");
    private final By dateOfBirth_datePicker = getByTestId("patientForm-birthDate");
    private final By title_searchList = getInputByTestId("patientForm-patientTitle");
    private final By gender_dropDnList = getByTestId("patientForm-gender");
    private final By patientEmail_emailField = getByTestId("patientForm-email");
    private final By address_searchList = getByTestId("patientForm-addressField");
    private final By assignedPractitioner_searchList = getInputByTestId("patientForm-assignedPractitioner");
    private final By priceList_searchList = getInputByTestId("patientForm-priceList");
    private final By tags_searchMultiSelect = getByTestId("patientForm-patientTags");
    private final By material_dropDnList = getByTestId("patientForm-marital");
    private final By job_searchList = getInputByTestId("selectWithNewOptions-job");
    private final By nationality_searchList = getByTestId("countryField-nationality");
    private final By tax_decimalField = getByTestId("patientForm-tax");
    private final By createdAt_dateTimePicker = getByTestId("patientForm-createdAt");
    private final By branch_searchList = getInputByTestId("");
    private final By nationalId_numericField = getByTestId("nameField-nationalId");
    private final By patientDetails_textArea = getByTestId("patientForm-details");
    private final By uploadImage_btn = getByTestId("upload-image");
    private final By removeImage_btn = getByTestId("delete-image");
    private final By referralType_searchList = getInputByTestId("patientForm-referralSource");
    private final By patientReferralDetails_txtArea = getByTestId("patientForm-referralDetails");
    private final By patientReferral_searchList = getInputByTestId("patientForm-referralPatient");
    private final By userReferral_searchList = getInputByTestId("patientForm-referralUser");
    private final By addFamilyMember_btn = getByTestId("patientForm-newFamily");
    private final By deleteFamilyMember_btn = getByTestId("patientForm-deleteFamily-0");

    private By familySelectPatient_searchList(int index) {
        return getByTestId("searchField-" + index + ",patient");
    }

    private By familySelectRelation_searchList(int index) {
        return getByTestId("patientForm-familyRelation-" + index + "");
    }

    private final By emergencyFirstName_txtField = getByTestId("patientForm-firstNameE");
    private final By emergencyLastName_txtField = getByTestId("patientForm-lastNameE");
    private final By emergencyPhoneNumber_numericField = getByTestId("patientForm-phoneNumberE");
    private final By emergencySecondPhoneNumber_numericField = getByTestId("patientForm-phoneNumber2E");
    private final By emergencyAddress_txtField = getByTestId("patientForm-addressE");
    private final By emergencyRelationship_searchList = getByTestId("patientForm-relationE");
    private final By datePickerToday_btn = By.xpath("//div//a[@class='ant-picker-today-btn' and contains(.,'Today')]");
    private final By createPatient_btn = By.xpath("//button[@type='submit' and contains(.,'Create')]");
    private final By updatePatient_btn = By.xpath("//button[@type='submit' and contains(.,'Update')]");
    private final By addInsurance_btn = getByTestId("");
    private final By insuranceName_input = getByTestId("");
    private final By insuranceCompanyNumber_input = getByTestId("");
    private final By insuranceLimit_input = getByTestId("");
    private final By insuranceUnlimited_checkbox = getByTestId("");
    private final By insuranceDiscount_input = getByTestId("");
    private final By insuranceFullDiscount_checkbox = getByTestId("");
    private final By insuranceMemberNumber_input = getByTestId("");
    private final By insuranceGroup_input = getByTestId("");
    private final By insuranceCRT_input = getByTestId("");
    private final By insuranceExpirationDate_input = getByTestId("");
    private final By insuranceStartMonth_input = getByTestId("");

    private By insuranceMonth_list(String month) {
        return By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[@title='" + month + "']");
    }
    //private final By deletePatient_btn = commonLocators.dynamicButtons("Delete/Archive");
    //private final By mergePatient_btn = commonLocators.dynamicButtons("Merge Patient");

    @Step("Enter Patient Custom ID: [ {patientId} ]")
    public PatientForm enterPatientCustomId(String patientId) {
        driver.element().type(patientReferenceId_txtField, patientId);
        return this;
    }

    @Step("Enter Required Patient Data: [ {patientFirstName} ], [ {patientLastName} ], [ {patientPhoneNumber} ]")
    public PatientForm enterPatient_requiredData(String patientFirstName, String patientLastName, String patientPhoneNumber) {
        enterRequiredDataToCreatePatient(patientFirstName, patientLastName, patientPhoneNumber);
        return this;
    }

    @Step("Enter Required Patient Data: [ {patientFirstName} ], [ {patientLastName} ], [ {patientPhoneNumber} ]")
    public AppointmentForm enterPatient_requiredDataFromAppointmentForm(String patientFirstName, String patientLastName, String patientPhoneNumber) {
        enterRequiredDataToCreatePatient(patientFirstName, patientLastName, patientPhoneNumber);
        return new AppointmentForm(driver);
    }

    @Step("Enter Patient Phone Number 2: [ {patientPhoneNumber2} ]")
    public PatientForm enterPatientPhoneNumber2(String patientPhoneNumber2) {
        driver.element().type(patientPhoneNumber2_numericField, patientPhoneNumber2);
        return this;
    }

    @Step("Select Patient Country: [ {countryName} ]")
    public PatientForm selectPatientCountry(String countryName) {
        driver.element()
                .type(country_searchList, countryName)
                .type(country_searchList, Keys.ENTER);
        return this;
    }

    @Step("Select Patient Date of Birth today")
    public PatientForm selectPatientBirthDate() {
        driver.element()
                .click(dateOfBirth_datePicker)
                .click(datePickerToday_btn);
        return this;
    }

    @Step("Select Patient Title: [ {title} ]")
    public PatientForm selectPatientTitle(String title) {
        driver.element()
                .click(title_searchList)
                .type(title_searchList, title + Keys.ENTER);
        return this;
    }

    @Step("Select Patient Gender: [ {gender} ]")
    public PatientForm selectPatientGender(String gender) {
        driver.element()
                .click(gender_dropDnList)
                .click(this.commonLocators.listOfOptionByName(gender));
        return this;
    }

    @Step("Enter Patient Email: [ {patientEmail} ]")
    public PatientForm enterPatientEmail(String patientEmail) {
        driver.element().type(patientEmail_emailField, patientEmail);
        return this;
    }

    //TODO: Refactor Locators
    @Step("Select Patient Address: [ {address} ]")
    public PatientForm selectPatientAddress(String address) {
        driver.element()
                .click(address_searchList)
                .type(address_searchList, address)
                .click(this.commonLocators.listOfOptionByName(address));
        return this;
    }

    @Step("Select Assigned Practitioner for Patient: [ {assignedPractitioner} ]")
    public PatientForm selectAssignedPractitioner(String assignedPractitioner) {
        driver.element()
                .click(assignedPractitioner_searchList)
                .type(assignedPractitioner_searchList, assignedPractitioner)
                .click(this.commonLocators.listOfOptionByName(assignedPractitioner));
        return this;
    }

    @Step("Select Price List Group: [ {priceList} ]")
    public PatientForm selectPatientPriceList(String priceList) {
        driver.element()
                .click(priceList_searchList)
                .type(priceList_searchList, priceList)
                .click(this.commonLocators.listOfOptionByName(priceList));
        return this;
    }

    @Step("Select Patient Tag : [ {tag} ]")
    public PatientForm selectPatientTag(String tag) {
        driver.element()
                .click(tags_searchMultiSelect)
                .type(tags_searchMultiSelect, tag)
                .click(this.commonLocators.listOfOptionByName(tag));
        return this;
    }

    @Step("Select Patient Material : [ {material} ]")
    public PatientForm selectPatientMaterial(String material) {
        driver.element()
                .click(material_dropDnList)
                .click(this.commonLocators.listOfOptionByName(material));
        return this;
    }

    @Step("Select Patient Job: [ {job} ]")
    public PatientForm selectPatientJob(String job) {
        driver.element()
                .click(job_searchList)
                .type(job_searchList, job)
                .click(this.commonLocators.listOfOptionByName(job));
        return this;
    }

    @Step("Enter Patient Tax : [ {tax} ]")
    public PatientForm enterPatientTax(String tax) {
        driver.element()
                .type(tax_decimalField, tax);
        return this;
    }

    @Step("Select created at date today")
    public PatientForm selectPatientCreatedAt() {
        driver.element()
                .click(createdAt_dateTimePicker)
                .click(datePickerToday_btn);
        return this;
    }

    @Step("Select Patient Branch: [ {branch} ]")
    public PatientForm selectPatientBranch(String branch) {
        driver.element()
                .click(branch_searchList)
                .click(this.commonLocators.listOfOptionByName(branch));
        return this;
    }

    @Step("Enter Patient Details")
    public PatientForm enterPatientDetails(String details) {
        driver.element().type(patientDetails_textArea, details);
        return this;
    }

    @Step("Upload Patient Image: [ {imageName} ]")
    public PatientForm uploadPatientProfilePicture(String imageName) {
        String path = System.getProperty("user.dir") + "/src/test/resources/Uploads/" + imageName;
        driver.element().typeFileLocationForUpload(uploadImage_btn, path);
        return this;
    }

    //TODO: Refactor Locators for insurance fields
    @Step("Enter Required Insurance Data: [ {companyName} ], [ {limit} ], [ {Discount} ]")
    public PatientForm enterInsurance_requiredData(String companyName, String limit, String Discount) {
//        driver.element().scrollToElement(sectionTitleInForm("Insurance Details"));
//        driver.element().waitToBeReady(addInsurance_btn);
        driver.element().click(addInsurance_btn);
        enterRequiredDataToAddInsurance(companyName, limit, Discount);
        return this;
    }

    @Step("Enter insurance company Phone Number")
    public PatientForm enterInsuranceCompanyPhoneNumber(String phoneNumber) {
        driver.element().type(insuranceCompanyNumber_input, phoneNumber);
        return this;
    }

    @Step("Enter Insurance Member")
    public PatientForm enterInsuranceMember(String member) {
        driver.element()
                .type(insuranceMemberNumber_input, member)
                .type(insuranceMemberNumber_input, Keys.ENTER);
        return this;
    }

    @Step("Enter Insurance Group")
    public PatientForm enterInsuranceGroup(String group) {
        driver.element()
                .type(insuranceGroup_input, group)
                .type(insuranceGroup_input, Keys.ENTER);
        return this;
    }

    @Step("Enter Insurance CRT")
    public PatientForm enterInsuranceCRT(String crt) {
        driver.element()
                .type(insuranceCRT_input, crt)
                .type(insuranceCRT_input, Keys.ENTER);
        return this;
    }

    @Step("Select Insurance Start Month")
    public PatientForm selectInsuranceStartMonth(String month) {
        driver.element()
                .click(insuranceStartMonth_input)
                .click(insuranceMonth_list(month));
        return this;
    }

    @Step("Select patient referral: [ {referral} ]")
    public PatientForm selectPatientReferral(String referral) {
        driver.element()
                .click(referralType_searchList)
                .click(this.commonLocators.listOfOptionByName(referral));
        return this;
    }

    @Step("Enter Referral Details")
    public PatientForm enterReferralDetails(String details) {
        driver.element().type(patientReferralDetails_txtArea, details);
        return this;
    }

    @Step("Enter Emergency Name: [ {firstName} ], [ {lastName} ]")
    public PatientForm enterEmergencyName(String firstName, String lastName, String phoneNumber, String secondPhoneNumber) {
        driver.element()
                .type(emergencyFirstName_txtField, firstName)
                .type(emergencyLastName_txtField, lastName)
                .type(emergencyPhoneNumber_numericField, phoneNumber)
                .type(emergencySecondPhoneNumber_numericField, secondPhoneNumber);
        return this;
    }

    @Step("Enter Emergency Address: [ {address} ]")
    public PatientForm enterEmergencyAddress(String address) {
        driver.element().type(emergencyAddress_txtField, address);
        return this;
    }

    public PatientForm selectEmergencyRelationship(String relationship) {
        driver.element()
                .click(emergencyRelationship_searchList)
                .click(this.commonLocators.listOfOptionByName(relationship));
        return this;
    }


    // ******** common methods ********* //
    @Step("Add required data to create patient")
    private void enterRequiredDataToCreatePatient(String patientFirstName, String patientLastName, String patientPhoneNumber) {
        driver.element()
                .type(patientFirstName_txtField, patientFirstName)
                .type(patientLastName_txtField, patientLastName)
                .type(patientPhoneNumber_numericField, patientPhoneNumber);
        new ConfirmationMessage(driver).confirmInvalidNumber("Yes");
    }

    /**
     * @param insuranceName     insurance name
     * @param insuranceLimit    insurance limit option -> unlimited or limit value
     * @param insuranceDiscount insurance discount option -> fullDiscount or discount value
     */

    @Step("Add required data to Add insurance to patient {insuranceName}, {insuranceLimit}, {insuranceDiscount}")
    private void enterRequiredDataToAddInsurance(String insuranceName, String insuranceLimit, String insuranceDiscount) {
        driver.element().type(insuranceName_input, insuranceName);
        try {
            if (insuranceLimit.contains("unlimited")) {
                driver.element().click(insuranceUnlimited_checkbox);
            } else {
                driver.element().type(insuranceLimit_input, insuranceLimit);
            }
        } catch (Exception e) {
            ReportManager.log("Invalid test data -> input insurance limit " + e);
        }
        try {
            if (insuranceDiscount.contains("fullDiscount")) {
                driver.element().click(insuranceFullDiscount_checkbox);
            } else {
                driver.element().type(insuranceDiscount_input, insuranceDiscount);
            }
        } catch (Exception e) {
            ReportManager.log("Invalid test data -> input insurance discount " + e);
        }
    }

    @Step("Click on [ Create ] button")
    public PatientForm createPatientForm_btn() {
        driver.element().click(createPatient_btn);
        return this;
    }

    @Step("Click on [ Update ] button")
    public PatientForm updatePatientForm_btn() {
        driver.element().click(updatePatient_btn);
        return this;
    }

    @Step("Click on [ Delete ] button")
    public PatientForm deletePatientForm_btn() {
        driver.element()
                .click(this.commonLocators.dynamicButtons("Delete/Archive"))
                .click(this.commonLocators.dynamicButtons("Yes"));
        return this;
    }
}
