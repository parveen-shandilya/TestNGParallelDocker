package POM;

import BrowsersBase.BrowsersInvoked;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ClassPathUtils;
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
import CommonMethods.Helper;

public class DashBoardCRMUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods ceCommonMethod;
   SupervisorUtility supervise;
	public DashBoardCRMUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethod = new CECommonMethods(driver);
		supervise = new SupervisorUtility(driver);
	}

	public static By EscalatedNoticeForMyAgency = By.xpath("//label[text()='Escalated notices for my agency']");
	public static By escalatedNoticeForMyAgency = By.xpath("//h2[text()='Notices']//parent::div//a//label[contains(text(),'Escalated')]");
	public static By CRMToggle = By.xpath("//div[@class='multi-choice-buttons']/button[2]");
	// public static By SLAHeader =
	// By.xpath("//div[@class='dashboard__widgets-holder
	// dashboard__widgets-holder--cases']/h2");
	public static By SLAHeader = By.xpath("//h2[text()='SLA']");
	public static By CRMDashboard = By.xpath("//div[@class='dashboard__container']//h2");

	public static By AssignedForMeLink = By.xpath("//div[@class='widget widget--all-dashboard']/a/label");
	public static By MineButton = By.xpath("//button[text()='Mine']");
	public static By ForMyDepartMentLink = By.xpath("//div[@class='widget widget--all-dashboard'][2]//label");
	public static By ForMyAgency = By.xpath("//div[@class='widget widget--all-dashboard'][3]//label");
	// public static By CountAtLink1 = By.xpath("//div[@class='widget
	// widget--all-dashboard']//a/span[1]");
	public static By CountAtLink1 = By.xpath("(//div[@class='widget widget--all-dashboard']//a/span[1])[1]");
	public static By CountAtLink2 = By.xpath("(//div[@class='widget widget--all-dashboard']//a/span[1])[2]");
	public static By CountAtLink3 = By.xpath("(//div[@class='widget widget--all-dashboard']//a/span[1])[3]");
	public static By SubmissionID = By.xpath("//span[@class='checkbox-holder']/following::a[1]");

	public static int CountAtCSLPForLink1;
	public static int CountAtCSLPForLink2;
	public static int CountAtCSLPForLink3;
	public static String CRMToggleText;
	public static String SLAHeaderText;
	public static boolean CheckMineButtonState;
	public static String SubCountForAssignedToMe;
	public static String SubCountForMyDepartment;
	public static String SubCountForMyAgency;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void Dashboard_VerifyCRMToggleButton() throws InterruptedException {
		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		CRMToggleText = getTextElement(CRMToggle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CRMToggleText, "CRM");
		softAssert.assertAll();
	}

	public void Dashboard_VerifyDirectionToCRMDashboard() throws InterruptedException {
		waitForElementIsInteractable(CRMToggle);
		clickByJsExecuter(CRMToggle);
		waitForCurserRunning(4);
		ArrayList<String> CRMDashBoradHeaders;
		CRMDashBoradHeaders = new ArrayList<String>();
		findElementsByXPath(CRMDashboard).stream().forEach(x -> CRMDashBoradHeaders.add(x.getText()));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CRMDashBoradHeaders.contains("Open Submissions"), "Does not contains OpenSubmission");
		softAssert.assertTrue(CRMDashBoradHeaders.contains("Tasks"), "Does not contains Tasks");
		softAssert.assertTrue(CRMDashBoradHeaders.contains("Unread Messages"), "Does not contains Unread Messages");
		softAssert.assertAll();

	}

	public void Dashboard_VerifyDirectionToCSLPForAssignedToMELink() throws InterruptedException {

		waitUntilElementIsVisible(AssignedForMeLink);
		waitForElementIsInteractable(AssignedForMeLink);
		clickOn(AssignedForMeLink);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(MineButton);
		waitUntilElementPresent(MineButton);
		CheckMineButtonState = findElement(MineButton).isEnabled();
		List<WebElement> AllSubmissionsID = driver.findElements(SubmissionID);
		CountAtCSLPForLink1 = AllSubmissionsID.size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CheckMineButtonState);
		softAssert.assertAll();
	}

	public void Dashboard_VerifyDirectionToCSLPForMyDepartment() throws InterruptedException {
		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(5);
		Thread.sleep(5000);
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		waitForElementIsInteractable(CRMToggle);
		clickByJsExecuter(CRMToggle);
		waitUntilElementIsVisible(By.xpath("//button[text()='CRM'][@class='square-btn btn btn-primary']"));
		waitUntilElementPresent(By.xpath("//button[text()='CRM'][@class='square-btn btn btn-primary']"));
		waitUntilElementIsVisible(ForMyDepartMentLink);
		waitUntilElementPresent(ForMyDepartMentLink);
		waitForElementIsInteractable(ForMyDepartMentLink);
		waitForStaleElementReference(ForMyDepartMentLink);
		waitForElementIsInteractable(ForMyDepartMentLink);
		clickByJsExecuter(ForMyDepartMentLink);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementPresent(SubmissionID);
		List<WebElement> AllSubmissionsID = driver.findElements(SubmissionID);
		CountAtCSLPForLink2 = AllSubmissionsID.size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void Dashboard_VerifyDirectionToCSLPForMyAgency() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		waitForElementIsInteractable(CRMToggle);
		clickByJsExecuter(CRMToggle);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(By.xpath("(//div[@class='dashboard__widgets-holder__widgets']//label)[2]"));
		waitUntilElementPresent(By.xpath("(//div[@class='dashboard__widgets-holder__widgets']//label)[2]"));
		waitForElementIsInteractable(By.xpath("(//div[@class='dashboard__widgets-holder__widgets']//label)[2]"));
		clickOn(By.xpath("(//div[@class='dashboard__widgets-holder__widgets']//label)[2]"));
		waitForCurserRunning(8);
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementPresent(SubmissionID);
		List<WebElement> AllSubmissionsID = driver.findElements(SubmissionID);
		CountAtCSLPForLink3 = AllSubmissionsID.size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void Dashboard_VerifyTheCountOfSubmissions() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		waitForElementIsInteractable(CRMToggle);
		clickByJsExecuter(CRMToggle);
		waitUntilElementIsVisible(SLAHeader);
		SubCountForAssignedToMe = getTextElement(CountAtLink1);
		SubCountForMyDepartment = getTextElement(CountAtLink2);
		SubCountForMyAgency = getTextElement(CountAtLink3);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SubCountForAssignedToMe, CountAtCSLPForLink1);
		softAssert.assertEquals(SubCountForMyDepartment, CountAtCSLPForLink2);
		softAssert.assertEquals(SubCountForMyAgency, CountAtCSLPForLink3);
		softAssert.assertAll();
	}

	public void logoutCurrentUserAndLoginOther(String user) throws InterruptedException {

		ceCommonMethod.logOutCurrentUser();
		//supervise.logout();

		if (user.equalsIgnoreCase("No Supervisor"))
			log.LoginNonSupervisor();

		else if (user.equalsIgnoreCase("Basic Supervisor"))
			log.LoginBasicSupervisor();

		else
			log.LoginSupervisorManager();

	}

	public void VerifyEscalatedinkForMyAgencyDisplayedForNoSupervisorUser() throws InterruptedException {
		ceCommonMethod.createCaseWithCustomeNotices("EscalatedNotice");
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		waitForCurserRunning(5);
		forcedWaitTime(3);
		scrollTillPageEnd();
		scrollIntoView(escalatedNoticeForMyAgency);
		Assert.assertTrue(elementIsDisplayed(escalatedNoticeForMyAgency));
	}

	public void VerifyUserIsNaviagtedToCLP() throws InterruptedException {
		clickByJsExecuter(escalatedNoticeForMyAgency);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CLPUtility.DownloadButton);
		Assert.assertTrue(elementIsDisplayed(CLPUtility.DownloadButton));

	}

	public void VerifyEscalatedNoticeFilterAppliedByDefault() {

		Assert.assertTrue(elementIsDisplayed(CLPUtility.escalatedNoticeStatusCLP));

	}

	public void VerifyAllOptionsSelectedForEscalatedFilter() throws InterruptedException {
		clickByJsExecuter(CLPUtility.escalatedNoticeStatusCLP);
		Thread.sleep(2000);
		int size = driver.findElements(CLPUtility.checkBoxForEscalatedNotice).size();
		List<WebElement> options = driver.findElements(CLPUtility.checkBoxForEscalatedNotice);
		for (int i = 0; i < size; i++) {
			if (!(options.get(i).isSelected())) {
				Assert.assertTrue(false);
			}

		}

	}
	List<WebElement> status;
	public void VerifyAppropriateResultsAppearAfterFilter() throws InterruptedException
	{
		movetoElementAndClick(CLPUtility.notApprovedCheckbox);
		movetoElementAndClick(CLPUtility.approved);
		movetoElementAndClick(CLPUtility.approvedAndApplied);
		clickByJsExecuter(CLPUtility.escalatedNoticeStatusCLP);
		waitForPresenceandVisiblity(CLPUtility.pendingSupervisorStatusCLP);
		status= driver.findElements(CLPUtility.pendingSupervisorStatusCLP);
		int size= status.size();
		System.out.println("size is "+size);
		scrollToRight();
		Thread.sleep(3000);
		for(int i=0;i<size;i++)
		{
			 status= driver.findElements(CLPUtility.pendingSupervisorStatusCLP);
			if(!(status.get(i).getText().equalsIgnoreCase("Pending Supervisor Approval")))
			{
				
				Assert.assertFalse(true);
			}
		}

		
		
	}
	
	//Basic supervisor cases
	public void EscalatedNoticeForMyAgencyDisplayed()
	{
		waitForElementIsInteractable(EscalatedNoticeForMyAgency);
		scrollTillPageEnd();
		Assert.assertTrue(elementIsDisplayed(EscalatedNoticeForMyAgency));
	}
	
	
}
