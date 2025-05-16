package POM;

import BrowsersBase.BrowsersInvoked;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.twilio.twiml.voice.Prompt.For;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class NotificationManagementUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;

	public NotificationManagementUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
	}

	public static String notificationMangementSideBar = "//label[text()='Notification Management']";
	public static String caseNavigation = "//a[text()='Cases']";
	public static String activeNotifdetails = "//h2[contains(text(),'Active')]";
	public static String inActiveNotifdetails = "//h2[contains(text(),'Inactive')]";
	public static String notificationHeaderLbl = "//div[text()='Notifications']";
	public static String createNotificationPopupHeader = "//div[@class='modal-header']//h1";
	public static String createNotificationbtn = "//button[text()='Create Notification']";
	public static String createNotifPopUpbtn = "(//h1[text()='Create Notification']//parent::div//button)[2]";
	public static String cancelNotifPopUpbtn = "(//h1[text()='Create Notification']//parent::div//button)[1]";
	public static String crtNotificationLableName = "//input[@name='label']";
	public static String crtNotifDescription = "//input[@name='description']";
	public static String crtNotifPagingNxt = "(//div[@class='pagination-bottom']//button)[2]";
	public static String crtNotifGridPageCount = "//div[@class='pagination-bottom']//span";

	public static String activeNotifications = "//h2[contains(text(),'Active')]";
	public static String inActiveNotifications = "//h2[contains(text(),'Inactive')]";
	public static String editNotifSaveBtn = "//button[text()='Save']";
	public static String crtNotifInputLabelName = "//h1[text()='Create Notification']//ancestor::div[@class='modal-content']//input[@name='label']";
	public static String crtNotifActionDropdown = "//h1[text()='Create Notification']//ancestor::div[@class='modal-content']//span[@class='Select-arrow']";
	public static String crtNotifActiveToggle = "//button[text()='Active']";
	public static String crtNotifInactiveToggle = "//button[text()='Inactive']";
	public static String crtNotifInputDescription = "//h1[text()='Create Notification']//ancestor::div[@class='modal-content']//input[@name='description']";
	public static String crtNotifLableNameValidMsg = "//input[@name='label']//parent::div//following-sibling::span";
	public static String crtNotifGlobalValidMsg = "(//div[@class='modal-body']/div)[1]";

	public static String crtAddRuleBtn = "//button[text()='Add Rule']";
	public static String crtCreateRule = "(//h1[text()='Create Rule']//parent::div//following-sibling::div//button)[2]";
	public static String crtCancelCrtRule = "(//h1[text()='Create Rule']//parent::div//following-sibling::div//button)[1]";
	public static String crtRuleGolbalValidMsg = "(//div[@class='modal-body']/div)[3]";
	public static String crtRuleAddCriteria = "//a[text()='Add Criteria']";
	public static String crtRuleCriteriaValid = "//div[@class='criteria-list']//span[@class='field__error']";
	public static String crtRuleAddDelivery = "//a[text()='Add Delivery option']";
	public static String crtRuleAddDeliveryValid = "//div[@class='delivery-options']//span[@class='field__error']";

	public static String actionSelectArrow = "//span[@class='Select-arrow-zone']";
	public static String operatorSelectArrow = "//label[@for='attribute']/following::div[@class='Select-placeholder'][1]";
	public static String attributeSelectArrow = "(//label[contains(text(),'Select Option')])[1]";
	public static String valueSelectArrow = "//div[@class='Select-arrow-zone']//span[@class='Select-arrow']";
	public static String sendOptionSelectArrow = "//label[@title='Send Options']//parent::div//parent::div//span[@class='Select-arrow']";
	public static String useEmialTemplateSelectArrow = "//label[@title='Use Email Template']//parent::div//parent::div//span[@class='Select-arrow']";
	public static String recipientAssignee = "//label[@title='Recipient']//parent::div//parent::div//span[@class='Select-arrow']";
	public static String actionSelectArrow1 = "(//label[@title='Action']//parent::div//parent::div//span[@class='Select-arrow'])[1]";
	public static String operatorSelectArrow1 = "(//label[@title='Operator']//parent::div//parent::div//span[@class='Select-arrow'])[1]";
	public static String attributeSelectArrow1 = "(//label[contains(text(),'Select Option')])[1]";
	public static String valueSelectArrow1 = "(//label[contains(text(),'Select Option')])[1]";
	public static String sendOptionSelectArrow1 = "(//label[@title='Send Options']//parent::div//parent::div//span[@class='Select-arrow'])[1]";
	public static String useEmialTemplateSelectArrow1 = "(//label[@title='Use Email Template']//parent::div//parent::div//span[@class='Select-arrow'])[1]";
	public static String recipentArrow2 = "(//label[@title='Recipient']//parent::div//parent::div//span[@class='Select-arrow'])[2]";

	public static String actionSelectArrow2 = "(//label[@title='Action']//parent::div//parent::div//span[@class='Select-arrow'])[2]";
	public static String operatorSelectArrow2 = "(//label[@title='Operator']//parent::div//parent::div//span[@class='Select-arrow'])[2]";
	public static String attributeSelectArrow2 = "(//label[contains(text(),'Select Option')])[1]";
	public static String valueSelectArrow2 = "(//label[contains(text(),'Select Option')])[1]";
	public static String sendOptionSelectArrow2 = "(//label[@title='Send Options']//parent::div//parent::div//span[@class='Select-arrow'])[2]";
	public static String useEmialTemplateSelectArrow2 = "(//label[@title='Use Email Template']//parent::div//parent::div//span[@class='Select-arrow'])[2]";

	public static String selectAttribute = "//*[span='Submission Category']";
	public static String selectOperator = "(//*[@aria-label='Equals'])";
	public static String selectValue = "(//li[@class='multi']//input[@type='checkbox'])[1]";
	public static String selectCatValue2 = "(//li[@class='multi']//input[@type='checkbox'])[2]";
	public static String sendToOption = "//div[@class='Select-menu-outer']//div[@aria-label='Send To']";
	public static String selectUseEmailTemp = "//div[@class='Select-menu-outer']//div[@aria-label='Submission Created']";
	public static String selectUseEmailTempSubClose = "//div[@class='Select-menu-outer']//div[@aria-label='Submission Closed']";
	public static String recipientCollaborator = "div.Select-menu-outer div[aria-label='Collaborator/s']";
	public static String selectedAttribute = "//label[normalize-space()='Submission Category']";
	public static String selectedValue = "(//input[@name='value']//parent::div//span)[1]";
	public static String selectActionValue = "//div[@class='Select-menu-outer']//div[@aria-label='Submission Received']";
	public static String addedRuleCriteria = "(//div[@class='sortable-table__body__td'])[1]";

	public static String selectAttribute1 = "(//div[@id='attribute'])[1]//*[span='Case Assignee']";
	public static String selectOperator1 = "//div[@class='Select-menu-outer']//div[@aria-label='Equals']";
	public static String selectValu1 = "//span[normalize-space()='Logged In User']";

	public static String sendToOption1 = "//div[@class='Select-menu-outer']//div[@aria-label='Send To']";
	public static String selectUseEmailTemp1 = "//div[@class='Select-menu-outer']//div[@aria-label='Submission Created']";

	public static String selectAttribute2 = "(//div[@id='attribute'])[2]//*[span='Case Notification']";
	public static String selectOperator2 = "//div[@class='Select-menu-outer']//div[@aria-label='Equals']";
	public static String selectValu2 = "(//div[@id='value'])[2]//*[span='Inspection Assigned']";

	public static String sendToOption2 = "//div[@class='Select-menu-outer']//div[@aria-label='Send To']";
	public static String selectUseEmailTemp2 = "//div[@class='Select-menu-outer']//div[@aria-label='Notice Issued']";
	public static String reciptentOption2 = "div.Select-menu-outer div[aria-label='Collaborator/s']";
	public static String selectValOption = "(//div[@id='value']//ul//li)[%s]";
	public static String select_Operator = "(//*[@aria-label='%s'])";
	public static By CaseNavigation = By.xpath(caseNavigation);
	public static By SelectCatValue2 = By.xpath(selectCatValue2);
	public static By NotificationMangementSideBar = By.xpath(notificationMangementSideBar);
	public static By NotificationHeaderLbl = By.xpath(notificationHeaderLbl);
	public static By CreateNotificationbtn = By.xpath(createNotificationbtn);
	public static By CreateNotificationPopupHeader = By.xpath(createNotificationPopupHeader);
	public static By EditNotificationPopupHeader = By.xpath(createNotificationPopupHeader);
	public static By CancelNotifPopUpbtn = By.xpath(cancelNotifPopUpbtn);
	public static By CreateNotifPopUpbtn = By.xpath(createNotifPopUpbtn);
	public static By CrtNotifLableNameValidMsg = By.xpath(crtNotifLableNameValidMsg);
	public static By CrtNotifGlobalValidMsg = By.xpath(crtNotifGlobalValidMsg);
	public static By ActiveNotifdetails = By.xpath(activeNotifdetails);
	public static By InActiveNotifdetails = By.xpath(inActiveNotifdetails);
	public static By CrtAddRuleBtn = By.xpath(crtAddRuleBtn);
	public static By CrtRuleAddCriteria = By.xpath(crtRuleAddCriteria);
	public static By CrtCreateRule = By.xpath(crtCreateRule);
	public static By CrtRuleGolbalValidMsg = By.xpath(crtRuleGolbalValidMsg);
	public static By CrtRuleCriteriaValid = By.xpath(crtRuleCriteriaValid);
	public static By CrtRuleAddDelivery = By.xpath(crtRuleAddDelivery);
	public static By CrtRuleAddDeliveryValid = By.xpath(crtRuleAddDeliveryValid);
	public static By CrtCancelCrtRule = By.xpath(crtCancelCrtRule);

	public static By OperatorSelectArrow = By.xpath(operatorSelectArrow);
	public static By AttributeSelectArrow = By.xpath(attributeSelectArrow);
	public static By ValueSelectArrow = By.xpath(valueSelectArrow);
	public static By SendOptionSelectArrow = By.xpath(sendOptionSelectArrow);
	public static By UseEmialTemplateSelectArrow = By.xpath(useEmialTemplateSelectArrow);

	public static By SelectAttribute = By.xpath(selectAttribute);
	public static By SelectOperator = By.xpath(selectOperator);
	public static By SelectValue = By.xpath(selectValue);
	public static By SendToOption = By.xpath(sendToOption);
	public static By SelectUseEmailTemp = By.xpath(selectUseEmailTemp);
	public static By SelectUseEmailTempSubClose = By.xpath(selectUseEmailTempSubClose);
	public static By RecipientAssignee = By.xpath(recipientAssignee);
	public static By RecipientCollaborator = By.cssSelector(recipientCollaborator);
	public static By SelectedAttribute = By.xpath(selectedAttribute);
	public static By SelectedValue = By.xpath(selectedValue);
	public static By AddedRuleCriteria = By.xpath(addedRuleCriteria);

	public static By CrtNotificationLableName = By.xpath(crtNotificationLableName);
	public static By CrtNotifActionSelectArrow = By.xpath(actionSelectArrow);
	public static By CrtNotifselectActionValue = By.xpath(selectActionValue);
	public static By CrtNotifDescription = By.xpath(crtNotifDescription);
	public static By CrtNotifPagingNxt = By.xpath(crtNotifPagingNxt);
	public static By CrtNotifGridPageCount = By.xpath(crtNotifGridPageCount);
	public static By CrtNotifInactiveToggle = By.xpath(crtNotifInactiveToggle);
	public static By EditNotifSaveBtn = By.xpath(editNotifSaveBtn);
	public static By CrtNotifActiveToggle = By.xpath(crtNotifActiveToggle);
	public static By ActionSelectArrow1 = By.xpath(actionSelectArrow1);

	public static By OperatorSelectArrow1 = By.xpath(operatorSelectArrow1);
	public static By AttributeSelectArrow1 = By.xpath(attributeSelectArrow1);
	public static By ValueSelectArrow1 = By.xpath(valueSelectArrow1);
	public static By SendOptionSelectArrow1 = By.xpath(sendOptionSelectArrow1);
	public static By UseEmialTemplateSelectArrow1 = By.xpath(useEmialTemplateSelectArrow1);

	public static By ActionSelectArrow2 = By.xpath(actionSelectArrow2);
	public static By OperatorSelectArrow2 = By.xpath(operatorSelectArrow2);
	public static By AttributeSelectArrow2 = By.xpath(attributeSelectArrow2);
	public static By ValueSelectArrow2 = By.xpath(valueSelectArrow2);
	public static By SendOptionSelectArrow2 = By.xpath(sendOptionSelectArrow2);
	public static By UseEmialTemplateSelectArrow2 = By.xpath(useEmialTemplateSelectArrow2);
	public static String sendDonotSendOption = "//div[@class='Select-menu-outer']//div[@aria-label='%s']";
	public static String recipientOptions = "div.Select-menu-outer div[aria-label='%s']";
	public static String emailTemplateOptions = "//div[@class='Select-menu-outer']//div[@aria-label='%s']";
	public static String notificationName = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'][text()='%s'])";
	public static String SelectAttributeOption = "//*[span='%s']";
	public static String SelectValueOption = "//ul[@class='picklist-with-handler__picklist-section multi-picklist']//label[@for='%s']";
	public static String SelectValueOptions = "(//ul[@class='picklist-with-handler__picklist-section multi-picklist']//label)";
	public static String editActiveNotificationBtn = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'][text()='%s'])//ancestor::div[@class='rt-tr-group']//button";

	public void activeInactiveNotification(String name) throws InterruptedException {
		waitUntilElementIsVisible(CrtNotifGridPageCount);

		waitForElementIsInteractable(By.xpath(stringFormat(editActiveNotificationBtn, name)));
		clickByJsExecuter(By.xpath(stringFormat(editActiveNotificationBtn, name)));
		waitUntilElementIsVisible(EditNotificationPopupHeader);
		forcedWaitTime(3);
		waitUntilElementIsVisible(CrtNotifInactiveToggle);
		waitForElementIsInteractable(CrtNotifInactiveToggle);
		clickOn(CrtNotifInactiveToggle);
		forcedWaitTime(2);
		waitUntilElementIsVisible(EditNotifSaveBtn);
		scrollIntoView(EditNotifSaveBtn);
		waitForElementIsInteractable(EditNotifSaveBtn);
		clickOn(EditNotifSaveBtn);
		waitForCurserRunning(5);

	}

	public void SelectSendOtions(String Option) {
		waitForElementIsInteractable(By.xpath(sendOptionSelectArrow1));
		clickOn(By.xpath(sendOptionSelectArrow1));
		waitForElementIsInteractable(By.xpath(stringFormat(sendDonotSendOption, Option)));
		clickOn(By.xpath(stringFormat(sendDonotSendOption, Option)));
	}

	// Select the Option from Recipient
	public void SelectRecipient(String Option) {
		waitForElementIsInteractable(By.cssSelector(stringFormat(recipientOptions, Option)));
		clickOn(By.cssSelector(stringFormat(recipientOptions, Option)));
	}

	public void ClickonRecipient() {
		waitForElementIsInteractable(RecipientAssignee);
		scrollIntoView(RecipientAssignee);
		clickOn(RecipientAssignee);
	}

	public void ClickonEmailTemplate() {
		waitForElementIsInteractable(UseEmialTemplateSelectArrow);
		scrollIntoView(UseEmialTemplateSelectArrow);
		clickOn(UseEmialTemplateSelectArrow);
	}

	// check either option is present or not for Recipient
	public Boolean checkRecipientOptions(String Option) {
		waitForElementIsInteractable(RecipientAssignee);
		scrollIntoView(RecipientAssignee);
		clickOn(RecipientAssignee);
		waitUntilElementIsVisible(By.cssSelector(stringFormat(recipientOptions, Option)));
		scrollIntoView(By.cssSelector(stringFormat(recipientOptions, Option)));
		Boolean check = elementIsDisplayed(By.cssSelector(stringFormat(recipientOptions, Option)));
		return check;
	}

	// Select the Option from Email Template
	public void SelectEmailTemplate(String Option) {
		waitForElementIsInteractable(By.xpath(stringFormat(emailTemplateOptions, Option)));
		clickOn(By.xpath(stringFormat(emailTemplateOptions, Option)));

	}

	// check either option is present or not for Email Template
	public Boolean checkEmailTemplateOptions(String Option) {
		waitForElementIsInteractable(UseEmialTemplateSelectArrow);
		clickOn(UseEmialTemplateSelectArrow);
		waitUntilElementIsVisible(By.xpath(stringFormat(emailTemplateOptions, Option)));
		scrollIntoView(By.xpath(stringFormat(emailTemplateOptions, Option)));
		Boolean check = elementIsDisplayed(By.xpath(stringFormat(emailTemplateOptions, Option)));
		return check;
	}

	// Click on the 'Create Notification' button on 'Create Notification' Pop up
	public void ClickonCreateNotificationPopBtn() throws InterruptedException {
		waitUntilElementIsVisible(CreateNotifPopUpbtn);
		scrollIntoView(CreateNotifPopUpbtn);
		waitForElementIsInteractable(CreateNotifPopUpbtn);
		clickOn(CreateNotifPopUpbtn);
		waitUntilElementInvisibleLocated(CreateNotifPopUpbtn);
		waitUntilElementIsVisible(ActiveNotifdetails);
		forcedWaitTime(4);
		scrollIntoView(ActiveNotifdetails);
	}

	// click on Create Rule Button
	public void ClickonCreateRuleBtn() throws InterruptedException {
		scrollIntoView(CrtCreateRule);
		waitForElementIsInteractable(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		waitForCurserRunning(5);
	}

	public void LoginAdmin() throws InterruptedException {
		log.LoginAgency();

	}

	public static String GetCrtRuleValidationbyIndexXPath(int index) {
		String xPath = "(//h2[text()='Define Criteria']//ancestor::div[@class='fields-container tile']//span[@class='field__error'])["
				+ index + "]";
		return xPath;
	}

	public static String GetCrtRuleValidationXPath(int index) {
		String xPath = "//h2[text()='Define Criteria']//ancestor::div[@class='fields-container tile']//span[@class='field__error']";
		return xPath;
	}

	public static String GetActiveNotiificationGridData(int index) {
		String xPath = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]";
		return xPath;
	}

	public static String GetActiveNotiificationEditIcon(int index) {
		String xPath = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td']//button)["
				+ index + "]";
		return xPath;
	}

	public static String GetInactiveNotiificationGridData(int index) {
		String xPath = "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]";
		return xPath;
	}

	public static String GetInactiveNotiificationEditIcon(int index) {
		String xPath = "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td']//button)["
				+ index + "]";
		return xPath;
	}

	public static String SelectCustomeActionValue(String value) {
		String xPath = "//div[@class='Select-menu-outer']//div[@aria-label='" + value + "']";
		// //div[@class='Select-menu-outer']//div[@aria-label='Code Case Management']
		// Code Case Management
		return xPath;
	}

	// Global Variables

	public static String ActualnotificationHeader;
	public static String expectednotificationHeader = "Notifications";

	public static String ActualCrtNotifPopupHeader;
	public static String expectedCrtNotifPopupHeader = "Create Notification";
	public static Boolean PopupClosed;

	public static String actualNotifGlobalValidMsg;
	public static String expectedNotifGlobalValidMsg = "At least one rule should be present.";

	public static String actualLabelNameValid;
	public static String expectedLableNameValid = "The Name is required.";

	public static int actualDefaultActiveNotifCount;
	public static int expectedDefaultActiveNotifCount = 5;

	public static int actualDefaultInactiveNotifCount;
	public static int expedtedDefaultInactiveNotifCount = 4;

	public static String selectedAttriVal;

	public static String selectedCatVal;
	public static String AddedRuleDesc;
	public static int InactiveNotifCount;
	public static String expectedAddRuleGlobalValidation = "At least one delivery option should be present.";
	public static String actualAddRuleGlobalValidation;

	public static String expectedAddRuleAttributValidation = "The Attribute is required.";
	public static String actualAddRuleAttributValidation;

	public static String expectedAddRuleOperatorValidation = "The Operator is required.";
	public static String actualAddRuleOperatorValidation;

	public static String expectedAddRuleValueValidation = "The Value is required.";
	public static String actualAddRuleValueValidation;

	public static String expectedAddRuleSendOptValidation = "The Send Options is required.";
	public static String actualAddRuleSendOptValidation;
	public static String notificationnLabelName;
	public static String notificationnDescription;

	public static int activeNotifCount;
	public static int inActiveNotifCount;
	public static String actualNotifLable;
	public static String actualNotifdesc;
	public static int gridIndex;
	public static String InactivatedNotif;
	public static String ActivatNotif;
	public static int InactiveNotifCountBefore;
	public static int InactiveNotifCountAfter;

	public void clickonCreateNotificationButton() throws InterruptedException {

		waitUntilElementIsVisible(CreateNotificationbtn);
		scrollIntoView(CreateNotificationbtn);
		waitForElementIsInteractable(CreateNotificationbtn);
		clickByJsExecuter(CreateNotificationbtn);

	}

	public void ClickOnAddRuleBtn() throws InterruptedException {
		forcedWaitTime(2);
		waitUntilElementIsVisible(CrtAddRuleBtn);
		scrollIntoView(CrtAddRuleBtn);
		waitForElementIsInteractable(CrtAddRuleBtn);
		clickOn(CrtAddRuleBtn);
	}

	public void ClickOnAddDeliveryOtpion() {
		waitUntilElementIsVisible(CrtRuleAddDelivery);
		scrollIntoView(CrtRuleAddDelivery);
		waitForElementIsInteractable(CrtRuleAddDelivery);
		clickByJsExecuter(CrtRuleAddDelivery);
	}

	public void SelectAttribut(String Option) {
		waitUntilElementIsVisible(AttributeSelectArrow);
		waitForElementIsInteractable(AttributeSelectArrow);
		clickOn(AttributeSelectArrow);
		waitForElementIsInteractable(By.xpath(stringFormat(SelectAttributeOption, Option)));
		clickOn(By.xpath(stringFormat(SelectAttributeOption, Option)));
	}

	public void SelectRuleOperator() {
		waitForElementIsInteractable(OperatorSelectArrow);
		clickOn(OperatorSelectArrow);
		waitForElementIsInteractable(SelectOperator);
		clickOn(SelectOperator);
	}

	public void SelectRuleOperator(String operator) throws InterruptedException {
		forcedWaitTime(1);
		waitForElementIsInteractable(OperatorSelectArrow);
		clickOn(OperatorSelectArrow);
		waitForElementIsInteractable(By.xpath(stringFormat(select_Operator, operator)));
		clickOn(By.xpath(stringFormat(select_Operator, operator)));

	}

	public void SelectRuleValue(Boolean checkbox, String Option) {
		if (!checkbox) {
			waitUntilElementIsVisible(By.xpath(stringFormat(selectValOption, Option)));
			waitForElementIsInteractable(By.xpath(stringFormat(selectValOption, Option)));
			clickByJsExecuter(By.xpath(stringFormat(selectValOption, Option)));
		} else {
			waitUntilElementIsVisible(By.xpath(stringFormat(SelectValueOption, Option)));
			waitForElementIsInteractable(By.xpath(stringFormat(SelectValueOption, Option)));
			clickByJsExecuter(By.xpath(stringFormat(SelectValueOption, Option)));
		}
	}

	public void clickOnValueDrp() throws InterruptedException {
		waitForElementIsInteractable(
				By.xpath("//div[@class='dropdown__selector__selected']//label[text()='Select Option']"));
		clickOn(By.xpath("//div[@class='dropdown__selector__selected']//label[text()='Select Option']"));
		forcedWaitTime(2);
	}

	public List<String> checkRuleValue() {
		waitForElementIsInteractable(ValueSelectArrow);
		clickOn(ValueSelectArrow);
		waitUntilElementIsVisible(By.xpath(SelectValueOptions));
		List<String> valueOptions = new ArrayList<>();
		driver.findElements(By.xpath(SelectValueOptions)).stream().forEach(x -> valueOptions.add(x.getText()));
		return valueOptions;
	}

	public void AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount() throws InterruptedException {
		waitUntilElementIsVisible(CaseNavigation);
		scrollIntoView(CaseNavigation);
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToNotificationMangement();
		ActualnotificationHeader = getTextElement(NotificationHeaderLbl);
		actualDefaultActiveNotifCount = Integer.parseInt(getTextElement(ActiveNotifdetails).split(" ")[0]);
		actualDefaultInactiveNotifCount = Integer.parseInt(getTextElement(InActiveNotifdetails).split(" ")[0]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualnotificationHeader, expectednotificationHeader);
		softAssert.assertAll();

	}

	public void AgencySetup_CreateNotificationPopCloseOpenAndValidations() throws InterruptedException {

		scrollIntoView(CreateNotificationbtn);
		waitForElementIsInteractable(CreateNotificationbtn);
		clickByJsExecuter(CreateNotificationbtn);
		waitUntilElementIsVisible(CreateNotificationPopupHeader);
		ActualCrtNotifPopupHeader = getTextElement(CreateNotificationPopupHeader);
		scrollIntoView(CancelNotifPopUpbtn);
		waitForElementIsInteractable(CancelNotifPopUpbtn);
		clickByJsExecuter(CancelNotifPopUpbtn);
		waitUntilElementInvisibleLocated(CancelNotifPopUpbtn);
		waitUntilElementIsVisible(By.xpath(notificationHeaderLbl));
		PopupClosed = driver.findElement(By.xpath(notificationHeaderLbl)).isDisplayed();
		scrollIntoView(CreateNotificationbtn);
		waitForElementIsInteractable(CreateNotificationbtn);
		clickByJsExecuter(CreateNotificationbtn);
		waitUntilElementIsVisible(CreateNotifPopUpbtn);
		waitForElementIsInteractable(CreateNotifPopUpbtn);
		clickByJsExecuter(CreateNotifPopUpbtn);
		waitUntilElementIsVisible(CrtNotifLableNameValidMsg);
		actualLabelNameValid = getTextElement(CrtNotifLableNameValidMsg);
		actualNotifGlobalValidMsg = getTextElement(CrtNotifGlobalValidMsg);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualCrtNotifPopupHeader, expectedCrtNotifPopupHeader);
		softAssert.assertEquals(PopupClosed, Boolean.TRUE);
		softAssert.assertEquals(actualLabelNameValid, expectedLableNameValid);
		softAssert.assertEquals(actualNotifGlobalValidMsg, expectedNotifGlobalValidMsg);
		softAssert.assertAll();

	}

	public void AgencySetup_CreateNotificationAddRulePopupValidations() throws InterruptedException {

		waitUntilElementIsVisible(CrtAddRuleBtn);
		scrollIntoView(CrtAddRuleBtn);
		Thread.sleep(2000);
		waitForElementIsInteractable(CrtAddRuleBtn);
		clickByJsExecuter(CrtAddRuleBtn);

		waitUntilElementIsVisible(CrtRuleAddCriteria);
		scrollIntoView(CrtRuleAddCriteria);
		waitForElementIsInteractable(CrtRuleAddCriteria);
		clickByJsExecuter(CrtRuleAddCriteria);

		waitUntilElementIsVisible(CrtCreateRule);
		scrollIntoView(CrtCreateRule);
		waitForElementIsInteractable(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		waitUntilElementIsVisible(CrtRuleGolbalValidMsg);
		actualAddRuleGlobalValidation = getTextElement(CrtRuleGolbalValidMsg);

		ArrayList<String> criteriaValid = new ArrayList<String>();
		driver.findElements(CrtRuleCriteriaValid).stream().forEach(x -> criteriaValid.add(x.getText()));

		actualAddRuleAttributValidation = criteriaValid.get(0);
		actualAddRuleOperatorValidation = criteriaValid.get(1);
		actualAddRuleValueValidation = criteriaValid.get(2);

		waitUntilElementIsVisible(CrtRuleAddDelivery);
		scrollIntoView(CrtRuleAddDelivery);
		waitForElementIsInteractable(CrtRuleAddDelivery);
		clickByJsExecuter(CrtRuleAddDelivery);

		waitUntilElementIsVisible(CrtCreateRule);
		scrollIntoView(CrtCreateRule);
		waitUntilElementIsVisible(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		waitUntilElementIsVisible(CrtRuleAddDeliveryValid);
		ArrayList<String> addDeliveryValid = new ArrayList<String>();
		driver.findElements(CrtRuleAddDeliveryValid).stream().forEach(x -> addDeliveryValid.add(x.getText()));
		actualAddRuleSendOptValidation = addDeliveryValid.get(0);

		scrollIntoView(CrtCancelCrtRule);
		waitForElementIsInteractable(CrtCancelCrtRule);
		clickByJsExecuter(CrtCancelCrtRule);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(expectedAddRuleGlobalValidation, actualAddRuleGlobalValidation);
		softAssert.assertEquals(expectedAddRuleAttributValidation, actualAddRuleAttributValidation);
		softAssert.assertEquals(expectedAddRuleOperatorValidation, actualAddRuleOperatorValidation);
		softAssert.assertEquals(expectedAddRuleValueValidation, actualAddRuleValueValidation);
		softAssert.assertEquals(expectedAddRuleSendOptValidation, actualAddRuleSendOptValidation);
		softAssert.assertAll();

	}

	public void AgencySetup_CreateNotificationAddRule() throws InterruptedException {

		waitUntilElementIsVisible(CrtAddRuleBtn);
		scrollIntoView(CrtAddRuleBtn);
		waitForElementIsInteractable(CrtAddRuleBtn);
		clickOn(CrtAddRuleBtn);
		waitUntilElementIsVisible(AttributeSelectArrow);
		
		scrollIntoView(CrtRuleAddDelivery);
		waitForElementIsInteractable(CrtRuleAddDelivery);
		clickByJsExecuter(CrtRuleAddDelivery);

		waitForElementIsInteractable(SendOptionSelectArrow);
		clickOn(SendOptionSelectArrow);
		waitForElementIsInteractable(SendToOption);
		clickOn(SendToOption);
		waitForElementIsInteractable(UseEmialTemplateSelectArrow);
		clickOn(UseEmialTemplateSelectArrow);
		waitForElementIsInteractable(SelectUseEmailTemp);
		clickOn(SelectUseEmailTemp);
		scrollIntoView(CrtCreateRule);
		waitForElementIsInteractable(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		int validCheck = findElementsSize(CrtRuleGolbalValidMsg);
		
		
		waitForElementIsInteractable(AttributeSelectArrow);
		clickOn(AttributeSelectArrow);
		waitForElementIsInteractable(SelectAttribute);
		clickOn(SelectAttribute);
		waitUntilElementIsVisible(SelectedAttribute);
		selectedAttriVal = getTextElement(SelectedAttribute);
		waitForElementIsInteractable(OperatorSelectArrow);
		clickOn(OperatorSelectArrow);
		waitForElementIsInteractable(SelectOperator);
		clickOn(SelectOperator);
		waitForElementIsInteractable(ValueSelectArrow);
		clickOn(ValueSelectArrow);

		waitUntilElementIsVisible(SelectValue);
//		waitForElementIsInteractable(SelectValue);
		clickByJsExecuter(SelectValue);

		waitUntilElementIsVisible(SelectedValue);
		selectedCatVal = getTextElement(SelectedValue);
		scrollIntoView(CrtCreateRule);
		waitForElementIsInteractable(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(AddedRuleCriteria);
		scrollIntoView(AddedRuleCriteria);
		AddedRuleDesc = getTextElement(AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains(selectedCatVal), true);
		softAssert.assertEquals(AddedRuleDesc.contains(selectedAttriVal), true);
		softAssert.assertTrue(validCheck == 0);
		softAssert.assertAll();

	}

	public void editRuleSet() {
		clickOn(CaseAssignmentUtility.EditRuleIcon);
		waitForElementIsInteractable(UseEmialTemplateSelectArrow);
	}

	public void clickOnSaveRule() {
		waitForElementIsInteractable(CaseAssignmentUtility.SaveButtonEditRule);
		clickOn(CaseAssignmentUtility.SaveButtonEditRule);
	}

	public boolean CompareRecipientStr;
	public boolean CompareEmailTemplate;

	public void AgencySetup_CreateNotificationEditRule() throws InterruptedException {

		String RecipientBefore = getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String EmailTemplateBefore = getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		clickOn(CaseAssignmentUtility.EditRuleIcon);

		waitForElementIsInteractable(UseEmialTemplateSelectArrow);
		scrollIntoView(UseEmialTemplateSelectArrow);
		clickOn(UseEmialTemplateSelectArrow);
		waitForElementIsInteractable(SelectUseEmailTempSubClose);
		clickOn(SelectUseEmailTempSubClose);

		waitForElementIsInteractable(RecipientAssignee);
		scrollIntoView(RecipientAssignee);
		clickOn(RecipientAssignee);
		waitForElementIsInteractable(RecipientCollaborator);
		clickOn(RecipientCollaborator);

		waitForElementIsInteractable(CaseAssignmentUtility.SaveButtonEditRule);
		clickOn(CaseAssignmentUtility.SaveButtonEditRule);
		String RecipientAfter = getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String EmailTemplateAfter = getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		CompareRecipientStr = RecipientBefore.equals(RecipientAfter);
		CompareEmailTemplate = EmailTemplateBefore.equals(EmailTemplateAfter);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CompareRecipientStr, false);
		softAssert.assertEquals(CompareEmailTemplate, false);
		softAssert.assertAll();

	}

	public void AgencySetup_CreateNotificationCreateNotifiction() throws InterruptedException {

		Thread.sleep(4000);
		notificationnLabelName = "Notif" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "NDesc" + RandomStrings.requiredCharacters(3);
		waitForElementIsInteractable(CrtNotificationLableName);
		sendKeysWithWait(CrtNotificationLableName, notificationnLabelName);

		forcedWaitTime(1);
		waitForElementIsInteractable(CrtNotifDescription);
		sendKeysWithWait(CrtNotifDescription, notificationnDescription);
		forcedWaitTime(1);
		waitForElementIsInteractable(CrtNotifActionSelectArrow);
		clickOn(CrtNotifActionSelectArrow);

		waitForElementIsInteractable(CrtNotifselectActionValue);
		clickOn(CrtNotifselectActionValue);

		scrollIntoView(CreateNotifPopUpbtn);
		waitForElementIsInteractable(CreateNotifPopUpbtn);
		clickOn(CreateNotifPopUpbtn);

		waitUntilElementInvisibleLocated(CreateNotifPopUpbtn);
		waitUntilElementIsVisible(ActiveNotifdetails);
		forcedWaitTime(2);
		scrollIntoView(ActiveNotifdetails);

		activeNotifCount = Integer.parseInt(getTextElement(ActiveNotifdetails).split(" ")[0]);
		int check = driver.findElements(CrtNotifPagingNxt).size();
		if (check > 0) {
			while (driver.findElement(CrtNotifPagingNxt).isEnabled()) {

				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);
				forcedWaitTime(1);

			}
		}

		waitUntilElementIsVisible(CrtNotifGridPageCount);
		int pagecount = Integer.parseInt(driver.findElement(CrtNotifGridPageCount).getText().split(" ")[1]);
		if (pagecount > 1) {
			for (int i = 1; i < pagecount; i++) {
				activeNotifCount = activeNotifCount - 10;
			}
		}

		gridIndex = activeNotifCount * 5;
		forcedWaitTime(2);
		waitUntilElementIsVisible(By.xpath(GetActiveNotiificationGridData(gridIndex - 4)));
		actualNotifLable = getTextElement(By.xpath(GetActiveNotiificationGridData(gridIndex - 4)));
		actualNotifdesc = getTextElement(By.xpath(GetActiveNotiificationGridData(gridIndex - 3)));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualNotifLable.trim(), notificationnLabelName.trim());
		softAssert.assertEquals(actualNotifdesc.trim(), notificationnDescription.trim());
		softAssert.assertAll();

	}

	public void AddRuleWithMultipleCriteraAndDelivery(int criteriaDelCount) throws InterruptedException {

		forcedWaitTime(2);
		// Thread.sleep(3000);
		waitUntilElementIsVisible(CrtAddRuleBtn);
		// Thread.sleep(3000);
		scrollIntoView(CrtAddRuleBtn);
		waitForElementIsInteractable(CrtAddRuleBtn);
		Thread.sleep(3000);
		clickByJsExecuter(CrtAddRuleBtn);
		// movetoElementAndClick(CrtAddRuleBtn);
		// clickOn(CrtAddRuleBtn);
		// moveToWebElementAndClick(CrtAddRuleBtn);
		// click

		for (int index = 1; index < criteriaDelCount; index++) {

			waitUntilElementIsVisible(CrtRuleAddCriteria);
			scrollIntoView(CrtRuleAddCriteria);
			waitForElementIsInteractable(CrtRuleAddCriteria);
			clickByJsExecuter(CrtRuleAddCriteria);

		}

		waitForElementIsInteractable(AttributeSelectArrow1);
		clickOn(AttributeSelectArrow1);
		waitForElementIsInteractable(By.xpath(selectAttribute1));
		clickOn(By.xpath(selectAttribute1));

		waitForElementIsInteractable(OperatorSelectArrow1);
		clickOn(OperatorSelectArrow1);

		waitForElementIsInteractable(By.xpath(selectOperator1));
		clickOn(By.xpath(selectOperator1));

		waitForElementIsInteractable(ValueSelectArrow1);
		clickOn(ValueSelectArrow1);

		waitForElementIsInteractable(By.xpath(selectValu1));
		clickOn(By.xpath(selectValu1));

		waitForElementIsInteractable(AttributeSelectArrow2);
		clickOn(AttributeSelectArrow2);

		waitForElementIsInteractable(By.xpath(selectAttribute2));
		clickOn(By.xpath(selectAttribute2));

		waitForElementIsInteractable(OperatorSelectArrow2);
		clickOn(OperatorSelectArrow2);

		waitForElementIsInteractable(By.xpath(selectOperator2));
		clickOn(By.xpath(selectOperator2));

		waitForElementIsInteractable(ValueSelectArrow2);
		clickOn(ValueSelectArrow2);

		waitForElementIsInteractable(By.xpath(selectValu2));
		clickOn(By.xpath(selectValu2));

		for (int index = 1; index <= criteriaDelCount; index++) {

			scrollIntoView(CrtRuleAddDelivery);
			waitForElementIsInteractable(CrtRuleAddDelivery);
			clickByJsExecuter(CrtRuleAddDelivery);

		}

		waitForElementIsInteractable(By.xpath(sendOptionSelectArrow1));
		clickOn(By.xpath(sendOptionSelectArrow1));
		waitForElementIsInteractable(By.xpath(sendToOption1));
		clickOn(By.xpath(sendToOption1));

		waitForElementIsInteractable(By.xpath(useEmialTemplateSelectArrow1));
		clickOn(By.xpath(useEmialTemplateSelectArrow1));
		waitForElementIsInteractable(By.xpath(selectUseEmailTemp1));
		clickOn(By.xpath(selectUseEmailTemp1));

		waitForElementIsInteractable(By.xpath(sendOptionSelectArrow2));
		clickOn(By.xpath(sendOptionSelectArrow2));
		waitForElementIsInteractable(By.xpath(sendToOption2));
		clickOn(By.xpath(sendToOption2));

		waitForElementIsInteractable(By.xpath(recipentArrow2));
		clickOn(By.xpath(recipentArrow2));
		waitForElementIsInteractable(By.xpath(reciptentOption2));
		clickOn(By.cssSelector(reciptentOption2));

		waitForElementIsInteractable(By.xpath(useEmialTemplateSelectArrow2));
		clickOn(By.xpath(useEmialTemplateSelectArrow2));
		waitForElementIsInteractable(By.xpath(selectUseEmailTemp2));
		clickOn(By.xpath(selectUseEmailTemp2));

		scrollIntoView(CrtCreateRule);
		waitForElementIsInteractable(CrtCreateRule);
		clickByJsExecuter(CrtCreateRule);
		waitForCurserRunning(5);

	}

	public void AgencySetup_CreateNotifictionMultipleCriteriaDeliveryOption() throws InterruptedException {
		waitForCurserRunning(5);
		refreshPage();
		clickonCreateNotificationButton();
		// refreshPage();
		forcedWaitTime(2);
		try {
			movetoElementAndClick(CrtNotifActionSelectArrow);

		} catch (Exception e) {
			System.out.println("Enter in catch");
			forcedWaitTime(3);
			movetoElementAndClick(CrtNotifActionSelectArrow);
		}

		waitUntilElementIsVisible(By.xpath(SelectCustomeActionValue("Code Case Management")));
		waitForElementIsInteractable(By.xpath(SelectCustomeActionValue("Code Case Management")));
		clickOn(By.xpath(SelectCustomeActionValue("Code Case Management")));

		// refreshPage();
		Thread.sleep(3000);
		AddRuleWithMultipleCriteraAndDelivery(2);
		AgencySetup_CreateNotificationCreateNotifiction();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualNotifLable, notificationnLabelName);
		softAssert.assertEquals(actualNotifdesc, notificationnDescription);
		softAssert.assertAll();

	}

	public int GetInactiveGridIndex() throws InterruptedException {
		waitUntilElementIsVisible(InActiveNotifdetails);
		scrollIntoView(InActiveNotifdetails);
		InactiveNotifCount = Integer.parseInt(getTextElement(InActiveNotifdetails).split(" ")[0]);
		gridIndex = InactiveNotifCount * 5;
		return gridIndex;

	}

	public int GetActiveGridIndex() throws InterruptedException {

		waitUntilElementIsVisible(ActiveNotifdetails);
		scrollIntoView(ActiveNotifdetails);
		activeNotifCount = Integer.parseInt(getTextElement(ActiveNotifdetails).split(" ")[0]);
		int check = driver.findElements(CrtNotifPagingNxt).size();
		if (check > 0) {
			while (driver.findElement(CrtNotifPagingNxt).isEnabled()) {
				waitUntilElementIsVisible(CrtNotifPagingNxt);
				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);

			}
		}

		Thread.sleep(2000);
		waitUntilElementIsVisible(CrtNotifGridPageCount);
		int pagecount = Integer.parseInt(driver.findElement(CrtNotifGridPageCount).getText().split(" ")[1]);
		if (pagecount > 1) {
			for (int i = 1; i < pagecount; i++) {
				activeNotifCount = activeNotifCount - 10;
			}
		}

		return activeNotifCount;

	}

	public String actualEditNotificationHeader;
	public String expectedEditNotificationHeader = "Edit Notification";

	public void AgencySetup_CreateNotificationInactivateActiveNotificatiion() throws InterruptedException {

		gridIndex = GetActiveGridIndex();
		ActivatNotif = getTextElement(By.xpath(GetActiveNotiificationGridData((gridIndex * 5) - 4)));
		waitUntilElementIsVisible(InActiveNotifdetails);
		scrollIntoView(InActiveNotifdetails);
		InactiveNotifCountBefore = Integer.parseInt(getTextElement(InActiveNotifdetails).split(" ")[0]);
		waitUntilElementIsVisible(By.xpath(GetActiveNotiificationEditIcon(gridIndex)));
		scrollIntoView(By.xpath(GetActiveNotiificationEditIcon(gridIndex)));
		waitForElementIsInteractable(By.xpath(GetActiveNotiificationEditIcon(gridIndex)));
		clickByJsExecuter(By.xpath(GetActiveNotiificationEditIcon(gridIndex)));
		waitUntilElementIsVisible(EditNotificationPopupHeader);
		actualEditNotificationHeader = getTextElement(EditNotificationPopupHeader);
		forcedWaitTime(3);
		waitUntilElementIsVisible(CrtNotifInactiveToggle);
		waitForElementIsInteractable(CrtNotifInactiveToggle);
		clickOn(CrtNotifInactiveToggle);
		forcedWaitTime(2);
		waitUntilElementIsVisible(EditNotifSaveBtn);
		scrollIntoView(EditNotifSaveBtn);
		waitForElementIsInteractable(EditNotifSaveBtn);
		clickOn(EditNotifSaveBtn);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(InActiveNotifdetails);
		InactiveNotifCountAfter = Integer.parseInt(getTextElement(InActiveNotifdetails).split(" ")[0]);
		InactivatedNotif = getTextElement(By.xpath(GetInactiveNotiificationGridData(GetInactiveGridIndex() - 4)));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActivatNotif, InactivatedNotif);
		softAssert.assertEquals(InactiveNotifCountAfter, InactiveNotifCountBefore + 1);
		softAssert.assertEquals(actualEditNotificationHeader, expectedEditNotificationHeader);
		softAssert.assertAll();

	}

	public String InactiveNotif;
	public String ActivatedNotif;

	public int ActiveNotifCountBefore;
	public int ActiveNotifCountAfter;

	public void AgencySetup_CreateNotificationActivateInactiveNotificatiion() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath(GetInactiveNotiificationGridData(GetInactiveGridIndex() - 4)));
		InactiveNotif = getTextElement(By.xpath(GetInactiveNotiificationGridData(GetInactiveGridIndex() - 4)));
		waitUntilElementIsVisible(ActiveNotifdetails);
		scrollIntoView(ActiveNotifdetails);
		ActiveNotifCountBefore = Integer.parseInt(getTextElement(ActiveNotifdetails).split(" ")[0]);
		int inactivebtnindex = GetInactiveGridIndex() / 5;
		waitUntilElementIsVisible(By.xpath(GetInactiveNotiificationEditIcon(inactivebtnindex)));
		scrollIntoView(By.xpath(GetInactiveNotiificationEditIcon(inactivebtnindex)));
		waitForElementIsInteractable(By.xpath(GetInactiveNotiificationEditIcon(inactivebtnindex)));
		clickByJsExecuter(By.xpath(GetInactiveNotiificationEditIcon(inactivebtnindex)));

		forcedWaitTime(2);
		waitUntilElementIsVisible(CrtNotifActiveToggle);
		waitForElementIsInteractable(CrtNotifActiveToggle);
		clickOn(CrtNotifActiveToggle);

		forcedWaitTime(2);
		waitUntilElementIsVisible(EditNotifSaveBtn);
		scrollIntoView(EditNotifSaveBtn);
		waitForElementIsInteractable(EditNotifSaveBtn);
		clickOn(EditNotifSaveBtn);

		waitForCurserRunning(5);

		waitUntilElementIsVisible(ActiveNotifdetails);
		scrollIntoView(ActiveNotifdetails);
		ActiveNotifCountAfter = Integer.parseInt(getTextElement(ActiveNotifdetails).split(" ")[0]);
		gridIndex = GetActiveGridIndex();
		ActivatedNotif = getTextElement(By.xpath(GetActiveNotiificationGridData((gridIndex * 5) - 4)));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(InactiveNotif, ActivatedNotif);
		softAssert.assertEquals(ActiveNotifCountAfter, ActiveNotifCountBefore + 1);
		softAssert.assertAll();

	}

	public void AgencySetup_CreateNotificationEscalatedNoticeGenerated() throws InterruptedException {
		clickonCreateNotificationButton();
		forcedWaitTime(2);
		waitUntilElementIsVisible(CrtNotifActionSelectArrow);
		waitForElementIsInteractable(CrtNotifActionSelectArrow);
		clickOn(CrtNotifActionSelectArrow);
		waitUntilElementIsVisible(By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		scrollIntoView(By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		Boolean esclatedNoticeGenerated = elementIsDisplayed(
				By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		Boolean esclatedNoticeGeneratedSupervisor = elementIsDisplayed(
				By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		waitForElementIsInteractable(By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		clickOn(By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		Thread.sleep(4000);
		String notificationnLabelName = "EsclatedNotif" + RandomStrings.requiredCharacters(3);
		String notificationnDescription = "EsclatedNDesc" + RandomStrings.requiredCharacters(3);
		waitForElementIsInteractable(CrtNotificationLableName);
		sendKeysWithWait(CrtNotificationLableName, notificationnLabelName);
		forcedWaitTime(2);
		waitForElementIsInteractable(CrtNotifDescription);
		sendKeysWithWait(CrtNotifDescription, notificationnDescription);
		forcedWaitTime(2);
		ClickOnAddRuleBtn();
		ClickOnAddDeliveryOtpion();
		SelectSendOtions("Send To");
		Boolean DesignatedSupervisor = checkRecipientOptions("Designated Supervisor");
		ClickonRecipient();
		Boolean CaseAssignee = checkRecipientOptions("Case Assignee");
		SelectRecipient("Designated Supervisor");
		Boolean Escalated_Notice_Generated = checkEmailTemplateOptions("Escalated Notice Generated");
		SelectEmailTemplate("Escalated Notice Generated");
		ClickonCreateRuleBtn();
		ClickonCreateNotificationPopBtn();
		waitUntilElementIsVisible(CrtNotifGridPageCount);
		Boolean NotificationAdded = elementIsDisplayed(
				By.xpath(stringFormat(notificationName, notificationnLabelName)));
		;
		int check = driver.findElements(CrtNotifPagingNxt).size();
		Boolean nexPage = true;
		if (check > 0 && !NotificationAdded) {
			while (nexPage) {
				if (NotificationAdded) {
					break;
				}
				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);
				forcedWaitTime(2);
				NotificationAdded = elementIsDisplayed(
						By.xpath(stringFormat(notificationName, notificationnLabelName)));
				;
				nexPage = driver.findElement(CrtNotifPagingNxt).isEnabled();

			}
		}

		forcedWaitTime(4);
		Assert.assertTrue(esclatedNoticeGenerated, "Escalated Notice Generated action is not present.");
		Assert.assertTrue(esclatedNoticeGeneratedSupervisor,
				"Escalated Notice Reviewed by Supervisor action is not present.");
		Assert.assertTrue(DesignatedSupervisor, "Designated Supervisor recipient is not present.");
		Assert.assertTrue(Escalated_Notice_Generated, "Escalated Notice Generated Email Template is not present.");
		Assert.assertTrue(NotificationAdded, "New Notification is created.");
		Assert.assertTrue(CaseAssignee, "Case Assignee Recipient is not Present.");
		// clean up
				activeInactiveNotification(notificationnLabelName);

	}

	public void AgencySetup_CreateNotificationEscalatedNoticeReviewdSuperVisor() throws InterruptedException {
		clickonCreateNotificationButton();
		forcedWaitTime(2);
		waitUntilElementIsVisible(CrtNotifActionSelectArrow);
		waitForElementIsInteractable(CrtNotifActionSelectArrow);
		clickOn(CrtNotifActionSelectArrow);
		waitUntilElementIsVisible(By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		scrollIntoView(By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		Boolean esclatedNoticeGenerated = elementIsDisplayed(
				By.xpath(SelectCustomeActionValue("Escalated Notice Generated")));
		Boolean esclatedNoticeGeneratedSupervisor = elementIsDisplayed(
				By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		waitForElementIsInteractable(By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		clickOn(By.xpath(SelectCustomeActionValue("Escalated Notice Reviewed by Supervisor")));
		Thread.sleep(4000);
		String notificationnLabelName = "EsclatedReviewNotif" + RandomStrings.requiredCharacters(3);
		String notificationnDescription = "EsclatedReviewNDesc" + RandomStrings.requiredCharacters(3);
		waitForElementIsInteractable(CrtNotificationLableName);
		sendKeysWithWait(CrtNotificationLableName, notificationnLabelName);
		forcedWaitTime(2);
		waitForElementIsInteractable(CrtNotifDescription);
		sendKeysWithWait(CrtNotifDescription, notificationnDescription);
		forcedWaitTime(2);

		ClickOnAddRuleBtn();
		SelectAttribut("Approval Status");
		SelectRuleOperator();
		List<String> ValueOptions = checkRuleValue();
		SelectRuleValue(true, "all");

		ClickOnAddDeliveryOtpion();
		SelectSendOtions("Send To");
		Boolean DesignatedSupervisor = checkRecipientOptions("Designated Supervisor");
		ClickonRecipient();
		Boolean CaseAssignee = checkRecipientOptions("Case Assignee");
		SelectRecipient("Designated Supervisor");
		Boolean Escalated_Notice_Generated = checkEmailTemplateOptions("Escalated Notice Reviewed by Supervisor");
		SelectEmailTemplate("Escalated Notice Reviewed by Supervisor");
		ClickonCreateRuleBtn();
		ClickonCreateNotificationPopBtn();
		waitUntilElementIsVisible(CrtNotifGridPageCount);
		Boolean NotificationAdded = elementIsDisplayed(
				By.xpath(stringFormat(notificationName, notificationnLabelName)));
		;
		int check = driver.findElements(CrtNotifPagingNxt).size();
		Boolean nexPage = true;
		if (check > 0 && !NotificationAdded) {
			while (nexPage) {
				if (NotificationAdded) {
					break;
				}
				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);
				forcedWaitTime(2);
				NotificationAdded = elementIsDisplayed(
						By.xpath(stringFormat(notificationName, notificationnLabelName)));
				;
				nexPage = driver.findElement(CrtNotifPagingNxt).isEnabled();

			}
		}

		forcedWaitTime(4);
		Assert.assertTrue(esclatedNoticeGenerated, "Escalated Notice Generated action is not present.");
		Assert.assertTrue(esclatedNoticeGeneratedSupervisor,
				"Escalated Notice Reviewed by Supervisor action is not present.");
		Assert.assertTrue(DesignatedSupervisor, "Designated Supervisor recipient is not present.");
		Assert.assertTrue(Escalated_Notice_Generated, "Escalated Notice Generated Email Template is not present.");
		Assert.assertTrue(NotificationAdded, "New Notification is created.");
		Assert.assertTrue(ValueOptions.contains("Notice Approved"), "Notice Approved value options is not present.");
		Assert.assertTrue(ValueOptions.contains("Notice Rejected"), "Notice Rejected value options is not present.");
		Assert.assertTrue(ValueOptions.contains("Notice Reviewed (Approved or Rejected)"),
				"Notice Reviewed (Approved or Rejected) value options is not present.");
		Assert.assertTrue(CaseAssignee, "Case Assignee Recipient is not Present.");
		
		// clean up
				activeInactiveNotification(notificationnLabelName);

	}

	public void AgencySetup_CreateNotificationEscalatedNoticeEdited() throws InterruptedException {

		clickonCreateNotificationButton();
		forcedWaitTime(2);
		waitUntilElementIsVisible(CrtNotifActionSelectArrow);
		waitForElementIsInteractable(CrtNotifActionSelectArrow);
		clickOn(CrtNotifActionSelectArrow);
		waitUntilElementIsVisible(By.xpath(SelectCustomeActionValue("Escalated Notice Edited")));
		scrollIntoView(By.xpath(SelectCustomeActionValue("Escalated Notice Edited")));
		Boolean esclatedNoticeGenerated = elementIsDisplayed(
				By.xpath(SelectCustomeActionValue("Escalated Notice Edited")));
		waitForElementIsInteractable(By.xpath(SelectCustomeActionValue("Escalated Notice Edited")));
		clickOn(By.xpath(SelectCustomeActionValue("Escalated Notice Edited")));
		Thread.sleep(4000);
		String notificationnLabelName = "EsclatedNoticeEditedNotif" + RandomStrings.requiredCharacters(3);
		String notificationnDescription = "EsclatedNoticeEditedNDesc" + RandomStrings.requiredCharacters(3);
		waitForElementIsInteractable(CrtNotificationLableName);
		sendKeysWithWait(CrtNotificationLableName, notificationnLabelName);
		forcedWaitTime(2);
		waitForElementIsInteractable(CrtNotifDescription);
		sendKeysWithWait(CrtNotifDescription, notificationnDescription);
		forcedWaitTime(2);
		ClickOnAddRuleBtn();
		ClickOnAddDeliveryOtpion();
		SelectSendOtions("Send To");
		Boolean DesignatedSupervisor = checkRecipientOptions("Designated Supervisor");
		ClickonRecipient();
		Boolean CaseAssignee = checkRecipientOptions("Case Assignee");
		SelectRecipient("Designated Supervisor");
		Boolean Escalated_Notice_Generated = checkEmailTemplateOptions("Escalated Notice Edited");
		SelectEmailTemplate("Escalated Notice Edited");
		ClickonCreateRuleBtn();
		ClickonCreateNotificationPopBtn();
		waitUntilElementIsVisible(CrtNotifGridPageCount);
		Boolean NotificationAdded = elementIsDisplayed(
				By.xpath(stringFormat(notificationName, notificationnLabelName)));

		int check = driver.findElements(CrtNotifPagingNxt).size();
		Boolean nexPage = true;
		if (check > 0 && !NotificationAdded) {
			while (nexPage) {
				if (NotificationAdded) {
					break;
				}
				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);
				forcedWaitTime(2);
				NotificationAdded = elementIsDisplayed(
						By.xpath(stringFormat(notificationName, notificationnLabelName)));
				nexPage = driver.findElement(CrtNotifPagingNxt).isEnabled();

			}
		}

		forcedWaitTime(4);
		Assert.assertTrue(esclatedNoticeGenerated, "Escalated Notice Generated action is not present.");
		Assert.assertTrue(DesignatedSupervisor, "Designated Supervisor recipient is not present.");
		Assert.assertTrue(Escalated_Notice_Generated, "Escalated Notice Generated Email Template is not present.");
		Assert.assertTrue(NotificationAdded, "New Notification is created.");
		Assert.assertTrue(CaseAssignee, "Case Assignee Recipient is not Present.");
		
		// clean up
		activeInactiveNotification(notificationnLabelName);

	}

	public Boolean checkNotiificationIsPresent(String name) throws InterruptedException {

		waitUntilElementIsVisible(CrtNotifGridPageCount);
		int NotificationAdded = findElementsSize(By.xpath(stringFormat(notificationName, name)));

		int check = driver.findElements(CrtNotifPagingNxt).size();
		Boolean nexPage = true;
		if (check > 0 && NotificationAdded == 0) {
			while (nexPage) {
				if (NotificationAdded > 0) {
					break;
				}
				scrollIntoView(CrtNotifPagingNxt);
				waitForElementIsInteractable(CrtNotifPagingNxt);
				clickByJsExecuter(CrtNotifPagingNxt);
				forcedWaitTime(2);
				NotificationAdded = findElementsSize(By.xpath(stringFormat(notificationName, name)));
				nexPage = driver.findElement(CrtNotifPagingNxt).isEnabled();

			}
		}

		forcedWaitTime(4);
		Boolean notificationDisplayed = elementIsDisplayed(By.xpath(stringFormat(notificationName, name)));
		return notificationDisplayed;

	}

	public void ClickOnActionDropDown() throws InterruptedException {
		forcedWaitTime(2);
		try {
			movetoElementAndClick(CrtNotifActionSelectArrow);

		} catch (Exception e) {
			e.printStackTrace();
			forcedWaitTime(3);
			movetoElementAndClick(CrtNotifActionSelectArrow);
		}

	}

	// Code Case Management
	public void SelectActionOption(String option) {
		waitUntilElementIsVisible(By.xpath(SelectCustomeActionValue(option)));
		waitForElementIsInteractable(By.xpath(SelectCustomeActionValue(option)));
		clickOn(By.xpath(SelectCustomeActionValue(option)));

	}

	public void enterNotificationName(String lableName) throws InterruptedException {
		waitForElementIsInteractable(CrtNotificationLableName);
		sendKeysWithWait(CrtNotificationLableName, lableName);
		forcedWaitTime(2);

	}

	public void enterDesription(String notificationnDescription) throws InterruptedException {
		waitForElementIsInteractable(CrtNotifDescription);
		sendKeysWithWait(CrtNotifDescription, notificationnDescription);
		forcedWaitTime(2);
	}
}
