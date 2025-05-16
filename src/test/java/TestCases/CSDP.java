package TestCases;

import CommonMethods.CRMCommonMethods;
import CommonMethods.DateAndTime;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import org.testng.asserts.SoftAssert;

import static CommonMethods.CRMCommonMethods.extractIntegersWithHyphen;
import static POM.CSDPUtility.*;
import static POM.CSLPUtility.CSLPSearchField;
import static POM.CSLPUtility.cSLPSearchField;
import static POM.CategoryPage.*;
import static POM.CategoryPage.SaveButton;
import static POM.CategoryPage.breedCategoryfieldCSP;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CSDP extends BrowsersInvoked {

	
	ExtentReportClass extentClass;
	ITestResult result;
	CSDPUtility csdp;
	DateAndTime dateAndTime;
	CRMCommonMethods crmCommonMethods;
	CSLPUtility cslpUtility;
	CategoryPage categoryPage;
	String categoryCustomFieldName;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		csdp = new CSDPUtility(getDriver());
		dateAndTime = new DateAndTime(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		cslpUtility = new CSLPUtility(getDriver());
		categoryPage = new CategoryPage(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
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

	@Test(priority = 1)
	public void CSDP_OpenCSDPAfterSubmissionCreation() throws InterruptedException {
		csdp.CSDP_OpenCSDPAfterSubmissionCreation();
		System.out.println("submissionId : " + csdp.submissionId);

	}

	@Test(priority = 2, description = "Verify that user is able to see valid due date on CSDP")
	public void csdp_ValidDueDateShowOnCSDP() throws InterruptedException {
		// CDS -409
		// "Invalid Due Date" showing on all new customer submissions even though
		// “Resolution time” is configured at the category level.
		String date = csdp.getTextElement(csdp.caseHeader);
		String extractedDate = dateAndTime.extractDateFromString(date);
		String dateFormat = dateAndTime.dateFormatConverter(extractedDate, "MMMM d, yyyy", "MM/dd/yyyy");
		System.out.println("dateFormat :" + dateFormat);
		String expecteddueDate = csdp.getTextElement(csdp.dueDate);
		System.out.println("dueDate :" + expecteddueDate);
		csdp.clickOn(csdp.CloseSDPage);
		csdp.navigatePage(BrowsersInvoked.URLCategories);
		csdp.forcedWaitTime(3);
		csdp.scrollIntoView(By.xpath(
				"//div[normalize-space()='" + csdp.category + "']/..//div[@class='sortable-table__body__td'][5]"));
		String resoTime = csdp.getTextElement(By.xpath(
				"//div[normalize-space()='" + csdp.category + "']/..//div[@class='sortable-table__body__td'][5]"));
		int resolutionTime = crmCommonMethods.extractedInteger(resoTime);
		System.out.println("resoTime: " + resolutionTime);
		String actualfinalDate = dateAndTime.dateManuplation(dateFormat, resolutionTime);
		System.out.println("finalDate: " + actualfinalDate);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualfinalDate, expecteddueDate);
		st.assertAll();

	}

	@Test(priority = 3)
	public void CSDP_ChangeDueByDate() throws InterruptedException {
		csdp.navigatePage(BrowsersInvoked.URLCustomerSubmissions);
		csdp.refreshPage();

		csdp.waitUntilElementIsVisible(cslpUtility.CSLPSearchField);
		csdp.sendKeysWithWait(cslpUtility.CSLPSearchField, csdp.submissionId);
		csdp.forcedWaitTime(3);
		csdp.clickByJsExecuter(By.xpath("//div[normalize-space()='" + csdp.submissionId + "']//a"));
		csdp.waitForCurserRunning(3);
		csdp.CSDP_ChangeDueByDate();

	}

	@Test(priority = 4)
	public void CSDP_VerifyInternalNotesContent() throws InterruptedException {
		csdp.CSDP_VerifyInternalNotesContent();

	}

	@Test(priority = 5)
	public void CSDP_VerifyEscalatedIssue() throws InterruptedException {
		csdp.CSDP_VerifyEscalatedIssue();

	}

	@Test(priority = 6)
	public void CSDP_VerifyReasonWithInternalNotes() throws InterruptedException {
		csdp.CSDP_VerifyReasonWithInternalNotes();

	}

	@Test(priority = 7)
	public void CSDP_VerifyNoEscalationOnCancel() throws InterruptedException {
		csdp.CSDP_VerifyNoEscalationOnCancel();

	}

	@Test(priority = 9)
	public void CSDP_VerifyDirectionToCoDP() throws InterruptedException {
		csdp.CSDP_VerifyDirectionToCoDP();

	}

	@Test(priority = 10)
	public void CSDP_VerifyDirectionToCSLPFromTags() throws InterruptedException {
		csdp.CSDP_VerifyDirectionToCSLPFromTags();

	}

	@Test(priority = 12)
	public void CSDP_VerifyAddedAttachments() throws InterruptedException {
		csdp.CSDP_VerifyAddedAttachments();

	}

	@Test(priority = 13)
	public void CSDP_VerifyAddedInternalNote() throws InterruptedException {
		csdp.CSDP_VerifyAddedInternalNote();

	}

	@Test(priority = 14)
	public void CSDP_VerifyUpdatedNote() throws InterruptedException {
		csdp.CSDP_VerifyUpdatedNote();

	}

	@Test(priority = 15)
	public void CSDP_VerifyUserIsAbleToPrintCSD() throws InterruptedException {
		csdp.CSDP_VerifyUserIsAbleToPrintCSD();

	}

	@Test(priority = 16)
	public void CSDP_VerifyMultipleTagsAddition() throws InterruptedException {
		csdp.CSDP_VerifyMultipleTagsAddition();

	}

	@Test(priority = 20)
	public void CSDP_VerifyAdditionOfTasks() throws InterruptedException {

		csdp.CSDP_VerifyAdditionOfTasks();

	}

	@Test(priority = 21)
	public void CSDP_VerifyUpdationAndDeletionOfTasks() throws InterruptedException {

		csdp.CSDP_VerifyUpdationAndDeletionOfTasks();

	}

	@Test(priority = 22)
	public void CSDP_VerifyClosedSubmission() throws InterruptedException {
		csdp.CSDP_VerifyClosedSubmission();

	}

	@Test(priority = 23)
	public void CSDP_VerifyReopenedSubmission() throws InterruptedException {
		csdp.CSDP_VerifyReopenedSubmission();

	}

	@Test(priority = 24)
	public void CSDP_VerifySubmissionAssignee() throws InterruptedException {
		csdp.CSDP_VerifySubmissionAssignee();

	}

	@Test(priority = 25)
	public void CSDP_VerifySubmissionCollaborator() throws InterruptedException {
		csdp.CSDP_VerifySubmissionCollaborator();

	}

	@Test(priority = 25)
	public void CSDP_VerifySubmissionCollaboratorDeselect() throws InterruptedException {
		csdp.CSDP_VerifySubmissionCollaboratorDeselect();

	}

	@Test(priority = 26)
	public void CSDP_VerifyEmailTileWhenNoEmail() throws InterruptedException {
		csdp.CSDP_VerifyEmailTileWhenNoEmail();

	}

	@Test(priority = 27)
	public void CSDP_VerifyEmailTileExpandClickMore() throws InterruptedException {
		csdp.CSDP_VerifyEmailTileExpandClickMore();

	}

	@Test(priority = 28)
	public void CSDP_UpdateTheSubjectOfMail() throws InterruptedException {
		csdp.CSDP_UpdateTheSubjectOfMail();

	}

	@Test(priority = 29)
	public void CSDP_SubmissionDetails() throws InterruptedException {
		csdp.CSDP_SubmissionDetails();

	}

	@Test(priority = 30, enabled = true, description = "verify That Cascading Fields Appear Blank On CSDP")
	public void verifyThatCascadingFieldsAppearBlankOnCSDP() throws InterruptedException {
		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, "CascadingCategory");
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);
		csdp.sendKeysWithWait(enterTextCategory1CSP, "color1");
		csdp.sendKeysWithWait(breedTextCustomField, "brown");
		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(5);
		csdp.waitUntilElementIsVisible(hypenTextForCascadinField2);
		String actualText = csdp.getTextElement(hypenTextForCascadinField2);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "-", " - hypen text were not present");
		st.assertAll();

    }

	@Test(priority = 31, enabled = true, description = "verify That User Is Able To Enter Value In Cascading Fields Appears On CSDP")
	public void verifyThatUserIsAbleToEnterValueInCascadingFieldsAppearsCSDP() throws InterruptedException {
		csdp.clickOn(editButtonCSDP);
		csdp.sendKeysWithWait(enterTextCategory2CSPExternal, "color2");
		csdp.clickOn(whiteDropDownCSDP);
		csdp.clickOn(By.xpath(csdp.selectorFormate(lightwhiteOptionCSDP, "lightwhite")));
		csdp.clickOn(SaveButton);
		csdp.waitForCurserRunning(3);
		String actualText = csdp.getTextElement(hypenTextForCascadinField2);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "color2", "  text were not present");
		st.assertAll();
	}

	@Test(priority = 32, enabled = true, description = "verify That Cascading Label Value Appears On CSDP While Creating The Submission")
	public void verifyThatCascadingLabelValueAppearsWhileCreatingTheSubmission() throws InterruptedException {
		String actualTextLabel1 = csdp.getTextElement(cascadingLabelValueOnCSDP);
		String actualTextLabel2subField = csdp.getTextElement(cascadingSubFieldLabelValueOnCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualTextLabel1, "color1", "  text were not present");
		st.assertEquals(actualTextLabel2subField, "brown", "  text 2 were not present");
		st.assertAll();
	}

	@Test(priority = 33, enabled = true, description = "verify That User Is Able To Update Cascading Field on CSDP")
	public void verifyThatUserIsAbleToUpdateCascadingField() throws InterruptedException {

		csdp.clickOn(editButtonCSDP);
		csdp.waitUntilElementIsVisible(enterTextCategory1CSPExternal);
		csdp.sendKeysWithWait(enterTextCategory1CSPExternal, "updated");
		csdp.clickOn(SaveButton);
		csdp.waitForCurserRunning(4);

		String actualText = csdp.getTextElement(cascadingLabelValueOnCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "color1updated", "  text were not present");
		st.assertAll();
	}

	@Test(priority = 34, enabled = true, description = "verify That User Is Able To Update Cascading Nested Field On CSDP")
	public void verifyThatUserIsAbleToUpdateCascadingNestedField() throws InterruptedException {

		csdp.clickOn(editButtonCSDP);
		csdp.waitUntilElementIsVisible(breedTextCustomFieldCSPExternal);
		csdp.sendKeysWithWait(breedTextCustomFieldCSPExternal, "updated");
		csdp.clickOn(SaveButton);
		csdp.waitForCurserRunning(4);

		String actualText = csdp.getTextElement(cascadingSubFieldLabelValueOnCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualText, "brownupdated", "  text were not present");
		st.assertAll();
	}

	@Test(priority = 35, enabled = true, description = "verify That Deactivated Category Appear On CSDP")
	public void verifyThatDeactivatedCategoryAppearONCSDP() throws InterruptedException {
		csdp.waitForElementIsInteractable(CloseSDPage);
		csdp.clickOn(CloseSDPage);
		csdp.waitForCurserRunning(5);

		// crmCommonMethods.navigationTo(By.xpath(categoryPage.selectorFormate(CSDPUtility.tabParent,
		// "CRM")),By.xpath(categoryPage.selectorFormate(CSDPUtility.tabChild,
		// "CRM","Categories")));
		categoryPage.naviateToCategory();
		csdp.waitUntilElementIsVisible(CreateCategoryButton);
		csdp.waitForElementIsInteractable(CreateCategoryButton);
		categoryPage.clickOn(CreateCategoryButton);
		categoryCustomFieldName = "NewCategory" + RandomStrings.requiredCharacters(3);
		csdp.sendKeysWithWait(NameField, categoryCustomFieldName);
		csdp.clickByJsExecuter(addFieldCustomField);
		csdp.sendKeysWithWait(LabelField, RandomStrings.requiredCharacters(5));
		csdp.clickByJsExecuter(CreateCategoryPopupBtn);
		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);
		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.waitForCurserRunning(3);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(3);

		String customerSubmissionId = extractIntegersWithHyphen(csdp.getTextElement(CSDPSubmissionID));
		categoryPage.naviateToCategory();

		csdp.clickByJsExecuter(By.xpath(csdp.selectorFormate(editIconCategoryCDP, categoryCustomFieldName)));
		csdp.waitForElementIsInteractable(inactiveButton);
		csdp.clickOn(inactiveButton);
		categoryPage.clickOnSaveButton();
		categoryPage.waitForCurserRunning(3);
		crmCommonMethods.navigateToCSLP();
		csdp.sendKeysWithWait(CSLPSearchField, customerSubmissionId);
		csdp.waitUntilElementIsVisible(By.xpath(csdp.selectorFormate(submissionNumber, customerSubmissionId)));
		csdp.waitForElementIsInteractable(By.xpath(csdp.selectorFormate(submissionNumber, customerSubmissionId)));
		csdp.forcedWaitTime(3);
		csdp.clickOn(By.xpath(csdp.selectorFormate(submissionNumber, customerSubmissionId)));
		csdp.waitForCurserRunning(3);
		String actualLabelTxt = csdp.getTextElement(categoryDropDownLabelCSDP);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualLabelTxt, categoryCustomFieldName + " (Deactivated)", "name doesnot match");
		st.assertAll();
	}

	@Test(priority = 36, enabled = true, description = "verify That Internal Custom Fields Tile Appear On CSDP")
	public void verifyThatInternalCustomFieldsTileAppearOnCSDP() throws InterruptedException {
		try {
			// Navigate to the category page with timeout handling
			categoryPage.naviateToCategory();
		} catch (TimeoutException e) {
			System.out.println("TimeoutException occurred. Retrying navigation...");
			getDriver().navigate().refresh(); // Refresh and retry
			categoryPage.naviateToCategory();
		}

		categoryPage.clickOn(CreateCategoryButton);
		categoryCustomFieldName = "NewCat" + RandomStrings.requiredCharacters(3);
		csdp.sendKeysWithWait(NameField, categoryCustomFieldName);
		csdp.clickOn(internalCustomFieldAddFieldLink);
		csdp.sendKeysWithWait(LabelField, RandomStrings.requiredCharacters(5));
		csdp.clickByJsExecuter(CreateCategoryPopupBtn);

		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);

		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.waitForCurserRunning(3);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(3);

		String actualTileTxt = csdp.getTextElement(internalCustomFieldTileOnCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualTileTxt, "Internal Information", "Tile name does not match");
		st.assertAll();
	}

	@Test(priority = 37, enabled = true, description = "verify That External Custom Fields Tile Appear On CSDP")
	public void verifyThatCustomFieldsTileAppearOnCSDP() throws InterruptedException {
		categoryPage.naviateToCategory();
		categoryPage.waitForElementIsInteractable(CreateCategoryButton);
		categoryPage.clickOn(CreateCategoryButton);
		categoryCustomFieldName = "NewCat" + RandomStrings.requiredCharacters(3);
		csdp.sendKeysWithWait(NameField, categoryCustomFieldName);
		csdp.clickOn(addFieldCustomField);
		csdp.sendKeysWithWait(LabelField, RandomStrings.requiredCharacters(5));
		csdp.clickByJsExecuter(CreateCategoryPopupBtn);
		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);
		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.waitForCurserRunning(3);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(3);

		String atualTileTxt = csdp.getTextElement(internalCustomFieldTileOnCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(atualTileTxt, "Public Information", "Tile name doesnot match");
		st.assertAll();
	}

	@Test(priority = 38, enabled = true, description = "verify That External/Internal Custom Fields Tile Appear On CSDP")
	public void verifyThatInternalCustomAndEternalFieldsTileAppearOnCSDP() throws InterruptedException {
		categoryPage.naviateToCategory();
		categoryPage.clickOn(CreateCategoryButton);
		categoryCustomFieldName = "NewCat" + RandomStrings.requiredCharacters(3);
		csdp.sendKeysWithWait(NameField, categoryCustomFieldName);
		csdp.clickOn(addFieldCustomField);
		csdp.waitForElementIsInteractable(internalCustomFieldAddFieldLink);
		csdp.clickOn(internalCustomFieldAddFieldLink);
		csdp.sendKeysWithWait(LabelField, RandomStrings.requiredCharacters(5));
		csdp.sendKeysWithWait(labelField2, RandomStrings.requiredCharacters(5));
		csdp.clickByJsExecuter(CreateCategoryPopupBtn);
		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, categoryCustomFieldName);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);
		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.waitForCurserRunning(3);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(3);

		String actualTileTxt1 = csdp.getTextElement(customFieldTileOnCSDP);
		String actualTileTxt2 = csdp.getTextElement(internalCustom2FieldTileOnCSDP);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualTileTxt1, "Public Information", "Tile1 name doesnot match");
		st.assertEquals(actualTileTxt2, "Internal Information", "Tile2 name doesnot match");
		st.assertAll();
	}

	@Test(priority = 39, enabled = true, description = "verify That Change category popup opens up On CSDP")
	public void verifyThatChangeCategoryPopupOpensUpOnCSDP() throws InterruptedException {
		csdp.clickOn(categoryDropDownLabelCSDP);
		csdp.waitUntilElementIsVisible(dropDownListFistOptCSDP);
		csdp.clickOn(dropDownListFistOptCSDP);
		csdp.waitUntilElementIsVisible(changeCategoryPopupHeader);

		String actualHeaderTxt = csdp.getTextElement(changeCategoryPopupHeader);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualHeaderTxt, "Change Category", "Header doesnot match");
		st.assertAll();
	}

	@Test(priority = 40, enabled = true, description = "verify That validation message appears on Change Category popup opens up On CSDP")
	public void verifyThatValidationMessageApearONChangeCategoryPopupOpensUpOnCSDP() throws InterruptedException {
		try {
			// Click on the category dropdown
			csdp.forcedWaitTime(3);
			csdp.scrollIntoView(CancelButton);
			csdp.clickOn(CancelButton);
			csdp.forcedWaitTime(3);
			csdp.clickOn(categoryDropDownLabelCSDP);
			csdp.waitUntilElementIsVisible(dropDownListFistOptCSDP);
			csdp.scrollIntoView(By.xpath(csdp.selectorFormate(dropDownOption, "CascadingCategory")));
			csdp.clickOn(By.xpath(csdp.selectorFormate(dropDownOption, "CascadingCategory")));
			csdp.waitUntilElementIsVisible(changeCategoryPopupHeader);
			csdp.clickOn(SaveButton);

//            csdp.clickOn(categoryDropDownLabelCSDP);
//            csdp.waitUntilElementIsVisible(dropDownListFistOptCSDP);
//            csdp.forcedWaitTime(3);
//            csdp.scrollIntoView(By.xpath(csdp.selectorFormate(dropDownOption, "CascadingCategory")));
//            // Select the desired category from the dropdown
//            csdp.clickOn(By.xpath(csdp.selectorFormate(dropDownOption, "CascadingCategory")));
//            csdp.waitUntilElementIsVisible(changeCategoryPopupHeader);

            // Click the Save button
//            csdp.clickOn(SaveButton);

			// Validate the error message
			String validationText = "The CascadingField1 is required.";
			String actualText = csdp
					.getTextElement(By.xpath(csdp.selectorFormate(categoryValidationMessageCSP, validationText)));

			// Assertion for validation message
			SoftAssert st = new SoftAssert();
			st.assertEquals(actualText, validationText, "Validation text does not match");
			st.assertAll();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 41, enabled = true, description = "verify That user is able to change category on CSDP")
	public void verifyThatFollowingOptionsAppearOnChangeCategoryPopup() throws InterruptedException {
		csdp.sendKeysWithWait(cascadingFieldCategoryPopup, "color");

		String txt1 = csdp.getTextElement(By.xpath(csdp.selectorFormate(reassignmentsOptions, Integer.toString(1))));
		String txt2 = csdp.getTextElement(By.xpath(csdp.selectorFormate(reassignmentsOptions, Integer.toString(2))));
		String txt3 = csdp.getTextElement(By.xpath(csdp.selectorFormate(reassignmentsOptions, Integer.toString(3))));

		SoftAssert st = new SoftAssert();
		st.assertEquals(txt1, "Reassign submission based on new submission assignment rules (on submission received)",
				"txt1 text doesnot match");
		st.assertEquals(txt2, "Reassign submission based on category change assignment rules",
				"txt1 text doesnot match");
		st.assertEquals(txt3, "Do not reassign submission", "txt1 text doesnot match");

		st.assertAll();

	}

	@Test(priority = 42, enabled = true, description = "verify That user is able to change category on CSDP")
	public void verifyThaUserIsAbleToChangeCategoryOnCSDP() throws InterruptedException {
		csdp.clickOn(SaveButton);
		csdp.waitForCurserRunning(3);
		csdp.waitUntilElementIsVisible(categoryDropDownLabelCSDP);
		String actualLabelTxt = csdp.getTextElement(categoryDropDownLabelCSDP);
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualLabelTxt, "CascadingCategory", "category name text doesnot match");
		st.assertAll();
	}

	@Test(priority = 43, enabled = true, description = "verify That user is able to change category on CSDP")
	public void verifyThatSubmissionHasBeenCreadtedWithTheCategory() throws InterruptedException {
		csdp.cascadingAssignmentRule();
		crmCommonMethods.navigationToCSP();
		csdp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		csdp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		csdp.sendKeysWithWait(CSPInternalUtility.SearchCategory, "CascadingCategory");
		csdp.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
		csdp.clickOn(CSPInternalUtility.SearchResultsCategory);
		csdp.sendKeysWithWait(enterTextCategory1CSP, "color1");
		csdp.sendKeysWithWait(breedTextCustomField, "blackColor");
		String RandomDescription = RandomStrings.requiredString(20);
		csdp.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);
		csdp.scrollIntoView(createSubmissionButton);
		csdp.clickOn(createSubmissionButton);
		csdp.waitForCurserRunning(6);
		csdp.forcedWaitTime(6);
		csdp.waitUntilElementIsVisible(SubmissionCollaborator);
		csdp.waitForElementIsInteractable(SubmissionCollaborator);
		csdp.forcedWaitTime(6);
		String actualCollabratorName = csdp.getTextElement(SubmissionCollaborator);

		SoftAssert st = new SoftAssert();
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		st.assertAll();
	}

	@Test(priority = 44, enabled = true, description = "")
	public void verifyThatAssigneeNameShouldAppear() throws InterruptedException {
		csdp.waitForElementIsInteractable(SubmissionAssingee);
		String assigneeName = csdp.getTextElement(SubmissionAssingee);
		SoftAssert st = new SoftAssert();
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(assigneeName, "Mark Shane", "assignee  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(assigneeName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"assignee  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(assigneeName, "Shane ES", "assignee  name text doesnot match");
		}
		st.assertAll();
	}

	@Test(priority = 45, enabled = true, description = "")
	public void verifyThatChangeCategoryByDefaultOptions() throws InterruptedException {
		csdp.clickOn(categoryDropDownLabelCSDP);
		csdp.waitUntilElementIsVisible(dropDownListFistOptCSDP);
		csdp.scrollIntoView(By.xpath(csdp.selectorFormate(dropDownOption, "Other")));
		csdp.clickOn(By.xpath(csdp.selectorFormate(dropDownOption, "Other")));

		SoftAssert st = new SoftAssert();
		st.assertTrue(csdp.elementIsChecked(radioButton));
		st.assertAll();

    }

	@Test(priority = 46, enabled = true, description = "")
	public void verifyThatChangeinCategoryAndCollabratorAndAssigneNameChanged() throws InterruptedException {
		csdp.clickOn(SaveButton);
		csdp.waitForCurserRunning(3);
		csdp.waitUntilElementIsVisible(categoryDropDownLabelCSDP);
		csdp.forcedWaitTime(3);

		String assigneeName = csdp.getTextElement(SubmissionAssingee);
		String actualCollabratorName = csdp.getTextElement(SubmissionCollaborator);
		SoftAssert st = new SoftAssert();
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(assigneeName, "Mark Shane", "assignee  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(assigneeName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"assignee  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(assigneeName, "Shane ES", "assignee  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(actualCollabratorName, PropertiesUtils.getPropertyValue("crmCustomerName"),
					"collabrator  name text doesnot match");
		}
		st.assertAll();

	}

}


