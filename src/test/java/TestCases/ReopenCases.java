package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.DateAndTime;
import CommonMethods.Helper;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CSDPUtility;
import POM.LoginUtility;
import POM.PerformInspectionUtility;
import POM.ReopenCasesUtility;

public class ReopenCases extends BrowsersInvoked{
	
	
	ExtentReportClass extentClass;
	ITestResult result;
	ReopenCasesUtility reopenCase;
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
	
		reopenCase = new ReopenCasesUtility(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}
	
	@Test(priority = 0, description = "Login Test Case")
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
	
	@Test(priority = 1,description = "Verify that 'Reopen Case' popup opens up, when user clicks on 'More' button > 'Reopen Case' option, on CDP. ")
	public void ReopenCase_OpenReopenCasePopup() throws InterruptedException {
		reopenCase.ReopenCase_PreRequisite();
		reopenCase.ReopenCase_OpenReopenCasePopup();
	}
	
	@Test(priority = 2,description = " Verify that exact violation(s) from CDP appear on 'Reopen Case' popup. ")
	public void ReopenCase_VerifyViolationsFromCDP() throws InterruptedException{
		reopenCase.ReopenCase_VerifyViolationsFromCDP();
	}
	
	@Test(priority = 3,description = "Verify that user is not able to Reopen a case without selecting at least one violation as Non-Compliant.")
	public void ReopenCase_NonCompliantViolationIsRequired() throws InterruptedException{
		reopenCase.ReopenCase_NonCompliantViolationIsRequired();
	}
	
	@Test(priority = 4,description = "Verify that Closed case does not Reopen, when user clicks on 'Cancel' button, on 'Reopen Case' popup.")
	public void ReopenCase_CaseDoesNotReopenOnCancel() throws InterruptedException{
		reopenCase.ReopenCase_CaseDoesNotReopenOnCancel();
	}
	
	@Test(priority = 5,description = "Verify that user is able to Reopen the closed Case, on CDP.")
	public void ReopenCase_VerifyCaseReopened() throws InterruptedException{
		reopenCase.ReopenCase_VerifyCaseReopened();
	}
	
	@Test(priority = 6,description = "Verify that Case Reopened details get added under 'Abatement Activities' tile, on CDP.")
	public void ReopenCase_VerifyCaseReopenedDetails() throws InterruptedException{
		reopenCase.ReopenCase_VerifyCaseReopenedDetails();
	}
}
