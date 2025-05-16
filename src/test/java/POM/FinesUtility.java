package POM;

import static org.testng.Assert.assertEquals;

import java.util.List;

import CommonMethods.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class FinesUtility extends Helper {

	public WebDriver driver;
	CECommonMethods ceCommonMethod;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;

	public FinesUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethod = new CECommonMethods(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
	}

	public static By finesBtn = By.xpath("//button[text()='Fines']");
	public static By finesGrid = By.xpath("(//div[@role='gridcell'])[1]");
	public static By waterFViolation = By.xpath("//*[@class='list-label' ]/b[contains(text(),'WaterF')]");
	public static By searchViolationBox = By
			.xpath("(//*[@placeholder='Start typing name of violation or article number'])[2]");
	public static By violationSpecificOptionOnCreateFinePage = By.xpath("//button[text()='Violation Specific']");
	public static By associatedViolationDropdown = By.xpath("//span[text()='Select Violation']");
	public static By transactionNameOnFinancePageColumn = By.xpath("//div[@role='row']/*[@role='gridcell'][1]");
	public static By transactionNumbersOnFinancePageColumn = By
			.xpath("//div[@role='row']/*[@role='gridcell'][1]//following-sibling::*[1]");
	public static By addFineBtnPaymentAndDetailsPage = By
			.xpath("//*[@class='add-transaction']//button[text()='Add Fine']");
	public static By select1Violation = By.xpath("//*[@class='checkbox-holder']/input");
	public static By selectFineDropdownOnFineAndPaymentsPage = By.xpath("//*[@class='Select-arrow-zone']");
	public static By associatedFineNameWithNotice = By
			.xpath("//*[@class='tile propose-fine-tile']//*[text()='Flat Fine With Notice']");
	public static By associatedFineNameWithViolation = By.xpath(
			"//*[@class='tile propose-fine-tile']//*[text()='Violation Specific Fine Linked To Violations Only']");
	public static By associatedFine = By.xpath("//span[@class='selected-notice'][text()='Violation Specific Fine Linked To Notice Only']");
	public static By associatedFine2 = By.xpath("//button[text()='Notice For Violation Fine Linked To Violations']");
	public static By vSFineLinkedToViolations = By
			.xpath("//*[@class='tile propose-fine-tile']//*[text()='Violation Specific Fine Linked To Notice Only']");
	public static By selectFineDropdownOptions = By.xpath("//*[@class='Select-menu-outer']//div[@role='option']");
	public static By associatedFineWithFADocumentNotice = By.xpath("//*[text()='Flat Fine With FA Document']");
	public static By associatedFineWithFADocumentNoticeViolation = By.xpath("//*[text()='VS fine linked to FA doc']");

	public static By fineAmountOnPI = By.xpath("//*[@name='amount']");
	public static By doNotIssueTheFineCheckbox = By
			.xpath("//*[@class='checkbox-holder checkbox-holder--radio col-md-12']//*[@type='checkbox']");

	public static By finesAndPaymentsDetailsPageHeader = By.xpath("//*[contains(text(),'Fines & Payments Details')]");

	public static By fineNameOnFinesAndPaymentsDetailsPage = By
			.xpath("//*[@class='rt-tr-group']//*[@role='gridcell'][2]/span");

	public static By closeBtnOnFinesAndPaymentsPage = By.xpath("//button[@aria-label='Close']");
	public static By violationSpecficToggelBtn = By.xpath("//button[text()='Violation Specific']");
	public static By CrtFineLabelName = By.xpath("//input[@name='label']");
	public static By CrtDefaultAmnt = By.xpath("//input[@name='defaultAmount']");
	public static By validationMsgAssociatedNoticeFADoc = By.xpath("//*[@class='field__error']");
	public static By fieldErrors = By.xpath("//span[@class='field__error']");
	public static String checkFAdocument = "//label[contains(text(),'%s')]//parent::span//input[@name='associatedNoticeIds'][@type='checkbox'][not (@disabled)]";
	public static By selectViolations = By.xpath("//span[text()='Select Violation']");
	// public static String violationSpecification = "//input[@name='%s']";
	public static By fineGridNextbtn = By.xpath("(//div[@class='table__pagination-nav-btns']//button)[2]");
	public static By fineGridCellCount = By.xpath(
			"//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@role='gridcell'][@class='rt-td']");
	public static String fineGridCell = "(//div[@role='gridcell'][@class='rt-td'])[%s]";
	public static String checkViolationSpecific = "//label[contains(text(),'%s')]//parent::span//input[@name='associatedViolationIds'][@type='checkbox'][not (@disabled)]";
	public static By checkviolation = By
			.xpath("(//input[@name='associatedViolationIds'][@type='checkbox'][not (@disabled)])[1]");
	public static By FlateFineToggel = By.xpath("//button[text()='Flat Fine']");
	public static By createFine = By.xpath("//button[text()='Create Fine']");
	public static By dropdownarrow = By.xpath("//*[@class='abatement-activities__documents']//*[@class='dropdown__arrow']");
	public static By dropdownOpt = By.xpath(
			"//*[@class='abatement-activities__documents']//ul[@class='dropdown__options--single']/li/span");
	public static By paginationNavigationBtn = By.xpath("//div[@class='table__pagination-nav-btns']/button[2]");

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void navigateToCreateFinePageFromDashboard() throws InterruptedException {
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToFines();
		waitUntilElementIsVisible(AppPreRequisiteUtility.CreateFineBtn);
		scrollIntoView(AppPreRequisiteUtility.CreateFineBtn);
		clickByJsExecuter(AppPreRequisiteUtility.CreateFineBtn);

	}

	public void goToCreateFinePage() throws InterruptedException {
		forcedWaitTime(5);
		scrolltoPageTop();
		scrollIntoView(AppPreRequisiteUtility.CreateFineBtn);
		try {
			// clickByJsExecuter(AppPreRequisiteUtility.CreateFineBtn);
			clickOn(AppPreRequisiteUtility.CreateFineBtn);
		} catch (Exception e) {
			scrolltoPageTop();
			clickByJsExecuter(createFine);
		}
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFinePopUpbtn);
		Assert.assertTrue(elementIsDisplayed(AppPreRequisiteUtility.CreateFinePopUpbtn));

	}

	public void setValueInLabelField() {
		String randomLabelName = RandomStrings.requiredString(5) + "FlatFine";
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, randomLabelName);
	}

	public void setValueInLabelField(String FineName) {
		String randomLabelName = RandomStrings.requiredString(5) + FineName;
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, randomLabelName);
	}
	public void setValueInLabelFieldWithoutRandom(String FineName) {
		String randomLabelName = FineName;
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, randomLabelName);
	}

	public String setandReturnValueInLabelField(String FineName) {
		String randomLabelName = RandomStrings.requiredString(5) + FineName;
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, randomLabelName);
		return randomLabelName;
	}

	public String setCustomefineName(String FineName) {
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, FineName);
		return FineName;
	}

	public void verifyValidationMessageDisplayedForAmountField() {
		String expected = PropertiesUtils.getPropertyValue("NumberCantBeLessThan0");
		waitForPresenceandVisiblity(By.xpath(selectorFormate(AppPreRequisiteUtility.CrtFineFieldValidMsg, "1")));
		String actual = getTextByJSExecutor(
				By.xpath(selectorFormate(AppPreRequisiteUtility.CrtFineFieldValidMsg, PropertiesUtils.getPropertyValue("amount1"))));
		Assert.assertEquals(actual, expected);
	}

	public void setValueInDefaultAmountField() {
		sendKeysWithWait(AppPreRequisiteUtility.CrtDefaultAmnt, PropertiesUtils.getPropertyValue("amount200"));
	}

	public void setValueInDefaultAmountField(String amount) {
		sendKeysWithWait(AppPreRequisiteUtility.CrtDefaultAmnt, amount);
	}

	public String returnDefaultAmount() {
		String amount = getSpecificAttribute(CrtDefaultAmnt, "value");
		return amount;
	}

	public void selectDoNotAssociateNoticeCheckboxForCreateFine() {
		waitForElementIsInteractable(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
		clickByJsExecuter(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
	}

	public void clickCreateFineButtonOnCreateFinePage() {
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFinePopUpbtn);
		clickByJsExecuter(AppPreRequisiteUtility.CreateFinePopUpbtn);
	}

	public void verifyValidationMessageDisplayedForLabelField() {
		String actual = getTextByJSExecutor(AppPreRequisiteUtility.LabelValidation);
		String expected = PropertiesUtils.getPropertyValue("labelreq");
		Assert.assertEquals(actual, expected);
	}

	public void exitFromCreateFinePage() {
		waitForElementIsInteractable(AppPreRequisiteUtility.CancelCreateFine);
		clickByJsExecuter(AppPreRequisiteUtility.CancelCreateFine);
	}

	public String getValidationText() {
		String text = getTextElement(fieldErrors);
		return text;
	}

	public void createCaseAndPerformInspection() throws InterruptedException {
		ceCommonMethod.createCaseAndPerformInspectionWithoutAttachment();
		scrollIntoView(PerformInspectionUtility.ContinueBtn);
		waitForElementIsInteractable(PerformInspectionUtility.ContinueBtn);
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
		forcedWaitTime(3);

	}

	public void selectNoticeOnPerformInspection(String noticeName) throws InterruptedException {
		int size = driver.findElements(By.xpath("//button[text()='" + noticeName + "']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//button[text()='" + noticeName + "']"));
		}

		else {
			forcedWaitTime(5);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			forcedWaitTime(5);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[text()='" + noticeName + "']")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[text()='" + noticeName + "']")));
		}

	}
	public void selectNoticeOnPerformInspectionPopup(String noticeName) throws InterruptedException {
		int size = driver.findElements(By.xpath("//button[text()='" + noticeName + "']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//div[text()='" + noticeName + "']"));
		}

		else {
			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(6000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("(//*[text()='" + noticeName + "'])")));
			movetoElementAndClick(driver.findElement(By.xpath("(//*[text()='" + noticeName + "'])")));
		}

	}

	public void selectNoticeOnPerformInspectionPopup2(String noticeName) throws InterruptedException {
		int size = driver.findElements(By.xpath("//button[text()='" + noticeName + "']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//div[text()='" + noticeName + "']"));
		}

		else {
			forcedWaitTime(5);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			forcedWaitTime(6);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//div[text()='" + noticeName + "']")));
			movetoElementAndClick(driver.findElement(By.xpath("//div[text()='" + noticeName + "']")));
		}

	}

	public void selectNoticeOnGenerateNoticeOutOfInspection(String NoticeName) throws InterruptedException {
		forcedWaitTime(4);
		int size = driver.findElements(By.xpath(stringFormat(PerformInspectionUtility.notices, NoticeName))).size();
		Reporter.log("size " + size);
		if (size > 0) {
			clickByJsExecuter(By.xpath(stringFormat(PerformInspectionUtility.notices, NoticeName)));
			Reporter.log(stringFormat(PerformInspectionUtility.notices, NoticeName));
			int b = driver.findElements(By.xpath(stringFormat(PerformInspectionUtility.notices, NoticeName))).size();
			Reporter.log("size " + b);
		}

		else {

			Thread.sleep(3000);

			waitForElementIsInteractable(PerformInspectionUtility.selectNoticeDownArrow);
			// clickByJsExecuter(PerformInspectionUtility.selectNoticeDownArrow);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			forcedWaitTime(3);
//			scrollIntoViewWebElement(driver
//					.findElement(By.xpath(stringFormat(PerformInspectionUtility.noticesFromDropdown, NoticeName))));
			forcedWaitTime(1);
			System.out.println("Notice name to be selected is " + NoticeName);
			// clickByJsExecuter(By.xpath(stringFormat(PerformInspectionUtility.noticesFromDropdown,
			// NoticeName)));
			movetoElementAndClick(By.xpath(stringFormat(PerformInspectionUtility.noticesFromDropdown, NoticeName)));
		}
		forcedWaitTime(3);
	}

	public void verifyFlatFineIsDisplayed() {
		String expectedName = PropertiesUtils.getPropertyValue("FlatFineWithNotice");
		String actualFlatFineName = getTextByJSExecutor(associatedFineNameWithNotice);
		Assert.assertEquals(actualFlatFineName, expectedName);

	}

	public void verifyFineAmountIsDisplayed() {
		waitUntilElementIsVisible(fineAmountOnPI);
		waitForElementIsInteractable(fineAmountOnPI);
		String value = (getSpecificAttribute(fineAmountOnPI, "value"));
		System.out.println(value);
		String actualFine = value.split("\\.")[0];
		int actualFineAmount = Integer.parseInt(actualFine);
		int expectedAmount = 100;

		Assert.assertEquals(actualFineAmount, expectedAmount);

	}

	public void verifyUserIsAbleToEditFlatFine() throws InterruptedException {
		int updatedFineAmount = 20000;
		// 200 but written as 20000 as per the field as it includes decimal values also.
		String updateAmountFine = Integer.toString(updatedFineAmount);
		waitForElementIsInteractable(fineAmountOnPI);
		clearByJSE(fineAmountOnPI);
		forcedWaitTime(3);
		waitForElementIsInteractable(fineAmountOnPI);
		movetoElementAndClick(fineAmountOnPI);
		sendKeysWithWait(fineAmountOnPI, updateAmountFine);

		String UpdatedactualFine = getSpecificAttribute(fineAmountOnPI, "value").split("\\.")[0];
		int updatedFineAmountActual = Integer.parseInt(UpdatedactualFine);
		Assert.assertEquals(updatedFineAmountActual, 200);

	}

	public void verifyDoNotIssueFineCheckboxDisplayed() {
		waitForElementIsInteractable(doNotIssueTheFineCheckbox);
		clickByJsExecuter(doNotIssueTheFineCheckbox);
		Boolean value = findElementsSize(doNotIssueTheFineCheckbox)>0;
		System.out.println(value);
		Assert.assertTrue(value);
		clickByJsExecuter(doNotIssueTheFineCheckbox);

	}

	public void completePIFromVerificationInspectionInProgressPageAndGoToCDP() throws InterruptedException {
		scrollIntoView(PerformInspectionUtility.ContinueBtnSec2);
		waitForElementIsInteractable(PerformInspectionUtility.ContinueBtnSec2);
		clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		forcedWaitTime(3);
		movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		waitForCurserRunning(3);
		Boolean generateNoticeBtn= elementIsDisplayed(PerformInspectionUtility.GenerateNoticeBtn);
		if(generateNoticeBtn)
		{
			clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);		
		}
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(NoticesUtility.issueNoticeAdCompleteInspectionBtn);
		clickByJsExecuter(NoticesUtility.issueNoticeAdCompleteInspectionBtn);
		waitForElementIsInteractable(PerformInspectionUtility.YesBtnConfirmationPopup);
		clickByJsExecuter(PerformInspectionUtility.YesBtnConfirmationPopup);
		waitForCurserRunning(3);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.outstandingBalanceValue));
	}

	public void verifyFineAmountIsAddedUnderOutstandingBalance() {
		waitForPresenceandVisiblity(CDP_Utility.outstandingBalanceValue);
		String outstandingBalanceValue = getTextByJSExecutor(CDP_Utility.outstandingBalanceValue);
		int outstandingBalanceActual = Integer.parseInt(outstandingBalanceValue.split("\\.")[0].replace("$", ""));
		System.out.println(outstandingBalanceActual);
		Assert.assertEquals(outstandingBalanceActual, 200);

	}

	public void verifyFineNameDisplayedOnFineAndPaymentPage(String fineNameP) throws InterruptedException {
		Boolean flag = false;
		waitForElementIsInteractable(CDP_Utility.viewDetailsOutstandingBalance);
		clickByJsExecuter(CDP_Utility.viewDetailsOutstandingBalance);
		waitForCurserRunning(5);
		waitForElementIsInteractable(finesAndPaymentsDetailsPageHeader);
		Assert.assertTrue(elementIsDisplayed(finesAndPaymentsDetailsPageHeader));

		List<WebElement> finesNames = driver.findElements(fineNameOnFinesAndPaymentsDetailsPage);
		int size = finesNames.size();
		for (int i = 0; i < size; i++) {
			String fineName = finesNames.get(i).getText();
			if (fineName.contains(fineNameP)) {
				flag = true;
				System.out.println("Found fine with name " + fineName);
				break;
			}

		}
		Assert.assertTrue(flag);

	}

	public void navigatToCDPFromFinesAndPaymentsPage() throws InterruptedException {
		waitForElementIsInteractable(closeBtnOnFinesAndPaymentsPage);
		clickByJsExecuter(closeBtnOnFinesAndPaymentsPage);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.outstandingBalanceValue);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.outstandingBalanceValue));
	}

	public void performGenerateNoticeOnCDP() throws InterruptedException {
		scrollIntoView(CDP_Utility.generateNoticeBtn);
		waitForElementIsInteractable(CDP_Utility.generateNoticeBtn);
		clickByJsExecuter(CDP_Utility.generateNoticeBtn);
		scrollIntoView(CDP_Utility.continueBtn1GenerateNoticeInProgressPage);
		waitForElementIsInteractable(CDP_Utility.continueBtn1GenerateNoticeInProgressPage);
		clickByJsExecuter(CDP_Utility.continueBtn1GenerateNoticeInProgressPage);
		waitForCurserRunning(5);

	}

	public void completeGenerateNoticeFlowFromGenerateNoticeInProgressPage() throws InterruptedException {
		waitForElementIsInteractable(CDP_Utility.continueBtn2GenerateNoticeInProgressPage);
		clickByJsExecuter(CDP_Utility.continueBtn2GenerateNoticeInProgressPage);
		waitForElementIsInteractable(CDP_Utility.continueBtn3GenerateNoticeInProgressPage);
		clickByJsExecuter(CDP_Utility.continueBtn3GenerateNoticeInProgressPage);
		scrollIntoView(CDP_Utility.generateNoticeBtnOOI);
		waitForElementIsInteractable(CDP_Utility.generateNoticeBtnOOI);
		clickByJsExecuter(CDP_Utility.generateNoticeBtnOOI);
		waitForCurserRunning(5);
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(NoticesUtility.generateNoticeBtnOnGenerateNoticePopUp);
		clickByJsExecuter(NoticesUtility.generateNoticeBtnOnGenerateNoticePopUp);
		waitForCurserRunning(3);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.outstandingBalanceValue));
	}

	public void applyNoticeGeneatedThroughGenerateNotice() throws InterruptedException {
		scrollIntoView(CDP_Utility.applyNoticeBtnCDP);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.applyNoticeBtnCDP));
		waitForElementIsInteractable(CDP_Utility.applyNoticeBtnCDP);
		clickByJsExecuter(CDP_Utility.applyNoticeBtnCDP);
		waitForElementIsInteractable(CDP_Utility.continueAfterApplyNotice);
		clickByJsExecuter(CDP_Utility.continueAfterApplyNotice);
		forcedWaitTime(3);
		waitForElementIsInteractable(NoticesUtility.yesOnPopUp);
		Assert.assertTrue(elementIsDisplayed(NoticesUtility.yesOnPopUp));
		clickByJsExecuter(NoticesUtility.yesOnPopUp);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.outstandingBalanceValue);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.outstandingBalanceValue));
	}

	public void verifyOutstandingBalanceIsUpdated() {
		String outstandingBalanceValue = getTextByJSExecutor(CDP_Utility.outstandingBalanceValue);
		int outstandingBalanceActual = Integer.parseInt(outstandingBalanceValue.split("\\.")[0].replace("$", ""));
		System.out.println(outstandingBalanceActual);
		Assert.assertEquals(outstandingBalanceActual, 400);
	}

	public void performForcedAbatementFromCDP() throws InterruptedException {
		waitForElementIsInteractable(CDP_Utility.moreBtnCDP);
		clickByJsExecuter(CDP_Utility.moreBtnCDP);
		movetoElementAndClick(ForcedAbatementUtility.InitiateFABtn);
		sendKeysWithWait(ForcedAbatementUtility.NoteField, PropertiesUtils.getPropertyValue("FA"));
		waitForElementIsInteractable(ForcedAbatementUtility.IFAPopupBtn);
		clickByJsExecuter(ForcedAbatementUtility.IFAPopupBtn);
		waitForCurserRunning(5);
		scrollIntoView(ForcedAbatementUtility.AddActivityBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.AddActivityBtn);
		clickByJsExecuter(ForcedAbatementUtility.AddActivityBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.LabelForText1);
		sendKeysWithWait(ForcedAbatementUtility.LabelForText1, PropertiesUtils.getPropertyValue("labelText"));
		sendKeysWithWait(ForcedAbatementUtility.LabelForNumber2, PropertiesUtils.getPropertyValue("12345"));
		waitForElementIsInteractable(ForcedAbatementUtility.LabelForSelect3);
		clickOn(ForcedAbatementUtility.LabelForSelect3);
		waitForElementIsInteractable(ForcedAbatementUtility.FirstOption);
		clickOn(ForcedAbatementUtility.FirstOption);
		waitForElementIsInteractable(ForcedAbatementUtility.labelForCaseID);
		sendKeysWithWait(ForcedAbatementUtility.labelForCaseID, PropertiesUtils.getPropertyValue("labelText"));
		scrollIntoView(ForcedAbatementUtility.ContinueToGenDoc);
		waitForElementIsInteractable(ForcedAbatementUtility.ContinueToGenDoc);
		clickOn(ForcedAbatementUtility.ContinueToGenDoc);
		waitForCurserRunning(4);
		forcedWaitTime(3);

		waitForElementIsInteractable(ForcedAbatementUtility.selectFAADocArrow);

	}

	public void selectFAADocumentOnAbatementDetailsSection(String noticeName) throws InterruptedException {
		int size = driver.findElements(By.xpath("//*[text()='" + noticeName + "']")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[text()='" + noticeName + "']"));
		}

		else {
			Thread.sleep(5000);
			Boolean flag2 = false;
			movetoElementAndClick(driver.findElement(dropdownarrow));

			forcedWaitTime(5);

			List<WebElement> listOfFADocs = driver.findElements(dropdownOpt);
			int sizeOfList = listOfFADocs.size();
			for (int i = 0; i < sizeOfList; i++) {
				if (listOfFADocs.get(i).getText().equalsIgnoreCase(noticeName)) {
					flag2 = true;
					scrollIntoViewWebElement(listOfFADocs.get(i));
					movetoElementAndClick(listOfFADocs.get(i));
					break;
				}

			}

		}

	}

	public void verifyFlatFineWithFADocIsDisplayed() {
		String expectedName = PropertiesUtils.getPropertyValue("FlatFinewithFA");
		String actualFlatFineName = getTextByJSExecutor(associatedFineWithFADocumentNotice);
		Assert.assertEquals(actualFlatFineName, expectedName);
	}

	public void verifyViolationSpecificFineWithFAIsDisplayed() {
		String expectedName = PropertiesUtils.getPropertyValue("VSFineLinkedToFADoc");
		String actualFlatFineName = getTextByJSExecutor(associatedFineWithFADocumentNoticeViolation);
		Assert.assertEquals(actualFlatFineName, expectedName);
	}

	public String verifyViolationSpecificFineTextDisplayed() {
		waitUntilElementIsVisible(associatedFineWithFADocumentNoticeViolation);
		waitForElementIsInteractable(associatedFineWithFADocumentNoticeViolation);
		String actualFlatFineName = getTextByJSExecutor(associatedFineWithFADocumentNoticeViolation);
		return actualFlatFineName;

	}

	public void verifyFineAmountIsUpdatedUnderOutstandingBalance() {
		String outstandingBalanceValue = getTextByJSExecutor(CDP_Utility.outstandingBalanceValue);
		int outstandingBalanceActual = Integer.parseInt(outstandingBalanceValue.split("\\.")[0].replace("$", ""));
		System.out.println(outstandingBalanceActual);
		Assert.assertEquals(outstandingBalanceActual, 500);
	}

	public void completeFAAndNavigateToCDP() throws InterruptedException {
		waitForElementIsInteractable(ForcedAbatementUtility.GenFAADoc);
		clickByJsExecuter(ForcedAbatementUtility.GenFAADoc);
		waitForCurserRunning(5);
		scrollIntoView(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(ForcedAbatementUtility.GenerateDocAddFABtn);
		clickByJsExecuter(ForcedAbatementUtility.GenerateDocAddFABtn);
		waitForCurserRunning(3);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.outstandingBalanceValue));

	}

	public void verifyFLatFineWithoutNoticeIsDisplayedOnFineAndPaymentsPage() throws InterruptedException {
		scrollIntoView(CDP_Utility.outstandingBalanceValue);
		waitForElementIsInteractable(CDP_Utility.viewDetailsOutstandingBalance);
		clickByJsExecuter(CDP_Utility.viewDetailsOutstandingBalance);
		waitForElementIsInteractable(finesAndPaymentsDetailsPageHeader);
		Assert.assertTrue(elementIsDisplayed(finesAndPaymentsDetailsPageHeader));
		forcedWaitTime(5);
		waitForElementIsInteractable(selectFineDropdownOnFineAndPaymentsPage);

		forcedWaitTime(5);
		waitForElementIsInteractable(selectFineDropdownOnFineAndPaymentsPage);
		clickOn(selectFineDropdownOnFineAndPaymentsPage);
		Boolean flag = false;
		List<WebElement> fineNames = driver.findElements(selectFineDropdownOptions);
		int size = fineNames.size();
		for (int i = 0; i < size; i++) {
			if (fineNames.get(i).getText().contains(PropertiesUtils.getPropertyValue("FlatFIneWithNoNoticeOrFA"))) {
				fineNames.get(i).click();
				flag = true;
				break;

			}

		}
		Assert.assertTrue(flag);
		waitForElementIsInteractable(addFineBtnPaymentAndDetailsPage);
		clickByJsExecuter(addFineBtnPaymentAndDetailsPage);
		waitForCurserRunning(5);

	}

	public void verifyFLatFineWithoutNoticeIsAppliedOnFineAndPaymentsPage(String fineNameP) {
		Boolean flag = false;
		List<WebElement> finesNames = driver.findElements(fineNameOnFinesAndPaymentsDetailsPage);
		int size = finesNames.size();
		for (int i = 0; i < size; i++) {
			String fineName = finesNames.get(i).getText();
			if (fineName.contains(fineNameP)) {
				flag = true;
				System.out.println("Found fine with name " + fineName);
				break;
			}

		}
		Assert.assertTrue(flag);

	}

	public void verifyOutstandingIsUpdated() {
		String outstandingBalanceValue = getTextByJSExecutor(CDP_Utility.outstandingBalanceValue);
		int outstandingBalanceActual = Integer.parseInt(outstandingBalanceValue.split("\\.")[0].replace("$", ""));
		System.out.println(outstandingBalanceActual);
		Assert.assertEquals(outstandingBalanceActual, 600);
	}

	public void navigateToFinancePageFromCDPPage() throws InterruptedException {
		waitForElementIsInteractable(CDP_Utility.crossIconCDP);
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		waitForCurserRunning(10);

		waitForPresenceandVisiblity(AppPreRequisiteUtility.AppMenuIcon);
		waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
		scrollIntoView(AppPreRequisiteUtility.AppMenuIcon);
		waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
		clickByJsExecuter(AppPreRequisiteUtility.AppMenuIcon);

		waitForPresenceandVisiblity(AppPreRequisiteUtility.financeMenu);
		waitForElementIsInteractable(AppPreRequisiteUtility.financeMenu);
		scrollIntoView(AppPreRequisiteUtility.financeMenu);
		waitForElementIsInteractable(AppPreRequisiteUtility.financeMenu);
		movetoElementAndClick(AppPreRequisiteUtility.financeMenu);
		if(elementIsDisplayed(AppPreRequisiteUtility.financeMenu))
		{
			forcedWaitTime(2);
			clickByJsExecuter(AppPreRequisiteUtility.financeMenu);
		}

	}

	public void verifyFineDisplayedOnFinancePage(String text) {
		List<WebElement> transactionNames = driver.findElements(transactionNameOnFinancePageColumn);
		List<WebElement> transactionNos = driver.findElements(transactionNumbersOnFinancePageColumn);
		int size = transactionNames.size();

		System.out.println("transactionNos: " + transactionNos);
		System.out.println("transNames: " + transactionNames);
		Boolean flag = false;
		for (int i = 0; i < size; i++) {

			if (transactionNames.get(i).getText().contains(text)) {
				System.out.println("Fine name displayed on finance page  " + transactionNames.get(i).getText());
				System.out.println(transactionNos.get(i).getText());
				flag = true;
				break;

			}

		}
		Assert.assertTrue(flag);
	}

	String fineNameWithoutNotice;
	public static By pagesOnFinesPage = By.xpath("//*[@class='table__pagination-of-text']");

	public void createFlatFineWithoutNoticeAndFADoc() throws InterruptedException {

		fineNameWithoutNotice = PropertiesUtils.getPropertyValue("fineW/ONotice") + RandomStrings.requiredCharacters(5);
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, fineNameWithoutNotice);
		sendKeysWithWait(AppPreRequisiteUtility.CrtDefaultAmnt, PropertiesUtils.getPropertyValue("amount100"));
		waitForElementIsInteractable(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
		clickByJsExecuter(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFinePopUpbtn);
		clickByJsExecuter(AppPreRequisiteUtility.CreateFinePopUpbtn);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateFineBtn);
		Assert.assertTrue(elementIsDisplayed(AppPreRequisiteUtility.CreateFineBtn));
		Boolean flag = false;
		int size1 = findElementsByXPath(pagesOnFinesPage).size();
		if (size1 > 0) {
			scrollIntoView(pagesOnFinesPage);
			String pages = getTextByJSExecutor(pagesOnFinesPage).split("\\ ")[1];
			int noOfPages = Integer.parseInt(pages);
			System.out.println("No of pages on fines page " + noOfPages);

			for (int i = 1; i <= noOfPages; i++) {
				List<WebElement> fineName = driver.findElements(By.xpath("//*[@class='rt-td'][1]/div"));
				int size = fineName.size();
				System.out.println("no of fines on page " + size);
				for (int j = 0; j < size; j++) {
					System.out.println(fineName.get(j).getText());
					if (fineName.get(j).getText().contains(fineNameWithoutNotice)) {
						System.out.println(fineName.get(j).getText());
						flag = true;
						break;

					}

				}
				if (flag == true)
					break;
				clickByJsExecuter(paginationNavigationBtn);
				waitForCurserRunning(5);
				waitForElementIsInteractable(AppPreRequisiteUtility.CreateFineBtn);

			}
			Assert.assertTrue(flag);
		}

		else {
			// Boolean flag=false;
			List<WebElement> fineName = driver.findElements(By.xpath("//*[@class='rt-td'][1]/div"));
			int size = fineName.size();
			System.out.println("no of fines on page " + size);
			for (int j = 0; j < size; j++) {
				System.out.println(fineName.get(j).getText());
				if (fineName.get(j).getText().contains(fineNameWithoutNotice)) {
					System.out.println(fineName.get(j).getText());
					flag = true;
					break;

				}

			}
			if (flag == true)

				Assert.assertTrue(flag);
		}

	}

	public static By editFineHeader = By.xpath("//*[@class='modal-content']/div");
	public static By saveFineBtn = By.xpath("//button[text()='Save']");
	String editedFineNameWithoutNotice;

	public void editFineWithoutNotice() throws InterruptedException {

		clickByJsExecuter(
				By.xpath("//*[@class='rt-td'][1]/div[text()='" + fineNameWithoutNotice + "']/../../div[5]/button"));
		waitForCurserRunning(5);
		waitForElementIsInteractable(editFineHeader);
		SoftAssert s1 = new SoftAssert();
		s1.assertTrue(elementIsDisplayed(editFineHeader));
		clearByJSE(AppPreRequisiteUtility.LabelField);
		editedFineNameWithoutNotice = "Updated" + fineNameWithoutNotice;
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, editedFineNameWithoutNotice);
		waitForElementIsInteractable(saveFineBtn);
		scrollIntoView(saveFineBtn);
		// movetoElementAndClick(By.xpath("//button[text()='Save']"));
		clickByJsExecuter(saveFineBtn);
		waitForCurserRunning(5);

		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFineBtn);

	}

	public static By fineAlredyExistsValidationMessage = By.xpath("//*[@class='notification-message']");

	public void verifyValidationMessageForDuplicateFine() throws InterruptedException {

		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFineBtn);
		scrollIntoView(AppPreRequisiteUtility.CreateFineBtn);
		scrolltoPageTop();
		Thread.sleep(5000);
		try {
			movetoElementAndClick(AppPreRequisiteUtility.CreateFineBtn);
		} catch (Exception e) {
			clickByJsExecuter(AppPreRequisiteUtility.CreateFineBtn);
		}

		waitForCurserRunning(5);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.LabelField);
		sendKeysWithWait(AppPreRequisiteUtility.LabelField, editedFineNameWithoutNotice);
		forcedWaitTime(2);
		waitForElementIsInteractable(AppPreRequisiteUtility.CrtDefaultAmnt);
		sendKeysWithWait(AppPreRequisiteUtility.CrtDefaultAmnt, PropertiesUtils.getPropertyValue("amount100"));
		waitForElementIsInteractable(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
		clickByJsExecuter(AppPreRequisiteUtility.DoNotAttachedNoticeChk);
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFinePopUpbtn);
		scrollIntoView(AppPreRequisiteUtility.CreateFinePopUpbtn);
		clickByJsExecuter(AppPreRequisiteUtility.CreateFinePopUpbtn);
		// waitForCurserRunning(3);

		waitForElementIsInteractable(fineAlredyExistsValidationMessage);
		String actualMessage = getTextByJSExecutor(fineAlredyExistsValidationMessage);
		String expectedMessage = PropertiesUtils.getPropertyValue("fineExists");

		Assert.assertEquals(actualMessage, expectedMessage);
		forcedWaitTime(5);
		waitForElementIsInteractable(AppPreRequisiteUtility.CancelButton);
		clickByJsExecuter(AppPreRequisiteUtility.CancelButton);

		waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateFineBtn);
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateFineBtn);

	}

	public void createCaseAndPerformInspectionWithWaterFFViolation() throws InterruptedException {
		ceCommonMethod.createCaseAndPerformInspectionWithoutAttachment();
		clickByJsExecuter(PerformInspectionUtility.InvalidVioToggle);
		sendKeysWithWait(searchViolationBox, PropertiesUtils.getPropertyValue("WaterFFViolation"));
		forcedWaitTime(2);
		waitForElementIsInteractable(waterFViolation);
		clickByJsExecuter(waterFViolation);
		clickByJsExecuter(PerformInspectionUtility.validToggleBtn2);

		scrollIntoView(PerformInspectionUtility.ContinueBtn);
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);

	}

	public void selectViolationSpecifcToggelButton() {
		waitForElementIsInteractable(violationSpecficToggelBtn);
		clickByJsExecuter(violationSpecficToggelBtn);

	}

	public void EnterFineNameAndFineAmount() {
		String labelName = RandomStrings.requiredString(3) + "Fine";
		sendKeysWithWait(CrtFineLabelName, labelName);
		String DefaultFineAmount = RandomStrings.requiredDigits(4);
		sendKeysWithWait(CrtDefaultAmnt, DefaultFineAmount);
	}

	public void SelectNoticeAndFAdocument(String NoticeFADoc) {
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CrtFineSelectNoitce);
		clickByJsExecuter(AppPreRequisiteUtility.CrtFineSelectNoitce);
		waitForPresenceandVisiblity(By.xpath(selectorFormate(checkFAdocument, NoticeFADoc)));
		clickByJsExecuter(By.xpath(selectorFormate(checkFAdocument, NoticeFADoc)));
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CrtFineApplyNotices);
		clickByJsExecuter(AppPreRequisiteUtility.CrtFineApplyNotices);

	}

	public void SelectViolationSpecification(String Violation) {
		waitForPresenceandVisiblity(selectViolations);
		clickByJsExecuter(selectViolations);
		waitForPresenceandVisiblity(By.xpath(selectorFormate(checkViolationSpecific, Violation)));
		clickByJsExecuter(By.xpath(selectorFormate(checkViolationSpecific, Violation)));
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CrtFineApplyNotices);
		clickByJsExecuter(AppPreRequisiteUtility.CrtFineApplyNotices);

	}

	public void SelectViolationSpecification() {
		waitForPresenceandVisiblity(selectViolations);
		clickByJsExecuter(selectViolations);
		waitForPresenceandVisiblity(checkviolation);
		clickByJsExecuter(checkviolation);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CrtFineApplyNotices);
		clickByJsExecuter(AppPreRequisiteUtility.CrtFineApplyNotices);

	}

	public String getCreatedFineText() throws InterruptedException {
		int countNextbnt = findElementsSize(fineGridNextbtn);

		if (countNextbnt > 0) {
			Boolean nextbtn = findElement(fineGridNextbtn).isEnabled();
			while (nextbtn) {
				clickByJsExecuter(fineGridNextbtn);
				forcedWaitTime(2);
				nextbtn = findElement(fineGridNextbtn).isEnabled();

			}
		}

		int cellCount = findElementsSize(fineGridCellCount);
		scrollIntoView(By.xpath(selectorFormate(fineGridCell, Integer.toString(cellCount - 4))));
		forcedWaitTime(1);
		String text = getTextElement(By.xpath(selectorFormate(fineGridCell, Integer.toString(cellCount - 4))));
		return text;

	}

	public String getAssociatedNoticeWithFine() {

		int cellCount = findElementsSize(fineGridCellCount);
		String notice = getTextElement(By.xpath(selectorFormate(fineGridCell, Integer.toString(cellCount - 3))));
		return notice;
	}

	public void verifyVSFineLinkedToViolationIsDisplayed() {
		String expectedName = PropertiesUtils.getPropertyValue("ViolationSpecificFineLinkedToNotice");
		waitForPresenceandVisiblity(associatedFine);
		waitForElementIsInteractable(associatedFine);
		String actualFlatFineName = getTextByJSExecutor(associatedFine);
		Assert.assertEquals(actualFlatFineName, expectedName);

	}

	public void verifyVSFineLinkedToViolationIsDisplayed1() {
		String expectedName = PropertiesUtils.getPropertyValue("ViolationSpecificFineLinkedToNotice");
		waitForPresenceandVisiblity(associatedFine2);
		waitForElementIsInteractable(associatedFine2);
		String actualFlatFineName = getTextByJSExecutor(associatedFine2);
		Assert.assertEquals(actualFlatFineName, expectedName);

	}

	public void verifyVSFineLinkedToViolationIsDisplayed2() {
		String expectedName = PropertiesUtils.getPropertyValue("NoticeForViolationFineLinkedToViolations");
		waitForPresenceandVisiblity(associatedFine2);
		waitForElementIsInteractable(associatedFine2);
		String actualFlatFineName = getTextByJSExecutor(associatedFine2);
		Assert.assertEquals(actualFlatFineName, expectedName);

	}

	public void verifyVSFineLinkedToNoticeIsDisplayed() {
		String expectedName = PropertiesUtils.getPropertyValue("ViolationSpecificFineLinkedToNotice");
		waitForPresenceandVisiblity(vSFineLinkedToViolations);
		String actualFlatFineName = getTextByJSExecutor(vSFineLinkedToViolations);
		Assert.assertEquals(actualFlatFineName, expectedName);

	}

	public void selectViolationSpecificOption() {
		clickByJsExecuter(violationSpecificOptionOnCreateFinePage);

	}

	public static By applyBtn = By.xpath("//button[text()='Apply']");

	public void selectValueInAssociatedViolationDropdown() {
		clickByJsExecuter(associatedViolationDropdown);
		waitForElementIsInteractable(select1Violation);
		clickByJsExecuter(select1Violation);
		movetoElementAndClick(applyBtn);

	}

	public void verifyValidationMessageDisplayedForAssociateNoticeField() {
		String actual = getTextByJSExecutor(validationMsgAssociatedNoticeFADoc);
		String expected = PropertiesUtils.getPropertyValue("noticeReq");
		Assert.assertEquals(actual, expected);
	}

	public static By noNoticeAssociation = By.xpath("//label[@for='no-notice-association']");
	public static By saveBtn = By.xpath("//button[text()='Save']");

	public void editFineChangeVioToFlat(String fineName) throws InterruptedException {
		clickByJsExecuter(
				By.xpath("//div[contains(text(),'" + fineName + "')]//parent::div//following-sibling::div//button"));
		waitForCurserRunning(4);

		waitUntilElementIsVisible(FlateFineToggel);
		clickByJsExecuter(FlateFineToggel);
		clickByJsExecuter(noNoticeAssociation);
		scrollIntoView(saveBtn);
		clickByJsExecuter(saveBtn);
		waitForCurserRunning(5);
	}

	public void navigateToCreateViolationPage() throws InterruptedException {

		crmCommonMethod.navigateToAgencySetup();
		waitForElementIsInteractable(AppPreRequisiteUtility.ceTabOnAgenctSetupPage);
		scrollIntoView(AppPreRequisiteUtility.ceTabOnAgenctSetupPage);
		clickByJsExecuter(AppPreRequisiteUtility.ceTabOnAgenctSetupPage);
		waitForElementIsInteractable(AppPreRequisiteUtility.violationsTabOnAgencySetup);

		clickByJsExecuter(AppPreRequisiteUtility.violationsTabOnAgencySetup);

	}

	public void createRandomViolation(String violationName) throws InterruptedException {
		

		waitUntilElementIsVisible(AppPreRequisiteUtility.ViolationsTab);
		waitUntilElementPresent(AppPreRequisiteUtility.ViolationsTab);
		waitForElementIsInteractable(AppPreRequisiteUtility.ViolationsTab);
		clickByJsExecuter(AppPreRequisiteUtility.ViolationsTab);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateViolationButton);
		waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton);
		List<WebElement> AddedViolations = findElementsByXPath(AppPreRequisiteUtility.AddedViolationsRows);
		int rowsBefore=AddedViolations.size();
		clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateViolationPopup);
		String CreateViolationTitle = getTextElement(AppPreRequisiteUtility.CreateViolationPopup);
		crmCommonMethod.addNewViolationAdmin(violationName);
		waitForPresenceandVisiblity(AppPreRequisiteUtility.AddedViolationsRows);
		AddedViolations = findElementsByXPath(AppPreRequisiteUtility.AddedViolationsRows);
		List<WebElement> AddedViolations2= findElementsByXPath(AppPreRequisiteUtility.AddedViolationsRows);
		int rowsAfter=AddedViolations2.size();
		Assert.assertEquals(rowsBefore+1, rowsAfter);

	}

}
