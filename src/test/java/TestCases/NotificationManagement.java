package TestCases;

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
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CaseAssignmentUtility;
import POM.NotificationManagementUtility;
import POM.TemplateManagementUtility;

public class NotificationManagement extends BrowsersInvoked {

	
	ExtentReportClass extentClass;
	ITestResult result;
	NotificationManagementUtility nm;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets getDriver() for this thread
      
        nm = new NotificationManagementUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the getDriver() for this thread
    }
	


	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		nm.LoginAdmin();

	}

	@Test(priority = 1, description = "Verify navigation to 'Notification Management' and default Active -5 and Inactive -4 Notification count")
	public void AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount() throws InterruptedException {
		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount();

	}

	@Test(priority = 2, description = "Verify that user is able to open and close the 'Create Notification' popup after clicking the 'Create Notification' and 'Cancel' buttons on 'Notification' and 'Create Notification' pages respectively")
	public void AgencySetup_CreateNotificationPopCloseOpenAndValidations() throws InterruptedException {
		nm.AgencySetup_CreateNotificationPopCloseOpenAndValidations();

	}

	@Test(priority = 3,description = "Verify that user is able to open and close the 'Create Rule' popup after clicking the 'Add Rule' and 'Cancel' buttons on 'Create Rule' and 'Create Rule' pages respectively")
	public void AgencySetup_CreateNotificationAddRulePopupValidations() throws InterruptedException {
		nm.AgencySetup_CreateNotificationAddRulePopupValidations();

	}

	@Test(priority = 4,description = "Verify that user is able to add Rules under 'Rules Set' section, on 'Create Notification' popup.")
	public void AgencySetup_CreateNotificationAddRule() throws InterruptedException {
		nm.AgencySetup_CreateNotificationAddRule();

	}

	@Test(priority = 5,description = "Verify that user is able to add Rules under 'Rules Set' section, on 'Create Notification' popup.")
	public void AgencySetup_CreateNotificationEditRule() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEditRule();

	}

	@Test(priority = 6,description = "Verify that user is able to create & add a Notification, under 'Notifications' tab.")
	public void AgencySetup_CreateNotificationCreateNotifiction() throws InterruptedException {
		nm.AgencySetup_CreateNotificationCreateNotifiction();

	}

	@Test(priority = 7,description = "Verify that user is able to create & add a Notification, under 'Notifications' tab.")
	public void AgencySetup_CreateNotifictionMultipleCriteriaDeliveryOption() throws InterruptedException {
		nm.AgencySetup_CreateNotifictionMultipleCriteriaDeliveryOption();

	}

	@Test(priority = 8,description = "Verify that user is able to Inactivate the Active notification on 'Notofication Mangement' Page")
	public void AgencySetup_CreateNotificationInactivateActiveNotificatiion() throws InterruptedException {
		nm.AgencySetup_CreateNotificationInactivateActiveNotificatiion();

	}

	@Test(priority = 9,description = "Verify that user is able to Activate the Inactive notification on 'Notofication Mangement' Page")
	public void AgencySetup_CreateNotificationActivateInactiveNotificatiion() throws InterruptedException {
		nm.AgencySetup_CreateNotificationActivateInactiveNotificatiion();

	}

	@Test(priority = 10, description = "Verify that user able to create 'Esclated Notice Generated' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeGenerated() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeGenerated();

	}

	@Test(priority = 11, description = "Verify that user able to create 'Escalated Notice Reviewed by Supervisor' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeReviewdSuperVisor() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeReviewdSuperVisor();

	}
	
	
	@Test(priority = 12, description = "Verify that user able to create 'Escalated Notice Edited' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeEdited() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeEdited();

	}
	
	
	public static String notificationnLabelName;
	public static String notificationnDescription;
	
	@Test(priority = 13,description = "Auto-173 | Verify that user is able to add rule set with 'Case Notification equals ( Case Assigned )' criteria, on 'Create Notification' popup")
	public void CreateCaseAssignedRuleSet() throws InterruptedException { 
//		nm.LoginAdmin();
//		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount(); 
		notificationnLabelName = "Case Assignee Messages" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "Case Assignee Messages" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Code Case Management");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		nm.SelectAttribut("Case Notification");
		
		nm.SelectRuleOperator("Equals");
		nm.clickOnValueDrp();
		
		// case Assigned
		nm.SelectRuleValue(false,"1");
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.ClickonCreateRuleBtn();
		
		String AddedRuleDesc = nm.getTextElement(NotificationManagementUtility.AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains("Case Notification"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("Case Assigned"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("equals"), true);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 14,description = "Auto-174 | Verify that user is able to update rule set with 'Case Notification equals ( Case Assigned )' criteria, on 'Create Notification' popup.")
	public void EditCaseAssignedRuleSet() throws InterruptedException {
		
		String recipientBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		nm.editRuleSet();
		
	
		// Case Assignee Changed to Inspection Assigned
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Inspection Assigned");
		nm.clickOnSaveRule();
		
		
		String recipientAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(recipientBefore, recipientAfter);
		softAssert.assertNotEquals(emailTemplateBefore, emailTemplateAfter);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 15,description = "Auto-175 | Verify that user is able to create 'Case Management(Case Assigned)' Notification, on 'Notifications' page.")
	public void CreateCaseManagementCaseAssignedNotification() throws InterruptedException {
//		CreateCaseAssignedRuleSet();
//		EditCaseAssignedRuleSet();
		nm.editRuleSet();
		// Inspection Assigned Changed to Case Assignee
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.clickOnSaveRule();
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	
	
	
	@Test(priority = 16,description = "Auto-176 | Verify that user is able to add rule set with 'Case Notification equals ( Inspection Assigned )' criteria, on 'Create Notification' popup.")
	public void CreateCaseInspectionAssignedRuleSet() throws InterruptedException {
//		nm.LoginAdmin();
//		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount(); 
		notificationnLabelName = "Case Inspection Assignee Messages" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "Case Inspection Assignee Messages" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Code Case Management");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		nm.SelectAttribut("Case Notification");
		
		nm.SelectRuleOperator("Equals");
		nm.clickOnValueDrp();
		
		// case Assigned
		nm.SelectRuleValue(false,"2");
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Inspection Assigned");
		nm.ClickonCreateRuleBtn();
		
		String AddedRuleDesc = nm.getTextElement(NotificationManagementUtility.AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains("Case Notification"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("Inspection Assigned"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("equals"), true);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 17,description = "Auto-177 | Verify that user is able to update 'Case Notification equals ( Inspection Assigned )' Rules under the 'Rules Set' section, on 'Create Notification' popup.")
	public void EditCaseInspectionAssignedRuleSet() throws InterruptedException {
		
		String recipientBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		nm.editRuleSet();
		
	
		// Inspection Assigned Changed to Case Assigned
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.clickOnSaveRule();
		
		
		String recipientAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(recipientBefore, recipientAfter);
		softAssert.assertNotEquals(emailTemplateBefore, emailTemplateAfter);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 18,description = "Auto-178 | Verify that user is able to create 'Case Management(Case Inspection)' Notification, on 'Notifications' page.")
	public void CreateCaseManagementCaseInspectionAssignedNotification() throws InterruptedException {
//		CreateCaseInspectionAssignedRuleSet();
//		EditCaseInspectionAssignedRuleSet();
		nm.editRuleSet();
		// Case Assigned Changed to Inspection Assignee
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Inspection Assigned");
		nm.clickOnSaveRule();
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	
	
	
	
	
	@Test(priority = 19,description = "Auto-179 | Verify that user is able to add rule set with 'Case Notification equals ( New Customer Message Received )' criteria, on 'Create Notification' popup.")
	public void CreateNewCustomerMessageRuleSet() throws InterruptedException {
//		nm.LoginAdmin();
//		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount(); 
		notificationnLabelName = "New Cusstomer Message Received Messages" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "New Cusstomer Message Received Messages" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Code Case Management");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		nm.SelectAttribut("Case Notification");
		
		nm.SelectRuleOperator("Equals");
		nm.clickOnValueDrp();
		
		// case Assigned
		nm.SelectRuleValue(false,"3");
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Customer Message Received");
		nm.ClickonCreateRuleBtn();
		
		String AddedRuleDesc = nm.getTextElement(NotificationManagementUtility.AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains("Case Notification"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("New Customer Message Received"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("equals"), true);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 20,description = "Auto-180 | Verify that user is able to update rule set with 'Case Notification equals ( New Customer Message Received )' criteria, on 'Create Notification' popup.")
	public void EditNewCustomerMessageRuleSet() throws InterruptedException {
		
		String recipientBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		nm.editRuleSet();
		
	
		// Case Assigned Changed to Inspection Assigned
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.clickOnSaveRule();
		
		
		String recipientAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(recipientBefore, recipientAfter);
		softAssert.assertNotEquals(emailTemplateBefore, emailTemplateAfter);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 21,description = "Auto-181 | Verify that user is able to create 'Case Management(New Customer Message Received)' Notification, on 'Notifications' page.")
	public void CreateCaseManagementNewCustomerMessageReceivedNotification() throws InterruptedException {
//		CreateNewCustomerMessageRuleSet();
//		EditNewCustomerMessageRuleSet();
		nm.editRuleSet();
		// Inspection Assignee Changed to Case Assignee
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Customer Message Received");
		nm.clickOnSaveRule();
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	
	
	
	@Test(priority = 22,description = "Auto-182 | Verify that user is able to add rule set with 'New Internal Comment' criteria, on 'Create Notification' popup.")
	public void CreateNewInternalCommentRuleSet() throws InterruptedException {
//		nm.LoginAdmin();
//		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount(); 
		notificationnLabelName = "New Internal Comment Messages" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "New Internal Comment Messages" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Code Case Management");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		nm.SelectAttribut("Case Notification");
		
		nm.SelectRuleOperator("Equals");
		nm.clickOnValueDrp();
		
		// case Assigned
		nm.SelectRuleValue(false,"4");
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Internal Comment");
		nm.ClickonCreateRuleBtn();
		
		String AddedRuleDesc = nm.getTextElement(NotificationManagementUtility.AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains("Case Notification"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("New Internal Comment"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("equals"), true);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 23,description = "Auto-183 | Verify that user is able to update rule set with 'Case Notification equals ( New Internal Comment )' criteria, on 'Create Notification' popup.")
	public void EditNewInternalCommentRuleSet() throws InterruptedException {
		
		String recipientBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		nm.editRuleSet();
		
	
		// Case Assigned Changed to Inspection Assigned
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.clickOnSaveRule();
		
		
		String recipientAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(recipientBefore, recipientAfter);
		softAssert.assertNotEquals(emailTemplateBefore, emailTemplateAfter);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 24,description = "Auto-184 | Verify that user is able to create 'Case Management(New Internal comment)' Notification, on 'Notifications' page.")
	public void CreateCaseanagementNewInternalCommentNotification() throws InterruptedException {
//		CreateNewInternalCommentRuleSet();
//		EditNewInternalCommentRuleSet();
		nm.editRuleSet();
		// Inspection Assignee Changed to Case Assignee
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Internal Comment");
		nm.clickOnSaveRule();
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	

	@Test(priority = 25,description = "Auto-185 | Verify that user is able to add rule set with 'Case Notification equals ( Case and Inspection Assigned )' criteria, on 'Create Notification' popup.")
	public void CreateCaseandInspectionAssignedRuleSet() throws InterruptedException {
//		nm.LoginAdmin();
//		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount(); 
		notificationnLabelName = "Case and Inspection Consolidated Messages" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "Case and Inspection Consolidated Messages" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Code Case Management");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		nm.SelectAttribut("Case Notification");
		
		nm.SelectRuleOperator("Equals");
		nm.clickOnValueDrp();
		
		// case Assigned
		nm.SelectRuleValue(false,"5");
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("Case and Inspection Consolidated");
		nm.ClickonCreateRuleBtn();
		
		String AddedRuleDesc = nm.getTextElement(NotificationManagementUtility.AddedRuleCriteria);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddedRuleDesc.contains("Case Notification"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("Case and Inspection Assigned"), true);
		softAssert.assertEquals(AddedRuleDesc.contains("equals"), true);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 26,description = "Auto-186 | Verify that user is able to update rule set with 'Case Notification equals ( Case and Inspection Assigned )' criteria, on 'Create Notification' popup.")
	public void EditCaseandInspectionAssignedRuleSet() throws InterruptedException {
		
		String recipientBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateBefore = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		nm.editRuleSet();
		
	
		
		nm.ClickonRecipient();
		nm.SelectRecipient("Inspection Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("New Case Assigned");
		nm.clickOnSaveRule();
		
		
		String recipientAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][3]"));
		String emailTemplateAfter = nm.getTextElement(By.xpath("//div[@class='sortable-table__body__td'][4]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(recipientBefore, recipientAfter);
		softAssert.assertNotEquals(emailTemplateBefore, emailTemplateAfter);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority = 27,description = "Auto-187 | Verify that user is able to create 'Case Management(Consolidated)' Notification, on 'Notifications' page.")
	public void CreateCaseManagementConsolidatedNotification() throws InterruptedException {
//		CreateCaseandInspectionAssignedRuleSet();
//		EditCaseandInspectionAssignedRuleSet();
		nm.editRuleSet();
	
		nm.ClickonRecipient();
		nm.SelectRecipient("Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("Case and Inspection Consolidated");
		nm.clickOnSaveRule();
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	
	
	
	@Test(priority = 28,description = "Auto-187 | Verify that user is able to create 'Esclated Notice Reviewed By Supervisor' recipient 'case assignee' Notification, on 'Notifications' page.")
	public void CreateEsclatedNoticeReviewedBySupervisorNotification() throws InterruptedException {
		
		nm.LoginAdmin();
		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount();
		notificationnLabelName = "EsclatedNoticeReviewedBySupervisor" + RandomStrings.requiredCharacters(3);
		notificationnDescription = "EsclatedNoticeReviewedBySupervisor" + RandomStrings.requiredCharacters(3);
		nm.clickonCreateNotificationButton();
		nm.ClickOnActionDropDown();
		nm.SelectActionOption("Escalated Notice Reviewed by Supervisor");
		nm.enterNotificationName(notificationnLabelName);
		nm.enterDesription(notificationnDescription);
		nm.ClickOnAddRuleBtn();
		
		nm.SelectAttribut("Approval Status");
		nm.SelectRuleOperator();
		List<String> ValueOptions = nm.checkRuleValue();
		nm.SelectRuleValue(true, "all");
		
		
		// case Assigned
	
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
		nm.ClickonRecipient();
		nm.SelectRecipient("Case Assignee");
		nm.ClickonEmailTemplate();
		nm.SelectEmailTemplate("Escalated Notice Reviewed by Supervisor");
		nm.ClickonCreateRuleBtn();
		
	
		nm.ClickonCreateNotificationPopBtn();
		Boolean notificationAdded = nm.checkNotiificationIsPresent(notificationnLabelName);
		nm.activeInactiveNotification(notificationnLabelName);
		Assert.assertTrue(notificationAdded, "New Notification is created.");
	}
	
	
	
	
	
	
	@Test(priority = 29, description = "Verify that user able to see following email template on Notification Management Page")
	public void AgencySetup_VerifyFollowingUseemailTemplate() throws InterruptedException {
		nm.clickonCreateNotificationButton();
		
		nm.ClickOnAddRuleBtn();
		
		nm.ClickOnAddDeliveryOtpion();
		nm.SelectSendOtions("Send To");
	
		nm.ClickonEmailTemplate();
		List<String> templateNames = nm.getElementTextList(By.xpath("//div[@class='Select-menu-outer']//div"));
		String myList2 = PropertiesUtils.getPropertyValue("UseEmailTemplate");
        List<String> expectedTempList = Arrays.asList(myList2.split(","));
        
        Assert.assertTrue(templateNames.containsAll(expectedTempList));
		
		

	}

	@Test(priority = 30, description = "Verify that user able to see following Recipient on Notification Management Page")
	public void AgencySetup_VerifyFollowingRecipent() throws InterruptedException {
		nm.ClickonRecipient();
		List<String> templateNames = nm.getElementTextList(By.xpath("//div[@class='Select-menu-outer']//div"));
		String myList2 = PropertiesUtils.getPropertyValue("Recipiets");
        List<String> expectedTempList = Arrays.asList(myList2.split(","));
        
        Assert.assertTrue(templateNames.containsAll(expectedTempList));
		
		

	}
	
	
	
	


}
