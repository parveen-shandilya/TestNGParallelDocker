package TestCases;

import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;

import CommonMethods.CRMCommonMethods;
import CommonMethods.DateAndTime;
import POM.CCPUtility;
import POM.CSDPUtility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import ExtentReport.ExtentReportClass;
import POM.CloseCaseUtility;
import POM.LoginUtility;
import POM.OnlinePaymentUtility;
import POM.PerformInspectionUtility;
import org.testng.asserts.SoftAssert;

public class PerformInspection extends BrowsersInvoked {


	PerformInspectionUtility perInspect;
	CSDPUtility csdp;
	DateAndTime dateAndTime;
	CRMCommonMethods crmCommonMethods;
    CCPUtility ccpUtility;
	
	

	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		perInspect = new PerformInspectionUtility(getDriver());
		csdp = new CSDPUtility(getDriver());
		dateAndTime = new DateAndTime(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		ccpUtility = new CCPUtility(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}

	
	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		//LoginUtility log = new LoginUtility(getDriver());
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

	@Test(priority=1,description = "Edit the Location after creating Case")
	public void CCP_CDP_EditLocation() throws InterruptedException {
		perInspect.PerformInspection_PreRequisite_CDP();
		//perInspect.CCP_CDP_EditLocation();

	}
	@Test(priority = 2,description = "Verify that the created case is associated with multiple contacts.")
	public void PerformInspection_PreRequisite_Contacts() {
		perInspect.PerformInspection_PreRequisite_Contacts();
	}

	@Test(priority = 3,description = "Verify that 'Verification Inspection in Progress' page opens up, when user clicks on 'Perform Inspection' button under 'Abatement Activities' tile, 'Case Detail' page.")
	public void PerformInspection_OpenVerificationInspectionInProgressPage() throws InterruptedException {
		perInspect.PerformInspection_OpenVerificationInspectionInProgressPage();

	}

	@Test(priority = 5,description = "Verify that appropriate validation message appears, when user clicks on 'Continue' button without entering data in mandatory fields, on 'Verify Violations' popup. ")
	public void PerformInspection_ValidationMessageSection1() throws InterruptedException {
		perInspect.PerformInspection_ValidationMessageSection1();

	}

	@Test(priority = 6,description = "Verify that the status of 'Verify Violations' section appears 'Incomplete' by default, under 'Verify Violations' section. ")
	public void PerformInspection_VerifySection1Status() {
		perInspect.PerformInspection_VerifySection1Status();
	}

//	@Test(priority = 6)
//	public void PerformInspection_AddAViolation() throws InterruptedException {
//		perInspect.PerformInspection_AddAViolation();
//	}

	@Test(priority = 7,description = "Verify that 'Verification Pending' status appears by defualt, when no toggle is selected for a violation, under 'Verify Violations' section.")
	public void PerformInspection_VerifyVerificationPendingStatusForViolation() {
		
perInspect.PerformInspection_VerifyVerificationPendingStatusForViolation();
	}

	@Test(priority = 8,description = "Verify that user is able to select any toggle button for the added violations , under 'Verify Violations' section. ")
	public void PerformInspection_SelectAnyToggleButtonForViolation() {

		perInspect.PerformInspection_SelectAnyToggleButtonForViolation();
	}

	@Test(priority = 9,description = "Verify that 'Closed, invalid, ' status appears, when user selects 'Invalid' toggle button for a violation, under 'Verify Violations' section. ")
	public void PerformInspection_VerifyClosedStatusForViolation() {
		perInspect.PerformInspection_VerifyClosedStatusForViolation();
	}

	@Test(priority = 10,description = "Verify that 'Open, non-compliant' status appears, when user selects 'Valid' toggle button for a violation, under 'Verify Violations' section. ")
	public void PerformInspection_VerifyOpenStatusForViolation() {
		perInspect.PerformInspection_VerifyOpenStatusForViolation();
	}

	@Test(priority = 11,description = "Verify that 'Continue' button no longer appears, when 'Invalid' toggle button is selected for all the violations, on 'Verify Violations' popup.")
	public void PerformInspection_VerifyContinueButtonPresence() {
		perInspect.PerformInspection_VerifyContinueButtonPresence();

	}

	@Test(priority = 12,description = "Verify that confirmation popup opens up, when user clicks on 'Complete Inspection & Close Case' button for invalid violations, under 'Verify Violations' section.")
	public void PerformInspection_OpenConfirmationPopupForCloseCaseButton() {
		perInspect.PerformInspection_OpenConfirmationPopupForCloseCaseButton();

	}

	@Test(priority = 13,description = "Verify that confirmation popup gets closed, when user clicks on 'Close' button, under 'Verify Violations' section. ")
	public void PerformInspection_CloseConfirmationPopup() {
		perInspect.PerformInspection_CloseConfirmationPopup();
	}

	@Test(priority = 14,description = "Verify that 'Select Notice & Schedule Follow Up' section's title appears under 'Verify Violations' section, when 'Valid' toggle button is selected for any violation.")
	public void PerformInspection_VerifySection2Title() {
		perInspect.PerformInspection_VerifySection2Title();
	}

	@Test(priority = 15,description = "Verify that 'Close Case' popup opens up, when user clicks on 'Complete Inspection & Close Case' button for valid violations, on 'Verify Violations' popup.")
	public void PerformInspection_OpenCloseCasePopup() {
		perInspect.PerformInspection_OpenCloseCasePopup();

	}

	@Test(priority = 16,description = " Verify that 'Voluntary' toggle button appears selected by default, on 'Close Case' popup.")
	public void PerformInspection_VerifyVoluntaryToggleButtonState() {
		perInspect.PerformInspection_VerifyVoluntaryToggleButtonState();

	}

	@Test(priority = 17,description = " Verify that user is able to select 'Forced' toggle button, on 'Close case' popup.")
	public void PerformInspection_SelectForcedToggleButton() {
		perInspect.PerformInspection_SelectForcedToggleButton();

	}

	@Test(priority = 18, description = "Verify that 'Close Case' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Verify Violations' popup. ")
	public void PerformInspection_CloseCloseCasePopup() {
		perInspect.PerformInspection_CloseCloseCasePopup();
	}

	@Test(priority = 19,description = "Verify that user is able to add notes in the 'Inspection Note' field, on the 'Verify Violations' popup. ")
	public void PerformInspection_AddInspectionNote() {
		perInspect.PerformInspection_AddInspectionNote();
	}

	@Test(priority = 20,description = "Verify that user is able to add an attachment under 'Attachments' tile after clicking on 'Image' icon, on 'Verify Violations' popup.")
	public void PerformInspection_AddAttachment() throws InterruptedException {
		perInspect.PerformInspection_AddAttachment();
	}

	@Test(priority = 21,description = "Verify that 'Select Notice & Schedule Follow Up' popup opens up, when user clicks on 'Continue' button, on 'Verify Violations' popup.")
	public void PerformInspection_ExpandSection2OnContinue() {
		perInspect.PerformInspection_ExpandSection2OnContinue();
	}

	@Test(priority = 22 , enabled = true,description = "Verify that label of the 'Verify Violations' popup appears complete after user clicks on 'Continue' button.")
	public void PerformInspection_VerifySection1Label() {
		perInspect.PerformInspection_VerifySection1Label();
	}

	@Test(priority = 23,description = "Verify that user is able to edit the 'Verify Violations' popup, after clicking on the 'Edit' icon, on 'Select Notice & Schedule Follow Up' popup.")
	public void PerformInspection_EditVerifyViolationSection() throws InterruptedException {
		perInspect.PerformInspection_EditVerifyViolationSection();
	}

	@Test(priority = 24,description = "Verify that first notice appears selected by default under 'Select a notice' sub-section of the 'Select Notice & Schedule Follow Up' section. ")
	public void PerformInspection_VerifyFirstNoticeState() throws InterruptedException {
		perInspect.PerformInspection_VerifyFirstNoticeState();
	}

	@Test(priority = 25,description = " Verify that user is able to select a notice under 'Select a notice' sub-section of the 'Select Notice & Schedule Follow Up' section. ")
	public void PerformInspection_SelectAnyNotice() throws InterruptedException {
		perInspect.PerformInspection_SelectAnyNotice();
	}

	@Test(priority = 26,description = "Verify that 'Generate Notice' section's title appears under 'Select a notice' sub-section of the 'Select Notice & Schedule Follow Up' section, when user selects any HTML notice.")
	public void PerformInspection_VerifySection3Title() {
		perInspect.PerformInspection_VerifySection3Title();
	}

	@Test(priority = 27,description = " Verify that user is able to select 'No Notice' toggle button, on 'Select Notice & Schedule Follow Up' popup. ")
	public void PerformInspection_SelectNoNoticeRequiredCheckbox() throws InterruptedException {
		perInspect.PerformInspection_SelectNoNoticeRequiredCheckbox();

	}

	@Test(priority = 28,description = " Verify that 'Notice issue date' sub-section gets updated, when user selects a date from calendar, on 'Select Notice & Schedule Follow Up' popup.")
	public void PerformInspection_UpdateNoticeIssueDate() throws InterruptedException {
		perInspect.PerformInspection_UpdateNoticeIssueDate();

	}

	@Test(priority = 29,description = " Verify that 'Issue Notice & Complete Inspection' button appears, when any non-HTML notice option is selected, under 'Select a notice' sub-section.")
	public void PerformInspection_VerifyIssueNoticeAndCompleteInspectionButton() {
		perInspect.PerformInspection_VerifyIssueNoticeAndCompleteInspectionButton();
	}

	@Test(priority = 30,description = "Verify that 'Continue' button appears, when any HTML notice option is selected, under 'Select a notice' sub-section.")
	public void PerformInspection_VerifyContinueButtonPresenceOnHtmlSelected() throws InterruptedException {
		perInspect.PerformInspection_VerifyContinueButtonPresenceOnHtmlSelected();

	}

	@Test(priority = 31,description = "Verify that only valid violations appear under 'Review Open Violations and Comply by dates' sub-section, on 'Select Notice & Schedule Follow Up' section.")
	public void PerformInspection_VerifyViolationsUnderReviewOpenViolations() {
		perInspect.PerformInspection_VerifyViolationsUnderReviewOpenViolations();
	}

	@Test(priority = 32,description = "Verify that user is able to update the Comply by date for the open violations under 'Review Open Violations and Comply by dates' sub-section of the 'Select Notice & Schedule Follow Up' section.")
	public void PerformInspection_UpdateComplyByDate() {
		perInspect.PerformInspection_UpdateComplyByDate();
	}

	@Test(priority = 33,description = "Verify that user is able to update the Follow-up inspection date under 'Follow-up inspection date' sub-section of the 'Select Notice & Schedule Follow Up' section.")
	public void PerformInspection_UpdateFollowUpInspectionDate() throws InterruptedException {
		perInspect.PerformInspection_UpdateFollowUpInspectionDate();

	}

	@Test(priority = 34,description = " Verify that logged in user appears selected by default under 'Follow-up inspection assignee' sub-section of the 'Select Notice & Schedule Follow Up' section.")
	public void PerformInspection_VerifyLoggedInUserToggleButtonState() throws InterruptedException {
		perInspect.PerformInspection_VerifyLoggedInUserToggleButtonState();
	}

	@Test(priority = 35,description = "Verify that 'Generate Notice' section expands after clicking the 'Continue' button, when any HTML notice is selected, under 'Select Notice & Schedule Follow Up' section.")
	public void PerformInspection_ExpandSection3() throws InterruptedException {
		perInspect.PerformInspection_ExpandSection3();

	}

	@Test(priority = 36,description = "Verify that user is able to enter Certified Mail Number in the 'Certified Mail Number' field, under 'Generate Notice' section.")
	public void PerformInspection_EnterCertifiedMailNumber() {
		perInspect.PerformInspection_EnterCertifiedMailNumber();

	}

	@Test(priority = 37,description = "Verify that 'Recipient' sub-section gets displayed, when case is associated with multiple contacts, under 'Generate Notice' section. ")
	public void PerformInspection_VerifyRecipientSubSectionPresence() {
		perInspect.PerformInspection_VerifyRecipientSubSectionPresence();
	}

	@Test(priority = 38,description = " Verify that No validation message appears after user clicks on 'Generate Notice' button, when no Recipient is selected, under 'Generate Notice' section.")
	public void PerformInspection_VerifyRecipientNoLongerMandatory() throws InterruptedException {
		perInspect.PerformInspection_VerifyRecipientNoLongerMandatory();
	}

	@Test(priority = 39,description = "Verify that user is able to select multiple contacts from 'Recipient' sub-section, under 'Generate Notice' section.")
	public void PerformInspection_SelectMultipleContact() {
		perInspect.PerformInspection_SelectMultipleContact();
	}

	@Test(priority = 40,description = "Verify 'Responsible Party' section gets displayed when there are more than one contact are marked as Bill to contact or none of the contact is marked as Bill to contact when case is having multiple contacts associated with a case.")
	public void PerformInspection_VerifyResponsiblePartySectionPresence() {
		perInspect.PerformInspection_VerifyResponsiblePartySectionPresence();

	}

	@Test(priority = 41,description = "Verify that confirmation popup opens up, when user clicks on 'Exit' button, on 'Verification Inspection in Progress' page. ")
	public void PerformInspection_OpenConfirmationPopupOnExitButton() {
		perInspect.PerformInspection_OpenConfirmationPopupOnExitButton();
	}

	@Test(priority = 42,description = "Verify that confirmation popup gets closed, when user clicks on 'Cancel' button.")
	public void PerformInspection_CloseConfirmationPopupForExitButto() {
		perInspect.PerformInspection_CloseConfirmationPopupForExitButto();
	}

	@Test(priority = 43,description = "Verify that 'Generate Notice' popup opens up, when user clicks on 'Generate Notice' button, on 'Generate Notice' popup.")
	public void PerformInspection_OpenGenerateNoticepopup() {
		perInspect.PerformInspection_OpenGenerateNoticepopup();
	}

	@Test(priority = 44,description = "Verify that 'Generate Notice' popup gets closed, when user clicks on 'Cancel' button, on 'Generate Notice' popup.")
	public void PerformInspection_CloseGenerateNoticePopup() {
		perInspect.PerformInspection_CloseGenerateNoticePopup();
	}

	@Test(priority = 45,description = "Verify that user is able to add text to the text box on 'Generate Notice' popup.")
	public void PerformInspection_AddTextToTextBox() {
		perInspect.PerformInspection_AddTextToTextBox();
	}

	@Test(priority = 46,description = "Verify that 'Print' toggle button appears selected by default on the 'Generate Notice' popup.")
	public void PerformInspection_VerifyPrintToggleButtonState() {
		perInspect.PerformInspection_VerifyPrintToggleButtonState();

	}

	@Test(priority = 47,description = " Verify that user is able to select the 'Queue To Print'/'Do Not Print' toggle button on the 'Generate Notice' popup.")
	public void PerformInspection_SelectAnyToggleButton() {
		perInspect.PerformInspection_SelectAnyToggleButton();

	}

	@Test(priority = 48,description = "Verify that confirmation popup opens up, when user clicks on 'Issue Notice & complete Inspection' button, on 'Generate Notice' popup. ")
	public void PerformInspection_OpenConfirmationPopupForCompleteInspection() {

		perInspect.PerformInspection_OpenConfirmationPopupForCompleteInspection();
	}

	@Test(priority = 49,description = " Verify that confirmation popup gets closed, when user clicks on 'Cancel' button, on Confirmation popup.")
	public void PerformInspection_CloseConfirmationPopupOnCancel() {
		perInspect.PerformInspection_CloseConfirmationPopupOnCancel();
	}

	@Test(priority = 50,description = "Verify that a notice gets issued successfully, when user clicks on 'Yes' button, on confirmation popup.")
	public void PerformInspection_VerifyTheNoticeIssued() throws InterruptedException {
		perInspect.PerformInspection_VerifyTheNoticeIssued();
	}

	@Test(priority = 51,description = "Verify that 'Follow-up Inspection' sub-section gets added under 'Abatement Activities' section, after user performs first Inspection, on CDP.")
	public void FollowUpInspection_VerifyFollowUpInspectionSubSection() {
		perInspect.FollowUpInspection_VerifyFollowUpInspectionSubSection();

	}

	@Test(priority = 52,description = "Verify that 'Edit Follow-up Inspection1' popup opens up, when user clicks on 'Edit' icon under 'Abatement Activities' section, on CDP.")
	public void FollowUpInspection_OpenEditFollowUpInspectionPopup() {
		perInspect.FollowUpInspection_OpenEditFollowUpInspectionPopup();
	}

	@Test(priority = 53,description = "Verify that user is able to edit & update Follow-up Inspection, after clicking on 'Update' button, on 'Edit Follow-up Inspection1' popup.")
	public void FollowUpInspection_VerifyEditedDetails() {
		perInspect.FollowUpInspection_VerifyEditedDetails();
	}

	@Test(priority = 54,description = "Verify that 'Follow-up Inspection 1 in Progress - <Case #>' popup opens up, when user clicks on 'Perform Inspection' button, on CDP.")
	public void FollowUpInspection_OpenFollowUpInspectionInProgressPopup() throws InterruptedException {
		perInspect.FollowUpInspection_OpenFollowUpInspectionInProgressPopup();
	}

	@Test(priority = 55,description = "Verify that 'Inspect Violations' header appears for section 1 of Follow-up Inspection, on CDP.")
	public void FollowUpInspection_VerifyInspectViolationsHeadersection1() {
		perInspect.FollowUpInspection_VerifyInspectViolationsHeadersection1();
	}

	@Test(priority = 56,description = "Verify that user is able to perform Follow-up Inspection on CDP. ")
	public void FollowUpInspection_PerformFollowUpInspection() {
		perInspect.FollowUpInspection_PerformFollowUpInspection();
	}

	@Test(priority = 57,description = " Verify that 'Follow-up Inspection 2' title appears under 'Abatement Activities' sub-section, after Follow-up Inspection 1 is completed, on CDP")
	public void FollowUpInspection_VerifyFollowUpInspection2Title() {
		perInspect.FollowUpInspection_VerifyFollowUpInspection2Title();
	}

	@Test(priority = 58,description = "CDP_PerformInspection_NoteVerification")
	public void CDP_PerformInspection_AddedNoteVerification() {
		perInspect.CDP_PerformInspection_AddedNoteVerification();
	}

	@Test(priority = 59,description = "CDP_VerifyAddCaseNotePopup")
	public void CDP_VerifyOpenAddCaseNotePopup() {
		perInspect.CDP_VerifyOpenAddCaseNotePopup();
	}

	@Test(priority = 60,description = "CDP_VerifyPopopClosesOnclickingCancel")
	public void CDP_VerifyPopopClosesOnclickingCancel() {
		perInspect.CDP_VerifyPopopClosesOnclickingCancel();
	}

	@Test(priority = 61,description = "CDP_ValidationMessageForAddCaseNoteField")
	public void CDP_ValidationMessageForAddCaseNoteField() {
		perInspect.CDP_ValidationMessageForAddCaseNoteField();
	}

//	@Test(priority = 62)
//	public void CDP_validationMsgForMoreThan5000Characters() throws InterruptedException {
//		perInspect.CDP_validationMsgForMoreThan5000Characters();
//
//	}

	@Test(priority = 63,description = "CDP_VerifyCaseNoteGetsAdded")
	public void CDP_VerifyCaseNoteGetsAdded() throws Exception {
		perInspect.CDP_VerifyCaseNoteGetsAdded();

	}

	@Test(priority = 64,description = "Verify comply date on CDP ...")
	public void PerformInspection_ValidateCompileDate()throws InterruptedException{
		// CDS -3185
		String date = csdp.getTextElement(csdp.caseHeaderCDP);
		String extractedDate = dateAndTime.extractDateFromString(date);
		String dateFormat = dateAndTime.dateFormatConverter(extractedDate);
		System.out.println("dateFormat :"+dateFormat);
		String extractedDays = perInspect.getTextElement(perInspect.extractDaysCDP);
		int days = crmCommonMethods.extractedInteger(extractedDays);
		System.out.println("days: "+ days);
		perInspect.clickByJsExecuter(perInspect.PerformInsButton);
		perInspect.clickByJsExecuter(perInspect.ContinueBtnSec2);

		String expectedComplyByDate = perInspect.getValueAttribute(perInspect.complyByDate);
		System.out.println("value: "+ expectedComplyByDate);

		String dte =  dateAndTime.dateManuplation(dateFormat,days);
		System.out.println("after adding days : "+ dte);

		perInspect.forcedWaitTime(3);
		perInspect.scrollIntoView(perInspect.ContinueBtnSec2);
		perInspect.clickByJsExecuter(perInspect.ContinueBtnSec2);
		perInspect.scrollIntoView(perInspect.GenerateNoticeBtn);
		perInspect.forcedWaitTime(3);
		perInspect.clickByJsExecuter(perInspect.GenerateNoticeBtn);
		//	perInspect.forcedWaitTime(3);

		perInspect.waitForCurserRunning(3);

		perInspect.clickByJsExecuter(perInspect.DoNotPrintBtn);
		perInspect.clickByJsExecuter(perInspect.IssueNoticeButton);
		perInspect.clickByJsExecuter(perInspect.YesConfirmation);

		perInspect.waitForCurserRunning(3);

		String dateCDP = perInspect.getTextElement(perInspect.complyCDPDate);
		System.out.println(dateCDP);

		String finalDate = perInspect.getTextElement(perInspect.complyDateOnCDP);
		System.out.println("FinalDate CDP: "+finalDate);
		String actualDateFormatted = dateAndTime.dateFormatConverter(finalDate,"MMM d, yyyy","MM/dd/yyyy");
		System.out.println("dateFormat :"+actualDateFormatted);

		String originalString = perInspect.getTextElement(perInspect.complyByDateResolution);

		// Remove the substring "| " in one line
		String resultString = originalString.replace("| ", "");

		SoftAssert st = new SoftAssert();
		// on CDP
		st.assertEquals(dte ,expectedComplyByDate);
		// expectedComplyByDate come from performinspection popup.
		st.assertEquals(actualDateFormatted, expectedComplyByDate);
		st.assertEquals(resultString,"Comply By 7 days");
		st.assertAll();
		perInspect.clickOn(ccpUtility.CloseCDP);

	}

}
