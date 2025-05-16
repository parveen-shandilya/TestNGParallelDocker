package POM;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class FinanceUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods ceMethods;
	CRMCommonMethods crmCommonMethods;

    public static By financeHeading = By.xpath("//h2[text()='Finance']");
	public static By financeLabel = By.xpath("//label[text()='Finance']");
	public static By financeTitle= By.xpath("//div[@class='sidebar']/*[text()='Finance']");
	public static By financeMenu = By.xpath("//div//label[text()='Finance']");
	public static String transactionToggels = "//button[text()='%s']";
	public static String financeDrpSelected = "//label[contains(text(),'%s')]//parent::div//div//label";
	public static By clearALL_filter = By.cssSelector("a.clear-filters");
	public static By searchInput = By.xpath("//input[@name='searchQuery']");
	public static String gridData = "(//div[@role='grid']//div[@role='gridcell']//div)[%s]";
	public static String gridColData = "//div[@role='rowgroup']//div[@role='gridcell'][%s]/div";
	public static By gridCaseNumber = By.xpath("(//div[@role='grid']//div[@role='gridcell']//a[@target='_blank'])[1]");
	public static By gridCaseNumberList = By.xpath("(//div[@role='grid']//div[@role='gridcell']//a[@target='_blank'])");
	public static By transactionId = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[2][1]");
	public static By transactionIdList = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'][2])");
	public static By noData = By.cssSelector("div.rt-noData");
	public static By csvDownloadBtn = By.cssSelector("div.transaction-listing__CSV-button button");
	public static By transactionName = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[1][1]");
	public static By transaction_Status = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[7]");
	public static By transaction_amount = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[8]");
	public static By transaction_OutstandingBalance = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[9]");
	public static String custome_gridData = "(//div[@role='grid']//div[@role='gridcell'])[%s]";
	public static By transaction_Names = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'][1])");
	public static By nextPagignationBtn = By.xpath("//div[@class='table__pagination-nav-btns']/button[2]");
	public static By previousPagignationBtn = By.xpath("//div[@class='table__pagination-nav-btns']/button[1]");
	public static String amountnullified = "(//div[@role='grid']//div[@role='gridcell'])[%s]//span";
	
	public static String customeGridColListData = "//div[@role='rowgroup']//div[@role='gridcell'][%s]";
	public static String nullPartialAmt = "(//div[@role='grid']//div[@role='gridcell'])[%s]//span[%s]";
	public static By paymentBal = By.xpath("(//div[@role='rowgroup']//div[@role='gridcell'])[6]");
	
	public static String filterArrowIcon = "//label[text()='%s']//following-sibling::div//span";
	public static By fromNumberValue = By.xpath("//div[@id='amount']//input[@name='fromNumber']");
	public static By toNumberValue = By.xpath("//div[@id='amount']//input[@name='toNumber']");
	public static By amountApplyButton = By.xpath("//div[@id='amount']//button[text()='Apply']");
	public static By fromDateValue = By.xpath("//div[@id='createdAt']//input[@name='fromDate']");
	public static By ToDateValue = By.xpath("//div[@id='createdAt']//input[@name='toDate']");
	public static By addedOnApplyBtn = By.xpath("//div[@id='createdAt']//button[text()='Apply']");
	
	public static String pickDate = "//input[@name='%s']//parent::div//following-sibling::div//td[@data-value='%s']";
	public static String datePicker = "//input[@name='%s']//following-sibling::span";
	
	public static String filterApplybutton = "//div[@id='%s']//button[text()='Apply']";
	public static String amountFromToVal = "//div[@id='%s']//input[@name='%s']";
	
	
	
	public FinanceUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceMethods = new CECommonMethods(driver);
		crmCommonMethods = new CRMCommonMethods(driver);
	}
	
	
	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}
	
	public String getTransactionName() {
		String text = getTextElement(transactionName);
		return text;
	}
	
	
	public String getTransactionStatus() {
		String text = getTextElement(transaction_Status);
		return text;
	}
	
	
	public String getTransactionAmount() {
		String text = getTextElement(transaction_amount);
		return text;
	}
	
	public String getTransactionBalance() {
		String text = getTextElement(transaction_OutstandingBalance);
		return text;
	}
	
	
	public String getElementClass(By element) {
		String text = findElement(element).getAttribute("class");
		return text;
	}
	
	public String getCustomGridDataValue(String col) {
		String text = getTextElement(By.xpath(selectorFormate(custome_gridData,col)));
		return text;
	}
	
	public void clickOnTransactionToggel(String toggel) throws InterruptedException {
		waitForPresenceandVisiblity(By.xpath(selectorFormate(transactionToggels,toggel)));
		forcedWaitTime(3);
		waitForElementIsInteractable(By.xpath(selectorFormate(transactionToggels,toggel)));
		clickByJsExecuter(By.xpath(selectorFormate(transactionToggels,toggel)));
	    waitForCurserRunning(10);
	}
	
	public Boolean clearALLFilterDisplyed() {
		Boolean filter = elementIsDisplayed(clearALL_filter);
		return filter;
	}
	
	public Boolean cSVDownoadeBtnDisplayed() {
		Boolean cSVBtn = elementIsDisplayed(csvDownloadBtn);
		return cSVBtn;
	}
	
	public void clickOnDownloadCSV() throws InterruptedException {
		waitForPresenceandVisiblity(csvDownloadBtn);
		forcedWaitTime(2);
		waitForElementIsInteractable(csvDownloadBtn);
		clickByJsExecuter(csvDownloadBtn);
	    waitForCurserRunning(5);
	    forcedWaitTime(5);
	}
	
	public void clickOnClearAllFilter() throws InterruptedException {
		
		if(findElementsSize(clearALL_filter) > 0) {
			waitForPresenceandVisiblity(clearALL_filter);
			forcedWaitTime(2);
			waitForElementIsInteractable(clearALL_filter);
			clickByJsExecuter(clearALL_filter);
		    waitForCurserRunning(10);
		    forcedWaitTime(4);
		}
		
		else {
			forcedWaitTime(2);
		}
	}
	
	public Boolean searchInputDisplyed() {
		Boolean filter = elementIsDisplayed(searchInput);
		return filter;
	}
	
	public String getGridData (String colIndex) {
		String text = getTextElement(By.xpath(selectorFormate(gridData, colIndex)));
		return text;
		
	}
	
	public void enterDataSearchInput(String text) throws InterruptedException {
		waitForElementIsInteractable(searchInput);
		forcedWaitTime(1);
		clearElement(searchInput);
		waitForCurserRunning(5);
		forcedWaitTime(2);
		sendKeysWithWait(searchInput, text);
		waitForCurserRunning(10);
	}
	
	
	public List<String> getGridColData(String colIndex) throws InterruptedException {
		waitForCurserRunning(2);
		forcedWaitTime(4);
		List<String> textList = getElementTextList(By.xpath(selectorFormate(gridColData, colIndex)));
		return textList;
	}
	
	public List<String> getCustomGridColData(String colIndex) throws InterruptedException{
		forcedWaitTime(2);
		List<String> textList = getElementTextList(By.xpath(selectorFormate(customeGridColListData, colIndex)));
		return textList;
	}
	
	
	
	public String getCaseNumGridData () {
		waitForPresenceandVisiblity(gridCaseNumber);
		String text = getTextElement(gridCaseNumber);
		return text;
		
	}
	
	public List<String> getCaseNumGridColData() throws InterruptedException {
		waitForCurserRunning(2);
		forcedWaitTime(2);
		List<String> textList = getElementTextList(gridCaseNumberList);
		return textList;
	}
	
	

	public String getTransactionIdGridData () {
		waitForPresenceandVisiblity(transactionId);
		String text = getTextElement(transactionId);
		return text;
		
	}
	
	public List<String> getTransactionIdListColData() throws InterruptedException {
		waitForCurserRunning(2);
		forcedWaitTime(2);
		List<String> textList = getElementTextList(transactionIdList);
		return textList;
	}
	
	
	public List<String> getTransactionsListColData() throws InterruptedException {
		waitForCurserRunning(2);
		forcedWaitTime(2);
		List<String> textList = getElementTextList(transaction_Names);
		return textList;
	}
	
	
	
	public String getNoTransactionMessage() throws InterruptedException {
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(noData);
		String text = getTextElement(noData);
		return text;
	}
	
	public void clickOnNextBtn() throws InterruptedException{
		forcedWaitTime(2);
		waitForElementIsInteractable(nextPagignationBtn);
		clickByJsExecuter(nextPagignationBtn);
		waitForCurserRunning(6);
	}
	

	public void clickOnPreviousBtn() throws InterruptedException{
		forcedWaitTime(2);
		waitForElementIsInteractable(previousPagignationBtn);
		clickByJsExecuter(previousPagignationBtn);
		waitForCurserRunning(6);
	}
	
	public void clickOnFilterArrows(String filterName) throws InterruptedException {
		forcedWaitTime(2);
		waitForElementIsInteractable(By.xpath(selectorFormate(filterArrowIcon, filterName)));
		clickByJsExecuter(By.xpath(selectorFormate(filterArrowIcon,filterName)));
		forcedWaitTime(2);
	
	}
	
	public void clickOnAmountapply() throws InterruptedException {
		waitForElementIsInteractable(amountApplyButton);
		clickOn(amountApplyButton);
		forcedWaitTime(2);
		waitForCurserRunning(4);
	
	}
	
	public void clickOnAddedOnApply() throws InterruptedException {
		waitForElementIsInteractable(addedOnApplyBtn);
		clickOn(addedOnApplyBtn);
		forcedWaitTime(2);
		waitForCurserRunning(4);
	
	}
	
	public void clickOnfilterApplyBtn(String filterName) throws InterruptedException{
		waitForElementIsInteractable(By.xpath(selectorFormate(filterApplybutton, filterName)));
		clickOn(By.xpath(selectorFormate(filterApplybutton, filterName)));
		forcedWaitTime(2);
		waitForCurserRunning(5);
		forcedWaitTime(2);
	}
	
	
	
	public void sendFromNumberValue(String val) throws InterruptedException {
		waitForElementIsInteractable(fromNumberValue);
		sendKeysWithWait(fromNumberValue, val);
		forcedWaitTime(2);
	}
	
	
	
	public void sendToNumberValue(String val) throws InterruptedException {
		waitForElementIsInteractable(toNumberValue);
		sendKeysWithWait(toNumberValue, val);
		forcedWaitTime(2);
	}

	
	public void sendFromDateValue(String val) throws InterruptedException {
		waitForElementIsInteractable(fromDateValue);
		sendKeysWithWait(fromDateValue, val);
		forcedWaitTime(2);
	}
	
	public void sendToDateValue(String val) throws InterruptedException {
		waitForElementIsInteractable(ToDateValue);
		sendKeysWithWait(ToDateValue, val);
		forcedWaitTime(2);
	}
	
	public void sendValueToFrom(String filterName, String fromTo ,String val) throws InterruptedException {
		waitForElementIsInteractable(By.xpath(selectorFormate(amountFromToVal, filterName,fromTo)));
		sendKeysWithWait(By.xpath(selectorFormate(amountFromToVal, filterName,fromTo)), val);
		forcedWaitTime(2);
	}
	
	
	
	public void clickOnDatePicker(String datePickerName) throws InterruptedException {
		waitForElementIsInteractable(By.xpath(selectorFormate(datePicker, datePickerName)));
		clickOn(By.xpath(selectorFormate(datePicker, datePickerName)));
		forcedWaitTime(2);
		waitForCurserRunning(4);
		
	}
	
	public void pickDateToDatePicker(String tofrom ,String day) throws InterruptedException {
		forcedWaitTime(3);
		waitForElementIsInteractable(By.xpath(selectorFormate(pickDate,tofrom, day)));
		clickByJsExecuter(By.xpath(selectorFormate(pickDate, tofrom,day)));
		forcedWaitTime(2);
		waitForCurserRunning(4);
	}
	
	
	
	public void checkedStatus(String filterName,String status) throws InterruptedException {
		forcedWaitTime(3);
		waitForElementIsInteractable(By.xpath(selectorFormate(amountFromToVal,filterName, status)));
		clickByJsExecuter(By.xpath(selectorFormate(amountFromToVal, filterName,status)));
		forcedWaitTime(2);
		waitForCurserRunning(4);
	}
	


}