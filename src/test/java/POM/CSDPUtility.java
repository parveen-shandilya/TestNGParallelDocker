package POM;

import BrowsersBase.BrowsersInvoked;

import static POM.CSDPUtility.SubmissionAssingee;
import static POM.CitationUtility.ActiveViolationCount;
import static POM.SubmissionAssignmentUtility.*;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

public class CSDPUtility extends Helper {

		public WebDriver driver;
		LoginUtility log;
		CRMCommonMethods crmCommonMethod;
		CECommonMethods ceCommonMethod;
		SubmissionAssignmentUtility subAss;

		public CSDPUtility(WebDriver driver) {
			super(driver);
			this.driver = driver;
			log = new LoginUtility(driver);
			crmCommonMethod = new CRMCommonMethods(driver);
			ceCommonMethod = new CECommonMethods(driver);
			subAss = new SubmissionAssignmentUtility(driver);
		}


		public static By file = By.xpath("//input[@type='file']");
		public static String changeLinkDueDate = "//a[text()='Change']";
	public static String closeSDPage = "div.customer-submission-details__close-icon img";
	public static String changeDueByPopup = "//div[text()='Change Due By']";
	public static String reasonField = "//textarea[@name='reason']";
	public static String saveButton = "//button[text()='Save']";
	public static String cancelButton = "//button[text()='Cancel']";
	public static String validationMsgReason = "//textarea[@name='reason']/following::span";
	public static String dueByDatepicker = "//input[@name='dueBy']";
	public static String updateDueDate = "//td[@class='rdtDay rdtActive']/following::td[1]";
	public static String updateDueDates = "//td[@class='rdtDay rdtActive rdtToday']/following::td[1]";
	public static String changedDueDate = "//label[text()='Due By']/following::label[1]";
	public static String internalNotesContent = "//div[@class='internal-note-tile-content__content']";
	public static String internalNotesContent2 = "(//div[@class='internal-note-tile-content__content'])[2]";
	public static String escalateIssueToggle = "(//div[@class='react-toggle-thumb'])[1]";
	public static String customerNameLink = "//label[text()='Customer Name']/following::a[1]";
	public static String coDPHeader = "//div[@class='contact-details__header__main']/h2[1]";
	public static String closeIconCoDP = "//div[@class='contact-details__header__close-icon']/img";
	public static String tagsLink = "//span[@class='clipped-text']/a";
	public static String cSLPHeader = "(//label[@class='dropdown__selector__label'])[1]";
	public static String imageIconCSDP = "//div[@id='cs-attachments']//button";
	public static String internalNotesIcon = "//div[@id='cs-notes']//button[@class='compose-note-icon btn btn-primary']";
	public static String addInternalNotePopup = "//div[text()='Add Internal Comment']";
	public static String createNoteButton = "//button[text()='Create Comment']";
	public static String internalNoteValidation = "//div[@class='notes']//span";
	public static String internalNoteField = "//textarea[@name='internalComment']";
	public static String editNoteIcon = "//button[@class='edit-btn internal-note-tile-content__actions__edit btn btn-primary']";
	public static String editInternalNotePopup = "//div[text()='Edit Internal Comment']";

	public static By ChangeLinkDueDate = By.xpath(changeLinkDueDate);
	public static By CloseSDPage = By.cssSelector(closeSDPage);
	public static By ChangeDueByPopup = By.xpath(changeDueByPopup);
	public static By ReasonField = By.xpath(reasonField);
	public static By SaveButton = By.xpath(saveButton);
	public static By ValidationMsgReason = By.xpath(validationMsgReason);
	public static By DueByDatepicker = By.xpath(dueByDatepicker);
	public static By UpdateDueDate = By.xpath(updateDueDate);
	public static By UpdateDueDates = By.xpath(updateDueDates);
	public static By ChangedDueDate = By.xpath(changedDueDate);
	public static By InternalNotesContent = By.xpath(internalNotesContent);
	public static By InternalNotesContent2 = By.xpath(internalNotesContent2);
	public static By EscalateIssueToggle = By.xpath(escalateIssueToggle);
	public static By CustomerNameLink = By.xpath(customerNameLink);
	public static By CoDPHeader = By.xpath(coDPHeader);
	public static By CloseIconCoDP = By.xpath(closeIconCoDP);
	public static By TagsLink = By.xpath(tagsLink);
	public static By CSLPHeader = By.xpath(cSLPHeader);
	public static By ImageIconCSDP = By.xpath(imageIconCSDP);
	public static By InternalNotesIcon = By.xpath(internalNotesIcon);
	public static By AddInternalNotePopup = By.xpath(addInternalNotePopup);
	public static By CreateNoteButton = By.xpath(createNoteButton);
	public static By InternalNoteValidation = By.xpath(internalNoteValidation);
	public static By InternalNoteField = By.xpath(internalNoteField);
	public static By EditNoteIcon = By.xpath(editNoteIcon);
	public static By EditInternalNotePopup = By.xpath(editInternalNotePopup);

