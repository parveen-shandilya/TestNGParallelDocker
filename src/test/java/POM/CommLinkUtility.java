package POM;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static POM.CSPExternalUtility.*;

public class CommLinkUtility extends Helper {
    public WebDriver driver;
    LoginUtility log;
    CRMCommonMethods crmCommonMethod;

    public CommLinkUtility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        crmCommonMethod = new CRMCommonMethods(driver);

    }

    public static By editAgencyHeader = By.xpath("//h1[@class='case-header__left']");
    public static By commlinkFeatureFlagOffToggle = By.xpath("((//label[text()='CommLink Feature Flag'])/../..)//button[text()='OFF']");
    public static By commlinkEnterPriseOffToggle = By.xpath("((//label[text()='CommLink Enterprise'])/../..)//button[text()='OFF']");
    public static By commlinkFeatureFlagONToggle = By.xpath("((//label[text()='CommLink Feature Flag'])/../..)//button[text()='ON']");
    public static By commlinkEnterPriseONToggle = By.xpath("((//label[text()='CommLink Enterprise'])/../..)//button[text()='ON']");

    public static By editAndConfigureCRMHeader = By.xpath("(//div[@class='modal-header'])[2]");
    public static By editCRMButton = By.xpath("(//h4[text()='CRM']/..)/button");
    public static By commlinkEnterpriseSaveBttn = By.xpath("(//button[text()='Save'])[2]");
    public static By saveButton = By.xpath("(//button[text()='Save'])");
    public static By cancelButtonCommlinkEnterprise = By.xpath("(//button[text()='Cancel'])[2]");
    public static By cancelButton = By.xpath("(//button[text()='Cancel'])");
    public static By createDynamicListBtn = By.xpath("//button[text()='Create Dynamic List']");
    public static By createDynamicListPopupHeader = By.xpath("//div[@class='modal-title']//h1");
    public static By nameFieldValidationMeesage = By.xpath("//span[@class='field__error']");
    public static By saveDynamicListBttn = By.xpath("//button[text()='Save Dynamic List']");
    public static By nameField = By.xpath("//input[@name='listName']");
    public static By newlyCreatedList = By.xpath("(//div[@class='contact-list-row'])[1]");
    public static By contactTypeDropdown = By.xpath("//label[@class='dropdown__selector__label']");
    public static By contactTypeDropDown2 = By.xpath("(//label[@class='dropdown__selector__label'])[4]");
    public static By submissionCategoryDropdown = By.xpath("//label[@for='selectedCategory']");
    public static By sourceDropdown = By.xpath("//label[@for='contactSource']");
    public static By sourceDropdown2 = By.xpath("(//label[@for='contactSource'])[2]");
    public static By contactTypeDropdownList = By.xpath("//div[@id='ccContactType']/ul/li");
    public static By sourceDropdownList = By.xpath("//div[@id='contactSource']/ul/li");
    public static By contactsButton = By.xpath("//button[text()='Contacts']");
    public static By listsButton = By.xpath("//button[text()='Lists']");

    public static By mergeContactsButton = By.xpath("//button[text()='Merge Contacts']");
    public static By createStaticListButton = By.xpath("//button[text()='Create Static List']");
    public static String contactListCheckBox = "(//span[@class='checkbox-holder']/input)[%s]";
    public static String contactListName = "//span[@class='checkbox-holder']/following::a[%s]";
    public static By createContactButton = By.xpath("(//button[@class='square-btn btn btn-primary'])[2]");
    public static By createContactPopupButton = By.xpath("(//div[@class='full-page-modal__header']//button[2])");
    public static String mergeContactsPopupName = "((//span[text()='Name']/../..)//div[@class='rt-td'])[%s]";
    public static String mergeContactsPopupNameCheckBox = "(((//span[text()='Name']/../..)//div[@class='rt-td'])[%s])//input";
    public static String emailAddressContactsPage = "//span[@class='checkbox-holder']/following::a[%s]/following::div[5]/div";
    public static String emailAddressPopup = "((//span[text()='Email Address']/../..)//div[@class='rt-td'])[%s]";
    public static String emailAddressPopupCheckBox = "(((//span[text()='Email Address']/../..)//div[@class='rt-td'])[%s])//input";
    public static String editButton = "(//span[@class='checkbox-holder']/following::a[%s])/following::button";
    public static By workPhone = By.xpath("//input[@name='workPhone']");
    public static String workPhonePopup = "((//span[text()='Work Phone']/../..)//div[@class='rt-td'])[%s]";
    public static String workPhonePopupCheckBox = "(((//span[text()='Work Phone']/../..)//div[@class='rt-td'])[%s])//input";
    public static By mergeButton = By.xpath("//button[text()='Merge']");
    public static By contactsCount = By.xpath("//span[@class='contacts-heading']");
    public static By searchFieldContactsPage = By.xpath("(//input[@type='TEXT'])[2]");
    public static By editButtonSearch = By.xpath("(//span[@class='checkbox-holder']/following::a)/following::button[1]");
    public static By nameFieldEditContact = By.xpath("//input[@name='name']");
    public static By emailFieldEditContact = By.xpath("//input[@name='email']");
    public static By staticListButton = By.xpath("//button[text()='Create Static List']");
    public static By listCounts = By.xpath("//div[@class='contact-listing__section__header']");
    public static By contactsListButton = By.xpath("//button[text()='Contacts']");
    public static By staticListName = By.xpath("//div[@class='contact-list-row']");

    public static By CEMOptions = By.xpath("//label[@for='Source-1']");
    public static By CEMOptions2 = By.xpath("((//label[@for='Source-1'])[2]/..)//input");
    public static By CRMOptions = By.xpath("//label[@for='Source-0']");
    public static By CRMOptions2 = By.xpath("((//label[@for='Source-0'])[2]/..)//input");
    public static By UnspecifiedOptions = By.xpath("//label[@for='Source-2']");
    public static By UnspecifiedOptions2 = By.xpath("((//label[@for='Source-2'])[2]/..)//input");

    public static By individualsContacts = By.xpath("//li[text()='Individuals']");
    public static By legalEntitiesContacts = By.xpath("//li[text()='Legal Entities']");
    public static By anyContacts = By.xpath("//li[text()='Any']");

    public static By individualsContacts2 = By.xpath("(//li[text()='Individuals'])[2]");
    public static By legalEntitiesContacts2 = By.xpath("(//li[text()='Legal Entities'])[2]");
    public static By anyContacts2 = By.xpath("(//li[text()='Any'])[2]");

    public static By informativeMessage = By.xpath("//div[@class='rt-noData']");
    public static By exportCSV = By.xpath("(//div[@class='rt-td'][5])");
    public static By exportCSV2 = By.xpath("(//div[@class='rt-td'][6])/span");

    public static By totalcontactCountOnDynamicPopup = By.xpath("//div[@class='table__pagination flex-row--center']//h4");
    public static By valdiationMessage = By.xpath("//div[@class='notification-message']");

    public static By crossSign = By.xpath("(//span[@class='search__img'])[2]");
    public static By emailAddressContacts = By.xpath("//span[@class='checkbox-holder']/following::a[1]/following::div[5]/div");

    public static By contactType = By.xpath("//div[text()='Contact Type']");
    public static By ContactsHeader = By.xpath("//h2[text()='Contacts']");
    public static By emailAddress = By.xpath("//div[text()='Email Address']");
    public static By address = By.xpath("//div[text()='Address']");
    public static By currentPageNumber = By.xpath("(//input[@type='text'])[1]");
    public static By totalPageNumber = By.xpath("//span[@class='table__pagination-of-text']");
    public static By informtiveMessageEXportCSV = By.xpath("//div[@class='modal-base__body']");
    public static By successMessageExportCSV = By.xpath("//div[@class='success-custom-message']");
    public static By sendButton = By.xpath("//button[text()='Send']");
    public static By downloadFileYopmailBttn = By.xpath("(//div[@id='mail']/div/div/a)");
    public static By loginCheck = By.xpath("//input[@placeholder='Enter Email'][@name='email']");

    public static Boolean ToggleButtonState;

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();
    }

    public void openEditAgencyPopup() throws InterruptedException {
        closeOtherTabs();
        driver.navigate().to(BrowsersInvoked.AdminURL);
        waitForCurserRunning(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int lginCheck = driver.findElements(loginCheck).size();
        if (lginCheck > 0) {
            log.LoginAdmin();
            waitUntilElementIsVisible(AgencySearchField);
        }
        String AgencyID = Integer.toString(BrowsersInvoked.AgencyID);
        System.out.println("AgencyID : " + AgencyID);
        waitUntilElementIsVisible(AgencySearchField);
        scrollIntoView(AgencySearchField);
        waitForElementIsInteractable(AgencySearchField);
        sendKeysWithWait(AgencySearchField, AgencyID);
        waitUntilElementIsVisible(By.xpath(AgencyNameGrid(AgencyID)));
        waitForElementIsInteractable(EditAgencyIcon);
        clickByJsExecuter(EditAgencyIcon);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(editAgencyHeader);
    }

    public void editAndConfigureCRMPopup() {
        waitUntilElementIsVisible(editCRMButton);
        scrollIntoView(editCRMButton);
        waitForElementIsInteractable(editCRMButton);
        clickOn(editCRMButton);
        waitUntilElementIsVisible(editAndConfigureCRMHeader);
    }

    public void commlink_prerequiste(String commlinkFeatureFlag, String commlinkEnterprise) throws InterruptedException {
        if (commlinkFeatureFlag.equalsIgnoreCase("ON")) {
            waitForElementIsInteractable(commlinkFeatureFlagONToggle);
            clickOn(commlinkFeatureFlagONToggle);
        } else {
            waitForElementIsInteractable(commlinkFeatureFlagOffToggle);
            clickOn(commlinkFeatureFlagOffToggle);
        }

        if (commlinkEnterprise.equalsIgnoreCase("ON")) {
            editAndConfigureCRMPopup();
            waitForElementIsInteractable(commlinkEnterPriseONToggle);
            scrollIntoView(commlinkEnterPriseONToggle);
            clickOn(commlinkEnterPriseONToggle);
            waitForElementIsInteractable(commlinkEnterpriseSaveBttn);
            clickOn(commlinkEnterpriseSaveBttn);
            waitForCurserRunning(3);

        } else {
            editAndConfigureCRMPopup();
            waitForElementIsInteractable(commlinkEnterPriseOffToggle);
            scrollIntoView(commlinkEnterPriseOffToggle);
            clickOn(commlinkEnterPriseOffToggle);
            waitForElementIsInteractable(commlinkEnterpriseSaveBttn);
            clickOn(commlinkEnterpriseSaveBttn);
            waitForCurserRunning(3);
        }

        waitForElementIsInteractable(saveButton);
        clickOn(saveButton);
        waitForCurserRunning(3);

    }


    public void naviateToContact() throws InterruptedException {
        forcedWaitTime(5);
        try {
            driver.navigate().to(BrowsersInvoked.URLContacts);
            waitForCurserRunning(5);
            forcedWaitTime(2);
            driver.navigate().refresh();
        } catch (TimeoutException e) {
            driver.navigate().refresh();
            e.printStackTrace();

        }
        waitForCurserRunning(5);
    }

    public void createDynamicListPopup() throws InterruptedException {

        waitForElementIsInteractable(createDynamicListBtn);
        clickOn(createDynamicListBtn);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(createDynamicListPopupHeader);
    }

    public Boolean checkButtonIsEnabled(By locator) throws InterruptedException {
        String GetClass = waitUntilVisibleWE(locator).getAttribute("class");
        Boolean status = GetClass.equals("square-btn btn btn-primary");
        return status;
    }

    List<String> contactName = new ArrayList<>();

    public List<String> createContact(int tries) throws InterruptedException {
        for (int i = 0; i < tries; i++) {
            waitForElementIsInteractable(createContactButton);
            clickOn(createContactButton);
            String RandomName = RandomStrings.requiredCharacters(8);
            contactName.add(RandomName);
            String RandomMail = RandomName + "@yopmail.com";
            String RandomContact = RandomStrings.requiredDigits(10);
            sendKeysWithWait(CCPUtility.NameField, RandomName);
            sendKeysWithWait(CCPUtility.EmailField, RandomMail);
            sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);

            waitForCurserRunning(4);
            System.out.println("successfully enter after waitforCurserRunning..... ");
            waitForElementIsInteractable(createContactPopupButton);
            clickOn(createContactPopupButton);
            Thread.sleep(3000);
            waitForCurserRunning(4);
        }
        for (String w : contactName) {
            System.out.println("contacts name :  " + w);
        }
        return contactName;
    }

    public int contactsCount(String st) {
        int value = crmCommonMethod.extractedInteger(st);
        System.out.println(value);
        return value;
    }


    public static String extractSortParams(String urlString) throws Exception {

        URL url = new URL(urlString);

        // it will return the query param
        String query = url.getQuery();


        String sortBy = null;
        String sortOrder = null;


        if (query != null && !query.isEmpty()) {

            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("="); // Split by "=" to get key and value
                if (keyValue.length == 2) {
                    if (keyValue[0].equals("sortBy")) {
                        sortBy = keyValue[1];
                    } else if (keyValue[0].equals("sortOrder")) {
                        sortOrder = keyValue[1];
                    }
                }
            }
        }

        return sortBy + " " + sortOrder;
    }
}
