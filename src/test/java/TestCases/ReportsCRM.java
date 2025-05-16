package TestCases;

import BrowsersBase.BrowsersInvoked;
import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.DashBoardCRMUtility;
import POM.LoginUtility;
import POM.ReopenCasesUtility;
import POM.ReportCRMUtility;
import POM.SubmissionAssignmentUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReportsCRM extends BrowsersInvoked {

	
	CaseAssignmentUtility obj;
	ExtentReportClass extentClass;
	ITestResult result;
	ReportCRMUtility repCRM;

	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		repCRM = new ReportCRMUtility(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}
	
	
	@Test(priority = -1, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
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
	

	@Test(priority = 0)
	public void Reports_PreRequisite() throws InterruptedException {
		repCRM.Reports_PreRequisite();
	}

	@Test(priority = 1,description = "Verify that user is able to add new Reports under 'QS Reports' section, on 'Edit & Configure CRM' popup.")
	public void Reports_VerifyAdditionOfNewReports() throws InterruptedException {
		repCRM.Reports_VerifyAdditionOfNewReports();

	}

	@Test(priority = 2,description = "Verify that user is able to edit the added Reports under 'QS Reports' section, on 'Edit & Configure CRM' popup.")
	public void Reports_VerifyEditedQSReport() throws InterruptedException {
		repCRM.Reports_VerifyEditedQSReport();

	}

	@Test(priority = 3,description = "Verify that 'CRM' toggle appears on the header of 'Reports' page.")
	public void Reports_VerifyCRMToggleForReports() throws InterruptedException {
		repCRM.Reports_VerifyCRMToggleForReports();

	}

	@Test(priority = 4,description = "Verify that all CRM Reports added on 'Edit & Configure CRM' popup appears, when user clicks on 'CRM' toggle, on 'Reports' page.")
	public void Reports_VerifyAllCRMReports() throws InterruptedException {
		repCRM.Reports_VerifyAllCRMReports();

	}

}
