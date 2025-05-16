package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CDP_Utility;
import POM.CaseAssignmentUtility;
import POM.CategoryPage;
import POM.LoginUtility;
import POM.SmsAndEmailVerificationUtility;
import POM.TemplateManagementUtility;
import POM.UserManagementUtility;

public class CCP extends BrowsersInvoked {
	
	ExtentReportClass extentClass;
	ITestResult result;
	CCPUtility ccp;
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
     
        ccp = new CCPUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }

	
//	@Test(priority = 0)
//	public void LoginAgency() throws InterruptedException {
//		ccp.LoginAgency();
//
//	}
	
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

	@Test(priority = 1, description = "Verify that appropriate validation message appears when user clicks on 'Create Case' button without entering any data in mandatory fields, on 'Create Case' page. ")
	public void CCP_GlobalValidationMsgForNoData() throws InterruptedException {
		ccp.CCP_PreRequisite();
		ccp.CCP_GlobalValidationMsgForNoData();
	}

	@Test(priority = 2, description = " Verify that an information message appears by deafult, when no location is selected, on 'Create Case' page. ")
	public void CCP_DefaultInfoMsgOnLOcationTile() throws InterruptedException {
		ccp.CCP_DefaultInfoMsgOnLOcationTile();
	}

	// Blank page is encountered through automation Bug id-CDS
	@Test(priority = 3 ,enabled=false, description = " Verify that appropriate validation message appears, when user clicks on the outside of Agency boundary on map, on 'Create Case' page. ")
	public void CCP_ValidationMsgOutsideAgencyBoundary() throws InterruptedException {
		ccp.CCP_ValidationMsgOutsideAgencyBoundary();
	}

	@Test(priority = 4, description = " Verify that user is able to add a location from 'Enter Address, APN or drop a Pin on the Map' combo box, on 'Create Case' page. ")
	public void CCP_SearchAndAddAddress() throws InterruptedException {
		ccp.CCP_SearchAndAddAddress();
	}

	@Test(priority = 5, description = " Verify that 'Add Address Manually' popup opens up, after clicking on 'Add Address Manually' link, on 'Create Case' page. ")
	public void CCP_OpenAddAddressManuallyPopup() throws InterruptedException {
		ccp.CCP_OpenAddAddressManuallyPopup();
	}

	@Test(priority = 6, description = " Verify that 'Add Address Manually' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Create Case' page. ")
	public void CCP_CloseAddAddressManuallyPopup() throws InterruptedException {
		ccp.CCP_CloseAddAddressManuallyPopup();
	}

	// Removed as functionality is changed
