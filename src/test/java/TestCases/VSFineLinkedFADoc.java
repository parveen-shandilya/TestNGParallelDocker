package TestCases;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;
import POM.AppPreRequisiteUtility;
import POM.CDP_Utility;
import POM.FinesUtility;
import POM.ForcedAbatementUtility;
import POM.LoginUtility;

public class VSFineLinkedFADoc extends BrowsersInvoked {

	
	ITestResult result;
	FinesUtility fines;
	CECommonMethods ceMethod;
	CRMCommonMethods crmCommonMethod;

	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		fines = new FinesUtility(getDriver());
		ceMethod = new CECommonMethods(getDriver());
		crmCommonMethod = new CRMCommonMethods(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}
	
	public static String ViolationfineName = "VS fine linked to FA doc";
	public static String attachedNotice = "Notice for violation specific linked to FA";
	public static String defaultAmount = "100.00";
	public static String setFineNameLabel;

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		if (BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
		} else {
			log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
		}
	}


	@Test(priority = 1, enabled = true, description = "Verify 'Associated Notice & FA Document' is mandatory while creating violation specific fine when notice is attached")
	public void verifyAssociateNoticeAndFADocumentRequired() throws InterruptedException {
		fines.navigateToCreateFinePageFromDashboard();
		fines.selectViolationSpecifcToggelButton();
		setFineNameLabel = fines.setandReturnValueInLabelField("ViolationSpecific");
		fines.setValueInDefaultAmountField();
		fines.clickCreateFineButtonOnCreateFinePage();
		String actualValidationText = fines.getValidationText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualValidationText, "The Notice is required.", "Validation Message is not Appear");
		softAssert.assertAll();

	}

	@Test(priority = 2, enabled = true, description = "Verify user is able to create violation specific fine with FA doc attached when 'Do not associate a notice' checkbox is unchecked.")
	public void verifyCreateViolationSpecficfineFADocument() throws InterruptedException {
		String nameOfViolationCreated = "Violation" + RandomStrings.requiredCharacters(3);
		String nameOfFaNoticeCreated = "VS Notice FA " + RandomStrings.requiredCharacters(3);
		String fineName = "FineViolationSpecificFA " + RandomStrings.requiredCharacters(3);
		ceMethod.navigateToDashboard();

		fines.navigateToCreateViolationPage();
		fines.createRandomViolation(nameOfViolationCreated);
		ceMethod.navigateToDashboard();
		crmCommonMethod.navigationToNotices();
		ceMethod.creationCustomeFANotices(nameOfFaNoticeCreated,
				PropertiesUtils.getPropertyValue("FANoticeMergeField"));
		Thread.sleep(3000);
		ceMethod.navigateToDashboard();
		fines.navigateToCreateFinePageFromDashboard();
		fines.selectViolationSpecifcToggelButton();
		fines.SelectNoticeAndFAdocument(nameOfFaNoticeCreated);
		fines.SelectViolationSpecification(nameOfViolationCreated);
		fines.setValueInDefaultAmountField("10000");
		fines.setValueInLabelFieldWithoutRandom(fineName);
		fines.clickCreateFineButtonOnCreateFinePage();
		String actualCreatedFine = fines.getCreatedFineText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(fineName, actualCreatedFine, "Fine is not Created or assertion failed.");
		softAssert.assertAll();

	}

	@Test(priority = 3, description = "Verify that violation specific fine with FA document attached appears on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineFADocumentAppearOnFAA() throws InterruptedException {
		// Create Prerequisite Case
		ceMethod.createCaseCCPWithFireViolation();

		// Initiate forceAbatement on Case
		ceMethod.initiateForceAbatement();

		// Add Activity
		ceMethod.clickOnAddActivityBtn();

		// Enter FAA details
		ceMethod.enterFAADetails();

		// Assert FA document with violation specific fine is appeared

		// click on FAA doc select drop down

		// check if FA doc is displayed in first 3 notices else click on dropdown

//		Boolean flag=(getDriver().findElements(By.xpath("//*[text()='" + attachedNotice + "']")).size())>0;
//		Boolean FAADocument;
//		if(flag=true)
//		{
//			fines.selectFAADocumentOnAbatementDetailsSection(attachedNotice);
//			FAADocument=true;
//		}
//		else
//		{
//		ceMethod.clickOnSelectFADocDropdown();
//		ceMethod.searchFADocument(attachedNotice);
//		FAADocument = ceMethod.FAdocumentIsDisplayed();
//		}
		fines.selectFAADocumentOnAbatementDetailsSection("Notice for violation specific linked to FA");
		fines.verifyViolationSpecificFineWithFAIsDisplayed();

	}

	@Test(priority = 4, description = "Verify violation specific fine  name is correctly displayed  on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineAppearWithFADocOnFAA() throws InterruptedException {

		// select FAA document

		String associated_FineName = fines.verifyViolationSpecificFineTextDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(associated_FineName, ViolationfineName,
				"Associated FineName is not present or doesnot matches.");
		softAssert.assertAll();

	}

	@Test(priority = 5, description = "Verify appropriate violation specific fine amount is displayed  on selecting a notice on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineAmountAppearWithFADocOnFAA() throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 6, description = "Verify violation specific fine with notice attached amount gets added on case under the 'Outstanding Balance' section, when user generate FAA document on CDP")
	public void verifyAmountAddOnOutstandingBalance() throws InterruptedException {

		// Generate a document
		ceMethod.clickOnGenerateDocumentBtn();
		ceMethod.clickonDonotPrintBtn();
		ceMethod.clickonGenerateFAAdocuemtn();
		CDP_Utility cdp_Utility = new CDP_Utility(getDriver());
		String outStandingBal = (cdp_Utility.getOutstandingBalance()).split("\\$")[1];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(outStandingBal, defaultAmount,
				outStandingBal + "Associated Fine Amount  is not Equal." + defaultAmount);
		softAssert.assertAll();

	}

	@Test(priority = 7, description = "Verify that applied violation specific fines with notice attached on case appears on the  'All' 'Fines' view of 'Finanace' page.")
	public void verifyFineonFinanacePage() throws InterruptedException {

		// Close Case Details Page
		ceMethod.closeCaseDetailPage();
		defaultAmount = "100.00";
		ceMethod.navigationToFinancePage();
		String alltransactionFine = ceMethod.getFineTransactionGridData();

		ceMethod.clickOnFineToggelBtn();
		String finetransactionFine = ceMethod.getFineTransactionGridData();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(alltransactionFine.contains(ViolationfineName));
		softAssert.assertTrue(finetransactionFine.contains(ViolationfineName));
		softAssert.assertAll();

	}

}
