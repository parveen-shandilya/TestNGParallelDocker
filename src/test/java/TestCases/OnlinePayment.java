package TestCases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.LoginUtility;
import POM.NoticesUtility;
import POM.OnlinePaymentUtility;

public class OnlinePayment extends BrowsersInvoked {

	
	ITestResult result;
	OnlinePaymentUtility op;


	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		op = new OnlinePaymentUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}
	
	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		if(BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
			}
			else {
				log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
			}

	}

	@Test(priority = 1,description = "Create a Online Payment Case Prerequisite ")
	public void OnlinePaymentCasePreRequisite() throws InterruptedException {

		op.OnlinePaymentCasePreRequisite();

	}

	@Test(priority = 2,description = "Copy Payment Portal URL On Citizen Payment Portal")
	public void CopyPaymentPortalURLOnCitizenPaymentPortal()
			throws InterruptedException, IOException, UnsupportedFlavorException {

		op.CopyPaymentPortalURLOnCitizenPaymentPortal();

	}

	@Test(priority = 3,description = "User is able to navigate Payment Portal Page through the link on Citizen Payment Portal Setting page ")
	public void UserNavigateToPaymentPortalThroughLink() throws InterruptedException {
		op.UserNavigateToPaymentPortalThroughLink();

	}

	@Test(priority = 4,description = "Validation message appear when useer click on the search button when the required fields are empty")
	public void CaseDetailsValidationMessageOnPaymentPortal() throws InterruptedException {
		op.CaseDetailsValidationMessageOnPaymentPortal();

	}

	@Test(priority = 5,description = "Verify that the 'No matching case found' validation message appears after clicking on the search button Payment Portal when  case details are not valid")
	public void WrongCaseDetailsValidationMessageOnPaymentPortal() throws InterruptedException {
		op.WrongCaseDetailsValidationMessageOnPaymentPortal();

	}

	@Test(priority = 6,description = "Verify that 'Review Your Outstanding Fines & Fees' page open after entering valid value and click on search on Payment portal Page")
	public void VerifytheReviewOutstandingFeeAndPaymentDatailsPage() throws InterruptedException {
		op.VerifytheReviewOutstandingFeeAndPaymentDatailsPage();

	}

	@Test(priority = 7,description = "Verify that user is able to make payment on  Payment portal Page")
	public void MakeOnlinePayment() throws InterruptedException {
		op.MakeOnlinePayment();

	}

	@Test(priority = 8,description = "Verify that user is able to make payment as void payment on CDP")
	public void UserAbleToMarkPaymentAsVoid() throws InterruptedException {
		op.UserAbleToMarkPaymentAsVoid();

	}

	@Test(priority = 9,description = "Verify that user is able to make void payment on Payment Portal")
	public void UserAbleToMakeVoidPayment() throws InterruptedException, IOException, UnsupportedFlavorException {
		op.UserAbleToMakeVoidPayment();

	}

	@Test(priority = 10,description = "Verify that user is able to make Partial payment")
	public void UserAbleToMakePartialPayment() throws InterruptedException, IOException, UnsupportedFlavorException {
		op.UserAbleToMakePartialPayment();

	}

}
