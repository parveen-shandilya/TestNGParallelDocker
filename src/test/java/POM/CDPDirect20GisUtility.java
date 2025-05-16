package POM;

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

public class CDPDirect20GisUtility extends Helper {

	public WebDriver driver;
	CECommonMethods ceCommonMethod;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;

	public CDPDirect20GisUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethod = new CECommonMethods(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
	}


	public static String performInsButton = "//button[text()='Perform Inspection']";
	public static String continueBtn = "//div[@class='footer_actions']/button[2]";
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
	public static String selectANotice = "(//div[@class='multi-choice-buttons'])[5]/button";
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
	public static String addContactsPIP = "(//input[@class='react-autosuggest__input'])[2]";
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
	public static String caseNotePopupValidate = "//div[text()='Add Case Note']";
	public static String noticePopupCancel = "//button[text()='Cancel']";
	public static String validationMessage = "//label[@title='Add Case Note']/../../span";
	public static String noteTextArea = "//textarea[@name='caseNote']";
	public static String notes5000valMsg = "//span[text()='5000 character limit.']";
	public static String createNoteButton = "//button[text()='Create Note']";
	public static String createdNotesTitle = "//div[@id='case-notes']//h2/span";
	public static String newNoticeToggle = "//button[text()='New Notice']";
	public static String editsaveAddress = "//div[@class='tile-header']//button[text()='Save']";
	public static String editGISvalidateBtnCDP = "//div[@class='tile-header']//button[text()='GIS Validated']";
	public static String validateAddressbtnCDP = "//div[@class='tile-header']//button[contains(text(),'Validate Address')]";

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

	public static String editLocation_btn = "//div[@class='location-tile__header__actions']//button[@class='edit-btn  btn btn-primary']";

	public static String apn_text = "//input[@name='apn']";
	public static String streetAddresstxt = "//input[@name='streetAddress']";
	public static String secUnittxt = "//input[@name='secUnitNum']";
	public static String cityNametxt = "//input[@name='city']";
	public static String zipNotxt = "//input[@name='zip']";
	public static String apnNotxt = "//input[@name='apn']";
	public static By Apn_Text = By.xpath(apn_text);

