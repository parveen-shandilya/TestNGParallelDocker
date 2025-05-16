package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.DateAndTime;
import POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CSDPInternalGISDirect20 extends BrowsersInvoked {

	
	public CSDPGISDirect20Utility csdpGISDirect20Utility;
	CCPUtility ccp;
	CCPDirect20Utility CCPDirect20Utils;
	CategoryPage category;
	CSPInternalUtility CSPInternalUtils;
	CRMCommonMethods crmCommonMethods;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
	
		CSPInternalUtils = new CSPInternalUtility(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		CCPDirect20Utils = new CCPDirect20Utility(getDriver());
		csdpGISDirect20Utility = new CSDPGISDirect20Utility(getDriver());
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

	@Test(priority = 0, description = "Verify that options appear under appropriate sections after clicking on 'Edit' icon and entering any address in 'Search' field of location tile on CSDP, only when  GIS 2.0 is selected from admin agency settings")
	public void EditLocationonSearchLocationCDP() throws InterruptedException {
		crmCommonMethods.CRM_CreateSubmissionCustomeAddress("No", "Yes", "Yes", "Yes", "Yes", "Location Required",
				CCPDirect20Utils.gisDataAddress, false, false);
		System.out.println("CRM_CreateSubmissionCustomeAddress successfully runnn");
		csdpGISDirect20Utility.EditLocationonSearchLocationCSDP();

	}

	@Test(priority = 1, description = "Verify that options appear under appropriate sections after clicking on 'Edit' icon and pin a location tile on CSDP, only when  GIS 2.0 is selected from admin agency settings")
	public void EditLocationonPinCSDP() throws InterruptedException {
		csdpGISDirect20Utility.EditLocationonPinCSDP();

	}

	@Test(priority = 2, description = "Verify that the 'GIS Validated' status appears on the 'Location' tile after selecting the address from the 'APN' section , on CSDP")
	public void EditLocationonPinGISValidatedButtonAppearCSDP() throws InterruptedException {
		csdpGISDirect20Utility.EditLocationonPinGISValidatedButtonAppearCSDP();

	}

	@Test(priority = 3, description = "Verify that the 'GIS Validated' status appears on the 'Location' tile after searching APN on Location tile , on CSDP")
	public void EditLocationonSearchAPNGISValidatedButtonAppearCSDP() throws InterruptedException {
		csdpGISDirect20Utility.EditLocationonSearchAPNGISValidatedButtonAppearCSDP();

	}

	@Test(priority = 4, description = "Verify that the user able to validate the address on CSDP,When Address select from GIS Data Address.")
	public void VerifyUserAbletoValidateAddressWithGISDataAddressOnCSDP() throws InterruptedException {
		csdpGISDirect20Utility.VerifyUserAbletoValidateAddressWithGISDataAddressOnCSDP();

	}

	@Test(priority = 5, description = "Verify that the user able to validate the address on CSDP,When Address select from GIS APN Address.")
	public void VerifyUserAbletoValidateAddressWithGISAPNAddressOnCSDP() throws InterruptedException {

		csdpGISDirect20Utility.VerifyUserAbletoValidateAddressWithGISAPNAddressOnCSDP();

	}

	@Test(priority = 6, description = "Verify that the user able to validate the address on CSDP,When Address Added Manually.")
	public void ValidatedManuallyAddedAddressOnCSDP() throws InterruptedException {

		csdpGISDirect20Utility.ValidatedManuallyAddedAddressOnCSDP();

	}

	@Test(priority = 7, description = "Verify that the user able to validate the address on CSDP,When Address is Pinned on the map")
	public void ValidatedAddressOnWithPinLocationCSDP() throws InterruptedException {

		csdpGISDirect20Utility.ValidatedAddressOnWithPinLocationCSDP();

	}

}