//	@Test(priority = 7, description = " Verify that validation messages appear when user clicks on 'Add Address' button without entering data in mandatory fields, on 'Create Case' popup.  ")
//	public void CCP_ValidationMsgForNoAddressDetails() throws InterruptedException {
//		ccp.CCP_ValidationMsgForNoAddressDetails();
//	}

	@Test(priority = 8, description = " Verify that the address gets added under 'Select Location' tile, after entering address details manually & clicking on 'Add Address' button, on 'Add Address Manually' popup. ")
	public void CCP_AddTheAddressManually() throws InterruptedException {
		ccp.CCP_AddTheAddressManually();
	}

	@Test(priority = 9, description = " Verify that user is able to edit the location details, after clicking on the 'Edit' icon, on 'Create Case' page. ")
	public void CCP_EditAddedAddress() throws InterruptedException {
		ccp.CCP_EditAddedAddress();
	}

	@Test(priority = 10, description = " Verify that address gets updated, when user edits data and clicks on 'Save' button under 'Select Location' tile, on 'Create Case' page. ")
	public void CCP_UpdateAddressOnSaveButton() throws InterruptedException {
		ccp.CCP_UpdateAddressOnSaveButton();
	}

	@Test(priority = 11, description = " Verify that address does not get updated, when user edits data and clicks on 'Cancel' button under 'Select Location' tile, on 'Create Case' page. ")
	public void CCP_AddressShouldntGetUpdatedOnCancelButton() throws InterruptedException {
		ccp.CCP_AddressShouldntGetUpdatedOnCancelButton();
	}

	@Test(priority = 12, description = " Verify that 'Flag Address' popup opens up for an unflagged address, when user clicks on 'Flagged?' toggle button, on 'Create Case' page. ")
	public void CCP_OpenFlagAddressPopup() throws InterruptedException {
		ccp.CCP_OpenFlagAddressPopup();
	}

	@Test(priority = 13, description = " Verify that 'Flag Address' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Flag Address' popup. ")
	public void CCP_CloseFlagAddressPopup() throws InterruptedException {
		ccp.CCP_CloseFlagAddressPopup();
	}

	@Test(priority = 14, description = " Verify that 'Flag address' button gets enabled, when user enters data in 'Reason to Flag the address' field, on 'Flag Address' popup. ")
	public void CCP_VerifyFlagAddressButtonState() throws InterruptedException {
		ccp.CCP_VerifyFlagAddressButtonState();
	}

	@Test(priority = 15, description = " Verify that 'Flagged?' toggle button gets enabled, when user clicks on 'Flag Address' button after entering data in the mandatory field, on 'Create Case' popup. ")
	public void CCP_VerifyFlaggedButtonState() throws InterruptedException {
		ccp.CCP_VerifyFlaggedButtonState();
	}

	@Test(priority = 16, description = " Verify that an information message appears when no violation is added, on 'Create Case' page. ")
	public void CCP_InfoMsgForNoViolation() throws InterruptedException {
		ccp.CCP_InfoMsgForNoViolation();
	}

	@Test(priority = 17, description = " Verify that appropriate validation message appears when user clicks on 'Create Case' button without adding any violation, on 'Create Case' page. ")
	public void CCP_ValidationMsgForNoViolation() throws InterruptedException {
		ccp.CCP_ValidationMsgForNoViolation();
	}

	@Test(priority = 18, description = " Verify that an information message appears on entering non-existing data in 'Find a violation, article number or describe the issue' field, on 'Create Case' page. ")
	public void CCP_InfoMsgForNonExistingData() throws InterruptedException {
		ccp.CCP_InfoMsgForNonExistingData();
	}

	@Test(priority = 19, description = " Verify that 'Custom Issue Description' field gets added after entering data & clicking on 'Add custom issue description' link, on 'Create Case' page. ")
	public void CCP_AddCustomIssueDescriptionField() throws InterruptedException {
		ccp.CCP_AddCustomIssueDescriptionField();
	}

	@Test(priority = 20, description = " Verify that appropriate validation message appears when 'Custom Issue Description' field is blank, on 'Create Case' page. ")
	public void CCP_validationMsgForEmptyCustomIssueDescriptionField() throws InterruptedException {
		ccp.CCP_validationMsgForEmptyCustomIssueDescriptionField();
	}

	@Test(priority = 21, description = " Verify that Violation with no entity gets added under 'Add Violations' tile via search results of 'Find a violation, article number or describe the issue' combo box, on 'Create Case' page. ")
	public void CCP_AddViolationWithoutEntity() throws InterruptedException {
		ccp.CCP_AddViolationWithoutEntity();
	}

	@Test(priority = 22, description = " Verify that '<Violation>' popup opens up for violations with entity, via search results of 'Find a violation, article number or describe the issue' combo box, on 'Create Case' page. ")
	public void CCP_OpenViolationWithEntityPopup() throws InterruptedException {
		ccp.CCP_OpenViolationWithEntityPopup();
	}

	@Test(priority = 23, description = " Verify that appropriate validation message appears when user clicks on 'Add' button, without entering data in the mandatory field, on violation popup. ")
	public void CCP_ValidationMsgForNoViolationData() throws InterruptedException {
		ccp.CCP_ValidationMsgForNoViolationData();
	}

	@Test(priority = 24, description = " Verify that a violation gets added under 'Find a violation, article number or describe the issue' combo box, when user clicks on 'Add' button after entering data in mandatory fields, on 'Create Case' page. ")
	public void CCP_AddViolationWithEntity() throws InterruptedException {
		ccp.CCP_AddViolationWithEntity();
	}

	@Test(priority = 25, description = " Verify that user is able to add a violation after selecting an option from 'Find and add existing Entity' combo box, on Violation popup. ")
	public void CCP_SearchAndAddViolation() throws InterruptedException {
		ccp.CCP_SearchAndAddViolation();
	}

	@Test(priority = 26, description = " Verify that 'Add Another <Violation>' link appears under each added Violation type, under 'Add Violations' tile, on 'Create Case' page. ")
	public void CCP_VerifyAddAnotherViolationLink() throws InterruptedException {
		ccp.CCP_VerifyAddAnotherViolationLink();
	}

	@Test(priority = 27, description = " Verify that previously added violation gets deleted, when user clicks on the 'Delete' icon under 'Add Violations' tile, on 'Create Case' page. ")
	public void CCP_DeleteAddedViolation() throws InterruptedException {
		ccp.CCP_DeleteAddedViolation();
	}

	@Test(priority = 28, description = " Verify that 'Edit <Violation>' popup opens up, when user clicks on 'Edit' icon under 'Add Violations' tile, on 'Create Case' page. ")
	public void CCP_OpenEditViolationPopup() throws InterruptedException {
		ccp.CCP_OpenEditViolationPopup();
	}

	@Test(priority = 29, description = " Verify that a photo gets uploaded, when user selects a photo after clicking on 'Upload' button, on 'Edit <Violation>' popup. ")
	public void CCP_UploadPhotoForViolation() throws InterruptedException {
		ccp.CCP_UploadPhotoForViolation();
	}

	@Test(priority = 30, description = " Verify that the 'Upload' button converts into 'Replace' button, when user uploads a photo, on 'Edit <Violation>' popup. ")
	public void CCP_VerifyReplaceButtonPresence() throws InterruptedException {
		ccp.CCP_VerifyReplaceButtonPresence();
	}

	@Test(priority = 31, description = " Verify that the added photo gets deleted, when user clicks on the 'Delete' icon, on 'Edit <Violation>' popup. ")
	public void CCP_DeleteAddedPhoto() throws InterruptedException {
		ccp.CCP_DeleteAddedPhoto();
	}

	@Test(priority = 32, description = " Verify that total count along with '<Violation with entity>' count of added violations appear beside 'Add Violations' tile's header, on 'Create Case' page. ")
	public void CCP_VerifyTotalViolationsCount() throws InterruptedException {
		ccp.CCP_VerifyTotalViolationsCount();
	}

	@Test(priority = 33, description = " Verify that respective '<Violation> Listing' popup opens up, when user clicks on '<n> <Violation>' link next to 'Add Violation' tile header, on 'Create Case' page. ")
	public void CCP_OpenViolationListingPopup() throws InterruptedException {
		ccp.CCP_OpenViolationListingPopup();
	}

	@Test(priority = 34, description = " Verify that '<Violation> Listing' popup gets closed, when user clicks on 'Cancel' button or 'Cross' icon, on 'Create Case' page. ")
	public void CCP_CloseViolationListingPopup() throws InterruptedException {
		ccp.CCP_CloseViolationListingPopup();
	}

	@Test(priority = 35, description = " Verify that 'Create a Contact' popup opens up, when user clicks on 'Add Contact' field > 'Create a new contact' link, on 'Create Case' popup. ")
	public void CCP_OpenCreateAContactPopup() throws InterruptedException {
		ccp.CCP_OpenCreateAContactPopup();
	}

	@Test(priority = 36, description = " Verify that appropriate validation message appears when 'Create Contact' button is clicked without entering data in the mandatory field, on 'Create a Contact' popup. ")
	public void CCP_ValidationMsgForNodataInNameField() throws InterruptedException {
		ccp.CCP_ValidationMsgForNodataInNameField();
	}

	@Test(priority = 37, description = " Verify that 'Create a Contact' popup gets closed , when user clicks on 'Cancel' button, on 'Create Case' popup. ")
	public void CCP_CloseCreateAContactPopup() throws InterruptedException {
		ccp.CCP_CloseCreateAContactPopup();
	}

	@Test(priority = 38, description = "Verify that user is able to add new Legal contact under 'Contacts' section on the CCP.")
	public void CCP_AddNewContact() throws InterruptedException {
		ccp.CCP_AddNewContact();
	}

	@Test(priority = 39, description = " Verify that 'Edit Contact' popup opens up for newly created contact, when user clicks on 'Edit' icon, on 'Create Case' page. ")
	public void CCP_OpenEditContactPopup() throws InterruptedException {
		ccp.CCP_OpenEditContactPopup();
	}

	@Test(priority = 40, description = " Verify that previously added contact gets deleted, when user clicks on the 'Delete' icon, on 'Create Case' page. ")
	public void CCP_DeleteAddedContact() throws InterruptedException {
		ccp.CCP_DeleteAddedContact();
	}

	@Test(priority = 41, description = " Verify that accurate count of added contacts appear beside 'Contacts' tile's header, on 'Create Case' popup. ")
	public void CCP_VerifyTotalContactCount() throws InterruptedException {
		ccp.CCP_VerifyTotalContactCount();
	}

	@Test(priority = 42, description = " Verify that attachments added to the 'Add Violations' tile also appear on the 'Attachments' tile, on 'Create Case' page. ")
	public void CCP_VerifyViolationAttachmentsPresence() throws InterruptedException {
		ccp.CCP_VerifyViolationAttachmentsPresence();
	}

	@Test(priority = 43, description = " Verify that 'Add Attachments' popup opens up, when user clicks on the 'Image' icon under 'Attachments' tile, on 'Create Case' page. ")
	public void CCP_OpenAddAttachmentsPopup() throws InterruptedException {
		ccp.CCP_OpenAddAttachmentsPopup();
	}

	@Test(priority = 44, description = " Verify that attachment's preview appears, when user selects an attachment after clicking on 'Browse file' link or 'Camera' button, on 'Add Attachments' popup. ")
	public void CCP_VerifyAttachmentsPreview() throws InterruptedException {
		ccp.CCP_VerifyAttachmentsPreview();
	}

	@Test(priority = 45, description = " Verify that 'Close Add Attachments' confirmation popup opens up, when user clicks on 'Cross' icon or 'Cancel' button after selecting an attachment, on 'Add Attachments' popup. ")
	public void CCP_OpenCloseAddAttachmentsPopup() throws InterruptedException {
		ccp.CCP_OpenCloseAddAttachmentsPopup();
	}

	@Test(priority = 46, description = " Verify that 'Add Attachments' popup gets closed, when user clicks on 'Yes, Close' button, on 'Close Add Attachment' confirmation popup. ")
	public void CCP_CloseAddAttachmentsPopup() throws InterruptedException {
		ccp.CCP_CloseAddAttachmentsPopup();
	}

	@Test(priority = 47, description = " Verify that 'Add Attachments' popup reopens, when user clicks on 'No, Don't Close' button, on 'Close Add Attachment' confirmation popup. ")
	public void CCP_ReopenAddAttachmentsPopup() throws InterruptedException {
		ccp.CCP_ReopenAddAttachmentsPopup();
	}

	@Test(priority = 48, description = " Verify that an attachment gets added under 'Attachments' tile, when user clicks on 'Add' button after selecting an attachment, on 'Add Attachments' popup. ")
	public void CCP_AddAnAttachment() throws InterruptedException {
		ccp.CCP_AddAnAttachment();
	}

	@Test(priority = 49, description = " Verify that user is able to add multiple attachments under 'Attachments' tile, on 'Create Case' popup. ")
	public void CCP_AddMultipleAttachments() throws InterruptedException {
		ccp.CCP_AddMultipleAttachments();
	}

	@Test(priority = 50, description = " Verify that 'Attachments Details' popup opens up, when user clicks on the added attachment, on 'Create Case' popup. ")
	public void CCP_OpenAttachmentsDetailsPopup() throws InterruptedException {
		ccp.CCP_OpenAttachmentsDetailsPopup();
	}

	@Test(priority = 51, description = " Verify that attachment details get updated, when user clicks on 'Update' button, on 'Attachment Details' popup. ")
	public void CCP_UpdateAttachmentDetails() throws InterruptedException {
		ccp.CCP_UpdateAttachmentDetails();
	}

	@Test(priority = 52, description = " Verify that an attachment gets deleted, when user clicks on 'Update' button after clicking on 'Delete' icon, on 'Attachment Details' popup ")
	public void CCP_DeleteAnAttachment() throws InterruptedException {
		ccp.CCP_DeleteAnAttachment();
	}

	@Test(priority = 53, description = " Verify that accurate count of added attachments appear beside 'Attachments' tile's header, on 'Create Case' popup. ")
	public void CCP_VerifyTotalAttachmentsCount() throws InterruptedException {
		ccp.CCP_VerifyTotalAttachmentsCount();
	}

	@Test(priority = 53, description = " Verify that 'Create Case' popup opens up, when user clicks on 'Create Case' button, on 'Create Case' page. ")
	public void CCP_OpenCreateCasePopup() throws InterruptedException {
		ccp.CCP_OpenCreateCasePopup();
	}

	@Test(priority = 54, description = " Verify that 'Create & Perform Inspection' button converts into 'Create & Schedule Inspection' button, when user selects 'Schedule Verification Inspection' checkbox, on 'Create Case' popup.  ")
	public void CCP_VerifyCreateAndScheduleInspectionButton() throws InterruptedException {
		ccp.CCP_VerifyCreateAndScheduleInspectionButton();
	}

	@Test(priority = 55, description = " Verify that 'Next Inspection' section gets enabled, when user selects 'Schedule Verification Inspection' checkbox, on 'Create Case' popup.  ")
	public void CCP_VerifyNextInspectionSectionState() throws InterruptedException {
		ccp.CCP_VerifyNextInspectionSectionState();
	}

	@Test(priority = 56, description = " Verify that a case gets created, when user clicks on 'Create & Schedule Inspection' button after selecting the Assignees, 'Create Case' page.  ")
	public void CCP_VerifyCaseCreation() throws InterruptedException {
		ccp.CCP_VerifyCaseCreation();
	}

	@Test(priority = 57, description = "")
	public void CCP_CDP_CountVerifications() throws InterruptedException {
		ccp.CCP_CDP_CountVerifications();
	}

	@Test(priority = 58, description = "Case Creation With Multiple Violation Same Entity ")
	public void CCP_CaseCreationWithMultipleViolationSameEntity() throws InterruptedException {
		ccp.CCP_CaseCreationWithMultipleViolationSameEntity();
	}

	@Test(priority = 59, description = "")
	public void CCP_SearchCaseAndNavigatetoCDP() throws InterruptedException {
		ccp.CCP_SearchCaseAndNavigatetoCDP();
	}
	
	@Test(priority = 60,description = "Auto-193,194 | Verify that a notification is generated for the assignee when the user create a case on CCP")
	public void CreateCaseCaseAssigneeNotification() throws InterruptedException {
		CaseAssignmentUtility case_Assignment = new CaseAssignmentUtility(getDriver());
		Helper helper = new Helper(getDriver());
		case_Assignment.CaseAssignment_OpenEditAssignmentPopup();
		case_Assignment.editRule("Water", "Mark Shane","stageHosted1 User");
		case_Assignment.clickOnSave();
		ccp.CreateCase("Water","Contact",false);
		CDP_Utility cdp = new CDP_Utility(getDriver());
		UserManagementUtility user_mgm = new UserManagementUtility(getDriver());
		SmsAndEmailVerificationUtility smsemail = new SmsAndEmailVerificationUtility(getDriver());
		String caseId = cdp.getCaseId();
		String inspectionMessage = cdp.getMessageInfo(CDP_Utility.inspectionAssigneeMsg);
		String codeCaseMessage = cdp.getMessageInfo(CDP_Utility.codeCaseAssigneeMsg);
		user_mgm.openYopmailMail(PropertiesUtils.getPropertyValue("AgencyUsernameStage"));
		String actualInspectionMessage = (smsemail.getMailSubject(caseId)).split(":")[1];
		System.out.println(actualInspectionMessage);
		
		user_mgm.openYopmailMail(PropertiesUtils.getPropertyValue("markShaneMail"));
		String actualCaseAssigneeMessage = (smsemail.getMailSubject(caseId)).split(":")[1];
		System.out.println(actualCaseAssigneeMessage);
		
		SoftAssert assrt = new SoftAssert();
		assrt.assertEquals(actualInspectionMessage.trim(), inspectionMessage.trim());
		assrt.assertEquals(actualCaseAssigneeMessage.trim(), codeCaseMessage.trim());
		assrt.assertAll();
		
		helper.closeOtherTabs();
		
			
	}
	
	
	
	
	
	@Test(priority = 61,description = "Auto-195 | Verify that a Consolidated notification is generated for the assignee user and inspection assignee user when a user creates a case on CCP with same case assignee and inspection assignee")
	public void CreateCaseCosolidatedNotification() throws InterruptedException, MessagingException, IOException {
//		LoginTest();
		CaseAssignmentUtility case_Assignment = new CaseAssignmentUtility(getDriver());
		Helper helper = new Helper(getDriver());
		case_Assignment.CaseAssignment_OpenEditAssignmentPopup();
		case_Assignment.editRule("Waters", "testSqe Labs","testSqe Labs");
		case_Assignment.clickOnSave();	
		ccp.CreateCase("Waters","Contact",false);
		CDP_Utility cdp = new CDP_Utility(getDriver());	
		String inspectionMessage = cdp.getMessageInfo(CDP_Utility.inspectionAssigneeMsg);
		SmsAndEmailVerificationUtility smsMail = new SmsAndEmailVerificationUtility(getDriver());
		boolean actualInspectionMessage  = smsMail.composeGmailMessage(inspectionMessage,PropertiesUtils.getPropertyValue("userNameMail"),PropertiesUtils.getPropertyValue("passwordMail"),"[Gmail]/Spam");
		
		SoftAssert assrt = new SoftAssert();
		assrt.assertTrue(actualInspectionMessage);
		assrt.assertAll();
		
		// clean up
		
		helper.closeOtherTabs();
		case_Assignment.CaseAssignment_OpenEditAssignmentPopup();
		case_Assignment.editRule("Water", "Mark Shane","stageHosted1 User");
		case_Assignment.clickOnSave();
			
	}

}
