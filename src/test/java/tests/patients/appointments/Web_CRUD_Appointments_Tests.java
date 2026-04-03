package tests.patients.appointments;

import com.dentolize.dashboard.gui.pages.HomePage;
import engine.dataDriven.FakerData;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;
import engine.Helper;
import java.io.IOException;

@Epic("Appointments Module")
@Feature("Web")
@Test(groups = {"web"})
@Owner("Ismail El-Shafeiy")
public class Web_CRUD_Appointments_Tests extends WebBaseTests {
    String createSuccessMessage, updateSuccessMessage, deleteSuccessMessage;

    @BeforeClass(description = "Before class - read success messages from json file")
    public void readSuccessMessageData() {
        createSuccessMessage = successMessages.getTestData("appointments.create");
        updateSuccessMessage = successMessages.getTestData("appointments.update");
        deleteSuccessMessage = successMessages.getTestData("appointments.delete");
    }

    @Test(groups = "smokeTest", description = "Verify the User can \"Add New Appointment\" and fill all required data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Appointments_UserStory)
    @TmsLink(CRUD_Appointments_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newAppointment_requiredData() throws IOException {
        new HomePage(driver).addAppointmentFromShortCut()
                .clickOnAddPatientWithAddAppointment()
                .enterPatient_requiredDataFromAppointmentForm(
                        FakerData.getInstance().getFirstName(), FakerData.getInstance().getLastName() + Helper.getTimestamp(),
                        "01" + FakerData.getInstance().getNumberLimit(9))
                .selectDentist(settings_TD.getCellData("Users", "User1", "Name"))
                .clickOnSubmitAppointmentButton()
                .confirmAppointmentSameTime("Yes")
                .confirmSendSms("Yes")
                .confirmInvalidNumber("Yes");
    //    Verifications.verifyTextForElement(driver, AppointmentForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify the User can \"Add New Appointment\" and fill all appointment form data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Appointments_UserStory)
    @TmsLink(CRUD_Appointments_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newAppointment_AllData1() {
        String appointmentRow = "Appointment1";
        new HomePage(driver)
                .addAppointmentFromShortCut()
                .clickOnAddPatientWithAddAppointment()
                .enterPatient_requiredDataFromAppointmentForm(
                        FakerData.getInstance().getFirstName(), FakerData.getInstance().getLastName() + Helper.getTimestamp(),
                        "01" + FakerData.getInstance().getNumberLimit(9))
                .clickOnUrgentSwitchButton()
                .selectDentist(settings_TD.getCellData(usersSheet, "User1", "Name"))
                .selectRoom("Dr 2")
                .selectAppointmentStatus("Open")
                .selectAppointmentDay("26 Sep 2023")
                .selectAppointmentStartTime("10:00 AM")
                .selectAppointmentEndTime("11:00 AM")
                .selectCreatedAtDate()
                .enterAppointmentDetails(FakerData.getInstance().getTextLimit(500))
                .clickOnSubmitAppointmentButton();
       // Verifications.verifyTextForElement(driver, AppointmentForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }

    @Test(description = "Verify the User can \"Edit Appointment\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Appointments_UserStory)
    @TmsLink(CRUD_Appointments_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Update_Appointment_requiredData() {
        new HomePage(driver).navigateToAppointmentPage()
                .clickOnEditAppointment_btn(1)
                .enterAppointmentDetails(FakerData.getInstance().getTextLimit(2000))
                .clickOnUpdateAppointmentButton();
      //  Verifications.verifyTextForElement(driver, AppointmentForm.successMessageText(updateSuccessMessage), updateSuccessMessage);
    }

    @Test(description = "Verify the User can \"Delete Appointment\"")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Appointments_UserStory)
    @TmsLink(CRUD_Appointments_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Delete_Appointment() {
        new HomePage(driver).navigateToAppointmentPage()
                .clickOnEditAppointment_btn(1)
                .clickOnDeleteAppointmentButton();
      //  Verifications.verifyTextForElement(driver, AppointmentForm.successMessageText(deleteSuccessMessage), deleteSuccessMessage);
    }

    @Test(description = "Verify the User can \"Add New Appointment\" and fill all appointment form data")
    @Issues({@Issue(""), @Issue("")})
    @Story(CRUD_Appointments_UserStory)
    @TmsLink(CRUD_Appointments_Functions)
    @Link(patient_Data)
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyUserCan_Create_newAppointment_AllData() {
        String appointmentRow = "Appointment1";
        new HomePage(driver)
                .addAppointmentFromShortCut()
                .searchForPatient(patients_TD.getCellData(patientsSheet, "Patient1", "First Name"), 1)
                .selectDentist(settings_TD.getCellData("Users", "User1", "Name"))
                .selectRoom(patients_TD.getCellData(appointmentsSheet, appointmentRow, "Room"))
                .selectAppointmentStatus(patients_TD.getCellData(appointmentsSheet, appointmentRow, "Status"))
                .selectAppointmentDay(patients_TD.getCellData(appointmentsSheet, appointmentRow, "Day"))
                .selectAppointmentStartTime(patients_TD.getCellData(appointmentsSheet, appointmentRow, "Start"))
                .selectAppointmentEndTime(patients_TD.getCellData(appointmentsSheet, appointmentRow, "End"))
                .selectCreatedAtDate()
                .enterAppointmentDetails(Helper.getRandomString(1000))
                .clickOnSubmitAppointmentButton();
      //  Verifications.verifyTextForElement(driver, AppointmentForm.successMessageText(createSuccessMessage), createSuccessMessage);
    }
}
