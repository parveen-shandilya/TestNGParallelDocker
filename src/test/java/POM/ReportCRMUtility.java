package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class ReportCRMUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public ReportCRMUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);

	}

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public static By CRMSectionEditIcon = By.xpath("//h4[text()='CRM']/following::button[1]");
	public static By BackToUrLCitizenView = By.xpath("//input[@name='citizenPortalHomeLinkURL']");
	public static By AddReportLinkText = By.xpath("//div[text()='Add Report']");
	public static By DashboardNameField = By.xpath("//label[@title='Dashboard Name']/following::input[1]");
	public static By DashboardIDField = By.xpath("//label[@title='Dashboard ID']/following::input[1]");
	public static By AddReportButton = By.xpath("//button[text()='Add Report']");
	public static By QSReportsList = By
			.xpath("//div[@class='product-form__executive-reports']//div[@class='rt-td'][1]");
	public static By QSReportEditIcon = By.xpath("//div[@class='product-form__executive-reports']//button");
	public static By DashboardIDList = By
			.xpath("//div[@class='product-form__executive-reports']//div[@class='rt-td'][2]");
	public static By SaveButton = By.xpath("//div[@class='integration__footer']/button[text()='Save']");
	public static By SaveQSReportPopup = By.xpath("//div[@class='product-form__footer']/button[text()='Save']");
	public static By SaveEditAgencyPopup = By.xpath("//div[@class='case-header__actions']/button[text()='Save']");
	public static By ReportsTab = By.xpath("//a[text()='Reports']");
	public static By CRMToggle = By.xpath("//button[text()='CRM']");
	public static By AppReportsList = By.xpath("//div[@class='sidebar']//label");
	public static By QsReportNextListButton = By.xpath(
			"(//div[text()='Edit & Configure CRM']//following::div[@class='table__pagination-nav-btns']//button)[2]");
	public static By QsReportPreListButton = By.xpath(
			"(//div[text()='Edit & Configure CRM']//following::div[@class='table__pagination-nav-btns']//button)[1]");

	public static By SaveReportAdded = By
			.xpath("//div[text()='Edit & Configure CRM']//following::button[text()='Save']");
	public static By SaveEditAgency = By.xpath("//h1[text()='Edit Agency']//following::button[text()='Save']");
	public static By ActiveQSReport = By.xpath(
			"//*[@class='product-form__executive-reports']//div[text()='Active']//ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][1]");

	public static String RandomID;
	public static ArrayList<String> ReportsListAdmin = new ArrayList<String>();
	public static boolean StatusFound;
	public static boolean EditedIDFound;
	public static boolean CheckCRMToggle;
	public static boolean CompareReports;

	public static String AgencyNameGrid(String name) {
		String xPath = "//div[text()='" + name + "']";
		return xPath;
	}

	public void Reports_PreRequisite() throws InterruptedException {
		log.LoginAdmin();
		waitForCurserRunning(2);
		waitUntilElementIsVisible(CSPExternalUtility.AgencySearchField);
		waitUntilElementPresent(CSPExternalUtility.AgencySearchField);
		waitForElementIsInteractable(CSPExternalUtility.AgencySearchField);
		String AgencyID = Integer.toString(BrowsersInvoked.AgencyID);
		sendKeysWithWait(CSPExternalUtility.AgencySearchField, AgencyID);
		waitUntilElementIsVisible(By.xpath(AgencyNameGrid(AgencyID)));
		waitForElementIsInteractable(CSPExternalUtility.EditAgencyIcon);
		clickOn(CSPExternalUtility.EditAgencyIcon);
		waitUntilElementInvisibleLocated(CSPExternalUtility.EditAgencyIcon);
		waitUntilElementIsVisible(CRMSectionEditIcon);
		waitUntilElementPresent(CRMSectionEditIcon);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(CRMSectionEditIcon);
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		clickOn(CRMSectionEditIcon);
		waitForElementIsInteractable(BackToUrLCitizenView);
		clearElement(BackToUrLCitizenView);
		sendKeysWithWait(BackToUrLCitizenView, "https://app-stage.comcate.com/agencies/181/setup");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void Reports_VerifyAdditionOfNewReports() throws InterruptedException {
		clickOn(AddReportLinkText);
		String RandomName = RandomStrings.requiredCharacters(9);
		RandomID = RandomStrings.requiredString(15);
		sendKeysWithWait(DashboardNameField, RandomName);
		sendKeysWithWait(DashboardIDField, RandomID);
		clickOn(AddReportButton);
		if (driver.findElements(QsReportPreListButton).size() > 0) {
			Boolean listPrebtncheck = driver.findElement(QsReportPreListButton).isEnabled();
			while (listPrebtncheck) {
				clickOn(QsReportPreListButton);

				listPrebtncheck = driver.findElement(QsReportPreListButton).isEnabled();

			}

		}

		List<String> QSReportText = new ArrayList<String>();
		driver.findElements(ActiveQSReport).stream().forEach(x -> QSReportText.add(x.getText()));

		if (driver.findElements(QsReportNextListButton).size() > 0) {

			Boolean listbtncheck = driver.findElement(QsReportNextListButton).isEnabled();
			while (listbtncheck) {
				clickOn(QsReportNextListButton);
				listbtncheck = driver.findElement(QsReportNextListButton).isEnabled();

				driver.findElements(ActiveQSReport).stream().forEach(x -> QSReportText.add(x.getText()));
			}
		}

		int Count = 0;
		for (int j = 0; j < QSReportText.size(); j++) {
			String QSReporty = QSReportText.get(j);

			if (QSReporty.equals(RandomName)) {
				Count++;
			}
		}

		for (int ix = 0; ix < QSReportText.size(); ix++) {
			String QSReportz = QSReportText.get(ix);

			ReportsListAdmin.add(QSReportz);
		}

		StatusFound = (Count == 1);
		waitUntilElementPresent(SaveReportAdded);
		clickOn(SaveReportAdded);
		waitUntilElementInvisibleLocated(SaveReportAdded);
		waitForElementIsInteractable(SaveEditAgency);
		clickOn(SaveEditAgency);
		waitUntilElementInvisibleLocated(SaveEditAgency);
		waitUntilElementInvisibleLocated(SaveEditAgency);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(StatusFound);
		softAssert.assertAll();
	}

	public void Reports_VerifyEditedQSReport() throws InterruptedException {

		waitUntilElementIsVisible(CSPExternalUtility.EditAgencyIcon);
		waitUntilElementPresent(CSPExternalUtility.EditAgencyIcon);
		waitForElementIsInteractable(CSPExternalUtility.EditAgencyIcon);
		clickByJsExecuter(CSPExternalUtility.EditAgencyIcon);
		waitUntilElementIsVisible(CRMSectionEditIcon);
		waitUntilElementPresent(CRMSectionEditIcon);
		waitForElementIsInteractable(CRMSectionEditIcon);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(CRMSectionEditIcon);
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		clickByJsExecuter(CRMSectionEditIcon);
		waitUntilElementIsVisible(QSReportEditIcon);
		waitForElementIsInteractable(QSReportEditIcon);
		RandomID = RandomStrings.requiredString(15);
		String DashboardNewId = "Edited123#";
		waitUntilElementPresent(QSReportEditIcon);
		waitForElementIsInteractable(QSReportEditIcon);
		clickByJsExecuter(QSReportEditIcon);
		waitForElementIsInteractable(DashboardIDField);
		driver.findElement(DashboardIDField).clear();
		sendKeysWithWait(DashboardIDField, DashboardNewId);
		waitForElementIsInteractable(SaveButton);
		clickByJsExecuter(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitUntilElementIsVisible(DashboardIDList);
		String DashboardIDs = driver.findElement(DashboardIDList).getText();
		int Count;

		if (DashboardIDs.equalsIgnoreCase(DashboardNewId)) {
			Count = 1;
		} else {
			Count = 0;
		}

		EditedIDFound = (Count == 1);
		clickOn(SaveQSReportPopup);
		waitUntilElementInvisibleLocated(SaveQSReportPopup);
		clickOn(SaveEditAgencyPopup);
		waitUntilElementInvisibleLocated(SaveEditAgencyPopup);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(EditedIDFound);
		softAssert.assertAll();
	}

	public void Reports_VerifyCRMToggleForReports() throws InterruptedException {

		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(ReportsTab);
		waitUntilElementPresent(ReportsTab);
		waitForElementIsInteractable(ReportsTab);
		clickByJsExecuter(ReportsTab);

		int checkCRM = findElementsByXPath(CRMToggle).size();
		if (checkCRM == 0) {
			refreshPage();
			waitForCurserRunning(8);
			waitUntilElementIsVisible(CRMToggle);
			waitForElementIsInteractable(CRMToggle);
		}
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		waitForElementIsInteractable(CRMToggle);
		List<WebElement> CRMTogglePresence = driver.findElements(CRMToggle);
		CheckCRMToggle = CRMTogglePresence.size() == 1;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CheckCRMToggle);
		softAssert.assertAll();
	}

	public void Reports_VerifyAllCRMReports() throws InterruptedException {
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CRMToggle);
		waitUntilElementPresent(CRMToggle);
		// WebDriverWaits.ClickByJsExecuter(CRMToggle);
		driver.findElement(CRMToggle).click();
		waitForCurserRunning(5);
		forcedWaitTime(2);
		waitUntilElementIsVisible(AppReportsList);
		waitUntilElementPresent(AppReportsList);
		ArrayList<String> ReportsListApp = new ArrayList<String>();
		List<WebElement> ReportsList = driver.findElements(AppReportsList);
		for (int i = 0; i < ReportsList.size(); i++) {
			WebElement AppReports = ReportsList.get(i);
			String ReportsText = AppReports.getText();
			ReportsListApp.add(ReportsText);
		}
		CompareReports = (ReportsListApp.equals(ReportsListAdmin));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareReports);	
		softAssert.assertAll();
	}

}
