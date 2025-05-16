package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.*;
import ExtentReport.ExtentReportClass;
import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static POM.CommLinkUtility.*;

public class CommLinkTest extends BrowsersInvoked {


    ExtentReportClass extentClass;
    CommLinkUtility contactPage;

    
    
    @BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread

        contactPage = new CommLinkUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
    
    
  

    @Test(priority = 0, description = "Login Test Case")
    public void LoginTest() throws InterruptedException {
        LoginUtility log = new LoginUtility(getDriver());
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


    @Test(priority = 1, description = "Verify that the 'CommLink Feature Flag' toggle appears 'OFF' after navigating to the 'Edit Agency' page from the 'Agency List' page.")
    public void contacts_verifyThatCommlinkFeatureFlagOFFByDefault() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        helper.waitForCurserRunning(4);
        contactPage.openEditAgencyPopup();
        helper.waitUntilElementIsVisible(commlinkFeatureFlagOffToggle);
        helper.scrollIntoView(commlinkFeatureFlagOffToggle);

        String GetClass = helper.waitUntilVisibleWE(commlinkFeatureFlagOffToggle).getAttribute("class");
        ToggleButtonState = GetClass.equals("square-btn btn btn-primary");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ToggleButtonState);
        softAssert.assertAll();

    }

    @Test(priority = 2, description = "Verify that the 'CommLink Feature Flag' toggle is set to 'OFF' when the 'Edit & Configure CRM' page is loaded.")
    public void contacts_verifyThatCommlinkEnterpriseOffByDefault() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        contactPage.editAndConfigureCRMPopup();
        helper.waitUntilElementIsVisible(commlinkEnterPriseOffToggle);
        helper.scrollIntoView(commlinkEnterPriseOffToggle);

        String GetClass = helper.waitUntilVisibleWE(commlinkEnterPriseOffToggle).getAttribute("class");
        ToggleButtonState = GetClass.equals("square-btn btn btn-primary");

        helper.scrollIntoView(cancelButtonCommlinkEnterprise);
        helper.clickOn(cancelButtonCommlinkEnterprise);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ToggleButtonState);
        softAssert.assertAll();


    }

    @Test(priority = 3, description = "Verify that the 'Create Dynamic List' option appears after navigating to the 'Contacts' page")
    public void contacts_verifyThatCreateDynamicListOptionAppear() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        contactPage.commlink_prerequiste("ON", "OFF");
        contactPage.naviateToContact();
        helper.waitUntilElementIsVisible(createDynamicListBtn);

        SoftAssert st = new SoftAssert();
        st.assertTrue(helper.findElementsSize(createDynamicListBtn) > 0, "create dynamic list button doesnot appear");
        st.assertAll();
    }


    @Test(priority = 4, description = "Verify that create DynamicList popup opensup and validaion message should appear ")
    public void contacts_verifyThatCreateDynamicListPopupOpensUpAndValidationMessage() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.waitForElementIsInteractable(createDynamicListBtn);
        helper.clickOn(createDynamicListBtn);
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(createDynamicListPopupHeader);

        String actualHeaderTxt = helper.getTextElement(createDynamicListPopupHeader);
        helper.waitUntilElementIsVisible(createDynamicListPopupHeader);
        helper.scrollIntoView(createDynamicListPopupHeader);
        helper.clickOn(saveDynamicListBttn);
        helper.waitUntilElementPresent(nameFieldValidationMeesage);
        String nameFieldValidaionText = helper.getTextElement(nameFieldValidationMeesage);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeaderTxt, "Create Dynamic List", "create dynamic list button doesnot appear");
        st.assertEquals(nameFieldValidaionText, "The List Name is required.", "validation message doesnot Match");
        st.assertAll();

    }

    @Test(priority = 5, enabled = true, description = "Verify that 'Create Dynamic List' popup closes after clicking 'Cancel' button on 'Create Dynamic List' popup, on 'Contacts' page.")
    public void contacts_verifyThatPopupGetsClosedafterClickingOnCancelBttn() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.scrollIntoView(cancelButton);
        helper.waitForElementIsInteractable(cancelButton);
        helper.clickOn(cancelButton);

        Boolean value = helper.findElementsSize(createDynamicListPopupHeader) > 0;
        System.out.println(value);
        SoftAssert st = new SoftAssert();
        st.assertFalse(value, "Dynamic List popup header appears");
        st.assertAll();

    }

    String name;

    @Test(priority = 6, enabled = true, description = "Verify that a dynamic list is created when the user clicks on 'Save Dynamic list', after the user has filled the 'Name' field, on 'Create Dynamic list' popup")
    public void contacts_verifyThatUserIsAbleToCreateDynamicList() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        name = RandomStrings.requiredString(5);
        contactPage.createDynamicListPopup();
        helper.sendKeysWithWait(nameField, name);
        helper.waitForElementIsInteractable(saveDynamicListBttn);
        helper.clickOn(saveDynamicListBttn);
        helper.waitForCurserRunning(3);
        String actualRowName = helper.getTextElement(newlyCreatedList);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualRowName, name, "list name doesnot match");
        st.assertAll();

    }

    List<String> contactList = Arrays.asList("Any", "Individuals", "Legal Entities");
    List<String> sourceList = Arrays.asList("CRM", "CEM", "Unspecified");

    @Test(priority = 7, enabled = true, description = "Verify that dropdown options appears after clicking 'Create Dynamic List' popup, on 'Contacts' page.")
    public void contacts_verifyThatFollowingFilterAppearOnDynamicListPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        contactPage.createDynamicListPopup();

        String actualcontactType = helper.getTextElement(contactTypeDropdown);
        String actualcategoryDropdown = helper.getTextElement(submissionCategoryDropdown);
        String actualsourceDown = helper.getTextElement(sourceDropdown);

        helper.clickOn(contactTypeDropdown);

        List<String> contactEleList = helper.getElementTextList(contactTypeDropdownList);
        System.out.println(contactEleList.size());
        for (String a : contactEleList) {
            // print the data present in the contact list
            System.out.println(a);
        }

        helper.waitForElementIsInteractable(sourceDropdown);
        helper.clickOn(sourceDropdown);

        List<String> sourceEleList = helper.getElementTextList(sourceDropdownList);
        System.out.println(sourceEleList.size());
        for (String a : sourceEleList) {
            // print the data present in the source list
            System.out.println(a);
        }

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualcontactType, "Contact Type", "Contact Type name doesnot match");
        st.assertEquals(actualcategoryDropdown, "Submission Category", "Submission Category name doesnot match");
        st.assertEquals(actualsourceDown, "Source", "Source Type name doesnot match");

        st.assertTrue(contactEleList.equals(contactList), "contacts list element doesnot match");
        st.assertTrue(sourceEleList.equals(sourceList), "source list element doesnot match");
        st.assertAll();

        helper.clickOn(cancelButton);
        helper.waitForCurserRunning(3);
    }


    @Test(priority = 7, enabled = true, description = "Verify that 'Create Static List' and 'Merge Contacts' buttons appear disabled when no contacts are selected, on 'Contacts' page.")
    public void contacts_verifyThatStaticListAndContactButtonAppearDisabled() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        helper.clickOn(contactsButton);
        helper.waitUntilElementIsVisible(mergeContactsButton);

        WebElement ele1 = helper.findElement(mergeContactsButton);
        WebElement ele2 = helper.findElement(createStaticListButton);
        System.out.println(ele1.isEnabled());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(ele1.isEnabled(), "state of staticListButton is enabled");
        softAssert.assertFalse(ele2.isEnabled(), "state of mergeContacts is enabled");
        softAssert.assertAll();
    }

    int TotalcaseCount;
    List<String> newlyCreatedContacts = new ArrayList<>();
    List<String> list = new ArrayList<>();
    List<String> emailContactsPage = new ArrayList<>();
    List<String> phoneNum = new ArrayList<>();

    @Test(priority = 8, enabled = true, description = "Verify that 'Merge Contacts' button appear enabled, after clicking, when user has selected more than 1 upto 3 contacts, on 'Contacts' page.  ")
    public void contacts_verifyThatMergeContactsButtonAppearEnabled() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        // create new contact which consist the mobile number and email
        newlyCreatedContacts = contactPage.createContact(4);
        for (String w : newlyCreatedContacts) {
            System.out.println("contacts name :  " + w);
        }

        String totalContactCount = helper.getTextElement(contactsCount);
        TotalcaseCount = contactPage.contactsCount(totalContactCount);

        WebElement ele1 = helper.findElement(mergeContactsButton);

        Boolean beforecheck, aftercheck;
        // iteratrate from 1 to 4 checkbox to see that the button doesnot appear enabled
        for (int i = 1; i <= 3; i++) {
            String temp = Integer.toString(i);
            helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, temp)));
            String st = helper.getTextElement(By.xpath(helper.stringFormat(contactListName, temp)));
            String email = helper.getTextElement(By.xpath(helper.stringFormat(emailAddressContactsPage, temp)));
            list.add(st);
            emailContactsPage.add(email);
        }

        for (int i = 1; i <= 3; i++) {
            String temp = Integer.toString(i);
            helper.clickOn(By.xpath(helper.stringFormat(editButton, temp)));
            helper.forcedWaitTime(3);
            helper.waitForElementIsInteractable(workPhone);
            String workPhonetxt = helper.getValueAttribute(workPhone);
            System.out.println("workPhoneTxt: " + workPhonetxt);
            if (workPhonetxt.equals(" ")) {
                String txt = (workPhonetxt.replace(" ", "-"));
                System.out.println("txt : " + txt);
                phoneNum.add(txt);
            } else {
                phoneNum.add(workPhonetxt);
            }
            helper.clickOn(cancelButton);
        }

        beforecheck = ele1.isEnabled();
        System.out.println(beforecheck);
        for (String w : phoneNum) {
            System.out.println("print phoneNumber : " + w);
        }
        for (String w : list) {
            System.out.println("print list of ele: " + w);
        }
        for (String w : emailContactsPage) {
            System.out.println("print  email ele: " + w);
        }
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, "4")));
        helper.forcedWaitTime(2);

        aftercheck = ele1.isEnabled();
        System.out.println("after check: " + aftercheck);
        SoftAssert st = new SoftAssert();
        st.assertTrue(beforecheck, "merge contact button is not enabled");
        st.assertFalse(aftercheck, "merge contact button is  enabled");
        st.assertAll();


    }

    List<String> mergeContactsName = new ArrayList<>();
    List<String> mergeContactsEmail = new ArrayList<>();
    List<String> mergeContactsWorkPhone = new ArrayList<>();

    @Test(priority = 9, enabled = true, description = "Verify that selected contacts appears under 'Merge Contacts' popup, after clicking the 'Merge Contacts' button, when more than 1 upto 3 contacts are selected, on 'Contacts' page.")
    public void contacts_verifyThatSelectedContactsAppearUnderMergeContactsPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());


        // again click on 4th checkbox for activate the merge contact button.
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, "4")));
        helper.waitForElementIsInteractable(mergeContactsButton);
        helper.clickByJsExecuter(mergeContactsButton);
        for (int i = 2; i < 5; i++) {
            String temp = Integer.toString(i);
            String st = helper.getTextElement(By.xpath(helper.stringFormat(mergeContactsPopupName, temp)));
            String email = helper.getTextElement(By.xpath(helper.stringFormat(emailAddressPopup, temp)));
            String workPhone = helper.getTextElement(By.xpath(helper.stringFormat(workPhonePopup, temp)));
            mergeContactsName.add(st);
            mergeContactsEmail.add(email);
            mergeContactsWorkPhone.add(workPhone);
        }

        for (String w : mergeContactsName) {
            System.out.println("selected contacts: " + w);
        }
        for (String w : mergeContactsEmail) {
            System.out.println("selected emails: " + w);
        }
        for (String w : mergeContactsWorkPhone) {
            System.out.println("selected contacts: " + w);
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(list.equals(mergeContactsName), " contacts name mismatched");
        softAssert.assertTrue(emailContactsPage.equals(mergeContactsEmail), " emails  mismatched");
        softAssert.assertTrue(phoneNum.equals(mergeContactsWorkPhone), " phone number  mismatched");
        softAssert.assertAll();
    }


    @Test(priority = 10, enabled = true, description = "Verify that the contacts gets merged into one after clicking Merge button, after selecting checkboxes as per requirements, on 'Merge Contacts' popup.")
    public void contacts_verifyThatAllContactsMergedIntoSingleContact() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        String name = helper.getTextElement(By.xpath(helper.stringFormat(mergeContactsPopupName, "2")));
        System.out.println("merge contact popup name: " + name);
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(emailAddressPopupCheckBox, "3")));
        String email = helper.getTextElement(By.xpath(helper.stringFormat(emailAddressPopup, "3")));
        System.out.println("merge contact popup email: " + email);
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(workPhonePopupCheckBox, "4")));
        String phone = helper.getTextElement(By.xpath(helper.stringFormat(workPhonePopup, "4")));
        System.out.println("merge contact popup workPhone: " + phone);


        helper.waitForElementIsInteractable(mergeButton);
        helper.clickOn(mergeButton);
        helper.waitForCurserRunning(3);

        String totalContactCount = helper.getTextElement(contactsCount);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.sendKeysWithWait(searchFieldContactsPage, name);
        helper.waitForCurserRunning(3);
        helper.waitForElementIsInteractable(editButtonSearch);
        helper.clickOn(editButtonSearch);
        helper.waitForCurserRunning(3);


        String actualnameTxt = helper.getValueAttribute(nameFieldEditContact);
        String actualemailTxt = helper.getValueAttribute(emailFieldEditContact);
        String workPhoneTxt = helper.getValueAttribute(workPhone);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualnameTxt, name, "name does not match");
        st.assertEquals(actualemailTxt, email, "email does not match");
        st.assertEquals(workPhoneTxt, phone, "phone number does not match");
        st.assertEquals(actualTotalcaseCount, TotalcaseCount - 2, "case count doesnot match");
        st.assertAll();

        helper.clickOn(cancelButton);
        helper.waitForCurserRunning(3);
    }


    int listCount;

    @Test(priority = 11, enabled = true, description = "Verify that appropriate validation message appears, after clicking 'Save' button, when the user has named the list with the already existing list name, on 'Create Static List' popup.")
    public void contacts_verifyThatValidationMessageAppearsAfterClickingONSaveBttnOnStaticPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clearByJSE(searchFieldContactsPage);
        helper.waitForCurserRunning(3);

        helper.clickOn(listsButton);
        helper.waitForCurserRunning(3);

        listCount = contactPage.contactsCount(helper.getTextElement(listCounts));
        System.out.println("list count" + listCount);

        helper.clickOn(contactsListButton);
        helper.waitForCurserRunning(3);

        for (int i = 1; i <= 3; i++) {
            String temp = Integer.toString(i);
            helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, temp)));
        }

        helper.clickOn(createStaticListButton);
        helper.waitUntilElementPresent(createDynamicListPopupHeader);
        helper.clickOn(saveButton);

        String actualValidationMessage = helper.getTextElement(nameFieldValidationMeesage);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualValidationMessage, "The List Name is required.", "Validation Message is not same");
        st.assertAll();

    }

    @Test(priority = 12, enabled = true, description = "Verify that a 'Static list' is created, after clicking 'Save Static list' when 1 or more contacts are selected on 'Contacts' page.")
    public void contacts_verifyThatUserIsAbleToSaveTheStaticList() throws InterruptedException {
        Helper helper = new Helper(getDriver());
        String listName = RandomStrings.requiredString(4);
        helper.sendKeysWithWait(nameField, listName);
        helper.clickOn(saveButton);
        helper.waitForCurserRunning(3);
        int actualcount = contactPage.contactsCount(helper.getTextElement(listCounts));
        System.out.println("actual count" + actualcount);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualcount, listCount + 1, "count of list is not matched");
        st.assertEquals(helper.getTextElement(staticListName), listName, "name of created list is not matched");
        st.assertTrue(helper.findElementsSize(exportCSV) > 0, "export csv is not visible ");
        st.assertAll();

        helper.clickOn(contactsListButton);
        helper.waitForCurserRunning(3);
    }

    @Test(priority = 13, enabled = true, description = "Verify that only contacts associated with CEM are displayed when the user selects the CEM option from the source filter, on 'Contacts' page.")
    public void contacts_verifyThatContactsAssociatedWithCEMIsDisplayed() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        String totalContactCount = helper.getTextElement(contactsCount);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(CEMOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CEMOptions);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(contactsCount);
        int actualTotalcaseCountCEM = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountCEM);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountCEM < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

    }

    @Test(priority = 14, enabled = true, description = "Verify that only contacts associated with CRM are displayed when the user selects the CRM option from the source filter, on 'Contacts' page.")
    public void contacts_verifyThatContactsAssociatedWithCRMIsDisplayed() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(CEMOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CEMOptions);

        helper.waitForCurserRunning(3);
        String totalContactCount = helper.getTextElement(contactsCount);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(CRMOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CRMOptions);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(contactsCount);
        int actualTotalcaseCountCRM = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountCRM);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountCRM < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

    }

    @Test(priority = 15, enabled = true, description = "Verify that only contacts not associated with CEM and CRM are displayed when the user selects the \"Unspecified\" option from the source filter, on 'Contacts' page.")
    public void contacts_verifyThatContactsAssociatedWithUnspecifiedIsDisplayed() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(CRMOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CRMOptions);

        helper.waitForCurserRunning(3);
        String totalContactCount = helper.getTextElement(contactsCount);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(UnspecifiedOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(UnspecifiedOptions);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(contactsCount);
        int actualTotalcaseCountUnspecified = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountUnspecified);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountUnspecified < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

        helper.clickOn(sourceDropdown);
        helper.waitForElementIsInteractable(UnspecifiedOptions);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(UnspecifiedOptions);

    }

    String totalContactCount;
    int actualTotalcaseCount;

    @Test(priority = 16, enabled = true, description = "Verify that only contacts with Contact Type 'Individuals' are displayed when the user selects the 'Individuals' option on the 'Contacts' page.")
    public void contacts_verifyThatIndividualsContactTypeAppears() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.waitForCurserRunning(3);
        totalContactCount = helper.getTextElement(contactsCount);
        actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(contactTypeDropdown);
        helper.waitForElementIsInteractable(individualsContacts);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(individualsContacts);


        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(contactsCount);
        int actualTotalcaseCountIndividuals = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountIndividuals);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountIndividuals < actualTotalcaseCount, "count is mismatched");
        st.assertAll();


    }

    @Test(priority = 17, enabled = true, description = "Verify that only contacts with Contact Type 'Legal Entities' are displayed when the user selects the 'Legal Entities' option on the 'Contacts' page.")
    public void contacts_verifyThatLegalEntitiesContactTypeAppears() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(contactTypeDropdown);
        helper.waitForElementIsInteractable(legalEntitiesContacts);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(legalEntitiesContacts);


        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(contactsCount);
        int actualTotalcaseCountIndividuals = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountIndividuals);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountIndividuals < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

        helper.clickOn(contactTypeDropdown);
        helper.waitForElementIsInteractable(anyContacts);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(anyContacts);

    }

    @Test(priority = 18, enabled = true, description = "Verify that the relevant contact appears in the list after searching for a contact in the search bar, on the 'Contacts' page.")
    public void contacts_verifyThatAppropriateResultShouldAppear() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        String actualTxt = helper.getTextElement(By.xpath(helper.selectorFormate(contactListName, "1")));
        System.out.println(actualTxt);

        helper.sendKeysWithWait(searchFieldContactsPage, actualTxt);
        helper.waitForCurserRunning(3);

        String expectedTxt = helper.getTextElement(By.xpath(helper.selectorFormate(contactListName, "1")));
        System.out.println(expectedTxt);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualTxt, expectedTxt, "search is mismatched");
        st.assertAll();
    }

    @Test(priority = 18, enabled = true, description = "Verify appropriate information mesage appears in the contact list after searching for a non existing contact in the search bar, on the 'Contacts' page.")
    public void contacts_verifyThatNoDatashouldAppearAfterSearchTheNonExistingData() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clearByJSE(searchFieldContactsPage);
        helper.waitForCurserRunning(3);
        helper.sendKeysWithWait(searchFieldContactsPage, "Anonymous");
        helper.waitForCurserRunning(3);
        helper.waitUntilElementPresent(informativeMessage);
        String actualTxt = helper.getTextElement(informativeMessage);

        String total = helper.getTextElement(contactsCount);
        int actualTotalCount = contactPage.contactsCount(total);
        System.out.println("actualTotalCount: " + actualTotalCount);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualTxt, "No contacts to display", "Contact appears ");
        st.assertEquals(actualTotalCount, 0, "count doesnot match");
        st.assertAll();

        helper.waitForElementIsInteractable(crossSign);
        helper.clearByJSE(searchFieldContactsPage);
