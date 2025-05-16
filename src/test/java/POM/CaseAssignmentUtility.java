package POM;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import Constant.CEConstants;

public class CaseAssignmentUtility extends Helper {

	public WebDriver driver;
	public LoginUtility log;

	public CaseAssignmentUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	public static By save = By.xpath("//button[normalize-space()='Save']");
	public static By search = By.xpath("//input[contains(@placeholder,'Search...')])[1]");
	public static By amandeepSingh = By.xpath("//b[text() ='Amandeep Singh1']");
	public static String editAssignmentIcon = "//div[text()='Case Created']//following::button[1]";
	public static String assignmentRuleSideBar = "//label[text()='Assignment Rules']";
	static String editAssignmentPopup = "//div[@class='full-page-modal__header']/h1";
	public static String nameField = "//label[@title='Name']/following::input[@name='label']";
	public static String descriptionField = "//input[@name='description']";
	public static String actionDropdown = "//div[@class='Select-value']";
	public static String optionActionDropdown = "//*[text()='Submission Received']";
	public static String saveButton = "//button[text()='Save']";
	public static String crossIconRuleSet = "//div[@class='sortable-table__body__td']/button[2]";
	public static String validationNoRule = "//div[@class='modal-base__error modal-base__error--show']";
	public static String addRuleButton = "//button[text()='Add Rule']";
	public static String createRule = "//h1[text()='Create Rule']";
	public static String criteriaFields = "(//label[contains(text(),'Select Option')])[1]";

	public static String criteriaFields2 = "//label[@for='attribute']/following::div[@class='Select-placeholder'][1]";
	public static By CriteriaFields2 = By.xpath(criteriaFields2);

	public static By customLocationFieldsTab=By.xpath("(//div[@class='tabs__names']/div[text()='Custom Location Fields'])[1]");
	public static By customLocationFieldsTab2=By.xpath("(//div[@class='tabs__names']/div[text()='Custom Location Fields'])[2]");

	public static String zipOption = "//*[span='Zip']";
	public static String equalsOption = "//*[@aria-label='Equals']";
	public static String addCriteriaLink = "//a[text()='Add Criteria']";
	public static String valueField = "//input[@name='value']";
	public static String blockOption = "(//*[span='Block'])[2]";
	public static String equalsOption2 = "//*[@aria-label='Equals']";
	public static String valueField2 = "(//input[@name='value'])[2]";
	public static String caseAssigneeField = "//label[@for='caseAssignee']/following::label";
	public static String inspectionAssigneeField = "//label[@for='inspectionAssignee']/following::label[text()='Select Option']";
	public static String userOptionCA = "//label[@for='caseAssignee']/following::ul/li[1]";
	public static String userOptionIA = "//label[@for='inspectionAssignee']/following::ul/li[1]";
	public static String createRulebutton = "//button[text()='Create Rule']";
	public static String addedRule = "//div[@class='sortable-table__body__tr']";
	public static String editRuleIcon = "//div[@class='sortable-table__body__td']/button[1]";
	public static String crossCriteriaIcon = "(//div[@class='close-icon'])[2]";
	public static String userOptionCA2 = "//label[@for='caseAssignee']/following::ul/li[2]";
	public static String saveButtonEditRule = "//h1[text()='Edit Rule']/following::button[text()='Save']";
	public static String assignCaseToColumn = "//div[@class='sortable-table__body__td'][2]";
	public static String deleteRuleIcon = "//div[@class='sortable-table__body__td']/button[2]";
	public static String inactiveToggle = "//button[text()='Inactive']";
	public static String activeToggle = "//button[text()='Active']";

