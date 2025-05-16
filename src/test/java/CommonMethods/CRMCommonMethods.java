package CommonMethods;


import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import POM.*;
import TestCases.CCP;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import BrowsersBase.BrowsersInvoked;

import static POM.CCPDirect20Utility.GisDataAddress;
import static POM.CCPUtility.*;
import static POM.CSDPUtility.SubmitAnywayButton;
import static POM.CSPInternalGISDirect20Utility.ExtractedSearchLocationHosted20;
import static POM.CSPInternalUtility.CellPhoneField;
import static POM.CategoryPage.*;
import static POM.CategoryPage.CreateCategoryPopupBtn;
import static POM.CategoryPage.SaveButton;

public class CRMCommonMethods {

	
    public WebDriver driver;
    public Helper helper;
    public CSPExternalUtility cspExternal;
    CECommonMethods ceMethod;

    public CRMCommonMethods(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        cspExternal = new CSPExternalUtility(driver);
//       ceMethod = new CECommonMethods(driver);

    }

    public String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
    public String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");
    public static String searchAPNLocation20 = PropertiesUtils.getPropertyValue("searchAPNLocation20");

    // search on CSLP with Location
    public void searchLocationCSP(String Address) throws InterruptedException {
        helper.waitForElementIsInteractable(CSPInternalUtility.LocationField);
        helper.forcedWaitTime(3);
        System.out.println("Address CSP: -> " + Address);
        helper.sendKeysUsingActions(CSPInternalUtility.LocationField, Address);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.LocationSearchResult);
        helper.waitForElementIsInteractable(CSPInternalUtility.LocationSearchResult);
        helper.forcedWaitTime(4);
        // add on for deugging
        // helper.clickOn(SubmitAnywayButton);
        helper.clickByJsExecuter(CSPInternalUtility.LocationSearchResult);
        helper.forcedWaitTime(3);
        helper.waitForCurserRunning(7);


    }

    public void addAttachmentOnCSDP(String path) throws InterruptedException {
        helper.waitUntilElementIsVisible(CSDPUtility.attachmentDefaultbtn);
        helper.clickOn(CSDPUtility.attachmentDefaultbtn);
        WebElement UploadFile4 = driver.findElement(CSDPUtility.file);
        UploadFile4.sendKeys(path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
        helper.waitForCurserRunning(4);

    }

    public void navigationToNotices() throws InterruptedException {
        navigateToAgencySetup();
        helper.waitForPresenceandVisiblity(NoticesUtility.chngeLogo);
        helper.waitForElementIsInteractable(NoticesUtility.chngeLogo);
        helper.forcedWaitTime(2);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage")) || BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
            helper.waitForPresenceandVisiblity(NoticesUtility.CE);
            helper.scrollIntoView(NoticesUtility.CE);
            helper.waitUntilElementIsVisible(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.clickByJsExecuter(NoticesUtility.CE);
        } else {
            int ceSize = driver.findElements(NoticesUtility.CE).size();
            int ProductDemoSize = driver.findElements(NoticesUtility.ProductDemo).size();
            if (ceSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.CE);
                helper.scrollIntoView(NoticesUtility.CE);
                helper.waitUntilElementPresent(NoticesUtility.CE);
                helper.waitForElementIsInteractable(NoticesUtility.CE);
                helper.clickByJsExecuter(NoticesUtility.CE);
            } else if (ProductDemoSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.ProductDemo);
                helper.scrollIntoView(NoticesUtility.ProductDemo);
                helper.waitUntilElementPresent(NoticesUtility.ProductDemo);
                helper.waitForElementIsInteractable(NoticesUtility.ProductDemo);
                helper.clickByJsExecuter(NoticesUtility.ProductDemo);
            }


        }
        helper.waitForPresenceandVisiblity(NoticesUtility.NoticesPageLink);
        helper.scrollIntoView(NoticesUtility.NoticesPageLink);
        helper.waitForElementIsInteractable(NoticesUtility.NoticesPageLink);
        helper.clickByJsExecuter(NoticesUtility.NoticesPageLink);
        helper.implicitWaitforCustometime(3);
        helper.scrollIntoView(NoticesUtility.AppHeaderIcon);
        helper.waitForPresenceandVisiblity(NoticesUtility.ActiveTab);
    }


    public void navigationToCSP() throws InterruptedException {
        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        Thread.sleep(2000);
        System.out.println("enter in click by js executor");
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CSPPopupTitle);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
    }

    public void navigateToCSLP() throws InterruptedException {
        helper.waitUntilElementIsVisible(CSLPUtility.CSLPTab);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPTab);
        helper.clickByJsExecuter(CSLPUtility.CSLPTab);
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CSLPUtility.CustomerSubmissionsHeader);

    }

    public void navigateToCSP() throws InterruptedException {

            helper.waitForCurserRunning(5);
            helper.refreshPage();
            helper.waitUntilElementIsVisible(CLPUtility.plusButtonHeader);
            helper.waitUntilElementPresent(CLPUtility.plusButtonHeader);
            WebElement CCPBtnJSE = driver.findElement(CLPUtility.plusButtonHeader);
            helper.scrollIntoView(CLPUtility.plusButtonHeader);
            helper.waitForElementInteractable(CCPBtnJSE);
            helper.waitForElementIsInteractable(CLPUtility.plusButtonHeader);
            helper.clickByJsExecuter(CLPUtility.plusButtonHeader);
            helper.waitUntilElementIsVisible(CCPUtility.customerSubmissionButton);
            helper.waitForElementIsInteractable(CCPUtility.customerSubmissionButton);
            helper.clickByJsExecuter(CCPUtility.customerSubmissionButton);
            helper.waitForCurserRunning(10);

    }

    public void searchLocationExternalCS(String Address) throws InterruptedException {
        helper.waitUntilElementPresent(CSPExternalUtility.LocationSearchField);
        helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
        helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
        helper.sendKeysUsingActions(CSPExternalUtility.LocationSearchField, Address);
        helper.forcedWaitTime(4);
        Thread.sleep(4000);
        helper.waitForPresenceandVisiblity(CSPExternalUtility.LocationSearchResult);
//        helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchResult);
        helper.clickByJsExecuter(CSPExternalUtility.LocationSearchResult);
        helper.waitForCurserRunning(5);

    }

    public void creationOf50PlusSubmissions() throws InterruptedException {
        String paraonymous = PropertiesUtils.getPropertyValue("Anonymous");
        List<String> anonymous = Arrays.asList(paraonymous.split(","));

        String paracust = PropertiesUtils.getPropertyValue("Customer");
        List<String> customer = Arrays.asList(paracust.split(","));

        String paratags = PropertiesUtils.getPropertyValue("Tags");
        List<String> tags = Arrays.asList(paratags.split(","));

        String paralocation = PropertiesUtils.getPropertyValue("Location");
        List<String> location = Arrays.asList(paralocation.split(","));

        String parattachments = PropertiesUtils.getPropertyValue("Attachments");
        List<String> attachments = Arrays.asList(parattachments.split(","));


        for (int i = 0; i <= 50; i++) {
            createSubmission(anonymous.get(0), customer.get(0), tags.get(0), location.get(0), attachments.get(0), PropertiesUtils.getPropertyValue("LocationReq"));

        }
    }

    public void switchToAnotherTab(WebDriver driver) {

        System.out.println("enter in function ...");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to open the provided link in a new tab
        try {
            //	String url = "https://app-stage.comcate.com/agencies/212/products/customer-submission/create";
            String url2 = BrowsersInvoked.URLCreateCustomerSubmission;

            js.executeScript("window.open('" + url2 + "');");

            // Switch to the new tab
            // Get the handles of all open windows/tabs
            for (String handle : driver.getWindowHandles()) {
                // Switch to the new tab
                driver.switchTo().window(handle);
            }

        } catch (Exception e) {
            System.out.println("enter in catch ...");

        }

        System.out.println("exit from this function ....");
    }


    public void createSubmission(String Anonymous, String Customer, String Tags, String Location, String Attachment, String CategoryName) throws InterruptedException {
        //driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
        try {
            System.out.println("enteer in try ..");
//            helper.navigatePage(BrowsersInvoked.URLCreateCustomerSubmission);
            navigationToCSP();
            helper.forcedWaitTime(2);
            System.out.println("referesh 1");
//            helper.refreshPage();

            System.out.println("Execute successfully");

        } catch (Exception e) {
            //e.getMessage();
            System.out.println("Exception while rendering.");
            //helper.refreshPage();

        }
        System.out.println("Link .... " + BrowsersInvoked.URLCreateCustomerSubmission);
        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);

        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.sendKeysWithWait(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
        helper.forcedWaitTime(2);
        helper.clickOn(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        By email = By.xpath("//*[@name='email']");

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser.executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            helper.forcedWaitTime(2);
            helper.clickOn(CSPInternalUtility.ContactSearchResults);
            if (helper.getValueAttribute(CellPhoneField).isEmpty()) {
                helper.sendKeysWithWait(CellPhoneField, "12057547399");
            }

            if (helper.getValueAttribute(email).isEmpty()) {
                helper.sendKeysWithWait(email, "a@a.com");
            }

            int Emailcheck = driver.findElements(CSPInternalUtility.emailBtn).size();
            int Textcheck = driver.findElements(CSPInternalUtility.textMsg).size();

            if (Emailcheck == 0) {
                helper.clickOn(CSPInternalUtility.emailCheck);

            }
            if (Textcheck == 0) {
                helper.clickOn(CSPInternalUtility.textCheck);

            }

        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {

            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
                serachLocationCCP(searchLocationKey1O);
            } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod"));
            } else {
                serachLocationCCP(searchLocationKey);
            }
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.findElementsSize(CSPInternalUtility.ToggleChecked) > 0) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.findElementsSize(CSPInternalUtility.reasonForFlagging);
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(CSPInternalUtility.reasonForFlagging, "Unflagged");
                    helper.waitForElementIsInteractable(CSPInternalUtility.unflagAddress);
                    helper.clickOn(CSPInternalUtility.unflagAddress);
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }

            }

        }
        if (Attachment == "Yes") {
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(CSPInternalUtility.file);
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
            helper.forcedWaitTime(3);
            helper.scrollIntoView(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitUntilElementInvisibleLocated(CSPInternalUtility.AddButton);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        //helper.waitUntilElementInvisibleLocated(CSPInternalUtility.CreateSubmissionButton);

        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(2);
        List<WebElement> DuplicateSubsPopup = driver.findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.scrollIntoView(SubmitAnywayButton);
            helper.waitForElementIsInteractable(SubmitAnywayButton);
            helper.forcedWaitTime(1);
            helper.clickByJsExecuter(SubmitAnywayButton);
            helper.waitForCurserRunning(4);
        }

    }


    public void editCaseAssignmentRule() throws InterruptedException {
        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(3);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.scrollIntoView(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.waitForElementIsInteractable(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.forcedWaitTime(2);
        helper.clickOn(SubmissionAssignmentUtility.EditCaseAssingment);
//        helper.waitUntilElementInvisibleLocated(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentPopup);
        helper.waitUntilElementPresent(SubmissionAssignmentUtility.EditAssignmentPopup);
    }

    public void editSubmissionAssignmentRule() throws InterruptedException {
        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(3);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.scrollIntoView(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitForElementIsInteractable(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.clickByJsExecuter(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitUntilElementInvisibleLocated(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentPopup);
        helper.waitUntilElementPresent(SubmissionAssignmentUtility.EditAssignmentPopup);
    }


    public void createSubmissionPreRequisite(String Anonymous, String Customer, String Tags, String Location, String Attachment, String CategoryName) throws InterruptedException {
        helper.forcedWaitTime(2);
        int CheckCancel = driver.findElements(CSPInternalUtility.CancelCreateCase).size();
        if (CheckCancel > 0) {
            helper.scrollIntoView(CSPInternalUtility.CancelCreateCase);
            helper.clickOn(CSPInternalUtility.CancelCreateCase);

        }

        int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            helper.scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
            helper.clickOn(CSPInternalUtility.CloseSubmissionIcon);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.scrollIntoView(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitUntilElementPresent(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.sendKeysWithWait(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.SearchResultsCategory);
        helper.clickByJsExecuter(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser.executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
//            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            helper.sendKeysUsingActions(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            if (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("stage") || (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("Production"))) {
                helper.waitUntilElementIsVisible(CSPInternalUtility.listLabel);
                helper.waitForElementIsInteractable(CSPInternalUtility.listLabel);
                helper.forcedWaitTime(3);
                helper.clickByJsExecuter(CSPInternalUtility.listLabel);
            } else {
                //helper.waitForElementIsInteractable(By.xpath("//div[contains(text(),'automationcomcate')]"));
                //  helper.forcedWaitTime(3);
                // helper.clickByJsExecuter(By.xpath("//div[contains(text(),'automationcomcate')]"));
                helper.waitForElementIsInteractable(CSPInternalUtility.autoWhatever);
                helper.clickByJsExecuter(CSPInternalUtility.autoWhatever);
            }
            if (helper.getValueAttribute(CellPhoneField).isEmpty())
                helper.sendKeysWithWait(CellPhoneField, PropertiesUtils.getPropertyValue("Contact"));

        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {
            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
                System.out.println("Enter in direct2.0........");
                searchLocationCSP(searchLocationKey1O);
            } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                searchLocationCSP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_QA"));
            } else {
                searchLocationCSP(searchLocationKey);
            }
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.findElementsSize(CSPInternalUtility.ToggleChecked) > 0) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.findElementsSize(CSPInternalUtility.reasonForFlagging);
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(CSPInternalUtility.reasonForFlagging, "Unflagged");
                    helper.waitForElementIsInteractable(CSPInternalUtility.unflagAddress);
                    helper.clickOn(CSPInternalUtility.unflagAddress);
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }
            }
        }
        if (Attachment == "Yes") {
            helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);
            helper.waitForElementIsInteractable(CSPInternalUtility.AttachmentIcon);
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(CSPInternalUtility.file);
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
            helper.waitForCurserRunning(5);
            helper.waitForElementIsInteractable(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitForCurserRunning(4);
        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForCurserRunning(5);
        List<WebElement> DuplicateSubsPopup = driver.findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.clickOn(SubmitAnywayButton);
            helper.waitForCurserRunning(5);
        }

    }

    public void createCategory(String Checkbox, String IncludeLoc, String Keywords, String CategoryName) throws InterruptedException {

        driver.navigate().to(BrowsersInvoked.URLCategories);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.forcedWaitTime(3);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);

        if (Checkbox == "Yes") {
            helper.waitForElementIsInteractable(CategoryPage.LocationRequiredCheckbox);
            helper.clickByJsExecuter(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
          //  helper.waitForElementIsInteractable(CategoryUtility.NoLocationToggle);
            try{
                System.out.println("enter in try for category ...");
                helper.waitForElementIsInteractable(CategoryPage.NoLocationToggle);
                helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
            }catch (Exception e){
                System.out.println("in catch of category ");
                helper.forcedWaitTime(3);
                helper.waitForElementIsInteractable(CategoryPage.NoLocationToggle);
                helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
            }
         //   helper.clickByJsExecuter(CategoryUtility.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }
        }
        helper.waitForPresenceandVisiblity(CategoryPage.NameField);
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryPopupBtn);
        helper.scrollIntoView(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }

    }

    public void createCategoryAppPrerequisute(String Checkbox, String IncludeLoc, String Keywords, String CategoryName) throws InterruptedException {

        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.scrollIntoView(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);
        helper.waitForPresenceandVisiblity(CategoryPage.LocationRequiredCheckbox);
        if (Checkbox == "Yes") {
            //  helper.clickOn(CategoryUtility.LocationRequiredCheckbox);
            helper.forcedWaitTime(2);
            helper.clickByJsExecuter(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
            // helper.clickOn(CategoryUtility.NoLocationToggle);
            helper.forcedWaitTime(2);
            helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }
        }
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
    }

    public void createCasCategoryAppPreRequisite(String Checkbox, String IncludeLoc, String Keywords, String CategoryName) throws InterruptedException {

        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.scrollIntoView(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForPresenceandVisiblity(CategoryPage.LocationRequiredCheckbox);
        if (Checkbox == "Yes") {
            //  helper.clickOn(CategoryUtility.LocationRequiredCheckbox);
            helper.forcedWaitTime(2);
            helper.clickByJsExecuter(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
            // helper.clickOn(CategoryUtility.NoLocationToggle);
            helper.forcedWaitTime(2);
            helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }
        }

        helper.waitForElementIsInteractable(AddFieldLink);
        helper.clickOn(AddFieldLink);
        helper.sendKeysWithWait(CategoryPage.labelInputCustomFields, PropertiesUtils.getPropertyValue("CascadingField1"));
        helper.waitForElementIsInteractable(addSecondayCustomField);
        helper.clickOn(addSecondayCustomField);
        helper.scrollIntoView(primaryOptionsDropdown);
        helper.waitForElementIsInteractable(primaryOptionsDropdown);
        helper.clickOn(primaryOptionsDropdown);
        helper.waitForElementIsInteractable(containsDropdownTxt);
        helper.clickOn(containsDropdownTxt);
        helper.sendKeysWithWait(nameFieldSeondaryCustom, PropertiesUtils.getPropertyValue("Color1"));
        helper.sendKeysWithWait(labelFieldSecondaryCustomField, PropertiesUtils.getPropertyValue("Black"));

        helper.scrollIntoView(AddFieldLink1);
        helper.waitForElementIsInteractable(AddFieldLink1);
        helper.forcedWaitTime(3);
        helper.waitForElementIsInteractable(AddFieldLink1);
        helper.clickOn(AddFieldLink1);
        helper.sendKeysWithWait(labelFieldSecondaryCustomField5, PropertiesUtils.getPropertyValue("CascadingField2"));
        helper.waitForElementIsInteractable(addSecondayCustomField2);
        helper.clickOn(addSecondayCustomField2);
        helper.scrollIntoView(primaryOptionsDropdown);
        helper.waitForElementIsInteractable(primaryOptionsDropdown);
        helper.clickOn(primaryOptionsDropdown);
        helper.waitForElementIsInteractable(equalsDropdownTxt);
        helper.clickOn(equalsDropdownTxt);
        helper.sendKeysWithWait(nameFieldSeondaryCustom3, PropertiesUtils.getPropertyValue("Color2"));
        helper.sendKeysWithWait(labelFieldSecondaryCustomField6, PropertiesUtils.getPropertyValue("White"));
        helper.waitForElementIsInteractable(typeDropdownForPicklist);
        helper.clickOn(typeDropdownForPicklist);
        helper.waitForElementIsInteractable(pickListDropdownText);
        helper.clickOn(pickListDropdownText);
        helper.waitUntilElementIsVisible(addValueOnManagePickListPopup);
        helper.clickOn(addValueOnManagePickListPopup);
        helper.waitForElementIsInteractable(pickListOption);
        helper.sendKeysWithWait(pickListOption, PropertiesUtils.getPropertyValue("lightwhite"));
        helper.waitUntilElementIsVisible(addValueOnManagePickListPopup);
        helper.clickOn(addValueOnManagePickListPopup);
        helper.waitForElementIsInteractable(pickListOption2);
        helper.sendKeysWithWait(pickListOption2, PropertiesUtils.getPropertyValue("darkshade"));
        helper.waitForElementIsInteractable(saveBtnOnManagePicklist);
        helper.clickOn(saveBtnOnManagePicklist);

        helper.forcedWaitTime(2);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryPopupBtn);
        helper.clickOn(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
    }

    public void createExternalSubmission(String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {

        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
        String RandomDescription = RandomStrings.requiredString(50);
        helper.waitUntilElementIsVisible(CSPInternalUtility.drpDownLabelCategory);
        helper.scrollIntoView(CSPInternalUtility.drpDownLabelCategory);
        helper.clickOn(CSPInternalUtility.drpDownLabelCategory);
        helper.waitUntilElementIsVisible(CSPInternalUtility.dropdownSearchField);
        helper.sendKeysWithWait(CSPInternalUtility.dropdownSearchField, Category);
        helper.waitUntilElementIsVisible(CSPInternalUtility.optionBlack);
        helper.clickOn(By.xpath("//div[@class='option-black'][contains(text(),'" + Category + "')]"));
        helper.sendKeysWithWait(CSPExternalUtility.IssueDescriptionField, RandomDescription);
        if (Attachment == "Yes") {

            WebElement UploadFile = driver.findElement(CSPInternalUtility.file);
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }
        clickOnIssueDescriptionNextButton();

        String validationMssg = "The location you have entered falls outside the city limits. Please select a location within the city limits to continue";

        if (Category == PropertiesUtils.getPropertyValue("LocationReq") || Category == PropertiesUtils.getPropertyValue("LocationNotRequired")) {

            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
                helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchField);
                helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
                helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
                helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, PropertiesUtils.getPropertyValue("SearchLocation"));
                helper.forcedWaitTime(3);
                helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchResult);
                helper.forcedWaitTime(3);
                helper.clickOn(CSPExternalUtility.LocationSearchResult);
            } else {
                helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchField);
                helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
                helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
                helper.forcedWaitTime(2);
                helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise"));
                helper.forcedWaitTime(4);
                helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchResult);
                helper.forcedWaitTime(4);
                helper.clickOn(CSPExternalUtility.LocationSearchResult);

          }


        }

        clickOnLocationNextButton();
        if (Anonymous == "Yes") {
            helper.waitUntilElementIsVisible(CSPExternalUtility.YesButton);
            helper.scrollIntoView(CSPExternalUtility.YesButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickByJsExecuter(CSPExternalUtility.YesButton);

            helper.waitUntilElementIsVisible(CSPExternalUtility.SubmitButton);
            helper.scrollIntoView(CSPExternalUtility.SubmitButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.SubmitButton);
            helper.clickByJsExecuter(CSPExternalUtility.SubmitButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {

            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.EmailPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.TextMsgPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.TextMsgPreferenceButton);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, "automationcomcate@gmail.com");
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, "+12057547399");
        }


        helper.waitForPresenceandVisiblity(CSPInternalUtility.submissionBtn);
        helper.scrollIntoView(CSPInternalUtility.submissionBtn);
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(CSPInternalUtility.submissionBtn);
        helper.clickByJsExecuter(CSPInternalUtility.submissionBtn);
    }

    public void createExternalSubmissionWithoutLogin(String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {
        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePageNOLogin();
        String RandomDescription = RandomStrings.requiredString(50);
        helper.sendKeysWithWait(CSPExternalUtility.IssueDescriptionField, RandomDescription);
        if (Attachment == "Yes") {
            WebElement UploadFile = driver.findElement(CSPInternalUtility.file);
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }

        helper.clickOn(CSPExternalUtility.NextButton);

        if (Category == PropertiesUtils.getPropertyValue("LocationNotIncluded")) {

            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals(PropertiesUtils.getPropertyValue("LocationNotIncluded"));
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals(PropertiesUtils.getPropertyValue("LocationNotIncluded"))) {
                        AllCategories.click();
                        break;
                    }
                }
            }
        } else if (Category == "Location Required") {

            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals(PropertiesUtils.getPropertyValue("LocationReq"));
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals(PropertiesUtils.getPropertyValue("LocationReq"))) {
                        AllCategories.click();
                        break;
                    }
                }
            }
            helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
            helper.clickOn(CSPExternalUtility.LocationSearchField);
            helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, PropertiesUtils.getPropertyValue("SearchLocation1"));
            helper.clickOn(CSPExternalUtility.LocationSearchResult);
        } else if (Category == PropertiesUtils.getPropertyValue("LocationNotRequired")) {
            helper.waitForPresenceandVisiblity(CSPExternalUtility.SelectedCategory);
            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals(PropertiesUtils.getPropertyValue("LocationNotRequired"));
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals(PropertiesUtils.getPropertyValue("LocationNotRequired"))) {
                        AllCategories.click();
                        break;
                    }
                }
            }
        }
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec2);
        helper.clickOn(CSPExternalUtility.NextButtonSec2);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec3);
        helper.clickOn(CSPExternalUtility.NextButtonSec3);

        if (Anonymous == "Yes") {
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickOn(CSPExternalUtility.YesButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {
            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.EmailPreferenceButton);
            helper.clickOn(CSPExternalUtility.EmailPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.FirstNameField);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, PropertiesUtils.getPropertyValue("Email"));
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, PropertiesUtils.getPropertyValue("Contact"));
        }
        helper.clickOn(CSPExternalUtility.SubmitButton);

    }


    public void createACase() throws InterruptedException {

        helper.forcedWaitTime(4);
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        WebElement CCPBtnJSE = (WebElement) jser.executeScript("return document.querySelector('#header > div.app-header__right > div:nth-child(2) > div.app-header__new')");

        helper.clickOnWE20(CCPBtnJSE);
        helper.clickOn(CCPUtility.CCPOption);
        helper.waitForCurserRunning(8);
        helper.waitForPresenceandVisiblity(CCPUtility.CreateCaseButton);

        addLocation();
        addViolation();
        addContact();
        helper.waitForPresenceandVisiblity(CCPUtility.CreateCaseButton);
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickOn(CCPUtility.CreateCaseButton);
        helper.waitForPresenceandVisiblity(CCPUtility.AssignCaseTo);
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(CCPUtility.AssignCaseTo);
        helper.clickByJsExecuter(CCPUtility.AssignCaseTo);
        helper.waitForElementIsInteractable(CCPUtility.InspectionAssigneeTo);
        helper.clickByJsExecuter(CCPUtility.InspectionAssigneeTo);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
        helper.waitForCurserRunning(7);

    }

    public void addAttachment() throws InterruptedException {
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        WebElement AttachmentIcon = (WebElement) jser.executeScript("return document.querySelector('div.tile-header-container > div > h2 > button')");
        AttachmentIcon.click();
        WebElement UploadFile4 = driver.findElement(CSPInternalUtility.file);
        UploadFile4.sendKeys(System.getProperty("user.dir") + "/TestData/Jellyfish_11zon.jpg");
        helper.clickOn(CCPUtility.AddButton);

    }

    public void serachLocationCCP(String Address) throws InterruptedException {
        helper.waitForElementIsInteractable(LocationSearchField);
        helper.sendKeysWithWait(LocationSearchField, Address);
        helper.waitForPresenceandVisiblity(LocationSearchResult);
        helper.waitForElementIsInteractable(LocationSearchResult);
        helper.clickOn(LocationSearchResult);

    }

    public void addLocation() throws InterruptedException {

        if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
            serachLocationCCP(searchLocationKey1O);
        } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
            serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod"));
        } else {
            serachLocationCCP(searchLocationKey);
        }

    }

    public void addViolation() throws InterruptedException {

        helper.waitForElementIsInteractable(CCPUtility.violationSearch_Box);
        helper.clickByJsExecuter(CCPUtility.violationSearch_Box);
        helper.waitForElementIsInteractable(CCPUtility.violationSearch_Box);
        helper.sendKeysWithWait(CCPUtility.violationSearch_Box, "Wa");
        helper.waitForPresenceandVisiblity(CCPUtility.ViolationsList);
        helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
        helper.clickByJsExecuter(CCPUtility.ViolationsList);
    }

    public void addContact() throws InterruptedException {
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CCPUtility.AddContactField);
        helper.scrollIntoView(CCPUtility.AddContactField);
        helper.waitForElementIsInteractable(CCPUtility.AddContactField);
        helper.forcedWaitTime(5);
        helper.clickOn(CCPUtility.AddContactField);
        helper.forcedWaitTime(4);
        helper.waitForElementIsInteractable(CCPUtility.CreateNewContact);
        helper.clickOn(CCPUtility.CreateNewContact);
        String RandomName = RandomStrings.requiredCharacters(8);
        String RandomMail = RandomName + "@yopmail.com";
        String RandomContact = RandomStrings.requiredDigits(10);
        helper.sendKeysWithWait(CCPUtility.NameField, RandomName);
        helper.sendKeysWithWait(CCPUtility.EmailField, RandomMail);
        helper.sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);

        helper.waitForCurserRunning(4);
        System.out.println("successfully enter after waitforCurserRunning..... ");
        helper.waitForElementIsInteractable(CCPUtility.CreateContactBtn);
        helper.clickOn(CCPUtility.CreateContactBtn);
        helper.forcedWaitTime(3);
        helper.waitForPresenceandVisiblity(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.ApplyButton);
        helper.waitForCurserRunning(4);

    }

    public void closeCaseOnCDP() throws InterruptedException {

        helper.waitForPresenceandVisiblity(PerformInspectionUtility.PerformInsButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.PerformInsButton);
        helper.clickOn(PerformInspectionUtility.PerformInsButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.InvalidVioToggle);
        helper.clickOn(PerformInspectionUtility.InvalidVioToggle);
        helper.waitForElementIsInteractable(PerformInspectionUtility.FooterButton);
        helper.clickOn(PerformInspectionUtility.FooterButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.YesBtnConfirmationPopup);
        helper.clickOn(PerformInspectionUtility.YesBtnConfirmationPopup);

    }

    public void navigateToAgencySetup() throws InterruptedException {
        helper.forcedWaitTime(3);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AppMenuIcon);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
        helper.scrollIntoView(AppPreRequisiteUtility.AppMenuIcon);
        helper.clickByJsExecuter(AppPreRequisiteUtility.AppMenuIcon);

        //	helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.scrollIntoView(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.clickByJsExecuter(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.forcedWaitTime(3);

        helper.waitForCurserRunning(10);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AuditTrial);
        helper.scrollIntoView(AppPreRequisiteUtility.AuditTrial);
    }

    public void navigationToPayment() throws InterruptedException {

        // helper.scrollIntoView();(OnlinePaymentUtility.PaymentSideBar);
        if (!driver.findElement(OnlinePaymentUtility.CitizenPaymentProtal).isDisplayed()) {
            helper.waitUntilElementIsVisible(OnlinePaymentUtility.PaymentSideBar);
            helper.scrollIntoView(OnlinePaymentUtility.PaymentSideBar);
            helper.waitForElementIsInteractable(OnlinePaymentUtility.PaymentSideBar);
            helper.waitForElementIsInteractable(OnlinePaymentUtility.PaymentSideBar);
            helper.clickByJsExecuter(OnlinePaymentUtility.PaymentSideBar);

        }
        helper.waitForPresenceandVisiblity(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.scrollIntoView(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.clickByJsExecuter(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.waitForCurserRunning(4);
        helper.implicitWaitforCustometime(3);
        helper.scrolltoUp();
    }

    public void navigationToNoticesUtility() throws InterruptedException {
        navigateToAgencySetup();
        helper.waitForPresenceandVisiblity(CSPInternalUtility.chngeLogo);
        helper.waitForElementIsInteractable(CSPInternalUtility.chngeLogo);
        helper.forcedWaitTime(2);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            helper.waitForPresenceandVisiblity(NoticesUtility.CE);
            helper.scrollIntoView(NoticesUtility.CE);
            helper.waitUntilElementIsVisible(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.clickByJsExecuter(NoticesUtility.CE);
        } else {
            int ceSize = driver.findElements(NoticesUtility.CE).size();
            int ProductDemoSize = driver.findElements(NoticesUtility.ProductDemo).size();
            if (ceSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.CE);
                helper.scrollIntoView(NoticesUtility.CE);
                helper.waitUntilElementPresent(NoticesUtility.CE);
                helper.waitForElementIsInteractable(NoticesUtility.CE);
                helper.clickByJsExecuter(NoticesUtility.CE);
            } else if (ProductDemoSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.ProductDemo);
                helper.scrollIntoView(NoticesUtility.ProductDemo);
                helper.waitUntilElementPresent(NoticesUtility.ProductDemo);
                helper.waitForElementIsInteractable(NoticesUtility.ProductDemo);
                helper.clickByJsExecuter(NoticesUtility.ProductDemo);
            }

        }
        helper.waitForPresenceandVisiblity(NoticesUtility.NoticesPageLink);
        helper.scrollIntoView(NoticesUtility.NoticesPageLink);
        helper.waitForElementIsInteractable(NoticesUtility.NoticesPageLink);
        helper.clickByJsExecuter(NoticesUtility.NoticesPageLink);
        helper.implicitWaitforCustometime(3);
        helper.scrollIntoView(NoticesUtility.AppHeaderIcon);
        helper.waitForPresenceandVisiblity(NoticesUtility.ActiveTab);
    }

    public void navigateToFines() throws InterruptedException {
        helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
        if (!driver.findElement(AppPreRequisiteUtility.FinesSideBar).isDisplayed()) {
            helper.waitUntilElementIsVisible(AppPreRequisiteUtility.CEProdSideBar);
            helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.clickByJsExecuter(AppPreRequisiteUtility.CEProdSideBar);

        }
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FinesSideBar);
        helper.scrollIntoView(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.FinesSideBar);
        helper.clickByJsExecuter(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForCurserRunning(4);
        helper.implicitWaitforCustometime(3);
        helper.scrolltoUp();

    }

    public void navigateToViolation() throws InterruptedException {
        helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
        if (!driver.findElement(AppPreRequisiteUtility.FinesSideBar).isDisplayed()) {
            helper.waitUntilElementIsVisible(AppPreRequisiteUtility.CEProdSideBar);
            helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.clickByJsExecuter(AppPreRequisiteUtility.CEProdSideBar);

        }
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.violationSideBar);
        helper.scrollIntoView(AppPreRequisiteUtility.violationSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.violationSideBar);
        helper.clickByJsExecuter(AppPreRequisiteUtility.violationSideBar);
        helper.waitForCurserRunning(4);
        helper.implicitWaitforCustometime(3);
        helper.scrolltoUp();

    }

    public void navigateToLateFeesSubTab() throws InterruptedException {

        helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
        if (!driver.findElement(AppPreRequisiteUtility.FinesSideBar).isDisplayed()) {
            helper.clickOn(AppPreRequisiteUtility.CEProdSideBar);

        }
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FinesSideBar);
        helper.scrollIntoView(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.FinesSideBar);
        helper.clickByJsExecuter(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForCurserRunning(4);
        helper.scrolltoUp();
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LateFeeSubtab);
        helper.scrollIntoView(AppPreRequisiteUtility.LateFeeSubtab);
        helper.clickByJsExecuter(AppPreRequisiteUtility.LateFeeSubtab);
        helper.implicitWaitforCustometime(3);

    }

    public void navigateToTemplateManagement() throws InterruptedException {

        helper.waitForPresenceandVisiblity(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.scrollIntoView(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.waitForElementIsInteractable(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.clickByJsExecuter(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.waitForPresenceandVisiblity(TemplateManagementUtility.EmailTemplatesTab);

    }

    public void addTemplateFiles(String selector, String filePath) throws InterruptedException, AWTException {

        helper.waitForPresenceandVisiblity(By.xpath(selector));
        helper.scrollIntoView(By.xpath(selector));
        WebElement UploadFile4 = driver.findElement(CSPInternalUtility.file);
        UploadFile4.sendKeys(filePath);

    }

    public void addNewTemplate(String templateName) throws InterruptedException, AWTException {

        helper.scrollIntoView(TemplateManagementUtility.CreateTemplateBtn);
        helper.waitForElementIsInteractable(TemplateManagementUtility.CreateTemplateBtn);
        helper.clickByJsExecuter(TemplateManagementUtility.CreateTemplateBtn);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(TemplateManagementUtility.TemplateNameTxt);
        helper.scrollIntoView(TemplateManagementUtility.TemplateNameTxt);
        helper.waitForElementIsInteractable(TemplateManagementUtility.TemplateNameTxt);
        helper.sendKeysWithWait(TemplateManagementUtility.TemplateNameTxt, templateName);
        helper.scrollIntoView(TemplateManagementUtility.EmailSubLineInput);
        String rndSubLine = RandomStrings.requiredString(3) + "EmailSubjectLine";
        helper.waitForElementIsInteractable(TemplateManagementUtility.EmailSubLineInput);
        helper.clearElement(TemplateManagementUtility.EmailSubLineInput);
        helper.waitForElementIsInteractable(TemplateManagementUtility.EmailSubLineInput);
        helper.sendKeysWithWait(TemplateManagementUtility.EmailSubLineInput, rndSubLine);
        String TemplateMessgae = RandomStrings.requiredCharacters(10);
        String ExpectedpreviewTemplateData = TemplateMessgae;
        WebElement switchFrame = helper.findElement(TemplateManagementUtility.IframeBody);
        driver.switchTo().frame(switchFrame);
        helper.sendKeysWithWait(TemplateManagementUtility.MessageBody, TemplateMessgae);
        driver.switchTo().defaultContent();
        helper.waitUntilElementIsVisible(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.scrollIntoView(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.waitForElementIsInteractable(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.clickByJsExecuter(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.scrollIntoView(TemplateManagementUtility.SaveCrtTemplate);
        helper.waitForElementIsInteractable(TemplateManagementUtility.SaveCrtTemplate);
        helper.clickOn(TemplateManagementUtility.SaveCrtTemplate);

    }

    public void navigateToNotificationMangement() throws InterruptedException {

        helper.waitForPresenceandVisiblity(NotificationManagementUtility.NotificationMangementSideBar);
        helper.scrollIntoView(NotificationManagementUtility.NotificationMangementSideBar);
        helper.waitForElementIsInteractable(NotificationManagementUtility.NotificationMangementSideBar);
        helper.clickByJsExecuter(NotificationManagementUtility.NotificationMangementSideBar);
        helper.waitForCurserRunning(4);

    }

    public void navigateToAssignmentRules() throws InterruptedException {

        helper.waitForCurserRunning(3);
        helper.waitForPresenceandVisiblity(POM.CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.scrollIntoView(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.waitForElementIsInteractable(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.clickByJsExecuter(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.waitForCurserRunning(2);

    }

    public void navigateToSLA() throws InterruptedException {

        helper.waitForPresenceandVisiblity(SLAUtility.SLASideBar);
        helper.scrollIntoView(SLAUtility.SLASideBar);
        helper.waitForElementIsInteractable(SLAUtility.SLASideBar);
        helper.clickByJsExecuter(SLAUtility.SLASideBar);
        helper.waitForCurserRunning(4);

    }

    public void navigationToFAAAdmin(By CaseManagementSidebar) throws InterruptedException {
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        jser.executeScript("window.scrollBy(0,450)", "");
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CEProdSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
        helper.clickOn(AppPreRequisiteUtility.CEProdSideBar);
        helper.waitForPresenceandVisiblity(CaseManagementSidebar);
        helper.waitForElementIsInteractable(CaseManagementSidebar);
        helper.clickByJsExecuter(CaseManagementSidebar);
        helper.waitForCurserRunning(4);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.ForcedAbatementTab);
        jser.executeScript("window.scrollBy(0,-450)", "");

    }

    public void navigationToViolationAdmin(By ViolationsSidebarOption) throws InterruptedException {
        helper.refreshPage();
        helper.waitForCurserRunning(6);
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        jser.executeScript("window.scrollBy(0,450)", "");
        helper.waitForPresenceandVisiblity(ViolationsSidebarOption);
        helper.scrollIntoView(ViolationsSidebarOption);
        helper.waitForElementIsInteractable(ViolationsSidebarOption);
        helper.waitUntilElementPresent(ViolationsSidebarOption);
        helper.clickByJsExecuter(ViolationsSidebarOption);
        helper.waitForCurserRunning(3);
        jser.executeScript("window.scrollBy(0,-450)", "");
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.MunicipalCodeTab);
        // helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateMunicipalCodeButton);
    }

    public void addNewViolationAdmin(String violationName) throws InterruptedException {
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LabelField);
        helper.sendKeysWithWait(AppPreRequisiteUtility.LabelField, violationName);

        helper.scrollIntoView(AppPreRequisiteUtility.ViolationTypeDropdown);
        helper.clickOn(AppPreRequisiteUtility.ViolationTypeDropdown);

        if (violationName.equalsIgnoreCase(PropertiesUtils.getPropertyValue("AnimalViolation"))) {

            helper.scrollIntoView(AppPreRequisiteUtility.VioOptionAnimal);
            helper.clickOn(AppPreRequisiteUtility.VioOptionAnimal);
        } else {
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.VioOptionGeneral);
            helper.clickOn(AppPreRequisiteUtility.VioOptionGeneral);
        }
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeField);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeField);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeOption);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeOption);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton2);
        helper.clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton2);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(By.xpath(AppPreRequisiteUtility.getMuncipalVioCode(violationName)));

    }

    public void addNewCitationViolation(String violationName) throws InterruptedException {
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LabelField);
        helper.sendKeysWithWait(AppPreRequisiteUtility.LabelField, violationName);

        helper.scrollIntoView(AppPreRequisiteUtility.ViolationTypeDropdown);
        helper.clickOn(AppPreRequisiteUtility.ViolationTypeDropdown);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.VioOptionGeneral);
        helper.clickOn(AppPreRequisiteUtility.VioOptionGeneral);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeField);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeField);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeOption);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeOption);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.inspectionReq);
        helper.clickOn(AppPreRequisiteUtility.inspectionReq);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton2);
        helper.clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton2);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(By.xpath(AppPreRequisiteUtility.getMuncipalVioCode(violationName)));

    }


    public void navigateToDisposition() throws InterruptedException {
        helper.refreshPage();
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.DispositionsTab);
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        helper.scrollIntoView(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.DispositionsTab);
        helper.clickByJsExecuter(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateInvalidDispositionButton);
    }

    public void clickOnIssueDescriptionNextButton() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.NextButton);
        helper.waitUntilElementPresent(CSPExternalUtility.NextButton);
        helper.scrollIntoView(CSPExternalUtility.NextButton);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButton);
        helper.clickByJsExecuter(CSPExternalUtility.NextButton);
    }

    public void clickOnBackButtonCRMExternal() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.BackButton);
        helper.scrollIntoView(CSPExternalUtility.BackButton);
        helper.waitForElementIsInteractable(CSPExternalUtility.BackButton);
        helper.clickByJsExecuter(CSPExternalUtility.BackButton);
    }

    public void clickOnLocationNextButton() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.NextButtonSec2);
        helper.waitUntilElementPresent(CSPExternalUtility.NextButtonSec2);
        helper.scrollIntoView(CSPExternalUtility.NextButtonSec2);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec2);
        helper.clickByJsExecuter(CSPExternalUtility.NextButtonSec2);
    }

    public void createCategoryCustomKeyWord(String Checkbox, String IncludeLoc, String Keywords, String CategoryName, String KeywordName) throws InterruptedException {

        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.scrollIntoView(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);
        helper.waitForPresenceandVisiblity(CategoryPage.LocationRequiredCheckbox);
        if (Checkbox == "Yes") {
            helper.clickOn(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
            helper.clickOn(CategoryPage.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }

            AddKeywordsField.sendKeys(KeywordName);
            AddKeywordsField.sendKeys(Keys.SPACE);
        }
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
    }

    public void customExternalSubmissionPinLocation(String description, String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {
        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
        helper.waitUntilElementIsVisible(CSPInternalUtility.drpDownLabelCategory);
        helper.scrollIntoView(CSPInternalUtility.drpDownLabelCategory);
        helper.clickOn(CSPInternalUtility.drpDownLabelCategory);
        helper.waitUntilElementIsVisible(CSPInternalUtility.dropdownSearchField);
        helper.sendKeysWithWait(CSPInternalUtility.dropdownSearchField, Category);
        helper.waitUntilElementIsVisible(CSPInternalUtility.optionBlack);
        helper.clickOn(By.xpath("//div[@class='option-black'][contains(text(),'" + Category + "')]"));
        helper.sendKeysWithWait(cspExternal.IssueDescriptionField, description);
        if (Attachment == "Yes") {

            WebElement UploadFile = driver.findElement(CSPInternalUtility.file);
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }

        clickOnIssueDescriptionNextButton();

        if (Category != PropertiesUtils.getPropertyValue("LocationNotRequired")) {
            ExternalCSPPinLocation();

        }
        helper.forcedWaitTime(4);
        clickOnLocationNextButton();

        if (Anonymous == "Yes") {
            helper.waitUntilElementIsVisible(CSPExternalUtility.YesButton);
            helper.scrollIntoView(CSPExternalUtility.YesButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickByJsExecuter(CSPExternalUtility.YesButton);

            helper.waitUntilElementIsVisible(CSPExternalUtility.SubmitButton);
            helper.scrollIntoView(CSPExternalUtility.SubmitButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.SubmitButton);
            helper.clickByJsExecuter(CSPExternalUtility.SubmitButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {

            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.EmailPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.TextMsgPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.TextMsgPreferenceButton);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, PropertiesUtils.getPropertyValue("Email"));
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, PropertiesUtils.getPropertyValue("Contact"));
        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.submissionBtn);
        helper.scrollIntoView(CSPInternalUtility.submissionBtn);
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(CSPInternalUtility.submissionBtn);
        helper.clickByJsExecuter(CSPInternalUtility.submissionBtn);
    }

    public void composeCRMMessage(String randomSubject) throws InterruptedException {
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
        String SubmissionNumberSplit[] = helper.getTextElement(CreateAndLinkCaseUtility.SubmissionNumber).split("#");
        String SubmissionNumberCSDP = SubmissionNumberSplit[1];
        helper.clickOn(SmsAndEmailVerificationUtility.MessagesIcon);
        helper.sendKeysWithWait(SmsAndEmailVerificationUtility.SubjectField, randomSubject);
        WebElement switchFrame = helper.waitUntilVisibleWE(SmsAndEmailVerificationUtility.IframeBody);
        driver.switchTo().frame(switchFrame);
        String RandomBody = "Random Body" + RandomStrings.requiredString(50);
        helper.waitForElementIsInteractable(SmsAndEmailVerificationUtility.MessageBody);
        helper.sendKeysWithWait(SmsAndEmailVerificationUtility.MessageBody, RandomBody);
        driver.switchTo().defaultContent();
        helper.clickByJsExecuter(SmsAndEmailVerificationUtility.SendButton);
        helper.waitUntilElementInvisibleLocated(SmsAndEmailVerificationUtility.SendButton);
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
    }

    public void searchSubmissionCSLP(String filtersearch) throws InterruptedException {
        helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
        helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, filtersearch);
        helper.forcedWaitTime(4);
        helper.waitForCurserRunning(4);
        helper.WaitForGridTableEnable();
    }


    public void closeSubmissionDetailPage() throws InterruptedException {
        helper.waitUntilElementIsVisible(CSDPUtility.CloseSDPage);
        helper.scrollIntoView(CSDPUtility.CloseSDPage);
        helper.waitForElementIsInteractable(CSDPUtility.CloseSDPage);
        helper.clickByJsExecuter(CSDPUtility.CloseSDPage);
        helper.waitUntilElementInvisibleLocated(CSDPUtility.CloseSDPage);
        helper.waitForCurserRunning(5);
    }


    public void SearchCaseOnCSLP(String caseId) throws InterruptedException {
        Thread.sleep(2000);
        // helper.waitUntilElementIsInvisible(CSLPUtility.CSLPSearchField);
        helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.clearElement(CSLPUtility.CSLPSearchField);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
        helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, caseId);
        helper.waitForCurserRunning(2);
        System.out.println("caseID" + caseId);
        helper.waitUntilElementIsVisible(By.xpath("//a[text()='" + caseId + "']"));
        helper.waitUntilElementPresent(By.xpath("//a[text()='" + caseId + "']"));
        helper.waitForElementIsInteractable(By.xpath("//a[text()='" + caseId + "']"));
    }

    public void CRM_CreateSubmissionCustomeAddress(String Anonymous, String Customer, String Tags, String Location,
                                                   String Attachment, String CategoryName, String AddressLocator, Boolean APN, Boolean PinLocation) throws InterruptedException {


        helper.waitForCurserRunning(5);
        int CheckCancel = driver.findElements(CSPInternalUtility.CancelCreateCase).size();
        if (CheckCancel > 0) {
            helper.scrollIntoView(CSPInternalUtility.CancelCreateCase);
            helper.clickOn(CSPInternalUtility.CancelCreateCase);

        }

        int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            helper.scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
            helper.clickOn(CSPInternalUtility.CloseSubmissionIcon);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.scrollIntoView(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitUntilElementPresent(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.forcedWaitTime(2);
        helper.sendKeysUsingActions(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.SearchResultsCategory);
        helper.clickByJsExecuter(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser
                    .executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            if (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("stage")) {
                helper.waitForElementIsInteractable(CSPInternalUtility.listLabel);
                helper.forcedWaitTime(3);
                helper.clickOn(CSPInternalUtility.listLabel);
            } else {
                if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                    try {
                        helper.waitForElementIsInteractable(CSPInternalUtility.listLabel);
                        helper.clickOn(CSPInternalUtility.listLabel);
                    } catch (Exception e) {
                        System.out.println("enter in catch of CRM_CreateSubmissionCustomeAddress ........ ");
                        helper.forcedWaitTime(4);
                        helper.waitForElementIsInteractable(CSPInternalUtility.listLabel);
                        helper.clickByJsExecuter(CSPInternalUtility.listLabel);
                    }

                } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise)) {
                    helper.waitForElementIsInteractable(CSPInternalUtility.automationComcate);
                    helper.clickOn(CSPInternalUtility.automationComcate);
                }

            }
            if (helper.getValueAttribute(CellPhoneField).isEmpty())
                helper.sendKeysWithWait(CellPhoneField, PropertiesUtils.getPropertyValue("Contact"));


        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {
            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {
                    if (APN) {
//                        CRMCommonMethods.serachLocationCCPNoClick(searchAPNLocation20);
                        serachLocationCCPNoClick(searchAPNLocation20);
                    } else {
//                        CRMCommonMethods.serachLocationCCPNoClick(searchLocationKey1O);
                        serachLocationCCPNoClick(searchLocationKey1O);
                    }
                }

                helper.forcedWaitTime(3);
                helper.scrollIntoView(By.xpath(AddressLocator));
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));
                helper.waitUntilElementPresent(By.xpath(AddressLocator));
                helper.waitForElementIsInteractable(By.xpath(AddressLocator));
                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } else if
            (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {
                    if (APN) {
                        serachLocationCCPNoClick(searchAPNLocation20);
                    } else {
                        serachLocationCCPNoClick(searchLocationKey1O);
                    }
                }
                helper.forcedWaitTime(3);
                helper.scrollIntoView(By.xpath(AddressLocator));
                helper.forcedWaitTime(3);
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));
                helper.waitUntilElementPresent(By.xpath(AddressLocator));
                helper.waitForElementIsInteractable(By.xpath(AddressLocator));
                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } else if
            (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {
                    if (APN) {

                        serachLocationCCPNoClick("7030-0207-0006-000");

                    } else {
                        serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchAPNLocationHost20_prod"));
                    }

                }
                helper.forcedWaitTime(3);

                helper.scrollIntoView(By.xpath(AddressLocator));
                helper.forcedWaitTime(2);
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));

                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } else {
                searchLocationCSP(searchLocationKey);
            }
            // Flag toggle
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.findElementsSize(CSPInternalUtility.ToggleChecked) > 0) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.findElementsSize(CSPInternalUtility.reasonForFlagging);
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(CSPInternalUtility.reasonForFlagging, "Unflagged");
                    helper.waitForElementIsInteractable(CSPInternalUtility.unflagAddress);
                    helper.clickOn(CSPInternalUtility.unflagAddress);
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }
            }
        }
        if (Attachment == "Yes") {
            helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);
            helper.waitForElementIsInteractable(CSPInternalUtility.AttachmentIcon);
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(CSPInternalUtility.file);
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
            helper.waitForCurserRunning(5);
            helper.waitForElementIsInteractable(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitForCurserRunning(4);
        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        helper.forcedWaitTime(3);
        System.out.println("create submission popup appears  in custome Address");
        helper.waitForCurserRunning(5);

        List<WebElement> DuplicateSubsPopup = driver
                .findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.clickOn(SubmitAnywayButton);
        }
        helper.forcedWaitTime(3);

    }


    public void serachLocationCCPNoClick(String Address) throws InterruptedException {
        helper.waitUntilElementIsVisible(LocationSearchField);
        helper.waitForElementIsInteractable(LocationSearchField);
        helper.forcedWaitTime(5);
        helper.sendKeysUsingActions(LocationSearchField, Address);
        System.out.println("Address : -> " + Address);
        helper.forcedWaitTime(3);
        System.out.println("successfully passs ");
        helper.waitForPresenceandVisiblity(LocationSearchResult);
        helper.waitForElementIsInteractable(LocationSearchResult);
    }


    public void NavigateTo_LocationManagement(By subtab) throws InterruptedException {
//        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
//        helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
//        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
//        helper.forcedWaitTime(2);

        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
            helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
            helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
            helper.forcedWaitTime(2);

            helper.clickByJsExecuter(AppPreRequisiteUtility.locationAndMapsTab);
            helper.waitForCurserRunning(3);
            helper.clickByJsExecuter(AppPreRequisiteUtility.securedLocationSetting);
            helper.waitForCurserRunning(3);
            boolean checkSubtab = helper.elementIsDisplayed(subtab);
            if (!checkSubtab) {
                helper.clickByJsExecuter(AppPreRequisiteUtility.LocationManagementTab);
            }
            helper.waitForPresenceandVisiblity(subtab);
            helper.waitForElementIsInteractable(subtab);
            helper.clickByJsExecuter(subtab);
            helper.waitUntilVisibleWE(AppPreRequisiteUtility.parcelLayerTab);
            helper.waitUntilElementPresent(AppPreRequisiteUtility.parcelLayerTab);
        } else {
            helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
            helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
            helper.forcedWaitTime(2);
            boolean checkSubtab = helper.elementIsDisplayed(subtab);
            if (!checkSubtab) {
                helper.clickByJsExecuter(AppPreRequisiteUtility.LocationManagementTab);
            }
            helper.waitForPresenceandVisiblity(subtab);
            helper.waitForElementIsInteractable(subtab);
            helper.clickByJsExecuter(subtab);
            helper.waitUntilVisibleWE(AppPreRequisiteUtility.parcelLayerTab);
            helper.waitUntilElementPresent(AppPreRequisiteUtility.parcelLayerTab);

        }
    }

    public void CCPGisDirectPinLocation() throws InterruptedException {

//        helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
//        helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
//        WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
//        String aria = zoomIn.getAttribute("aria-disabled");
//        while (aria.equalsIgnoreCase("false")) {
//            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
//            helper.clickByJsExecuter(CCPDirect20Utility.ZoomInMapLocation);
//            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
//            zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
//            aria = zoomIn.getAttribute("aria-disabled");
//        }
//
//        WebElement element = helper.findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
//        Point offset = element.getLocation();
//        int xoffset = offset.getX();
//        int yoffset = offset.getY();
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
//        element.click();
////		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
////		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);

        if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
            WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
            String aria = zoomIn.getAttribute("aria-disabled");
            while (aria.equalsIgnoreCase("false")) {
                helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
                helper.clickByJsExecuter(CCPDirect20Utility.ZoomInMapLocation);
                helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
                zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
                aria = zoomIn.getAttribute("aria-disabled");
            }

            WebElement element = helper.findElement(CSPInternalUtility.mapContainer);
            Point offset = element.getLocation();
            int xoffset = offset.getX();
            int yoffset = offset.getY();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
            try {
                element.click();
            } catch (Exception e) {
                element.click();

            }
            helper.waitUntilVisibleWE(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
//		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
        } else {
            System.out.println("enter in else conidition");
            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
            WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
            String aria = zoomIn.getAttribute("aria-disabled");

            WebElement element = helper.findElement(CSPInternalUtility.mapContainer);
            Point offset = element.getLocation();
            int xoffset = offset.getX();
            int yoffset = offset.getY();
            xoffset = -20;
            yoffset = -20;

            Actions actions = new Actions(driver);
            Thread.sleep(3000);
            actions.moveToElement(element, xoffset, yoffset).click().perform();
            helper.waitUntilVisibleWE(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
//		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
        }
    }

    public void ExternalCSPPinLocation() throws InterruptedException {

        helper.waitUntilElementIsVisible(CCPUtility.ZoomInMapLocation);
        helper.waitForElementIsInteractable(CCPUtility.ZoomInMapLocation);
        WebElement zoomIn = helper.findElement(CCPUtility.ZoomInMapLocation);
        String aria = zoomIn.getAttribute("aria-disabled");
        while (aria.equalsIgnoreCase("false")) {
            helper.waitForElementIsInteractable(CCPUtility.ZoomInMapLocation);
            helper.clickByJsExecuter(CCPUtility.ZoomInMapLocation);
            helper.waitUntilElementIsVisible(CCPUtility.ZoomInMapLocation);
            zoomIn = helper.findElement(CCPUtility.ZoomInMapLocation);
            aria = zoomIn.getAttribute("aria-disabled");
        }

        WebElement element = helper.findElement(CSPInternalUtility.mapView);
        Point offset = element.getLocation();
        int xoffset = (int) offset.getX();
        int yoffset = (int) offset.getY();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
        element.click();
    }

    public static String extractAddressFunction(String address) {
        String[] parts = address.split(" ");

        String extracted = " ";
        // Combine the first two parts to get the desired output....
        if (parts.length >= 2) {
            extracted = parts[0] + " " + parts[1];
            System.out.println("Extracted: " + extracted);
        } else {
            System.out.println("The address does not have enough parts.");
        }
        return extracted;
    }


    public void clickCasesHeader() throws InterruptedException {
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(CSPInternalUtility.Cases);
        helper.clickByJsExecuter(CSPInternalUtility.Cases);
    }

    public int extractedInteger(String st) {
        int extractedNumber = Integer.parseInt(st.replaceAll("\\D+", ""));
        return extractedNumber;
    }

    public String extractSubmissionIdOnCSDP(String input) {
        int hashIndex = input.indexOf('#'); // Find the index of '#'

        // Check if '#' exists and has content after it
        if (hashIndex != -1 && hashIndex + 1 < input.length()) {
            return input.substring(hashIndex + 1).trim(); // Extract and trim any spaces
        }
        return ""; // Return empty string if '#' is not found or nothing follows
    }


    public boolean isSorted(List<String> list, boolean caseSensitive) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                System.out.println(list.get(i - 1) + "    " + list.get(i));
                return false; // List is not in order
            }
        }
        return true; // Sorted
    }


    public static boolean isListInAscendingOrder(List<String> list) {
        // Loop through the list and compare each string with the next
        for (int i = 0; i < list.size() - 1; i++) {
            // Compare ignoring case
            if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) {
                return false; // List is not in ascending order
            }
        }
        return true; // List is in ascending order
    }


    // extract submission number
    public static String extractIntegersWithHyphen(String input) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            if (result.length() > 0) {
                result.append("-");
            }
            result.append(matcher.group());
        }
        return result.toString();
    }
    

    public void navigationTo(By tab, By subTab) throws InterruptedException {
//        JavascriptExecutor jser = (JavascriptExecutor) driver;
//        jser.executeScript("window.scrollBy(0,450)", "");
        helper.waitForPresenceandVisiblity(tab);
        helper.scrollIntoView(tab);
        helper.waitForElementIsInteractable(tab);
        helper.clickOn(tab);

        if (subTab.toString() != null) {
            helper.waitForPresenceandVisiblity(subTab);
            helper.waitForElementIsInteractable(subTab);
            helper.clickByJsExecuter(subTab);
        }
        helper.waitForCurserRunning(4);
       
    }
    
    public void navigateToTopNavigation(By tab) throws InterruptedException {
    	
    	 helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AppMenuIcon);
    	 helper.waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
    	 helper.scrollIntoView(AppPreRequisiteUtility.AppMenuIcon);
    	 helper.waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
    	 helper.clickByJsExecuter(AppPreRequisiteUtility.AppMenuIcon);
    	 
    	 helper.waitForPresenceandVisiblity(tab);
         helper.waitForElementIsInteractable(tab);
         helper.waitForElementIsInteractable(tab);
         helper.clickByJsExecuter(tab);
         //helper.waitForCurserRunning(4);
         helper.forcedWaitTime(2);
