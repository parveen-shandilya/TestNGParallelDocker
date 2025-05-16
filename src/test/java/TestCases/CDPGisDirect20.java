package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import POM.CCPDirect20Utility;
import POM.CCPUtility;
import POM.CDPDirect20GisUtility;
import POM.CDP_Utility;
import POM.LoginUtility;

public class CDPGisDirect20 extends BrowsersInvoked {
	
	
	CDPDirect20GisUtility CDPGisDirect20Utils;
	CCPDirect20Utility CCPDirect20Utils;
	CECommonMethods ce;
	CRMCommonMethods crm;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
    	ce = new CECommonMethods(getDriver());
		CDPGisDirect20Utils= new CDPDirect20GisUtility(getDriver());
		CCPDirect20Utils= new CCPDirect20Utility(getDriver());
		crm= new CRMCommonMethods(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
	
	
	@Test(priority = -1, description = "Login Test Case")
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
	
	 @Test(priority=0, description="Verify that options appear under appropriate sections after clicking on 'Edit' icon and entering any address in 'Search' field of location tile on CDP, only when  GIS 2.0 is selected from admin agency settings")
	   public void CDPGis_EditLocationonSearchLocationCDP() throws InterruptedException{
	        CCPDirect20Utils.CCP_CreateCaseWithGISDataAddress();
	        CDPGisDirect20Utils.EditLocationonSearchLocationCDP();
	        
	    }

	    @Test(priority=1, description="Verify that options appear under appropriate sections after clicking on 'Edit' icon and pin a location tile on CDP, only when  GIS 2.0 is selected from admin agency settings")
	   public void CDPGis_EditLocationonPinCDP()throws InterruptedException{
	        CDPGisDirect20Utils.EditLocationonPinCDP();
	       
	    }


	    @Test(priority=2, description="Verify that the 'GIS Validated' status appears on the 'Location' tile after selecting the address from the 'APN' section , on CDP")
	   public void CDPGis_EditLocationonPinGISValidatedButtonAppearCDP()throws InterruptedException{
	        CDPGisDirect20Utils.EditLocationonPinGISValidatedButtonAppearCDP();
	        
	    }


	    @Test(priority=3, description="Verify that the 'GIS Validated' status appears on the 'Location' tile after searching APN on Location tile , on CDP")
	   public void CDPGis_EditLocationonSearchAPNGISValidatedButtonAppearCDP()throws InterruptedException{
	        CDPGisDirect20Utils.EditLocationonSearchAPNGISValidatedButtonAppearCDP();
	        
	    }


	    @Test(priority=4, description="Verify that the user able to validate the address on CDP,When Address select from GIS Data Address.")
	   public void CDPGis_VerifyUserAbletoValidateAddressWithGISDataAddressOnCDP()throws InterruptedException{
	        CDPGisDirect20Utils.VerifyUserAbletoValidateAddressWithGISDataAddressOnCDP();
	       
	    }

	    @Test(priority=5, description="Verify that the user able to validate the address on CDP,When Address select from GIS APN Address.")
	   public void CDPGis_VerifyUserAbletoValidateAddressWithGISAPNAddressOnCDP()throws InterruptedException{
	        CDPGisDirect20Utils.VerifyUserAbletoValidateAddressWithGISAPNAddressOnCDP();
	       
	    }


	    @Test(priority = 6, description="Verify that the user able to validate the address on CDP,When Address Added Manually.")
	   public void CDPGis_ValidatedManuallyAddedAddressOnCDP()throws InterruptedException{

	        CDPGisDirect20Utils.ValidatedManuallyAddedAddressOnCDP();
	       
	    }


	    @Test(priority = 7, description="Verify that the user able to validate the address on CDP,When Address is Pinned on the map")
	   public void CDPGis_ValidatedAddressOnWithPinLocationCDP()throws InterruptedException{

	        CDPGisDirect20Utils.ValidatedAddressOnWithPinLocationCDP();
	       
	    }



	
	

}