	public static By EditAssignmentIcon = By.xpath(editAssignmentIcon);
	public static By AssignmentRuleSideBar = By.xpath(assignmentRuleSideBar);
	public static By EditAssignmentPopup = By.xpath(editAssignmentPopup);
	public static By NameField = By.xpath(nameField);
	public static By DescriptionField = By.xpath(descriptionField);
	public static By ActionDropdown = By.xpath(actionDropdown);
	public static By OptionActionDropdown = By.xpath(optionActionDropdown);
	public static By CrossIconRuleSet = By.xpath(crossIconRuleSet);
	public static By SaveButton = By.xpath(saveButton);
	public static By ValidationNoRule = By.xpath(validationNoRule);
	public static By AddRuleButton = By.xpath(addRuleButton);
	public static By CreateRule = By.xpath(createRule);
	public static By CriteriaFields = By.xpath(criteriaFields);
	public static By ZipOption = By.xpath(zipOption);
	public static By EqualsOption = By.xpath(equalsOption);
	public static By ValueField = By.xpath(valueField);
	public static By AddCriteriaLink = By.xpath(addCriteriaLink);
	public static By EqualsOption2 = By.xpath(equalsOption2);
	public static By CaseAssigneeField = By.xpath(caseAssigneeField);
	public static By InspectionAssigneeField = By.xpath(inspectionAssigneeField);
	public static By UserOptionCA = By.xpath(userOptionCA);
	public static By UserOptionIA = By.xpath(userOptionIA);
	public static By CreateRulebutton = By.xpath(createRulebutton);
	public static By AddedRule = By.xpath(addedRule);
	public static By EditRuleIcon = By.xpath(editRuleIcon);
	public static By UserOptionCA2 = By.xpath(userOptionCA2);
	public static By SaveButtonEditRule = By.xpath(saveButtonEditRule);
	public static By AssignCaseToColumn = By.xpath(assignCaseToColumn);
	public static By DeleteRuleIcon = By.xpath(deleteRuleIcon);
	public static By InactiveToggle = By.xpath(inactiveToggle);
	public static By BlockOption = By.xpath(blockOption);
	public static By ValueField2 = By.xpath(valueField2);
	public static By ActiveToggle = By.xpath(activeToggle);

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

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
		clickByJsExecuter(By.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']"));

		waitForCurserRunning(10);
		waitForPresenceandVisiblity(By.xpath("//label[text()='Audit Trail']"));
		scrollIntoView(By.xpath("//label[text()='Audit Trail']"));
	}

	public void Navigate_To_AssignmentRules() throws InterruptedException {

		waitForPresenceandVisiblity(AssignmentRuleSideBar);
		scrollIntoView(AssignmentRuleSideBar);
		waitForElementIsInteractable(AssignmentRuleSideBar);
		clickByJsExecuter(AssignmentRuleSideBar);
		waitForCurserRunning(2);

	}

	public void CaseAssignment_OpenEditAssignmentPopup() throws InterruptedException {
		Thread.sleep(3000);
		NavigateTo_AgencySetup();
		Navigate_To_AssignmentRules();
		waitUntilElementIsVisible(EditAssignmentIcon);
		waitUntilElementIsVisible(EditAssignmentIcon);
		waitForElementIsInteractable(EditAssignmentIcon);
		clickByJsExecuter(EditAssignmentIcon);
		Thread.sleep(5000);
		String PopupTitle = getTextElement(EditAssignmentPopup);
		Assert.assertEquals(PopupTitle, CEConstants.EDIT_ASSIGNMENT);
	}

	public void CaseAssignment_EditFieldsOnEditAssignmentPopup() throws InterruptedException {

		String RandomName = RandomStrings.requiredString(10);

		WebElement Name = waitUntilVisibleWE(NameField);

		Name.clear();
		Name.sendKeys(RandomName);
		String NameValue = waitUntilVisibleWE(NameField).getAttribute("value");
		Assert.assertEquals(NameValue, RandomName);
	}

