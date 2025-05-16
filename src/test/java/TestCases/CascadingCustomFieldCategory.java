package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.RandomStrings;
import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static POM.CCPUtility.description;
import static POM.CSPExternalUtility.*;
import static POM.CSPInternalGISDirect20Utility.IssueDescriptionField;
import static POM.CSPInternalGISDirect20Utility.SubmissionNumber;
import static POM.CategoryPage.*;
import static POM.CategoryPage.issueDescriptionField;

public class CascadingCustomFieldCategory extends BrowsersInvoked {

	
	ITestResult result;
	CCPUtility ccp;
	CategoryPage category;
	int newResoTime;
	int categoriesCountBefore;
	String RandomCategoryname;
	CRMCommonMethods crmCommonMethods;
	CSPExternalUtility cspExternal;
	
	
	
	
	
	@BeforeClass
    public void setUp() throws InterruptedException {
        Setup(); // sets driver for this thread
       
        ccp = new CCPUtility(getDriver());
		category = new CategoryPage(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		cspExternal = new CSPExternalUtility(getDriver());

		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
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

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
	


	@Test(priority = 1, enabled = true, description = "")
	public void verifyThatAddSecondaryCustomFieldLinkAppear() throws InterruptedException {
		category.naviateToCategory();
		category.clickOnCreateCategoryBtn();
		category.clickOn(addFieldCustomField);

		String linkText = category.getTextElement(addSecondayCustomField);
		SoftAssert st = new SoftAssert();
		st.assertEquals(linkText, "Add Secondary Custom Field", "link Text doesnot appear same");
		st.assertAll();
	}

	@Test(priority = 2, enabled = true, description = "")
	public void verifyThatSecondaryCustomFieldsSectionAppears() throws InterruptedException {

		category.clickOn(addSecondayCustomField);

		String headingText = category.getTextElement(secondaryCustomFieldsSection);
		SoftAssert st = new SoftAssert();
		st.assertEquals(headingText, "Secondary Custom Fields (1)", "Heading Text doesnot appear same");
		st.assertAll();

	}

	@Test(priority = 3, enabled = true, description = "")
	public void verifyThatFollowingSectionAppearsUnderCustomFields() throws InterruptedException {

		String actualLabelHeading = category.getTextElement(labelCustomFields);
		String actualRequiredHeading = category.getTextElement(requiredCustomFields);
		String actualStatusHeading = category.getTextElement(statusCustomFields);
		String actualTypeHeading = category.getTextElement(typeCustomFields);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualLabelHeading, "Label", "Label Heading Text doesnot appear");
		st.assertEquals(actualRequiredHeading, "Required?", "Required Heading Text doesnot appear");
		st.assertEquals(actualStatusHeading, "Status", "Status Heading Text doesnot appear");
		st.assertEquals(actualTypeHeading, "Type", "Type Heading Text doesnot appear");
		st.assertAll();

	}

	@Test(priority = 4, enabled = true, description = "")
	public void verifyThatSecondaryCustomFieldsSectionAppears2() throws InterruptedException {

		category.clickOn(addSecondayCustomField);

		String headingText = category.getTextElement(secondaryCustomField2);
		SoftAssert st = new SoftAssert();
		st.assertEquals(headingText, "Secondary Custom Fields (2)", "Secondary Custom Fields (2) doesnot appear");
		st.assertAll();

	}

	@Test(priority = 5, enabled = true, description = "")
	public void verifyThatFollowingSectionAppearsUnderCustomFields2() throws InterruptedException {

		String actuallabelSecondaryCustomFields2 = category.getTextElement(labelSecondaryCustomFields2);
		String actualrequiredSecondaryCustomFields2 = category.getTextElement(requiredSecondaryCustomFields2);
		String actualstatusSecondaryCustomFields2 = category.getTextElement(statusSecondaryCustomFields2);
		String actualtypeSecondaryCustomFields2 = category.getTextElement(typeSecondaryCustomFields2);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actuallabelSecondaryCustomFields2, "Label", "Label Heading Text doesnot appear");
		st.assertEquals(actualrequiredSecondaryCustomFields2, "Required?", "Required Heading Text doesnot appear");
		st.assertEquals(actualstatusSecondaryCustomFields2, "Status", "Status Heading Text doesnot appear");
		st.assertEquals(actualtypeSecondaryCustomFields2, "Type", "Type Heading Text doesnot appear");
		st.assertAll();

	}

