package tests.bases;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;

public class GlobalBases {
    public SHAFT.TestData.JSON successMessages;
    // ************************  Test Data URLs   ***************************** //
    public final String patient_Data = "https://docs.google.com/spreadsheets/d/1d6tfNd4rCbmb7r--FlCA5bYCwBli23O-dQ74EFQ3lc0/edit?usp=sharing";
    public final String settings_Data = "https://docs.google.com/spreadsheets/d/1sZ_cQMCvWEXXyjqcyjgbz2HS4Rk-WacObMaxBYd6aiY/edit?usp=sharing";
    public final String associates_Data = "https://docs.google.com/spreadsheets/d/1DELIPkkI7Q4J09wIlGh3z8HpNhcO0Pv9Cms9WStEGHA/edit?usp=sharing";
    public final String inventory_Data = "https://docs.google.com/spreadsheets/d/1kx6QGeYp93hAseZo0T-_wAsiBsq4juXKEo9WDoikHc0/edit?usp=sharing";

    // ************************  Test Data variables   ***************************** //
    public SHAFT.TestData.EXCEL settings_TD;
    public String usersSheet = "Users", branchesSheet = "Branches", permissionsSheet = "PermissionsGroup", monthlyExpensesSheet = "MonthlyExpenses", proceduresSheet = "Procedures", priceListSheet = "PriceList", conditionsSheet = "Conditions", medicalOptionsSheet = "MedicalOptions", clinicalOptionsSheet = "ClinicalOptions", noteTemplatesSheet = "NoteTemplates", medicationsSheet = "Medications", prescriptionTemplatesSheet = "PrescriptionTemplates", patientReminders = "PatientReminders", freeForm = "FreeForm", automaticTasks = "AutomaticTasks";

    public SHAFT.TestData.EXCEL patients_TD;
    public String patientsSheet = "Patients", appointmentsSheet = "Appointments", medicalSheet = "Medical", clinicalSheet = "Clinical";
    public SHAFT.TestData.EXCEL associates_TD;
    public String labsSheet = "Labs", labsItemsSheet = "LabItems", suppliersSheet = "Suppliers", insuranceCompanySheet = "InsuranceCompany";
    public SHAFT.TestData.EXCEL inventory_TD;
    public String branchInventorySheet = "Branch", masterInventorySheet = "Master";
    // ************************  User Stories variables  ***************************** //
    public final String CRUD_Patient_UserStory = "CRUD Patient Functions";
    public final String CRUD_Appointments_UserStory = "CRUD Appointment Functions";
    public final String CRUD_Operations_UserStory = "CRUD Operations Functions";
    public final String CRUD_Prescription_UserStory = "CRUD Prescription Functions";
    public final String CRUD_Notes_UserStory = "CRUD Notes Functions";
    public final String CRUD_LabOrder_UserStory = "CRUD Lab Order Functions";
    public final String CRUD_User_UserStory = "CRUD User Functions";
    public final String CRUD_Branch_UserStory = "CRUD Branch Functions";
    public final String CRUD_MonthlyExpenses_UserStory = "CRUD Monthly Expenses Functions";
    public final String CRUD_Medications_UserStory = "CRUD Medications Functions";
    public final String CRUD_PrescriptionTemplates_UserStory = "CRUD Prescription Templates Functions";
    public final String CRUD_PatientReminder_UserStory = "CRUD Patient Reminder Functions";
    public final String CRUD_FreeForm_UserStory = "CRUD Free Form Functions";
    public final String CRUD_AutomaticTask_UserStory = "CRUD Automatic Task Functions";
    public final String CRUD_Sms_UserStory = "CRUD SMS Functions";
    public final String CRUD_InsuranceCompany_UserStory = "CRUD insurance Company Functions";
    public final String CRUD_Labs_UserStory = "CRUD Labs Functions";
    public final String CRUD_Suppliers_UserStory = "CRUD Suppliers Functions";
    // ************************  Test Cases URLs  ***************************** //
    public final String CRUD_Patient_Functions = "cfc40542bac94b56b25de0d076254a3b?v=c607eb6ff5364dd3b56226882ebef6fe&pvs=4";
    public final String CRUD_Appointments_Functions = "";
    public final String CRUD_Operations_Functions = "";
    public final String CRUD_Prescription_Functions = "";
    public final String CRUD_Notes_Functions = "";
    public final String CRUD_LabOrder_Functions = "206766f521434715a95e68a7288f4503?v=983dfd251d7345deba0aa2ab8c2e32e9&pvs=4";
    public final String CRUD_User_Functions = "";
    public final String CRUD_Branch_Functions = "";
    public final String CRUD_MonthlyExpenses_Functions = "";
    public final String CRUD_Medications_Functions = "";
    public final String CRUD_PrescriptionTemplates_Functions = "";
    public final String CRUD_PatientReminder_Functions = "";
    public final String CRUD_FreeForm_Functions = "";
    public final String CRUD_AutomaticTask_Functions = "";
    public final String CRUD_Sms_Functions = "";
    public final String CRUD_InsuranceCompany_Functions = "";
    public final String CRUD_Labs_Functions = "";
    public final String CRUD_Suppliers_Functions = "";

    @BeforeClass(description = "Before Suite - Setup test data")
    protected void readTestBaseData() {
        settings_TD = new SHAFT.TestData.EXCEL(System.getProperty("settingsData"));
        patients_TD = new SHAFT.TestData.EXCEL(System.getProperty("patientsData"));
        associates_TD = new SHAFT.TestData.EXCEL(System.getProperty("associatesData"));
        inventory_TD = new SHAFT.TestData.EXCEL(System.getProperty("inventoryData"));
        successMessages = new SHAFT.TestData.JSON(System.getProperty("successMessages"));
    }
}
