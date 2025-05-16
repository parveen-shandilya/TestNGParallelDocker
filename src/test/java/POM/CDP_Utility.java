
package POM;

import static POM.CCPUtility.*;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CheckDownloadedFile;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import TestCases.CCP;
import TestCases.CLP;
import TestCases.ForcedAbatement;

/**
 * @author SQE Labs
 *
 */
public class CDP_Utility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	PerformInspectionUtility PI;
	CCPUtility ccp;
	ForcedAbatementUtility FA;
	CECommonMethods CEcommonMethod;
	CLPUtility clp;
	OnlinePaymentUtility op;
	FinesUtility fines;

	public CDP_Utility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		PI = new PerformInspectionUtility(driver);
		ccp = new CCPUtility(driver);
		FA = new ForcedAbatementUtility(driver);
		CEcommonMethod = new CECommonMethods(driver);
		clp = new CLPUtility(driver);
		op = new OnlinePaymentUtility(driver);
		fines = new FinesUtility(driver);
	}

	SoftAssert softAssert = new SoftAssert();

	public static String CaseId1;
	public static By viewDetailsOutstandingBalance = By.xpath("//*[@class='view-details']");
	public static By scheduleFollowUpInspectonChkbox = By.xpath("//*[@name='skipFollowUpInspection']");

	public static By noticeCreatedIndependentOfInspectionHeader = By
			.xpath("//*[@class='abatement-activities__draft-notice']/h4");
	public static By noticeCreatedIndependentOfInspection = By
			.xpath("//*[@class='abatement-activities__draft-notice']//div/h4");
	public static By addFineHeader = By.xpath("(//*[@class='modal-content']//*[text()='Add Fine'])[1]");
	public static By outstandingBalanceValue = By.xpath("//*[@class='field__label-data-field']/span");
	public static By addFineFooter = By.xpath("(//*[@class='modal-content']//*[text()='Add Fine'])[2]");
	public static By selectFineDropdown = By.xpath("//*[text()='Select Option']");
	public static By selectFineFromDropdownFirstValue = By.xpath("//*[@class='Select-menu']/div");
	public static By generateNoticeBtn = By.xpath("//button[text()='Generate Notice']");
	public static By generateNoticeBtnOOI = By.xpath("(//button[text()='Generate Notice'])[2]");
	public static By resolutionSectionTile = By.xpath("//*[@class='case-inspection__violation-tile ']");
	public static By resolutionActionHeader = By.xpath("//*[@class='case-inspection__violation-tile ']/h4");
	public static By resolutionActionTextArea = By.xpath("//*[@name='resolutionAction']");
	public static By certifiedMailNumberHeader = By.xpath("//*[@title='Certified Mail Number']");
	public static By certifiedMailNoTextField = By.xpath("//*[@name='certifiedMailNumber']");
	public static By selectNoticeForOOI = By.xpath("(//*[@class='multi-choice-buttons'])[2]/button");
	public static By noticeIssueDateTextbox = By
			.xpath("//*[@class='field__input row']//div[@class='rdt']//*[@name='issuedAt']");
	public static By followUpInspectionDateField = By.xpath("//*[@name='inspectionPlannedDate']");
	public static By datePickerIcon = By.xpath("(//*[@class='datepicker-image'])[1]");
	public static By continueBtn1GenerateNoticeInProgressPage = By
			.xpath("//*[@class='footer_actions']//button[text()='Continue']");
	public static By continueBtn2GenerateNoticeInProgressPage = By
			.xpath("(//*[@class='progressive-form__footer']/button)[1]");
	public static By continueBtn3GenerateNoticeInProgressPage = By
			.xpath("(//*[@class='progressive-form__footer']/button[text()='Continue'])[2]");
	public static By selectNoticesTypeAndAssociatedFinesHeader = By
			.xpath("//*[@class='progressive-form__title']/h2[starts-with(text(),'Select Notice')]");
	public static By addAnotherFineBtn = By.xpath("//a//*[@class='case-inspection__fine-add-icon']");
	public static By associatedFineLabelForHTMLMandatory = By
			.xpath("//*[contains(text(),'HTML Mandatory Notice Fine')]");
	public static By fineAddedOnGenerateNoticeInProgress = By.xpath("//*[@name='amount']");
	public static By selectDateFromDatePickerLastDay = By.xpath("(//tbody)[1]/tr/td");
	public static By followUpInspectionDateLabel = By.xpath("//*[text()='Follow-up Inspection Date']");
	public static By htmlMandatoryNotice = By.xpath("//button[contains(text(),'Mandatory')]");
	public static By closeCaseHistory = By.xpath("//button[@class='btn-close']");
	public static By reviewOpenViolationsAndComplyByDatesctionHeader = By
			.xpath("//*[text()='Review Open Violations & Comply By Dates']");
	public static By selectDateForComplyByDateField = By.xpath("(//table)[3]//tr/td");
	public static By selectDate_30 = By.xpath("//td[contains(text(),20) and @class='rdtDay']");
	public static By approveNoticeBtnForSupervisor = By.xpath("//button[text()='Approve Notice']");
	public static By crossIconCDP = By.xpath("//*[@class='case-details__close-icon']/img");
	public static By complyByDateField = By.xpath("//*[@name='complyByDate']");
	public static By select3AssigneeForFollowUpInspectionAsg = By
			.xpath("(//div[@class='multi-choice-buttons'])[2]/button[3]");
	public static By Assignee = By
			.xpath("//label[text()='Assigned to']//parent::div//div[@class='dropdown__selector__selected']//label");
	public By AssineeArrow = By
			.xpath("//label[text()='Assigned to']//parent::div//div[@class='dropdown__selector__selected']//span");
	public By AssingeeNotSelOpt = By.xpath("(//div[@id='caseAssignee']//li[@class='option'])[3]");
	public By serachAssingee = By.xpath("//input[@placeholder='Search...'][@name='query']");
	public By searchedAssingee = By.xpath("//div[@id='caseAssignee']//li[@class='option']//b");
	public By timeTackinglnk = By.cssSelector("a.time-tracking");
	public By timeTackingModel = By.xpath("(//div[@class='modal-header'])[2]");
	public By timeLogDatePicker = By.xpath("//input[@name='date']//following-sibling::span");
	public By timeLogDueDatePicker = By.xpath("//input[@placeholder='Due Time']//following-sibling::span");
	public By timeLogStartDatePicker = By.xpath("//input[@placeholder='Start Time']//following-sibling::span");
	public By dateNextPick = By.xpath("(//td[@class='rdtDay rdtActive rdtToday']//following-sibling::td)[1]");
	public By timeLogHour = By.xpath("//input[@name='hours']");
	public By timeLogNote = By.xpath("//textarea[@name='note']");
	public By addTimeLoggBtn = By.xpath("//div[@class='add-time-log']//button");
	public By deleteYesTimeLog = By.xpath("//div[@class='flex-row--middle']//button[contains(text(),'Yes, Delete')]");
	public By closeTimeTracking = By.xpath("//div[@class='modal-footer']//button[contains(text(),'Close')]");
	public By abatementActivityTile = By.cssSelector("div.abatement-activities__title-wrapper h2");
	public By caseActivity = By.cssSelector("h4.case-activity__label");
	public By nextInspection = By.cssSelector("div.abatement-activities__next-details h4");
	public By addContact = By.cssSelector(
			"input[autocomplete='new-password'][placeholder='Find contact by name, email or phone number or start typing to create a new contact']");
	public By editContact = By
			.xpath("(//div[@class='contact__actions']//button[@class='edit-btn  btn btn-primary'])");
	public By contactName = By.xpath("(//div[@class='contact__name-role']//label//b)");
	public By contactNameList = By.xpath("//div[@class='contact__name-role']//label//b");
	public By deleteContact = By
			.xpath("(//div[@class='contact__actions']//button[@class='delete-btn  btn btn-primary'])");
	public By contactTileCount = By.xpath("(//h2//div)[1]");
	public By createNewContact = By
			.xpath("//div[@class='react-autosuggest__function']//span[text()='Create a  new contact']");
	public By createContactButton = By.xpath("//div[@class='full-page-modal__header']//button[2]");
	public By editCustomTilebtn = By.xpath("//h2[text()='Custom Tile']//following-sibling::button");
	public By editCustomTilePop = By.xpath("//div[text()='Edit Custom Tile']");
	public By saveCustomUpdate = By.xpath("//button[text()='Save Changes']");
	public static By addAttachmentCDP = By
			.xpath("//span[contains(text(),'Attachments')]//parent::h2//button[@class='attach-btn btn btn-primary']");
	public static By file = By.xpath("//input[@type='file']");
	public By attachemntTileCDP = By.xpath("//span[contains(text(),'Attachments')]");
	public By attachemntImg = By.xpath("//div[@class='attachments-tile__photo-container']//img");
	public By YesDeleteButton = By.xpath("//button[text()='Yes, Delete']");
	public By updateAttachments = By.xpath("//button[text()='Update']");
	public By selectPhotobtn = By.xpath("//button[text()='Select Photos']");
	public By deSelectPhotos = By.xpath("//button[text()='Delete Selected']");
	public By printSelectedPhotos = By.xpath("//button[text()='Print Selected']");
	public By downloadSelectedPhotos = By.xpath("//button[text()='Download Selected']");
	public By tickPhoto = By.xpath("(//div[@class='tick--not-selected'])[1]");
	public By PhotoTickSelected = By.xpath("//div[@class='tick--selected']");
	public By selectPhotsDetails = By
			.xpath("(//div[@class='tick--selected']//following-sibling::div[@class='file-details']//span)[1]");
	public By printViewPage = By.xpath("//h4[contains(text(),'Print Images')]");
	public By printedPhotoDetail = By.xpath("(//div[@class='view-print-images__image-info']//p)[2]");
	public By generateNotice = By.xpath("//button[text()='Generate Notice']");
	public By generateNoticeBtnOnGenerateNoticeInProgressPage = By.xpath("(//button[text()='Generate Notice'])[2]");
	public By generateNoticePopUp = By.xpath("//div[@class='perform-inspection__title-text']//b");
	public By continueButton = By.xpath("(//button[text()='Continue'])[1]");
	public By continueButton2 = By.xpath("(//button[text()='Continue'])[2]");
	public By continueButton3 = By.xpath("(//button[text()='Continue'])[3]");
	public By htmlNoticeTooglebtn = By.xpath("(//button[contains(text(),'HTML')])[1]");
	public By noticeindependent = By
			.xpath("//h4[contains(text(),'Notice created independent of Follow-up inspection')]");
	public By applyNoticesbtn = By.xpath("//button[text()='Apply Notice']");
	public By manageNotice = By.xpath("//a[text()='Manage Notice']");
	public By deleteNotice = By.xpath("//a[text()='Delete']");
	public By deleteAndReissueNotice = By.xpath("//a[text()='Delete and Reissue']");
	public By independentNotice = By.cssSelector("div.abatement-activities__draft-notice div h4");
	public By caseHistory = By.xpath("//a[@class='view-history']");
	public By closebtn = By.xpath("//button[text()='Close']");
	public By editViolation = By.cssSelector("div.edit-entity__button-wrapper button");
	public By closeCrosEditViolation = By.cssSelector("div[class='modal-header'] button[aria-label='Close']");
	public By editVioNotes = By.xpath("//textarea[@name='Note']");
	public By editEntityAge = By.xpath("//input[@placeholder='Enter Number'][@type='NUMBER']");
	public By editVioSavebtn = By.xpath("//div[@class='entity-modal__footer']//button[text()='Save']");
	public By entityAge = By.xpath("//div[@class='entity-info']//div[contains(text(),'Age')]//following-sibling::div");
	public By entityNotesDetails = By
			.xpath("//div[@class='entity-info']//following-sibling::label//span[@class='clipped-text']");
	public By caseInitiation = By
			.xpath("//label[text()='Case Initiation']//parent::div//div[@class='dropdown__selector__selected']//label");

	public static By viewHistory = By.xpath("//a[text()='View History']");
	public static By editInternalComment = By.xpath("(//div[@id='case-notes']/div/div/div/div)[2]/div/button");
	public static By editInternalComment2 = By
			.xpath("(//div[@class='case-note-tile__notes']//button[@class='edit-btn  btn btn-primary'])[2]");
	public static By internalCommentText = By.xpath("//div[@class='case-note-tile__content']");
	public static By internalCommentText2 = By.xpath("(//div[@class='case-note-tile__content'])[2]");
	public static By caseHistoryAddedInternalComment = By.xpath("//*[text()='Added internal comment (Approved)']");
	public static By notApprovedEscalatedNotice = By.xpath("//div[@class='escalated-label not-approved']");

	public String assingeeBefore;
	public String assingeeAfter;
	public String timeTackingHeader;

	public boolean timeLoggedAssingee;
	public boolean timeLoggedhour;
	public boolean timeLoggedNote;
	public int timeLogDeleted;
	public boolean AbatementActivityTile;
	public boolean CaseActvityTile;
	public boolean NextInspectiontile;
	public boolean caseActivityTileTxt;
	public boolean NextInspectiontileTxt;
	public boolean EditedContactName;
	public boolean ContactEdited;
	public int deletedContact;
	public int contactCountAfter;
	public int contactCountBefore;
	public int contactTile;

	public static By approvedStatusCDP = By.xpath("//*[text()='Approved']");
	public static By applyNoticeBtnCDP = By.xpath("//button[text()='Apply Notice']");
	public static By applyApprovedNotice = By.xpath("//button[text()='Apply Approved Notice']");
	public static By applyApprovedNotice2 = By.xpath("(//button[text()='Apply Approved Notice'])[2]");
	public static By manageNoticeLinkCDP = By.xpath("//div[@class='abatement-activities__draft-notice-cta']/a");
	public static By viewNotice = By.xpath("//a[text()='View Notice']");
	public static By noticeApprovedAndAppliedToCaseText = By.xpath("//*[@class='completed-summary']/span/b");
	public static By checkMarkForNoticeApproved = By.xpath("(//div[@class='abatement-activities__done abatement-activities__done-details-position']/span)[1]");
	public static By approvedAndAppliedToCaseText = By.xpath("//label[@class='escalated-label approved-applied']");
	public static By closeBtn = By.xpath("//button[text()='Close']");
	public static By keepContactBtn = By.xpath("//button[text()='Keep contact']");
	public static By closeBtnManageNoticePopUp = By.xpath("//*[@class='view-notice__footer']//*[text()='Close']");
	public static By moreBtnCDP = By.xpath("//button[contains(text(),'More')]");
	public static By closeCaseAfterMoreBtn = By.xpath("//ul[@class='dropdown-button__dropdown-wrap']/li");
	public static String openedCaseId = "//h2[@class='case-details__case-number']";
	public static String buttonsEsclatedNotices = "//button[text()='%s']";
	public static String approveNoticePOpup = "//div[text()='%s']";
	public static String appliedNoticePOpup = "//span[text()='%s']";
	public static By unappliedNoticeWarning = By.xpath("//*[@class='close-case-form__notice-message']");
	public static By rejectNotice = By.xpath("//textarea[@name='note']");
	public static By contactSection = By.xpath("//h2/div");
	public static By contactcrossicon = By.xpath("//div[@class='contact__actions']//button[2]");
	public static String performInsButton = "//button[text()='Perform Inspection']";
	public static By performInspectionBtn = By.xpath("//button[text()='Perform Inspection']");

	public static By closeCaseBtnOnCloseCasePopup = By.xpath("//button[text()='Close Case']");
	public static By continueAfterApplyNotice = By.xpath("//button[text()='Continue']");
	public static By applyNoticeConfirmationPopup = By
			.xpath("//*[@class='modal-base__body']/div/h4[contains(text(),'apply')]");
	
	 public static By inspectionAssigneeMsg = By.xpath("(//div[@class='email-item__content']//h4)[1]");
	 public static By codeCaseAssigneeMsg = By.xpath("(//div[@class='email-item__content']//h4)[2]");
  public  static  By createContactPopup = By.xpath("//h1[text()='Create a Contact']");
  
  public static By createNewPayor = By.xpath("//div[contains(text(),'Create new contact ')]");

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}
	
	public String getMessageInfo(By locator) {
		
		String text = getTextElement(locator);

		return text;
	}

	public String deleteTimeLogBtn(String note) {
		return "//span[text()='" + note + "']//ancestor::div[@role='gridcell']//following-sibling::div//button";

	}

	public String editCustomefields(int index) {
		return "(//div[@class='custom-field-form__wrapper']//input)[" + index + "]";
	}

	public String actualCaseInitation;

	public void cdp_CaseDetailPagePreRequisite() throws InterruptedException {

		PI.PerformInspection_VerifyCreatAndPerformInspection();
		waitUntilElementIsVisible(caseInitiation);
		actualCaseInitation = getTextElement(caseInitiation);

	}

	public String getOutstandingBalance() {
		waitUntilElementIsVisible(By.xpath(
				"//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));
		String oustandingBal = getTextElement(By.xpath(
				"//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));

		return oustandingBal;
	}

	public void cdp_UserAbleToChangeAssignee() throws InterruptedException {
		waitUntilElementIsVisible(Assignee);
		assingeeBefore = getTextElement(Assignee);
		System.out.println(assingeeBefore);
		clickOn(AssineeArrow);
		waitUntilElementIsVisible(AssingeeNotSelOpt);
		clickOn(AssingeeNotSelOpt);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(Assignee);
		waitUntilElementIsVisible(AssineeArrow);
		waitForElementIsInteractable(AssineeArrow);
		// ClickByJsExecuter(AssineeArrow);
		// WaitUntilPresent(serachAssingee);
		// WaitForElementInteractable(serachAssingee);
		// SendKeys(serachAssingee, assingeeBefore);
		// WaitUntilVisible(searchedAssingee);
		// ClickByJsExecuter(searchedAssingee);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(Assignee);
		assingeeAfter = getTextElement(Assignee);
		System.out.println(assingeeAfter);
		softAssert.assertNotEquals(assingeeBefore, assingeeAfter, "Both Assignee are Same.");
		softAssert.assertAll();

	}

	public void cdp_VerifyUserDirectedToTimeTracking() throws InterruptedException {
		waitUntilElementPresent(timeTackinglnk);
		clickOn(timeTackinglnk);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(timeTackingModel);
		timeTackingHeader = getTextElement(timeTackingModel);
		softAssert.assertEquals(timeTackingHeader, "Time Tracking");
		softAssert.assertAll();

	}

	public void cdp_VerifyUserAbleToAddTimeLogOnTimeTracking() throws InterruptedException {
		waitUntilElementIsVisible(timeLogDatePicker);
		// ClickOn(timeLogDatePicker);
		// WaitUntilVisible(By.cssSelector("td.rdtDay"));
		String assingee = getTextElement(By.xpath("(//div[@class='multi-choice-buttons']//button)[1]"));
		// WaitUntilVisible(dateNextPick);
		// ClickOn(dateNextPick);
		clickOn(By.xpath("(//div[@class='multi-choice-buttons']//button)[1]"));
		sendKeysWithWait(timeLogHour, "1.00");
		sendKeysWithWait(timeLogNote, "Time Log Added For Case");
		clickOn(addTimeLoggBtn);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath("//div[@role='grid']//div[@role='gridcell']"));
		String AddedTimeNote = getTextElement(By.xpath("(//div[@role='grid']//div[@role='gridcell'])[5]"));
		String AddedHour = getTextElement(By.xpath("(//div[@role='grid']//div[@role='gridcell'])[4]"));
		String Addedassingee = getTextElement(By.xpath("(//div[@role='gridcell'][2])"));
		timeLoggedAssingee = assingee.equalsIgnoreCase(Addedassingee);
		timeLoggedhour = AddedHour.equalsIgnoreCase("1.00");
		timeLoggedNote = AddedTimeNote.equalsIgnoreCase("Time Log Added For Case");

		softAssert.assertTrue(timeLoggedAssingee);
		softAssert.assertTrue(timeLoggedhour);
		softAssert.assertTrue(timeLoggedNote);
		softAssert.assertAll();

	}

	public void cdp_VerifyUserAbleToDeleteAddedLogTime() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath(deleteTimeLogBtn("Time Log Added For Case")));
		clickOn(By.xpath(deleteTimeLogBtn("Time Log Added For Case")));
		waitUntilElementIsVisible(deleteYesTimeLog);
		waitForElementIsInteractable(deleteYesTimeLog);
		clickOn(deleteYesTimeLog);
		waitForCurserRunning(5);
		timeLogDeleted = findElementsSize(By.xpath(deleteTimeLogBtn("Time Log Added For Case")));
		waitUntilElementIsVisible(closeTimeTracking);
		clickOn(closeTimeTracking);
		waitUntilElementInvisibleLocated(closeTimeTracking);
		softAssert.assertTrue(timeLogDeleted == 0);
		softAssert.assertAll();

	}

	public void cdp_VerifyAbatementActivityTile() throws InterruptedException {
		waitUntilElementIsVisible(abatementActivityTile);
		AbatementActivityTile = findElement(abatementActivityTile).isDisplayed();
		CaseActvityTile = findElement(caseActivity).isDisplayed();
		String caseActivityTxt = getTextElement(caseActivity);
		NextInspectiontile = findElement(nextInspection).isDisplayed();
		String nextInsepectionTxt = getTextElement(nextInspection);
		caseActivityTileTxt = caseActivityTxt.equalsIgnoreCase("Case Created");
		NextInspectiontileTxt = nextInsepectionTxt.contains("Follow-up Inspection");
		softAssert.assertTrue(AbatementActivityTile);
		softAssert.assertTrue(CaseActvityTile);
		softAssert.assertTrue(NextInspectiontile);
		softAssert.assertTrue(caseActivityTileTxt);
		softAssert.assertTrue(NextInspectiontileTxt);
		softAssert.assertAll();

	}

	public void cdp_VerifyUserAbletoEditContact() throws InterruptedException {
		waitUntilElementIsVisible(addContact);
		scrollIntoView(addContact);
		waitForElementIsInteractable(editContact);
		clickByJsExecuter(editContact);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath(ccp.nameField));
		String contactBeforEdit = getValueAttribute(By.xpath(ccp.nameField));
		String newContactName = "NewEditedContact" + RandomStrings.requiredCharacters(8);
		clearElement(By.xpath(ccp.nameField));
		sendKeysWithWait(By.xpath(ccp.nameField), newContactName);
		waitForElementIsInteractable(By.xpath(clp.saveButton));
		try {
			clickByJsExecuter(By.xpath(clp.saveButton));
		} catch (Exception e) {
			forcedWaitTime(2);
			movetoElementAndClick(By.xpath(clp.saveButton));

		}
		waitUntilElementInvisibleLocated(By.xpath(clp.saveButton));
		waitForCurserRunning(3);
		waitUntilElementIsVisible(contactName);
		String contactAfterEdit = getTextElement(contactName);
		EditedContactName = newContactName.equalsIgnoreCase(contactAfterEdit);
		ContactEdited = !(contactBeforEdit.equalsIgnoreCase(newContactName));
		waitUntilElementIsVisible(deleteContact);
		softAssert.assertTrue(EditedContactName);
		softAssert.assertTrue(ContactEdited);
		softAssert.assertAll();

	}

	public void cdp_VerifyUserAbletoDeleteContact() throws InterruptedException {
		waitUntilElementIsVisible(deleteContact);
		contactCountBefore = findElementsSize(contactNameList);
		waitForElementIsInteractable(deleteContact);
		clickOn(deleteContact);
		waitForCurserRunning(5);
		Thread.sleep(3000);
		waitUntilElementIsVisible(addContact);

		deletedContact = findElementsSize(deleteContact);
		contactCountAfter = findElementsSize(contactNameList);
		contactTile = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		// softAssert.assertTrue(deletedContact == 0);
		softAssert.assertEquals(contactCountAfter, contactCountBefore - 1);
		softAssert.assertEquals(contactTile, contactCountAfter);
		softAssert.assertAll();

	}

	public String LegalContactCustome = "label[title='LegalContact']";
	public String IndiviualContactCustome = "label[title='IndiviualContact']";
	public boolean IndiviualContCustField;

	public int BeforeAddingContact;
	public boolean LegalContCustField;
	public int AfterAddingContact;

	public void AddNewContactCDP(String contactType, String customeFieldval, int contactCount)
			throws InterruptedException {
		BeforeAddingContact = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());

		for (int z = 0; z < contactCount; z++) {
			String RandomName = RandomStrings.requiredCharacters(8);
			String RandomMail = RandomName + "@yopmail.com";
			String RandomContact = RandomStrings.requiredDigits(10);
			waitUntilElementIsVisible(addContact);
			clickOn(addContact);
			clickOn(createNewContact);
			sendKeysWithWait(ccp.NameField, RandomName);
			sendKeysWithWait(ccp.EmailField, RandomMail);
			sendKeysWithWait(ccp.WorkPhoneField, RandomContact);

			if (contactType.equalsIgnoreCase("Legal Entity")) {
				clickOn(By.xpath("//button[text()='" + contactType + "']"));
				waitUntilElementIsVisible(By.cssSelector(LegalContactCustome));
				LegalContCustField = findElement(By.cssSelector(LegalContactCustome)).isDisplayed();
				if (customeFieldval.equalsIgnoreCase("Yes")) {
					WebElement element = findElement(By.xpath(
							"//label[@title='LegalContact']//parent::div//following-sibling::div/input[@placeholder='Enter Text']"));
					element.sendKeys("Legal" + RandomStrings.requiredString(4));
				}
			} else {
				clickOn(By.xpath("//button[text()='" + contactType + "']"));
				waitUntilElementIsVisible(By.cssSelector(IndiviualContactCustome));
				waitUntilElementIsVisible(By.cssSelector(IndiviualContactCustome));
				IndiviualContCustField = findElement(By.cssSelector(IndiviualContactCustome)).isDisplayed();
				if (customeFieldval.equalsIgnoreCase("Yes")) {
					WebElement element = findElement(By.xpath(
							"//label[@title='IndiviualContact']//parent::div//following-sibling::div/input[@placeholder='Enter Text']"));
					element.sendKeys("Legal" + RandomStrings.requiredString(4));
				}
			}

			waitForElementIsInteractable(createContactButton);
			clickOn(createContactButton);

			waitForElementIsInteractable(ccp.PropertyOwnerOption);
			clickOn(ccp.PropertyOwnerOption);
			clickOn(ccp.ApplyButton);
		}
		waitForCurserRunning(2);
		waitUntilElementIsVisible(contactTileCount);
		AfterAddingContact = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		softAssert.assertEquals(AfterAddingContact, BeforeAddingContact + 1);
		softAssert.assertAll();

	}

	public void cdp_VerifyUserAbletoAddNewContact() throws InterruptedException {
		AddNewContactCDP("Individual", "No", 1);
	}

	public boolean billToContact;

	public void cdp_VerifyUserAbletoSelectetheContactAsBilltoContact() throws InterruptedException {
		waitUntilElementIsVisible(FA.billtoContact2);
		scrollIntoView(FA.billtoContact2);
		clickByJsExecuter(FA.billtoContact2);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(FA.billtoContact2);
		billToContact = elementIsSelected(FA.billtoContact2);
		Assert.assertTrue(billToContact);
	}

	public boolean editCustomeTile;
	public boolean field1;
	public boolean field2;
	public boolean field3;

	public void cdp_VerifyUserAbletoUpdateCustomeTileFields() throws InterruptedException {
		waitUntilElementIsVisible(editCustomTilebtn);
		scrollIntoView(editCustomTilebtn);
		clickOn(editCustomTilebtn);
		waitUntilElementIsVisible(editCustomTilePop);
		editCustomeTile = elementIsDisplayed(editCustomTilePop);
		String field1Before = getValueAttribute(By.xpath(editCustomefields(1)));
		String field2Before = getValueAttribute(By.xpath(editCustomefields(2)));
		String field3Before = getValueAttribute(By.xpath(editCustomefields(3)));
		clearElement(By.xpath(editCustomefields(1)));
		clearElement(By.xpath(editCustomefields(2)));
		clearElement(By.xpath(editCustomefields(3)));

		sendKeysWithWait(By.xpath(editCustomefields(1)), RandomStrings.requiredString(6));
		sendKeysWithWait(By.xpath(editCustomefields(2)), RandomStrings.requiredString(6));
		sendKeysWithWait(By.xpath(editCustomefields(3)), RandomStrings.requiredString(6));

		waitUntilElementIsVisible(saveCustomUpdate);
		clickOn(saveCustomUpdate);
		waitForCurserRunning(3);

		waitUntilElementIsVisible(editCustomTilebtn);
		scrollIntoView(editCustomTilebtn);
		clickByJsExecuter(editCustomTilebtn);
		waitUntilElementIsVisible(editCustomTilePop);

		String field1after = getValueAttribute(By.xpath(editCustomefields(1)));
		String field2after = getValueAttribute(By.xpath(editCustomefields(2)));
		String field3after = getValueAttribute(By.xpath(editCustomefields(3)));

		field1 = (field1after.length() > 0) && !(field1after.equalsIgnoreCase(field1Before));
		field2 = (field2after.length() > 0) && !(field2after.equalsIgnoreCase(field2Before));
		field3 = (field3after.length() > 0) && !(field3after.equalsIgnoreCase(field3Before));

		waitUntilElementPresent(By.xpath("//button[text()='Cancel']"));
		clickOn(By.xpath("//button[text()='Cancel']"));
		Assert.assertTrue(editCustomeTile);
		Assert.assertTrue(field1);
		Assert.assertTrue(field2);
		Assert.assertTrue(field3);

	}

	public boolean attachemntCount;

	public void cdp_VerifyUserAbletoAddMultipleAttachment() throws InterruptedException {
		int BeforeAttachmentCount = Integer
				.parseInt(getTextElement(attachemntTileCDP).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		System.out.println(BeforeAttachmentCount);
		CEcommonMethod.addAttachmentCDP(CEcommonMethod.SetTestDataFilePath("Panda_11zon.jpg"));
		waitForCurserRunning(10);
		waitUntilElementIsVisible(attachemntTileCDP);
		forcedWaitTime(2);
		CEcommonMethod.addAttachmentCDP(CEcommonMethod.SetTestDataFilePath("Jellyfish_11zon.jpg"));
		waitForCurserRunning(10);
		waitUntilElementIsVisible(attachemntTileCDP);
		int AfterAttachmentCount = Integer
				.parseInt(getTextElement(attachemntTileCDP).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		attachemntCount = (BeforeAttachmentCount + 2) == (AfterAttachmentCount);
		Assert.assertTrue(attachemntCount);

	}

	public boolean DeleteattachemntCount;

	public void cdp_VerifyUserAbletoDeleteAttachment() throws InterruptedException {
		int BeforeAttachmentCount = Integer
				.parseInt(getTextElement(attachemntTileCDP).split(" ")[1].replace("(", " ").replace(")", " ").trim());

		waitUntilElementIsVisible(attachemntImg);
		List<WebElement> Attachemnts = findElementsByXPath(attachemntImg);
		int LastIndex = Attachemnts.size() - 1;
		(Attachemnts.get(LastIndex)).click();
		waitUntilElementIsVisible(By.xpath("//div[text()='Attachments Details']"));
		waitUntilElementIsVisible(By.xpath(
				"(//div[@class='attachments-edit__saved-summary']//button[@class='delete-btn  btn btn-primary'])[4]"));
		scrollIntoView(By.xpath(
				"(//div[@class='attachments-edit__saved-summary']//button[@class='delete-btn  btn btn-primary'])[4]"));
		clickOn(By.xpath(
				"(//div[@class='attachments-edit__saved-summary']//button[@class='delete-btn  btn btn-primary'])[4]"));
		waitUntilElementIsVisible(YesDeleteButton);
		waitForElementIsInteractable(YesDeleteButton);
		clickOn(YesDeleteButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(updateAttachments);
		waitForElementIsInteractable(updateAttachments);
		clickOn(updateAttachments);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(attachemntImg);
		int AfterAttachmentCount = Integer
				.parseInt(getTextElement(attachemntTileCDP).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		DeleteattachemntCount = (BeforeAttachmentCount - AfterAttachmentCount) == 1;

		Assert.assertTrue(DeleteattachemntCount);

	}

	public boolean PrintedPhoto;

	public void cdp_VerifyUserAblePrintSelectedAttatchment() throws InterruptedException {
		waitUntilElementIsVisible(selectPhotobtn);
		clickOn(selectPhotobtn);
		waitUntilElementIsVisible(deSelectPhotos);
		waitUntilElementIsVisible(printSelectedPhotos);
		waitUntilElementIsVisible(downloadSelectedPhotos);
		waitUntilElementIsVisible(tickPhoto);
		clickOn(tickPhoto);
		waitUntilElementIsVisible(PhotoTickSelected);
		String photoDetails = getTextElement(selectPhotsDetails);
		clickOn(printSelectedPhotos);
		forcedWaitTime(2);
		waitForCurserRunning(4);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		waitForPageLoadTime(5);
		waitUntilElementIsVisible(printViewPage);
		String actualPhoto = getTextElement(printedPhotoDetail);
		PrintedPhoto = photoDetails.equalsIgnoreCase(actualPhoto);
		driver.switchTo().window(currentWindow);
		Assert.assertTrue(PrintedPhoto);

	}

	public String attachmentDownloaded;

	public void cdp_VerifyUserAbleDownloadSelectedAttatchment() throws InterruptedException {
		waitUntilElementIsVisible(selectPhotobtn);
		clickByJsExecuter(selectPhotobtn);
		waitUntilElementIsVisible(deSelectPhotos);
		waitUntilElementIsVisible(printSelectedPhotos);
		waitUntilElementIsVisible(downloadSelectedPhotos);
		waitUntilElementIsVisible(tickPhoto);
		clickByJsExecuter(tickPhoto);
		waitUntilElementIsVisible(PhotoTickSelected);
		String photoDetails = getTextElement(selectPhotsDetails);
		System.out.println("photoDetails: "+ photoDetails);
		forcedWaitTime(3);
		clickByJsExecuter(downloadSelectedPhotos);
		forcedWaitTime(4);
		waitUntilElementIsVisible(By.xpath("//button[text()='Cancel']"));
		clickByJsExecuter(By.xpath("//button[text()='Cancel']"));
		waitUntilElementInvisibleLocated(By.xpath("//button[text()='Cancel']"));
		attachmentDownloaded = CheckDownloadedFile.isFileDownloaded(photoDetails);
		System.out.println(attachmentDownloaded);
		Assert.assertEquals(attachmentDownloaded, "File Present");

	}

	public boolean NoticeAppear;
	public By queueToPrint = By.xpath("//div[@class='case-inspection__print-notice']//button[text()='Queue To Print']");

	public void cdp_VerifyUserAbleGenerateNoticeOutsideofInspection() throws InterruptedException {
		waitUntilElementIsVisible(generateNotice);
		scrollIntoView(generateNotice);
		waitForElementIsInteractable(generateNotice);
		Thread.sleep(5000);
		clickOn(generateNotice);
		waitUntilElementIsVisible(generateNoticePopUp);
		waitUntilElementIsVisible(continueButton);
		scrollIntoView(continueButton);
		clickByJsExecuter(continueButton);
		waitUntilElementIsVisible(htmlNoticeTooglebtn);
		waitForCurserRunning(3);
		clickOn(htmlNoticeTooglebtn);
		waitUntilElementIsVisible(continueButton2);
		scrollIntoView(continueButton2);
		clickByJsExecuter(continueButton2);
		waitUntilElementIsVisible(By.cssSelector("a.view-photos"));
		waitUntilElementIsVisible(continueButton3);
		scrollIntoView(continueButton3);
		clickByJsExecuter(continueButton3);
		waitUntilElementIsVisible(By.cssSelector("#skip-inspection"));

		CEcommonMethod.selectScheduleFollowUpInspectionCheckbox();

		CEcommonMethod.selectUserScheduleFollowUpInspection("Amandeep");
		waitUntilElementIsVisible(By.xpath("(//button[text()='Generate Notice'])[2]"));
		scrollIntoView(By.xpath("(//button[text()='Generate Notice'])[2]"));
		clickOn(By.xpath("(//button[text()='Generate Notice'])[2]"));
		waitForCurserRunning(4);
		Thread.sleep(5000);
		waitForElementIsInteractable(queueToPrint);
		clickByJsExecuter(queueToPrint);
		waitUntilElementIsVisible(By.xpath("(//button[text()='Generate Notice'])[3]"));
		scrollIntoView(By.xpath("(//button[text()='Generate Notice'])[3]"));
		clickOn(By.xpath("(//button[text()='Generate Notice'])[3]"));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(noticeindependent);
		NoticeAppear = elementIsDisplayed(noticeindependent);
		Assert.assertTrue(NoticeAppear);

	}

	public boolean NoticeDeletedAppear;

	public void cdp_VerifyUserAbleToDeleteNotice() throws InterruptedException {
		waitUntilElementIsVisible(manageNotice);
		scrollIntoView(manageNotice);
		clickOn(manageNotice);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(deleteNotice);
		waitUntilElementIsVisible(deleteAndReissueNotice);
		clickOn(deleteNotice);
		waitUntilElementIsVisible(By.xpath("//button[text()='Yes']"));
		clickOn(By.xpath("//button[text()='Yes']"));
		waitForCurserRunning(5);
		NoticeDeletedAppear = findElementsSize(noticeindependent)>0;
		Assert.assertFalse(NoticeDeletedAppear);

	}

	public boolean reissuedNotice;

	public void cdp_VerifyUserAbleToDeleteAndReissueNotice() throws InterruptedException {

//		refreshPage();
//		waitForCurserRunning(4);

		cdp_VerifyUserAbleGenerateNoticeOutsideofInspection();
		String previousNotice = getTextElement(independentNotice);
		System.out.println("prev notice " + previousNotice);
		Thread.sleep(5000);
		waitUntilElementIsVisible(manageNotice);
		scrolltoPageTop();
		scrollIntoView(manageNotice);
		clickOn(manageNotice);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(deleteNotice);
		waitUntilElementIsVisible(deleteAndReissueNotice);
		waitForElementIsInteractable(deleteAndReissueNotice);
		clickOn(deleteAndReissueNotice);
		waitUntilElementIsVisible(By.xpath("//button[text()='Yes']"));
		clickOn(By.xpath("//button[text()='Yes']"));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(generateNoticePopUp);
		waitUntilElementIsVisible(continueButton);
		scrollIntoView(continueButton);
		clickByJsExecuter(continueButton);
		waitForCurserRunning(2);
		// waitUntilElementIsVisible(By.xpath("(//button[starts-with(text(),'HTML')])"));
		// clickOn(By.xpath("(//button[starts-with(text(),'HTML')])"));
		fines.selectNoticeOnPerformInspection("HTML Mandatory Notice");

		waitUntilElementIsVisible(continueButton2);
		scrollIntoView(continueButton2);
		clickByJsExecuter(continueButton2);
		waitUntilElementIsVisible(By.cssSelector("a.view-photos"));
		waitUntilElementIsVisible(continueButton3);
		scrollIntoView(continueButton3);
		clickByJsExecuter(continueButton3);
		waitUntilElementIsVisible(By.cssSelector("#skip-inspection"));

		if (!(findElementsSize(By.cssSelector("#skip-inspection"))>0)) {
			System.out.println("Continue not clicked");
			Thread.sleep(3000);
			scrollIntoView(continueButton3);
			moveToElement(continueButton3);
		}

		CEcommonMethod.selectScheduleFollowUpInspectionCheckbox();
		CEcommonMethod.selectUserScheduleFollowUpInspection("Amandeep");
		waitUntilElementIsVisible(By.xpath("(//button[text()='Generate Notice'])[2]"));
		scrollIntoView(By.xpath("(//button[text()='Generate Notice'])[2]"));
		clickOn(By.xpath("(//button[text()='Generate Notice'])[2]"));
		waitForCurserRunning(4);
		waitForElementIsInteractable(queueToPrint);
		Assert.assertTrue(elementIsDisplayed(queueToPrint));
		clickOn(queueToPrint);
		waitUntilElementIsVisible(By.xpath("(//button[text()='Generate Notice'])[3]"));
		scrollIntoView(By.xpath("(//button[text()='Generate Notice'])[3]"));
		clickOn(By.xpath("(//button[text()='Generate Notice'])[3]"));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(noticeindependent);
		NoticeAppear = elementIsDisplayed(noticeindependent);
		String NewNotice = getTextElement(independentNotice);
		System.out.println("new notice " + NewNotice);
		Assert.assertTrue(elementIsDisplayed(manageNotice));

	}

	public String noticeApplied;

	public void cdp_VerifyUserAbleApplyNoticeOutsideofInspection() throws InterruptedException {
		Thread.sleep(5000);
		waitUntilElementIsVisible(applyNoticesbtn);
		scrollIntoView(applyNoticesbtn);

		clickOn(applyNoticesbtn);
		waitUntilElementIsVisible(By.cssSelector("#skip-inspection"));
		CEcommonMethod.selectScheduleFollowUpInspectionCheckbox();
		waitUntilElementIsVisible(continueButton);
		scrollIntoView(continueButton);
		clickByJsExecuter(continueButton);
		waitUntilElementIsVisible(By.xpath("(//*[@class='modal-base__body'])[3]"));
		clickOn(By.xpath("//button[text()='Yes']"));
		waitForCurserRunning(10);
		waitUntilElementIsVisible(By.xpath("(//label[@class='completed-summary']//b)[1]"));
		noticeApplied = getTextElement(By.xpath("(//label[@class='completed-summary']//b)[1]"));
		Assert.assertTrue(noticeApplied.equalsIgnoreCase("Notice Applied"));

	}

	public boolean historyView;
	public boolean caseHistoryButton;
	public boolean contactHistory;
	public boolean noticehistory;

	public void cdp_VerifyCaseHistory() throws InterruptedException {
		waitUntilElementIsVisible(caseHistory);
		List<WebElement> recentNoticeAdded = findElementsByXPath(By.xpath("//h4[@class='inspection-notice__name']"));
		String recentAddedNotice = (recentNoticeAdded.get(recentNoticeAdded.size() - 1)).getText();
		waitUntilElementIsVisible(By.xpath("//button[text()='Print']"));
		scrollIntoView(By.xpath("//button[text()='Print']"));
		String CaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		scrollIntoView(caseHistory);
		waitForElementIsInteractable(caseHistory);
		clickByJsExecuter(caseHistory);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath(
				"//div[@class='modal-header'][contains(text(),'" + CaseId + "') and contains(text(),'History Case')]"));
		historyView = elementIsDisplayed(By.xpath(
				"//div[@class='modal-header'][contains(text(),'" + CaseId + "') and contains(text(),'History Case')]"));
		caseHistoryButton = elementIsDisplayed(By.xpath("//button[text()='Case History']"));
		contactHistory = elementIsDisplayed(By.xpath("//button[text()='Contact History']"));
		waitUntilElementIsVisible(
				By.xpath("//span[@class='clipped-text'][contains(text(),'" + recentAddedNotice + "')]"));
		noticehistory = findElementsSize(
				By.xpath("//span[@class='clipped-text'][contains(text(),'" + recentAddedNotice + "')]")) > 0;
		waitUntilElementIsVisible(closeCaseHistory);
		clickOn(closeCaseHistory);
		waitUntilElementInvisibleLocated(closeCaseHistory);
		Assert.assertTrue(historyView);
		Assert.assertTrue(caseHistoryButton);
		Assert.assertTrue(contactHistory);
		Assert.assertTrue(noticehistory);

	}

	public boolean CaseId;
	public boolean abatmnetStatus;
	public boolean locationDetails;
	public boolean Contact;
	public boolean AttachmentCount;
	public boolean violationCount;
	public boolean followupInspectionCount;

	boolean CaseId2;

	public void cdp_VerifyPrintCaseDetailsPage() throws InterruptedException {
		String CaseIdCDP = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		String abatmnetStatusCDP = getTextElement(By.xpath("//span[@class='abatement-status']"));
		String locationCDP = getTextElement(By.xpath("//span[@class='space-left']"));
		int ContactCDP = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		int AttachmentCountCDP = Integer
				.parseInt(getTextElement(attachemntTileCDP).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		int violationCountCDP = Integer
				.parseInt(getTextElement(By.xpath("//span[@class='violation-tile-headline__count']")).split(" ")[1]
						.replace("(", " ").replace(")", " ").trim());
		int followupInspectionCountCDP = Integer.parseInt(
				getTextElement(By.cssSelector(" div.abatement-activities__next-details h4")).split(" ")[2].trim());
		waitUntilElementIsVisible(By.xpath("//button[text()='Print']"));
		scrollIntoView(By.xpath("//button[text()='Print']"));
		clickOn(By.xpath("//button[text()='Print']"));
		waitUntilElementIsVisible(By.xpath("//div[text()='Print Settings']"));
		waitUntilElementIsVisible(By.xpath("(//button[text()='Print'])[2]"));
		clickOn(By.xpath("(//button[text()='Print'])[2]"));
		forcedWaitTime(4);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		waitForPageLoadTime(3);
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		String PrintViewCaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		String PrintViewabatmnetStatus = getTextElement(By.xpath("//span[@class='abatement-status']"));
		String PrintViewlocation = getTextElement(By.xpath("//h2[text()='Location']//following-sibling::span"));
		int PrintViewContact = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		waitUntilElementIsVisible(By.cssSelector("div.attachment-count"));
		scrollIntoView(By.cssSelector("div.attachment-count"));
		int PrintViewAttachmentCount = Integer.parseInt(getTextElement(By.cssSelector("div.attachment-count")));
		int PrintViewFollowupInspectionCount = Integer.parseInt(
				getTextElement(By.cssSelector("div.abatement-activities__next-details h4")).split(" ")[2].trim());
		CaseId2 = PrintViewCaseId.equalsIgnoreCase(CaseIdCDP);
		abatmnetStatus = PrintViewabatmnetStatus.equalsIgnoreCase(abatmnetStatusCDP);
		locationDetails = PrintViewlocation.equalsIgnoreCase(locationCDP);
		Contact = PrintViewContact == ContactCDP;
		AttachmentCount = PrintViewAttachmentCount == (AttachmentCountCDP);
		followupInspectionCount = PrintViewFollowupInspectionCount == (followupInspectionCountCDP);
		driver.switchTo().window(currentWindow);
		Assert.assertTrue(CaseId2);
		Assert.assertTrue(abatmnetStatus);
		Assert.assertTrue(locationDetails);
		Assert.assertTrue(Contact);
		Assert.assertTrue(AttachmentCount);
		Assert.assertTrue(followupInspectionCount);
	}

	public boolean violationNo1;
	public boolean violationNo2;
	public boolean NoteEdited;
	public boolean AgeEdited;

	public void cdp_VerifyUserAbletoEditviolationsonCDP() throws InterruptedException {
		if (driver.findElements(ccp.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		CEcommonMethod.navigateToCCP();
		waitUntilElementIsVisible(ccp.CCPTitle);
		waitForElementIsInteractable(ccp.CCButton);
		CEcommonMethod.addLocationCCP();
		CEcommonMethod.addViolationParam("Wa");
		CEcommonMethod.addViolationWithEntity("Animal", "Black");
		CEcommonMethod.ce_addContact();
		CEcommonMethod.addAttachmentCCP(CEcommonMethod.SetTestDataFilePath("pexels-mike-b-170811.jpg"));
		waitUntilElementIsVisible(ccp.CreateCaseButton);
		scrollIntoView(ccp.CreateCaseButton);
		waitForElementIsInteractable(ccp.CreateCaseButton);
		clickOn(ccp.CreateCaseButton);

		handleReviewContact();

		waitForCurserRunning(5);
		waitUntilElementIsVisible(
				By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));
		waitUntilElementPresent(
				By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));
//		waitUntilElementIsVisible(ccp.performInspectionToogel);
//		waitUntilElementIsVisible(ccp.AssignCaseTo);
//		waitForElementIsInteractable(ccp.AssignCaseTo);
//		clickOn(ccp.AssignCaseTo);
//		waitForElementIsInteractable(ccp.InspectionAssigneeTo);
//		clickOn(ccp.InspectionAssigneeTo);
//		waitForElementIsInteractable(ccp.CreateScheduleInspectionButton);
		clickOn(ccp.CreateScheduleInspectionButton);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		waitUntilElementIsVisible(caseInitiation);
		actualCaseInitation = getTextElement(caseInitiation);
		waitUntilElementIsVisible(By.xpath("(//span[@class='violation-label'])[1]"));
		scrollIntoView(By.xpath("(//span[@class='violation-label'])[1]"));
		String violationName = getTextElement(By.xpath("(//span[@class='violation-label'])[1]"));
		scrollIntoView(By.xpath("(//span[@class='violation-label'])[1]"));
		String violationName2 = getTextElement(By.xpath("(//span[@class='violation-label'])[2]"));
		violationNo1 = violationName.contains("Water");
		violationNo2 = violationName2.contains("Animal");

		waitUntilElementIsVisible(editViolation);
		clickOn(editViolation);
		waitUntilElementIsVisible(closeCrosEditViolation);

		waitUntilElementIsVisible(editVioNotes);
		waitUntilElementIsVisible(editEntityAge);
		sendKeysWithWait(editEntityAge, "3");
		sendKeysWithWait(editVioNotes, "ViolationUpdated");
		waitUntilElementIsVisible(editVioSavebtn);
		clickOn(editVioSavebtn);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(entityNotesDetails);
		String updatedNote = getTextElement(entityNotesDetails);
		waitUntilElementIsVisible(entityAge);
		String updatedAge = getTextElement(entityAge);

		NoteEdited = updatedNote.equalsIgnoreCase("ViolationUpdated");
		AgeEdited = updatedAge.equalsIgnoreCase("3");
		Assert.assertTrue(violationNo1);
		Assert.assertTrue(violationNo2);
		Assert.assertTrue(NoteEdited);
		Assert.assertTrue(AgeEdited);
	}

	public int UnPaidFinePayment;
	public boolean finetypeAndAmout;
	public boolean fineAddedOn;
	public boolean cashPaymentAdded;
	public boolean partialPaymentLabel;

	public static By outstandingBalDetails = By
			.xpath("//label[text()='Outstanding Balance']//parent::div//a[@class='view-details']");
	public static By finePaymentDetailsPopup = By.xpath("//div[contains(text(),'Fines & Payments Details')]");

	public static By selectFineDropdownArrow = By
			.xpath("//label[@title='Select Fine']//parent::div//parent::div//span[@class='Select-arrow']");
	public static By selectFineOptions = By.xpath("//div[@class='Select-menu-outer']/div/div[1]");
	public static By addNewFine = By.xpath("//div[@class='add-transaction']//button[text()='Add Fine']");
	public static By closeFinePaymentDetailsPop = By
			.xpath("//button[text()='Close']");
	public By voidIconFinePaymentList = By.xpath("(//img[@class='void-icon'])[1]");
	public static By unpaidButton = By.xpath("//button[text()='Unpaid']");

	public By paymentSideBar = By.xpath("//label[text()='Payments']");
	public By citizenPaymentProtal = By.xpath("(//label[text()='Citizen Payment Portal']");
	public By paymentPortallinkText = By.xpath("//div[@class='payment-portal-form__url-section__url']//h5");
	public By copyPaymentPortalLink = By.xpath("//div[@class='payment-portal-form__url-section__url']//button");
	public By defaultPaymentPortaltitle = By.xpath("//input[@placeholder='Enter Payment Portal Title'][@name='title']");
	public By savePaymentPorrtalSettings = By.xpath("//button[text()='Save Changes']");
	public static By AddedfineDetails = By.xpath("//div[@role='rowgroup']//div[@role='gridcell']//span");
	public static By AddPayment = By.xpath("//button[text()='Add Payment']");
	public static By AddPaymentAmnt = By.xpath("//input[@name='amount']");
	public static By SelectPayor = By.xpath("//div[text()='Payor']");
	public static By fineAddedOnDate = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'])[3]");
	public static By addLateFeeToggel = By.xpath("//div[@class='multi-choice-buttons']//button[text()='Add Late Fee']");
	public static By selectLateFeeDropDownArrow = By.xpath("//label[@title='Select Late Fee']//parent::div//parent::div//span[@class='Select-arrow']");
	public static By addNewLateFee = By.xpath("//div[@class='add-transaction']//button[text()='Add Late Fee']");
	public static By checkkOrRecipient = By.xpath("//input[@name='receiptNumber']");
	public static By paymentClerk = By.xpath("//input[@name='paymentClerk']");
	public static By addedPaymentType = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]");
	public static By partialPaidBtn = By.xpath("//button[text()='Partially Paid']");
	public static By payorName = By.xpath("//input[@name='payorId']//parent::div//span[@role='option']");

	public void cdp_VerifyAddPaymentFromFineAndPaymentDetalis() throws InterruptedException {
		waitUntilElementIsVisible(outstandingBalDetails);
		waitUntilElementIsVisible(By.xpath("//button[text()='Print']"));
		scrollIntoView(By.xpath("//button[text()='Print']"));
		waitForElementIsInteractable(outstandingBalDetails);
		clickOn(outstandingBalDetails);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(finePaymentDetailsPopup);
		waitUntilElementIsVisible(addNewFine);
		waitUntilElementPresent(finePaymentDetailsPopup);
		waitForElementIsInteractable(selectFineDropdownArrow);
		clickOn(selectFineDropdownArrow);
		waitUntilElementIsVisible(selectFineOptions);
		clickOn(selectFineOptions);
		waitForElementIsInteractable(addNewFine);
		clickOn(addNewFine);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(closeFinePaymentDetailsPop);
		waitUntilElementPresent(closeFinePaymentDetailsPop);
		waitUntilElementIsVisible(unpaidButton);
		waitUntilElementIsVisible(AddedfineDetails);
		UnPaidFinePayment = findElementsByXPath(unpaidButton).size();
		List<WebElement> fineTypeAmout = findElementsByXPath(AddedfineDetails);
		for (int i = 0; i < fineTypeAmout.size(); i++) {
			String textRetrived = fineTypeAmout.get(i).getText();
			finetypeAndAmout = !(textRetrived.isEmpty());
		}
		fineAddedOn = !(getTextElement(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'])[3]"))).isEmpty();

		waitUntilElementIsVisible(AddPayment);
		clickOn(AddPayment);
		waitUntilElementIsVisible(AddPaymentAmnt);
		sendKeysWithWait(AddPaymentAmnt, "1500");
		waitUntilElementIsVisible(SelectPayor);
		clickOn(SelectPayor);
		waitUntilElementIsVisible(op.SelectPayorOpt);
		clickOn(op.SelectPayorOpt);
		if(findElementsSize(createContactPopup)>0){
			CEcommonMethod.ce_addContact2();
		}
		Thread.sleep(3000);
		try {
			waitUntilElementIsVisible(op.AddPaymentbtn);
			clickOn(op.AddPaymentbtn);
		} catch (Exception e) {
			clickByJsExecuter(op.AddPaymentbtn);
		}
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]"));
		String cashPayment = getTextElement(By.xpath("(//div[@role='rowgroup']//div[@role='gridcell']//span)[1]"));
		cashPaymentAdded = cashPayment.contains("Cash");
		waitUntilElementIsVisible(By.xpath("//button[text()='Partially Paid']"));
		partialPaymentLabel = findElementsSize(By.xpath("//button[text()='Partially Paid']"))>0;

		Assert.assertTrue(UnPaidFinePayment == 1);
		Assert.assertTrue(finetypeAndAmout);
		Assert.assertTrue(fineAddedOn);
		Assert.assertTrue(cashPaymentAdded);
		Assert.assertTrue(partialPaymentLabel);
		Assert.assertEquals(actualCaseInitation, "Reactive");
	}

	public String Actuallabel;
	public String CaseIdCDP;
	public boolean overdueLabel;
	public By overdueLbl = By.xpath("//span[@class='is-overdue']");

	public void cdp_VerifyOverdueFinePayment() throws InterruptedException {
		waitUntilElementIsVisible(op.AddFineToggle);
		clickByJsExecuter(op.AddFineToggle);
		waitUntilElementIsVisible(op.AddNewFine);
		waitForElementIsInteractable(op.SelectFineDropdownArrow);
		try {
			clickOn(op.SelectFineDropdownArrow);
		} catch (Exception e) {
			movetoElementAndClick(op.SelectFineDropdownArrow);
		}
		waitUntilElementIsVisible(op.SelectFineOptions);
		waitForElementIsInteractable(op.SelectFineOptions);
		clickOn(op.SelectFineOptions);
		waitForElementIsInteractable(op.AddNewFine);
		waitUntilElementIsVisible(op.DueDatePicker);
		clickByJsExecuter(op.DueDatePicker);
		waitUntilElementIsVisible(By.xpath("//div[@class='rdt rdtOpen']"));
		waitUntilElementIsVisible(op.PrevDateArrow);
		clickByJsExecuter(op.PrevDateArrow);
		waitUntilElementIsVisible(op.PrevDateArrow);
		clickByJsExecuter(op.PrevDateArrow);
		waitUntilElementIsVisible(op.SelectDate10);
		clickByJsExecuter(op.SelectDate10);
		waitUntilElementIsVisible(op.AddNewFine);
		clickByJsExecuter(op.AddNewFine);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(op.CloseFinePaymentDetailsPop);
		waitUntilElementPresent(op.CloseFinePaymentDetailsPop);
		waitUntilElementIsVisible(op.OverdueFineLbl);
		Actuallabel = getTextElement(op.OverdueFineLbl);

		clickByJsExecuter(op.CloseFinePaymentDetailsPop);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseIdCDP = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		CEcommonMethod.closeCaseDetailPage();
		CEcommonMethod.searchCaseoOnCLP(CaseIdCDP);

		waitForElementIsInteractable(clp.ColumnControlWidget);
		clickByJsExecuter(clp.ColumnControlWidget);
		waitForElementIsInteractable(clp.ColumnOutstandingBalance);
		clickByJsExecuter(clp.ColumnOutstandingBalance);
		waitForElementIsInteractable(clp.CloseColumnControl);
		clickByJsExecuter(clp.CloseColumnControl);
		waitUntilElementIsVisible(clp.ColumnOutstandingBalanceCLP);
		scrollIntoView(clp.ColumnOutstandingBalanceCLP);
		waitUntilElementIsVisible(overdueLbl);
		overdueLabel = elementIsDisplayed(overdueLbl);
		Assert.assertTrue(Actuallabel.equalsIgnoreCase("Overdue"));
		Assert.assertTrue(overdueLabel);
	}
	
	public String getCaseId() {
		String CaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		return CaseId;
	}

	public Boolean voidLableIcon;
	public String voidLableButton;
	public Boolean paymentNullifiedPresent;

	public void cdp_VerifyUserAbletoMakeFineAsVoid() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//a[text()='" + CaseIdCDP + "']"));
		waitForElementIsInteractable(By.xpath("//a[text()='" + CaseIdCDP + "']"));
		clickByJsExecuter(By.xpath("//a[text()='" + CaseIdCDP + "']"));
		waitForCurserRunning(10);
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		waitForElementIsInteractable(op.OutstandingBalDetails);
		clickOn(op.OutstandingBalDetails);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(op.FinePaymentDetailsPopup);
		waitUntilElementIsVisible(op.AddNewFine);
		waitUntilElementPresent(op.FinePaymentDetailsPopup);
		waitForElementIsInteractable(op.SelectFineDropdownArrow);
		waitUntilElementIsVisible(op.VoidIconFinePaymentList);
		waitForElementIsInteractable(op.VoidIconFinePaymentList);
		clickByJsExecuter(op.VoidIconFinePaymentList);
		sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
		waitForElementIsInteractable(op.VoidfineBtn);
		clickByJsExecuter(op.VoidfineBtn);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(op.VoidLable);
		waitUntilElementPresent(op.VoidLable);
		voidLableIcon = findElement(op.VoidLable).isDisplayed();
		voidLableButton = getTextElement(op.VoidLable);
		paymentNullifiedPresent = findElement(op.FineNullified).isDisplayed();
		Assert.assertEquals(voidLableIcon, Boolean.TRUE);
		Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
		Assert.assertEquals(voidLableButton, "Void");
	}

	public void cdp_VerifyUserAbletoMakeFineAsWaive() throws InterruptedException {
		waitUntilElementIsVisible(op.AddNewFine);
		waitUntilElementPresent(op.FinePaymentDetailsPopup);
		waitForElementIsInteractable(op.SelectFineDropdownArrow);
		clickOn(op.SelectFineDropdownArrow);
		waitUntilElementIsVisible(op.SelectFineOptions);
		clickOn(op.SelectFineOptions);
		waitForElementIsInteractable(op.AddNewFine);
		waitUntilElementIsVisible(op.AddNewFine);
		clickOn(op.AddNewFine);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(op.CloseFinePaymentDetailsPop);
		waitUntilElementPresent(op.CloseFinePaymentDetailsPop);
		waitUntilElementIsVisible(op.VoidIconFinePaymentList);
		waitForElementIsInteractable(op.VoidIconFinePaymentList);
		clickByJsExecuter(op.VoidIconFinePaymentList);
		waitUntilElementIsVisible(By.xpath("//button[text()='Waive']"));
		clickOn(By.xpath("//button[text()='Waive']"));
		sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
		waitForElementIsInteractable(op.WaivefineBtn);
		clickByJsExecuter(op.WaivefineBtn);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(op.VoidLable);
		waitUntilElementPresent(op.VoidLable);
		voidLableIcon = findElement(op.VoidLable).isDisplayed();
		voidLableButton = getTextElement(op.VoidLable);
		paymentNullifiedPresent = findElement(op.FineNullified).isDisplayed();
		Assert.assertEquals(voidLableIcon, Boolean.TRUE);
		Assert.assertEquals(paymentNullifiedPresent, Boolean.TRUE);
		Assert.assertEquals(voidLableButton, "Waived");
	}

	public boolean PaymentvoidLableIcon;
	public String PaymentvoidLableBtn;
	public String oustandingBal;
	public String oustandingBalCLP;
	public boolean PaymentNullified;

	public void cdp_VerifyUserAbletoMakePaymentAsVoid() throws InterruptedException {
		waitUntilElementIsVisible(op.PaymentVoidSymbol);
		waitForElementIsInteractable(op.PaymentVoidSymbol);
		clickByJsExecuter(op.PaymentVoidSymbol);
		sendKeysWithWait(op.ReasonForVoid, RandomStrings.requiredString(4));
		waitForElementIsInteractable(op.VoidPaymentbutton);
		clickByJsExecuter(op.VoidPaymentbutton);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(op.PaymentVoid);
		PaymentvoidLableIcon = findElement(op.PaymentVoid).isDisplayed();
		PaymentvoidLableBtn = getTextElement(op.PaymentVoid);
		PaymentNullified = findElement(op.PaymentCashNullified).isDisplayed();
		Assert.assertTrue(PaymentvoidLableIcon);
		Assert.assertTrue(PaymentNullified);
		Assert.assertEquals(PaymentvoidLableBtn, "Void");
	}

	public void cdp_VerifyOustandingBalWithCLP() throws InterruptedException {
		clickOn(op.CloseFinePaymentDetailsPop);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(By.xpath(
				"//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));
		oustandingBal = getTextElement(By.xpath(
				"//label[text()='Outstanding Balance']//parent::div//label[@class='field__label-data-field']//span"));
		CEcommonMethod.closeCaseDetailPage();
		waitForElementIsInteractable(clp.ColumnControlWidget);
		clickOn(clp.ColumnControlWidget);
		waitForElementIsInteractable(clp.ColumnOutstandingBalance);

		boolean flag = elementIsChecked(clp.outstandingBalanceChkboxWidget);
		if (flag == false)

			clickOn(clp.ColumnOutstandingBalance);
		waitForElementIsInteractable(clp.CloseColumnControl);

		clickOn(clp.CloseColumnControl);
		Thread.sleep(5000);
		waitUntilElementIsVisible(clp.ColumnOutstandingBalanceCLP);

		// find the no of headings so that we get a no at which index outstanding
		// balance is located
		int indexOfOutstandingBalance = 0;
		List<WebElement> columns = findElementsByXPath(columnHeadingsOnCDP);
		System.out.println("size is " + columns.size());
		for (int i = 0; i <= columns.size() - 1; i++) {
			if (columns.get(i).getText().contains("Outstanding")) {
				System.out.println("text found " + columns.get(i).getText());
				indexOfOutstandingBalance = i;
				System.out.println(i + "qwertyqwertyqwerty");
				break;
			}

		}
		indexOfOutstandingBalance = indexOfOutstandingBalance + 1;

//		scrollIntoView(clp.ColumnOutstandingBalanceCLP);
//		scrollHorizontally(20);
//		waitUntilElementIsVisible(By.xpath("(//div[@role='gridcell']//div)[14]"));
		oustandingBalCLP = getTextElement(By.xpath("//div[@role='gridcell'][" + indexOfOutstandingBalance + "]"));

		Assert.assertEquals(oustandingBalCLP, oustandingBal);
	}

	public static By columnHeadingsOnCDP = By
			.xpath("//*[@class='rt-tr']/div/div[@class='rt-resizable-header-content']");

	public void VerifyApproveNoticeAppearBasicSupervisor() throws InterruptedException {
		CEcommonMethod.createCaseWithCustomeNotices("EscalatedNotice");
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		System.out.println(CaseId + " case id");
		CEcommonMethod.closeCaseDetailPage();
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginBasicSupervisor_QAProdStage();
		Thread.sleep(2000);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		forcedWaitTime(3);
		waitUntilElementIsVisible(By.xpath("//button[text()='Approve Notice']"));
		Boolean Approve_Notice = findElementByXPath(stringFormat("//button[text()='%s']", "Approve Notice"))
				.isDisplayed();
		Assert.assertTrue(Approve_Notice, "Approve Notice does not button Appears.");

	}

	public void VerifyApproveNoticeNotAppear() throws InterruptedException {

		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		// Login with user outside of any group

		log.loginUserOutsideOfGroup_QAStageProd();

		CEcommonMethod.createCaseWithCustomeNotices("EscalatedNotice");
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		CEcommonMethod.closeCaseDetailPage();
		log.LogOut();
		forcedWaitTime(5);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		// log.LoginBasicSupervisor();
		log.loginBasicSupervisor_QAProdStage();

		forcedWaitTime(2);

		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		Boolean Approve_Notice = elementIsDisplayed(By.xpath(stringFormat("//button[text()='%s']", "Approve Notice")));
		Assert.assertFalse(Approve_Notice, "Approve Notice is button Appears.");

	}

	public void VerifyApproveNoticeOutsideGroup() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginSupervisorManager_QAProdStage();

		Thread.sleep(2000);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		CEcommonMethod.approvedPendingEsclatedNoticeCDP();
		Thread.sleep(2000);
		Boolean Approved_Notice = elementIsDisplayed(By.xpath("//div[text()='Approved']"));
		Boolean Apply_Approved_Notice = elementIsDisplayed(By.xpath("//button[text()='Apply Approved Notice']"));
		Boolean Manage_Notice = elementIsDisplayed(manageNotice);

		Assert.assertTrue(Approved_Notice, "Approved Notice is not button Appears.");
		Assert.assertTrue(Apply_Approved_Notice, "Apply Notice is not button Appears.");
		Assert.assertTrue(Manage_Notice, "Manage_Notice is not button Appears.");

	}

	public void VerifyApprovedNoticeStatusAppearNonSuperviosr() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginNoSupervisor_QAProdStage();
		Thread.sleep(2000);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		Thread.sleep(2000);
		Boolean Approved_Notice = elementIsDisplayed(By.xpath("//div[text()='Approved']"));
		Boolean Apply_Approved_Notice = elementIsDisplayed(By.xpath("//button[text()='Apply Approved Notice']"));
		Boolean Manage_Notice = elementIsDisplayed(manageNotice);
		Assert.assertTrue(Approved_Notice, "Approved Notice is not button Appears.");
		Assert.assertTrue(Apply_Approved_Notice, "Apply Notice is not button Appears.");
		Assert.assertTrue(Manage_Notice, "Manage_Notice is not button Appears.");
	}

	public void VerifyEsclatedNoticeStatusAppearToSupervisorManager() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}
		log.loginSupervisorManager_QAProdStage();

		Thread.sleep(2000);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		CEcommonMethod.applyEsclatedNoticeCDP();
		Thread.sleep(2000);
		Boolean ApprovedApplied_Notice = elementIsDisplayed(By.xpath("//label[text()='Approved & Applied to Case']"));
		Boolean View_Notice = elementIsDisplayed(By.xpath("//a[text()='View Notice']"));
		Assert.assertTrue(ApprovedApplied_Notice, "Approved & Applied to Case is not button Appears.");
		Assert.assertTrue(View_Notice, "View Notice is not button Appears.");
	}

	public void VerifyEsclatedNoticeStatusAppearToNonSupervisorManager() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginNoSupervisor_QAProdStage();

		Thread.sleep(2000);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId1);
		Thread.sleep(2000);
		Boolean ApprovedApplied_Notice = elementIsDisplayed(By.xpath("//label[text()='Approved & Applied to Case']"));
		Boolean View_Notice = elementIsDisplayed(By.xpath("//a[text()='View Notice']"));
		Assert.assertTrue(ApprovedApplied_Notice, "Approved & Applied to Case is not button Appears.");
		Assert.assertTrue(View_Notice, "View Notice is not button Appears.");
	}

	public void VerifyRejectNoticeOutsideGroupManager() throws InterruptedException {

		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			CEcommonMethod.closeCaseDetailPage();
		}

		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginUserOutsideOfGroup_QAStageProd();

		Thread.sleep(2000);
		CEcommonMethod.createCaseWithCustomeNotices("EscalatedNotice");
		forcedWaitTime(4);
		waitUntilElementIsVisible(By.xpath("//h2[@class='case-details__case-number']"));
		String CaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		Reporter.log(CaseId +" for last test",true);
		CEcommonMethod.closeCaseDetailPage();
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginSupervisorManager_QAProdStage();