//        helper.clickOn(crossSign);
        helper.waitForCurserRunning(3);
        helper.refreshPage();
        helper.waitForCurserRunning(3);
        helper.clickOn(createDynamicListBtn);

    }

    @Test(priority = 19, enabled = true, description = "Verify that only contacts associated with CEM are displayed when the user selects the CEM option from the source filter on the \"Create Dynamic Lists\" pop-up.")
    public void contacts_verifyThatContactsAssociatedWithCEMIsDisplayedonDynamicPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.forcedWaitTime(3);
        String totalContactCount = helper.getTextElement(totalcontactCountOnDynamicPopup);
        System.out.println("totalContactCount: " + totalContactCount);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(CEMOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CEMOptions2);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCountCEM = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountCEM);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountCEM < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

    }

    @Test(priority = 20, enabled = true, description = "Verify that only contacts associated with CRM are displayed when the user selects the CRM option from the source filter on the \"Create Dynamic Lists\" pop-up.")
    public void contacts_verifyThatContactsAssociatedWithCRMIsDisplayedonDynamicPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(CEMOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CEMOptions2);

        helper.waitForCurserRunning(3);
        String totalContactCount = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(CRMOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CRMOptions2);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCountCRM = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountCRM);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountCRM < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

    }

    @Test(priority = 21, enabled = true, description = "Verify that only contacts not associated with CEM and CRM are displayed when the user selects the \"Unspecified\" option from the source filter on the \"Create Dynamic Lists\" pop-up.")
    public void contacts_verifyThatContactsAssociatedWithUnspecifiedIsDisplayedonDynamicPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(CRMOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CRMOptions2);

        helper.waitForCurserRunning(3);
        String totalContactCount = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcaseCount);

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(UnspecifiedOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(UnspecifiedOptions2);

        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCountUnspecified = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountUnspecified);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountUnspecified < actualTotalcaseCount, "count is mismatched");
        st.assertAll();

        helper.clickOn(sourceDropdown2);
        helper.waitForElementIsInteractable(UnspecifiedOptions2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(UnspecifiedOptions2);

    }

    String totalContactsCount = " ";
    int actualTotalcasesCount = 0;

    @Test(priority = 22, enabled = true, description = "Verify that only contacts with Contact Type 'Individuals' are displayed when the user selects the 'Individuals' option on the 'Create Dynamic Lists' pop-up.")
    public void contacts_verifyThatIndividualsContactTypeAppearsonDynamicPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.waitForCurserRunning(3);
        totalContactsCount = helper.getTextElement(totalcontactCountOnDynamicPopup);
        actualTotalcasesCount = contactPage.contactsCount(totalContactCount);
        System.out.println("actualTotalcaseCount: " + actualTotalcasesCount);

        helper.clickOn(contactTypeDropDown2);
        helper.waitForElementIsInteractable(individualsContacts2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(individualsContacts2);


        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCountIndividuals = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountIndividuals);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountIndividuals < actualTotalcasesCount, "count is mismatched");
        st.assertAll();


    }

    @Test(priority = 23, enabled = true, description = "Verify that only contacts with Contact Type 'Legal Entities' are displayed when the user selects the 'Legal Entities' option on the 'Create Dynamic Lists' pop-up.")
    public void contacts_verifyThatLegalEntitiesContactTypeAppearsonDynamicPopup() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(contactTypeDropDown2);
        helper.waitForElementIsInteractable(legalEntitiesContacts2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(legalEntitiesContacts2);


        helper.waitForCurserRunning(3);
        String totalContactCount2 = helper.getTextElement(totalcontactCountOnDynamicPopup);
        int actualTotalcaseCountIndividuals = contactPage.contactsCount(totalContactCount2);
        System.out.println("actualTotalcaseCount2: " + actualTotalcaseCountIndividuals);


        SoftAssert st = new SoftAssert();
        st.assertTrue(actualTotalcaseCountIndividuals < actualTotalcasesCount, "count is mismatched");
        st.assertAll();

        helper.waitForElementIsInteractable(contactTypeDropDown2);

        helper.clickOn(contactTypeDropDown2);
        helper.waitForElementIsInteractable(anyContacts2);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(anyContacts2);
        helper.waitForCurserRunning(3);


        helper.clickOn(cancelButton);
        helper.waitForCurserRunning(3);
    }


    @Test(priority = 24, enabled = true, description = "Verify that appropriate validation message appears, after clicking 'Save' button, when the user has named the list with the already existing list name, on 'Create Dynamic List' popup.")
    public void contacts_verifyThatUSerIsNotAbleToCreateDuplicateList() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.clickOn(createDynamicListBtn);
        helper.forcedWaitTime(3);
        helper.sendKeysWithWait(nameField, name);
        helper.clickOn(saveDynamicListBttn);

        helper.waitForElementIsInteractable(valdiationMessage);
        String actualTxt = helper.getTextElement(valdiationMessage);
        System.out.println("actualtxt: " + actualTxt);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualTxt, "A list with given name already exists.", "validation message does not match");
        st.assertAll();
    }

    // CRM toggle is on , and edit agency toggle is off ..
    @Test(priority = 25, enabled = true, description = "Verify that all CommLink features disappear, when the CE toggle is 'OFF' and the CRM toggle is 'ON', on 'Contacts' page.")
    public void contacts_verifyThatCommLinkFeatureDisappearWhenCEtoggleIsOff() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        helper.waitForCurserRunning(4);
        contactPage.openEditAgencyPopup();
        helper.waitUntilElementIsVisible(commlinkFeatureFlagOffToggle);
        helper.scrollIntoView(commlinkFeatureFlagOffToggle);

        contactPage.commlink_prerequiste("OFF", "ON");
        contactPage.naviateToContact();

        SoftAssert st = new SoftAssert();
        st.assertFalse(helper.findElementsSize(createDynamicListBtn) > 0, "create dynamic list bttn is vissible");
        st.assertFalse(helper.findElementsSize(createStaticListButton) > 0, "create static list button is vissible");
        st.assertFalse(helper.findElementsSize(mergeContactsButton) > 0, "merge contact button is vissible");
        st.assertAll();

    }

    @Test(priority = 25, enabled = true, description = "Verify that the 'Merge Contacts' button appears when the user selects more than 1 and up to 3 contacts from the contact list, on 'Contacts' page.")
    public void contacts_verifyThatMergeContactsButtonAppear() throws InterruptedException {
        Helper helper = new Helper(getDriver());

        for (int i = 1; i <= 4; i++) {
            String temp = Integer.toString(i);
            helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, temp)));
        }

        System.out.println(helper.elementIsDisplayed(By.xpath(helper.stringFormat(contactListCheckBox, "4"))));
        SoftAssert st = new SoftAssert();
        st.assertTrue(helper.findElementsSize(mergeContactsButton) > 0);
        st.assertFalse(helper.elementIsDisplayed(By.xpath(helper.stringFormat(contactListCheckBox, "4"))));
        st.assertAll();

        // uncheck the checked box
        for (int i = 1; i <= 3; i++) {
            String temp = Integer.toString(i);
            helper.clickByJsExecuter(By.xpath(helper.stringFormat(contactListCheckBox, temp)));
        }

    }

    @Test(priority = 26, enabled = true, description = "Verify that the 'Contact Type' column gets sorted, after clicking the Sorting icon in the 'Contact Type' column, on 'Contacts page.")
    public void contacts_verifyThatContactTypeListSortedinASC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .
