package TestCases;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import POM.FinesUtility;
import POM.LoginUtility;

public class VSFineLinkedToNotices extends BrowsersInvoked {

	
	ITestResult result;
	FinesUtility fines;


	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		fines = new FinesUtility(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		if(BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
			}
			else {
				log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
			}
	}
	
	


	@Test(priority = 1, description = "Verify validation message is displayed for associate notice and FA document field when kept blank for violation specific fines")
	public void verifyValidationMessageForAssociateNoticeAndFADocumentField() throws InterruptedException {
		fines.navigateToCreateFinePageFromDashboard();
		fines.setValueInDefaultAmountField();
		fines.setValueInLabelField();
		fines.selectViolationSpecificOption();
		fines.selectValueInAssociatedViolationDropdown();

		fines.clickCreateFineButtonOnCreateFinePage();
		fines.verifyValidationMessageDisplayedForAssociateNoticeField();
		fines.exitFromCreateFinePage();

	}

	@Test(priority = 2, description = "Verify violation specific fines linked to violations only is displayed on perform inspection")
	public void verifyViolationSpecificFineIsDisplayedOnPerformInspection() throws InterruptedException {
		fines.createCaseAndPerformInspection();
		fines.selectNoticeOnPerformInspection("Notice For Violation Specific Fine Linked To Notice");
		fines.verifyVSFineLinkedToNoticeIsDisplayed();

	}

	@Test(priority = 3, description = "Verify amount and name of VS fine linked to violation only is correctly displayed when user performs inspection")
	public void verifyVSFineLinkedToViolation_AmountIsDisplayedOnPI() throws InterruptedException {
		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 4, description = "Verify user is able to edit violation specific fine linked to violations only amount when user performs inspection")
	public void verifyUserIsAbleToEditVSFineLinkedToViolationsOnPI() throws InterruptedException {
		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 5, description = "Verify do not issue the fine checkbox is displayed for violation specific fine linked to violations only when user performs inspection")
	public void verifyDoNotIssueTheFineCheckboxIsDisplayed() throws InterruptedException {
		fines.verifyDoNotIssueFineCheckboxDisplayed();

	}

	@Test(priority = 6, description = "Verify amount of violation specific fine linked with violations only is added under outstanding balance after PI is done ")
	public void verifyViolationSpecificFineAmountIsAddedUnderOutstandingBalance() throws InterruptedException {
		fines.completePIFromVerificationInspectionInProgressPageAndGoToCDP();
		fines.verifyFineAmountIsAddedUnderOutstandingBalance();

	}

	@Test(priority = 7, description = "Verify violation specific fine with linked to violation only applied on case is displayed on Fines and Payments details page after clicking on outstanding balance on CDP")
	public void verifyViolationSpecificFineIsDisplayedOnFinesAndPaymentsPage() throws InterruptedException {
		fines.verifyFineNameDisplayedOnFineAndPaymentPage("Violation Specific Fine Linked To Notice Only");
		fines.navigatToCDPFromFinesAndPaymentsPage();

	}

	// Generate Notice Out of inspection//

	@Test(priority = 8, description = "Verify flat fine with notice is displayed when user performs generate notice out of inspection")
	public void verifyFlatFineWithNoticeDisplayedForGenerateNotice() throws InterruptedException {
		fines.performGenerateNoticeOnCDP();
		fines.selectNoticeOnGenerateNoticeOutOfInspection("Notice For Violation Specific Fine Linked To Notice");
		fines.verifyVSFineLinkedToNoticeIsDisplayed();

	}

	@Test(priority = 9, description = "Verify amount of flat fine with notice is correctly displayed when user performs generate notice out of inspection")
	public void verifyFlatFineWithNoticeAmountIsDisplayedForGenerateNotice() throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 10, description = "Verify user is able to edit flat fine amount when user performs generate notice out of inspection")
	public void verifyUserIsAbleToEditFlatFineAmount() throws InterruptedException {

		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 11, description = "Verify outstanding balance is updated after flat with notice added on generate notice out of inspection is applied")
	public void verifyOutstandingBalanceIsUpdatedAfterNoticeGeneratedIsApplied() throws InterruptedException {

		fines.completeGenerateNoticeFlowFromGenerateNoticeInProgressPage();
		fines.applyNoticeGeneatedThroughGenerateNotice();
		fines.verifyOutstandingBalanceIsUpdated();

	}

}
