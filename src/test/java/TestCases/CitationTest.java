package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.RandomStrings;
import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static POM.CitationUtility.*;
import static POM.OnlinePaymentUtility.*;
import static POM.OnlinePaymentUtility.SelectFineOptions;

public class CitationTest extends BrowsersInvoked {

   
    public int UnPaidFinePayment;
    public boolean finetypeAndAmout, fineAddedOn, cashPaymentAdded, partialPaymentLabel;
    public boolean paymentvoidLableIcon;
    public String PaymentvoidLableBtn;
    public boolean PaymentNullified;
    CitationUtility citationUtility;
    CECommonMethods ceCommonMethods;
    String violationName, editedViolation, fineAmmount, selectedNoticeName;
    String CitationViolation = "citationvio";
    String fine2;
    double actualFineammount;
    
    
    @BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
       
        citationUtility = new CitationUtility(getDriver());
        performInspectionUtility = new PerformInspectionUtility(getDriver());
        finesUtility = new FinesUtility(getDriver());
        op = new OnlinePaymentUtility(getDriver());
        ceCommonMethods = new CECommonMethods(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }

   

    int updatedFineAmountActual;
    String noticeNameCDP;
    OnlinePaymentUtility op;
    PerformInspectionUtility performInspectionUtility;
    FinesUtility finesUtility;

   

    @Test(priority = 0, description = "Login Test Case")
    public void LoginTest() throws InterruptedException {
        LoginUtility log = new LoginUtility(getDriver());
        System.out.println(BrowsersInvoked.suiteName);
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

    @Test(priority = 1, description = "Verify that user is able to create Citation Violation , after selecting the 'No' option from 'Inspection Required?' toggle, on 'Create Violation' popup .")
    public void verifyCitationViolationCreated() throws InterruptedException {
        citationUtility.navigateToViolationPageFromDashboard();
        violationName = "CitationViolation" + RandomStrings.requiredString(2);
        citationUtility.createCitationViolation(violationName, "No");
        SoftAssert st = new SoftAssert();

        st.assertEquals(citationUtility.popupTitle, "Create Violation", "Title doesnot match");
        st.assertEquals(citationUtility.getLastViolationRecord(), violationName, "Violation name doesnot match");
        st.assertAll();


    }

    @Test(priority = 2, description = "Verify that the count of active records gets increased, when user creates a Citation Violation, on 'Violation' page.")
    public void verifyActiveCountIncreasedCitationViolation() throws InterruptedException {
        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.rowsBefore + 1, citationUtility.activeCount, "ActiveCount doesnot match");
        st.assertAll();

    }

