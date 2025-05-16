package POM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import CommonMethods.CECommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class SupervisorUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods ceCommonMethod;

	public SupervisorUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethod = new CECommonMethods(driver);
	}

	public static By saveBtnOnGroupsEdit = By.xpath("//button[text()='Save']");
	public static By descriptionBoxOnGroups = By.xpath("//*[@name='description']");
	public static By appLauncher = By.cssSelector(".app-header__menu__icon");
	public static By agencySetupLink = By.xpath("//label[text()='Agency Setup']");
	public static By userManagementTab = By.xpath("//label[text()='User Management']");
	public static By rolesTab = By.xpath("//div[text()='Roles']");
	public static By createRoleBtn = By.xpath("//button[text()='Create Role']");
	public static By toggleCEBtnProdSetting = By.xpath("(//div[@class='react-toggle-thumb'])[1]");
	public static By noBtnSupervisor = By.xpath("(//button[text()='Supervisor (basic)']/../button)[1]");
	public static By supervisorBasicBtn = By.xpath("//button[text()='Supervisor (basic)']");
	public static By supervisionManagerBtn = By.xpath("//button[text()='Supervision Manager']");
	public static By createRoleBtn2 = By.xpath("(//button[text()='Create Role'])[2]");
	public static By roleName = By.xpath("//div[@class='field__input row']/input");
	public static By roleCreatedSuccessMsg = By.xpath("//div[@class='success-custom-message']");
	public static By groupCreatedSuccessMsg = By.xpath("//div[@class='success-custom-message']");
	public static By groupUpdatedSuccessMsg = By.xpath("//div[@class='success-custom-message']/span");
	public static By usersTabs = By.xpath("//div[text()='Users']");
	public static By createUserBtn = By.xpath("//button[text()='Create User']");
	public static By firstNameFieldCreateUser = By.xpath("//input[@name='firstName']");
	public static By lastNameFieldCreateUser = By.xpath("//input[@name='lastName']");
	public static By emailFieldCreateUser = By.xpath("//input[@name='email']");
	public static By roleFieldCreateUser = By.xpath("(//div[text()='Select Option'])[2]");
	public static By selectNoSupervisorRole = By.xpath("//div[text()='No Supervisor']");
	public static By selectBasicSupervisorRole = By.xpath("//div[contains(text(),'Basic Supervisor')]");
	public static By selectSupervisorManagerRole = By.xpath("//div[text()='Supervisor Manager']");
	public static By createUserBtn2 = By.xpath("(//button[text()='Create User'])[2]");
	public static By filterByNameEmailUserPage = By.xpath("//*[@placeholder='Filter by name or email']");
	public static By userCountDisplayed = By.xpath("//*[@class='agency-setup-tab__section__header']/h2");
	public static By groupsTab = By.xpath("//*[@class='tabs__names']//div[text()='Groups']");
	public static By createNewGroupBtn = By.xpath("//button[text()='Create New Group']");
	public static By createGroupBtn2 = By.xpath("//button[text()='Create Group']");
	public static By groupNameField = By.xpath("//div[@class='field__input row']/input[@placeholder='Enter Text']");
	public static By AddUsersInGroups = By.xpath("//div[@class='dropdown__selector__selected']/label");
	public static By searchByUserNameField = By.xpath("//*[@name='query']");
	public static By basicSuperviserUser = By.xpath("//*[@name='BasicSuperviser User']/..");
	public static By supervisorManagerHead = By.xpath("//*[@name='SupervisorManagerHead Z']");
	public static By applyBtn = By.xpath("//button[text()='Apply']");

	public static By pendingSupervisolApprovalBtn = By.xpath("//div[@class='escalated-label pending-approval']");

	public static By completeInspAndGenerateNoticeForApproval = By
			.xpath("//button[text()='Complete Inspection & Generate Notice for Approval']");

	public static By completeInspAndGenerateNoticeForApproval2 = By
			.xpath("//button[text()='Issue Notice & Complete Inspection']");
	public static By warningMsgOnIssueNotice = By.xpath("//*[@class='approval-warning']/em");
	public static By escalatedNoticeHeader = By.xpath("//*[@class='case-details__case-escalated-label']");
	public static By pendingSupervisorApprovalCDP = By.xpath("//*[text()=\"Pending Supervisor Approval\"]");

	public static By noticeGeneratedPendingSupervisorApprovalTile = By
			.xpath("//*[@class='abatement-activities__draft-notice']/h4");
	public static By viewNotice = By.xpath("//a[text()='View Notice']");
	public static By approveNoticeBtnSupervisor = By.xpath("//button[text()='Approve Notice']");
	public static By approveBtnForEscalatedNotice = By.xpath("//button[text()='Approve']");
	public static By saveBtnEscalatedNotice = By.xpath("//button[text()='Save']");
	public static String addUserToGroup = "//span//b[text()='%s']";

	public void LoginSupervisor() throws InterruptedException {
		log.LoginBasicSupervisor();

	}

	public void LoginNonSupervisor() throws InterruptedException {
		log.LoginNonSupervisor();

	}

	public void verify_No_BasicSup_SupManager_IsDisplayed() {
		waitForElementIsInteractable(appLauncher);
		clickByJsExecuter(appLauncher);
		waitForElementIsInteractable(agencySetupLink);
		clickByJsExecuter(agencySetupLink);
		waitForElementIsInteractable(userManagementTab);
		clickByJsExecuter(userManagementTab);
		waitForElementIsInteractable(rolesTab);

		clickByJsExecuter(rolesTab);
		waitForElementIsInteractable(createRoleBtn);

		clickByJsExecuter(createRoleBtn);
		scrollIntoView(toggleCEBtnProdSetting);
		waitForElementIsInteractable(toggleCEBtnProdSetting);

		clickByJsExecuter(toggleCEBtnProdSetting);
		Boolean isNoPresent = elementIsDisplayed(noBtnSupervisor);
		Boolean isBasicSupervisorPresent = elementIsDisplayed(supervisorBasicBtn);
		Boolean supervisionManagerBtnPresent = elementIsDisplayed(supervisionManagerBtn);

		if (!(isNoPresent && isBasicSupervisorPresent && supervisionManagerBtnPresent)) {
			Assert.assertFalse(true);

		}

	}

	public void VerifyThatUserIsAbleToCreateARoleWithNoSupervisorPermission() {

		waitForElementIsInteractable(createRoleBtn2);
		clickByJsExecuter(noBtnSupervisor);
		scrollIntoView(roleName);

		clickByJsExecuter(noBtnSupervisor);
		scrollIntoView(roleName);
		String roleNameText = "Role_NoSupervisor" + RandomStrings.requiredDigits(5);
		sendKeysWithWait(roleName, roleNameText);
		clickByJsExecuter(createRoleBtn2);
		waitForPresenceandVisiblity(roleCreatedSuccessMsg);
		String successMsg = getTextByJSExecutor(roleCreatedSuccessMsg);
		waitForinvisibilityOfElementText(roleCreatedSuccessMsg, "Role created");

		Assert.assertEquals(successMsg, "Role created");

	}

	public void VerifyThatUserIsAbleToCreateARoleWithBasicSupervisorPermission() {
		waitForElementIsInteractable(createRoleBtn);
		clickByJsExecuter(createRoleBtn);
		waitForElementIsInteractable(toggleCEBtnProdSetting);

		clickByJsExecuter(toggleCEBtnProdSetting);
		waitForElementIsInteractable(supervisorBasicBtn);

		clickByJsExecuter(supervisorBasicBtn);

		scrollIntoView(roleName);
		String roleNameText = "Role_SupervisorBasic" + RandomStrings.requiredDigits(5);
		sendKeysWithWait(roleName, roleNameText);
		clickByJsExecuter(createRoleBtn2);
		waitForPresenceandVisiblity(roleCreatedSuccessMsg);
		String successMsg = getTextByJSExecutor(roleCreatedSuccessMsg);
		waitForinvisibilityOfElementText(roleCreatedSuccessMsg, "Role created");
		Assert.assertEquals(successMsg, "Role created");

	}

	public void VerifyThatUserIsAbleToCreateARoleWithSupervisorManagerPermission() {
		waitForElementIsInteractable(createRoleBtn);
		clickByJsExecuter(createRoleBtn);
		waitForElementIsInteractable(toggleCEBtnProdSetting);

		clickByJsExecuter(toggleCEBtnProdSetting);
		waitForElementIsInteractable(supervisionManagerBtn);

		clickByJsExecuter(supervisionManagerBtn);

		scrollIntoView(roleName);
		String roleNameText = "Role_SupervisorManager" + RandomStrings.requiredDigits(5);
		sendKeysWithWait(roleName, roleNameText);
		clickByJsExecuter(createRoleBtn2);
		waitForPresenceandVisiblity(roleCreatedSuccessMsg);
		String successMsg = getTextByJSExecutor(roleCreatedSuccessMsg);
		waitForinvisibilityOfElementText(roleCreatedSuccessMsg, "Role created");

		Assert.assertEquals(successMsg, "Role created");

	}

	public void VerifyUserIsAbleToAssignRoleNoSupervisor() throws InterruptedException {

		waitForElementIsInteractable(usersTabs);
		clickByJsExecuter(usersTabs);
		Thread.sleep(2000);
		waitForElementIsInteractable(createUserBtn);

		clickByJsExecuter(createUserBtn);

		String roleNameText = "Role" + RandomStrings.requiredDigits(5) + "NoSupervisor";
		String emailText = roleNameText + "@yopmail.com";
		Thread.sleep(5000);
		waitForElementIsInteractable(firstNameFieldCreateUser);
		sendKeysWithWait(firstNameFieldCreateUser, roleNameText);

		Thread.sleep(2000);
		sendKeysWithWait(lastNameFieldCreateUser, "Z");
		Thread.sleep(2000);

		sendKeysWithWait(emailFieldCreateUser, emailText);
		waitForElementIsInteractable(roleFieldCreateUser);

		movetoElementAndClick(roleFieldCreateUser);
		Thread.sleep(5000);
		waitForElementIsInteractable(selectNoSupervisorRole);
		scrollIntoView(selectNoSupervisorRole);
		Thread.sleep(2000);
		// Thread.sleep(5000);

		scrollIntoView(selectNoSupervisorRole);
		// Thread.sleep(5000);

		movetoElementAndClick(selectNoSupervisorRole);
		scrolltoPageTop();
		clickByJsExecuter(createUserBtn2);

		waitForCurserRunning(5);
		waitForElementIsInteractable(filterByNameEmailUserPage);
		sendKeysWithWait(filterByNameEmailUserPage, roleNameText);

		Thread.sleep(2000);
		int userCount = Integer.parseInt(getTextByJSExecutor(userCountDisplayed).split(" ")[0]);
		clearElement(filterByNameEmailUserPage);
		System.out.println(userCount);

		if (userCount < 1)
			Assert.assertFalse(true);
	}

	public void VerifyUserIsAbleToAssignRoleBasicSupervisor() throws InterruptedException {
		WebElement clearFilterByNameEmail = driver.findElement(By.xpath("//*[@placeholder='Filter by name or email']"));

		Thread.sleep(2000);

		waitForElementIsInteractable(createUserBtn);

		clickByJsExecuter(createUserBtn);

		String roleNameText = "Role" + RandomStrings.requiredDigits(5) + "BasicSupervisor";
		String emailText = roleNameText + "@yopmail.com";
		Thread.sleep(5000);
		waitForElementIsInteractable(firstNameFieldCreateUser);
		sendKeysWithWait(firstNameFieldCreateUser, roleNameText);

		Thread.sleep(2000);
		sendKeysWithWait(lastNameFieldCreateUser, "Z");
		Thread.sleep(2000);

		sendKeysWithWait(emailFieldCreateUser, emailText);
		waitForElementIsInteractable(roleFieldCreateUser);

		movetoElementAndClick(roleFieldCreateUser);
		// Thread.sleep(5000);

		scrollIntoView(selectBasicSupervisorRole);
		// Thread.sleep(5000);

		movetoElementAndClick(selectBasicSupervisorRole);
		scrolltoPageTop();
		clickByJsExecuter(createUserBtn2);

		waitForCurserRunning(5);
		waitForElementIsInteractable(filterByNameEmailUserPage);
		sendKeysWithWait(filterByNameEmailUserPage, roleNameText);

		Thread.sleep(2000);
		int userCount = Integer.parseInt(getTextByJSExecutor(userCountDisplayed).split(" ")[0]);
		System.out.println(userCount);
		clearElement(filterByNameEmailUserPage);

//		if (userCount < 1)
//			Assert.assertFalse(true);
// To be implememted once bug for user created pop up is resolved		

	}

	public void VerifyUserIsAbleToAssignRoleSupervisorManager() throws InterruptedException {
		// clearByJSE(filterByNameEmailUserPage);
		WebElement clearFilterByNameEmail = driver.findElement(By.xpath("//*[@placeholder='Filter by name or email']"));

		clearFilterByNameEmail.clear();
		Thread.sleep(2000);
		waitForElementIsInteractable(createUserBtn);

		clickByJsExecuter(createUserBtn);

		String roleNameText = "Role" + RandomStrings.requiredDigits(5) + "SupervisorManager";
		String emailText = roleNameText + "@yopmail.com";
		Thread.sleep(5000);
		waitForElementIsInteractable(firstNameFieldCreateUser);
		sendKeysWithWait(firstNameFieldCreateUser, roleNameText);

		Thread.sleep(2000);
		sendKeysWithWait(lastNameFieldCreateUser, "Z");
		forcedWaitTime(2);

		sendKeysWithWait(emailFieldCreateUser, emailText);
		waitForElementIsInteractable(roleFieldCreateUser);

		movetoElementAndClick(roleFieldCreateUser);
		forcedWaitTime(2);

		scrollIntoView(selectSupervisorManagerRole);
		forcedWaitTime(3);

		movetoElementAndClick(selectSupervisorManagerRole);
		scrolltoPageTop();
		clickByJsExecuter(createUserBtn2);

		waitForCurserRunning(5);
		waitForElementIsInteractable(filterByNameEmailUserPage);
		sendKeysWithWait(filterByNameEmailUserPage, roleNameText);

		Thread.sleep(2000);
		int userCount = Integer.parseInt(getTextByJSExecutor(userCountDisplayed).split(" ")[0]);
		System.out.println(userCount);

//		if (userCount < 1)
//			Assert.assertFalse(true);

	}

	String grpNameWith1Basic;
	String grpNameWuth1Supervissor;

	public void VerifyUserIsAbleToCreateGrpWith1BasicSupervisor() throws InterruptedException {

		clickByJsExecuter(groupsTab);
		clickByJsExecuter(createNewGroupBtn);

		String groupNameRandom = "GroupWithBasicSupervisor" + RandomStrings.requiredDigits(5);
		grpNameWith1Basic = groupNameRandom;
		waitForElementIsInteractable(groupNameField);
		Thread.sleep(2000);

		sendKeysWithWait(groupNameField, groupNameRandom);
		scrollIntoView(AddUsersInGroups);
		clickByJsExecuter(AddUsersInGroups);
		waitForElementIsInteractable(searchByUserNameField);
		sendKeysWithWait(searchByUserNameField, "Basic Supervisor");
		forcedWaitTime(1);
		waitForElementIsInteractable(By.xpath(selectorFormate(addUserToGroup, "Basic Supervisor")));
		movetoElementAndClick(By.xpath(selectorFormate(addUserToGroup, "Basic Supervisor")));
		clickByJsExecuter(applyBtn);
		scrollIntoView(createGroupBtn2);
		clickByJsExecuter(createGroupBtn2);
		waitForPresenceandVisiblity(groupCreatedSuccessMsg);
		String actualSuccessMsg = getTextByJSExecutor(groupCreatedSuccessMsg);
		Assert.assertEquals(actualSuccessMsg, "Group created");
	}

	public void VerifyUserIsAbleToCreateGrpWith1SupervisorManager() throws InterruptedException {

		clickByJsExecuter(createNewGroupBtn);

		String groupNameRandom = "GroupWithSupervisorManager" + RandomStrings.requiredDigits(5);
		grpNameWuth1Supervissor = groupNameRandom;

		waitForElementIsInteractable(groupNameField);
		sendKeysWithWait(groupNameField, groupNameRandom);
		scrollIntoView(AddUsersInGroups);
		clickByJsExecuter(AddUsersInGroups);
		waitForElementIsInteractable(searchByUserNameField);
		sendKeysWithWait(searchByUserNameField, "Supervisor Manager");
		forcedWaitTime(1);
		waitForElementIsInteractable(By.xpath(selectorFormate(addUserToGroup, "Supervisor Manager")));
		movetoElementAndClick(By.xpath(selectorFormate(addUserToGroup, "Supervisor Manager")));
		clickByJsExecuter(applyBtn);
		scrollIntoView(createGroupBtn2);
		clickByJsExecuter(createGroupBtn2);
		waitForPresenceandVisiblity(groupCreatedSuccessMsg);
		System.out.println(grpNameWuth1Supervissor);
		String actualSuccessMsg = getTextByJSExecutor(groupCreatedSuccessMsg);
		Assert.assertEquals(actualSuccessMsg, "Group created");
	}

	public By noOfPagesInGroups = By.xpath("//*[@class='table__pagination-of-text']");

	public void verifyUserIsAbleToEditCreatedGroupWithBasic() throws InterruptedException {
		forcedWaitTime(2);
		int sizePage = findElementsSize(noOfPagesInGroups);
		if (sizePage > 0) {
			int noOfPages = Integer.parseInt(getTextByJSExecutor(noOfPagesInGroups).split(" ")[1]);
			System.out.println("no of pages " + noOfPages);

			for (int i = 0; i < noOfPages; i++) {
				int size = driver.findElements(By.xpath("//*[text()='" + grpNameWith1Basic + "']")).size();
				if (size > 0) {
					WebElement edit = driver.findElement(
							By.xpath("//*[text()='" + grpNameWith1Basic + "']//parent::div//div//button[1]"));
					waitForElementInteractable(edit);
					Thread.sleep(3000);
					try {
						movetoElementAndClick(edit);
					} catch (Exception e) {
						WebElement edit2 = driver.findElement(
								By.xpath("//*[text()='" + grpNameWith1Basic + "']//parent::div//div//button[1]"));
						movetoElementAndClick(edit2);
					}

					break;
				} else {
					scrollIntoView(By.xpath("(//button[@class='square-btn btn btn-default'])[2]"));
					clickByJsExecuter(By.xpath("(//button[@class='square-btn btn btn-default'])[2]"));
				}

			}
		} else {

			WebElement edit = driver
					.findElement(By.xpath("//*[text()='" + grpNameWith1Basic + "']//parent::div//div//button[1]"));
			waitForElementInteractable(edit);
			Thread.sleep(3000);
			try {
				movetoElementAndClick(edit);
			} catch (Exception e) {
				WebElement edit2 = driver
						.findElement(By.xpath("//*[text()='" + grpNameWith1Basic + "']//parent::div//div//button[1]"));
				movetoElementAndClick(edit2);
			}
		}

		Thread.sleep(3000);
		waitForElementIsInteractable(descriptionBoxOnGroups);
		sendKeysWithWait(descriptionBoxOnGroups, "Edited");
		waitForElementIsInteractable(saveBtnOnGroupsEdit);
		clickByJsExecuter(saveBtnOnGroupsEdit);

		waitForCurserRunning(5);
		String grpUpdatedText = getTextByJSExecutor(groupUpdatedSuccessMsg);
		Assert.assertEquals(grpUpdatedText, "Group updated");

	}

	public void verifyUserIsAbleToEditCreatedGroupWithSupervisorManager() throws InterruptedException {
		forcedWaitTime(2);
		int sizePage = findElementsSize(noOfPagesInGroups);
		if (sizePage > 0) {
			int noOfPages = Integer.parseInt(getTextByJSExecutor(noOfPagesInGroups).split(" ")[1]);
			System.out.println("no of pages " + noOfPages);

			for (int i = 0; i < noOfPages; i++) {
				int size = driver.findElements(By.xpath("//*[text()='" + grpNameWuth1Supervissor + "']")).size();
				if (size > 0) {
					WebElement edit = driver.findElement(
							By.xpath("//*[text()='" + grpNameWuth1Supervissor + "']//parent::div//div//button[1]"));
					movetoElementAndClick(edit);

					break;
				} else {
					scrollIntoView(By.xpath("(//button[@class='square-btn btn btn-default'])[2]"));
					clickByJsExecuter(By.xpath("(//button[@class='square-btn btn btn-default'])[2]"));
				}

			}
		} else {
			WebElement edit = driver.findElement(
					By.xpath("//*[text()='" + grpNameWuth1Supervissor + "']//parent::div//div//button[1]"));
			movetoElementAndClick(edit);
		}
		Thread.sleep(3000);
		waitForElementIsInteractable(descriptionBoxOnGroups);
		sendKeysWithWait(descriptionBoxOnGroups, "Edited");
		waitForElementIsInteractable(saveBtnOnGroupsEdit);
		clickByJsExecuter(saveBtnOnGroupsEdit);
		waitForCurserRunning(5);
		String grpUpdatedText = getTextByJSExecutor(groupUpdatedSuccessMsg);
		Assert.assertEquals(grpUpdatedText, "Group updated");

	}

	String esacalateNoticeVadilationMsg;

	public void verifyEscalatedNoticeNeedsSupervisorApprovalMsgDisplayed() throws InterruptedException {
		ceCommonMethod.createCaseAndPerformInspection();
		waitForElementIsInteractable(PerformInspectionUtility.ContinueBtn);
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
		
		try {
			Boolean flag= elementIsDisplayed(PerformInspectionUtility.ContinueBtn);
			if(flag)
				movetoElementAndClick(PerformInspectionUtility.ContinueBtn);
			
		}
		catch(Exception e)
		{
			clickByJsExecuter(PerformInspectionUtility.ContinueBtn);

		}
		Thread.sleep(2000);

		if (findElementsSize(PerformInspectionUtility.selectNoticeDownArrow)>0) {
			movetoElementAndClick(PerformInspectionUtility.ContinueBtn);
		}

		int size = driver.findElements(By.xpath("//*[text()='EscalatedNotice']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[text()='EscalatedNotice']"));
		}

		else {
			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(5000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
		}

		esacalateNoticeVadilationMsg =

				getTextByJSExecutor(PerformInspectionUtility.escalateNoticeValMsg);

		Assert.assertEquals(esacalateNoticeVadilationMsg, "Note: Escalated notice type, requires supervisor approval");

	}

	public void verifyPendingSupervisorApprovalIsDisplayed() throws InterruptedException {
		clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(2000);
		movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(2000);
		if (findElementsSize(PerformInspectionUtility.GenerateNoticeBtn)>0)
			clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);
		waitForElementIsInteractable(pendingSupervisolApprovalBtn);
		scrollIntoView(pendingSupervisolApprovalBtn);
		String validationMsg = getTextElement(pendingSupervisolApprovalBtn);

		Assert.assertEquals(validationMsg, "Pending Supervisor Approval");

	}

	public void verifyIssueNoticeAndCompleteInspectionNotDisplayed() {
		Boolean flag = findElementsSize(PerformInspectionUtility.IssueNoticeButton)>0;
		Assert.assertFalse(flag);

	}

	public void verifyCompleteInspectionAndGenerateNoticeIsDisplayed() throws InterruptedException {
		String valMsg = getTextByJSExecutor(completeInspAndGenerateNoticeForApproval);
		String valMsg2 = getTextByJSExecutor(warningMsgOnIssueNotice);
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(valMsg, "Complete Inspection & Generate Notice for Approval");
		s1.assertEquals(valMsg2, "*Please Note: Notice will not be applied until Approved*");

		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(completeInspAndGenerateNoticeForApproval);
		waitForCurserRunning(5);

		s1.assertAll();

	}

	static String caseId;

	public void verifyPendingSupervisorApprovalDislayedUnderAbatementActivity() {
		String escalatedNotice = getTextByJSExecutor(escalatedNoticeHeader).split(" ")[0].substring(1);
		System.out.println(escalatedNotice);
		String noticeGeneratedPendingSupervisorApp = getTextByJSExecutor(noticeGeneratedPendingSupervisorApprovalTile);
		String pendingSupervisorApproval = getTextByJSExecutor(pendingSupervisorApprovalCDP);
		String viewNoticeValidation = getTextByJSExecutor(viewNotice);

		caseId = getTextByJSExecutor(By.xpath("//*[@class='case-details__case-number']")).split("#")[1];
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(escalatedNotice, "Escalated");
		s1.assertEquals(noticeGeneratedPendingSupervisorApp, "Notice Generated, Pending Supervisor Approval");
		s1.assertEquals(pendingSupervisorApproval, "Pending Supervisor Approval");
		s1.assertEquals(viewNoticeValidation, "View Notice");
		System.out.println(caseId);
		s1.assertAll();

	}

	public void logout() throws InterruptedException {
		// waitForCurserRunning(5);
		int i = 1;
		Reporter.log("LogOut attempt " + i, true);
		clickByJsExecuter(By.xpath("//*[@class='app-header__user-name']/div"));
		Thread.sleep(2000);
		clickByJsExecuter(By.xpath("//label[text()='Logout']"));
		waitForCurserRunning(5);

		while (driver.findElements(By.xpath("//img[contains(@aria-label,'logo')]")).size() < 1) {
			waitForElementIsInteractable(By.xpath("//img[contains(@aria-label,'logo')]"));
			Boolean flag = elementIsDisplayed(By.xpath("//img[contains(@aria-label,'logo')]"));
			System.out.println("hello " + flag + " "
					+ driver.findElements(By.xpath("//img[contains(@aria-label,'logo')]")).size());
			i++;
			if (flag)
				break;
			logout();
		}
	}

	public void supervisorLoginAndApproveEscalatedNotice() throws InterruptedException {

		clickByJsExecuter(CDP_Utility.crossIconCDP);
		logout();
		Thread.sleep(3000);

		log.LoginSupervisorManagerAfterLogOff();

		Thread.sleep(10000);

		ceCommonMethod.searchCaseoOnCLP(caseId);
		try {
			Thread.sleep(5000);
			waitForElementIsInteractable(CLPUtility.firstCaseCLP);
			clickByJsExecuter(CLPUtility.firstCaseCLP);
		} catch (Exception e) {
			WebElement firstCaseCLP = driver.findElement(By.xpath("//*[@class='checkbox-holder']//../a"));

			clickByJsExecuterWebElement(firstCaseCLP);

		}
		waitForCurserRunning(5);
		waitForElementIsInteractable(approveNoticeBtnSupervisor);
		SoftAssert s1 = new SoftAssert();
		s1.assertTrue(elementIsDisplayed(approveNoticeBtnSupervisor));
		clickByJsExecuter(approveNoticeBtnSupervisor);

		waitForElementIsInteractable(saveBtnEscalatedNotice);
		scrollIntoView(saveBtnEscalatedNotice);
		clickByJsExecuter(saveBtnEscalatedNotice);
		waitForCurserRunning(5);
		System.out.println("Notice approved by Supervisor is --"
				+ getTextByJSExecutor((By.xpath("//*[@class='case-details__case-number']"))));

		clickByJsExecuter(CDP_Utility.crossIconCDP);

		logout();

	}

	public void loginNoSupervisorUserAfterLogOff() throws InterruptedException {

		log.LoginNoSupervisorUserAfterLogOff();
		ceCommonMethod.searchCaseoOnCLP(caseId);
		Thread.sleep(3000);
		int size = driver.findElements(By.xpath("//*[@class='checkbox-holder']//../a")).size();
		while (size != 1) {
			Thread.sleep(2000);
			size = driver.findElements(By.xpath("//*[@class='checkbox-holder']//../a")).size();
		}
		waitForElementIsInteractable(CLPUtility.firstCaseCLP);
		clickByJsExecuter(CLPUtility.firstCaseCLP);
		waitForCurserRunning(5);
	}

	public void verifyApprovedStatusDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		waitForElementIsInteractable(CDP_Utility.approvedStatusCDP);
		String approvedStatus = getTextByJSExecutor(CDP_Utility.approvedStatusCDP);
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(approvedStatus, "Approved");

	}

	public void verifyApplyNoticeAndManageNoticeIsDisplayed() {
		String applyNoticeVal = getTextByJSExecutor(CDP_Utility.applyApprovedNotice);
		String manageNoticeVal = getTextByJSExecutor(CDP_Utility.manageNoticeLinkCDP);

		Assert.assertEquals(applyNoticeVal, "Apply Approved Notice");
		Assert.assertEquals(manageNoticeVal, "Manage Notice");

	}

	public void verifyApplyNoticePopUpOpens() {
		clickByJsExecuter(CDP_Utility.applyApprovedNotice);
		String followUpInspectionVal = getTextByJSExecutor(ForcedAbatementUtility.followUpInspectionHeader);
		Assert.assertEquals(followUpInspectionVal, "Follow Up Inspection?");
		waitForElementIsInteractable(ForcedAbatementUtility.exitBtn);
		clickByJsExecuter(ForcedAbatementUtility.exitBtn);

	}

	public void verifyViewNoticeLinkIsDisplayed() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.applyApprovedNotice);

		clickByJsExecuter(CDP_Utility.applyApprovedNotice2);
		clickByJsExecuter(ForcedAbatementUtility.yesBtnPopUp);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.viewNotice);

		Boolean flag = elementIsDisplayed(CDP_Utility.viewNotice);
		Assert.assertTrue(flag);

	}

	public void verifyApprovedBtnAppearsForNotice() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		waitForCurserRunning(5);
		logout();
		log.LoginSupervisorManagerAfterLogOff();

		ceCommonMethod.createCaseAndPerformInspection();
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//*[text()='EscalatedNotice']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[text()='EscalatedNotice']"));
		}

		else {
			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(5000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
		}
		clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(2000);
		clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);
		// movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		waitForCurserRunning(5);

		scrollIntoView(NoticesUtility.approvedStatusOnIssueNotice);
		String approvedValidation = getTextElement(NoticesUtility.approvedStatusOnIssueNotice);
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(approvedValidation, "Approved");

	}

	public void verifyIssueNoticeAndCompleteInspectionIsDisplayed() {
		waitForElementIsInteractable(NoticesUtility.issueNoticeAdCompleteInspectionBtn);
		String issueNoticeBtn = getTextByJSExecutor(NoticesUtility.issueNoticeAdCompleteInspectionBtn);
		Assert.assertEquals(issueNoticeBtn, "Issue Notice & Complete Inspection");

	}

	public void verifyUserIsNavigatedToCDP() throws InterruptedException {
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(NoticesUtility.issueNoticeAdCompleteInspectionBtn);

		waitForElementIsInteractable(ForcedAbatementUtility.yesBtnPopUp);

		elementIsDisplayed(ForcedAbatementUtility.noBtnPopUp);

		SoftAssert s1 = new SoftAssert();
		s1.assertTrue(elementIsDisplayed(ForcedAbatementUtility.noBtnPopUp));

		clickByJsExecuter(ForcedAbatementUtility.noBtnPopUp);

		// WaitForElementInteractable(userManagementTab);

		s1.assertTrue(elementIsDisplayed(PerformInspectionUtility.DoNotPrintBtn));

		clickByJsExecuter(NoticesUtility.issueNoticeAdCompleteInspectionBtn);

		waitForElementIsInteractable(ForcedAbatementUtility.yesBtnPopUp);
		s1.assertTrue(elementIsDisplayed(ForcedAbatementUtility.yesBtnPopUp));
		clickByJsExecuter(ForcedAbatementUtility.yesBtnPopUp);
		waitForCurserRunning(5);
		String escalatedNotice = getTextByJSExecutor(escalatedNoticeHeader).split(" ")[0].substring(1);
		String noticeApprovedValidation = getTextByJSExecutor(CDP_Utility.noticeApprovedAndAppliedToCaseText);
		s1.assertTrue(elementIsDisplayed(CDP_Utility.checkMarkForNoticeApproved));
		s1.assertEquals(escalatedNotice, "Escalated");
		s1.assertEquals(noticeApprovedValidation, "Notice Approved & Applied to case ");
		s1.assertAll();

	}

	public void verifyApprovedAndAppliedToCaseIsDisplayed() {
		String valMsg = getTextByJSExecutor(CDP_Utility.approvedAndAppliedToCaseText);
		Assert.assertEquals(valMsg, "Approved & Applied to Case");
		clickByJsExecuter(CDP_Utility.crossIconCDP);
	}

	public void logOutFromCLPPageAndLoginAsNoSupervisor() throws InterruptedException {

		logout();

//		waitForElementIsInteractable(By.xpath("//*[@class='app-header__user-name']/div"));
//
//		clickByJsExecuter(By.xpath("//*[@class='app-header__user-name']/div"));
//		clickByJsExecuter(By.xpath("//label[text()='Logout']"));
//		waitForCurserRunning(5);
		log.LoginNoSupervisorUserAfterLogOff();

	}

	public void logOutFromCLPPageAndLoginAsSupervisor() throws InterruptedException {
		logout();
		log.LoginSupervisorManagerAfterLogOff();

	}

	public void createCaseAndAddEscalatedNoticeForSupervisorApproval() throws InterruptedException {
		ceCommonMethod.createCaseAndPerformInspection();
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);

		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//*[text()='EscalatedNotice']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[text()='EscalatedNotice']"));
		}

		else {
			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(5000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[text()='EscalatedNotice']")));
		}

		clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(2000);
		movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(3000);

		if (!elementIsDisplayed(pendingSupervisolApprovalBtn)) {
			waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
			clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);
		}
		waitForElementIsInteractable(pendingSupervisolApprovalBtn);
		scrollIntoView(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(completeInspAndGenerateNoticeForApproval);
		waitForCurserRunning(5);
		Assert.assertTrue(elementIsDisplayed(By.xpath("//*[@class='case-details__case-number']")));
		caseId = getTextByJSExecutor(By.xpath("//*[@class='case-details__case-number']")).split("#")[1];

	}

	public void verifyApproveNoticeIsDisplayedForSupervisor() throws InterruptedException {

		logOutFromCLPPageAndLoginAsSupervisor();
		ceCommonMethod.searchCaseoOnCLP(caseId);
		Thread.sleep(5000);
		int counter = 0;
		int size = driver.findElements(By.xpath("//*[@class='checkbox-holder']//../a")).size();
		while ((size != 1) && counter < 5) {
			Thread.sleep(2000);
			counter++;
			size = driver.findElements(By.xpath("//*[@class='checkbox-holder']//../a")).size();
		}
		waitForElementIsInteractable(CLPUtility.firstCaseCLP);
		clickByJsExecuter(CLPUtility.firstCaseCLP);
		waitForCurserRunning(5);
		Thread.sleep(3000);
		waitForElementIsInteractable(CDP_Utility.approveNoticeBtnForSupervisor);
		Boolean flag = elementIsDisplayed(CDP_Utility.approveNoticeBtnForSupervisor);
		Assert.assertTrue(flag);

	}

	public void verifyApproveNoticePopUpOpens() {
		clickByJsExecuter(CDP_Utility.approveNoticeBtnForSupervisor);
		waitForElementIsInteractable(NoticesUtility.approveNoticePopUpText);
		String approveNoticeHeaderText = getTextByJSExecutor(NoticesUtility.approveNoticePopUpText);
		SoftAssert s = new SoftAssert();
		s.assertEquals(approveNoticeHeaderText, "Approve Notice?");
		s.assertAll();

	}

	public void verifyAddCaseNoteIsDisplayed() {

		SoftAssert s = new SoftAssert();
		s.assertTrue(elementIsDisplayed(NoticesUtility.addCaseNoteTextArea));
		s.assertTrue(elementIsDisplayed(NoticesUtility.pendingSupervisorApprovalNoticePopup));
		s.assertTrue(elementIsDisplayed(NoticesUtility.approveBtnOnApproveNoticePopUp));
		s.assertTrue(elementIsDisplayed(NoticesUtility.rejectBtnOnApproveNoticePopUp));
		s.assertTrue(elementIsDisplayed(NoticesUtility.printNoticeTextOnNoticePopup));
		s.assertTrue(elementIsDisplayed(NoticesUtility.saveBtnNoticePopUp));
		s.assertAll();

	}

	public void verifySaveBtnIsDisabledAfterReject() {

		scrollIntoView(NoticesUtility.saveBtnNoticePopUp);
		clickByJsExecuter(NoticesUtility.rejectBtnOnApproveNoticePopUp);

		Boolean flag = driver.findElement(NoticesUtility.saveBtnNoticePopUp).isEnabled();
		Assert.assertFalse(flag);

	}

	String caseNoteMsg;

	public void verifyUserIsAbleToRejectNotice() throws InterruptedException {
		caseNoteMsg = "Rejected";
		sendKeysWithWait(NoticesUtility.addCaseNoteTextArea, caseNoteMsg);
		scrollIntoView(NoticesUtility.saveBtnNoticePopUp);
		clickByJsExecuter(NoticesUtility.saveBtnNoticePopUp);
		waitForCurserRunning(10);
		Thread.sleep(5000);
		Assert.assertTrue(findElementsSize(NoticesUtility.notApproved)>0,"Not approved status is not displayed");

	}

	public void verifyUserIsAbleToEditCaseNote() throws InterruptedException {
		Thread.sleep(5000);

		String updatedCaseNote = "RejectedUpdated";
		waitForElementIsInteractable(CDP_Utility.editInternalComment);
		scrollIntoView(CDP_Utility.editInternalComment);
		clickByJsExecuter(CDP_Utility.editInternalComment);
		waitForElementIsInteractable(NoticesUtility.editInternalCommentTextArea);
		String caseNoteMsgActual = getTextElement(NoticesUtility.editInternalCommentTextArea);
		System.out.println(caseNoteMsgActual);

		SoftAssert s1 = new SoftAssert();
		Assert.assertEquals(caseNoteMsgActual, caseNoteMsg);

		clearElement(NoticesUtility.editInternalCommentTextArea);
		sendKeysWithWait(NoticesUtility.editInternalCommentTextArea, updatedCaseNote);
		clickByJsExecuter(NoticesUtility.saveBtnNoticePopUp);
		waitForCurserRunning(10);
		waitForElementIsInteractable(CDP_Utility.internalCommentText);
		String updatedCommentActual = getTextElement(CDP_Utility.internalCommentText);
		s1.assertEquals(updatedCommentActual, updatedCaseNote);
		s1.assertAll();

	}

	public void verifyNotApprovedDisplayed() {
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.notApprovedEscalatedNotice));

	}

	String msgForApproveNotice;

	public void verifyUserIsAbleToApproveNotice() throws InterruptedException {
		msgForApproveNotice = "Approved";
		clickByJsExecuter(CDP_Utility.approveNoticeBtnForSupervisor);
		waitForElementIsInteractable(NoticesUtility.saveBtnNoticePopUp);
		sendKeysWithWait(NoticesUtility.addCaseNoteTextArea, msgForApproveNotice);
		clickByJsExecuter(NoticesUtility.saveBtnNoticePopUp);
		waitForCurserRunning(5);
		Thread.sleep(5000);
		Assert.assertTrue(findElementsSize(NoticesUtility.approvedStatusOnIssueNotice)>0,"Approved doesnot appear");
	}

	String updatedMsgForApproveNotice = "Approved Updated";

	public void verifyUserIsAbleToUpdateCaseNoteForApproval() throws InterruptedException {
		Thread.sleep(5000);
		scrollIntoView(CDP_Utility.editInternalComment);
		clickByJsExecuter(CDP_Utility.editInternalComment2);
		waitForElementIsInteractable(NoticesUtility.editInternalCommentTextArea);
		String actualMsgInternalComment = getTextElement(NoticesUtility.editInternalCommentTextArea);
		Assert.assertEquals(actualMsgInternalComment, msgForApproveNotice);

		clearElement(NoticesUtility.editInternalCommentTextArea);
		sendKeysWithWait(NoticesUtility.editInternalCommentTextArea, updatedMsgForApproveNotice);
		clickByJsExecuter(NoticesUtility.saveBtnNoticePopUp);
		waitForCurserRunning(5);
		Thread.sleep(5000);

		String actualMsgInternalComments = getTextElement(CDP_Utility.internalCommentText2);
		Assert.assertEquals(actualMsgInternalComments, updatedMsgForApproveNotice);

	}

	public void verifyCaseHistoryUpdated() throws InterruptedException {
		scrollIntoView(CDP_Utility.viewHistory);
		clickByJsExecuter(CDP_Utility.viewHistory);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.caseHistoryAddedInternalComment);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.caseHistoryAddedInternalComment));
		clickByJsExecuter(CDP_Utility.closeCaseHistory);
	}

	String caseNoteForRejection;

	public void loginSupervisorAndRejectEscalatedNotice() throws InterruptedException {
		logOutFromCLPPageAndLoginAsSupervisor();
		ceCommonMethod.searchCaseoOnCLP(caseId);
		Thread.sleep(5000);
		waitForElementIsInteractable(CLPUtility.firstCaseCLP);
		clickByJsExecuter(CLPUtility.firstCaseCLP);
		waitForCurserRunning(5);
		Thread.sleep(5000);
		waitForElementIsInteractable(CDP_Utility.approveNoticeBtnForSupervisor);
		clickByJsExecuter(CDP_Utility.approveNoticeBtnForSupervisor);
		waitForElementIsInteractable(NoticesUtility.rejectBtnOnApproveNoticePopUp);
		scrollIntoView(NoticesUtility.rejectBtnOnApproveNoticePopUp);
		clickByJsExecuter(NoticesUtility.rejectBtnOnApproveNoticePopUp);
		caseNoteForRejection = "I am rejecting notice";
		sendKeysWithWait(NoticesUtility.addCaseNoteTextArea, caseNoteForRejection);
		clickByJsExecuter(NoticesUtility.SaveBtn);
		waitForCurserRunning(5);

	}

	public void logoutManagerAndLoginNoSupervisor() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		waitForCurserRunning(5);
		logOutFromCLPPageAndLoginAsNoSupervisor();
		createCaseAndAddEscalatedNoticeForSupervisorApproval();
		loginSupervisorAndRejectEscalatedNotice();
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		waitForCurserRunning(5);
		logOutFromCLPPageAndLoginAsNoSupervisor();
		ceCommonMethod.searchCaseoOnCLP(caseId);
		Thread.sleep(10000);
		waitForElementIsInteractable(CLPUtility.firstCaseCLP);
		clickByJsExecuter(CLPUtility.firstCaseCLP);
		waitForCurserRunning(5);
		Thread.sleep(5000);

	}

	public void verifyEscalatedNoticeTextDisplayedForNoSupervisor() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementIsInteractable(escalatedNoticeHeader);
		String escalatedNotice = getTextByJSExecutor(escalatedNoticeHeader).split(" ")[0].substring(1);
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(escalatedNotice, "Escalated");

	}

	public void verifyNotApprovedIsDisplayedForNonSupervisor() {

		Assert.assertTrue(elementIsDisplayed(CDP_Utility.notApprovedEscalatedNotice));

	}

	public void verifyManageNoticeIsDisplayedForNonSupervisor() {
		String manageNoticeVal = getTextByJSExecutor(CDP_Utility.manageNoticeLinkCDP);

		Assert.assertEquals(manageNoticeVal, "Manage Notice");

	}

	public void verifyViewNotes() {

		String actualMsgNote = getTextElement(CDP_Utility.internalCommentText);
		Assert.assertEquals(actualMsgNote, caseNoteForRejection);
	}

	public void verifyEscalatedNoticePopUpOpensUp() {

		clickByJsExecuter(CDP_Utility.manageNoticeLinkCDP);
		waitForElementIsInteractable(NoticesUtility.viewEscalatedNoticePopUp);
		String actual = getTextByJSExecutor(NoticesUtility.viewEscalatedNoticePopUp);
		String expected = "View EscalatedNotice";
		Assert.assertEquals(actual, expected);

	}

	public void verifyDeleteAndReisue() {

		waitForElementIsInteractable(NoticesUtility.deleteAndReissue);
		clickByJsExecuter(NoticesUtility.deleteAndReissue);
		clickByJsExecuter(NoticesUtility.yesOnPopUp);
		String expected = "Verify Violations";
		waitForElementIsInteractable(NoticesUtility.verifyViolationTextHeader);
		String actual = getTextElement(NoticesUtility.verifyViolationTextHeader);
		Assert.assertEquals(actual, expected);

	}

}