	public void CaseAssignment_NotAbleToUpdateWithoutRule() throws InterruptedException {
		try {
			scrollIntoView(CrossIconRuleSet);
		} catch (WebDriverException we) {
			we.printStackTrace();
		}

		implicitWaitforCustometime(2);
		List<WebElement> CrossIcon = driver.findElements(CrossIconRuleSet);

		int CountCrossIcons = CrossIcon.size();
		while (CountCrossIcons > 0) {
			waitForElementIsInteractable(CrossIconRuleSet);
			driver.findElement(CrossIconRuleSet).click();

			implicitWaitforCustometime(2);
			CountCrossIcons--;
		}

		clickOn(SaveButton);
		String NoRuleValidation = getTextElement(ValidationNoRule);
		Assert.assertEquals(NoRuleValidation, CEConstants.ONE_RULE_VALIDATOON);
	}

	public void CaseAssignment_OpenCreateRulepopup() throws InterruptedException {
		clickOn(AddRuleButton);
		Thread.sleep(5000);
		String PopupTitle = getTextElement(CreateRule);
		Assert.assertEquals(PopupTitle, CEConstants.CREAT_RULE_POPUP_TITLE);
	}

	public void CaseAssignment_CreateRuleWithMultipleCriterias() throws InterruptedException {
		clickOn(CriteriaFields);
		waitForElementIsInteractable(customLocationFieldsTab);
		forcedWaitTime(2);
		clickOn(customLocationFieldsTab);
		waitForElementIsInteractable(ZipOption);
		clickOn(ZipOption);
		clickOn(CriteriaFields2);
		waitForElementIsInteractable(EqualsOption);
		clickOn(EqualsOption);
		waitForElementIsInteractable(ValueField);
		sendKeysWithWait(ValueField, "77590");
		clickOn(AddCriteriaLink);
		clickOn(CriteriaFields);
		waitForElementIsInteractable(customLocationFieldsTab2);
		clickOn(customLocationFieldsTab2);
		waitForElementIsInteractable(BlockOption);
		clickOn(BlockOption);
		clickOn(CriteriaFields2);
		waitForElementIsInteractable(EqualsOption2);
		clickOn(EqualsOption2);
		waitForElementIsInteractable(ValueField2);
		sendKeysWithWait(ValueField2, "1");
		clickOn(CaseAssigneeField);
		waitForElementIsInteractable(UserOptionCA);
		clickOn(UserOptionCA);
		clickOn(InspectionAssigneeField);
		waitForElementIsInteractable(UserOptionIA);
		clickOn(UserOptionIA);
		clickOn(CreateRulebutton);
		waitForElementIsInteractable(AddedRule);
		List<WebElement> RulesCount = driver.findElements(AddedRule);
		boolean SizeAfter = RulesCount.size() >= 1;
		Assert.assertEquals(SizeAfter, true);

	}

	public void CaseAssignment_EditAddedRule() throws InterruptedException {
		String AssigneeBefore = getTextElement(AssignCaseToColumn);
		clickByJsExecuter(EditRuleIcon);
		clickByJsExecuter(CaseAssigneeField);
		waitForElementIsInteractable(UserOptionCA2);
		clickByJsExecuter(UserOptionCA2);
		waitForElementIsInteractable(SaveButtonEditRule);
		clickByJsExecuter(SaveButtonEditRule);
		String AssigneeAfter = getTextElement(AssignCaseToColumn);
		boolean CompareStr = AssigneeBefore.equals(AssigneeAfter);
		Assert.assertEquals(CompareStr, false);

	}
	