    @Test(priority = 3, description = "Verify that 'Edit Violation' popup opens up after clicking on 'edit' icon next to a Citation Violation, on 'Violation' page.")
    public void verifyEditViolationPopupOpens() throws InterruptedException {

        citationUtility.clickOnEditIcon();
        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.popupTitle, "Edit Violation", "popup Title doesnot match");
        st.assertAll();


    }

    @Test(priority = 4, description = "Verify that user is able to update Citation Violation , on 'Violation' page.")
    public void verifyEditedViolation() throws InterruptedException {

        citationUtility.sendViolationNameinLabelField(violationName + "Edited");
        citationUtility.clickOnSaveViolationButton();

        editedViolation = citationUtility.getLastViolationRecord();
        System.out.println(editedViolation);

        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.removeEditedFromCitationViolation(editedViolation), violationName, "Edited Violation name doesnot match");
        st.assertAll();
    }

    int actualInactiveCount ;
    @Test(priority = 5, enabled = true, description = "verify user is able to inactive the violation")
    public void verifyInactiveViolation() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.clickOnEditIcon();
        citationUtility.inActiveViolation();
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(3);
        actualInactiveCount =  citationUtility.getInActiveHeaderCount();
        System.out.println("actual inactive count:" +actualInactiveCount);
        String inactiveViolation = citationUtility.getLastViolationRecordInactive();
        System.out.println("inactiveViolation name : "+inactiveViolation);
        SoftAssert st = new SoftAssert();
        st.assertEquals(inactiveViolation, editedViolation, "inactive violation doesnot match");
        st.assertAll();


    }

    @Test(priority = 6, enabled = true, description = "verify that count of inactive records get increased")
    public void verifyCountOfInactiveViolation() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        int inactiveCounts =  citationUtility.getInActiveHeaderCount();

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualInactiveCount , inactiveCounts, "InactiveCount doesnot match");
        st.assertAll();

    }


    @Test(priority = 7, enabled = true, description = "verify that CitationViolation Appear on CCP")
    public void verifyCitationViolationAppearonCCP() throws InterruptedException {
        // added citation violation to assignment rules
        // and check that added assignee should display on the Create Case & Generate Notice..
        citationUtility.setAssignmentRules(CitationViolation);
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        String actualViolationAdded = citationUtility.getTextElement(CitationUtility.AddedViolationNameOnCCP);
        System.out.println(actualViolationAdded);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualViolationAdded, CitationViolation);
        st.assertAll();


    }

    @Test(priority = 8, enabled = true, description = "verify 'Create Case & Issue Notice' button appears")
    public void verifyCaseCreateButtonTxt() {
        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.getTextElement(CitationUtility.CreateCaseBttn), "Create Case & Issue Notice");
        st.assertAll();


    }

    @Test(priority = 9, enabled = true, description = "verify GenerateNotice Popup Opens Up")
    public void verifyGenerateNoticePopupOpensUp() throws InterruptedException {
        citationUtility.createCaseWithCitationVio();
        String header = citationUtility.getTextElement(CitationUtility.PopupHeader);
        System.out.println(header);
        SoftAssert st = new SoftAssert();
        st.assertEquals(header, "Create Case & Generate Notice", "Popup title doesnot match");
        st.assertAll();


    }

    @Test(priority = 10, enabled = true, description = "verify that Following Section Appears")
    public void verifyFollowingSectionAppears() throws InterruptedException {

        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.getTextElement(CitationUtility.AssignCaseToToggle), "Assign Case To", "Assign case to txt doesnot match");
        st.assertEquals(citationUtility.getTextElement(CitationUtility.SelectNoticeToggle), "Select a notice", "select a notice txt doesnot match");
        st.assertEquals(citationUtility.getTextElement(CitationUtility.NoticeIssueDate), "Notice issue date", "notice issue date txt doesnot match");
        st.assertEquals(citationUtility.getTextElement(CitationUtility.AddAFine), "Add a Fine", "Add a Fine link txt  doestnot match");
        st.assertAll();


    }

    @Test(priority = 11, enabled = true, description = "verify that Continue Button text When User select NonHtmlSelect")
    public void verifythatContinueButtonWhenNonHtmlSelect() throws InterruptedException {
        // when non html notice select
        citationUtility.waitUntilElementIsVisible(CitationUtility.conituneButton);
        citationUtility.scrollIntoView(CitationUtility.conituneButton);
        String buttonBeforeNonHtmlNoticeSelect = citationUtility.getTextElement(CitationUtility.conituneButton);

        SoftAssert st = new SoftAssert();
        st.assertEquals(buttonBeforeNonHtmlNoticeSelect, "Create Case", "continue button name doesnot match");
        st.assertAll();
    }

    @Test(priority = 12, enabled = true, description = "verify that Continue Button text When User select Html Notice")
    public void verifythatContinueButtonWhenHtmlSelect() throws InterruptedException {
        finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        selectedNoticeName = citationUtility.getTextElement(CitationUtility.HtmlFlatFineNotice);
        citationUtility.waitUntilElementIsVisible(CitationUtility.saveAndGenerateButton);
        String continueButtonHtmlNotice = citationUtility.getTextElement(CitationUtility.saveAndGenerateButton);

        SoftAssert st = new SoftAssert();
        st.assertEquals(continueButtonHtmlNotice, "Create Case and Generate Notice", "continue button name doesnot match");
        st.assertAll();

    }

    @Test(priority = 13, enabled = true, description = "verifythatAssociateFineAppearWhenHtmlFlatFineNoticeSelect")
    public void verifythatAssociateFineAppearWhenHtmlFlatFineNoticeSelect() throws InterruptedException {
        citationUtility.scrollIntoView(AssociatedFine);
        citationUtility.waitUntilElementIsVisible(AssociatedFine);
        String associatedFineText = citationUtility.getTextElement(CitationUtility.AssociatedFine);
        String associatedFineNamme = CitationUtility.extractAfterColon(associatedFineText);
        citationUtility.waitForElementIsInteractable(CitationUtility.fineAmmountField);
        int actualFineammount = citationUtility.fineAmountDisplayeonGenerateNotice(CitationUtility.fineAmmountField);
        int expectedAmount = 100;
        System.out.println(actualFineammount);
        SoftAssert st = new SoftAssert();
        st.assertEquals(associatedFineNamme, "Flat Fine With Notice", "attach notice name doesnot match");
        st.assertEquals(actualFineammount, expectedAmount, "fineAmmount doesnot match");
        st.assertAll();

    }

    @Test(priority = 14, enabled = true, description = "verifyThatUserIsAbleToAddAFine")
    public void verifyThatUserIsAbleToAddAFine() throws InterruptedException {
        citationUtility.addFine();
        citationUtility.forcedWaitTime(3);
        String noticeName2 = citationUtility.getTextElement(CitationUtility.AssociatedFine2);
        String result = citationUtility.extractAfterColon(noticeName2);

        actualFineammount = citationUtility.fineAmountDisplayeonGenerateNotice2(CitationUtility.fineAmmountField2);

        Double v2 = citationUtility.fineAmountDisplayeonGenerateNotice2(CitationUtility.fineAmmountField2);
        System.out.println("expectedAmount v2: "+ v2);

        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.fineHeadder, "Add Fine", "header name doesnot match");
        st.assertEquals(result, citationUtility.noticeName, "notice name doesnot match");
        st.assertEquals(actualFineammount, v2, "fine ammount doesnot match");
        st.assertAll();


    }

    @Test(priority = 15, enabled = true, description = "verifyThatUserIsAbleToUpdateAmmountField")
    public void verifyThatUserIsAbleToUpdateAmmountField() throws InterruptedException {
        updatedFineAmountActual = citationUtility.editFlatFine(CitationUtility.fineAmmountField);
        SoftAssert st = new SoftAssert();
        st.assertEquals(updatedFineAmountActual, 200, "update fine ammount doesnot match");
        st.assertAll();

    }

    @Test(priority = 16, enabled = true, description = "verifyThatAmmountOfOutstandingBalance")
    public void verifyThatAmmountOfOutstandingBalance() throws InterruptedException {
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickOn(CitationUtility.saveAndGenerateButton);
        citationUtility.generateNoticepopup();
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);
        SoftAssert st = new SoftAssert();
        double expectedAmmmount = updatedFineAmountActual + actualFineammount;
        System.out.println(expectedAmmmount);
        st.assertEquals(Double.parseDouble(outStandingBal), expectedAmmmount);
        st.assertAll();

    }

    @Test(priority = 17, enabled = true, description = "verifyThatCaseGetsCreatedWithHTMLNotice")
    public void verifyThatCaseGetsCreatedWithHTMLNotice() {
        noticeNameCDP = citationUtility.getTextElement(CitationUtility.noticeNameCDP);
        System.out.println(noticeNameCDP);
        Boolean bool = citationUtility.elementIsDisplayed(CitationUtility.caseHeaderCDP);
        SoftAssert st = new SoftAssert();
        st.assertTrue(bool);
        st.assertEquals(selectedNoticeName, noticeNameCDP, "notice name doesnot match");
        st.assertAll();
    }

    @Test(priority = 18, enabled = true, description = "verifyThatCaseGetsCreatedWithNonHTMLNotice")
    public void verifyThatCaseGetsCreatedWithNonHTMLNotice() throws InterruptedException {
        citationUtility.clickOn(CitationUtility.closeCDPIcon);
        citationUtility.waitForCurserRunning(5);
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
        String actualtxt = citationUtility.getTextElement(By.xpath("//div[@class='Select has-value Select--single']"));
        System.out.println(actualtxt);
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.creatCaseButtonNonHTMLNotice);
        citationUtility.clickOn(CitationUtility.creatCaseButtonNonHTMLNotice);
        citationUtility.waitForCurserRunning(4);
        String noticeNameNonHTML = citationUtility.getTextElement(CitationUtility.noticeNameCDP);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualtxt, noticeNameNonHTML, " notice name doesnot match");
        st.assertAll();

    }

    @Test(priority = 19, enabled = true, description = "verifyThatCaseCreatedAfterClickingOnCancel")
    public void verifyThatCaseCreatedAfterClickingOnCancel() throws InterruptedException {
        citationUtility.clickOn(CitationUtility.closeCDPIcon);
        citationUtility.waitForCurserRunning(5);
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
            finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickOn(CitationUtility.saveAndGenerateButton);
        citationUtility.waitForCurserRunning(3);
        citationUtility.clickOn(CitationUtility.cancelButtonOnGenerateNotice);
        citationUtility.waitForCurserRunning(3);
        String noNotice = citationUtility.getTextElement(CitationUtility.noticeNameCDP);

        SoftAssert st = new SoftAssert();
        st.assertEquals(noNotice, "No Notice", " notice name doesnot match");
        st.assertAll();

    }

    @Test(priority = 20, enabled = true, description = "verifythatPaymentAndIssueButtonIsDisplayed")
    public void verifythatPaymentAndIssueButtonIsDisplayed() {
        SoftAssert st = new SoftAssert();
        st.assertTrue(citationUtility.elementIsDisplayed(CitationUtility.issueNoticeButtonCDP), "issue notice button is not vissible");
        st.assertTrue(citationUtility.elementIsDisplayed(CitationUtility.addPaymentButtonCDP), "add Payemnt button is not vissible");

        st.assertAll();

    }

    @Test(priority = 21, enabled = true, description = "verifyThatPaymentButtonisDisabled")
    public void verifyThatPaymentButtonisDisabled() {

        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);
        var balanceFlag = Double.parseDouble(outStandingBal) >= 0.00 ? false : true;
        Boolean flag = citationUtility.buttonisEnabledOrDisabled(CitationUtility.addPaymentButtonCDP);
        SoftAssert st = new SoftAssert();
        st.assertFalse(flag, "payment button is disabled");
        st.assertFalse(balanceFlag, "ammount is greater than 0");
        st.assertAll();
    }

    @Test(priority = 22, enabled = true, description = "Verify that payment button is enabled")
    public void verifyThatPaymentButtonisEnabled() throws InterruptedException {
        citationUtility.clickOn(CitationUtility.issueNoticeButtonCDP);
        finesUtility.selectNoticeOnPerformInspectionPopup("HTML Flat Fine Notice");
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.generateNoticeButton);
        citationUtility.clickOn(CitationUtility.generateNoticeButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.DonotPrint);
        citationUtility.clickOn(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton2);
        citationUtility.clickOn(CitationUtility.IssueButton2);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(CitationUtility.caseStatusCDP);
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);

        var balanceFlag = Double.parseDouble(outStandingBal) <= 0.00 ? false : true;
        System.out.println(balanceFlag);
        Boolean flag = citationUtility.buttonisEnabledOrDisabled(CitationUtility.addPaymentButtonCDP);
        SoftAssert st = new SoftAssert();
        st.assertTrue(flag, "payment button is enabled");
        st.assertTrue(balanceFlag, "Ammount is less than zero");
        st.assertAll();
    }

    @Test(priority = 23, enabled = true, description = "Verify that case get automatically closed when toggle set to yes ")
    public void verifyThatCaseGetClosedWhenTogglesetToYes() throws InterruptedException {
        // setting toggle to yes  so case is automatically closed..
        citationUtility.navigateToAgencySetupCitation();
        citationUtility.navigateToFinesCitation();
        citationUtility.clickByJsExecuter(CitationUtility.setupTab);
        citationUtility.waitForElementIsInteractable(CitationUtility.yesToggle);
        citationUtility.clickByJsExecuter(CitationUtility.yesToggle);
        citationUtility.waitForElementIsInteractable(CitationUtility.saveChanges);
        citationUtility.clickByJsExecuter(CitationUtility.saveChanges);
        citationUtility.waitForCurserRunning(4);
        // navigate to ccp
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.CreateCaseBttn);
        citationUtility.clickByJsExecuter(CitationUtility.CreateCaseBttn);
        // adding fine
        finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickByJsExecuter(CitationUtility.saveAndGenerateButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.DonotPrint);
        citationUtility.clickByJsExecuter(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton);
        citationUtility.forcedWaitTime(5);
        citationUtility.refreshPage();
        citationUtility.forcedWaitTime(3);

        String actualHeaderStatusCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);

        var balanceFlagBefore = Double.parseDouble(outStandingBal) <= 0.00 ? false : true;
        System.out.println(balanceFlagBefore);

        citationUtility.waitForElementIsInteractable(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnPopup);
        int ammt = 10000;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
