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
import POM.LoginUtility;
import POM.NotificationManagementUtility;
import POM.SLAUtility;

public class SLA extends BrowsersInvoked {
	
	
	ExtentReportClass extentClass;
	ITestResult result;
	SLAUtility sla;
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets getDriver() for this thread
       
        sla = new SLAUtility(getDriver());
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
	
	@Test(priority = 1)
    public  void AgencySetup_SLAPreRequisite() throws InterruptedException {
		sla.AgencySetup_SLAPreRequisite();
        
    }


    @Test(priority = 2)
    public  void AgencySetup_CreateSLAPopupOpenAndClose() throws InterruptedException {
    	sla.AgencySetup_CreateSLAPopupOpenAndClose();
       
    }


    @Test(priority = 3)
    public  void AgencySetup_CreateSLAPopupValidatiions() throws InterruptedException {
    	sla.AgencySetup_CreateSLAPopupValidatiions();
        
    }


    @Test(priority = 4)
    public  void AgencySetup_CreateSLAAddRuleValidations() throws InterruptedException {
    	sla.AgencySetup_CreateSLAAddRuleValidations();
       

    }


    @Test(priority = 5)
    public  void AgencySetup_CreateSLA_AddRule() throws InterruptedException {
    	sla.AgencySetup_CreateSLA_AddRule();
        


    }


    @Test(priority = 6)
    public  void AgencySetup_CreateSLA_EditAddRule() throws InterruptedException {
    	sla.AgencySetup_CreateSLA_EditAddRule();
       

    }

    @Test(priority = 7)
    public  void AgencySetup_CreateSLA() throws InterruptedException {
    	sla.AgencySetup_CreateSLA();
       


    }

    @Test(priority = 8)
    public  void AgencySetup_EditSLA() throws InterruptedException {
    	sla.AgencySetup_EditSLA();
        


    }


    @Test(priority = 9)
    public  void AgencySetup_ErrorMessageAppearCreatingExistingSLAName() throws InterruptedException {
    	sla.AgencySetup_ErrorMessageAppearCreatingExistingSLAName();
        
    }

    @Test(priority = 10)
    public  void AgencySetup_InactivteActiveSLA() throws InterruptedException {
    	sla.AgencySetup_InactivteActiveSLA();
       
    }


    @Test(priority = 11)
    public  void AgencySetup_ActivateInactiveSLA() throws InterruptedException {
        sla.AgencySetup_ActivateInactiveSLA();

        
    }

	
	

}
