package POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

//import com.twilio.Twilio;
//import com.twilio.base.ResourceSet;
//import com.twilio.rest.api.v2010.account.Call;
//import com.twilio.rest.api.v2010.account.Message;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;


public class SmsAndEmailVerificationUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	
	public SmsAndEmailVerificationUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		

}
	
	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	 public static final String ACCOUNT_SID = PropertiesUtils.getPropertyValue("ACCOUNT_SID");
	    public static final String AUTH_TOKEN = PropertiesUtils.getPropertyValue("AUTH_TOKEN");
	    public static By MessagesIcon = By.xpath("//p[text()='Customer Messages']/parent::div//button");
	    public static By SubjectField = By.xpath("//div[@class='fade compose-email modal-base modal show']//input[@name='subject']");
	    public static By IframeBody = By.xpath("//iframe[@id='compose-email-html-editor-modal_ifr']");
	    public static By MessageBody = By.xpath("//body[@class='mce-content-body ']");
	    public static By SendButton = By.xpath("//button[text()='Send']");
	    public static By PrivateSubmissionHeader = By.xpath("//h2[@class='private-submission-details__number']");
	    public static By ReceivedMailHeader = By.xpath("//td[@align='center']/h2");
	    public static String RandomSubject = "Security alert";
	    public static String URLSubmissionInfo;
	    public static String LatestSID;

	    public  void ComposeMessage() throws InterruptedException {
	        SoftAssert softAssert = new SoftAssert();
	        refreshPage();
	        waitForCurserRunning(5);
	        int loginCheckQA = findElementsSize(LoginAgencyUtility.UsernameField);
	        int loginCheckStage = findElementsSize(LoginAgencyUtility.OKTAUsernameField);
	        if(loginCheckQA > 0 || loginCheckStage >0){
	            log.LoginAgency();
	        }
	        
	        CRMCommonMethods crmCommonMethod=new CRMCommonMethods(driver);
	        crmCommonMethod.createSubmissionPreRequisite("No", "Yes", "Yes", "No", "Yes", "Location Not Required");
	        //CRMCommonMethods.CRM_CreateSubmission("No", "Yes", "Yes", "No", "Yes", "Location Not Required");
	        waitForCurserRunning(7);
	        waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
	        String SubmissionNumberSplit[] = getTextElement(CreateAndLinkCaseUtility.SubmissionNumber).split("#");
	        String SubmissionNumberCSDP = SubmissionNumberSplit[1];
	        clickOn(MessagesIcon);
	        RandomSubject = RandomStrings.requiredCharacters(10);
	        sendKeysWithWait(SubjectField, RandomSubject);
	        WebElement switchFrame = waitUntilVisibleWE(IframeBody);
	        driver.switchTo().frame(switchFrame);
	        String RandomBody = "Random Body" + RandomStrings.requiredString(50);
	        waitForElementIsInteractable(MessageBody);
	        sendKeysWithWait(MessageBody, RandomBody);
	        driver.switchTo().defaultContent();
	        clickByJsExecuter(SendButton);
	        waitUntilElementInvisibleLocated(SendButton);
	        waitForCurserRunning(7);
	        waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
//	        TwilioGetMessage();
	        String[] FetchAllText = URLSubmissionInfo.split("https");
	        String FetchSMSURL = ("https" + FetchAllText[1]).split(" ")[0];
	        driver.navigate().to(FetchSMSURL);
	        System.out.println(FetchSMSURL);
	        waitForCurserRunning(8);
	        
	        waitUntilElementIsVisible(PrivateSubmissionHeader);
	        String OpenedSubmissionHeader[] = getTextElement(PrivateSubmissionHeader).split("Submission #");
	        softAssert.assertEquals(SubmissionNumberCSDP, OpenedSubmissionHeader[1]);
	        softAssert.assertAll();
	    }

