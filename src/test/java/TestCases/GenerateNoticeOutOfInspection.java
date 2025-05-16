package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.ForcedAbatementUtility;
import POM.GenerateNoticeOutOfInspectionUtility;
import POM.LoginUtility;

public class GenerateNoticeOutOfInspection extends BrowsersInvoked{
	
	ExtentReportClass extentClass;
	ITestResult result;
	GenerateNoticeOutOfInspectionUtility ooi;

	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		ooi= new GenerateNoticeOutOfInspectionUtility(getDriver());
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

	@Test(priority = 1, description="Create case with perform inspection done")
	public void preRequisite() throws InterruptedException
	{
		ooi.preRequisite();
	}
	
	@Test(priority = 2, description="Generate notice pop up should open after clicing generate notice on CDP")
	public void verifyGenerateNoticePopUpOpensUp() throws InterruptedException
	{
		ooi.verifyGenerateNoticePopUpOpensUp();
	}
	
	@Test(priority = 3, description="Verify user is not able to update violations")
	public void verifyViolationsCannotBeUpdated() throws InterruptedException
	{
		//ooi.verifyViolationsCannotBeUpdated();
	}
	
	
	@Test(priority = 5, description="Verify resolution section is displayed on generate notice page after out of order notice generation")
	public void verifyResolutionSectionIsDisplayed() throws InterruptedException
	{
		ooi.verifyResolutionSectionIsDisplayed();
	}
	
	@Test(priority = 6, description="Verify user is able to update resolution section")
	public void verifyUserIsAbleToUpdateResolutionSection() throws InterruptedException
	{
		ooi.verifyUserIsAbleToUpdateResolutionSection();
	}
	
	@Test(priority = 7, description="Verify certified mail number field is displayed")
	public void verifyCertifiedMailNoFieldDisplayed() throws InterruptedException
	{
		ooi.verifyCertifiedMailNoFieldDisplayed();
	}

	@Test(priority = 8, description="Verify user is able to update certified mail number")
	public void verifyUserIsAbleToUpdateCertifiedNumber() throws InterruptedException
	{
		ooi.verifyUserIsAbleToUpdateCertifiedNumber();
	}
	@Test(priority = 9, description="Verify continue button is displayed")
	public void verifyUserIsAbleToClickContinueBtn() throws InterruptedException
	{
		ooi.verifyUserIsAbleToClickContinueBtn();
	}
	
	@Test(priority = 10, description="Verify after clicking continue btn select notice type and fine associated sectionis displayed")
	public void verifySelectNoticeTypeAndAssociatedFinesSectionDisplayed() throws InterruptedException
	{
		ooi.verifySelectNoticeTypeAndAssociatedFinesSectionDisplayed();
	}
	
	@Test(priority = 11, description="Verify only HTML notices are displayed")
	public void verifyOnlyHtmlNoticesDisplayed() throws InterruptedException
	{
		ooi.verifyOnlyHTMLNoticesAreDisplayed();
		//to be written//
	}
	
	@Test(priority = 12, description="Verify user can select any notice out of HTML notices displayed")
	public void verifyUserIsAbleToSelectAnyNotice() throws InterruptedException
	{
		ooi.verifyUserIsAbleToSelectAnyNotice();
		
	}
	@Test(priority = 13, description="Verify user is able to select date for date picker")
	public void verifyUserIsAbleToSelectADate() throws InterruptedException
	{
		ooi.verifyUserIsAbleToSelectADate();
		
	}
	@Test(priority = 14, description="Verify fine associated with notice is displayed")
	public void verifyFineAssociatedWithNoticeIsDisplayed() throws InterruptedException
	{
		ooi.verifyFineAssociatedWithNoticeIsDisplayed();
		
	}
	
	@Test(priority = 15, description="Verify user is able to add new fines")
	public void verifyUserIsAbleToAddNewFine() throws InterruptedException
	{
		ooi.verifyUserIsAbleToAddNewFine();
		
	}
	
	@Test(priority = 16, description="Verify user is directed to Review Open Violations And Comply By section after clicking continue")
	public void verifyUserIsDirectedToReviewOpenViolationsAndComplyByDates() throws InterruptedException
	{
		ooi.verifyUserIsDirectedToReviewOpenViolationsAndComplyByDates();
		
	}
	@Test(priority = 17, description="Verify autocalculated, autofilled date is present in comply by date section")
	public void verifyAutoCalculatedDateAppearsByDefault() throws InterruptedException
	{
		ooi.verifyAutoCalculatedDateAppearsByDefaultInComplyBySection();
		
	}
	
