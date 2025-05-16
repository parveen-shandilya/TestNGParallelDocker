package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import CommonMethods.Helper;

public class ReopenCasesUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public ReopenCasesUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	public static String statusColumnSort = "//div[text()='Status']";
	public static String closedCase = "//span[@class='checkbox-holder']/following::a[1]";
	public static String reOpenCaseGrid = "//span[contains(text(),' Reopened')]//parent::div//parent::div//preceding-sibling::div//span[@class='checkbox-holder']/following::a[1]";
	public static String reopenCaseOption = "//li[text()='Reopen Case']";
	public static String closedCaseGrid = "//div[contains(text(),'Closed')]//parent::div//parent::div//preceding-sibling::div//span[@class='checkbox-holder']/following::a[1]";
	public static String reopenCasePopup = "//div[@class='modal-header']/following::span[text()='Reopen Case']";
	public static String violationsOnCDP = "//span[@class='violation-label']";
	public static String reopenCaseButton = "//button[text()='Reopen Case']";
	public static String errorMessageRCP = "//h5[@id='reopen-case-heading']";
	public static String violationsOnRCP = "//div[@class='case-violation-list reopen-variant']//span[@class='violation-label']";
	public static String nonCompliantButton = "//button[text()='Non-Compliant']";
	public static String reopenedCaseActivity = "//h4[@class='case-activity__label' and text()='Case Reopened']";
	public static String dateReopenedCase = "//h4[text()='Case Reopened']/following-sibling::span";
	public static String userInfoRCP = "//h4[text()='Case Reopened']/following::label[@class='case-activity__user-info']";
	public static String CancelButton = "//button[text()='Cancel']";

	public static By StatusColumnSort = By.xpath(statusColumnSort);
	public static By ReOpenCaseGrid = By.xpath(reOpenCaseGrid);
	public static By ClosedCaseGrid = By.xpath(closedCaseGrid);
	public static By ClosedCase = By.xpath(closedCase);
	public static By ReopenCaseOption = By.xpath(reopenCaseOption);
	public static By ReopenCasePopup = By.xpath(reopenCasePopup);
	public static By ViolationsOnCDP = By.xpath(violationsOnCDP);
	public static By ReopenCaseButton = By.xpath(reopenCaseButton);
	public static By ViolationsOnRCP = By.xpath(violationsOnRCP);
	public static By ErrorMessageRCP = By.xpath(errorMessageRCP);
	public static By NonCompliantButton = By.xpath(nonCompliantButton);
	public static By ReopenedCaseActivity = By.xpath(reopenedCaseActivity);
	public static By DateReopenedCase = By.xpath(dateReopenedCase);
	public static By UserInfoRCP = By.xpath(userInfoRCP);
	public static By cancelButton = By.xpath(CancelButton);

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void ReopenCase_PreRequisite() throws InterruptedException {
		Thread.sleep(5000);
		waitForCurserRunning(20);
		waitForPageLoadTime(20);

		waitForElementIsInteractable(CLPUtility.CLP);
		waitForPresenceandVisiblity(CLPUtility.CLP);
		clickOn(CLPUtility.CLP);
		Thread.sleep(5000);
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
		forcedWaitTime(10);
		
		
		clickByJsExecuter(By.xpath("(//*[@class='dropdown__selector__selected']//span)[4]"));
		clickByJsExecuter(By.xpath("//*[@class='checkbox-holder checkbox-holder--radio']//input[@name='Closed']"));
		clickByJsExecuter(By.xpath("(//*[@class='dropdown__selector__selected']//span)[4]"));

		
		
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
		scrollIntoView(StatusColumnSort);
		int checkOpen = driver.findElements(ClosedCaseGrid).size();
		if (checkOpen > 0) {
			waitUntilElementIsVisible(ClosedCaseGrid);
			waitUntilElementPresent(ClosedCaseGrid);
			scrollIntoView(ClosedCaseGrid);
			waitForElementIsInteractable(ClosedCaseGrid);
			clickByJsExecuter(ClosedCaseGrid);
			waitUntilElementInvisibleLocated(ClosedCaseGrid);
		} else {
			clickOn(StatusColumnSort);
			implicitWaitforCustometime(5);
			waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
			waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
			int checktOpen = driver.findElements(ClosedCaseGrid).size();
			if (checktOpen > 0) {
				waitUntilElementPresent(ClosedCaseGrid);
				scrollIntoView(ClosedCaseGrid);
				waitForElementIsInteractable(ClosedCaseGrid);
				clickByJsExecuter(ClosedCaseGrid);
				waitUntilElementInvisibleLocated(ClosedCaseGrid);

			}
		
		}
		waitForCurserRunning(5);
		String ClosedStatus;
		
			waitForElementIsInteractable(CCPUtility.CaseStatus);
			
			 ClosedStatus = getTextElement(CCPUtility.CaseStatus);
		
		
	Assert.assertEquals("Closed",ClosedStatus);

	}

	public void ReopenCase_OpenReopenCasePopup() throws InterruptedException {
		Thread.sleep(5000);

		waitUntilElementIsVisible(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
		waitUntilElementIsVisible(ReopenCaseOption);
		waitForElementIsInteractable(ReopenCaseOption);
		Thread.sleep(5000);
		clickOn(ReopenCaseOption);
		waitUntilElementIsVisible(ReopenCasePopup);
		String PopupTitle = getTextElement(ReopenCasePopup);
		Assert.assertEquals("Reopen Case", PopupTitle);
	}

	public ArrayList<String> VioCDPList = new ArrayList<String>();

	public void ReopenCase_VerifyViolationsFromCDP() throws InterruptedException {
		waitUntilElementIsVisible(cancelButton);
		waitForElementIsInteractable(cancelButton);
		clickOn(cancelButton);
		waitUntilElementIsInvisible(cancelButton);
		waitUntilElementIsVisible(ViolationsOnCDP);
		waitUntilElementIsVisible(ViolationsOnCDP);
		scrollIntoView(ViolationsOnCDP);
		List<WebElement> VioCDP = waitUntilVisibleList(ViolationsOnCDP);
		int VioCDPCount = VioCDP.size();
		for (int i = 0; i < VioCDPCount; i++) {
			WebElement VioList = VioCDP.get(i);
			String ViolationsCDP = VioList.getText();
			VioCDPList.add(ViolationsCDP);
		}
		waitUntilElementIsVisible(ForcedAbatementUtility.MoreBtn);
		scrollIntoView(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		clickOn(ForcedAbatementUtility.MoreBtn);
		waitUntilElementIsVisible(ReopenCaseOption);
		waitForElementIsInteractable(ReopenCaseOption);
		clickOn(ReopenCaseOption);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(ViolationsOnRCP);
		ArrayList<String> VioRCPList = new ArrayList<String>();
		List<WebElement> VioRCP = waitUntilVisibleList(ViolationsOnRCP);
		int VioRCPCount = VioRCP.size();
		for (int i = 0; i < VioRCPCount; i++) {
			WebElement VioList2 = VioRCP.get(i);
			String ViolationsRCP = VioList2.getText();
			VioRCPList.add(ViolationsRCP);
		}
		boolean CompareList = VioCDPList.equals(VioRCPList);
		Assert.assertEquals(CompareList, true);
	}

	public void ReopenCase_NonCompliantViolationIsRequired() {
		waitForElementIsInteractable(ReopenCaseButton);
		clickOn(ReopenCaseButton);
		String ErrorMsgExp = "You must mark at least one violation as Non-Compliant and schedule an inspection to reopen this Case.";
		String ErrorMsgActual = getTextElement(ErrorMessageRCP);
		Assert.assertEquals(ErrorMsgExp, ErrorMsgActual);
	}

	public void ReopenCase_CaseDoesNotReopenOnCancel() throws InterruptedException {
		waitForElementIsInteractable(cancelButton);
		clickOn(cancelButton);
		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		String ClosedStatus = getTextElement(CCPUtility.CaseStatus);
		Assert.assertEquals("Closed", ClosedStatus);
	}

	public void ReopenCase_VerifyCaseReopened() throws InterruptedException {
		clickOn(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ReopenCaseOption);
		clickOn(ReopenCaseOption);
		clickOn(NonCompliantButton);
		clickOn(ReopenCaseButton);
		waitForCurserRunning(10);

		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		waitUntilVisibleWE(CCPUtility.CaseStatus);
		String ClosedStatus = getTextElement(CCPUtility.CaseStatus);
		Assert.assertEquals("Open", ClosedStatus);
	}

	public void ReopenCase_VerifyCaseReopenedDetails() throws InterruptedException {
		String ReopenedCaseStr = getTextElement(ReopenedCaseActivity);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Case Reopened", ReopenedCaseStr);
		String UserInfoActual = getTextElement(UserInfoRCP);
		String UserInfoExp = "Reopened by " + LoginUtility.AgencyLoggedInUserName;
		SoftAssert soft2 = new SoftAssert();
		soft2.assertEquals(UserInfoExp, UserInfoActual);
		soft.assertAll();
//        WaitUntilVisible(By.cssSelector("div.case-details__close-icon img"));
//        ScrollIntoView(By.cssSelector("div.case-details__close-icon img"));
//        ClickOn(By.cssSelector("div.case-details__close-icon img"));
//        WaitForCurserRunning(4);

	}

}
