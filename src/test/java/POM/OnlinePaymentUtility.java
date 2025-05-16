package POM;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import TestCases.CLP;




public class OnlinePaymentUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	PerformInspectionUtility PI;
	CCPUtility ccp;
	ForcedAbatementUtility FA;
	CECommonMethods CEcommonMethod;
	CLPUtility clp;
	CRMCommonMethods crmCommonMethod;

	public OnlinePaymentUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		PI = new PerformInspectionUtility(driver);
		ccp = new CCPUtility(driver);
		FA = new ForcedAbatementUtility(driver);
		CEcommonMethod=new CECommonMethods(driver);
		crmCommonMethod= new CRMCommonMethods(driver);
		clp=new CLPUtility(driver);
	}
	public static String outstandingBalDetails = "//label[text()='Outstanding Balance']//parent::div//a[@class='view-details']";
    public static String finePaymentDetailsPopup = "//div[contains(text(),'Fines & Payments Details')]";
    public static String selectFineDropdownArrow = "//label[@title='Select Fine']//parent::div//parent::div//span[@class='Select-arrow']";
    public static String selectFineOptions = "(//div[@class='Select-menu-outer']//div[@role='option'])[1]";
    public static String addNewFine = "//div[@class='add-transaction']//button[text()='Add Fine']";
    public static String closeFinePaymentDetailsPop = "//div[contains(text(),'Fines & Payments Details')]//parent::div//button[text()='Close']";
    public static String voidIconFinePaymentList = "(//img[@class='void-icon'])[1]";
    public static String unpaidButton = "//button[text()='Unpaid']";
    public static String contactName = "(//div[@class='contact__name']//label//b)[1]";
    public static String paymentSideBar = "//label[text()='Payments']";
    public static String citizenPaymentProtal = "//label[text()='Citizen Payment Portal']";
    public static String paymentPortallinkText = "//div[@class='payment-portal-form__url-section__url']//h5";
    public static String copyPaymentPortalLink = "//div[@class='payment-portal-form__url-section__url']//button";
    public static String defaultPaymentPortaltitle = "//input[@placeholder='Enter Payment Portal Title'][@name='title']";
    public static String savePaymentPorrtalSettings = "//button[text()='Save Changes']";
    public static String paymentPortalHeaderTitle = "//section[@class='payment-info']//h1";
    public static String paymentPortalDescription = "//div[@class='payment-description']//p";
    public static String paymentPortalParaGraphText = "//textarea[@name='description']";
    public static String caseSearchButton = "//div[@class='case-search-fields']//following-sibling::button";
    public static String validationErrorMessage = "//span[@class='field__error']";
    public static String notificationError = "//div[@class='notifications-wrapper']";
    public static String caseNumberField = "//input[@name='caseNumber']";
    public static String noticenameField = "//input[@name='nameOnNotice']";
    public static String balanceDetails = "//header[@class='outstanding-balance-details']//div[@class='balance']";
    public static String balnceOnCDP = "//div[@class='field-section outstanding-balance']//span";
    public static String totalTransactionAmount = "//header[@class='payment-portal-total-payment-details']//div[@class='amount']";
    public static String enterPaymentdetailbtn = "//div[@class='payment-details-btn-container']//button";
    public static String orderSummary = "//label[contains(text(),'Order Summary')]";
    public static String cardDetails = "//input[@id='cardNum'][@name='cardNum']";
    public static String cardExPDate = "//input[@id='expiryDate'][@name='expiryDate']";
    public static String cardCVVCode = "//input[@id='cvv'][@name='cvv']";
    public static String payButton = "//button[@id='payBtn']";
    public static String receiptMerchantName = "//label[@id='receiptMerchantName']";
    public static String receiptTransactMessage = "//label[@id='receiptTransactMessage']";
    public static String receiptTransactionId = "//label[@id='receiptTransactionId']";
    public static String paymnetdetailsExpander = "(//div[@class='rt-expander'])[1]";
    public static String paymentTransactionndetails = "//*[@class='field-section']//*[@class='field__label-label']//*[@class='field__label-data-field']";
    public static String voidPayment = "//div[contains(text(),'Void or Refund Payment')]";
    public static String reasonForVoid = "//textarea[@name='reason']";
    public static String voidPaymentbutton = "//button[text()='Void Payment']";
    public static String voidfineBtn = "//button[text()='Void Fine']";
    public static String waivefineBtn = "//button[text()='Waive Fine']";
    public static String voidLable = "((//div[@class='rt-expander'])[1]//ancestor::div[@role='rowgroup']//div[@role='gridcell'])[4]//button";
    public static String paymentNullified = "((//div[@class='rt-expander'])[1]//ancestor::div[@role='rowgroup']//div[@role='gridcell'])[5]//span[@class='payment_amount is-nullified']";
    public static String fineNullified = "((//div[@class='rt-expander'])[1]//ancestor::div[@role='rowgroup']//div[@role='gridcell'])[5]//span[@class='is-nullified']";
    public static String minimumPayAmount = "//input[@name='paymentAmount']";
    public static String cardInvalidError = "errorMsgID";
    public static String addedfineDetails = "//div[@role='rowgroup']//div[@role='gridcell']//span";
    public static String addPayment = "//button[text()='Add Payment']";
    public static String addPaymentAmnt = "//input[@name='amount']";
    public static String selectPayor = "//div[text()='Payor']";
    public static String selectPayorOpt = "(//div[@class='Select-menu-outer']//div[@class='Select-option'])[1]";
    public static String addPaymentbtn = "//div[@class='add-transaction']//button";
    public static String addFineToggle = "//button[text()='Add Fine']";
    public static String dueDatePicker = "//span[@class='datepicker-image']";
    public static String prevDateArrow = "//th[@class='rdtPrev']";
    public static String selectDate10 = "//td[@data-value='10']";
    public static String overdueFineLbl = "//Button[text()='Unpaid']//following-sibling::span[@class='is-overdue']";
    public static String paymentVoid = "(//div[@class='rt-td']//span[contains(text(),'Payment')]//parent::div//following-sibling::div[@role='gridcell'])[2]";
    public static String paymentCashNullified = "(//div[@class='rt-td']//span[contains(text(),'Payment')]//parent::div//following-sibling::div[@role='gridcell'])[3]//span[@class='payment_amount is-nullified']";
    public static String paymentVoidSymbol = "//div[@class='rt-td']//span[contains(text(),'Payment')]//parent::div//following-sibling::div[@role='gridcell']//img[@class='void-icon']";
    public static By OutstandingBalDetails = By.xpath(outstandingBalDetails);
    public static By PaymentVoidSymbol = By.xpath(paymentVoidSymbol);
    public static By PaymentCashNullified = By.xpath(paymentCashNullified);
    public static By PaymentVoid = By.xpath(paymentVoid);
    public static By OverdueFineLbl = By.xpath(overdueFineLbl);
    public static By AddPayment = By.xpath(addPayment);
    public static By SelectDate10 = By.xpath(selectDate10);
    public static By PrevDateArrow = By.xpath(prevDateArrow);
    public static By DueDatePicker = By.xpath(dueDatePicker);
    public static By AddFineToggle = By.xpath(addFineToggle);
    public static By AddPaymentbtn = By.xpath(addPaymentbtn);
    public static By SelectPayorOpt = By.xpath(selectPayorOpt);
    public static By SelectPayor = By.xpath(selectPayor);
    public static By AddPaymentAmnt = By.xpath(addPaymentAmnt);
    public static By AddedfineDetails = By.xpath(addedfineDetails);
    public static By ReasonForVoid = By.xpath(reasonForVoid);
    public static By PaymentNullified = By.xpath(paymentNullified);
    public static By FineNullified = By.xpath(fineNullified);
    public static By VoidLable = By.xpath(voidLable);
    public static By VoidPaymentbutton = By.xpath(voidPaymentbutton);
    public static By VoidfineBtn = By.xpath(voidfineBtn);
    public static By PaymnetdetailsExpander = By.xpath(paymnetdetailsExpander);
    public static By PaymentTransactionndetails = By.xpath(paymentTransactionndetails);
    public static By PaymentSideBar  = By.xpath(paymentSideBar);
    public static By CitizenPaymentProtal = By.xpath(citizenPaymentProtal);
    public static By FinePaymentDetailsPopup = By.xpath(finePaymentDetailsPopup);
    public static By SelectFineDropdownArrow = By.xpath(selectFineDropdownArrow);
    public static By SelectFineOptions = By.xpath(selectFineOptions);
    public static By AddNewFine = By.xpath(addNewFine);
    public static By CloseFinePaymentDetailsPop = By.xpath(closeFinePaymentDetailsPop);
    public static By VoidIconFinePaymentList = By.xpath(voidIconFinePaymentList);
    public static By UnpaidButton = By.xpath(unpaidButton);
    public static By ContactName  = By.xpath(contactName);
    public static By PaymentPortallinkText = By.xpath(paymentPortallinkText);
    public static By CopyPaymentPortalLink = By.xpath(copyPaymentPortalLink);
    public static By DefaultPaymentPortaltitle = By.xpath(defaultPaymentPortaltitle);
    public static By SavePaymentPorrtalSettings = By.xpath(savePaymentPorrtalSettings);
    public static By PaymentPortalHeaderTitle = By.xpath(paymentPortalHeaderTitle);
    public static By PaymentPortalParaGraphText = By.xpath(paymentPortalParaGraphText);
    public static By PaymentPortalDescription = By.xpath(paymentPortalDescription);
    public static By CaseSearchButton = By.xpath(caseSearchButton);
    public static By ValidationErrorMessage = By.xpath(validationErrorMessage);
    public static By NotificationError = By.xpath(notificationError);
    public static By CaseNumberField = By.xpath(caseNumberField);
    public static By NoticenameField = By.xpath(noticenameField);
    public static By BalanceDetails = By.xpath(balanceDetails);
    public static By BalnceOnCDP = By.xpath(balnceOnCDP);
    public static By TotalTransactionAmount = By.xpath(totalTransactionAmount);
    public static By EnterPaymentdetailbtn = By.xpath(enterPaymentdetailbtn);
    public static By OrderSummary = By.xpath(orderSummary);
    public static By CardDetails = By.xpath(cardDetails);
    public static By CardExPDate = By.xpath(cardExPDate);
    public static By CardCVVCode = By.xpath(cardCVVCode);
    public static By PayButton = By.xpath(payButton);
    public static By ReceiptMerchantName = By.xpath(receiptMerchantName);
    public static By ReceiptTransactMessage = By.xpath(receiptTransactMessage);
    public static By ReceiptTransactionId = By.xpath(receiptTransactionId);
    public static By VoidPayment = By.xpath(voidPayment);
    public static By MinimumPayAmount = By.xpath(minimumPayAmount);
    public static By CardInvalidError = By.id(cardInvalidError);
    public static By WaivefineBtn = By.xpath(waivefineBtn);
    
    
    public static By waivetoggel = By.xpath("//button[text()='Waive']");
    public static By voidLateFee = By.xpath("//button[text()='Void Late Fee']");
    
    public static By waiveLateFee = By.xpath("//button[text()='Waive Late Fee']");
    
    public static By refundToggel = By.xpath("//button[text()='Refund']");
    public static By refundAmountTxt = By.xpath("//input[@name='refundAmount']");
    public static By refundIssueBtn = By.xpath("//button[text()='Issue Refund']");
    public static By paymentStatus = By.xpath("(//div[@role='gridcell']//button)[1]");
    
    
    public static Boolean FinePaymentDetailsHeader;
    public static int UnPaidFinePaymentCounBefore ;
    public static int UnPaidFinePaymentCounAfter ;
    public static String caseId;
    public static String caseOutstandingBal;
    public static String BillToContactName;
    public static String expectedPortalLink;
    public static String actualPortalLink;
    public static String DefaultPaymentPortaltitleText;
    public static String DefaultPaymentParaGraphText;
    public static String paymentProtalText = "Look Up and Pay Outstanding Balances";
    public static String actualPaymentPortalHeaderTitle;
    public static String actualPaymentPortalDescription;
    public static String actualPaymentPortal;



    public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

    public static String agencyName;
    
    
    public void OnlinePaymentCasePreRequisite()  throws InterruptedException{

    	
    	agencyName=CEcommonMethod.getAgencyName();
    	System.out.println("Agency Name : " + agencyName);
    	CEcommonMethod.createCaseCCP();
        waitUntilElementIsVisible(OutstandingBalDetails);
        waitForElementIsInteractable(OutstandingBalDetails);
        clickOn(OutstandingBalDetails);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(FinePaymentDetailsPopup);
        waitUntilElementIsVisible(AddNewFine);
        waitUntilElementPresent(FinePaymentDetailsPopup);
        FinePaymentDetailsHeader = findElement(FinePaymentDetailsPopup).isDisplayed();
        UnPaidFinePaymentCounBefore = findElementsSize(UnpaidButton);

        waitForElementIsInteractable(SelectFineDropdownArrow);
        clickOn(SelectFineDropdownArrow);
        waitUntilElementIsVisible(SelectFineOptions);
        clickOn(SelectFineOptions);
        waitForElementIsInteractable(AddNewFine);
        clickOn(AddNewFine);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(CloseFinePaymentDetailsPop);
        waitUntilElementPresent(CloseFinePaymentDetailsPop);
        waitUntilElementIsVisible(UnpaidButton);

        UnPaidFinePaymentCounAfter = findElementsByXPath(UnpaidButton).size();
        waitForElementIsInteractable(CloseFinePaymentDetailsPop);
        clickOn(CloseFinePaymentDetailsPop);
        waitForCurserRunning(5);
        waitUntilElementIsVisible(OutstandingBalDetails);
        waitForElementIsInteractable(OutstandingBalDetails);

        caseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
        caseOutstandingBal = getTextElement(BalnceOnCDP);
        scrollIntoView(By.xpath("(//input[@name='billableContact'][@type='checkbox'])[1]"));
        BillToContactName = getTextElement(ContactName);
        clickByJsExecuter(By.xpath("//label//b[text()='"+BillToContactName+"']//ancestor::div[@class='contact__name']//following-sibling::div[@class='contact__bill-to-contact']//input[@name='billableContact'][@type='checkbox']"));
        waitForCurserRunning(5);
        CEcommonMethod.closeCaseDetailPage();
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(FinePaymentDetailsHeader,Boolean.TRUE);
        SFA.assertEquals(UnPaidFinePaymentCounAfter,UnPaidFinePaymentCounBefore + 1);
        SFA.assertAll();

    }

    public  void clearClipboard() {
        // Create an empty StringSelection
        StringSelection emptySelection = new StringSelection("");

        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Set the clipboard contents to an empty StringSelection
        clipboard.setContents(emptySelection, null);
    }
    
    
    public  void CopyPaymentPortalURLOnCitizenPaymentPortal() throws InterruptedException, IOException, UnsupportedFlavorException {

    	
      
    	 crmCommonMethod.navigateToAgencySetup();
    	 crmCommonMethod.navigationToPayment();
         waitForElementIsInteractable(CopyPaymentPortalLink);
         clickByJsExecuter(CopyPaymentPortalLink);
         expectedPortalLink = getTextElement(PaymentPortallinkText);
         clickByJsExecuter(CopyPaymentPortalLink);

         DefaultPaymentPortaltitleText =  getValueAttribute(DefaultPaymentPortaltitle);
         DefaultPaymentParaGraphText = getTextElement(PaymentPortalParaGraphText);

         clearElement(DefaultPaymentPortaltitle);
         WebElement targetEle = findElement(DefaultPaymentPortaltitle);
         forcedWaitTime(2);
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         Transferable contents = clipboard.getContents(null);
         String data = (String) contents.getTransferData(DataFlavor.stringFlavor);
         int i=0;
         while(!data.equalsIgnoreCase("https://app-stage.comcate.com/payment-portal/XQoufyeUAP8YIhU")&&i<5)
         {
             clickByJsExecuter(CopyPaymentPortalLink);
             i++;
         }
         targetEle.sendKeys(data);

         actualPortalLink =  getValueAttribute(DefaultPaymentPortaltitle);



    }

    public  void UserNavigateToPaymentPortalThroughLink() throws InterruptedException{
        driver.navigate().to(expectedPortalLink);
        waitForCurserRunning(4);
        waitUntilElementIsVisible(PaymentPortalHeaderTitle);
        waitUntilElementPresent(PaymentPortalHeaderTitle);
        actualPaymentPortalHeaderTitle = getTextElement(PaymentPortalHeaderTitle);
        actualPaymentPortalDescription = getTextElement(PaymentPortalDescription);
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(actualPaymentPortalHeaderTitle,DefaultPaymentPortaltitleText);
        SFA.assertEquals(actualPaymentPortalDescription,DefaultPaymentParaGraphText);
        SFA.assertAll();
    }

    public static String ActualcaseNumbervalidation = "The Case number is required.";
    public static String ExpectedcaseNumbervalidation ;

    public static String ActualNameOnNoticevalidation = "The Name on notice is required.";
    public static String ExpectedNameOnNoticevalidation ;

    public static String ExpectedwrongCaseError = "No matching cases found";
    public static String ActualwrongCaseError ;



    public  void CaseDetailsValidationMessageOnPaymentPortal() throws InterruptedException {

        waitUntilElementIsVisible(CaseSearchButton);
        scrollIntoView(CaseSearchButton);
        waitForElementIsInteractable(CaseSearchButton);
        clickByJsExecuter(CaseSearchButton);
        waitUntilElementIsVisible(ValidationErrorMessage);
        waitUntilElementPresent(ValidationErrorMessage);
        List<WebElement> ele = findElementsByXPath(ValidationErrorMessage);
        ExpectedcaseNumbervalidation = ele.get(0).getText();
        ExpectedNameOnNoticevalidation = ele.get(1).getText();
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(ActualcaseNumbervalidation,ExpectedcaseNumbervalidation);
        SFA.assertEquals(ActualNameOnNoticevalidation,ExpectedNameOnNoticevalidation);
        SFA.assertAll();
    }

    public  void WrongCaseDetailsValidationMessageOnPaymentPortal() throws InterruptedException {

        String InvalidCaseNumber = RandomStrings.requiredString(5);
        String InvalidNoticeName = RandomStrings.requiredString(5);

        sendKeysWithWait(CaseNumberField,InvalidCaseNumber);
        sendKeysWithWait(NoticenameField,InvalidNoticeName);
        waitUntilElementIsVisible(CaseSearchButton);
        scrollIntoView(CaseSearchButton);
        waitForElementIsInteractable(CaseSearchButton);
        clickByJsExecuter(CaseSearchButton);
        waitForCurserRunning(1);
        ActualwrongCaseError =  driver.findElement(NotificationError).getText();
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(ActualwrongCaseError,ExpectedwrongCaseError);
        SFA.assertAll();

    }

    public static String reviewPaymentTitle ;
    public static String reviewBalance ;
    public static Boolean TotalAmountToPay ;

    public  void VerifytheReviewOutstandingFeeAndPaymentDatailsPage()throws InterruptedException {
        driver.navigate().refresh();
        waitUntilElementIsVisible(CaseNumberField);
        waitUntilElementIsVisible(CaseNumberField);
        waitForElementIsInteractable(CaseNumberField);
        clearElement(CaseNumberField);
        waitUntilElementIsVisible(CaseNumberField);
        waitForElementIsInteractable(CaseNumberField);
        clearElement(NoticenameField);

        sendKeysWithWait(CaseNumberField,caseId);
        System.out.println("Case id is "+ caseId +" Bill to contact "+ BillToContactName);
        sendKeysWithWait(NoticenameField,BillToContactName);
        waitUntilElementIsVisible(CaseSearchButton);
        scrollIntoView(CaseSearchButton);
        waitForElementIsInteractable(CaseSearchButton);
        clickByJsExecuter(CaseSearchButton);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(PaymentPortalHeaderTitle);
        waitUntilElementPresent(PaymentPortalHeaderTitle);
        reviewPaymentTitle = getTextElement(PaymentPortalHeaderTitle);
        reviewBalance = getTextElement(BalanceDetails);
        double Amount = Double.parseDouble((getTextElement(BalanceDetails)).split("\\$")[1]);
        double transactionFee = (Amount * 10)/100 ;
        double totalexpetedAmount = Amount + transactionFee ;
        double totalactalAmount = Double.parseDouble((getTextElement(TotalTransactionAmount)).split("\\$")[1]);
        System.out.println("totalexpetedAmount : " +(Double.toString(totalexpetedAmount)).split("\\.")[0]);
        System.out.println("totalactalAmount : " + (Double.toString(totalactalAmount)).split("\\.")[0]);
        TotalAmountToPay = Double.toString(totalexpetedAmount).split("\\.")[0].equalsIgnoreCase(Double.toString(totalactalAmount).split("\\.")[0]);
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(reviewPaymentTitle,"Review Your Outstanding Fines & Fees");
        SFA.assertEquals(reviewBalance,caseOutstandingBal,"2nd assertion failed");
        SFA.assertEquals(Boolean.TRUE,TotalAmountToPay);
        SFA.assertAll();
    }

    public static Boolean orderSummaryLabel ;
    public static String ActualReceiptMerchantName ;
    public static String ActualReceiptTransactMessage;
    public static String TransactionId;
    public static String expectedTransactionId ;
    public static Boolean wronngDetailsPaybtnStatus;
    public static String InvalidCardError;

    public  void MakeOnlinePayment() throws InterruptedException{

        waitForElementIsInteractable(EnterPaymentdetailbtn);
        scrollIntoView(EnterPaymentdetailbtn);
        clickOn(EnterPaymentdetailbtn);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(OrderSummary);
        orderSummaryLabel = findElement(OrderSummary).isDisplayed();
        sendKeysWithWait(CardDetails, "4007000000028");
        sendKeysWithWait(CardExPDate, "08//25");
        sendKeysWithWait(CardCVVCode, "900");
        wronngDetailsPaybtnStatus = findElement(PayButton).isEnabled();

        clearElement(CardDetails);
        clearElement(CardExPDate);
        clearElement(CardCVVCode);
        waitForElementIsInteractable(CardDetails);
        waitForElementIsInteractable(CardCVVCode);

//        SendKeys(CardDetails, "40070670000027");
//        SendKeys(CardExPDate, "08//25");
//        SendKeys(CardCVVCode, "9050");
//        WaitForElementInteractable(PayButton);
//        ClickByJsExecuter(PayButton);
//
//        WaitUntilVisible(CardInvalidError);
//        InvalidCardError = findElement(CardInvalidError).getText();

        clearElement(CardDetails);
        clearElement(CardExPDate);
        clearElement(CardCVVCode);
        waitForElementIsInteractable(CardDetails);
        waitForElementIsInteractable(CardCVVCode);

        sendKeysWithWait(CardDetails, "4007000000027");
        sendKeysWithWait(CardExPDate, "08//25");
        sendKeysWithWait(CardCVVCode, "9300");
        waitForElementIsInteractable(PayButton);
        clickByJsExecuter(PayButton);
        waitForCurserRunning(5);
        forcedWaitTime(4);
        waitUntilElementIsVisible(ReceiptMerchantName);
        ActualReceiptMerchantName = getTextElement(ReceiptMerchantName);
        ActualReceiptTransactMessage = getTextElement(ReceiptTransactMessage);
        TransactionId = getTextElement(ReceiptTransactionId).split(" ")[2];
        driver.navigate().to(BrowsersInvoked.URLCases);
        waitForCurserRunning(4);
      //  WaitUntilVisible(CLP.CLP);
        Thread.sleep(5000);
        CEcommonMethod.searchCaseAndNavigateToCDP(caseId);
        caseOutstandingBal = (getTextElement(BalnceOnCDP)).split("\\$")[1];

        waitUntilElementIsVisible(OutstandingBalDetails);
        waitForElementIsInteractable(OutstandingBalDetails);
        clickByJsExecuter(OutstandingBalDetails);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(FinePaymentDetailsPopup);
        waitUntilElementIsVisible(AddNewFine);
        waitUntilElementPresent(FinePaymentDetailsPopup);
        waitForElementIsInteractable(PaymnetdetailsExpander);
        Thread.sleep(5000);
        clickByJsExecuter(PaymnetdetailsExpander);
        waitUntilElementIsVisible(PaymentTransactionndetails);
        waitUntilElementPresent(PaymentTransactionndetails);
        expectedTransactionId = getTextElement(PaymentTransactionndetails);
        System.out.println(PaymentTransactionndetails);
        SoftAssert SFA = new SoftAssert();
        System.out.println("Agency name is "+agencyName);
        SFA.assertEquals(ActualReceiptTransactMessage,"Thank you for your payment.");
        SFA.assertEquals(ActualReceiptMerchantName,agencyName);
        SFA.assertEquals(Boolean.TRUE,orderSummaryLabel);
        SFA.assertEquals(caseOutstandingBal,"0.00");
        SFA.assertEquals(TransactionId,expectedTransactionId);
        SFA.assertEquals(wronngDetailsPaybtnStatus,Boolean.FALSE);
//        SFA.assertEquals(op.InvalidCardError,"The credit card number is invalid.");
        SFA.assertAll();

    }

    public static Boolean voidPaymentModel ;
    public static Boolean voidLableIcon ;
    public static String voidLableButton;
    public static Boolean paymentNullifiedPresent;

    public  void UserAbleToMarkPaymentAsVoid() throws InterruptedException{
             waitUntilElementIsVisible(VoidIconFinePaymentList);
             waitForElementIsInteractable(VoidIconFinePaymentList);
             clickByJsExecuter(VoidIconFinePaymentList);
             voidPaymentModel =  findElement(VoidPayment).isDisplayed();
             sendKeysWithWait(ReasonForVoid,RandomStrings.requiredString(4));
             waitForElementIsInteractable(VoidPaymentbutton);
             clickByJsExecuter(VoidPaymentbutton);
             waitForCurserRunning(4);
             waitUntilElementIsVisible(VoidLable);
             waitUntilElementPresent(VoidLable);
             voidLableIcon = findElement(VoidLable).isDisplayed();
             voidLableButton = getTextElement(VoidLable);
             paymentNullifiedPresent = findElement(PaymentNullified).isDisplayed();
             SoftAssert SFA = new SoftAssert();
 	        SFA.assertEquals(voidPaymentModel,Boolean.TRUE);
 	        SFA.assertEquals(voidLableIcon,Boolean.TRUE);
 	        SFA.assertEquals(paymentNullifiedPresent,Boolean.TRUE);
 	        SFA.assertEquals(voidLableButton,"Void");
 	        SFA.assertAll();

    }

    public  void UserAbleToMakeVoidPayment() throws InterruptedException, IOException, UnsupportedFlavorException {

        waitUntilElementIsVisible(FinePaymentDetailsPopup);
        waitUntilElementIsVisible(AddNewFine);
        waitUntilElementPresent(FinePaymentDetailsPopup);
        FinePaymentDetailsHeader = findElement(FinePaymentDetailsPopup).isDisplayed();
        UnPaidFinePaymentCounBefore = findElementsSize(UnpaidButton);
        waitUntilElementIsVisible(SelectFineDropdownArrow);
        waitForElementIsInteractable(SelectFineDropdownArrow);
        forcedWaitTime(2);
        clickOn(SelectFineDropdownArrow);
        waitUntilElementIsVisible(SelectFineOptions);
        clickOn(SelectFineOptions);
        waitForElementIsInteractable(AddNewFine);
        clickOn(AddNewFine);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(CloseFinePaymentDetailsPop);
        waitUntilElementPresent(CloseFinePaymentDetailsPop);
        waitUntilElementIsVisible(UnpaidButton);
        clickByJsExecuter(CloseFinePaymentDetailsPop);
        waitForCurserRunning(5);
        waitUntilElementIsVisible(OutstandingBalDetails);
        waitForElementIsInteractable(OutstandingBalDetails);
        caseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
        caseOutstandingBal = getTextElement(BalnceOnCDP);
        scrollIntoView(By.xpath("(//input[@name='billableContact'][@type='checkbox'])[1]"));
        BillToContactName = getTextElement(ContactName);
        CEcommonMethod.closeCaseDetailPage();
        //CopyPaymentPortalURLOnCitizenPaymentPortal();
        UserNavigateToPaymentPortalThroughLink();
        VerifytheReviewOutstandingFeeAndPaymentDatailsPage();
        MakeOnlinePayment();
        SoftAssert SFA = new SoftAssert();
        SFA.assertEquals(ActualReceiptTransactMessage,"Thank you for your payment.");
        SFA.assertEquals(ActualReceiptMerchantName.toUpperCase(),agencyName);
        SFA.assertEquals(Boolean.TRUE,orderSummaryLabel);
        SFA.assertEquals(Double.parseDouble(caseOutstandingBal),Double.parseDouble(caseOutstandingBal) - totalexpetedAmountNew);
        SFA.assertEquals(TransactionId,expectedTransactionId);
        SFA.assertAll();
        
    }

    public static double totalactalAmountNew ;
    public static double totalexpetedAmountNew;
    public  void UserAbleToMakePartialPayment() throws InterruptedException, IOException, UnsupportedFlavorException {
        
    	 waitUntilElementIsVisible(SelectFineDropdownArrow);
         waitForElementIsInteractable(SelectFineDropdownArrow);
         clickOn(SelectFineDropdownArrow);
         waitUntilElementIsVisible(SelectFineOptions);
         clickOn(SelectFineOptions);
         waitForElementIsInteractable(AddNewFine);
         clickOn(AddNewFine);
         waitForCurserRunning(3);
    	waitUntilElementIsVisible(CloseFinePaymentDetailsPop);
        waitUntilElementPresent(CloseFinePaymentDetailsPop);
        clickByJsExecuter(CloseFinePaymentDetailsPop);
        waitForCurserRunning(5);
        waitUntilElementIsVisible(OutstandingBalDetails);
        waitForElementIsInteractable(OutstandingBalDetails);
        caseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
        caseOutstandingBal = getTextElement(BalnceOnCDP);
        scrollIntoView(By.xpath("(//input[@name='billableContact'][@type='checkbox'])[1]"));
        BillToContactName = getTextElement(ContactName);
        CEcommonMethod.closeCaseDetailPage();
        CopyPaymentPortalURLOnCitizenPaymentPortal();
        UserNavigateToPaymentPortalThroughLink();
        driver.navigate().refresh();
        waitUntilElementIsVisible(CaseNumberField);
        waitUntilElementIsVisible(CaseNumberField);
        waitForElementIsInteractable(CaseNumberField);
        clearElement(CaseNumberField);
        waitUntilElementIsVisible(CaseNumberField);
        waitForElementIsInteractable(CaseNumberField);
        clearElement(NoticenameField);

        sendKeysWithWait(CaseNumberField,caseId);
        sendKeysWithWait(NoticenameField,BillToContactName);
        waitUntilElementIsVisible(CaseSearchButton);
        scrollIntoView(CaseSearchButton);
        waitForElementIsInteractable(CaseSearchButton);
        clickByJsExecuter(CaseSearchButton);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(PaymentPortalHeaderTitle);
        waitUntilElementPresent(PaymentPortalHeaderTitle);
        reviewPaymentTitle = getTextElement(PaymentPortalHeaderTitle);
        clearElement(MinimumPayAmount);
        sendKeysWithWait(MinimumPayAmount,"20");
        reviewBalance = getValueAttribute(BalanceDetails);
        double Amount = Double.parseDouble((getValueAttribute(MinimumPayAmount)));
        double transactionFee = (Amount * 10)/100 ;
        double totalexpetedAmount = Amount + transactionFee ;
        totalexpetedAmountNew = totalexpetedAmount;
        double totalactalAmount = Double.parseDouble((getTextElement(TotalTransactionAmount)).split("\\$")[1]);
        TotalAmountToPay = totalexpetedAmount == totalactalAmount;
        totalactalAmountNew = totalactalAmount;
        MakeOnlinePayment();
    }

}
