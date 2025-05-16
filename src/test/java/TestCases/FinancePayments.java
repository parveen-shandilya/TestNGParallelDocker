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

public class FinancePayments extends BrowsersInvoked {

	
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
			log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
		}
	}

	@Test(priority = 1, description = "Verify that defult selected filter on 'Transactions' 'Payments' Page.")
	public void finance_VerifyDefaultSelectedFilterOptionsOnTransactionPayments() throws InterruptedException {

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);

		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);

		fn.clickOnTransactionToggel("Payments");

		Boolean filter = fn.clearALLFilterDisplyed();
		Boolean searchInput = fn.searchInputDisplyed();

		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "Payments")));
		String amountOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Amount")));

		String addedOnOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Added On")));

		String outStandingOption = helper.getTextElement(
				By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Outstanding Balance")));

		String statusOption = helper
				.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.financeDrpSelected, "Status")));

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(amountOption, "Any");
		soft.assertEquals(addedOnOption, "Any Time");
		soft.assertEquals(outStandingOption, "Any");
		soft.assertEquals(statusOption, "All");
		soft.assertTrue(Element_class.contains("btn-primary"), "Btn class is not metched");
		soft.assertTrue(searchInput, "search filed is not appear");
		soft.assertTrue(filter, "clear All Filter is not appear");
		soft.assertAll();
	}

	@Test(priority = 2, description = "Verify that appropriate transaction appears after searching with any 'Case Assignee' name, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifySearchByAssigneeOnTranscationPayments() throws InterruptedException {

//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
   	
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
//    	   
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);

		String caseAssignee = fn.getGridData("8");
		fn.enterDataSearchInput(caseAssignee);
		helper.forcedWaitTime(2);
		String caseAssigneeAfter = fn.getGridData("8");
		List<String> searchAssigneeList = fn.getGridColData("13");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(caseAssigneeAfter, caseAssignee);
		soft.assertAll();
		for (String assignee : searchAssigneeList) {
			Assert.assertEquals(assignee, caseAssignee);

		}

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 3, description = "Verify that appropriate transaction appears after searching with any 'TransactionId'  on 'Transactions' > 'Payments' Page.")
	public void finance_VerifySearchByTransactionIdOnTranscationPayments() throws InterruptedException {
		fn.clickOnClearAllFilter();
//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
//    	
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);   
		fn.clickOnTransactionToggel("Payments");
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

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 4, description = "Verify that appropriate transaction appears after searching with any 'Case Number'  on 'Transactions' > 'Payments' Page.")
	public void finance_VerifySearchByCaseNumberOnTranscationPayments() throws InterruptedException {
		fn.clickOnClearAllFilter();
//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
//    	
		Helper helper = new Helper(getDriver());
    	   helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
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

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 5, description = "Verify that 'No transaction to display' message appear after searching with no deatil Transaction  on 'Transactions' > 'Payments' Page.")
	public void finance_VerifySearchByNoTransactionOnTranscationPayments() throws InterruptedException {

//   	LoginTest();
//   	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);

		String transactionId3 = RandomStrings.requiredDigits(10);
		String transactionId2 = RandomStrings.requiredDigits(4);
		String transactionId1 = RandomStrings.requiredDigits(2);

		String transactionId = String.join("-", transactionId1, transactionId2, transactionId3);

		fn.enterDataSearchInput(transactionId);
		helper.forcedWaitTime(2);
		String actualMessage = fn.getNoTransactionMessage();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualMessage, CRMConstants.No_Transaction_message);
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 6, description = "Verify that user is able to download CSV file after clicking 'Download CSV' button, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifydownlodeCSVfileTranscationPayments() throws InterruptedException {

