package tests.inventory;

import com.dentolize.dashboard.gui.pages.HomePage;
import com.dentolize.inventory.gui.pages.MasterInventoryPage;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.bases.WebBaseTests;
import engine.Helper;

@Epic("Inventory Module")
@Feature("Web")
@Test(groups = {"web"})
public class Web_MasterInventory_Tests extends WebBaseTests {

	@Story("As an admin, I want to \"Add New Inventory Item\"")
	@Test(description = "Verify the User can \"Add New Inventory\" Item with required Data")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("Test Cases")
	@Link("https://my.dentope.com/inventory/master")
	@Description("""
			- Given the browser is open, 
			- When the user navigate to Login to Admin Dentolize
			- And Add Login with valid  data
			- Then navigate to Dashboard page
			""")
	public void VerifyUserCan_Add_newInventoryItem () {
		// Test steps
		new HomePage(driver)
				.navigateToMasterInventoryPage()
				.clickOnNewInventoryItem()
				.enterItemName(newInventoryItemItem)
				.selectStorage()
				.selectType()
				.clickOnCreate();
		// Verifications
		Validations.verifyThat()
				.element(driver.getDriver(), MasterInventoryPage.getSuccessMessage()).text()
				.contains(expectedResult_AddNewItem)
				.withCustomReportMessage("Assert that the user logged in By Get  text")
				.perform();
	}

	//*****************************************************//
	//********************// Set Up //*********************//
	//*****************************************************//
	String newInventoryItemItem, expectedResult_AddNewItem;

	@BeforeClass
	public void loadTestData () {
		JSONFileManager inventory_TD = new JSONFileManager(System.getProperty("inventoryJson"));
		newInventoryItemItem = inventory_TD.getTestData("newInventoryItem") + Helper.getTimestamp();
		expectedResult_AddNewItem = inventory_TD.getTestData("expectedResult_AddNewItem");
	}
}
