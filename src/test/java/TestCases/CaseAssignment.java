package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

//import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.SupervisorUtility;
import ExtentReport.ExtentReportClass;

public class CaseAssignment extends BrowsersInvoked{
	
	
	CaseAssignmentUtility obj ;
	ExtentReportClass extentClass;
	ITestResult result;
		
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
        obj = new CaseAssignmentUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
	
	
	
	
//	@Test(priority = 0,description="Login Test Case")
//	public void LoginTest() throws InterruptedException {
//		obj.LoginAgency();
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

	
	@Test(priority = 1,description=" Verify that 'Edit Assignment' popup opens up after clicking the 'Edit' icon next to 'Case Assignment' rule on the 'Assignment Rules' page. ")
	public void CaseAssignment_OpenEditAssignmentPopup() throws InterruptedException, IOException {
		obj.CaseAssignment_OpenEditAssignmentPopup();
	}

	
	@Test(priority = 2, description =" Verify that user is able to update the 'Name', 'Action' & 'Status' fields on the 'Edit Assignment' popup " )
	public void CaseAssignment_EditFieldsOnEditAssignmentPopup() throws InterruptedException {
	       obj.CaseAssignment_EditFieldsOnEditAssignmentPopup();
		
	}

	
	@Test(priority = 3,description = " Verify that user is not able to save the changes, when no Rule is added under 'Rules Set' tile, on 'Edit Assignment' popup. ")
	public void CaseAssignment_NotAbleToUpdateWithoutRule() throws InterruptedException {
		obj.CaseAssignment_NotAbleToUpdateWithoutRule();
		
	}

	
	@Test(priority = 4, description = " Verify that 'Create Rule' popup opens up, when user clicks the 'Add Rule' button, on 'Edit Assignment' popup. ")
	public void CaseAssignment_OpenCreateRulepopup() throws InterruptedException {
		obj.CaseAssignment_OpenCreateRulepopup();
		
	}

	
	@Test(priority = 5,description = " Verify that the created rule with one or multiple criterias, gets added under 'Rules Set' tile, on 'Edit Assignment' popup. ")
	public void CaseAssignment_CreateRuleWithMultipleCriterias() throws InterruptedException {
		obj.CaseAssignment_CreateRuleWithMultipleCriterias();

	}

	
	@Test(priority = 6, description = " Verify that user is able to edit the added Rules under 'Rules Set' tile, on 'Edit Assignment' popup. ")
	public void CaseAssignment_EditAddedRule() throws InterruptedException {
		obj.CaseAssignment_EditAddedRule();
	}

	
	@Test(priority = 7, description = " Verify that user is able to delete that added Rules under 'Rules Set' tile, on 'Edit Assignment' popup. ")
	public void CaseAssignment_DeleteAddedRule() {
		obj.CaseAssignment_DeleteAddedRule();

	}

	
	@Test(priority = 8,description = " Verify that Assignment Rule appears under 'Inactive' section, when user sets 'Status' toggle button as Inactive, on 'Edit Assignment' popup. ")
	public void CaseAssignment_AssignmentRuleUnderInactiveSection() throws InterruptedException {
	obj.CaseAssignment_AssignmentRuleUnderInactiveSection();

	}

	
	

}
