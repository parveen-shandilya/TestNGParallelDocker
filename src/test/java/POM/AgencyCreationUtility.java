package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;

import org.openqa.selenium.WebElement;

import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;

public class AgencyCreationUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public AgencyCreationUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
	}

	public static By cssHamburger = By.cssSelector("div.app-header__menu__icon");
	public static By agencySetupIcon = By.xpath("(//*[@class='tools-dropdown__tool flex-column--center']/a)[1]");
	public static By hamburger = By.xpath("//*[@class='app-header__menu__icon']");
	public static By agencyName = By.xpath("(//*[@class='agency-info__summary flex-column--left']/h2)[1]");
	public static By map = By.xpath("(//div[@class='map-container']//div)[1]");
	public static By CreateAgencyButton = By.xpath("//button[text()='Create Agency']");
	public static By FinesTracking = By.xpath("//span[contains(text(),'Fines Tracking')]");
	public static By FineTrackingLbl = By.xpath("//label[contains(text(),'Fines Tracking:')]//span");
	public static By AgencyNameField = By.xpath("//input[@name='name']");
	public static By StreetAddressField = By.xpath("//input[@name='streetAddress']");
	public static By CityField = By.xpath("//input[@name='city']");
	public static By StateDropdownField = By.xpath("//label[text()='Select Option']");
	public static By ZipField = By.xpath("//input[@name='zip']");
	public static By TimezoneDropdownField = By.xpath("//div[@class='Select-placeholder']");
	public static By EmailField = By.xpath("//input[@name='email']");
	public static By WebsiteURLField = By.xpath("//input[@name='websiteURL']");
	public static By SendFromEmailField = By.xpath("//input[@name='sendFromEmail']");
	public static By SendFromTextMessageToggle = By.xpath("(//div[@class='react-toggle-thumb'])[2]");
	public static By CodeEnforcementLinkText = By.xpath("//div[text()='Code Enforcement']");
	public static By CRMLinkText = By.xpath("//div[text()='CRM']");
	public static By ProductNameField = By.xpath("//div[@class='product-form__info']//input");
	public static By WaterVioToggle = By.xpath("//span[text()='General']");
	public static By AnimalVioToggle = By.xpath("//span[text()='Animal']");
	public static By AddCodeEnforcementButton = By.xpath("//button[text()='Add Code Enforcement']");
	public static By CRMProductNameField = By.xpath("//div[@class='product-form__info crm']//input");
	public static By AddCRMButton = By.xpath("//button[text()='Add CRM']");
	public static By CreateAgencyButton2 = By.xpath("//h1[text()='Create Agency']/following::button[2]");
	public static By CreateAgencyPopup = By.xpath("//h1[text()='Create Agency']");
	public static By ValidationMsg = By.xpath("//span[@class='field__error']");
	public static By PlusIconOnHeader = By.xpath("//div[@class='app-header__new']");
	public static By CCPOption = By.xpath("//label[text()='Code Enforcement Case']");
	public static By CSPOption = By.xpath("//label[text()='Customer submission']");
	public static By AddAndConfigureCEPopup = By.xpath("//div[text()='Add & Configure Code Enforcement']");
	public static By ValidationProdName = By.xpath("//div[@class='product-form__info']//span");
	public static By AddAndConfigureCRMPopup = By.xpath("//div[text()='Add & Configure CRM']");
	public static By ValidationProdNameCRM = By.xpath("//div[@class='product-form__info crm']//span");
	public static By ProductNameFieldCRM = By.xpath("//div[@class='product-form__info crm']//input");
	public static By BackToUrLCitizenView = By.xpath("//input[@name='citizenPortalHomeLinkURL']");
	public static By StateSearchField = By.xpath("//input[@name='query']");
	public static By SearchedStateOption = By.xpath("//ul[@class='dropdown__options--single']//span");
	public static By PSTOption = By.xpath("//*[text()='PST']");
	public static By SendFromTextMessageField = By.xpath("//input[@name='sendFromPhoneNumber']");
	public static By AgencySearchField = By.xpath("//input[@placeholder='Search by keyword']");
	public static By AddedCEProduct = By.xpath("//div[@class='agency-form__product-header-title']/h4[1]");
	public static By AddedCRMProduct = By.xpath("(//div[@class='agency-form__product-header-title']/h4[1])[2]");
	public static By NewAgencyCreated = By.xpath("//div[@class='rt-tr -odd']/div[2]");
	public static By refershButton_lntxt = By.cssSelector("a.agencies-listing__refresh");
	public static By allAgencyFilter_btn = By.cssSelector("div.agencies-listing__filter button:nth-child(1)");
	public static By activeAgencyFilter_btn = By.cssSelector("div.agencies-listing__filter button:nth-child(2)");
	public static By inactiveAgencyFilter_btn = By.cssSelector("div.agencies-listing__filter button:nth-child(3)");
	public static By agencyCount = By.cssSelector("div.table__pagination-summary label:nth-child(1)");
	public static By cdbg_lnktxt = By.cssSelector("a[href*='cdbg']");
	public static By cdbgfile = By.cssSelector("div.cdbg__file-upload label b");
	public static By replaceCDBGfile = By.cssSelector("label.cdbg__file-label[for='file-upload']");
	public static By agencyTestTrue = By.xpath("//button[text()='True']");
	public static By deleteAgencybtn = By.xpath("//button[@class='delete-btn  btn btn-primary']");
	public static By deleteAgencypopUpBtn = By.xpath("//button[text()='Delete Agency']");
	public static By doNotDeleteAgencypopupBtn = By.xpath("//button[text()='Do Not Delete']");
	public static By deleteTextField = By.xpath("//input[@name='deleteText']");
	public static By NoAgencyData = By.xpath("//div[@class='rt-noData']");
	public static By editAgency = By.xpath("//button[@class='edit-btn agencies-listing__agency-action-edit btn btn-primary']");

	public static By integrationOnlinePayments = By.xpath("//div[@class='agency-form__product-listing'][text()='Online Payments']");
	public static By paymentGatWay = By.xpath("//label[@title='Payment Gateway']//parent::div//following-sibling::div//span[@class='Select-arrow']");
	public static By selectPaymentGatWay = By.xpath("(//div[@class='Select-menu-outer']//div)[1]");
	public static By apiIDText = By.xpath("//input[@name='apiKeyId']");
	public static By paymentKey = By.xpath("//input[@name='apiKeySecret']");
	public static By paymentTransactionAmt = By.xpath("//input[@name='transactionFeeValue']");
	public static By minimumPaymentAmount = By.xpath("//input[@name='minimumPaymentAmount']");
	public static By citizenPortalOn = By.xpath("//button[text()='On']");
	public static By addIntegration = By.xpath("//button[text()='Add Integration']");
	public static By onlinePaymentActive = By.xpath("//h4[text()='Online Payments']//following-sibling::h4[text()='Active']");
	public static By paymentPortalActive = By.xpath("//h4[text()='Payment Portal']//following-sibling::h4[text()='Active']");
	public static By agencyConfigDirect = By.xpath("//button[text()='GIS Enterprise: Direct']");
	public static By gisDirectURL = By.xpath("//input[@name='gisDirectURL']");
	public static By saveESRIURL = By.xpath("//button[text()='Save']");
	public static By gisActivation20 = By.xpath("(//span[text()='GIS Activation'])[2]");
	public static By gisHosted20 = By.xpath("(//span[text()='GIS Hosted'])[2]");
	public static By animalViolation = By.xpath("//span[@class='toggle__children'][text()='Animal']");



	public static String CloseCaseText;
	public static String CCPopupText;
	public static String ClosedStatus;
	public static String CreateAgencyPopupTitle;
	public static String AddAndConfigureCEPopupTitle;
	public static String ValidationMSgProdName;
	public static String ValidationMSgCharLimit;
	public static String AddedCETitle;
	public static String AddAndConfigureCRMPopupTitle;
	public static String ValidationMSgProdNameCRM;
	public static String AddedCRMTitle;
	public static String ValidationMSgCharLimitCRM;
	public static String RandomAgencyName;
	public static String NewAgencyTitle;
	public static String FineTrackingStatus;
	public static boolean FineToggle;
	public static List<WebElement> modalCount;
	public static WebElement VoluntaryBtnState;
	public static WebElement ForcedBtnState;
	public static WebElement Case;
	public static List<WebElement> InvalidBtnList;
	public static WebElement ConfirmationIcon;
	public static List<WebElement> ConfirmationValid;

	public void LoginAdmin() throws InterruptedException {
		log.LoginAdmin();

	}

	public void agencyCreation_OpenCreateAgencyPopup() throws InterruptedException {
		waitUntilElementIsVisible(CreateAgencyButton);
		waitForElementIsInteractable(CreateAgencyButton);
		WebElement element = driver.findElement(CreateAgencyButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		waitUntilElementIsVisible(CreateAgencyPopup);
		CreateAgencyPopupTitle = getTextElement(CreateAgencyPopup);
		waitForElementIsInteractable(CreateAgencyButton2);
		clickByJsExecuter(CreateAgencyButton2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CreateAgencyPopupTitle, CRMConstants.CREATE_AGECNY);
		softAssert.assertAll();

	}

	public void agencyCreation_ConfigureCE() throws InterruptedException {
		waitUntilElementIsVisible(CodeEnforcementLinkText);
		waitForElementIsInteractable(CodeEnforcementLinkText);
		scrollIntoView(CodeEnforcementLinkText);
		clickOn(CodeEnforcementLinkText);
		waitUntilElementIsVisible(AddAndConfigureCEPopup);
		AddAndConfigureCEPopupTitle = getTextElement(AddAndConfigureCEPopup);
		waitUntilElementIsVisible(AddCodeEnforcementButton);
		waitForElementIsInteractable(AddCodeEnforcementButton);
		clickOn(AddCodeEnforcementButton);
		ValidationMSgProdName = getTextElement(ValidationProdName);

		String Char20Plus = RandomStrings.requiredCharacters(21);
		sendKeysWithWait(ProductNameField, Char20Plus);
		clickOn(AddCodeEnforcementButton);
		ValidationMSgCharLimit = getTextElement(ValidationProdName);

		waitUntilElementIsVisible(ProductNameField);
		waitForElementIsInteractable(ProductNameField);
		clearElement(ProductNameField);
		waitForElementIsInteractable(ProductNameField);
		sendKeysWithWait(ProductNameField, "CE");
		waitUntilElementIsVisible(animalViolation);
		waitForElementIsInteractable(WaterVioToggle);
		clickOn(WaterVioToggle);
		waitForElementIsInteractable(AnimalVioToggle);
		clickOn(AnimalVioToggle);
		waitUntilElementIsVisible(FinesTracking);
		waitForElementIsInteractable(FinesTracking);
		clickByJsExecuter(FinesTracking);
		waitForElementIsInteractable(AddCodeEnforcementButton);
		clickOn(AddCodeEnforcementButton);
		waitUntilElementIsVisible(AddedCEProduct);
		AddedCETitle = getTextElement(AddedCEProduct);
		waitUntilElementIsVisible(FineTrackingLbl);
		FineTrackingStatus = getTextElement(FineTrackingLbl);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddAndConfigureCEPopupTitle, CRMConstants.ADD_CE_CONFIGURATION);
		softAssert.assertEquals(ValidationMSgProdName, CRMConstants.PRODUCT_NAME_NOTEMPTY);
		softAssert.assertEquals(ValidationMSgCharLimit, CRMConstants.PRODUCT_NAME_LIMIT20);
		softAssert.assertEquals(AddedCETitle, CRMConstants.CE_NAME);
		softAssert.assertEquals(FineTrackingStatus, CRMConstants.FINE_TRACKING_STATUS);
		softAssert.assertAll();

	}

	public void agencyCreation_ConfigureCRM() throws InterruptedException {
		waitUntilElementIsVisible(FineTrackingLbl);
		waitForElementIsInteractable(FineTrackingLbl);
		clickOn(CRMLinkText);
		waitUntilElementIsVisible(AddAndConfigureCRMPopup);
		AddAndConfigureCRMPopupTitle = getTextElement(AddAndConfigureCRMPopup);
		waitUntilElementIsVisible(AddCRMButton);
		waitForElementIsInteractable(AddCRMButton);
		clickOn(AddCRMButton);
		waitUntilElementIsVisible(ValidationProdNameCRM);
		ValidationMSgProdNameCRM = getTextElement(ValidationProdNameCRM);
		String Char50Plus = RandomStrings.requiredCharacters(51);
		waitForElementIsInteractable(ProductNameFieldCRM);
		sendKeysWithWait(ProductNameFieldCRM, Char50Plus);
		waitForElementIsInteractable(AddCRMButton);
		clickOn(AddCRMButton);
		waitUntilElementIsVisible(ValidationProdNameCRM);
		ValidationMSgCharLimitCRM = getTextElement(ValidationProdNameCRM);
		waitUntilElementIsVisible(ProductNameFieldCRM);
		waitForElementIsInteractable(ProductNameFieldCRM);
		WebElement ProdNameFieldCRM = findElement(ProductNameFieldCRM);
		ProdNameFieldCRM.clear();
		waitForElementIsInteractable(ProductNameFieldCRM);
		sendKeysWithWait(ProductNameFieldCRM, CRMConstants.CRM_NAME);
		waitForElementIsInteractable(BackToUrLCitizenView);
		clearElement(BackToUrLCitizenView);
		waitForElementIsInteractable(BackToUrLCitizenView);
		sendKeysWithWait(BackToUrLCitizenView, "https://app-stage.comcate.com/agencies/181/setup");
		waitForElementIsInteractable(AddCRMButton);
		clickOn(AddCRMButton);
		waitUntilElementIsVisible(AddedCRMProduct);
		AddedCRMTitle = getTextElement(AddedCRMProduct);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AddAndConfigureCRMPopupTitle, CRMConstants.ADD_CRM_CONFIGURATION);
		softAssert.assertEquals(ValidationMSgProdNameCRM, CRMConstants.PRODUCT_NAME_NOTEMPTY);
		softAssert.assertEquals(ValidationMSgCharLimitCRM, CRMConstants.PRODUCT_NAME_LIMIT50);
		softAssert.assertEquals(AddedCRMTitle, CRMConstants.CRM_NAME);
		softAssert.assertAll();
	}

	public void agencyCreation_VerifyNewAgencyCreation() throws InterruptedException {

		// Add Agency Name
		
		String agencyConfig = PropertiesUtils.getPropertyValue("agencyConfig");
			
		switch(agencyConfig) {
		
		case "Enterprise":
			RandomAgencyName = "Auto_Enterprise" + RandomStrings.requiredCharacters(8);
			break;
		case "GisDirect2o":
			RandomAgencyName = "Auto_GISDirect20" + RandomStrings.requiredCharacters(8);
			break;
		case "EnterpriseHosted20":
			RandomAgencyName = "Auto_Hosted20" + RandomStrings.requiredCharacters(8);
			break;	
		default:
			System.out.println("NA");
		}
		
		waitUntilElementIsVisible(AgencyNameField);
		waitForElementIsInteractable(AgencyNameField);
		forcedWaitTime(3);
		sendKeysWithWait(AgencyNameField, RandomAgencyName);

		// Add Street Address and City Address
		waitForElementIsInteractable(StreetAddressField);
		sendKeysWithWait(StreetAddressField, PropertiesUtils.getPropertyValue("StreetAddress"));
		waitForElementIsInteractable(CityField);
		sendKeysWithWait(CityField, PropertiesUtils.getPropertyValue("CityField"));

		// search and select State Address
		waitForElementIsInteractable(StateDropdownField);
		clickOn(StateDropdownField);
		waitForElementIsInteractable(StateSearchField);
		sendKeysWithWait(StateSearchField, PropertiesUtils.getPropertyValue("state"));
		waitForElementIsInteractable(SearchedStateOption);
		clickOn(SearchedStateOption);

		// Add Zip Address
		waitForElementIsInteractable(ZipField);
		sendKeysWithWait(ZipField, PropertiesUtils.getPropertyValue("Zip"));

		// Select Agency  Time Zone
		waitForElementIsInteractable(TimezoneDropdownField);
		clickOn(TimezoneDropdownField);
		waitForElementIsInteractable(PSTOption);
		clickOn(PSTOption);



		// Add Email Contact Address
		waitForElementIsInteractable(EmailField);
		sendKeysWithWait(EmailField, PropertiesUtils.getPropertyValue("EmailID"));


		// Add  website mail address
		waitForElementIsInteractable(WebsiteURLField);
		sendKeysWithWait(WebsiteURLField, PropertiesUtils.getPropertyValue("websiteURL"));

		// choose Agency Configuration
		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			waitForElementIsInteractable(agencyConfigDirect);
			clickOn(agencyConfigDirect);
			waitForPresenceandVisiblity(gisDirectURL);
			waitForElementIsInteractable(gisDirectURL);
			if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
				String esriURL = PropertiesUtils.getPropertyValue("ESRIurl_CI");
				sendKeysWithWait(gisDirectURL, esriURL);
			}
			else {
			String esriURL = PropertiesUtils.getPropertyValue("ESRIurl");
			sendKeysWithWait(gisDirectURL, esriURL);
			}
			waitForElementIsInteractable(saveESRIURL);
			clickOn(saveESRIURL);

		}

		// add send from email address
		forcedWaitTime(1);
		waitForPresenceandVisiblity(SendFromEmailField);
		waitForElementIsInteractable(SendFromEmailField);
		sendKeysWithWait(SendFromEmailField, PropertiesUtils.getPropertyValue("teamComcate"));

		// select send from text message toggle
		clickByJsExecuter(By.xpath("(//div[@class='react-toggle-thumb'])[3]"));
		waitForElementIsInteractable(SendFromTextMessageField);
		sendKeysWithWait(SendFromTextMessageField, "4142864141");

		// set agency as Testing Agency true
		waitForElementIsInteractable(agencyTestTrue);
		clickByJsExecuter(agencyTestTrue);

		// Click on Create Agency Button
		waitForElementIsInteractable(CreateAgencyButton2);
		scrollIntoView(CreateAgencyButton2);
		waitForElementIsInteractable(CreateAgencyButton2);
		clickByJsExecuter(CreateAgencyButton2);


		// Wait and Search for the Create Agency
		waitUntilElementInvisibleLocated(CreateAgencyButton2);
		waitUntilElementInvisibleLocated(CreateAgencyButton2);
		waitUntilElementIsVisible(AgencySearchField);
		forcedWaitTime(4);
		sendKeysWithWait(AgencySearchField, RandomAgencyName);
		forcedWaitTime(1);
        WaitForGridTableEnable();
		// Get Agency Name
		waitUntilElementIsVisible(By.xpath(ReportCRMUtility.AgencyNameGrid(RandomAgencyName)));
		NewAgencyTitle = getTextElement(NewAgencyCreated);

		// Check Delete Agency Cross icon is present
		boolean deleteBtn = elementIsDisplayed(deleteAgencybtn);

		// Assertion
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(NewAgencyTitle, RandomAgencyName);
		softAssert.assertTrue(deleteBtn, PropertiesUtils.getPropertyValue("deleteIcon"));
		softAssert.assertAll();

	}

	public int allAgencyCount;
	public int activeAgencyCount;
	public int inactiveAgencyCount;
	public int TotalAgencyCount;
	public boolean agencyCountMatched;

	public void verifyActiveInactiveAgencyCount() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(4);
		waitUntilElementIsVisible(allAgencyFilter_btn);
		waitUntilElementIsVisible(agencyCount);
		waitUntilElementIsVisible(NewAgencyCreated);
		allAgencyCount = Integer.parseInt(getTextElement(agencyCount).split(" ")[0]);
		clickByJsExecuter(activeAgencyFilter_btn);
		waitForCurserRunning(2);
		waitUntilElementPresent(activeAgencyFilter_btn);
		waitForElementIsInteractable(inactiveAgencyFilter_btn);
		waitUntilElementPresent(NewAgencyCreated);
		forcedWaitTime(8);
		activeAgencyCount = Integer.parseInt(getTextElement(agencyCount).split(" ")[0]);
		clickByJsExecuter(inactiveAgencyFilter_btn);
		waitForCurserRunning(2);
		waitUntilElementPresent(inactiveAgencyFilter_btn);
		waitForElementIsInteractable(activeAgencyFilter_btn);
		waitUntilElementIsVisible(NewAgencyCreated);
		forcedWaitTime(8);
		inactiveAgencyCount = Integer.parseInt(getTextElement(agencyCount).split(" ")[0]);
		TotalAgencyCount = activeAgencyCount + inactiveAgencyCount;
		agencyCountMatched = TotalAgencyCount == allAgencyCount;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(agencyCountMatched, true);
		softAssert.assertAll();

	}

	public void clickOnEditAgencyIcon() throws InterruptedException {
		waitForElementIsInteractable(editAgency);
		clickOn(editAgency);
		waitForCurserRunning(5);
	}

	public void agencyCreation_setPaymentPortal( ) throws InterruptedException {
		waitForElementIsInteractable(editAgency);
		clickOn(editAgency);
		waitForCurserRunning(5);
		waitForElementIsInteractable(ReportCRMUtility.SaveEditAgency);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(ReportCRMUtility.CRMSectionEditIcon);
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		element = driver.findElement(integrationOnlinePayments);
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		clickOn(integrationOnlinePayments);
		waitForElementIsInteractable(paymentGatWay);
		clickOn(paymentGatWay);
		waitForElementIsInteractable(selectPaymentGatWay);
		clickOn(selectPaymentGatWay);
		String paymentApiID = PropertiesUtils.getPropertyValue("paymentAPIID");
		String paymentApiKey = PropertiesUtils.getPropertyValue("paymentAPIKey");

		sendKeysWithWait(apiIDText,paymentApiID);

		sendKeysWithWait(paymentKey, paymentApiKey);
		sendKeysWithWait(paymentTransactionAmt, "10");
		sendKeysWithWait(minimumPaymentAmount, "10");

		clickOn(citizenPortalOn);

		clickOn(addIntegration);
		waitForCurserRunning(4);
		boolean onlinePayment = elementIsDisplayed(onlinePaymentActive);
		boolean onlinePaymentPortal = elementIsDisplayed(paymentPortalActive);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(onlinePayment, true);
		softAssert.assertEquals(onlinePaymentPortal, true);
		softAssert.assertAll();

		waitForElementIsInteractable(ReportCRMUtility.SaveEditAgency);
		clickOn(ReportCRMUtility.SaveEditAgency);
		waitUntilElementInvisibleLocated(ReportCRMUtility.SaveEditAgency);
		waitUntilElementInvisibleLocated(ReportCRMUtility.SaveEditAgency);
		waitForCurserRunning(5);


	}




	public boolean cdbgFileDiplayed;
	public boolean replacecdbgFileDiplayed;

	public void verifyCDBGfileandReplaceButton() throws InterruptedException {
		waitUntilElementIsVisible(cdbg_lnktxt);
		clickByJsExecuter(cdbg_lnktxt);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(cdbgfile);
		cdbgFileDiplayed = elementIsDisplayed(cdbgfile);
		replacecdbgFileDiplayed = elementIsDisplayed(replaceCDBGfile);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(cdbgFileDiplayed, true);
		softAssert.assertEquals(replacecdbgFileDiplayed, true);
		softAssert.assertAll();
	}

	public AppPreRequisiteUtility returnDriver() {
		return new AppPreRequisiteUtility(driver);

	}

	public void deleteCreatedAgency() throws InterruptedException {

		driver.get(BrowsersInvoked.AdminURL);
		waitForCurserRunning(8);
		agencyCreation_OpenCreateAgencyPopup();
		agencyCreation_ConfigureCE();
		agencyCreation_ConfigureCRM();
		agencyCreation_VerifyNewAgencyCreation();
		waitForElementIsInteractable(deleteAgencybtn);
		clickByJsExecuter(deleteAgencybtn);
		waitForCurserRunning(6);
		waitForPresenceandVisiblity(deleteAgencypopUpBtn);
		waitForPresenceandVisiblity(doNotDeleteAgencypopupBtn);
		boolean deleteAgencyBtn = elementIsDisplayed(deleteAgencypopUpBtn);
		boolean doNotAgencyBtn = elementIsDisplayed(doNotDeleteAgencypopupBtn);
		sendKeysWithWait(deleteTextField, "DELETE");
		clickByJsExecuter(deleteAgencypopUpBtn);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(AgencySearchField);
		forcedWaitTime(2);
		clearByJSE(AgencySearchField);
		forcedWaitTime(2);
		sendKeysWithWait(AgencySearchField, RandomAgencyName);
		waitUntilElementIsVisible(NoAgencyData);


		String actualText = getTextElement(NoAgencyData);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(deleteAgencyBtn, true);
		softAssert.assertEquals(doNotAgencyBtn, true);
		softAssert.assertEquals(actualText, PropertiesUtils.getPropertyValue("noAgencyMsg"));
		softAssert.assertAll();
	}

	public void clickOn2Odirecttoggle () throws InterruptedException {
		waitForElementIsInteractable(gisActivation20);
		clickOn(gisActivation20);
		forcedWaitTime(2);
	}
	
	public void clickonHosted20toggel() throws InterruptedException {	
		waitForElementIsInteractable(gisHosted20);
		clickOn(gisHosted20);
		forcedWaitTime(2);
	}

	public void clickOnSaveAgencyButton() throws InterruptedException {
		waitForElementIsInteractable(ReportCRMUtility.SaveEditAgency);
		clickOn(ReportCRMUtility.SaveEditAgency);
		waitUntilElementInvisibleLocated(ReportCRMUtility.SaveEditAgency);
		waitUntilElementInvisibleLocated(ReportCRMUtility.SaveEditAgency);
		waitForCurserRunning(5);
		closeOtherTabs();
		forcedWaitTime(2);
	}
}
