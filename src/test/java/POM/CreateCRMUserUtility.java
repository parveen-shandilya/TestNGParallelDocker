package POM;

import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import TestCases.Login;
import org.testng.Assert;

public class CreateCRMUserUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public CreateCRMUserUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}
	
	
	
	  public static String createUserButton = "//button[text()='Create User']";
	    public static String createUserPopupTitle = "//h1[text()='Create User']";
	    public static String firstNameField = "//input[@name='firstName']";
	    public static String lastNameField = "//input[@name='lastName']";
	    public static String emailField = "//input[@name='email']";
	    public static String roleDropdown = "//label[text()='Role']/following::span[1]";
	    public static String roleSelectArrow = "(//span[@class='Select-arrow-zone'])[2]//span";
	    public static String standardUserOption = "//*[text()='Standard User CRM']";
	    public static String customUserRoles = "//*[text()='%s']";

	    public static String productAdminOption = "//*[text()='Product Admin CRM']";
	    public static String addGroupDropdown = "//label[text()='Add Group']";
	    public static String standardGroupCheckbox = "//label[text()='Standard Group']";
	    public static String adminGroupCheckbox = "//label[text()='Admin Group']";
	    public static String applyButton = "//button[text()='Apply']";
	    public static String cancelButton = "//button[text()='Cancel']";
	    public static String saveButton = "//button[text()='Save']";
	    public static String searchField = "//input[@placeholder='Filter by name or email'][@type='TEXT']";

	    public static String usersCount = "//div[@class='agency-setup-tab__section__header']/h2";
	    public static String searchResultName = "//div[@class='rt-tr -odd']/div";
	    public static String createUserPopupBtn = "//div[@class='user-form__header full-page-modal__header']//button[text()='Create User']";
	    public static String editUserIcon = "//button[@class='edit-btn  btn btn-primary']";
	    public static String editUserIcon1 = "(//button[@class='edit-btn  btn btn-primary'])[1]";
	    public static String editUserpopupTitle = "//h1[text()='Edit User']";
	    public static String yopmailSearchUser = "//input[@class='ycptinput']";
	    public static String paginationText = "//span[@class='table__pagination-of-text']";
	    public static String userSearchResult = "//div[@class='rt-tr-group']";
	    public static String yopmailInboxArrow = "//button[@class='md']";
	    public static String rolesTab = "//div[text()='Roles']";
	    public static String createRoleButton = "//button[text()='Create Role']";
	    public static String createRolePopupTitle = "//h1[text()='Create Role']";
	    public static String roleNameField = "//input[@placeholder='Enter Text']";
	    public static String descriptionField = "//textarea[@name='description']";
	    public static String createRolePopupBtn = "//div[@class='modal-header']//following::button[text() ='Create Role']";
	    public static String roleCreatedSuccessMsg = "//span[text()='Role created']";
	    public static String resetPasswordLink = "//a[text()='Send Reset Password Link']";
	    public static String iframeSwitch = "//iframe[@id='ifmail']";
	    public static String firstMail = "//button[@class='lm']";
	    public static String activateOktaBtn = "//span[text()='Activate Okta Account']";
	    public static String newPassword = "//input[@name='newPassword']";
	    public static String verifyPassword = "//input[@name='verifyPassword']";
	    public static String resetPasswordBtn = "//span[text()='Reset Password']";
	    public static String productSettingsToggle = "//span[@class='toggle__children']";
	    public static String deleteReissueYesBtn = "//label[@title='Delete and Reissue Notice']/following::button[text()='Yes'][1]";
	    public static String basicToggle = "//button[text()='Basic']";
	    public static String groupsTab = "//div[text()='Groups']";
	    public static String createNewGroupBtn = "//button[text()='Create New Group']";
	    public static String createGroupPopupTitle = "//h1[text()='Create Group']";
	    public static String createGroupPopupBtn = "//button[text()='Create Group']";
	    public static String groupName = "//input[@name='label']";
	    public static String groupCreatedSuccessMsg = "//span[text()='Group created']";
	    public static String nextNavigationIcon = "//div[@class='table__pagination-nav-btns']/button[2]";
	    public static String createMyAccountBtn = "//input[@value='Create My Account']";
	    public static String standardUserCEOption = "//*[text()='Agency Admin CRM and CEM']";
	    public static String agencyAdminUseerCECRMOption = "//*[text()='Agency Admin CRM and CEM']";

	    public static By CreateUserButton = By.xpath(CreateCRMUserUtility.createUserButton);
	    public static By CreateUserPopupTitle = By.xpath(CreateCRMUserUtility.createUserPopupTitle);
	    public static By FirstNameField = By.xpath(CreateCRMUserUtility.firstNameField);
	    public static By LastNameField = By.xpath(CreateCRMUserUtility.lastNameField);
	    public static By EmailField = By.xpath(CreateCRMUserUtility.emailField);
	    public static By RoleDropdown = By.xpath(CreateCRMUserUtility.roleDropdown);
	    public static By StandardUserOption = By.xpath(CreateCRMUserUtility.standardUserOption);
	    public static By StandardUseerCEOption = By.xpath(standardUserCEOption);
	    public static By AgencyAdminUseerCECRMOption = By.xpath(agencyAdminUseerCECRMOption);
	    public static By ProductAdminOption = By.xpath(CreateCRMUserUtility.productAdminOption);
	    public static By RoleSelectArrow = By.xpath(CreateCRMUserUtility.roleSelectArrow);
	    public static By AddGroupDropdown = By.xpath(CreateCRMUserUtility.addGroupDropdown);
	    public static By StandardGroupCheckbox = By.xpath(CreateCRMUserUtility.standardGroupCheckbox);
	    public static By AdminGroupCheckbox = By.xpath(CreateCRMUserUtility.adminGroupCheckbox);
	    public static By ApplyButton = By.xpath(CreateCRMUserUtility.applyButton);
	    public static By CancelButton = By.xpath(CreateCRMUserUtility.cancelButton);
	    public static By SaveButton = By.xpath(CreateCRMUserUtility.saveButton);
	    public static By SearchField = By.xpath(CreateCRMUserUtility.searchField);
	    public static By CreateUserPopupBtn = By.xpath(CreateCRMUserUtility.createUserPopupBtn);
	    public static By UsersCount = By.xpath(CreateCRMUserUtility.usersCount);
	    public static By UserSearchResult = By.xpath(CreateCRMUserUtility.userSearchResult);
	    public static By EditUserIcon = By.xpath(CreateCRMUserUtility.editUserIcon);

	    public static By EditUseerIcon1 = By.xpath(CreateCRMUserUtility.editUserIcon1);

	    public static By ResetPasswordLink = By.xpath(CreateCRMUserUtility.resetPasswordLink);
	    public static By EditUserpopupTitle = By.xpath(CreateCRMUserUtility.editUserpopupTitle);
	    public static By YopmailSearchUser = By.xpath(CreateCRMUserUtility.yopmailSearchUser);
	    public static By PaginationText = By.xpath(CreateCRMUserUtility.paginationText);
	    public static By SearchResultName = By.xpath(CreateCRMUserUtility.searchResultName);
	    public static By YopmailInboxArrow = By.xpath(CreateCRMUserUtility.yopmailInboxArrow);
	    public static By CreateRoleButton = By.xpath(CreateCRMUserUtility.createRoleButton);
	    public static By RolesTab = By.xpath(CreateCRMUserUtility.rolesTab);
	    public static By CreateRolePopupTitle = By.xpath(CreateCRMUserUtility.createRolePopupTitle);
	    public static By RoleNameField = By.xpath(CreateCRMUserUtility.roleNameField);
	    public static By DescriptionField = By.xpath(CreateCRMUserUtility.descriptionField);
	    public static By CreateRolePopupBtn = By.xpath(CreateCRMUserUtility.createRolePopupBtn);
	    public static By IframeSwitch = By.xpath(CreateCRMUserUtility.iframeSwitch);
	    public static By FirstMail = By.xpath(CreateCRMUserUtility.firstMail);
	    public static By ActivateOktaBtn = By.xpath(CreateCRMUserUtility.activateOktaBtn);
	    public static By NewPassword = By.xpath(CreateCRMUserUtility.newPassword);
	    public static By VerifyPassword = By.xpath(CreateCRMUserUtility.verifyPassword);
	    public static By ResetPasswordBtn = By.xpath(CreateCRMUserUtility.resetPasswordBtn);
	    public static By RoleCreatedSuccessMsg = By.xpath(CreateCRMUserUtility.roleCreatedSuccessMsg);
	    public static By ProductSettingsToggle = By.xpath(CreateCRMUserUtility.productSettingsToggle);
	    public static By DeleteReissueYesBtn = By.xpath(CreateCRMUserUtility.deleteReissueYesBtn);
	    public static By BasicToggle = By.xpath(CreateCRMUserUtility.basicToggle);
	    public static By GroupsTab = By.xpath(CreateCRMUserUtility.groupsTab);
	    public static By CreateNewGroupBtn = By.xpath(CreateCRMUserUtility.createNewGroupBtn);
	    public static By CreateGroupPopupTitle = By.xpath(CreateCRMUserUtility.createGroupPopupTitle);
	    public static By CreateGroupPopupBtn = By.xpath(CreateCRMUserUtility.createGroupPopupBtn);
	    public static By GroupName = By.xpath(CreateCRMUserUtility.groupName);
	    public static By GroupCreatedSuccessMsg = By.xpath(CreateCRMUserUtility.groupCreatedSuccessMsg);
	    public static By NextNavigationIcon = By.xpath(CreateCRMUserUtility.nextNavigationIcon);
	    public static By CreateMyAccountBtn = By.xpath(CreateCRMUserUtility.createMyAccountBtn);
	    public static By CasesTab = By.xpath("//a[text()='Cases']");
	    public static By SubmissionsTab = By.xpath("//a[text()='Customer Submissions']");
	   // public static By LogoutDropdownArrow = By.xpath("//div[@class='app-header__user-name']//div[@class='app-header__user-name-caret']");
	   public static By LogoutDropdownArrow = By.cssSelector("div.app-header__user-profile div:nth-child(1)");
	    public static By LogoutOption = By.xpath("//label[text()='Logout']");
	    public static By AgencyAdminCEM = By.xpath("//*[text()='Agency Admin CEM']");
	    public static By AgencyAdminCRMOnly = By.xpath("//*[text()='Agency Admin CRM']");

	    public static String RandomFirstNameCRM = "CRM" + RandomStrings.requiredCharacters(6);
	    public static String RandomLastNameCRM = RandomStrings.requiredCharacters(6);

	    public static boolean CreateStandardUser_CompareCount;
	    public static boolean CreateProductAdminUser_CompareCount;
	    public static boolean CEAbsence;
	    public static boolean CRMAccess;
	    public static String FirstUserName;

	    public static String RandomupdatedPassword;

	    public  void CreateCRMUser_CreateStandardUser() throws InterruptedException {
	       closeOtherTabs();
	        driver.get(BrowsersInvoked.URLUserManagement);
	       waitForCurserRunning(10);
	       waitUntilElementIsVisible(UsersCount);
	       waitUntilElementPresent(UsersCount);
	        Thread.sleep(10000);
	       waitUntilElementPresent(UsersCount);
	        String[] CountUsers1 = (driver.findElement(UsersCount).getText()).split(" ");
	        String UsersBefore = CountUsers1[0];
	        int TotalUsersBefore = Integer.parseInt(UsersBefore);
	        if(TotalUsersBefore == 0){
	            Thread.sleep(10000);
	            CountUsers1 = (driver.findElement(UsersCount).getText()).split(" ");
	            UsersBefore = CountUsers1[0];
	            TotalUsersBefore = Integer.parseInt(UsersBefore);
	        }
	       waitUntilElementIsVisible(CreateUserButton);
	       waitForElementIsInteractable(CreateUserButton);
	       clickByJsExecuter(CreateUserButton);
	       waitUntilElementIsVisible(FirstNameField);
	       waitForElementIsInteractable(FirstNameField);
	       sendKeysWithWait(FirstNameField, "Stand" + RandomFirstNameCRM);
	       sendKeysWithWait(LastNameField, RandomLastNameCRM);
	        String EmailRandom = "stand" + RandomFirstNameCRM + RandomLastNameCRM + "@yopmail.com";
	       sendKeysWithWait(EmailField, EmailRandom);
	       clickOn(RoleDropdown);
	       waitUntilElementIsVisible(AgencyAdminUseerCECRMOption);
	       waitForElementIsInteractable(AgencyAdminUseerCECRMOption);
	       clickOn(AgencyAdminUseerCECRMOption);
	       clickOn(AddGroupDropdown);
	       waitUntilElementIsVisible(StandardGroupCheckbox);
	       waitForElementIsInteractable(StandardGroupCheckbox);
	       clickOn(StandardGroupCheckbox);
	       waitUntilElementIsVisible(ApplyButton);
	       waitForElementIsInteractable(ApplyButton);
	       clickOn(ApplyButton);
	       waitUntilElementIsVisible(CreateUserPopupBtn);
	       waitForElementIsInteractable(CreateUserPopupBtn);
	        Thread.sleep(4000);
	       clickOn(CreateUserPopupBtn);
	       waitUntilElementInvisibleLocated(CreateUserPopupBtn);
	       waitForCurserRunning(10);
	        Thread.sleep(4000);
	       waitUntilElementIsVisible(UsersCount);
	        String[] CountUsers2 =getTextElement(UsersCount).split(" ");
	        String UsersAfter = CountUsers2[0];
	        int TotalUsersAfter = Integer.parseInt(UsersAfter);
	        System.out.println(TotalUsersAfter);
	        System.out.println(TotalUsersBefore + 1);
	        CreateStandardUser_CompareCount = (TotalUsersAfter == (TotalUsersBefore + 1));
	        SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(CreateStandardUser_CompareCount, true);
			softAssert.assertAll();
	    }

	    public  void CreateCRMUser_CreateProductAdminUser() throws InterruptedException {

	        Thread.sleep(8000);
	        String[] CountUsers1 =getTextElement(UsersCount).split(" ");
	        String UsersBefore = CountUsers1[0];
	        int TotalUsersBefore = Integer.parseInt(UsersBefore);
	       waitForPresenceandVisiblity(CreateUserButton);
	       scrollIntoView(CreateUserButton);
	       waitForElementIsInteractable(CreateUserButton);
	       waitUntilElementPresent(CreateUserButton);
	       clickByJsExecuter(CreateUserButton);
	       waitForPresenceandVisiblity(FirstNameField);
	       waitForElementIsInteractable(FirstNameField);
	        FirstUserName = "Prod Admin" + RandomFirstNameCRM;
	       sendKeysWithWait(FirstNameField, FirstUserName);
	       sendKeysWithWait(LastNameField, RandomLastNameCRM);
	        String EmailRandom = "prodadmin" + RandomFirstNameCRM + RandomLastNameCRM + "@yopmail.com";
	       sendKeysWithWait(EmailField, EmailRandom);
	       clickOn(RoleDropdown);
	       waitUntilElementIsVisible(ProductAdminOption);
	       waitForElementIsInteractable(ProductAdminOption);
	       clickOn(ProductAdminOption);
	       waitUntilElementIsVisible(AddGroupDropdown);
	       waitForElementIsInteractable(AddGroupDropdown);
	       clickOn(AddGroupDropdown);
	       waitUntilElementIsVisible(AdminGroupCheckbox);
	       waitForElementIsInteractable(AdminGroupCheckbox);
	       clickOn(AdminGroupCheckbox);
	       waitUntilElementIsVisible(ApplyButton);
	       waitForElementIsInteractable(ApplyButton);
	       clickOn(ApplyButton);
	       waitUntilElementIsVisible(CreateUserPopupBtn);
	        Thread.sleep(4000);
	       waitForElementIsInteractable(CreateUserPopupBtn);
	       clickByJsExecuter(CreateUserPopupBtn);
	       waitUntilElementInvisibleLocated(CreateUserPopupBtn);
	       waitForCurserRunning(10);
	        Thread.sleep(4000);
	       waitUntilElementIsVisible(UsersCount);
	       waitUntilElementIsVisible(By.xpath("//div[contains(text(),'"+FirstUserName+"')][@role='gridcell']"));
	        String[] CountUsers2 =getTextElement(UsersCount).split(" ");
	        String UsersAfter = CountUsers2[0];
	        int TotalUsersAfter = Integer.parseInt(UsersAfter);
	        System.out.println(TotalUsersAfter);
	        System.out.println(TotalUsersBefore + 1);
	        CreateProductAdminUser_CompareCount = (TotalUsersAfter == (TotalUsersBefore + 1));
	    	SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(CreateProductAdminUser_CompareCount, true);
			softAssert.assertAll();
	    }
	    
	    
	   

	    
	    

	    public  void CreateStandardCEUser() throws InterruptedException {
	       waitForElementIsInteractable(CreateUserButton);
	       clickOn(CreateUserButton);
	       waitUntilElementIsVisible(FirstNameField);
	       waitForElementIsInteractable(FirstNameField);
	        String rn = RandomStrings.requiredCharacters(3);
	       sendKeysWithWait(FirstNameField, "CE User" + RandomFirstNameCRM);
	       sendKeysWithWait(LastNameField, RandomLastNameCRM);
	        String EmailRandom = "stand" + RandomFirstNameCRM + rn + RandomLastNameCRM + "@yopmail.com";

	       waitForElementIsInteractable(EmailField);
	       sendKeysWithWait(EmailField, EmailRandom);
	       waitForElementIsInteractable(RoleDropdown);
	       clickOn(RoleDropdown);
	       waitUntilElementIsVisible(AgencyAdminUseerCECRMOption);
	       waitForElementIsInteractable(AgencyAdminUseerCECRMOption);
	       clickOn(AgencyAdminUseerCECRMOption);
	       waitUntilElementIsVisible(AddGroupDropdown);
	       waitForElementIsInteractable(AddGroupDropdown);
	       clickOn(AddGroupDropdown);
	       waitUntilElementIsVisible(StandardGroupCheckbox);
	       waitForElementIsInteractable(StandardGroupCheckbox);
	       clickOn(StandardGroupCheckbox);
	       waitUntilElementIsVisible(ApplyButton);
	       waitForElementIsInteractable(ApplyButton);
	       clickOn(ApplyButton);
	       waitUntilElementIsVisible(CreateUserPopupBtn);
	        Thread.sleep(4000);
	       waitForElementIsInteractable(CreateUserPopupBtn);
	       clickOn(CreateUserPopupBtn);
	       waitUntilElementInvisibleLocated(CreateUserPopupBtn);
	       waitForCurserRunning(10);
	        Thread.sleep(4000);
	        
	    }


	    public  void CreateStandardCRMUser() throws InterruptedException {
	       waitForElementIsInteractable(CreateUserPopupBtn);
	       clickOn(CreateUserButton);
	       waitUntilElementIsVisible(FirstNameField);
	        Thread.sleep(2000);
	       waitForElementIsInteractable(FirstNameField);
	        String rn = RandomStrings.requiredCharacters(3);
	       sendKeysWithWait(FirstNameField, "CRM User" + RandomFirstNameCRM);
	       sendKeysWithWait(LastNameField, RandomLastNameCRM);
	        String EmailRandom = "stand" + RandomFirstNameCRM + rn + RandomLastNameCRM + "@yopmail.com";

	       waitUntilElementIsVisible(EmailField);
	       waitForElementIsInteractable(EmailField);
	       sendKeysWithWait(EmailField, EmailRandom);

	       waitUntilElementIsVisible(RoleDropdown);
	       waitForElementIsInteractable(RoleDropdown);
	       clickOn(RoleDropdown);

	       waitUntilElementIsVisible(AgencyAdminUseerCECRMOption);
	       waitForElementIsInteractable(AgencyAdminUseerCECRMOption);
	       clickOn(AgencyAdminUseerCECRMOption);

	       waitUntilElementIsVisible(AddGroupDropdown);
	       waitForElementIsInteractable(AddGroupDropdown);
	       clickOn(AddGroupDropdown);

	       waitUntilElementIsVisible(StandardGroupCheckbox);
	       waitForElementIsInteractable(StandardGroupCheckbox);
	       clickOn(StandardGroupCheckbox);

	       waitUntilElementIsVisible(ApplyButton);
	       waitForElementIsInteractable(ApplyButton);
	       clickOn(ApplyButton);

	       waitUntilElementIsVisible(CreateUserPopupBtn);
	        Thread.sleep(4000);
	       waitForElementIsInteractable(CreateUserPopupBtn);
	       clickOn(CreateUserPopupBtn);
	       waitUntilElementInvisibleLocated(CreateUserPopupBtn);
	       waitForCurserRunning(10);
	        Thread.sleep(4000);
	        
	    }


	    public  void CreateCRMUser_UpdateCEOnlyUserToCRMOnly() throws InterruptedException {
	       waitUntilElementIsVisible(SearchField);
	       waitUntilElementPresent(SearchField);
	       waitForElementIsInteractable(SearchField);
	       sendKeysWithWait(SearchField, "CE User");
	       waitForCurserRunning(4);
	        Thread.sleep(4000);
	        int count = driver.findElements(By.xpath("//div[contains(text(),'No user found')]")).size();
	        if (count > 0) {

	            CreateStandardCEUser();
	           waitForElementIsInteractable(SearchField);
	           clearElement(SearchField);
	           sendKeysWithWait(SearchField, "CE User");
	           waitForCurserRunning(7);
	           waitUntilElementIsVisible(By.xpath("//div[contains(text(),'CE User')]"));

	        }
	       waitForCurserRunning(4);
	       waitUntilElementIsVisible(By.xpath("//div[contains(text(),'CE User')]"));
	       waitUntilElementPresent(By.xpath("//div[contains(text(),'CE User')]"));
	       waitForElementIsInteractable(EditUserIcon);
	       clickOn(EditUserIcon);
	       waitUntilElementIsVisible(FirstNameField);
	       waitForElementIsInteractable(FirstNameField);
	        Thread.sleep(8000);
	        WebElement FirstNameFld =waitUntilVisibleWE(FirstNameField);
	       // FirstNameFld.clear();
	        driver.findElement(FirstNameField).clear();
	       forcedWaitTime(3);
	       waitForElementIsInteractable(FirstNameField);
	       sendKeysWithWait(FirstNameField, "CE To CRM");
	       forcedWaitTime(4); // interactable issue could not be resolved by selenium waits
	       waitUntilElementIsVisible(RoleDropdown);
	       waitForElementIsInteractable(RoleDropdown);
	        Thread.sleep(2000);
	       clickOn(RoleDropdown);
	       waitUntilElementIsVisible(ProductAdminOption);
	       waitForElementIsInteractable(ProductAdminOption);
	       clickByJsExecuter(ProductAdminOption);
	        
	       waitUntilElementIsVisible(SaveButton);
	        Thread.sleep(4000);
	       waitForElementIsInteractable(SaveButton);
	       clickOn(SaveButton);
	       waitUntilElementInvisibleLocated(SaveButton);
	       waitForCurserRunning(9);
	        Thread.sleep(2000);
	        SoftAssert softAssert = new SoftAssert();
			softAssert.assertAll();
	        

	    }

	    public  void CreateCRMUser_VerifyCRMProductAccessToCRMUser() throws InterruptedException, AWTException {
	        driver.get(BrowsersInvoked.URLUserManagement);
	       waitForCurserRunning(10);
	       waitUntilElementIsVisible(SearchField);
	       waitForElementIsInteractable(SearchField);
	        WebElement SearchUserField =waitUntilVisibleWE(SearchField);
	       forcedWaitTime(3);
	        SearchUserField.clear();
	        SearchUserField.sendKeys("CE To CRM");
	       waitForCurserRunning(4);
	       forcedWaitTime(3);
	        int count = driver.findElements(By.xpath("//div[contains(text(),'No user found')]")).size();
	        if (count > 0) {

	            CreateStandardCRMUser();
	           forcedWaitTime(3);
	           clearElement(SearchField);
	           sendKeysWithWait(SearchField, "CE To CRM");
	           waitForCurserRunning(4);
	           waitUntilElementIsVisible(By.xpath("//div[contains(text(),'CE To CRM')]"));

	        }
	       waitUntilElementIsVisible(By.xpath("//div[contains(text(),'CE To CRM')]"));
	       waitForElementIsInteractable(EditUserIcon);
	       clickByJsExecuter(EditUserIcon);
	       waitUntilElementIsVisible(EmailField);
	       forcedWaitTime(3);
	       waitUntilElementIsVisible(ResetPasswordLink);
	       waitForElementIsInteractable(ResetPasswordLink);
	       clickByJsExecuter(ResetPasswordLink);
	       visibilityOfElementLocated(EmailField, 2);
	        String YopmailID = driver.findElement(EmailField).getAttribute("value");
	        ((JavascriptExecutor) driver).executeScript("window.open()");
	        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
	        driver.navigate().to("https://yopmail.com/en/");
	       waitForCurserRunning(4);
	       forcedWaitTime(4);
	       waitUntilElementIsVisible(YopmailSearchUser);
	       waitUntilElementPresent(YopmailSearchUser);
	       waitForElementIsInteractable(YopmailSearchUser);
	       sendKeysWithWait(YopmailSearchUser, YopmailID);
	       waitForElementIsInteractable(YopmailInboxArrow);
	       clickOn(YopmailInboxArrow);
	       waitForCurserRunning(4);
	       waitUntilElementIsVisible(IframeSwitch);
	       waitForElementIsInteractable(By.xpath("//button[@id='refresh']"));
	       clickByJsExecuter(By.xpath("//button[@id='refresh']"));
	       waitUntilElementIsVisible(IframeSwitch);
	       forcedWaitTime(3);
	        WebElement switchFrame =waitUntilVisibleWE(IframeSwitch);
	        driver.switchTo().frame(switchFrame);
	       waitUntilElementIsVisible(ResetPasswordBtn);
	       visibilityOfElementLocated(ResetPasswordBtn, 2);
	       waitForElementIsInteractable(ResetPasswordBtn);
	       clickOn(ResetPasswordBtn);
	       waitForCurserRunning(5);
	       forcedWaitTime(4);
	        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs2.get(2));
	        
	        RandomupdatedPassword = "Hello@12" + RandomStrings.requiredDigits(5);
	        int answerCheck = driver.findElements(By.xpath("//input[@id='input39']")).size();
	        if (answerCheck > 0) {
	           waitForElementIsInteractable(By.xpath("//input[@id='input39']"));
	            driver.findElement(By.xpath("//input[@id='input39']")).sendKeys("good");
	            driver.findElement(By.xpath("//input[@value='Reset Password']")).click();
	           waitForElementIsInteractable(By.xpath("//input[@name='newPassword']"));
	            driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys(RandomupdatedPassword);
	            driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(RandomupdatedPassword);
	           waitUntilElementIsVisible(By.xpath("//input[@value='Reset Password']"));
	           waitForElementIsInteractable(By.xpath("//input[@value='Reset Password']"));
	            driver.findElement(By.xpath("//input[@value='Reset Password']")).click();
	           waitForCurserRunning(4);
	           forcedWaitTime(4);
	            driver.switchTo().window((String) tabs2.get(0));
	           refreshPage();
	           waitForCurserRunning(5);
	            int cancelbtnCheck = driver.findElements(CancelButton).size();
	            if (cancelbtnCheck > 0) {
	               waitForElementIsInteractable(CancelButton);
	               clickOn(CancelButton);
	               waitForElementIsInteractable(LogoutDropdownArrow);
	               clickOn(LogoutDropdownArrow);
	               waitForElementIsInteractable(LogoutOption);
	               clickOn(LogoutOption);
	               waitForCurserRunning(4);
	            }
	            driver.navigate().to(BrowsersInvoked.AgencyURL);
	           waitForCurserRunning(8);
	           waitUntilElementIsVisible(SubmissionsTab);
	            List<WebElement> CRMPresence = driver.findElements(SubmissionsTab);
	            CRMAccess = CRMPresence.size() == 1;


	        } else if (driver.findElements(By.xpath("//h1[contains(text(),'Welcome to Comcate')]")).size() > 0) {
	           waitUntilElementIsVisible(By.xpath("//h1[contains(text(),'Welcome to Comcate')]"));
	           waitForElementIsInteractable(NewPassword);
	           sendKeysWithWait(NewPassword, RandomupdatedPassword);
	           waitForElementIsInteractable(VerifyPassword);
	           sendKeysWithWait(VerifyPassword, RandomupdatedPassword);
	           waitForElementIsInteractable(By.xpath("//input[@id='loginForm.securityAnswer']"));
	           sendKeysWithWait(By.xpath("//input[@id='loginForm.securityAnswer']"), "good");
	           waitForElementIsInteractable(CreateMyAccountBtn);
	           clickOn(CreateMyAccountBtn);
	           waitForCurserRunning(4);
	           forcedWaitTime(2);

	            driver.switchTo().window((String) tabs2.get(0));
	           refreshPage();
	           waitForCurserRunning(5);
	           forcedWaitTime(2);
	            int cancelbtnCheck = driver.findElements(CancelButton).size();
	            if (cancelbtnCheck > 0) {
	               waitForElementIsInteractable(CancelButton);
	               clickOn(CancelButton);
	               waitForElementIsInteractable(LogoutDropdownArrow);
	               clickOn(LogoutDropdownArrow);
	               waitForElementIsInteractable(LogoutOption);
	               clickOn(LogoutOption);
	               waitForCurserRunning(4);
	            }
	            driver.navigate().to(BrowsersInvoked.AgencyURL);
	           waitForCurserRunning(8);
	           waitUntilElementIsVisible(SubmissionsTab);
	            List<WebElement> CRMPresence = driver.findElements(SubmissionsTab);
	            CRMAccess = CRMPresence.size() == 1;
	        }
	        else{
	            List<WebElement> CRMPresence = driver.findElements(SubmissionsTab);
	            CRMAccess = CRMPresence.size() == 1;
	        }
	        
	        SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(CRMAccess, true);
			softAssert.assertAll();


	    }

	    public  void CreateCRMUser_VerifyNoCEAccessToCRMOnlyUser() throws InterruptedException, AWTException {
	        driver.get(BrowsersInvoked.URLUserManagement);
	       waitForCurserRunning(9);
	       waitUntilElementIsVisible(SearchField);
	       waitForElementIsInteractable(SearchField);
	       forcedWaitTime(3);
	        driver.findElement(SearchField).clear();
	       waitForElementIsInteractable(SearchField);
	        driver.findElement(SearchField).sendKeys("CE To CRM");
	       waitForCurserRunning(5);
	       waitUntilElementIsVisible(By.xpath("//div[contains(text(),'CE To CRM')]"));
	       visibilityOfElementLocated(EditUserIcon, 2);
	       waitForElementIsInteractable(EditUserIcon);
	       clickOn(EditUserIcon);
	       waitForCurserRunning(8);
	       waitUntilElementIsVisible(RoleDropdown);
	       waitUntilElementPresent(RoleDropdown);
	       waitForElementIsInteractable(RoleDropdown);
	       clickOn(RoleDropdown);
	       forcedWaitTime(3);
	       waitUntilElementIsVisible(AgencyAdminCRMOnly);
	       scrollIntoView(AgencyAdminCRMOnly);
	       waitForElementIsInteractable(AgencyAdminCRMOnly);
		   forcedWaitTime(3);
	       clickOn(AgencyAdminCRMOnly);
	       waitUntilElementIsVisible(FirstNameField);
	       waitForElementIsInteractable(FirstNameField);
	        WebElement FirstNameFld =findElement(FirstNameField);
	        FirstNameFld.clear();
	       sendKeysWithWait(FirstNameField, "CRM to CE");
	        String YopmailID = driver.findElement(EmailField).getAttribute("value");
	       waitForElementIsInteractable(SaveButton);
	       clickOn(SaveButton);
	       waitUntilElementInvisibleLocated(SaveButton);
	       waitForCurserRunning(8);
	       waitUntilElementIsVisible(LogoutDropdownArrow);
	       waitUntilElementPresent(LogoutDropdownArrow);
	        Boolean check =findElement(LogoutDropdownArrow).isDisplayed();
	        System.out.println(check + "Log out present");
	       forcedWaitTime(4);
	       scrollIntoView(LogoutDropdownArrow);
	       waitForElementIsInteractable(LogoutDropdownArrow);
	       clickByJsExecuter(LogoutDropdownArrow);
	       waitForElementIsInteractable(LogoutOption);
	       clickByJsExecuter(LogoutOption);
	       waitForCurserRunning(3);
	       waitUntilElementInvisibleLocated(CasesTab);
	       waitForCurserRunning(5);
	       closeOtherTabs();
	        driver.navigate().to(BrowsersInvoked.AgencyURL);
	       waitForCurserRunning(8);
	       forcedWaitTime(4);
	            int Logoutbtncheck = driver.findElements(LogoutDropdownArrow).size();
	            if (Logoutbtncheck > 0) {
	               clickOn(LogoutDropdownArrow);
	               waitForElementIsInteractable(LogoutOption);
	               clickOn(LogoutOption);
	               waitForCurserRunning(8);

	               waitForCurserRunning(5);
	            }

	        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
	           sendKeysWithWait(LoginAgencyUtility.UsernameField, YopmailID);
	           sendKeysWithWait(LoginAgencyUtility.PasswordField, BrowsersInvoked.AgencyPassword);
	           clickOn(LoginAgencyUtility.SubmitButton);
	        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE") || BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

	           visibilityOfElementLocated(LoginAgencyUtility.OKTAUsernameField, 2);
	           sendKeysWithWait(LoginAgencyUtility.OKTAUsernameField, YopmailID);
	           clickOn(LoginAgencyUtility.NextButton);
	           sendKeysWithWait(LoginAgencyUtility.OKTAPasswordField,BrowsersInvoked.AgencyPassword);
	           waitUntilElementIsVisible(LoginAgencyUtility.OKTASubmitButton);
	           clickOn(LoginAgencyUtility.OKTASubmitButton);
	        } else {
	            System.out.print(BrowsersInvoked.RunEnvironment);
	        }

	        
	       //WaitUntilVisible(CasesTab);
	        List<WebElement> CLPPresence = driver.findElements(CasesTab);
	        CEAbsence = CLPPresence.size() == 0;
	        
	        SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(CEAbsence, true);
			softAssert.assertAll();
	    }


}
