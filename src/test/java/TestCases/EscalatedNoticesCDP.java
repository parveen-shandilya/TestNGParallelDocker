package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.AppPreRequisiteUtility;
import POM.CDP_Utility;
import POM.CLPUtility;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.SupervisorUtility;

public class EscalatedNoticesCDP extends BrowsersInvoked {
	
	
	CDP_Utility cdp ;
	AppPreRequisiteUtility appPreRequisite;

	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		cdp = new CDP_Utility(getDriver());
		appPreRequisite = new AppPreRequisiteUtility(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}
	

	@Test(priority = 0,description="Log in Agency With Valid Credential")
	public void Login() throws InterruptedException {
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
	
	
	
	
	@Test(priority = 1,description="Verify the 'Approve Notice' button appear to basic supervisor user.")
	public void EscalatedNoticesCDP_VerifyApproveNoticeAppearBasicSupervisor() throws InterruptedException {
		cdp.VerifyApproveNoticeAppearBasicSupervisor();

	}
	
	@Test(priority=2,description="verify the 'Approve Notice' is not appear to basic user when case is created by user outside of the group")
	public void EscalatedNoticesCDP_VerifyApproveNoticeNotAppear() throws InterruptedException{
		cdp.VerifyApproveNoticeNotAppear();
	}
	
	
	@Test(priority=3,description="verify the Supervisor able to approve the case which is created by user outside of the group")
	public void EscalatedNoticesCDPVerifyApproveNoticeOutsideGroup() throws InterruptedException{
		cdp.VerifyApproveNoticeOutsideGroup();
	}
	
	
	@Test(priority=4,description="verify the 'Approved' 'Apply Notice' 'Manage Link' should appear to Non-supervisor user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyApprovedNoticeStatusAppearNonSuperviosr() throws InterruptedException{
		cdp.VerifyApprovedNoticeStatusAppearNonSuperviosr();
	}
	
	
	@Test(priority=5,description="verify the 'Approved and Appiled to case' 'View Notice' 'Manage Link' should appear to supervisor manager user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyEsclatedNoticeStatusAppearToSupervisorManager() throws InterruptedException{
		cdp.VerifyEsclatedNoticeStatusAppearToSupervisorManager();
	}
	
	
	
	@Test(priority=6,description="verify the 'Approved and Appiled to case' 'View Notice' 'Manage Link' should appear to Non-supervisor user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyEsclatedNoticeStatusAppearToNonSupervisorManager() throws InterruptedException{
		cdp.VerifyEsclatedNoticeStatusAppearToNonSupervisorManager();
	}
	
	@Test(priority=7,description="Verify that supervisor manager from outside the group is able to reject the escalated notice created by the any users in the agency, on CDP")
	public void EscalatedNoticesCDP_VerifyRejectNoticeOutsideGroupManager() throws InterruptedException {
		cdp.VerifyRejectNoticeOutsideGroupManager();
	}
	
	
	
	

}
