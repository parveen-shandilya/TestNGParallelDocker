package POM;

import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import TestCases.CSPInternalGISDirect20;
import org.openqa.selenium.By;
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

import static POM.ForcedAbatementUtility.RunEnvironment;

public class CSPExternalUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public CSPExternalUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	public static String reportAnIssuePage = "//nav[@class='crm-submission__navigation-bar']/h1";
	public static String issueDescriptionField = "//textarea[@name='description']";
	public static String validationMsgDescription = "//span[@class='field__error']";
	public static String nextButton = "(//button[text()='Next'])[1]";
	public static String nextButtonSec2 = "(//button[text()='Next'])[2]";
	public static String nextButtonSec3 = "(//button[text()='Next'])[3]";
	public static String selectedCategory = "//div[@class='chip__wrapper active clickable']";
	public static String otherCategories = "//div[@class='category-list-section']//div";
	public static String showMoreLinktext = "//a[@class='show-more']";
	public static String showMoreOnlyLinktext = "//a[@class='show-more' and text()='More']";
	public static String submissionUpdatesCheckbox = "//input[@name='hasSubscribed']";
	public static String noButton = "//button[text()='No']";
	public static String yesButton = "//button[text()='Yes']";
	public static String firstNameField = "//input[@name='firstName']";
	public static String lastNameField = "//input[@name='lastName']";
	public static String emailField = "//input[@name='email']";
	public static String emailPreferenceButton = "//button[text()='Email']";
	public static String otherField = "//input[@name='notificationNote']";
	public static String backButton = "//button[text()='Back']";
	public static String submitButton = "//button[text()='Submit']";
	public static String firstNameValidation = "//input[@name='firstName']/following::span[1]";
	public static String lastNameValidation = "//input[@name='firstName']/following::span[2]";
	public static String successMessage = "//section[@class='crm__success-message-section']//h5";
	public static String agencySearchField = "//span[@class='agencies-listing__search']/input";
	public static String editAgencyIcon = "//div[@class='agencies-listing__agency-actions']/button[3]";
	public static String cSPExternalURL = "//div[@class='agency-form__product-config']/a";
	public static String categoryExpandedSection = "//div[@class='crm-location-section']";
	public static String issueDescriptionTitle = "//h2[text()='Issue Description']";
	public static String attachmentThumbnail = "//img[@class='photos-tile__saved-thumb']";
	public static String deleteIconAttachment = "//img[@class='delete-button']";
	public static String locationSection = "//h2[text()='Location']";
	public static String locationSearchField = "//input[@type='text']";
	public static String changeLocationValue = "//button[contains(text(),'Change')]";
	public static String locationValidationMsg = "//div[@class='crm-location-field error']/following::span";
	// public static String locationSearchResult = "//div[@class='list-label']";
	public static String locationSearchResult = "//div[@class='list-label']";

	public static String selectCategoryTitle = "//h2[text()='Select Category']";
	public static String changeLocButton = "//button[text()='Change']";
	public static String submitSubmissionPage = "//div[@class='crm__anonymous-toggle col']/h5";
	// public static String emailValidationMsg = "//span[text()='Enter the
	// details.']";
	public static String emailValidationMsg = "//*[@name='email']/../../span";
	public static By attachmentThumbnail2 = By.xpath("(//img[@class='photos-tile__saved-thumb'])[2]");
	// public static By attachmentThumbnail2 =
	// By.xpath("(//img[@class='photos-tile__saved-thumb'])[2]");

	public static By ReportAnIssuePage = By.xpath(reportAnIssuePage);
	public static By IssueDescriptionField = By.xpath(issueDescriptionField);
	public static By ValidationMsgDescription = By.xpath(validationMsgDescription);
	public static By NextButton = By.xpath(nextButton);
	public static By NextButtonSec2 = By.xpath(nextButtonSec2);
	public static By NextButtonSec3 = By.xpath(nextButtonSec3);
	public static By SelectedCategory = By.xpath(selectedCategory);
	public static By OtherCategories = By.xpath(otherCategories);
	public static By ShowMoreLinktext = By.xpath(showMoreLinktext);
	public static By ShowMoreOnlyLinktext = By.xpath(showMoreOnlyLinktext);

	public static By SubmissionUpdatesCheckbox = By.xpath(submissionUpdatesCheckbox);
	public static By NoButton = By.xpath(noButton);
	public static By YesButton = By.xpath(yesButton);
	public static By FirstNameField = By.xpath(firstNameField);
	public static By LastNameField = By.xpath(lastNameField);
	public static By EmailField = By.xpath(emailField);
	public static By EmailPreferenceButton = By.xpath(emailPreferenceButton);
	public static By OtherField = By.xpath(otherField);
	public static By BackButton = By.xpath(backButton);
	public static By SubmitButton = By.xpath(submitButton);
	public static By FirstNameValidation = By.xpath(firstNameValidation);
	public static By LastNameValidation = By.xpath(lastNameValidation);
	public static By SuccessMessage = By.xpath(successMessage);
	public static By AgencySearchField = By.xpath(agencySearchField);
	public static By EditAgencyIcon = By.xpath(editAgencyIcon);
	public static By CSPExternalURL = By.xpath(cSPExternalURL);
	public static By CategoryExpandedSection = By.xpath(categoryExpandedSection);
	public static By IssueDescriptionTitle = By.xpath(issueDescriptionTitle);
	public static By AttachmentThumbnail = By.xpath(attachmentThumbnail);
	public static By DeleteIconAttachment = By.xpath(deleteIconAttachment);
	public static By LocationSection = By.xpath(locationSection);
	public static By LocationSearchField = By.xpath(locationSearchField);
	public static By ChangeLoactionValue = By.xpath(changeLocationValue);
	public static By LocationValidationMsg = By.xpath(locationValidationMsg);
	public static By LocationSearchResult = By.xpath(locationSearchResult);
	public static By SelectCategoryTitle = By.xpath(selectCategoryTitle);
	public static By ChangeLocButton = By.xpath(changeLocButton);
	public static By SubmitSubmissionPage = By.xpath(submitSubmissionPage);
	public static By EmailValidationMsg = By.xpath(emailValidationMsg);
	public static By TextMsgPreferenceButton = By.xpath("//button[text()='Text Message']");
	public static By MobileNumberField = By.xpath("//input[@name='phoneNumber']");
	public static By CategoriesTab = By.xpath(CategoryPage.categoriesTab);
	public static String locationSearchSuggestion = "//ul[@role='listbox']//li[@role='option']//b[text()='%s']";

	public static String RASPageTitle;
	public static String TabTitle;
	public static String DescriptionValidation;
	public static String ExpectedDescriptionMsg;
	public static String Validation2000;
	public static String Expected2000Msg;
	public static boolean CategorySectionState;
	public static int CountAttachments;
	public static int CountAttachmentsAfter;
	public static String CategorySelected;
	public static boolean CountAllCategories;
	public static boolean NoLocationSection;
	public static String PageTitleSubmitSubmission;
	public static String ExpectedTitleSubmitSubmission;
	public static String ValidationMsgLocation;
	public static String ExpectedMsgLoc;
	public static String SubmitPageTitle;
	public static String ValidMsgFirstName;
	public static String ExpectedMsgName1;
	public static String ValidMsgLastName;
	public static String ExpectedMsgName2;
	public static String LimitMsgFirstName;
	public static String LimitMsgLastName;
	public static String CharLimitValidation;
	public static String EmailValidationMessage;
	public static String ExpectedEmailMsg;
	public static String InvalidMailMsg;
	public static String ExpectedInvalidMsg;
	public static String SubmissionSuccessMsg;
	public static String ExpectedSuccessMsg;
	public static String SubmissionSuccessMsgNA;
	public static Boolean categoryContains = false;
	public static String CategoryValidation;
	public static String ExpectedCAtegoryvalidMsg;

	public static String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
	public static String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public static String AgencyNameGrid(String name) {
		String xPath = "//div[text()='" + name + "']";
		return xPath;
	}

	public void CSPExternal_PreRequisite_OpenReportAnIssuePage() throws InterruptedException {
		closeOtherTabs();
		driver.navigate().to(BrowsersInvoked.AdminURL);
		waitForCurserRunning(5);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int lginCheck = driver.findElements(By.xpath("//input[@placeholder='Enter Email'][@name='email']")).size();
		if (lginCheck > 0) {
			log.LoginAdmin();
			waitUntilElementIsVisible(AgencySearchField);
		}
		String AgencyID = Integer.toString(BrowsersInvoked.AgencyID);
		System.out.println("AgencyID : "+AgencyID);
		waitUntilElementIsVisible(AgencySearchField);
		scrollIntoView(AgencySearchField);
		waitForElementIsInteractable(AgencySearchField);
		sendKeysWithWait(AgencySearchField, AgencyID);
		waitUntilElementIsVisible(By.xpath(AgencyNameGrid(AgencyID)));
		waitForElementIsInteractable(EditAgencyIcon);
		clickByJsExecuter(EditAgencyIcon);
		waitUntilElementIsVisible(CSPExternalURL);
		waitForElementIsInteractable(CSPExternalURL);
		scrollIntoView(CSPExternalURL);
		clickByJsExecuter(CSPExternalURL);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window((String) tabs.get(1));
		waitUntilElementIsVisible(ReportAnIssuePage);
		RASPageTitle = getTextElement(ReportAnIssuePage);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(RASPageTitle, "Report an issue");
		softAssert.assertAll();
	}

	public void CSPExternal_PreRequisite_OpenReportAnIssuePageNOLogin() throws InterruptedException {
		closeOtherTabs();
		implicitWaitforCustometime(3);
		refreshPage();
		waitForCurserRunning(4);
		String AgencyID = Integer.toString(BrowsersInvoked.AgencyID);
		waitUntilElementIsVisible(AgencySearchField);
		scrollIntoView(AgencySearchField);
		waitForElementIsInteractable(AgencySearchField);
		sendKeysWithWait(AgencySearchField, AgencyID);
		waitUntilElementIsVisible(By.xpath(AgencyNameGrid(AgencyID)));
		clickOn(EditAgencyIcon);
		waitUntilElementIsVisible(CSPExternalURL);
		waitForElementIsInteractable(CSPExternalURL);
		clickOn(CSPExternalURL);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window((String) tabs.get(1));
		waitUntilElementIsVisible(ReportAnIssuePage);
		RASPageTitle = getTextElement(ReportAnIssuePage);
	}

	public void CSPExternal_VerifyIssueDescription() throws InterruptedException {
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		waitUntilElementIsVisible(By.xpath("//h2[@class='h2-dropdown']"));
		crmMethods.clickOnIssueDescriptionNextButton();
		waitUntilElementIsVisible(ValidationMsgDescription);
		waitUntilElementPresent(ValidationMsgDescription);
		scrollIntoView(ValidationMsgDescription);
		DescriptionValidation = getTextElement(ValidationMsgDescription);
		CategoryValidation = getTextElement(By.xpath("//h2[@class='error-h2']"));
		ExpectedDescriptionMsg = "The Issue description is required.";
		ExpectedCAtegoryvalidMsg = "The Category is required.";
		waitUntilElementIsVisible(By.xpath("//div[contains(text(),'Select One')]"));
		clickByJsExecuter(By.xpath("//div[contains(text(),'Select One')]"));
		waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
		sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"), "Other");
		waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
		clickOn(By.xpath("//div[@class='option-black']"));

		String description = PropertiesUtils.getPropertyValue("Description2001");
		forcedWaitTime(2);
		sendKeysWithWait(IssueDescriptionField, description);
		forcedWaitTime(4);
		crmMethods.clickOnIssueDescriptionNextButton();
		waitUntilElementIsVisible(ValidationMsgDescription);
		Validation2000 = getTextElement(ValidationMsgDescription);
		Expected2000Msg = "2000 character limit.";
		WebElement DescriptionField = waitUntilVisibleWE(IssueDescriptionField);
		DescriptionField.clear();
		String RandomDescription = RandomStrings.requiredString(50);
		sendKeysWithWait(IssueDescriptionField, RandomDescription);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(DescriptionValidation, ExpectedDescriptionMsg);
		softAssert.assertEquals(Validation2000, Expected2000Msg);
		softAssert.assertEquals(CategoryValidation, ExpectedCAtegoryvalidMsg);
		softAssert.assertAll();


	}

	public void CSPExternal_VerifyAddedAttachments() throws InterruptedException {

		CECommonMethods ceMethods = new CECommonMethods(driver);

		ceMethods.uploadAttachment(ceMethods.SetTestDataFilePath("Panda_11zon.jpg"));
		waitForCurserRunning(5);
		ceMethods.uploadAttachment(ceMethods.SetTestDataFilePath("Jellyfish_11zon.jpg"));
		
		waitUntilElementIsVisible(AttachmentThumbnail);
		waitUntilElementPresent(AttachmentThumbnail);
		forcedWaitTime(2);
		List<WebElement> AttachmentCountBefore = driver.findElements(AttachmentThumbnail);
		CountAttachments = AttachmentCountBefore.size();
		clickOn(DeleteIconAttachment);
		waitUntilElementInvisibleLocated(attachmentThumbnail2);
		forcedWaitTime(4);
		List<WebElement> AttachmentCountAfter = driver.findElements(AttachmentThumbnail);
		CountAttachmentsAfter = AttachmentCountAfter.size();
		Assert.assertEquals(CountAttachments, 2, "Attachment Count is not equal to 2.");
		Assert.assertEquals(CountAttachmentsAfter, 1, "Attachment Count is not equal to 1.");
	}

	public void CSPExternal_VerifyCorrespondingCategoryToKeyword() throws InterruptedException {
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		scrollIntoView(IssueDescriptionField);
		waitForElementIsInteractable(IssueDescriptionField);
		findElement(IssueDescriptionField).clear();
		waitForElementIsInteractable(IssueDescriptionField);
		sendKeysWithWait(IssueDescriptionField, "Location Not Included");
		crmMethods.clickOnIssueDescriptionNextButton();
		CategorySelected = getTextElement(SelectedCategory);
		List<WebElement> ShowMoreLink = driver.findElements(ShowMoreLinktext);
		List<String> CategoriesText = new ArrayList<String>();

		if (ShowMoreLink.size() == 1) {
			clickOn(ShowMoreLinktext);
			List<WebElement> CountCategories = driver.findElements(OtherCategories);

			driver.findElements(OtherCategories).stream().forEach(x -> CategoriesText.add(x.getText()));

			CountAllCategories = CountCategories.size() > 0;
			categoryContains = CategoriesText.contains("Location Not Included");
		} else {

			List<WebElement> CountCategories = driver.findElements(OtherCategories);
			driver.findElements(OtherCategories).stream().forEach(x -> CategoriesText.add(x.getText()));
			CountAllCategories = CountCategories.size() > 0;
			categoryContains = CategoriesText.contains("Location Not Included");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(categoryContains);
		softAssert.assertTrue(CountAllCategories);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyNoLocationSection() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		scrolltoPageTop();
		scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		clickByJsExecuter(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
		sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"),
				"Location Not Included");
		waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
		Thread.sleep(3000);
		clickByJsExecuter(By.xpath("//div[@class='option-black'][contains(text(),'Location Not Included')]"));
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		crmMethods.clickOnIssueDescriptionNextButton();
		List<WebElement> LocationSec = driver.findElements(LocationSection);
		NoLocationSection = LocationSec.size() == 0;
		PageTitleSubmitSubmission = getTextElement(SubmitSubmissionPage);
		ExpectedTitleSubmitSubmission = "Stay Updated on the Progress of your Submission";
		crmMethods.clickOnBackButtonCRMExternal();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(NoLocationSection, "Location Section is present");
		softAssert.assertEquals(PageTitleSubmitSubmission, ExpectedTitleSubmitSubmission, "Page Tile is not matched.");
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyRequiredLocationSection() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		clickOn(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
		sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"),
				"Location Required");
		waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
		clickOn(By.xpath("//div[@class='option-black'][contains(text(),'Location Required')]"));
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		crmMethods.clickOnIssueDescriptionNextButton();
		crmMethods.clickOnLocationNextButton();
		waitUntilElementIsVisible(LocationValidationMsg);
		ValidationMsgLocation = getTextElement(LocationValidationMsg);
		ExpectedMsgLoc = "The location is required.";
		waitUntilElementIsVisible(LocationSearchField);
		waitUntilElementPresent(LocationSearchField);
		clickByJsExecuter(LocationSearchField);
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			crmMethods.searchLocationExternalCS("1851 HILLPOINT");
		}
		else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20))
		{

				crmMethods.searchLocationExternalCS(POM.CSPInternalGISDirect20Utility.ExtractedSearchLocationHosted20);

		} else {
			crmMethods.searchLocationExternalCS("720 14th Avenue North, Texas City, TX 77590");
		}

		if (findElementsSize(CSPInternalUtility.ToggleChecked) > 0) {
			clickOn(CSPInternalUtility.FlagToggle);
			clickOn(CSPInternalUtility.FlagToggle);

		}

		crmMethods.clickOnLocationNextButton();
		waitUntilElementIsVisible(SubmitSubmissionPage);
		SubmitPageTitle = getTextElement(SubmitSubmissionPage);
		crmMethods.clickOnBackButtonCRMExternal();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ValidationMsgLocation, ExpectedMsgLoc);
		softAssert.assertEquals(SubmitPageTitle, ExpectedTitleSubmitSubmission);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyNonMandatoryLocationSection() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//h2[text()='Issue Description']"));
		scrollIntoView(By.xpath("//h2[text()='Issue Description']"));
		clickByJsExecuter(By.xpath("//h2[text()='Issue Description']"));
		waitUntilElementIsVisible(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		clickOn(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
		sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"),
				"Location Not Required");
		waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
		clickOn(By.xpath("//div[@class='option-black'][contains(text(),'Location Not Required')]"));
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		crmMethods.clickOnIssueDescriptionNextButton();
//	  comment due to change in functionality  ... 	
//		waitForElementIsInteractable(ChangeLocButton);
//		clickByJsExecuter(ChangeLocButton);

		crmMethods.clickOnLocationNextButton();
		waitUntilElementIsVisible(SubmitSubmissionPage);
		waitUntilElementPresent(SubmitSubmissionPage);
		SubmitPageTitle = getTextElement(SubmitSubmissionPage);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubmitPageTitle, ExpectedTitleSubmitSubmission);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyMandatoryFieldsForNonAnonymous() throws InterruptedException {

		waitUntilElementIsVisible(SubmitButton);
		scrollIntoView(SubmitButton);
		waitForElementIsInteractable(SubmitButton);
		clickByJsExecuter(SubmitButton);
		waitUntilElementIsVisible(FirstNameValidation);
		scrollIntoView(FirstNameValidation);
		ValidMsgFirstName = getTextElement(FirstNameValidation);
		ExpectedMsgName1 = "The First Name is required.";
		scrollIntoView(LastNameValidation);
		ValidMsgLastName = getTextElement(LastNameValidation);
		ExpectedMsgName2 = "The Last Name is required.";
		String Text21Chars = RandomStrings.requiredCharacters(21);
		sendKeysWithWait(FirstNameField, Text21Chars);
		waitUntilVisibleWE(FirstNameField).clear();
		sendKeysWithWait(LastNameField, Text21Chars);
		waitUntilVisibleWE(LastNameField).clear();
		waitUntilElementIsVisible(SubmitButton);
		scrollIntoView(SubmitButton);
		waitForElementIsInteractable(SubmitButton);
		clickByJsExecuter(SubmitButton);
		waitUntilElementIsVisible(FirstNameValidation);
		scrollIntoView(FirstNameValidation);
		LimitMsgFirstName = getTextElement(FirstNameValidation);
		LimitMsgLastName = getTextElement(LastNameValidation);
		CharLimitValidation = "20 character limit.";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ValidMsgFirstName, ExpectedMsgName1);
		softAssert.assertEquals(ValidMsgLastName, ExpectedMsgName2);
		softAssert.assertEquals(LimitMsgFirstName, CharLimitValidation);
		softAssert.assertEquals(LimitMsgLastName, CharLimitValidation);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyEmailFieldPreference() throws InterruptedException {
		waitUntilElementIsVisible(EmailPreferenceButton);
		waitUntilElementPresent(EmailPreferenceButton);
		scrollIntoView(EmailPreferenceButton);
		waitForElementIsInteractable(EmailPreferenceButton);
		clickByJsExecuter(EmailPreferenceButton);
		waitForElementIsInteractable(EmailPreferenceButton);
		waitUntilElementIsVisible(SubmitButton);
		scrollIntoView(SubmitButton);
		waitForElementIsInteractable(SubmitButton);
		clickByJsExecuter(SubmitButton);
		EmailValidationMessage = getTextElement(EmailValidationMsg);
		ExpectedEmailMsg = "Enter the details.";
		String InvalidMail = "invalid@mail";
		waitForElementIsInteractable(EmailField);
		sendKeysWithWait(EmailField, InvalidMail);
		waitUntilElementIsVisible(SubmitButton);
		scrollIntoView(SubmitButton);
		waitForElementIsInteractable(SubmitButton);
		clickByJsExecuter(SubmitButton);
		waitUntilElementIsVisible(EmailValidationMsg);
		InvalidMailMsg = getTextElement(EmailValidationMsg);
		ExpectedInvalidMsg = "Email format is invalid.";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(EmailValidationMessage, ExpectedEmailMsg);
		softAssert.assertEquals(InvalidMailMsg, ExpectedInvalidMsg);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyAnonymousSubmission() throws InterruptedException {
		waitUntilElementIsVisible(YesButton);
		waitForElementIsInteractable(YesButton);
		forcedWaitTime(3);
		scrollTillPageEnd();
		scrollIntoView(YesButton);
		waitForElementIsInteractable(YesButton);
		clickByJsExecuter(YesButton);
		waitUntilElementIsVisible(SubmitButton);
		scrollIntoView(SubmitButton);
		waitForElementIsInteractable(SubmitButton);
		clickByJsExecuter(SubmitButton);
		waitUntilElementIsVisible(SuccessMessage);
		SubmissionSuccessMsg = getTextElement(SuccessMessage);
		ExpectedSuccessMsg = "Issue submitted successfully";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubmissionSuccessMsg, ExpectedSuccessMsg);
		softAssert.assertAll();
	}

	public void CSPExternal_VerifyNonAnonymousSubmission() throws InterruptedException, AWTException {

		ExpectedSuccessMsg = "Issue submitted successfully";
		refreshPage();
		waitForCurserRunning(7);
		driver.navigate().to(BrowsersInvoked.AdminURL);
		waitForCurserRunning(5);
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		crmMethods.createExternalSubmission("Yes", "Location Not Required", "No", "Yes");
		waitUntilElementIsVisible(SuccessMessage);
		scrollIntoView(SuccessMessage);
		waitUntilElementPresent(SuccessMessage);
		int successmessage = findElementsByXPath(SuccessMessage).size();
		while (successmessage == 0) {
			successmessage = findElementsByXPath(SuccessMessage).size();
		}
		SubmissionSuccessMsgNA = driver.findElement(By.xpath(successMessage)).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubmissionSuccessMsgNA, ExpectedSuccessMsg);
		softAssert.assertAll();
	}

	public void CSPExternal_CreateExternalSubmissionLocationNotRequired() throws InterruptedException, AWTException {

		ExpectedSuccessMsg = "Issue submitted successfully";
		refreshPage();
		waitForCurserRunning(7);
		driver.navigate().to(BrowsersInvoked.AdminURL);
		waitForCurserRunning(5);
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		crmMethods.createExternalSubmission("Yes", "Location Not Required", "No", "Yes");
		waitUntilElementIsVisible(SuccessMessage);
		scrollIntoView(SuccessMessage);
		waitUntilElementPresent(SuccessMessage);
		int successmessage = findElementsByXPath(SuccessMessage).size();
		while (successmessage == 0) {
			successmessage = findElementsByXPath(SuccessMessage).size();
		}
		SubmissionSuccessMsgNA = driver.findElement(By.xpath(successMessage)).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubmissionSuccessMsgNA, ExpectedSuccessMsg);
		softAssert.assertAll();

	}

	public void CSPExternal_CreateExternalSubmissionWithPinaLocation() throws InterruptedException {
		CRMCommonMethods crmMethods = new CRMCommonMethods(driver);
		closeOtherTabs();
		ExpectedSuccessMsg = "Issue submitted successfully";
		refreshPage();
		waitForCurserRunning(7);
		driver.navigate().to(BrowsersInvoked.AdminURL);
		waitForCurserRunning(5);
		String CategoryNname = "Required " + RandomStrings.requiredString(6);
		String keyWords = RandomStrings.requiredString(12);
		AppPreRequisiteUtility appPreReq = new AppPreRequisiteUtility(driver);
		appPreReq.AgencySetup_VerifyAppConfigurations(Integer.toString(BrowsersInvoked.AgencyID));
		crmMethods.navigateToAgencySetup();
		Thread.sleep(3000);
		driver.navigate().to(BrowsersInvoked.URLCategories);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CategoriesTab);
		waitUntilElementPresent(CategoriesTab);
		TabTitle = getTextElement(CategoriesTab);
		crmMethods.createCategoryCustomKeyWord("No", "Yes", "Yes", CategoryNname, keyWords);
		crmMethods.customExternalSubmissionPinLocation(keyWords, "Yes", CategoryNname, "No", "Yes");
		waitUntilElementIsVisible(SuccessMessage);
		scrollIntoView(SuccessMessage);
		waitUntilElementPresent(SuccessMessage);
		int successmessage = findElementsByXPath(SuccessMessage).size();
		while (successmessage == 0) {
			successmessage = findElementsByXPath(SuccessMessage).size();
		}
		SubmissionSuccessMsgNA = driver.findElement(By.xpath(successMessage)).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubmissionSuccessMsgNA, ExpectedSuccessMsg);
		softAssert.assertAll();
	}

}
