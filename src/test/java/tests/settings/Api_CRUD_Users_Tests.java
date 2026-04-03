package tests.settings;


import com.dentolize.search.SearchApis;
import com.dentolize.settings.users.api.UsersApi;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.ApiBaseTests;
import engine.Helper;

import java.util.List;

@Epic("Settings >> Users")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Users_Tests extends ApiBaseTests {

	@Story("As a User, I want to \"Add New User\"")
	@Test(description = "Verify the User can Add User")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void addNewUser () {
		Response permissionGroups = searchApis.searchPermissionGroups(COOKIE, permissionGroup);
		String permissionGroup_id = RestActions.getResponseJSONValue(permissionGroups, "data.searchGroups[0].id");
		Response addNewUserResponse = usersApis.addNewUser(COOKIE, name, phoneNumber, phoneNumber2, branches, job, salary, permissionGroup_id, dentalNotation, loginMethod, email, username, password, isDoctor, doctorPercentage, expensesFrom, automaticExpenses, automaticPaid, customFields);
		String user_id = RestActions.getResponseJSONValue(addNewUserResponse, "data.addNewUser.id");
		Response getUserResponse = usersApis.getUsers(COOKIE, name);

		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].id").isEqualTo(user_id).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].name").isEqualTo(name).perform();
//		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].loginMethod").isEqualTo(loginMethod).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].username").isEqualTo(username).perform();
		Boolean isDoctorR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].isDoctor"));
		Validations.verifyThat().object(isDoctorR).isEqualTo(isDoctor).perform();
		Float doctorPercentageR = Float.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].doctorPercentage"));
		Validations.verifyThat().object(doctorPercentageR).isEqualTo(doctorPercentage).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].phoneNumber").isEqualTo(phoneNumber).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].phoneNumber2").isEqualTo(phoneNumber2).perform();
		Float salaryR = Float.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].salary"));
		Validations.verifyThat().object(salaryR).isEqualTo(salary).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].expensesFrom").isEqualTo(expensesFrom).perform();
		Boolean automaticExpensesR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].automaticExpenses"));
		Validations.verifyThat().object(automaticExpensesR).isEqualTo(automaticExpenses).perform();
		Boolean automaticPaidR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].automatic"));
		Validations.verifyThat().object(automaticPaidR).isEqualTo(automaticPaid).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].job").isEqualTo(job).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].dentalNotation").isEqualTo(dentalNotation).perform();
//		Validations.verifyThat().response(addNewUserResponse).extractedJsonValue("data.users[0].address").isEqualTo(address).perform();
		//        Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].branches[0].id").isEqualTo(branches).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].group.name").isEqualTo(permissionGroup).perform();
	}

	@Story("As a User, I want to \"edit New User\"")
	@Test(dependsOnMethods = "addNewUser", description = "Verify the User can edit User")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void editNewUser () {
		Response permissionGroups = searchApis.searchPermissionGroups(COOKIE, _permissionGroup);
		String permissionGroup_id = RestActions.getResponseJSONValue(permissionGroups, "data.searchGroups[0].id");
		usersApis.editUser(COOKIE, user_id, _name, _phoneNumber, _phoneNumber2, _branches, _job, _salary, permissionGroup_id, _dentalNotation, _loginMethod, _email, _username, _password, _isDoctor, _doctorPercentage, _expensesFrom, _automaticExpenses, _automaticPaid, _customFields);
		Response getUserResponse = usersApis.getUsers(COOKIE, _name);

//		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].id").isEqualTo(user_id).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].name").isEqualTo(_name).perform();
//		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].loginMethod").isEqualTo(loginMethod).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].username").isEqualTo(_username).perform();
		Boolean isDoctorR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].isDoctor"));
		Validations.verifyThat().object(isDoctorR).isEqualTo(_isDoctor).perform();
		Float doctorPercentageR = Float.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].doctorPercentage"));
		Validations.verifyThat().object(doctorPercentageR).isEqualTo(_doctorPercentage).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].phoneNumber").isEqualTo(_phoneNumber).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].phoneNumber2").isEqualTo(_phoneNumber2).perform();
		Float salaryR = Float.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].salary"));
		Validations.verifyThat().object(salaryR).isEqualTo(_salary).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].expensesFrom").isEqualTo(_expensesFrom).perform();
		Boolean automaticExpensesR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].automaticExpenses"));
		Validations.verifyThat().object(automaticExpensesR).isEqualTo(_automaticExpenses).perform();
		Boolean automaticPaidR = Boolean.valueOf(RestActions.getResponseJSONValue(getUserResponse, "data.users[0].automatic"));
		Validations.verifyThat().object(automaticPaidR).isEqualTo(_automaticPaid).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].job").isEqualTo(_job).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].dentalNotation").isEqualTo(_dentalNotation).perform();