	public static String editRulebtn = "(//span//b[contains(text(),'%s')]//ancestor::div[@class='sortable-table__body__td']//following-sibling::div//button)[1]";
	public void editRule(String rule,String assingee,String inspectionAssignee) {
		clickByJsExecuter(By.xpath(stringFormat(editRulebtn, rule)));
		
		clickByJsExecuter(By.xpath("//label[@for='caseAssignee']//parent::div//span"));
		waitForElementIsInteractable(By.xpath("//div[@id='caseAssignee']//input"));
		sendKeysWithWait(By.xpath("//div[@id='caseAssignee']//input"), assingee);
	
		waitForElementIsInteractable(By.xpath("//div[@id='caseAssignee']//ul//li//span//b[contains(text(),'"+assingee+"')]"));
		clickByJsExecuter(By.xpath("//div[@id='caseAssignee']//ul//li//span//b[contains(text(),'"+assingee+"')]"));
		
		
		clickByJsExecuter(By.xpath("//label[@for='inspectionAssignee']//parent::div//span"));
		waitForElementIsInteractable(By.xpath("//div[@id='inspectionAssignee']//input"));
		sendKeysWithWait(By.xpath("//div[@id='inspectionAssignee']//input"), inspectionAssignee);
	
		waitForElementIsInteractable(By.xpath("//div[@id='inspectionAssignee']//ul//li//span//b[contains(text(),'"+inspectionAssignee+"')]"));
		clickByJsExecuter(By.xpath("//div[@id='inspectionAssignee']//ul//li//span//b[contains(text(),'"+inspectionAssignee+"')]"));
		
		
		waitForElementIsInteractable(SaveButtonEditRule);
		clickByJsExecuter(SaveButtonEditRule);
	}

	public void CaseAssignment_DeleteAddedRule() {
		List<WebElement> RulesCountBefore = driver.findElements(AddedRule);
		int BeforeDeleting = RulesCountBefore.size();
		clickOn(DeleteRuleIcon);
		List<WebElement> RulesCountAfter = driver.findElements(AddedRule);
		int AfterDeleting = RulesCountAfter.size();
		boolean CompareCount = (AfterDeleting == BeforeDeleting - 1);
		Assert.assertEquals(CompareCount, true);

	}
	
	public void clickOnSave() {
		clickByJsExecuter(SaveButton);
	}

	public void CaseAssignment_AssignmentRuleUnderInactiveSection() throws InterruptedException {
		clickOn(AddRuleButton);
		clickOn(CriteriaFields);
		waitForElementIsInteractable(customLocationFieldsTab);
        clickOn(customLocationFieldsTab);
		waitForElementIsInteractable(ZipOption);
		clickOn(ZipOption);
		clickOn(CriteriaFields2);

		waitForElementIsInteractable(EqualsOption);
		clickOn(EqualsOption);

		waitForElementIsInteractable(ValueField);
		sendKeysWithWait(ValueField, "77590");
		clickOn(CaseAssigneeField);

		waitForElementIsInteractable(UserOptionCA);
		clickOn(UserOptionCA);
		clickOn(InspectionAssigneeField);

		waitForElementIsInteractable(UserOptionIA);
		clickOn(UserOptionIA);
		clickOn(CreateRulebutton);

		waitForElementIsInteractable(InactiveToggle);
		clickByJsExecuter(InactiveToggle);
		clickByJsExecuter(SaveButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath("//div[@role='gridcell']"));
		waitUntilElementPresent(By.xpath("//div[@role='gridcell']"));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		waitUntilElementIsVisible(EditAssignmentIcon);
		waitForStaleElementReference(EditAssignmentIcon);
		waitUntilElementPresent(EditAssignmentIcon);
		waitForElementIsInteractable(EditAssignmentIcon);
		try {
			forcedWaitTime(2);
			clickOn(EditAssignmentIcon);
		} catch (Exception e) {
			forcedWaitTime(2);
			movetoElementAndClick(EditAssignmentIcon);
		}
		waitUntilElementIsVisible(ActiveToggle);
		waitUntilElementPresent(ActiveToggle);
		waitForElementIsInteractable(ActiveToggle);
		clickByJsExecuter(ActiveToggle);
		waitUntilElementIsVisible(SaveButton);
		waitForElementIsInteractable(SaveButton);
		clickByJsExecuter(SaveButton);

	}

}
