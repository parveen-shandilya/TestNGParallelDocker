package POM;

import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import CommonMethods.CECommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;

import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class UserManagementUtility extends Helper {

	public WebDriver driver;
	public LoginUtility log;
	public SoftAssert softAssert;
	public CECommonMethods ceCommonMethods;

	public UserManagementUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethods = new CECommonMethods(driver);
		softAssert = new SoftAssert();
	}

	public String createUserButton = "//button[text()='Create User']";
	public static String userMangementSideBar = "//label[text()='User Management']";
	public static String creatUserBtn = "//div[@class='action-item']//button";
	public String createUserPopupTitle = "//h1[text()='Create User']";
	public String firstNameField = "//input[@name='firstName']";
	public String lastNameField = "//input[@name='lastName']";
	public String emailField = "//input[@name='email']";
	public String roleDropdown = "//label[text()='Role']/following::span[1]";
	public String roleOptionselect = "//*[text()='Agency Admin CEM']";
	public String cancelButton = "//button[text()='Cancel']";
	public String searchField = "//input[@placeholder='Filter by name or email']";
	public String usersCount = "//div[@class='agency-setup-tab__section__header']/h2[contains(text(),'Users')]";
	public String roleCount = "//div[@class='agency-setup-tab__section__header']//h2[contains(text(),'Active')]";
	public String searchResultName = "//div[@class='rt-tr -odd']/div";
	public String createUserPopupBtn = "//div[@class='user-form__header full-page-modal__header']//button[text()='Create User']";
	public String editUserIcon = "//button[@class='edit-btn  btn btn-primary']";
	public String editUserpopupTitle = "//h1[text()='Edit User']";
	public String yopmailSearchUser = "//input[@class='ycptinput']";
	public String paginationText = "//span[@class='table__pagination-of-text']";
	public String userSearchResult = "//div[@class='rt-tr-group']";
	public String yopmailInboxArrow = "//button[@class='md']";
	public static String rolesTab = "//div[contains(text(),'Roles')]";
	public static String createRoleButton = "//button[text()='Create Role']";
	public static String createRolePopupTitle = "//h1[text()='Create Role']";
	public static String roleNameField = "//input[@placeholder='Enter Text']";
	public static String descriptionField = "//textarea[@name='description']";
	public static String createRolePopupBtn = "//div[@class='modal-header']//following::button[text() ='Create Role']";
	public static String roleCreatedSuccessMsg = "//span[text()='Role created']";
	public String iframeSwitch = "//iframe[@id='ifmail']";
	public String firstMail = "//button[@class='lm']";
	public String activateBtn = "//span[contains(text(),'Activate')]";
	public String activateOktaBtn = "//span[contains(text(),'Activate Okta Account')]";
	public String activateOktaBtn_Stage = "//span[text()=' Activate Comcate Account ']";
	public String newPassword = "//input[@name='newPassword']";
	public String confirmPassword = "//input[@name='confirmPassword']";
	public String resetPasswordBtn = "//input[@value='Reset Password']";
	public static String productSettingsToggle = "//span[@class='toggle__children']";
	public String deleteReissueYesBtn = "//label[@title='Delete and Reissue Notice']/following::button[text()='Yes'][1]";
	public String basicToggle = "//button[text()='Basic']";
	public String groupsTab = "//div[contains(text(),'Groups')]";
	public String createNewGroupBtn = "//button[text()='Create New Group']";
	public String createGroupPopupTitle = "//h1[text()='Create Group']";
	public String createGroupPopupBtn = "//button[text()='Create Group']";
	public String groupName = "//input[@name='label']";
	public String groupCreatedSuccessMsg = "//span[text()='Group created']";
	public String nextNavigationIcon = "//div[@class='table__pagination-nav-btns']/button[2]";
	public String saveButton = "//button[text()='Save']";
	public String nextPagination = "//div[@class='table__pagination-nav-btns']//button[@class='square-btn btn btn-default'][2]";

	By NextPagination = By.xpath(nextPagination);
	By CreateUserButton = By.xpath(createUserButton);
	public static By agencySetupGearIcon = By.xpath("//label[contains(text(),'Agency Setup')]");

	public static By UserMangementSideBar = By.xpath(userMangementSideBar);
	public static By CreateUserbtn = By.xpath(creatUserBtn);
	By CreateUserPopupTitle = By.xpath(createUserPopupTitle);
	By FirstNameField = By.xpath(firstNameField);
	public By SaveButton = By.xpath(saveButton);
	public By LastNameField = By.xpath(lastNameField);
	public By EmailField = By.xpath(emailField);
	public By RoleDropdown = By.xpath(roleDropdown);
	public By RoleOptionselect = By.xpath(roleOptionselect);
	public By CancelButton = By.xpath(cancelButton);
	public By SearchField = By.xpath(searchField);
	public By CreateUserPopupBtn = By.xpath(createUserPopupBtn);
	public By UsersCount = By.xpath(usersCount);
	public By RoleCount = By.xpath(roleCount);
	public By UserSearchResult = By.xpath(userSearchResult);
	public By EditUserIcon = By.xpath(editUserIcon);
	public By EditUserpopupTitle = By.xpath(editUserpopupTitle);
	public By YopmailSearchUser = By.xpath(yopmailSearchUser);
	public By PaginationText = By.xpath(paginationText);
	public By SearchResultName = By.xpath(searchResultName);
	public By YopmailInboxArrow = By.xpath(yopmailInboxArrow);
	public static By CreateRoleButton = By.xpath(createRoleButton);
	public static By RolesTab = By.xpath(rolesTab);
	public static By CreateRolePopupTitle = By.xpath(createRolePopupTitle);
	public static By RoleNameField = By.xpath(roleNameField);
	public static By DescriptionField = By.xpath(descriptionField);
	public static By CreateRolePopupBtn = By.xpath(createRolePopupBtn);
	public By IframeSwitch = By.xpath(iframeSwitch);
	public By FirstMail = By.xpath(firstMail);
	public By ActivateBtn = By.xpath(activateBtn);
	public By ActivateOktaBtn = By.xpath(activateOktaBtn);
	public By ActivateOktaBtn_stage = By.xpath(activateOktaBtn_Stage);

	public By NewPassword = By.xpath(newPassword);
	public By ConfirmPassword = By.xpath(confirmPassword);
	public By ResetPasswordBtn = By.xpath(resetPasswordBtn);
	public static By RoleCreatedSuccessMsg = By.xpath(roleCreatedSuccessMsg);
	public static By ProductSettingsToggle = By.xpath(productSettingsToggle);
	public By DeleteReissueYesBtn = By.xpath(deleteReissueYesBtn);
	public By BasicToggle = By.xpath(basicToggle);
	public By GroupsTab = By.xpath(groupsTab);
	public By CreateNewGroupBtn = By.xpath(createNewGroupBtn);
	public By CreateGroupPopupTitle = By.xpath(createGroupPopupTitle);
	public By CreateGroupPopupBtn = By.xpath(createGroupPopupBtn);
	public By GroupName = By.xpath(groupName);
	public By GroupCreatedSuccessMsg = By.xpath(groupCreatedSuccessMsg);
	public By NextNavigationIcon = By.xpath(nextNavigationIcon);

	public static By siteSettingUserAdmin = By.xpath(
			"(//h2[text()='Site Settings']//ancestor::div[@class='tile-header-container']//following-sibling::div//button[text()='Yes'])[2]");
	public static By siteSettingSiteAdmin = By.xpath(
			"(//h2[text()='Site Settings']//ancestor::div[@class='tile-header-container']//following-sibling::div//button[text()='Yes'])[1]");

	public static By CRMSettingToggel = By.xpath("//span[@class='toggle__children'][text()='CRM']");
	public static By productAdminYes = By.xpath("(//button[text()='Yes'])[3]");
	public static By basicSupervisorToggle = By.xpath("//button[text()='Supervisor (basic)']");
	public static By supervisorManager = By.xpath("//button[text()='Supervision Manager']");

	public static By allStaffToggel = By.xpath("//button[text()='All Staff']");

	public static By allStaffDashboard = By.xpath("//button[text()='All Staff Dashboard']");

	public static By canVoidWaive = By.xpath("//button[text()='Can Void / Waive']");
	public static By productExecutiveReport = By.xpath("(//button[text()='Yes'])[4]");
	public static By productDeleteAndReissue = By.xpath("(//button[text()='Yes'])[5]");
	public static By violationAnimalBasic = By
			.xpath("//label[@title='Animal']//parent::div//parent::div//button[text()='Basic']");
	public static By generalViolationBasic = By
			.xpath("//label[@title='General']//parent::div//parent::div//button[text()='Basic']");
	public static By crmProductAdminYes = By
			.xpath("(//span[text()='CRM']//parent::label//following-sibling::div//button[text()='Yes'])[1]");
	public static By crmExecutiveReport = By
			.xpath("(//span[text()='CRM']//parent::label//following-sibling::div//button[text()='Yes'])[2]");
	public static By crmPermissionBasic = By
			.xpath("//span[text()='CRM']//parent::label//following-sibling::div//button[text()='Basic']");
	public static By violationAdminOverwrite = By
			.xpath("//label[@title='Animal']//parent::div//parent::div//button[text()='Overwrite']");
	public static By generalViolationOverwrite = By
			.xpath("//label[@title='General']//parent::div//parent::div//button[text()='Overwrite']");
	public static By crmOverwritePermission = By
			.xpath("//span[text()='CRM']//parent::label//following-sibling::div//button[text()='Overwrite']");

	public static By inactiveStatus = By.xpath("//button[normalize-space()='Inactive']");
	public static By commLinkToggle = By.xpath("//button[@class='square-btn btn btn-default'][text()='Can View']");

	public String fname;
	public String lname;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public String UserCreated(String username) {
		String xpath = "//div[contains(text(),'" + username + "')]";
		return xpath;
	}

	public void NavigateTo_AgencySetup() throws InterruptedException {
		waitForPresenceandVisiblity(By.xpath("//div[@class='app-header__menu__icon']"));
		waitForElementIsInteractable(By.xpath("//div[@class='app-header__menu__icon']"));
		scrollIntoView(By.xpath("//div[@class='app-header__menu__icon']"));
		clickByJsExecuter(By.xpath("//div[@class='app-header__menu__icon']"));

		waitForPresenceandVisiblity(By.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']"));
		scrollIntoView(By.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']"));
		waitForElementIsInteractable(
				By.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']"));
		try {
			clickByJsExecuter(By.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']"));
		} catch (Exception e) {
			clickByJsExecuter(agencySetupGearIcon);

		}

		waitForCurserRunning(10);
		waitForPresenceandVisiblity(By.xpath("//label[text()='Audit Trail']"));
		scrollIntoView(By.xpath("//label[text()='Audit Trail']"));
	}

	public void NavigateTo_UserManagement() throws InterruptedException {

		waitUntilElementIsVisible(UserMangementSideBar);
		waitUntilElementPresent(UserMangementSideBar);
		scrollIntoView(UserMangementSideBar);
		waitForElementIsInteractable(UserMangementSideBar);
		Thread.sleep(5000);
		clickByJsExecuter(UserMangementSideBar);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(CreateUserbtn);
		waitUntilElementPresent(CreateUserbtn);
		waitForElementIsInteractable(CreateUserbtn);

	}

	public void UserManagement_OpenCreateUserPopup() throws InterruptedException {

		NavigateTo_AgencySetup();
		NavigateTo_UserManagement();
		scrollIntoView(CreateUserbtn);
		waitForElementIsInteractable(CreateUserbtn);
		clickByJsExecuter(CreateUserbtn);
		Thread.sleep(5000);
		String PopupTitle = getTextElement(CreateUserPopupTitle);
		Assert.assertEquals(PopupTitle, "Create User");
		softAssert.assertAll();
	}

	public String RandomFirstName = RandomStrings.requiredCharacters(6);
	public String RandomLastName = RandomStrings.requiredCharacters(6);

	public void UserManagement_VerifyUserGetsCreated() throws InterruptedException {

		clickOn(CancelButton);
		waitUntilElementInvisibleLocated(CreateUserPopupTitle);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(UsersCount);
		scrollIntoView(CreateUserbtn);
		waitForElementIsInteractable(CreateUserbtn);
		String[] CountUsers1 = getTextElement(UsersCount).split(" ");
		String UsersBefore = CountUsers1[0];
		int TotalUsersBefore = Integer.parseInt(UsersBefore);
		clickByJsExecuter(CreateUserbtn);
		waitUntilElementIsVisible(FirstNameField);
		waitForElementIsInteractable(FirstNameField);
		fname = "CE User " + RandomFirstName;
		// sendKeysWithWait(FirstNameField, "CE User " + RandomFirstName);
		sendKeysWithWait(FirstNameField, fname);
		String s = RandomLastName;
		sendKeysWithWait(LastNameField, s);
		System.out.println("firstName : " + fname);
		String EmailRandom = RandomFirstName + RandomLastName + "@yopmail.com";
		sendKeysWithWait(EmailField, EmailRandom);
		clickOn(RoleDropdown);
		waitForElementIsInteractable(RoleOptionselect);
		clickOn(RoleOptionselect);
		waitForElementIsInteractable(CreateUserPopupBtn);
		clickOn(CreateUserPopupBtn);
		waitUntilElementInvisibleLocated(CreateUserPopupBtn);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(UsersCount);

		lname = (fname + s);
		waitForElementIsInteractable(CreateUserbtn);
		scrollIntoView(UsersCount);
		String[] CountUsers2 = getTextElement(UsersCount).split(" ");
		String UsersAfter = CountUsers2[0];
		int TotalUsersAfter = Integer.parseInt(UsersAfter);
		boolean CompareCount = (TotalUsersAfter == (TotalUsersBefore + 1));
		Assert.assertEquals(CompareCount, true);
		softAssert.assertAll();
	}

	public void UserManagement_VerifySearchUser() throws InterruptedException {

		waitForElementIsInteractable(SearchField);
		sendKeysWithWait(SearchField, RandomFirstName);
		waitForElementIsInteractable(SearchField);
		sendKeysWithWait(SearchField, RandomLastName);

		waitUntilElementIsVisible(By.xpath(UserCreated(RandomLastName)));
		List<WebElement> SearchResults = driver.findElements(UserSearchResult);
		boolean ResultsCount = SearchResults.size() >= 1;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ResultsCount, true);
		soft.assertAll();
		waitUntilElementIsVisible(By.xpath(UserCreated(RandomLastName)));

		String ResultName = getTextElement(SearchResultName);

		String ResultNameExpected = "CE User " + RandomFirstName + " " + RandomLastName;

		Assert.assertEquals(ResultName, ResultNameExpected);
		softAssert.assertAll();
	}

	public void UserManagement_OpenEditUserPopup() throws InterruptedException {

		waitUntilElementIsVisible(EditUserIcon);
		waitForElementIsInteractable(EditUserIcon);
		clickOn(EditUserIcon);
		waitUntilElementIsVisible(EditUserpopupTitle);
		String PopupTitle = getTextElement(EditUserpopupTitle);
		Assert.assertEquals(PopupTitle, "Edit User");
		softAssert.assertAll();
	}

	public void UserManagement_VerifyUpdatedUserDetails() throws InterruptedException {

		waitUntilElementIsVisible(FirstNameField);
		waitForElementIsInteractable(FirstNameField);
		WebElement FirstNameFld = waitUntilVisibleWE(FirstNameField);
		clearByJSE(FirstNameField);
		waitForCurserRunning(2);
		sendKeysWithWait(FirstNameField, "Edited User");
		String RandomStr01 = RandomStrings.requiredCharacters(8);
		WebElement LastNameFld = waitUntilVisibleWE(LastNameField);
		waitForElementIsInteractable(LastNameField);
		LastNameFld.clear();
		waitForCurserRunning(2);
		sendKeysWithWait(LastNameField, RandomStr01);
		clickOn(SaveButton);
		waitForCurserRunning(5);
		forcedWaitTime(3);
		waitUntilElementIsVisible(SearchField);
		WebElement SearchFld = driver.findElement(SearchField);
		waitForElementIsInteractable(SearchField);
		SearchFld.clear();
		waitUntilElementIsVisible(SearchField);
		waitUntilElementPresent(SearchField);
		waitForElementIsInteractable(SearchField);
		sendKeysWithWait(SearchField, "Edited User ");
		waitUntilElementIsVisible(By.xpath(UserCreated("Edited User")));
		waitUntilElementPresent(By.xpath(UserCreated("Edited User")));
		SearchFld.clear();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		waitUntilElementIsVisible(SearchField);
		waitUntilElementPresent(SearchField);
		waitForElementIsInteractable(SearchField);
		waitForElementIsInteractable(SearchField);
		sendKeysWithWait(SearchField, "" + RandomStr01);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath(UserCreated(RandomStr01)));
		waitUntilElementPresent(By.xpath(UserCreated(RandomStr01)));
		List<WebElement> SearchResults = driver.findElements(UserSearchResult);
		boolean ResultsCount = SearchResults.size() >= 1;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ResultsCount, true);
		soft.assertAll();

		waitUntilElementIsVisible(SearchResultName);
		String ResultName = getTextElement(SearchResultName);
		String ResultNameExpected = "Edited User" + " " + RandomStr01;
		Assert.assertEquals(ResultName, ResultNameExpected);
		softAssert.assertAll();
	}
	
	
	public void openYopmailMail(String userEmail) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get("https://yopmail.com/en/");
		waitForPageLoadTime(5);

		waitUntilElementIsVisible(YopmailSearchUser);
		waitForElementIsInteractable(YopmailSearchUser);
		clearByJSE(YopmailSearchUser);
		sendKeysWithWait(YopmailSearchUser, userEmail);
		clickOn(YopmailInboxArrow);
	}

	public void UserManagement_VerifyResetMailReceived() throws AWTException, InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLUserManagement);
		waitForCurserRunning(4);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get("https://yopmail.com/en/");
		waitForPageLoadTime(5);

		waitUntilElementIsVisible(YopmailSearchUser);
		waitForElementIsInteractable(YopmailSearchUser);
		sendKeysWithWait(YopmailSearchUser, (RandomFirstName + RandomLastName));
		clickOn(YopmailInboxArrow);
		waitUntilElementIsVisible(IframeSwitch);
		WebElement switchFrame = waitUntilVisibleWE(IframeSwitch);

		driver.switchTo().frame(switchFrame);
		waitUntilElementIsVisible(ActivateBtn);
		String AOB = getTextElement(ActivateBtn);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA"))
			Assert.assertEquals(AOB.trim(), "Activate Okta Account");
		else
			Assert.assertEquals(AOB.trim(), "Activate Comcate Account");
		softAssert.assertAll();
	}

	public void UserManagement_ResetPasswordForUser() throws InterruptedException {

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			waitForElementIsInteractable(ActivateOktaBtn);
			clickOn(ActivateOktaBtn);
		} else {
			waitForElementIsInteractable(ActivateOktaBtn_stage);
			clickOn(ActivateOktaBtn_stage);
		}

		implicitWaitforCustometime(3);
		ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
		implicitWaitforCustometime(2);
		driver.switchTo().window((String) tabs2.get(2));
		waitForPageLoadTime(2);
		waitUntilElementIsVisible(NewPassword);
		waitUntilElementPresent(NewPassword);
		waitForElementIsInteractable(NewPassword);
		sendKeysWithWait(NewPassword, "Hello@123");
		waitForElementIsInteractable(ConfirmPassword);
		sendKeysWithWait(ConfirmPassword, "Hello@123");
		clickOn(ResetPasswordBtn);
		waitForCurserRunning(5);
		implicitWaitforCustometime(3);
		driver.switchTo().window((String) tabs2.get(0));

	}

	public void UserManagement_VerifyCountOfUsers() throws InterruptedException {

		refreshPage();
		waitForCurserRunning(5);
		waitForElementContainsText(UsersCount, "Users");
		waitUntilElementIsVisible(UsersCount);
		waitUntilElementPresent(UsersCount);
		scrollIntoView(UsersCount);
		waitForElementIsInteractable(UsersCount);
		forcedWaitTime(5);
		forcedWaitTime(5);
		String[] CountUsers = getTextByJSExecutor(UsersCount).split(" ");
		String usersCount = CountUsers[0];

		if (Integer.parseInt(usersCount) == 0) {
			CountUsers = driver.findElement(UsersCount).getText().split(" ");
			usersCount = CountUsers[0];
			System.out.println(usersCount);
		}

		int TotalUsers = Integer.parseInt(usersCount);

		waitUntilElementPresent(PaginationText);

		int FinalCountUsers = ceCommonMethods.countItemsUsingPagenation(10);

		waitUntilElementIsVisible(UserSearchResult);
		waitUntilElementPresent(UserSearchResult);
		Assert.assertEquals(TotalUsers, FinalCountUsers);
		softAssert.assertAll();
	}

	public void UserManagement_OpenCreateRolePopup() throws InterruptedException {

		scrollIntoView(RolesTab);
		waitForElementIsInteractable(RolesTab);
		clickByJsExecuter(RolesTab);
		waitForElementIsInteractable(CreateRoleButton);
		clickByJsExecuter(CreateRoleButton);
		Thread.sleep(5000);
		waitUntilElementInvisibleLocated(CreateRoleButton);
		waitUntilElementIsVisible(CreateRolePopupTitle);
		String PopupTitle = getTextElement(CreateRolePopupTitle);
		Assert.assertEquals(PopupTitle, "Create Role");
		softAssert.assertAll();
	}

	public void UserManagement_VerifyRoleCreationWithoutProdSettings() throws InterruptedException {

		waitForCurserRunning(3);
		waitUntilElementIsVisible(RoleCount);
		scrollIntoView(RoleCount);
		waitForElementIsInteractable(RoleCount);
		String[] CountUsers1 = getTextElement(RoleCount).split(" ");
		String UsersBefore = CountUsers1[0];
		int TotalUsersBefore = Integer.parseInt(UsersBefore);
		System.out.println(TotalUsersBefore);

		String RandomRoleName = RandomStrings.requiredCharacters(8);
		waitUntilElementIsVisible(RoleNameField);
		waitUntilElementPresent(RoleNameField);
		waitForElementIsInteractable(RoleNameField);
		sendKeysWithWait(RoleNameField, RandomRoleName);
		String RandomDescription = RandomStrings.requiredString(20);
		sendKeysWithWait(DescriptionField, RandomDescription);
		waitUntilElementPresent(CreateRolePopupBtn);
		waitForElementIsInteractable(CreateRolePopupBtn);
		clickOn(CreateRolePopupBtn);
		waitForCurserRunning(5);
		waitUntilElementInvisibleLocated(CreateRolePopupBtn);
		// String SuccessMsg =GetText(RoleCreatedSuccessMsg);
		forcedWaitTime(3);
		waitUntilElementIsVisible(RoleCount);
		scrollIntoView(RoleCount);
		waitForElementIsInteractable(RoleCount);
		String[] AfterCountUsers = getTextElement(RoleCount).split(" ");
		String AfterCountUsers1 = AfterCountUsers[0];
		int AfterCountRole = Integer.parseInt(AfterCountUsers1);
		System.out.println(AfterCountRole);

		// String SuccessMsg =
		// driver.findElement(By.xpath(roleCreatedSuccessMsg)).getText();
		Assert.assertEquals(TotalUsersBefore + 1, AfterCountRole);

		softAssert.assertAll();
	}

	public void UserManagement_VerifyRoleCreationWithProdSettings() throws InterruptedException {

		waitUntilElementIsVisible(CreateRoleButton);
		waitUntilElementIsVisible(CreateRoleButton);
		waitUntilElementPresent(CreateRoleButton);
		waitForElementIsInteractable(CreateRoleButton);
		clickOn(CreateRoleButton);
		waitUntilElementInvisibleLocated(CreateRoleButton);
		String RandomRoleName = RandomStrings.requiredCharacters(8);
		waitUntilElementIsVisible(RoleNameField);
		waitUntilElementPresent(RoleNameField);
		waitForElementIsInteractable(RoleNameField);
		sendKeysWithWait(RoleNameField, RandomRoleName);
		String RandomDescription = RandomStrings.requiredString(20);
		sendKeysWithWait(DescriptionField, RandomDescription);
		waitForElementIsInteractable(ProductSettingsToggle);
		clickOn(ProductSettingsToggle);
		waitForElementIsInteractable(DeleteReissueYesBtn);
		clickOn(DeleteReissueYesBtn);
		waitForElementIsInteractable(BasicToggle);
		clickOn(BasicToggle);
		scrollIntoView(CreateRolePopupBtn);
		waitForElementIsInteractable(CreateRolePopupBtn);
		clickOn(CreateRolePopupBtn);
		waitForElementIsInteractable(RoleCreatedSuccessMsg);
		String SuccessMsg = getTextElement(RoleCreatedSuccessMsg);
		Assert.assertEquals(SuccessMsg, "Role created");
		softAssert.assertAll();
	}

	public void setProductSettings() {
		waitForElementIsInteractable(ProductSettingsToggle);
		clickOn(ProductSettingsToggle);
		clickOn(UserManagementUtility.productAdminYes);
		clickOn(UserManagementUtility.allStaffToggel);
		clickOn(UserManagementUtility.allStaffDashboard);
		clickOn(UserManagementUtility.canVoidWaive);
		clickOn(UserManagementUtility.productExecutiveReport);
		clickOn(UserManagementUtility.productDeleteAndReissue);
		clickOn(UserManagementUtility.violationAnimalBasic);
		clickOn(UserManagementUtility.generalViolationBasic);

	}

	public void setCRMSettings() {
		waitForElementIsInteractable(CRMSettingToggel);
		clickOn(CRMSettingToggel);
		clickOn(crmProductAdminYes);
		clickOn(crmExecutiveReport);
		clickOn(crmPermissionBasic);
	}

	public void addUsersInGroup(List<String> username) throws InterruptedException {
		waitForElementIsInteractable(By.xpath("//label[text()='Add Users']//parent::div//span"));
		clickOn(By.xpath("//label[text()='Add Users']//parent::div//span"));
		waitForElementIsInteractable(By.xpath("//input[@name='query'][@type='TEXT']"));
		for (String name : username) {
			sendKeysWithWait(By.xpath("//input[@name='query'][@type='TEXT']"), name);
			forcedWaitTime(3);
			waitUntilElementIsVisible(By.xpath("//ul//li[@class='option']//span//label"));
			waitForElementIsInteractable(By.xpath("//ul//li[@class='option']//span//label"));
			clickOn(By.xpath("//ul//li[@class='option']//span//label"));
			forcedWaitTime(1);
			waitForElementIsInteractable(By.xpath("//button[text()='Apply']"));
			clickByJsExecuter(By.xpath("//button[text()='Apply']"));
			forcedWaitTime(2);
//			clearByJSE(By.xpath("//input[@name='query'][@type='TEXT']"));
//			forcedWaitTime(3);
			waitForElementIsInteractable(By.xpath("//label[text()='Add Users']//parent::div//span"));
			clickOn(By.xpath("//label[text()='Add Users']//parent::div//span"));

		}

	}

	public void createGroupWithUser(String groupName, String description, List<String> username)
			throws InterruptedException {
		waitForElementIsInteractable(GroupsTab);
		clickByJsExecuter(GroupsTab);
		waitForElementIsInteractable(CreateNewGroupBtn);
		scrollIntoView(CreateNewGroupBtn);
		clickByJsExecuter(CreateNewGroupBtn);
		waitUntilElementIsVisible(CreateGroupPopupTitle);
		waitForElementIsInteractable(CreateGroupPopupTitle);

		waitUntilElementIsVisible(GroupName);
		waitUntilElementPresent(GroupName);
		waitForElementIsInteractable(GroupName);
		forcedWaitTime(2);
		sendKeysWithWait(GroupName, groupName);
		waitUntilElementIsVisible(DescriptionField);
		waitUntilElementPresent(DescriptionField);
		waitForElementIsInteractable(DescriptionField);
		sendKeysWithWait(DescriptionField, description);
		clickOn(siteSettingUserAdmin);
		clickOn(siteSettingSiteAdmin);

		setProductSettings();
		setCRMSettings();
		addUsersInGroup(username);

		waitUntilElementPresent(CreateGroupPopupBtn);
		waitForElementIsInteractable(CreateGroupPopupBtn);
		clickOn(CreateGroupPopupBtn);
		// WaitUntilElementInvisible(CreateGroupPopupBtn);
		forcedWaitTime(2);
		String SuccessMsg = getTextElement(GroupCreatedSuccessMsg);
		Assert.assertEquals(SuccessMsg, "Group created");
		softAssert.assertAll();
	}

	public void UserManagement_OpenCreateGroupPopup() throws InterruptedException {

		waitForElementIsInteractable(GroupsTab);
		clickByJsExecuter(GroupsTab);
		waitForElementIsInteractable(CreateNewGroupBtn);
		scrollIntoView(CreateNewGroupBtn);
		clickByJsExecuter(CreateNewGroupBtn);
		waitUntilElementIsVisible(CreateGroupPopupTitle);
		waitForElementIsInteractable(CreateGroupPopupTitle);
		String PopupTitle = getTextElement(CreateGroupPopupTitle);
		Assert.assertEquals(PopupTitle, "Create Group");
		softAssert.assertAll();
	}

	public void UserManagement_VerifyGroupCreationWithoutProdSettings() throws InterruptedException {

		waitUntilElementIsVisible(GroupName);
		waitUntilElementPresent(GroupName);
		String RandomGrpName = RandomStrings.requiredCharacters(8);
		waitForElementIsInteractable(GroupName);
		forcedWaitTime(2);
		sendKeysWithWait(GroupName, RandomGrpName);
		String RandomDescription = RandomStrings.requiredString(20);
		waitUntilElementIsVisible(DescriptionField);
		waitUntilElementPresent(DescriptionField);
		waitForElementIsInteractable(DescriptionField);
		sendKeysWithWait(DescriptionField, RandomDescription);

		waitUntilElementPresent(CreateGroupPopupBtn);
		waitForElementIsInteractable(CreateGroupPopupBtn);
		clickOn(CreateGroupPopupBtn);
		// WaitUntilElementInvisible(CreateGroupPopupBtn);
		waitForElementIsInteractable(GroupCreatedSuccessMsg);
		String SuccessMsg = getTextElement(GroupCreatedSuccessMsg);
		Assert.assertEquals(SuccessMsg, "Group created");
		softAssert.assertAll();
	}

	public void UserManagement_VerifyCaseAssignToNextUser() throws InterruptedException {

		System.out.println("enter in assign to next User");
		forcedWaitTime(3);
		UserManagement_OpenCreateUserPopup();
		UserManagement_VerifyUserGetsCreated();
		System.out.println("name" + fname);
		ceCommonMethods.createCaseCCP(fname);
		waitForCurserRunning(3);
		ceCommonMethods.closeCaseDetailPage();
		waitForCurserRunning(3);
		NavigateTo_UserManagement();
		waitForElementIsInteractable(SearchField);
		scrollIntoView(SearchField);
		sendKeysWithWait(SearchField, fname);
		waitForCurserRunning(4);
		waitForElementIsInteractable(By.xpath(editUserIcon));
		clickByJsExecuter(By.xpath(editUserIcon));
		waitForCurserRunning(3);
		waitForElementIsInteractable(inactiveStatus);
		clickByJsExecuter(inactiveStatus);
		forcedWaitTime(2);
		clickByJsExecuter(By.xpath(saveButton));
		waitForCurserRunning(3);
		String actual_assigneePopup = getTextElement(By.xpath("//div[normalize-space()='Transfer Workload']"));
		SoftAssert st = new SoftAssert();
		st.assertEquals(actual_assigneePopup, "Transfer Workload", "Popup is appear");

	}

	public void UserManagement_VerifyCaseAssignToNextUserPopup(String nameOfUser) throws InterruptedException {

		ceCommonMethods.selectCaseAssineCCP2(nameOfUser);
		ceCommonMethods.selectInspectionAssineCCP2(nameOfUser);

		clickByJsExecuter(By.xpath("//button[normalize-space()='Done']"));

		SoftAssert st = new SoftAssert();

		st.assertEquals(getTextElement(By.xpath("//div[normalize-space()='Inactive']")), "Inactive");

	}

}