	@Test(priority = 18, description="Verify user is able to update comply by date")
	public void verifyUserIsAbleToUpdateComplyByDate() throws InterruptedException
	{
		ooi.verifyUserIsAbleToUpdateComplyByDate();
		
	}
	@Test(priority = 19, description="Verify user is navigated to follow up inspection date after clicking continue")
	public void verifyUserIsDirectedToFollowUpInspectionDatePage() throws InterruptedException
	{
		ooi.verifyUserIsDirectedToFollowUpInspectionDatePage();
		
	}
	@Test(priority = 20, description="Verify user is able to update follow up inspection date")
	public void verifyUserIsAbleToUpdateFollowUpInspectionDate() throws InterruptedException
	{
		ooi.verifyUserIsAbleToUpdateFollowUpInspectionDate();
		
	}
	@Test(priority = 21, description="Verify user is able to update follow up inspection assignee")
	public void verifyUserIsAbleToUpdateFollowUpInspectionAssignee() throws InterruptedException
	{
		ooi.verifyUserIsAbleToUpdateFollowUpInspectionAssignee();
		
	}
	
	@Test(priority = 22, description="Verify user is directed to generate notice pop up after clicking on generate notice button")
	public void verifyUserIsDirectedToGenerateNoticePopUpAfterClickingGenerateNoticeBtn() throws InterruptedException
	{
		ooi.verifyUserIsNavigatedToGenerateNoticePop();
		
	}
	
	@Test(priority = 23, description="Verify correct preview of HTML notice is displayed")
	public void verifyCorrectPreviewOfHtmlNoticeIsDisplayed() throws InterruptedException
	{
		ooi.verifyCorrectPreviewOfHtmlNoticeIsDisplayed();
		
	}
	
	@Test(priority = 24, description="Verify print toggle button is selected by default")
	public void verifyPrintToggleBtnIsSelected() throws InterruptedException
	{
		ooi.verifyPrintToggleBtnIsSelected();
		
	}
	
	@Test(priority = 25, description="Verify notice generated independent of follow up inspection is displayed")
	public void verifyNoticeCreatedIndeoendentOfFollowUpInspectionSectionIsDisplayed() throws InterruptedException
	{
		ooi.verifyNoticeCreatedIndeoendentOfFollowUpInspectionSectionIsDisplayed();
		
	}
	
	@Test(priority = 26, description="Verify apply notice button is displayed")
	public void verifyApplyNoticeBtnIsDisplayed() throws InterruptedException
	{
		ooi.verifyApplyNoticeBtnIsDisplayed();
		
	}
	
	@Test(priority = 27, description="Verify manage notice link is displayed")
	public void verifyManageNoticeLinkIsDisplayed() throws InterruptedException
	{
		ooi.verifyManageNoticeLinkIsDisplayed();
		
	}
	
	@Test(priority = 28, description="Verify edit notice pop up is displayed after clicking on manage notice")
	public void verifyEditNoticeIsDisplayed() throws InterruptedException
	{
		ooi.verifyEditNoticeIsDisplayed();
		
	}
	
	@Test(priority = 29, description="Verify additional text is displayed while closing case having notice generated out of inspection not applied")
	public void verifyAdditionalTextDisplayedOnCloseCasePopUp() throws InterruptedException
	{
		ooi.verifyAdditionalTextDisplayedOnCloseCasePopUp();
		
	}
	
	@Test(priority = 30, description="Unapplied notice should appear on CDP even after case is closed")
	public void verifyUnaplliedNoticeAppearsAfterClosingCase() throws InterruptedException
	{
		ooi.verifyUnaplliedNoticeAppearsAfterClosingCase();
		
	}
	@Test(priority = 31, description="Apply notice button should no longer appear once case is closed")
	public void verifyApplyNoticeBtnNotDisplayed () throws InterruptedException
	{
		ooi.voidverifyApplyNoticeBtnNotDisplayed();
		
	}
	@Test(priority = 32, description="View notice link should not be displayed for unapplied notice")
	public void verifyViewNoticeBtnNotDisplayed () throws InterruptedException
	{
		ooi.verifyViewNoticeBtnNotDisplayed();
		
	}
	
	@Test(priority = 33, description="View confirmation pop opens up after clicking Apply Notice")
	public void verifyConfirmationPopUpOpensAfterClickingApplyNoticeBtn () throws InterruptedException
	{
		ooi.verifyConfirmationPopUpOpensAfterClickingApplyNoticeBtn();
		
	}
	@Test(priority = 34, description="View confirmation pop closes after clicking Cancel")
	public void verifyConfirmationPopIsClosedAFterCancel () throws InterruptedException
	{
		ooi.verifyConfirmationPopIsClosedAFterCancel();
		
	}
	
	@Test(priority = 35, description="Verify user is able to apply notice after clicking Yes on confirmation popup")
	public void verifyUserIsAbleToApplyNoticeAfterClickingYes() throws InterruptedException
	{
		ooi.verifyUserIsAbleToApplyNoticeAfterClickingYes();
		
	}
	
	@Test(priority = 36, description="Verify outstanding balance is changed after notice is applied on case")
	public void verifyOutstandingBalanceIsUpdated() throws InterruptedException
	{
		ooi.verifyOutstandingBalanceIsUpdated();
		
	}
	
	@Test(priority = 37, description="Verify generate notice button is not displayed until inspection is performed")
	public void verifyGenerateNoticeBtnNotDisplayed() throws InterruptedException
	{
		ooi.verifyGenerateNoticeButtonNotDisplayed();
		
	}



}
