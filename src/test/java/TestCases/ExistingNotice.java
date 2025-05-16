package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CLPUtility;
import POM.ExistingNoticeUtility;
import POM.LoginUtility;
import POM.NoticesUtility;


public class ExistingNotice extends BrowsersInvoked {

	
	ExtentReportClass extentClass;
	ITestResult result;
	ExistingNoticeUtility existingNotice;
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
	
		existingNotice=new ExistingNoticeUtility(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
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
	
	

	
	@Test(priority = 1,description= "Verify that Confirmation popup appears instead of warning popup, on clicking the 'Perform Inspection' button, when no contact exist on the case" )
	public void existingNotice_OpenConfirmationPopup()throws InterruptedException {
		existingNotice.existingNotice_PreRequisite();
		existingNotice.existingNotice_OpenConfirmationPopup();

	}
	
	@Test(priority = 2,description= "Verify that confirmation popup gets closed after clicking the 'No' button." )
	public void existingNotice_CloseConfirmationPopup() throws InterruptedException {
		existingNotice.existingNotice_CloseConfirmationPopup();

	}
	
	@Test(priority = 3,description= "Verify that user is able to perform the inspection after clicking the 'Yes' button on the confirmation popup." )
	public void existingNotice_OpenVerificationInspProgressPopup() throws InterruptedException {
		existingNotice.existingNotice_OpenVerificationInspProgressPopup();

	}
	
	@Test(priority = 4,description= "Verify that 'Existing Notice' option appears at step 2 of 'Perform Inspection' page.")
	public void existingNotice_ExistingNoticeToggle() throws InterruptedException {
		existingNotice.existingNotice_GenerateNoticeOutofInpec();
		existingNotice.existingNotice_ExistingNoticeToggle();
	}
	
	@Test(priority = 5,description= "Verify that un-applied notices appear under 'Which notice do you want to apply this inspection to?' section, after user selects 'Existing Notice' option at step 2 of 'Perform Inspection' page.")
	public void existingNotice_AppearsUnappliedNotice()throws InterruptedException {
		existingNotice.existingNotice_AppearsUnappliedNotice();
	}
	
	@Test(priority = 6,description= "Verify that 'View Notice' popup opens up after clicking the 'Manage Notice' link, after user selects 'Existing Notice' option at step 2 of 'Perform Inspection' page.")
	public void existingNotice_OpensViewNoticePopup() throws InterruptedException {
		existingNotice.existingNotice_OpnesViewNoticePopup();
	
	}
	
	@Test(priority = 7,description= "Verify that user is able to complete inspection and apply notice, after clicking the 'Apply <Notice Name> & Complete Inspection' button.")
	public void existingNotice_CompleteInpandApplyNotice()throws InterruptedException {
		existingNotice.existingNotice_CompleteInpandApplyNotice();
	
	}
	
	@Test(priority = 8,description= "Verify that user is able to delete and reissue the un-applied notice, after clicking the 'Delete and Reissue' link on the 'View Notice' popup")
	public void existingNotice_DeleteandReissueNotice()throws InterruptedException {
		existingNotice.existingNotice_DeleteandReissueNotice();
	}
	
	@Test(priority = 9,description= "Verify that user is able to delete the un-applied notice, after clicking the 'Delete' link on the 'View Notice' popup.")
	public void existingNotice_DeleteNotice()throws InterruptedException {
		existingNotice.existingNotice_DeleteNotice();
	
	}
	


}