//        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
//        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        // use wait to bypass this bug
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
//        citationUtility.forcedWaitTime(5);


        citationUtility.waitForElementIsInteractable(CitationUtility.closeButtonFine);
        citationUtility.clickByJsExecuter(CitationUtility.closeButtonFine);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(3);


        String caseStatusAfterPaymentCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        System.out.println(caseStatusAfterPaymentCDP);


        String outStandingBalAfter = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println("outStandingBalAfter: " + outStandingBalAfter);

        var balanceFlagAfter = Double.parseDouble(outStandingBalAfter) == 0.00 ? true : false;
        System.out.println(balanceFlagAfter);


        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeaderStatusCDP, "Open", "status doesnot match");
        st.assertTrue(balanceFlagBefore, "balance must be greater than 0 that's why we clear the payment");
        st.assertEquals(caseStatusAfterPaymentCDP, "Open", "After payment status doesnot match");
        st.assertTrue(balanceFlagAfter, "balance must be equals to 0 that's Case is open");

        st.assertAll();


    }

    @Test(priority = 24, enabled = true, description = "Verify that case doesnot get automatically closed when toggle set to no ")
    public void verifyThatCaseDoesnotGetClosedWhenTogglesetToNo() throws InterruptedException {
        // setting toggle to no  so case is automatically closed..
        citationUtility.navigateToAgencySetupCitation();
        citationUtility.navigateToFinesCitation();
        citationUtility.clickByJsExecuter(CitationUtility.setupTab);
        citationUtility.waitForElementIsInteractable(CitationUtility.noToggle);
        citationUtility.clickByJsExecuter(CitationUtility.noToggle);
        citationUtility.waitForElementIsInteractable(CitationUtility.saveChanges);
        citationUtility.clickByJsExecuter(CitationUtility.saveChanges);
        citationUtility.waitForCurserRunning(4);
        // navigate to ccp
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.CreateCaseBttn);
        citationUtility.clickByJsExecuter(CitationUtility.CreateCaseBttn);
        // adding fine
        finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickByJsExecuter(CitationUtility.saveAndGenerateButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.DonotPrint);
        citationUtility.clickByJsExecuter(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton);
        citationUtility.forcedWaitTime(5);
        citationUtility.refreshPage();
        citationUtility.forcedWaitTime(5);

        String actualHeaderStatusCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);

        var balanceFlagBefore = Double.parseDouble(outStandingBal) <= 0.00 ? false : true;
        System.out.println(balanceFlagBefore);

        citationUtility.waitForElementIsInteractable(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnPopup);
        int ammt = 10000;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