	public static By EditLocation_btn = By.xpath(editLocation_btn);
	public static By StreetAddresstxt = By.xpath(streetAddresstxt);
	public static By SecUnittxt = By.xpath(secUnittxt);
	public static By CityNametxt = By.xpath(cityNametxt);
	public static By ZipNotxt = By.xpath(zipNotxt);
	public static By ApnNotxt = By.xpath(apnNotxt);
	public static By EditsaveAddress = By.xpath(editsaveAddress);
	public static By EditGISvalidateBtnCDP = By.xpath(editGISvalidateBtnCDP);
	public static By ValidateAddressbtnCDP = By.xpath(validateAddressbtnCDP);
	public static By PerformInsButton = By.xpath(PerformInspectionUtility.performInsButton);
	public static By ContinueBtn = By.xpath(PerformInspectionUtility.continueBtn);
	public static By GlobalValidMsg = By.xpath(PerformInspectionUtility.globalValidMsg);
	public static By TitlePIPage = By.xpath(PerformInspectionUtility.titlePIPage);
	public static By AddVioPI = By.xpath(PerformInspectionUtility.addVioPI);
	public static By SelectVioList = By.xpath(PerformInspectionUtility.selectVioList);
	public static By InvalidBtnList = By.xpath(PerformInspectionUtility.invalidBtnList);
	public static By NoteField = By.xpath(PerformInspectionUtility.noteField);
	public static By FooterButtons = By.xpath(PerformInspectionUtility.footerButtons);
	public static By AddImgIcon = By.xpath(PerformInspectionUtility.addImgIcon);
	public static By BrowseFileLink = By.xpath(PerformInspectionUtility.browseFileLink);
	public static By AddBtnAttach = By.xpath(PerformInspectionUtility.addBtnAttach);
	public static By CaseVioList = By.xpath(PerformInspectionUtility.caseVioList);
	public static By ConfirmationPopup = By.xpath(PerformInspectionUtility.confirmationPopup);
	public static By CancelConfirmation = By.xpath(PerformInspectionUtility.cancelConfirmation);
	public static By CloseCasePopup = By.xpath(PerformInspectionUtility.closeCasePopup);
	public static By ModalHeaderPI = By.xpath(PerformInspectionUtility.modalHeaderPI);
	public static By ValidBtnList = By.xpath(PerformInspectionUtility.validBtnList);
	public static By VoluntaryToggle = By.xpath(PerformInspectionUtility.voluntaryToggle);
	public static By CancelCloseCase = By.xpath(PerformInspectionUtility.cancelCloseCase);
	public static By IssueNoticeBtn = By.xpath(PerformInspectionUtility.issueNoticeBtn);
	public static By EditVerifyVio = By.xpath(PerformInspectionUtility.editVerifyVio);
	public static By EditVioIcon = By.xpath(PerformInspectionUtility.editVioIcon);
	public static By EditVioPopup = By.xpath(PerformInspectionUtility.editVioPopup);
	public static By LabelVioStatus1 = By.xpath(PerformInspectionUtility.labelVioStatus1);
	public static By NoNoticeToggleButton = By.xpath(PerformInspectionUtility.noNoticeToggleButton);
	public static By NoticeIssueDate = By.xpath(PerformInspectionUtility.noticeIssueDate);
	public static By CancelEditAnimal = By.xpath(PerformInspectionUtility.cancelEditAnimal);
	public static By VioVerificationStatus = By.xpath(PerformInspectionUtility.vioVerificationStatus);
	public static By TitleSection2 = By.xpath(PerformInspectionUtility.titleSection2);
	public static By ForcedToggle = By.xpath(PerformInspectionUtility.forcedToggle);
	public static By ClosedInvalidStatus = By.xpath(PerformInspectionUtility.closedInvalidStatus);
	public static By OpenCompliantStatus = By.xpath(PerformInspectionUtility.openCompliantStatus);
	public static By NoticeSelected = By.xpath(PerformInspectionUtility.noticeSelected);
	public static By NoticeSelected2 = By.xpath(PerformInspectionUtility.noticeSelected2);
	public static By SelectANotice = By.xpath(PerformInspectionUtility.selectANotice);
	public static By Notice2 = By.xpath(PerformInspectionUtility.notice2);
	public static By TitleSection3 = By.xpath(PerformInspectionUtility.titleSection3);
	public static By NoticeDatePicker = By.xpath(PerformInspectionUtility.noticeDatePicker);
	public static By IssueNoticeButton = By.xpath(PerformInspectionUtility.issueNoticeButton);
	public static By ContinueBtnSec2 = By.xpath(PerformInspectionUtility.continueBtnSec2);
	public static By VioListSec2 = By.xpath(PerformInspectionUtility.vioListSec2);
	public static By ComplyByDateFld = By.xpath(PerformInspectionUtility.complyByDateFld);
	public static By ComplyByDatePicker = By.xpath(PerformInspectionUtility.complyByDatePicker);
	public static By InspectionDateFld = By.xpath(PerformInspectionUtility.inspectionDateFld);
	public static By InspectionDatePicker = By.xpath(PerformInspectionUtility.inspectionDatePicker);
	public static By AgencyAdmin = By.xpath(PerformInspectionUtility.agencyAdmin);
	public static By InspectionAssingee = By.xpath(PerformInspectionUtility.inspectionAssingee);
	public static By CertifiedMail = By.xpath(PerformInspectionUtility.certifiedMail);
	public static By CertifiedMailFld = By.xpath(PerformInspectionUtility.certifiedMailFld);
	public static By RecipientTile = By.xpath(PerformInspectionUtility.recipientTile);
	public static By RecipientContacts = By.xpath(PerformInspectionUtility.recipientContacts);
	public static By GenerateNoticeBtn = By.xpath(PerformInspectionUtility.generateNoticeBtn);
	public static By ErrorMsgSec3 = By.xpath(PerformInspectionUtility.errorMsgSec3);
	public static By ResponsiblePartyTile = By.xpath(PerformInspectionUtility.responsiblePartyTile);
	public static By ExitBtn = By.xpath(PerformInspectionUtility.exitBtn);
	public static By GenerateNoticePopup = By.xpath(PerformInspectionUtility.generateNoticePopup);
	public static By CancelNoticeBtn = By.xpath(PerformInspectionUtility.cancelNoticeBtn);
	public static By NoticeContent = By.xpath(PerformInspectionUtility.noticeContent);
	public static By PrintBtn = By.xpath(PerformInspectionUtility.printBtn);
	public static By DoNotPrintBtn = By.xpath(PerformInspectionUtility.doNotPrintBtn);
	public static By IssueNoticeCIBtn = By.xpath(PerformInspectionUtility.issueNoticeCIBtn);
	public static By YesConfirmation = By.xpath(PerformInspectionUtility.yesConfirmation);
	public static By TotalContacts = By.xpath(PerformInspectionUtility.totalContacts);
	public static By IframeHTML = By.id(PerformInspectionUtility.iframeHTML);
	public static By CLP = By.xpath(PerformInspectionUtility.cLP);
	public static By CDP = By.xpath(PerformInspectionUtility.cDP);
	public static By AddContactsPIP = By.xpath(PerformInspectionUtility.addContactsPIP);
	public static By CrtContactLink2 = By.xpath(PerformInspectionUtility.crtContactLink2);
	public static By NameFieldPIP = By.xpath(PerformInspectionUtility.nameFieldPIP);
	public static By CrtContactBtn = By.xpath(PerformInspectionUtility.crtContactBtn);
	public static By FollowUpInspectionSection = By.xpath(PerformInspectionUtility.followUpInspectionSection);
	public static By EditFollowUpIcon = By.xpath(PerformInspectionUtility.editFollowUpIcon);
	public static By EditFollowUpPopup = By.xpath(PerformInspectionUtility.editFollowUpPopup);
	public static By After7daysDateLink = By.xpath(PerformInspectionUtility.after7daysDateLink);
	public static By UpdateButton = By.xpath(PerformInspectionUtility.updateButton);
	public static By ScheduleInspectionBtn = By.xpath(PerformInspectionUtility.scheduleInspectionBtn);
	public static By ScheduleInspectionPopupBtn = By.xpath(PerformInspectionUtility.scheduleInspectionPopupBtn);
	public static By ContinueBtnFollowUp = By.xpath(PerformInspectionUtility.continueBtnFollowUp);
	public static By ContinueBtnFollowUp2 = By.xpath(PerformInspectionUtility.continueBtnFollowUp2);
	public static By InspectVioSection = By.xpath(PerformInspectionUtility.inspectVioSection);
	public static By ArrowForPINote = By.xpath(PerformInspectionUtility.arrowForPINote);
	public static By InspectionNoteCDP = By.xpath(PerformInspectionUtility.inspectionNoteCDP);
	public static By CaseNotesIcon = By.xpath(PerformInspectionUtility.caseNotesIcon);
	public static By CaseNotePopupValidate = By.xpath(PerformInspectionUtility.caseNotePopupValidate);
	public static By NoticePopupCancel = By.xpath(PerformInspectionUtility.noticePopupCancel);
	public static By ValidationMessage = By.xpath(PerformInspectionUtility.validationMessage);
	public static By NoteTextArea = By.xpath(PerformInspectionUtility.noteTextArea);
	public static By Notes5000valMsg = By.xpath(PerformInspectionUtility.notes5000valMsg);
	public static By CreateNoteButton = By.xpath(PerformInspectionUtility.createNoteButton);
	public static By CreatedNotesTitle = By.xpath(PerformInspectionUtility.createdNotesTitle);
	public static By NewNoticeToggle = By.xpath(PerformInspectionUtility.newNoticeToggle);

