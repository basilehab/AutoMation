package tests.settings;

import com.dentolize.search.SearchApis;
import com.dentolize.settings.priceList.api.PriceListApi;
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

@Epic("Settings >> PriceList")
@Feature("API")
@Test(groups = {"apis"})
public class Api_CRUD_PriceList_Tests extends ApiBaseTests {

	@Story("As a User, I want to \"Add New Price List\"")
	@Test(description = "Verify the User can Add Price List")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void addNewPriceList () {
		Response addNewPriceListResponse = priceListApis.addNewPriceList(COOKIE, name, branch_id, syncToPriceList_id, keepInSync, whichWay, discount);
		priceList_id = RestActions.getResponseJSONValue(addNewPriceListResponse, "data.addNewPriceList.id");
		Response getPriceListDetails = searchApis.searchPriceList(COOKIE, name);
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].id").isEqualTo(priceList_id).perform();
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].name").isEqualTo(name).perform();
//        Validations.verifyThat().response(addNewPriceListResponse).extractedJsonValue("data.addNewPriceList[0].branches.id").isEqualTo(branch_id).perform();
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].syncTo").isEqualTo(syncToPriceList_id).perform();
		int discountR = Integer.parseInt(RestActions.getResponseJSONValue(getPriceListDetails, "data.searchPriceLists[0].difference"));
		Validations.verifyThat().number(discountR).isEqualTo(discount).perform();
	}

	@Story("As a User, I want to \"Edit Price List\"")
	@Test(dependsOnMethods = "addNewPriceList", description = "Verify the User can Edit Price List")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void editPriceList () {
		priceListApis.editPriceList(COOKIE, priceList_id, name1, branch_id1, syncToPriceList_id1, keepInSync1, whichWay1, discount1);
		Response getPriceListDetails = searchApis.searchPriceList(COOKIE, name1);
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].id").isEqualTo(priceList_id).perform();
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].name").isEqualTo(name1).perform();
//        Validations.verifyThat().response(editPriceListResponse).extractedJsonValue("data.editPriceList[0].branches.id").isEqualTo(_branch_id).perform();
		Validations.verifyThat().response(getPriceListDetails).extractedJsonValue("data.searchPriceLists[0].syncTo").isEqualTo(syncToPriceList_id1).perform();
		int discountR = Integer.parseInt(RestActions.getResponseJSONValue(getPriceListDetails, "data.searchPriceLists[0].percentage"));
		Validations.verifyThat().number(discountR).isEqualTo(discount1).perform();
	}

	@Story("As a User, I want to \"Delete Price List\"")
	@Test(dependsOnMethods = "editPriceList", description = "Verify the User can Delete Price List")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	public void deleteMonthlyExpenses () {
		Response deletePriceList = priceListApis.deletePriceList(COOKIE, priceList_id);
		Validations.verifyThat().response(deletePriceList).extractedJsonValue("data.deletePriceList.id").isEqualTo(priceList_id);
	}

	//*****************************************************//
	//********************// Set Up //*********************//
	//*****************************************************//

	private PriceListApi priceListApis;
	String priceList_id, name, name1, syncToPriceList_id, syncToPriceList_id1, whichWay, whichWay1;
	List branch_id, branch_id1;
	int discount, discount1;
	Boolean keepInSync, keepInSync1;

	@BeforeClass
	public void loadTestData () {
		searchApis = new SearchApis(restActions);
		priceListApis = new PriceListApi(restActions);
		JSONFileManager priceList_TD = new JSONFileManager(System.getProperty("priceListApisJson"));
		// Test Data for addNewPriceList
		name = priceList_TD.getTestData("priceList1.name")+ Helper.getTimestamp();
		branch_id = priceList_TD.getTestDataAsList("priceList1.branches");
		syncToPriceList_id = priceList_TD.getTestData("priceList1.syncTo");
		keepInSync = Boolean.valueOf(priceList_TD.getTestData("priceList1.keepInSync"));
		whichWay = priceList_TD.getTestData("priceList1.whichWay");
		discount = Integer.parseInt(priceList_TD.getTestData("priceList1.difference"));
		// Test Data for editPriceList
		name1 = priceList_TD.getTestData("priceList2.name") + " updated" + Helper.getTimestamp();
		branch_id1 = priceList_TD.getTestDataAsList("priceList2.branches");
		syncToPriceList_id1 = priceList_TD.getTestData("priceList2.syncTo");
		keepInSync1 = Boolean.valueOf(priceList_TD.getTestData("priceList2.keepInSync"));
		whichWay1 = priceList_TD.getTestData("priceList2.whichWay");
		discount1 = Integer.parseInt(priceList_TD.getTestData("priceList2.percentage"));
	}


}

