package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CSDPUtility;
import POM.CSLPUtility;
import POM.Department;
import POM.SubmissionAssignmentUtility;
import POM.SupervisorUtility;

public class EscalatedNotices extends BrowsersInvoked {

	
	ExtentReportClass extentClass;
	ITestResult result;
	SupervisorUtility su;

	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		su = new SupervisorUtility(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}
	
	
	
	

	@Test(priority = 0, description = "Log in with Non-Supervisor user")
	public void LoginNonSupervisor() throws InterruptedException {
		su.LoginNonSupervisor();

	}

	@Test(priority = 1)
	public void verifyEscalatedNoticeNeedsSupervisorApprovalIsDisplayed() throws InterruptedException {
		su.verifyEscalatedNoticeNeedsSupervisorApprovalMsgDisplayed();

	}

	@Test(priority = 2)
	public void verifyPendingSupervisorApprovalIsDisplayed() throws InterruptedException {
		su.verifyPendingSupervisorApprovalIsDisplayed();

	}

	@Test(priority = 3)
	public void verifyIssueNoticeAndCompleteInspectionNotDisplayed() throws InterruptedException {
		su.verifyIssueNoticeAndCompleteInspectionNotDisplayed();

	}

	@Test(priority = 4)
	public void verifyCompleteInspectionAndGenerateNoticeIsDisplayed() throws InterruptedException {
		su.verifyCompleteInspectionAndGenerateNoticeIsDisplayed();

	}

	@Test(priority = 5)
	public void verifyPendingSupervisorApprovalDislayedUnderAbatementActivity() {
		su.verifyPendingSupervisorApprovalDislayedUnderAbatementActivity();
	}

	@Test(priority = 6)
	public void supervisorLoginAndApproveEscalatedNotice() throws InterruptedException {
		su.supervisorLoginAndApproveEscalatedNotice();
		su.loginNoSupervisorUserAfterLogOff();
	}

	@Test(priority = 7, description = "Verify that Approved status appears next to Notice Generated Pending Supervisor Approval' text under 'Abatement Activities' section, once supervisor approval done")
	public void verifyApprovedStatusDisplayed() throws InterruptedException {
		su.verifyApprovedStatusDisplayed();
	}

	@Test(priority = 8, description = "Verify apply notice and manage notice is displayed on cpd once supervisor approves escalated notice")
	public void verifyApplyNoticeAndManageNoticeIsDisplayed() throws InterruptedException {
		su.verifyApplyNoticeAndManageNoticeIsDisplayed();
	}

	@Test(priority = 9, description = "Verify apply notice pop up opens")
	public void verifyApplyNoticePopUpOpens() throws InterruptedException {
		su.verifyApplyNoticePopUpOpens();
	}

	@Test(priority = 10, description = "Verify view notice link is displayed once supervisor approves escalated notice and issues it")
	public void verifyViewNoticeLinkIsDisplayed() throws InterruptedException {
		su.verifyViewNoticeLinkIsDisplayed();
	}

	@Test(priority = 11, description = "Verify approved button appears for notice when supervisor manager performs inspection for escalated notice")
	public void verifyApprovedBtnAppearsForNotice() throws InterruptedException {
		su.verifyApprovedBtnAppearsForNotice();
	}

	@Test(priority = 12, description = "Verify Issue Notice And Complete Inspection is displayed for supervisor manger while issuing escalated notice")
	public void verifyIssueNoticeAndCompleteInspectionIsDisplayed() throws InterruptedException {
		su.verifyIssueNoticeAndCompleteInspectionIsDisplayed();
	}

	@Test(priority = 13, description = "Verify after selecting Yes for - Are you sure you want to issue the notice and complete inspection, user is navigated to CDP")
	public void verifyUserIsNavigatedToCDP() throws InterruptedException {
		su.verifyUserIsNavigatedToCDP();
	}

	@Test(priority = 14, description = "Approved and applied to case is displayed on CDP after supervisor issues escalated notice")
	public void verifyApprovedAndAppliedToCaseIsDisplayed() throws InterruptedException {
		su.verifyApprovedAndAppliedToCaseIsDisplayed();
	}

	@Test(priority = 15, description = "Login NonSupervisor")
	public void loginNonSupervisor() throws InterruptedException {
		su.logOutFromCLPPageAndLoginAsNoSupervisor();
		su.createCaseAndAddEscalatedNoticeForSupervisorApproval();
	}