//        contactPage.naviateToContact();
        helper.waitForCurserRunning(5);

        helper.waitUntilElementIsVisible(ContactsHeader);


        helper.clickOn(contactType);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "contactType", "contactype ");
        st.assertEquals(arr[1], "ASC", "asscending order");
        st.assertAll();


    }

    @Test(priority = 27, enabled = true, description = "Verify that the 'Contact Type' column gets sorted, after clicking the Sorting icon in the 'Contact Type' column, on 'Contacts page.")
    public void contacts_verifyThatContactTypeListSortedinDESC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .

        helper.waitUntilElementIsVisible(ContactsHeader);
        helper.clickByJsExecuter(contactType);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "contactType", "contactype ");
        st.assertEquals(arr[1], "DESC", "descending order");
        st.assertAll();

    }

    @Test(priority = 28, enabled = true, description = "Verify that the 'Email Address' column gets sorted, after clicking the Sorting icon in the 'Email Address' column.")
    public void contacts_verifyThatEmailTypeListSortedinASC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .

        helper.waitUntilElementIsVisible(ContactsHeader);

        helper.clickOn(emailAddress);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "email", "email type sorting ");
        st.assertEquals(arr[1], "ASC", "asscending order");
        st.assertAll();


    }

    @Test(priority = 29, enabled = true, description = "Verify that the 'Email Address' column gets sorted, after clicking the Sorting icon in the 'Email Address' column.")
    public void contacts_verifyThatEmailTypeListSortedinDESC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .

        helper.waitUntilElementIsVisible(ContactsHeader);
        helper.clickByJsExecuter(emailAddress);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "email", "email type sorting ");
        st.assertEquals(arr[1], "DESC", "descending order");
        st.assertAll();

    }


    @Test(priority = 30, enabled = true, description = "Verify that the 'Address' column gets sorted, after clicking the Sorting icon in the 'Address' column, on 'Contacts' page.")
    public void contacts_verifyThatAddressTypeListSortedinASC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .

        helper.waitUntilElementIsVisible(ContactsHeader);

        helper.clickByJsExecuter(address);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "address", "address type sorting ");
        st.assertEquals(arr[1], "ASC", "asscending order");
        st.assertAll();


    }

    @Test(priority = 31, enabled = true, description = "Verify that the 'Address' column gets sorted, after clicking the Sorting icon in the 'Address' column, on 'Contacts' page.")
    public void contacts_verifyThatAddressTypeListSortedinDESC() throws Exception {
        Helper helper = new Helper(getDriver());

        // in this test case we just simply break down the current url that asscending or descending order functionality work properly .

        helper.waitUntilElementIsVisible(ContactsHeader);
        helper.clickByJsExecuter(address);
        helper.waitForCurserRunning(3);
        String url = getDriver().getCurrentUrl();
        System.out.println("url :" + url);


        String extractedTxt = contactPage.extractSortParams(url);
        System.out.println(extractedTxt);

        String arr[] = extractedTxt.split(" ");

        SoftAssert st = new SoftAssert();
        st.assertEquals(arr[0], "address", "address type sorting ");
        st.assertEquals(arr[1], "DESC", "descending order");
        st.assertAll();

    }

    String secondContact;

    @Test(priority = 32, enabled = true, description = "Verify that the user is able to navigate through pages after clicking the 'Next' and 'Previous' arrow icons of pagination, on 'Contacts' page.")
    public void contacts_verifyThatUserISAbleToNavigateToNextPageUsingNavigation() throws Exception {
        Helper helper = new Helper(getDriver());
        CLPUtility clpUtility = new CLPUtility(getDriver());
        contactPage.naviateToContact();

        helper.waitForCurserRunning(5);

        String firstContact = helper.getTextElement(By.xpath(helper.stringFormat(contactListName, "1")));
        System.out.println("firstContact: " + firstContact);

        Boolean checkNext = getDriver().findElement(CLPUtility.NextPagination).isEnabled();

        if (checkNext) {
            helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
            helper.scrollIntoView(CLPUtility.NextPagination);
            helper.waitForElementIsInteractable(CLPUtility.NextPagination);
            helper.clickByJsExecuter(CLPUtility.NextPagination);
            helper.WaitForGridTableEnable();
            helper.waitForCurserRunning(5);
            helper.forcedWaitTime(2);
            secondContact = helper.getTextElement(By.xpath(helper.stringFormat(contactListName, "1")));
            System.out.println("secondContact: " + secondContact);
        }

        helper.waitUntilElementIsVisible(CLPUtility.PreviousPagingation);
        helper.scrollIntoView(CLPUtility.PreviousPagingation);
        helper.waitForElementIsInteractable(CLPUtility.PreviousPagingation);
        helper.clickByJsExecuter(CLPUtility.PreviousPagingation);
        helper.WaitForGridTableEnable();
        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(2);

        String actualfirstContact = helper.getTextElement(By.xpath(helper.stringFormat(contactListName, "1")));
        System.out.println("firstContact: " + actualfirstContact);

        Boolean checkNext2 = getDriver().findElement(CLPUtility.NextPagination).isEnabled();
        String actualsecondContact = "";
        if (checkNext2) {
            helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
            helper.scrollIntoView(CLPUtility.NextPagination);
            helper.waitForElementIsInteractable(CLPUtility.NextPagination);
            helper.clickByJsExecuter(CLPUtility.NextPagination);
            helper.WaitForGridTableEnable();
            helper.waitForCurserRunning(5);
            helper.forcedWaitTime(2);
            actualsecondContact = helper.getTextElement(By.xpath(helper.stringFormat(contactListName, "1")));
            System.out.println("secondContact: " + actualsecondContact);
        }


        SoftAssert st = new SoftAssert();
        st.assertEquals(actualfirstContact, firstContact, "first contact is not same");
        st.assertEquals(actualsecondContact, secondContact, "second contact is not same");
        st.assertAll();

    }

    @Test(priority = 33, enabled = true, description = "Verify that 'Export CSV' popup opensup with a information message, after clicking 'Export Csv' download link, on 'List' page. ")
    public void contacts_verifyThatUserExportCSVPopupOpensUp() throws Exception {
        Helper helper = new Helper(getDriver());

        contactPage.openEditAgencyPopup();
        contactPage.commlink_prerequiste("ON","ON");
        contactPage.naviateToContact();
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(createDynamicListBtn);

        helper.clickOn(listsButton);
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(exportCSV2);
        helper.waitForElementIsInteractable(exportCSV2);
        helper.clickByJsExecuter(exportCSV2);
        helper.waitUntilElementIsVisible(informtiveMessageEXportCSV);

        String actualMessage = helper.getTextElement(informtiveMessageEXportCSV);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualMessage, "We will email you a link to download your CSV.", "Message does not appear");
        st.assertAll();


    }

    @Test(priority = 34, enabled = true, description = "Verify that mail is sent to the logged in user after clicking 'Send' button on 'Export CSV' popup. ")
    public void contacts_verifyThatSuccessMessagesAppearAfterClickingOnExportCSV() throws Exception {
        Helper helper = new Helper(getDriver());

        helper.clickOn(sendButton);
        helper.waitUntilElementIsVisible(successMessageExportCSV);

        String actualMessage = helper.getTextElement(successMessageExportCSV);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualMessage, "Check your email to download the CSV file", "Success Message does not appear");
        st.assertAll();

    }


    @Test(priority = 35, enabled = false, description = "Verify that logged in user is able to download the csv file, after clicking 'Download File' link in mail box")
    public void contacts_verifyThatLoggedInUserIsAbleToDownloadFile() throws Exception {
        // this test case is not to be automated because of robot captcha .
        Helper helper = new Helper(getDriver());
//        String mailId = helper.getTextElement(By.xpath("//label[text()='Customer Email']//following-sibling::label"));
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().navigate().to("https://yopmail.com/en/");
        helper.waitForCurserRunning(4);
        helper.forcedWaitTime(4);
        helper.waitUntilElementIsVisible(CreateCRMUserUtility.YopmailSearchUser);
        helper.waitUntilElementPresent(CreateCRMUserUtility.YopmailSearchUser);
        helper.waitForElementIsInteractable(CreateCRMUserUtility.YopmailSearchUser);
        helper.sendKeysWithWait(CreateCRMUserUtility.YopmailSearchUser, "stageHosted1User@yopmail.com");
        helper.waitForElementIsInteractable(CreateCRMUserUtility.YopmailInboxArrow);
        helper.clickOn(CreateCRMUserUtility.YopmailInboxArrow);
        helper.forcedWaitTime(2);
        getDriver().switchTo().frame("ifmail");
        System.out.println(getDriver().findElement(downloadFileYopmailBttn).isEnabled());
        helper.waitForElementIsInteractable(downloadFileYopmailBttn);
        helper.clickByJsExecuter(downloadFileYopmailBttn);
        helper.forcedWaitTime(4);
        getDriver().switchTo().defaultContent();
        CheckDownloadedFile checkDownloadedFile = new CheckDownloadedFile();
//        System.out.println(CheckDownloadedFile.isFileDownloaded());

    }

    @Test(priority = 36, enabled = true, description = "This test case is just for revert the changes.")
    public void contacts_resetSettings() throws Exception {
        Helper helper = new Helper(getDriver());

        contactPage.openEditAgencyPopup();
        contactPage.commlink_prerequiste("OFF","OFF");

    }

}





