package POM;

import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

public class TemplateManagementUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;
	CECommonMethods ceCommonMethod;

	public TemplateManagementUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
		ceCommonMethod = new CECommonMethods(driver);
	}

	public static String loggedUserName = "//div[@class='app-header__user-name']//label";
	public static String templateManagementSideBarTab = "//label[text()='Template Management']";
	public static String textTemplatesTab = "//div[@class='tab-name ']";
	public static String createTemplateBtn = "//h2[contains(text(),'Active')]//parent::div//button";
	public static String emailTemplatesTab = "//div[@class='tab-name ']//preceding-sibling::div";
	public static String createTemplatePopupHeader = "//div[@class='modal-header']//h1";

	public static String inactiveTemplate = "//h2[contains(text(),'Inactive')]";

	public static String cancelCrtTemplate = "//button[text()='Cancel']";
	public static String saveCrtTemplate = "//button[text()='Save']";
	public static String templateNameTxt = "//input[@name='name']";
	public static By TemplateNameTxt = By.xpath(templateNameTxt);
	public static By MessageBody = By.xpath("//body[@class='mce-content-body ']");
	public static By IncludeMagicLinkchk = By.xpath("//input[@name='MagicLinkToggle'][@type='checkbox']");
	public static By PreviewTemplateBtn = By.xpath("//button[text()='Preview']");
	public static By PreviewTempHeader = By.xpath("(//div[@class='modal-header'])[2]");
	public static By PreviewTemplateBdyMesg = By.xpath("(//div[@class='modal-header'])[2]//following-sibling::div//p");
	public static By ClosePreview = By.xpath("//button[text()='Close']");
	public static By IframeBody = By.xpath("//iframe[@id='editor_ifr']");
	public static String activeTooglebtn = "//button[text()='Active']";
	public static String inactiveTooglebtn = "//button[text()='Inactive']";

	public static String ExistingErrorTemplate = "//div[contains(text(),'Error while creating config email template')]";

	public static By ActiveTogglebtn = By.xpath(activeTooglebtn);
	public static By InactiveTooglebtn = By.xpath(inactiveTooglebtn);

	public static By EmailTemplatesTab = By.xpath(emailTemplatesTab);
	public static By CreateTemplateBtn = By.xpath(createTemplateBtn);
	public static By TextTemplatesTab = By.xpath(textTemplatesTab);
	public static By TemplateManagementSideBarTab = By.xpath(templateManagementSideBarTab);
	public static By CreateTemplatePopupHeader = By.xpath(createTemplatePopupHeader);
	public static By CancelCrtTemplate = By.xpath(cancelCrtTemplate);
	public static By SaveCrtTemplate = By.xpath(saveCrtTemplate);
	public static By LoggedUserName = By.xpath(loggedUserName);
	public static By InactiveTemplate = By.xpath(inactiveTemplate);
	public static String TempalteName = "//div[text()='%s']";
	public static String EditTemplate = "//div[text()='%s']//parent::div/div/button";
	public static By TemplateSubjectLine = By.xpath("//input[@name='subject']");

	
	public static String emailBdyValidMsg = "//label[@class='html-editor__error']";
	public static String emailSubLineInput = "//input[@name='subject']";
	public static By TemplateEmailBodyMsz = By.xpath("//body[@class='mce-content-body ']//p");

	public static By EmailBdyValidMsg = By.xpath(emailBdyValidMsg);
	public static By EmailSubLineInput = By.xpath(emailSubLineInput);
	public static By emailTemplateNames = By.cssSelector("div.sortable-table__body__tr div.sortable-table__body__td:nth-child(1)");

	

	
	public void LoginAdmin() throws InterruptedException {
		log.LoginAgency();

	}

	public String getEmailTemplateTab() {
		String text = getTextElement(EmailTemplatesTab);
		return text;
	}

	public String getTextTemplateTab() {
		String text = getTextElement(TextTemplatesTab);
		return text;
	}

	public String getLoggedUser() {
		String loggedUser = getTextElement(LoggedUserName);
		return loggedUser;
	}

	public void TemplateMangement_PreRequisite() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(10);
		scrolltoUp();
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToTemplateManagement();
	}

	public void closeCreateTemplatePopUp() {
		waitUntilElementIsVisible(CancelCrtTemplate);
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickByJsExecuter(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
	}

	public void openCreateTemplatePopUp() {
		waitUntilElementIsVisible(CreateTemplateBtn);
		scrollIntoView(CreateTemplateBtn);
		waitForElementIsInteractable(CreateTemplateBtn);
		clickByJsExecuter(CreateTemplateBtn);
		waitUntilElementIsVisible(CreateTemplatePopupHeader);
	}

	public String getCrtTemplatePopupTitle() {
		String title = getTextElement(CreateTemplatePopupHeader);
		return title;
	}

	public int getCreateTemplateHeaderCount() {
		waitUntilElementIsVisible(CreateTemplatePopupHeader);
		int count = driver.findElements(CreateTemplatePopupHeader).size();
		return count;
	}

	public String GetCustomXPath(int index) {
		String xpath = "(//span[@class='field__error'])[" + index + "]";
		return xpath;
	}

	public void clickOnSaveTemplate() {
		waitUntilElementIsVisible(SaveCrtTemplate);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
	}

	public String getTemplateNameValidationMsg() {
		waitUntilElementIsVisible(By.xpath(GetCustomXPath(1)));
		String text = findElementByXPath(GetCustomXPath(1)).getText();
		return text;
	}

	public String getTemplateEmailSubValidationMsg() {
		waitUntilElementIsVisible(By.xpath(GetCustomXPath(2)));
		String text = findElementByXPath(GetCustomXPath(2)).getText();
		return text;
	}

	public String getEmailBodyvalidMsg() {
		String text = getTextElement(EmailBdyValidMsg);
		return text;
	}

	public void setEmailSubLineRndChar(int charCount) {
		scrollIntoView(EmailSubLineInput);
		String rng = RandomStrings.requiredString(charCount);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, rng);
	}

	public String AddDocument = "//label[text()='Add Related Documents']";
	public String addedFiles = "//div[@class='chip__body']";
	public String removeFiles = "//button[@class='chip__close-button']";

	public By AddedFiles = By.xpath(addedFiles);
	public By RemoveFiles = By.xpath(removeFiles);


	

	public void addTemplateFile(String fileName) throws InterruptedException, AWTException {
		String filePath = ceCommonMethod.SetTestDataFilePath(fileName);
		crmCommonMethod.addTemplateFiles(AddDocument, filePath);
		waitUntilElementIsVisible(AddedFiles);
	}

	public int getAddedTemplateFileCount() {
		int filesCount = driver.findElements(AddedFiles).size();
		return filesCount;

	}

	public void clickOnRemovefilesIcon() {
		waitUntilElementIsVisible(RemoveFiles);
		scrollIntoView(RemoveFiles);
		waitForElementIsInteractable(RemoveFiles);
		WebElement ele = driver.findElement(RemoveFiles);
		ele.click();
		waitUntilElementIsVisible(AddedFiles);
	}

	public void setTemplateName(String templateName) {
		waitUntilElementIsVisible(TemplateNameTxt);
		scrollIntoView(TemplateNameTxt);
		waitForElementIsInteractable(TemplateNameTxt);
		sendKeysWithWait(TemplateNameTxt, templateName);

	}

	public void setTemplateEmailSubLine(String emailSubLine) {
		scrollIntoView(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		clearElement(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, emailSubLine);

	}

	public String switchToFrame() {
		String currentWindow = driver.getWindowHandle();
		WebElement switchFrame = waitUntilVisibleWE(IframeBody);
		driver.switchTo().frame(switchFrame);
		return currentWindow;

	}

	public void setTemplateMessage(String message) throws InterruptedException {
		waitForElementIsInteractable(MessageBody);
		sendKeysWithWait(MessageBody, message);
		forcedWaitTime(4);
	}

	public void switchToWindow(String currentWindow) throws InterruptedException {
		driver.switchTo().window(currentWindow);
		forcedWaitTime(4);

	}

	public void clickOnMagicLinkCheckBox() {
		scrollIntoView(IncludeMagicLinkchk);
		clickByJsExecuter(IncludeMagicLinkchk);
	}

	public void clickOnPreviewTemp() {
		scrollIntoView(PreviewTemplateBtn);
		waitForElementIsInteractable(PreviewTemplateBtn);
		clickByJsExecuter(PreviewTemplateBtn);
		waitUntilElementIsVisible(PreviewTempHeader);
		waitUntilElementIsVisible(PreviewTemplateBdyMesg);
	}

	public void clickOnclosePreviewTemp() {
		waitForElementIsInteractable(ClosePreview);
		clickByJsExecuter(ClosePreview);
	}

	public String getTemplatePreviewHeader() {
		String text = getTextElement(PreviewTempHeader);
		return text;
	}

	public String getTemplatePreviewMsgBody() {
		String text = getTextElement(PreviewTemplateBdyMesg);
		return text;
	}



	public By ActiveTemplates = By.xpath("//h2[contains(text(),'Active')]");

	public String GetInactiveTemplateXPath(int index) {
		return "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]";
	}
	
	public String getLastInactiveXpath(int index)
	{
		
		return "(//div[@class='rt-tr-group'])["+index+"]//div[@role='gridcell'][1]";
	}

	public String GetCustomTemplateGridXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]";
	}

	public String GetInactiveEditIconXPath(int index) {
		return "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]//button";
	}

	public String GetTemplateEditButtonXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]//button";
	}

	public String GetCustomTemplateMoreLinlXPath(int index) {

		return "(//div[@class='sortable-table__body__tr']/div)[" + index
				+ "]/div/a";
	}

	public String GetCustomTemplateLessLinlXPath(int index) {

		return "(//div[@class='sortable-table__body__tr']/div)[" + index
				+ "]//span//following-sibling::a[text()=' less']";
	}

	public String LastUpdatedGridXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]//span";
	}
	
	
	public int getActiveTemplateCount(int col) throws InterruptedException {
		waitUntilElementIsVisible(CreateTemplateBtn);
		waitForElementIsInteractable(CreateTemplateBtn);
		scrollIntoView(ActiveTemplates);
		forcedWaitTime(4);
		String ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		int index = ((Integer.parseInt(ActiveTemplatecount)) * 5) - col;
		
		return index;
	}
	
	
	public String getTempGridNameLbl(int index) {
		String text = getTextElement(By.xpath(GetCustomTemplateGridXPath(index)));
		return text;
	}
	
	
	public String getTemplateGridSubLine(int index) {
		String text = getTextElement(By.xpath(GetCustomTemplateGridXPath(index)));
		return text;
	}
	
	public void clickOnMoreLinkText(int index) throws InterruptedException {
		waitUntilElementIsVisible(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		scrollIntoView(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		waitForElementIsInteractable(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		WebElement ele = driver.findElement(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		forcedWaitTime(4);
	}
	
	public String getLastUpdatetext(int index) {
		String text = driver.findElement(By.xpath(LastUpdatedGridXPath(index))).getText();
		return text;
	}


	public void clickOnEditTemplate(int index) throws InterruptedException {
		clickByJsExecuter(By.xpath(GetTemplateEditButtonXPath(index)));
		waitUntilElementIsVisible(EditTemplatePopHeader);
		forcedWaitTime(4);
	}
	
	public String getEditTemplatePopHeader() {
		String text = getTextElement(EditTemplatePopHeader);
		return text;
	}
	
	public Boolean checkStatusTemplateNameField() {
		Boolean namestatus = driver.findElement(TemplateNameTxt).isEnabled();
		return namestatus;
	}

	

	public By EditTemplatePopHeader = By.xpath(createTemplatePopupHeader);

	

	

	
	public int getInactiveTemplateCount() {
		scrollIntoView(InactiveTemplate);
		int inactiveTemplatecount= Integer.parseInt(getTextElement(InactiveTemplate).split(" ")[0]);
		return inactiveTemplatecount;
	}
	
	public void clickOnIactiveToggle() {
		waitUntilElementIsVisible(InactiveTooglebtn);
		waitForElementIsInteractable(InactiveTooglebtn);
		clickByJsExecuter(InactiveTooglebtn);
	}
	
	public String getInactiveTemplateName(int index) {
		String inactivatedTemplate = driver.findElement(By.xpath(GetInactiveTemplateXPath(index))).getText();
		return inactivatedTemplate;
	}
	
	public void editInactiveTemplate(int index) {
		scrollIntoView(By.xpath(GetInactiveEditIconXPath(index)));
		waitForElementIsInteractable(By.xpath(GetInactiveEditIconXPath(index)));
		clickByJsExecuter(By.xpath(GetInactiveEditIconXPath(index)));
	}
	
	
	public void clickOnActiveToggle() {
		waitUntilElementIsVisible(ActiveTogglebtn);
		waitForElementIsInteractable(ActiveTogglebtn);
		clickByJsExecuter(ActiveTogglebtn);
	}

	public String existingTemplateName;
	public String expectedMsg;
	public String actualMsg = "Error while creating config email template";
	
	
	public String getExistingTemplateError() {
		waitUntilElementIsVisible(By.xpath(ExistingErrorTemplate));
		String text = getTextElement(By.xpath(ExistingErrorTemplate));
		return text;
	}
	
	public void clickOnCancleButton() throws InterruptedException {
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickOn(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
		waitForCurserRunning(3);
	}

	

	

	public void ClickonCancelTemplateButton() {
		waitUntilElementIsVisible(CancelCrtTemplate);
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickByJsExecuter(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
	}
	
	public void editCustomTemplate(String name) throws InterruptedException {
		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, name)));
		scrollIntoView(By.xpath(stringFormat(TempalteName, name)));
		clickByJsExecuter(By.xpath(stringFormat(EditTemplate, name)));
		waitForCurserRunning(5);
	}
	
	
	// get subject line text through value attribute
	public String getSubjectLineValue() throws InterruptedException {
		waitUntilElementIsVisible(TemplateSubjectLine);
		forcedWaitTime(4);
		waitUntilElementIsVisible(TemplateSubjectLine);
		String subjectLine = getValueAttribute(TemplateSubjectLine);
		
		return subjectLine;
	}
	
	public String getEmailBodyMsg() throws InterruptedException {
		waitForElementIsInteractable(MessageBody);
		String text = getTextElement(TemplateEmailBodyMsz);
		forcedWaitTime(4);
		return text;
	}

	

	
	

}