	@Test(priority = 16, description = "Approve notice button should be displayed for Supervisor after escalated notice is issued by non supervisor user")
	public void verifyApproveBtnIsDisplayedForSupervisor() throws InterruptedException {
		su.verifyApproveNoticeIsDisplayedForSupervisor();

	}

	@Test(priority = 17, description = "Approve notice pop up should open after supervisor clicks on Approve notice btn")
	public void verifyApproveNoticePopUpOpens() throws InterruptedException {
		su.verifyApproveNoticePopUpOpens();

	}

	@Test(priority = 18, description = "Verify print, save, approve, reject, add case note, pending supervisor approval is displayed on approvw pop up ")
	public void verifyPrintBtnIsDisplayed() throws InterruptedException {
		su.verifyAddCaseNoteIsDisplayed();

	}

	@Test(priority = 19, description = "Verify validation message is displayed when user rejects the notice without adding case note")
	public void verifyValidationMsgAppearsAfterReject() throws InterruptedException {
		su.verifySaveBtnIsDisabledAfterReject();

	}

	@Test(priority = 20, description = "Verify user is able to reject escalated notice for approval")
	public void verifyUserIsAbleToRejectNotice() throws InterruptedException {
		su.verifyUserIsAbleToRejectNotice();

	}

	@Test(priority = 21, description = "Verify user is able to edit case note on escalated notice")
	public void verifyUserIsAbleToUpdateCaseNote() throws InterruptedException {
		su.verifyUserIsAbleToEditCaseNote();

	}

	@Test(priority = 22, description = "Verify Not approved is displayed in red after supervisor rejects escalated notice")
	public void verifyNotApprovedDisplayed() throws InterruptedException {
		su.verifyNotApprovedDisplayed();

	}

	@Test(priority = 23, description = "Verify user is navigated to CDP after selecting approve button on approve notice pop")
	public void verifyUserIsAbleToApproveNotice() throws InterruptedException {
		su.verifyUserIsAbleToApproveNotice();

	}

	@Test(priority = 24, description = "Verify user is able to update case note for approved status")
	public void verifyUserIsAbleToUpdateCaseNoteForApproval() throws InterruptedException {
		su.verifyUserIsAbleToUpdateCaseNoteForApproval();

	}

	@Test(priority = 25, description = "Verify case history is updated")
	public void verifyCaseHistoryUpdated() throws InterruptedException {
		su.verifyCaseHistoryUpdated();

	}
	

	@Test(priority = 27, description = "Logging in as no supervisor user, creating case with esclating notice, rejecting it with supervisor manager user and then logging back with no supervisor user")
	public void preRequisiteForCDS301() throws InterruptedException
	{
		su.logoutManagerAndLoginNoSupervisor();
	}
	@Test(priority = 28, description = "Verfiy Escalated notice text is displayed for no supervisor user once supervisor user rejects escalated notice")
	public void verifyEscalatedNoticeTextDisplayedOnCDPForNonSupervisor() throws InterruptedException
	{
		su.verifyEscalatedNoticeTextDisplayedForNoSupervisor();
	}
	
	@Test(priority = 29, description = "Not approved displpayed for no supervisor user once supervisor user rejects escalated notice")
	public void verifyNotApprovedIsDisplayed() throws InterruptedException
	{
		su.verifyNotApprovedIsDisplayedForNonSupervisor();
	}
	@Test(priority = 30, description = "Manage notice link is displayed after supervisor rejects escalated notice")
	public void verifyManageNoticeIsDisplayed() throws InterruptedException
	{
		su.verifyManageNoticeIsDisplayedForNonSupervisor();
	}
	
	
	
	
	@Test(priority = 31, description = "Verify user is able to view notes added by supervisor manager while rejecting escalated notice")
	public void verifyUserIsAbleToViewNotes () throws InterruptedException
	{
		su.verifyViewNotes();
	}
	
	
	@Test(priority = 32, description = "View escalated notice pop up opens up")
	public void verifyViewEscalatedNoticePopUpOpensUp() throws InterruptedException
	{
		su.verifyEscalatedNoticePopUpOpensUp();
	}
	
	@Test(priority = 33, description = "verify User Is Able To Delete And Reissue Notice escalated notice")
	public void verifyUserIsAbleToDeleteAndReissueNotice() throws InterruptedException
	{
		su.verifyDeleteAndReisue();
	}
	

}