	@Test(priority = 6, enabled = true, description = "")
	public void verifyThatSecondaryCustomFieldsDisappear() throws InterruptedException {

		for (var i = 0; i < 3; i++) {
			category.waitForPresenceandVisiblity(addSecondayCustomField);
			category.clickOn(addSecondayCustomField);
		}

		SoftAssert st = new SoftAssert();
		st.assertTrue((category.findElementsSize(addSecondayCustomField) == 0), "add Secondary Custom Field link appears ");
		st.assertAll();

	}

	public static String categoryCustomFieldName;

	@Test(priority = 7, enabled = true, description = "")
	public void verifyThatAppropriateValidationMessageAppearsWhenFieldLeftBlank() throws InterruptedException {

		// close secondary custom fields .
		for (var i = 0; i < 4; i++) {
			category.waitForPresenceandVisiblity(closeButtonSecondaryCustomField);
			category.clickOn(closeButtonSecondaryCustomField);
		}
		categoryCustomFieldName = "CatCategory" + RandomStrings.requiredCharacters(3);
		category.sendKeysWithWait(NameField, categoryCustomFieldName);
		category.waitForElementIsInteractable(closeButtonSecondaryCustomField);
		category.clickByJsExecuter(CreateCategoryPopupBtn);

		String actualLabelValidationMessage = category.getTextElement(labelFieldValidationMessage);
		String actualPrimaryQuestionValidationMessage = category.getTextElement(primaryQuestionValidationMessage);
		String actualPrimaryQuestionLabelTextValidationMessage = category
				.getTextElement(primaryQuestionLabelTextValidationMessage);
		String actuallabelFieldValidationMessageSecondaryCustom = category
				.getTextElement(labelFieldValidationMessageSecondaryCustom);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualLabelValidationMessage, "The Label is required.",
				"Label Heading Message doesnot appear");
		st.assertEquals(actualPrimaryQuestionValidationMessage, "Picklist type should have options",
				"Picklist type validation Message doesnot appear ");
		st.assertEquals(actualPrimaryQuestionLabelTextValidationMessage, "The Label is required.",
				"Primary Question Label Message Validaiton Text doesnot appear");
		st.assertEquals(actuallabelFieldValidationMessageSecondaryCustom, "The Label is required.",
				"label Field Validation MessageSecondaryCustom Message doesnot appear");
		st.assertAll();

	}

	@Test(priority = 8, enabled = true, description = "")
	public void verifyThatUserIsAbleToSelectOptionsUnderSecondaryCustom() throws InterruptedException {

		category.sendKeysWithWait(LabelField, RandomStrings.requiredCharacters(5));
		category.waitForElementIsInteractable(typeDropdown);
		category.clickOn(typeDropdown);
		category.waitForElementIsInteractable(numberDropDownType);
		category.clickOn(numberDropDownType);
		String actualType = category.getTextElement(typeDropdown);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualType, "Number", "type name doesnot match");
		st.assertAll();

	}

	String customFieldName;

	@Test(priority = 9, enabled = true, description = "")
	public void verifyThatUserIsAbleToCreateCatergoryWithContains() throws InterruptedException {
		category.waitForElementIsInteractable(AddFieldLink);
		category.clickOn(AddFieldLink);
		customFieldName = "Cat" + RandomStrings.requiredCharacters(3);
		category.sendKeysWithWait(labelFieldSecondaryCustomField, customFieldName);
		category.waitForElementIsInteractable(addSecondayCustomField);
		category.clickOn(addSecondayCustomField);
		category.scrollIntoView(primaryOptionsDropdown);
		category.waitForElementIsInteractable(primaryOptionsDropdown);
		category.clickOn(primaryOptionsDropdown);
		category.waitForElementIsInteractable(containsDropdownTxt);
		category.clickOn(containsDropdownTxt);
		category.sendKeysWithWait(nameFieldSeondaryCustom, "Black");
		category.sendKeysWithWait(labelFieldSecondaryCustomField3, "Breed");
		category.waitForElementIsInteractable(CreateCategoryPopupBtn);
		category.clickOn(CreateCategoryPopupBtn);
		category.waitForCurserRunning(4);
		int activeCount = category.getActiveHeaderCount();
		System.out.println(activeCount);
		category.scrollIntoView(
				By.xpath(category.selectorFormate(lastRowCountCategory, String.valueOf(activeCount - 1))));
		String actualCategoryName = category.getTextElement(
				By.xpath(category.selectorFormate(lastRowCountCategory, String.valueOf(activeCount - 1))));
		System.out.println(actualCategoryName);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualCategoryName, categoryCustomFieldName, "Category name does not match ");
		st.assertAll();

	}

	@Test(priority = 10, enabled = true, description = "")
	public void verifyThatUserIsAbleToCreateCatergoryWithEquals() throws InterruptedException {
		System.out.println("categoryCustomFieldName: "+categoryCustomFieldName);
		category.waitForElementIsInteractable(
				By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.clickByJsExecuter(By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));

		category.scrollIntoView(AddFieldLink);
		category.waitForElementIsInteractable(AddFieldLink);
		category.forcedWaitTime(3);
		category.waitForElementIsInteractable(AddFieldLink);
		category.clickOn(AddFieldLink);
		category.sendKeysWithWait(labelFieldSecondaryCustomField4, "Cat2" + RandomStrings.requiredCharacters(3));
		category.waitForElementIsInteractable(addSecondayCustomField2);
		category.clickOn(addSecondayCustomField2);
		category.scrollIntoView(primaryOptionsDropdown);
		category.waitForElementIsInteractable(primaryOptionsDropdown);
		category.clickOn(primaryOptionsDropdown);
		category.waitForElementIsInteractable(equalsDropdownTxt);
		category.clickOn(equalsDropdownTxt);

		category.sendKeysWithWait(nameFieldSeondaryCustom3, "Brown");
		category.sendKeysWithWait(labelFieldSecondaryCustomField5, "Breed2");
		category.waitForElementIsInteractable(SaveButton);
		category.clickOn(SaveButton);
		int activeCount = category.getActiveHeaderCount();
		System.out.println(activeCount);
		category.scrollIntoView(
				By.xpath(category.selectorFormate(lastRowCountCategory, String.valueOf(activeCount - 1))));
		String actualCategoryName = category.getTextElement(
				By.xpath(category.selectorFormate(lastRowCountCategory, String.valueOf(activeCount - 1))));
		System.out.println(actualCategoryName);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualCategoryName, categoryCustomFieldName, "Category name doesnot match ");
		st.assertAll();

	}

	@Test(priority = 11, enabled = true, description = "")
	public void verifyThatSecondaryCustomFieldsSectionAppearsClickingOnEditIcon() throws InterruptedException {
		category.waitForElementIsInteractable(
				By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.clickByJsExecuter(By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.waitForPresenceandVisiblity(secondaryCustomFieldsSection);
		category.scrollIntoView(secondaryCustomFieldsSection);
		String headingText = category.getTextElement(secondaryCustomFieldsSection);
		SoftAssert st = new SoftAssert();
		st.assertEquals(headingText, "Secondary Custom Fields (1)", "Heading Text doesnot appear same");
		st.assertAll();
	}

	@Test(priority = 12, enabled = true, description = "")
	public void verifyThatSecondaryFiledAppearMandatoryAfterClickingYesToggle() throws InterruptedException {
		category.scrollIntoView(requiredYesToggle);
		category.waitForElementIsInteractable(requiredYesToggle);
		category.clickOn(requiredYesToggle);
		category.scrollIntoView(SaveButton);
		category.clickOn(SaveButton);
		crmCommonMethods.navigateToCSP();
		category.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);

		category.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		category.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		Thread.sleep(5000);
		category.clickOn(CSPInternalUtility.SearchResultsCategory);
		String RandomDescription = RandomStrings.requiredString(20);
		category.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		category.clickOn(createSubmissionButton);

		String validationText = "The " + customFieldName + " is required.";
		System.out.println(validationText);
		String actualText = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText)));
		System.out.println(actualText);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "The " + customFieldName + " is required.", "validation Message doesnot match");
		st.assertAll();
	}

	public static boolean submissionnumber;

	@Test(priority = 13, enabled = true, description = "")
	public void verifyThatCategoryFieldAppearOptionalWhenNoOptionAvailable() throws InterruptedException {
		category.naviateToCategory();
		category.clickByJsExecuter(By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.waitForCurserRunning(3);
		category.scrollIntoView(requiredNoToggle);
		category.clickOn(requiredNoToggle);
		category.scrollIntoView(SaveButton);
		category.clickOn(SaveButton);
		crmCommonMethods.navigateToCSP();
		category.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);

		category.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		category.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		Thread.sleep(5000);
		category.clickOn(CSPInternalUtility.SearchResultsCategory);
		String RandomDescription = RandomStrings.requiredString(20);
		category.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		category.waitForCurserRunning(3);
		// to check whether the submission is created or not .
		category.clickOn(createSubmissionButton);
		category.waitUntilElementIsVisible(SubmissionNumber);
		submissionnumber = category.elementIsDisplayed(SubmissionNumber);
		SoftAssert st = new SoftAssert();
		st.assertEquals(submissionnumber, true, "submission is not created");
		st.assertAll();
	}

	public String RASPageTitle;

	@Test(priority = 14, enabled = true, description = "")
	public void verifyThatCategoryFieldAppearOptionalWhenNoOptionCSPExternal() throws InterruptedException {
		cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
		category.waitUntilElementIsVisible(dropdownCategoryCSPExternal);
		category.scrollIntoView(dropdownCategoryCSPExternal);
		category.clickOn(dropdownCategoryCSPExternal);
		category.waitUntilElementIsVisible(searchCategoryCSPExternal);
		category.sendKeysWithWait(searchCategoryCSPExternal, categoryCustomFieldName);
		category.clickOn(By.xpath(category.selectorFormate(dropDownOptionCategory, categoryCustomFieldName)));
		category.sendKeysWithWait(issueDescriptionField, RandomStrings.requiredString(5));
		crmCommonMethods.clickOnIssueDescriptionNextButton();
		crmCommonMethods.clickOnLocationNextButton();

		category.sendKeysWithWait(FirstNameField, RandomStrings.requiredCharacters(8));
//        category.waitUntilVisibleWE(FirstNameField).clear();
		category.sendKeysWithWait(LastNameField, RandomStrings.requiredCharacters(8));
//        category.waitUntilVisibleWE(LastNameField).clear();

		category.waitUntilElementIsVisible(SubmitButton);
		category.scrollIntoView(SubmitButton);
		category.waitForElementIsInteractable(SubmitButton);
		category.clickByJsExecuter(SubmitButton);
		category.waitForCurserRunning(2);
		category.waitUntilElementIsVisible(ReportAnIssuePage);
		RASPageTitle = category.getTextElement(ReportAnIssuePage);
		SoftAssert st = new SoftAssert();
		st.assertEquals(RASPageTitle, "Report an issue");
		st.assertAll();

	}

	@Test(priority = 15, enabled = true, description = "")
	public void verifyThatCategoryFieldAppearOptionalWhenYesOptionCSPExternal() throws InterruptedException {
		category.naviateToCategory();
		category.clickByJsExecuter(By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.waitForCurserRunning(3);
		category.scrollIntoView(requiredYesToggle);
		category.clickOn(requiredYesToggle);
		category.scrollIntoView(SaveButton);
		category.clickOn(SaveButton);
		cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
		category.waitUntilElementIsVisible(dropdownCategoryCSPExternal);
		category.scrollIntoView(dropdownCategoryCSPExternal);
		category.clickOn(dropdownCategoryCSPExternal);
		category.waitUntilElementIsVisible(searchCategoryCSPExternal);
		category.sendKeysWithWait(searchCategoryCSPExternal, categoryCustomFieldName);
		category.clickOn(By.xpath(category.selectorFormate(dropDownOptionCategory, categoryCustomFieldName)));
		category.sendKeysWithWait(issueDescriptionField, RandomStrings.requiredString(5));
		crmCommonMethods.clickOnIssueDescriptionNextButton();
		String validationText = "The " + customFieldName + " is required.";
		System.out.println(validationText);
		String actualText = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText)));
		System.out.println(actualText);
		category.sendKeysWithWait(categorySecondaryFieldText, RandomStrings.requiredString(5));
		crmCommonMethods.clickOnIssueDescriptionNextButton();
		crmCommonMethods.clickOnLocationNextButton();
		category.waitForPresenceandVisiblity(FirstNameField);
		category.sendKeysWithWait(FirstNameField, RandomStrings.requiredCharacters(8));

