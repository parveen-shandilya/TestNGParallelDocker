package TestCases;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.LoginUtility;
import POM.SubmissionAssignmentUtility;
import POM.SubmissionSettingsUtility;

public class SubmissionSettings extends BrowsersInvoked {
	
	
	ExtentReportClass extentClass;
	ITestResult result;
	CCPUtility ccp;
	SubmissionSettingsUtility submissionSetting;


	  @BeforeClass
		public void setUp() {
			Setup(); // sets getDriver() for this thread
			
			submissionSetting = new SubmissionSettingsUtility(getDriver());
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

	
	@Test(priority = 1,description = "Verify that user is able to select any 'Closing the code case automatically closes the submission?' toggle buttons, on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyToggleButtonsState() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyToggleButtonsState();
		
	}

	@Test(priority = 2,description = "Verify that the changes do not get saved, when user clicks on 'Discard Changes' button, on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyDiscardButtonFunctionality() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyDiscardButtonFunctionality();
		
	}

	@Test(priority = 3,description = "Verify that the changes get saved, when user clicks on 'Save Changes' button, on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyChangesGetSaved() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyChangesGetSaved();
		
	}

	@Test(priority = 4,description = "Verify that Submission gets closed automatically on closing the linked Case, when 'Closing the code case automatically closes the submission?' toggle button is set to 'Yes', on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyAutomaticClosingOfLinkedSubmission() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyAutomaticClosingOfLinkedSubmission();
		
	}

	@Test(priority = 5,description = "Verify that Submission does not get closed automatically on closing the linked Case, when 'Closing the code case automatically closes the submission?' toggle button is set to 'No', on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyCaseDoesntCloseForNoToggle() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyCaseDoesntCloseForNoToggle();
		
	}

	@Test(priority = 6,description = "Verify that user is able to select any 'Can submit an issue anonymously?' toggle button, on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyselectionOfAnonymousToggles() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyselectionOfAnonymousToggles();
		
	}

	@Test(priority = 7,description = "Verify that 'Post anonymously' checkbox appears on CSP, when 'Can submit an issue anonymously?' toggle button is set to 'Yes', on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyPostAnonymouslyForYesToggle() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyPostAnonymouslyForYesToggle();
		
	}

	@Test(priority = 8,description = "Verify that 'Post anonymously' checkbox does not appear on CSP, when 'Can submit an issue anonymously?' toggle button is set to 'No', on 'Submission Settings' page.")
	public void SubmissionSettings_VerifyPostAnonymouslyForNoToggle() throws InterruptedException {
		submissionSetting.SubmissionSettings_VerifyPostAnonymouslyForNoToggle();
		
	}

}
