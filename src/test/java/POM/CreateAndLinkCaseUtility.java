package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;


public class CreateAndLinkCaseUtility extends Helper {


    public WebDriver driver;
    LoginUtility log;
    CRMCommonMethods crmCommonMethod;
    CECommonMethods ceCommonMethod;

    public CreateAndLinkCaseUtility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        crmCommonMethod = new CRMCommonMethods(driver);
        ceCommonMethod = new CECommonMethods(driver);
    }


    public static String descriptionTextCSDP = "(//div[@class='description tile'])/div[2]/div";
    public static String attachmentsHeaderCSDP = "//div[@id='cs-attachments']//h2/span";
    public static String addedCustomerCSDP = "//label[text()='Customer Name']/following::a[1]";
    public static String submissionNumber = "//h2[@class='customer-submission-details__number']";
    public static String moreButtonCSDP = "//button[text()='More...']";
    public static String createAndLinkCaseOption = "//li[text()='Create & Link Case']";
    public static String createACasePage = "//h1[text()='Create A Case']";
    public static String issueDescriptionCCP = "//textarea[@name='issueDescription']";
    public static String addedContactCCP = "//div[@class='contact__name-role']//b";
    public static String attachmentHeaderCCP = "//div[@class='attachment-tile tile']//h2/span";
    public static String locationSearchField = "//div[@class='location-tile__inputs-container']//input";
    public static String locationSearchResults = "//div[@class='react-autosuggest__suggestion-element']";
    public static String createCaseButton = "button.square-btn.space-left.btn.btn-primary";
    public static String createCasePopup = "//div[text()='Create Case']";
    public static String createScheduleInspectionButton = "//button[text()='Create & Schedule Inspection']";
    public static String associatedSubmissionLink = "//label[text()='Associated Submission']/following::a[1]";
    public static String linkedCaseNumber = "//h2[@class='case-details__case-number']";
    public static String associatedCaseLink = "//label[text()='Associated Case']/following::a[1]";
    public static String removeLink = "//a[text()='Remove Link']";

    public static By DescriptionTextCSDP = By.xpath(descriptionTextCSDP);
    public static By AttachmentsHeaderCSDP = By.xpath(attachmentsHeaderCSDP);
    public static By AddedCustomerCSDP = By.xpath(addedCustomerCSDP);
    public static By SubmissionNumber = By.xpath(submissionNumber);
    public static By MoreButtonCSDP = By.xpath(moreButtonCSDP);
    public static By CreateAndLinkCaseOption = By.xpath(createAndLinkCaseOption);
    public static By CreateACasePage = By.xpath(createACasePage);
    public static By IssueDescriptionCCP = By.xpath(issueDescriptionCCP);
    public static By AddedContactCCP = By.xpath(addedContactCCP);
    public static By AttachmentHeaderCCP = By.xpath(attachmentHeaderCCP);
    public static By LocationSearchField = By.xpath(locationSearchField);
    public static By LocationSearchResults = By.xpath(locationSearchResults);
    public static By CreateCaseButton = By.cssSelector(createCaseButton);
    public static By CreateCasePopup = By.xpath(createCasePopup);
    public static By CreateScheduleInspectionButton = By.xpath(createScheduleInspectionButton);
    public static By AssociatedSubmissionLink = By.xpath(associatedSubmissionLink);
    public static By LinkedCaseNumber = By.xpath(linkedCaseNumber);
    public static By AssociatedCaseLink = By.xpath(associatedCaseLink);
    public static By RemoveLink = By.xpath(removeLink);

    public static String DescriptionCSDP;
    public static String AttachmentsCountCSDP;
    public static String CustomerOnCSDP;
    public static String SubmissionNumberCSDP;
    public static String CaseNumberLinked;
    public static String CCPTitle;
    public static String AssociatedCase2;
    public static String AssociatedCase;
    public static String AssociatedSubmission;
    public static String CreateCasePopupTitle;
    public static String IssueDescriptionTextCCP;
    public static String AttachmentCountCCP;
    public static String ContactOnCCP;

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();

    }


    public void CreateAndLinkCase_PreRequisite() throws InterruptedException {
        closeOtherTabs();

        crmCommonMethod.createSubmission("No", "Yes", "Yes", "No", "Yes", "Location Not Required");
        waitForCurserRunning(15);
        waitUntilElementIsVisible(DescriptionTextCSDP);
        forcedWaitTime(4);
        waitUntilElementIsVisible(DescriptionTextCSDP);
        DescriptionCSDP = getTextElement(DescriptionTextCSDP);
        AttachmentsCountCSDP = getTextElement(AttachmentsHeaderCSDP);
        CustomerOnCSDP = getTextElement(AddedCustomerCSDP);
        String SubmissionNumberSplit[] = getTextElement(SubmissionNumber).split("#");
        SubmissionNumberCSDP = SubmissionNumberSplit[1];
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

    public void CreateAndLinkCase_OpenCCPToLinkTheCase() throws InterruptedException {
        waitUntilElementIsVisible(MoreButtonCSDP);
        waitForElementIsInteractable(MoreButtonCSDP);
        clickByJsExecuter(MoreButtonCSDP);
        waitForElementIsInteractable(CreateAndLinkCaseOption);
        clickByJsExecuter(CreateAndLinkCaseOption);
        waitForCurserRunning(7);
        waitUntilElementIsVisible(CreateACasePage);
        Thread.sleep(3000);
        CCPTitle = getTextElement(CreateACasePage);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(CCPTitle.equals("Create A Case"));
        softAssert.assertAll();
    }

    public void CreateAndLinkCase_VerifyAutopopulatedData() throws InterruptedException {

        waitUntilElementIsVisible(IssueDescriptionCCP);
        waitUntilElementPresent(IssueDescriptionCCP);

        forcedWaitTime(4);
        IssueDescriptionTextCCP = getTextElement(IssueDescriptionCCP);
        AttachmentCountCCP = getTextElement(AttachmentHeaderCCP);
        ContactOnCCP = getTextElement(AddedContactCCP);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(IssueDescriptionTextCCP, DescriptionCSDP, "issue Description is not matched.");
        softAssert.assertEquals(AttachmentCountCCP, AttachmentsCountCSDP, "attachment count is not matched.");
        softAssert.assertEquals(ContactOnCCP, CustomerOnCSDP, "contact is not matched.");
        softAssert.assertAll();
    }

    public void CreateAndLinkCase_VerifyLinkedCase() throws InterruptedException {
        waitForCurserRunning(5);
        crmCommonMethod.addLocation();
        crmCommonMethod.addViolation();
        scrolltoPageTop();
        waitUntilElementIsVisible(CreateCaseButton);
        scrollIntoView(CreateCaseButton);
        Thread.sleep(3000);

        waitForElementIsInteractable(CreateCaseButton);
        Thread.sleep(3000);
        //movetoElementAndClick(CreateCaseButton);
        //clickOn(CreateCaseButton);
        clickByJsExecuter(CreateCaseButton);
        Thread.sleep(3000);

        handleReviewContact();
        waitUntilElementIsVisible(CreateCasePopup);
        CreateCasePopupTitle = getTextElement(CreateCasePopup);
        waitUntilElementIsVisible(CreateScheduleInspectionButton);
        forcedWaitTime(4);
        waitUntilElementIsVisible(By.xpath("//div[@class='multi-choice-buttons'] //button[@class='square-btn btn btn-primary']"));
        waitUntilElementPresent(CreateScheduleInspectionButton);
        waitForElementIsInteractable(CreateScheduleInspectionButton);
        clickByJsExecuter(CreateScheduleInspectionButton);
        waitForCurserRunning(12);
        waitUntilElementIsVisible(AssociatedSubmissionLink);
        waitUntilElementPresent(AssociatedSubmissionLink);
        AssociatedSubmission = getTextElement(AssociatedSubmissionLink);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(CreateCasePopupTitle.equals("Create Case"));
        softAssert.assertTrue(AssociatedSubmission.equals(SubmissionNumberCSDP));
        softAssert.assertAll();
    }

//	    public  void CreateAndLinkCase_VerifyDirectionToAssociatedSubmission() throws InterruptedException {
//	        waitUntilElementIsVisible(LinkedCaseNumber);
//	        String CaseNumberSplit[] = getTextElement(LinkedCaseNumber).split("#");
//	        CaseNumberLinked = CaseNumberSplit[1];
//	        waitForElementIsInteractable(AssociatedSubmissionLink);
//	        clickByJsExecuter(AssociatedSubmissionLink);
//            forcedWaitTime(3);
//	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//	        waitForPageLoadTime(4);
//	        driver.switchTo().window((String) tabs.get(1));
//	        waitUntilElementIsVisible(AssociatedCaseLink);
//	        AssociatedCase = getTextElement(AssociatedCaseLink);
//	        SoftAssert softAssert = new SoftAssert();
//			softAssert.assertTrue(AssociatedCase.equals(CaseNumberLinked));
//			softAssert.assertAll();
//	    }

//	    public  void CreateAndLinkCase_VerifyDirectionToAssociatedCase( ) throws InterruptedException {
//	        waitUntilElementIsVisible(AssociatedCaseLink);
//	        AssociatedCase2 = getTextElement(AssociatedCaseLink);
//	        waitForElementIsInteractable(AssociatedCaseLink);
//	        clickByJsExecuter(AssociatedCaseLink);
//	        forcedWaitTime(3);
//	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//	        waitForPageLoadTime(4);
//	        driver.switchTo().window((String) tabs.get(2));
//	        waitUntilElementIsVisible(LinkedCaseNumber);
//	        String CaseNumberSplit[] = getTextElement(LinkedCaseNumber).split("#");
//	        CaseNumberLinked = CaseNumberSplit[1];
//	        SoftAssert softAssert = new SoftAssert();
//			softAssert.assertTrue(CaseNumberLinked.equals(AssociatedCase2));
//			softAssert.assertAll();
//	    }


    public void CreateAndLinkCase_VerifyDirectionToAssociatedSubmission() throws InterruptedException {
        waitUntilElementIsVisible(LinkedCaseNumber);
        String CaseNumberSplit[] = getTextElement(LinkedCaseNumber).split("#");
        CaseNumberLinked = CaseNumberSplit[1];
        waitForElementIsInteractable(AssociatedSubmissionLink);
        clickByJsExecuter(AssociatedSubmissionLink);
        forcedWaitTime(3);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        waitForPageLoadTime(4);
        driver.switchTo().window((String) tabs.get(1));
        Thread.sleep(3000);
        waitUntilElementIsVisible(AssociatedCaseLink);
        AssociatedCase = getTextElement(AssociatedCaseLink);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(AssociatedCase.equals(CaseNumberLinked));
        softAssert.assertAll();
    }


    public void CreateAndLinkCase_VerifyDirectionToAssociatedCase() throws InterruptedException {
        waitUntilElementIsVisible(AssociatedCaseLink);
        AssociatedCase2 = getTextElement(AssociatedCaseLink);
        waitForElementIsInteractable(AssociatedCaseLink);
        clickByJsExecuter(AssociatedCaseLink);
        forcedWaitTime(3);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        waitForPageLoadTime(4);
        driver.switchTo().window((String) tabs.get(2));
        waitUntilElementIsVisible(LinkedCaseNumber);
        String CaseNumberSplit[] = getTextElement(LinkedCaseNumber).split("#");
        CaseNumberLinked = CaseNumberSplit[1];
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(CaseNumberLinked.equals(AssociatedCase2));
        softAssert.assertAll();
    }
}