//        category.waitUntilVisibleWE(FirstNameField).clear();
		category.sendKeysWithWait(LastNameField, RandomStrings.requiredCharacters(8));

//        category.waitUntilVisibleWE(LastNameField).clear();

		category.waitUntilElementIsVisible(SubmitButton);
		category.scrollIntoView(SubmitButton);
		category.waitForElementIsInteractable(SubmitButton);
		category.clickByJsExecuter(SubmitButton);
		category.waitForCurserRunning(2);
		category.waitUntilElementIsVisible(ReportAnIssuePage);
		RASPageTitle = category.getTextElement(ReportAnIssuePage);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "The " + customFieldName + " is required.", "validation Message doesnot match");
		st.assertEquals(RASPageTitle, "Report an issue", "Report issue page doesnot appear");
		st.assertAll();
	}

	@Test(priority = 16, enabled = true, description = "")
	public void verifyThatNestedCascadingfieldAppearsOnCSP() throws InterruptedException {
		category.forcedWaitTime(3);
		category.naviateToCategory();
		crmCommonMethods.navigationToCSP();
		category.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		category.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		Thread.sleep(5000);
		category.clickOn(CSPInternalUtility.SearchResultsCategory);
		category.sendKeysWithWait(enterTextCategory1CSP, "black");
		boolean breedCategory = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed")));
		System.out.println(breedCategory);
		category.sendKeysWithWait(enterTextCategory2CSP, "brown");
		boolean breedCategory2 = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed2")));
		System.out.println(breedCategory2);

		String RandomDescription = RandomStrings.requiredString(20);
		category.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		category.waitForCurserRunning(3);

		SoftAssert st = new SoftAssert();
		st.assertTrue(breedCategory, "sub category1 is not visible");
		st.assertTrue(breedCategory2, "sub category2 is not visible");
		st.assertAll();

	}

	@Test(priority = 17, enabled = true, description = "")
	public void verifyThatValidationMessageAppearONNestedCascadingfieldAppearsOnCSP() throws InterruptedException {
		category.naviateToCategory();
		category.clickByJsExecuter(By.xpath(category.selectorFormate(editCategorysIcon, categoryCustomFieldName)));
		category.waitForCurserRunning(3);
		category.scrollIntoView(requiredSecondaryCustomFields);
		category.clickOn(requiredSecondaryCustomFields);
		category.scrollIntoView(requiredSecondaryCategoryCustomFields2);
		category.clickOn(requiredSecondaryCategoryCustomFields2);
		category.scrollIntoView(SaveButton);
		category.clickOn(SaveButton);
		crmCommonMethods.navigateToCSP();
		category.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		category.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		category.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		category.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		Thread.sleep(5000);
		category.clickOn(CSPInternalUtility.SearchResultsCategory);
		category.sendKeysWithWait(enterTextCategory1CSP, "black");
		boolean breedCategory = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed")));
		System.out.println(breedCategory);
		category.sendKeysWithWait(enterTextCategory2CSP, "brown");
		boolean breedCategory2 = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed2")));
		System.out.println(breedCategory2);

		String RandomDescription = RandomStrings.requiredString(20);
		category.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		category.waitForCurserRunning(3);
		category.clickOn(createSubmissionButton);
		String validationText = "The Breed is required.";
		String validationText2 = "The Breed2 is required.";

		String actualText = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText)));
		System.out.println(actualText);
		String actualText2 = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText2)));
		System.out.println(actualText);

		SoftAssert st = new SoftAssert();
		st.assertTrue(breedCategory, "sub category1 is not visible");
		st.assertTrue(breedCategory2, "sub category2 is not visible");
		st.assertEquals(actualText, validationText, "validation Message 1 doesnot match");
		st.assertEquals(actualText2, validationText2, "validation Message 2 doesnot match");
		st.assertAll();

	}

	@Test(priority = 18, enabled = true, description = "")
	public void verifyThatUserIsAbleToCreateSubmissionByEnterValueinSecondaryCustomField() throws InterruptedException {
		category.sendKeysWithWait(breedTextCustomField, RandomStrings.requiredString(3));
		category.sendKeysWithWait(breed2TextCustomField, RandomStrings.requiredString(4));
		category.clickOn(createSubmissionButton);
		category.waitUntilElementIsVisible(SubmissionNumber);
		boolean submissionnumber = category.elementIsDisplayed(SubmissionNumber);
		SoftAssert st = new SoftAssert();
		st.assertEquals(submissionnumber, true, "submission is not created");
		st.assertAll();

	}

	@Test(priority = 19, enabled = true, description = "")
	public void verifyThatAppropriateNestedCustomFieldAppearsOnCSPExternal() throws InterruptedException {
		cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
		category.waitUntilElementIsVisible(dropdownCategoryCSPExternal);
		category.scrollIntoView(dropdownCategoryCSPExternal);
		category.clickOn(dropdownCategoryCSPExternal);
		category.waitUntilElementIsVisible(searchCategoryCSPExternal);
		category.sendKeysWithWait(searchCategoryCSPExternal, categoryCustomFieldName);
		category.clickOn(By.xpath(category.selectorFormate(dropDownOptionCategory, categoryCustomFieldName)));
		category.sendKeysWithWait(issueDescriptionField, RandomStrings.requiredString(5));
		category.sendKeysWithWait(enterTextCategory1CSPExternal, "black");
		category.sendKeysWithWait(enterTextCategory2CSPExternal, "brown");

		boolean breedCategory = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed")));
		System.out.println(breedCategory);
		boolean breedCategory2 = category
				.elementIsDisplayed(By.xpath(category.selectorFormate(breedCategoryfieldCSP, "Breed2")));
		System.out.println(breedCategory2);

		SoftAssert st = new SoftAssert();
		st.assertTrue(breedCategory, "sub category1 is not visible");
		st.assertTrue(breedCategory2, "sub category2 is not visible");
		st.assertAll();

	}

	@Test(priority = 20, enabled = true, description = "")
	public void verifyThatAppropriateValidationMessageAppearsonNestedCustomFieldsCSPExternal()
			throws InterruptedException {

		crmCommonMethods.clickOnIssueDescriptionNextButton();
		String validationText = "The Breed is required.";
		String validationText2 = "The Breed2 is required.";

		String actualText = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText)));
		System.out.println(actualText);
		String actualText2 = category
				.getTextElement(By.xpath(category.selectorFormate(categoryValidationMessageCSP, validationText2)));
		System.out.println(actualText2);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, validationText, "validation Message Doesnot Match");
		st.assertAll();

	}

	@Test(priority = 21, enabled = true, description = "")
	public void verifyThatUSerIsAbletoCreateSubmisionCSPExternalWithNestedCustomField() throws InterruptedException {

		category.sendKeysWithWait(breedTextCustomFieldCSPExternal, RandomStrings.requiredString(3));
		category.sendKeysWithWait(breed2TextCustomFieldCSPExternal, RandomStrings.requiredString(3));
		crmCommonMethods.clickOnIssueDescriptionNextButton();
		crmCommonMethods.clickOnLocationNextButton();
		category.sendKeysWithWait(FirstNameField, RandomStrings.requiredCharacters(8));
//        category.waitUntilVisibleWE(FirstNameField).clear();
		category.sendKeysWithWait(LastNameField, RandomStrings.requiredCharacters(8));
//        category.waitUntilVisibleWE(LastNameField).clear();
		category.waitUntilElementIsVisible(SubmitButton);
		category.scrollIntoView(SubmitButton);
		category.waitForElementIsInteractable(SubmitButton);
		category.clickByJsExecuter(SubmitButton);
		category.waitForCurserRunning(2);
		category.waitUntilElementIsVisible(ReportAnIssuePage);
		String RASPageTitle = category.getTextElement(ReportAnIssuePage);
		SoftAssert st = new SoftAssert();
		st.assertEquals(RASPageTitle, "Report an issue", "Report issue page doesnot appear");
		st.assertAll();

	}



}
