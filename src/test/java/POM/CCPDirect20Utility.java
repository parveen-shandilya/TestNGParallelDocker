package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

import static POM.CCPUtility.agencyConfig;

public class CCPDirect20Utility extends Helper {
	public WebDriver driver;
	CECommonMethods CECommonMethodS;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;

	public CCPDirect20Utility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		CECommonMethodS = new CECommonMethods(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
	}

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public static String zoomInMapLocation = "//a[@title='Zoom in'][@role='button']";
	public static String gisDataAddressSection = "//label[text()='GIS Validated Addresses']";
	public static String comcateApplicationSection = "//label[text()='Comcate Application Addresses']";
	public static String aPNAddressSection = "//label[text()='APN']";
	public static String gisDataAddress = "//li[@id='react-autowhatever-1-section-0-item-0']";
	public static String comcateAddresses = "(//label[text()='Comcate Application Addresses']//parent::div//following-sibling::ul//li//div[@class='list-label'])[1]";
	public static String apnAddrresses = "(//label[text()='APN']//parent::div//following-sibling::ul//li//div[@class='list-label'])[1]";
	public static String secUnitNumber = "(//label[@class='field__label-data-field'])[2]";
	public static String secUnitExclamMark = "//div[@data-for='secUnitTip']";
	public static String editGisLocationAddress = "//div[@class='edit-address__actions']//button[@class='edit-btn  btn btn-primary']";
	public static String editGisValidationButton = "//div[@class='edit-address__actions']//button[contains(text(),'GIS Validated')]";
	public static String editvalidatAddressButton = "//div[@class='edit-address__actions']//button[contains(text(),'Validate Address')]";
	public static String editAddressTile = "//div[@class='edit-address__header']//h1";
	public static String secUnitText = "//input[@name='secUnitNum']";
	public static String editSaveAddress = "//div[@class='edit-address__header']//button[text()='Save']";
	public static String addPlusSecUnit = "//div[@class='manual-secondary-address-suggestion']//div[contains(text(),'+ Add Secondary')]";

	public static By ZoomInMapLocation = By.xpath(zoomInMapLocation);
	public static By EditGisValidationButton = By.xpath(editGisValidationButton);
	public static By EditvalidatAddressButton = By.xpath(editvalidatAddressButton);
	public static By AddPlusSecUnit = By.xpath(addPlusSecUnit);
	public static By EditSaveAddress = By.xpath(editSaveAddress);
	public static By SecUnitText = By.xpath(secUnitText);
	public static By EditGisLocationAddress = By.xpath(editGisLocationAddress);
	public static By EditAddressTile = By.xpath(editAddressTile);
	public static By ComcateAddresses = By.xpath(comcateAddresses);
	public static By CancelCreatCasePopup = By.xpath(CCPUtility.cancelCreatCasePopup);
	public static By GisDataAddress = By.xpath(gisDataAddress);
	public static By GisDataAddressSection = By.xpath(gisDataAddressSection);
	public static By ComcateApplicationSection = By.xpath(comcateApplicationSection);
	public static By APNAddressSection = By.xpath(aPNAddressSection);
	public static By ApnAddrresses = By.xpath(apnAddrresses);
	public static By SecUnitNumber = By.xpath(secUnitNumber);
	public static By SecUnitExclamMark = By.xpath(secUnitExclamMark);
	public static By SaveButtonAddress = By.xpath(CCPUtility.saveButton);
	public static By LocationSearchField = By.xpath(CCPUtility.locationSearchField);
	public static By CCPTitle = By.xpath(CCPUtility.cCPTitle);
	public static By LocationFld = By.xpath(CCPUtility.Location);
	public static By EditLocIcon = By.xpath(CCPUtility.EditLocation);
	public static By SaveButton = By.xpath(CCPUtility.saveButton);
	public static By CCButton = By.xpath(CCPUtility.CCbutton);
	public static By AddLocManually = By.xpath(CCPUtility.addLocManually);
	public static By ValidationMsg3 = By.xpath(CCPUtility.validationMsg3);
	public static By SaveButton2 = By.xpath(CCPUtility.saveButton2);
	public static By StreetAdd = By.xpath(CCPUtility.streetAdd);
	public static By CityAdd = By.xpath(CCPUtility.cityAdd);
	public static By ZipAdd = By.xpath(CCPUtility.zipAdd);
	public static By ApnAdd = By.xpath(CCPUtility.apnAdd);
	public static By CancelBtnLoc = By.xpath(CCPUtility.cancelBtnLoc);
	public static By StreetLabel = By.xpath(CCPUtility.streetLabel);
	public static By stateLabel = By.xpath(CCPUtility.stateLabel);
	public static By CityLabel = By.xpath(CCPUtility.cityLabel);
	public static By ZipLabel = By.xpath(CCPUtility.zipLabel);
	public static By apnLabel = By.xpath(CCPUtility.apnLabel);
	public static By OwnerName = By.xpath(CCPUtility.ownerName);
	public static By OwnerAddress = By.xpath(CCPUtility.ownerAddress);

	public static By StateLabelSecUnit = By.xpath(CCPUtility.stateLabelSecUnit);
	public static By CityLabelSecUnit = By.xpath(CCPUtility.cityLabelSecUnit);
	public static By ZipLabelSecUnit = By.xpath(CCPUtility.zipLabelSecUnit);
	public static By ApnLabelSecUnit = By.xpath(CCPUtility.apnLabelSecUnit);
	public static By OwnerNameSecUnit = By.xpath(CCPUtility.ownerNameSecUnit);
	public static By OwnerAddressSecUnit = By.xpath(CCPUtility.ownerAddressSecUnit);
	public static By CancelButton = By.xpath(CCPUtility.cancelButton);

	public static By EmailField = By.xpath(CCPUtility.emailField);
	public static By ModalHeaders = By.xpath(CCPUtility.modalHeaders);
	public static By CaseStatus = By.xpath(CCPUtility.caseStatus);
	public static SoftAssert softAssert = new SoftAssert();
	public static String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
	public static String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");
	public static String searchLocationKeyHost20_prod = PropertiesUtils
			.getPropertyValue("searchLocationKeyHost20_prod");
	public static By secUnitAddress = By.xpath("(//label[@class='field__label-data-field'])[3]");
	public static String expectedStreetName;
	public static boolean gisValidationButton;
	public static boolean gisValidationButtonPin;
	public static String expectedStreetNum;
	public static String expectedOwnerStreetNum;
	public static String expectedOwnerStreetName;
	public static String expectedMappedCity;
	public static String expectedMappedState;
	public static String expectedMappedZip;
	public static String expectedMappedSecUnitNo;
	public static String expectedMappedAPN;
	public static String expectedMappedOwnerName;
	public static String expectedMappedOwnerStreetNum;
	public static String expectedMappedOwnerStreetName;
	public static String expectedMappedOwnerCity;
	public static String expectedMappedOwnerState;
	public static String expectedMappedOwnerZip;
	public static Boolean GISsectionstatus;
	public static Boolean APNsectionstatus;
	public static Boolean ComcateApplicationsectionstaus;
	public static String ValidateStreetAdd;
	public static String validatestate;
	public static String validateCity;
	public static String validateZip;
	public static String validateApn;
	public static String validateOwnerName;
	public static String validateOwnerAddress;

