package POM;



import BrowsersBase.BrowsersInvoked;
import CommonMethods.*;
import TestCases.CCP;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static BrowsersBase.BrowsersInvoked.agencyConfigEnterpriseHosted20;
import static POM.CCPDirect20Utility.*;
import static POM.CCPUtility.agencyConfig;
import static POM.CCPUtility.softAssert;
import static org.junit.Assert.assertEquals;

public class CSPInternalGISDirect20Utility extends Helper{

    public WebDriver driver;

    LoginUtility log;
    CRMCommonMethods crmCommonMethod;
    CECommonMethods ceCommonMethod;
    CCPDirect20Utility CCPDirect20Utils;
    public Helper helper;


    public CSPInternalGISDirect20Utility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        crmCommonMethod = new CRMCommonMethods(driver);
        ceCommonMethod = new CECommonMethods(driver);
        CCPDirect20Utils= new CCPDirect20Utility(driver);
    }

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();

    }

        public static String plusIconToCRM = "//*[@class='app-header__new']";
        public static String editLocationHeaderCSP = "//div[@class='flex-row--center location-tile__header']//h2";
        public static String editLocationSave= "//div[@class='flex-row--center location-tile__header']//button[text()='Save']";
        public static String customerSubmissionOption = "//label[text()='Customer submission']";
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
        public static String contactSearchResults = "(//div[@class='react-autosuggest__suggestion-element']/div)[3]";
        public static String categoryDropdown = "//label[@for='selectedCategory']/following::span[1]";
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
        public static String cancelButton = "//button[text()='Cancel']";
        public static String toggleChecked = "//div[@class='react-toggle react-toggle--checked bs-toggle danger']";
        public static String flagToggle = "(//div[@class='react-toggle-thumb'])[1]";
        public static String postAnonymouslyCheckboxbtn = "//input[@name='isAnonymous'][@type='checkbox']";
        public static String submissionNumber = "//h2[@class='customer-submission-details__number']";
        public static String submissionStatus = "//h2[@class='customer-submission-details__status']";


        public static By PostAnonymouslyCheckboxbtn = By.xpath(CSPInternalGISDirect20Utility.postAnonymouslyCheckboxbtn);
        public static By PlusIconToCRM = By.xpath(CSPInternalGISDirect20Utility.plusIconToCRM);
        public static By CancelCreateCase = By.xpath(CSPInternalGISDirect20Utility.cancelCreateCase);
        public static By CustomerSubmissionOption = By.xpath(CSPInternalGISDirect20Utility.customerSubmissionOption);
        public static By CSPPopupTitle = By.xpath(CSPInternalGISDirect20Utility.cSPPopupTitle);
        public static By CreateSubmissionButton = By.xpath(CSPInternalGISDirect20Utility.createSubmissionButton);
        public static By GlobalErrorMessageCSP = By.xpath(CSPInternalGISDirect20Utility.globalErrorMessageCSP);
        public static By PostAnonymouslyCheckbox = By.xpath(CSPInternalGISDirect20Utility.postAnonymouslyCheckbox);
        public static By AddExistingCustomerField = By.xpath(CSPInternalGISDirect20Utility.addExistingCustomerField);
        public static By NameField = By.xpath(CSPInternalGISDirect20Utility.nameField);
        public static By EmailField = By.xpath(CSPInternalGISDirect20Utility.emailField);
        public static By WorkPhoneField = By.xpath(CSPInternalGISDirect20Utility.workPhoneField);
        public static By CellPhoneField = By.xpath(CSPInternalGISDirect20Utility.cellPhoneField);
        public static By SelectedAnonymousToggle = By.xpath(CSPInternalGISDirect20Utility.selectedAnonymousToggle);
        public static By YesToggleAnonymous = By.xpath(CSPInternalGISDirect20Utility.yesToggleAnonymous);
        public static By SaveChangesButton = By.xpath(CSPInternalGISDirect20Utility.saveChangesButton);
        public static By ContactSearchResults = By.xpath(CSPInternalGISDirect20Utility.contactSearchResults);
        public static By CategoryDropdown = By.xpath(CSPInternalGISDirect20Utility.categoryDropdown);
        public static By SearchCategory = By.xpath(CSPInternalGISDirect20Utility.searchCategory);
        public static By SelectedCategory = By.xpath(CSPInternalGISDirect20Utility.selectedCategory);
        public static By SearchResultsCategory = By.xpath(CSPInternalGISDirect20Utility.searchResultsCategory);
        public static By LocationValidationMsg = By.xpath(CSPInternalGISDirect20Utility.locationValidationMsg);
        public static By LocationSearchResult = By.xpath(CSPInternalGISDirect20Utility.locationSearchResult);
        public static By ToggleChecked = By.xpath(CSPInternalGISDirect20Utility.toggleChecked);
        public static By FlagToggle = By.xpath(CSPInternalGISDirect20Utility.flagToggle);
        public static By LocationField = By.xpath(CSPInternalGISDirect20Utility.locationField);
        public static By IssueDescriptionField = By.xpath(CSPInternalGISDirect20Utility.issueDescriptionField);
        public static By TagsField = By.xpath(CSPInternalGISDirect20Utility.tagsField);
        public static By AttachmentIcon = By.xpath(CSPInternalGISDirect20Utility.attachmentIcon);
        public static By CameraButton = By.xpath(CSPInternalGISDirect20Utility.cameraButton);
        public static By AddButton = By.xpath(CSPInternalGISDirect20Utility.addButton);
        public static By ImageThumb = By.xpath(CSPInternalGISDirect20Utility.imageThumb);
        public static By SubmisionStatus = By.xpath(CSPInternalGISDirect20Utility.submisionStatus);
        public static By CloseSubmissionIcon = By.xpath(CSPInternalGISDirect20Utility.closeSubmissionIcon);
        public static By CancelButton = By.xpath(CSPInternalGISDirect20Utility.cancelButton);
        public static By EditLocationHeaderCSP = By.xpath(editLocationHeaderCSP);
        public static By EditLocationSave = By.xpath(editLocationSave);
        public static By SubmissionNumber = By.xpath(submissionNumber);
        public static By SubmissionStatus = By.xpath(submissionStatus);

        public static String SelectedToggleForAnonymous;
        public static String SelectedToggleNow;
        public static String ErrMessageActual;
        public static String ErrMessageExpected;
        public static String CSPTitleActual;
        public static String CSPTitleExpected;
        public static String ValidateStreetAdd;
        public static String validatestate;
        public static String validateCity;
        public static String validateZip;
        public static String validateApn;
        public static String validateOwnerName;
        public static String validateOwnerAddress;
        public static boolean gisValidationButtonPin;
        public static boolean gisValidationButton;



        public static String fullStreetAddress= "(//input[contains(@placeholder,'')])[4]";
        public static String expectedMappedCity2 = "(//input[contains(@placeholder,'')])[]";
        public static String searchLocationHosted20 = "1225 10TH ST N, Texas City, TX 77590";

        public static String ExtractedSearchLocationHosted20=  CRMCommonMethods.extractAddressFunction(searchLocationHosted20);

        public  void CSPInternal_VerifyCSPOpensUp() throws InterruptedException {
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
        }



        public  void VerifyPinAddressDetailsMappedWithMappingGISDataCSP() throws InterruptedException {
            //  CRMCommonMethods.navigateToCSP();
         if(agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)){
            crmCommonMethod.navigationToCSP();
            waitUntilElementIsVisible(ZoomInMapLocation);
            scrollIntoView(ZoomInMapLocation);
            waitUntilElementPresent(ZoomInMapLocation);
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
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
            element.click();

            waitUntilElementIsVisible(GisDataAddress);
            waitForElementIsInteractable(GisDataAddress);
            clickByJsExecuter(GisDataAddress);

//            forcedWaitTime(4);
//            clickByJsExecuter(By.xpath("//button[normalize-space()='Add Address']"));
//

            waitForCurserRunning(10);
            waitUntilElementIsVisible(EditLocIcon);
            waitForElementIsInteractable(EditLocIcon);
            waitUntilElementIsVisible(StreetLabel);
            ValidateStreetAdd = getTextElement(StreetLabel);
            System.out.println("ValidateStreetAdd: -> " + ValidateStreetAdd);
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

            CCPDirect20Utils.GISMappingDataPreRequisite(ValidateStreetAdd);

            System.out.println("ValidateStreetAdd : " + ValidateStreetAdd);

            String ab = CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[0];

            System.out.println("ab : -> " + ab);

            softAssert.assertEquals(ab, expectedStreetNum, "checking street num");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[2], expectedStreetName, "Stree name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateCity, expectedMappedCity, "city does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validatestate, expectedMappedState, "state does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateZip, expectedMappedZip, "Zip does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateApn, expectedMappedAPN, "APN number does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().split(" ")[0], expectedMappedOwnerStreetNum, "Owner street number does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName), Boolean.TRUE.booleanValue(), "Owner street name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[1].trim(), expectedMappedOwnerCity.trim(), "Owner City name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState, "Owner State name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip, "Owner Zip does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.gisValidationButtonPin, true);
            softAssert.assertAll();

        }  else{

             System.out.println("enter in else conidition");
             crmCommonMethod.navigationToCSP();
             waitUntilElementIsVisible(ZoomInMapLocation);
             scrollIntoView(ZoomInMapLocation);
             waitUntilElementPresent(ZoomInMapLocation);
             waitForElementIsInteractable(ZoomInMapLocation);
             WebElement zoomIn = findElement(ZoomInMapLocation);
             String aria = zoomIn.getAttribute("aria-disabled");

             WebElement element = findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
             Point offset = element.getLocation();
             int xoffset = offset.getX();
             int yoffset = offset.getY();
             System.out.println("xoffset :"+ xoffset);
             System.out.println("yoffset :"+yoffset);
              xoffset= -10;
              yoffset= 12;

             Actions actions =  new Actions(driver);
             Thread.sleep(3000);
             actions.moveToElement(element,xoffset,yoffset).click().perform();

             Thread.sleep(3000);
           //  element.click();
             Thread.sleep(4000);
             waitUntilElementIsVisible(GisDataAddress);
             waitForElementIsInteractable(GisDataAddress);
             clickByJsExecuter(GisDataAddress);

             waitForCurserRunning(10);
             waitUntilElementIsVisible(EditLocIcon);
             waitForElementIsInteractable(EditLocIcon);
             waitUntilElementIsVisible(StreetLabel);
             ValidateStreetAdd = getTextElement(StreetLabel);
             System.out.println("ValidateStreetAdd: -> " + ValidateStreetAdd);
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

             String[] parts = ValidateStreetAdd.split(" ");

             String extracted =" ";
             // Combine the first two parts to get the desired output
             if (parts.length >= 2) {
                 extracted = parts[0] + " " + parts[1];
                 System.out.println("Extracted: " + extracted);
             } else {
                 System.out.println("The address does not have enough parts.");
             }



             CCPDirect20Utils.GISMappingDataPreRequisite(extracted.toString());

             System.out.println("ValidateStreetAdd : " + ValidateStreetAdd);


            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateCity, expectedMappedCity, "city does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validatestate, expectedMappedState, "state does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateZip, expectedMappedZip, "Zip does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateApn, expectedMappedAPN, "APN number does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName), Boolean.TRUE.booleanValue(), "Owner street name does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[1].trim(), expectedMappedOwnerCity.trim(), "Owner City name does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState, "Owner State name does not not match");
             System.out.println("expectedMappedOwnerZip : " + expectedMappedOwnerZip);
             System.out.println("validateOwnerAddress : "+validateOwnerAddress);
             softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip, "Owner Zip does not not match");
             softAssert.assertEquals(CSPInternalGISDirect20Utility.gisValidationButtonPin, true);
             softAssert.assertAll();
            }

        }

        public static String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");

        public  void VerifySearchAddressDetailsMappedWithMappingGISDataCSP() throws InterruptedException {

            if (agencyConfig.equalsIgnoreCase(POM.CCPUtility.agencyConfigGisDirect2o)){
                CCPDirect20Utils.GISMappingDataPreRequisite(searchLocationKey1O);
            //   crmCommonMethod.NavigationTo_CSP();
            crmCommonMethod.navigationToCSP();
            ceCommonMethod.serachLocationCCP(searchLocationKey1O);
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


            softAssert.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[0], expectedStreetNum, "Stree address does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[1], expectedStreetName, "Stree name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateCity, expectedMappedCity, "city does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validatestate, expectedMappedState, "state does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateZip, expectedMappedZip, "Zip does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateApn, expectedMappedAPN, "APN number does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().split(" ")[0], expectedMappedOwnerStreetNum, "Owner street number does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName), Boolean.TRUE.booleanValue(), "Owner street name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[1].trim(), expectedMappedOwnerCity.trim(), "Owner City name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState, "Owner State name does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip, "Owner Zip does not not match");
            softAssert.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
            softAssert.assertAll();
        }else {
                System.out.println("enter in else condition");

                CCPDirect20Utils.GISMappingDataPreRequisite(searchLocationHosted20);
                //   crmCommonMethod.NavigationTo_CSP();
                crmCommonMethod.navigationToCSP();
              String extractedAddress =  CRMCommonMethods.extractAddressFunction(searchLocationHosted20);
                ceCommonMethod.serachLocationCCP(extractedAddress);
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


//                softAssert.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[0], expectedStreetNum, "Stree address does not not match");
//                softAssert.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAdd.split(" ")[1], expectedStreetName, "Stree name does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateCity, expectedMappedCity, "city does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validatestate, expectedMappedState, "state does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateZip, expectedMappedZip, "Zip does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateApn, expectedMappedAPN, "APN number does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerName, expectedMappedOwnerName, "Owner name does not not match");
//                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().split(" ")[0], expectedMappedOwnerStreetNum, "Owner street number does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[0].trim().contains(expectedMappedOwnerStreetName), Boolean.TRUE.booleanValue(), "Owner street name does not not match");
             //   softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[1].trim(), expectedMappedOwnerCity.trim(), "Owner City name does not not match");
                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[0], expectedMappedOwnerState, "Owner State name does not not match");

                System.out.println("validateOwnerAddress : "+validateOwnerAddress);
                System.out.println("expectedMappedOwnerZip :  "+expectedMappedOwnerZip);

                softAssert.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.split(",")[2].trim().split(" ")[1], expectedMappedOwnerZip, "Owner Zip does not not match");
                System.out.println("validateOwnerAddress : "+validateOwnerAddress);
                System.out.println("expectedMappedOwnerZip :  "+expectedMappedOwnerZip);
                softAssert.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
                softAssert.assertAll();


            }






        }


        public static String PopupTitleActual;

        public  void CSP_OpenAddAddressManuallyPopup() throws InterruptedException {

            List<WebElement> OutsideAgency = driver.findElements(CCPUtility.OutAgencyMsg);
            if ((OutsideAgency.size() > 0)) {
                refreshPage();
            }
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            sendKeysUsingActions(CCPUtility.LocationFld, " ");

            WebElement AddLoc = (WebElement) jse.executeScript("return document.querySelector('#react-autowhatever-1 > div')");
            waitUntilWebElementIsVisible(AddLoc);
            waitForElementInteractable(AddLoc);
            clickOnWE(AddLoc);

            waitUntilElementIsVisible(CCPUtility.ManualLocPopup);
            PopupTitleActual = getTextElement(CCPUtility.ManualLocPopup);


            String PopupTitleExpected = "Add Address Manually";
            SoftAssert s7 = new SoftAssert();
            s7.assertEquals(CSPInternalGISDirect20Utility.PopupTitleActual, PopupTitleExpected);
            s7.assertAll();



        }

        public static List<WebElement> ModalHeaders1;

        public  void CSP_CloseAddAddressManuallyPopup() throws InterruptedException {
            waitUntilElementIsVisible(CancelBtnLoc);
            waitForElementIsInteractable(CancelBtnLoc);
            clickOn(CancelBtnLoc);
            waitUntilElementIsInvisible(CancelBtnLoc);
            waitUntilElementIsInvisible(By.xpath("//div[@class='modal-header']//h2[contains(text(),'Add Address Manually')]"));
            waitUntilElementIsVisible(ModalHeaders);
            ModalHeaders1 = findElementsByXPath(ModalHeaders);

            if (!(CSPInternalGISDirect20Utility.ModalHeaders1.size() <= 1)) {

                SoftAssert s8 = new SoftAssert();
                s8.assertEquals(false, true);
                s8.assertAll();
            }
        }



        public static String ValidationMsgActual;

        public  void CSP_ValidationMsgForNoAddressDetails() throws InterruptedException {
            waitForElementIsInteractable(LocationFld);
            clickByJsExecuter(LocationFld);
            Thread.sleep(3000);
            clickByJsExecuter(AddLocManually);
            clickOn(SaveButton2);

            waitUntilElementIsVisible(ValidationMsg3);
            ValidationMsgActual = getTextElement(ValidationMsg3);

            String ValidMsgExpected = "The Address is required.";
            SoftAssert s9 = new SoftAssert();
            s9.assertEquals(CSPInternalGISDirect20Utility.ValidationMsgActual, ValidMsgExpected);
            s9.assertAll();

        }


        public static String ValidateStreetAddManual;

        public  void CSP_AddTheAddressManually() throws InterruptedException {
            if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {
                waitForElementIsInteractable(LocationFld);
                clickByJsExecuter(LocationFld);
                Thread.sleep(3000);
                clickByJsExecuter(AddLocManually);
                // clickOn(SaveButton2);
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
                try{
                    waitUntilElementIsVisible(SaveButton2);
                    waitForElementIsInteractable(SaveButton2);
                    clickOn(SaveButton2);
                }catch (Exception e){
                  e.printStackTrace();
                }
                waitForCurserRunning(5);
                waitUntilElementIsVisible(StreetLabel);
                waitForElementIsInteractable(StreetLabel);
                ValidateStreetAddManual = getTextElement(StreetLabel);

//1851 HILLPOINTE RD

                SoftAssert s10 = new SoftAssert();
                s10.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAddManual, "1225 10TH ST N");
                s10.assertAll();
            }else{
                System.out.println("Enter in else");
                waitForElementIsInteractable(LocationFld);
                clickOn(LocationFld);
                Thread.sleep(3000);
                clickByJsExecuter(AddLocManually);
                // clickOn(SaveButton2);
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
                clickByJsExecuter(SaveButton2);
                waitForCurserRunning(5);
                waitUntilElementIsVisible(StreetLabel);
                waitForElementIsInteractable(StreetLabel);
                ValidateStreetAddManual = getTextElement(StreetLabel);

//1851 HILLPOINTE RD

                SoftAssert s10 = new SoftAssert();
                s10.assertEquals(CSPInternalGISDirect20Utility.ValidateStreetAddManual, "1851 HILLPOINTE RD");
                s10.assertAll();
            }
        }




        public static Boolean GISsectionstatus;
        public static Boolean APNsectionstatus;
        public static Boolean ComcateApplicationsectionstaus;

        public  void CSP_VerifyGISComacteAPNSectionUnderLocationTile() throws InterruptedException {
           if(agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
//               driver.navigate().refresh();
               waitForElementIsInteractable(LocationSearchField);
               waitUntilElementIsVisible(CCPUtility.LocationFld);
               waitUntilElementPresent(CCPUtility.LocationFld);
               waitForElementIsInteractable(CCPUtility.LocationFld);
               sendKeysUsingActions(CCPUtility.LocationFld, searchLocationKey1O);
               waitUntilElementIsVisible(CCPUtility.MapGis2);
               waitForElementIsInteractable(CCPUtility.MapGis2);
               GISsectionstatus = findElement(GisDataAddressSection).isDisplayed();
               APNsectionstatus = findElement(APNAddressSection).isDisplayed();
               ComcateApplicationsectionstaus = findElement(ComcateApplicationSection).isDisplayed();


               SoftAssert s10 = new SoftAssert();
               s10.assertEquals(CSPInternalGISDirect20Utility.GISsectionstatus, Boolean.TRUE);
               s10.assertEquals(CSPInternalGISDirect20Utility.ComcateApplicationsectionstaus, Boolean.TRUE);
               s10.assertEquals(CSPInternalGISDirect20Utility.APNsectionstatus, Boolean.TRUE);
               s10.assertAll();
           }else{
               driver.navigate().refresh();
               waitForElementIsInteractable(LocationSearchField);
               waitUntilElementIsVisible(CCPUtility.LocationFld);
               waitUntilElementPresent(CCPUtility.LocationFld);
               waitForElementIsInteractable(CCPUtility.LocationFld);
               sendKeysUsingActions(CCPUtility.LocationFld, ExtractedSearchLocationHosted20);
               waitUntilElementIsVisible(CCPUtility.MapGis2);
               waitForElementIsInteractable(CCPUtility.MapGis2);
               GISsectionstatus = findElement(GisDataAddressSection).isDisplayed();
               APNsectionstatus = findElement(APNAddressSection).isDisplayed();
               ComcateApplicationsectionstaus = findElement(ComcateApplicationSection).isDisplayed();


               SoftAssert s10 = new SoftAssert();
               s10.assertEquals(CSPInternalGISDirect20Utility.GISsectionstatus, Boolean.TRUE);
               s10.assertEquals(CSPInternalGISDirect20Utility.ComcateApplicationsectionstaus, Boolean.TRUE);
               s10.assertEquals(CSPInternalGISDirect20Utility.APNsectionstatus, Boolean.TRUE);
               s10.assertAll();
           }
        }





        public static boolean validateAddressBtn;
        public  void CSP_VerifySelectAddressRomComcateApplicationAddress() throws InterruptedException {
           Thread.sleep(2000);
            clickByJsExecuter(ComcateAddresses);
            waitForCurserRunning(8);
            waitUntilElementIsVisible(EditLocIcon);
            waitUntilElementIsVisible(StreetLabel);
            waitUntilElementIsVisible(StreetLabel);
            ValidateStreetAdd = getTextElement(StreetLabel);
            waitUntilElementIsVisible(stateLabel);
            validateAddressBtn =  findElementsSize(EditvalidatAddressButton)>0;
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
            s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateAddressBtn,true);
            s10.assertAll();




        }


        public  void CSP_VerifySelectAddressAPNSection() throws InterruptedException {

            if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
                refreshPage();
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                waitUntilElementPresent(CCPUtility.LocationFld);
                waitForElementIsInteractable(CCPUtility.LocationFld);
                clickOn(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                sendKeysUsingActions(CCPUtility.LocationFld, "17816113033");
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
                s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
                s10.assertAll();
            }else{
                refreshPage();
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                waitUntilElementPresent(CCPUtility.LocationFld);
                waitForElementIsInteractable(CCPUtility.LocationFld);
                clickByJsExecuter(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                sendKeysUsingActions(CCPUtility.LocationFld, "7030-0207-0006-000");
                waitUntilElementIsVisible(ApnAddrresses);
                scrollIntoView(ApnAddrresses);
                waitForElementIsInteractable(ApnAddrresses);
                clickByJsExecuter(ApnAddrresses);
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
                s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
                s10.assertAll();
            }



        }



        public  void CSP_VerifySelectAddressFromComcateApplicationAddressPinAddress() throws InterruptedException {
            refreshPage();
            ceCommonMethod.CCPGisDirectPinLocation();
            ceCommonMethod.CCPGisDirectSelectComcateAddress();

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
            s10.assertAll();
        }


        public static boolean secNumber;
        public static boolean secNumberPrefix;

        public void  CSP_VerifySecondaryUnitNumberUpdated() throws InterruptedException {
            waitUntilElementIsVisible(EditGisLocationAddress);
            waitForElementIsInteractable(EditGisLocationAddress);
            clickOn(EditGisLocationAddress);
            waitUntilElementIsVisible(EditLocationHeaderCSP);
            String unitnumber = RandomStrings.requiredDigits(4);
            WebElement EditSecUnit = waitUntilVisibleWE(SecUnitText);
            EditSecUnit.clear();
            waitForElementIsInteractable(SecUnitText);
            sendKeysWithWait(SecUnitText, unitnumber);
            waitUntilElementIsVisible(EditLocationSave);
            waitForElementIsInteractable(EditLocationSave);
            clickOn(EditLocationSave);
            waitForCurserRunning(3);
            waitUntilElementIsVisible(SecUnitNumber);

          String secUnitAdd =   getTextElement(By.xpath("(//label[@class='field__label-data-field'])[3]"));
            System.out.println("secUnitAdd : " +secUnitAdd);

            secUnitNumberVal = getTextElement(SecUnitNumber);
           String secUnitNumber2 = (secUnitNumberVal+" "+secUnitAdd);
            System.out.println("secUnitNumberVal :" +secUnitNumber2);
            secNumberPrefix = secUnitAdd.startsWith("#");
            System.out.println(secNumberPrefix);
            secNumber = secUnitNumber2.contains(unitnumber);
            SecUnitExclamMarkIcon = elementIsDisplayed(SecUnitExclamMark);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals((CSPInternalGISDirect20Utility.secUnitNumberVal).isEmpty(), false,"1 st assertion");
            s10.assertEquals(CSPInternalGISDirect20Utility.secNumberPrefix,true,"2nd assertion");
            s10.assertEquals(CSPInternalGISDirect20Utility.secNumber,true,"3rd assertion");
            s10.assertEquals(CSPInternalGISDirect20Utility.SecUnitExclamMarkIcon,true,"4th assertion");
            s10.assertAll();


        }


        public void  CSP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton() throws InterruptedException{
            refreshPage();

            if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
                String unitnumber = "#" + RandomStrings.requiredDigits(4);
                crmCommonMethod.serachLocationCCPNoClick("1851 Hillpoine RD" + " " + unitnumber);
//                crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O);
                System.out.println("unitnumber: -> " + unitnumber);
                waitUntilElementIsVisible(AddPlusSecUnit);
                waitForElementIsInteractable(AddPlusSecUnit);
                clickByJsExecuter(AddPlusSecUnit);
                //System.out.println("SecUnitNumber: -> " + SecUnitNumber);
                waitForCurserRunning(5);
                Thread.sleep(3000);

                String secUnitAdd =   getTextElement(secUnitAddress);
                secUnitNumberVal = getTextElement(SecUnitNumber);
                String secUnitNumber2 = (secUnitNumberVal+" "+secUnitAdd);
                secNumberPrefix = secUnitAdd.startsWith("#");
                secNumber = secUnitNumber2.contains(unitnumber);
                SecUnitExclamMarkIcon = findElementsSize(SecUnitExclamMark)>0;

                SoftAssert s10 = new SoftAssert();
                s10.assertEquals((CSPInternalGISDirect20Utility.secUnitNumberVal).isEmpty(), false, "1st assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.secNumberPrefix, true, "2nd assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.secNumber, true, "3rd assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.SecUnitExclamMarkIcon, true, "4th assertion");
                s10.assertAll();
            }else {
                String unitnumber = "#" + RandomStrings.requiredDigits(4);
                crmCommonMethod.serachLocationCCPNoClick(searchLocationHosted20 + " " + unitnumber);
                System.out.println("unitnumber: -> " + unitnumber);
                waitUntilElementIsVisible(AddPlusSecUnit);
                waitForElementIsInteractable(AddPlusSecUnit);
                clickByJsExecuter(AddPlusSecUnit);
                System.out.println("SecUnitNumber: -> " + SecUnitNumber);
                waitForCurserRunning(5);
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
                s10.assertEquals((CSPInternalGISDirect20Utility.secUnitNumberVal).isEmpty(), false, "1st assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.secNumberPrefix, true, "2nd assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.secNumber, true, "3rd assertion");
                s10.assertEquals(CSPInternalGISDirect20Utility.SecUnitExclamMarkIcon, true, "4th assertion");
                s10.assertAll();
            }

        }


        public void  CSP_VerifySelectAddressAPNSectionPinAddressPinAddress() throws InterruptedException {
            refreshPage();
            ceCommonMethod.CCPGisDirectPinLocation();
            ceCommonMethod.CCPGisDirectSelectAPNAddress();
            gisValidationButton = elementIsDisplayed(EditGisValidationButton);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
            s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
            s10.assertEquals(CSPInternalGISDirect20Utility.gisValidationButtonPin,true);
            s10.assertAll();
        }



        public static String secUnitNumberVal;
        public static boolean SecUnitExclamMarkIcon;

        public void  CSP_VerifySecondaryUnitNumber() throws InterruptedException {

            if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
                refreshPage();
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

                s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.SecUnitExclamMarkIcon, false);
                s10.assertEquals((CSPInternalGISDirect20Utility.secUnitNumberVal).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                s10.assertAll();
            }else {
                refreshPage();
                crmCommonMethod.serachLocationCCP(ExtractedSearchLocationHosted20);
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

                s10.assertEquals((CSPInternalGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.SecUnitExclamMarkIcon, false);
                s10.assertEquals((CSPInternalGISDirect20Utility.secUnitNumberVal).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validatestate.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateCity).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateZip.isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateApn.isEmpty(), false);
                s10.assertEquals((CSPInternalGISDirect20Utility.validateOwnerName).isEmpty(), false);
                s10.assertEquals(CSPInternalGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                s10.assertAll();
            }


        }


        public void  CSP_VerifyValidationAddressOfNotGISValidateAdddress() throws InterruptedException {

            if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
                CCPDirect20Utils.CCP_VerifyGISComacteAPNSectionUnderLocationTile();
                CCPDirect20Utils.CCP_VerifySelectAddressRomComcateApplicationAddress();
                waitForElementIsInteractable(EditvalidatAddressButton);
                clickOn(EditvalidatAddressButton);
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
                clickByJsExecuter(By.xpath("//div[@class='cross']"));
                crmCommonMethod.serachLocationCCPNoClick(searchLocationKey1O);
                waitUntilElementIsVisible(GisDataAddress);
                waitUntilElementPresent(GisDataAddress);
                waitForElementIsInteractable(GisDataAddress);
                forcedWaitTime(4);
                scrollIntoView(GisDataAddress);
                forcedWaitTime(4);
                clickByJsExecuter(GisDataAddress);
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocationSave);
                waitForElementIsInteractable(EditLocationSave);
                clickOn(EditLocationSave);

                waitForCurserRunning(5);
                Thread.sleep(3000);
                waitUntilElementIsVisible(EditGisValidationButton);
                gisValidationButton = findElementsSize(EditGisValidationButton)>0;


                SoftAssert s10 = new SoftAssert();
                s10.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
                s10.assertAll();
            }else{
                CCPDirect20Utils.CCP_VerifyGISComacteAPNSectionUnderLocationTile();
                CCPDirect20Utils.CCP_VerifySelectAddressRomComcateApplicationAddress();
                waitForElementIsInteractable(EditvalidatAddressButton);
                clickOn(EditvalidatAddressButton);
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
                clickByJsExecuter(By.xpath("//div[@class='cross']"));
                crmCommonMethod.serachLocationCCPNoClick("920 14TH AVE N TEXAS CITY TX 77590");
                waitUntilElementIsVisible(GisDataAddress);
                waitUntilElementPresent(GisDataAddress);
                waitForElementIsInteractable(GisDataAddress);
                forcedWaitTime(4);
                clickByJsExecuter(GisDataAddress);
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocationSave);
                waitForElementIsInteractable(EditLocationSave);
                clickByJsExecuter(EditLocationSave);

                waitForCurserRunning(5);
                Thread.sleep(3000);
                waitUntilElementIsVisible(EditGisValidationButton);
                gisValidationButton = elementIsDisplayed(EditGisValidationButton);


                SoftAssert s10 = new SoftAssert();
                s10.assertEquals(CSPInternalGISDirect20Utility.gisValidationButton, true);
                s10.assertAll();
            }



        }

        public static boolean submissionnumber;
        public static String submissionStatusText;
        public void  CSP_CreateCustomerSubmissionWithComcateApplicationAddress() throws InterruptedException{
            refreshPage();
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",comcateAddresses,false,false);
            waitUntilElementIsVisible(SubmissionNumber);
            submissionnumber = findElementsSize(SubmissionNumber)>0;
            waitUntilElementIsVisible(SubmissionStatus);
            forcedWaitTime(3);
            submissionStatusText =  getTextElement(SubmissionStatus);
            System.out.println("submissionStatusText: "+ submissionStatusText);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionnumber,true);
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionStatusText,"Open");
            s10.assertAll();



        }


        public void  CSP_CreateCustomerSubmissionWithGISDataAddress() throws InterruptedException{
            driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",gisDataAddress,false,false);
            waitUntilElementIsVisible(SubmissionNumber);
            submissionnumber = elementIsDisplayed(SubmissionNumber);
            waitUntilElementIsVisible(SubmissionStatus);
            submissionStatusText =  getTextElement(SubmissionStatus);
            System.out.println("submissionStatusText :"+submissionStatusText);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionnumber,true);
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionStatusText,"Open");
            s10.assertAll();


        }


        public void  CSP_CreateCustomerSubmissionWithAPNAddress() throws InterruptedException{
            driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",apnAddrresses,true,false);
            waitUntilElementIsVisible(SubmissionNumber);
            submissionnumber = findElementsSize(SubmissionNumber)>0;
            waitUntilElementIsVisible(SubmissionStatus);
            submissionStatusText =  getTextElement(SubmissionStatus);
            System.out.println("submissionStatusText :"+ submissionStatusText);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionnumber,true);
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionStatusText,"Open");
            s10.assertAll();



        }

        public void  CSP_CreateSubmissionWithAPNDataAddressPinAPNAddress() throws InterruptedException{
            driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",apnAddrresses,true,true);
            waitUntilElementIsVisible(SubmissionNumber);
            submissionnumber = findElementsSize(SubmissionNumber)>0;
            waitUntilElementIsVisible(SubmissionStatus);
            submissionStatusText =  getTextElement(SubmissionStatus);
            System.out.println("submissionStatusText :" + submissionStatusText);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionnumber,true);
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionStatusText,"Open");
            s10.assertAll();


        }

        public void  CSP_CreateSubmissionWithGISDataPinAPNAddress() throws InterruptedException{
            driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",gisDataAddress,true,true);
            waitUntilElementIsVisible(SubmissionNumber);
            submissionnumber = findElementsSize(SubmissionNumber)>0;
            waitUntilElementIsVisible(SubmissionStatus);
            submissionStatusText =  getTextElement(SubmissionStatus);
            System.out.println("submissionStatusText :"+ submissionStatusText);

            SoftAssert s10 = new SoftAssert();
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionnumber,true);
            s10.assertEquals(CSPInternalGISDirect20Utility.submissionStatusText,"Open");
            s10.assertAll();



        }



        public void  CSPInternal_AddLocation() throws InterruptedException {
            clickOn(CategoryDropdown);
            sendKeysWithWait(SearchCategory, "Location Not Required");
            clickOn(SearchResultsCategory);
            sendKeysWithWait(LocationField, "Texas ");
            waitUntilElementIsVisible(LocationSearchResult);
            sendKeysWithWait(LocationField, "City Museum");
            waitUntilElementIsVisible(LocationSearchResult);
            waitForElementIsInteractable(LocationSearchResult);
            clickOn(LocationSearchResult);
        }




}
