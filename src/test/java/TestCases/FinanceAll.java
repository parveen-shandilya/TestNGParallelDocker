package TestCases;

import POM.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.CheckDownloadedFile;
import CommonMethods.DateAndTime;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;
import ExtentReport.ExtentReportClass;

public class FinanceAll extends BrowsersInvoked {

	
	FinanceUtility fn;
	CRMCommonMethods crm;


	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		fn = new FinanceUtility(getDriver());
		crm = new CRMCommonMethods(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}

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
			log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
		}
	}

	@Test(priority = 1, description = "Verify that user gets directed to 'Finance' page after clicking the TNB> 'Menu' icon> 'Finance' button")
	public void finance_VerifyUserGetsDirectedToFinancePage() throws InterruptedException {

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.waitUntilElementIsVisible(FinanceUtility.financeTitle);
		String actual = fn.getTextElement(FinanceUtility.financeTitle);
		Assert.assertEquals(actual, CRMConstants.FINANCE_PAGE);
	}

	@Test(priority = 2, description = "Verify that 'All' toggle appears selected by default on 'Transactions'  'All' Page.")
	public void finance_VerifyAllToggleSelectedByDefault() throws InterruptedException {
		Helper helper = new Helper(getDriver());
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "All")));
		Assert.assertTrue(Element_class.contains("btn-primary"));
	}

	@Test(priority = 3, description = "Verify that defult selected filter on 'Transactions'  'All' Page.")
	public void finance_VerifyDefaultSelectedFilterOptions() throws InterruptedException {
		Helper helper = new Helper(getDriver());

		Boolean searchInput = fn.searchInputDisplyed();
		String amountOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Amount")));

		String addedOnOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Added On")));

		String outStandingOption = helper.getTextElement(
				By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Outstanding Balance")));

		String statusOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Status")));

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(searchInput, "search filed is not appear");
		soft.assertEquals(amountOption, "Any");
		soft.assertEquals(addedOnOption, "Any Time");
		soft.assertEquals(outStandingOption, "Any");
		soft.assertEquals(statusOption, "All");
		soft.assertAll();
	}

	@Test(priority = 4, description = "Verify that appropriate transaction appears after searching with any 'Case Assignee' name, on 'Transactions' > 'All' Page.")
	public void finance_VerifySearchByAssigneeOnTranscationALL() throws InterruptedException {   	
		Helper helper = new Helper(getDriver());
//    	   
		fn.clickOnTransactionToggel("All");
		helper.forcedWaitTime(3);

		String caseAssignee = fn.getGridData("9");
		fn.enterDataSearchInput(caseAssignee);

		String caseAssigneeAfter = fn.getGridData("9");
		List<String> searchAssigneeList = fn.getGridColData("14");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(caseAssigneeAfter, caseAssignee, "Assignee is not same");
		soft.assertAll();
		for (String assignee : searchAssigneeList) {
			Assert.assertEquals(assignee, caseAssignee, "List of not expected.");

		}

	}

	@Test(priority = 5, description = "Verify that appropriate transaction appears after searching with any 'Case Number'  on 'Transactions' > 'All' Page.")
	public void finance_VerifySearchByCaseNumberOnTranscationAll() throws InterruptedException {

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
//    	   
		fn.clickOnTransactionToggel("All");
		helper.forcedWaitTime(3);

		String caseNumber = fn.getCaseNumGridData();
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		String caseNumberAfter = fn.getCaseNumGridData();
		List<String> caseNumberList = fn.getCaseNumGridColData();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(caseNumberAfter, caseNumber);
		soft.assertAll();
		for (String caseNo : caseNumberList) {
			Assert.assertEquals(caseNo, caseNumber);

		}

	}

	@Test(priority = 6, description = "Verify that appropriate transaction appears after searching with any 'TransactionId'  on 'Transactions' > 'All' Page.")
	public void finance_VerifySearchByTransactionIdOnTranscationAll() throws InterruptedException {
   	
		Helper helper = new Helper(getDriver());
		fn.clickOnClearAllFilter();
		fn.clickOnTransactionToggel("All");
		helper.forcedWaitTime(3);

		String transactionId = fn.getTransactionIdGridData();
		fn.enterDataSearchInput(transactionId);
		helper.forcedWaitTime(2);
		String transactionIdAfter = fn.getTransactionIdGridData();
		List<String> transactionIdList = fn.getTransactionIdListColData();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(transactionIdAfter, transactionId);
		soft.assertAll();
		for (String id : transactionIdList) {
			Assert.assertEquals(id, transactionId);

		}

	}

	@Test(priority = 7, description = "Verify that 'No transaction to display' message appear after searching with no deatil Transaction  on 'Transactions' > 'All' Page.")
	public void finance_VerifySearchByNoTransactionOnTranscationAll() throws InterruptedException {

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
//    	   
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);

		String transactionId3 = RandomStrings.requiredDigits(10);
		String transactionId2 = RandomStrings.requiredDigits(4);
		String transactionId1 = RandomStrings.requiredDigits(2);

		String transactionId = String.join("-", transactionId1, transactionId2, transactionId3);

		fn.enterDataSearchInput(transactionId);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		String actualMessage = fn.getNoTransactionMessage();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualMessage, CRMConstants.No_Transaction_message);
		soft.assertAll();

	}

	@Test(priority = 8, description = "Verify that user is able to download CSV file after clicking 'Download CSV' button, on 'Transactions' > 'All' Page.")
	public void finance_VerifydownlodeCSVfileTranscationALL() throws InterruptedException {

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		Boolean cSVBtn = fn.cSVDownoadeBtnDisplayed();
		fn.clickOnDownloadCSV();

		Date date = new Date();
		DateFormat pstFormat = new SimpleDateFormat("MM-dd-YYYY hh:mm");
		TimeZone pstTime = TimeZone.getTimeZone("PST");
		pstFormat.setTimeZone(pstTime);
		String[] timesdate = (pstFormat.format(date).split(" "));

		DateFormat pstFormat24 = new SimpleDateFormat("YYYY-DD-MM HH:MM:SS a");
		TimeZone pstTime1 = TimeZone.getTimeZone("PST");
		pstFormat24.setTimeZone(pstTime1);
		String[] timesdate1 = (pstFormat24.format(date).split(" "));

		String[] times = (timesdate[1].split(":"));
		String file_Name = "All_Transactions" + "_" + timesdate[0] + "_" + times[0] + "_" + times[1] + " "
				+ timesdate1[2].toLowerCase() + ".csv";
		System.out.println(file_Name);
		String FileStatus = CheckDownloadedFile.isFileDownloaded(file_Name, BrowsersInvoked.directory);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cSVBtn, "CSV download button is not vissible.");
		soft.assertEquals(FileStatus, "File Present");

		soft.assertAll();

	}

	@Test(priority = 9, description = "Verify all the details of a fine applied on a case on 'Transactions' > 'All' Page.")
	public void finance_VerifyAllthe_Fine_DetailsAppliedOnCaseOnTranscationAll() throws InterruptedException {

		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
		String LoggedInUserName = helper.getTextElement(CLPUtility.AgencyUserName);
		ce.createCaseCCP();
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		// Add Fine On CDP
		crm.addFineOnCDP();
		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);
		String upPaid = helper.getTextElement(CDP_Utility.unpaidButton);

		// Extracting Fine details

		String fineDetails = fine_Name_Amount.get(0).split(": Due")[0].trim() + ")";

		// Extract Date
		String dueDate = fine_Name_Amount.get(0).split(": Due")[1].trim().replace(")", "");

		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		String actualFineName = fn.getTransactionName();
		String actualTransactionId = fn.getTransactionIdGridData();
		String actualAddedOnDate = fn.getGridData("1");
		String actualDueDate = fn.getGridData("2");

		String actualType = fn.getGridData("3");
		String actualPaymentReference = fn.getGridData("4");
		String actualPaidBy = fn.getGridData("5");
		String actualPaymentClerk = fn.getGridData("7");
		String actualPayor = fn.getGridData("8");

		String status = fn.getTransactionStatus();
		String actualAmount = fn.getTransactionAmount();
		String balance = fn.getTransactionBalance();
		String actualCaseId = fn.getCustomGridDataValue("13");
		String actualAddedBy = fn.getCustomGridDataValue("15");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));

		String hrefCase = element.getAttribute("href");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualFineName, fineDetails, "Fine name is not matched.");
		soft.assertFalse(actualTransactionId.isEmpty(), "Transaction Id is null.");
		soft.assertEquals(actualAddedOnDate, fineAddedOnDate, "Fine Added on Date is not same.");
		soft.assertEquals(actualDueDate, dueDate, "Fine Due date is not same.");
		soft.assertEquals(actualType, "-", "Type is not same.");
		soft.assertEquals(actualPaymentReference, "-", "Payment Reference is not same.");
		soft.assertEquals(actualPaidBy, "-", "Actual Paid By is not - for unpaid fine.");
		soft.assertEquals(status, upPaid, "Fine status is not same.");
		soft.assertEquals(actualAmount, amount, "Amount in not same.");
		soft.assertEquals(balance, amount, "Balance is not same.");
		soft.assertEquals(actualPaymentClerk, "-", "PaymentClerk is not same.");
		soft.assertEquals(actualPayor, "-", "Payor is not same.");
		soft.assertNotNull(hrefCase, "Case Id is not a link.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same.");
		soft.assertAll();

	}

	@Test(priority = 10, description = "Verify all the details of a Partial Payment added on a case on 'Transactions' > 'All' Page.")
	public void finance_VerifyPartial_Payment_AppliedOnCaseOnTranscationAll() throws InterruptedException {

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		crm.addFineOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		String cleanedAmount = amount.replaceAll("[$,]", "").split("\\.")[0];
		// Convert to integer
		int amount1 = Integer.parseInt(cleanedAmount);

		crm.addPaymentOnCDP(Integer.toString(amount1 - 50), null);
		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		String actualFineTransactionId = fn.getTransactionIdGridData();

		fn.clickOnTransactionToggel("All");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);

		String statusOn_All_Page = fn.getCustomGridDataValue("22");
		String actual_addedDate_2 = fn.getCustomGridDataValue("18");
		String actualAppliedTo = fn.getCustomGridDataValue("10");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_All_Page, "Partially Paid", "Payment status is not same.");
		soft.assertEquals(actualAppliedTo, actualFineTransactionId, "Applied to is not matched.");
		soft.assertAll();
	}

	@Test(priority = 11, description = "Verify that 'Void' status appears for the void Fines under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyVoidStatusAppearsForVoid_Fine_OnTransactionsAll() throws InterruptedException {

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		crm.addFineOnCDP();
		String voidLabel = crm.UserAbleToMarkFineAsVoid();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(2);
		helper.forcedWaitTime(2);

		String statusOn_All_Page = fn.getCustomGridDataValue("7");
		String actual_addedDate_2 = fn.getCustomGridDataValue("3");
		String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_All_Page, voidLabel, "void status is not same.");
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "All")));
		Assert.assertTrue(Element_class.contains("btn-primary"));
		soft.assertAll();
	}

	@Test(priority = 12, description = "Verify that 'Waive' status appears for the Waive Fines under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyWaiveStatusAppearsForWaive_Fine_OnTransactionsAll() throws InterruptedException {
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
		String LoggedInUserName = helper.getTextElement(CLPUtility.AgencyUserName);
		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);

		crm.addFineOnCDP();
		String voidLabel = crm.UserAbleToMarkFineAsWaive();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		crm.closeFines_Payments_Details();
		helper.forcedWaitTime(1);
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		String statusOn_All_Page = fn.getCustomGridDataValue("7");
		String actual_addedDate_2 = fn.getCustomGridDataValue("3");
		String actualCaseAssignee = fn.getCustomGridDataValue("14");
		String actualAddedBy = fn.getGridData("10");
		String actualCaseId = fn.getCustomGridDataValue("13");
		helper.forcedWaitTime(2);
		WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));
		String hrefLink = element.getAttribute("href");

		SoftAssert soft = new SoftAssert();
		String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_All_Page, voidLabel, "waive status is not same.");
		soft.assertEquals(actualCaseAssignee, caseAssignee, "Case Assignee on CDP and on finance All page not same.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same Logged In user.");
		soft.assertNotNull(hrefLink);
		soft.assertAll();

	}

	@Test(priority = 13, description = "Verify that next and previous pagination under 'Payments' toggle, on 'Transactions' > 'All' Page.")
	public void finance_VerifyNextAndPreviousPaginationOnTransactionAll() throws InterruptedException {
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(4);

		// Transaction Id on first page
		String transactionId_1 = fn.getTransactionIdGridData();
		fn.clickOnNextBtn();
		helper.waitForCurserRunning(5);
		helper.forcedWaitTime(3);

		// Transaction Id on second page
		String transactionId_2 = fn.getTransactionIdGridData();

		fn.clickOnPreviousBtn();
		helper.waitForCurserRunning(5);
		helper.forcedWaitTime(3);
		// Transaction Id on first page
		String transactionId_3 = fn.getTransactionIdGridData();

		fn.clickOnNextBtn();
		helper.waitForCurserRunning(5);
		helper.forcedWaitTime(3);
		// Transaction Id on second page
		String transactionId_4 = fn.getTransactionIdGridData();

		// fn.clickOnClearAllFilter();

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(transactionId_2, transactionId_4);
		soft.assertEquals(transactionId_1, transactionId_3);
		soft.assertAll();
	}

	@Test(priority = 14, description = "Verify that CDP opens up  in a new tab after clicking the Case ID link under 'Case Number' column, for Payments on 'Transactions' > 'All' Page.")
	public void finance_VerifyCDPOpensUpNewTabClickinOnCaseIDLinkOnTransactionAll() throws InterruptedException {

		Helper helper = new Helper(getDriver());

		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		String expectedCaseId = fn.getCustomGridDataValue("13");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + expectedCaseId + "']"));
		helper.clickOnElement(element);
		// element.click();
		helper.forcedWaitTime(4);
		String currentWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));

		helper.waitForPageLoadTime(3);
		helper.waitUntilElementIsVisible(CLPUtility.OpenedCaseId);
		String actualCaseId = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCaseId, expectedCaseId, "Case Id is not matched on CDP.");
		soft.assertAll();

		getDriver().switchTo().window(currentWindow);
		// fn.clickOnClearAllFilter();
		helper.closeOtherTabs();

	}

	@Test(priority = 15, description = "Verify that CDP opens up  in a new tab after clicking the Case ID link under 'Case Number' column, for Fines on 'Transactions' > 'All' Page.")
	public void finance_VerifyCDPOpensUpNewTabClickinOn_Fines_CaseIDLinkOnTransactionAll() throws InterruptedException {

		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);

		crm.addFineOnCDP();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(1);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(4);
		String actualCaseAssignee = fn.getCustomGridDataValue("14");
		String expectedCaseId = fn.getCustomGridDataValue("13");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + expectedCaseId + "']"));
		helper.clickOnElement(element);
		// element.click();
		helper.forcedWaitTime(4);
		String currentWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));

		helper.waitForPageLoadTime(3);
		helper.waitUntilElementIsVisible(CLPUtility.OpenedCaseId);
		String actualCaseId = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCaseId, expectedCaseId, "Case Id is not matched on CDP.");
		soft.assertEquals(actualCaseAssignee, caseAssignee, "Case Assignee on CDP and on finance All page not same.");

		soft.assertAll();

		getDriver().switchTo().window(currentWindow);
		// fn.clickOnClearAllFilter();
		helper.closeOtherTabs();

	}

	@Test(priority = 16, description = "Verify all the details of a Late Fee applied on a case on 'Transactions' > 'All' Page.")
	public void finance_VerifyAllthe_LateFee_DetailsAppliedOnCaseOnTranscationAll() throws InterruptedException {
		
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
		String LoggedInUserName = helper.getTextElement(CLPUtility.AgencyUserName);

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);

		crm.addLateFeeOnCDP();

		List<String> lateFee_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String lateFeeAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);
		String upPaid = helper.getTextElement(CDP_Utility.unpaidButton);

		// Extracting Fine details

		// Extracting values
		String lateFeeName = lateFee_Name_Amount.get(0).replaceFirst("Manual ", "");
		String amount = lateFee_Name_Amount.get(1);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);

		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		String actualLateFeeName = fn.getTransactionName();
		String actualTransactionId = fn.getTransactionIdGridData();
		String actualAddedOnDate = fn.getGridData("1");

		String dueDate = fn.getCustomGridDataValue("4");
		String type = fn.getCustomGridDataValue("5");
		String paymentReference = fn.getCustomGridDataValue("6");

		String status = fn.getCustomGridDataValue("7");
		String actualAmount = fn.getCustomGridDataValue("8");
		String balance = fn.getCustomGridDataValue("9");

		String paidBy = fn.getCustomGridDataValue("10");
		String paymentClerk = fn.getCustomGridDataValue("11");
		String actualCaseAssignee = fn.getCustomGridDataValue("14");
		String actualAddedBy = fn.getGridData("10");
		String payor = fn.getCustomGridDataValue("12");
		String actualCaseId = fn.getCustomGridDataValue("13");
		helper.forcedWaitTime(2);
		WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));
		String hrefLink = element.getAttribute("href");

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualLateFeeName, lateFeeName, "Late Fee name is not matched.");
		soft.assertFalse(actualTransactionId.isEmpty(), "Transaction Id is null.");
		soft.assertEquals(actualAddedOnDate, lateFeeAddedOnDate, "Late Fee Added on Date is not same.");

		soft.assertEquals(paidBy, "-", "Type is not same.");
		soft.assertEquals(dueDate, "-", "Type is not same.");
		soft.assertEquals(type, "-", "Type is not same.");
		soft.assertEquals(paymentReference, "-", "Type is not same.");
		soft.assertEquals(payor, "-", "Payor is not same for Unpaid late Fee.");
		soft.assertEquals(paymentClerk, "-", "paymentClerk is not same for Unpaid late Fee.");
		soft.assertEquals(status, upPaid, "Late Fee status is not same.");
		soft.assertEquals(actualAmount, amount, "Amount in not same.");
		soft.assertEquals(balance, amount, "Balance is not same.");
		soft.assertNotNull(hrefLink, "Case ID is not as Link.");

		soft.assertEquals(actualCaseAssignee, caseAssignee, "Case Assignee on CDP and on finance All page not same.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same Logged In user.");
		soft.assertAll();
	}

	@Test(priority = 17, description = "Verify all the details of a Late Fee Partial Payment added on a case on 'Transactions' > 'All' Page.")
	public void finance_VerifyPartial_LateFee_PaymentAppliedOnCaseOnTranscationAll() throws InterruptedException {
		
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		crm.addLateFeeOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		String cleanedAmount = amount.replaceAll("[$,]", "").split("\\.")[0];
		// Convert to integer
		int amount1 = Integer.parseInt(cleanedAmount);

		crm.addPaymentOnCDP(Integer.toString(amount1 - 50), null);
		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		String status = fn.getCustomGridDataValue("22");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status, "Partially Paid", "Late Fee Payment status is not same.");

		soft.assertAll();

	}

	@Test(priority = 18, description = "Verify that 'Paid' status appears for the paid Late Fees under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_Verify_LateFee_PaymentPaidStatusAppliedOnCaseOnTranscationAll() throws InterruptedException {
		
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		crm.addLateFeeOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		String cleanedAmount = amount.replaceAll("[$,]", "").split("\\.")[0];
		// Convert to integer
		int amount1 = Integer.parseInt(cleanedAmount);

		crm.addPaymentOnCDP(amount, null);
		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		String status = fn.getCustomGridDataValue("22");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status, "Paid", "Late Fee Payment status is not same.");

		soft.assertAll();

	}

	@Test(priority = 19, description = "Verify that 'Void' status appears for the void Late Fees under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyVoidStatusAppearsForVoid_LateFee_OnTransactionsAll() throws InterruptedException {
		
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		crm.addLateFeeOnCDP();
		String voidLabel = crm.UserAbleToMarkLateAsVoid();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		String paidBy = fn.getCustomGridDataValue("10");
		String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));

		String status = fn.getCustomGridDataValue("7");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(paidBy, "-", "Paid By/Applied By is not same.");
		soft.assertEquals(status, voidLabel, "void status is not same.");
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		soft.assertAll();

	}

	@Test(priority = 20, description = "Verify that 'Wavied' status appears for the void Late Fees under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyWaviedStatusAppearsForWavied_LateFee_OnTransactionsAll() throws InterruptedException {
		
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		crm.addLateFeeOnCDP();
		String voidLabel = crm.UserAbleToMarkLateFeeAsWavied();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		String paidBy = fn.getCustomGridDataValue("10");
		String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));
		String status = fn.getCustomGridDataValue("7");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(paidBy, "-", "PaidBy/Applied By is not same.");
		soft.assertEquals(status, voidLabel, "Waived status is not same.");
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		soft.assertAll();
	}

	@Test(priority = 21, description = "Auto-525 | Verify that CDP opens up  in a new tab after clicking the Late Fee Case ID link under 'Case Number' column, for Fines on 'Transactions' > 'All' Page.")
	public void finance_VerifyCDPOpensUpNewTabClickinOn_LateFee_CaseIDLinkOnTransactionFines()
			throws InterruptedException {

		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);

		crm.addLateFeeOnCDP();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(4);
		String actualCaseAssignee = fn.getCustomGridDataValue("14");
		String expectedCaseId = fn.getCustomGridDataValue("13");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + expectedCaseId + "']"));
		helper.clickOnElement(element);
		// element.click();
		helper.forcedWaitTime(4);
		String currentWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));

		helper.waitForPageLoadTime(3);
		helper.waitUntilElementIsVisible(CLPUtility.OpenedCaseId);
		String actualCaseId = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCaseId, expectedCaseId, "Case Id is not matched on CDP.");
		soft.assertEquals(actualCaseAssignee, caseAssignee, "Case Assignee on CDP and on finance All page not same.");

		soft.assertAll();

		getDriver().switchTo().window(currentWindow);
		// fn.clickOnClearAllFilter();
		helper.closeOtherTabs();

	}

	@Test(priority = 22, description = "Verify all the details of a Payment added on a case on 'Transactions' > 'All' Page.")
	public void finance_VerifyAllthe_Payments_AppliedOnCaseOnTranscationAll() throws InterruptedException {
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		CECommonMethods ce = new CECommonMethods(getDriver());
		String LoggedInUserName = helper.getTextElement(CLPUtility.AgencyUserName);
		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);
		crm.addFineOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);
		String upPaid = helper.getTextElement(CDP_Utility.unpaidButton);

		// Extracting Fine details

		String fineDetails = fine_Name_Amount.get(0).split(": Due")[0].trim() + ")";

		// Extract Date
		String dueDate = fine_Name_Amount.get(0).split(": Due")[1].trim().replace(")", "");

		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		String cleanedAmount = amount.replaceAll("[$,]", "").split("\\.")[0];
		// Convert to integer
		int amount1 = Integer.parseInt(cleanedAmount);

		String recipient = RandomStrings.requiredString(10);
		crm.addPaymentOnCDP(amount, null);
		String expectedPayorName = CRMCommonMethods.getPayorName();

		String paymentType = helper.getTextElement(CDP_Utility.addedPaymentType);
		String paymentAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		crm.closeFines_Payments_Details();
		
		String oustandingBalanceCDP = helper.getTextElement(OnlinePaymentUtility.BalnceOnCDP);
		
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);

		helper.waitForCurserRunning(4);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		String actualDueDate = fn.getGridData("2");

		String actualPaymentName = fn.getTransactionName();
		String actualTransactionId = fn.getTransactionIdGridData();
		String actualAddedOnDate = fn.getGridData("1");

		String type = fn.getCustomGridDataValue("5");
		String paymentReference = fn.getCustomGridDataValue("6");
		String status = fn.getCustomGridDataValue("7");
		String paidAmount = fn.getCustomGridDataValue("8");
		String outstandingBalance = fn.getCustomGridDataValue("9");
		// String clerk = fn.getCustomGridDataValue("10");
		String actualCaseAssignee = fn.getCustomGridDataValue("14");
		String actualCaseId = fn.getCustomGridDataValue("13");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));

		String actualAddedBy = fn.getCustomGridDataValue("15");
		String actualPaymentClerk = fn.getCustomGridDataValue("11");
		String actualPayorName = fn.getCustomGridDataValue("12");
		String actualAppliedTo = fn.getCustomGridDataValue("10");
		String fineTransactionId = fn.getCustomGridDataValue("17");
		WebElement amountEle = helper
				.findElement(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));
		String colorr = amountEle.getCssValue("color");
		String amount_hexColor = Color.fromString(colorr).asHex();
		Assert.assertNotNull(element.getAttribute("href"));

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualPaymentName, paymentType, "Payment type is not matched.");
		soft.assertFalse(actualTransactionId.isEmpty());
		soft.assertEquals(actualAddedOnDate, paymentAddedOnDate, "Payment Added on Date is not matched.");
		soft.assertEquals(paymentReference, "-", "Payment reference is not matched.");
		soft.assertEquals(type, "Cash", "Type is not matched.");
		soft.assertEquals(status, "Paid", "Payment status is not same.");
		soft.assertEquals(paidAmount, "-" + amount, "Amount in not same.");
		soft.assertEquals(outstandingBalance, "$0.00", "Balance is not same.");
		soft.assertEquals(outstandingBalance, oustandingBalanceCDP,"CDP Outstanding bal and Finance Outstanding bal is not same.");
		soft.assertEquals(actualDueDate, "-", "actual date is not matched.");
		soft.assertEquals(actualCaseAssignee, caseAssignee,
				"Case Assignee on CDP and on finance payment page not same.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same Logged In user.");
		soft.assertEquals(actualPayorName, expectedPayorName.split(" ")[0], "Payor Name is not matched.");
		soft.assertEquals(actualPaymentClerk, "Comcate Support", "payment clerk is not matched.");
		soft.assertEquals(amount_hexColor, "#00b125", "Refunded amount is not in Green color.");
        soft.assertEquals(actualAppliedTo, fineTransactionId,"Applied To is not same as fine or late transaction Id.");
		soft.assertAll();
	}

	@Test(priority = 23, description = "Verify that 'Void' status appears for the void Payments under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyVoidStatusAppearsForVoidPaymentOnTransactionsAll() throws InterruptedException {
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		CECommonMethods ce = new CECommonMethods(getDriver());
		String LoggedInUserName = helper.getTextElement(CLPUtility.AgencyUserName);
		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		String caseAssignee = helper.getTextElement(CDP_Utility.Assignee);
		crm.addFineOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();
		String recipient = RandomStrings.requiredString(10);
		crm.addPaymentOnCDP(amount, recipient);

		String voidLabel = crm.UserAbleToMarkPaymentAsVoid();

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		String status = fn.getCustomGridDataValue("7");
		String appliedTo = fn.getCustomGridDataValue("10");
		String paymentReference = fn.getCustomGridDataValue("6");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status, voidLabel, "Payment status is not same.");
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));
		List<String> status1 = helper
				.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.customeGridColListData, "7")));

		WebElement element = helper.findElement(By.xpath("//a[text()='" + status1.get(0) + "']"));
		String color = element.getCssValue("color");
		String hexColor = Color.fromString(color).asHex();

		soft.assertEquals(hexColor, "#0071b5", "Status color is not blue");
		soft.assertEquals(paymentReference, recipient, "Payment Reference is not same.");
		soft.assertTrue(Element_class.contains("is-nullified"));
		soft.assertEquals(appliedTo, "-", "Applied to status is not '-' for void payment.");

		// fn.clickOnClearAllFilter();
		soft.assertAll();
	}

	@Test(priority = 24, description = " Auto-537 | Verify that 'Refunded' status appears for the refunded Payments under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyRefundedStatusAppearsForRefundPaymentOnTransactionsAll() throws InterruptedException {
	

		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		crm.addFineOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		crm.addPaymentOnCDP(amount, null);

		int value = Integer.parseInt(amount.replaceAll("[^0-9]", "").substring(0, 3));

		String voidLabel = crm.UserAbleToRefundPayment(Integer.toString((value) * 100));
		String balAfterRefund = helper.getTextElement(FinanceUtility.paymentBal);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(2);
		List<String> status = helper
				.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.customeGridColListData, "7")));

		String amount_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "23")));

		WebElement refunded_amount = helper
				.findElement(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "8")));
		String colorr = refunded_amount.getCssValue("color");
		String refunded_amount_hexColor = Color.fromString(colorr).asHex();

		WebElement refunded = helper.findElement(By.xpath("//a[text()='" + status.get(1) + "']"));
		String color = refunded.getCssValue("color");
		String refunded_hexColor = Color.fromString(color).asHex();

		String outstandingBalance = fn.getCustomGridDataValue("9");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status.get(0), "Issued", "Ist row status is not Issued.");
		soft.assertEquals(status.get(1), voidLabel, "Payment status is not same.");
		soft.assertTrue(status.size() == 3, "3 row is not created.");
		soft.assertEquals(outstandingBalance, balAfterRefund, "Balance is not Same");
		soft.assertEquals(refunded_hexColor, "#0071b5", "Status color is not Blue");
		soft.assertTrue(amount_class.contains("is-nullified"), "Amount is not nullified.");
		soft.assertEquals(refunded_amount_hexColor, "#00b125", "Refunded amount is not in Green color.");

		// fn.clickOnClearAllFilter();
		soft.assertAll();
	}

	@Test(priority = 25, description = " Auto-536,538 | Verify that 'Partial Refunded' status appears for the refunded Payments under 'Status' column on 'Transactions' > 'All' Page.")
	public void finance_VerifyPartialRefundedStatusAppearsForRefund_Payment_OnTransactionsAll()
			throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		CECommonMethods ce = new CECommonMethods(getDriver());

		ce.createCaseCCP();
		helper.refreshPage();
		helper.waitForCurserRunning(6);
		helper.forcedWaitTime(4);
		String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];

		crm.addFineOnCDP();

		List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
		// Extract Amount
		String amount = fine_Name_Amount.get(1).trim();

		crm.addPaymentOnCDP(amount, null);

		int value = Integer.parseInt(amount.replaceAll("[^0-9]", "").substring(0, 3));

		String voidLabel = crm.UserAbleToRefundPayment(Integer.toString((value - 100) * 100));
		
		String balAfterRefund = helper.getTextElement(FinanceUtility.paymentBal);

		
		
		List<String> refundedAmountExp = helper
				.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "12")));

		

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);

		List<String> status = helper
				.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.customeGridColListData, "7")));

		String amount_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "23")));

		
		
		
		List<String> partialRefundedAmount = helper
				.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "23")));

		WebElement refunded = helper.findElement(By.xpath("//a[text()='" + status.get(1) + "']"));
		String color = refunded.getCssValue("color");
		String refunded_hexColor = Color.fromString(color).asHex();

		String outstandingBalance = fn.getCustomGridDataValue("9");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status.get(0), "Issued", "Ist row status is not Issued.");
		soft.assertEquals(status.get(1), voidLabel, "Payment status is not same.");
		soft.assertTrue(status.size() == 3, "3 row is not created.");
		soft.assertEquals(refunded_hexColor, "#0071b5", "Status color is not blue");
		soft.assertTrue(amount_class.contains("is-nullified"));
		soft.assertEquals(outstandingBalance, balAfterRefund, "Balance is not Same");
		soft.assertEquals(partialRefundedAmount.get(1),refundedAmountExp.get(1), "partialRefundedAmount is not same");

		// fn.clickOnClearAllFilter();
		soft.assertAll();
	}
	
	@Test(priority = 26,description = "Verify that user is able to select any option from 'Amount' dropdown, on 'Transactions' > 'All' Page.")
	public void finance_VerifyAmountDropDwonFilter() throws InterruptedException {
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Amount ");
		fn.sendValueToFrom("amount","fromNumber","5");
		fn.sendValueToFrom("amount","toNumber","10");
		fn.clickOnfilterApplyBtn("amount");
		List<String> searchFilterAmount = fn.getCustomGridColData("8");
		
		for (String amt : searchFilterAmount) {
		    // Extract numeric part, including decimals
		    String numericValue = amt.replaceAll("[^0-9.]", ""); 

		    // Ensure the extracted string is not empty and contains at most one dot (to avoid cases like "5..34")
		    if (!numericValue.isEmpty() && numericValue.matches("\\d+(\\.\\d+)?")) { 
		        double value = Double.parseDouble(numericValue);
		        Assert.assertTrue(value >= 5.0 && value <= 10.0, "Value " + value + " is out of range");
		    } 
		}

	}
	
	
	
	
	@Test(priority = 27,description = "Verify that user is able to select any option from 'Added On' dropdown, on 'Transactions' > 'All' Page.")
	public void finance_VerifyAddedOnDropDwonFilter() throws InterruptedException {
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String currentDate = DateAndTime.getCurrentDate("MM/dd/yyyy");
		String previousDate = DateAndTime.getPreviosDate("MM/dd/yyyy",7);
		
		LocalDate currentLocalDate = LocalDate.parse(currentDate, formatter);
        LocalDate previousLocalDate = LocalDate.parse(previousDate, formatter);
        
        String day = previousLocalDate.format(DateTimeFormatter.ofPattern("d"));

		fn.clickOnFilterArrows("Added On");
		fn.clickOnDatePicker("fromDate");
		fn.pickDateToDatePicker("fromDate",day);
		fn.clickOnfilterApplyBtn("createdAt");
		List<String> searchFilterAddedOn = fn.getCustomGridColData("3");
		
		 for (String dateStr : searchFilterAddedOn) {
	            // Convert date string to LocalDate
	            LocalDate date = LocalDate.parse(dateStr, formatter);

	            // Assert that the date is within the range (inclusive)
	            Assert.assertTrue((date.isEqual(previousLocalDate) || date.isEqual(currentLocalDate) || 
	                (date.isAfter(previousLocalDate) && date.isBefore(currentLocalDate))),"Date " + dateStr + " is out of the valid range!");
	        }
	}
	
	
	
	
	@Test(priority = 28,description = "Verify that user is able to select any option from 'Outstanding Balance' dropdown, on 'Transactions' > 'All' Page.")
	public void finance_VerifyOutStandingBalanceDropDwonFilter() throws InterruptedException {
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Outstanding Balance");
		fn.sendValueToFrom("outstandingBalance","fromNumber","10");
		fn.sendValueToFrom("outstandingBalance","toNumber","20");
		fn.clickOnfilterApplyBtn("outstandingBalance");
		List<String> searchFilterAmount = fn.getCustomGridColData("9");
		
		for (String amt : searchFilterAmount) {
		    // Extract numeric part, including decimals
		    String numericValue = amt.replaceAll("[^0-9.]", ""); 

		    // Ensure the extracted string is not empty and contains at most one dot (to avoid cases like "5..34")
		    if (!numericValue.isEmpty() && numericValue.matches("\\d+(\\.\\d+)?")) { 
		        double value = Double.parseDouble(numericValue);
		        Assert.assertTrue(value >= 10.0 && value <= 20.0, "Value " + value + " is out of range");
		    } 
		}

	}
	
	@Test(priority = 29,description = "Verify that user is able to select any option from 'Status' dropdown, on 'Transactions' > 'All' Page.")
	public void finance_VerifyStatusDropDwonFilter() throws InterruptedException {
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("All");
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Status");
		fn.checkedStatus("status","Unpaid");
		List<String> searchFilterStatus = fn.getCustomGridColData("7");
		
		for (String status : searchFilterStatus) {
		    
		    
		        Assert.assertTrue(status.equalsIgnoreCase("Unpaid"), "Unpaid " + status + " is not matched.");
		}

	}
	
	
	
	
	@Test(priority = 30, description = "Verify that all type of transactions appear on 'Transactions' > 'All' Page.")
	public void finance_VerifyAllTransactionAppearOnTransactionAll() throws InterruptedException {
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(10);
		helper.forcedWaitTime(2);
		//fn.clickOnTransactionToggel("Fines");
		
		
		List<String> finesTransactions = fn.getTransactionsListColData();
		for (String fine : finesTransactions) {
			Assert.assertTrue(fine.startsWith("fine") ||
					fine.startsWith("Late Fee") ||  
					fine.startsWith("Fine") || 
					fine.startsWith("late fee") ||
					fine.startsWith("payments") || 
					fine.startsWith("Payments") ||
					fine.startsWith("Payment") ||
					fine.startsWith("Refund") || 
					fine.startsWith("Partial"));
		}
		

		//fn.clickOnClearAllFilter();
	}
	
	


}
