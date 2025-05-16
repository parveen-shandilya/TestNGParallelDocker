package POM;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


import java.util.List;

import static POM.CCPUtility.agencyConfig;

public class CitationUtility extends Helper {
    public WebDriver driver;
    public String popupTitle;
    public int rowsBefore, rowsAfter, activeCount, inactiveCount, inactiveRowsBefore;
    public String noticeName, fineHeadder;
    CECommonMethods ceCommonMethod;
    LoginUtility log;
    CRMCommonMethods crmCommonMethod;
    FinesUtility finesUtility;
    List<WebElement> AddedViolations, AddedInactiveViolations, AddedViolations2;


    public static String activeViolationCount = "//h2[contains(text(),'Active')]";
    public static String inactiveViolationCount = "//h2[contains(text(),'Inactive')]";
    public static String lastRowCount = "((//li[@class='sortable__element'])[%s])//div[@class='sortable-table__body__td'][1]";
    public static String lastRowCountInactive = "((//div[@class='rt-tr-group'])[%s])//div[@class='rt-td'][1]";
    public static String lastRowCountEdited = "(//button[@type='button'])[%s]";
    public static String editViolationTitle = "(//div[@class='full-page-modal__header'])//h1";
    public static String saveButton = "//button[text()='Save']";
    public static String inActiveButton = "//button[text()='Inactive']";
    public static String addedInactiveViolationRows = "//div[@class='rt-tr-group']";
    public static String addedViolationNameOnCCP = "//label[@class='violation-tile__item-info-name']";
    public static String createCaseBttn = "//div/button[text()='Create Case & Issue Notice']";
    public static String popupHeader = "(//div[@class='modal-content']//div[@class='modal-header'])[2]";
    public static String assignCaseToToggle = "//h5[@class='assignee-label']";
    public static String selectNoticeToggle = "(//*[text()='Select a notice'])";
    public static String noticeIssueDate = "//label[@title='Notice issue date']";
    public static String addAFine = "//div[@class='case-inspection__unassociated-fines']//a";
    public static String htmlFlatFineNotice = "//*[text()='HTML Flat Fine Notice']";
    public static String selectFineOptions = "(//div[@class='Select-menu-outer']//div[@role='option'])";
    public static By saveAndGenerateButton = By.xpath("//button[normalize-space()='Create Case and Generate Notice']");
    public static By DonotPrint = By.xpath("//button[text()='Do Not Print']");
    public static By IssueButton = By.xpath("//button[text()='Issue Notice']");
    public static By IssueButton2 = By.xpath("(//button[text()='Issue Notice'])[2]");
    public static By conituneButton = By.xpath("//button[@class='square-btn btn btn-primary']");

