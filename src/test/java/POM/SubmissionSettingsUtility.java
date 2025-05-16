package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;

public class SubmissionSettingsUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public SubmissionSettingsUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	public static By YesToggle1 = By.xpath("//button[text()='Yes']");
	public static By NoToggle1 = By.xpath("//button[text()='No']");
	public static By YesToggle2 = By.xpath("(//button[text()='Yes'])[2]");
	public static By NoToggle2 = By.xpath("(//button[text()='No'])[2]");
	public static By DiscardChangesButton = By.xpath("//button[text()='Discard Changes']");
	public static By SaveChangesButton = By.xpath("//button[text()='Save Changes']");
	public static By CaseStatus = By.xpath("//h2[@class='case-details__case-status']");
	public static By SubmissionStatus = By.xpath("//h2[@class='customer-submission-details__status']");

	public static boolean ToggleButtonState;
	public static boolean ToggleButtonState2;
	public static boolean ToggleButtonState3;
	public static String FetchCaseStatusForYes;
	public static String FetchSubmissionStatusForYes;
	public static String FetchCaseStatusForNo;
	public static String FetchSubmissionStatusForNo;
	public static boolean ToggleButtonState4;
	public static boolean PostAnonymouslyPresence;
	public static boolean PostAnonymouslyAbsence;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void SubmissionSettings_VerifyToggleButtonsState() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLSubmissionSettings);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(YesToggle1);
		waitUntilElementPresent(YesToggle1);
		waitForElementIsInteractable(YesToggle1);
		clickByJsExecuter(YesToggle1);
		String GetClass = waitUntilVisibleWE(YesToggle1).getAttribute("class");
		ToggleButtonState = GetClass.equals("square-btn btn btn-primary");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ToggleButtonState);
		softAssert.assertAll();

	}

	public void SubmissionSettings_VerifyDiscardButtonFunctionality() throws InterruptedException {

		waitUntilElementPresent(NoToggle1);
		waitForElementIsInteractable(NoToggle1);
		clickByJsExecuter(NoToggle1);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(YesToggle1);
		waitUntilElementPresent(YesToggle1);
		waitForElementIsInteractable(YesToggle1);
		clickByJsExecuter(YesToggle1);
		waitForElementIsInteractable(DiscardChangesButton);
		clickByJsExecuter(DiscardChangesButton);
		waitForCurserRunning(5);
		String GetClass = waitUntilVisibleWE(YesToggle1).getAttribute("class");
		ToggleButtonState2 = GetClass.equals("square-btn btn btn-primary");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(ToggleButtonState2);
		softAssert.assertAll();

	}

	public void SubmissionSettings_VerifyChangesGetSaved() throws InterruptedException {

		waitUntilElementIsVisible(YesToggle1);
		waitForElementIsInteractable(YesToggle1);
		clickByJsExecuter(YesToggle1);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(YesToggle1);
		String GetClass = waitUntilVisibleWE(YesToggle1).getAttribute("class");
		ToggleButtonState3 = GetClass.equals("square-btn btn btn-primary");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ToggleButtonState3);
		softAssert.assertAll();

	}

	public void SubmissionSettings_VerifyAutomaticClosingOfLinkedSubmission() throws InterruptedException {
		waitUntilElementPresent(YesToggle1);
		waitForElementIsInteractable(YesToggle1);
		clickByJsExecuter(YesToggle1);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(3);
		CreateAndLinkCaseUtility createLinkCase = new CreateAndLinkCaseUtility(driver);
		createLinkCase.CreateAndLinkCase_PreRequisite();
		createLinkCase.CreateAndLinkCase_OpenCCPToLinkTheCase();
		createLinkCase.CreateAndLinkCase_VerifyLinkedCase();
		CRMCommonMethods crmMethod = new CRMCommonMethods(driver);
		crmMethod.closeCaseOnCDP();
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CaseStatus);
		FetchCaseStatusForYes = getTextElement(CaseStatus);
		forcedWaitTime(4);
		scrollIntoView(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		waitForElementIsInteractable(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		clickOn(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		waitForCurserRunning(2);
		forcedWaitTime(5);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		waitUntilElementIsVisible(SubmissionStatus);
		FetchSubmissionStatusForYes = getTextElement(SubmissionStatus);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(FetchCaseStatusForYes, "Closed");
		softAssert.assertEquals(FetchSubmissionStatusForYes, "Closed");
		softAssert.assertAll();
	}

	public void SubmissionSettings_VerifyCaseDoesntCloseForNoToggle() throws InterruptedException {
		closeOtherTabs();
		forcedWaitTime(3);
		driver.get(BrowsersInvoked.URLSubmissionSettings);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(NoToggle1);
		waitForElementIsInteractable(NoToggle1);
		clickByJsExecuter(NoToggle1);
		waitUntilElementIsVisible(SaveChangesButton);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);
		CreateAndLinkCaseUtility createLinkCase = new CreateAndLinkCaseUtility(driver);
		createLinkCase.CreateAndLinkCase_PreRequisite();
		createLinkCase.CreateAndLinkCase_OpenCCPToLinkTheCase();
		createLinkCase.CreateAndLinkCase_VerifyLinkedCase();
		CRMCommonMethods crmMethod = new CRMCommonMethods(driver);
		crmMethod.closeCaseOnCDP();
		waitForCurserRunning(10);
		forcedWaitTime(2);
		waitUntilElementIsVisible(CaseStatus);
		waitUntilElementIsVisible(CaseStatus);
		FetchCaseStatusForNo = getTextElement(CaseStatus);
		scrollIntoView(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		waitForElementIsInteractable(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		clickOn(CreateAndLinkCaseUtility.AssociatedSubmissionLink);
		waitForCurserRunning(5);
		forcedWaitTime(4);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		System.out.println("Current Tab URL: " + driver.getCurrentUrl());
		waitForPageLoadTime(4);
		waitUntilElementIsVisible(SubmissionStatus);
		FetchSubmissionStatusForNo = getTextElement(SubmissionStatus);
		SubmissionSettings_VerifyToggleButtonsState();
		waitUntilElementIsVisible(SaveChangesButton);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(FetchCaseStatusForNo, "Closed");
		softAssert.assertEquals(FetchSubmissionStatusForNo, "Open");
		softAssert.assertAll();
	}

	public void renderSubmissionSettingPage() {
		driver.get(BrowsersInvoked.URLSubmissionSettings);
	}

	public void SubmissionSettings_VerifyselectionOfAnonymousToggles() throws InterruptedException {
		renderSubmissionSettingPage();
		waitForCurserRunning(4);

		waitUntilElementIsVisible(YesToggle2);
		waitForElementIsInteractable(YesToggle2);
		clickByJsExecuter(YesToggle2);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(YesToggle2);
		waitUntilElementPresent(YesToggle2);
		String GetClass = findElement(YesToggle2).getAttribute("class");
		ToggleButtonState4 = GetClass.equals("square-btn btn btn-primary");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ToggleButtonState4);
		softAssert.assertAll();

	}

	public void SubmissionSettings_VerifyPostAnonymouslyForYesToggle() throws InterruptedException {
		waitForElementIsInteractable(YesToggle2);
		clickOn(YesToggle2);
		clickOn(SaveChangesButton);
		waitForCurserRunning(8);
		waitUntilElementIsVisible(CSPInternalUtility.PlusIconToCRM);
		waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
		clickOn(CSPInternalUtility.PlusIconToCRM);
		waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
		clickOn(CSPInternalUtility.CustomerSubmissionOption);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CSPInternalUtility.PostAnonymouslyCheckbox);
		WebElement PostAnonymously = waitUntilVisibleWE(CSPInternalUtility.PostAnonymouslyCheckbox);
		PostAnonymouslyPresence = PostAnonymously.isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PostAnonymouslyPresence);
		softAssert.assertAll();
	}

	public void SubmissionSettings_VerifyPostAnonymouslyForNoToggle() throws InterruptedException {
		renderSubmissionSettingPage();
		waitForCurserRunning(5);
		waitUntilElementIsVisible(NoToggle2);
		waitUntilElementPresent(NoToggle2);
		waitForElementIsInteractable(NoToggle2);
		clickByJsExecuter(NoToggle2);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(CSPInternalUtility.PlusIconToCRM);
		waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
		clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
		waitUntilElementIsVisible(CSPInternalUtility.CustomerSubmissionOption);
		waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
		clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
		waitForCurserRunning(8);

		List<WebElement> PostAnonymously = driver.findElements(CSPInternalUtility.PostAnonymouslyCheckbox);
		PostAnonymouslyAbsence = PostAnonymously.size() == 0;
		SubmissionDefaultsetttings();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PostAnonymouslyPresence);
		softAssert.assertAll();
	}

	public void SubmissionDefaultsetttings() throws InterruptedException {
		forcedWaitTime(3);
		driver.navigate().to(BrowsersInvoked.URLSubmissionSettings);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(YesToggle2);
		waitForElementIsInteractable(YesToggle2);
		clickByJsExecuter(YesToggle2);
		waitUntilElementPresent(SaveChangesButton);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);

	}

}