	static String InspectionNote = RandomStrings.requiredString(15);
	public static String streetAddreassBefore;
	public static String streetCityBefore;
	public static String streetZipBefore;
	public static String streetAPNBefore;
	public static String streetAddreassafter;
	public static String streetCityafter;
	public static String streetZipafter;
	public static String streetAPNafter;
	public static Boolean GISsectionstatus;
	public static Boolean APNsectionstatus;
	public static Boolean ComcateApplicationsectionstaus;
	public static boolean gisValidationButton;
	public static boolean validateAddressBtn;

	public static String ValidateStreetAdd;
	public static String validatestate;
	public static String validateCity;
	public static String validateZip;
	public static String validateApn;
	public static String validateOwnerName;
	public static String validateOwnerAddress;
	public static By addAddressManuallyPopup = By.xpath("//h2[text()='Add Address Manually']");
	public static By addAddressBttn = By.xpath("//button[text()='Add Address']");


	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void EditLocationonSearchLocationCDP() throws InterruptedException {

		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o))
		{
			waitUntilElementIsVisible(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
		crmCommonMethod.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
		GISsectionstatus = findElement(CCPDirect20Utility.GisDataAddressSection).isDisplayed();
		APNsectionstatus = findElement(CCPDirect20Utility.APNAddressSection).isDisplayed();
		ComcateApplicationsectionstaus = findElement(CCPDirect20Utility.ComcateApplicationSection)
				.isDisplayed();
		forcedWaitTime(4);
		waitUntilElementIsVisible(CCPDirect20Utility.GisDataAddress);
		waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
		clickOn(CCPDirect20Utility.GisDataAddress);
		waitForCurserRunning(3);
		
		handleReviewContactWhileUpdatingAddress();
		
		
		waitUntilElementIsVisible(EditsaveAddress);
		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickOn(EditsaveAddress);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		ValidateStreetAdd = getTextElement(CCPDirect20Utility.StreetLabel);
		
		
		waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
		validatestate = getTextElement(CCPDirect20Utility.stateLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
		validateCity = getTextElement(CCPDirect20Utility.CityLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
		validateZip = getTextElement(CCPDirect20Utility.ZipLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
		validateApn = getTextElement(CCPDirect20Utility.apnLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
		validateOwnerName = getTextElement(CCPDirect20Utility.OwnerName);
		waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
		validateOwnerAddress = getTextElement(CCPDirect20Utility.OwnerAddress);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(GISsectionstatus, Boolean.TRUE);
		sft.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
		sft.assertEquals(APNsectionstatus, Boolean.TRUE);
		sft.assertEquals(gisValidationButton, true);
		sft.assertEquals((ValidateStreetAdd).isEmpty(), false);
		sft.assertEquals(validatestate.isEmpty(), false);
		sft.assertEquals((validateCity).isEmpty(), false);
		sft.assertEquals(validateZip.isEmpty(), false);
		sft.assertEquals(validateApn.isEmpty(), false);
		sft.assertEquals((validateOwnerName).isEmpty(), false);
		sft.assertEquals(validateOwnerAddress.isEmpty(), false);
		sft.assertAll();
		}
		else
		{
			
			waitUntilElementIsVisible(EditLocation_btn);
			waitForElementIsInteractable(EditLocation_btn);
			clickByJsExecuter(EditLocation_btn);
			waitUntilElementIsVisible(SearchLocation_text);
			waitForElementIsInteractable(SearchLocation_text);
			crmCommonMethod.serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20"));
			GISsectionstatus = findElement(CCPDirect20Utility.GisDataAddressSection).isDisplayed();
			APNsectionstatus = findElement(CCPDirect20Utility.APNAddressSection).isDisplayed();
			ComcateApplicationsectionstaus = findElement(CCPDirect20Utility.ComcateApplicationSection)
					.isDisplayed();
			forcedWaitTime(4);
			waitUntilElementIsVisible(CCPDirect20Utility.GisDataAddress);
			waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
			clickOn(CCPDirect20Utility.GisDataAddress);
			waitForCurserRunning(3);
			waitUntilElementIsVisible(EditsaveAddress);
			forcedWaitTime(4);
			waitForElementIsInteractable(EditsaveAddress);
			clickOn(EditsaveAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditGISvalidateBtnCDP);
			gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
			ValidateStreetAdd = getTextElement(CCPDirect20Utility.StreetLabel);
			
			
			waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
			validatestate = getTextElement(CCPDirect20Utility.stateLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
			validateCity = getTextElement(CCPDirect20Utility.CityLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
			validateZip = getTextElement(CCPDirect20Utility.ZipLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
			validateApn = getTextElement(CCPDirect20Utility.apnLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
			validateOwnerName = getTextElement(CCPDirect20Utility.OwnerName);
			waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
			validateOwnerAddress = getTextElement(CCPDirect20Utility.OwnerAddress);
			SoftAssert sft = new SoftAssert();
			sft.assertEquals(GISsectionstatus, Boolean.TRUE);
			sft.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
			sft.assertEquals(APNsectionstatus, Boolean.TRUE);
			sft.assertEquals(gisValidationButton, true);
			sft.assertEquals((ValidateStreetAdd).isEmpty(), false);
			sft.assertEquals(validatestate.isEmpty(), false);
			sft.assertEquals((validateCity).isEmpty(), false);
			sft.assertEquals(validateZip.isEmpty(), false);
			sft.assertEquals(validateApn.isEmpty(), false);
			sft.assertEquals((validateOwnerName).isEmpty(), false);
			sft.assertEquals(validateOwnerAddress.isEmpty(), false);
			sft.assertAll();
			
			
		}
		

	}

	public static By noOfGisAddressDisplayed=By.xpath("//label[text()='GIS Validated Addresses']//parent::div//following-sibling::ul//li//div[@class='list-label']");
	
	public void EditLocationonPinCDP() throws InterruptedException {

		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o))
		{
			refreshPage();
			waitForCurserRunning(3);
		waitUntilElementIsVisible(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
//		ceCommonMethod.CCPGisDirectPinLocation();


		WebElement element = findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
		Point offset = element.getLocation();
		int xoffset = offset.getX();
		int yoffset = offset.getY();
			System.out.println("xoff" + xoffset);
			System.out.println("yoff" + yoffset);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(" + yoffset + "," + xoffset + ");");
			System.out.println("xoff after" + xoffset);
			System.out.println("yoff after" + yoffset);
			try {
		element.click();
		}
		catch(Exception e)
		{
			element.click();

		}

		GISsectionstatus = findElement(CCPDirect20Utility.GisDataAddressSection).isDisplayed();
		APNsectionstatus = findElement(CCPDirect20Utility.APNAddressSection).isDisplayed();
		ComcateApplicationsectionstaus = findElement(CCPDirect20Utility.ComcateApplicationSection)
				.isDisplayed();
		forcedWaitTime(4);
		waitUntilElementIsVisible(CCPDirect20Utility.GisDataAddress);
		waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
		clickOn(CCPDirect20Utility.GisDataAddress);
			waitUntilElementIsVisible(addAddressManuallyPopup);
			if(findElementsSize(addAddressManuallyPopup)>0){
				waitUntilElementIsVisible(addAddressBttn);
				waitForElementIsInteractable(addAddressBttn);
				clickOn(addAddressBttn);
			}

		waitForCurserRunning(3);
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = findElementsSize(EditGISvalidateBtnCDP)>0;
		ValidateStreetAdd = getTextElement(CCPDirect20Utility.StreetLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
		validatestate = getTextElement(CCPDirect20Utility.stateLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
		validateCity = getTextElement(CCPDirect20Utility.CityLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
		validateZip = getTextElement(CCPDirect20Utility.ZipLabel);
		
		if(driver.findElements(By.xpath("(//button[text()='Cancel'])[2]")).size()>0)
		clickByJsExecuter(By.xpath("(//button[text()='Cancel'])[2]"));
		
		waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
		validateApn = getTextElement(CCPDirect20Utility.apnLabel);
		waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
		validateOwnerName = getTextElement(CCPDirect20Utility.OwnerName);
		waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
		validateOwnerAddress = getTextElement(CCPDirect20Utility.OwnerAddress);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(GISsectionstatus, Boolean.TRUE);
		sft.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
		sft.assertEquals(APNsectionstatus, Boolean.TRUE);
		sft.assertEquals(gisValidationButton, true);
		sft.assertEquals((ValidateStreetAdd).isEmpty(), false);
		sft.assertEquals(validatestate.isEmpty(), false);
		sft.assertEquals((validateCity).isEmpty(), false);
		sft.assertEquals(validateZip.isEmpty(), false);
		sft.assertEquals(validateApn.isEmpty(), false);
		sft.assertEquals((validateOwnerName).isEmpty(), false);
		sft.assertEquals(validateOwnerAddress.isEmpty(), false);
		sft.assertAll();
		}
		
		else
		{
			waitUntilElementIsVisible(EditLocation_btn);
			waitForElementIsInteractable(EditLocation_btn);
			clickByJsExecuter(EditLocation_btn);
			waitUntilElementIsVisible(SearchLocation_text);
			waitForElementIsInteractable(SearchLocation_text);
			//ceCommonMethod.CCPGisDirectPinLocation();
			WebElement element = findElement(By.xpath("(//div[@class='map-container']//div)[1]"));

			  Point offset = element.getLocation();
	          int xoffset = offset.getX();
	          int yoffset = offset.getY();

	          xoffset= -20;
	          yoffset= -20;

	          Actions actions =  new Actions(driver);
	          Thread.sleep(3000);
	          actions.moveToElement(element,xoffset,yoffset).click().perform();

			GISsectionstatus = findElement(CCPDirect20Utility.GisDataAddressSection).isDisplayed();
			APNsectionstatus = findElement(CCPDirect20Utility.APNAddressSection).isDisplayed();
			ComcateApplicationsectionstaus = findElement(CCPDirect20Utility.ComcateApplicationSection)
					.isDisplayed();
			forcedWaitTime(4);
			waitUntilElementIsVisible(CCPDirect20Utility.GisDataAddress);
			waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
			clickOn(CCPDirect20Utility.GisDataAddress);
			waitForCurserRunning(3);
			waitUntilElementIsVisible(EditsaveAddress);
			forcedWaitTime(4);
			waitForElementIsInteractable(EditsaveAddress);
			clickByJsExecuter(EditsaveAddress);
			waitUntilElementIsVisible(EditsaveAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditGISvalidateBtnCDP);
			gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
			ValidateStreetAdd = getTextElement(CCPDirect20Utility.StreetLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
			validatestate = getTextElement(CCPDirect20Utility.stateLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
			validateCity = getTextElement(CCPDirect20Utility.CityLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
			validateZip = getTextElement(CCPDirect20Utility.ZipLabel);
			
			if(driver.findElements(By.xpath("(//button[text()='Cancel'])[2]")).size()>0)
			clickByJsExecuter(By.xpath("(//button[text()='Cancel'])[2]"));
			
			waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
			validateApn = getTextElement(CCPDirect20Utility.apnLabel);
			waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
			validateOwnerName = getTextElement(CCPDirect20Utility.OwnerName);
			waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
			validateOwnerAddress = getTextElement(CCPDirect20Utility.OwnerAddress);
			SoftAssert sft = new SoftAssert();
			sft.assertEquals(GISsectionstatus, Boolean.TRUE);
			sft.assertEquals(ComcateApplicationsectionstaus, Boolean.TRUE);
			sft.assertEquals(APNsectionstatus, Boolean.TRUE);
			sft.assertEquals(gisValidationButton, true);
			sft.assertEquals((ValidateStreetAdd).isEmpty(), false);
			sft.assertEquals(validatestate.isEmpty(), false);
			sft.assertEquals((validateCity).isEmpty(), false);
			sft.assertEquals(validateZip.isEmpty(), false);
			sft.assertEquals(validateApn.isEmpty(), false);
			sft.assertEquals((validateOwnerName).isEmpty(), false);
			sft.assertEquals(validateOwnerAddress.isEmpty(), false);
			sft.assertAll();

			
			
		}

	}

	public void EditLocationonPinGISValidatedButtonAppearCDP() throws InterruptedException {

		refreshPage();
		waitForCurserRunning(4);
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitUntilElementPresent(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
		ceCommonMethod.CCPGisDirectPinLocation();
		waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);
		scrollIntoView(CCPDirect20Utility.ApnAddrresses);
		waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
		clickOn(CCPDirect20Utility.ApnAddrresses);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(EditsaveAddress);
		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickByJsExecuter(EditsaveAddress);
		handleReviewContact();
		waitUntilElementIsVisible(EditsaveAddress);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertAll();

	}

	public void EditLocationonSearchAPNGISValidatedButtonAppearCDP() throws InterruptedException {

		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o))
		{
		refreshPage();
		waitForCurserRunning(4);
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
		waitForElementIsInteractable(CCPUtility.LocationFld);
		clickOn(CCPUtility.LocationFld);
		clearByJSE(CCPUtility.LocationFld);
		sendKeysWithWait(CCPUtility.LocationFld, "17816113033");
		waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);
		scrollIntoView(CCPDirect20Utility.ApnAddrresses);
		waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
		clickOn(CCPDirect20Utility.ApnAddrresses);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(EditsaveAddress);
		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickByJsExecuter(EditsaveAddress);
		handleReviewContactWhileUpdatingAddress();

		waitUntilElementIsVisible(EditsaveAddress);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = findElementsSize(EditGISvalidateBtnCDP)>0;
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertAll();
		}
		else
		{
			refreshPage();
			waitForCurserRunning(4);
			waitUntilElementIsVisible(EditLocation_btn);
			waitUntilElementPresent(EditLocation_btn);
			waitForElementIsInteractable(EditLocation_btn);
			clickByJsExecuter(EditLocation_btn);
			waitUntilElementIsVisible(SearchLocation_text);
			waitForElementIsInteractable(SearchLocation_text);
			waitForElementIsInteractable(CCPUtility.LocationFld);
			clickOn(CCPUtility.LocationFld);
			clearByJSE(CCPUtility.LocationFld);
			sendKeysWithWait(CCPUtility.LocationFld, "6131-0000-0020-000");
			waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);
			scrollIntoView(CCPDirect20Utility.ApnAddrresses);
			waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
			clickOn(CCPDirect20Utility.ApnAddrresses);
			waitForCurserRunning(8);
			waitUntilElementIsVisible(EditsaveAddress);
			forcedWaitTime(4);
			waitForElementIsInteractable(EditsaveAddress);
			clickByJsExecuter(EditsaveAddress);
			waitUntilElementIsVisible(EditsaveAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditGISvalidateBtnCDP);
			gisValidationButton = findElementsSize(EditGISvalidateBtnCDP)>0;
			SoftAssert sft = new SoftAssert();
			sft.assertEquals(gisValidationButton, true);
			sft.assertAll();
			
			
			
		}
	}

	public void VerifyUserAbletoValidateAddressWithGISDataAddressOnCDP() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(4);
		ceCommonMethod.SelectComcateApplicationAddressOnCDP();
		validateAddressBtn = elementIsDisplayed(ValidateAddressbtnCDP);
		waitForElementIsInteractable(ValidateAddressbtnCDP);
		clickOn(ValidateAddressbtnCDP);
		waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
		clickByJsExecuter(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(CCPUtility.LocationFld);
		ceCommonMethod.SelectGISDataAddressOnCDP();
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertEquals(validateAddressBtn, true);
		sft.assertAll();

	}

	public void VerifyUserAbletoValidateAddressWithGISAPNAddressOnCDP() throws InterruptedException {
		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o))
		{
		ceCommonMethod.SelectComcateApplicationAddressOnCDP();
		validateAddressBtn = elementIsDisplayed(ValidateAddressbtnCDP);
		waitForElementIsInteractable(ValidateAddressbtnCDP);
		clickOn(ValidateAddressbtnCDP);
		waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
		clickByJsExecuter(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(CCPUtility.LocationFld);
		clickOn(CCPUtility.LocationFld);
		clearByJSE(CCPUtility.LocationFld);
		sendKeysWithWait(CCPUtility.LocationFld, "17816113033");
		waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);
		scrollIntoView(CCPDirect20Utility.ApnAddrresses);
		waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
		clickOn(CCPDirect20Utility.ApnAddrresses);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(EditsaveAddress);
		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickOn(EditsaveAddress);
		handleReviewContactWhileUpdatingAddress();
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertAll();
		}
		else
		{
			ceCommonMethod.SelectComcateApplicationAddressOnCDP();
			validateAddressBtn = elementIsDisplayed(ValidateAddressbtnCDP);
			waitForElementIsInteractable(ValidateAddressbtnCDP);
			clickOn(ValidateAddressbtnCDP);
			waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
			waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
			clickByJsExecuter(By.xpath("//div[@class='cross']"));
			waitForElementIsInteractable(CCPUtility.LocationFld);
			clickOn(CCPUtility.LocationFld);
			clearByJSE(CCPUtility.LocationFld);
			sendKeysWithWait(CCPUtility.LocationFld, "4416-0003-0015-001");
			waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);
			scrollIntoView(CCPDirect20Utility.ApnAddrresses);
			waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
			clickOn(CCPDirect20Utility.ApnAddrresses);
			waitForCurserRunning(8);
			waitUntilElementIsVisible(EditsaveAddress);
			forcedWaitTime(4);
			waitForElementIsInteractable(EditsaveAddress);
			clickOn(EditsaveAddress);
			waitForCurserRunning(2);
			waitUntilElementIsVisible(EditLocation_btn);
			waitUntilElementPresent(EditLocation_btn);
			gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
			SoftAssert sft = new SoftAssert();
			sft.assertEquals(gisValidationButton, true);
			sft.assertAll();
			
			
		}
	}

	public void ValidatedManuallyAddedAddressOnCDP() throws InterruptedException {
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);

		waitForElementIsInteractable(StreetAddresstxt);
		clearByJSE(StreetAddresstxt);
		waitForElementIsInteractable(StreetAddresstxt);
		sendKeysWithWait(StreetAddresstxt, RandomStrings.requiredString(7));

		waitForElementIsInteractable(SecUnittxt);
		clearByJSE(SecUnittxt);
		waitForElementIsInteractable(SecUnittxt);
		sendKeysWithWait(SecUnittxt, RandomStrings.requiredString(4));

		waitForElementIsInteractable(CityNametxt);
		clearByJSE(CityNametxt);
		waitForElementIsInteractable(CityNametxt);
		sendKeysWithWait(CityNametxt, RandomStrings.requiredString(7));

		waitForElementIsInteractable(ZipNotxt);
		clearByJSE(ZipNotxt);
		waitForElementIsInteractable(ZipNotxt);
		sendKeysWithWait(ZipNotxt, RandomStrings.requiredDigits(4));

		waitForElementIsInteractable(ApnNotxt);
		clearByJSE(ApnNotxt);
		waitForElementIsInteractable(ApnNotxt);
		sendKeysWithWait(ApnNotxt, RandomStrings.requiredDigits(11));

		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickOn(EditsaveAddress);
		handleReviewContactWhileUpdatingAddress();
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);

		validateAddressBtn = elementIsDisplayed(ValidateAddressbtnCDP);
		waitForElementIsInteractable(ValidateAddressbtnCDP);
		clickOn(ValidateAddressbtnCDP);
		waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
		clickByJsExecuter(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(CCPUtility.LocationFld);
		ceCommonMethod.SelectGISDataAddressOnCDP();
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertEquals(validateAddressBtn, true);
		sft.assertAll();

	}

	public void ValidatedAddressOnWithPinLocationCDP() throws InterruptedException {

		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		waitForElementIsInteractable(EditLocation_btn);
		clickByJsExecuter(EditLocation_btn);
		waitUntilElementIsVisible(SearchLocation_text);
		waitForElementIsInteractable(SearchLocation_text);
		ceCommonMethod.CCPGisDirectPinLocation();
		forcedWaitTime(4);
		waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
		waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
		clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
		forcedWaitTime(4);
		waitForElementIsInteractable(EditsaveAddress);
		clickByJsExecuter(EditsaveAddress);
		handleReviewContactWhileUpdatingAddress();
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EditLocation_btn);
		waitUntilElementPresent(EditLocation_btn);
		validateAddressBtn = elementIsDisplayed(ValidateAddressbtnCDP);
		waitForElementIsInteractable(ValidateAddressbtnCDP);
		clickOn(ValidateAddressbtnCDP);
		waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(By.xpath("//div[@class='cross']"));
		clickByJsExecuter(By.xpath("//div[@class='cross']"));
		waitForElementIsInteractable(CCPUtility.LocationFld);
		ceCommonMethod.SelectGISDataAddressOnCDP();
		waitUntilElementIsVisible(EditGISvalidateBtnCDP);
		gisValidationButton = elementIsDisplayed(EditGISvalidateBtnCDP);
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(gisValidationButton, true);
		sft.assertEquals(validateAddressBtn, true);
		sft.assertAll();
	}

}
