package TestCases;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import POM.CCPUtility;
import POM.CDP_Utility;
import POM.FinanceUtility;
import POM.FinesUtility;
import POM.LoginUtility;

public class FlatFineWithNotice extends BrowsersInvoked {

	
	ITestResult result;
	FinesUtility fines;

	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		fines = new FinesUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		if (BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
		} else {
			log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
		}
	}

	
	  @Test(priority = 1, description =
	  "Verify validation message is displayed for label field on create fine page")
	  public void
	  flatFineWithNotice_verifyValidationMessageOnCreateFineForLabelField() throws
	  InterruptedException { fines.navigateToCreateFinePageFromDashboard();
	  fines.setValueInDefaultAmountField();
	  fines.selectDoNotAssociateNoticeCheckboxForCreateFine();
	  fines.clickCreateFineButtonOnCreateFinePage();
	  fines.verifyValidationMessageDisplayedForLabelField();
	  fines.exitFromCreateFinePage();
	  
	  }
	  
	  @Test(priority = 2, description =
	  "Verify user is able to create flat fine with no notice attached") public
	  void flatFineWithNotice_verifyUserAbleToCreateFlatFineWithoutNotice() throws
	  InterruptedException { fines.goToCreateFinePage();
	  fines.createFlatFineWithoutNoticeAndFADoc();
	  
	  }
	  
	  @Test(priority = 3, description =
	  "Verify user is able to edit flat fine created without notice") public void
	  flatFineWithNotice_verifyUserAbleToEditFlatFineWithoutNotice() throws
	  InterruptedException { fines.editFineWithoutNotice();
	  
	  }
	  
	  @Test(priority = 4, description =
	  "Verify validation message is displayed on creating duplicate flat fine without notice"
	  ) public void
	  flatFineWithNotice_verifyValidationMessageDisplayedForDuplicateFine() throws
	  InterruptedException { fines.verifyValidationMessageForDuplicateFine();
	  
	  }
	  
	  @Test(priority = 5, description =
	  "Verify validation message is displayed for Amount field on create fine page"
	  ) public void
	  flatFineWithNotice_verifyValidationMessageOnCreateFineForAmountField() throws
	  InterruptedException { fines.goToCreateFinePage();
	  fines.setValueInLabelField();
	  fines.selectDoNotAssociateNoticeCheckboxForCreateFine();
	  fines.clickCreateFineButtonOnCreateFinePage();
	  fines.verifyValidationMessageDisplayedForAmountField();
	  fines.exitFromCreateFinePage();
	  
	  }
	  
	 
	@Test(priority = 6, description = "Verify flat fine linked to notice is displayed when user performs inspection")
	public void flatFineWithNotice_verifyFlatFineWithNoticeIsDisplayedOnPI() throws InterruptedException {
		fines.createCaseAndPerformInspection();
		fines.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
		fines.verifyFlatFineIsDisplayed();

	}

	@Test(priority = 7, description = "Verify amount and name of flat fine linked to notice is correctly displayed when user performs inspection")
	public void flatFineWithNotice_verifyFlatFineWithNoticeAmountIsDisplayedOnPI() throws InterruptedException {
		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 8, description = "Verify user is able to edit flat fine with notice amount when user performs inspection")
	public void flatFineWithNotice_verifyUserIsAbleToEditFlatFineWithNoticeOnPI() throws InterruptedException {
		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 9, description = "Verify do not issue the fine checkbox is displayed for flat fine with notice when user performs inspection")
	public void flatFineWithNotice_verifyDoNotIssueTheFineCheckboxIsDisplayed() throws InterruptedException {
		fines.verifyDoNotIssueFineCheckboxDisplayed();

	}

	@Test(priority = 10, description = "Verify amount of flat fine linked with notice is added under outstanding balance after PI is done ")
	public void flatFineWithNotice_verifyFlatFineAmountWithNoticeIsAddedUnderOutstandingBalance()
			throws InterruptedException {
		fines.completePIFromVerificationInspectionInProgressPageAndGoToCDP();
		fines.verifyFineAmountIsAddedUnderOutstandingBalance();

	}

	@Test(priority = 11, description = "Verify flat fine with notice applied on case is displayed on Fines and Payments details page after clicking on outstanding balance on CDP")
	public void flatFineWithNotice_verifyFlatFineWithNoticeDisplayedOnFinesAndPaymentsPage()
			throws InterruptedException {
		fines.verifyFineNameDisplayedOnFineAndPaymentPage("Flat Fine With Notice");
		fines.navigatToCDPFromFinesAndPaymentsPage();

	}

	// Generate notice out of inspection//

	@Test(priority = 12, description = "Verify flat fine with notice is displayed when user performs generate notice out of inspection")
	public void flatFineWithNotice_verifyFlatFineWithNoticeDisplayedForGenerateNotice() throws InterruptedException {
		fines.performGenerateNoticeOnCDP();
		fines.selectNoticeOnGenerateNoticeOutOfInspection("HTML Flat Fine Notice");
		fines.verifyFlatFineIsDisplayed();

	}

	@Test(priority = 13, description = "Verify amount of flat fine with notice is correctly displayed when user performs generate notice out of inspection")
	public void flatFineWithNotice_verifyFlatFineWithNoticeAmountIsDisplayedForGenerateNotice()
			throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 14, description = "Verify user is able to edit flat fine amount when user performs generate notice out of inspection")
	public void flatFineWithNotice_verifyUserIsAbleToEditFlatFineAmount() throws InterruptedException {

		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 15, description = "Verify outstanding balance is updated after flat with notice added on generate notice out of inspection is applied")
	public void flatFineWithNotice_verifyOutstandingBalanceIsUpdatedAfterNoticeGeneratedIsApplied()
			throws InterruptedException {

		fines.completeGenerateNoticeFlowFromGenerateNoticeInProgressPage();
		fines.applyNoticeGeneatedThroughGenerateNotice();
		fines.verifyOutstandingBalanceIsUpdated();

	}

	// FA document test cases//

	@Test(priority = 16, description = "Verify flat fine linked to FA document is displayed when user performs forced abatement")
	public void flatFineWithNotice_verifyFlatFineLinkedToFADocumentIsDisplayedOnFAA() throws InterruptedException {

		fines.performForcedAbatementFromCDP();
		fines.selectFAADocumentOnAbatementDetailsSection("FA document with Flat Fine");
		fines.verifyFlatFineWithFADocIsDisplayed();

	}

	@Test(priority = 17, description = "Verify correct amount of flat fine linked to FA document is displayed when user performs forced abatement")
	public void flatFineWithNotice_verifyCorrectAmountOfFlatFineLinkedToFADocumentIsDisplayedOnFAA()
			throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	// issue user not able to update FA fines
	@Test(priority = 18, enabled = false, description = "Verify user is able to edit flat fine linked to FA document on FAA section")
	public void flatFineWithNotice_verifyUserIsAbleToEditFlatFineLinkedToFADocumentIsDisplayedOnFAA()
			throws InterruptedException {

		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 19, description = "Verify do not issue the fine checkbox is displayed for flat fine linked to FA document on FAA section")
	public void flatFineWithNotice_verifyDoNotIssueFineCheckboxIsDisplayed() throws InterruptedException {

		fines.verifyDoNotIssueFineCheckboxDisplayed();

	}

	@Test(priority = 20, description = "Verify fine amount linked to FA document is added on CDP under outstanding balance once FA is done")
	public void flatFineWithNotice_verifyFADocumentFineIsAddedUnderOutstandingBalance() throws InterruptedException {

		fines.completeFAAndNavigateToCDP();
		fines.verifyFineAmountIsUpdatedUnderOutstandingBalance();

	}

	@Test(priority = 21, enabled = false, description = "Verify flat fine name with FA doc attached is displayed correctly on Fines And Payments Page")
	public void flatFineWithNotice_verifyFADocumentFineNameIsDisplayedOnFinesAndPaymentsPage()
			throws InterruptedException {

		fines.verifyFineNameDisplayedOnFineAndPaymentPage("Flat Fine With FA Document");
		fines.navigatToCDPFromFinesAndPaymentsPage();

	}

	@Test(priority = 22, enabled = false, description = "Verify flat fine with FA doc applied is displayed on Finance page under All Fines/View")
	public void flatFineWithNotice_verifyFADocumentFineIsDisplayedOnFinancePage() throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	// Flat fine without notice and FA document//
	@Test(priority = 23, description = "Verify flat fine without notice is displayed on Fines And Payments page")
	public void flatFineWithNotice_verifyFLatFineWithoutNoticeIsDisplayedOnFineAndPaymentsPage()
			throws InterruptedException {

		fines.verifyFLatFineWithoutNoticeIsDisplayedOnFineAndPaymentsPage();

	}

	@Test(priority = 24, description = "Verify flat fine without notice is applied on Fines And Payments page")
	public void flatFineWithNotice_verifyFLatFineWithoutNoticeIsAppliedOnFineAndPaymentsPage()
			throws InterruptedException {

		fines.verifyFLatFineWithoutNoticeIsAppliedOnFineAndPaymentsPage("Flat Fine With No Notice And No FA");

	}

	@Test(priority = 25, description = "Verify outstanding balance is updated after flat fine with no notice attached is applied on fines and payments page")
	public void flatFineWithNotice_verifyOutstandingBalanceUpdatedWhenFlatFineWithoutNoticeIsApplied()
			throws InterruptedException {
		fines.navigatToCDPFromFinesAndPaymentsPage();
		fines.verifyOutstandingIsUpdated();

	}

	@Test(priority = 26, description = "Verify that added flat fine without notice is displayed under finance page")
	public void flatFineWithNotice_verifyAddedFineDisplayedUnderFinancePage() throws InterruptedException {
		fines.navigateToFinancePageFromCDPPage();
		fines.verifyFineDisplayedOnFinancePage("Flat Fine With No Notice And No FA");

	}

}