    public static By ActiveViolationCount = By.xpath(activeViolationCount);
    public static By EditViolationTitle = By.xpath(editViolationTitle);
    public static By SaveButton = By.xpath(saveButton);
    public static By InactiveButton = By.xpath(inActiveButton);
    public static By InactiveViolationCount = By.xpath(inactiveViolationCount);
    public static By AddedInactiveViolationRows = By.xpath(addedInactiveViolationRows);
    public static By AddedViolationNameOnCCP = By.xpath(addedViolationNameOnCCP);
    public static By CreateCaseBttn = By.xpath(createCaseBttn);
    public static By PopupHeader = By.xpath(popupHeader);
    public static By AssignCaseToToggle = By.xpath(assignCaseToToggle);
    public static By SelectNoticeToggle = By.xpath(selectNoticeToggle);
    public static By NoticeIssueDate = By.xpath(noticeIssueDate);
    public static By AddAFine = By.xpath(addAFine);
    public static By HtmlFlatFineNotice = By.xpath(htmlFlatFineNotice);
    public static By AssociatedFine = By.xpath("(//div[@class='rt-th']//div)[1]");
    public static By fineAmmountField = By.xpath("(//*[@name='amount'])");
    public static By fineAmmountField2 = By.xpath("(//*[@name='amount'])[2]");
    public static By AssociatedFine2 = By.xpath("//div[@class='unassociated-fine__default-amount']//label");
    public static By SelectFineOptions = By.xpath(selectFineOptions);
    public static By caseHeaderCDP = By.xpath("//div[@class='case-details__header__creation']");
    public static By creatCaseButtonNonHTMLNotice = By.xpath("//button[normalize-space()='Create Case']");
    public static By closeCDPIcon = By.xpath("//div[@class='case-details__close-icon']");
    public static By cancelButtonOnGenerateNotice = By.xpath("(//button[@type='button'][normalize-space()='Cancel'])[3]");
    public static By issueNoticeButtonCDP = By.xpath("//button[text()='Issue Notice']");
    public static By addPaymentButtonCDP = By.xpath("//button[text()='Add Payment']");
    public static By generateNoticeButton = By.xpath("//button[normalize-space()='Generate Notice']");
    public static By yesToggle = By.xpath("//button[text()='Yes']");
    public static By noToggle = By.xpath("//button[text()='No']");
    public static By saveChanges = By.xpath("//button[text()='Save Changes']");
    public static By setupTab = By.xpath("//div[text()='Setup']");
    public static By caseStatusCDP = By.xpath("//h2[@class='case-details__case-status']");
    public static By viewDetailsBalanceCDP = By.xpath("//a[text()='View Details']");
    public static By addPaymentBttnPopup = By.xpath("(//button[text()='Add Payment'])[2]");
    public static By selectPayor = By.xpath("//div[text()='Payor']");
    public static By addPaymentBttnOnFinesPopup = By.xpath("(//button[@type='button'][normalize-space()='Add Payment'])[3]");
    public static By closeButtonFine = By.xpath("//button[text()='Close']");
    public static By PaymentCheck = By.xpath("//input[@name='paymentClerk']");
    public static By generateNoticeHeader = By.xpath("//div[normalize-space()='Generate Notice']");
    public By selectFineDropdownArrow = By
            .xpath("(//div[text()='Select Option'])/..");
    public By AddFineButton = By.xpath("//button[normalize-space()='Add Fine']");
    public By SelectFineDropdown = By.xpath("(//div[@class='Select-value'])");
    public By SelectFineDropDown2 = By.xpath("(//label[@title='Select Fine']//..//..)//div[@class='field__input row']");
    public static By SelectNoticeToggle2 = By.xpath("(//div[@class='field__label row'])[1]");
    public static By selectedNoticeBadge = By.xpath("//div[@class='field-section abatement-status-wrapper']");
    public static By finePaymentDetailsPopup = By.xpath("//div[contains(text(),'Fines & Payments Details')]");
    public static By unpaidButton = By.xpath("//button[text()='Unpaid']");
    public static By SelectFineDropdownArrow = By.xpath("(//div[text()='Select Fine'])");
    public static By selectLateFeeDropDown = By.xpath("(//div[text()='Select Late Fee'])");
    public static By addLateFeeToggleButton = By.xpath("(//button[text()='Add Late Fee'])");
    public static By addLateFeeButton = By.xpath("(//button[text()='Add Late Fee'])[2]");
    public static By ammountValidationMessage = By.xpath("//span[text()='The Amount is required.']");
    public static By payorValidationMessage = By.xpath("//span[text()='Please select a payor']");
    public static By paymentError = By.xpath("//div[@class='payment-error']");
    public static By closeButtonOnfinePopup= By.xpath("//button[text()='Close']");
    public static By viewNotice = By.xpath("//a[text()='View Notice']");
    public static By deleteLink = By.xpath("//a[text()='Delete']");
    public static By deleteAndReissue = By.xpath("//a[text()='Delete and Reissue']");
    public static By noticeNameAbatementActivity = By.xpath("//h4[contains(@class,'inspection-notice__name')]");
    public static By voidfineBtn = By.xpath("//button[text()='Void Fine']");
    public static By waivefineBtn = By.xpath("//button[text()='Waive Fine']");
    public static By waiveToggleBtn = By.xpath("//button[text()='Waive']");
    public static By waiveLateFeeBtn =  By.xpath("//button[text()='Waive Late Fee']");
    public static By VoidLateFeeBtn =  By.xpath("//button[text()='Void Late Fee']");
//    public static By waiveLateFeeBtn =  By.xpath("//button[text()='Waive Late Fee']");
    public static By RefundToggleButton = By.xpath("//button[text()='Refund']");
    public static By issueRefundButton = By.xpath("//button[text()='Issue Refund']");
    public static By refundAmmountField = By.xpath("(//*[@name='refundAmount'])");
  public static By noticeNameCDP = By.xpath("//div[@class='field-section abatement-status-wrapper']");
    public CitationUtility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        ceCommonMethod = new CECommonMethods(driver);
        crmCommonMethod = new CRMCommonMethods(driver);
        finesUtility = new FinesUtility(driver);

    }

    public static String extractAfterColon(String input) {
        int colonIndex = input.indexOf(':');
        if (colonIndex != -1 && colonIndex + 1 < input.length()) {
            return input.substring(colonIndex + 1).trim(); // trim() to remove leading spaces
        }
        return ""; // Return an empty string if no colon is found
    }

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();
    }

    public void navigateToViolationPageFromDashboard() throws InterruptedException {
        finesUtility.navigateToCreateViolationPage();

    }

    public void createCitationViolation(String Violation, String toggleOption) throws InterruptedException {
        // citation violation ..
        waitUntilElementIsVisible(AppPreRequisiteUtility.ViolationsTab);
        waitUntilElementPresent(AppPreRequisiteUtility.ViolationsTab);
        waitForElementIsInteractable(AppPreRequisiteUtility.ViolationsTab);
        waitForCurserRunning(5);
        beforeAddedViolationSize();
        waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateViolationButton);
        waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton);

        clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton);
        waitForCurserRunning(2);
        waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateViolationPopup);
        getTitleOfPopup(AppPreRequisiteUtility.CreateViolationPopup);
        // create Citation Violation with No Inspection Required .
        addNewCitationViolation(Violation, toggleOption);

        waitForPresenceandVisiblity(AppPreRequisiteUtility.AddedViolationsRows);

    }

    public void getTitleOfPopup(By xpath) {
        popupTitle = getTextElement(xpath);
    }

    public int beforeAddedViolationSize() {
        AddedViolations = findElementsByXPath(AppPreRequisiteUtility.AddedViolationsRows);
        rowsBefore = AddedViolations.size();
        return rowsBefore;

    }

    public int beforeAddedInactiveViolationRows() throws InterruptedException {
        waitForElementIsInteractable(AddedInactiveViolationRows);
        forcedWaitTime(3);
        AddedInactiveViolations = findElementsByXPath(AddedInactiveViolationRows);
        inactiveRowsBefore = AddedViolations.size();
        return inactiveRowsBefore;

    }

    public int afterAddedViolationSize() {
        AddedViolations2 = findElementsByXPath(AppPreRequisiteUtility.AddedViolationsRows);
        rowsAfter = AddedViolations2.size();
        return rowsAfter;
    }

    public int getActiveHeaderCount() throws InterruptedException {
        forcedWaitTime(4);
        activeCount = Integer.parseInt(getTextElement(ActiveViolationCount).split(" ")[0]);
        return activeCount;
    }

    public int getInActiveHeaderCount() {
        waitUntilElementIsVisible(InactiveViolationCount);
        waitForElementIsInteractable(InactiveViolationCount);
        String txt = getTextElement(InactiveViolationCount);
        System.out.println(txt);
        inactiveCount = Integer.parseInt(txt.split(" ")[0]);
        return inactiveCount;
    }

    public void addNewCitationViolation(String violationName, String toggleOption) throws InterruptedException {
        waitForElementIsInteractable(AppPreRequisiteUtility.LabelField);
        sendKeysWithWait(AppPreRequisiteUtility.LabelField, violationName);

        scrollIntoView(AppPreRequisiteUtility.ViolationTypeDropdown);
        clickOn(AppPreRequisiteUtility.ViolationTypeDropdown);

        if (violationName.equalsIgnoreCase("Animal")) {

            scrollIntoView(AppPreRequisiteUtility.VioOptionAnimal);
            clickOn(AppPreRequisiteUtility.VioOptionAnimal);
        } else {
            waitForElementIsInteractable(AppPreRequisiteUtility.VioOptionGeneral);
            clickOn(AppPreRequisiteUtility.VioOptionGeneral);
        }
        waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeField);
        clickOn(AppPreRequisiteUtility.MunicipalCodeField);

        waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeOption);
        clickOn(AppPreRequisiteUtility.MunicipalCodeOption);

        waitForElementIsInteractable(By.xpath(selectorFormate(AppPreRequisiteUtility.inspectionRequiredToggleNo, toggleOption)));
        clickOn(By.xpath(selectorFormate(AppPreRequisiteUtility.inspectionRequiredToggleNo, toggleOption)));

        waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton2);
        clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton2);
        waitForCurserRunning(5);
        waitForPresenceandVisiblity(By.xpath(AppPreRequisiteUtility.getMuncipalVioCode(violationName)));

    }

    public void addCitaitonViolationCCP(String violation) throws InterruptedException {
        waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
        waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
        waitForCurserRunning(5);
        try {
            movetoElementAndClick(CCPUtility.ViolationSearchBox);
        } catch (Exception e) {
            waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
            clickByJsExecuter(CCPUtility.ViolationSearchBox);
        }
        sendKeysWithWait(CCPUtility.ViolationSearchBox, violation);
        waitUntilElementIsVisible(By.xpath(stringFormat(CCPUtility.violationListlabel, violation)));
        try {
            waitForElementIsInteractable(CCPUtility.ViolationsList);
            waitForCurserRunning(3);
            clickByJsExecuter(CCPUtility.ViolationsList);
        } catch (StaleElementReferenceException e) {
            WebElement violationsList = driver.findElement(CCPUtility.violationSuggested);
            waitForElementInteractable(violationsList);
            clickOnElement(violationsList);
        }

    }

    public String getLastViolationRecord() throws InterruptedException {
        getActiveHeaderCount();
        scrollIntoView(By.xpath(selectorFormate(lastRowCount, String.valueOf(activeCount))));
        waitUntilElementIsVisible(By.xpath(selectorFormate(lastRowCount, String.valueOf(activeCount))));
        return getTextElement(By.xpath(selectorFormate(lastRowCount, String.valueOf(activeCount))));
    }

    public void clickOnEditIcon() throws InterruptedException {
        scrollIntoView(By.xpath(selectorFormate(lastRowCountEdited, String.valueOf(activeCount + 1))));
        waitUntilElementIsVisible(By.xpath(selectorFormate(lastRowCountEdited, String.valueOf(activeCount + 1))));
        waitForElementIsInteractable(By.xpath(selectorFormate(lastRowCountEdited, String.valueOf(activeCount + 1))));
        clickByJsExecuter(By.xpath(selectorFormate(lastRowCountEdited, String.valueOf(activeCount + 1))));
        waitUntilElementIsVisible(EditViolationTitle);
        forcedWaitTime(3);
        getTitleOfPopup(EditViolationTitle);
        waitForCurserRunning(3);
    }

    public void sendViolationNameinLabelField(String violationName) throws InterruptedException {
        clearElement(AppPreRequisiteUtility.LabelField);
        forcedWaitTime(4);
        waitForElementIsInteractable(AppPreRequisiteUtility.LabelField);
        sendKeysWithWait(AppPreRequisiteUtility.LabelField, violationName);
    }

    public void clickOnSaveViolationButton() throws InterruptedException {
        waitUntilElementIsVisible(SaveButton);
        forcedWaitTime(4);
        clickByJsExecuter(SaveButton);
        waitForCurserRunning(3);
        forcedWaitTime(2);
    }

    public String removeEditedFromCitationViolation(String editViolationName) {
        return editViolationName.substring(0, editViolationName.indexOf("Edited")).trim();
    }

    public void inActiveViolation() throws InterruptedException {
        waitUntilElementIsVisible(InactiveButton);
        waitForElementIsInteractable(InactiveButton);
        clickByJsExecuter(InactiveButton);
        forcedWaitTime(4);
        waitForElementIsInteractable(SaveButton);
        clickByJsExecuter(SaveButton);
    }

    public String getLastViolationRecordInactive() {
        getInActiveHeaderCount();
        scrollIntoView(By.xpath(selectorFormate(lastRowCountInactive, String.valueOf(inactiveCount))));
        waitUntilElementIsVisible(By.xpath(selectorFormate(lastRowCountInactive, String.valueOf(inactiveCount))));
        return getTextElement(By.xpath(selectorFormate(lastRowCountInactive, String.valueOf(inactiveCount))));
    }

    public void navigateToCCP() throws InterruptedException {
        ceCommonMethod.navigateToCCP();
    }

    public void createCaseWithCitationVio() throws InterruptedException {
        forcedWaitTime(3);
        ceCommonMethod.addLocationCCP();
        waitForCurserRunning(5);
        ceCommonMethod.ce_addContact();
        waitForElementIsInteractable(CreateCaseBttn);
        clickByJsExecuter(CreateCaseBttn);
        handleReviewContact();
        waitUntilElementIsVisible(PopupHeader);

    }

    public void handleReviewContact() throws InterruptedException {
        int warnningPopUp = findElementsSize(
                By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));

        if (warnningPopUp > 0) {
            waitForElementIsInteractable(
                    By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
            try {
                clickOn(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
            } catch (Exception e) {
                clickByJsExecuter(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
            }

            waitUntilElementIsVisible(By.xpath("//button[text()='Keep contact']"));

            List<WebElement> keepContactBtn = driver.findElements(By.xpath("//button[text()='Keep contact']"));
            int size = keepContactBtn.size();

            for (int i = 0; i < size; i++) {
                scrollIntoViewWebElement(keepContactBtn.get(i));
                clickByJsExecuterWebElement(keepContactBtn.get(i));

            }

            clickOnCreateCaseButtonCitation();
            forcedWaitTime(3);
            handleReviewContact();

        }
    }

    public void clickOnCreateCaseButtonCitation() throws InterruptedException {
        waitUntilElementIsVisible(CreateCaseBttn);
        scrollIntoView(CreateCaseBttn);
        waitForElementIsInteractable(CreateCaseBttn);
        WebElement ele = findElement(CreateCaseBttn);
        clickByJsExecuter(CreateCaseBttn);
        Thread.sleep(3000);
    }

    public void setAssignmentRules(String citationValue) throws InterruptedException {
        crmCommonMethod.navigateToAssignmentRules();
        crmCommonMethod.editCaseAssignmentRule();
        ceCommonMethod.deleteRules(1);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
            ceCommonMethod.addCaseAssignmentRule("Case Violation", "Contains", citationValue, "Mark Shane", "Amandeep");
        } else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
            ceCommonMethod.addCaseAssignmentRule("Case Violation", "Contains", citationValue, "Mark Shane", "Amandeep");
        } else {
            ceCommonMethod.addCaseAssignmentRule("Case Violation", "Contains", citationValue, "Shane Es", "Amandeep");
        }

        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();


    }

    public void addFine() throws InterruptedException {
        waitUntilElementIsVisible(AddAFine);
        forcedWaitTime(3);
        clickByJsExecuter(AddAFine);
        forcedWaitTime(3);
        fineHeadder = getTextElement(By.xpath("//div[normalize-space()='Add Fine']"));
        waitForElementIsInteractable(selectFineDropdownArrow);
        clickOn(selectFineDropdownArrow);
        waitForElementIsInteractable(SelectFineOptions);
        clickOn(SelectFineOptions);
        forcedWaitTime(3);
        noticeName = getTextElement(SelectFineDropDown2);
        System.out.println(noticeName);

        waitForElementIsInteractable(AddFineButton);
        try {
            forcedWaitTime(3);
            clickByJsExecuter(AddFineButton);

        }catch (Exception e){
            forcedWaitTime(3);
            clickOn(AddFineButton);
        }

    }

    public void generateNoticepopup() throws InterruptedException {
        forcedWaitTime(3);
        waitUntilElementIsVisible(DonotPrint);
        clickByJsExecuter(DonotPrint);
        clickByJsExecuter(IssueButton);
        waitForCurserRunning(3);

    }


    public String getOutstandingBalance() {
        waitUntilElementIsVisible(By.xpath(
                "//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));
        String oustandingBal = getTextElement(By.xpath(
                "//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));

        return oustandingBal;
    }

    public int fineAmountDisplayeonGenerateNotice(By fineLocator) {
        String value = (getSpecificAttribute(fineLocator, "value"));
        System.out.println(value);
        String actualFine = value.split("\\.")[0];
        int actualFineAmount = Integer.parseInt(actualFine);
        return actualFineAmount;
    }

    public double fineAmountDisplayeonGenerateNotice2(By fineLocator) {
        String value = (getSpecificAttribute(fineLocator, "value"));
        System.out.println(value);
//        String actualFine = value.split("\\.")[0];
        double actualFineAmount = Double.parseDouble(value);
        return actualFineAmount;
    }

    public int editFlatFine(By fineLocator) throws InterruptedException {
        int updatedFineAmount = 20000;
        // 200 but written as 20000 as per the field as it includes decimal values also.
        String updateAmountFine = Integer.toString(updatedFineAmount);
        clearByJSE(fineLocator);
        Thread.sleep(3000);
        waitForElementIsInteractable(fineLocator);
        movetoElementAndClick(fineLocator);
        sendKeysWithWait(fineLocator, updateAmountFine);

        String UpdatedactualFine = getSpecificAttribute(fineLocator, "value").split("\\.")[0];
        int updatedFineAmountActual = Integer.parseInt(UpdatedactualFine);
        return updatedFineAmountActual;

    }

    public int makePayment(By fineLocator, String ammount) throws InterruptedException {
        int updatedFineAmount = 20000;
        // 200 but written as 20000 as per the field as it includes decimal values also.
        String updateAmountFine = Integer.toString(updatedFineAmount);
        clearByJSE(fineLocator);
        Thread.sleep(3000);
        waitForElementIsInteractable(fineLocator);
        movetoElementAndClick(fineLocator);
        sendKeysWithWait(fineLocator, updateAmountFine);

        String UpdatedactualFine = getSpecificAttribute(fineLocator, "value").split("\\.")[0];
        int updatedFineAmountActual = Integer.parseInt(UpdatedactualFine);
        return updatedFineAmountActual;

    }

    public Boolean buttonisEnabledOrDisabled(By loc) {
        return findElement(loc).isEnabled();
    }


    public void navigateToAgencySetupCitation() throws InterruptedException {
        crmCommonMethod.navigateToAgencySetup();
    }

    public void navigateToFinesCitation() throws InterruptedException {
        crmCommonMethod.navigateToFines();
    }

    public void addPayment(By fineLocator, int updatedFineAmount) throws InterruptedException {
        String updateAmountFine = Integer.toString(updatedFineAmount);
        clearByJSE(fineLocator);
        Thread.sleep(3000);
        waitForElementIsInteractable(fineLocator);
        movetoElementAndClick(fineLocator);
        sendKeysWithWait(fineLocator, updateAmountFine);
    }
}
