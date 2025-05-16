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

public class FinanceFines extends BrowsersInvoked {

	
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

	
	
	@Test(priority = 1, description = "Verify that defult selected filter on 'Transactions' 'Fine' Page.")
	public void finance_VerifyDefaultSelectedFilterOptionsOnTransactionFine() throws InterruptedException {

//    	LoginTest();
    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);

		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		Boolean filter = fn.clearALLFilterDisplyed();
		Boolean searchInput = fn.searchInputDisplyed();

		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "Fines")));
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
		soft.assertTrue(filter, "clear All Filter is not appear");
		soft.assertTrue(searchInput, "search filed is not appear");
		soft.assertAll();
	}
	
	@Test(priority = 2, description = "Verify that appropriate transaction appears after searching with any 'Case Assignee' name, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifySearchByAssigneeOnTranscationFines() throws InterruptedException {

//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
//    	
		Helper helper = new Helper(getDriver());
//    	   
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);

		String caseAssignee = fn.getGridData("5");
		fn.enterDataSearchInput(caseAssignee);
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		String caseAssigneeAfter = fn.getGridData("5");
		List<String> searchAssigneeList = fn.getGridColData("10");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(caseAssigneeAfter, caseAssignee);
		soft.assertAll();
		for (String assignee : searchAssigneeList) {
			Assert.assertEquals(assignee, caseAssignee);

		}

		//fn.clickOnClearAllFilter();
	}

	@Test(priority = 3, description = "Verify that appropriate transaction appears after searching with any 'Case Number'  on 'Transactions' > 'Fines' Page.")
	public void finance_VerifySearchByCaseNumberOnTranscationFines() throws InterruptedException {

//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
    	helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);

		String caseNumber = fn.getCaseNumGridData();
		fn.enterDataSearchInput(caseNumber);
		helper.waitForCurserRunning(3);
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
	
	
	@Test(priority = 4, description = "Verify that appropriate transaction appears after searching with any 'TransactionId'  on 'Transactions' > 'Fines' Page.")
	public void finance_VerifySearchByTransactionIdOnTranscationFines() throws InterruptedException {

//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
//    	
		Helper helper = new Helper(getDriver());
		fn.clickOnClearAllFilter(); 
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);

		String transactionId = fn.getTransactionIdGridData();
		fn.enterDataSearchInput(transactionId);
		helper.waitForCurserRunning(3);
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
	
	
	@Test(priority = 5, description = "Verify that 'No transaction to display' message appear after searching with no deatil Transaction  on 'Transactions' > 'Fines' Page.")
	public void finance_VerifySearchByNoTransactionOnTranscationFines() throws InterruptedException {

//    	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);

		String transactionId3 = RandomStrings.requiredDigits(10);
		String transactionId2 = RandomStrings.requiredDigits(4);
		String transactionId1 = RandomStrings.requiredDigits(2);

		String transactionId = String.join("-", transactionId1, transactionId2, transactionId3);

		fn.enterDataSearchInput(transactionId);
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		String actualMessage = fn.getNoTransactionMessage();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualMessage, CRMConstants.No_Transaction_message);
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	
	
	@Test(priority = 6, description = "Verify that user is able to download CSV file after clicking 'Download CSV' button, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifydownlodeCSVfileTranscationFines() throws InterruptedException {

//   	LoginTest();
//   	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
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
		String file_Name = "Fines_Transactions" + "_" + timesdate[0] + "_" + times[0] + "_" + times[1] + " " + timesdate1[2].toLowerCase()
				+ ".csv";
        System.out.println(file_Name);
		String FileStatus = CheckDownloadedFile.isFileDownloaded(file_Name,BrowsersInvoked.directory);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cSVBtn, "CSV download button is not vissible.");
		soft.assertEquals(FileStatus, "File Present");

		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	
	
	@Test(priority = 7, description = "Verify all the details of a fine applied on a case on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyAlltheFineDetailsAppliedOnCaseOnTranscationFines() throws InterruptedException {
//		LoginTest();
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		CECommonMethods ce = new CECommonMethods(getDriver());
    	
		ce.createCaseCCP();
    	String caseNumber = helper.getTextElement(CLPUtility.OpenedCaseId).split("#")[1];
    	crm.addFineOnCDP();
    	
    	
    	List<String> fine_Name_Amount = helper.getElementTextList(CDP_Utility.AddedfineDetails);
    	String fineAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);
    	String upPaid = helper.getTextElement(CDP_Utility.unpaidButton);

    	
    	// Extracting Fine details
    	
        String fineDetails = fine_Name_Amount.get(0).split(": Due")[0].trim()+")";  

        // Extract Date
        String dueDate = fine_Name_Amount.get(0).split(": Due")[1].trim().replace(")", "");  

        // Extract Amount
        String amount = fine_Name_Amount.get(1).trim();  
    	
    	
    	crm.closeFines_Payments_Details();
    	ce.closeCaseDetailPage();
    	
    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);


        helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);

		
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
		
        String actualFineName = fn.getTransactionName();
        String actualTransactionId = fn.getTransactionIdGridData();
        String actualAddedOnDate = fn.getGridData("1");
        String actualDueDate = fn.getGridData("2");
        
        String paidBy = fn.getCustomGridDataValue("8");
       
        String status = fn.getCustomGridDataValue("5");
        String actualAmount = fn.getCustomGridDataValue("6");
        String balance = fn.getCustomGridDataValue("7");
        
        
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualFineName, fineDetails,"Fine name is not matched.");
		soft.assertFalse(actualTransactionId.isEmpty(),"Transaction Id is null.");
		soft.assertEquals(actualAddedOnDate, fineAddedOnDate,"Fine Added on Date is not same.");
		soft.assertEquals(actualDueDate, dueDate,"Fine Due date is not same.");
		soft.assertEquals(paidBy, "-","Type is not same.");
		
		soft.assertEquals(status, upPaid,"Fine status is not same.");
		soft.assertEquals(actualAmount, amount,"Amount in not same.");
		soft.assertEquals(balance, amount,"Balance is not same.");
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	@Test(priority = 8, description = "Verify that only 'Fines' transaction appears under 'Fines' toggle, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyOnlyFinesTransactionOnTransactionFines() throws InterruptedException {

//     	LoginTest();
//    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(2);
		fn.clickOnTransactionToggel("Fines");
		helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);
		
		List<String> finesTransactions = fn.getTransactionsListColData();
		for (String fine : finesTransactions) {
			Assert.assertTrue(fine.contains("fine") || fine.contains("Fine") ,"Fine is not present.");
			Assert.assertFalse(fine.contains("Late Fees") || fine.contains("late fees"),"Late Fees Added in the fine Transaction.");
			Assert.assertFalse(fine.contains("payments") || fine.contains("Payments") || fine.contains("Refund"),"Payments Added in the fine Transaction.");
		}
		

		//fn.clickOnClearAllFilter();
	}
	
	
	
	@Test(priority = 9, description = "Verify that 'Paid' status appears for the paid Fines under 'Status' column on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyPaidPaymentAppliedOnCaseOnTranscationFines() throws InterruptedException {
//		LoginTest();
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
    	String upPaid = helper.getTextElement(CDP_Utility.unpaidButton);

    	
    	// Extracting Fine details
    	
        String fineDetails = fine_Name_Amount.get(0).split(": Due")[0].trim()+")";  

        // Extract Date
        String dueDate = fine_Name_Amount.get(0).split(": Due")[1].trim().replace(")", "");  

        // Extract Amount
        String amount = fine_Name_Amount.get(1).trim();
        
        String cleanedAmount = amount.replaceAll("[$,]", "").split("\\.")[0];
        // Convert to integer
        int amount1 = Integer.parseInt(cleanedAmount);
        
        String recipient = RandomStrings.requiredString(10);
        
        // Make a payment
        crm.addPaymentOnCDP(amount,null);
        
        String balAfterPayment = helper.getTextElement(FinanceUtility.paymentBal);

        
    	String paymentType = helper.getTextElement(CDP_Utility.addedPaymentType);
    	String paymentAddedOnDate = helper.getTextElement(CDP_Utility.fineAddedOnDate);
    	
    	crm.closeFines_Payments_Details();
    	ce.closeCaseDetailPage();
    	
    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
    	
    	fn.clickOnTransactionToggel("Fines");
    	helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);

    	String actual_addedDate_2 = fn.getGridData("1");
    	String statusOn_Fines_Page = fn.getCustomGridDataValue("5");
    	String balance = fn.getCustomGridDataValue("7");
    	
    	String appliedTo = fn.getCustomGridDataValue("8");
    	
    	fn.clickOnTransactionToggel("Payments");
    	helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);
    	
		String transactionId_1 = fn.getTransactionIdGridData();
		
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(statusOn_Fines_Page, "Paid","Payment status is not same on Fines.");
		soft.assertEquals(actual_addedDate_2, paymentAddedOnDate);
		soft.assertEquals(balance, balAfterPayment,"Outstanding Balance is not same.");
		soft.assertEquals(appliedTo, transactionId_1,"applied to is not same.");
		
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	
	
	
	
	
	@Test(priority = 10, description = "Verify all the details of a Partial Payment added on a case on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyPartialPaymentAppliedOnCaseOnTranscationFines() throws InterruptedException {
		//LoginTest();
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
        
        
        // Make a partial Payment 
        crm.addPaymentOnCDP(Integer.toString(amount1 - 50),null);
    	crm.closeFines_Payments_Details();
    	ce.closeCaseDetailPage();
    	
    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
    	
    	fn.clickOnTransactionToggel("Fines");
    	helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);

    	String actual_addedDate_2 = fn.getCustomGridDataValue("3");
    	String statusOn_Fines_Page = fn.getCustomGridDataValue("5");
    
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_Fines_Page, "Partially Paid","Payment status is not same.");
		
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	
	
	@Test(priority = 11, description = "Verify that 'Void' status appears for the void Fines under 'Status' column on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyVoidStatusAppearsForVoidFineOnTransactionsFines() throws InterruptedException {
		//LoginTest();
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
    	
    	fn.clickOnTransactionToggel("Fines");
    	helper.waitForCurserRunning(4);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);

		String actual_addedDate_2 = fn.getCustomGridDataValue("3");
    	String statusOn_Fines_Page = fn.getCustomGridDataValue("5");
    	String paidBy = fn.getCustomGridDataValue("8");
    	String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "6")));
		
    
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_Fines_Page, voidLabel,"void status is not same.");
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		soft.assertEquals(paidBy, "-","Type is not same.");
		
		fn.clickOnClearAllFilter();
		helper.waitForCurserRunning(5);
		String Element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.transactionToggels, "All")));
		Assert.assertTrue(Element_class.contains("btn-primary"));
		
		soft.assertAll();
	}
	
	
	
	@Test(priority = 12, description = "Verify that 'Waive' status appears for the Waive Fines under 'Status' column on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyWaiveStatusAppearsForWaiveFineOnTransactionsFines() throws InterruptedException {
		//LoginTest();
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
    	ce.closeCaseDetailPage();
    	
    	crm.navigateToTopNavigation(FinanceUtility.financeMenu);
    	
    	fn.clickOnTransactionToggel("Fines");
    	helper.waitForCurserRunning(5);
		helper.forcedWaitTime(3);
		fn.enterDataSearchInput(caseNumber);
		helper.forcedWaitTime(2);

		String actual_addedDate_2 = fn.getCustomGridDataValue("3");
    	String statusOn_Fines_Page = fn.getCustomGridDataValue("5");
    	String paidBy = fn.getCustomGridDataValue("8");
    	
    	String actualCaseAssignee = fn.getCustomGridDataValue("10");
    	String actualAddedBy = fn.getCustomGridDataValue("11");
    	String actualCaseId = fn.getCustomGridDataValue("9");
    	WebElement element = helper.findElement(By.xpath("//a[text()='" + actualCaseId + "']"));
    	String amount_element_class = fn
				.getElementClass(By.xpath(helper.selectorFormate(FinanceUtility.amountnullified, "6")));
		
    	
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_addedDate_2, fineAddedOnDate);
		soft.assertEquals(statusOn_Fines_Page, voidLabel,"Status is not same.");
		soft.assertEquals(actualCaseAssignee, caseAssignee,
				"Case Assignee on CDP and on finance Fines page not same.");
		soft.assertEquals(actualAddedBy, LoggedInUserName, "Added By is not same Logged In user.");
		soft.assertNotNull(element.getAttribute("href"));
		soft.assertTrue(amount_element_class.contains("is-nullified"));
		soft.assertEquals(paidBy, "-","Type is not same.");
		
		soft.assertAll();

		//fn.clickOnClearAllFilter();
	}
	
	
	@Test(priority = 13, description = "Verify that next and previous pagination under 'Payments' toggle, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyNextAndPreviousPaginationOnTransactionFines() throws InterruptedException {
		fn.clickOnClearAllFilter();
//		LoginTest();
//		crm.navigateToTopNavigation(FinanceUtility.financeMenu);

		Helper helper = new Helper(getDriver());

		fn.clickOnTransactionToggel("Fines");
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

		

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(transactionId_2, transactionId_4);
		soft.assertEquals(transactionId_1, transactionId_3);
		soft.assertAll();
	}
	
	
	
	@Test(priority = 14, description = "Verify that CDP opens up  in a new tab after clicking the Case ID link under 'Case Number' column, for Payments on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyCDPOpensUpNewTabClickinOnCaseIDLinkOnTransactionFines() throws InterruptedException {

//		LoginTest();
//		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		fn.clickOnClearAllFilter();
		Helper helper = new Helper(getDriver());

		fn.clickOnTransactionToggel("Fines");
		helper.forcedWaitTime(3);
		String expectedCaseId = fn.getCustomGridDataValue("9");
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
	
	
	
	@Test(priority = 15,description = "Verify that user is able to select any option from 'Amount' dropdown, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyAmountDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Fines");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Amount ");
		fn.sendValueToFrom("amount","fromNumber","100");
		fn.sendValueToFrom("amount","toNumber","500");
		fn.clickOnfilterApplyBtn("amount");
		List<String> searchFilterAmount = fn.getCustomGridColData("6");
		
		for (String amt : searchFilterAmount) {
		    // Extract numeric part, including decimals
		    String numericValue = amt.replaceAll("[^0-9.]", ""); 

		    // Ensure the extracted string is not empty and contains at most one dot (to avoid cases like "5..34")
		    if (!numericValue.isEmpty() && numericValue.matches("\\d+(\\.\\d+)?")) { 
		        double value = Double.parseDouble(numericValue);
		        Assert.assertTrue(value >= 100.0 && value <= 500.0, "Value " + value + " is out of range");
		    } 
		}

	}
	
	
	
	
	@Test(priority = 16,description = "Verify that user is able to select any option from 'Added On' dropdown, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyAddedOnDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Fines");
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
	
	
	
	
	@Test(priority = 17,description = "Verify that user is able to select any option from 'Outstanding Balance' dropdown, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyOutStandingBalanceDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Fines");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Outstanding Balance");
		fn.sendValueToFrom("outstandingBalance","fromNumber","100");
		fn.sendValueToFrom("outstandingBalance","toNumber","200");
		fn.clickOnfilterApplyBtn("outstandingBalance");
		List<String> searchFilterAmount = fn.getCustomGridColData("7");
		
		for (String amt : searchFilterAmount) {
		    // Extract numeric part, including decimals
		    String numericValue = amt.replaceAll("[^0-9.]", ""); 

		    // Ensure the extracted string is not empty and contains at most one dot (to avoid cases like "5..34")
		    if (!numericValue.isEmpty() && numericValue.matches("\\d+(\\.\\d+)?")) { 
		        double value = Double.parseDouble(numericValue);
		        Assert.assertTrue(value >= 100.0 && value <= 200.0, "Value " + value + " is out of range");
		    } 
		}

	}
	
	@Test(priority = 18,description = "Verify that user is able to select any option from 'Status' dropdown, on 'Transactions' > 'Fines' Page.")
	public void finance_VerifyStatusDropDwonFilter() throws InterruptedException {
		
		//LoginTest();
		fn.clickOnClearAllFilter();
		
		Helper helper = new Helper(getDriver());
		helper.forcedWaitTime(2);
		crm.navigateToTopNavigation(FinanceUtility.financeMenu);
		helper.waitForCurserRunning(5);
		fn.clickOnTransactionToggel("Fines");
		helper.forcedWaitTime(3);
		//CECommonMethods ce = new CECommonMethods(getDriver());
		
		fn.clickOnFilterArrows("Status");
		fn.checkedStatus("status","Unpaid");
		List<String> searchFilterStatus = fn.getCustomGridColData("5");
		
		for (String status : searchFilterStatus) {
		    
		    
		        Assert.assertTrue(status.equalsIgnoreCase("Unpaid"), "Unpaid " + status + " is not matched.");
		}

	}





}
