package POM;

import BrowsersBase.BrowsersInvoked;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class CSPInternalUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;
	CECommonMethods ceCommonMethods ;

	public CSPInternalUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
		ceCommonMethods = new CECommonMethods(driver);

	}

	public static By paymentListingRow = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]");
	public static By outstandingBal = By.xpath(
			"//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span");
	public static By printBtn = By.xpath("//button[text()='Print']");
	public static By Cases = By.xpath("//a[normalize-space()='Cases']");
	public static By mapContainer = By.xpath("(//div[@class='map-container']//div)[1]");
	public static By automationComcate = By.xpath("//div[contains(text(),'automationcomcate')]");
	public static By chngeLogo = By.xpath("//label[text()='Change Logo']");
	public static By submissionBtn = By.cssSelector("div.actions button.btn-primary");
	public static By optionBlack = By.xpath("//div[@class='option-black']");
	public static By dropdownSearchField = By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']");
	public static By drpDownLabelCategory = By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']");
	public static By autoWhatever = By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']");
	public static By listLabel = By.xpath("(//div[@class='list-label']//b)[1]");
	public static By file = By.xpath("//input[@type='file']");
	public static By unflagAddress = By.xpath("//button[text()='Unflag address']");
	public static By reasonForFlagging = By.xpath("//textarea[@name='reasonForFlagging']");
	public static By textCheck = By.xpath("//button[text()='Text Message']");
	public static By emailCheck = By.xpath("//button[contains(text(),'Email')]");
	public static By textMsg = By.xpath("//button[@class='square-btn preference-selected-button btn btn-primary'][text()='Text Message']");
	public static By emailBtn = By.xpath("//button[@class='square-btn preference-selected-button btn btn-primary'][text()='Email']");
	public static String plusIconToCRM = "//*[@class='app-header__new']";
	public static String customerSubmissionOption = "//label[text()='Customer Submission']";
	public static String cancelCreateCase = "//h1[text()='Create A Case']//parent::div//button[text()='Cancel']";
	public static String cSPPopupTitle = "//div[@class='full-page-modal__header']/h1";
	public static String createSubmissionButton = "//button[text()='Create Submission']";
	public static String globalErrorMessageCSP = "//div[@class='create-submission__global-error']/h2";
	public static String postAnonymouslyCheckbox = "//label[text()='Post anonymously']";
	public static String addExistingCustomerField = "//label[@class='contact-tile__searchbox-label']/following::input[1]";
	public static String nameField = "//input[@name='name']";
	public static String emailField = "//input[@name='email']";
	public static String workPhoneField = "//input[@name='workPhone']";
	public static String cellPhoneField = "//input[@name='phoneNumber']";
	public static String selectedAnonymousToggle = "//div[@class='post-anonymous-section']//button[@class='square-btn btn btn-primary']";
	public static String yesToggleAnonymous = "//div[@class='post-anonymous-section']//button[2]";
	public static String saveChangesButton = "//button[text()='Save Changes']";
	// public static String contactSearchResults =
	// "(//div[@class='react-autosuggest__suggestion-element']/div)[1]";
	public static String contactSearchResults = "(//div[@class='react-autosuggest__suggestion-element']/div//b)";
	public static String categoryDropdown = "//div[@class='dropdown__selector__selected']/label";
	public static String searchCategory = "//input[@name='query']";
	public static String selectedCategory = "//label[@for='selectedCategory']/following::label[1]";
	public static String searchResultsCategory = "//ul[@class='dropdown__options--single']//li//b";
	public static String locationValidationMsg = "//div[@class='tile--error-msg']";
	public static String locationField = "//div[@class='location-tile__inputs-container']//input";
	public static String locationSearchResult = "//li[@id='react-autowhatever-1-section-0-item-0']";

	public static String EditLocation = "//div[@class='edit-address__header']/button";
	public static String issueDescriptionField = "//textarea[@name='issueDescription']";
	public static String tagsField = "//div[@class='tags-input__chips']/input";
	public static String attachmentIcon = "//div[text()='Attachments ']/following::button";
	public static String cameraButton = "//span[text()='Camera']";
	public static String addButton = "//button[text()='Add']";
	public static String imageThumb = "//img[@class='attachments-tile__saved-thumb']";
	public static String submisionStatus = "//h2[@class='customer-submission-details__status']";
	public static String closeSubmissionIcon = "//div[@class='customer-submission-details__close-icon']/img";
	public static String cancelButton = "//*[text()='Cancel']";
	public static String toggleChecked = "//div[@class='react-toggle react-toggle--checked bs-toggle danger']";
	public static String flagToggle = "(//div[@class='react-toggle-thumb'])[1]";
	public static String postAnonymouslyCheckboxbtn = "//input[@name='isAnonymous'][@type='checkbox']";

	public static By PostAnonymouslyCheckboxbtn = By.xpath(postAnonymouslyCheckboxbtn);
	public static By PlusIconToCRM = By.xpath(plusIconToCRM);
	public static By CancelCreateCase = By.xpath(cancelCreateCase);
	public static By CustomerSubmissionOption = By.xpath(customerSubmissionOption);
	public static By CSPPopupTitle = By.xpath(cSPPopupTitle);
	public static By CreateSubmissionButton = By.xpath(createSubmissionButton);
	public static By GlobalErrorMessageCSP = By.xpath(globalErrorMessageCSP);
	public static By PostAnonymouslyCheckbox = By.xpath(postAnonymouslyCheckbox);
	public static By AddExistingCustomerField = By.xpath(addExistingCustomerField);
	public static By NameField = By.xpath(nameField);
	public static By EmailField = By.xpath(emailField);
	public static By WorkPhoneField = By.xpath(workPhoneField);
	public static By CellPhoneField = By.xpath(cellPhoneField);
	public static By SelectedAnonymousToggle = By.xpath(selectedAnonymousToggle);
	public static By YesToggleAnonymous = By.xpath(yesToggleAnonymous);
	public static By SaveChangesButton = By.xpath(saveChangesButton);
	public static By ContactSearchResults = By.xpath(contactSearchResults);
	public static By CategoryDropdown = By.xpath(categoryDropdown);
	public static By SearchCategory = By.xpath(searchCategory);
	public static By SelectedCategory = By.xpath(selectedCategory);
	public static By SearchResultsCategory = By.xpath(searchResultsCategory);
	public static By LocationValidationMsg = By.xpath(locationValidationMsg);
	public static By LocationSearchResult = By.xpath(locationSearchResult);
	public static By ToggleChecked = By.xpath(toggleChecked);
	public static By FlagToggle = By.xpath(flagToggle);
	public static By LocationField = By.xpath(locationField);
	public static By IssueDescriptionField = By.xpath(issueDescriptionField);
	public static By TagsField = By.xpath(tagsField);
	public static By AttachmentIcon = By.xpath(attachmentIcon);
	public static By CameraButton = By.xpath(cameraButton);
	public static By AddButton = By.xpath(addButton);
	public static By ImageThumb = By.xpath(imageThumb);
	public static By SubmisionStatus = By.xpath(submisionStatus);
	public static By CloseSubmissionIcon = By.xpath(closeSubmissionIcon);
	public static By CancelButton = By.xpath(cancelButton);
	public static By mapView = By.xpath("(//div[@class='map-container map-container--hide-layer-control']//div)[1]");

	public static String SelectedToggleForAnonymous;
	public static String SelectedToggleNow;
	public static String ErrMessageActual;
	public static String ErrMessageExpected;
	public static String CSPTitleActual;
	public static String CSPTitleExpected;
	public static boolean PostAnonymouslyState;
	public static boolean ContactsTileState;
	public static String EmailValue;
	public static String ActualCategorySel;
	public static String ActualCategorySel2;
	public static String LocValidMsg;
	public static boolean LocationPresence;
	public static boolean CheckImgSize;
	public static String StatusOfSubmission;

	public static String createdCategory1 = "Location Required";
	public static String createdCategory2 = "Location Not Included";
	public static String createdCategory3 = "Location Not Required";
	
	
	public static By cascadingField1= By.xpath("//label[@title='CascadingField1']/../../div[@class='field__input row']/input");
	

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void CSPInternal_Prerequisites() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to(BrowsersInvoked.URLSubmissionSettings);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(SelectedAnonymousToggle);
		String SelectedToggleForAnonymous = getTextElement(SelectedAnonymousToggle);
		if (SelectedToggleForAnonymous.equals("No")) {
			waitUntilElementIsVisible(YesToggleAnonymous);
			waitForElementIsInteractable(YesToggleAnonymous);
			clickByJsExecuter(YesToggleAnonymous);
			waitForElementIsInteractable(SaveChangesButton);
			clickByJsExecuter(SaveChangesButton);
			waitForCurserRunning(5);

		}
		waitUntilElementIsVisible(SelectedAnonymousToggle);
		SelectedToggleNow = getTextElement(SelectedAnonymousToggle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(SelectedToggleNow.equals("Yes"));
		softAssert.assertAll();
	}

	public void CSPInternal_VerifyAllThreeCategoriesCreation() throws InterruptedException {
		crmCommonMethod.createCategory("Yes", "Yes", "No", createdCategory1);
		crmCommonMethod.createCategory("No", "No", "No", createdCategory2);
		crmCommonMethod.createCategory("Yes", "Yes", "No", createdCategory3);
	}

	public void CSPInternal_VerifyCSPOpensUp() throws InterruptedException {
		waitUntilElementIsVisible(PlusIconToCRM);
		waitForElementIsInteractable(PlusIconToCRM);
		clickByJsExecuter(PlusIconToCRM);
		waitUntilElementIsVisible(CustomerSubmissionOption);
		waitForElementIsInteractable(CustomerSubmissionOption);
		clickByJsExecuter(CustomerSubmissionOption);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(CSPPopupTitle);
		waitUntilElementPresent(CSPPopupTitle);
		CSPTitleActual = getTextElement(CSPPopupTitle);
		CSPTitleExpected = "Create Customer Submission";
		waitUntilElementIsVisible(CreateSubmissionButton);
		waitForElementIsInteractable(CreateSubmissionButton);
		clickByJsExecuter(CreateSubmissionButton);
		ErrMessageActual = getTextElement(GlobalErrorMessageCSP);
		ErrMessageExpected = "Please complete all fields marked in red below to continue.";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CSPTitleActual.equals(CSPTitleExpected));
		softAssert.assertTrue(ErrMessageActual.equals(ErrMessageExpected));
		softAssert.assertAll();
	}

	public void CSPInternal_VerifyPostAnonymouslycheckbox() throws InterruptedException {
		waitUntilElementIsVisible(PostAnonymouslyCheckbox);
		WebElement PostAnonymously = findElement(PostAnonymouslyCheckbox);
		PostAnonymouslyState = PostAnonymously.isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PostAnonymouslyState);
		softAssert.assertAll();
	}

	public void CSPInternal_VerifyCustomerInformationTile() throws InterruptedException {
		// Thread.sleep(3000);
		waitForElementIsInteractable(PostAnonymouslyCheckboxbtn);
		clickByJsExecuter(PostAnonymouslyCheckboxbtn);
		waitUntilElementIsVisible(NameField);
		WebElement ContactsTile = findElement(NameField);
		ContactsTileState = ContactsTile.isEnabled();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(ContactsTileState);
		softAssert.assertAll();
	}

	public void CSPInternal_AddExistingCustomer() throws InterruptedException {
		refreshPage();
		waitUntilElementIsVisible(AddExistingCustomerField);
		waitForElementIsInteractable(AddExistingCustomerField);
		sendKeysWithWait(AddExistingCustomerField, "a");
		Thread.sleep(3000);
		waitUntilElementIsVisible(ContactSearchResults);
		waitForElementIsInteractable(ContactSearchResults);
		clickByJsExecuter(ContactSearchResults);
		waitUntilElementIsVisible(EmailField);
		EmailValue = driver.findElement(EmailField).getAttribute("value");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(EmailValue.equals(null));
		softAssert.assertAll();
	}

	public void CSPInternal_VerifyCategoriesList() throws InterruptedException {
		CSPInternal_VerifyAllThreeCategoriesCreation();
		createdCategory1 = "Location Required";
		driver.navigate().to(BrowsersInvoked.URLCreateCustomerSubmission);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CategoryDropdown);
		scrollIntoView(CategoryDropdown);
		waitForElementIsInteractable(CategoryDropdown);
		clickByJsExecuter(CategoryDropdown);
		waitUntilElementIsVisible(SearchCategory);
		sendKeysWithWait(SearchCategory, createdCategory1);
		forcedWaitTime(2);
		waitUntilElementIsVisible(SearchResultsCategory);
		waitForElementIsInteractable(SearchResultsCategory);
		clickByJsExecuter(SearchResultsCategory);
		waitUntilElementIsVisible(SelectedCategory);
		ActualCategorySel = getTextElement(SelectedCategory);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ActualCategorySel.equals(createdCategory1));
		softAssert.assertAll();
	}

	public void CSPInternal_SearchAndAddCategory() throws InterruptedException {
		waitUntilElementIsVisible(CategoryDropdown);
		waitUntilElementPresent(CategoryDropdown);
		waitForElementIsInteractable(CategoryDropdown);
		clickByJsExecuter(CategoryDropdown);
		waitUntilElementIsVisible(SearchCategory);
		waitUntilElementPresent(SearchCategory);
		sendKeysWithWait(SearchCategory, createdCategory1);
		waitUntilElementIsVisible(SearchResultsCategory);
		waitForElementIsInteractable(SearchResultsCategory);
		clickByJsExecuter(SearchResultsCategory);
		waitUntilElementIsVisible(SelectedCategory);
		ActualCategorySel2 = getTextElement(SelectedCategory);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ActualCategorySel2.equals(createdCategory1));
		softAssert.assertAll();
	}

	public void CSPInternal_LocationRequiredValCategory() throws InterruptedException {
		waitUntilElementIsVisible(CreateSubmissionButton);
		waitForElementIsInteractable(CreateSubmissionButton);
		clickByJsExecuter(CreateSubmissionButton);
		waitUntilElementIsVisible(LocationValidationMsg);
		waitUntilElementIsVisible(LocationValidationMsg);
		scrollIntoView(LocationValidationMsg);
		LocValidMsg = getTextElement(LocationValidationMsg);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(LocValidMsg.equals("The location is required."));
		softAssert.assertAll();
	}

	public void CSPInternal_AddLocation() throws InterruptedException {
		clickByJsExecuter(CategoryDropdown);
		waitUntilElementIsVisible(SearchCategory);
		sendKeysWithWait(SearchCategory, "Location Not Required");
		waitUntilElementIsVisible(SearchResultsCategory);
		clickOn(SearchResultsCategory);
		waitUntilElementIsVisible(LocationField);
		sendKeysWithWait(LocationField, "Texas ");
		waitUntilElementIsVisible(LocationSearchResult);
		sendKeysWithWait(LocationField, "City Museum");
		waitUntilElementIsVisible(LocationSearchResult);
		waitForElementIsInteractable(LocationSearchResult);
		clickOn(LocationSearchResult);
		waitForCurserRunning(5);
	}

	public void CSPInternal_CategoryWithLocationIncluded() throws InterruptedException {
		createdCategory2 = "Location Not Included";
		scrollIntoView(CategoryDropdown);
		forcedWaitTime(2);
		clickByJsExecuter(CategoryDropdown);
		sendKeysWithWait(SearchCategory, createdCategory2);
		waitForElementIsInteractable(SearchResultsCategory);
		clickOn(SearchResultsCategory);
		forcedWaitTime(2);
		JavascriptExecutor jser = (JavascriptExecutor) driver;
		jser.executeScript("window.scrollBy(0,550)", "");
		waitUntilElementIsVisible(LocationField);
		List<WebElement> LocationTile = driver.findElements(LocationField);
		LocationPresence = (LocationTile.size() == 0);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(LocationPresence);
		softAssert.assertAll();
	}

	public void CSPInternal_VerifyIssueDescription() throws InterruptedException {
		String RandomDescription = RandomStrings.requiredString(20);
		sendKeysWithWait(IssueDescriptionField, RandomDescription);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void CSPInternal_AddMultipleTags() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			String RandomTags = RandomStrings.requiredString(4);
			sendKeysWithWait(TagsField, RandomTags + ",");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void CSPInternal_AddAttachments() throws InterruptedException {
		clickByJsExecuter(AttachmentIcon);
		ceCommonMethods.uploadAttachment(ceCommonMethods.SetTestDataFilePath("Cat_11zon.jpg"));
		waitForCurserRunning(2);
		waitForElementIsInteractable(AddButton);
		clickOn(AddButton);
		waitUntilElementIsVisible(ImageThumb);
		List<WebElement> CountAttachments = driver.findElements(ImageThumb);
		int ImgSize = CountAttachments.size();
		CheckImgSize = ImgSize >= 1;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CheckImgSize);
		softAssert.assertAll();
	}

	public void CSPInternal_VerifySubmissionCreation() throws InterruptedException {
		waitUntilElementIsVisible(CreateSubmissionButton);
		forcedWaitTime(2);
		scrolltoPageTop();
		forcedWaitTime(2);
		try {
			scrollIntoView(CreateSubmissionButton);
			waitForElementIsInteractable(CreateSubmissionButton);
			clickOn(CreateSubmissionButton);
		} catch (Exception e) {
			e.getMessage();
			scrollIntoView(CreateSubmissionButton);
			waitForElementIsInteractable(CreateSubmissionButton);
			clickByJsExecuter(CreateSubmissionButton);
			waitForCurserRunning(8);
		}

		if (findElementsSize(CreateSubmissionButton) > 0) {
			clickByJsExecuter(CreateSubmissionButton);

		}
		waitForCurserRunning(10);
		Thread.sleep(3000);
		waitUntilElementIsVisible(SubmisionStatus);
		StatusOfSubmission = getTextElement(SubmisionStatus);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(StatusOfSubmission.contains("Open"));
		softAssert.assertAll();
	}

	public void CSPInternal_SubmissionDoesNotGetCreatedOnCancel() throws InterruptedException {
		waitUntilElementIsVisible(CloseSubmissionIcon);
		waitForElementIsInteractable(CloseSubmissionIcon);
		Thread.sleep(3000);
		clickOn(CloseSubmissionIcon);
		waitUntilElementIsInvisible(CloseSubmissionIcon);
		waitUntilElementIsVisible(PlusIconToCRM);
		waitForElementIsInteractable(PlusIconToCRM);
		clickByJsExecuter(PlusIconToCRM);
		waitForElementIsInteractable(CustomerSubmissionOption);
		clickByJsExecuter(CustomerSubmissionOption);
		waitForCurserRunning(3);
		scrollIntoView(CancelButton);
		waitForElementIsInteractable(CancelButton);
		clickByJsExecuter(CancelButton);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

}