	public static By AddedCustomerName = By.xpath("//label[text()='Customer Name']/following-sibling::label");
	public static By PrintButton = By.xpath("//button[text()='Print']");
	public static By PrintSettingsPopup = By.xpath("//div[text()='Print Settings']");
	public static By PrintButtonPSP = By.xpath("//div[text()='Print Settings']/following::button[text()='Print']");
	public static By PrintPageSubmissionID = By.xpath("//h2[@class='customer-submission-print-details__number']");
	public static By CSDPSubmissionID = By.xpath("//h2[@class='customer-submission-details__number']");
	public static By ManageTagsButton = By.xpath("//button[text()='Manage Tags']");
	public static By ManageTagsPopup = By.xpath("//div[text()='Manage Tags']");
	public static By EnterTagsField = By.xpath("//input[@name='tags-input']");
	public static By SaveButtonTags = By.xpath("//input[@name='tags-input']/following::button[2]");
	public static By TagsSuccessMessage = By.xpath("//div[@class='success-custom-message']/span");
	public static By TasksIcon = By.xpath("//p[text()='Tasks']/..//button");
	public static By AddATaskPopup = By.xpath("//div[text()='Add a Task']");
	public static By TaskNameField = By.xpath("//input[@name='name']");
	public static By TaskAssigneeDropdown = By.xpath("//label[@for='assigneeId']/following::span[1]");
	public static By TaskAssigneeOption = By.xpath("//label[@for='assigneeId']/following::ul/li[1]");
	public static By AddTaskButton = By.xpath("//button[text()='Add Task']");
	public static By AddedTaskName = By.xpath("//div[@class='tasks-table']//div[@class='rt-td'][2]/div");
	public static By EditTaskIcon = By
			.xpath("//button[@class='edit-btn edit-task-content__actions__edit space-right btn btn-primary']");
	public static By EditATaskPopup = By.xpath("//div[text()='Edit a Task']");
	public static By SaveButtonTask = By.xpath("//div[text()='Edit a Task']/following::button[2]");
	public static By TaskSectionIcon = By.xpath("//div[@class='cs-tasks__header']//button");
	public static By DeleteTaskIcon = By.xpath("//button[@class='delete-btn space-right btn btn-primary']");
	public static By TasksCountAtHeader = By.xpath("//div[@class='cs-tasks__header']/h2");
	public static By TaskCoulumns = By.xpath("//div[@class='rt-tr -odd']");
	public static By MoreButtonCSDP = By.xpath("//button[text()='More...']");
	public static By CloseSubmissionOption = By.xpath("//li[text()='Close Submission']");
	public static By YesCloseButton = By.xpath("//button[text()='Yes, Close']");
	public static By SubmissionStatus = By.xpath("//h2[@class='customer-submission-details__status']");
	public static By ReopenSubmissionOption = By.xpath("//li[text()='Reopen Submission']");
	public static By YesReopenButton = By.xpath("//button[text()='Yes, Reopen']");
	public static By YesDeleteButton = By.xpath("//button[text()='Yes, Delete']");
	public static By PossibleDuplicateSubmissionsPopup = By.xpath("//h2[text()='Possible Duplicate Submissions']");
	public static By SubmitAnywayButton = By.xpath("//button[text()='Submit Anyway']");
	public static By SubmissionAssingee = By.xpath("(//div[@class='dropdown__selector__selected']//label)[4]");
	public static By SubmissionAssingeeOpts = By
			.xpath("//div[@id='assignee']//ul[@class='dropdown__options--single']//li[@class='option']");
	public static By submissionAssigneeSearch = By
			.xpath("//div[@id='assignee']//input[@name='query'][@placeholder='Search...']");
	public static By SubmissionAssingeeOpt = By.cssSelector("div#assignee ul li");
	public static By SubmissionCollaborator = By.xpath("(//div[@class='dropdown__selector__selected']//label)[2]");
	public static By CollaboratorSearch = By
			.xpath("//div[@id='collaboratorIds']//input[@name='query'][@placeholder='Search...']");
	public static By CollaboratorOpt = By.cssSelector("div#collaboratorIds ul li");
	public static By collaboratorOption1 = By
			.xpath("(//div[@id='collaboratorIds']//ul[@class='dropdown__options--single']//li[@class='option'])[1]");
	public static By emailTile = By.xpath("//div[@id='cs-emails']//h2");
	public static By emailMoreLnkTxt = By
			.xpath("(//div[@class='email-item__body']//a[@class='clip-text'][text()='more'])[1]");
	public static By selectEmailTempDropdown = By.xpath("(//div[@class='email-item__content__info'])[2]");
	public static By emailBodyParaGraph = By.xpath("//div[@class='email-item__body']//span[@class='clipped-text']//p");
	public static By mailSubject = By.xpath("//input[@name='subject']");
	public static By sendmailReply = By
			.xpath("//div[@class='email-form__footer__form-actions']//button[text()='Send']");
	public static By mailReplyFrame = By.xpath("//iframe[@id='email-tile-html-editor-form_ifr']");
	public static By mailreplyMsz = By.xpath("//body[@id='tinymce']//p");
	public static By mailedSubject = By.xpath("(//div[@class='email-item__content']//h4)[2]");
	public static By attachmentDefaultbtn = By.xpath("(//button[@class='attach-btn btn btn-primary'])[1]");
	public static By attachmentCount = By.xpath("//div[@class='icon-count attachment-count']");
	public static By emailLessLnkTxt = By
			.xpath("(//div[@class='email-item__body']//a[@class='clip-text'][contains(text(),'less')])[1]");

    public static By resolutionTime = By.xpath("//input[@placeholder='Enter Number']");
    public static By caseHeader = By.xpath("//div[@class='customer-submission-details__header__creation']");
	public static By dueDate =By.xpath("//label[normalize-space()='Due By']/..//label[@class='field__label-data-field']");
     public static By caseHeaderCDP = By.xpath("//div[@class='case-details__header__creation']");

	public static String category  ;
	public static String getYopMailSubject(int index) {
		return "(//div[@class='m'])[" + index + "]//div[@class='lms']";
	}
  public static String editIconCategoryCDP  = "//div[text()='%s']/..//button";
	public static String RandomReason;
	public static String Characters500 = PropertiesUtils.getPropertyValue("Characters500");;
	public static String RandomReason2;
	public static String RandomTaskName;
	public static String StatusOfSubmission;
	public static String PopupTitleChangeDueBy;
	public static String ReasonValidationMsg;
	public static String ValidationMsgMaxChar;
	public static String InternalNotes;
	public static String ValidationMsgCharLimit;
	public static boolean EscalateToggleStatus;
	public static String InternalNotes2;
	public static String CustomerName;
	public static String CustomerDetailHeader;
	public static boolean CheckImageSize;
	public static String InternalNotePopupTitle;
	public static String EditNotePopupTitle;
	public static String EditedNotes;
	public static String PrintSettingsPopupTitle;
	public static String PrintPageSubmissionHeader;
	public static String CSDPSubmissionHeader;
	public static String ManageTagsPopupTitle;
	public static String SuccessMessageTags;
	public static String ExpectedSuccessMsg;
	public static String AddTaskPopupTitle;
	public static String AddedTaskText;
	public static String EditTaskPopupTitle;
	public static String AddedTaskText2;
	public static boolean TasksCount;
	public static String ClosedStatusOfSubmission;
	public static String OpenedStatusOfSubmission;
	public static String RandomEditedNote;
	public static String AgencyLoggedInUserName;