//        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
//        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(5);


        citationUtility.waitForElementIsInteractable(CitationUtility.closeButtonFine);
        citationUtility.clickByJsExecuter(CitationUtility.closeButtonFine);
        citationUtility.waitForCurserRunning(3);

        String caseStatusAfterPaymentCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        System.out.println(caseStatusAfterPaymentCDP);


        String outStandingBalAfter = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println("outStandingBalAfter: " + outStandingBalAfter);

        var balanceFlagAfter = Double.parseDouble(outStandingBalAfter) == 0.00 ? true : false;
        System.out.println(balanceFlagAfter);


        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeaderStatusCDP, "Open", "status doesnot match");
        st.assertTrue(balanceFlagBefore, "balance must be greater than 0 that's why we clear the payment");
        st.assertEquals(caseStatusAfterPaymentCDP, "Open", "After payment status should remain open ");
        st.assertTrue(balanceFlagAfter, "balance must be equals to 0 that's Case does not get Closed");

        st.assertAll();

    }

    @Test(priority = 25, enabled = true, description = "Verify that case doesnot get automatically closed when toggle set to no and outstanding balance is greater than zero ")
    public void verifyThatCaseDoesNotGetClosedWhenBalanceIsGreaterThanZeroNo() throws InterruptedException {
        // setting toggle to no  so case is automatically closed..
        citationUtility.navigateToAgencySetupCitation();
        citationUtility.navigateToFinesCitation();
        citationUtility.clickByJsExecuter(CitationUtility.setupTab);
        citationUtility.waitForElementIsInteractable(CitationUtility.noToggle);
        citationUtility.clickByJsExecuter(CitationUtility.noToggle);
        citationUtility.waitForElementIsInteractable(CitationUtility.saveChanges);
        citationUtility.clickByJsExecuter(CitationUtility.saveChanges);
        citationUtility.waitForCurserRunning(4);
        // navigate to ccp
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.CreateCaseBttn);
        citationUtility.clickByJsExecuter(CitationUtility.CreateCaseBttn);
        // adding fine
        finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickByJsExecuter(CitationUtility.saveAndGenerateButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.DonotPrint);
        citationUtility.clickByJsExecuter(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton);
        citationUtility.forcedWaitTime(5);
        citationUtility.refreshPage();
        citationUtility.forcedWaitTime(5);

        String actualHeaderStatusCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);

        var balanceFlagBefore = Double.parseDouble(outStandingBal) <= 0.00 ? false : true;
        System.out.println(balanceFlagBefore);

        citationUtility.waitForElementIsInteractable(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnPopup);
        int ammt = 500;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
