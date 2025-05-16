package POM;

import BrowsersBase.BrowsersInvoked;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.google.api.services.gmail.model.Thread;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import junit.framework.Assert;

public class NoticesUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods CRMcommonMethod;

	public NoticesUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		CRMcommonMethod = new CRMCommonMethods(driver);

	}

	public static By chngeLogo = By.xpath("//label[text()='Change Logo']");
	public static By generateNoticeInProgressHeader = By.xpath("//h1/b");
	public static By generateNoticeHeader = By.xpath("//*[@class='full-page-modal__header']/h1");
	public static By verifyViolationTextHeader = By.xpath("(//div[@class='progressive-form__title']/h2)[1]");
	public static By deleteAndReissue = By.xpath("//a[text()='Delete and Reissue']");
	public static By yesOnPopUp = By.xpath("//button[text()='Yes']");
	public static By viewEscalatedNoticePopUp = By.xpath("//div[text()='View EscalatedNotice']");
	public static By approveNoticePopUpText = By.xpath("//div[@class='notice-preview-title']");
	public static By approveBtnOnApproveNoticePopUp = By.xpath("//button[text()='Approve']");
	public static By rejectBtnOnApproveNoticePopUp = By.xpath("//button[text()='Reject']");
	public static By pendingSupervisorApprovalNoticePopup = By
			.xpath("(//div[text()='Pending Supervisor Approval'])[2]");
	public static By printNoticeTextOnNoticePopup = By.xpath("//a[text()='Print Notice']");
	public static By printBtnOnGenerateNotice=By.xpath("//*[@class='multi-choice-buttons']//button[text()='Print']");
	public static By generateNoticePreview=By.xpath("//*[@id='tinymce']/p[contains(text(),'Mandatory')]");
	public static By saveBtnNoticePopUp = By.xpath("//button[text()='Save']");
	public static By addCaseNoteTextArea = By.xpath("//*[@class='field__input row']/textarea");
	public static By editInternalCommentTextArea = By.xpath("//textarea[@name='internalComment']");
	public static By generateNoticeBtnOnGenerateNoticePopUp=By.xpath("//*[@class='case-inspection__notice-action-buttons']//*[text()='Generate Notice']");

	public static By issueNoticeAdCompleteInspectionBtn = By
			.xpath("//button[text()='Issue Notice & Complete Inspection']");
	public static By approvedStatusOnIssueNotice = By.xpath("//div[text()='Approved']");
	public static String activeTab = "//div[@class='tab-name tab-name--active']";
	public static String createNonHtmlNoticeBtn = "//button[text()='Create Non-HTML Notice']";
	public static String createNonHtmlNoticePopup = "//div[text()='Create Non-HTML Notice']";
	public static String labelField = "//input[@name='label']";
	public static String createNoticeBtn = "//button[text()='Create Notice']";
	public static By notApproved = By.xpath("//div[text()='Not Approved']");
	public static String createHtmlNoticeBtn = "//button[text()='Create HTML Notice']";
	public static String createHtmlNoticePopup = "//h1[text()='Create HTML Notice']";
	public static String mergeFieldsLink = "//span[text()='Merge Fields']";
	public static String addMergeFieldsPopup = "//div[text()='Add Merge Fields']";
	public static String countNotices = "//div[@class='agency-setup-tab__section__header']/h2";
	public static String categoryDropdown = "//div[@class='Select-value']";
	public static String categoryOption = "//*[text()='Case Activity']";
	public static String fieldResults = "//div/div[@class='rt-td']/a";
	public static String categoryResults = "//div[text()='Case Activity']";
	public static String doneButton = "//button[text()='Done']";
	public static String previewButton = "//button[text()='Preview']";
	public static String previewPopupBody = "//div[@class='modal-base__body']//div/p";
	public static String fADocumentToggle = "//button[text()='FA Document']";
	public static String noticesPageLink = "//label[text()='Notices']";
	public static String editIconNotice = "//button[@class='edit-btn space-right btn btn-primary']";
	public static String noticeLabelColumn = "//div[@class='sortable-table__body__td'][1]";
	public static String noticesCountHeader = "//div[@class='agency-setup-tab__section__header']/h2";
	public static String noticesCountActual = "//div[@class='sortable-table__body__td'][1]";
	public static String linkToVioTypesField = "//span[@class='Select-placeholder placeholder']";
	public static String waterOptionToLink = "//*[text()='Water']";
	public static String appHeaderIcon = "//div[@class='app-header__menu__icon']";
	public static String agencySetupLabel = "//label[text()='Agency Setup']";
	public static String cE = "//label[contains(text(),'CE')]";
	public static String productDemo = "//label[contains(text(),'Product Demo')]";
	public static String cancelButtonCCP = "//button[text()='Cancel']";
	public static String noticeContent = "//body[@class='mce-content-body ']/p";
	public static String closePopup = "//button[text()='Close']";
	public static String saveBtn = "//button[text()='Save']";
	public static String iframeHTML = "editor_ifr";

	public static By IframeHTML = By.id(iframeHTML);
	public static By SaveBtn = By.xpath(saveBtn);
	public static By ClosePopup = By.xpath(closePopup);
	public static By NoticeContent = By.xpath(noticeContent);
	public static By ActiveTab = By.xpath(activeTab);
	public static By CreateNonHtmlNoticeBtn = By.xpath(createNonHtmlNoticeBtn);
	public static By CreateNonHtmlNoticePopup = By.xpath(createNonHtmlNoticePopup);
	public static By LabelField = By.xpath(labelField);
	public static By CreateNoticeBtn = By.xpath(createNoticeBtn);
	public static By CreateHtmlNoticeBtn = By.xpath(createHtmlNoticeBtn);
	public static By MergeFieldsLink = By.xpath(mergeFieldsLink);
	public static By AddMergeFieldsPopup = By.xpath(addMergeFieldsPopup);
	public static By CreateHtmlNoticePopup = By.xpath(createHtmlNoticePopup);
	public static By CountNotices = By.xpath(countNotices);
	public static By CategoryDropdown = By.xpath(categoryDropdown);
	public static By CategoryOption = By.xpath(categoryOption);
	public static By FieldResults = By.xpath(fieldResults);
	public static By CategoryResults = By.xpath(categoryResults);
	public static By DoneButton = By.xpath(doneButton);
	public static By PreviewButton = By.xpath(previewButton);
	public static By PreviewPopupBody = By.xpath(previewPopupBody);
	public static By FADocumentToggle = By.xpath(fADocumentToggle);
	public static By NoticesPageLink = By.xpath(noticesPageLink);
	public static By EditIconNotice = By.xpath(editIconNotice);
	public static By NoticeLabelColumn = By.xpath(noticeLabelColumn);
	public static By NoticesCountHeader = By.xpath(noticesCountHeader);
	public static By NoticesCountActual = By.xpath(noticesCountActual);
	public static By LinkToVioTypesField = By.xpath(linkToVioTypesField);
	public static By WaterOptionToLink = By.xpath(waterOptionToLink);
	public static By AppHeaderIcon = By.xpath(appHeaderIcon);
	public static By AgencySetupLabel = By.xpath(agencySetupLabel);
	public static By CE = By.xpath(cE);
	public static By ProductDemo = By.xpath(productDemo);
	public static By CancelButtonCCP = By.xpath(cancelButtonCCP);

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void Notices_PreRequisite() throws InterruptedException {
		waitForCurserRunning(3);
		CRMcommonMethod.navigationToNoticesUtility();

	}

	public void Notices_OpenCreateNonHtmlNoticePopup() throws InterruptedException {
		waitForElementIsInteractable(ActiveTab);
		scrollIntoView(ActiveTab);
		waitUntilElementPresent(CreateNonHtmlNoticeBtn);
		scrollIntoView(CreateNonHtmlNoticeBtn);
		waitForElementIsInteractable(CreateNonHtmlNoticeBtn);
		clickByJsExecuter(CreateNonHtmlNoticeBtn);
		implicitWaitforCustometime(3);
		waitUntilElementIsVisible(CreateNonHtmlNoticePopup);
		String PopupTitle = getTextElement(CreateNonHtmlNoticePopup);
		Assert.assertEquals(PopupTitle, "Create Non-HTML Notice");
	}

	public static int CurrentNoticesCount;

	public void Notices_CreateNonHTMLNotice() throws InterruptedException {
		waitUntilElementIsVisible(CancelButtonCCP);
		waitForElementIsInteractable(CancelButtonCCP);
		clickByJsExecuter(CancelButtonCCP);
		waitUntilElementIsVisible(CountNotices);
		forcedWaitTime(5);
		waitUntilElementPresent(By.xpath("div.sortable-table__body__td"));
		waitUntilElementPresent(CountNotices);
		String[] NoticesSplit = getTextElement(CountNotices).split(" ");
		String CountText = NoticesSplit[0];
		int NoticesCountBefore = Integer.parseInt(CountText);
		waitForElementIsInteractable(CreateNonHtmlNoticeBtn);
		clickByJsExecuter(CreateNonHtmlNoticeBtn);
		forcedWaitTime(5);
		waitUntilElementIsVisible(LabelField);
		waitForElementIsInteractable(LabelField);
		String RandomLabel = "Non-HTML " + RandomStrings.requiredCharacters(8);
		sendKeysWithWait(LabelField, RandomLabel);
		waitUntilElementIsVisible(CreateNoticeBtn);
		waitForElementIsInteractable(CreateNoticeBtn);
		scrollIntoView(CreateNoticeBtn);
		waitForElementIsInteractable(CreateNoticeBtn);
		clickByJsExecuter(CreateNoticeBtn);
		// WaitUntilElementInvisible(CreateNoticeBtn);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CountNotices);
		waitUntilElementPresent(CountNotices);
		scrollIntoView(CountNotices);
		waitForElementIsInteractable(CountNotices);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		waitUntilElementPresent(By.xpath("div.sortable-table__body__td"));
		String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
		String CountText2 = NoticesSplit2[0];
		CurrentNoticesCount = Integer.parseInt(CountText2);
		boolean CompareCount = CurrentNoticesCount == (NoticesCountBefore + 1);
		Assert.assertEquals(CompareCount, true);
	}

	public void Notices_OpenCreateHtmlNoticePopup() throws InterruptedException {
		waitUntilElementIsVisible(CreateHtmlNoticeBtn);
		scrollIntoView(CreateHtmlNoticeBtn);
		waitForElementIsInteractable(CreateHtmlNoticeBtn);
		clickOn(CreateHtmlNoticeBtn);
		waitUntilElementIsVisible(CreateHtmlNoticePopup);
		String PopupTitle = getTextElement(CreateHtmlNoticePopup);
		Assert.assertEquals(PopupTitle, "Create HTML Notice");
	}

	public void Notices_OpenAddMergeFieldsPopup() throws InterruptedException {
		waitUntilElementIsVisible(MergeFieldsLink);
		waitForElementIsInteractable(MergeFieldsLink);
		clickByJsExecuter(MergeFieldsLink);
		waitUntilElementIsVisible(AddMergeFieldsPopup);
		String PopupTitle = getTextElement(AddMergeFieldsPopup);
		Assert.assertEquals(PopupTitle, "Add Merge Fields");
	}

	public void Notices_ApplyCategoryOnMergeFields() throws InterruptedException {
		waitUntilElementIsVisible(CategoryDropdown);
		waitForElementIsInteractable(CategoryDropdown);
		clickOn(CategoryDropdown);

		waitForElementIsInteractable(CategoryOption);
		clickOn(CategoryOption);
		List<WebElement> CategoryApplied = driver.findElements(FieldResults);
		int CountFields = CategoryApplied.size();
		List<WebElement> CategoryResult = driver.findElements(CategoryResults);
		int CountCategory = CategoryResult.size();
		Assert.assertEquals(CountFields, CountCategory);
	}

	public void Notices_VerifyMergeFieldsOnHtmleditor() throws InterruptedException {
		waitForElementIsInteractable(FieldResults);
		clickOn(FieldResults);
		String FieldText = getTextElement(FieldResults);
		clickOn(DoneButton);
		WebElement switchFrame = waitUntilVisibleWE(IframeHTML);

		implicitWaitforCustometime(2);
		driver.switchTo().frame(switchFrame);
		String NoticeText = getTextElement(NoticeContent);
		Assert.assertEquals(FieldText, NoticeText);
	}

	public void Notices_VerifyPreviewPopup() {
		waitForElementIsInteractable(NoticeContent);
		
		
		String NoticeText = getTextElement(NoticeContent);
		System.out.println("Notice content is "+NoticeContent);
		driver.switchTo().defaultContent();
		clickOn(PreviewButton);
		String PreviewText = getTextElement(PreviewPopupBody);
		Assert.assertEquals(PreviewText, NoticeText);
	}

	public void Notices_CreateHtmlCaseNotice() throws InterruptedException {
		waitUntilElementIsVisible(ClosePopup);
		clickOn(ClosePopup);
		java.lang.Thread.sleep(3000);
		
		String RandomLabel = "HTML " + RandomStrings.requiredCharacters(8);
		
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField, RandomLabel);
		scrollIntoView(CreateNoticeBtn);
		waitForElementIsInteractable(CreateNoticeBtn);
		clickByJsExecuter(CreateNoticeBtn);
		waitUntilElementInvisibleLocated(CreateNoticeBtn);
		waitUntilElementInvisibleLocated(CreateNoticeBtn);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CountNotices);
		waitUntilElementIsVisible(By.xpath("//div[@class='sortable-table__body__td']"));
		waitUntilElementPresent(By.xpath("//div[@class='sortable-table__body__td']"));
		scrollIntoView(CountNotices);
		String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
		String CountText2 = NoticesSplit2[0];
		int NoticesCountAfter = Integer.parseInt(CountText2);
		boolean CompareCount = NoticesCountAfter == (CurrentNoticesCount + 1);
		Assert.assertEquals(CompareCount, true);

	}

	public void Notices_CreateFADocumentHtmlNotice() throws InterruptedException {
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CreateHtmlNoticeBtn);
		waitUntilElementPresent(CreateHtmlNoticeBtn);
		scrollIntoView(CreateHtmlNoticeBtn);
		waitForElementIsInteractable(CreateHtmlNoticeBtn);
		waitForElementIsInteractable(CreateHtmlNoticeBtn);
		clickByJsExecuter(CreateHtmlNoticeBtn);
		waitUntilElementInvisibleLocated(CreateHtmlNoticeBtn);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(FADocumentToggle);
		waitUntilElementPresent(FADocumentToggle);
		waitForElementIsInteractable(FADocumentToggle);
		clickOn(FADocumentToggle);
		String RandomLabel = "FA Doc " + RandomStrings.requiredCharacters(8);
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField, RandomLabel);
		clickOn(MergeFieldsLink);
		clickOn(FieldResults);
		clickOn(DoneButton);
		java.lang.Thread.sleep(3000);
		waitForElementIsInteractable(CreateNoticeBtn);
		clickOn(CreateNoticeBtn);
		waitForCurserRunning(3);
		waitUntilVisibleWE(CountNotices);
		scrollIntoView(CountNotices);
		waitUntilElementPresent(By.xpath("div.sortable-table__body__td"));
		waitUntilElementIsVisible(CountNotices);
		waitForElementIsInteractable(CountNotices);
		String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
		String CountText2 = NoticesSplit2[0];
		int NoticesCountAfter = Integer.parseInt(CountText2);
		boolean CompareCount = NoticesCountAfter == (CurrentNoticesCount + 2);
		Assert.assertEquals(CompareCount, true);
	}

	public void Notices_VerifyEditNotices() throws InterruptedException {
		waitUntilElementIsVisible(EditIconNotice);
		waitUntilElementPresent(EditIconNotice);
		waitForElementIsInteractable(EditIconNotice);
		waitForElementIsInteractable(EditIconNotice);
		clickByJsExecuter(EditIconNotice);
		waitUntilElementInvisibleLocated(EditIconNotice);
		waitUntilElementIsVisible(LabelField);
		waitUntilElementPresent(LabelField);
		waitForElementIsInteractable(LabelField);
		WebElement Label = findElement(LabelField);
		Label.clear();
		String RandomLabel = "Non-Html Edited " + RandomStrings.requiredCharacters(4);
		waitForElementIsInteractable(LabelField);
		Label.sendKeys(RandomLabel);
		clickOn(SaveBtn);
		waitUntilElementInvisibleLocated(SaveBtn);
		waitForCurserRunning(6);
		waitUntilElementIsVisible(By.xpath("//div[@class='sortable-table__body__td']"));
		waitUntilElementPresent(By.xpath("//div[@class='sortable-table__body__td']"));
		waitUntilElementPresent(NoticeLabelColumn);
		String GetLabel = getTextElement(NoticeLabelColumn);
		Assert.assertEquals(GetLabel, RandomLabel);
	}

	public void Notices_VerifyCountOfNotices() throws InterruptedException {
		waitUntilElementIsVisible(NoticesCountHeader);
		String[] CountAtHeader = getTextElement(NoticesCountHeader).split(" ");
		String NoticesCountExp = CountAtHeader[0];
		int NoticesCountExpected = Integer.parseInt(NoticesCountExp);
		waitUntilElementIsVisible(NoticesCountActual);
		List<WebElement> NoOfNotices = driver.findElements(NoticesCountActual);
		int TotalCountNotices = NoOfNotices.size();
		Assert.assertEquals(NoticesCountExpected, TotalCountNotices);
	}

	public static void Notices_VerifyAutoPopulationOfNotices() throws InterruptedException {

	}

}
