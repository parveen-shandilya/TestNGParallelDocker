package TestCases;

import static POM.CSDPUtility.SubmitAnywayButton;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CSDPUtility;
import POM.CSLPUtility;
import POM.CSPExternalUtility;
import POM.CSPInternalUtility;
import POM.LoginUtility;

public class CSLP extends BrowsersInvoked {

	
	ITestResult result;
	CCPUtility ccp;
	CSLPUtility cslp;
	CRMCommonMethods crmMethods;
	CSPInternalUtility csp;
	CSDPUtility csdp;
	CSPExternalUtility ext;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		cslp = new CSLPUtility(getDriver());
		crmMethods = new CRMCommonMethods(getDriver());
		csp = new CSPInternalUtility(getDriver());
		csdp = new CSDPUtility(getDriver());
		ext = new CSPExternalUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
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

	@Test(priority = 1, description = "Verify that 'Customer Submission Listing' page opens up, when user clicks on 'Customer Submission' header, on Dashboard.")
	public void CSLP_VerifyCSLPOpensUP() throws InterruptedException {
		cslp.CSLP_VerifyCSLPOpensUP();

	}

	@Test(priority = 2, description = "Verify that respective Tag Filter gets applied, when user clicks on any Tag under 'Tags' column, on CSLP.")
	public void CSLP_VerifyPrimaryFilters() throws InterruptedException {
		cslp.CSLP_VerifyPrimaryFilters();

	}

//
//	// comment due to bug...
//
//	/*
//	 * @Test(priority = 3,description =
//	 * " Verify that respective Tag Filter gets applied, when user clicks on any Tag under 'Tags' column, on CSLP."
//	 * ) public void CSLP_VerifyTagFilter() throws InterruptedException {
//	 * cslp.CSLP_VerifyTagFilter(); }
//	 */
//
	@Test(priority = 4, description = "Verify that user is able to navigate to the next page, after clicking on the 'Next' arrow icon, on CSLP.")
	public void CSLP_VerifyNavigationFromPagination() throws InterruptedException {
		cslp.CSLP_VerifyNavigationFromPagination();

	}

	@Test(priority = 5, description = "Verify that by default submissions are arranged in descending order, on CSLP. ")
	public void CSLP_VerifyDescendingOrderOfSubmissions() throws InterruptedException {
		cslp.CSLP_VerifyDescendingOrderOfSubmissions();

	}

	@Test(priority = 6, description = "Verify that user is able to sort the submissions, after clicking on the 'Case Number' header, on CSLP.")
	public void CSLP_VerifyAscendingOrderOfCases() throws InterruptedException {
		cslp.CSLP_VerifyAscendingOrderOfCases();

	}

	@Test(priority = 7, description = "erify that user is able to delete a Submission, after entering 'DELETE' text in mandatory field, on 'Delete Case' popup. ")
	public void CSLP_VerifyDeletedSubmission() throws InterruptedException {
		cslp.CSLP_VerifyDeletedSubmission();

	}

	@Test(priority = 8, description = "Verify that accurate total count of submissions appear above submissions, on CSLP.")
	public void CSLP_VerifyTotalCountOfSubmissions() throws InterruptedException {
		cslp.CSLP_VerifyTotalCountOfSubmissions();

	}

	@Test(priority = 9, description = "Verify that 'Clear all filters' link text appears, when user applies any filter on the submissions, on CSLP.")
	public void CSLP_VerifyClearAllFiltersLinkText() throws InterruptedException {
		cslp.CSLP_VerifyClearAllFiltersLinkText();

	}

	@Test(priority = 10, description = "Verify that 'Clear all filters' link text no longer appears, when user clicks on 'Clear all filters' link text, on CSLP.")
	public void CSLP_VerifyClearAllFiltersAfterClicking() throws InterruptedException {
		cslp.CSLP_VerifyClearAllFiltersAfterClicking();

	}

