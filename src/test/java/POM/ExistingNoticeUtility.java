package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class ExistingNoticeUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods CECommonMethodS;
	CCPUtility ccp;

	public ExistingNoticeUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		CECommonMethodS = new CECommonMethods(driver);
		ccp = new CCPUtility(driver);

	}

	SoftAssert softAssert = new SoftAssert();

	public static By secFilter = By.xpath("//div[@class='dropdown__wrapper  dropdown__wrapper--open']");
	public static By noContactPopuptext = By.xpath("//h4[@class='disclaimer-modal__disclaimer-text']");
	public static By noButton = By.xpath("//button[text()='No']");
	public static By yesButton = By.xpath("//button[text()='Yes']");
	public static By selectNoticeScheduleFollowUp = By.xpath("//h2[text()='Select Notice & Schedule Follow Up']");
	public static By generateNoticeBtn = By.xpath("//button[text()='Generate Notice']");
	public static By generateNoticeHeaderText = By.xpath("//div[@class='perform-inspection__title-text']");
	public static By continueBtn1 = By.xpath("//div[@class='footer_actions']/button");
	public static By continueBtn2 = By
			.xpath("(//div[@class='progressive-form__footer']//button[@class='square-btn btn btn-primary'])[2]");
	public static By reviewOpenViolationsComplyDatesHeaderText = By
			.xpath("//h2[text()='Review Open Violations & Comply By Dates']");
	public static By continueBtn3 = By
			.xpath("(//div[@class='progressive-form__footer']//button[@class='square-btn btn btn-primary'])[3]");
	public static By followupInspectionDateHeaderText = By
			.xpath("(//div[@class='progressive-form__footer']//button[@class='square-btn btn btn-primary'])[3]");
	public static By generateNoticeBtn1 = By.xpath("//div[@class='apply-notice-footer']//button[1]");
	public static By generateNoticeBtn2 = By.xpath("//div[@class='case-inspection__notice-action-buttons']/button[2]");
	public static By selectNoticeTypeAssociatedFines = By.xpath("//h2[text()='Select Notice Type & Associated Fines']");
	public static By selectNotice = By.xpath("//*[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]");
	public static By validToggleBtn = By.xpath("//button[text()='Valid']");
	public static By independentNoticeCreateSection = By
			.xpath("//h4[text()='Notice created independent of Follow-up inspection']");
	public static By followupInspection2inProgressHeaderText = By.xpath("//div[@class='perform-inspection__title']");
	public static By nonComplianttoggle = By.xpath("//button[text()='Non-Compliant']");
	public static By continueBtn4 = By.xpath("//div[@class='footer_actions']//button[text()='Continue']");
	public static By selectNoticeScheduleFollowUp2 = By.xpath("//h2[text()='Select Notice & Schedule Follow Up']");
	public static By existingNoticeToggle = By.xpath("//button[text()='Existing Notice']");
	public static By whichNoticeDoyouWantToggle = By
			.xpath("(//div[@class='multi-choice-buttons']//button[@class='square-btn btn btn-primary'])[2]");
	public static By finishInspectionAndApplyBtn = By.xpath("//button[text()='Finish Inspection and Apply']");
	public static By viewNoticeLink = By.xpath(
			"//div[@class='abatement-activities__done-cta abatement-activities__done-cta-margin']/a[text()='View Notice']");
	public static By viewNoticepoptilte = By.xpath("//div[@class='notice-preview-title']");
	public static By deleteLink = By.xpath("//a[text()='Delete']");
	public static By deleteandreissuelink = By.xpath("//a[text()='Delete and Reissue']");
	public static By followUpInspection1Completed = By.xpath("(//label[@class='completed-summary']//span)[2]");
	public static By addContactField = By.xpath(
			"//input[@placeholder='Find contact by name, email or phone number or start typing to create a new contact']");
	public static By createANewContactLink = By.xpath("//span[text()='Create a  new contact']");
	public static By nameField = By.xpath("//input[@name='name']");
	public static By emailAddressField = By.xpath("//input[@name='email']");
	public static By cellPhoneField = By.xpath("//input[@name='cellPhone']");
	public static By createContactBtn = By.xpath("//button[text()='Create Contact']");
	public static By contactTileCount = By.xpath("(//h2//div)[1]");
	public static By manageNoticeLink = By.xpath("//u[text()='Manage Notice']");
	public static By closeBtnonViewNoticePopup = By.xpath("(//div[@class='view-notice__footer']//button)[2]");
	public static By applyNoticeBtn = By.xpath("//button[text()='Apply Notice']");
	public static By followUpInspPopupTitle = By.xpath("//h1[text()='Follow Up Inspection']");
	public static By continueBtn5 = By.xpath("//button[text()='Continue']");
	public static By viewNoticepopup = By.xpath("//div[@class='preview-form-header']");

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void existingNotice_PreRequisite() throws InterruptedException {

		CECommonMethodS.navigateToCCP();
		CECommonMethodS.addLocationCCP();
		Thread.sleep(5000);
		CECommonMethodS.addViolationParam("Water");
		Thread.sleep(5000);
		// CECommonMethodS.addAttachmentCCP(CECommonMethodS.SetTestDataFilePath("pexels-mike-b-170811.jpg"));
		List<WebElement> contactCrossIcons = driver.findElements(ccp.contactcrossicon);
		int no = contactCrossIcons.size();
		if (no > 0) {
			for (int i = 0; i < no; i++) {
				try {
					contactCrossIcons.get(i).click();
					waitForCurserRunning(5);
				} catch (Exception e) {
					clickByJsExecuter(
							By.xpath("//*[@class='contact__actions']//*[@class='delete-btn  btn btn-primary']"));

				}
			}
		}
		scrollIntoView(CCPUtility.CreateCaseButton);
		clickOn(CCPUtility.CreateCaseButton);
		handleReviewContact();
		waitForCurserRunning(10);
		waitUntilElementIsVisible(CCPUtility.performInspectionToogel);
		clickOn(CCPUtility.performInspectionToogel);
		waitUntilElementIsVisible(CCPUtility.proActiveButton);
		Boolean proActiveButton = elementIsDisplayed(CCPUtility.proActiveButton);
		waitUntilElementIsVisible(CCPUtility.performInspectionAndCreateCase);
		scrollIntoView(CCPUtility.performInspectionAndCreateCase);
		clickOn(CCPUtility.performInspectionAndCreateCase);
		waitForCurserRunning(5);

	}

	public void existingNotice_OpenConfirmationPopup() throws InterruptedException {
		forcedWaitTime(2);
		waitForElementIsInteractable(noContactPopuptext);
		String actualpopupText = getTextElement(noContactPopuptext);
		String expectedPopupText = "There is no contact information on the case. Do you wish to proceed?";
		softAssert.assertEquals(actualpopupText, expectedPopupText);
		softAssert.assertAll();

	}

	public void existingNotice_CloseConfirmationPopup() throws InterruptedException {
		waitUntilElementPresent(noButton);
		forcedWaitTime(3);
		clickByJsExecuter(noButton);
		forcedWaitTime(5);
		int noBtn = findElementsSize(noButton);
		System.out.println(noBtn);
		if (noBtn == 0) {
			softAssert.assertTrue(true);
			softAssert.assertAll();

		} else {
			softAssert.assertFalse(true);
			softAssert.assertAll();

		}

	}

	public void existingNotice_OpenVerificationInspProgressPopup() throws InterruptedException {
		clickByJsExecuter(CDP_Utility.performInspectionBtn);
		waitUntilElementPresent(yesButton);
		clickOn(yesButton);
		waitForElementIsInteractable(NoticesUtility.verifyViolationTextHeader);
		Assert.assertTrue(elementIsDisplayed(NoticesUtility.verifyViolationTextHeader));

		clickOn(By.xpath("//button[text()='Valid']"));
		scrollIntoView(PerformInspectionUtility.ContinueBtnFollowUp);
		waitForElementIsInteractable(PerformInspectionUtility.ContinueBtnFollowUp);
		clickOn(PerformInspectionUtility.ContinueBtnFollowUp);
		Assert.assertTrue(elementIsDisplayed(selectNoticeScheduleFollowUp));
		clickByJsExecuter(PerformInspectionUtility.NewNoticeBtn);
		waitUntilElementIsVisible(By.xpath(PerformInspectionUtility.continueBtnFollowUp2));
		waitForElementIsInteractable(selectNotice);
		int htmlSizebtn = driver
				.findElements(By.xpath("//*[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]"))
				.size();
		if (htmlSizebtn > 0) {
			clickByJsExecuter(By.xpath("//*[@class='multi-choice-buttons']//button[starts-with(text(),'HTML')]"));
		} else {
			List<WebElement> allNotices = waitUntilVisibleList(PerformInspectionUtility.SelectANotice);
			int CountNotices = allNotices.size();
			for (int i = 0; i < CountNotices; i++) {
				WebElement listSeq = allNotices.get(i);
				String[] noticeType = listSeq.getText().split(" ");
				if (noticeType[0].equalsIgnoreCase("HTML")) {
					listSeq.click();
					break;
				}
			}
		}
		waitForElementIsInteractable(PerformInspectionUtility.ContinueBtnFollowUp2);
		clickOn(PerformInspectionUtility.ContinueBtnFollowUp2);
		forcedWaitTime(4);
		waitUntilElementIsVisible(PerformInspectionUtility.GenerateNoticeBtn);
		clickOn(PerformInspectionUtility.GenerateNoticeBtn);
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickOn(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(By.xpath(PerformInspectionUtility.issueNoticeButton));
		clickOn(By.xpath(PerformInspectionUtility.issueNoticeButton));
		waitUntilElementIsVisible(PerformInspectionUtility.YesConfirmation);
		waitForElementIsInteractable(PerformInspectionUtility.YesConfirmation);
		clickOn(PerformInspectionUtility.YesConfirmation);
		waitForCurserRunning(10);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(PerformInspectionUtility.FollowUpInspectionSection);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		WebElement followUp2Title = waitUntilVisibleWE(PerformInspectionUtility.FollowUpInspectionSection);
		if (!(followUp2Title.isDisplayed())) {
			SoftAssert s120 = new SoftAssert();
			s120.assertEquals(false, true);
			s120.assertAll();

		}
	}

	public void existingNotice_GenerateNoticeOutofInpec() throws InterruptedException {
		Thread.sleep(3000);
		scrollIntoView(generateNoticeBtn);
		waitForElementIsInteractable(generateNoticeBtn);
		clickByJsExecuter(generateNoticeBtn);
		waitForElementIsInteractable(generateNoticeHeaderText);
		Assert.assertTrue(elementIsDisplayed(generateNoticeHeaderText));
		waitForElementIsInteractable(continueBtn1);
		clickOn(continueBtn1);
		Assert.assertTrue(elementIsDisplayed(selectNoticeTypeAssociatedFines));
		waitForElementIsInteractable(
				By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"));
		int htmlSizebtn2 = driver
				.findElements(By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"))
				.size();
		System.out.println(htmlSizebtn2);
		if (htmlSizebtn2 > 0) {
			clickByJsExecuter(By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"));
		} else {
			System.out.println("html notice not found");
		}
		waitForElementIsInteractable(continueBtn2);
		clickOn(continueBtn2);
		Assert.assertTrue(elementIsDisplayed(reviewOpenViolationsComplyDatesHeaderText));
		waitForElementIsInteractable(continueBtn3);
		clickOn(continueBtn3);
		waitForElementIsInteractable(generateNoticeBtn1);
		clickOn(generateNoticeBtn1);
		waitForCurserRunning(5);
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickOn(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(generateNoticeBtn2);
		clickOn(generateNoticeBtn2);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(independentNoticeCreateSection);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		String generatedNoticeText = getTextElement(independentNoticeCreateSection);
		String expectedPopupText = "Notice created independent of Follow-up inspection";
		softAssert.assertEquals(generatedNoticeText, expectedPopupText);
		softAssert.assertAll();

	}

	public void existingNotice_ExistingNoticeToggle() throws InterruptedException {

		waitForElementIsInteractable(CDP_Utility.performInspectionBtn);
		clickByJsExecuter(CDP_Utility.performInspectionBtn);
		waitUntilElementPresent(yesButton);
		clickOn(yesButton);
		waitForElementIsInteractable(followupInspection2inProgressHeaderText);
		Assert.assertTrue(elementIsDisplayed(followupInspection2inProgressHeaderText));
		clickOn(nonComplianttoggle);
		scrollIntoView(continueBtn4);
		waitForElementIsInteractable(continueBtn4);
		clickOn(continueBtn4);
		Assert.assertTrue(elementIsDisplayed(selectNoticeScheduleFollowUp2));
		clickByJsExecuter(existingNoticeToggle);
		WebElement existingNoticeoption = waitUntilVisibleWE(existingNoticeToggle);
		String btnClass = getSpecificAttribute(existingNoticeToggle, "class");
		Assert.assertTrue(btnClass.contains("primary"));

	}

	public void existingNotice_AppearsUnappliedNotice() throws InterruptedException {
		Thread.sleep(2000);
		waitForElementIsInteractable(whichNoticeDoyouWantToggle);
		clickByJsExecuter(whichNoticeDoyouWantToggle);
		WebElement whichnoticedoyouwantToggle = waitUntilVisibleWE(whichNoticeDoyouWantToggle);
		String btnClass1 = getSpecificAttribute(whichNoticeDoyouWantToggle, "class");
		Assert.assertTrue(btnClass1.contains("btn-primary"));

	}

	public void existingNotice_OpnesViewNoticePopup() throws InterruptedException {
		waitForElementIsInteractable(manageNoticeLink);
		clickOn(manageNoticeLink);
		// WebElement actualviewNoticePopuptitle = waitUntilVisibleWE(viewNoticepopup);
		String viewNoticePopUp1 = getSpecificAttribute(viewNoticepopup, "class");
		Assert.assertTrue(viewNoticePopUp1.contains("header"));

	}

	public void existingNotice_CompleteInpandApplyNotice() throws InterruptedException {
		scrollIntoView(closeBtnonViewNoticePopup);
		waitForElementIsInteractable(closeBtnonViewNoticePopup);
		clickOn(closeBtnonViewNoticePopup);
		scrollIntoView(finishInspectionAndApplyBtn);
		waitForElementIsInteractable(finishInspectionAndApplyBtn);
		clickOn(finishInspectionAndApplyBtn);
		waitForElementIsInteractable(yesButton);
		clickOn(yesButton);
		waitForCurserRunning(10);
		List<WebElement> generatedNoticeText = driver.findElements(independentNoticeCreateSection);
		if (!(generatedNoticeText.size() == 0)) {
			SoftAssert s120 = new SoftAssert();
			s120.assertEquals(false, true);
			s120.assertAll();
		}

	}

	public int beforeAddingContact;
	public int afterAddingContact;

	public void existingNotice_DeleteandReissueNotice() throws InterruptedException {
		beforeAddingContact = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());

		String randomName = RandomStrings.requiredCharacters(8);
		String randomMail = randomName + "@yopmail.com";
		String randomContact = RandomStrings.requiredDigits(10);
		waitUntilElementIsVisible(addContactField);
		clickOn(addContactField);
		clickOn(createANewContactLink);
		sendKeysWithWait(nameField, randomName);
		sendKeysWithWait(emailAddressField, randomMail);
		sendKeysWithWait(cellPhoneField, randomContact);
		waitForElementIsInteractable(createContactBtn);
		clickOn(createContactBtn);
		waitForElementIsInteractable(ccp.PropertyOwnerOption);
		clickOn(ccp.PropertyOwnerOption);
		clickOn(ccp.ApplyButton);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(contactTileCount);
		afterAddingContact = Integer
				.parseInt(getTextElement(contactTileCount).split(" ")[1].replace("(", " ").replace(")", " ").trim());
		softAssert.assertEquals(afterAddingContact, beforeAddingContact + 1);
		softAssert.assertAll();
		scrollIntoView(viewNoticeLink);
		waitForElementIsInteractable(viewNoticeLink);
		clickOn(viewNoticeLink);
		waitForElementIsInteractable(deleteandreissuelink);
		clickOn(deleteandreissuelink);
		waitForElementIsInteractable(yesButton);
		clickOn(yesButton);
		waitUntilElementIsVisible(generateNoticeHeaderText);
		Assert.assertTrue(elementIsDisplayed(generateNoticeHeaderText));
		waitForElementIsInteractable(continueBtn1);
		clickOn(continueBtn1);
		Assert.assertTrue(elementIsDisplayed(selectNoticeTypeAssociatedFines));
		waitForElementIsInteractable(
				By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"));
		int htmlSizebtn2 = driver
				.findElements(By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"))
				.size();
		System.out.println(htmlSizebtn2);
		if (htmlSizebtn2 > 0) {
			clickByJsExecuter(By.xpath("//div[@class='multi-choice-buttons']/button[(starts-with(text(),'HTML'))]"));
		} else {
			System.out.println("html notice not found");
		}
		waitForElementIsInteractable(continueBtn2);
		clickOn(continueBtn2);
		Assert.assertTrue(elementIsDisplayed(reviewOpenViolationsComplyDatesHeaderText));
		waitForElementIsInteractable(continueBtn3);
		clickOn(continueBtn3);
		waitForElementIsInteractable(generateNoticeBtn1);
		clickOn(generateNoticeBtn1);

		try {
			clickByJsExecuter(generateNoticeBtn1);
		} catch (Exception e) {
			movetoElementAndClick(generateNoticeBtn1);
		}

		waitForCurserRunning(5);
		waitForElementIsInteractable(PerformInspectionUtility.DoNotPrintBtn);
		clickOn(PerformInspectionUtility.DoNotPrintBtn);
		waitForElementIsInteractable(generateNoticeBtn2);
		clickOn(generateNoticeBtn2);
		waitForCurserRunning(10);
		waitUntilElementIsVisible(independentNoticeCreateSection);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		clickByJsExecuter(yesButton);
		waitForCurserRunning(5);
		softAssert.assertTrue(elementIsDisplayed(viewNoticeLink));

	}

	public void existingNotice_DeleteNotice() throws InterruptedException {
		waitForElementIsInteractable(viewNoticeLink);

		List<WebElement> generatedNoticeText = driver.findElements(viewNoticeLink);
		int size1 = generatedNoticeText.size();
		clickOn(viewNoticeLink);
		waitForElementIsInteractable(deleteLink);
		clickOn(deleteLink);
		waitForElementIsInteractable(yesButton);
		clickOn(yesButton);
		waitForCurserRunning(10);
		waitForElementIsInteractable(viewNoticeLink);

		List<WebElement> generatedNoticeText1 = driver.findElements(viewNoticeLink);
		int size2 = generatedNoticeText1.size();

		if (size2 >= size1) {
			SoftAssert s120 = new SoftAssert();
			s120.assertEquals(false, true);
			s120.assertAll();

		}

// 	    String ActualNoticeTileText = getTextElement(followUpInspection1Completed);
//		String ExpectedNoticeTileText = "Follow-up Inspection 1 Completed";
//		softAssert.assertEquals(ActualNoticeTileText, ExpectedNoticeTileText);
//		softAssert.assertAll();

	}

}
