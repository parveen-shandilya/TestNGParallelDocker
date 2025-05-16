package POM;

import BrowsersBase.BrowsersInvoked;

import static java.lang.Integer.parseInt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;

public class DashBoardUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public DashBoardUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	String dashboardDropdownArrow = "//span[@class='dropdown__arrow']";
	String allStaffOption = "//li[text()='All Staff']";
	String selectedOptionText = "//div[@class='dropdown__selector__selected']/label";
	String meOption = "//li[text()='Me']";
	String openCasesAssignedToMe = "//label[text()='Open cases assigned to me']";
	String dashboardPage = "//a[text()='Dashboard']";
	String openCasesForMyAgency = "//label[text()='Open cases for my agency']";
	String overdueInspections = "//label[text()='Overdue Inspections']";
	String overdueInspection = "//label[text()='Overdue Inspection']";
	String inspectionsDueToday = "//label[contains(text(),'Due Today')]";
	String totalInspections = "//label[text()='Total Inspections']";
	String totalCasesForMyAgency = "//label[text()='Total cases for my agency']";
	String showMoreLink = "//label[text()='Total Inspections']/following::a";
	String totalCasesPopup = "//div[@class='modal-header']/label[@class='widget__text']";
	String closePopupButton = "//div[@class='modal-footer']//button";
	String countOpenCasesFMA = "//label[text()='Open cases for my agency']/preceding-sibling::span";
	String noticesToPrintLink = "//*[@class='widget widget-size']/a/*[contains(text(),'unprinted notices')]";
	String noticesTotal = "(//span[@class='widget__total'])[7]";
	String noticeToPrintLink = "//*[@class='widget widget-size']/a/*[contains(text(),'unprinted notices')]";
	String printQueuePopup = "//div[@class='modal-header']//h2";
	String closePrintQueuePopoup = "//div[@class='modal-footer']//button[1]";
	String inspectionsDueTodayCount = "//label[contains(text(),'Due Today')]/preceding-sibling::span";
	String inspectionDueToday = "//label[text()='Inspection Due Today']";
	public static By dashboardTab = By.xpath("//a[text()='Dashboard']");
    public static  By escalatedNoticeLink = By.xpath("//label[text()='Escalated notices for my agency']");
    public static By escalatedNoticsCount = By.xpath("(//div[@class='widget widget-size'])[2]");

	By DashboardDropdownArrow = By.xpath(dashboardDropdownArrow);
	By AllStaffOption = By.xpath(allStaffOption);
	By SelectedOptionText = By.xpath(selectedOptionText);
	By MeOption = By.xpath(meOption);
	By OpenCasesAssignedToMe = By.xpath(openCasesAssignedToMe);
	By DashboardPage = By.xpath(dashboardPage);
	By OpenCasesForMyAgency = By.xpath(openCasesForMyAgency);
	By OverdueInspections = By.xpath(overdueInspections);
	By OverdueInspection = By.xpath(overdueInspection);
	By InspectionsDueToday = By.xpath(inspectionsDueToday);
	By TotalInspections = By.xpath(totalInspections);
	By TotalCasesForMyAgency = By.xpath(totalCasesForMyAgency);
	By ShowMoreLink = By.xpath(showMoreLink);
	By TotalCasesPopup = By.xpath(totalCasesPopup);
	By ClosePopupButton = By.xpath(closePopupButton);
	By NoticeTotal = By.xpath(noticesTotal);

	By NoticesToPrintLink = By.xpath(noticesToPrintLink);
	By NoticeToPrintLink = By.xpath(noticeToPrintLink);

	By PrintQueuePopup = By.xpath(printQueuePopup);
	By ClosePrintQueuePopoup = By.xpath(closePrintQueuePopoup);
	By CountOpenCasesFMA = By.xpath(countOpenCasesFMA);

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void tc_Dashboard_ViewAllStaffDashboard() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(DashboardDropdownArrow);
		waitForElementIsInteractable(DashboardDropdownArrow);
		clickByJsExecuter(DashboardDropdownArrow);
		waitUntilElementIsVisible(AllStaffOption);
		waitForElementIsInteractable(AllStaffOption);
		clickByJsExecuter(AllStaffOption);
		waitUntilElementIsVisible(SelectedOptionText);
		String AllStaffText = getTextElement(SelectedOptionText);
		Assert.assertEquals(AllStaffText, "All Staff");

	}

	public void tc_Dashboard_ViewMeDashboard() throws InterruptedException {
		try {
			waitUntilElementIsVisible(DashboardDropdownArrow);
			waitForElementIsInteractable(DashboardDropdownArrow);

			clickOn(DashboardDropdownArrow);
		} catch (Exception e) {
			Thread.sleep(5000);
			clickOn(DashboardDropdownArrow);
		}
		waitUntilElementIsVisible(MeOption);
		waitForElementIsInteractable(MeOption);
		clickOn(MeOption);
		String AllStaffText = getTextElement(SelectedOptionText);
		Assert.assertEquals(AllStaffText, "Me");

	}

	public void tc_Dashboard_OpenCasesAssignedToMeLink() throws InterruptedException {

		waitUntilElementIsVisible(OpenCasesAssignedToMe);
		waitForElementIsInteractable(OpenCasesAssignedToMe);
		implicitWaitforCustometime(2);
		clickByJsExecuter(OpenCasesAssignedToMe);

		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {

			SoftAssert s3 = new SoftAssert();
			s3.assertEquals(false, true);
			s3.assertAll();

		}

	}

	@Test(priority = 4)
	public void tc_Dashboard_OpenCasesForMyAgencyLink() {

		try {

			clickByJsExecuter(By.xpath("//a[text()='Dashboard']"));
			waitForCurserRunning(2);
			waitUntilElementIsVisible(DashboardDropdownArrow);
			waitForElementIsInteractable(DashboardDropdownArrow);
			clickByJsExecuter(DashboardDropdownArrow);
			clickByJsExecuter(MeOption);
			waitUntilElementIsVisible(OpenCasesForMyAgency);
			waitForElementIsInteractable(OpenCasesForMyAgency);
			clickOn(OpenCasesForMyAgency);

			WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
			if ((CasesText.isDisplayed()) == false) {
				SoftAssert s4 = new SoftAssert();
				s4.assertEquals(false, true);
				s4.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void tc_Dashboard_OverdueInspectionsLink() {

		driver.navigate().to(BrowsersInvoked.URLDashboard);

		waitUntilElementIsVisible(DashboardDropdownArrow);
		waitForElementIsInteractable(DashboardDropdownArrow);
		clickByJsExecuter(DashboardDropdownArrow);

		waitUntilElementIsVisible(MeOption);
		scrollIntoView(MeOption);
		waitForElementIsInteractable(MeOption);
		clickByJsExecuter(MeOption);

		waitUntilElementIsVisible(OverdueInspections);
		scrollIntoView(OverdueInspections);
		int overDueInstpections = driver.findElements(OverdueInspections).size();
		if (overDueInstpections > 0) {

			waitUntilElementPresent(OverdueInspections);
			waitForElementIsInteractable(OverdueInspections);
			clickByJsExecuter(OverdueInspections);

		} else {
			clickOn(OverdueInspection);
		}

		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {
			SoftAssert s5 = new SoftAssert();
			s5.assertEquals(false, true);
			s5.assertAll();
		}

	}

	public By InspectionDueTodayCount = By.xpath(inspectionsDueTodayCount);
	public By InspectionDueToday = By.xpath(inspectionDueToday);
	public By InspectionDuetdy = By.xpath(inspectionsDueToday);

	public void tc_Dashboard_InspectionsDueTodayLink() {

		try {
			driver.navigate().to(BrowsersInvoked.URLDashboard);
			implicitWaitforCustometime(5);
			waitUntilElementIsVisible(DashboardDropdownArrow);
			waitForElementIsInteractable(DashboardDropdownArrow);
			clickByJsExecuter(DashboardDropdownArrow);
			waitUntilElementIsVisible(MeOption);
			waitForElementIsInteractable(MeOption);
			clickByJsExecuter(MeOption);
			scrollIntoView(InspectionDueTodayCount);
			String dueTodayCount = getTextElement(InspectionDueTodayCount);
			int TodayDueWidget = parseInt(dueTodayCount);
			if (TodayDueWidget > 1) {
				clickByJsExecuter(InspectionsDueToday);
			} else {
				clickByJsExecuter(InspectionDueToday);
			}

			WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
			if (!(CasesText.isDisplayed())) {
				SoftAssert s6 = new SoftAssert();
				s6.assertEquals(false, true);
				s6.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tc_Dashboard_TotalInspectionsLink() {

		try {
			driver.navigate().to(BrowsersInvoked.URLDashboard);

			implicitWaitforCustometime(3);
			waitUntilElementIsVisible(DashboardDropdownArrow);
			waitForElementIsInteractable(DashboardDropdownArrow);
			clickByJsExecuter(DashboardDropdownArrow);
			waitForElementIsInteractable(MeOption);
			clickByJsExecuter(MeOption);

			waitUntilElementIsVisible(TotalInspections);
			scrollIntoView(TotalInspections);

			waitUntilElementIsVisible(TotalInspections);
			waitForElementIsInteractable(TotalInspections);
			clickByJsExecuter(TotalInspections);

			WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
			if ((CasesText.isDisplayed()) == false) {
				SoftAssert s7 = new SoftAssert();
				s7.assertEquals(false, true);
				s7.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void tc_Dashboard_AllStaff_OpenCasesForMyAgency() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(OpenCasesForMyAgency);

		waitForElementIsInteractable(OpenCasesForMyAgency);
		clickByJsExecuter(OpenCasesForMyAgency);

		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {
			SoftAssert s8 = new SoftAssert();
			s8.assertEquals(false, true);
			s8.assertAll();

		}

	}

	public void tc_Dashboard_TotalcasesForMyAgencyLink() {

		driver.navigate().to(BrowsersInvoked.URLDashboard);

		waitUntilElementIsVisible(TotalCasesForMyAgency);
		scrollIntoView(TotalCasesForMyAgency);

		waitForElementIsInteractable(TotalCasesForMyAgency);
		clickByJsExecuter(TotalCasesForMyAgency);

		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {
			SoftAssert s9 = new SoftAssert();
			s9.assertEquals(false, true);
			s9.assertAll();
		}

	}

	public void tc_Dashboard_AllStaff_OverdueInspections() {

		driver.navigate().to(BrowsersInvoked.URLDashboard);

		waitUntilElementIsVisible(OverdueInspections);
		scrollIntoView(OverdueInspections);
		waitForElementIsInteractable(OverdueInspections);
		clickByJsExecuter(OverdueInspections);

		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {
			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(false, true);
			s10.assertAll();
		}

	}

	@Test(priority = 11)
	public void tc_Dashboard_AllStaff_InspectionsDueToday() {

		try {
			driver.navigate().to(BrowsersInvoked.URLDashboard);
			waitUntilElementIsVisible(InspectionDueTodayCount);
			waitUntilElementPresent(InspectionDueTodayCount);
			String dueTodayCount = getTextElement(InspectionDueTodayCount);
			int TodayDueWidget = Integer.parseInt(dueTodayCount);
			if (TodayDueWidget > 1) {
				scrollIntoView(InspectionsDueToday);

				waitForElementIsInteractable(InspectionDueTodayCount);
				clickByJsExecuter(InspectionsDueToday);
			} else {

				scrollIntoView(InspectionDueToday);
				clickByJsExecuter(InspectionDueToday);

			}

			WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
			if ((CasesText.isDisplayed()) == false) {
				SoftAssert s11 = new SoftAssert();
				s11.assertEquals(false, true);
				s11.assertAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tc_Dashboard_AllStaff_TotalInspectionsLink() {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitUntilElementIsVisible(TotalInspections);
		waitUntilVisibleWE(TotalInspections);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)", "");

		scrollIntoView(TotalInspections);

		waitForElementIsInteractable(TotalInspections);
		clickByJsExecuter(TotalInspections);

		waitUntilVisibleWE(CLPUtility.Cases);
		waitUntilElementPresent(CLPUtility.Cases);
		WebElement CasesText = waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {
			SoftAssert s12 = new SoftAssert();
			s12.assertEquals(false, true);
			s12.assertAll();
		}

	}

	public void tc_Dashboard_OpenTotalInspectionPopup() {

		try {
			driver.navigate().to(BrowsersInvoked.URLDashboard);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2500)", "");

			clickOn(ShowMoreLink);

			String PopupTitle = getTextElement(TotalCasesPopup);

			SoftAssert s13 = new SoftAssert();
			s13.assertEquals(PopupTitle, "Total Inspections");
			s13.assertAll();
			clickOn(ClosePrintQueuePopoup);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void tc_Dashboard_CompareCountOfCasesWithCLP() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CountOpenCasesFMA);
		String GetOpenCasesFMACount = getTextElement(CountOpenCasesFMA);
		int CountCases1 = Integer.parseInt(GetOpenCasesFMACount);
		System.out.println("count1 " + CountCases1);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,-2500)", "");
		scrollIntoView(OpenCasesForMyAgency);
		waitUntilVisibleWE(OpenCasesForMyAgency);
		waitForElementIsInteractable(OpenCasesForMyAgency);
		clickOn(OpenCasesForMyAgency);

		Thread.sleep(5000);
		implicitWaitforCustometime(12);
		waitUntilElementPresent(CLPUtility.CasesCount);
		waitUntilVisibleWE(CLPUtility.CasesCount);
		System.out.println(getTextElement(CLPUtility.CasesCount));
		String[] CountOfCases = getTextElement(CLPUtility.CasesCount).split(" ");
		System.out.println("size of list " + CountOfCases.length);
		for (String s : CountOfCases)
			System.out.println(s);
		String CountCases0 = CountOfCases[0];
		int CountCases = Integer.parseInt(CountCases0);
		Assert.assertEquals(CountCases1, CountCases);
		System.out.println("2nd " + CountCases1 + " " + CountCases);
		clickOn(DashboardPage);

	}

	public void tc_Dashboard_OpenPrintQueuePopup() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(2);
		waitUntilElementPresent(NoticeTotal);
		waitUntilElementIsVisible(NoticeTotal);
		scrollIntoView(NoticeTotal);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		scrollTillPageEnd();
		if (parseInt(getTextElement(NoticeTotal)) > 1) {
			scrollIntoView(NoticesToPrintLink);
			waitForElementIsInteractable(NoticesToPrintLink);
			clickByJsExecuter(NoticesToPrintLink);

		} else {
			waitForElementIsInteractable(NoticeToPrintLink);
			scrollIntoView(NoticeToPrintLink);
			waitForElementIsInteractable(NoticeToPrintLink);
			clickByJsExecuter(NoticeToPrintLink);
		}
		WebElement PopupTitle = waitUntilVisibleWE(PrintQueuePopup);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PopupTitle.isDisplayed(), "Print Queue Popup didn't open!!");
		waitUntilElementIsVisible(ClosePrintQueuePopoup);
		waitForCurserRunning(2);
		clickOn(ClosePrintQueuePopoup);
		softAssert.assertAll();

	}

}
