package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CSDPGISDirect20Utility;
import POM.CSDPUtility;
import POM.CSPInternalUtility;
import POM.CategoryPage;
import POM.LoginUtility;
import POM.CSLPGisDirect20Utility;
import POM.CSLPUtility;
import POM.CSPExternalUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CSLPGisDirect20 extends BrowsersInvoked {

	public static SoftAssert softAssert = new SoftAssert();
	
	public CSLPGisDirect20 CSLPGisDirect20;
	ITestResult result;
	CCPUtility ccp;
	CategoryPage category;
	CSPInternalUtility CSPInternalUtils;
	CSLPGisDirect20Utility CSLPGisDirect20Utility;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		CSPInternalUtils = new CSPInternalUtility(getDriver());
		CSLPGisDirect20Utility = new CSLPGisDirect20Utility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

	@Test(priority = -1, description = "Login Test Case")
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

	@Test(priority = 0, description = "Verify that invalid icon appear before the GIS invalid address on CSLP")
	public void CSLP_VerifyAppropriateIconAppearwithInvalidGisAddress() throws InterruptedException {
		CSLPGisDirect20Utility.CSLP_VerifyAppropriateIconAppearwithInvalidGisAddress();

	}

	@Test(priority = 1, description = "Verify that Valid icon appear before the GIS Valid address on CSLP.")
	public void CSLP_VerifyAppropriateIconAppearwithValidGisAddress() throws InterruptedException {
		CSLPGisDirect20Utility.CSLP_VerifyAppropriateIconAppearwithValidGisAddress();
	}
}
