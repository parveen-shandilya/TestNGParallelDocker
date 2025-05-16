package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CommLinkUtility;
import POM.CreateAndLinkCaseUtility;
import POM.LoginUtility;

public class CreateAndLinkCase extends BrowsersInvoked {
	
	ExtentReportClass extentClass;
	ITestResult result;
	CreateAndLinkCaseUtility createLinkCase;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		createLinkCase = new CreateAndLinkCaseUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

//	@Test(priority = 0)
//	public void LoginAgency() throws InterruptedException {
//		createLinkCase.LoginAgency();
//
//	}

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

	@Test(priority = 1)
	public void CreateAndLinkCase_PreRequisite() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_PreRequisite();

	}

	@Test(priority = 2)
	public void CreateAndLinkCase_OpenCCPToLinkTheCase() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_OpenCCPToLinkTheCase();

	}

	@Test(priority = 3)
	public void CreateAndLinkCase_VerifyAutopopulatedData() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_VerifyAutopopulatedData();

	}

	@Test(priority = 4)
	public void CreateAndLinkCase_VerifyLinkedCase() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_VerifyLinkedCase();

	}

	@Test(priority = 5)
	public void CreateAndLinkCase_VerifyDirectionToAssociatedSubmission() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_VerifyDirectionToAssociatedSubmission();

	}

	@Test(priority = 6)
	public void CreateAndLinkCase_VerifyDirectionToAssociatedCase() throws InterruptedException {
		createLinkCase.CreateAndLinkCase_VerifyDirectionToAssociatedCase();

	}
}