	public static By editButtonCSDP = By.xpath("//div[@class='category-custom-field-tile__header']//button");
	public static By whiteDropDownCSDP = By.xpath("(//div[@class='Select-placeholder'])");
	public static String lightwhiteOptionCSDP = ("(//div[text()='%s'])");

   public static String submissionNumber = "//a[text()='%s']";
	public static By categoryDropDownLabelCSDP = By.xpath("(//div[@class='dropdown__selector__selected']//label)[1]");
	public static By printButton = By.xpath("(//button[normalize-space()='Print'])[1]");
	public static By internalCustomFieldAddFieldLink = By.xpath("(//a[text()='Add Field'])[2]");

	public static By internalCustomFieldTileOnCSDP = By.xpath("//div[@class='category-custom-fields-section']//h4");

	public static By customFieldTileOnCSDP = By.xpath("//div[@class='category-custom-fields-section']//h4");
	public static By internalCustom2FieldTileOnCSDP = By.xpath("(//div[@class='category-custom-fields-section']//h4)[2]");

	public static By dropDownListFistOptCSDP = By.xpath("//div[@class='dropdown__list']//ul//li");
	public static By changeCategoryPopupHeader = By.xpath("//div[text()='Change Category']");
	public static String dropDownOption = "//li[normalize-space()='%s']";

	public static By cascadingFieldCategoryPopup = By.xpath("//input[@placeholder='Enter Text']");

	public static String reassignmentsOptions = "((//div[@class='option-radio-button-styles align-category-modal'])//span)[%s]";

	public static By radioButton = By.xpath("//input[@class='option-radio-input-styles']");
	
	public static String tabParent =  "//label[text()='%s']";
	public static String tabChild = "//label[text()='%s']//following-sibling::div//label[text()='%s']";
	
