package POM;

import BrowsersBase.BrowsersInvoked;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class PerformInspectionUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods CEcommonMethod;
	CRMCommonMethods crmMethods;
	CLPUtility cLPUtility;
	PerformInspectionUtility PI;

	public PerformInspectionUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		CEcommonMethod = new CECommonMethods(driver);
		crmMethods = new CRMCommonMethods(driver);
		cLPUtility = new CLPUtility(driver);
		// PI=new PerformInspectionUtility(driver);

	}

	public static By selectNoticeDownArrow = By.xpath("//div[@class='Select-control']");
	public static By escalateNoticeValMsg = By.xpath("//*[@class='approval-warning align']/em");
	public static String performInsButton = "//button[text()='Perform Inspection']";
	public static String continueBtn = "//div[@class='footer_actions']/button[2]";
	public static By continueBtn1 =By.xpath("//div[@class='footer_actions']/button[1]");
	public static String globalValidMsg = "//div[@class='case-inspection__global-error']/h2";
	public static String titlePIPage = "//div[@class='perform-inspection__title-text']/h1";
	public static String addVioPI = "//div[@id='case-inspection']//input";
	public static String selectVioList = "//div[@id='case-inspection']//div[@class='list-label']";
	public static String invalidBtnList = "//div[@class='multi-choice-buttons']/button[text()='Invalid']";
	public static String noteField = "//textarea[@placeholder='Enter Note']";
	public static String footerButtons = "//div[@class='footer_actions']/button";
	public static String addImgIcon = "//div[@class='case__attachment__title']/button";
	public static String browseFileLink = "//div[@class='attachments-modal__drag-drop-box']/label";
	public static String addBtnAttach = "//div[@class='attachments-modal__footer']/button[2]";
	public static String caseVioList = "//div[@class='case-details__violation-tile']/following::div[@class='case-violation-list']";
	public static String confirmationPopup = "//div[@class='disclaimer-modal__disclaimer-img']";
	public static String cancelConfirmation = "//div[@class='flex-row--center']/button[text()='Cancel']";
	public static String closeCasePopup = "//div[@class='modal-header' and text()='Close Case']";
	public static String modalHeaderPI = "//div[@class='modal-header']";
	public static String validBtnList = "//div[@class='multi-choice-buttons']/button[text()='Valid']";
	public static String voluntaryToggle = "//div[@class='multi-choice-buttons']/button[text()='Voluntary']";
	public static String cancelCloseCase = "//div[@class='modal-footer']//button[text()='Cancel']";
	public static String issueNoticeBtn = "//div[@class='progressive-form__footer']/button";
	public static String editVerifyVio = "//h2[text()='Verify Violations']/preceding-sibling::div";
	public static String editVioIcon = "//div[@class='case-inspection__violation-tile ']//div[@class='edit-entity__button-wrapper']/button";
	public static String editVioPopup = "//div[@id='case-inspection']//following::div[@class='modal-header']";
	public static String noNoticeToggleButton = "//button[text()='No Notice']";
	public static String noticeIssueDate = "//input[@name='issuedAt']";
	public static String cancelEditAnimal = "//div[@class='entity-modal__footer']/button[text()='Cancel']";
	public static String labelVioStatus1 = "//div/h2[text()='Verify Violations']/following-sibling::label";
	public static String vioVerificationStatus = "//div[@class='case-violation__status verification-pending']/label";
	public static String titleSection2 = "//h2[text()='Select Notice & Schedule Follow Up']";
	public static String forcedToggle = "//div[@class='multi-choice-buttons']/button[text()='Forced']";
	public static String closedInvalidStatus = "//div[@class='case-violation__status closed']";
	public static String openCompliantStatus = "//div[@class='case-violation__status open']";
	public static String noticeSelected = "//div[@class='notice-list row']//button";
	public static String noticeSelected2 = "(//div[@class='notice-list row']//button)[2]";
	public static String selectANotice = "//*[contains(text(),'HTML')]";
	public static String notice2 = "//div[@class='notice-list row']//button[2]";
	public static String titleSection3 = "//h2[text()='Generate Notice']";
	public static String noticeDatePicker = "//td[@class='rdtDay rdtActive rdtToday']/following::td[2]";
	public static String issueNoticeButton = "//button[text()='Issue Notice & Complete Inspection']";
	public static String continueBtnSec2 = "//div[@class='progressive-form active']//button[text()='Continue']";
	public static String vioListSec2 = "//div[@class='progressive-form active']//div[@class='case-violation-list']";
	public static String complyByDateFld = "(//input[@name='complyByDate'])[1]";
	public static String complyByDatePicker = "(//div[@class='rdt rdtOpen']//td[@class='rdtDay rdtActive']//following-sibling::td)[1]";
	public static String inspectionDateFld = "//input[@name='inspectionPlannedDate']";
	public static String inspectionDatePicker = "//input[@name='inspectionPlannedDate']//following::td[@class='rdtDay rdtActive']//following::td[2]";
	public static String agencyAdmin = "//label[@title='Follow-up inspection date']//following::button[1]";
	public static String inspectionAssingee = "//label[@title='Follow-up inspection assignee']//parent::div//following-sibling::div//button[@class='square-btn btn btn-primary']";
	public static String certifiedMail = "//label[@title='Certified Mail Number']";
	public static String certifiedMailFld = "//input[@name='certifiedMailNumber']";
	public static String recipientTile = "//div[@class='recipient-tile-headline']";
	public static String recipientContacts = "//div[@class='recipient-tile__subtile']//span[@class='contact-name']";
	public static String generateNoticeBtn = "//div[@class='progressive-form__footer']//button[text()='Generate Notice']";
	public static String errorMsgSec3 = "//span[@class='tile-error']";
	public static String responsiblePartyTile = "//div[@class='responsible-party-tile-headline']";
	public static String exitBtn = "//button[text()='Exit']";
	public static String generateNoticePopup = "//h1[text()='Generate Notice']";
	public static String cancelNoticeBtn = "//div[@class='case-inspection__notice-action-buttons']/button[1]";
	public static String noticeContent = "//body[@class='mce-content-body ']/p";
	public static String printBtn = "//div[@class='case-inspection__print-notice']//button[text()='Print']";
	public static String doNotPrintBtn = "//div[@class='case-inspection__print-notice']//button[text()='Do Not Print']";
	public static String issueNoticeCIBtn = "//div[@class='case-inspection__notice-action-buttons']/button[2]";
	public static String yesConfirmation = "//div[@class='flex-row--center']/button[text()='Yes']";
	public static String totalContacts = "//div[@class='contact flex-row--center']";
	public static String iframeHTML = "editor_ifr";
	public static String cLP = "//a[text()='Cases']";
	public static String cDP = "//span[@class='checkbox-holder']/following::a[1]";
	public static String addContactsPIP = "//*[@class='contact-tile__searchbox searchbox-container']/div/div";
	public static String crtContactLink2 = "//span[text()='Create a  new contact']";
	public static String nameFieldPIP = "//input[@name='name']";
	public static String crtContactBtn = "//button[text()='Create Contact']";
	public static String followUpInspectionSection = "//h4[text()='Follow-up Inspection' and '1']";
	public static String editFollowUpIcon = "//div[@class='abatement-activities__next_edit']/button";
	public static String editFollowUpPopup = "//div[text()='Edit Follow-up Inspection 1']";
	public static String after7daysDateLink = "//a[text()='After 7 days']";
	public static String updateButton = "//button[text()='Update']";
	public static String scheduleInspectionBtn = "//button[text()='Schedule Inspection']";
	public static String scheduleInspectionPopupBtn = "//div[@class='modal-footer']//button[text()='Schedule Inspection']";
	public static String continueBtnFollowUp = "//div[@class='footer_actions']/button[text()='Continue']";
	public static String continueBtnFollowUp2 = "(//button[text()='Continue'])[2]";
	public static String inspectVioSection = "(//div[@class='progressive-form__title']/h2)[1]";
	public static String arrowForPINote = "//div[@class='abatement-activities__inspection-info']/span";
	public static String inspectionNoteCDP = "//label[@class='inspection-note__label']/following-sibling::p";
	public static String caseNotesIcon = "(//button[@class='attach-btn btn btn-primary'])[2]";
	public static String caseNotePopupValidate = "//div[text()='Add Internal Comment']";
	public static String noticePopupCancel = "//button[text()='Cancel']";
	public static String validationMessage = "//span[text()='The Internal comment is required.']";
	public static String noteTextArea = "//textarea[@name='internalComment']";
	public static String notes5000valMsg = "//span[text()='5000 character limit.']";
	public static String createNoteButton = "//button[text()='Create Comment']";
	public static String createdNotesTitle = "//div[@id='case-notes']//h2/span";
	public static String newNoticeToggle = "//button[text()='New Notice']";
	public static String buttonText = "//button[contains(text(),'%s')]";
	public static By userNameSearch = By.xpath("(//input[@placeholder='Search...'])[2]");
	public static String followUpInspectionAssignee = "//li//b[text()='%s']";
	public static By performInspectionAndCreateCase = By.xpath("//button[text()='Create & Perform Inspection']");
	public static String notices = "//button[text()='%s']";
	public static String noticesInDropdownPI="//button[text()='%s']";
	public static String noticesFromDropdown = "//div[@class='Select-menu']//*[text()='%s']";
	public static By doNotPrint = By.xpath("//button[text()='Do Not Print']");

	public static By PerformInsButton = By.xpath(performInsButton);
	public static By ContinueBtn = By.xpath(continueBtn);
	public static By GlobalValidMsg = By.xpath(globalValidMsg);
	public static By TitlePIPage = By.xpath(titlePIPage);
	public static By AddVioPI = By.xpath(addVioPI);
	public static By SelectVioList = By.xpath(selectVioList);
	public static By InvalidBtnList = By.xpath(invalidBtnList);
	public static By NoteField = By.xpath(noteField);
	public static By FooterButtons = By.xpath(footerButtons);
	public static By AddImgIcon = By.xpath(addImgIcon);
	public static By BrowseFileLink = By.xpath(browseFileLink);
	public static By AddBtnAttach = By.xpath(addBtnAttach);
	public static By CaseVioList = By.xpath(caseVioList);
	public static By ConfirmationPopup = By.xpath(confirmationPopup);
	public static By CancelConfirmation = By.xpath(cancelConfirmation);
	public static By CloseCasePopup = By.xpath(closeCasePopup);
	public static By ModalHeaderPI = By.xpath(modalHeaderPI);
	public static By ValidBtnList = By.xpath(validBtnList);
	public static By VoluntaryToggle = By.xpath(voluntaryToggle);
	public static By CancelCloseCase = By.xpath(cancelCloseCase);
	public static By IssueNoticeBtn = By.xpath(issueNoticeBtn);
	public static By EditVerifyVio = By.xpath(editVerifyVio);
	public static By EditVioIcon = By.xpath(editVioIcon);
	public static By EditVioPopup = By.xpath(editVioPopup);
	public static By LabelVioStatus1 = By.xpath(labelVioStatus1);
	public static By NoNoticeToggleButton = By.xpath(noNoticeToggleButton);
	public static By NoticeIssueDate = By.xpath(noticeIssueDate);
	public static By CancelEditAnimal = By.xpath(cancelEditAnimal);
	public static By VioVerificationStatus = By.xpath(vioVerificationStatus);
	public static By TitleSection2 = By.xpath(titleSection2);
	public static By ForcedToggle = By.xpath(forcedToggle);
	public static By ClosedInvalidStatus = By.xpath(closedInvalidStatus);
	public static By OpenCompliantStatus = By.xpath(openCompliantStatus);
	public static By NoticeSelected = By.xpath(noticeSelected);
	public static By NoticeSelected2 = By.xpath(noticeSelected2);
	public static By SelectANotice = By.xpath(selectANotice);
	public static By Notice2 = By.xpath(notice2);
	public static By TitleSection3 = By.xpath(titleSection3);
	public static By NoticeDatePicker = By.xpath(noticeDatePicker);
	public static By IssueNoticeButton = By.xpath(issueNoticeButton);
	public static By ContinueBtnSec2 = By.xpath(continueBtnSec2);
	public static By VioListSec2 = By.xpath(vioListSec2);
	public static By ComplyByDateFld = By.xpath(complyByDateFld);
	public static By ComplyByDatePicker = By.xpath(complyByDatePicker);
	public static By InspectionDateFld = By.xpath(inspectionDateFld);
	public static By InspectionDatePicker = By.xpath(inspectionDatePicker);
	public static By AgencyAdmin = By.xpath(agencyAdmin);
	public static By InspectionAssingee = By.xpath(inspectionAssingee);
	public static By CertifiedMail = By.xpath(certifiedMail);
	public static By CertifiedMailFld = By.xpath(certifiedMailFld);
	public static By RecipientTile = By.xpath(recipientTile);
	public static By RecipientContacts = By.xpath(recipientContacts);
	public static By GenerateNoticeBtn = By.xpath(generateNoticeBtn);
	public static By ErrorMsgSec3 = By.xpath(errorMsgSec3);
	public static By ResponsiblePartyTile = By.xpath(responsiblePartyTile);
	public static By ExitBtn = By.xpath(exitBtn);
	public static By GenerateNoticePopup = By.xpath(generateNoticePopup);
	public static By CancelNoticeBtn = By.xpath(cancelNoticeBtn);
	public static By NoticeContent = By.xpath(noticeContent);
	public static By PrintBtn = By.xpath(printBtn);
	public static By DoNotPrintBtn = By.xpath(doNotPrintBtn);
	public static By IssueNoticeCIBtn = By.xpath(issueNoticeCIBtn);
	public static By YesConfirmation = By.xpath(yesConfirmation);
	public static By TotalContacts = By.xpath(totalContacts);
	public static By IframeHTML = By.id(iframeHTML);
	public static By CLP = By.xpath(cLP);
	public static By CDP = By.xpath(cDP);
	public static By AddContactsPIP = By.xpath(addContactsPIP);
	public static By CrtContactLink2 = By.xpath(crtContactLink2);
	public static By NameFieldPIP = By.xpath(nameFieldPIP);
	public static By CrtContactBtn = By.xpath(crtContactBtn);
	public static By FollowUpInspectionSection = By.xpath(followUpInspectionSection);
	public static By EditFollowUpIcon = By.xpath(editFollowUpIcon);
	public static By EditFollowUpPopup = By.xpath(editFollowUpPopup);
	public static By After7daysDateLink = By.xpath(after7daysDateLink);
	public static By UpdateButton = By.xpath(updateButton);
	public static By ScheduleInspectionBtn = By.xpath(scheduleInspectionBtn);
	public static By ScheduleInspectionPopupBtn = By.xpath(scheduleInspectionPopupBtn);
	public static By ContinueBtnFollowUp = By.xpath(continueBtnFollowUp);
	public static By ContinueBtnFollowUp2 = By.xpath(continueBtnFollowUp2);
	public static By InspectVioSection = By.xpath(inspectVioSection);
	public static By ArrowForPINote = By.xpath(arrowForPINote);
	public static By InspectionNoteCDP = By.xpath(inspectionNoteCDP);
	public static By CaseNotesIcon = By.xpath(caseNotesIcon);
	public static By CaseNotePopupValidate = By.xpath(caseNotePopupValidate);
	public static By NoticePopupCancel = By.xpath(noticePopupCancel);
	public static By ValidationMessage = By.xpath(validationMessage);
	public static By NoteTextArea = By.xpath(noteTextArea);
	public static By Notes5000valMsg = By.xpath(notes5000valMsg);
	public static By CreateNoteButton = By.xpath(createNoteButton);
	public static By CreatedNotesTitle = By.xpath(createdNotesTitle);
	public static By NewNoticeToggle = By.xpath(newNoticeToggle);

	public static By addAnotherViolationBox = By.xpath("(//div[@role='combobox'])[3]");
	public static By selectViolAnimalFromDropdown = By.cssSelector(".list-label");
	public static By animalColourBox = By.xpath("(//*[@class='field__input row']//*[@placeholder='Enter Text'])[1]");
	public static By addBtn_For_EntitiyViolation = By.xpath("//button[text()='Add']");

	public static String searchLocation_text = "//input[@placeholder='Enter Address, APN or Drop a pin on Map']";
	public static By SearchLocation_text = By.xpath(searchLocation_text);

	public static String streetAddressafter = "(//div[@class='location-tile__fields']//label[@class='field__label-data-field'])[1]";
	public static By StreetAddressafter = By.xpath(streetAddressafter);

	public static String street_Cityafter = "(//div[@class='location-tile__fields']//label[@class='field__label-data-field'])[2]";
	public static By StreetCityafter = By.xpath(street_Cityafter);

	public static String street_Zipafter = "(//div[@class='location-tile__fields']//label[@class='field__label-data-field'])[4]";
	public static By StreetZipafter = By.xpath(street_Zipafter);

	public static String street_APNafter = "(//div[@class='location-tile__fields']//label[@class='field__label-data-field'])[5]";
	public static By StreetAPNafter = By.xpath(street_APNafter);

	public static String editLocation_btn = "//button[@class='edit-btn  btn btn-primary']";

	public static String apn_text = "//input[@name='apn']";
	public static By Apn_Text = By.xpath(apn_text);

	public static By EditLocation_btn = By.xpath(editLocation_btn);
	public static By extractDaysCDP = By.xpath("//div[@class='case-violation-list__violation-info-text']/.//span[@class='comply-by-days']");
	public static By complyByDate = By.xpath("//input[@name='complyByDate']");


	public static String streetAddreassBefore;
	public static String streetCityBefore;
	public static String streetZipBefore;
	public static String streetAPNBefore;

	public static String streetAddreassafter;
	public static String streetCityafter;
	public static String streetZipafter;
	public static String streetAPNafter;
	public static By validTogglebtn = By.xpath("//button[@class='square-btn btn btn-danger'][text()='Valid']");
	public static By validToggleBtn2= By.xpath("(//*[text()=\"Valid\"])[2]");

	public static By AddanotherAnimalLinkText = By.xpath("//a[text()='Add another Animal']");
	public static By AddButtonViolation = By.xpath("//button[text()='Add']");
	public static By YesBtnConfirmationPopup = By.xpath("//div[@class='flex-row--center']/button[text()='Yes']");
	public static By FooterButton = By.xpath("//div[@class='footer_actions']/button");
	public static By InvalidVioToggle = By.xpath("//div[@class='multi-choice-buttons']/button[text()='Invalid']");
	public static By assignee = By.xpath("//button[normalize-space()='StandCRMzOVdGX eDVLOB']");
   public static By complyByDateResolution = By.xpath("//span[contains(@class,'comply-by-days')]");
   public static By complyCDPDate =By.xpath("//label[normalize-space()='Comply by']/..");
	public static By complyDateOnCDP = By.xpath("//label[text()='Comply by']//following-sibling::label");
   static String InspectionNote = RandomStrings.requiredString(15);

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void PerformInspection_PreRequisite_CDP() throws InterruptedException {
		
			CEcommonMethod.createACase();
			String CaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
			CEcommonMethod.closeCaseDetailPage();
			CEcommonMethod.searchCaseAndNavigateToCDP(CaseId);
		
	}

	public static boolean ValidTogglebtn;
	public static boolean InValidToggle;
	public static int selectNotice;
	public static int noticeIssuedte;
	public static String certifiedMailNo;
	public static By invalidToogelbtn = By.xpath("//button[text()='Invalid']");
	public static By noNoticeBtn = By.xpath("//button[text()='No Notice']");
	public static By CompleteInspectiontBtn = By
			.xpath("//div[@class='progressive-form__footer']//button[text()='Complete Inspection']");
	public static By NewNoticeBtn = By.xpath("//button[text()='New Notice']");
	public static By queueToPrint = By
			.xpath("//div[@class='case-inspection__print-notice']//button[text()='Queue To Print']");
	public static By selectNoticelbl = By.xpath("//label[@title='Select a notice']");
	public static By noticeIssueDatelbl = By.xpath("//label[@title='Notice issue date']");

	public void PerformInspection_VerifyCreatAndPerformInspection() throws InterruptedException {

        CEcommonMethod.createCaseAndPerformInspection();
        waitUntilElementIsVisible(validTogglebtn);
        ValidTogglebtn = findElement(validTogglebtn).isDisplayed();
        clickOn(invalidToogelbtn);
        InValidToggle = findElement(By.xpath("//button[text()='Invalid'][@class='square-btn btn btn-info']"))
                .isDisplayed();
        clickOn(By.xpath("//button[text()='Valid'][@class='square-btn btn btn-default']"));
        waitForElementIsInteractable(ContinueBtnFollowUp);
        clickOn(ContinueBtnFollowUp);
        waitUntilElementIsVisible(noNoticeBtn);
        waitUntilElementIsVisible(By.xpath(continueBtnFollowUp2));
        clickByJsExecuter(noNoticeBtn);
        selectNotice = driver.findElements(selectNoticelbl).size();
        noticeIssuedte = driver.findElements(noticeIssueDatelbl).size();
        waitUntilElementIsVisible(CompleteInspectiontBtn);
        CEcommonMethod.selectUserScheduleFollowUpInspection("two");
        waitUntilElementIsVisible(CompleteInspectiontBtn);
        scrollIntoView(NewNoticeBtn);
        clickByJsExecuter(NewNoticeBtn);
        waitUntilElementIsVisible(By.xpath(continueBtnFollowUp2));
        waitForElementIsInteractable(By.xpath(
                "(//div[@class='notice-list row'])[2]//div[@class='multi-choice-buttons']/button[starts-with(text(),'HTML')]"));
        int htmlSizebtn = driver.findElements(By.xpath("(//div[@class='notice-list row'])[2]//div[@class='multi-choice-buttons']/button[starts-with(text(),'HTML')]")).size();
        if (htmlSizebtn > 0) {
            clickByJsExecuter(By.xpath(
                    "(//div[@class='notice-list row'])[2]//div[@class='multi-choice-buttons']/button[starts-with(text(),'HTML')]"));
        } else {
        	
        	movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);
        	
            List<WebElement> AllNotices = findElementsByXPath(SelectANotice);
            int CountNotices = AllNotices.size();
            for (int i = 0; i < CountNotices; i++) {
                WebElement ListSeq = AllNotices.get(i);
                String[] NoticeType = ListSeq.getText().split(" ");
                if (NoticeType[0].equalsIgnoreCase("HTML")) {
                    ListSeq.click();
                    break;
                }
            }
        }
        waitForElementIsInteractable(ContinueBtnFollowUp2);
        clickOn(ContinueBtnFollowUp2);
        forcedWaitTime(4);
        waitUntilElementIsVisible(GenerateNoticeBtn);
        clickOn(GenerateNoticeBtn);
        waitForElementIsInteractable(queueToPrint);
        clickOn(queueToPrint);
        waitForElementIsInteractable(By.xpath(issueNoticeButton));
        clickOn(By.xpath(issueNoticeButton));
        waitUntilElementIsVisible(YesConfirmation);
        waitForElementIsInteractable(YesConfirmation);
        clickOn(YesConfirmation);
        waitForCurserRunning(10);
        waitUntilElementIsVisible(FollowUpInspectionSection);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
        WebElement FollowUp2Title = waitUntilVisibleWE(FollowUpInspectionSection);
        if (!(FollowUp2Title.isDisplayed())) {
            SoftAssert s120 = new SoftAssert();
            s120.assertEquals(false, true);
            s120.assertAll();
        }
    }

	public void CCP_CDP_EditLocation() throws InterruptedException {

		waitUntilElementIsVisible(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
		streetAddreassBefore = getValueAttribute(CCPUtility.EditStreetAdd);
		streetCityBefore = getValueAttribute(CCPUtility.EditCity);
		streetZipBefore = getValueAttribute(CCPUtility.EditZip);
		streetAPNBefore = getValueAttribute(Apn_Text);
		String rndStreet = "street" + RandomStrings.requiredString(4);
		String rndcity = "city" + RandomStrings.requiredString(4);
		String rndZip = RandomStrings.requiredDigits(4);
		String rndAPN = RandomStrings.requiredDigits(4) + "-" + RandomStrings.requiredDigits(4) + "-"
				+ RandomStrings.requiredDigits(4) + "-" + RandomStrings.requiredDigits(4);

		clearByJSE(CCPUtility.EditStreetAdd);
		waitForElementIsInteractable(CCPUtility.EditStreetAdd);
		sendKeysWithWait(CCPUtility.EditStreetAdd, rndStreet);
		clearByJSE(CCPUtility.EditCity);
		waitForElementIsInteractable(CCPUtility.EditCity);
		sendKeysWithWait(CCPUtility.EditCity, rndcity);
		clearByJSE(CCPUtility.EditZip);
		waitForElementIsInteractable(CCPUtility.EditZip);
		sendKeysWithWait(CCPUtility.EditZip, rndZip);
		clearByJSE(Apn_Text);
		waitForElementIsInteractable(Apn_Text);
		sendKeysWithWait(Apn_Text, rndAPN);
		waitForElementIsInteractable(cLPUtility.SaveButton);
		clickByJsExecuter(cLPUtility.SaveButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(StreetAddressafter);
		waitUntilElementPresent(StreetAddressafter);
		streetAddreassafter = getValueAttribute(StreetAddressafter);
		streetCityafter = getValueAttribute(StreetCityafter);
		streetZipafter = getValueAttribute(StreetZipafter);
		streetAPNafter = getValueAttribute(StreetAPNafter);
	}

	public void PerformInspection_PreRequisite_Contacts() {

		try {
			waitUntilElementIsVisible(TotalContacts);
			scrollIntoView(TotalContacts);
			implicitWaitforCustometime(2);
			List<WebElement> CountContacts = driver.findElements(TotalContacts);
			if (((CountContacts.size()) >= 2) == false) {
				for (int con = 0; con < 2; con++) {
					waitForElementIsInteractable(AddContactsPIP);
					clickOn(AddContactsPIP);
					waitForElementIsInteractable(CrtContactLink2);
					clickOn(CrtContactLink2);
					String ContactName = RandomStrings.requiredString(10);
					waitForElementIsInteractable(NameFieldPIP);
					sendKeysWithWait(NameFieldPIP, ContactName);
					clickOn(CrtContactBtn);
					waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
					waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
					clickOn(CCPUtility.PropertyOwnerOption);
					waitForElementIsInteractable(CCPUtility.ApplyButton);
					clickOn(CCPUtility.ApplyButton);
					waitForCurserRunning(5);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void PerformInspection_OpenVerificationInspectionInProgressPage() throws InterruptedException {

		implicitWaitforCustometime(2);
		waitUntilElementIsVisible(PerformInsButton);
		scrollIntoView(PerformInsButton);
		waitForElementIsInteractable(PerformInsButton);
		clickByJsExecuter(PerformInsButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(TitlePIPage);
		waitUntilElementIsVisible(TitlePIPage);
		String[] Title = getTextElement(TitlePIPage).split("-");
		String TitleValid = Title[0];
		String ActualTitle = "Verification Inspection in Progress ";

		SoftAssert s65 = new SoftAssert();
		s65.assertEquals(ActualTitle, TitleValid);
		s65.assertAll();

	}

	public void PerformInspection_ValidationMessageSection1() throws InterruptedException {

		try {
			implicitWaitforCustometime(2);
			waitForElementIsInteractable(ContinueBtn);
			clickByJsExecuter(ContinueBtn);
			String ActValidMsg = getTextElement(GlobalValidMsg);
			String ExpValidMsg = "Could not proceed. There are missing fields/information on this page.";
			SoftAssert s66 = new SoftAssert();
			s66.assertEquals(ActValidMsg, ExpValidMsg);
			s66.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PerformInspection_VerifySection1Status() {

		try {
			implicitWaitforCustometime(2);
			waitUntilElementIsVisible(LabelVioStatus1);
			String VioStatus1 = getTextElement(LabelVioStatus1);
			SoftAssert s67 = new SoftAssert();
			s67.assertEquals(VioStatus1, "Incomplete");
			s67.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PerformInspection_AddAViolation() throws InterruptedException {

		// List<WebElement> VioList = findElementsByXPath(CaseVioList);
		List<WebElement> VioList = driver.findElements(By.xpath(caseVioList));
		int BeforeAdding = VioList.size();
		System.out.println("Before adding " + BeforeAdding);
		waitForElementIsInteractable(AddVioPI);
		sendKeysWithWait(AddVioPI, "Waterf");
		waitForElementIsInteractable(SelectVioList);
		clickOn(SelectVioList);
		waitForCurserRunning(5);
		implicitWaitforCustometime(2);
		waitUntilElementIsVisible(CaseVioList);
		List<WebElement> VioList2 = driver.findElements(By.xpath(caseVioList));
		int AfterAdding = VioList2.size();
		System.out.println("After adding " + AfterAdding);
		SoftAssert s68 = new SoftAssert();
		s68.assertEquals(AfterAdding, BeforeAdding + 1,
				"Violation After Adding " + AfterAdding + "  must be 1 greater than before Adding. " + BeforeAdding);
		s68.assertAll();

	}

	public void PerformInspection_VerifyVerificationPendingStatusForViolation() {

		String VioVerifStatus = getTextElement(VioVerificationStatus);
		SoftAssert s69 = new SoftAssert();
		s69.assertEquals(VioVerifStatus, "Verification Pending ");
		s69.assertAll();

	}

	public void PerformInspection_SelectAnyToggleButtonForViolation() {

		clickOn(InvalidBtnList);
		WebElement InvalidToggle = waitUntilVisibleWE(InvalidBtnList);
		if ((InvalidToggle.isEnabled()) == false) {

			SoftAssert s70 = new SoftAssert();
			s70.assertEquals(false, true);
			s70.assertAll();
		}

	}

	public void PerformInspection_VerifyClosedStatusForViolation() {

		try {
			waitForElementIsInteractable(InvalidBtnList);
			clickOn(InvalidBtnList);
			waitUntilElementIsVisible(ClosedInvalidStatus);
			String[] VioVerifStatus1 = getTextElement(ClosedInvalidStatus).split(",");

			SoftAssert s71 = new SoftAssert();
			s71.assertEquals(VioVerifStatus1[0], "Closed");
			s71.assertAll();

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void PerformInspection_VerifyOpenStatusForViolation() {

		clickOn(ValidBtnList);

		String VioVerifStatus1 = getTextElement(OpenCompliantStatus);

		SoftAssert s72 = new SoftAssert();
		s72.assertEquals(VioVerifStatus1, "Open, non-compliant ");
		s72.assertAll();
	}

	public void PerformInspection_VerifyContinueButtonPresence() {

		List<WebElement> InvalidList = waitUntilVisibleList(InvalidBtnList);
		int CountList = InvalidList.size();
		for (int i = 0; i < CountList; i++) {
			WebElement ListClick = InvalidList.get(i);
			ListClick.click();
		}
		List<WebElement> FooterBtns = waitUntilVisibleList(FooterButtons);
		int sizeFootBtn = FooterBtns.size();
		if ((sizeFootBtn <= 1) == false) {
			SoftAssert s73 = new SoftAssert();
			s73.assertEquals(false, true);
			s73.assertAll();

		}

	}

	public void PerformInspection_OpenConfirmationPopupForCloseCaseButton() {

		clickOn(FooterButtons);
		WebElement ConfirmationIcon = waitUntilVisibleWE(ConfirmationPopup);
		if ((ConfirmationIcon.isDisplayed()) == false) {
			SoftAssert s74 = new SoftAssert();
			s74.assertEquals(false, true);
			s74.assertAll();
		}

	}

	public void PerformInspection_CloseConfirmationPopup() {

		try {
			waitUntilElementIsVisible(CancelConfirmation);
			waitForElementIsInteractable(CancelConfirmation);
			clickOn(CancelConfirmation);
			waitUntilElementInvisibleLocated(CancelConfirmation);
			waitForCurserRunning(4);
			List<WebElement> ConfirmationValid = driver.findElements(ConfirmationPopup);
			if (((ConfirmationValid.size()) < 1) == false) {
				SoftAssert s75 = new SoftAssert();
				s75.assertEquals(false, true);
				s75.assertAll();

			}
		} catch (Exception e) {
			e.printStackTrace();
			SoftAssert s75 = new SoftAssert();
			s75.assertEquals(false, true);
			s75.assertAll();
		}
	}

	public void PerformInspection_VerifySection2Title() {

		try {
			implicitWaitforCustometime(2);
			waitForElementIsInteractable(ValidBtnList);
			clickOn(ValidBtnList);
			waitUntilElementIsVisible(TitleSection2);
			WebElement Section2 = waitUntilVisibleWE(TitleSection2);
			if ((Section2.isDisplayed()) == false) {
				SoftAssert s76 = new SoftAssert();
				s76.assertEquals(false, true);
				s76.assertAll();

			}
		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_OpenCloseCasePopup() {

		List<WebElement> ValidList = waitUntilVisibleList(ValidBtnList);
		int CountList1 = ValidList.size();
		for (int i = 0; i < CountList1; i++) {
			WebElement ListClick = ValidList.get(i);
			ListClick.click();
		}
		clickOn(FooterButtons);
		waitForElementIsInteractable(CloseCasePopup);
		String CCPopupTitle = getTextElement(CloseCasePopup);

		SoftAssert s77 = new SoftAssert();
		s77.assertEquals(CCPopupTitle, "Close Case");
		s77.assertAll();

	}

	public void PerformInspection_VerifyVoluntaryToggleButtonState() {

		WebElement VoluntaryBtn = waitUntilVisibleWE(VoluntaryToggle);
		if ((VoluntaryBtn.isEnabled()) == false) {
			SoftAssert s78 = new SoftAssert();
			s78.assertEquals(false, true);
			s78.assertAll();

		}

	}

	public void PerformInspection_SelectForcedToggleButton() {

		WebElement ForcedBtn = waitUntilVisibleWE(ForcedToggle);
		if ((ForcedBtn.isEnabled()) == false) {
			SoftAssert s79 = new SoftAssert();
			s79.assertEquals(false, true);
			s79.assertAll();

		}

	}

	public void PerformInspection_CloseCloseCasePopup() {

		try {
			waitUntilElementIsVisible(CancelCloseCase);
			waitUntilElementPresent(CancelCloseCase);
			waitForElementIsInteractable(CancelCloseCase);
			clickByJsExecuter(CancelCloseCase);
			waitUntilElementInvisibleLocated(CancelCloseCase);
			waitForCurserRunning(4);
			implicitWaitforCustometime(3);
			waitUntilElementIsVisible(ModalHeaderPI);
			List<WebElement> ModalCount = findElementsByXPath(ModalHeaderPI);
			if (((ModalCount.size()) < 3) == false) {

				SoftAssert s80 = new SoftAssert();
				s80.assertEquals(false, true);
				s80.assertAll();

			}
		} catch (Exception e) {
			e.printStackTrace();
			SoftAssert s80 = new SoftAssert();
			s80.assertEquals(false, true);
			s80.assertAll();

		}
	}

	public void PerformInspection_AddInspectionNote() {

		waitUntilElementIsVisible(NoteField);
		waitUntilElementPresent(NoteField);
		waitForElementIsInteractable(NoteField);
		clickByJsExecuter(NoteField);
		sendKeysWithWait(NoteField, InspectionNote);

	}

	public void PerformInspection_AddAttachment() throws InterruptedException {

		waitForElementIsInteractable(AddImgIcon);
		clickOn(AddImgIcon);
		implicitWaitforCustometime(2);
		
		CEcommonMethod.uploadAttachment(CEcommonMethod.SetTestDataFilePath("Panda_11zon.jpg"));
		
		waitForCurserRunning(5);
		implicitWaitforCustometime(2);
		waitUntilElementIsVisible(AddBtnAttach);
		waitForElementIsInteractable(AddBtnAttach);
		clickOn(AddBtnAttach);

	}

	public void PerformInspection_ExpandSection2OnContinue() {

		waitForElementIsInteractable(ContinueBtn);
		clickOn(ContinueBtn);
		WebElement CompleteInsBtn = waitUntilVisibleWE(IssueNoticeBtn);
		if ((CompleteInsBtn.isDisplayed()) == false) {
			SoftAssert s83 = new SoftAssert();
			s83.assertEquals(false, true);
			s83.assertAll();

		}

	}

	public void PerformInspection_VerifySection1Label() {

		waitUntilElementIsVisible(LabelVioStatus1);
		waitUntilElementPresent(LabelVioStatus1);
		String LabelComplete = getTextElement(LabelVioStatus1);
		SoftAssert s84 = new SoftAssert();
		s84.assertEquals(LabelComplete, "Complete");
		s84.assertAll();

	}

	public void PerformInspection_EditVerifyViolationSection() throws InterruptedException {

		waitUntilElementPresent(EditVerifyVio);
		waitForElementIsInteractable(EditVerifyVio);
		clickByJsExecuter(EditVerifyVio);
		Thread.sleep(5000);

		// CEcommonMethod.CE_AddViolationWithEntity("Animal", "Black");

		addViolationOnVeriftViolation1_Animal();

		waitUntilElementIsVisible(EditVioIcon);
		waitForElementIsInteractable(EditVioIcon);
		clickByJsExecuter(EditVioIcon);
		waitUntilElementIsVisible(EditVioPopup);
		String[] EditVioTitle = getTextElement(EditVioPopup).split(" ");
		SoftAssert s85 = new SoftAssert();
		s85.assertEquals(EditVioTitle[0], "Edit");
		s85.assertAll();
		waitForElementIsInteractable(CancelEditAnimal);
		clickByJsExecuter(CancelEditAnimal);
		Thread.sleep(2000);
		By addAnotherVioTxt = By.xpath("(//*[@class='violation-tile__searchbox-label'])[2]");
		clickByJsExecuter(addAnotherVioTxt);
		// ClickByJsExecuter(By.xpath("(//button[text()='Valid'])[3]"));
		By selectValid = By.xpath("(//button[text()='Valid'])[2]");
		clickByJsExecuter(selectValid);
		waitUntilElementIsVisible(ContinueBtn);
		scrollIntoView(ContinueBtn);
		waitUntilElementPresent(ContinueBtn);
		waitForElementIsInteractable(ContinueBtn);
		clickByJsExecuter(ContinueBtn);

	}

	public void PerformInspection_VerifyFirstNoticeState() throws InterruptedException {

		waitForCurserRunning(5);
		implicitWaitforCustometime(2);
		waitUntilElementIsVisible(NoticeSelected2);
		waitUntilElementPresent(NoticeSelected2);
		WebElement Notice = findElement(NoticeSelected2);
		if ((Notice.isEnabled()) == false) {

			SoftAssert s86 = new SoftAssert();
			s86.assertEquals(false, true);
			s86.assertAll();
		}
	}

	public void PerformInspection_SelectAnyNotice() throws InterruptedException {

		waitUntilElementIsVisible(Notice2);
		waitForElementIsInteractable(Notice2);
		clickByJsExecuter(Notice2);
		implicitWaitforCustometime(1);
		WebElement Notice02 = waitUntilVisibleWE(Notice2);
		if ((Notice02.isEnabled()) == false) {
			SoftAssert s87 = new SoftAssert();
			s87.assertEquals(false, true);
			s87.assertAll();
		}

	}

	public void PerformInspection_VerifySection3Title() {

		try {
			implicitWaitforCustometime(1);
			List<WebElement> AllNotices = waitUntilVisibleList(NoticeSelected);
			int CountNotices = AllNotices.size();
			for (int i = 0; i < CountNotices; i++) {
				WebElement ListSeq = AllNotices.get(i);
				String[] NoticeType = ListSeq.getText().split(" ");
				if (NoticeType[0].equalsIgnoreCase("HTML")) {
					ListSeq.click();
					break;
				}
			}
			WebElement TitleSec3 = waitUntilVisibleWE(TitleSection3);
			if ((TitleSec3.isDisplayed()) == false) {

				SoftAssert s88 = new SoftAssert();
				s88.assertEquals(false, true);
				s88.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_SelectNoNoticeRequiredCheckbox() throws InterruptedException {

		WebElement NoNoticeToggle = waitUntilVisibleWE(NoNoticeToggleButton);
		NoNoticeToggle.click();
		implicitWaitforCustometime(2);
		if ((NoNoticeToggle.isEnabled()) == false) {
			SoftAssert s89 = new SoftAssert();
			s89.assertEquals(false, true);
			s89.assertAll();
		}

	}

	public void PerformInspection_UpdateNoticeIssueDate() throws InterruptedException {

		waitForElementIsInteractable(By.xpath("//button[text()='New Notice']"));
		clickOn(By.xpath("//button[text()='New Notice']"));
		waitForElementIsInteractable(NoticeIssueDate);
		WebElement CurDate = waitUntilVisibleWE(NoticeIssueDate);
		String CurrentDate = CurDate.getAttribute("value");
		clickOn(NoticeIssueDate);
		clickOn(NoticeDatePicker);
		WebElement UpdDate = waitUntilVisibleWE(NoticeIssueDate);
		String UpdatedDate = UpdDate.getAttribute("value");
		SoftAssert s90 = new SoftAssert();
		s90.assertNotEquals(CurrentDate, UpdatedDate);
		s90.assertAll();

	}

	public void PerformInspection_VerifyIssueNoticeAndCompleteInspectionButton() {

		try {
			boolean flag=false;
			clickOn(NewNoticeToggle);
			implicitWaitforCustometime(2);
			List<WebElement> AllNotices1 = waitUntilVisibleList(NoticeSelected);
			int CountNotices = AllNotices1.size();
			for (int i = 0; i < CountNotices; i++) {
				WebElement ListSeq = AllNotices1.get(i);
				String[] NoticeType1 = ListSeq.getText().split("-");
				if (NoticeType1[0].equalsIgnoreCase("Non")) {

					ListSeq.click();
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				Thread.sleep(3000);
				movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

				Thread.sleep(3000);
				scrollIntoViewWebElement(driver.findElement(By.xpath("//*[contains(text(),'Non-HTML')]")));
				movetoElementAndClick(driver.findElement(By.xpath("//*[contains(text(),'Non-HTML')]")));
				
				
				
			}
			
			
			waitUntilElementIsVisible(IssueNoticeButton);
			scrollIntoView(IssueNoticeButton);
			SoftAssert s91 = new SoftAssert();
			s91.assertEquals(elementIsDisplayed(IssueNoticeButton), true);
			s91.assertAll();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_VerifyContinueButtonPresenceOnHtmlSelected() throws InterruptedException {
		
		int size = driver.findElements(By.xpath("//*[starts-with(text(),'HTML')]")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[starts-with(text(),'HTML')]"));
		}

		else {
			Thread.sleep(3000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(3000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[starts-with(text(),'HTML')]")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[starts-with(text(),'HTML')]")));
		}
		
		
		
		
		

//		List<WebElement> AllNotices = WaitUntilVisibleList(NoticeSelected);
//		int CountNotices = AllNotices.size();
//		System.out.println("size of list"+ CountNotices);
//		
		// By moreBtn= By.xpath("//div[@class='Select Select--single']");

		//By HTML_pFVtHGlv_document = By.xpath("//button[contains(text(),'HTML')]");

		// ClickOn(moreBtn);
	//	clickOn(HTML_pFVtHGlv_document);

//		for (int i = 0; i < CountNotices; i++) {
//			WebElement ListSeq = AllNotices.get(i);
//			String[] NoticeType = ListSeq.getText().split(" ");
//			if (NoticeType[0].equalsIgnoreCase("HTML")) {
//				ListSeq.click();
//				System.out.println("Heelloo I am "+NoticeType[0]);
//				break;
//			}
		WebElement ContinueBtn2 = waitUntilVisibleWE(ContinueBtnSec2);
		if ((ContinueBtn2.isDisplayed()) == false) {

			SoftAssert s92 = new SoftAssert();
			s92.assertEquals(false, true);
			s92.assertAll();
		}

	}

	public void PerformInspection_VerifyViolationsUnderReviewOpenViolations() {

		try {
			waitForElementIsInteractable(EditVerifyVio);
			clickOn(EditVerifyVio);
			waitForElementIsInteractable(ValidBtnList);
			List<WebElement> validList = waitUntilVisibleList(ValidBtnList);
			int CountList = validList.size();
			int CountValidVio = 0;
			for (int i = 0; i < CountList; i++) {
				WebElement ListClick = validList.get(i);
				if ((ListClick.isEnabled()) == true) {
					CountValidVio++;
				}
			}
			int finalCount = CountValidVio;
			waitForElementIsInteractable(ContinueBtn);
			clickOn(ContinueBtn);
			implicitWaitforCustometime(2);
			List<WebElement> VioList = waitUntilVisibleList(VioListSec2);
			int actualCount = VioList.size();

			SoftAssert s93 = new SoftAssert();
			s93.assertEquals(actualCount, finalCount);
			s93.assertAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String beforeUpdateComplyDate;
	public static String afterUpdateComplyDate;

	public void PerformInspection_UpdateComplyByDate() {

		try {

			waitUntilElementIsVisible(By.xpath("(//input[@name='complyByDate'])[1]"));
			beforeUpdateComplyDate = findElement(By.xpath("(//input[@name='complyByDate'])[1]")).getAttribute("value");

			implicitWaitforCustometime(2);
			waitUntilElementIsVisible(ComplyByDateFld);
			waitForElementIsInteractable(ComplyByDateFld);
			clickByJsExecuter(ComplyByDateFld);

			waitUntilElementIsVisible(ComplyByDatePicker);
			waitForElementIsInteractable(ComplyByDatePicker);
			clickByJsExecuter(ComplyByDatePicker);
			waitUntilElementInvisibleLocated(ComplyByDatePicker);

			waitUntilElementIsVisible(By.xpath("(//input[@name='complyByDate'])[1]"));
			afterUpdateComplyDate = findElement(By.xpath("(//input[@name='complyByDate'])[1]")).getAttribute("value");

			SoftAssert s93 = new SoftAssert();
			s93.assertNotEquals(afterUpdateComplyDate, beforeUpdateComplyDate);
			s93.assertAll();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_UpdateFollowUpInspectionDate() throws InterruptedException {

		WebElement CurDate2 = waitUntilVisibleWE(InspectionDateFld);
		String CurrentDate2 = CurDate2.getAttribute("value");
		clickOn(InspectionDateFld);
		clickOn(InspectionDatePicker);
		implicitWaitforCustometime(2);
		WebElement UpdDate2 = waitUntilVisibleWE(InspectionDateFld);
		String UpdatedDate2 = UpdDate2.getAttribute("value");

		SoftAssert s97 = new SoftAssert();
		s97.assertNotEquals(CurrentDate2, UpdatedDate2);
		s97.assertAll();

	}

	public void PerformInspection_VerifyLoggedInUserToggleButtonState() throws InterruptedException {

		WebElement Admin = waitUntilVisibleWE(InspectionAssingee);
		String assingee = Admin.getText();
		Boolean LoggedinUser = Admin.isEnabled();
		SoftAssert s98 = new SoftAssert();
		s98.assertEquals(LoggedinUser, Boolean.TRUE);
		s98.assertEquals(assingee, log.AgencyLoggedInUserName);
		s98.assertAll();

	}

	public void PerformInspection_ExpandSection3() throws InterruptedException {

		PerformInspection_VerifyContinueButtonPresenceOnHtmlSelected();
		clickOn(ContinueBtnSec2);
		WebElement VerifyEle = waitUntilVisibleWE(CertifiedMail);
		if ((VerifyEle.isDisplayed()) == false) {

			SoftAssert s99 = new SoftAssert();
			s99.assertEquals(false, true);
			s99.assertAll();
		}

	}

	public void PerformInspection_EnterCertifiedMailNumber() {

		String MailNumber = RandomStrings.requiredString(10);
		sendKeysWithWait(CertifiedMailFld, MailNumber);
		WebElement MailEntered = waitUntilVisibleWE(CertifiedMailFld);
		String MailEntered2 = MailEntered.getAttribute("value");
		if (MailEntered2 == null) {

			SoftAssert s100 = new SoftAssert();
			s100.assertEquals(false, true);
			s100.assertAll();
		}

	}

	public void PerformInspection_VerifyRecipientSubSectionPresence() {

		WebElement RecipientSec = waitUntilVisibleWE(RecipientTile);
		if ((RecipientSec.isDisplayed()) == false) {

			SoftAssert s101 = new SoftAssert();
			s101.assertEquals(false, true);
			s101.assertAll();
		}
	}

	public void PerformInspection_VerifyRecipientNoLongerMandatory() throws InterruptedException {

		waitUntilElementIsVisible(RecipientContacts);
		waitUntilElementPresent(RecipientContacts);
		waitForElementIsInteractable(RecipientContacts);
		clickByJsExecuter(RecipientContacts);
		forcedWaitTime(2);
		waitUntilElementIsVisible(GenerateNoticeBtn);
		scrollIntoView(GenerateNoticeBtn);
		waitForElementIsInteractable(GenerateNoticeBtn);
		clickByJsExecuter(GenerateNoticeBtn);

		waitUntilElementIsVisible(GenerateNoticePopup);
		waitUntilElementPresent(GenerateNoticePopup);
		String NoticePopup = getTextElement(GenerateNoticePopup);
		Assert.assertEquals(NoticePopup, "Generate Notice");
	}

	public void PerformInspection_SelectMultipleContact() {

		try {
			waitForElementIsInteractable(CancelNoticeBtn);
			clickOn(CancelNoticeBtn);
			List<WebElement> RecpContacts = waitUntilVisibleList(RecipientContacts);
			int CountContacts = RecpContacts.size();
			for (int i = 0; i < CountContacts; i++) {
				WebElement ContClick = RecpContacts.get(i);
				ContClick.click();
				implicitWaitforCustometime(2);
				if ((RecpContacts.get(i).isEnabled()) == false) {

					SoftAssert s103 = new SoftAssert();
					s103.assertEquals(false, true);
					s103.assertAll();
				}
			}

		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_VerifyResponsiblePartySectionPresence() {

		WebElement ResponsiblePSec = waitUntilVisibleWE(ResponsiblePartyTile);
		if ((ResponsiblePSec.isDisplayed()) == false) {

			SoftAssert s104 = new SoftAssert();
			s104.assertEquals(false, true);
			s104.assertAll();
		}

	}

	public void PerformInspection_OpenConfirmationPopupOnExitButton() {

		clickOn(ExitBtn);
		WebElement ConfirmationIcon1 = waitUntilVisibleWE(ConfirmationPopup);
		if ((ConfirmationIcon1.isDisplayed()) == false) {

			SoftAssert s105 = new SoftAssert();
			s105.assertEquals(false, true);
			s105.assertAll();
		}

	}

	public void PerformInspection_CloseConfirmationPopupForExitButto() {

		try {
			waitUntilElementIsVisible(CancelConfirmation);
			waitForElementIsInteractable(CancelConfirmation);
			clickOn(CancelConfirmation);
			waitUntilElementInvisibleLocated(CancelConfirmation);
			List<WebElement> ConfirmaValid = driver.findElements(ConfirmationPopup);
			if (((ConfirmaValid.size()) < 1) == false) {

				SoftAssert s106 = new SoftAssert();
				s106.assertEquals(false, true);
				s106.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			SoftAssert s106 = new SoftAssert();
			s106.assertEquals(false, true);
			s106.assertAll();

		}
	}

	public void PerformInspection_OpenGenerateNoticepopup() {

		waitForElementIsInteractable(GenerateNoticeBtn);
		clickOn(GenerateNoticeBtn);
		waitForElementIsInteractable(GenerateNoticePopup);
		String NoticePopup = getTextElement(GenerateNoticePopup);

		SoftAssert s107 = new SoftAssert();
		s107.assertEquals(NoticePopup, "Generate Notice");
		s107.assertAll();

	}

	public void PerformInspection_CloseGenerateNoticePopup() {

		try {
			waitUntilElementPresent(CancelNoticeBtn);
			waitForElementIsInteractable(CancelNoticeBtn);
			clickOn(CancelNoticeBtn);
			waitUntilElementInvisibleLocated(CancelNoticeBtn);
			waitUntilElementInvisibleLocated(By.xpath("//h1[contains(text(),'Generate Notice')]"));
			waitUntilElementIsVisible(By.xpath("//div[@class='perform-inspection__title']"));
			List<WebElement> modalCount = waitUntilVisibleList(By.xpath("//div[@class='perform-inspection__title']"));
			if (((modalCount.size()) <= 2) == false) {

				SoftAssert s108 = new SoftAssert();
				s108.assertEquals(false, true);
				s108.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			SoftAssert s108 = new SoftAssert();
			s108.assertEquals(false, true);
			s108.assertAll();

		}
	}

	public void PerformInspection_AddTextToTextBox() {

		try {
			waitForElementIsInteractable(GenerateNoticeBtn);
			clickOn(GenerateNoticeBtn);
			implicitWaitforCustometime(1);
			WebElement switchFrame = waitUntilVisibleWE(IframeHTML);
			implicitWaitforCustometime(2);
			driver.switchTo().frame(switchFrame);
			WebElement noticeText = waitUntilVisibleWE(NoticeContent);
			noticeText.clear();
			noticeText.sendKeys("New HTML Notice");
			waitForCurserRunning(5);
			waitUntilElementIsVisible(NoticeContent);
			String newNoticeText = getTextElement(NoticeContent);

			SoftAssert s109 = new SoftAssert();
			s109.assertEquals(newNoticeText, "New HTML Notice");
			s109.assertAll();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_VerifyPrintToggleButtonState() {

		driver.switchTo().defaultContent();
		WebElement printStatus = waitUntilVisibleWE(PrintBtn);
		if ((printStatus.isEnabled()) == false) {

			SoftAssert s110 = new SoftAssert();
			s110.assertEquals(false, true);
			s110.assertAll();
		}

	}

	public void PerformInspection_SelectAnyToggleButton() {

		clickOn(DoNotPrintBtn);
		WebElement DontPrint = waitUntilVisibleWE(DoNotPrintBtn);
		if ((DontPrint.isEnabled()) == false) {

			SoftAssert s111 = new SoftAssert();
			s111.assertEquals(false, true);
			s111.assertAll();
		}

	}

	public void PerformInspection_OpenConfirmationPopupForCompleteInspection() {

		clickOn(IssueNoticeCIBtn);
		WebElement ConfirmationIcon2 = waitUntilVisibleWE(ConfirmationPopup);
		if ((ConfirmationIcon2.isDisplayed()) == false) {

			SoftAssert s112 = new SoftAssert();
			s112.assertEquals(false, true);
			s112.assertAll();
		}

	}

	public void PerformInspection_CloseConfirmationPopupOnCancel() {

		try {
			waitForElementIsInteractable(CancelConfirmation);
			clickOn(CancelConfirmation);
			waitUntilElementInvisibleLocated(ConfirmationPopup);
			List<WebElement> ConfirmaValid = driver.findElements(ConfirmationPopup);
			if (((ConfirmaValid.size()) < 1) == false) {

				SoftAssert s113 = new SoftAssert();
				s113.assertEquals(false, true);
				s113.assertAll();
			}
		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public void PerformInspection_VerifyTheNoticeIssued() throws InterruptedException {

		waitForElementIsInteractable(IssueNoticeCIBtn);
		clickOn(IssueNoticeCIBtn);
		waitForElementIsInteractable(YesConfirmation);
		clickByJsExecuter(YesConfirmation);
		waitForCurserRunning(5);

		By cancelBtn = By.xpath("//button[text()='Cancel']");

		if (findElementsSize(cancelBtn)>0)
			clickByJsExecuter(cancelBtn);
		else {

			waitUntilElementIsVisible(ScheduleInspectionBtn);
			waitForElementIsInteractable(ScheduleInspectionBtn);
			List<WebElement> ScheduleIns = driver.findElements(ScheduleInspectionBtn);
			if ((ScheduleIns.size() >= 1) == true) {
				clickOn(ScheduleInspectionBtn);
				waitForElementIsInteractable(After7daysDateLink);
				clickOn(After7daysDateLink);
				waitForElementIsInteractable(ScheduleInspectionPopupBtn);
				clickOn(ScheduleInspectionPopupBtn);

			}

			waitForCurserRunning(6);
			waitUntilElementIsVisible(FollowUpInspectionSection);
			String FollowUP = getTextElement(FollowUpInspectionSection);

			String ExpectedTitle = "Follow-up Inspection 1";

			SoftAssert s114 = new SoftAssert();
			s114.assertEquals(FollowUP, ExpectedTitle);
			s114.assertAll();
		}

	}

	public void FollowUpInspection_VerifyFollowUpInspectionSubSection() {

		
			implicitWaitforCustometime(2);
			WebElement FollowUpIns = waitUntilVisibleWE(FollowUpInspectionSection);
			if ((FollowUpIns.isDisplayed()) == false) {

				SoftAssert s115 = new SoftAssert();
				s115.assertEquals(false, true);
				s115.assertAll();
			}
		} 
	

	public void FollowUpInspection_OpenEditFollowUpInspectionPopup() {

		try {
			waitForElementIsInteractable(EditFollowUpIcon);
			clickByJsExecuter(EditFollowUpIcon);
			waitUntilElementIsVisible(EditFollowUpPopup);
			String EditFollowUpTitle = getTextElement(EditFollowUpPopup);

			SoftAssert s116 = new SoftAssert();
			s116.assertEquals(EditFollowUpTitle, "Edit Follow-up Inspection 1");
			s116.assertAll();
		} catch (WebDriverException e) {
			e.printStackTrace();
			SoftAssert s116 = new SoftAssert();
			s116.assertEquals(Boolean.TRUE, Boolean.FALSE);
			s116.assertAll();

		}
	}

	public void FollowUpInspection_VerifyEditedDetails() {

		try {
			waitForElementIsInteractable(After7daysDateLink);
			clickOn(After7daysDateLink);
			clickOn(UpdateButton);
		} catch (WebDriverException e) {
			e.printStackTrace();
			SoftAssert s118 = new SoftAssert();
			s118.assertEquals(Boolean.TRUE, Boolean.FALSE);
			s118.assertAll();

		}
	}

	public void FollowUpInspection_OpenFollowUpInspectionInProgressPopup() throws InterruptedException {

		waitForCurserRunning(8);
		waitUntilElementIsVisible(PerformInsButton);
		waitForElementIsInteractable(PerformInsButton);
		clickByJsExecuter(PerformInsButton);
		waitForElementIsInteractable(TitlePIPage);
		String[] Title = getTextElement(TitlePIPage).split(" in ");
		String TitleValid = Title[0];
		String ExpectedTitle = "Follow-up Inspection 1";

		SoftAssert s118 = new SoftAssert();
		s118.assertEquals(TitleValid, ExpectedTitle);
		s118.assertAll();

	}

	public void FollowUpInspection_VerifyInspectViolationsHeadersection1() {

		try {
			waitForCurserRunning(6);
			waitUntilElementIsVisible(InspectVioSection);
			String InspectVioHeader = getTextElement(InspectVioSection);
			String ExpectedHeader = "Inspect Violations";

			SoftAssert s119 = new SoftAssert();
			s119.assertEquals(InspectVioHeader, ExpectedHeader);
			s119.assertAll();

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void FollowUpInspection_PerformFollowUpInspection() {

		try {
			waitForElementIsInteractable(ContinueBtnFollowUp);
			clickOn(ContinueBtnFollowUp);
			waitForElementIsInteractable(
					By.xpath("//div[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]"));

			int htmlSizebtn = driver
					.findElements(By.xpath("//div[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]"))
					.size();

			if (htmlSizebtn > 0) {
				clickByJsExecuter(By.xpath("//div[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]"));
			} 
			else {
				Thread.sleep(3000);
				movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

				Thread.sleep(3000);
				scrollIntoViewWebElement(driver.findElement(By.xpath("//*[starts-with(text(),'HTML')]")));
				movetoElementAndClick(driver.findElement(By.xpath("//*[starts-with(text(),'HTML')]")));
			}
			

			waitForElementIsInteractable(ContinueBtnFollowUp2);
			clickOn(ContinueBtnFollowUp2);

			waitForElementIsInteractable(GenerateNoticeBtn);
			clickOn(GenerateNoticeBtn);

			waitForElementIsInteractable(DoNotPrintBtn);
			clickOn(DoNotPrintBtn);
			clickOn(IssueNoticeCIBtn);

			waitUntilElementIsVisible(YesConfirmation);
			waitForElementIsInteractable(YesConfirmation);
			clickOn(YesConfirmation);

			waitForCurserRunning(10);
			waitUntilElementIsVisible(FollowUpInspectionSection);
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
			WebElement FollowUp2Title = waitUntilVisibleWE(FollowUpInspectionSection);
			if ((FollowUp2Title.isDisplayed()) == false) {

				SoftAssert s120 = new SoftAssert();
				s120.assertEquals(false, true);
				s120.assertAll();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void FollowUpInspection_VerifyFollowUpInspection2Title() {

		try {

			waitUntilElementIsVisible(FollowUpInspectionSection);
			waitUntilElementPresent(FollowUpInspectionSection);
			String FollowUp2 = getTextElement(FollowUpInspectionSection);
			String ExpectedTitle = "Follow-up Inspection 2";

			SoftAssert s121 = new SoftAssert();
			s121.assertEquals(FollowUp2, ExpectedTitle);
			s121.assertAll();
		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public void CDP_PerformInspection_AddedNoteVerification() {

		try {
			String PINote = InspectionNote;

			waitForElementIsInteractable(ArrowForPINote);
			clickOn(ArrowForPINote);
			String PINoteCDP = getTextElement(InspectionNoteCDP);
			Assert.assertEquals(PINote, PINoteCDP);
		} catch (WebDriverException e) {
			e.printStackTrace();

		}
	}

	public void CDP_VerifyOpenAddCaseNotePopup() {

		waitUntilElementIsVisible(CaseNotesIcon);
		waitForElementIsInteractable(CaseNotesIcon);
		clickByJsExecuter(CaseNotesIcon);

		implicitWaitforCustometime(2);
		waitUntilElementIsVisible(CaseNotePopupValidate);
		String PopupOpens = getTextElement(CaseNotePopupValidate);
		Assert.assertEquals(PopupOpens, "Add Internal Comment");

	}

	public void CDP_VerifyPopopClosesOnclickingCancel() {
		try {
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(4));
			waitUntilElementIsVisible(NoticePopupCancel);
			waitUntilElementPresent(NoticePopupCancel);
			waitForElementIsInteractable(NoticePopupCancel);
			clickByJsExecuter(NoticePopupCancel);
			waitUntilElementInvisibleLocated(NoticePopupCancel);
			waitForCurserRunning(3);
			List<WebElement> NotesPopup = driver.findElements(CaseNotePopupValidate);
			if (NotesPopup.size() != 0) {
				Assert.assertEquals(false, true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void CDP_ValidationMessageForAddCaseNoteField() {
		try {

			waitForCurserRunning(3);
			waitForElementIsInteractable(CaseNotesIcon);
			clickOn(CaseNotesIcon);

			waitForElementIsInteractable(CreateNoteButton);
			clickOn(CreateNoteButton);

			waitForCurserRunning(3);
			waitUntilElementIsVisible(ValidationMessage);
			String ValMsg5000 = getTextByJSExecutor(ValidationMessage);
			Assert.assertEquals(ValMsg5000, "The Internal comment is required.");
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void CDP_validationMsgForMoreThan5000Characters() throws InterruptedException {

		String char2500 = "Lorem pom ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa..";
		forcedWaitTime(5);
		waitUntilElementIsVisible(NoticePopupCancel);
		waitUntilElementPresent(NoticePopupCancel);
		waitForElementIsInteractable(NoticePopupCancel);
		clickByJsExecuter(NoticePopupCancel);
		waitUntilElementInvisibleLocated(NoticePopupCancel);
		clickOn(CaseNotesIcon);
		waitForElementIsInteractable(NoteTextArea);
		sendKeysWithWait(NoteTextArea, char2500);
		sendKeysWithWait(NoteTextArea, char2500);
		waitForElementIsInteractable(CreateNoteButton);
		clickByJsExecuter(CreateNoteButton);
		moveToWebElementAndClick(CreateNoteButton);
		waitUntilElementIsVisible(Notes5000valMsg);
		String ValMsg5000 = getTextByJSExecutor(Notes5000valMsg);
		Assert.assertEquals(ValMsg5000, "5000 character limit.");

	}

	public void CDP_VerifyCaseNoteGetsAdded() throws Exception {

		waitForElementIsInteractable(NoteTextArea);
		WebElement AddNoteField = waitUntilVisibleWE(NoteTextArea);

		AddNoteField.clear();
		String RandomNote = RandomStrings.requiredString(50);

		waitForElementIsInteractable(NoteTextArea);
		sendKeysWithWait(NoteTextArea, RandomNote);
		clickOn(CreateNoteButton);
		waitForCurserRunning(4);
		String[] NotesTitle = getTextElement(CreatedNotesTitle).split(" ");
		Assert.assertEquals(NotesTitle[0], "Internal");

	}

	public void addViolationOnVeriftViolation1_Animal() throws InterruptedException {
		waitForElementIsInteractable(AddVioPI);
		sendKeysWithWait(AddVioPI, "Animal");
		clickByJsExecuter(selectViolAnimalFromDropdown);

		Thread.sleep(2000);
		By animalNumber = By.xpath("//*[text()='Age']/../.. //input");
		waitForElementIsInteractable(animalNumber);
		sendKeysWithWait(animalNumber, "2");
		clickOn(addBtn_For_EntitiyViolation);

	}

}
