package com.dentolize.dashboard.gui.pages;

import com.dentolize.associates.insuranceCompanies.gui.pages.InsuranceCompanyTable;
import com.dentolize.associates.lab.gui.pages.LabTable;
import com.dentolize.associates.suppliers.gui.pages.SuppliersTable;
import com.dentolize.finances.expenses.gui.pages.ExpenseForm;
import com.dentolize.inventory.gui.pages.MasterInventoryPage;
import com.dentolize.patients.appointments.gui.AppointmentForm;
import com.dentolize.patients.appointments.gui.AppointmentTable;
import com.dentolize.patients.appointments.gui.CalendarPage;
import com.dentolize.patients.info.gui.pages.PatientForm;
import com.dentolize.patients.info.gui.pages.PatientsTable;
import com.dentolize.patients.labOrders.gui.pages.LabOrderForm;
import com.dentolize.patients.labOrders.gui.pages.LabOrderTable;
import com.dentolize.patients.notes.gui.pages.NoteForm;
import com.dentolize.patients.notes.gui.pages.NoteTable;
import com.dentolize.patients.operation.gui.pages.OperationForm;
import com.dentolize.patients.operation.gui.pages.OperationTable;
import com.dentolize.patients.prescriptions.gui.pages.PrescriptionForm;
import com.dentolize.patients.prescriptions.gui.pages.PrescriptionTable;
import com.dentolize.settings.automaticTasks.gui.pages.AutomaticTasksTable;
import com.dentolize.settings.branch.gui.pages.BranchTable;
import com.dentolize.settings.freeForms.gui.pages.FreeFormsTable;
import com.dentolize.settings.medications.gui.pages.MedicationsTable;
import com.dentolize.settings.monthlyExpenses.gui.pages.MonthlyExpensesTable;
import com.dentolize.settings.patientReminders.gui.pages.PatientRemindersTable;
import com.dentolize.settings.prescriptionTemplates.gui.pages.PrescriptionTemplatesTable;
import com.dentolize.settings.sms.gui.pages.SmsTable;
import com.dentolize.settings.users.gui.pages.UserTable;
import com.shaft.driver.SHAFT;
import components.CommonLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        commonLocators = new CommonLocators();
    }

    public static final String baseUrl = getSelectedEnv();
    private final String patientsPage = System.getProperty("patientsPage");
    private final String expensesPage = System.getProperty("expensesPage");
    private final String incomesPage = System.getProperty("incomesPage");
    private final String labOrdersPage = System.getProperty("labOrdersPage");
    private final String masterInventoryPage = System.getProperty("masterInventoryPage");
    private final String branchInventoryPage = System.getProperty("branchInventoryPage");
    private final String labsPage = System.getProperty("labsPage");
    private final String suppliersPage = System.getProperty("suppliersPage");
    private final String insuranceCompaniesPage = System.getProperty("insuranceCompaniesPage");
    private final String userPage = System.getProperty("usersPage");
    private final String branchPage = System.getProperty("branchesPage");
    private final String monthlyExpensesPage = System.getProperty("monthlyExpensesPage");
    private final String proceduresPage = System.getProperty("proceduresPage");
    private final String conditionsPage = System.getProperty("conditionsPage");
    private final String medicalOptionsPage = System.getProperty("medicalOptionsPage");
    private final String clinicalOptionsPage = System.getProperty("clinicalOptionsPage");
    private final String noteTemplatesPage = System.getProperty("noteTemplatesPage");
    private final String medicationsPage = System.getProperty("medicationsPage");
    private final String prescriptionTemplatesPage = System.getProperty("prescriptionTemplatesPage");
    private final String patientRemindersPage = System.getProperty("patientRemindersPage");
    private final String freeFormPage = System.getProperty("freeFormPage");
    private final String automaticTasksPage = System.getProperty("tasksPage");
    private final String smsPage = System.getProperty("smsPage");
    private final String appointmentsPage = System.getProperty("appointmentsPage");
    private final String operationsPage = System.getProperty("operationsPage");
    private final String prescriptionsPage = System.getProperty("prescriptionsPage");
    private final String notesPage = System.getProperty("notesPage");
    private final String communicationsPage = System.getProperty("communicationsPage");
    private final By switchBranch_btn = By.id("select-branch");

    private By getBranchName(String branchName) {
        return By.xpath("(//div[@class='imageContainer'])//following::p[contains(.,'" + branchName + "')]");
    }

    public static By dashboard_menuTitle_txt() {
        return By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Dashboard')]");
    }

    private final By plusIcon_shortCuts = By.xpath("(//span[@class='anticon anticon-plus'])[1]");
    private final By addNewPatient_shortCut = By.id("create-new-patient-menu");
    private final By addNewAppointment_shortCut = By.id("create-new-appointment-menu");
    private final By addNewOperation_shortCut = By.id("create-new-operation-menu");
    private final By addNewPrescription_shortCut = By.id("create-new-prescription-menu");
    private final By addNewNote_shortCut = By.id("create-new-note-menu");
    private final By sendSms_shortCut = By.id("create-new-sms-menu");
    private final By addNewExpense_shortCut = By.id("create-new-expense-menu");
    private final By addNewIncome_shortCut = By.id("create-new-income-menu");
    private final By addNewLabOrder_shortCut = By.id("create-new-lab-order-menu");
    private final By generatePatientLink_shortCut = By.id("create-new-patient-link-menu");
    private final By dashboard_menu = By.id("sidebar-link-home");
    private final By calendar_menu = By.id("sidebar-link-calendar");
    private final By patients_menu = By.id("sidebar-link-patients");
    private final By Reminders_menu = By.id("sidebar-link-reminders");
    private final By menuItems = By.xpath("//li[@class='ant-menu-item'][6]");
    private final By inventory_menuList = By.xpath("//div[contains(@data-menu-id,'-inventory') and @class='ant-menu-submenu-title']");
    private final By masterInventory_menu = By.xpath("(//li[@class='ant-menu-item ant-menu-item-only-child'])[4]");
    private final By attendance = By.cssSelector("#attendance");
    private final By startTimeAttendance = By.xpath("//button[@class='ant-btn css-1whf4lq ant-btn-primary'][contains(.,'Start')]");
    private final By endTimeAttendance = By.xpath("//button[@class='ant-btn css-1whf4lq ant-btn-primary ant-btn-dangerous ant-tooltip-open']");

    @Step("Switch Branch to [{branchName}]")
    public HomePage switchToBranch(String branchName) {
        driver.element().click(switchBranch_btn).click(getBranchName(branchName));
        return this;
    }

    @Step("Navigate to Patients Page")
    public PatientsTable navigateToPatientsPage() {
        String url = baseUrl + patientsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new PatientsTable(driver);
    }

    @Step("Navigate to Patients Page")
    public AppointmentTable navigateToAppointmentPage() {
        String url = baseUrl + appointmentsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new AppointmentTable(driver);
    }

    @Step("Navigate to Operations Page")
    public OperationTable navigateToOperationsPage() {
        String url = baseUrl + operationsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new OperationTable(driver);
    }

    @Step("Navigate to Prescriptions Page")
    public PrescriptionTable navigateToPrescriptionsPage() {
        String url = baseUrl + prescriptionsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new PrescriptionTable(driver);
    }

    @Step("Navigate to Notes Page")
    public NoteTable navigateToNotesPage() {
        String url = baseUrl + notesPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new NoteTable(driver);
    }

    @Step("Navigate to Lab Order Page")
    public LabOrderTable navigateToLabOrderPage() {
        String url = baseUrl + labOrdersPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new LabOrderTable(driver);
    }


    @Step("Navigate to Master Inventory Page")
    public MasterInventoryPage navigateToMasterInventoryPage() {
        String url = baseUrl + masterInventoryPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new MasterInventoryPage(driver);
    }

    @Step("Navigate to Calendar Page")
    public CalendarPage navigateToCalendarPage() {
        driver.element().click(calendar_menu);
        return new CalendarPage(driver);
    }

    @Step("Navigate to Users Page")
    public UserTable navigateToUsersPage() {
        String url = baseUrl + userPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new UserTable(driver);
    }

    @Step("Navigate to Branches Page")
    public BranchTable navigateToBranchesPage() {
        String url = baseUrl + branchPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new BranchTable(driver);
    }

    @Step("Navigate to Monthly Expenses Page")
    public MonthlyExpensesTable navigateToMonthlyExpensesPage() {
        String url = baseUrl + monthlyExpensesPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new MonthlyExpensesTable(driver);
    }

    @Step("Navigate to Medications Page")
    public MedicationsTable navigateToMedicationsPage() {
        String url = baseUrl + medicationsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new MedicationsTable(driver);
    }

    @Step("Navigate to Prescription Templates Page")
    public PrescriptionTemplatesTable navigateToPrescriptionTemplatesPage() {
        String url = baseUrl + prescriptionTemplatesPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new PrescriptionTemplatesTable(driver);
    }

    @Step("Navigate to Patient Reminders Page")
    public PatientRemindersTable navigateToPatientRemindersPage() {
        String url = baseUrl + patientRemindersPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new PatientRemindersTable(driver);
    }

    @Step("Navigate to Free Forms Page")
    public FreeFormsTable navigateToFreeFormsPage() {
        String url = baseUrl + freeFormPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new FreeFormsTable(driver);
    }

    @Step("Navigate to Free Forms Page")
    public AutomaticTasksTable navigateToAutomaticTasksPage() {
        String url = baseUrl + automaticTasksPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new AutomaticTasksTable(driver);
    }

    @Step("Navigate to SMS Page")
    public SmsTable navigateToSmsPage() {
        String url = baseUrl + smsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new SmsTable(driver);
    }

    @Step("Navigate to Labs Page")
    public LabTable navigateToLabsPage() {
        String url = baseUrl + labsPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new LabTable(driver);
    }

    @Step("Navigate to Suppliers Page")
    public SuppliersTable navigateToSuppliersPage() {
        String url = baseUrl + suppliersPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new SuppliersTable(driver);
    }

    @Step("Navigate to Insurance Company Page")
    public InsuranceCompanyTable navigateToInsuranceCompanyPage() {
        String url = baseUrl + insuranceCompaniesPage;
        driver.browser().navigateToURL(url).getCurrentWindowTitle();
        return new InsuranceCompanyTable(driver);
    }

    //************************* Shortcuts actions  ****************************//

    @Step("Add New Patient")
    public PatientForm addNewPatientFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewPatient_shortCut);
        return new PatientForm(driver);
    }

    @Step("Add New Appointment")
    public AppointmentForm addAppointmentFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewAppointment_shortCut);
        return new AppointmentForm(driver);
    }

    @Step("Add New Operation")
    public OperationForm addOperationFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewOperation_shortCut);
        return new OperationForm(driver);
    }

    @Step("Add New Prescription")
    public PrescriptionForm addPrescriptionFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewPrescription_shortCut);
        return new PrescriptionForm(driver);
    }

    @Step("Add New Note")
    public NoteForm AddNewNoteFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewNote_shortCut);
        return new NoteForm(driver);
    }

    @Step("Add New Appointment")
    public LabOrderForm addLabOrderFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewLabOrder_shortCut);
        return new LabOrderForm(driver);
    }

    @Step("Add New Expense")
    public ExpenseForm addNewExpenseFromShortCut() {
        driver.element().click(plusIcon_shortCuts).click(addNewExpense_shortCut);
        return new ExpenseForm(driver);
    }

    private static String getSelectedEnv() {
        String env = System.getProperty("env");
        return switch (env) {
            case "qa" -> System.getProperty("qaUrl");
            case "dev" -> System.getProperty("devUrl");
            case "prod" -> System.getProperty("prodUrl");
            default -> throw new IllegalArgumentException("Invalid environment: [ " + env + " ]");
        };
    }
}