	public static String submissionId ;
	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}


	public String getSelectedCollaboratorXPath(int index) {
		return "(//div[@id='collaboratorIds']//ul[@class='dropdown__options--single']//li[@class='option selected'])["
				+ index + "]";
	}

	public void CSDP_OpenCSDPAfterSubmissionCreation() throws InterruptedException {
		waitUntilElementIsVisible(LoginAgencyUtility.AgencyLoggedInUsername);
		AgencyLoggedInUserName = getTextElement(LoginAgencyUtility.AgencyLoggedInUsername);
		category = "Location Required";
		crmCommonMethod.createSubmission("No", "Yes", "Yes", "Yes", "Yes", category);
		Thread.sleep(5000);
		waitUntilElementIsVisible(CSPInternalUtility.SubmisionStatus);
		StatusOfSubmission = getTextElement(CSPInternalUtility.SubmisionStatus);
       submissionId = getTextElement(By.xpath("//h2[@class='customer-submission-details__number']")).split("#")[1];

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(StatusOfSubmission.equals("Open"));
		softAssert.assertAll();
	}

	public void CSDP_ChangeDueByDate() throws InterruptedException {
		waitForElementIsInteractable(ChangeLinkDueDate);
		forcedWaitTime(3);
		clickByJsExecuter(ChangeLinkDueDate);
		waitUntilElementIsVisible(ChangeDueByPopup);
		PopupTitleChangeDueBy = getTextElement(ChangeDueByPopup);
		clickOn(SaveButton);
		waitUntilElementIsVisible(ValidationMsgReason);
		ReasonValidationMsg = getTextElement(ValidationMsgReason);
		sendKeysWithWait(ReasonField, Characters500);
		clickOn(SaveButton);
		waitUntilElementIsVisible(ValidationMsgReason);
		ValidationMsgMaxChar = getTextElement(ValidationMsgReason);
		WebElement ReasonFieldWE = waitUntilVisibleWE(ReasonField);
		ReasonFieldWE.clear();
		RandomReason = RandomStrings.requiredString(50);
		sendKeysWithWait(ReasonField, RandomReason);
		clickOn(DueByDatepicker);
		waitForElementIsInteractable(UpdateDueDate);
		clickOn(UpdateDueDate);
		waitForElementIsInteractable(SaveButton);
		clickOn(SaveButton);
		waitForCurserRunning(2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PopupTitleChangeDueBy.equals("Change Due By"));
		softAssert.assertTrue(ReasonValidationMsg.equals("The Reason is required."));
		softAssert.assertTrue(ValidationMsgMaxChar.equals("Min 1 and Max 500 characters limit."));
		softAssert.assertAll();
	}

	public void CSDP_VerifyInternalNotesContent() throws InterruptedException {
		forcedWaitTime(3);
		InternalNotes = getTextElement(InternalNotesContent);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(InternalNotes.equals(RandomReason));
		softAssert.assertAll();
	}

	public void CSDP_VerifyEscalatedIssue() throws InterruptedException {
		clickByJsExecuter(EscalateIssueToggle);
		RandomReason2 = RandomStrings.requiredString(50);
		sendKeysWithWait(ReasonField, Characters500);
		clickOn(SaveButton);
		waitUntilElementIsVisible(ValidationMsgReason);
		ValidationMsgCharLimit = getTextElement(ValidationMsgReason);
		WebElement ReasonFieldWE = waitUntilVisibleWE(ReasonField);
		ReasonFieldWE.clear();
		sendKeysWithWait(ReasonField, RandomReason2);
		clickOn(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(EscalateIssueToggle);
		WebElement EscalateToggle = waitUntilVisibleWE(EscalateIssueToggle);
		EscalateToggleStatus = EscalateToggle.isEnabled();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ValidationMsgCharLimit.equals("500 character limit."));
		softAssert.assertTrue(EscalateToggleStatus);
		softAssert.assertAll();
	}

	public void CSDP_VerifyReasonWithInternalNotes() throws InterruptedException {
		waitUntilElementIsVisible(InternalNotesContent2);
		InternalNotes2 = getTextElement(InternalNotesContent2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(InternalNotes2.equals(RandomReason2));
		softAssert.assertAll();
	}

	public void CSDP_VerifyNoEscalationOnCancel() throws InterruptedException {
		waitUntilElementIsVisible(EscalateIssueToggle);
		waitForElementIsInteractable(EscalateIssueToggle);
		clickByJsExecuter(EscalateIssueToggle);
		waitForElementIsInteractable(ReasonField);
		sendKeysWithWait(ReasonField, RandomReason2);
		waitUntilElementIsVisible(CSPInternalUtility.CancelButton);
		forcedWaitTime(3);
		waitForElementIsInteractable(CSPInternalUtility.CancelButton);
		clickByJsExecuter(CSPInternalUtility.CancelButton);
		waitUntilElementInvisibleLocated(CSPInternalUtility.CancelButton);
		WebElement EscalateToggle = waitUntilVisibleWE(EscalateIssueToggle);
		EscalateToggleStatus = EscalateToggle.isEnabled();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(EscalateToggleStatus);
		softAssert.assertAll();
	}

	public void CSDP_VerifyDirectionToCoDP() throws InterruptedException {
		waitUntilElementIsVisible(CustomerNameLink);
		CustomerName = getTextElement(CustomerNameLink);
		waitUntilElementIsVisible(CustomerNameLink);
		waitForElementIsInteractable(CustomerNameLink);
		clickByJsExecuter(CustomerNameLink);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CoDPHeader);
		CustomerDetailHeader = getTextElement(CoDPHeader);
		waitUntilElementIsVisible(CloseIconCoDP);
		waitForElementIsInteractable(CloseIconCoDP);
		clickOn(CloseIconCoDP);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(TagsLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CustomerName.equals(CustomerDetailHeader));
		softAssert.assertAll();

	}

	public void CSDP_VerifyDirectionToCSLPFromTags() throws InterruptedException {
		waitUntilElementIsVisible(TagsLink);
		waitForElementIsInteractable(TagsLink);
		clickByJsExecuter(TagsLink);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(CSLPHeader);
		CustomerDetailHeader = getTextElement(CSLPHeader);
		driver.navigate().back();
		waitForCurserRunning(2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CustomerDetailHeader.equals("Customer Submissions:"));
		softAssert.assertAll();
	}

	public void CSDP_VerifyAddedAttachments() throws InterruptedException {
		waitUntilElementIsVisible(ImageIconCSDP);
		waitForElementIsInteractable(ImageIconCSDP);
		clickByJsExecuter(ImageIconCSDP);
		forcedWaitTime(2);
		waitUntilElementIsVisible(By.cssSelector("div.modal-header > button[aria-label='Close']"));
		forcedWaitTime(3);
		
//		waitUntilElementClickable(UploadFile2);
		ceCommonMethod.uploadAttachment(ceCommonMethod.SetTestDataFilePath("cow.jpg"));
		waitForCurserRunning(3);
		waitForElementIsInteractable(CSPInternalUtility.AddButton);
		forcedWaitTime(2);
		clickOn(CSPInternalUtility.AddButton);
		List<WebElement> CountAttachments = driver.findElements(CSPInternalUtility.ImageThumb);
		int ImgSize = CountAttachments.size();
		CheckImageSize = ImgSize >= 1;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CheckImageSize);
		softAssert.assertAll();
	}

	public void CSDP_VerifyAddedInternalNote() throws InterruptedException {
		waitUntilElementIsVisible(InternalNotesIcon);
		waitUntilElementPresent(InternalNotesIcon);
		scrollIntoView(InternalNotesIcon);
		waitForElementIsInteractable(InternalNotesIcon);
		clickByJsExecuter(InternalNotesIcon);
		waitUntilElementIsVisible(AddInternalNotePopup);
		InternalNotePopupTitle = getTextElement(AddInternalNotePopup);
		String AllChar5000 = "abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc d. ";
		sendKeysWithWait(InternalNoteField, AllChar5000);
		waitForElementIsInteractable(CreateNoteButton);
		clickByJsExecuter(CreateNoteButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(InternalNoteField);
		WebElement InternalNoteFieldWE = findElement(InternalNoteField);
		waitForElementIsInteractable(InternalNoteField);
		InternalNoteFieldWE.clear();
		String RandomNote = "Internal Note " + RandomStrings.requiredString(40);
		waitForElementIsInteractable(InternalNoteField);
		sendKeysWithWait(InternalNoteField, RandomNote);
		clickOn(CreateNoteButton);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(EditNoteIcon);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(InternalNotePopupTitle.equals("Add Internal Comment"));
		softAssert.assertAll();
	}

	public void CSDP_VerifyUpdatedNote() throws InterruptedException {

		waitUntilElementIsVisible(EditNoteIcon);
		waitForElementIsInteractable(EditNoteIcon);
		clickByJsExecuter(EditNoteIcon);
		waitUntilElementIsVisible(EditInternalNotePopup);
		waitForElementIsInteractable(InternalNoteField);
		EditNotePopupTitle = getTextElement(EditInternalNotePopup);
		WebElement InternalNoteFieldWE = waitUntilVisibleWE(InternalNoteField);
		InternalNoteFieldWE.clear();
		String RandomNote = "***Edited*** Internal Note " + RandomStrings.requiredString(5).trim();
		RandomEditedNote = RandomNote;
		sendKeysWithWait(InternalNoteField, RandomNote);
		waitForElementIsInteractable(SaveButton);
		Thread.sleep(2000);
		//waitForElementIsInteractable(SaveButton);
		clickByJsExecuter(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(InternalNotesContent);
		waitUntilElementPresent(InternalNotesContent);
		scrollIntoView(InternalNotesContent);
		EditedNotes = getTextElement(InternalNotesContent);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(EditNotePopupTitle, "Edit Internal Comment");
		softAssert.assertEquals(EditedNotes, RandomEditedNote);
		softAssert.assertAll();
	}

	public void CSDP_VerifyUserIsAbleToPrintCSD() throws InterruptedException {
		CSDPSubmissionHeader = getTextElement(CSDPSubmissionID);
		waitUntilElementIsVisible(PrintButton);
		waitUntilElementPresent(PrintButton);
		waitForElementIsInteractable(PrintButton);
		Thread.sleep(2000);
		scrollIntoView(PrintButton);
		//Thread.sleep(2000);
		//clickByJsExecuter(PrintButton);
		clickOn(PrintButton);
//	movetoElementAndClick(printButton);
		//moveToWebElementAndClick(printButton);
		waitUntilElementIsVisible(PrintSettingsPopup);
		waitForElementIsInteractable(PrintSettingsPopup);
		PrintSettingsPopupTitle = getTextElement(PrintSettingsPopup);
		System.out.println("PrintSettingsPopupTitle: -> "+ PrintSettingsPopupTitle);

		waitForElementIsInteractable(PrintButtonPSP);
		moveToElement(PrintButtonPSP);
		clickByJsExecuter(PrintButtonPSP);
		//clickOn(PrintButtonPSP);
		waitForCurserRunning(4);
		Thread.sleep(7000);
		//forcedWaitTime(4);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		waitForPageLoadTime(5);

		Thread.sleep(7000);
		try{

			waitUntilElementIsVisible(PrintPageSubmissionID);
            waitUntilElementPresent(PrintPageSubmissionID);
			PrintPageSubmissionHeader = getTextElement(PrintPageSubmissionID);
			System.out.println("PrintPageSubmissionHeader: -> "+ PrintPageSubmissionHeader);
			Thread.sleep(3000);
			driver.switchTo().window(currentWindow);

		}catch(Exception e){
			System.out.println("in catch ...");
			waitUntilElementIsVisible(PrintPageSubmissionID);

			PrintPageSubmissionHeader = getTextElement(PrintPageSubmissionID);
			System.out.println("PrintPageSubmissionHeader: -> "+ PrintPageSubmissionHeader);
			Thread.sleep(3000);
			driver.switchTo().window(currentWindow);
		}
//		waitUntilElementIsVisible(PrintPageSubmissionID);
//
//		PrintPageSubmissionHeader = getTextElement(PrintPageSubmissionID);
//		System.out.println("PrintPageSubmissionHeader: -> "+ PrintPageSubmissionHeader);
//		Thread.sleep(3000);
//		driver.switchTo().window(currentWindow);



		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PrintSettingsPopupTitle.equals("Print Settings"));
		softAssert.assertTrue(PrintPageSubmissionHeader.equals(CSDPSubmissionHeader));
		softAssert.assertAll();
	}

	public void CSDP_VerifyMultipleTagsAddition() throws InterruptedException {
		waitForElementIsInteractable(ManageTagsButton);
		clickByJsExecuter(ManageTagsButton);
		waitUntilElementIsVisible(ManageTagsPopup);

		ManageTagsPopupTitle = getTextElement(ManageTagsPopup);
		for (int i = 0; i < 3; i++) {
			String RandomTags = RandomStrings.requiredCharacters(4) + ",";
			sendKeysWithWait(EnterTagsField, RandomTags);
		}
		clickByJsExecuter(SaveButtonTags);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(TagsSuccessMessage);
		SuccessMessageTags = getTextByJSExecutor(TagsSuccessMessage);
		waitUntilElementIsInvisible(TagsSuccessMessage);

		ExpectedSuccessMsg = "Tags saved successfully";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ManageTagsPopupTitle.equals("Manage Tags"));
		softAssert.assertEquals(SuccessMessageTags, ExpectedSuccessMsg);
		softAssert.assertAll();
	}

	public void CSDP_VerifyAdditionOfTasks() throws InterruptedException {
		scrolltoPageTop();
		waitUntilElementIsVisible(TasksIcon);
		Thread.sleep(3000);
		waitForElementIsInteractable(AddATaskPopup);
		clickOn(TasksIcon);
		waitUntilElementIsVisible(AddATaskPopup);
		AddTaskPopupTitle = getTextElement(AddATaskPopup);
		RandomTaskName = RandomStrings.requiredCharacters(8);
		sendKeysWithWait(TaskNameField, RandomTaskName);
		clickOn(TaskAssigneeDropdown);
		waitUntilElementIsVisible(TaskAssigneeOption);
		waitForElementIsInteractable(TaskAssigneeOption);
		clickOn(TaskAssigneeOption);
		waitUntilElementIsVisible(AddTaskButton);
		clickOn(AddTaskButton);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(AddedTaskName);
		AddedTaskText = getTextElement(AddedTaskName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(AddTaskPopupTitle.equals("Add a Task"));
		softAssert.assertEquals(AddedTaskText, RandomTaskName);
		softAssert.assertAll();
	}

	public void CSDP_VerifyUpdationAndDeletionOfTasks() throws InterruptedException {
		scrolltoUpCustom(0, driver.findElement(EditTaskIcon).getRect().getY() + 50);
		scrollIntoView(EditTaskIcon);
		waitForElementIsInteractable(EditTaskIcon);

		clickByJsExecuter(EditTaskIcon);
		EditTaskPopupTitle = getTextElement(EditATaskPopup);
		waitForElementIsInteractable(TaskNameField);
		sendKeysWithWait(TaskNameField, " Edited");
		waitForElementIsInteractable(SaveButtonTask);
		clickByJsExecuter(SaveButtonTask);
		waitForCurserRunning(4);

		waitForElementIsInteractable(TaskSectionIcon);
		waitUntilElementIsVisible(AddedTaskName);
		AddedTaskText2 = getTextElement(AddedTaskName);
		clickByJsExecuter(TaskSectionIcon);
		sendKeysWithWait(TaskNameField, "TaskToDelete");
		clickByJsExecuter(TaskAssigneeDropdown);
		clickByJsExecuter(TaskAssigneeOption);
		waitUntilElementIsVisible(AddTaskButton);
		clickByJsExecuter(AddTaskButton);
		waitUntilElementIsVisible(DeleteTaskIcon);
		waitUntilElementPresent(DeleteTaskIcon);
		waitForElementIsInteractable(DeleteTaskIcon);
		try {
			clickByJsExecuter(DeleteTaskIcon);
		}catch (Exception e){
			System.out.println("in catch of deletion of tasks");
			clickOn(DeleteTaskIcon);
		}


		waitUntilElementIsVisible(YesDeleteButton);
		waitUntilElementPresent(YesDeleteButton);
		waitForElementIsInteractable(YesDeleteButton);
		clickByJsExecuter(YesDeleteButton);
		waitUntilElementInvisibleLocated(YesDeleteButton);
		waitForPresenceandVisiblity(TaskCoulumns);
		List<WebElement> CountTasks = driver.findElements(TaskCoulumns);
		TasksCount = CountTasks.size() == 1;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(EditTaskPopupTitle.equals("Edit a Task"));
		softAssert.assertTrue(TasksCount);
		softAssert.assertAll();
	}

	public void CSDP_VerifyClosedSubmission() throws InterruptedException {
		try{
			waitUntilElementIsVisible(MoreButtonCSDP);
			waitForElementIsInteractable(MoreButtonCSDP);
			scrollIntoView(MoreButtonCSDP);
			clickOn(MoreButtonCSDP);
			waitForElementIsInteractable(CloseSubmissionOption);
			clickOn(CloseSubmissionOption);
			waitUntilElementIsVisible(YesCloseButton);
			waitUntilElementPresent(YesCloseButton);
			clickOn(YesCloseButton);
			waitUntilElementInvisibleLocated(YesCloseButton);
			waitForCurserRunning(4);
			forcedWaitTime(4);
			waitUntilElementIsVisible(SubmissionStatus);
			ClosedStatusOfSubmission = getTextElement(SubmissionStatus);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(AddedTaskText2, RandomTaskName + " Edited");
			softAssert.assertTrue(ClosedStatusOfSubmission.equals("Closed"));
			softAssert.assertAll();
		}catch (Exception e){
			System.out.println("In catch ..");
			waitUntilElementIsVisible(MoreButtonCSDP);
			waitForElementIsInteractable(MoreButtonCSDP);
			scrollIntoView(MoreButtonCSDP);
			clickByJsExecuter(MoreButtonCSDP);
			waitForElementIsInteractable(CloseSubmissionOption);
			clickByJsExecuter(CloseSubmissionOption);
			waitUntilElementIsVisible(YesCloseButton);
			waitUntilElementPresent(YesCloseButton);
			clickByJsExecuter(YesCloseButton);
			waitUntilElementInvisibleLocated(YesCloseButton);
			waitForCurserRunning(4);
			forcedWaitTime(4);
			waitUntilElementIsVisible(SubmissionStatus);
			ClosedStatusOfSubmission = getTextElement(SubmissionStatus);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(AddedTaskText2, RandomTaskName + " Edited");
			softAssert.assertTrue(ClosedStatusOfSubmission.equals("Closed"));
			softAssert.assertAll();

		}
	}

	public void CSDP_VerifyReopenedSubmission() throws InterruptedException {
		try {
			waitUntilElementIsVisible(MoreButtonCSDP);
			waitUntilElementPresent(MoreButtonCSDP);
			waitForElementIsInteractable(MoreButtonCSDP);
			clickOn(MoreButtonCSDP);
			waitForElementIsInteractable(ReopenSubmissionOption);
			clickOn(ReopenSubmissionOption);
			waitUntilElementIsVisible(YesReopenButton);
			clickOn(YesReopenButton);
			waitUntilElementInvisibleLocated(YesReopenButton);
			waitForCurserRunning(4);
			waitUntilElementIsVisible(SubmissionStatus);
			OpenedStatusOfSubmission = getTextElement(SubmissionStatus);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(OpenedStatusOfSubmission.equals("Open"));
			softAssert.assertAll();
		}catch (Exception e){
			System.out.println("In catch of CSDP_verifyReopened");
			waitUntilElementIsVisible(MoreButtonCSDP);
			waitUntilElementPresent(MoreButtonCSDP);
			waitForElementIsInteractable(MoreButtonCSDP);
			clickByJsExecuter(MoreButtonCSDP);
			waitForElementIsInteractable(ReopenSubmissionOption);
			clickByJsExecuter(ReopenSubmissionOption);
			waitUntilElementIsVisible(YesReopenButton);
			clickByJsExecuter(YesReopenButton);
			waitUntilElementInvisibleLocated(YesReopenButton);
			waitForCurserRunning(4);
			waitUntilElementIsVisible(SubmissionStatus);
			OpenedStatusOfSubmission = getTextElement(SubmissionStatus);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(OpenedStatusOfSubmission.equals("Open"));
			softAssert.assertAll();
		}
	}

	public boolean DefaultAssingee;
	public boolean AssingeeOptions;
	public boolean readOnlyUser;
	public boolean UpdatedAssingee;

	public void CSDP_VerifySubmissionAssignee() throws InterruptedException {

		crmCommonMethod.closeSubmissionDetailPage();
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToAssignmentRules();
		crmCommonMethod.editSubmissionAssignmentRule();
		ceCommonMethod.deleteRules(0);
		ceCommonMethod.addCustomCategorySubmissionRule("Other");
		//crmCommonMethod.createSubmission("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
		crmCommonMethod.createSubmissionPreRequisite("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
		waitForCurserRunning(5);
		//waitUntilElementIsVisible(SubmissionAssingee);
		waitUntilElementIsVisible(SubmissionAssingee);
		scrollIntoView(SubmissionAssingee);
		String expectedDefaultAssingee = getTextElement(SubmissionAssingee);
		DefaultAssingee = expectedDefaultAssingee.equalsIgnoreCase("Unassigned");
		waitForElementIsInteractable(SubmissionAssingee);
		clickOn(SubmissionAssingee);
		waitUntilElementIsVisible(SubmissionAssingeeOpts);
		AssingeeOptions = elementIsDisplayed(SubmissionAssingeeOpts);
		List<String> assineeOptionVal = new ArrayList<>();
		driver.findElements(SubmissionAssingeeOpts).stream().forEach(x -> assineeOptionVal.add(x.getText()));
		readOnlyUser = assineeOptionVal.contains("Read Only User");
		waitUntilElementIsVisible(submissionAssigneeSearch);
		waitForElementIsInteractable(submissionAssigneeSearch);

		sendKeysWithWait(submissionAssigneeSearch, AgencyLoggedInUserName);
		forcedWaitTime(4);
		Thread.sleep(3000);
		waitUntilElementIsVisible(SubmissionAssingeeOpt);
		//waitForElementIsInteractable(SubmissionAssingeeOpt);
		movetoElementAndClick(SubmissionAssingeeOpt);
	  //  clickByJsExecuter(SubmissionAssingeeOpt);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(SubmissionAssingee);
		String expectedUpdatedAssingee = getTextElement(SubmissionAssingee);
		UpdatedAssingee = expectedUpdatedAssingee.equalsIgnoreCase(AgencyLoggedInUserName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(DefaultAssingee, "Default assignee must be unassigned");
		softAssert.assertTrue(AssingeeOptions, "Assinee options should display.");
		softAssert.assertFalse(readOnlyUser, "Read Only User must not be present in the list.");
		softAssert.assertTrue(UpdatedAssingee, "Updated Assingee.");
		softAssert.assertAll();
	}
	public void cascadingAssignmentRule() throws InterruptedException{

		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToAssignmentRules();
		subAss.waitUntilElementIsVisible(EditAssignmentIcon);
		subAss.waitForElementIsInteractable(EditAssignmentIcon);
		subAss.clickByJsExecuter(EditAssignmentIcon);
		subAss.waitForElementIsInteractable(AddRuleButton);
		subAss.clickByJsExecuter(AddRuleButton);
		subAss.waitForElementIsInteractable(CriteriaFields);
		subAss.clickByJsExecuter(CriteriaFields);
		subAss.waitUntilElementIsVisible(customCategoryFieldTab);
		subAss.clickByJsExecuter(customCategoryFieldTab);
		subAss.scrollIntoView(cascadingCategoryOption2);

		subAss.waitUntilElementIsVisible(By.xpath(subAss.selectorFormate(cascadingCategoryOption,"CascadingCategory")));
		subAss.scrollIntoView(cascadingCategoryOption2);
		subAss.clickOn(By.xpath(subAss.selectorFormate(cascadingCategoryOption,"CascadingCategory")));
		subAss.waitUntilElementIsVisible(customFiled1);
		subAss.clickByJsExecuter(customFiled1);
		subAss.waitUntilElementIsVisible(CriteriaFields2);
		subAss.clickOn(CriteriaFields2);
		subAss.waitForElementIsInteractable(By.xpath(getSubmissionAttributeOperator("Contains")));

		subAss.waitUntilElementIsVisible(By.xpath(getSubmissionAttributeOperator("Contains")));
		subAss.clickOn(By.xpath(getSubmissionAttributeOperator("Contains")));
		subAss.waitUntilElementIsVisible(CriteriaFields);
		subAss.clickOn(CriteriaFields);
		subAss.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute("color1")));
		subAss.scrollIntoView(By.xpath(getSubmissionAttribute("color1")));
		subAss.clickOn(By.xpath(getSubmissionAttribute("color1")));

		if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			ceCommonMethod.addAssignee("Mark Shane","Amandeep Singh1");
		}
		if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			ceCommonMethod.addAssignee("Amandeep","Amandeep Singh1");
		}
		if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			ceCommonMethod.addAssignee("Shane ES","Amandeep Singh1");
		}
		subAss.waitForElementIsInteractable(CreateRulebutton);
		subAss.clickOn(CreateRulebutton);
		subAss.waitUntilElementInvisibleLocated(CreateRulebutton);

		subAss.clickOn(SaveButton);
		subAss.waitForCurserRunning(10);
	}
	public boolean DefaultCollaborator;
	public boolean UpdatedCollaborator;

	public void CSDP_VerifySubmissionCollaborator() throws InterruptedException {
//		navigatePage("https://app-qa.comcateprime.com/agencies/1331/products/customer-submission/174878");
		waitUntilElementIsVisible(SubmissionCollaborator);
		scrollIntoView(SubmissionCollaborator);
		String expectedDefaultcol = getTextElement(SubmissionCollaborator);
		DefaultCollaborator = expectedDefaultcol.equalsIgnoreCase("None");
		waitForElementIsInteractable(SubmissionCollaborator);
		clickByJsExecuter(SubmissionCollaborator);
		waitUntilElementIsVisible(CollaboratorSearch);
		waitForElementIsInteractable(CollaboratorSearch);
		sendKeysWithWait(CollaboratorSearch, "Amandeep Singh1");
		waitUntilElementIsVisible(CollaboratorOpt);
		Thread.sleep(3000);
		clickOn(CollaboratorOpt);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(SubmissionCollaborator);
		scrollIntoView(SubmissionCollaborator);
		String actualDefaultcol = getTextElement(SubmissionCollaborator);
		System.out.println("actualDefaultCol:  "+actualDefaultcol);
		UpdatedCollaborator = actualDefaultcol.equalsIgnoreCase("Amandeep Singh1");
		System.out.println("UpdatedCollaborator : -> "+UpdatedCollaborator);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(DefaultCollaborator, "Default collaborator must be None.");
		softAssert.assertTrue(UpdatedCollaborator, "Updated collaborator");
		softAssert.assertAll();

	}

	public String newCollaborator;

	public void CSDP_VerifySubmissionCollaboratorDeselect() throws InterruptedException {
		waitUntilElementIsVisible(CollaboratorSearch);
		clickByJsExecuter(By.xpath("(//div[@id='collaboratorIds']//span)[1]"));
		waitUntilElementIsVisible(SubmissionCollaborator);
		waitUntilElementIsVisible(By.xpath(getSelectedCollaboratorXPath(1)));
		clickOn(By.xpath(getSelectedCollaboratorXPath(1)));
		waitForCurserRunning(3);
		//waitUntilElementIsVisible(SubmissionCollaborator);
		//waitUntilElementIsVisible(By.xpath(getSelectedCollaboratorXPath(1)));
//		clickOn(By.xpath(getSelectedCollaboratorXPath(1)));
		waitForCurserRunning(3);
		waitUntilElementIsVisible(SubmissionCollaborator);
		waitUntilElementIsVisible(SubmissionCollaborator);
		scrollIntoView(SubmissionCollaborator);
		newCollaborator = getTextElement(SubmissionCollaborator);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(newCollaborator, "None", "new collaborator must be None after deselected all.");
		softAssert.assertAll();

	}

	public boolean emailTiles;
	public boolean emailParagraph;
	public boolean EmailLessLnkTxt;

	public void CSDP_VerifyEmailTileWhenNoEmail() throws InterruptedException {
		int emailTiles = findElementsSize(emailTile);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(emailTiles > 0);
		softAssert.assertAll();
	}

	public void CSDP_VerifyEmailTileExpandClickMore() throws InterruptedException {
		waitUntilElementIsVisible(SmsAndEmailVerificationUtility.MessagesIcon);
        Thread.sleep(2000);
		waitForElementIsInteractable(SmsAndEmailVerificationUtility.MessagesIcon);
		clickByJsExecuter(SmsAndEmailVerificationUtility.MessagesIcon);
		String RandomSubject = RandomStrings.requiredCharacters(10);
		sendKeysWithWait(SmsAndEmailVerificationUtility.SubjectField, RandomSubject);
		WebElement switchFrame = waitUntilVisibleWE(SmsAndEmailVerificationUtility.IframeBody);
		driver.switchTo().frame(switchFrame);
		String RandomBody = "Random Body" + RandomStrings.requiredString(50);
		waitForElementIsInteractable(SmsAndEmailVerificationUtility.MessageBody);
		sendKeysWithWait(SmsAndEmailVerificationUtility.MessageBody, RandomBody);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		scrollIntoView(SmsAndEmailVerificationUtility.SendButton);
		clickByJsExecuter(SmsAndEmailVerificationUtility.SendButton);
	//	waitUntilElementInvisibleLocated(SmsAndEmailVerificationUtility.SendButton);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
		waitUntilElementIsVisible(emailTile);
		emailTiles = elementIsDisplayed(emailTile);
		waitUntilElementIsVisible(emailMoreLnkTxt);
		scrollIntoView(emailMoreLnkTxt);
		Thread.sleep(3000);
	//	clickOn(emailMoreLnkTxt);
		movetoElementAndClick(emailMoreLnkTxt);
		waitUntilElementIsVisible(emailLessLnkTxt);
		EmailLessLnkTxt = elementIsDisplayed(emailLessLnkTxt);
		waitUntilElementIsVisible(emailBodyParaGraph);
		emailParagraph = elementIsDisplayed(emailBodyParaGraph);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(emailTiles, "Email Tile is not visible");
		softAssert.assertTrue(emailParagraph, "Email Paragraph is not visible");
		softAssert.assertTrue(EmailLessLnkTxt, "Email Less Text not visible");
		softAssert.assertAll();

	}

	public boolean subjectUpdated;
	public boolean newMailSent;

	public void CSDP_UpdateTheSubjectOfMail() throws InterruptedException {
		waitUntilElementIsVisible(mailReplyFrame);
		WebElement mailFrame = findElement(mailReplyFrame);
		waitUntilElementIsVisible(mailSubject);
		String oldSubject = getValueAttribute(mailSubject);
		clearElement(mailSubject);
		sendKeysWithWait(mailSubject, "Subject " + RandomStrings.requiredString(4));
		driver.switchTo().frame(mailFrame);
		waitUntilElementIsVisible(mailreplyMsz);
		sendKeysWithWait(mailreplyMsz, "Mail Message" + RandomStrings.requiredString(4));
		driver.switchTo().defaultContent();
		waitUntilElementIsVisible(sendmailReply);
		clickOn(sendmailReply);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(mailedSubject);
		newMailSent = elementIsDisplayed(mailedSubject);
		String newSubject = getValueAttribute(mailSubject);
		subjectUpdated = !(oldSubject.equalsIgnoreCase(newSubject));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(subjectUpdated);
		softAssert.assertTrue(newMailSent);
		softAssert.assertAll();

	}

	public boolean defaultAttachmentIcon;
	public boolean AfterAttachmentIcon;
	public boolean AttachmentCount;

	public void CSDP_SubmissionDetails() throws InterruptedException {
		int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
		if (CancelSubmission > 0) {
			scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
			waitForElementIsInteractable(CSPInternalUtility.CloseSubmissionIcon);
			System.out.println("EnterSuccessfully..");
			Thread.sleep(2000);
			clickByJsExecuter(CSPInternalUtility.CloseSubmissionIcon);
		}
		waitForCurserRunning(5);
		Thread.sleep(3000);
		crmCommonMethod.createSubmission("No", "Yes", "Yes", "Yes", "No", "Location Required");
		waitUntilElementIsVisible(attachmentDefaultbtn);
		String attachemntStyle = findElement(attachmentDefaultbtn).getAttribute("style");
		defaultAttachmentIcon = attachemntStyle.contains("add-attachment.png");
		crmCommonMethod.addAttachmentOnCSDP(ceCommonMethod.SetTestDataFilePath("cow.jpg"));
		waitUntilElementIsVisible(attachmentDefaultbtn);
		waitUntilElementIsVisible(attachmentCount);
		String attachemntAfterStyle = findElement(attachmentDefaultbtn).getAttribute("style");
		AfterAttachmentIcon = attachemntAfterStyle.contains("attachments-active.png");
		waitUntilElementIsVisible(attachmentCount);
		int count = Integer.parseInt(getTextElement(attachmentCount));
		AttachmentCount = count == 1;

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(defaultAttachmentIcon);
		softAssert.assertTrue(AttachmentCount);
		softAssert.assertTrue(AfterAttachmentIcon);
		softAssert.assertAll();

	}
	int activeCount;
	public int getActiveHeaderCount() throws InterruptedException {
		waitUntilElementIsVisible(ActiveViolationCount);
		waitForElementIsInteractable(ActiveViolationCount);
		activeCount = Integer.parseInt(getTextElement(ActiveViolationCount).split(" ")[0]);
		return activeCount;
	}

	public void assignmentRuleForCasadingCategory(){

	}

}
