package tests.settings.branch;

import com.dentolize.search.SearchApis;
import com.dentolize.settings.branch.api.BranchesApis;
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

import java.util.List;


@Epic("Settings >> Branches")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_Branches_Tests extends ApiBaseTests {

	@Story("As a User, I want to \"Get All Branches\"")
	@Test(description = "Verify the User can get all Branches")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void getBranches () {
		Response response = branchesApis.getAllBranches(COOKIE, 0, 25, "createdAt-desc", searchTerm, branch);
		Verifications.verifyResponseTimeAndStatusCode(response);
	}

	@Story("As a User, I want to \"Add New Branches\"")
	@Test(description = "Verify the User can Add New Branch")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void addNewBranch () {
		Response addNewBranchResponse = branchesApis.addNewBranch(COOKIE, name, address, phones, users, defaultPriceList, availablePriceLists, diagnosticFee, rooms, openDays, opens, closes, viewClosedTimes);
		branch_id = RestActions.getResponseJSONValue(addNewBranchResponse, "data.addNewBranch.id");
		Response branchResponse = branchesApis.getBranchDetails(COOKIE, branch_id);
		Verifications.verifyResponseTimeAndStatusCode(branchResponse);
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.name").isEqualTo(name).perform();
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.address").isEqualTo(address).perform();
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.defaultPriceList.id").isEqualTo(defaultPriceList).perform();
		float diagnosticFeeR = Float.parseFloat(RestActions.getResponseJSONValue(branchResponse, "data.branchDetails.diagnosticFee"));
		Validations.verifyThat().number(diagnosticFeeR).isEqualTo(diagnosticFee).perform();
		boolean viewClosedTimesR = Boolean.parseBoolean(RestActions.getResponseJSONValue(branchResponse, "data.branchDetails.viewClosedTimes"));
		Validations.verifyThat().object(viewClosedTimesR).isEqualTo(viewClosedTimes).perform();
		List<Object> phoneList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.phones");
		Validations.verifyThat().object(phoneList).isEqualTo(phones).perform();
		List<Object> roomList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.rooms");
		Validations.verifyThat().object(roomList).isEqualTo(rooms).perform();
		List<Object> openDaysList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.openDays");
		Validations.verifyThat().object(openDaysList).isEqualTo(openDays).perform();
		List<Object> opensList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.opens");
		Validations.verifyThat().object(opensList).isEqualTo(opens).perform();
		List<Object> closesList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.closes");
		Validations.verifyThat().object(closesList).isEqualTo(closes).perform();


	}

	@Story("As a User, I want to \"Edit Branch\"")
	@Test(dependsOnMethods = "addNewBranch", description = "Verify the User can Edit Branch")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void editBranch () {
		branchesApis.editBranch(COOKIE, branch_id, name1, address1, phones1, users1, defaultPriceList1, availablePriceLists1, diagnosticFee1, rooms1, openDays1, opens1, closes1, viewClosedTimes1);
		Response branchResponse = branchesApis.getBranchDetails(COOKIE, branch_id);
		Verifications.verifyResponseTimeAndStatusCode(branchResponse);
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.name").isEqualTo(name1).perform();
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.address").isEqualTo(address1).perform();
		Validations.verifyThat().response(branchResponse).extractedJsonValue("data.branchDetails.defaultPriceList.id").isEqualTo(defaultPriceList1).perform();
		float diagnosticFeeR = Float.parseFloat(RestActions.getResponseJSONValue(branchResponse, "data.branchDetails.diagnosticFee"));
		Validations.verifyThat().number(diagnosticFeeR).isEqualTo(diagnosticFee).perform();
		boolean viewClosedTimesR = Boolean.parseBoolean(RestActions.getResponseJSONValue(branchResponse, "data.branchDetails.viewClosedTimes"));
		Validations.verifyThat().object(viewClosedTimesR).isEqualTo(viewClosedTimes).perform();
		List<Object> phoneList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.phones");
		Validations.verifyThat().object(phoneList).isEqualTo(phones).perform();
		List<Object> roomList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.rooms");
		Validations.verifyThat().object(roomList).isEqualTo(rooms).perform();
		List<Object> openDaysList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.openDays");
		Validations.verifyThat().object(openDaysList).isEqualTo(openDays).perform();
		List<Object> opensList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.opens");
		Validations.verifyThat().object(opensList).isEqualTo(opens).perform();
		List<Object> closesList = RestActions.getResponseJSONValueAsList(branchResponse, "data.branchDetails.closes");
		Validations.verifyThat().object(closesList).isEqualTo(closes).perform();
	}

	@Story("As a User, I want to \"Disable Branch\"")
	@Test(dependsOnMethods = "editBranch", description = "Verify the User can disable Branch")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void disableDetails () {
		branchesApis.disableBranch(COOKIE, branch_id, disableBranch);
		Response branchDetailsResponse = branchesApis.getBranchDetails(COOKIE, branch_id);
		Verifications.verifyResponseTimeAndStatusCode(branchDetailsResponse);
		boolean disableBranchR = Boolean.parseBoolean(RestActions.getResponseJSONValue(branchDetailsResponse, "data.branchDetails.disabled"));
		Validations.verifyThat().object(disableBranchR).isEqualTo(disableBranch).perform();
	}

	//*****************************************************//
	//********************// Set Up //*********************//
	//*****************************************************//
	private BranchesApis branchesApis;
	String searchTerm, branch;
	String branch_id, name, name1, address, address1, defaultPriceList, defaultPriceList1;
	Float diagnosticFee, diagnosticFee1;
	List users, phones, availablePriceLists, openDays, rooms, opens, closes, phones1,
			users1, availablePriceLists1, openDays1, rooms1, opens1, closes1;
	Boolean viewClosedTimes, viewClosedTimes1, disableBranch;

	@BeforeClass
	public void loadTestData () {
		SearchApis searchApis = new SearchApis(restActions);
		branchesApis = new BranchesApis(restActions);
		JSONFileManager branches_TD = new JSONFileManager(System.getProperty("branchesApisJson"));
		// Test Data for search branches
		searchTerm = branches_TD.getTestData("search.searchTerm");
		branch = branches_TD.getTestData("search.branch");
		// Test Data for create branch
		name = branches_TD.getTestData("branch1.name") + Helper.getTimestamp();
		address = branches_TD.getTestData("branch1.address");
		defaultPriceList = branches_TD.getTestData("branch1.defaultPriceList");
		diagnosticFee = (float) Integer.parseInt(branches_TD.getTestData("branch1.diagnosticFee"));
		viewClosedTimes = Boolean.valueOf(branches_TD.getTestData("branch1.viewClosedTimes"));
		phones = branches_TD.getTestDataAsList("branch1.phones");
		users = branches_TD.getTestDataAsList("branch1.users");
		availablePriceLists = branches_TD.getTestDataAsList("branch1.availablePriceLists");
		rooms = branches_TD.getTestDataAsList("branch1.rooms");
		opens = branches_TD.getTestDataAsList("branch1.opens");
		closes = branches_TD.getTestDataAsList("branch1.closes");
		openDays = branches_TD.getTestDataAsList("branch1.openDays");

		// Test Data for update branch
		name1 = branches_TD.getTestData("branch2.name") + " update" +  Helper.getTimestamp();
		address1 = branches_TD.getTestData("branch2.address");
		defaultPriceList1 = branches_TD.getTestData("branch2.defaultPriceList");
		diagnosticFee1 = Float.valueOf(branches_TD.getTestData("branch2.diagnosticFee"));
		viewClosedTimes1 = Boolean.valueOf(branches_TD.getTestData("branch2.viewClosedTimes"));
		phones1 = branches_TD.getTestDataAsList("branch2.phones");
		users1 = branches_TD.getTestDataAsList("branch2.users");
		availablePriceLists1 = branches_TD.getTestDataAsList("branch2.availablePriceLists");
		rooms1 = branches_TD.getTestDataAsList("branch2.rooms");
		opens1 = branches_TD.getTestDataAsList("branch2.opens");
		closes1 = branches_TD.getTestDataAsList("branch2.closes");
		openDays1 = branches_TD.getTestDataAsList("branch2.openDays");
		disableBranch = Boolean.valueOf(branches_TD.getTestData("disableBranch.disabled"));
	}

}
