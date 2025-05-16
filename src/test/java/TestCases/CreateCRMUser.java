package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CLPUtility;
import POM.CSPExternalUtility;
import POM.CaseAssignmentUtility;
import POM.CloseCaseUtility;
import POM.CreateAndLinkCaseUtility;
import POM.CreateCRMUserUtility;
import POM.ForcedAbatementUtility;
import POM.LoginUtility;
import POM.PerformInspectionUtility;
import POM.ReopenCasesUtility;

public class CreateCRMUser extends BrowsersInvoked{
	
	
	CreateCRMUserUtility crmUser ;
	ExtentReportClass extentClass;
	ITestResult result;
	
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		crmUser = new CreateCRMUserUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}
	
	
	
//	@Test(priority =0)
//	public void LoginAgency() throws InterruptedException {
//		crmUser.LoginAgency();
//
//	}
	
	
	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
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
	
	
	
	
	@Test(priority = 1)
	public void CreateCRMUser_CreateStandardUser() throws InterruptedException {
		
		crmUser.CreateCRMUser_CreateStandardUser();
		
		
	}

	@Test(priority = 2)
	public void CreateCRMUser_CreateProductAdminUser() throws InterruptedException {
		
		crmUser.CreateCRMUser_CreateProductAdminUser();
	
	}

	@Test(priority = 3)
	public void CreateCRMUser_UpdateCEOnlyUserToCRMOnly() throws InterruptedException {
		
		crmUser.CreateCRMUser_UpdateCEOnlyUserToCRMOnly();
		
	}

//	@Test(priority = 4)
//	public void CreateCRMUser_VerifyCRMProductAccessToCRMUser() throws InterruptedException, AWTException {
//
//		crmUser.CreateCRMUser_VerifyCRMProductAccessToCRMUser();
//
//	}

	@Test(priority = 5)
	public void CreateCRMUser_VerifyNoCEAccessToCRMOnlyUser() throws InterruptedException, AWTException {
		
		crmUser.CreateCRMUser_VerifyNoCEAccessToCRMOnlyUser();
		
	}
	
	
	

	
	

}