//   	LoginTest();
//   	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
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
		String file_Name = "Payments_Transactions" + "_" + timesdate[0] + "_" + times[0] + "_" + times[1] + " "
				+ timesdate1[2].toLowerCase() + ".csv";
		System.out.println(file_Name);
		String FileStatus = CheckDownloadedFile.isFileDownloaded(file_Name,BrowsersInvoked.directory);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cSVBtn, "CSV download button is not vissible.");
		soft.assertEquals(FileStatus, "File Present");

		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 7, description = "Verify that only 'Payments' transaction appears under 'Payments' toggle, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyOnlyPaymentTransactionOnTransactionPayments() throws InterruptedException {

//     	LoginTest();
		//crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(4);

		List<String> lateFeeTransactions = fn.getTransactionsListColData();
		for (String lateFee : lateFeeTransactions) {
			Assert.assertTrue(lateFee.contains("Payment") || lateFee.startsWith("Refund") || lateFee.contains("Partial Refund"),
					"payments is not added in the Transaction.");
			Assert.assertFalse(lateFee.startsWith("Fines") || lateFee.startsWith("fines"),
					"fine added in the payment Transaction.");
			Assert.assertFalse(lateFee.startsWith("Late Fee") || lateFee.startsWith("late fee"),
					"late fee Added in the payment Transaction.");
		}

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 8, description = "Verify all the details of a Payment added on a case on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyAllthePaymentsAppliedOnCaseOnTranscationPayments() throws InterruptedException {
		//LoginTest();
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
		String expectedPayorName =  (CRMCommonMethods.getPayorName()).split(" ")[0];

		String paymentType = helper.getTextElement(CDP_Utility.addedPaymentType);
		String paymentAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);

		fn.clickOnTransactionToggel("All");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		
		String actualDueDate = fn.getGridData("2");
		String statusOn_All_Page = fn.getCustomGridDataValue("7");
		
		
		fn.clickOnTransactionToggel("Fines");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		String actualFineTransactionId = fn.getTransactionIdGridData();
		

		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(2);
		helper.forcedWaitTime(2);

		String actualPaymentName = fn.getTransactionName();
		String actualTransactionId = fn.getTransactionIdGridData();
		String actualAddedOnDate = fn.getGridData("1");

		String type = fn.getCustomGridDataValue("4");
		String paymentReference = fn.getCustomGridDataValue("5");
		String status = fn.getCustomGridDataValue("6");
		String paidAmount = fn.getCustomGridDataValue("7");
		String outstandingBalance = fn.getCustomGridDataValue("8");
		String clerk = fn.getCustomGridDataValue("10");
		String actualCaseAssignee = fn.getGridData("8");
		String actualCaseId = fn.getCustomGridDataValue("12");
		WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));

		String actualAddedBy = fn.getCustomGridDataValue("14");
		String actualPaymentClerk = fn.getCustomGridDataValue("10");
		String actualPayorName = fn.getCustomGridDataValue("11");
		String actualAppliedTo = fn.getCustomGridDataValue("9");

		Assert.assertNotNull(element.getAttribute("href"));

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualPaymentName, paymentType,"Payment type is not matched.");
		soft.assertFalse(actualTransactionId.isEmpty());
		soft.assertEquals(actualAddedOnDate, paymentAddedOnDate,"Payment Added on Date is not matched.");
		soft.assertEquals(paymentReference, "-","Payment reference is not matched.");
		soft.assertEquals(type, "Cash","Type is not matched.");
		soft.assertEquals(status, "Paid", "Payment status is not same.");

		soft.assertEquals(statusOn_All_Page, "Paid", "Payment status is not same on All.");
		soft.assertEquals(paidAmount, "-" + amount, "Amount in not same.");
		soft.assertEquals(outstandingBalance, "$0.00", "Balance is not same.");
		soft.assertEquals(actualDueDate, "-","actual date is not matched.");
		soft.assertEquals(actualCaseAssignee, caseAssignee,
				"Case Assignee on CDP and on finance payment page not same.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same Logged In user.");
		soft.assertEquals(actualPayorName, expectedPayorName,"Payor Name is not matched.");
        soft.assertEquals(actualPaymentClerk, "Comcate Support","payment clerk is not matched.");
        soft.assertEquals(actualAppliedTo, actualFineTransactionId,"Applied to is not matched.");
		//fn.clickOnClearAllFilter();
		soft.assertAll();
	}

	@Test(priority = 9, description = "Verify that next and previous pagination under 'Payments' toggle, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyNextAndPreviousPaginationOnTransactionPayments() throws InterruptedException {

//		LoginTest();
//		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(5);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);

		// Transaction Id on first page
		String transactionId_1 = fn.getTransactionIdGridData();
		fn.clickOnNextBtn();
		helper.forcedWaitTime(3);

		// Transaction Id on second page
		String transactionId_2 = fn.getTransactionIdGridData();

		fn.clickOnPreviousBtn();
		helper.forcedWaitTime(3);
		// Transaction Id on first page
		String transactionId_3 = fn.getTransactionIdGridData();

		fn.clickOnNextBtn();
		helper.forcedWaitTime(3);
		// Transaction Id on second page
		String transactionId_4 = fn.getTransactionIdGridData();

		fn.clickOnClearAllFilter();
        helper.waitForCurserRunning(5);
		SoftAssert soft = new SoftAssert();
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "All")));
		soft.assertTrue(Element_class.contains("btn-primary"));
		
		soft.assertEquals(transactionId_2, transactionId_4);
		soft.assertEquals(transactionId_1, transactionId_3);
		soft.assertAll();
		
	}
	
	
	@Test(priority = 10, description = "Verify that CDP opens up  in a new tab after clicking the Case ID link under 'Case Number' column, for Payments on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyCDPOpensUpNewTabClickinOnCaseIDLinkOnTransactionPayments() throws InterruptedException {

//		LoginTest();
//		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(5);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		String expectedCaseId = fn.getCustomGridDataValue("12");
    	WebElement element = helper.findElement(By.xpath("//a[text()='" + expectedCaseId + "']"));
    	helper.clickOnElement(element);
    	//element.click();
		helper.forcedWaitTime(4);
		String currentWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		
		helper.waitForPageLoadTime(3);
		helper.waitUntilElementIsVisible(CLPUtility.OpenedCaseId);
		String actualCaseId = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
		

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCaseId, expectedCaseId,"Case Id is not matched on CDP.");
		soft.assertAll();
		
		getDriver().switchTo().window(currentWindow);
		//fn.clickOnClearAllFilter();
		
		
	}
	
	
	
	@Test(priority = 11, description = "Verify that 'Void' status appears for the void Payments under 'Status' column on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyVoidStatusAppearsForVoidPaymentOnTransactionsPayments() throws InterruptedException {
		//LoginTest();
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

		crm.addPaymentOnCDP(amount, null);
		
		String voidLabel = crm.UserAbleToMarkPaymentAsVoid();


		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		String status = fn.getCustomGridDataValue("6");
		String appliedTo = fn.getCustomGridDataValue("9");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status, voidLabel, "Payment status is not same.");
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "7")));
		
		WebElement element = helper.findElement(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "7")));
		String color = element.getCssValue("color");
		String hexColor = Color.fromString(color).asHex(); 
		
		soft.assertEquals(hexColor, "#00b125", "Element color is not green"); 
		soft.assertTrue(Element_class.contains("is-nullified"));
		
		soft.assertTrue(Element_class.contains("is-nullified"));
		soft.assertEquals(appliedTo, "-","Applied to status is not '-' for void payment.");
		

		//fn.clickOnClearAllFilter();
		soft.assertAll();
	}
	
	
	
	@Test(priority = 12, description = " Auto-673 | Verify that 'Partially Refunded' status appears for the partially refunded Payments under 'Status' column on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyPartialRefundedStatusAppearsForPartialRefundPaymentOnTransactionsPayments() throws InterruptedException {
		//LoginTest();

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
		
		String voidLabel = crm.UserAbleToRefundPayment(Integer.toString((value - 100)*100));
        String balAfterRefund = helper.getTextElement(FinanceUtility.paymentBal);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		List<String> status = helper.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.customeGridColListData, "6")));
		
		WebElement element = helper.findElement(By.xpath("//a[text()='" + status.get(1) + "']"));
		String color = element.getCssValue("color");
		String hexColor = Color.fromString(color).asHex();
		
		
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.nullPartialAmt, "21","1")));
		String actualBal = helper.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.nullPartialAmt, "7","1")));
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status.get(0), "Issued", "Ist row status is not Issued.");
		soft.assertEquals(status.get(1), voidLabel, "Payment status is not same.");
		soft.assertTrue(status.size() == 2,"2 row is not created.");
		soft.assertEquals(hexColor, "#0071b5", "Status color is not blue");
		soft.assertTrue(Element_class.contains("is-nullified"));
		soft.assertEquals(actualBal, balAfterRefund, "Balance is not Same");
		
		
		//fn.clickOnClearAllFilter();
		soft.assertAll();
	}
	
	
	@Test(priority = 13, description = " Auto-674 | Verify that 'Refunded' status appears for the refunded Payments under 'Status' column on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyRefundedStatusAppearsForRefundPaymentOnTransactionsPayments() throws InterruptedException {
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
		
		String voidLabel = crm.UserAbleToRefundPayment(Integer.toString((value)*100));
        String balAfterRefund = helper.getTextElement(FinanceUtility.paymentBal);

		crm.closeFines_Payments_Details();
		ce.closeCaseDetailPage();

		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		List<String> status = helper.getElementTextList(By.xpath(helper.selectorFormate(FinanceUtility.customeGridColListData, "6")));
		
		
		
		String actualBal = helper.getTextElement(By.xpath(helper.selectorFormate(FinanceUtility.nullPartialAmt, "7","1")));
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status.get(0), "Issued", "Ist row status is not Issued.");
		soft.assertEquals(status.get(1), voidLabel, "Payment status is not same.");
		soft.assertTrue(status.size() == 2,"2 row is not created.");
		soft.assertEquals(actualBal, balAfterRefund, "Balance is not Same");
		
		
		//fn.clickOnClearAllFilter();
		soft.assertAll();
	}
	
	
	
	
	@Test(priority = 14,description = "Verify that user is able to select any option from 'Amount' dropdown, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyAmountDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Amount ");
		fn.sendValueToFrom("amount","fromNumber","5");
		fn.sendValueToFrom("amount","toNumber","10");
		fn.clickOnfilterApplyBtn("amount");
		helper.forcedWaitTime(3);
		List<String> searchFilterAmount = fn.getCustomGridColData("7");
		
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
	
	
	
	
	@Test(priority = 15,description = "Verify that user is able to select any option from 'Added On' dropdown, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyAddedOnDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		
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
	
	
	
	
	@Test(priority = 16,description = "Verify that user is able to select any option from 'Outstanding Balance' dropdown, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyOutStandingBalanceDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Outstanding Balance");
		fn.sendValueToFrom("outstandingBalance","fromNumber","10");
		fn.sendValueToFrom("outstandingBalance","toNumber","20");
		fn.clickOnfilterApplyBtn("outstandingBalance");
		List<String> searchFilterAmount = fn.getCustomGridColData("8");
		
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
	
	@Test(priority = 17,description = "Verify that user is able to select any option from 'Status' dropdown, on 'Transactions' > 'Payments' Page.")
	public void finance_VerifyStatusDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Payments");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Status");
		fn.checkedStatus("status","Paid");
		List<String> searchFilterStatus = fn.getCustomGridColData("6");
		
		for (String status : searchFilterStatus) {
		    
		    
		        Assert.assertTrue(status.equalsIgnoreCase("Paid"), "Paid " + status + " is not matched.");
		}

	}

}