	public void GISMappingDataPreRequisite(String mappingAddress) throws InterruptedException {
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.NavigateTo_LocationManagement(AppPreRequisiteUtility.FieldMappingTab);

		// Getting expected addresses from field mapping page on agency setup
		waitUntilElementIsVisible(AppPreRequisiteUtility.CheckMappingInput);
		waitUntilElementPresent(AppPreRequisiteUtility.CheckMappingInput);
		forcedWaitTime(4);
		scrollIntoView(AppPreRequisiteUtility.CheckMappingInput);

		waitForElementIsInteractable(AppPreRequisiteUtility.CheckMappingInput);

		sendKeysWithWait(AppPreRequisiteUtility.CheckMappingInput, mappingAddress);
		waitForElementIsInteractable(AppPreRequisiteUtility.CheckMappingSaveBtn);
		clickByJsExecuter(AppPreRequisiteUtility.CheckMappingSaveBtn);
		waitForCurserRunning(4);
		forcedWaitTime(4);
		waitUntilElementIsVisible(AppPreRequisiteUtility.CheckMappingSaveBtn);
		waitForElementIsInteractable(AppPreRequisiteUtility.CheckMappingSaveBtn);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedStreetName);
		expectedStreetName = getValueAttribute(AppPreRequisiteUtility.MappedStreetName);

		expectedStreetNum = getValueAttribute(AppPreRequisiteUtility.MappedStreetNum);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerStreeNum);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerStreeNum);
		expectedOwnerStreetNum = getValueAttribute(AppPreRequisiteUtility.MappedOwnerStreeNum);
		expectedOwnerStreetName = getValueAttribute(AppPreRequisiteUtility.MappedOwnerStreeName);
		scrollIntoView(AppPreRequisiteUtility.MappedCity);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedCity);
		expectedMappedCity = getValueAttribute(AppPreRequisiteUtility.MappedCity);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedState);
		expectedMappedState = getValueAttribute(AppPreRequisiteUtility.MappedState);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedZip);
		expectedMappedZip = getValueAttribute(AppPreRequisiteUtility.MappedZip);
		scrollIntoView(AppPreRequisiteUtility.MappedSecUnitNo);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedSecUnitNo);
		expectedMappedSecUnitNo = getValueAttribute(AppPreRequisiteUtility.MappedSecUnitNo);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedAPN);
		expectedMappedAPN = getValueAttribute(AppPreRequisiteUtility.MappedAPN);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerName);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerName);
		expectedMappedOwnerName = getValueAttribute(AppPreRequisiteUtility.MappedOwnerName);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerStreetNum);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerStreetNum);
		expectedMappedOwnerStreetNum = getValueAttribute(AppPreRequisiteUtility.MappedOwnerStreetNum);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerStreetName);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerStreetName);
		expectedMappedOwnerStreetName = getValueAttribute(AppPreRequisiteUtility.MappedOwnerStreetName);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerCity);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerCity);
		expectedMappedOwnerCity = getValueAttribute(AppPreRequisiteUtility.MappedOwnerCity);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerState);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerState);
		expectedMappedOwnerState = getValueAttribute(AppPreRequisiteUtility.MappedOwnerState);
		scrollIntoView(AppPreRequisiteUtility.MappedOwnerZip);
		waitUntilElementIsVisible(AppPreRequisiteUtility.MappedOwnerZip);
		expectedMappedOwnerZip = getValueAttribute(AppPreRequisiteUtility.MappedOwnerZip);

	}
