package POM;

import BrowsersBase.BrowsersInvoked;


import java.util.List;

import CommonMethods.CRMCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import TestCases.CCP;
import POM.ForcedAbatementUtility;
import org.testng.annotations.Listeners;

import static POM.CLPUtility.CasesCount;


public class CloseCaseUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods ceMethods;
	ForcedAbatementUtility FA;
	private String AgencyLoggedInUserName;
	CRMCommonMethods crmCommonMethods;
	PerformInspectionUtility performInspectionUtility;
	CLPUtility clpUtility;
	public static String  CaseId1;
	public static String caseId1AfterExtraction;

	public CloseCaseUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceMethods = new CECommonMethods(driver);
		FA= new ForcedAbatementUtility(driver);
		crmCommonMethods = new CRMCommonMethods(driver);
		performInspectionUtility = new PerformInspectionUtility(driver);
		clpUtility = new CLPUtility(driver);

	}

	public static String closeCaseBtn = "ul.dropdown-button__dropdown-wrap>li:first-child";
	public static String closeCasePopup = "//div[@class='modal-header' and text()='Close Case']";
	public static String cancelBtnCCPopup = "//button[text()='Cancel']";
	public static String voluntaryBtn = "//button[text()='Voluntary']";
	public static String closeCaseBtnCCPopup = "//button[text()='Close Case']";
	public static String yesBtnConfirmationPopup = "//div[@class='flex-row--center']/button[text()='Yes']";
	public static String closedStatus = "//h2[text()='Closed']";
	public static String closeCDPIcon = "//div[@class='case-details__close-icon']";

	public static By CloseCaseBtn = By.cssSelector(closeCaseBtn);
	public static By CloseCasePopup = By.xpath(closeCasePopup);
	public static By CancelBtnCCPopup = By.xpath(cancelBtnCCPopup);
	public static By VoluntaryBtn = By.xpath(voluntaryBtn);
	public static By CloseCaseBtnCCPopup = By.xpath(closeCaseBtnCCPopup);
	public static By YesBtnConfirmationPopup = By.xpath(yesBtnConfirmationPopup);
	public static By ClosedStatus = By.xpath(closedStatus);
	public static By CloseCDPIcon = By.xpath(closeCDPIcon);
	public static By CCbutton = By.xpath("//div/button[text()='Create Case']");
	public static By crtSchInsButton = By.xpath("//div[@class='modal-footer']//button[2]");
	public static By caseStatus = By.xpath("//h2[@class='case-details__case-status']");
	public static By PerformInspectionBtn = By.xpath("//button[normalize-space()='Perform Inspection']");	
	public static String CloseCaseText;
	public static String CCPopupText;
	public static String Closed_Status;
	public static List<WebElement> modalCount;
	public static WebElement VoluntaryBtnState;
	public static WebElement ForcedBtnState;
	public static WebElement Case;
	public static List<WebElement> InvalidBtnList;
	public static WebElement ConfirmationIcon;
	public static List<WebElement> ConfirmationValid;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	
	
	public void CloseCase_PreRequisite() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(5);
		AgencyLoggedInUserName=getTextElement(log.AgencyLoggedInUsername);
		ceMethods.createCaseCCP();
		CaseId1 = getTextElement(By.xpath("//h2[@class='case-details__case-number']"));
		try {
			 caseId1AfterExtraction= ceMethods.extractCaseIdOnCDP(CaseId1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
       
				
				
		System.out.println("CaseId1 after trimming : "+ caseId1AfterExtraction);
		clickOn(PerformInspectionUtility.PerformInsButton);
		clickOn(performInspectionUtility.InvalidBtnList);
		clickOn(By.xpath("//button[text()='Complete Inspection & Close Case']"));
		clickOn(performInspectionUtility.YesConfirmation);
		waitForCurserRunning(5);

		waitUntilElementIsVisible(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
		waitForCurserRunning(5);
		clickByJsExecuter(ReopenCasesUtility.ReopenCaseOption);
		clickByJsExecuter(ReopenCasesUtility.NonCompliantButton);
		clickByJsExecuter(ReopenCasesUtility.ReopenCaseButton);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
		waitUntilElementIsVisible(CloseCaseBtn);
		String CloseCaseText = getTextElement(CloseCaseBtn);
		SoftAssert s134 = new SoftAssert();
		s134.assertEquals(CloseCaseText, "Close Case");
		s134.assertAll();
	}

	public void CloseCase_OpenCloseCasePopup() throws InterruptedException {

		waitForElementIsInteractable(CloseCaseBtn);
		System.out.print(CloseCaseText);
		clickOn(CloseCaseBtn);
		waitUntilElementIsVisible(CloseCasePopup);
		waitUntilElementPresent(CloseCasePopup);
		CCPopupText = getTextElement(CloseCasePopup);


	}

	public void CloseCase_CloseCloseCasePopup() throws InterruptedException {

		waitUntilElementPresent(CancelBtnCCPopup);
		waitForElementIsInteractable(CancelBtnCCPopup);
		clickOn(CancelBtnCCPopup);
		waitUntilElementInvisibleLocated(CancelBtnCCPopup);
		waitUntilElementIsVisible(By.cssSelector("h2.case-details__case-number"));
		waitUntilElementPresent(By.cssSelector("h2.case-details__case-number"));
	    modalCount = findElementsByCssSelector("h2.case-details__case-number");
		if (((modalCount.size()) <= 1) == false) {

			SoftAssert s136 = new SoftAssert();
			s136.assertEquals(false, true);
			s136.assertAll();
		}

	}

	public void CloseCase_VerifyVoluntaryToggleBtnState() {

		waitUntilElementIsVisible(ForcedAbatementUtility.MoreBtn);
		tryWaitUntilElementPresent(ForcedAbatementUtility.MoreBtn, 2);
		scrollIntoView(ForcedAbatementUtility.MoreBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
		waitUntilElementIsVisible(CloseCaseBtn);
		waitUntilElementPresent(CloseCaseBtn);
		clickOn(CloseCaseBtn);
		waitUntilElementIsVisible(By.xpath("//div[@class='multi-choice-buttons']//button[@class='square-btn btn btn-primary']"));
		waitUntilElementPresent(By.xpath("//div[@class='multi-choice-buttons']//button[@class='square-btn btn btn-primary']"));
		VoluntaryBtnState = findElement(VoluntaryBtn);
		if ((VoluntaryBtnState.isEnabled()) == false) {

			SoftAssert s137 = new SoftAssert();
			s137.assertEquals(false, true);
			s137.assertAll();
		}

	}

	public void CloseCase_SelectForcedToggleBtn() {

		waitForPageLoadTime(3);
		waitUntilElementPresent(PerformInspectionUtility.ForcedToggle);
		ForcedBtnState = findElement(PerformInspectionUtility.ForcedToggle);
		if ((ForcedBtnState.isEnabled()) == false) {

			SoftAssert s138 = new SoftAssert();
			s138.assertEquals(false, true);
			s138.assertAll();
		}

	}

	public void CloseCase_VerifyClosedStatus() throws InterruptedException {

		waitUntilElementPresent(CloseCaseBtnCCPopup);
		waitForElementIsInteractable(CloseCaseBtnCCPopup);
		clickByJsExecuter(CloseCaseBtnCCPopup);
		waitUntilElementInvisibleLocated(CloseCaseBtnCCPopup);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		waitUntilElementPresent(CCPUtility.CaseStatus);
		Closed_Status = getTextElement(CCPUtility.CaseStatus);
		SoftAssert s139 = new SoftAssert();
		s139.assertEquals(Closed_Status, "Closed");
		s139.assertAll();
		ceMethods.closeCaseDetailPage();

	}
   public void 	closeCase_VerifyOpenFilterStatus() throws InterruptedException {


	   SoftAssert st = new SoftAssert();
	   st.assertEquals(getTextElement(By.xpath("//div[normalize-space()='No cases to display']")),"No cases to display");
	   st.assertAll();
   }

	public void AddAddress()  {

		waitUntilElementPresent(CCPUtility.LocationFld);
		waitForElementIsInteractable(CCPUtility.LocationFld);
		clickOn(CCPUtility.LocationFld);
		waitUntilElementPresent(CCPUtility.AddLocManually);
		waitForElementIsInteractable(CCPUtility.AddLocManually);
		clickOn(CCPUtility.AddLocManually);

		String StreetAddress1 = RandomStrings.requiredString(8);
		sendKeysWithWait(CCPUtility.StreetAdd, StreetAddress1);
		String CityAddress1 = RandomStrings.requiredString(8);
		sendKeysWithWait(CCPUtility.CityAdd, CityAddress1);
		sendKeysWithWait(CCPUtility.ZipAdd, "77590");
		sendKeysWithWait(CCPUtility.ApnAdd, "7030-0122-0011-000");
		clickOn(CCPUtility.SaveButton2);
		waitUntilElementInvisibleLocated(CCPUtility.SaveButton2);
	}

	public void AddVio() throws InterruptedException {

		waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
		clickOn(CCPUtility.ViolationSearchBox);
		sendKeysWithWait(CCPUtility.ViolationSearchBox, "An");
		clickOn(CCPUtility.ViolationList);
		sendKeysWithWait(CCPUtility.EntitySearchBox, "Wh");
		clickOn(CCPUtility.EntitySearchList);
		clickOn(CCPUtility.AddButton);
		waitUntilElementInvisibleLocated(CCPUtility.AddButton);
	}

	public void CloseCase_PreRequisiteCaseCreationForCloseCase() throws InterruptedException {

		ceMethods.navigateToCCP();
		ceMethods.addLocationCCP();
		ceMethods.addViolationCCP();

		Thread.sleep(5000);
		waitUntilElementIsVisible(CCPUtility.CCButton);
		waitUntilElementPresent(CCPUtility.CCButton);
		//ScrollIntoView(CCPUtility.CCButton);
		clickByJsExecuter(CCPUtility.CCButton);
		
		handleReviewContact();
		
//		Point elementLocation = driver.findElement(CCPUtility.CCButton).getLocation();
//		int xCoordinate = elementLocation.getX();
//        int yCoordinate = elementLocation.getY();
		//moveToWebElementAndClickByCordinates(CCPUtility.CCButton,xCoordinate,yCoordinate);
		waitForCurserRunning(5);
	    waitUntilElementIsVisible(By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));
	    waitUntilElementPresent(By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));

		waitUntilElementIsVisible(CCPUtility.CrtSchInsButton);
		waitUntilElementPresent(CCPUtility.CrtSchInsButton);
		scrollIntoView(CCPUtility.CrtSchInsButton);
		waitForElementIsInteractable(CCPUtility.CrtSchInsButton);
		try {
		clickByJsExecuter(CCPUtility.CrtSchInsButton);
		}
		catch(Exception e)
		{
			Thread.sleep(3000);
			clickByJsExecuter(CCPUtility.CrtSchInsButton);
		}
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		waitUntilElementPresent(CCPUtility.CaseStatus);
		scrollIntoView(CCPUtility.CaseStatus);
		Case = waitUntilVisibleWE(CCPUtility.CaseStatus);
		if ((Case.isDisplayed()) == false) {

			SoftAssert s140 = new SoftAssert();
			s140.assertEquals(false, true);
			s140.assertAll();

		}

	}

	public void CloseCase_ConfirmationPopupForCloseCaseInvalidViolations() throws InterruptedException {

		waitUntilElementIsVisible(PerformInspectionUtility.AddContactsPIP);
		waitUntilElementPresent(PerformInspectionUtility.AddContactsPIP);
		scrollIntoView(PerformInspectionUtility.AddContactsPIP);
		waitForElementIsInteractable(PerformInspectionUtility.AddContactsPIP);
		clickOn(PerformInspectionUtility.AddContactsPIP);
		waitUntilElementIsVisible(PerformInspectionUtility.CrtContactLink2);
		waitUntilElementPresent(PerformInspectionUtility.CrtContactLink2);
		waitForElementIsInteractable(PerformInspectionUtility.CrtContactLink2);
		clickOn(PerformInspectionUtility.CrtContactLink2);
		String RandomName = RandomStrings.requiredCharacters(8);
		String RandomMail = RandomName + "@yopmail.com";
		String RandomContact = RandomStrings.requiredDigits(10);
		waitUntilElementIsVisible(PerformInspectionUtility.NameFieldPIP);
		waitForElementIsInteractable(PerformInspectionUtility.NameFieldPIP);
		sendKeysWithWait(PerformInspectionUtility.NameFieldPIP, RandomName);
		sendKeysWithWait(CCPUtility.NameField, RandomName);
		sendKeysWithWait(CCPUtility.EmailField, RandomMail);
		sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);
		waitUntilElementPresent(CCPUtility.CrtContactBtn);
		waitForElementIsInteractable(CCPUtility.CrtContactBtn);
		clickOn(CCPUtility.CrtContactBtn);

		waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
		waitUntilElementPresent(CCPUtility.PropertyOwnerOption);
		waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
		clickByJsExecuter(CCPUtility.PropertyOwnerOption);
		clickByJsExecuter(CCPUtility.ApplyButton);
		waitUntilElementInvisibleLocated(CCPUtility.ApplyButton);
		waitUntilElementIsVisible(PerformInspectionUtility.PerformInsButton);
		waitUntilElementPresent(PerformInspectionUtility.PerformInsButton);
		waitForElementIsInteractable(PerformInspectionUtility.PerformInsButton);
		clickByJsExecuter(PerformInspectionUtility.PerformInsButton);
		waitUntilElementInvisibleLocated(PerformInspectionUtility.PerformInsButton);
		InvalidBtnList = waitUntilVisibleList(PerformInspectionUtility.InvalidBtnList);
		int CountList = InvalidBtnList.size();
		for (int i = 0; i < CountList; i++) {
			WebElement ListClick = InvalidBtnList.get(i);

			ListClick.click();
		}
		waitUntilElementIsVisible(PerformInspectionUtility.FooterButtons);
		waitUntilElementPresent(PerformInspectionUtility.FooterButtons);
		waitForElementIsInteractable(PerformInspectionUtility.FooterButtons);
		clickOn(PerformInspectionUtility.FooterButtons);
		ConfirmationIcon = waitUntilVisibleWE(PerformInspectionUtility.ConfirmationPopup);
		if ((ConfirmationIcon.isDisplayed()) == false) {

			SoftAssert s141 = new SoftAssert();
			s141.assertEquals(false, true);
			s141.assertAll();

		}

	}

	public void CloseCase_CloseConfirmationPopupForCloseCase() throws InterruptedException {

		waitUntilElementIsVisible(PerformInspectionUtility.CancelConfirmation);
		waitUntilElementPresent(PerformInspectionUtility.CancelConfirmation);
		scrollIntoView(PerformInspectionUtility.CancelConfirmation);
		waitForElementIsInteractable(PerformInspectionUtility.CancelConfirmation);
		clickOn(PerformInspectionUtility.CancelConfirmation);
		waitUntilElementInvisibleLocated(PerformInspectionUtility.CancelConfirmation);
		ConfirmationValid = driver.findElements(PerformInspectionUtility.ConfirmationPopup);
		if (((ConfirmationValid.size()) < 1) == false) {

			SoftAssert s142 = new SoftAssert();
			s142.assertEquals(false, true);
			s142.assertAll();

		}

	}

	public void CloseCase_VerifyClosedStatusViaPerformInspection() throws InterruptedException {

		waitUntilElementIsVisible(PerformInspectionUtility.FooterButtons);
		waitForElementIsInteractable(PerformInspectionUtility.FooterButtons);
		clickOn(PerformInspectionUtility.FooterButtons);

		waitUntilElementIsVisible(YesBtnConfirmationPopup);
		waitUntilElementPresent(YesBtnConfirmationPopup);
		waitForElementIsInteractable(YesBtnConfirmationPopup);
		clickOn(YesBtnConfirmationPopup);
		waitUntilElementInvisibleLocated(YesBtnConfirmationPopup);
		waitForCurserRunning(4);
		waitUntilElementIsVisible(ClosedStatus);
		waitUntilElementPresent(ClosedStatus);
		Closed_Status = getTextElement(ClosedStatus);

		SoftAssert s143 = new SoftAssert();
		s143.assertEquals(Closed_Status, "Closed");
		s143.assertAll();

	}

	public void Create_New_Contact() throws InterruptedException {

		waitUntilElementIsVisible(CCPUtility.AddContactFld);
		waitUntilElementPresent(CCPUtility.AddContactFld);
		waitForElementIsInteractable(CCPUtility.AddContactFld);
		clickOn(CCPUtility.AddContactFld);
		waitUntilElementPresent(PerformInspectionUtility.CrtContactLink2);
		clickOn(PerformInspectionUtility.CrtContactLink2);
		waitUntilElementIsVisible(PerformInspectionUtility.NameFieldPIP);
		waitForElementIsInteractable(PerformInspectionUtility.NameFieldPIP);
		String RandomName = RandomStrings.requiredCharacters(8);
		String RandomMail = RandomName + "@yopmail.com";
		String RandomContact = RandomStrings.requiredDigits(10);
		sendKeysWithWait(PerformInspectionUtility.NameFieldPIP, RandomName);
		sendKeysWithWait(CCPUtility.NameField, RandomName);
		sendKeysWithWait(CCPUtility.EmailField, RandomMail);
		sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);
		clickOn(PerformInspectionUtility.CrtContactBtn);
		waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
		waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
		clickOn(CCPUtility.PropertyOwnerOption);
		clickOn(CCPUtility.ApplyButton);
		waitUntilElementInvisibleLocated(CCPUtility.ApplyButton);
	}

	public void CreateCasePreRequisites() throws InterruptedException {
		driver.navigate().to(BrowsersInvoked.URLCreateCase);

		AddAddress();
		AddVio();
		Create_New_Contact();

		waitUntilElementIsVisible(CCPUtility.CCButton);
		waitUntilElementPresent(CCPUtility.CCButton);
		waitForElementIsInteractable(CCPUtility.CCButton);
		clickOn(CCPUtility.CCButton);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CCPUtility.CrtSchInsButton);
		waitUntilElementPresent(CCPUtility.CrtSchInsButton);
		waitUntilElementIsVisible(
				By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));
		waitUntilElementPresent(
				By.xpath("//h5[text()='Assign Case To']//parent::div//button[@class='square-btn btn btn-primary']"));
		waitForElementIsInteractable(CCPUtility.CrtSchInsButton);
		clickByJsExecuter(CCPUtility.CrtSchInsButton);
		waitUntilElementInvisibleLocated(CCPUtility.CrtSchInsButton);
		waitForCurserRunning(5);

	}

	public void CloseCaseDetailPage() throws InterruptedException {
		waitUntilElementIsVisible(CCPUtility.CloseCDP);
		scrollIntoView(CCPUtility.CloseCDP);
		waitForElementIsInteractable(CCPUtility.CloseCDP);
		clickByJsExecuter(CCPUtility.CloseCDP);
		waitUntilElementInvisibleLocated(CCPUtility.CloseCDP);
		waitForCurserRunning(5);
	}

	public void CloseCase_CloseCasewithValidViolations() throws InterruptedException {

		CloseCaseDetailPage();
		CloseCase_PreRequisiteCaseCreationForCloseCase();
		waitForCurserRunning(10);
		waitUntilElementIsVisible(By.cssSelector("h2.case-details__case-number"));
		waitUntilElementIsVisible(PerformInspectionUtility.PerformInsButton);
		scrollIntoView(PerformInspectionUtility.PerformInsButton);
		waitUntilElementPresent(PerformInspectionUtility.PerformInsButton);
		waitForElementIsInteractable(PerformInspectionUtility.PerformInsButton);
		clickOn(PerformInspectionUtility.PerformInsButton);
		waitUntilElementIsVisible(PerformInspectionUtility.ValidBtnList);
		waitUntilElementPresent(PerformInspectionUtility.ValidBtnList);
		waitForElementIsInteractable(PerformInspectionUtility.ValidBtnList);
		clickOn(PerformInspectionUtility.ValidBtnList);
		scrollIntoView(PerformInspectionUtility.FooterButtons);
		waitUntilElementPresent(PerformInspectionUtility.FooterButtons);
		waitForElementIsInteractable(PerformInspectionUtility.FooterButtons);
		clickOn(PerformInspectionUtility.FooterButtons);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CloseCasePopup);
		CCPopupText = getTextElement(CloseCasePopup);

		SoftAssert s144a = new SoftAssert();
		s144a.assertEquals(CCPopupText, "Close Case");
		s144a.assertAll();

		clickOn(CloseCaseBtnCCPopup);
		waitUntilElementInvisibleLocated(CloseCaseBtnCCPopup);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CCPUtility.CaseStatus);
		waitUntilElementPresent(CCPUtility.CaseStatus);
		scrollIntoView(CCPUtility.CaseStatus);
		Closed_Status = getTextElement(CCPUtility.CaseStatus);

		SoftAssert s144b = new SoftAssert();
		s144b.assertEquals(Closed_Status, "Closed");
		s144b.assertAll();

	}

}
