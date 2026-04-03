package tests.settings.monthlyExpenses;

import com.dentolize.search.SearchApis;
import com.dentolize.settings.monthlyExpenses.api.MonthlyExpensesApi;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;
import engine.Helper;
import engine.Verifications;

@Epic("Settings >> Monthly Expenses")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_MonthlyExpenses_Tests extends ApiBaseTests {

	@Story("As a User, I want to \"Get all Monthly Expenses\"")
	@Test(description = "Verify the User can get all Monthly Expenses")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void getMonthlyExpenses () {
		Response response = monthlyExpensesApis.getMonthlyExpenses(COOKIE, searchTerm, null);
		Verifications.verifyResponseTimeAndStatusCode(response);
	}

	@Story("As a User, I want to \"Add New Monthly Expense\"")
	@Test(groups = {"add"}, description = "Verify the User can Add Monthly Expense")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void addNewMonthlyExpenses () {
		String branchId = searchApis.getBranchId(COOKIE, branch);
		String userId = searchApis.getUserId(COOKIE, user);
		Response addNewMonthlyExpenses = monthlyExpensesApis.addNewMonthlyExpenses(COOKIE, name, amount, automaticPaid, type, userId, branchId, details);
		monthlyExpense_id = RestActions.getResponseJSONValue(addNewMonthlyExpenses, "data.addNewMonthlyExpense.id");
		String monthlyExpense = RestActions.getResponseJSONValue(addNewMonthlyExpenses, "data.addNewMonthlyExpense.name");
		Response getMonthlyExpensesDetails = monthlyExpensesApis.getMonthlyExpenses(COOKIE, monthlyExpense, null);
		Verifications.verifyResponseTimeAndStatusCode(getMonthlyExpensesDetails);
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].id").isEqualTo(monthlyExpense_id);
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].name").isEqualTo(name).perform();
		Float amountR = Float.valueOf(RestActions.getResponseJSONValue(getMonthlyExpensesDetails, "data.monthlyExpenses[0].amount"));
		Validations.verifyThat().number(amountR).isEqualTo(amount).perform();
		Boolean automaticPaidR = Boolean.valueOf(RestActions.getResponseJSONValue(getMonthlyExpensesDetails, "data.monthlyExpenses[0].automatic"));
		Validations.verifyThat().object(automaticPaidR).isEqualTo(automaticPaid).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].type").isEqualTo(type).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].user.name").isEqualTo(user).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].branch.name").isEqualTo(branch).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].details").isEqualTo(details).perform();
	}

	@Story("As a User, I want to \"Edit Monthly Expense\"")
	@Test(dependsOnMethods = "addNewMonthlyExpenses", description = "Verify the User can Edit Monthly Expense")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void editMonthlyExpenses () {
		String userId = searchApis.getUserId(COOKIE, user1);
		String branchId = searchApis.getBranchId(COOKIE, branch1);
		monthlyExpensesApis.editMonthlyExpenses(COOKIE, monthlyExpense_id, name1, amount1, automaticPaid1, type1, userId, branchId, details1);
		Response getMonthlyExpensesDetails = monthlyExpensesApis.getMonthlyExpenses(COOKIE, name1, null);
		Verifications.verifyResponseTimeAndStatusCode(getMonthlyExpensesDetails);
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].name").isEqualTo(name1).perform();
		Float amountR = Float.valueOf(RestActions.getResponseJSONValue(getMonthlyExpensesDetails, "data.monthlyExpenses[0].amount"));
		Validations.verifyThat().number(amountR).isEqualTo(amount1).perform();
		Boolean automaticPaidR = Boolean.valueOf(RestActions.getResponseJSONValue(getMonthlyExpensesDetails, "data.monthlyExpenses[0].automatic"));
		Validations.verifyThat().object(automaticPaidR).isEqualTo(automaticPaid1).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].type").isEqualTo(type1).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].user.name").isEqualTo(user1).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].branch.name").isEqualTo(branch1).perform();
		Validations.verifyThat().response(getMonthlyExpensesDetails).extractedJsonValue("data.monthlyExpenses[0].details").isEqualTo(details1).perform();
	}

	@Story("As a User, I want to \"Delete Monthly Expenses\"")
	@Test(dependsOnMethods = "editMonthlyExpenses", description = "Verify the User can Delete Monthly Expenses")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void deleteMonthlyExpenses () {
		Response deleteMonthlyExpense = monthlyExpensesApis.deleteMonthlyExpenses(COOKIE, monthlyExpense_id);
		Verifications.verifyResponseTimeAndStatusCode(deleteMonthlyExpense);
		Validations.verifyThat().response(deleteMonthlyExpense).extractedJsonValue("data.deleteMonthlyExpense.id").isEqualTo(monthlyExpense_id);
	}

	//*****************************************************//
	//********************// Set Up //*********************//
	//*****************************************************//

	private MonthlyExpensesApi monthlyExpensesApis;
	String searchTerm, monthlyExpense_id;
	String name, type, user, branch, details,
			name1, type1, user1, branch1, details1;
	Boolean automaticPaid, automaticPaid1;
	Float amount, amount1;

	@BeforeClass
	public void loadTestData () {
		searchApis = new SearchApis(restActions);
		monthlyExpensesApis = new MonthlyExpensesApi(restActions);
		JSONFileManager monthlyExpenses_TD = new JSONFileManager(System.getProperty("monthlyExpensesApicJson"));
		// Test Data for search
		searchTerm = monthlyExpenses_TD.getTestData("search");
		// Test Data for Create monthly Expenses
		name = monthlyExpenses_TD.getTestData("internetBill0.name") + Helper.getTimestamp();
		type = monthlyExpenses_TD.getTestData("internetBill0.type");
		user = monthlyExpenses_TD.getTestData("internetBill0.user");
		branch = monthlyExpenses_TD.getTestData("internetBill0.branch");
		details = monthlyExpenses_TD.getTestData("internetBill0.details") + Helper.getTimestamp();
		automaticPaid = Boolean.valueOf(monthlyExpenses_TD.getTestData("internetBill0.automaticPaid"));
		amount = Float.valueOf(monthlyExpenses_TD.getTestData("internetBill0.amount"));
		// Test Data for Update monthly Expenses
		name1 = monthlyExpenses_TD.getTestData("Taxes1.name") + " update" + Helper.getTimestamp();
		type1 = monthlyExpenses_TD.getTestData("Taxes1.type");
		user1 = monthlyExpenses_TD.getTestData("Taxes1.user");
		branch1 = monthlyExpenses_TD.getTestData("Taxes1.branch");
		details1 = monthlyExpenses_TD.getTestData("Taxes1.details") + " update" + Helper.getTimestamp();
		automaticPaid1 = Boolean.valueOf(monthlyExpenses_TD.getTestData("Taxes1.automaticPaid"));
		amount1 = Float.valueOf(monthlyExpenses_TD.getTestData("Taxes1.amount"));
	}
}