//		Validations.verifyThat().response(addNewUserResponse).extractedJsonValue("data.users[0].address").isEqualTo(address).perform();
		//        Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].branches[0].id").isEqualTo(branches).perform();
		Validations.verifyThat().response(getUserResponse).extractedJsonValue("data.users[0].group.name").isEqualTo(_permissionGroup).perform();
	}

	@Story("As a User, I want to \"Disable New User\"")
	@Test(dependsOnMethods = "editNewUser", description = "Verify the User can disable User")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void disableNewUser () {
		Response getUserResponse = usersApis.getUsers(COOKIE, _name);
		user_id = RestActions.getResponseJSONValue(getUserResponse, "data.users[0].id");
		Response disableUserResp = usersApis.disableUser(COOKIE, user_id, disableUser);
		Response userDetailsResponse = usersApis.getUsers(COOKIE, _name);
		boolean disableUserR = Boolean.parseBoolean(RestActions.getResponseJSONValue(disableUserResp, "data.disableUser.disabled"));
		Validations.verifyThat().object(disableUserR).isEqualTo(disableUser).perform();
	}


	//*****************************************************//
	//********************// Set Up //*********************//
	//*****************************************************//

	private UsersApi usersApis;
	String user_id, name, phoneNumber, phoneNumber2, job, dentalNotation, companyLoginName, permissionGroup, loginMethod, address, email, username, password, expensesFrom,
			_name, _phoneNumber, _phoneNumber2, _job, _dentalNotation, _companyLoginName, _permissionGroup, _loginMethod, _address, _email, _username, _password, _expensesFrom;
	List customFields, branches, _customFields, _branches, permissions, _permissions, images, _images;
	Float doctorPercentage, _doctorPercentage, salary, _salary;
	Boolean disableUser, isDoctor, _isDoctor, automaticExpenses, _automaticExpenses, automaticPaid, _automaticPaid;

	@BeforeClass
	public void loadTestData () {
		searchApis = new SearchApis(restActions);
		usersApis = new UsersApi(restActions);
		JSONFileManager users_TD = new JSONFileManager(System.getProperty("usersApisJson"));
		// Test Data for add new user
		name = users_TD.getTestData("doctor_1.name") + Helper.getTimestamp();
		loginMethod = users_TD.getTestData("doctor_1.loginMethod");
		companyLoginName = users_TD.getTestData("doctor_1.companyLoginName");
		username = users_TD.getTestData("doctor_1.username") + randomNumber;
		password = users_TD.getTestData("doctor_1.password");
		isDoctor = Boolean.valueOf(users_TD.getTestData("doctor_1.isDoctor"));
		doctorPercentage = Float.valueOf(users_TD.getTestData("doctor_1.doctorPercentage"));
		salary = Float.valueOf(users_TD.getTestData("doctor_1.salary"));
		expensesFrom = users_TD.getTestData("doctor_1.expensesFrom");
		automaticExpenses = Boolean.valueOf(users_TD.getTestData("doctor_1.automaticExpenses"));
		automaticPaid = Boolean.valueOf(users_TD.getTestData("doctor_1.automaticPaid"));
		job = users_TD.getTestData("doctor_1.job");
		dentalNotation = users_TD.getTestData("doctor_1.dentalNotation");
		phoneNumber = users_TD.getTestData("doctor_1.phoneNumber");
		phoneNumber2 = users_TD.getTestData("doctor_1.phoneNumber2");
		address = users_TD.getTestData("doctor_1.address") + Helper.getTimestamp();
		branches = users_TD.getTestDataAsList("doctor_1.branches");
		permissionGroup = users_TD.getTestData("doctor_1.group");
		permissions = users_TD.getTestDataAsList("doctor_1.permissions");
		customFields = users_TD.getTestDataAsList("doctor_1.customFields");
		images = users_TD.getTestDataAsList("doctor_1.images");
		// Test Data for Edit User
		_name = users_TD.getTestData("doctor_2.name") + " updated" + Helper.getTimestamp();
		_loginMethod = users_TD.getTestData("doctor_2.loginMethod");
		_companyLoginName = users_TD.getTestData("doctor_2.companyLoginName");
		_username = users_TD.getTestData("doctor_2.username") + randomNumber;
		_password = users_TD.getTestData("doctor_2.password");
		_isDoctor = Boolean.valueOf(users_TD.getTestData("doctor_2.isDoctor"));
		_doctorPercentage = Float.valueOf(users_TD.getTestData("doctor_2.doctorPercentage"));
		_salary = Float.valueOf(users_TD.getTestData("doctor_2.salary"));
		_expensesFrom = users_TD.getTestData("doctor_2.expensesFrom");
		_automaticExpenses = Boolean.valueOf(users_TD.getTestData("doctor_2.automaticExpenses"));
		_automaticPaid = Boolean.valueOf(users_TD.getTestData("doctor_2.automaticPaid"));
		_job = users_TD.getTestData("doctor_2.job");
		_dentalNotation = users_TD.getTestData("doctor_2.dentalNotation");
		_phoneNumber = users_TD.getTestData("doctor_2.phoneNumber");
		_phoneNumber2 = users_TD.getTestData("doctor_2.phoneNumber2");
		_address = users_TD.getTestData("doctor_2.address") + Helper.getTimestamp();
		_branches = users_TD.getTestDataAsList("doctor_2.branches");
		_permissionGroup = users_TD.getTestData("doctor_2.group");
		_permissions = users_TD.getTestDataAsList("doctor_2.permissions");
		_customFields = users_TD.getTestDataAsList("doctor_2.customFields");
		_images = users_TD.getTestDataAsList("doctor_2.images");

		// Test Data for disable user
		disableUser = Boolean.valueOf(users_TD.getTestData("disableUser.disabled"));
	}
}