//         if (helper.findElementsSize(AppPreRequisiteUtility.financeMenu)>0) {
//        	 helper.forcedWaitTime(2);
//        	 helper.clickByJsExecuter(AppPreRequisiteUtility.financeMenu);
//       }
         
         helper.waitForCurserRunning(5);  
    	 
    	
}
    
    public void addFineOnCDP() throws InterruptedException {
        helper.waitUntilElementIsVisible(CDP_Utility.outstandingBalDetails);
        helper.waitUntilElementIsVisible(CSPInternalUtility.printBtn);
        helper.scrollIntoView(CSPInternalUtility.printBtn);
        helper.waitForElementIsInteractable(CDP_Utility.outstandingBalDetails);
        helper.forcedWaitTime(2);
        helper.clickOn(CDP_Utility.outstandingBalDetails);
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(CDP_Utility.finePaymentDetailsPopup);
        helper.waitUntilElementIsVisible(CDP_Utility.addNewFine);
        helper.waitUntilElementPresent(CDP_Utility.finePaymentDetailsPopup);
        helper.waitForElementIsInteractable(CDP_Utility.selectFineDropdownArrow);
        helper.forcedWaitTime(1);
        helper.clickOn(CDP_Utility.selectFineDropdownArrow);
        helper.waitUntilElementIsVisible(CDP_Utility.selectFineOptions);
        helper.clickOn(CDP_Utility.selectFineOptions);
        helper.waitForElementIsInteractable(CDP_Utility.addNewFine);
        helper.clickOn(CDP_Utility.addNewFine);
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(CDP_Utility.closeFinePaymentDetailsPop);
        helper.waitUntilElementPresent(CDP_Utility.closeFinePaymentDetailsPop);
    }

    public void closeFines_Payments_Details() throws InterruptedException {
        helper.clickOn(OnlinePaymentUtility.CloseFinePaymentDetailsPop);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(CSPInternalUtility.outstandingBal);

    }
    
    public void addLateFeeOnCDP() throws InterruptedException {
        helper.waitUntilElementIsVisible(CDP_Utility.outstandingBalDetails);
        helper.waitUntilElementIsVisible(CSPInternalUtility.printBtn);
        helper.scrollIntoView(CSPInternalUtility.printBtn);
        helper.waitForElementIsInteractable(CDP_Utility.outstandingBalDetails);
        helper.clickOn(CDP_Utility.outstandingBalDetails);
        helper.waitForCurserRunning(3);

        helper.waitUntilElementIsVisible(CDP_Utility.finePaymentDetailsPopup);
        helper.waitUntilElementIsVisible(CDP_Utility.addLateFeeToggel);
        helper.waitUntilElementPresent(CDP_Utility.addLateFeeToggel);
        helper.clickByJsExecuter(CDP_Utility.addLateFeeToggel);

        helper.waitForElementIsInteractable(CDP_Utility.selectLateFeeDropDownArrow);
        helper.clickOn(CDP_Utility.selectLateFeeDropDownArrow);
        helper.waitUntilElementIsVisible(CDP_Utility.selectFineOptions);
        helper.clickOn(CDP_Utility.selectFineOptions);
        helper.waitForElementIsInteractable(CDP_Utility.addNewLateFee);
        helper.clickOn(CDP_Utility.addNewLateFee);
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(CDP_Utility.closeFinePaymentDetailsPop);
        helper.waitUntilElementPresent(CDP_Utility.closeFinePaymentDetailsPop);
    }

    private static ThreadLocal<String> payorName = new ThreadLocal<>();

    public void addPaymentOnCDP(String amount, String recipient) throws InterruptedException {

        CECommonMethods CEMethods = new CECommonMethods(driver);
        helper.waitUntilElementIsVisible(CDP_Utility.AddPayment);
        helper.clickOn(CDP_Utility.AddPayment);
        helper.waitUntilElementIsVisible(CDP_Utility.AddPaymentAmnt);
        helper.sendKeysWithWait(CDP_Utility.AddPaymentAmnt, amount);
        helper.waitUntilElementIsVisible(CDP_Utility.SelectPayor);
        helper.clickOn(CDP_Utility.SelectPayor);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.SelectPayorOpt);
        helper.clickOn(OnlinePaymentUtility.SelectPayorOpt);
        helper.forcedWaitTime(2);
        if (helper.findElementsSize(CDP_Utility.createContactPopup) > 0) {
            CEMethods.ce_addContact2();
        }
        Thread.sleep(4000);

        if (recipient != null) {
            helper.sendKeysWithWait(CDP_Utility.checkkOrRecipient, recipient);
            helper.forcedWaitTime(2);
        }


        helper.clearElement(CDP_Utility.paymentClerk);
        helper.forcedWaitTime(2);
        helper.sendKeysWithWait(CDP_Utility.paymentClerk, "Comcate Support");

        payorName.set(helper.getTextElement(CDP_Utility.payorName));

        try {
            helper.waitUntilElementIsVisible(OnlinePaymentUtility.AddPaymentbtn);
            helper.clickOn(OnlinePaymentUtility.AddPaymentbtn);
        } catch (Exception e) {
            helper.clickByJsExecuter(OnlinePaymentUtility.AddPaymentbtn);
        }
        helper.waitForCurserRunning(6);
        helper.forcedWaitTime(1);
        helper.waitUntilElementIsVisible(CSPInternalUtility.paymentListingRow);
        String cashPayment = helper.getTextElement(CSPInternalUtility.paymentListingRow);
    }

    public static String getPayorName() {
        String name = payorName.get();
        payorName.remove();  // Cleanup after fetching
        return name;
    }


    public String UserAbleToMarkFineAsVoid() throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));


        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidfineBtn);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidfineBtn);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidLable);
        helper.waitUntilElementPresent(OnlinePaymentUtility.VoidLable);


        String voidLableButton = helper.getTextElement(OnlinePaymentUtility.VoidLable);

        SoftAssert SFA = new SoftAssert();

        SFA.assertEquals(voidLableButton, "Void");
        SFA.assertAll();

        return voidLableButton;

    }


    public String UserAbleToMarkFineAsWaive() throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);

        helper.waitForElementIsInteractable(OnlinePaymentUtility.waivetoggel);
        helper.clickByJsExecuter(OnlinePaymentUtility.waivetoggel);

        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));
        helper.waitForElementIsInteractable(OnlinePaymentUtility.WaivefineBtn);
        helper.clickByJsExecuter(OnlinePaymentUtility.WaivefineBtn);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidLable);
        helper.waitUntilElementPresent(OnlinePaymentUtility.VoidLable);

        String voidLableButton = helper.getTextElement(OnlinePaymentUtility.VoidLable);

        SoftAssert SFA = new SoftAssert();

        SFA.assertEquals(voidLableButton, "Waived");
        SFA.assertAll();
        
        return voidLableButton;

    }


    public String UserAbleToMarkLateAsVoid() throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));


        helper.waitForElementIsInteractable(OnlinePaymentUtility.voidLateFee);
        helper.clickByJsExecuter(OnlinePaymentUtility.voidLateFee);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidLable);
        helper.waitUntilElementPresent(OnlinePaymentUtility.VoidLable);


        String voidLableButton = helper.getTextElement(OnlinePaymentUtility.VoidLable);

        SoftAssert SFA = new SoftAssert();

        SFA.assertEquals(voidLableButton, "Void");
        SFA.assertAll();

        return voidLableButton;

    }


    public String UserAbleToMarkPaymentAsVoid() throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);

        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidPaymentbutton);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidPaymentbutton);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidLable);
        helper.waitUntilElementPresent(OnlinePaymentUtility.VoidLable);
        Boolean voidLableIcon = helper.findElement(OnlinePaymentUtility.VoidLable).isDisplayed();
        String voidLableButton = helper.getTextElement(OnlinePaymentUtility.VoidLable);
        Boolean paymentNullifiedPresent = helper.findElement(OnlinePaymentUtility.PaymentNullified).isDisplayed();
        SoftAssert SFA = new SoftAssert();


        SFA.assertEquals(voidLableButton, "Void");
        SFA.assertAll();

        return voidLableButton;

    }


    public String UserAbleToRefundPayment(String amount) throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);

        helper.waitForElementIsInteractable(OnlinePaymentUtility.refundToggel);
        helper.clickByJsExecuter(OnlinePaymentUtility.refundToggel);

        helper.waitForElementIsInteractable(OnlinePaymentUtility.refundAmountTxt);
        helper.sendKeysWithWait(OnlinePaymentUtility.refundAmountTxt, amount);

        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));
        helper.waitForElementIsInteractable(OnlinePaymentUtility.refundIssueBtn);
        helper.clickByJsExecuter(OnlinePaymentUtility.refundIssueBtn);
        helper.waitForCurserRunning(4);

        helper.waitUntilElementIsVisible(OnlinePaymentUtility.paymentStatus);
        helper.waitUntilElementPresent(OnlinePaymentUtility.paymentStatus);

        String partialORrefund = helper.getTextElement(OnlinePaymentUtility.paymentStatus);

        return partialORrefund;

    }


    public String UserAbleToMarkLateFeeAsWavied() throws InterruptedException {
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.VoidIconFinePaymentList);
        helper.clickByJsExecuter(OnlinePaymentUtility.VoidIconFinePaymentList);

        helper.waitForElementIsInteractable(OnlinePaymentUtility.waivetoggel);
        helper.clickByJsExecuter(OnlinePaymentUtility.waivetoggel);

        helper.sendKeysWithWait(OnlinePaymentUtility.ReasonForVoid, RandomStrings.requiredString(4));

        helper.waitForElementIsInteractable(OnlinePaymentUtility.waiveLateFee);
        helper.clickByJsExecuter(OnlinePaymentUtility.waiveLateFee);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(OnlinePaymentUtility.VoidLable);
        helper.waitUntilElementPresent(OnlinePaymentUtility.VoidLable);
        
        
       
        String voidLableButton = helper.getTextElement(OnlinePaymentUtility.VoidLable);
     
        SoftAssert SFA = new SoftAssert();

        SFA.assertEquals(voidLableButton, "Waived");
        SFA.assertAll();

        return voidLableButton;
    }

    
    
    

}