//	    public  void TwilioGetMessage() throws InterruptedException {
//	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	       
//	        ResourceSet<Message> messages = Message.reader().limit(1).read();
//	        for (Message record : messages) {
//	           
//	            LatestSID = record.getSid();
//
//	        }
//
//	        Message message = Message.fetcher(LatestSID).fetch();
//
//	        URLSubmissionInfo = message.getBody();
//
//
//	        ResourceSet<Call> calls = Call.reader().read();
//	        for (Call call : calls) {
//
//	        }
//	    }

	    public  void VerifyMailReceivedByAssignee() throws InterruptedException, MessagingException, IOException {
	        SoftAssert softAssert = new SoftAssert();
	        CRMCommonMethods crmCommonMethod=new CRMCommonMethods(driver);
	        crmCommonMethod.createExternalSubmission("Yes", "Location Not Required", "No", "Yes");
	       
	        driver.navigate().to(BrowsersInvoked.URLDashboard);
	       
	        clickOn(CSLPUtility.CSLPTab);
	       
	        String SubmissionToSearch = getTextElement(CSLPUtility.SubmissionID);
	      //  ComposeMail.CustomerReceivedMail(SubmissionToSearch);
	      //  boolean ExpectedCount = GMailHelper.SearchedMailCount == 1;
	       // softAssert.assertTrue(ExpectedCount);
	        softAssert.assertAll();
	    }

	    public void VerifyMailReceivedByCollaborator() throws InterruptedException, MessagingException, IOException, AWTException {
	        SoftAssert softAssert = new SoftAssert();
	        CRMCommonMethods crmCommonMethod=new CRMCommonMethods(driver);
	        crmCommonMethod.createExternalSubmission("Yes", "Location Not Required", "No", "Yes");
	       
	        driver.navigate().to(BrowsersInvoked.URLDashboard);
	       
	        clickOn(CSLPUtility.CSLPTab);
	       
	        String SubmissionToSearch = getTextElement(CSLPUtility.SubmissionID);
	        String CurrentWindow = driver.getWindowHandle();
	        Robot robot = new Robot();
	       
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_T);

	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	       
	        driver.switchTo().window((String) tabs.get(1));
	       
	        driver.navigate().to("https://yopmail.com/en/");
	       
	        sendKeysWithWait(CreateCRMUserUtility.YopmailSearchUser, BrowsersInvoked.AgencyUsername);
	        clickOn(CreateCRMUserUtility.YopmailInboxArrow);
	       
	        WebElement switchFrame = waitUntilVisibleWE(CreateCRMUserUtility.IframeSwitch);
	       
	        driver.switchTo().frame(switchFrame);
	       
	        String GetHeaderFromMail[] = getTextElement(ReceivedMailHeader).split("#");
	        String ReceivedSubmissionID[] = GetHeaderFromMail[1].split(")");
	       
	        driver.switchTo().window(CurrentWindow);
	        softAssert.assertEquals(SubmissionToSearch, ReceivedSubmissionID[0]);
	        softAssert.assertAll();
	    }


	    public  void ComposeMail() throws InterruptedException {
	    	 CRMCommonMethods crmCommonMethod=new CRMCommonMethods(driver);
	    	 crmCommonMethod.createSubmissionPreRequisite("No", "Yes", "Yes", "No", "Yes", "Location Not Required");
	        String RandomSubject = RandomStrings.requiredCharacters(10);
	        crmCommonMethod.composeCRMMessage(RandomSubject);
	        waitUntilElementIsVisible(By.xpath("//label[text()='Customer Email']//following-sibling::label"));
	        String mailId = getTextElement(By.xpath("//label[text()='Customer Email']//following-sibling::label"));
	        ((JavascriptExecutor) driver).executeScript("window.open()");
	        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
	        driver.navigate().to("https://yopmail.com/en/");
	        waitForCurserRunning(4);
	        forcedWaitTime(4);
	        waitUntilElementIsVisible(CreateCRMUserUtility.YopmailSearchUser);
	        waitUntilElementPresent(CreateCRMUserUtility.YopmailSearchUser);
	        waitForElementIsInteractable(CreateCRMUserUtility.YopmailSearchUser);
	        sendKeysWithWait(CreateCRMUserUtility.YopmailSearchUser, mailId);
	        waitForElementIsInteractable(CreateCRMUserUtility.YopmailInboxArrow);
	        clickOn(CreateCRMUserUtility.YopmailInboxArrow);
	        waitForCurserRunning(4);
	        waitUntilElementIsVisible(By.xpath("//iframe[@id='ifinbox']"));
	        waitForElementIsInteractable(By.xpath("//button[@id='refresh']"));
	        clickByJsExecuter(By.xpath("//button[@id='refresh']"));
	        waitUntilElementIsVisible(CreateCRMUserUtility.IframeSwitch);
	        WebElement switchFrame = driver.findElement(By.xpath("//iframe[@id='ifinbox']"));
	        driver.switchTo().frame(switchFrame);
	        //driver.switchTo().defaultContent();
	        forcedWaitTime(3);
	        waitUntilElementIsVisible(By.xpath("(//div[@class='lmfd']//following-sibling::div[@class='lms'])[1]"));
	        String ActualSub = getTextElement(By.xpath("(//div[@class='lmfd']//following-sibling::div[@class='lms'])[1]"));
	        SoftAssert soft = new SoftAssert();
	        assert ActualSub != null;
	        soft.assertTrue(ActualSub.contains(RandomSubject));
	    }
	    
	    
	    public String getMailSubject(String caseId) throws InterruptedException {
	    	    waitForCurserRunning(4);
		        waitUntilElementIsVisible(By.xpath("//iframe[@id='ifinbox']"));
		        waitForElementIsInteractable(By.xpath("//button[@id='refresh']"));
		        clickByJsExecuter(By.xpath("//button[@id='refresh']"));
		        waitUntilElementIsVisible(CreateCRMUserUtility.IframeSwitch);
		        WebElement switchFrame = driver.findElement(By.xpath("//iframe[@id='ifinbox']"));
		        driver.switchTo().frame(switchFrame);
		        //driver.switchTo().defaultContent();
		        forcedWaitTime(4);
		        waitUntilElementIsVisible(By.xpath("(//div[@class='lmfd']//following-sibling::div[@class='lms'])[1]"));
		        String actualSub = getTextElement(By.xpath("//div[@class='lmfd']//following-sibling::div[@class='lms'][contains(text(),'"+caseId +"')]"));
		        return actualSub;
	    }
	    
	    
	    
	    
	    public boolean composeGmailMessage(String subject,String username,String password,String folderName) throws InterruptedException, MessagingException, IOException {
//	        SoftAssert softAssert = new SoftAssert();

	        // Wait to ensure that the email is delivered (replace with appropriate handling)
	        forcedWaitTime(4);

	        // Verify that the expected email is received
	        boolean isEmailReceived = customerReceivedMail(subject,username,password,folderName);

	        // Assert that the expected email was received
//	        softAssert.assertTrue(isEmailReceived, "Expected email with subject '" + RandomSubject + "' was not received.");
//	        softAssert.assertAll();
	        return isEmailReceived;
	    }
	    
	   

	    public boolean customerReceivedMail(String searchBySubject,String userName,String password,String folderName) throws InterruptedException, MessagingException, IOException {
	    	SoftAssert softAssert = new SoftAssert();
	        forcedWaitTime(4);
	        GMailHelper gmailHelper = new GMailHelper(userName, password);
	        Message recentEmail = gmailHelper.getMostRecentEmail(folderName, searchBySubject);

	        if (recentEmail != null) {
	            System.out.println("Subject: " + recentEmail.getSubject());
	            System.out.println("Received Date: " + recentEmail.getReceivedDate());
	            softAssert.assertEquals(recentEmail.getSubject().split(":")[1].trim(), searchBySubject.trim());
		        softAssert.assertAll();
	            return true;
	        } else {
	            System.out.println("No email found with the specified subject.");
	        }

	        
	        return false;
	    }
	    
	    
	    public void replyToMostRecentEmail(String username ,String password ,String message,String folderName) throws MessagingException {
	    	GMailHelper gmailHelper = new GMailHelper(username,password);
	    	gmailHelper.replyToMostRecentEmail(username, password, message, folderName);
	    }







}