String address ="";
	String addressHosted20 ="";
	public void VerifyPinAddressDetailsMappedWithMappingGISData() throws InterruptedException {

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

			CECommonMethodS.navigateToCCP();
			waitUntilElementIsVisible(CCPTitle);
			waitForElementIsInteractable(CCButton);

			System.out.println("enter in hosted 20 conidition");
			waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
			waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
			WebElement zoomIn = findElement(CCPDirect20Utility.ZoomInMapLocation);
			String aria = zoomIn.getAttribute("aria-disabled");

			WebElement element = findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
			Point offset = element.getLocation();
			int xoffset = offset.getX();
			int yoffset = offset.getY();
			xoffset = -20;
			yoffset = -20;

			Actions actions = new Actions(driver);
			Thread.sleep(3000);
			actions.moveToElement(element, xoffset, yoffset).click().perform();

//	     helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//	     helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);

			waitUntilElementIsVisible(GisDataAddress);
			waitForElementIsInteractable(GisDataAddress);
			clickByJsExecuter(GisDataAddress);
			waitForCurserRunning(10);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementPresent(EditLocIcon);
			waitForElementIsInteractable(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			String extractedTextStreeetAddress = CECommonMethodS.extractAddressFunction(ValidateStreetAdd);
			// Getting actual address from CCP page

			addressHosted20 = extractedTextStreeetAddress;
			System.out.println(addressHosted20);


			waitUntilElementIsVisible(StreetLabel);

			validatestate = getTextElement(stateLabel);
			waitUntilElementIsVisible(CityLabel);
			validateCity = getTextElement(CityLabel);
			waitUntilElementIsVisible(ZipLabel);
			validateZip = getTextElement(ZipLabel);
			waitUntilElementIsVisible(apnLabel);
			validateApn = getTextElement(apnLabel);
			waitUntilElementIsVisible(OwnerName);
			validateOwnerName = getTextElement(OwnerName);
			waitUntilElementIsVisible(OwnerAddress);
			validateOwnerAddress = getTextElement(OwnerAddress);
			gisValidationButtonPin = elementIsDisplayed(EditGisValidationButton);

			waitUntilElementIsVisible(CancelCreatCasePopup);
			scrollIntoView(CancelCreatCasePopup);
			waitForElementIsInteractable(CancelCreatCasePopup);
			clickByJsExecuter(CancelCreatCasePopup);
			waitForCurserRunning(5);
			GISMappingDataPreRequisite(extractedTextStreeetAddress);

			softAssert.assertEquals(validateCity, expectedMappedCity, "city does not not match");
			softAssert.assertEquals(validatestate, expectedMappedState, "state does not not match");
			softAssert.assertEquals(validateZip, expectedMappedZip, "Zip does not not match");
			softAssert.assertEquals(validateApn, expectedMappedAPN, "APN number does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName),
					Boolean.TRUE.booleanValue(), "Owner street name does not not match");
			System.out.println("validateOwnerAddress: "+validateOwnerAddress);
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim(), expectedMappedOwnerCity.trim(),
					"Owner City name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[1].trim().split(" ")[0], expectedMappedOwnerState,
					"Owner State name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[1].trim().split(" ")[1], expectedMappedOwnerZip,
					"Owner Zip does not not match");
			softAssert.assertEquals(gisValidationButtonPin, true);
			softAssert.assertAll();

		}

		else

		{
			CECommonMethodS.navigateToCCP();
			waitUntilElementIsVisible(CCPTitle);
			waitForElementIsInteractable(CCButton);
			waitUntilElementIsVisible(ZoomInMapLocation);
			waitForElementIsInteractable(ZoomInMapLocation);
			WebElement zoomIn = findElement(ZoomInMapLocation);
			String aria = zoomIn.getAttribute("aria-disabled");
			while (aria.equalsIgnoreCase("false")) {
				waitForElementIsInteractable(ZoomInMapLocation);
				clickByJsExecuter(ZoomInMapLocation);
				waitUntilElementIsVisible(ZoomInMapLocation);
				zoomIn = findElement(ZoomInMapLocation);
				aria = zoomIn.getAttribute("aria-disabled");
				forcedWaitTime(2);
			}

			WebElement element = findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
			Point offset = element.getLocation();
			int xoffset = offset.getX();
			int yoffset = offset.getY();
//			int xoffset = -10;
//			int yoffset = 13;
			((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
			
			Actions action= new Actions(driver);
			forcedWaitTime(3);
			action.moveToElement(element,xoffset,yoffset).click().perform();
			
			//element.click();
			waitUntilElementIsVisible(GisDataAddress);
			waitForElementIsInteractable(GisDataAddress);
			clickByJsExecuter(GisDataAddress);
			waitForCurserRunning(10);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementPresent(EditLocIcon);
			waitForElementIsInteractable(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);

			// Getting actual address from CCP page
			ValidateStreetAdd = getTextElement(StreetLabel);
			address =ValidateStreetAdd;
			System.out.println(ValidateStreetAdd);
			waitUntilElementIsVisible(StreetLabel);
			validatestate = getTextElement(stateLabel);
			waitUntilElementIsVisible(CityLabel);
			validateCity = getTextElement(CityLabel);
			waitUntilElementIsVisible(ZipLabel);
			validateZip = getTextElement(ZipLabel);
			waitUntilElementIsVisible(apnLabel);
			validateApn = getTextElement(apnLabel);
			waitUntilElementIsVisible(OwnerName);
			validateOwnerName = getTextElement(OwnerName);
			waitUntilElementIsVisible(OwnerAddress);
			validateOwnerAddress = getTextElement(OwnerAddress);
			gisValidationButtonPin = elementIsDisplayed(EditGisValidationButton);

			waitUntilElementIsVisible(CancelCreatCasePopup);
			scrollIntoView(CancelCreatCasePopup);
			waitForElementIsInteractable(CancelCreatCasePopup);
			clickByJsExecuter(CancelCreatCasePopup);
			waitForCurserRunning(5);
			GISMappingDataPreRequisite(ValidateStreetAdd);

			softAssert.assertEquals(ValidateStreetAdd.split(" ")[0], expectedStreetNum,
					"Stree address does not not match");
			softAssert.assertEquals(ValidateStreetAdd.split(" ")[2], expectedStreetName,
					"Stree name does not not match");
//			softAssert.assertEquals(ValidateStreetAdd.substring(5,ValidateStreetAdd.indexOf(" ST")).trim(), expectedStreetName,
//					"Stree name does not not match");
			softAssert.assertEquals(validateCity, expectedMappedCity, "city does not not match");
			softAssert.assertEquals(validatestate, expectedMappedState, "state does not not match");
			softAssert.assertEquals(validateZip, expectedMappedZip, "Zip does not not match");
			softAssert.assertEquals(validateApn, expectedMappedAPN, "APN number does not not match");
			softAssert.assertEquals(validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim().split(" ")[0],
					expectedMappedOwnerStreetNum, "Owner street number does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName),
					Boolean.TRUE.booleanValue(), "Owner street name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[1].trim(), expectedMappedOwnerCity.trim(),
					"Owner City name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState,
					"Owner State name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip,
					"Owner Zip does not not match");
			softAssert.assertEquals(gisValidationButtonPin, true);
			softAssert.assertAll();
		}

	}

	public void VerifySearchAddressDetailsMappedWithMappingGISData() throws InterruptedException {

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			CECommonMethodS.navigateToCCP();
			waitUntilElementIsVisible(CCPTitle);
			waitForElementIsInteractable(CCButton);
			// in this we use the same address as we used in their parent function .
			CECommonMethodS.serachLocationCCP(address);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			waitUntilElementIsVisible(StateLabelSecUnit);
			validatestate = getTextElement(StateLabelSecUnit);
			waitUntilElementIsVisible(CityLabelSecUnit);
			validateCity = getTextElement(CityLabelSecUnit);
			waitUntilElementIsVisible(ZipLabelSecUnit);
			validateZip = getTextElement(ZipLabelSecUnit);
			waitUntilElementIsVisible(ApnLabelSecUnit);
			validateApn = getTextElement(ApnLabelSecUnit);
			waitUntilElementIsVisible(OwnerNameSecUnit);
			validateOwnerName = getTextElement(OwnerNameSecUnit);
			waitUntilElementIsVisible(OwnerAddressSecUnit);
			validateOwnerAddress = getTextElement(OwnerAddressSecUnit);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			softAssert.assertEquals(ValidateStreetAdd.split(" ")[0], expectedStreetNum,
					"Stree address does not not match");
			softAssert.assertEquals(ValidateStreetAdd.split(" ")[2], expectedStreetName,
					"Stree name does not not match");
//			softAssert.assertEquals(ValidateStreetAdd.substring(5,ValidateStreetAdd.indexOf(" ST")).trim(), expectedStreetName,
//					"Stree name does not not match");
			softAssert.assertEquals(validateCity, expectedMappedCity, "city does not not match");
			softAssert.assertEquals(validatestate, expectedMappedState, "state does not not match");
			softAssert.assertEquals(validateZip, expectedMappedZip, "Zip does not not match");
			softAssert.assertEquals(validateApn, expectedMappedAPN, "APN number does not not match");
			softAssert.assertEquals(validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim().split(" ")[0],
					expectedMappedOwnerStreetNum, "Owner street number does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName),Boolean.TRUE.booleanValue(), "Owner street name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim(), expectedMappedOwnerCity.trim(), "Owner City name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState, "Owner State name does not not match");
			softAssert.assertEquals(validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip, "Owner Zip does not not match");
			softAssert.assertEquals(gisValidationButton, true);
			softAssert.assertAll();

		} else {
			CECommonMethodS.navigateToCCP();
			waitUntilElementIsVisible(CCPTitle);
			waitForElementIsInteractable(CCButton);
			CECommonMethodS.serachLocationCCP(addressHosted20);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			System.out.println("validateStreeAddress: "+ ValidateStreetAdd);
			waitUntilElementIsVisible(StateLabelSecUnit);
			validatestate = getTextElement(StateLabelSecUnit);
			waitUntilElementIsVisible(CityLabelSecUnit);
			validateCity = getTextElement(CityLabelSecUnit);
			waitUntilElementIsVisible(ZipLabelSecUnit);
			validateZip = getTextElement(ZipLabelSecUnit);
			waitUntilElementIsVisible(ApnLabelSecUnit);
			validateApn = getTextElement(ApnLabelSecUnit);
			waitUntilElementIsVisible(OwnerNameSecUnit);
			validateOwnerName = getTextElement(OwnerNameSecUnit);
			waitUntilElementIsVisible(OwnerAddressSecUnit);
			validateOwnerAddress = getTextElement(OwnerAddressSecUnit);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			System.out.println(validateCity);
			System.out.println(validatestate);
			System.out.println(validateOwnerAddress);
			System.out.println(validateOwnerName);

			softAssert.assertEquals(validateCity, expectedMappedCity, "city does not not match");
			softAssert.assertEquals(validatestate, expectedMappedState, "state does not not match");
			softAssert.assertEquals(validateZip, expectedMappedZip, "Zip does not not match");
			softAssert.assertEquals(validateApn, expectedMappedAPN, "APN number does not not match");
			softAssert.assertEquals(validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");

			softAssert.assertEquals(validateOwnerAddress.split(",")[0].trim(), expectedMappedOwnerCity.trim(),
					"Owner City name does not not match");

			softAssert.assertEquals(validateOwnerAddress.split(",")[1].trim().split(" ")[1], expectedMappedOwnerZip,
					"Owner Zip does not not match");
			softAssert.assertEquals(gisValidationButton, true);
			softAssert.assertAll();

		}

	}

	public String PopupTitleActual;

	public void CCP_OpenAddAddressManuallyPopup() throws InterruptedException {

		List<WebElement> OutsideAgency = driver.findElements(CCPUtility.OutAgencyMsg);
		if ((OutsideAgency.size() > 0)) {
			refreshPage();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		sendKeysWithWait(CCPUtility.LocationFld, " ");

		WebElement AddLoc = (WebElement) jse
				.executeScript("return document.querySelector('#react-autowhatever-1 > div')");
		waitUntilWebElementIsVisible(AddLoc);
		waitForElementInteractable(AddLoc);
		clickOnWE(AddLoc);

		waitUntilElementIsVisible(CCPUtility.ManualLocPopup);
		PopupTitleActual = getTextElement(CCPUtility.ManualLocPopup);

		String PopupTitleExpected = "Add Address Manually";
		SoftAssert s7 = new SoftAssert();
		s7.assertEquals(PopupTitleActual, PopupTitleExpected);
		s7.assertAll();
	}

	public void CCP_PreRequisite() throws InterruptedException {
		clickByJsExecuter(By.xpath("//button[text()='Cancel']"));
		CECommonMethodS.navigateToCCP();
		waitUntilElementIsVisible(CCPTitle);
		waitForElementIsInteractable(CCButton);
		String CCPTitleActual = getTextElement(CCPTitle);
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(CCPTitleActual, "Create A Case");
		s1.assertAll();

	}

	public List<WebElement> ModalHeaders1;

	public void CCP_CloseAddAddressManuallyPopup() throws InterruptedException {
		waitUntilElementIsVisible(CancelBtnLoc);
		waitForElementIsInteractable(CancelBtnLoc);
		clickOn(CancelBtnLoc);
		waitUntilElementInvisibleLocated(CancelBtnLoc);
		waitUntilElementInvisibleLocated(
				By.xpath("//div[@class='modal-header']//h2[contains(text(),'Add Address Manually')]"));
		waitUntilElementIsVisible(ModalHeaders);
		ModalHeaders1 = findElementsByXPath(ModalHeaders);

		if ((ModalHeaders1.size() <= 1) == false) {

			SoftAssert s8 = new SoftAssert();
			s8.assertEquals(false, true);
			s8.assertAll();
		}
	}

	public String ValidationMsgActual;

	public void CCP_ValidationMsgForNoAddressDetails() throws InterruptedException {
		String ValidMsgExpected = "The Address is required.";
		waitForElementIsInteractable(LocationFld);
		clickOn(LocationFld);
		clickOn(AddLocManually);
		clickOn(SaveButton2);
		waitUntilElementIsVisible(ValidationMsg3);
		ValidationMsgActual = getTextElement(ValidationMsg3);

		SoftAssert s9 = new SoftAssert();
		s9.assertEquals(ValidationMsgActual, ValidMsgExpected);
		s9.assertAll();
	}

	public String ValidateStreetAddManual;

	public void CCP_AddTheAddressManually() throws InterruptedException {
		waitForElementIsInteractable(LocationFld);
		clickOn(LocationFld);
		clickOn(AddLocManually);
		waitUntilElementIsVisible(StreetAdd);
		waitForElementIsInteractable(StreetAdd);
		sendKeysWithWait(StreetAdd, "Manual Street");
		waitUntilElementIsVisible(CityAdd);
		waitForElementIsInteractable(CityAdd);
		sendKeysWithWait(CityAdd, "Manual City");
		waitUntilElementIsVisible(ZipAdd);
		waitForElementIsInteractable(ZipAdd);
		sendKeysWithWait(ZipAdd, "77590");
		waitUntilElementIsVisible(ApnAdd);
		waitForElementIsInteractable(ApnAdd);
		sendKeysWithWait(ApnAdd, "7030-0122-0011-000");
		waitUntilElementIsVisible(SaveButton2);
		waitForElementIsInteractable(SaveButton2);
		clickOn(SaveButton2);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(StreetLabel);
		waitForElementIsInteractable(StreetLabel);
		ValidateStreetAddManual = getTextElement(StreetLabel);

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals(ValidateStreetAddManual, "Manual Street");
		s10.assertAll();

	}

	public void CCP_VerifyGISComacteAPNSectionUnderLocationTile() throws InterruptedException {
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
			driver.navigate().refresh();
			waitForElementIsInteractable(LocationSearchField);
			waitUntilElementIsVisible(CCPUtility.LocationFld);
			waitUntilElementPresent(CCPUtility.LocationFld);
			waitForElementIsInteractable(CCPUtility.LocationFld);
			forcedWaitTime(3);
			waitForElementIsInteractable(ApnLabelSecUnit);
			sendKeysUsingActions(CCPUtility.LocationFld, "17928499008");
			forcedWaitTime(3);
			waitUntilElementIsVisible(CCPUtility.MapGis2);
			waitForElementIsInteractable(CCPUtility.MapGis2);
			GISsectionstatus = findElement(GisDataAddressSection).isDisplayed();
			APNsectionstatus = findElement(APNAddressSection).isDisplayed();
			ComcateApplicationsectionstaus = findElement(ComcateApplicationSection).isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(GISsectionstatus, Boolean.TRUE);
			s10.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
			s10.assertEquals(APNsectionstatus, Boolean.TRUE);
			s10.assertAll();
		} else {
			driver.navigate().refresh();
			waitForElementIsInteractable(LocationSearchField);
			waitUntilElementIsVisible(CCPUtility.LocationFld);
			waitUntilElementPresent(CCPUtility.LocationFld);
			waitForElementIsInteractable(CCPUtility.LocationFld);
			sendKeysWithWait(CCPUtility.LocationFld, CSPInternalGISDirect20Utility.ExtractedSearchLocationHosted20);
			waitUntilElementIsVisible(CCPUtility.MapGis2);
			waitForElementIsInteractable(CCPUtility.MapGis2);
			GISsectionstatus = findElement(GisDataAddressSection).isDisplayed();
			APNsectionstatus = findElement(APNAddressSection).isDisplayed();
			ComcateApplicationsectionstaus = findElement(ComcateApplicationSection).isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(GISsectionstatus, Boolean.TRUE);
			s10.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
			s10.assertEquals(APNsectionstatus, Boolean.TRUE);
			s10.assertAll();
		}

	}

	public boolean validateAddressBtn;

	public void CCP_VerifySelectAddressRomComcateApplicationAddress() throws InterruptedException {
		scrollIntoView(ComcateAddresses);
		clickByJsExecuter(ComcateAddresses);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(EditLocIcon);
		waitUntilElementIsVisible(StreetLabel);
		waitUntilElementIsVisible(StreetLabel);
		ValidateStreetAdd = getTextElement(StreetLabel);
		waitUntilElementIsVisible(stateLabel);
		validateAddressBtn = findElementsSize(EditvalidatAddressButton)>0;
		validatestate = getTextElement(stateLabel);
		waitUntilElementIsVisible(CityLabel);
		validateCity = getTextElement(CityLabel);
		waitUntilElementIsVisible(ZipLabel);
		validateZip = getTextElement(ZipLabel);
		waitUntilElementIsVisible(apnLabel);
		validateApn = getTextElement(apnLabel);
		waitUntilElementIsVisible(OwnerName);
		validateOwnerName = getTextElement(OwnerName);
		waitUntilElementIsVisible(OwnerAddress);
		validateOwnerAddress = getTextElement(OwnerAddress);

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateAddressBtn, true);
		s10.assertAll();
	}

	public void CCP_VerifySelectAddressAPNSection() throws InterruptedException {

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(PropertiesUtils.getPropertyValue("agencyConfigEnterpriseHosted20"))){
			refreshPage();
			waitUntilElementIsVisible(CCPUtility.LocationFld);
			waitUntilElementPresent(CCPUtility.LocationFld);
			waitForElementIsInteractable(CCPUtility.LocationFld);
			clickOn(CCPUtility.LocationFld);
			clearElement(CCPUtility.LocationFld);
			sendKeysWithWait(CCPUtility.LocationFld, "1275-0000-0031-000");
			waitUntilElementIsVisible(ApnAddrresses);
			scrollIntoView(ApnAddrresses);
			waitForElementIsInteractable(ApnAddrresses);
			clickOn(ApnAddrresses);
			waitForCurserRunning(8);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			waitUntilElementIsVisible(stateLabel);
			validatestate = getTextElement(stateLabel);
			waitUntilElementIsVisible(CityLabel);
			validateCity = getTextElement(CityLabel);
			waitUntilElementIsVisible(ZipLabel);
			validateZip = getTextElement(ZipLabel);
			waitUntilElementIsVisible(apnLabel);
			validateApn = getTextElement(apnLabel);
			waitUntilElementIsVisible(OwnerName);
			validateOwnerName = getTextElement(OwnerName);
			waitUntilElementIsVisible(OwnerAddress);
			validateOwnerAddress = getTextElement(OwnerAddress);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(gisValidationButton, true);
			s10.assertAll();

		} else {
			refreshPage();
			waitUntilElementIsVisible(CCPUtility.LocationFld);
			waitUntilElementPresent(CCPUtility.LocationFld);
			waitForElementIsInteractable(CCPUtility.LocationFld);
			clickByJsExecuter(CCPUtility.LocationFld);
			clearElement(CCPUtility.LocationFld);
			forcedWaitTime(3);
			sendKeysWithWait(CCPUtility.LocationFld, "17816113033");
			waitUntilElementIsVisible(ApnAddrresses);
			scrollIntoView(ApnAddrresses);
			waitForElementIsInteractable(ApnAddrresses);
			clickOn(ApnAddrresses);
			waitForCurserRunning(8);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			waitUntilElementIsVisible(stateLabel);
			validatestate = getTextElement(stateLabel);
			waitUntilElementIsVisible(CityLabel);
			validateCity = getTextElement(CityLabel);
			waitUntilElementIsVisible(ZipLabel);
			validateZip = getTextElement(ZipLabel);
			waitUntilElementIsVisible(apnLabel);
			validateApn = getTextElement(apnLabel);
			waitUntilElementIsVisible(OwnerName);
			validateOwnerName = getTextElement(OwnerName);
			waitUntilElementIsVisible(OwnerAddress);
			validateOwnerAddress = getTextElement(OwnerAddress);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(gisValidationButton, true);
			s10.assertAll();
		}
	}

	public void CCP_VerifySelectAddressFromComcateApplicationAddressPinAddress() throws InterruptedException {
		refreshPage();
		waitUntilElementIsVisible(CCPTitle);
		waitForElementIsInteractable(CCButton);
		CECommonMethodS.CCPGisDirectPinLocation();
		CECommonMethodS.CCPGisDirectSelectComcateAddress();

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertAll();
	}

	public void CCP_VerifySelectAddressAPNSectionPinAddressPinAddress() throws InterruptedException {
		refreshPage();
		waitUntilElementIsVisible(CCPTitle);
		waitForElementIsInteractable(CCButton);
		CECommonMethodS.CCPGisDirectPinLocation();
		CECommonMethodS.CCPGisDirectSelectAPNAddress();
		gisValidationButton = elementIsDisplayed(EditGisValidationButton);

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
		s10.assertEquals(gisValidationButtonPin, true);
		s10.assertAll();
	}

	public String secUnitNumberVal;
	public boolean SecUnitExclamMarkIcon;

	public void CCP_VerifySecondaryUnitNumber() throws InterruptedException {

		if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o))
		{
			refreshPage();
			forcedWaitTime(3);
			crmCommonMethod.serachLocationCCP(searchLocationKey1O);
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			waitUntilElementIsVisible(StateLabelSecUnit);
			waitUntilElementIsVisible(SecUnitNumber);
			secUnitNumberVal = getTextElement(SecUnitNumber);
			SecUnitExclamMarkIcon = findElementsSize(SecUnitExclamMark)>0;
			validatestate = getTextElement(StateLabelSecUnit);
			waitUntilElementIsVisible(CityLabelSecUnit);
			validateCity = getTextElement(CityLabelSecUnit);
			waitUntilElementIsVisible(ZipLabelSecUnit);
			validateZip = getTextElement(ZipLabelSecUnit);
			waitUntilElementIsVisible(ApnLabelSecUnit);
			validateApn = getTextElement(ApnLabelSecUnit);
			waitUntilElementIsVisible(OwnerNameSecUnit);
			validateOwnerName = getTextElement(OwnerNameSecUnit);
			waitUntilElementIsVisible(OwnerAddressSecUnit);
			validateOwnerAddress = getTextElement(OwnerAddressSecUnit);

			SoftAssert s10 = new SoftAssert();

			s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(SecUnitExclamMarkIcon, false);
			s10.assertEquals((secUnitNumberVal).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertAll();
		}
		else {
			refreshPage();
			System.out.println("Enter in host20");
			forcedWaitTime(3);
			crmCommonMethod.serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20"));
			waitUntilElementIsVisible(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			waitUntilElementIsVisible(StreetLabel);
			ValidateStreetAdd = getTextElement(StreetLabel);
			waitUntilElementIsVisible(StateLabelSecUnit);
			waitUntilElementIsVisible(SecUnitNumber);
			secUnitNumberVal = getTextElement(SecUnitNumber);
			SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);
			validatestate = getTextElement(StateLabelSecUnit);
			waitUntilElementIsVisible(CityLabelSecUnit);
			validateCity = getTextElement(CityLabelSecUnit);
			waitUntilElementIsVisible(ZipLabelSecUnit);
			validateZip = getTextElement(ZipLabelSecUnit);
			waitUntilElementIsVisible(ApnLabelSecUnit);
			validateApn = getTextElement(ApnLabelSecUnit);
			waitUntilElementIsVisible(OwnerNameSecUnit);
			validateOwnerName = getTextElement(OwnerNameSecUnit);
			waitUntilElementIsVisible(OwnerAddressSecUnit);
			validateOwnerAddress = getTextElement(OwnerAddressSecUnit);

			SoftAssert s10 = new SoftAssert();

			s10.assertEquals((ValidateStreetAdd).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(SecUnitExclamMarkIcon, false);
			s10.assertEquals((secUnitNumberVal).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validatestate.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateCity).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateZip.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateApn.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals((validateOwnerName).isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertEquals(validateOwnerAddress.isEmpty(), Boolean.FALSE.booleanValue());
			s10.assertAll();

		}
	}

	public boolean secNumber;
	public boolean secNumberPrefix;

	public void CCP_VerifySecondaryUnitNumberUpdated() throws InterruptedException {
		waitUntilElementIsVisible(EditGisLocationAddress);
		waitForElementIsInteractable(EditGisLocationAddress);
		clickByJsExecuter(EditGisLocationAddress);
		waitUntilElementIsVisible(EditAddressTile);
		String unitnumber = RandomStrings.requiredDigits(4);
		WebElement EditSecUnit = findElement(SecUnitText);
		EditSecUnit.clear();
		waitForElementIsInteractable(SecUnitText);
		forcedWaitTime(3);
		sendKeysWithWait(SecUnitText, unitnumber);
		waitUntilElementIsVisible(EditSaveAddress);
		waitForElementIsInteractable(EditSaveAddress);
		clickOn(EditSaveAddress);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(SecUnitNumber);

		String secUnitAdd =   getTextElement(secUnitAddress);
		secUnitNumberVal = getTextElement(SecUnitNumber);
		String secUnitNumber2 = (secUnitNumberVal+" "+secUnitAdd);
		secNumberPrefix = secUnitAdd.startsWith("#");
		secNumber = secUnitNumber2.contains(unitnumber);
		SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals((secUnitNumberVal).isEmpty(), false,"1 st assertion");
		s10.assertEquals(secNumberPrefix,true,"2nd assertion");
		s10.assertEquals(secNumber,true,"3rd assertion");
		s10.assertEquals(SecUnitExclamMarkIcon,true,"4th assertion");
		s10.assertAll();

		// Use for future reference the code is same as the above code..

//		secUnitNumberVal = getTextElement(SecUnitNumber);
//		secNumberPrefix = secUnitNumberVal.startsWith("#");
//		secNumber = secUnitNumberVal.contains(unitnumber);
//		SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);
//
//		SoftAssert s10 = new SoftAssert();
//		s10.assertEquals((secUnitNumberVal).isEmpty(), Boolean.FALSE.booleanValue());
//		s10.assertEquals(secNumberPrefix, true);
//		s10.assertEquals(secNumber, true);
//		s10.assertEquals(SecUnitExclamMarkIcon, true);
//		s10.assertAll();

	}

	public void CCP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton() throws InterruptedException {
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			refreshPage();
			String unitnumber = "#" + RandomStrings.requiredDigits(4);
			crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O + " " + unitnumber);
			forcedWaitTime(3);
			waitUntilElementIsVisible(AddPlusSecUnit);
			waitForElementIsInteractable(AddPlusSecUnit);
			clickByJsExecuter(AddPlusSecUnit);
			waitForCurserRunning(10);

			String secUnitAdd =   getTextElement(secUnitAddress);
			secUnitNumberVal = getTextElement(SecUnitNumber);
			String secUnitNumber2 = (secUnitNumberVal+" "+secUnitAdd);
			secNumberPrefix = secUnitAdd.startsWith("#");
			secNumber = secUnitNumber2.contains(unitnumber);
			SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals((secUnitNumberVal).isEmpty(), false, "1st assertion");
			s10.assertEquals(secNumberPrefix, true, "2nd assertion");
			s10.assertEquals(secNumber, true, "3rd assertion");
			s10.assertEquals(SecUnitExclamMarkIcon, true, "4th assertion");
			s10.assertAll();


			// Use for future reference the code is same as the above code..

//			waitUntilElementIsVisible(SecUnitNumber);
//			secUnitNumberVal = getTextElement(SecUnitNumber);
//			secNumberPrefix = secUnitNumberVal.startsWith("#");
//			secNumber = secUnitNumberVal.contains(unitnumber);
//			SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);
//
//			SoftAssert s10 = new SoftAssert();
//			s10.assertEquals((secUnitNumberVal).isEmpty(), Boolean.FALSE.booleanValue());
//			s10.assertEquals(secNumberPrefix, true);
//			s10.assertEquals(secNumber, true);
//			s10.assertEquals(SecUnitExclamMarkIcon, true);
//			s10.assertAll();
		} else {
			refreshPage();
			String unitnumber = "#" + RandomStrings.requiredDigits(4);
			crmCommonMethod.serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20") + " " + unitnumber);

			waitUntilElementIsVisible(AddPlusSecUnit);
			waitForElementIsInteractable(AddPlusSecUnit);
			clickByJsExecuter(AddPlusSecUnit);
			waitForCurserRunning(10);
			Thread.sleep(3000);

			// Replace this code with new code ..
//                waitUntilElementIsVisible(SecUnitNumber);
//                System.out.println("next step get text from SEcUnitNumber");
//                secUnitNumberVal = getTextByJSExecutor(SecUnitNumber);
//                System.out.println("secUnitNumberVal: ->" + secUnitNumberVal);
//                secNumberPrefix = secUnitNumberVal.startsWith("#");
//                System.out.println("secNumberPrefix: -> " + secNumberPrefix);
//                secNumber = secUnitNumberVal.contains(unitnumber);
//                System.out.println("secNumber: ->" + secNumber);
//                SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);
//                System.out.println("SecUnitExclamMarkIcon: ->" + SecUnitExclamMarkIcon);

			String secUnitAdd =   getTextElement(secUnitAddress);
			secUnitNumberVal = getTextElement(SecUnitNumber);
			String secUnitNumber2 = (secUnitNumberVal+" "+secUnitAdd);
			secNumberPrefix = secUnitAdd.startsWith("#");
			secNumber = secUnitNumber2.contains(unitnumber);
			SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);


			SoftAssert s10 = new SoftAssert();
			s10.assertEquals((secUnitNumberVal).isEmpty(), false, "1st assertion");
			s10.assertEquals(secNumberPrefix, true, "2nd assertion");
			s10.assertEquals(secNumber, true, "3rd assertion");
			s10.assertEquals(SecUnitExclamMarkIcon, true, "4th assertion");
			s10.assertAll();
		}


	}

	public void CCP_VerifyValidationAddressOfNotGISValidateAdddress() throws InterruptedException {

		if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
			CCP_VerifyGISComacteAPNSectionUnderLocationTile();
			CCP_VerifySelectAddressRomComcateApplicationAddress();
			waitForElementIsInteractable(EditvalidatAddressButton);
			clickOn(EditvalidatAddressButton);
			waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
			waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
			clickByJsExecuter(By.xpath("//div[@class='cross']"));
			crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O);
			forcedWaitTime(4);
			waitUntilElementIsVisible(GisDataAddress);
			waitForElementIsInteractable(GisDataAddress);
			clickByJsExecuter(GisDataAddress);
			forcedWaitTime(4);
			waitForCurserRunning(4);
			waitUntilElementIsVisible(SaveButtonAddress);
			waitForElementIsInteractable(SaveButtonAddress);
			clickOn(SaveButtonAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditGisValidationButton);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(gisValidationButton, true);
			s10.assertAll();
		}else{
			CCP_VerifyGISComacteAPNSectionUnderLocationTile();
			CCP_VerifySelectAddressRomComcateApplicationAddress();
			waitForElementIsInteractable(EditvalidatAddressButton);
			clickOn(EditvalidatAddressButton);
			waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
			waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
			clickByJsExecuter(By.xpath("//div[@class='cross']"));
			crmCommonMethod.serachLocationCCPNoClick(addressHosted20);
			forcedWaitTime(4);
			waitUntilElementIsVisible(GisDataAddress);
			waitForElementIsInteractable(GisDataAddress);
			clickByJsExecuter(GisDataAddress);
			forcedWaitTime(4);
			waitForCurserRunning(4);
			waitUntilElementIsVisible(SaveButtonAddress);
			waitForElementIsInteractable(SaveButtonAddress);
			clickOn(SaveButtonAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditGisValidationButton);
			gisValidationButton = elementIsDisplayed(EditGisValidationButton);

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(gisValidationButton, true);
			s10.assertAll();
		}

	}

	public boolean caseStatus;

	public void CCP_CreateCaseWithComcateApplicationAddress() throws InterruptedException {

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			refreshPage();
			crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O);
			CCP_VerifySelectAddressRomComcateApplicationAddress();
			CECommonMethodS.addViolationCCP();
			CECommonMethodS.ce_addContact();
			waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			clickOn(CCPUtility.CreateCaseButton);
			waitForCurserRunning(5);
			handleReviewContact();

			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
				CECommonMethodS.selectCaseAssineCCP("Mark Shane");
				CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
			} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
				CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
				CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

			} else {
				CECommonMethodS.selectCaseAssineCCP("Shane Es");
				CECommonMethodS.selectInspectionAssineCCP("Shane Es");
			}

			waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
			clickOn(CCPUtility.CreateScheduleInspectionButton);
			waitForCurserRunning(10);
			waitUntilElementIsVisible(CaseStatus);
			WebElement Case = findElement(CaseStatus);
			caseStatus = Case.isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(caseStatus, true);
			s10.assertAll();
		}else{
			refreshPage();
			forcedWaitTime(3);
			crmCommonMethod.serachLocationCCPNoClick(addressHosted20);
			CCP_VerifySelectAddressRomComcateApplicationAddress();
			CECommonMethodS.addViolationCCP();
			CECommonMethodS.ce_addContact();
			waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			clickOn(CCPUtility.CreateCaseButton);
			waitForCurserRunning(5);
			handleReviewContact();

			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
				CECommonMethodS.selectCaseAssineCCP("Mark Shane");
				CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
			} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
				CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
				CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

			} else {
				CECommonMethodS.selectCaseAssineCCP("Shane Es");
				CECommonMethodS.selectInspectionAssineCCP("Shane Es");
			}

			waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
			clickOn(CCPUtility.CreateScheduleInspectionButton);
			waitForCurserRunning(10);
			waitUntilElementIsVisible(CaseStatus);
			WebElement Case = findElement(CaseStatus);
			caseStatus = Case.isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(caseStatus, true);
			s10.assertAll();
		}

	}

	public void CCP_CreateCaseWithGISDataAddress() throws InterruptedException {

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			driver.get(BrowsersInvoked.URLCreateCase);
			waitForCurserRunning(3);
			crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O);
			waitUntilElementIsVisible(GisDataAddress);
			waitForElementIsInteractable(GisDataAddress);
			clickByJsExecuter(GisDataAddress);
			waitForCurserRunning(5);
			waitForElementIsInteractable(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			CECommonMethodS.addViolationCCP();
			CECommonMethodS.ce_addContact();
			waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			clickOn(CCPUtility.CreateCaseButton);
			handleReviewContact();
			waitForCurserRunning(5);

			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
				CECommonMethodS.selectCaseAssineCCP("Mark Shane");
				CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
			} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
				CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
				CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

			} else {
				CECommonMethodS.selectCaseAssineCCP("Shane Es");
				CECommonMethodS.selectInspectionAssineCCP("Shane Es");
			}

			clickOn(CCPUtility.CreateScheduleInspectionButton);
			waitForCurserRunning(10);
			waitUntilElementIsVisible(CaseStatus);
			WebElement Case = findElement(CaseStatus);
			caseStatus = Case.isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(caseStatus, true);
			s10.assertAll();
		} else {
			{
				driver.get(BrowsersInvoked.URLCreateCase);
				waitForCurserRunning(3);
				crmCommonMethod.serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20"));
				waitUntilElementIsVisible(GisDataAddress);
				waitForElementIsInteractable(GisDataAddress);
				clickByJsExecuter(GisDataAddress);
				waitForCurserRunning(10);
				waitUntilElementIsVisible(EditLocIcon);
				waitForElementIsInteractable(EditLocIcon);
				waitUntilElementIsVisible(StreetLabel);
				CECommonMethodS.addViolationCCP();
				CECommonMethodS.ce_addContact();
				waitForElementIsInteractable(CCPUtility.CreateCaseButton);
				clickOn(CCPUtility.CreateCaseButton);
				handleReviewContact();
				waitForCurserRunning(5);

				if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
					CECommonMethodS.selectCaseAssineCCP("Mark Shane");
					CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
				} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
					CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
					CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

				} else {
					CECommonMethodS.selectCaseAssineCCP("Shane Es");
					CECommonMethodS.selectInspectionAssineCCP("Shane Es");
				}

				clickOn(CCPUtility.CreateScheduleInspectionButton);
				waitForCurserRunning(10);
				waitUntilElementIsVisible(CaseStatus);
				WebElement Case = findElement(CaseStatus);
				caseStatus = Case.isDisplayed();

				SoftAssert s10 = new SoftAssert();
				s10.assertEquals(caseStatus, true);
				s10.assertAll();
			}

		}

	}

	public void CCP_CreateCaseWithAPNDataAddress() throws InterruptedException {

		if(agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
			driver.get(BrowsersInvoked.URLCreateCase);
			waitForCurserRunning(3);
			crmCommonMethod.serachLocationCCPNoClick("17816113033");
			CECommonMethodS.CCPGisDirectSelectAPNAddress();
			waitForCurserRunning(10);
			waitUntilElementIsVisible(EditLocIcon);
			waitForElementIsInteractable(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			CECommonMethodS.addViolationCCP();
			CECommonMethodS.ce_addContact();
			waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			clickOn(CCPUtility.CreateCaseButton);
			handleReviewContact();
			waitForCurserRunning(5);

			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
				CECommonMethodS.selectCaseAssineCCP("Mark Shane");
				CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
			} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
				CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
				CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

			} else {
				CECommonMethodS.selectCaseAssineCCP("Shane Es");
				CECommonMethodS.selectInspectionAssineCCP("Shane Es");
			}
			waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
			clickOn(CCPUtility.CreateScheduleInspectionButton);
			waitForCurserRunning(5);

			waitUntilElementIsVisible(CaseStatus);
			WebElement Case = findElement(CaseStatus);
			caseStatus = Case.isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(caseStatus, true);
			s10.assertAll();
		}else{
			driver.get(BrowsersInvoked.URLCreateCase);
			waitForCurserRunning(3);
			crmCommonMethod.serachLocationCCPNoClick("7030-0193-0001-000");
			CECommonMethodS.CCPGisDirectSelectAPNAddress();
			waitForCurserRunning(10);
			waitUntilElementIsVisible(EditLocIcon);
			waitForElementIsInteractable(EditLocIcon);
			waitUntilElementIsVisible(StreetLabel);
			CECommonMethodS.addViolationCCP();
			CECommonMethodS.ce_addContact();
			waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			clickOn(CCPUtility.CreateCaseButton);
			handleReviewContact();
			waitForCurserRunning(5);

			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
				CECommonMethodS.selectCaseAssineCCP("Mark Shane");
				CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
			} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
				CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
				CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

			} else {
				CECommonMethodS.selectCaseAssineCCP("Shane Es");
				CECommonMethodS.selectInspectionAssineCCP("Shane Es");
			}
			waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
			clickOn(CCPUtility.CreateScheduleInspectionButton);
			waitForCurserRunning(5);

			waitUntilElementIsVisible(CaseStatus);
			WebElement Case = findElement(CaseStatus);
			caseStatus = Case.isDisplayed();

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(caseStatus, true);
			s10.assertAll();
		}
	}

	public void CCP_CreateCaseWithAPNDataAddressPinAPNAddress() throws InterruptedException {

		driver.get(BrowsersInvoked.URLCreateCase);
		// for blank page issue occurs that's why putting wait here.
		forcedWaitTime(3);
		refreshPage();
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CCPTitle);
		waitForElementIsInteractable(CCButton);
		CECommonMethodS.CCPGisDirectPinLocation();
		CECommonMethodS.CCPGisDirectSelectAPNAddress();
		waitForCurserRunning(10);
		waitUntilElementIsVisible(EditLocIcon);
		waitForElementIsInteractable(EditLocIcon);
		waitUntilElementIsVisible(StreetLabel);
		CECommonMethodS.addViolationCCP();
		CECommonMethodS.ce_addContact();
		waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		clickOn(CCPUtility.CreateCaseButton);
		handleReviewContact();
		waitForCurserRunning(5);

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			CECommonMethodS.selectCaseAssineCCP("Mark Shane");
			CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
			CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

		} else {
			CECommonMethodS.selectCaseAssineCCP("Shane Es");
			CECommonMethodS.selectInspectionAssineCCP("Shane Es");
		}

		waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
		clickOn(CCPUtility.CreateScheduleInspectionButton);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CaseStatus);
		WebElement Case = findElement(CaseStatus);
		caseStatus = Case.isDisplayed();

		SoftAssert s10 = new SoftAssert();
		s10.assertEquals(caseStatus, true);
		s10.assertAll();
	}

	public void CCP_CreateCaseWithAPNDataAddressPinGISDataddress() throws InterruptedException {

		driver.get(BrowsersInvoked.URLCreateCase);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CCPTitle);
		waitForElementIsInteractable(CCButton);
		CECommonMethodS.CCPGisDirectPinLocation();
		waitUntilElementIsVisible(GisDataAddress);
		waitForElementIsInteractable(GisDataAddress);
		clickByJsExecuter(GisDataAddress);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(EditLocIcon);
		waitForElementIsInteractable(EditLocIcon);
		waitUntilElementIsVisible(StreetLabel);
		CECommonMethodS.addViolationCCP();
		CECommonMethodS.ce_addContact();
		waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		clickOn(CCPUtility.CreateCaseButton);
		handleReviewContact();
		waitForCurserRunning(5);

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			CECommonMethodS.selectCaseAssineCCP("Mark Shane");
			CECommonMethodS.selectInspectionAssineCCP("Mark Shane");
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			CECommonMethodS.selectCaseAssineCCP("Amandeep Singh1");
			CECommonMethodS.selectInspectionAssineCCP("Amandeep Singh1");

		} else {
			CECommonMethodS.selectCaseAssineCCP("Shane Es");
			CECommonMethodS.selectInspectionAssineCCP("Shane Es");
		}

		waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
		clickOn(CCPUtility.CreateScheduleInspectionButton);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CaseStatus);
		WebElement Case = findElement(CaseStatus);
		caseStatus = Case.isDisplayed();
		SoftAssert s10 = new SoftAssert();
		s10.assertEquals(caseStatus, true);
		s10.assertAll();
	}

}
