package TestCases;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;
import POM.LoginUtility;
import POM.TemplateManagementUtility;

public class TemplateManagement extends BrowsersInvoked {

	
	ITestResult result;
	TemplateManagementUtility templateManagement;
	
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets getDriver() for this thread
      
        templateManagement = new TemplateManagementUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the getDriver() for this thread
    }

	

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
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

	@Test(priority = 1, description = "Verify TemplateMangement sub tab is open after clicking on TemplateMangement sidebar under Agency setup.")
	public void templateMangement_PreRequisite() throws InterruptedException {

		// Template Management Prerequisite (Navigation)
		templateManagement.TemplateMangement_PreRequisite();

		// get email Template Tab text
		String emailTemplatesLabel = templateManagement.getEmailTemplateTab();

		// get text Template Tab text
		String textMessageTemplateLabel = templateManagement.getTextTemplateTab();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(emailTemplatesLabel, CRMConstants.EMAIL_TEMPLATE_LABEL);
		softAssert.assertEquals(textMessageTemplateLabel, CRMConstants.TEXT_MESSAGE_TEMPLATE_LABEL);
		softAssert.assertAll();

	}

	@Test(priority = 2, description = "Verify that user is able to open and close the '' popup after clicking the '' and '' buttons on '' and '' pages respectively")
	public void templateMangement_CloseandOpenCreateTemplatePOpup() throws InterruptedException {

		// open create Template pop up

		templateManagement.openCreateTemplatePopUp();

		// get title
		String crtTemplateHeader = templateManagement.getCrtTemplatePopupTitle();

		// close create Template pop up

		templateManagement.closeCreateTemplatePopUp();

		// get title
		int count = templateManagement.getCreateTemplateHeaderCount();
		Boolean check = count == 0;
		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(crtTemplateHeader, CRMConstants.CREATE_TEMPLATE_HEADER);
		softAssert.assertEquals(check, Boolean.TRUE);
		softAssert.assertAll();

	}

	@Test(priority = 3, description = "Verify that appropriate validation messages appears, on clicking the 'Save' button when no/ data exceeding the max limit is entered in fields, on 'Create Template' popup")
	public void templateMangement_VerifyValidationsOnCreateTemplatePOpup() throws InterruptedException, AWTException {

		// open create Template pop up
		templateManagement.openCreateTemplatePopUp();

		// click on save Template button
		templateManagement.clickOnSaveTemplate();

		// get Template name validation text
		String actualNameValidMsg = templateManagement.getTemplateNameValidationMsg();

		// get email subject line validation text
		String actualEmailSubLineValidMsg = templateManagement.getTemplateEmailSubValidationMsg();

		// get email body validation text
		String actualEmailBdyValidMsg = templateManagement.getEmailBodyvalidMsg();

		// set email sub line 151 random character String
		templateManagement.setEmailSubLineRndChar(151);

		// click on save Template button
		templateManagement.clickOnSaveTemplate();

		// get email subject line validation text
		String emailSubLineValidMsg = templateManagement.getTemplateEmailSubValidationMsg();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualNameValidMsg, CRMConstants.NAME_VALID_MSG);
		softAssert.assertEquals(actualEmailSubLineValidMsg, CRMConstants.EMAIL_SUBLINE_VALIDMSG);
		softAssert.assertEquals(actualEmailBdyValidMsg, CRMConstants.EMAIL_BODY_VALIDMSG);
		softAssert.assertEquals(actualEmailSubLineValidMsg, emailSubLineValidMsg);
		softAssert.assertAll();

	}

	@Test(priority = 4, description = "Verify that user is able to add/remove a single as well as multiple documents, on 'Create Template' popup")
	public void templateMangement_VerifyAdditionofMultipleDocTemplatePOpup() throws InterruptedException, AWTException {
		Helper helper = new Helper(getDriver());

		// add 1 template files
		templateManagement.addTemplateFile("Jellyfish_11zon.jpg");

		// add 2 template files
		templateManagement.addTemplateFile("Panda_11zon.jpg");

		// static wait applied
		helper.forcedWaitTime(2);

		// get added file count
		int filesCount = templateManagement.getAddedTemplateFileCount();

		// remove file
		templateManagement.clickOnRemovefilesIcon();

		// static wait applied
		helper.forcedWaitTime(2);

		// get added file count
		int filescountAfter = templateManagement.getAddedTemplateFileCount();

		// Test Data Added (add 1 template files)
		templateManagement.addTemplateFile("Jellyfish_11zon.jpg");

		// Assert
		Boolean filesCountCheck = filesCount == 2;
		Boolean filesAfterCountCheck = filescountAfter < filesCount;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(filesCountCheck, Boolean.TRUE);
		softAssert.assertEquals(filesAfterCountCheck, Boolean.TRUE);
		softAssert.assertAll();

	}

	public static String templateName;
	public static String rndSubLine;

	@Test(priority = 5, description = "Verify that 'Preview Email Template' popup opens up with appropriate data, when user clicks 'Preview' button, on 'Create Template' popup.")
	public void templateMangement_VerifyEmailPreviewPopDataAutoPopulated() throws InterruptedException, AWTException {

		// set template name
		templateName = RandomStrings.requiredCharacters(3) + "Template";
		templateManagement.setTemplateName(templateName);

		// set email sub line
		rndSubLine = RandomStrings.requiredCharacters(3) + "EmailSubjectLine";
		templateManagement.setTemplateEmailSubLine(rndSubLine);

		// switch to frame
		String templateMessgae = RandomStrings.requiredCharacters(10);
		String currentwindow = templateManagement.switchToFrame();

		// set Template body message
		templateManagement.setTemplateMessage(templateMessgae);

		// switch back to default content
		templateManagement.switchToWindow(currentwindow);

		// click include magic link check box
		templateManagement.clickOnMagicLinkCheckBox();

		// click on preview template
		templateManagement.clickOnPreviewTemp();

		// get preview template header
		String actualpreviewTempHeader = templateManagement.getTemplatePreviewHeader();

		// get preview template Message body
		String actualpreviewTempData = templateManagement.getTemplatePreviewMsgBody();

		// close preview view
		templateManagement.clickOnclosePreviewTemp();

		// Assert

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualpreviewTempData, templateMessgae);
		softAssert.assertEquals(actualpreviewTempHeader, CRMConstants.PREVIEW_TEMPLATE_HEADER);
		softAssert.assertAll();
	}

	public static String TemplateGridSubLine;
	public static String TemplateGridNameLbl;

	@Test(priority = 6, description = "New template gets added under 'Email templates' tab, when user clicks on 'Save' button after entering data in mandatory fields, on 'Create Template' popup.")
	public void templateMangement_VerifyTemplateAdditionOfTemplate() throws InterruptedException, AWTException {

		Helper helper = new Helper(getDriver());

		// click on save Template button
		templateManagement.clickOnSaveTemplate();
		helper.waitForCurserRunning(3);

		// get active template count
		int index = templateManagement.getActiveTemplateCount(4);

		TemplateGridSubLine = templateManagement.getTemplateGridSubLine(index + 1);
		TemplateGridNameLbl = templateManagement.getTempGridNameLbl(index);

		// click on more link text
		templateManagement.clickOnMoreLinkText(index);

		String TemplateGridRelatedDoc = templateManagement.getTempGridNameLbl(index + 2);
		String TemplateGridLastUpdated = templateManagement.getLastUpdatetext(index + 3);

		String user = templateManagement.getLoggedUser();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TemplateGridNameLbl, templateName);
		softAssert.assertEquals(TemplateGridSubLine.trim(), rndSubLine.trim());
		softAssert.assertEquals(
				TemplateGridRelatedDoc.contains((CRMConstants.DOCUMENT_JELLYFISH_11.replace(".jpg", ""))), true);
		softAssert.assertEquals(TemplateGridRelatedDoc.contains((CRMConstants.DOCUMENT_PANDA_11.replace(".jpg", ""))),
				true);
		softAssert.assertEquals(TemplateGridLastUpdated.contains(user), true);
		softAssert.assertAll();

	}

	@Test(priority = 7, enabled = true, description = "Verify that respective 'Edit Template Name' popup opens up, when user clicks on 'Edit' icon of any template and able to edit template on 'Template Management' page.")
	public void TemplateMangement_VerifyEditTheTemplate() throws InterruptedException, AWTException {

		int index = templateManagement.getActiveTemplateCount(0);

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		helper.scrollIntoView(By.xpath(templateManagement.GetTemplateEditButtonXPath(index)));

		String actualTemplateName = "Edit " + templateManagement.getTempGridNameLbl(index - 4);

		templateManagement.clickOnEditTemplate(index);

		String editTemplateHeader = templateManagement.getEditTemplatePopHeader();

		Boolean templateNameStatus = templateManagement.checkStatusTemplateNameField();

		// set email sub line
		rndSubLine = RandomStrings.requiredCharacters(3) + "EmailSubjectLine";
		templateManagement.setTemplateEmailSubLine(rndSubLine);

		// click on save Template button
		templateManagement.clickOnSaveTemplate();
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(4);

		String templateGridSubLine = templateManagement.getTemplateGridSubLine(index - 3);

		// Assert

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(templateGridSubLine.trim(), rndSubLine.trim());
		softAssert.assertEquals(templateNameStatus, Boolean.FALSE);
		softAssert.assertEquals(actualTemplateName, editTemplateHeader);
		softAssert.assertAll();

	}

	@Test(priority = 8, description = "Verify that an error message appears & Template does not get created, when user clicks on 'Save' button, after entering existing data in 'Name' field, on 'Create Template' popup.")
	public void templateMangement_VerifyErrorMessgeOnAdditionOfExistingTemplate()
			throws InterruptedException, AWTException {
		// templateManagement.TemplateMangement_VerifyErrorMessgeOnAdditionOfExistingTemplate();

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);

		// get existing template form grid
		int index = templateManagement.getActiveTemplateCount(0);
		String existingTemplate = templateManagement.getTempGridNameLbl(index - 4);

		// add exiting template
		CRMCommonMethods crm = new CRMCommonMethods(getDriver());

		crm.addNewTemplate(existingTemplate);

		// get error message while creating existing template
		String expectedMsg = templateManagement.getExistingTemplateError();

		// click on cancel button
		templateManagement.clickOnCancleButton();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CRMConstants.EXISTING_TEMPLATE_ERROR, expectedMsg);
		softAssert.assertAll();
	}

	@Test(priority = 9, description = "Verify that user able to activate/deactivate the template on 'Email Template' Page")
	public void TemplateMangement_VerifyActivateAndDeActivateTemplate() throws InterruptedException, AWTException {

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);

		// get existing template form grid
		int index = templateManagement.getActiveTemplateCount(0);
		String activatedTemplate = templateManagement.getTempGridNameLbl(index);

		// get inactive template count
		int inactiveTemplatecountBefore = templateManagement.getInactiveTemplateCount();

		// Expected Count
		int expectedInactiveCount = inactiveTemplatecountBefore + 1;

		// edit the template
		templateManagement.clickOnEditTemplate(index);

		// click on inactive toggle button on pop up
		helper.forcedWaitTime(4);
		templateManagement.clickOnIactiveToggle();

		// Save the template
		helper.forcedWaitTime(2);
		templateManagement.clickOnSaveTemplate();
		helper.waitForCurserRunning(7);

		// get inactive template count
		int inactiveTemplatecountAfter = templateManagement.getInactiveTemplateCount();

		// get Inactive Template

		// to be checked Aniket
		// find no of inactive templates present on current page
		By inactiveTempCountPerPage = By.xpath("//div[@class='rt-tr-group']");
		int inactiveTempPerPage = helper.findElementsSize(inactiveTempCountPerPage);

		// Getting name of last inactive temp present on particular page

		String lastInactiveTempXpath = templateManagement.getLastInactiveXpath(inactiveTempPerPage);

		String lastInactiveTempName = helper.getTextByJSExecutor(By.xpath(lastInactiveTempXpath));
		System.out.println(lastInactiveTempName);

		int actualCount = inactiveTemplatecountAfter * 5;
		String inactivatedTemplate = lastInactiveTempName;

		// get active template count
		int index2 = templateManagement.getActiveTemplateCount(0);
		int expectedActivecount = index2 + 1;

		// edit inactive template

		templateManagement.editInactiveTemplate(actualCount);

		// click on active toggle button
		helper.forcedWaitTime(4);
		templateManagement.clickOnActiveToggle();

		// Save the template
		helper.forcedWaitTime(2);
		templateManagement.clickOnSaveTemplate();
		helper.waitForCurserRunning(7);

		// get existing template form grid
		int indexActive = templateManagement.getActiveTemplateCount(0);
		String activatedTemplateNew = templateManagement.getTempGridNameLbl(index - 4);

		// Assert

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualCount, expectedInactiveCount);
		softAssert.assertEquals(activatedTemplate, inactivatedTemplate);
		softAssert.assertEquals(inactivatedTemplate, activatedTemplateNew);
		softAssert.assertEquals(indexActive, expectedActivecount);
		softAssert.assertAll();
	}

	@Test(priority = 10, description = "Verify Default Esclated Notices Email Template 'Escalated Notice Generated' and 'Escalated Notice Reviewed by Supervisor' should present on Email Template Page.")
	public void TemplateMangement_VerifyDefaultEsclatedNoticeTemplate() throws InterruptedException, AWTException {
		Helper helper = new Helper(getDriver());
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(TemplateManagementUtility.TempalteName, "Escalated Notice Generated")));
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(TemplateManagementUtility.TempalteName,
				"Escalated Notice Reviewed by Supervisor")));

		Boolean EsclatedNoticesTemplate1 = helper.elementIsDisplayed(
				By.xpath(helper.stringFormat(TemplateManagementUtility.TempalteName, "Escalated Notice Generated")));
		Boolean EsclatedNoticesTemplate2 = helper.elementIsDisplayed(By.xpath(helper
				.stringFormat(TemplateManagementUtility.TempalteName, "Escalated Notice Reviewed by Supervisor")));

		Assert.assertTrue(EsclatedNoticesTemplate1, "Escalated Notice Generated template is not Present.");
		Assert.assertTrue(EsclatedNoticesTemplate2, "Escalated Notice Reviewed by Supervisor template is not Present.");

	}

	@Test(priority = 11, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Generated' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeGeneratedTemplate() throws InterruptedException, AWTException {
		// edit Escalated Notice Generated template
		templateManagement.editCustomTemplate("Escalated Notice Generated");

		// get subject line text through value attribute
		String subjLine = templateManagement.getSubjectLineValue();

		// switch to frame
		String currentWindow = templateManagement.switchToFrame();

		// get email body message
		String emailBodyMsz = templateManagement.getEmailBodyMsg();

		// switch to default content/ main frame
		templateManagement.switchToWindow(currentWindow);

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(4);

		// Assert
		Assert.assertEquals(subjLine.trim(), "Escalated Notice Generated",
				"Subject Line is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz1")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz2")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");

		// click on cancel button
		templateManagement.clickOnCancleButton();

	}

	@Test(priority = 12, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Reviewed by Supervisor' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeSupervisorTemplate() throws InterruptedException, AWTException {

		// edit Escalated Notice Generated template
		templateManagement.editCustomTemplate("Escalated Notice Reviewed by Supervisor");

		// get subject line text through value attribute
		String subjLine = templateManagement.getSubjectLineValue();

		// switch to frame
		String currentWindow = templateManagement.switchToFrame();

		// get email body message
		String emailBodyMsz = templateManagement.getEmailBodyMsg();

		// switch to default content/ main frame
		templateManagement.switchToWindow(currentWindow);

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(4);

		// Assert
		Assert.assertEquals(subjLine.trim(), "Escalated Notice Reviewed by Supervisor",
				"Subject Line is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMszSupervisor1")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMszSupervisor2")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");

		// click on cancel button
		templateManagement.clickOnCancleButton();
	}

	@Test(priority = 13, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Edited' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeEditedTemplate() throws InterruptedException, AWTException {

		// edit Escalated Notice Generated template
		templateManagement.editCustomTemplate("Escalated Notice Edited");

		// get subject line text through value attribute
		String subjLine = templateManagement.getSubjectLineValue();

		// switch to frame
		String currentWindow = templateManagement.switchToFrame();

		// get email body message
		String emailBodyMsz = templateManagement.getEmailBodyMsg();

		// switch to default content/ main frame
		templateManagement.switchToWindow(currentWindow);

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(4);

		// Assert

		Assert.assertEquals(subjLine, "Escalated Notice Edited", "Subject Line is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz1")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedNoticeEditedBodyMsz2")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(emailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");

		// click on cancel button
		templateManagement.clickOnCancleButton();
	}

	@Test(priority = 14, description = "Verify that the user is able to see the case message default email templates on the 'Email Template' Page")
	public void TemplateMangement_VerifyDefaultCaseMessagesTemplate() throws InterruptedException, AWTException {
		List<String> templateNames = templateManagement.getElementTextList(templateManagement.emailTemplateNames);
		String myList2 = PropertiesUtils.getPropertyValue("caseMessagesEmailTemplates");
        List<String> expectedTempList = Arrays.asList(myList2.split(","));
        
        Assert.assertTrue(templateNames.containsAll(expectedTempList));
        
	}
	
	
			

}
