package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;

import org.openqa.selenium.WebElement;

import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

public class LocationManagmentUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public LocationManagmentUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
	}

	public static By LocationManagementTab = By.xpath("//label[text()='Location Management']");

	public static By LocationandMapsTab = By.xpath("//label[text()='Location and Maps']");
	public static By FieldMappingTab = By.xpath("//label[text()='Field Mapping']");
	public static By CheckMappingInput = By.xpath("//input[@name='address'][@type='TEXT']");
	public static By MappedStreetName = By.xpath("(//input[@name='mappedValue'])[3]");
	public static By MappedStreetNum = By.xpath("(//input[@name='mappedValue'])[2]");
	public static By MappedOwnerStreeNum = By.xpath("(//input[@name='mappedValue'])[8]");
	public static By MappedOwnerStreeName = By.xpath("(//input[@name='mappedValue'])[9]");
	public static By MappedCity = By.xpath("//td[contains(text(),'CITY*')]//following-sibling::td//input");
	public static By MappedState = By.xpath("//td[contains(text(),'STATE*')]//following-sibling::td//input");
	public static By MappedZip = By.xpath("//td[contains(text(),'ZIP*')]//following-sibling::td//input");
	public static By MappedSecUnitNo = By
			.xpath("(//td[contains(text(),'SECONDARY UNIT NUMBER')]//following-sibling::td//input)[1]");
	public static By MappedAPN = By.xpath("(//td[contains(text(),'APN')]//following-sibling::td//input)[1]");
	public static By MappedOwnerName = By
			.xpath("(//td[contains(text(),'OWNER NAME')]//following-sibling::td//input)[1]");
	public static By MappedOwnerStreetNum = By
			.xpath("(//td[contains(text(),'STREET NUMBER')]//following-sibling::td//input)[2]");
	public static By MappedOwnerStreetName = By
			.xpath("(//td[contains(text(),'STREET NAME')]//following-sibling::td//input)[2]");
	public static By MappedOwnerCity = By.xpath("(//td[contains(text(),'CITY')]//following-sibling::td//input)[2]");
	public static By MappedOwnerState = By.xpath("(//td[contains(text(),'STATE')]//following-sibling::td//input)[2]");
	public static By MappedOwnerZip = By.xpath("(//td[contains(text(),'ZIP')]//following-sibling::td//input)[2]");

	public static By CheckMappingSaveBtn = By.xpath("//button[contains(text(),'Check Mapping and Save')]");
	public static By parcelLayerTab = By.xpath("//div[contains(text(),'Parcel Layer Mappings')]");
	public static By LCFTab = By.xpath("//div[text()='Location Custom Fields']");
	public static By MapLayersTab = By.xpath("//div[text()='Map Layers']");
	public static By UploadMapLayerButton = By.xpath("//button[text()='Upload Map Layer']");
	public static By LabelField = By.xpath("//input[@name='label']");
	public static By ReplaceFile = By.xpath("//label[@for='file-upload__kml'][@class='file-upload__label']");
	public static By UploadFileLink = By.xpath("//label[@for='file-upload__kml']");
	public static By UploadFileInput = By.xpath("//input[@id='file-upload__kml']");
	public static By CreateMapLayerButton = By.xpath("//button[text()='Create Map Layer']");
	public static By AgencyBoundaryTab = By.xpath("//div[text()='Agency Boundary']");
	public static By AgencyBoundayTitle = By.xpath("//div[@class='flex-column--left agency-boundary__title']//h4");
	public static By AgencyMapSettingTitle = By.xpath("//div[@class='agency-setup-tab map-settings']//h4");
	public static By UploadAgencyBoundary = By.xpath("//input[@id='file-upload__boundary']");
	public static By UploadKMZFileInput = By.xpath("//input[@id='file-upload__boundary']");
	public static By MapSettingsTab = By.xpath("//div[text()='Map Settings']");
	public static By SaveChangesButton = By.xpath("//button[text()='Save Changes']");
	public static By CenterLongitudeField = By.xpath("//input[@name='centerLongitude']");
	public static By CenterLatitudeField = By.xpath("//input[@name='centerLatitude']");
	public static By TextOptionType = By.xpath("//div[text()='Text']");
	public static By LCFsActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By ICCActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By LCCActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By MapLayerUploadFile = By.xpath("//input[@id='file-upload__kml']");
	public static By SaveButton = By.xpath("//button[text()='Save']");
	public static By UploadedFileLabel = By.xpath("//div[@class='file-upload']//b");
	public static By AgencyParcelFileInput = By.xpath("//input[@id='file-upload__layer']");
	public static By RefreshLinkText = By.xpath("//a[text()='Refresh']");

	public static By securedLocSetting = By.xpath("//div[text()='Secured Location Settings']");
	public static By gisserverURL = By.xpath("//input[@name='gisServerUrl']");
	public static By addressMap = By.xpath("//label[@for='addressMapping']//parent::span//input[@name='secondary']");
	public static By selectArrowAddField = By
			.xpath("(//div[text()='Select Field'])[2]//parent::div//following-sibling::span");

	public static By selectArrowAddField2 = By
			.xpath("(//div[text()='Select Field'])[3]//parent::div//following-sibling::span");

	public static By selectArrowField3 = By
			.xpath("(//div[text()='Select Field'])[4]//parent::div//following-sibling::span");

	public static By selectPracelFieldArrow = By
			.xpath("(//div[text()='Select Field'])[7]//parent::div//following-sibling::span");

	public static By ownerPrimaryfieldRdBtn = By.xpath("(//div[@class='owner-container']//input[@name='primary'])[1]");

	public static By selectOwnerFieldArrow = By
			.xpath("(//div[text()='Select Field'])[9]//parent::div//following-sibling::span");

	public static By selectOwnerInfoFieldArrow = By
			.xpath("(//div[text()='Select Field'])[12]//parent::div//following-sibling::span");
	public static By selectOwnerAddressFieldArrow = By
			.xpath("(//div[text()='Select Field'])[13]//parent::div//following-sibling::span");
	public static By selectOwnerzIPAddressFieldArrow = By
			.xpath("(//div[text()='Select Field'])[14]//parent::div//following-sibling::span");

	public static By ownerAddressMapRdBtn = By.xpath("(//div[@class='container']//input[@name='secondary'])[3]");

	public static String selectfieldValue = "//div[text()='%s']";
	public static By checkAndSaveMappingBtn = By.xpath("//button[text()='Check Mapping and Save']");
	public static By mappingAddressTxt = By.xpath("//input[@name='address']");

	public static By addressMappingPrimary = By.xpath("//label[@for='addressMapping']//parent::span//input[@name='primary']");
	public static By selectArrowAddField1 = By
			.xpath("(//div[text()='Select Field'])[1]//parent::div//following-sibling::span");

	public static By selectArrowAddField6 = By
			.xpath("(//div[text()='Select Field'])[6]//parent::div//following-sibling::span");

	public static By selectAPNArrowField = By
			.xpath("(//div[text()='Select Field'])[11]//parent::div//following-sibling::span");

	public static By selectOwnerFieldAddressHost20 = By.xpath("(//div[@class='container']//input[@name='primary'])[2]");

	public static By selectOwnerNameFieldHost20 = By
			.xpath("(//div[text()='Select Field'])[15]//parent::div//following-sibling::span");

	public static By selectOwnerAddressMappingHost20 = By
			.xpath("(//div[@class='container']//input[@name='primary'])[3]");

	public static By selectOwnerAddressHost20 = By.xpath("(//div[text()='Select Field'])[17]//parent::div//following-sibling::span");

	public static By selectOwnerCityStateHost20 = By.xpath("(//div[text()='Select Field'])[22]//parent::div//following-sibling::span");

	public static By selectOwnerzipAddressHost20 = By.xpath("(//div[text()='Select Field'])[23]//parent::div//following-sibling::span");

	public void navigationToLocationManagement() throws InterruptedException {

		waitForPresenceandVisiblity(LocationManagementTab);
		scrollIntoView(LocationManagementTab);
		waitForElementIsInteractable(LocationManagementTab);
		clickByJsExecuter(LocationManagementTab);
		waitForCurserRunning(2);

	}

	// Navigation to Secured Location Settings
	public void navigationToSecuredLocationSettings() throws InterruptedException {
		forcedWaitTime(2);
		waitForElementIsInteractable(securedLocSetting);
		clickByJsExecuter(securedLocSetting);

	}

	// Send URL in GisServerURL field on secured Location Setting
	public void SendServerURL() {
		waitForElementIsInteractable(gisserverURL);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			String serverURL = PropertiesUtils.getPropertyValue("GISServerURL_CI");
			sendKeysWithWait(gisserverURL, serverURL);
		} else {
			String serverURL = PropertiesUtils.getPropertyValue("GISServerURL");
			sendKeysWithWait(gisserverURL, serverURL);
		}
	}

	// Click on Save changes button on secure Location Settings
	public void clickOnSaveChangesButton() throws InterruptedException {
		waitForElementIsInteractable(SaveChangesButton);
		clickOn(SaveChangesButton);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(SaveChangesButton);
	}

	// get GIS server URL
	public String getGisServerURL() {
		waitForElementIsInteractable(gisserverURL);
		String Url = getSpecificAttribute(gisserverURL, "value");
		return Url;
	}

	// Navigate to Field Mapping under Location Management Tab
	public void navigateToFieldMapping() throws InterruptedException {
		scrollIntoView(FieldMappingTab);
		waitForElementIsInteractable(FieldMappingTab);
		clickOn(FieldMappingTab);
		waitForCurserRunning(5);
	}

	public void navigationToLocationandMaps() throws InterruptedException {
		scrollIntoView(LocationandMapsTab);
		waitForElementIsInteractable(LocationandMapsTab);
		clickOn(LocationandMapsTab);
		waitForCurserRunning(5);
	}

	public void mapfieldAddress() throws InterruptedException {

		try{

		// click on secondary address
		forcedWaitTime(4);
		clickByJsExecuter(addressMap);
		forcedWaitTime(4);


		// select Directional Prefix field
		scrollIntoView(selectArrowAddField);
		forcedWaitTime(4);
		clickOn(selectArrowAddField);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRDIR")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "STRDIR")));
		forcedWaitTime(4);

			// select Street Number field
			clickOn(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRNO")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "STRNO")));
			forcedWaitTime(3);

			// select Street Name field
			clickOn(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRNAME")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "STRNAME")));
			forcedWaitTime(3);

			// select Street Type Address field
			clickOn(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRTYPE")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "STRTYPE")));
			forcedWaitTime(3);

			// select Agency City Address field
			clickOn(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_city")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "agency_city")));
			forcedWaitTime(3);

			// select Agency State Address field
			clickOn(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_state")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "agency_state")));
			forcedWaitTime(3);

			// select agency zip Address field
			waitForElementIsInteractable(selectArrowAddField2);
			clickOn(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_zip")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "agency_zip")));
			forcedWaitTime(3);

			// select secondary Unity Number field
			scrollIntoView(selectArrowField3);
			forcedWaitTime(2);
			waitForElementIsInteractable(selectArrowAddField2);
			clickOn(selectArrowField3);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRUNIT")));
			clickOn(By.xpath(selectorFormate(selectfieldValue, "STRUNIT")));
			forcedWaitTime(3);

		}catch (Exception e ){
			//  enter in catch Agency Creation


			// click on secondary address
			forcedWaitTime(3);
			clickByJsExecuter(addressMap);
			forcedWaitTime(3);

			// select Directional Prefix field
			clickByJsExecuter(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRDIR")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "STRDIR")));
			forcedWaitTime(3);

			// select Street Number field
			clickByJsExecuter(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRNO")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "STRNO")));
			forcedWaitTime(3);

			// select Street Name field
			clickByJsExecuter(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRNAME")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "STRNAME")));
			forcedWaitTime(3);

			// select Street Type Address field
			clickByJsExecuter(selectArrowAddField);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRTYPE")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "STRTYPE")));
			forcedWaitTime(3);

			// select Agency City Address field
			clickByJsExecuter(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_city")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "agency_city")));
			forcedWaitTime(3);

			// select Agency State Address field
			clickByJsExecuter(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_state")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "agency_state")));
			forcedWaitTime(3);

			// select agency zip Address field
			waitForElementIsInteractable(selectArrowAddField2);
			clickByJsExecuter(selectArrowAddField2);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "agency_zip")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "agency_zip")));
			forcedWaitTime(3);

			// select secondary Unity Number field
			waitForElementIsInteractable(selectArrowAddField2);
			clickByJsExecuter(selectArrowField3);
			forcedWaitTime(3);
			scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "STRUNIT")));
			clickByJsExecuter(By.xpath(selectorFormate(selectfieldValue, "STRUNIT")));
			forcedWaitTime(3);
		}

	}

	public void mapParcelAddress() throws InterruptedException {
		// select APN field
		forcedWaitTime(4);
		scrollIntoView(selectPracelFieldArrow);
		forcedWaitTime(4);

		waitForElementIsInteractable(selectPracelFieldArrow);
		clickOn(selectPracelFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "PARCEL")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "PARCEL")));
		forcedWaitTime(4);

		// select LAT* field
		scrollIntoView(selectPracelFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectPracelFieldArrow);
		clickOn(selectPracelFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "POINT_Y")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "POINT_Y")));
		forcedWaitTime(4);

		// select LONG* field
		scrollIntoView(selectPracelFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectPracelFieldArrow);
		clickOn(selectPracelFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "POINT_X")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "POINT_X")));
		forcedWaitTime(4);

	}

	public void mapOwnerInfo() throws InterruptedException {

		// checked Owner Mapping

		forcedWaitTime(4);
		scrollIntoView(ownerPrimaryfieldRdBtn);
		clickByJsExecuter(ownerPrimaryfieldRdBtn);
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerFieldArrow);
		waitForElementIsInteractable(selectOwnerFieldArrow);
		clickOn(selectOwnerFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_NAME")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_NAME")));
		forcedWaitTime(4);

	}

	public void mapownerAddress() throws InterruptedException {

		// checked Owner Address Mapping
		forcedWaitTime(4);
		scrollIntoView(ownerAddressMapRdBtn);
		clickByJsExecuter(ownerAddressMapRdBtn);
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerInfoFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerInfoFieldArrow);
		clickOn(selectOwnerInfoFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_STDIR")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_STDIR")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerInfoFieldArrow);
		waitForElementIsInteractable(selectOwnerInfoFieldArrow);
		clickOn(selectOwnerInfoFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_NUM")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_NUM")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerInfoFieldArrow);
		waitForElementIsInteractable(selectOwnerInfoFieldArrow);
		clickOn(selectOwnerInfoFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_STNAME")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_STNAME")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerInfoFieldArrow);
		waitForElementIsInteractable(selectArrowAddField2);
		clickOn(selectOwnerInfoFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_STTYPE")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_STTYPE")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerAddressFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerAddressFieldArrow);
		clickOn(selectOwnerAddressFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_CITY")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_CITY")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerAddressFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerAddressFieldArrow);
		clickOn(selectOwnerAddressFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_STATE")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_STATE")));
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerzIPAddressFieldArrow);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerzIPAddressFieldArrow);
		clickOn(selectOwnerzIPAddressFieldArrow);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "OWNER_ZIP")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "OWNER_ZIP")));
		forcedWaitTime(4);

	}

	public void checkAndSaveMapping() throws InterruptedException {
		waitForPresenceandVisiblity(checkAndSaveMappingBtn);
		scrollIntoView(checkAndSaveMappingBtn);
		forcedWaitTime(2);
		scrollIntoView(checkAndSaveMappingBtn);
		forcedWaitTime(2);
		waitForElementIsInteractable(mappingAddressTxt);
		String address = null;
		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			 address = PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod");
		}
		else {
		    address = PropertiesUtils.getPropertyValue("searchLocationKey1O");
		}
		sendKeysWithWait(mappingAddressTxt, address);
		forcedWaitTime(2);
		clickOn(checkAndSaveMappingBtn);
		waitForCurserRunning(5);
		forcedWaitTime(2);

	}

	public void mapfieldAddressHosted20() throws InterruptedException {
		// click on primary address
		forcedWaitTime(4);
		clickByJsExecuter(addressMappingPrimary);
		forcedWaitTime(4);

		// select Directional Prefix field
		scrollIntoView(selectArrowAddField1);
		forcedWaitTime(4);
		clickOn(selectArrowAddField1);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "site_address")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "site_address")));
		forcedWaitTime(4);

		// select Agency City Address field
		scrollIntoView(selectArrowAddField6);
		forcedWaitTime(2);
		clickOn(selectArrowAddField6);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "site_city")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "site_city")));
		forcedWaitTime(4);

		// select Agency State Address field
		scrollIntoView(selectArrowAddField6);
		forcedWaitTime(2);
		clickOn(selectArrowAddField6);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "site_state")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "site_state")));
		forcedWaitTime(4);

		// select agency zip Address field
		waitForPresenceandVisiblity(selectArrowAddField6);
		scrollIntoView(selectArrowAddField6);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectArrowAddField6);
		clickOn(selectArrowAddField6);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "site_zip")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "site_zip")));
		forcedWaitTime(4);

	}

	public void mapAPNHosted20() throws InterruptedException {
		// select APN field

		waitForElementIsInteractable(selectAPNArrowField);
		clickOn(selectAPNArrowField);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "apn")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "apn")));
		forcedWaitTime(4);
	}

	public void mapOwnerInfoHosted20() throws InterruptedException {
		// checked Owner Name Mapping
		forcedWaitTime(4);
		scrollIntoView(selectOwnerFieldAddressHost20);
		clickByJsExecuter(selectOwnerFieldAddressHost20);
		forcedWaitTime(4);

		// select Owner Name
		scrollIntoView(selectOwnerNameFieldHost20);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerNameFieldHost20);
		clickOn(selectOwnerNameFieldHost20);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "owner_name")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "owner_name")));
		forcedWaitTime(4);

		// checked Owner Address Mapping
		forcedWaitTime(4);
		scrollIntoView(selectOwnerAddressMappingHost20);
		clickByJsExecuter(selectOwnerAddressMappingHost20);
		forcedWaitTime(4);

		// select Owner address
		scrollIntoView(selectOwnerAddressHost20);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerAddressHost20);
		clickOn(selectOwnerAddressHost20);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "owner_address")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "owner_address")));
		forcedWaitTime(4);

		// select Owner City
		scrollIntoView(selectOwnerCityStateHost20);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerCityStateHost20);
		clickOn(selectOwnerCityStateHost20);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "owner_city")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "owner_city")));
		forcedWaitTime(4);

		// select Owner State
		scrollIntoView(selectOwnerCityStateHost20);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerCityStateHost20);
		clickOn(selectOwnerCityStateHost20);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "owner_state")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "owner_state")));
		forcedWaitTime(4);

		// select Owner Zip
		scrollIntoView(selectOwnerzipAddressHost20);
		forcedWaitTime(2);
		waitForElementIsInteractable(selectOwnerzipAddressHost20);
		clickOn(selectOwnerzipAddressHost20);
		forcedWaitTime(4);
		scrollIntoView(By.xpath(selectorFormate(selectfieldValue, "owner_zip")));
		clickOn(By.xpath(selectorFormate(selectfieldValue, "owner_zip")));
		forcedWaitTime(4);
	}

}
