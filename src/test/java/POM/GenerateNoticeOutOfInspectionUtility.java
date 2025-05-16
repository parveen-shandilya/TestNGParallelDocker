package POM;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class GenerateNoticeOutOfInspectionUtility extends Helper {
	public WebDriver driver;
	CECommonMethods ceCommonMethod;
	LoginUtility log;

	public GenerateNoticeOutOfInspectionUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceCommonMethod = new CECommonMethods(driver);
	}

	public void loginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void preRequisite() throws InterruptedException {
		ceCommonMethod.createCaseAndPerformInspection();
		forcedWaitTime(3);
		clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
		waitForCurserRunning(3);
		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//*[contains(text(),'HTML Mandatory Notice')]")).size();
		System.out.println(size);
		if (size > 0) {
			clickByJsExecuter(By.xpath("//*[contains(text(),'HTML Mandatory Notice')]"));
		}

		else {
			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(5000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[contains(text(),'HTML Mandatory Notice')]")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[contains(text(),'HTML Mandatory Notice')]")));
		}
		clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		Thread.sleep(3000);
		waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		waitUntilElementIsVisible(PerformInspectionUtility.DoNotPrintBtn);
		if(!elementIsDisplayed(PerformInspectionUtility.DoNotPrintBtn))
		clickByJsExecuter(PerformInspectionUtility.GenerateNoticeBtn);
		scrollIntoView(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		clickByJsExecuter(NoticesUtility.issueNoticeAdCompleteInspectionBtn);
		clickByJsExecuter(NoticesUtility.yesOnPopUp);
		waitForCurserRunning(3);

	}

	public void verifyGenerateNoticePopUpOpensUp() {
		scrollIntoView(CDP_Utility.generateNoticeBtn);
		clickByJsExecuter(CDP_Utility.generateNoticeBtn);
		String generateNotice = getTextElement(NoticesUtility.generateNoticeInProgressHeader);
		String expected = "Generate Notice";
		SoftAssert s1 = new SoftAssert();
		s1.assertEquals(generateNotice, expected);

		WebElement a1 = driver
				.findElement(By.xpath("//*[@class='field-section case-violation__toggle-section']/div/div/div/button"));
		WebElement a2 = driver.findElement(
				By.xpath("(//*[@class='field-section case-violation__toggle-section']/div/div/div/button)[2]"));

		System.out.println(a1.isEnabled() + " " + a1.isSelected());
		System.out.println(a2.isEnabled() + " " + a2.isSelected());

	}



	public void verifyResolutionSectionIsDisplayed() {
		waitForElementIsInteractable(CDP_Utility.resolutionSectionTile);
		Boolean resolutionActionTile = elementIsDisplayed(CDP_Utility.resolutionSectionTile);
		String actual = getTextByJSExecutor(CDP_Utility.resolutionActionHeader);
		String expected = "Resolution Action";
		SoftAssert s1 = new SoftAssert();
		s1.assertTrue(resolutionActionTile);
		s1.assertEquals(actual, expected);
		s1.assertAll();

	}

	public void verifyUserIsAbleToUpdateResolutionSection() throws InterruptedException {
		String textBeforeUpdation = getTextElement(CDP_Utility.resolutionActionTextArea);
		String updatedText = "Resolution action is updated";
		clickByJsExecuter(CDP_Utility.resolutionActionTextArea);
		forcedWaitTime(2);
		clearByJSE(CDP_Utility.resolutionActionTextArea);
		clearByJSE(CDP_Utility.resolutionActionTextArea);
		sendKeysWithWait(CDP_Utility.resolutionActionTextArea, updatedText);
		String textAfterUpdation = getTextElement(CDP_Utility.resolutionActionTextArea);
		Assert.assertEquals(textAfterUpdation, updatedText);
		Assert.assertNotEquals(textBeforeUpdation, textAfterUpdation);

	}

	public void verifyCertifiedMailNoFieldDisplayed() {

		Assert.assertTrue(elementIsDisplayed(CDP_Utility.certifiedMailNumberHeader));

	}

	public void verifyUserIsAbleToUpdateCertifiedNumber() {
		;
		String newText = RandomStrings.requiredCharacters(5).concat("updated");
		clearByJSE(CDP_Utility.certifiedMailNoTextField);
		sendKeysWithWait(CDP_Utility.certifiedMailNoTextField, newText);
		String updatedText = getValueAttribute(CDP_Utility.certifiedMailNoTextField);
		Assert.assertEquals(updatedText, newText);
	}

	public void verifyUserIsAbleToClickContinueBtn() {
		scrollIntoView(CDP_Utility.continueBtn1GenerateNoticeInProgressPage);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.continueBtn1GenerateNoticeInProgressPage));
		clickByJsExecuter(CDP_Utility.continueBtn1GenerateNoticeInProgressPage);

	}

	public void verifySelectNoticeTypeAndAssociatedFinesSectionDisplayed() {
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.selectNoticesTypeAndAssociatedFinesHeader));

	}

	public void verifyOnlyHTMLNoticesAreDisplayed() throws InterruptedException {
		forcedWaitTime(1);
		List<WebElement> notices = driver.findElements(CDP_Utility.selectNoticeForOOI);
		for (int i = 0; i < notices.size(); i++) {
			String noticeName = notices.get(i).getText();
			if (noticeName.contains("Non"))  {
				Assert.assertTrue(false);
			}
		}
	}

	public void verifyUserIsAbleToSelectAnyNotice() throws InterruptedException {
		Boolean htmlNoticeFound = false;
		waitForElementIsInteractable(By.xpath("//label[@title='Select a notice']//parent::div//following-sibling::div//button"));
		List<WebElement> notices = driver.findElements(By.xpath("//label[@title='Select a notice']//parent::div//following-sibling::div//button"));
		System.out.println(notices.size());
		for (int i = 0; i < notices.size(); i++) {
			System.out.println("Notice is "+notices.get(i).getText());
			Boolean flag = notices.get(i).isEnabled();
			if (notices.get(i).getText().contains("Mandatory")) {
				notices.get(i).click();
				htmlNoticeFound = true;
				flag=true;
				break;
			}
			
		}
		if (htmlNoticeFound == false) {

			Thread.sleep(5000);
			movetoElementAndClick(PerformInspectionUtility.selectNoticeDownArrow);

			Thread.sleep(5000);
			scrollIntoViewWebElement(driver.findElement(By.xpath("//*[@class='Select-menu']//*[contains(text(),'HTML Mandatory Notice')]")));
			movetoElementAndClick(driver.findElement(By.xpath("//*[@class='Select-menu']//*[contains(text(),'HTML Mandatory Notice')]")));

		}
		

	}

	public void verifyUserIsAbleToSelectADate() throws InterruptedException {

		String dateBefore = getValueAttribute(CDP_Utility.noticeIssueDateTextbox);
		clickByJsExecuter(CDP_Utility.datePickerIcon);
		forcedWaitTime(1);
		List<WebElement> selectDate = driver.findElements(CDP_Utility.selectDateFromDatePickerLastDay);
		int size = selectDate.size();
		System.out.println(size);
		selectDate.get(size - 1).click();
		String dateAfter = getValueAttribute(CDP_Utility.noticeIssueDateTextbox);

		Assert.assertNotEquals(dateBefore, dateAfter);

	}

	public void verifyFineAssociatedWithNoticeIsDisplayed() {
		if((BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) || (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")))
				{
		clickByJsExecuter(CDP_Utility.htmlMandatoryNotice);
				}
		Boolean flag = findElementsSize(CDP_Utility.associatedFineLabelForHTMLMandatory)>0;
		String fine = getValueAttribute(CDP_Utility.fineAddedOnGenerateNoticeInProgress);
		System.out.println("fine added " + fine);
		Assert.assertTrue(flag);
		Assert.assertEquals(fine, "100.00");

	}

	public void verifyUserIsAbleToAddNewFine() throws InterruptedException {

		clickByJsExecuter(CDP_Utility.addAnotherFineBtn);
		Thread.sleep(3000);
		waitForElementIsInteractable(CDP_Utility.addFineHeader);
		waitForElementIsInteractable(CDP_Utility.selectFineDropdown);

		movetoElementAndClick(CDP_Utility.selectFineDropdown);
		waitForElementIsInteractable(CDP_Utility.selectFineFromDropdownFirstValue);
		movetoElementAndClick(CDP_Utility.selectFineFromDropdownFirstValue);
		clickByJsExecuter(CDP_Utility.addFineFooter);
		waitForElementIsInteractable(CDP_Utility.addAnotherFineBtn);
		int size = driver.findElements(CDP_Utility.fineAddedOnGenerateNoticeInProgress).size();
		if (size < 2)
			Assert.assertTrue(false);
	}

	public void verifyUserIsDirectedToReviewOpenViolationsAndComplyByDates() {
		scrollIntoView(CDP_Utility.continueBtn2GenerateNoticeInProgressPage);
		clickByJsExecuter(CDP_Utility.continueBtn2GenerateNoticeInProgressPage);
		waitForElementIsInteractable(CDP_Utility.reviewOpenViolationsAndComplyByDatesctionHeader);
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.reviewOpenViolationsAndComplyByDatesctionHeader));

	}

	public void verifyAutoCalculatedDateAppearsByDefaultInComplyBySection() {
		String date = getValueAttribute(CDP_Utility.complyByDateField);
		Assert.assertNotEquals(date, "");

	}

	public void verifyUserIsAbleToUpdateComplyByDate() {
		String dateBefore = getValueAttribute(CDP_Utility.complyByDateField);
		scrollIntoView(CDP_Utility.complyByDateField);
		clickByJsExecuter(CDP_Utility.complyByDateField);
		List<WebElement> selectDate = driver.findElements(CDP_Utility.selectDateForComplyByDateField);
		int size = selectDate.size();
		try {
		//selectDate.get(size - 1).click();
			clickOn(CDP_Utility.selectDate_30);
		}
		catch(Exception e)
		{
			movetoElementAndClick(CDP_Utility.selectDate_30);
		}
		String dateAfter = getValueAttribute(CDP_Utility.complyByDateField);
		Assert.assertNotEquals(dateBefore, dateAfter);

	}

	public void verifyUserIsDirectedToFollowUpInspectionDatePage() {
		scrollIntoView(CDP_Utility.continueBtn3GenerateNoticeInProgressPage);
		try {
			clickByJsExecuter(CDP_Utility.continueBtn3GenerateNoticeInProgressPage);
		}catch (Exception e){
			clickOn(CDP_Utility.continueBtn3GenerateNoticeInProgressPage);
		}
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.followUpInspectionDateLabel));

	}

	public void verifyUserIsAbleToUpdateFollowUpInspectionDate() throws InterruptedException {
		ceCommonMethod.selectScheduleFollowUpInspectionCheckbox();
		String dateBefore = getValueAttribute(CDP_Utility.followUpInspectionDateField);
		clickByJsExecuter(CDP_Utility.datePickerIcon);
		List<WebElement> selectDate = driver.findElements(CDP_Utility.selectDateFromDatePickerLastDay);
		int size = selectDate.size();

		selectDate.get(size - 1).click();
		String dateAfter = getValueAttribute(CDP_Utility.followUpInspectionDateField);
		Assert.assertNotEquals(dateBefore, dateAfter);

	}

	public void verifyUserIsAbleToUpdateFollowUpInspectionAssignee() {
		scrollIntoView(CDP_Utility.select3AssigneeForFollowUpInspectionAsg);
		clickByJsExecuter(CDP_Utility.select3AssigneeForFollowUpInspectionAsg);
		String newAsignee = getSpecificAttribute(CDP_Utility.select3AssigneeForFollowUpInspectionAsg, "class");
		System.out.println(newAsignee);
		if (!(newAsignee.contains("primary"))) {
			Assert.assertTrue(false);
		}
	}

	public void verifyUserIsNavigatedToGenerateNoticePop() {
		scrollIntoView(CDP_Utility.generateNoticeBtn);
		clickByJsExecuter(CDP_Utility.generateNoticeBtnOOI);
		waitForElementIsInteractable(NoticesUtility.generateNoticeHeader);
		Assert.assertTrue(elementIsDisplayed(NoticesUtility.generateNoticeHeader));

	}

	public void verifyCorrectPreviewOfHtmlNoticeIsDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);

		String text = getTextByJSExecutor(NoticesUtility.generateNoticePreview);
		SoftAssert s1 = new SoftAssert();
		if (!(text.contains("Mandatory"))) {

			s1.assertTrue(false);
		}
		driver.switchTo().defaultContent();
		s1.assertAll();

	}

	public void verifyPrintToggleBtnIsSelected() {
		scrollIntoView(NoticesUtility.printBtnOnGenerateNotice);
		Assert.assertTrue(elementIsDisplayed(NoticesUtility.printBtnOnGenerateNotice));
		String text = getSpecificAttribute(NoticesUtility.printBtnOnGenerateNotice, "class");
		if (!(text.contains("primary"))) {
			Assert.assertFalse(false);
		}

	}

	public void verifyNoticeCreatedIndeoendentOfFollowUpInspectionSectionIsDisplayed() throws InterruptedException {
		clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(NoticesUtility.generateNoticeBtnOnGenerateNoticePopUp);
		try {
		clickByJsExecuter(NoticesUtility.generateNoticeBtnOnGenerateNoticePopUp);
		}
		catch(Exception e)
		{
			movetoElementAndClick(NoticesUtility.generateNoticeBtnOnGenerateNoticePopUp);
		}
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.noticeCreatedIndependentOfInspectionHeader);
		SoftAssert s1 = new SoftAssert();
		s1.assertTrue(elementIsDisplayed(CDP_Utility.noticeCreatedIndependentOfInspectionHeader));
		String notice = getTextByJSExecutor(CDP_Utility.noticeCreatedIndependentOfInspection);
		if (!(notice.contains("Mandatory"))) {
			s1.assertTrue(false);
		}
		s1.assertAll();

	}

	public void verifyApplyNoticeBtnIsDisplayed() {
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.manageNoticeLinkCDP));

	}

	public void verifyManageNoticeLinkIsDisplayed() {
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.manageNoticeLinkCDP));

	}

	public void verifyEditNoticeIsDisplayed() {
		clickByJsExecuter(CDP_Utility.manageNoticeLinkCDP);
		waitForElementIsInteractable(NoticesUtility.deleteAndReissue);
		Assert.assertTrue(elementIsDisplayed(NoticesUtility.deleteAndReissue));
		clickByJsExecuter(CDP_Utility.closeBtnManageNoticePopUp);
	}

	public void verifyAdditionalTextDisplayedOnCloseCasePopUp() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.moreBtnCDP);
		clickByJsExecuter(CDP_Utility.closeCaseAfterMoreBtn);
		String text = getTextByJSExecutor(CDP_Utility.unappliedNoticeWarning);
		String expected = "Un-applied notices will not be applied to the case";
		clickByJsExecuter(CDP_Utility.closeCaseBtnOnCloseCasePopup);
		waitForCurserRunning(5);
		Assert.assertEquals(text, expected);

	}

	public void verifyUnaplliedNoticeAppearsAfterClosingCase() {
		Assert.assertTrue(findElementsSize(CDP_Utility.noticeCreatedIndependentOfInspectionHeader)>0);

	}

	public void voidverifyApplyNoticeBtnNotDisplayed() {
		Assert.assertFalse(findElementsSize(CDP_Utility.applyNoticeBtnCDP)>0);

	}

	public void verifyViewNoticeBtnNotDisplayed() {
		Assert.assertTrue(elementIsDisplayed(CDP_Utility.viewNotice));

	}

	float outstandingBalance;

	public void verifyConfirmationPopUpOpensAfterClickingApplyNoticeBtn() throws InterruptedException {
		scrollIntoView(CDP_Utility.moreBtnCDP);
		clickByJsExecuter(CDP_Utility.moreBtnCDP);
		clickByJsExecuter(CDP_Utility.closeCaseAfterMoreBtn);
		clickByJsExecuter(ReopenCasesUtility.NonCompliantButton);
		clickByJsExecuter(ReopenCasesUtility.ReopenCaseButton);
		waitForCurserRunning(5);
		waitForElementIsInteractable(CDP_Utility.applyNoticeBtnCDP);

		outstandingBalance = Float
				.parseFloat(getTextByJSExecutor(CDP_Utility.outstandingBalanceValue).replace("$", ""));
		System.out.println("Outstanding balance is " + outstandingBalance);

		scrollIntoView(CDP_Utility.applyNoticeBtnCDP);

		clickByJsExecuter(CDP_Utility.applyNoticeBtnCDP);
		clickByJsExecuter(CDP_Utility.continueAfterApplyNotice);
		waitForElementIsInteractable(CDP_Utility.applyNoticeConfirmationPopup);

		Assert.assertTrue(findElementsSize(CDP_Utility.applyNoticeConfirmationPopup)>0);

	}

	public void verifyConfirmationPopIsClosedAFterCancel() throws InterruptedException {
		clickByJsExecuter(NoticesUtility.CancelButtonCCP);
		forcedWaitTime(1);
		Assert.assertFalse(findElementsSize(CDP_Utility.applyNoticeConfirmationPopup)>0);

	}

	public void verifyUserIsAbleToApplyNoticeAfterClickingYes() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.continueAfterApplyNotice);
		clickByJsExecuter(NoticesUtility.yesOnPopUp);
		waitForCurserRunning(5);

		Assert.assertFalse(findElementsSize(CDP_Utility.noticeCreatedIndependentOfInspectionHeader)>0);

	}

	public void verifyOutstandingBalanceIsUpdated() {
		// outstandingBalance=Float.parseFloat(getTextByJSExecutor(CDP_Utility.outstandingBalanceValue).replace("$",
		// ""));

		float outstandingBalanceAfterNoticeApplied = Float
				.parseFloat(getTextByJSExecutor(CDP_Utility.outstandingBalanceValue).replace("$", ""));
		System.out.println("Outstanding balance is " + outstandingBalance);

		if (outstandingBalance >= outstandingBalanceAfterNoticeApplied) {
			Assert.assertTrue(false);
		}

	}

	public void verifyGenerateNoticeButtonNotDisplayed() throws InterruptedException {
		scrollIntoView(CDP_Utility.crossIconCDP);
		clickByJsExecuter(CDP_Utility.crossIconCDP);
		ceCommonMethod.createACase();
//		Boolean flag = elementIsDisplayed(CDP_Utility.generateNoticeBtn);
		if (findElementsSize(CDP_Utility.generateNoticeBtn)>0)
			Assert.assertTrue(false);

	}

}