//        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
//        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(5);


        citationUtility.waitForElementIsInteractable(CitationUtility.closeButtonFine);
        citationUtility.clickByJsExecuter(CitationUtility.closeButtonFine);
        citationUtility.waitForCurserRunning(3);

        String caseStatusAfterPaymentCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        System.out.println(caseStatusAfterPaymentCDP);

        // PARTIAL PAYMENT DONE ...
        String outStandingBalAfter = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println("outStandingBalAfter: " + outStandingBalAfter);

        var balanceFlagAfter = Double.parseDouble(outStandingBalAfter) != 0.00 ? true : false;
        System.out.println(balanceFlagAfter);


        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeaderStatusCDP, "Open", "status doesnot match");
        st.assertTrue(balanceFlagBefore, "balance must be greater than 0 ");
        st.assertEquals(caseStatusAfterPaymentCDP, "Open", "After half payment status should remain open ");
        st.assertTrue(balanceFlagAfter, "balance must be not equal to 0 that's Case should remains open");

        st.assertAll();

    }

    @Test(priority = 26, enabled = true, description = "Verify that case doesnot get automatically closed when toggle set to yes and outstanding balance is greater than zero ")
    public void verifyThatCaseDoesNotGetClosedWhenBalanceIsGreaterThanZeroYes() throws InterruptedException {
        // setting toggle to no  so case is automatically closed..
        citationUtility.navigateToAgencySetupCitation();
        citationUtility.navigateToFinesCitation();
        citationUtility.clickByJsExecuter(CitationUtility.setupTab);
        citationUtility.waitForElementIsInteractable(CitationUtility.yesToggle);
        citationUtility.clickByJsExecuter(CitationUtility.yesToggle);
        citationUtility.waitForElementIsInteractable(CitationUtility.saveChanges);
        citationUtility.clickByJsExecuter(CitationUtility.saveChanges);
        citationUtility.waitForCurserRunning(4);
        // navigate to ccp
        citationUtility.navigateToCCP();
        citationUtility.addCitaitonViolationCCP(CitationViolation);
        citationUtility.createCaseWithCitationVio();
        citationUtility.forcedWaitTime(3);
        citationUtility.scrollIntoView(CitationUtility.CreateCaseBttn);
        citationUtility.clickByJsExecuter(CitationUtility.CreateCaseBttn);
        // adding fine
        finesUtility.selectNoticeOnPerformInspection("HTML Flat Fine Notice");
        citationUtility.scrollIntoView(CitationUtility.saveAndGenerateButton);
        citationUtility.clickByJsExecuter(CitationUtility.saveAndGenerateButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.DonotPrint);
        citationUtility.clickByJsExecuter(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton);
        citationUtility.waitForCurserRunning(3);
        citationUtility.refreshPage();
        citationUtility.forcedWaitTime(5);

        String actualHeaderStatusCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        String outStandingBal = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println(outStandingBal);

        var balanceFlagBefore = Double.parseDouble(outStandingBal) <= 0.00 ? false : true;
        System.out.println(balanceFlagBefore);

        citationUtility.waitForElementIsInteractable(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.clickByJsExecuter(CitationUtility.viewDetailsBalanceCDP);
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(addPaymentBttnPopup);
        int ammt = 5000;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
//        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
//        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(5);

        citationUtility.waitForElementIsInteractable(CitationUtility.closeButtonFine);
        citationUtility.clickByJsExecuter(CitationUtility.closeButtonFine);
        citationUtility.waitForCurserRunning(3);

        String caseStatusAfterPaymentCDP = citationUtility.getTextElement(CitationUtility.caseStatusCDP);
        System.out.println(caseStatusAfterPaymentCDP);

        // PARTIAL PAYMENT DONE ...
        String outStandingBalAfter = (citationUtility.getOutstandingBalance()).split("\\$")[1];
        System.out.println("outStandingBalAfter: " + outStandingBalAfter);

        var balanceFlagAfter = Double.parseDouble(outStandingBalAfter) != 0.00 ? true : false;
        System.out.println(balanceFlagAfter);

        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeaderStatusCDP, "Open", "status doesnot match");
        st.assertTrue(balanceFlagBefore, "balance must be greater than 0 that's why we clear the payment");
        st.assertEquals(caseStatusAfterPaymentCDP, "Open", "After half payment status should remain open ");
        st.assertTrue(balanceFlagAfter, "balance must be not equal to 0 ");

        st.assertAll();

    }

    @Test(priority = 27, enabled = true, description = "Verify that GenerateNoticePopupOpensUp on CDP")
    public void verifyThatAddGenerateNoticePopupOpensUpCDP() {
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickOn(CitationUtility.IssueButton);
        citationUtility.waitUntilElementIsVisible(CitationUtility.generateNoticeHeader);
        String actualHeader = citationUtility.getTextElement(CitationUtility.generateNoticeHeader);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualHeader, "Generate Notice", "Notice popup header doesnot match");
        st.assertAll();

    }

    @Test(priority = 28, enabled = true, description = "Verify that FollowingSectionAppearsonGenerateNoticePopup on CDP")
    public void verifyThatFollowingSectionAppearsonGenerateNoticePopupCDP() {
        SoftAssert st = new SoftAssert();
        st.assertEquals(citationUtility.getTextElement(CitationUtility.SelectNoticeToggle2), "Select a notice", "select a notice txt doesnot match");
        st.assertEquals(citationUtility.getTextElement(CitationUtility.NoticeIssueDate), "Notice issue date", "notice issue date txt doesnot match");
        st.assertEquals(citationUtility.getTextElement(CitationUtility.AddAFine), "Add a Fine", "Add a Fine link txt  doestnot match");
        st.assertAll();

    }

    @Test(priority = 29, enabled = true, description = "Verify that associated fine ammount appear when user select the html notice ")
    public void verifyThatAssociatedFineAmmountAppearOnGeneratNoticeCDP() throws InterruptedException {
        finesUtility.selectNoticeOnPerformInspectionPopup2("HTML Flat Fine Notice");
        citationUtility.forcedWaitTime(5);
        String associatedFineText = citationUtility.getTextElement(CitationUtility.AssociatedFine);
        String associatedFineNamme = CitationUtility.extractAfterColon(associatedFineText);
        citationUtility.waitForElementIsInteractable(CitationUtility.fineAmmountField);
        int actualFineammount = citationUtility.fineAmountDisplayeonGenerateNotice(CitationUtility.fineAmmountField);
        int expectedAmount = 100;
        System.out.println(actualFineammount);

        // generate notice popup opens up
        SoftAssert st = new SoftAssert();
        st.assertEquals(associatedFineNamme, "Flat Fine With Notice", "attach notice name doesnot match on Generate Notice CDP");
        st.assertEquals(actualFineammount, expectedAmount, "fine Ammount doesnot match on Generate Notice CDP");
        st.assertAll();

    }

    @Test(priority = 30, enabled = true, description = "verify Abatement Stage Badge Appears On CDP For HTMLNotice")
    public void verifyAbatementStageBadgeAppearsOnCDPForHTMLNotice() throws InterruptedException {

        citationUtility.waitForElementIsInteractable(CitationUtility.generateNoticeButton);
        citationUtility.scrollIntoView(CitationUtility.generateNoticeButton);
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.generateNoticeButton);
        citationUtility.clickOn(CitationUtility.DonotPrint);
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton);
        citationUtility.waitForCurserRunning(3);
        citationUtility.waitUntilElementIsVisible(CitationUtility.caseStatusCDP);

        String actualAbatmentStageBadge = citationUtility.getTextElement(CitationUtility.selectedNoticeBadge);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualAbatmentStageBadge, "HTML Flat Fine Notice", "Notice name doesnot match");
        st.assertTrue(citationUtility.elementIsDisplayed(CitationUtility.selectedNoticeBadge));
        st.assertAll();
    }

    @Test(priority = 31, enabled = true, description = "verify Abatement Stage Badge Appears On CDP For Non-HTMLNotice")
    public void verifyAbatementStageBadgeAppearsOnCDPforNonHTML() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton);
        citationUtility.clickOn(CitationUtility.IssueButton);
        citationUtility.waitUntilElementIsVisible(CitationUtility.generateNoticeHeader);
        finesUtility.selectNoticeOnPerformInspectionPopup("Non-HTMLabcd");

        citationUtility.waitForElementIsInteractable(CitationUtility.IssueButton2);
        citationUtility.scrollIntoView(CitationUtility.IssueButton2);
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.IssueButton2);
        citationUtility.waitForCurserRunning(3);
        citationUtility.waitUntilElementIsVisible(CitationUtility.caseStatusCDP);

        String actualAbatmentStageBadge = citationUtility.getTextElement(CitationUtility.selectedNoticeBadge);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualAbatmentStageBadge, "Non-HTMLabcd", "Notice name doesnot match");
        st.assertTrue(citationUtility.elementIsDisplayed(CitationUtility.selectedNoticeBadge));
        st.assertAll();
    }

    @Test(priority = 32, enabled = true, description = "verify That Fines Details PopUp Opens Up")
    public void verifyThatFinesDetailsPopUpOpensUp() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(CitationUtility.addPaymentButtonCDP);
        citationUtility.forcedWaitTime(2);
        citationUtility.clickOn(CitationUtility.addPaymentButtonCDP);
        citationUtility.waitUntilElementIsVisible(CitationUtility.finePaymentDetailsPopup);

        String headerTxt = citationUtility.getTextElement(CitationUtility.finePaymentDetailsPopup);
        SoftAssert st = new SoftAssert();
        st.assertEquals(headerTxt, "Fines & Payments Details", "Popup name doesnot match");
        st.assertAll();

    }

    @Test(priority = 33, enabled = true, description = "verify That User Is Able To Add Fine On Fines Popup")
    public void verifyThatUserIsAbleToAddFineOnFinesPopup() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineDropdownArrow);
        citationUtility.forcedWaitTime(4);
        citationUtility.clickOn(CitationUtility.SelectFineDropdownArrow);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(AddNewFine);
        citationUtility.clickOn(AddNewFine);
        citationUtility.waitForCurserRunning(3);
        citationUtility.waitUntilElementIsVisible(CloseFinePaymentDetailsPop);
        citationUtility.waitUntilElementPresent(CloseFinePaymentDetailsPop);
        citationUtility.waitUntilElementIsVisible(UnpaidButton);

        UnPaidFinePayment = citationUtility.findElementsByXPath(CitationUtility.unpaidButton).size();
        List<WebElement> fineTypeAmout = citationUtility.findElementsByXPath(AddedfineDetails);
        for (int i = 0; i < fineTypeAmout.size(); i++) {
            String textRetrived = fineTypeAmout.get(i).getText();
            finetypeAndAmout = !(textRetrived.isEmpty());
        }
        fineAddedOn = !(citationUtility.getTextElement(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'])[3]"))).isEmpty();

        SoftAssert st = new SoftAssert();
        st.assertTrue(UnPaidFinePayment == 1);
        st.assertTrue(finetypeAndAmout);
        st.assertTrue(fineAddedOn);
        st.assertAll();

    }

    @Test(priority = 33, enabled = true, description = "verifyThatUserIsAbleToAddPaymentOnFinesPopup")
    public void verifyThatUserIsAbleToAddPaymentOnFinesPopup() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(addPaymentBttnPopup);
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(addPaymentBttnPopup);
        citationUtility.waitUntilElementIsVisible(AddPaymentAmnt);
        citationUtility.addPayment(CitationUtility.fineAmmountField, 1500);
//        ceCommonMethods.ce_addContact();
        citationUtility.waitUntilElementIsVisible(SelectPayor);
        citationUtility.clickOn(SelectPayor);
        citationUtility.waitUntilElementIsVisible(SelectPayorOpt);
        citationUtility.clickOn(SelectPayorOpt);
        ceCommonMethods.ce_addContact2();
        Thread.sleep(3000);
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");

        try {
            citationUtility.waitUntilElementIsVisible(addPaymentBttnOnFinesPopup);
            citationUtility.clickOn(addPaymentBttnOnFinesPopup);
        } catch (Exception e) {
            citationUtility.clickByJsExecuter(addPaymentBttnOnFinesPopup);
        }
        citationUtility.waitForCurserRunning(5);
        citationUtility.waitUntilElementIsVisible(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]"));
        String cashPayment = citationUtility.getTextElement(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]"));
        cashPaymentAdded = cashPayment.contains("Cash");
        citationUtility.waitUntilElementIsVisible(By.xpath("//button[text()='Partially Paid']"));
        partialPaymentLabel = citationUtility.elementIsDisplayed(By.xpath("//button[text()='Partially Paid']"));

        SoftAssert st = new SoftAssert();
        st.assertTrue(cashPaymentAdded, "cashPayment label");
        st.assertTrue(partialPaymentLabel, "partial Payment ");
        st.assertAll();
    }

    @Test(priority = 34, enabled = true, description = "verifyThatUserIsAbleToAddLateFeeOnFinesPopup")
    public void verifyThatUserIsAbleToAddLateFeeOnFinesPopup() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(CitationUtility.addLateFeeToggleButton);
        citationUtility.clickOn(CitationUtility.addLateFeeToggleButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectLateFeeDropDown);
        citationUtility.clickOn(CitationUtility.selectLateFeeDropDown);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(CitationUtility.addLateFeeButton);
        citationUtility.clickOn(CitationUtility.addLateFeeButton);
        citationUtility.waitForCurserRunning(3);
        citationUtility.waitUntilElementIsVisible(CloseFinePaymentDetailsPop);
        citationUtility.waitUntilElementPresent(CloseFinePaymentDetailsPop);
        citationUtility.waitUntilElementIsVisible(UnpaidButton);

        UnPaidFinePayment = citationUtility.findElementsByXPath(CitationUtility.unpaidButton).size();
        System.out.println("Size :" + UnPaidFinePayment);
        List<WebElement> fineTypeAmout = citationUtility.findElementsByXPath(AddedfineDetails);
        for (int i = 0; i < fineTypeAmout.size(); i++) {
            String textRetrived = fineTypeAmout.get(i).getText();
            finetypeAndAmout = !(textRetrived.isEmpty());
        }
        fineAddedOn = !(citationUtility.getTextElement(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'])[3]"))).isEmpty();

        SoftAssert st = new SoftAssert();
        st.assertTrue(UnPaidFinePayment == 2, "UnPaidFineAmmont size is greater than 1");
        st.assertTrue(finetypeAndAmout, "fine type ammount");
        st.assertTrue(fineAddedOn, "fine added on ");
        st.assertAll();
    }

    @Test(priority = 35, enabled = true, description = "verify That Validaion Message Appear On Add Payment Popup")
    public void verifyThatValidaionMessageAppearOnAddPaymentPopup() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(addPaymentBttnPopup);
        citationUtility.clickOn(CitationUtility.addPaymentBttnPopup);
        citationUtility.waitForElementIsInteractable(addPaymentBttnOnFinesPopup);
        citationUtility.clickOn(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.forcedWaitTime(4);
        String ammountValidationText = citationUtility.getTextElement(ammountValidationMessage);
        String payorValidationText = citationUtility.getTextElement(payorValidationMessage);


        SoftAssert st = new SoftAssert();
        st.assertEquals(ammountValidationText, "The Amount is required.", "amount validaion message ");
        st.assertEquals(payorValidationText, "Please select a payor", "Payor validaion message ");
        st.assertAll();
    }

    @Test(priority = 36, enabled = true, description = "verifyThatErroMessageAppearWhenPaymentAmountIsGreaterThanBalance")
    public void verifyThatErroMessageAppearWhenPaymentAmountIsGreaterThanBalance() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        int ammt = 55555555;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.forcedWaitTime(3);
        citationUtility.clearElement(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "Payment Testing");
        citationUtility.forcedWaitTime(1);
        citationUtility.waitForElementIsInteractable(addPaymentBttnOnFinesPopup);
        citationUtility.clickOn(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.forcedWaitTime(4);


        String errorMessage = citationUtility.getTextElement(paymentError);

        SoftAssert st = new SoftAssert();
        st.assertEquals(errorMessage, "The payment amount cannot be greater than the current balance for the case." +
                " Please check the payment amount. If you wish to record an overpayment, first add a new fine for the overpayment amount", "error message doesnot match");
        st.assertAll();
    }

    @Test(priority = 37, enabled = true, description = "verify That Generated Notice Appear Under Abadment Activity Tile")
    public void verifyThatGeneratedNoticeAppearUnderAbadmentActivityTile() throws InterruptedException {
        citationUtility.waitForElementIsInteractable(closeButtonOnfinePopup);
        citationUtility.clickOn(closeButtonOnfinePopup);

        SoftAssert st = new SoftAssert();
        st.assertTrue(citationUtility.elementIsDisplayed(noticeNameAbatementActivity), "notice name doesnot appear");
        st.assertAll();

    }

    @Test(priority = 38, enabled = true, description = "verify That Delete And Reissue Link Appear After Clicking On View Notice")
    public void verifyThatDeleteAndReissueLinkAppearAfterClickingOnViewNotice() throws InterruptedException {

        citationUtility.forcedWaitTime(4);
        citationUtility.clickOn(viewNotice);
        citationUtility.waitForElementIsInteractable(deleteLink);
        citationUtility.waitForElementIsInteractable(deleteAndReissue);

        SoftAssert st = new SoftAssert();
        st.assertTrue(citationUtility.elementIsDisplayed(deleteLink));
        st.assertTrue(citationUtility.elementIsDisplayed(deleteAndReissue));
        st.assertAll();


    }

    @Test(priority = 39, enabled = true, description = "verify That Fine Marked As Void")
    public void verifyThatFineMarkedAsVoid() throws InterruptedException {
        citationUtility.clickOn(closeButtonOnfinePopup);
        citationUtility.forcedWaitTime(3);
        citationUtility.clickOn(addPaymentButtonCDP);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineDropdownArrow);
        citationUtility.clickOn(CitationUtility.SelectFineDropdownArrow);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(AddNewFine);
        citationUtility.clickOn(AddNewFine);
        citationUtility.waitForCurserRunning(3);
        // marked payement as void
        citationUtility.waitForElementIsInteractable(op.VoidIconFinePaymentList);
        citationUtility.clickByJsExecuter(op.VoidIconFinePaymentList);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(op.VoidfineBtn);
        citationUtility.clickByJsExecuter(op.VoidfineBtn);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.VoidLable);
        citationUtility.waitUntilElementPresent(op.VoidLable);
        voidLableIcon = citationUtility.findElement(op.VoidLable).isDisplayed();
        voidLableButton = citationUtility.getTextElement(op.VoidLable);
        paymentNullifiedPresent = citationUtility.findElement(op.FineNullified).isDisplayed();
        Assert.assertEquals(voidLableIcon, Boolean.TRUE);
        Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
        Assert.assertEquals(voidLableButton, "Void");
    }

    @Test(priority = 40, enabled = true, description = "verify That Fine Marked As Wavie")
    public void verifyThatFineMarkedAsWavie() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineDropdownArrow);
        citationUtility.clickOn(CitationUtility.SelectFineDropdownArrow);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(AddNewFine);
        citationUtility.clickOn(AddNewFine);
        citationUtility.waitForCurserRunning(3);

        citationUtility.waitUntilElementIsVisible(op.VoidIconFinePaymentList);
        citationUtility.waitForElementIsInteractable(op.VoidIconFinePaymentList);
        citationUtility.clickByJsExecuter(op.VoidIconFinePaymentList);
        citationUtility.waitUntilElementIsVisible(waiveToggleBtn);
        citationUtility.clickOn(waiveToggleBtn);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(op.WaivefineBtn);
        citationUtility.clickByJsExecuter(op.WaivefineBtn);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.VoidLable);
        citationUtility.waitUntilElementPresent(op.VoidLable);
        voidLableIcon = citationUtility.findElement(op.VoidLable).isDisplayed();
        voidLableButton = citationUtility.getTextElement(op.VoidLable);
        paymentNullifiedPresent = citationUtility.findElement(op.FineNullified).isDisplayed();
        Assert.assertEquals(voidLableIcon, Boolean.TRUE);
        Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
        Assert.assertEquals(voidLableButton, "Waived");
    }

    @Test(priority = 41, enabled = true, description = "verify That Late Fee Marked As Void")
    public void verifyThatLateFeeMarkedAsVoid() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.waitForElementIsInteractable(CitationUtility.addLateFeeToggleButton);
        citationUtility.clickOn(CitationUtility.addLateFeeToggleButton);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectLateFeeDropDown);
        citationUtility.clickOn(CitationUtility.selectLateFeeDropDown);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(addLateFeeButton);
        citationUtility.clickOn(addLateFeeButton);
        citationUtility.waitForCurserRunning(3);

        citationUtility.waitUntilElementIsVisible(op.VoidIconFinePaymentList);
        citationUtility.waitForElementIsInteractable(op.VoidIconFinePaymentList);
        citationUtility.clickByJsExecuter(op.VoidIconFinePaymentList);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(VoidLateFeeBtn);
        citationUtility.clickByJsExecuter(VoidLateFeeBtn);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.VoidLable);
        citationUtility.waitUntilElementPresent(op.VoidLable);
        voidLableIcon = citationUtility.findElement(op.VoidLable).isDisplayed();
        voidLableButton = citationUtility.getTextElement(op.VoidLable);
        paymentNullifiedPresent = citationUtility.findElement(op.FineNullified).isDisplayed();
        Assert.assertEquals(voidLableIcon, Boolean.TRUE);
        Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
        Assert.assertEquals(voidLableButton, "Void");
    }

    @Test(priority = 42, enabled = true, description = "verify That Late Fee Marked As Waived")
    public void verifyThatLateFeeMarkedAsWaived() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectLateFeeDropDown);
        citationUtility.clickOn(CitationUtility.selectLateFeeDropDown);
        citationUtility.forcedWaitTime(3);
        citationUtility.waitUntilElementIsVisible(SelectFineOptions);
        citationUtility.clickOn(SelectFineOptions);
        citationUtility.waitForElementIsInteractable(addLateFeeButton);
        citationUtility.clickOn(addLateFeeButton);
        citationUtility.waitForCurserRunning(3);

        citationUtility.waitUntilElementIsVisible(op.VoidIconFinePaymentList);
        citationUtility.waitForElementIsInteractable(op.VoidIconFinePaymentList);
        citationUtility.clickByJsExecuter(op.VoidIconFinePaymentList);
        citationUtility.waitUntilElementIsVisible(waiveToggleBtn);
        citationUtility.clickOn(waiveToggleBtn);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(waiveLateFeeBtn);
        citationUtility.clickByJsExecuter(waiveLateFeeBtn);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.VoidLable);
        citationUtility.waitUntilElementPresent(op.VoidLable);
        voidLableIcon = citationUtility.findElement(op.VoidLable).isDisplayed();
        voidLableButton = citationUtility.getTextElement(op.VoidLable);
        paymentNullifiedPresent = citationUtility.findElement(op.FineNullified).isDisplayed();
        Assert.assertEquals(voidLableIcon, Boolean.TRUE);
        Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
        Assert.assertEquals(voidLableButton, "Waived");
    }

    @Test(priority = 43, enabled = true, description = "verify That Payment Marked As Void")
    public void verifyThatPaymentMarkedAsVoid() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnPopup);
        int ammt = 20000;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        // use wait to bypass this bug
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(5);

        citationUtility.waitUntilElementIsVisible(op.PaymentVoidSymbol);
        citationUtility.waitForElementIsInteractable(op.PaymentVoidSymbol);
        citationUtility.clickByJsExecuter(op.PaymentVoidSymbol);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(op.VoidPaymentbutton);
        citationUtility.clickByJsExecuter(op.VoidPaymentbutton);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.PaymentVoid);
        paymentvoidLableIcon = citationUtility.findElement(op.PaymentVoid).isDisplayed();
        PaymentvoidLableBtn = citationUtility.getTextElement(op.PaymentVoid);
        PaymentNullified = citationUtility.findElement(op.PaymentCashNullified).isDisplayed();
        Assert.assertTrue(paymentvoidLableIcon);
        Assert.assertTrue(PaymentNullified);
        Assert.assertEquals(PaymentvoidLableBtn, "Void");
    }

    @Test(priority = 44, enabled = true, description = "verify That Payment Marked As Waived")
    public void verifyThatPaymentMarkedAsRefunded() throws InterruptedException {
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnPopup);
        int ammt = 20000;
        citationUtility.addPayment(CitationUtility.fineAmmountField, ammt);
        citationUtility.waitForElementIsInteractable(CitationUtility.selectPayor);
        citationUtility.clickOn(CitationUtility.selectPayor);
        citationUtility.waitForElementIsInteractable(CitationUtility.SelectFineOptions);
        citationUtility.clickOn(CitationUtility.SelectFineOptions);
        // this is bug and not to use this 2 line in future..
        // use wait to bypass this bug
        citationUtility.clearByJSE(CitationUtility.PaymentCheck);
        citationUtility.forcedWaitTime(3);
        citationUtility.sendKeysWithWait(CitationUtility.PaymentCheck, "abcdef");
        citationUtility.forcedWaitTime(3);
        citationUtility.clickByJsExecuter(CitationUtility.addPaymentBttnOnFinesPopup);
        citationUtility.waitForCurserRunning(3);
        citationUtility.forcedWaitTime(5);

        citationUtility.waitUntilElementIsVisible(op.PaymentVoidSymbol);
        citationUtility.waitForElementIsInteractable(op.PaymentVoidSymbol);
        citationUtility.clickByJsExecuter(op.PaymentVoidSymbol);
        citationUtility.waitUntilElementIsVisible(RefundToggleButton);
        citationUtility.clickOn(RefundToggleButton);
        int refundammt = 20000;
        citationUtility.addPayment(CitationUtility.refundAmmountField, refundammt);
        citationUtility.sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
        citationUtility.waitForElementIsInteractable(issueRefundButton);
        citationUtility.clickByJsExecuter(issueRefundButton);
        citationUtility.waitForCurserRunning(4);
        citationUtility.waitUntilElementIsVisible(op.PaymentVoid);
        paymentvoidLableIcon = citationUtility.findElement(op.PaymentVoid).isDisplayed();
        PaymentvoidLableBtn = citationUtility.getTextElement(op.PaymentVoid);
        Assert.assertTrue(paymentvoidLableIcon);
        Assert.assertEquals(PaymentvoidLableBtn, "Refunded");
    }

}
