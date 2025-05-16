package TestCases;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
//import POM.CCPDirect20Utils;
import POM.CCPUtility;
import POM.CSPInternalGISDirect20Utility;
import POM.CSPInternalGISDirect20Utility;
import POM.CSPInternalUtility;
//import POM.CSPInternalUtils;
import POM.CategoryPage;
import POM.LoginUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CSPInternalGISDirect20 extends BrowsersInvoked {

	
	public CSPInternalGISDirect20Utility CSPInternalGISDirect20Utility;
	CSPInternalUtility CSPInternalUtils;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		CSPInternalGISDirect20Utility = new CSPInternalGISDirect20Utility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

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

	public static SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1, description = "Verify that the Address on the right section, after dropping a pin on the CSP, when the Address fields are mapped on the 'Parcel Layer Mappings page")
	public void VerifyPinAddressDetailsMappedWithMappingGISDataCSP() throws InterruptedException {
		CSPInternalGISDirect20Utility.VerifyPinAddressDetailsMappedWithMappingGISDataCSP();
	}

	@Test(priority = 2, description = "Verify that the Address on the right section, after searching on the CSP, when the Address fields are mapped on the 'Parcel Layer Mappings page")
	public void VerifySearchAddressDetailsMappedWithMappingGISDataCSP() throws InterruptedException {
		CSPInternalGISDirect20Utility.VerifySearchAddressDetailsMappedWithMappingGISDataCSP();

	}

	@Test(priority = 3, description = "Verify that 'Add Address Manually' popup opens up, after clicking on 'Add Address Manually' link, on 'Create Submission' page.")
	public void CSP_OpenAddAddressManuallyPopup() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_OpenAddAddressManuallyPopup();

	}

	@Test(priority = 4, description = " Verify that 'Add Address Manually' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Create Submission' page.")
	public void CSP_CloseAddAddressManuallyPopup() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CloseAddAddressManuallyPopup();

	}

//	@Test(priority = 5, description = "Verify that validation messages appear when user clicks on 'Add Address' button without entering data in mandatory fields, on 'Create Submission' popup. ")
//	public void CSP_ValidationMsgForNoAddressDetails() throws InterruptedException {
//		CSPInternalGISDirect20Utility.CSP_ValidationMsgForNoAddressDetails();
//
//	}

	@Test(priority = 6, description = " Verify that the address gets added under 'Select Location' tile, after entering address details manually & clicking on 'Add Address' button, on 'Add Address Manually' popup.")
	public void CSP_AddTheAddressManually() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_AddTheAddressManually();

	}

	@Test(priority = 7, description = " Verify that the GIS Data Address,Comcate Application address and APN section should appear under 'Select Location' tile, after searching any valid address on CSP")
	public void CSP_VerifyGISComacteAPNSectionUnderLocationTile() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifyGISComacteAPNSectionUnderLocationTile();

	}

	@Test(priority = 8, description = "Verify  that the user able to select address appear under comcate application address section on CSP")
	public void CSP_VerifySelectAddressRomComcateApplicationAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySelectAddressRomComcateApplicationAddress();

//
	}

	@Test(priority = 9, description = " Verify that the user able to select address appear under APN section on CSP")
	public void CSP_VerifySelectAddressAPNSection() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySelectAddressAPNSection();

	}

	@Test(priority = 10, description = "Verify that the user able to select address appear under comcate application address section on CSP after pin a location")
	public void CSP_VerifySelectAddressFromComcateApplicationAddressPinAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySelectAddressFromComcateApplicationAddressPinAddress();

	}

	@Test(priority = 11, description = "Verify that the user able to select address appear under APN section on CSP after pin a location")
	public void CSP_VerifySelectAddressAPNSectionPinAddressPinAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySelectAddressAPNSectionPinAddressPinAddress();

	}

	@Test(priority = 12, description = "Verify that the Secondary Unit Number appears below the 'Street Address' field without the 'Secondary Address' label, on the 'Location' pane of CSP.")
	public void CSP_VerifySecondaryUnitNumber() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySecondaryUnitNumber();

	}

	@Test(priority = 13, description = "Verify that address gets updated with the new secondary unit, after adding the new secondary unit in the 'Secondary Address' field, on the 'Location' pane of CSP.")
	public void CSP_VerifySecondaryUnitNumberUpdated() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifySecondaryUnitNumberUpdated();

	}

	@Test(priority = 14, description = "Verify that exclamation mark appears next to the secondary unit after clicking '+ Add Secondary' button, when street address and non-existing secondary unit is entered is entered in the search field under the 'location' tile on CSP.")
	public void CSP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton();

	}

//
	@Test(priority = 15, description = "Verify that the user is able  Validate Address on CSP")
	public void CSP_VerifyValidationAddressOfNotGISValidateAdddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_VerifyValidationAddressOfNotGISValidateAdddress();

	}

	@Test(priority = 17, description = "Verify that the user is able to Create Submission with 'Comacte Address' on CSP")
	public void CSP_CreateCustomerSubmissionWithComcateApplicationAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CreateCustomerSubmissionWithComcateApplicationAddress();

	}

	@Test(priority = 18, description = "Verify that the user is able to Create Submission with 'GIS Data Address' on CSP")
	public void CSP_CreateCustomerSubmissionWithGISDataAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CreateCustomerSubmissionWithGISDataAddress();

	}

	@Test(priority = 19, description = "Verify that the user is able to Create Submission with 'APN' on CSP")
	public void CSP_CreateCustomerSubmissionWithAPNAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CreateCustomerSubmissionWithAPNAddress();

	}

	@Test(priority = 20, description = "Verify that the user is able to Create a Submission with 'APN' on CSP,after Pin a APN Location")
	public void CSP_CreateSubmissionWithAPNDataAddressPinAPNAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CreateSubmissionWithAPNDataAddressPinAPNAddress();

	}

	@Test(priority = 21, description = "Verify that the user is able to Create Submission with 'GIS Data Address' on CSP,after Pin a Location")
	public void CSP_CreateSubmissionWithGISDataPinAPNAddress() throws InterruptedException {
		CSPInternalGISDirect20Utility.CSP_CreateSubmissionWithGISDataPinAPNAddress();

	}

}