//		Thread.sleep(2000);
		forcedWaitTime(4);
		CEcommonMethod.searchCaseAndNavigateToCDP(CaseId);
		Thread.sleep(2000);

		CEcommonMethod.rejectORNotApprovedEsclatedNoticeCDP();
		Boolean NotApproved_Notice = elementIsDisplayed(By.xpath("//div[text()='Not Approved']"));
		Boolean Approve_Notice = elementIsDisplayed(By.xpath("//button[text()='Approve Notice']"));
		String noteAdded = driver
				.findElement(By.cssSelector("div.case-note-tile div:nth-child(1) div:nth-child(1) div:nth-child(1)"))
				.getText();
		Assert.assertTrue(NotApproved_Notice, "Not Approved  button is not Appears.");
		Assert.assertTrue(Approve_Notice, "Apply Notice is not button Appears.");
		Assert.assertFalse(noteAdded.isEmpty(), "Note is not added");

	}

	public void checkFlagOrNot() throws InterruptedException {
		Boolean actualFlaaged = findElementsSize(flaggedChip)>0;
		System.out.println("actualFlaaged ion cdp_utility : " + actualFlaaged);
		if (actualFlaaged.equals(true)) {
			System.out.println("enter in to change the location from flagg to unflag");
			waitForElementIsInteractable(locationDropdown);
			clickByJsExecuter(locationDropdown);
			waitUntilElementIsVisible(FlagToggle);
			forcedWaitTime(3);
			clickByJsExecuter(FlagToggle);
			sendKeysWithWait(reasonForFlagging, "UnFlagged Location");
			waitForElementIsInteractable(unFlagAddressBtn);
			forcedWaitTime(3);
			clickByJsExecuter(unFlagAddressBtn);
			forcedWaitTime(3);
			// clickByJsExecuter(locationDropdown);
			if (findElementsSize(flaggedChip)>0) {
				System.out.println("isDisplayed: " + actualFlaaged);
				actualFlaaged = false;
				System.out.println("isDisplayed Status: " + actualFlaaged);
			}

		} else {
			System.out.println("u can procced");
		}
		SoftAssert st = new SoftAssert();
		st.assertFalse(actualFlaaged);
		st.assertAll();
	}
	
	

}
