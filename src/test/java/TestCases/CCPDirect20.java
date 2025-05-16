package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import POM.CCPDirect20Utility;
import POM.CCPUtility;
import POM.LoginUtility;

public class CCPDirect20 extends BrowsersInvoked {

	
	CCPDirect20Utility CCPDirect20Utils;
	CECommonMethods ce;

	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
       
        CCPDirect20Utils = new CCPDirect20Utility(getDriver());
		ce = new CECommonMethods(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
	
	
	

	public static SoftAssert softAssert = new SoftAssert();

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

	@Test(priority = 1, description = "Verify that the Address on the right section, after dropping a pin on the CCP, when the Address fields are mapped on the 'Parcel Layer Mappings page")
	public void VerifyPinAddressDetailsMappedWithMappingGISData() throws InterruptedException {
		CCPDirect20Utils.VerifyPinAddressDetailsMappedWithMappingGISData();

	}

	@Test(priority = 2, description = "Verify that the Address on the right section, after searching on the CCP, when the Address fields are mapped on the 'Parcel Layer Mappings page")
	public void VerifySearchAddressDetailsMappedWithMappingGISData() throws InterruptedException {
		CCPDirect20Utils.VerifySearchAddressDetailsMappedWithMappingGISData();

	}

	@Test(priority = 3, description = " Verify that 'Add Address Manually' popup opens up, after clicking on 'Add Address Manually' link, on 'Create Case' page. ")
	public void CCP_OpenAddAddressManuallyPopup() throws InterruptedException {

		CCPDirect20Utils.CCP_PreRequisite();
		CCPDirect20Utils.CCP_OpenAddAddressManuallyPopup();

	}

	@Test(priority = 4, description = " Verify that 'Add Address Manually' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Create Case' page. ")
	public void CCP_CloseAddAddressManuallyPopup() throws InterruptedException {
		CCPDirect20Utils.CCP_CloseAddAddressManuallyPopup();

	}

	//Disabled test cases as functionality is changed and scenario is no longer valid
	@Test(priority = 5,enabled = false,description = " Verify that validation messages appear when user clicks on 'Add Address' button without entering data in mandatory fields, on 'Create Case' popup.  ")
	public void CCP_ValidationMsgForNoAddressDetails() throws InterruptedException {
		String ValidMsgExpected = "The Address is required.";
		CCPDirect20Utils.CCP_ValidationMsgForNoAddressDetails();

	}

	@Test(priority = 6, description = " Verify that the address gets added under 'Select Location' tile, after entering address details manually & clicking on 'Add Address' button, on 'Add Address Manually' popup. ")
	public void CCP_AddTheAddressManually() throws InterruptedException {
		CCPDirect20Utils.CCP_AddTheAddressManually();

	}

	@Test(priority = 7, description = " Verify that the GIS Data Address,Comcate Application address and APN section should appear under 'Select Location' tile, after searching any valid address on CCP")
	public void CCP_VerifyGISComacteAPNSectionUnderLocationTile() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifyGISComacteAPNSectionUnderLocationTile();

	}

	@Test(priority = 8, description = " Verify that the user able to select address appear under comcate application address section on CCP")
	public void CCP_VerifySelectAddressRomComcateApplicationAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySelectAddressRomComcateApplicationAddress();

	}

	@Test(priority = 9, description = " Verify that the user able to select address appear under APN section on CCP")
	public void CCP_VerifySelectAddressAPNSection() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySelectAddressAPNSection();

	}

	@Test(priority = 10, description = " Verify that the user able to select address appear under comcate application address section on CCP after pin a location")
	public void CCP_VerifySelectAddressFromComcateApplicationAddressPinAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySelectAddressFromComcateApplicationAddressPinAddress();

	}

	@Test(priority = 11, description = " Verify that the user able to select address appear under APN section on CCP after pin a location")
	public void CCP_VerifySelectAddressAPNSectionPinAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySelectAddressAPNSectionPinAddressPinAddress();

	}

	@Test(priority = 12, description = "Verify that the Secondary Unit Number appears below the 'Street Address' field without the 'Secondary Address' label, on the 'Location' pane of CCP.")
	public void CCP_VerifySecondaryUnitNumber() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySecondaryUnitNumber();

	}

	@Test(priority = 13, description = "Verify that address gets updated with the new secondary unit, after adding the new secondary unit in the 'Secondary Address' field, on the 'Location' pane of CCP.")
	public void CCP_VerifySecondaryUnitNumberUpdated() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifySecondaryUnitNumberUpdated();

	}

	@Test(priority = 14, description = "Verify that exclamation mark appears next to the secondary unit after clicking '+ Add Secondary' button, when street address and non-existing secondary unit is entered is entered in the search field under the 'location' tile on CCP.")
	public void CCP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifyAddSecUnitNumberUsingPlusAddSecondaryButton();

	}

	@Test(priority = 15, description = "Verify that the user is able  Validate Address on CCP")
	public void CCP_VerifyValidationAddressOfNotGISValidateAdddress() throws InterruptedException {
		CCPDirect20Utils.CCP_VerifyValidationAddressOfNotGISValidateAdddress();

	}

	@Test(priority = 16, description = "Verify that the user is able to Create Case with 'Comacte Address' on CCP")
	public void CCP_CreateCaseWithComcateApplicationAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_CreateCaseWithComcateApplicationAddress();

	}

	@Test(priority = 17, description = "Verify that the user is able to Create a Case with 'GIS Data Address' on CCP")
	public void CCP_CreateCaseWithGISDataAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_CreateCaseWithGISDataAddress();

	}

	@Test(priority = 18, description = "Verify that the user is able to Create a Case with 'APN' on CCP")
	public void CCP_CreateCaseWithAPNDataAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_CreateCaseWithAPNDataAddress();

	}

	@Test(priority = 19, description = "Verify that the user is able to Create a Case with 'APN' on CCP,after Pin a APN Location")
	public void CCP_CreateCaseWithAPNDataAddressPinAPNAddress() throws InterruptedException {
		CCPDirect20Utils.CCP_CreateCaseWithAPNDataAddressPinAPNAddress();

	}

	@Test(priority = 20, description = "Verify that the user is able to Create a Case with 'APN' on CCP,after Pin a Location")
	public void CCP_CreateCaseWithAPNDataAddressPinGISDataddress() throws InterruptedException {
		CCPDirect20Utils.CCP_CreateCaseWithAPNDataAddressPinGISDataddress();

	}

}