	@Test(priority = 11, description = "Verify that user is able to select & apply the secondary filters, after clicking on 'Filters' slider icon, on CSLP. ")
	public void CSLP_VerifyApplicationOfsecondaryFilters() throws InterruptedException {
		cslp.CSLP_VerifyApplicationOfsecondaryFilters();
	}

	@Test(priority = 12, description = "Verify that secondary filter gets removed, when user clicks on 'Cross' icon of filter, on CSLP.")
	public void CSLP_VerifyFilterGetsRemoved() throws InterruptedException {
		cslp.CSLP_VerifyFilterGetsRemoved();

	}

	@Test(priority = 13, description = "Verify that user is able to filter & search the Submissions by 'Filter submissions by keyword' search field, on CSLP.")
	public void CSLP_VerifyFilterAndSearch() throws InterruptedException {
		cslp.CSLP_VerifyFilterAndSearch();

	}

	@Test(priority = 14, description = "Verify that user is able to remove respective columns, after deselecting the checkboxes from 'Column Control' widget, on CSLP.")
	public void CSLP_VerifyRemovalOfColumns() throws InterruptedException {
		cslp.CSLP_VerifyRemovalOfColumns();

	}

	@Test(priority = 15, description = "Verify that removed columns reappear on CSLP, when user clicks on 'Restore Defaults' link text, on Column Control sidebar. ")
	public void CSLP_VerifyRestorationOfColumns() throws InterruptedException {
		cslp.CSLP_VerifyRestorationOfColumns();

	}

	@Test(priority = 16, description = "Verify that user is able to Save a Filter, after user clicks on 'Save As' button on the top of CSLP.")
	public void CSLP_VerifySavedFilter() throws InterruptedException {
		cslp.CSLP_VerifySavedFilter();

	}

	@Test(priority = 17, description = "Verify that user is able to delete the added filter under 'SAVED FILTERS' dropdown field, on CSLP.")
	public void CSLP_VerifyDeletedFilter() throws InterruptedException {
		cslp.CSLP_VerifyDeletedFilter();

	}

	@Test(priority = 18, description = "Verify that user is able to download the CSV file, after clicking on 'Download' button > 'CSV' option, on CSLP.")
	public void CSLP_VerifyCSVFile() throws InterruptedException {
		cslp.CSLP_VerifyCSVFile();

	}

	@Test(priority = 19, description = " Verify that user gets directed to the respective Submission, after clicking on any Submission link, on CSLP.")
	public void CSLP_VerifyDirectionToRespectiveSubmission() throws InterruptedException {
		cslp.CSLP_VerifyDirectionToRespectiveSubmission();

	}

	@Test(priority = 20, description = "Verify that only logged in Agency user's submissions appear, when user clicks on 'Mine' button, on CSLP.")
	public void CSLP_VerifySubmissionsForMineButton() throws InterruptedException {
		cslp.CSLP_VerifySubmissionsForMineButton();

	}

	@Test(priority = 21, description = "Verify that only logged in Agency user's submissions appear, when user clicks on 'Mine' button, on CSLP.")
	public void CSLP_VerifyDescendingSubmission() throws InterruptedException {
		cslp.CSLP_VerifyDescendingSubmission();

	}

	@Test(priority = 22, description = "Verify No Existing Submission Search on Case Submission List")
	public void CSLP_VerifyNoExistingSubmissionSearch() throws InterruptedException {
		cslp.CSLP_VerifyNoExistingSubmissionSearch();

	}

	@Test(priority = 23, description = "Verify search wtih category which has no submission.")
	public void CSLP_VerifyNoExistingCategorySubmission() throws InterruptedException {
		cslp.CSLP_VerifyNoExistingCategorySubmission();

	}

	@Test(priority = 24, description = "Verify that map view appears after clicking the 'Map' icon on the CSLP. ")
	public void VerifyMapViewPresent() throws InterruptedException {
		cslp.VerifyMapViewPresent();

	}

}
