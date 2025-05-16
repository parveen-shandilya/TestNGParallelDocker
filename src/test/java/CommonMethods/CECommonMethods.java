package CommonMethods;

import BrowsersBase.BrowsersInvoked;
import LogUtility.Log;
import POM.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Point;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static POM.CCPDirect20Utility.GisDataAddress;
import static POM.CCPUtility.*;
import static POM.CCPUtility.SaveButton;
import static POM.SubmissionAssignmentUtility.*;
import static POM.SupervisorUtility.completeInspAndGenerateNoticeForApproval;

public class CECommonMethods extends BrowsersInvoked {
    public WebDriver driver;
    public Helper helper;
    public CECommonMethods CEcommonMethod;
    public CCPUtility ccp;
    public CDP_Utility cdp;
    public CRMCommonMethods crmCommonMethods;
    public CCPDirect20Utility CCPDirect20Utility;

    public CECommonMethods(WebDriver driver) {
        super();
        this.driver = driver;
        helper = new Helper(driver);
        crmCommonMethods = new CRMCommonMethods(driver);

    }

    public String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
    public String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");
    public boolean proActiveButton;

    public String SetTestDataFilePath(String filename) {
        String resourcePath;
        if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
            resourcePath = System.getProperty("user.dir") + "\\TestData\\" + filename;
        } else {
            resourcePath = System.getProperty("user.dir") + "/TestData/" + filename;
        }
        return resourcePath;
    }

    public String getAgencyName() throws InterruptedException {
        helper.clickByJsExecuter(AgencyCreationUtility.hamburger);
        helper.clickByJsExecuter(AgencyCreationUtility.agencySetupIcon);
        helper.waitForPresenceandVisiblity(AgencyCreationUtility.agencyName);
        helper.forcedWaitTime(2);
        String AgencyName = helper.getTextElement(AgencyCreationUtility.agencyName).toUpperCase();
        return AgencyName;

    }

    public void creationCustomeFANotices(String NoticesName, String MergFields) throws InterruptedException {
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
        helper.clickByJsExecuter(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FADocumentToggle);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.FADocumentToggle);
        helper.clickByJsExecuter(AppPreRequisiteUtility.FADocumentToggle);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LabelField);
        helper.sendKeysWithWait(AppPreRequisiteUtility.LabelField, NoticesName);
        WebElement frameNotice = helper.findElement(By.id("editor_ifr"));
        driver.switchTo().frame(frameNotice);
        helper.waitForElementIsInteractable(By.id("tinymce"));
        helper.sendKeysWithWait(By.id("tinymce"), MergFields);
        driver.switchTo().defaultContent();
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateNoticeBtn);
        helper.clickByJsExecuter(AppPreRequisiteUtility.CreateNoticeBtn);
        helper.waitForCurserRunning(8);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CountNotices);
        helper.waitForPresenceandVisiblity(
                By.xpath(helper.stringFormat(AppPreRequisiteUtility.noticeName, NoticesName)));
    }

    public void searchCaseoOnCLP(String caseId) throws InterruptedException {

        navigationToCaseListPage();
        try {
            helper.waitForElementIsInteractable(CLPUtility.ClearAllFiltersLink);
            helper.clickByJsExecuter(CLPUtility.ClearAllFiltersLink);
        } catch (Exception e) {
            // ignore
        }
        helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.clearElement(CSLPUtility.CSLPSearchField);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
        helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, caseId);
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.waitForElementIsInteractable(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.forcedWaitTime(3);
        if (!helper.elementIsDisplayed(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)))) {
            searchCaseoOnCLP(caseId);
        }
    }

    public void addAttachmentCDP(String path) throws InterruptedException {

        helper.waitUntilElementIsVisible(CDP_Utility.addAttachmentCDP);
        helper.scrollIntoView(CDP_Utility.addAttachmentCDP);
        helper.clickByJsExecuter(CDP_Utility.addAttachmentCDP);
        WebElement UploadFile4 = driver.findElement(CDP_Utility.file);
        UploadFile4.sendKeys(path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
    }

    public void selectUserScheduleFollowUpInspection(String username) throws InterruptedException {
        int check = helper
                .findElementsSize(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
        if (check > 0) {
            helper.waitUntilElementIsVisible(
                    By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
            try {
                helper.clickOn(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
            } catch (Exception e) {
                helper.forcedWaitTime(3);
                helper.clickOn(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));

            }
        } else {
            helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(CSLPUtility.labelLnkText, "More...")));
            helper.clickOn(By.xpath(helper.selectorFormate(CSLPUtility.labelLnkText, "More...")));
            helper.forcedWaitTime(5);
            helper.waitUntilElementIsVisible(PerformInspectionUtility.userNameSearch);
            helper.sendKeysWithWait(PerformInspectionUtility.userNameSearch, username);
            helper.forcedWaitTime(4);
            helper.waitUntilElementIsVisible(
                    By.xpath(helper.selectorFormate(PerformInspectionUtility.followUpInspectionAssignee, username)));
            helper.clickOn(
                    By.xpath(helper.selectorFormate(PerformInspectionUtility.followUpInspectionAssignee, username)));

        }
    }

    public void createCustomeUsers(String FirstName, String LastName, String UserRoles) throws InterruptedException {
        helper.waitUntilElementIsVisible(CreateCRMUserUtility.CreateUserButton);
        helper.scrollIntoView(CreateCRMUserUtility.CreateUserButton);
        helper.waitForElementIsInteractable(CreateCRMUserUtility.CreateUserButton);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CreateCRMUserUtility.CreateUserButton);
        helper.waitUntilElementIsVisible(CreateCRMUserUtility.FirstNameField);
        helper.waitForElementIsInteractable(CreateCRMUserUtility.FirstNameField);
        String rn = RandomStrings.requiredDigits(4);
        helper.sendKeysWithWait(CreateCRMUserUtility.FirstNameField, FirstName);
        helper.sendKeysWithWait(CreateCRMUserUtility.LastNameField, LastName);
        String EmailRandom = FirstName + LastName + rn + CreateCRMUserUtility.RandomLastNameCRM + "@yopmail.com";
        helper.waitForElementIsInteractable(CreateCRMUserUtility.EmailField);
        helper.sendKeysWithWait(CreateCRMUserUtility.EmailField, EmailRandom);
        helper.waitForElementIsInteractable(CreateCRMUserUtility.RoleDropdown);
        helper.clickOn(CreateCRMUserUtility.RoleDropdown);
        helper.forcedWaitTime(1);
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));
        helper.waitForElementIsInteractable(
                By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));
        helper.clickOn(By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));
        helper.waitUntilElementIsVisible(CreateCRMUserUtility.CreateUserPopupBtn);
        helper.forcedWaitTime(5);
        helper.waitForElementIsInteractable(CreateCRMUserUtility.CreateUserPopupBtn);
        helper.clickOn(CreateCRMUserUtility.CreateUserPopupBtn);
        helper.waitUntilElementInvisibleLocated(CreateCRMUserUtility.CreateUserPopupBtn);
        helper.waitForCurserRunning(10);
        helper.forcedWaitTime(5);
    }

    public void createCaseAndPerformInspection() throws InterruptedException {
        if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
            closeCaseDetailPage();
        }
        navigateToCCP();
        helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
        helper.waitForElementIsInteractable(CCPUtility.CCButton);
        helper.forcedWaitTime(5);
        addLocationCCP();
        helper.forcedWaitTime(5);
        addViolationParam(PropertiesUtils.getPropertyValue("WaterViolation"));
        helper.forcedWaitTime(3);
        ce_addContact();
        addAttachmentCCP(SetTestDataFilePath("pexels-mike-b-170811.jpg"));
        addAttachmentCCP(SetTestDataFilePath("pexels-mike-b-810357.jpg"));

        helper.forcedWaitTime(5);
        helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
        helper.scrollIntoView(CCPUtility.CreateCaseButton);
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickByJsExecuter(CCPUtility.CreateCaseButton);
        helper.handleReviewContact();
        helper.waitForCurserRunning(10);
        helper.waitUntilElementIsVisible(CCPUtility.performInspectionToogel);
        helper.clickOn(CCPUtility.performInspectionToogel);
        helper.waitUntilElementIsVisible(CCPUtility.proActiveButton);
        proActiveButton = helper.elementIsDisplayed(CCPUtility.proActiveButton);
        helper.waitUntilElementIsVisible(CCPUtility.performInspectionAndCreateCase);
        helper.scrollIntoView(CCPUtility.performInspectionAndCreateCase);
        helper.clickOn(CCPUtility.performInspectionAndCreateCase);
        helper.waitForCurserRunning(5);
        String title = "Verification Inspection";

    }

    public void createCaseAndPerformInspectionWithoutAttachment() throws InterruptedException {
        if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
            closeCaseDetailPage();
        }
        navigateToCCP();
        helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
        helper.waitForElementIsInteractable(CCPUtility.CCButton);
        helper.forcedWaitTime(5);
        addLocationCCP();
        helper.forcedWaitTime(5);
        addViolationParam(PropertiesUtils.getPropertyValue("WaterViolation"));
        helper.forcedWaitTime(3);
        ce_addContact();

        helper.forcedWaitTime(5);
        helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
        helper.scrollIntoView(CCPUtility.CreateCaseButton);
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickByJsExecuter(CCPUtility.CreateCaseButton);
        helper.handleReviewContact();
        helper.waitForCurserRunning(5);

        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(CCPUtility.CaseAssigneeTo);
        helper.waitUntilElementPresent(CCPUtility.CaseAssigneeTo);
        helper.waitUntilElementIsVisible(CCPUtility.performInspectionToogel);
        helper.clickOn(CCPUtility.performInspectionToogel);
        helper.waitUntilElementIsVisible(CCPUtility.proActiveButton);
        proActiveButton = helper.elementIsDisplayed(CCPUtility.proActiveButton);
        helper.waitUntilElementIsVisible(CCPUtility.performInspectionAndCreateCase);
        helper.scrollIntoView(CCPUtility.performInspectionAndCreateCase);
        helper.clickOn(CCPUtility.performInspectionAndCreateCase);
        helper.waitForCurserRunning(5);
        String title = "Verification Inspection";
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CCPUtility.headerText, title)));
    }

    public void selectCaseAssineCCP(String asignee) throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.CaseAssignToArrow);
        helper.waitUntilElementPresent(CCPUtility.CaseAssignToArrow);
        try {
            helper.clickOn(CCPUtility.CaseAssignToArrow);
        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickOn(CCPUtility.CaseAssignToArrow);
        }
        helper.forcedWaitTime(3);
        helper.waitUntilElementPresent(CCPUtility.TypeCaseAssigne);
        helper.sendKeysWithWait(CCPUtility.TypeCaseAssigne, asignee);
        helper.waitUntilElementIsVisible(CCPUtility.AssineSuggested);
        helper.waitForElementIsInteractable(CCPUtility.AssineSuggested);
        helper.clickOn(CCPUtility.AssineSuggested);
        helper.forcedWaitTime(1);
        helper.clickOn(CCPUtility.CaseAssignToArrow);

    }

    //helper.sendKeysWithWait(CaseAssignmentUtility.search,asignee);
    public void selectCaseAssineCCP2(String asignee) throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.CaseAssignToArrow);
        helper.waitUntilElementPresent(CCPUtility.CaseAssignToArrow);
        try {
            helper.clickOn(CCPUtility.CaseAssignToArrow);
        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickOn(CCPUtility.CaseAssignToArrow);
        }
        helper.forcedWaitTime(3);
        helper.sendKeysWithWait(CaseAssignmentUtility.search, asignee);
        helper.forcedWaitTime(3);
        helper.clickOn(CaseAssignmentUtility.amandeepSingh);
        helper.forcedWaitTime(1);

    }

    public void selectInspectionAssineCCP(String asignee) throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.InspectionAssineArrow);
        helper.waitUntilElementPresent(CCPUtility.InspectionAssineArrow);
        helper.clickOn(CCPUtility.InspectionAssineArrow);
        helper.waitUntilElementPresent(CCPUtility.TypeInspectionAssinge);
        helper.sendKeysWithWait(CCPUtility.TypeInspectionAssinge, asignee);
        helper.waitUntilElementIsVisible(CCPUtility.AssineSuggested);
        helper.clickOn(CCPUtility.AssineSuggested);
        helper.forcedWaitTime(1);
        helper.clickOn(CCPUtility.InspectionAssineArrow);

    }

    public void selectInspectionAssineCCP2(String asignee) throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.InspectionAssineArrow);
        helper.waitUntilElementPresent(CCPUtility.InspectionAssineArrow);
        helper.clickOn(CCPUtility.InspectionAssineArrow);

        helper.sendKeysWithWait(CaseAssignmentUtility.search, asignee);
        helper.clickOn(CaseAssignmentUtility.amandeepSingh);
        helper.forcedWaitTime(1);

    }

    public void createCaseCCP() throws InterruptedException {
        navigateToCCP();
        addLocationCCP();
        addViolationParam(PropertiesUtils.getPropertyValue("WaterViolation"));
        helper.forcedWaitTime(5);
        // Verify if violation is added successfully if not then add it again
        helper.waitForElementIsInteractable(CCPUtility.violationNameLabelAfterAdd);
        String violationNameAdded = helper.getTextByJSExecutor(CCPUtility.violationNameLabelAfterAdd);
        if (!violationNameAdded.equalsIgnoreCase(PropertiesUtils.getPropertyValue("WaterViolation"))) {
            addViolationParam(PropertiesUtils.getPropertyValue("WaterViolation"));
        }
        ce_addContact();
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickByJsExecuter(CCPUtility.CreateCaseButton);
        helper.forcedWaitTime(5);

        if (driver.findElements(close).size() >= 1) {
            helper.clickOn(CDP_Utility.closeBtn);

            List<WebElement> keepContacts = driver.findElements(CDP_Utility.keepContactBtn);
            int size = keepContacts.size();
            if (size == 1) {
                helper.scrollIntoView(CDP_Utility.keepContactBtn);
                helper.clickByJsExecuter(CDP_Utility.keepContactBtn);
            }
            if (size > 1) {
                for (WebElement i : keepContacts) {
                    helper.scrollIntoViewWebElement(i);
                    helper.forcedWaitTime(2);
                    // i.click();
                    helper.clickByJsExecuterWebElement(i);
                }

            }

            helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
            helper.clickByJsExecuter(CCPUtility.CreateCaseButton);

        }

        helper.waitForCurserRunning(5);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCE2User"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCE2User"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("AmandeepSingh"));

        } else {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCE2User"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
        }

        helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        helper.clickByJsExecuter(CCPUtility.CreateScheduleInspectionButton);
        helper.waitForCurserRunning(10);

    }

    public void createCaseCCPWithFireViolation() throws InterruptedException {
        navigateToCCP();
        addLocationCCP();
        addViolationParam(PropertiesUtils.getPropertyValue("FireViolation"));
        helper.forcedWaitTime(5);
        ce_addContact();
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.scrollIntoView(CCPUtility.CreateCaseButton);
        helper.clickByJsExecuter(CCPUtility.CreateCaseButton);
        helper.forcedWaitTime(5);

        if (driver.findElements(close).size() >= 1) {
            helper.clickOn(CDP_Utility.closeBtn);

            List<WebElement> keepContacts = driver.findElements(CDP_Utility.keepContactBtn);
            int size = keepContacts.size();
            if (size == 1) {
                helper.scrollIntoView(CDP_Utility.keepContactBtn);
                helper.clickByJsExecuter(CDP_Utility.keepContactBtn);
            }
            if (size > 1) {
                for (WebElement i : keepContacts) {
                    helper.scrollIntoViewWebElement(i);
                    helper.forcedWaitTime(2);
                    // i.click();
                    helper.clickByJsExecuterWebElement(i);
                }

            }

            helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
            helper.clickByJsExecuter(CCPUtility.CreateCaseButton);

        }

        helper.waitForCurserRunning(5);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCEUser"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCEUser"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("AmandeepSingh"));

        } else {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCEUser"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
        }

        helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        helper.clickByJsExecuter(CCPUtility.CreateScheduleInspectionButton);
        helper.waitForCurserRunning(10);

    }

    public void createCaseCCP(String assigne) throws InterruptedException {
        navigateToCCP();
        addLocationCCP();
        addViolationParam("Wa");
        helper.forcedWaitTime(5);
        ce_addContact();
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickByJsExecuter(CCPUtility.CreateCaseButton);
        helper.forcedWaitTime(5);

        if (driver.findElements(close).size() >= 1) {
            helper.clickOn(CDP_Utility.closeBtn);

            List<WebElement> keepContacts = driver.findElements(CDP_Utility.keepContactBtn);
            int size = keepContacts.size();
            if (size == 1) {
                helper.scrollIntoView(CDP_Utility.keepContactBtn);
                helper.clickByJsExecuter(CDP_Utility.keepContactBtn);
            }
            if (size > 1) {
                for (WebElement i : keepContacts) {
                    helper.scrollIntoViewWebElement(i);
                    helper.forcedWaitTime(2);
                    // i.click();
                    helper.clickByJsExecuterWebElement(i);
                }

            }

            helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
            helper.clickByJsExecuter(CCPUtility.CreateCaseButton);

        }

        helper.waitForCurserRunning(5);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCEUser"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
            selectCaseAssineCCP(assigne);
            selectInspectionAssineCCP(assigne);

        } else {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCE2User"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
        }

        helper.forcedWaitTime(3);
        // helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        // helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
        helper.clickByJsExecuter(createAndScheduleInsp);

        helper.waitForCurserRunning(7);

    }

    public void addAttachmentCCP(String path) throws InterruptedException {

        helper.scrollIntoView(CCPUtility.addAttachmentCCP);
        helper.clickByJsExecuter(CCPUtility.addAttachmentCCP);
        WebElement UploadFile4 = driver.findElement(CDP_Utility.file);
        String testtDataPath = System.getProperty("user.dir");
        UploadFile4.sendKeys(path);
        helper.clickOn(CCPUtility.AddBtn);
    }

    public void addAttachmentTopRightCCP(String path) throws InterruptedException {

        helper.waitUntilElementIsVisible(CCPUtility.addAttachmenttop);
        helper.scrollIntoView(CCPUtility.addAttachmenttop);
        helper.clickByJsExecuter(CCPUtility.addAttachmenttop);
        WebElement UploadFile4 = driver.findElement(CDP_Utility.file);
        String testtDataPath = System.getProperty("user.dir");
        UploadFile4.sendKeys(testtDataPath + path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
        helper.waitForCurserRunning(5);
    }

    public void addAttachmentBottom(String path) throws InterruptedException {

        helper.waitUntilElementIsVisible(CCPUtility.addAttachmentbottom);
        helper.scrollIntoView(CCPUtility.addAttachmentbottom);
        helper.clickByJsExecuter(CCPUtility.addAttachmentbottom);
        WebElement UploadFile4 = driver.findElement(CDP_Utility.file);
        String testtDataPath = System.getProperty("user.dir");
        UploadFile4.sendKeys(testtDataPath + path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
    }

    public void addAttachmentAddActivityPage(String path) throws InterruptedException {
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.AddAttachment);
        helper.scrollIntoView(ForcedAbatementUtility.AddAttachment);
        helper.clickByJsExecuter(ForcedAbatementUtility.AddAttachment);
        WebElement UploadFile4 = driver.findElement(CDP_Utility.file);
        String testtDataPath = System.getProperty("user.dir");
        UploadFile4.sendKeys(testtDataPath + path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
    }

    public void addLocationCCP() throws InterruptedException {
        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect1o)
                || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
            serachLocationCCP(searchLocationKey1O);

        } else if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {
            serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_QA"));
//			serachLocationCCP("123 4TH AVE N");
        } else {
            serachLocationCCP(searchLocationKey);
        }

    }

    public void addViolationCCP() throws InterruptedException {

        helper.waitForElementIsInteractable(CCPUtility.StreetAdd);
        helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
        helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
        helper.waitForCurserRunning(5);
        try {
            helper.movetoElementAndClick(CCPUtility.ViolationSearchBox);
        } catch (Exception e) {
            helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
            helper.clickByJsExecuter(CCPUtility.ViolationSearchBox);
        }
        helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, PropertiesUtils.getPropertyValue("WaterViolation"));
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CCPUtility.violationListlabel, PropertiesUtils.getPropertyValue("WaterViolation"))));
        try {
            helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
            helper.waitForCurserRunning(3);
            helper.clickByJsExecuter(CCPUtility.ViolationsList);
        } catch (StaleElementReferenceException e) {
            WebElement violationsList = driver.findElement(CCPUtility.violationSuggested);
            helper.waitForElementInteractable(violationsList);
            helper.clickOnElement(violationsList);
        }

    }

    public void addViolationParam(String vName) throws InterruptedException {
        helper.forcedWaitTime(5);
        helper.scrollIntoView(CCPUtility.ViolationSearchBox);
        helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
        helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
        helper.waitUntilElementPresent(CCPUtility.ViolationSearchBox);
        // helper.scrollIntoView(CCPUtility.ViolationSearchBox);
        try {
            helper.clickByJsExecuter(CCPUtility.ViolationSearchBox);

        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickOn(CCPUtility.ViolationSearchBox);

        }
        helper.forcedWaitTime(3);
//		helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
        helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
        // helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, vName);
        // helper.sendKeysUsingJs(CCPUtility.ViolationSearchBox,vName);
        // added send keys by actions as js and selenium send keys were failing
        helper.sendKeysUsingActions(CCPUtility.ViolationSearchBox, vName);
        helper.forcedWaitTime(1);
        helper.waitForElementIsInteractable(CCPUtility.violationSearchResultsBox);
        Boolean flag = helper.elementIsDisplayed(CCPUtility.violationSearchResultsBox);
        if (flag == false) {
            helper.clearByJSE(CCPUtility.ViolationSearchBox);
            helper.sendKeysUsingActions(CCPUtility.ViolationSearchBox, vName);
            helper.forcedWaitTime(2);

        }
        helper.waitUntilElementIsVisible(CCPUtility.ViolationsList);
        helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
        // helper.scrollIntoView(CCPUtility.ViolationsList);
        try {
            helper.clickByJsExecuter(CCPUtility.ViolationsList);
        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickOn(CCPUtility.ViolationsList);
        }

    }

    public void ce_addContact() throws InterruptedException {

        helper.waitUntilElementIsVisible(CCPUtility.AddContactField);
        helper.scrollIntoView(CCPUtility.violationSearch_Box);
        helper.waitUntilElementIsVisible(CCPUtility.AddContactField);
        helper.waitForElementIsInteractable(CCPUtility.AddContactField);
        try {
            helper.forcedWaitTime(2);
            helper.sendKeysWithWait(CCPUtility.AddContactField, "zzzz");

            helper.forcedWaitTime(2);
        } catch (Exception e) {
            helper.forcedWaitTime(2);
            helper.clickOn(CCPUtility.AddContactField);
            helper.forcedWaitTime(2);

        }
        do {
            // Check if the "Add Contact" element is displayed
            Boolean isAddContactDisplayed = helper.elementIsDisplayed(CCPUtility.CreateNewContact);

            // If not displayed, call the add contact method
            if (!isAddContactDisplayed) {
                helper.movetoElementAndClick(CCPUtility.AddContactField);
            }

            // Break the loop after the first check, so it only runs once
            System.out.println("Executed recursion");
        } while (false);
        helper.waitUntilElementIsVisible(CCPUtility.CreateNewContact);
        helper.waitForElementIsInteractable(CCPUtility.CreateNewContact);
        helper.clickByJsExecuter(CCPUtility.CreateNewContact);
        String RandomName = RandomStrings.requiredCharacters(8);
        String RandomMail = RandomName + "@yopmail.com";
        String RandomContact = RandomStrings.requiredDigits(10);
        helper.sendKeysWithWait(CCPUtility.NameField, RandomName);
        helper.sendKeysWithWait(CCPUtility.EmailField, RandomMail);
        helper.sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);

        helper.scrollIntoView(CCPUtility.CreateContactBtn);
        // handle the review contact popup
        helper.handleReviewContact();
        helper.waitForElementIsInteractable(CCPUtility.CreateContactBtn);
        try {
            helper.clickOn(CCPUtility.CreateContactBtn);
        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickByJsExecuter(CCPUtility.CreateContactBtn);
        }

        helper.waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.ApplyButton);
        helper.clickOn(CCPUtility.ApplyButton);

    }

    public void ce_addContact2() throws InterruptedException {

        String RandomName = RandomStrings.requiredCharacters(8);

        helper.sendKeysWithWait(CCPUtility.NameField, RandomName);

        helper.scrollIntoView(CCPUtility.CreateContactBtn2);
        // handle the review contact popup
        helper.handleReviewContact();
        helper.waitForElementIsInteractable(CCPUtility.CreateContactBtn2);
        try {
            helper.clickOn(CCPUtility.CreateContactBtn2);
        } catch (Exception e) {
            helper.forcedWaitTime(3);
            helper.clickByJsExecuter(CCPUtility.CreateContactBtn2);
        }

        helper.waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.ApplyButton);
        helper.clickOn(CCPUtility.ApplyButton);

    }

    public void serachLocationCCP(String Address) throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.LocationFld);
        helper.waitForElementIsInteractable(CCPUtility.LocationFld);
        helper.sendKeysUsingActions(CCPUtility.LocationFld, Address);
        helper.waitUntilElementPresent(CCPUtility.locationCrossBtn);

        if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
            helper.forcedWaitTime(3);
           // helper.waitUntilElementIsVisible(CCPUtility.locationCrossBtn);
            int locations = helper.findElementsSize(CCPUtility.MapGis2);
            if (locations == 0) {
                helper.clearByJSE(CCPUtility.LocationFld);
                helper.waitForElementIsInteractable(CCPUtility.LocationFld);
                helper.sendKeysUsingActions(CCPUtility.LocationFld, Address);
                helper.waitUntilElementIsVisible(CCPUtility.locationCrossBtn);
            }

            try {
                helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
                helper.waitForElementIsInteractable(CCPUtility.MapGis2);
                helper.clickOn(CCPUtility.MapGis2);
            } catch (Exception e) {
                helper.forcedWaitTime(3);
                helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
                helper.waitForElementIsInteractable(CCPUtility.MapGis2);
                helper.clickOn(CCPUtility.MapGis2);
            }

        } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
            helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
            helper.waitForElementIsInteractable(CCPUtility.MapGis2);
            helper.clickByJsExecuter(CCPUtility.MapGis2);
            // helper.clickByJsExecuter(By.xpath(GisDataAddress));

        } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
            helper.waitForCurserRunning(5);
            helper.forcedWaitTime(2);
            helper.waitUntilElementIsVisible(searchLocationCCP);
            helper.scrollIntoView(searchLocationCCP);
            helper.waitForElementIsInteractable(searchLocationCCP);
            helper.clickOn(searchLocationCCP);
            helper.waitForCurserRunning(5);

        } else {
            helper.clearByJSE(CCPUtility.LocationFld);
            helper.sendKeysUsingActions(CCPUtility.LocationFld, Address);
            helper.forcedWaitTime(2);
            helper.waitUntilElementIsVisible(CCPUtility.Map3);
            helper.waitUntilElementIsVisible(CCPUtility.Map3);
            helper.waitForElementIsInteractable(CCPUtility.Map3);
            helper.clickByJsExecuter(CCPUtility.Map3);
        }
        helper.waitForCurserRunning(15);

    }

    public void creation50PlusCases() throws InterruptedException {

        for (int i = 0; i <= 50; i++) {
            createCaseCCP();
            helper.waitUntilElementIsVisible(CloseCaseUtility.CloseCDPIcon);
            helper.scrollIntoView(CloseCaseUtility.CloseCDPIcon);
            helper.waitForElementIsInteractable(CloseCaseUtility.CloseCDPIcon);
            helper.clickOn(CloseCaseUtility.CloseCDPIcon);
            helper.waitUntilElementInvisibleLocated(CloseCaseUtility.CloseCDPIcon);
            helper.waitForCurserRunning(4);

        }
    }


    public void handleUnwantedPopupOnCCP() throws InterruptedException {
        int countCheck = helper.findElementsSize(okay);
        if (countCheck > 0) {

            helper.clickByJsExecuter(okay);
            helper.forcedWaitTime(3);
            navigateToCCP();
        }

    }

    public void navigateToCCP() throws InterruptedException {
        try {
            helper.waitForCurserRunning(5);
            helper.refreshPage();
            helper.waitUntilElementIsVisible(CLPUtility.plusButtonHeader);
            helper.waitUntilElementPresent(CLPUtility.plusButtonHeader);
            WebElement CCPBtnJSE = driver.findElement(CLPUtility.plusButtonHeader);
            helper.scrollIntoView(CLPUtility.plusButtonHeader);
            helper.waitForElementInteractable(CCPBtnJSE);
            helper.waitForElementIsInteractable(CLPUtility.plusButtonHeader);
            helper.clickByJsExecuter(CLPUtility.plusButtonHeader);

            handleUnwantedPopupOnCCP();
            helper.waitUntilElementIsVisible(CCPUtility.CCPOption);
            helper.waitForElementIsInteractable(CCPUtility.CCPOption);
            helper.clickByJsExecuter(CCPUtility.CCPOption);

            handleUnwantedPopupOnCCP();
            helper.waitForCurserRunning(10);
            helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
            helper.waitUntilElementPresent(CCPUtility.CCPTitle);
            helper.waitForElementIsInteractable(CCPUtility.CCButton);
        } catch (Exception e) {
            System.out.println("enter in catch ");
            helper.forcedWaitTime(3);
            helper.refreshPage();
            helper.waitForCurserRunning(10);
            helper.waitUntilElementIsVisible(CLPUtility.plusButtonHeader);
            helper.waitUntilElementPresent(CLPUtility.plusButtonHeader);
            WebElement CCPBtnJSE = driver.findElement(CLPUtility.plusButtonHeader);
            helper.scrollIntoView(CLPUtility.plusButtonHeader);
            helper.waitForElementInteractable(CCPBtnJSE);
            helper.waitForElementIsInteractable(CLPUtility.plusButtonHeader);
            helper.clickByJsExecuter(CLPUtility.plusButtonHeader);

            handleUnwantedPopupOnCCP();
            helper.waitUntilElementIsVisible(CCPUtility.CCPOption);
            helper.waitForElementIsInteractable(CCPUtility.CCPOption);
            helper.clickByJsExecuter(CCPUtility.CCPOption);
            handleUnwantedPopupOnCCP();
            helper.waitForCurserRunning(10);
            helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
            helper.waitUntilElementPresent(CCPUtility.CCPTitle);
            helper.waitForElementIsInteractable(CCPUtility.CCButton);
        }
    }

    public void closeCaseDetailPage() throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPUtility.CloseCDP);
        helper.scrollIntoView(CCPUtility.CloseCDP);
        helper.waitForElementIsInteractable(CCPUtility.CloseCDP);
        helper.clickByJsExecuter(CCPUtility.CloseCDP);
        helper.waitUntilElementInvisibleLocated(CCPUtility.CloseCDP);
        helper.waitForCurserRunning(5);
    }

    public void navigateToUserManagement() throws InterruptedException {

        helper.waitUntilElementIsVisible(UserManagementUtility.UserMangementSideBar);
        helper.waitUntilElementPresent(UserManagementUtility.UserMangementSideBar);
        helper.scrollIntoView(UserManagementUtility.UserMangementSideBar);
        helper.waitForElementIsInteractable(UserManagementUtility.UserMangementSideBar);
        helper.clickByJsExecuter(UserManagementUtility.UserMangementSideBar);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(UserManagementUtility.CreateUserbtn);
        helper.waitUntilElementPresent(UserManagementUtility.CreateUserbtn);
        helper.waitForElementIsInteractable(UserManagementUtility.CreateUserbtn);

    }

    public void navigationToCaseListPage() throws InterruptedException {
        helper.waitUntilElementIsVisible(CLPUtility.CLP);
        helper.waitUntilElementPresent(CLPUtility.CLP);
        helper.scrollIntoView(CLPUtility.CLP);
        helper.waitForElementIsInteractable(CLPUtility.CLP);
        helper.waitForElementIsInteractable(CLPUtility.CLP);
        helper.clickByJsExecuter(CLPUtility.CLP);
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(CLPUtility.Cases);
        helper.waitUntilElementPresent(CLPUtility.Cases);

        int clearFilterText = helper.findElementsSize(CLPUtility.ClearAllFiltersLink);
        if (clearFilterText > 0)
            helper.clickByJsExecuter(CLPUtility.ClearAllFiltersLink);
        WebElement CasesText = helper.waitUntilVisibleWE(CLPUtility.Cases);
        if ((CasesText.isDisplayed()) == false) {

            SoftAssert s1 = new SoftAssert();
            s1.assertEquals(false, true);
            s1.assertAll();
        }

    }

    public void searchCaseAndNavigateToCDP(String caseId) throws InterruptedException {

        System.out.println("case id is " + caseId);
        navigationToCaseListPage();
        clearAllFilter();
        // Thread.sleep(5000);
        helper.waitUntilElementPresent(CLPUtility.CSLPSearchField);
        if (helper.findElementsSize(CLPUtility.ClearAllFiltersLink) > 0) {
            helper.waitForElementIsInteractable(CLPUtility.ClearAllFiltersLink);
            helper.clickByJsExecuter(CLPUtility.ClearAllFiltersLink);
        }
        helper.waitForElementIsInteractable(CLPUtility.CSLPSearchField);
        helper.WaitForGridTableEnable();
        helper.sendKeysWithWait(CLPUtility.CSLPSearchField, caseId);
        helper.waitForCurserRunning(2);
        helper.WaitForGridTableEnable();
        // helper.WaitForUntillCaseCountOne(By.xpath("(//span[@class='cases-count'])[1]"));
        Thread.sleep(5000);
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.waitForElementIsInteractable(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
        helper.waitForCurserRunning(10);
        helper.waitUntilElementIsVisible(By.xpath(CDP_Utility.openedCaseId));
        helper.forcedWaitTime(3);


    }

    public void createACase() throws InterruptedException {
        navigateToCCP();
        helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
        helper.waitForElementIsInteractable(CCPUtility.CCButton);
        addLocationCCP();
        helper.forcedWaitTime(2);
        ce_addContact();
        addViolationParam(PropertiesUtils.getPropertyValue("WaterViolation"));
        helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
        helper.scrollIntoView(CCPUtility.CreateCaseButton);
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickOn(CCPUtility.CreateCaseButton);
        helper.waitForCurserRunning(5);
        helper.forcedWaitTime(3);
        helper.handleReviewContact();
        // Thread.sleep(3000);
        // helper.handleReviewContact();

        helper.waitForCurserRunning(5);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AmandeepSingh"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("AmandeepSingh"));

        } else {
            selectCaseAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
            selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
        }
        helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
        helper.waitForCurserRunning(10);
        helper.waitUntilElementIsVisible(CCPUtility.CaseStatus);
        WebElement Case = helper.findElement(CCPUtility.CaseStatus);
        if ((Case.isDisplayed()) == false) {

            SoftAssert s62 = new SoftAssert();
            s62.assertEquals(false, true);
            s62.assertAll();
        }
    }

    public void addViolationWithEntity(String Vname, String entityName) throws InterruptedException {

        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
            helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
            helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
            helper.sendKeysUsingActions(CCPUtility.ViolationSearchBox, Vname);
            helper.forcedWaitTime(2);
            // helper.waitUntilElementIsVisible(CCPUtility.violationList20);
            // helper.waitForElementIsInteractable(CCPUtility.violationList20);
            Boolean flag = helper.elementIsDisplayed(CCPUtility.violationSearchResultsBox);
            if (flag == false) {
                helper.clearByJSE(CCPUtility.ViolationSearchBox);
                helper.sendKeysUsingActions(CCPUtility.ViolationSearchBox, Vname);
                helper.forcedWaitTime(2);

            }

            helper.clickByJsExecuter(CCPUtility.violationListNewLocator);
            helper.waitUntilElementIsVisible(CCPUtility.EntityField1);
            helper.waitForElementIsInteractable(CCPUtility.EntityField1);
            helper.sendKeysWithWait(CCPUtility.EntityField1, entityName);
            helper.waitForElementIsInteractable(CCPUtility.AddButton);
            helper.clickOn(CCPUtility.AddButton);

        } else {
            helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
            helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
            helper.clickOn(CCPUtility.ViolationSearchBox);
            helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, Vname);
            helper.waitUntilElementIsVisible(CCPUtility.ViolationList);
            helper.waitForElementIsInteractable(CCPUtility.ViolationList);
            helper.clickOn(CCPUtility.ViolationList);
            helper.waitUntilElementIsVisible(CCPUtility.EntityField1);
            helper.waitForElementIsInteractable(CCPUtility.EntityField1);
            helper.sendKeysWithWait(CCPUtility.EntityField1, entityName);
            helper.waitForElementIsInteractable(CCPUtility.AddButton);
            helper.clickOn(CCPUtility.AddButton);
        }
    }

    public void addSubmissionAssignmentRule(String attribute, String operator, String value, String assignee,
                                            String collaborator) throws InterruptedException {
        helper.waitUntilElementIsVisible(AddRuleButton);
        helper.clickByJsExecuter(AddRuleButton);
        helper.waitUntilElementIsVisible(CreateRule);
        helper.waitUntilElementPresent(CriteriaFields);
        helper.waitForElementIsInteractable(CriteriaFields);
        helper.clickOn(CriteriaFields);
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(attribute)));
        helper.clickOn(By.xpath(getSubmissionAttribute(attribute)));
        helper.waitUntilElementIsVisible(CriteriaFields2);
        helper.clickOn(CriteriaFields2);
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.clickOn(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.waitUntilElementIsVisible(CriteriaFields);
        helper.clickOn(CriteriaFields);
        helper.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute(value)));
        helper.scrollIntoView(By.xpath(getSubmissionAttribute(value)));
        helper.clickOn(By.xpath(getSubmissionAttribute(value)));

        helper.waitUntilElementIsVisible(DefaultAssigneeField);
        helper.scrollIntoView(DefaultAssigneeField);
        helper.clickOn(DefaultAssigneeField);
        helper.waitUntilElementIsVisible(AssigneeSearch);
        helper.sendKeysWithWait(AssigneeSearch, assignee);
        helper.waitUntilElementIsVisible(SearchedAssignee);
        helper.waitForElementIsInteractable(SearchedAssignee);
        helper.clickOn(SearchedAssignee);

        helper.waitForElementIsInteractable(SelectCollaboratorField);
        helper.clickOn(SelectCollaboratorField);
        helper.waitForElementIsInteractable(CollaboratorSearch);
        helper.sendKeysWithWait(CollaboratorSearch, collaborator);

        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvQa"))) {
            helper.waitUntilElementIsVisible(CollaboratorQA);
            helper.clickOn(CollaboratorQA);
        } else {
            helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(collaborators, collaborator)));
            helper.clickByJsExecuter(By.xpath(helper.selectorFormate(collaborators, collaborator)));
            // helper.clickOn(CollaboratorsOption);
        }
        helper.waitForElementIsInteractable(CreateRulebutton);
        helper.clickOn(CreateRulebutton);
        helper.waitUntilElementInvisibleLocated(CreateRulebutton);

        helper.waitForCurserRunning(2);
        helper.waitUntilElementIsVisible(AddedRule);
        helper.waitUntilElementPresent(AddedRule);
    }

    public void addAssignee(String assignee, String collaborator) throws InterruptedException {
        helper.waitUntilElementIsVisible(DefaultAssigneeField);
        helper.scrollIntoView(DefaultAssigneeField);
        helper.clickOn(DefaultAssigneeField);
        helper.waitUntilElementIsVisible(AssigneeSearch);
        helper.sendKeysWithWait(AssigneeSearch, assignee);
        helper.waitUntilElementIsVisible(SearchedAssignee);
        helper.waitForElementIsInteractable(SearchedAssignee);
        helper.clickOn(SearchedAssignee);

        helper.waitForElementIsInteractable(SelectCollaboratorField);
        helper.clickOn(SelectCollaboratorField);
        helper.waitForElementIsInteractable(CollaboratorSearch);
        helper.sendKeysWithWait(CollaboratorSearch, collaborator);

        helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(collaborators, collaborator)));
        helper.clickByJsExecuter(By.xpath(helper.selectorFormate(collaborators, collaborator)));


    }

    public void addSubmissionAssignmentRule2(String attribute, String operator, String value, String assignee,
                                             String collaborator) throws InterruptedException {
        helper.waitUntilElementIsVisible(AddRuleButton);
        helper.clickByJsExecuter(AddRuleButton);
        helper.waitUntilElementIsVisible(CreateRule);
        helper.waitUntilElementPresent(CriteriaFields);
        helper.waitForElementIsInteractable(CriteriaFields);
        helper.clickOn(CriteriaFields);
        //	helper.clickOn();
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(attribute)));
        helper.clickOn(By.xpath(getSubmissionAttribute(attribute)));
        helper.waitUntilElementIsVisible(CriteriaFields2);
        helper.clickOn(CriteriaFields2);
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.clickOn(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.waitUntilElementIsVisible(CriteriaFields);
        helper.clickOn(CriteriaFields);
        helper.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute(value)));
        helper.scrollIntoView(By.xpath(getSubmissionAttribute(value)));
        helper.clickOn(By.xpath(getSubmissionAttribute(value)));

        helper.waitUntilElementIsVisible(DefaultAssigneeField);
        helper.scrollIntoView(DefaultAssigneeField);
        helper.clickOn(DefaultAssigneeField);
        helper.waitUntilElementIsVisible(AssigneeSearch);
        helper.sendKeysWithWait(AssigneeSearch, assignee);
        helper.waitUntilElementIsVisible(SearchedAssignee);
        helper.waitForElementIsInteractable(SearchedAssignee);
        helper.clickOn(SearchedAssignee);

        helper.waitForElementIsInteractable(SelectCollaboratorField);
        helper.clickOn(SelectCollaboratorField);
        helper.waitForElementIsInteractable(CollaboratorSearch);
        helper.sendKeysWithWait(CollaboratorSearch, collaborator);

        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvQa"))) {
            helper.waitUntilElementIsVisible(CollaboratorQA);
            helper.clickOn(CollaboratorQA);
        } else {
            helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(collaborators, collaborator)));
            helper.clickByJsExecuter(By.xpath(helper.selectorFormate(collaborators, collaborator)));
            // helper.clickOn(CollaboratorsOption);
        }
        helper.waitForElementIsInteractable(CreateRulebutton);
        helper.clickOn(CreateRulebutton);
        helper.waitUntilElementInvisibleLocated(CreateRulebutton);

        helper.waitForCurserRunning(2);
        helper.waitUntilElementIsVisible(AddedRule);
        helper.waitUntilElementPresent(AddedRule);
    }

    public void deleteRules(int ruleCount) throws InterruptedException {
        int check = driver.findElements(CrossIconRuleSet).size();
        if (check > ruleCount) {
            helper.waitForElementIsInteractable(CrossIconRuleSet);
            Boolean crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
            while (crosscheck) {
                helper.waitForElementIsInteractable(CrossIconRuleSet);
                driver.findElement(CrossIconRuleSet).click();

                if (driver.findElements(CrossIconRuleSet).size() > 0) {
                    crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
                } else {
                    crosscheck = false;
                }
            }
        }
    }

    public void addCaseAssignmentRule(String attribute, String operator, String value, String caseassignee,
                                      String inspectionAssignee) throws InterruptedException {
        helper.waitUntilElementIsVisible(AddRuleButton);
        helper.waitForElementIsInteractable(AddRuleButton);
        helper.forcedWaitTime(1);
        helper.clickOn(AddRuleButton);
        helper.waitUntilElementIsVisible(CreateRule);
        helper.waitUntilElementPresent(CriteriaFields);
        helper.waitForElementIsInteractable(CriteriaFields);
        helper.clickOn(CriteriaFields);
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(attribute)));
        helper.clickOn(By.xpath(getSubmissionAttribute(attribute)));
        helper.waitUntilElementIsVisible(CriteriaFields2);
        helper.clickOn(CriteriaFields2);
        helper.forcedWaitTime(3);
        helper.waitForElementIsInteractable(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.clickOn(By.xpath(getSubmissionAttributeOperator(operator)));
        helper.waitUntilElementIsVisible(CriteriaFields);
        helper.clickOn(CriteriaFields);
        helper.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute(value)));
        helper.scrollIntoView(By.xpath(getSubmissionAttribute(value)));
        helper.clickByJsExecuter(By.xpath(getSubmissionAttribute(value)));

        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.CaseAssignee);
        helper.scrollIntoView(SubmissionAssignmentUtility.CaseAssignee);
        helper.clickOn(SubmissionAssignmentUtility.CaseAssignee);
        helper.waitUntilElementIsVisible(caseAssigneeSearch);
        helper.sendKeysWithWait(caseAssigneeSearch, caseassignee);
        helper.waitUntilElementIsVisible(caseAssigneeList);
        helper.waitForElementIsInteractable(caseAssigneeList);
        helper.clickOn(caseAssigneeList);

        helper.waitForElementIsInteractable(insepctionAssignee);
        helper.clickOn(insepctionAssignee);
        helper.waitForElementIsInteractable(insepctionAssigneeSearch);
        helper.sendKeysWithWait(insepctionAssigneeSearch, inspectionAssignee);

        helper.waitUntilElementIsVisible(insepctionAssingeeList);
        helper.clickOn(insepctionAssingeeList);

        helper.waitForElementIsInteractable(CreateRulebutton);
        helper.clickByJsExecuter(CreateRulebutton);
        helper.waitUntilElementInvisibleLocated(CreateRulebutton);

        helper.waitForCurserRunning(2);
        helper.waitUntilElementIsVisible(AddedRule);
        helper.waitUntilElementPresent(AddedRule);
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

    public void createCaseWithCustomeNotices(String NoticeName) throws InterruptedException {
        createCaseAndPerformInspection();
        helper.scrollIntoView(PerformInspectionUtility.ContinueBtn);
        helper.clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
        helper.forcedWaitTime(2);
        int size = driver.findElements(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName)))
                .size();
        if (size > 0) {
            helper.clickByJsExecuter(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName)));
        } else {

            Thread.sleep(3000);

            if (helper.findElementsSize(notice) > 0) {
                helper.waitForElementIsInteractable(notice);

                helper.clickOn(notice);
            } else {
                helper.waitForElementIsInteractable(PerformInspectionUtility.selectNoticeDownArrow);
                helper.clickOn(PerformInspectionUtility.selectNoticeDownArrow);

            }
            helper.forcedWaitTime(3);
            helper.scrollIntoViewWebElement(driver.findElement(
                    By.xpath(helper.stringFormat(PerformInspectionUtility.noticesInDropdownPI, NoticeName))));
            helper.movetoElementAndClick(driver.findElement(
                    By.xpath(helper.stringFormat(PerformInspectionUtility.noticesInDropdownPI, NoticeName))));

        }

        helper.clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
        helper.waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
        helper.scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);
        helper.waitUntilElementIsVisible(PerformInspectionUtility.DoNotPrintBtn);
        helper.scrollIntoView(PerformInspectionUtility.DoNotPrintBtn);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
        helper.forcedWaitTime(2);
        Assert.assertTrue(helper.findElementsSize(completeInspAndGenerateNoticeForApproval)>0);
        try {
            helper.clickByJsExecuter(completeInspAndGenerateNoticeForApproval);
            helper.waitForCurserRunning(5);
        } catch (Exception e) {
            helper.clickByJsExecuter(SupervisorUtility.completeInspAndGenerateNoticeForApproval2);
            helper.waitForCurserRunning(5);
        } finally {
            if (helper.findElementsSize(completeInspAndGenerateNoticeForApproval) > 0)
                helper.movetoElementAndClick(completeInspAndGenerateNoticeForApproval);
        }

    }

    public void approvedPendingEsclatedNoticeCDP() throws InterruptedException {
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approve Notice?")));
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approved")));
    }

    public void applyEsclatedNoticeCDP() throws InterruptedException {

        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Notice")));
        helper.scrollIntoView(
                By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Approved Notice")));
        helper.clickByJsExecuter(
                By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Approved Notice")));
        helper.clickByJsExecuter(CDP_Utility.applyApprovedNotice2);
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Yes")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Yes")));
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.appliedNoticePOpup, "Approved & Applied to Case")));
    }

    public void rejectORNotApprovedEsclatedNoticeCDP() throws InterruptedException {

        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approve Notice?")));
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
        helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
        helper.sendKeysWithWait(CDP_Utility.rejectNotice, "NoticeRejected");
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Not Approved")));

    }

    public void escaltedNoticeFilterApply(String filterCriteria) {
        helper.waitUntilElementIsVisible(
                By.xpath(helper.stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
        helper.waitUntilElementPresent(ExistingNoticeUtility.secFilter);
        helper.clickByJsExecuter(By.xpath(helper.stringFormat(CLPUtility.SecondaryFilterCriteria, filterCriteria)));
        helper.WaitForGridTableEnable();

    }

    public void logOutCurrentUser() throws InterruptedException {
        Thread.sleep(3000);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvQa")))
            Thread.sleep(5000);
        helper.waitForElementIsInteractable(LoginUtility.username);
        helper.movetoElementAndClick(LoginUtility.username);
        helper.waitForElementIsInteractable(LoginUtility.logout);
        helper.movetoElementAndClick(LoginUtility.logout);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(LoginUtility.OKTAUsernameField);

    }

    public void addCustomCategorySubmissionRule(String Category) throws InterruptedException {
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("MarkShane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("MarkShane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("MarkShane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {

            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Amandeep"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Amandeep"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Amandeep"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
        } else {
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Shane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Shane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
            addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("SubmissionCategory"), PropertiesUtils.getPropertyValue("Equals"), Category, PropertiesUtils.getPropertyValue("Shane"), PropertiesUtils.getPropertyValue("AmandeepSingh"));

        }

        helper.waitForElementIsInteractable(CaseAssignmentUtility.save);
        helper.clickByJsExecuter(CaseAssignmentUtility.save);
        helper.waitForCurserRunning(2);
    }

    public void selectScheduleFollowUpInspectionCheckbox() {
        Boolean checked = helper.elementIsChecked(CDP_Utility.scheduleFollowUpInspectonChkbox);
        System.out.println("checked : " + checked);
        if (checked == false) {
            try {
                helper.clickByJsExecuter(CDP_Utility.scheduleFollowUpInspectonChkbox);
            } catch (Exception e) {
                helper.waitForElementIsInteractable(CDP_Utility.scheduleFollowUpInspectonChkbox);
                helper.clickOn(CDP_Utility.scheduleFollowUpInspectonChkbox);
            }

        }

    }

    public void initiateForceAbatement() throws InterruptedException {
        helper.waitUntilElementPresent(ForcedAbatementUtility.MoreBtn);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
        helper.clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.InitiateFABtn);
        helper.clickOn(ForcedAbatementUtility.InitiateFABtn);
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.PopupTitleFA);
        helper.sendKeysWithWait(ForcedAbatementUtility.NoteField, "Notes for FA");
        helper.waitForElementIsInteractable(ForcedAbatementUtility.IFAPopupBtn);
        helper.clickOn(ForcedAbatementUtility.IFAPopupBtn);
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.AbatementInfo);
    }

    public void clickOnAddActivityBtn() throws InterruptedException {
        helper.waitForElementIsInteractable(ForcedAbatementUtility.AddActivityBtn);
        helper.clickByJsExecuter(ForcedAbatementUtility.AddActivityBtn);
        helper.waitForCurserRunning(3);
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.FAactivityPopup);
    }

    public void clickOnSelectFADocDropdown() throws InterruptedException {

        helper.waitForElementIsInteractable(ForcedAbatementUtility.selectFAADocArrow);
        helper.clickOn(ForcedAbatementUtility.selectFAADocArrow);
        Thread.sleep(5000);
    }

    public void searchFADocument(String fAADoc) throws InterruptedException {
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.SearchFADoc);
        helper.sendKeysWithWait(ForcedAbatementUtility.SearchFADoc, fAADoc);
        helper.forcedWaitTime(2);
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.SearchedFAdoc);
        // helper.clickByJsExecuter(ForcedAbatementUtility.SearchedFAdoc);

    }

    public void clickOnSearchedFADoc() {
        helper.clickByJsExecuter(ForcedAbatementUtility.SearchedFAdoc);
    }

    public Boolean FAdocumentIsDisplayed() {
        Boolean checkDoc = helper.elementIsDisplayed(ForcedAbatementUtility.SearchedFAdoc);
        return checkDoc;

    }

    public String associatedFineNameWithFAdoc() {
        String checkFineName = helper.getTextElement(ForcedAbatementUtility.AssociatedFineName);
        return checkFineName;
    }

    public String associatedFineAmountWithFAdoc() {
        String checkFineAmount = helper.getSpecificAttribute(ForcedAbatementUtility.FineAmount, "value");
        return checkFineAmount;
    }

    public void enterFAADetails() throws InterruptedException {
        helper.waitForElementIsInteractable(ForcedAbatementUtility.LabelForText1);
        helper.sendKeysWithWait(ForcedAbatementUtility.LabelForText1, "C123C456");
        helper.sendKeysWithWait(ForcedAbatementUtility.LabelForNumber2, "12345");
        helper.clickOn(ForcedAbatementUtility.LabelForSelect3);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.FirstOption);
        helper.clickOn(ForcedAbatementUtility.FirstOption);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.labelForCaseID);
        helper.sendKeysWithWait(ForcedAbatementUtility.labelForCaseID, ForcedAbatementUtility.caseIdValue);
        helper.scrollIntoView(ForcedAbatementUtility.ContinueToGenDoc);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.ContinueToGenDoc);
        helper.clickOn(ForcedAbatementUtility.ContinueToGenDoc);
        helper.waitForCurserRunning(4);
        Thread.sleep(3000);
    }

    public void clickOnGenerateDocumentBtn() throws InterruptedException {
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.GenFAADoc);
        helper.waitForElementIsInteractable(ForcedAbatementUtility.GenFAADoc);
        helper.clickOn(ForcedAbatementUtility.GenFAADoc);
        helper.waitForCurserRunning(5);

    }

    public void clickonDonotPrintBtn() throws InterruptedException {
        helper.waitForElementIsInteractable(PerformInspectionUtility.doNotPrint);
        helper.clickOn(PerformInspectionUtility.doNotPrint);

    }

    public void clickonGenerateFAAdocuemtn() throws InterruptedException {
        helper.clickOn(ForcedAbatementUtility.GenerateDocAddFABtn);
        helper.waitForCurserRunning(5);
        helper.waitUntilElementIsVisible(ForcedAbatementUtility.AddedActivity);
    }

    public void clickOnHamburger() {
        helper.waitUntilElementIsVisible(AgencyCreationUtility.cssHamburger);
        helper.clickByJsExecuter(AgencyCreationUtility.cssHamburger);

    }

    public void navigationToFinancePage() throws InterruptedException {
        clickOnHamburger();
        helper.waitUntilElementIsVisible(FinanceUtility.financeLabel);
        helper.clickByJsExecuter(FinanceUtility.financeLabel);
        helper.forcedWaitTime(3);
        helper.waitForCurserRunning(4);
        helper.waitUntilElementIsVisible(FinanceUtility.financeHeading);

    }

    public String getFineTransactionGridData() {
        String fineName = helper.getTextElement(FinesUtility.finesGrid);
        return fineName;

    }

    public void clickOnFineToggelBtn() throws InterruptedException {
        helper.waitForElementIsInteractable(FinesUtility.finesBtn);
        helper.clickByJsExecuter(FinesUtility.finesBtn);
        helper.forcedWaitTime(3);
        helper.waitForCurserRunning(5);

    }

    public void CCPGisDirectPinLocation() throws InterruptedException {

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

            WebElement element = helper.findElement(AgencyCreationUtility.map);
            Point offset = element.getLocation();
            // Required in future.
            int xoffset = offset.getX();
            int yoffset = offset.getY();
//			xoffset = -20;
//			yoffset = -20;
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
            helper.forcedWaitTime(3);
            try {
                element.click();
            } catch (Exception e) {
                element.click();

            }
            // for future use if pin condition is not worked then we use this
//			int xoffset = offset.getX();
//			int yoffset = offset.getY();
//			xoffset = -20;
//			yoffset = -20;

//			Actions actions = new Actions(driver);
//			Thread.sleep(3000);
//			actions.moveToElement(element, xoffset, yoffset).click().perform();

            helper.waitUntilVisibleWE(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
        } else {
            System.out.println("enter in else conidition");
            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
            WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
            String aria = zoomIn.getAttribute("aria-disabled");

            WebElement element = helper.findElement(AgencyCreationUtility.map);
            Point offset = element.getLocation();
            int xoffset = offset.getX();
            int yoffset = offset.getY();
            xoffset = -20;
            yoffset = -20;

            Actions actions = new Actions(driver);
            helper.forcedWaitTime(3);
            actions.moveToElement(element, xoffset, yoffset).click().perform();
            helper.waitUntilVisibleWE(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
        }
        helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
        helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
    }

    public void CCPGisDirectSelectAPNAddress() throws InterruptedException {
        helper.waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);

        helper.scrollIntoView(CCPDirect20Utility.ApnAddrresses);
        helper.waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
        helper.clickOn(CCPDirect20Utility.ApnAddrresses);
        helper.waitForCurserRunning(8);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.EditLocIcon);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
        CCPDirect20Utility.ValidateStreetAdd = helper.getTextElement(CCPDirect20Utility.StreetLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
        CCPDirect20Utility.validatestate = helper.getTextElement(CCPDirect20Utility.stateLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
        CCPDirect20Utility.validateCity = helper.getTextElement(CCPDirect20Utility.CityLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
        CCPDirect20Utility.validateZip = helper.getTextElement(CCPDirect20Utility.ZipLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
        CCPDirect20Utility.validateApn = helper.getTextElement(CCPDirect20Utility.apnLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
        CCPDirect20Utility.validateOwnerName = helper.getTextElement(CCPDirect20Utility.OwnerName);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
        CCPDirect20Utility.validateOwnerAddress = helper.getTextElement(CCPDirect20Utility.OwnerAddress);
    }

    public void CCPGisDirectSelectComcateAddress() throws InterruptedException {

        helper.forcedWaitTime(2);
        helper.scrollIntoView(CCPDirect20Utility.ComcateAddresses);
        helper.forcedWaitTime(2);
        helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
        helper.waitForCurserRunning(8);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.EditLocIcon);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
        CCPDirect20Utility.ValidateStreetAdd = helper.getTextElement(CCPDirect20Utility.StreetLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
        CCPDirect20Utility.validatestate = helper.getTextElement(CCPDirect20Utility.stateLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
        CCPDirect20Utility.validateCity = helper.getTextElement(CCPDirect20Utility.CityLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
        CCPDirect20Utility.validateZip = helper.getTextElement(CCPDirect20Utility.ZipLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
        CCPDirect20Utility.validateApn = helper.getTextElement(CCPDirect20Utility.apnLabel);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
        CCPDirect20Utility.validateOwnerName = helper.getTextElement(CCPDirect20Utility.OwnerName);
        helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
        CCPDirect20Utility.validateOwnerAddress = helper.getTextElement(CCPDirect20Utility.OwnerAddress);
    }

    public void SelectGISDataAddressOnCDP() throws InterruptedException {
        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearElement(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
            helper.waitUntilElementIsVisible(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
            helper.forcedWaitTime(4);
            helper.clickByJsExecuter(GisDataAddress);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
        } else {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearElement(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
            helper.waitUntilElementIsVisible(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
            helper.forcedWaitTime(4);
            helper.clickOn(GisDataAddress);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
        }
    }

    public void SelectComcateApplicationAddressOnCSDP() throws InterruptedException {
        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitForElementIsInteractable(CSDPGISDirect20Utility.EditLocation_btn);
            helper.clickByJsExecuter(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearElement(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
            helper.forcedWaitTime(4);
            helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
            helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);

        } else {
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitForElementIsInteractable(CSDPGISDirect20Utility.EditLocation_btn);
            helper.clickByJsExecuter(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearElement(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
            helper.forcedWaitTime(4);
            helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
            helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);

        }

    }

    public void SelectGISDataAddressOnCSDP() throws InterruptedException {
        if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearByJSE(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
            helper.waitUntilElementIsVisible(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
            helper.forcedWaitTime(4);
            helper.clickByJsExecuter(GisDataAddress);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
        } else {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearByJSE(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
            helper.waitUntilElementIsVisible(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
            helper.forcedWaitTime(4);
            helper.clickByJsExecuter(GisDataAddress);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
            helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
        }
    }

    public void SelectComcateApplicationAddressOnCDP() throws InterruptedException {
        if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditLocation_btn);
            helper.clickByJsExecuter(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearByJSE(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
            helper.forcedWaitTime(4);
            helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
            helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.handleReviewContactWhileUpdatingAddress();
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
        } else {
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditLocation_btn);
            helper.clickByJsExecuter(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
            helper.waitForElementIsInteractable(CCPUtility.LocationFld);
            helper.clickOn(CCPUtility.LocationFld);
            helper.clearByJSE(CCPUtility.LocationFld);
            crmCommonMethods.serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20"));
            helper.forcedWaitTime(4);
            helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
            helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            helper.forcedWaitTime(4);
            helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
            helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
            helper.waitForCurserRunning(2);
            helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
            helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);

        }
    }

    public void openCreateRolePopUp() throws InterruptedException {
        helper.scrollIntoView(UserManagementUtility.RolesTab);
        helper.waitForElementIsInteractable(UserManagementUtility.RolesTab);
        helper.clickByJsExecuter(UserManagementUtility.RolesTab);
        helper.waitForElementIsInteractable(UserManagementUtility.CreateRoleButton);
        helper.clickByJsExecuter(UserManagementUtility.CreateRoleButton);
        helper.forcedWaitTime(5);
        // waitUntilElementInvisibleLocated(CreateRoleButton);
        helper.waitUntilElementIsVisible(UserManagementUtility.CreateRolePopupTitle);
    }

    public void roleCreationWithCECRMSettings(String roleName, String role, String description) throws InterruptedException {

        helper.waitUntilElementIsVisible(UserManagementUtility.RoleNameField);
        helper.waitUntilElementPresent(UserManagementUtility.RoleNameField);
        helper.waitForElementIsInteractable(UserManagementUtility.RoleNameField);
        helper.sendKeysWithWait(UserManagementUtility.RoleNameField, roleName);
        helper.sendKeysWithWait(UserManagementUtility.DescriptionField, description);

        helper.clickOn(UserManagementUtility.siteSettingUserAdmin);
        helper.clickOn(UserManagementUtility.siteSettingSiteAdmin);
        helper.waitForElementIsInteractable(UserManagementUtility.ProductSettingsToggle);
        helper.clickOn(UserManagementUtility.ProductSettingsToggle);
        helper.waitForElementIsInteractable(UserManagementUtility.CRMSettingToggel);
        helper.clickOn(UserManagementUtility.CRMSettingToggel);

        if (role.equalsIgnoreCase(PropertiesUtils.getPropertyValue("BasicSupervisor"))) {
            helper.clickOn(UserManagementUtility.productAdminYes);
            helper.clickOn(UserManagementUtility.basicSupervisorToggle);
            helper.clickOn(UserManagementUtility.allStaffToggel);
            helper.clickOn(UserManagementUtility.allStaffDashboard);
            helper.clickOn(UserManagementUtility.canVoidWaive);
            helper.clickOn(UserManagementUtility.productExecutiveReport);
            helper.clickOn(UserManagementUtility.productDeleteAndReissue);

            helper.clickOn(UserManagementUtility.violationAnimalBasic);
            helper.clickOn(UserManagementUtility.generalViolationBasic);
            helper.clickOn(UserManagementUtility.crmProductAdminYes);
            helper.clickOn(UserManagementUtility.crmExecutiveReport);
            helper.clickOn(UserManagementUtility.crmPermissionBasic);
            helper.clickOn(UserManagementUtility.commLinkToggle);

        } else if (role.equalsIgnoreCase(PropertiesUtils.getPropertyValue("SupervisorManager"))) {
            helper.clickOn(UserManagementUtility.supervisorManager);

            helper.clickOn(UserManagementUtility.productAdminYes);
            helper.clickOn(UserManagementUtility.allStaffToggel);
            helper.clickOn(UserManagementUtility.allStaffDashboard);
            helper.clickOn(UserManagementUtility.canVoidWaive);
            helper.clickOn(UserManagementUtility.productExecutiveReport);
            helper.clickOn(UserManagementUtility.productDeleteAndReissue);

            helper.clickOn(UserManagementUtility.violationAdminOverwrite);
            helper.clickOn(UserManagementUtility.generalViolationOverwrite);
            helper.clickOn(UserManagementUtility.crmProductAdminYes);
            helper.clickOn(UserManagementUtility.crmExecutiveReport);
            helper.clickOn(UserManagementUtility.crmOverwritePermission);
            helper.clickOn(UserManagementUtility.commLinkToggle);

        }

        helper.scrollIntoView(UserManagementUtility.CreateRolePopupBtn);
        helper.waitForElementIsInteractable(UserManagementUtility.CreateRolePopupBtn);
        helper.clickOn(UserManagementUtility.CreateRolePopupBtn);
        helper.waitForElementIsInteractable(UserManagementUtility.RoleCreatedSuccessMsg);
        String SuccessMsg = helper.getTextElement(UserManagementUtility.RoleCreatedSuccessMsg);
        Assert.assertEquals(SuccessMsg, "Role created");

    }

    // adding search func.
    public void serachLocationCCPNoClick(String Address) throws InterruptedException {
        helper.waitUntilElementIsVisible(LocationSearchField);
        helper.waitForElementIsInteractable(LocationSearchField);
        helper.sendKeysWithWait(LocationSearchField, Address);
        helper.waitForPresenceandVisiblity(LocationSearchResult);
        helper.waitForElementIsInteractable(LocationSearchResult);
    }

    public String extractAddressFunction(String address) {
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

    public String extractCaseIdOnCDP(String caseId) {
        int hashIndex = caseId.indexOf('#');
        // Extract the part before the '#'
        String result = caseId.substring(hashIndex + 1).trim();
        return (result); // Output: "Case"
    }

    public void navigateToDashboard() throws InterruptedException {
        helper.clickByJsExecuter(DashBoardUtility.dashboardTab);
        helper.forcedWaitTime(3);

    }

    public int countCasesUsingPagenationToLastPage(int noOfElementsOnSinglePage) throws InterruptedException {
        helper.waitUntilElementIsVisible(CLPUtility.CasesCount);
        helper.forcedWaitTime(5);
        String[] CountOfCases = helper.getTextElement(CLPUtility.CasesCount).split(" ");
        String CountHeader = CountOfCases[0];

        int CountAtHeader = Integer.parseInt(CountHeader);
        System.out.println(CountAtHeader);
        int caseCount;
        WebElement pagenationIndexBoxCLP = helper.findElement(CLPUtility.pagenationBar);
        String[] PaginationCounts = helper.getTextElement(CLPUtility.PaginationCount).split(" ");
        String pageCounts = PaginationCounts[1];
        int pageCnt = Integer.parseInt(pageCounts);
        System.out.println(pageCnt);
        if (pageCnt > 1) {

            caseCount = noOfElementsOnSinglePage * (pageCnt - 1);
            Actions a = new Actions(driver);
            a.moveToElement(pagenationIndexBoxCLP).doubleClick().build().perform();
            helper.forcedWaitTime(2);
            a.sendKeys(pageCounts).sendKeys(Keys.ENTER).build().perform();
            helper.forcedWaitTime(2);
            helper.waitForElementIsInteractable(CLPUtility.caseIdCheckboxCLP);
            int case_Count = helper.findElementsSize(CLPUtility.caseIdCheckboxCLP);
            caseCount = caseCount + case_Count;
        } else {
            caseCount = helper.findElementsSize(CLPUtility.caseIdCheckboxCLP);
            Boolean checkNext = driver.findElement(CLPUtility.NextPagination).isEnabled();
            while (checkNext) {
                helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
                helper.scrollIntoView(CLPUtility.NextPagination);
                helper.waitForElementIsInteractable(CLPUtility.NextPagination);
                helper.clickByJsExecuter(CLPUtility.NextPagination);
                helper.WaitForGridTableEnable();
                helper.forcedWaitTime(5);
                helper.scrollTillPageEnd();
                int case_Count = helper.findElementsSize(CLPUtility.caseIdCheckboxCLP);
                caseCount = caseCount + case_Count;
                helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
                helper.scrollIntoView(CLPUtility.NextPagination);
                checkNext = driver.findElement(CLPUtility.NextPagination).isEnabled();
            }
        }

        helper.forcedWaitTime(3);
        helper.waitUntilElementIsVisible(CLPUtility.CaseID);
        helper.waitUntilElementPresent(CLPUtility.CaseID);
        SoftAssert s11 = new SoftAssert();
        s11.assertEquals(caseCount, CountAtHeader);
        s11.assertAll();

        return caseCount;

    }

    public int countItemsUsingPagenation(int noOfItemsEachPage) throws InterruptedException {
        int itemsCount;
        WebElement pagenationIndexBoxCLP = helper.findElement(CLPUtility.pagenationBar);
        String[] PaginationCounts = helper.getTextElement(CLPUtility.PaginationCount).split(" ");
        String pageCounts = PaginationCounts[1];
        int pageCnt = Integer.parseInt(pageCounts);
        System.out.println(pageCnt);
        if (pageCnt > 1) {

            itemsCount = noOfItemsEachPage * (pageCnt - 1);
            Actions a = new Actions(driver);
            a.moveToElement(pagenationIndexBoxCLP).doubleClick().build().perform();
            helper.forcedWaitTime(2);
            a.sendKeys(pageCounts).sendKeys(Keys.ENTER).build().perform();
            helper.forcedWaitTime(2);
            helper.waitForElementIsInteractable(CLPUtility.noOfRowsOnPage);
            int itemsOnLastPage = helper.findElementsSize(CLPUtility.noOfRowsOnPage);
            itemsCount = itemsCount + itemsOnLastPage;
        } else {
            itemsCount = helper.findElementsSize(CLPUtility.caseIdCheckboxCLP);
            Boolean checkNext = driver.findElement(CLPUtility.NextPagination).isEnabled();
            while (checkNext) {
                helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
                helper.scrollIntoView(CLPUtility.NextPagination);
                helper.waitForElementIsInteractable(CLPUtility.NextPagination);
                helper.clickByJsExecuter(CLPUtility.NextPagination);
                helper.WaitForGridTableEnable();
                helper.forcedWaitTime(5);
                helper.scrollTillPageEnd();
                int itemsCount2 = helper.findElementsSize(CLPUtility.noOfRowsOnPage);
                itemsCount = itemsCount + itemsCount2;
                helper.waitUntilElementIsVisible(CLPUtility.NextPagination);
                helper.scrollIntoView(CLPUtility.NextPagination);
                checkNext = driver.findElement(CLPUtility.NextPagination).isEnabled();
            }
        }
        return itemsCount;

    }

    public void clearAllFilter() throws InterruptedException {
        Thread.sleep(5000);
        Reporter.log("I was called clear filters", true);
        helper.waitForPresenceandVisiblity(CLPUtility.PrintButtonCLP);

        while (helper.findElementsSize(CLPUtility.ClearAllFiltersLink) > 0) {
            helper.clickByJsExecuter(CLPUtility.ClearAllFiltersLink);
            Reporter.log("clear filter clicked", true);
        }
    }
    
    public void uploadAttachment(String attachmentPath) throws InterruptedException {
//    	if (driver instanceof RemoteWebDriver) {
//		    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
//		}
		
		String filePath = System.getProperty("user.dir") + attachmentPath;
		Log.info("File path: " + filePath);

		// Create file object and log existence
		File file = new File(filePath);
		Log.info("File exists: " + file.exists());

		if (!file.exists()) {
		    throw new RuntimeException("File not found at: " + filePath);
		}
		
				
		WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
		uploadInput.sendKeys(file.getAbsolutePath());
		
		helper.waitForCurserRunning(5);
    }

}
