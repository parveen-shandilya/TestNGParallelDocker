package TestCases;
import BrowsersBase.BrowsersInvoked;
import java.io.IOException;
import java.lang.reflect.Method;

import CommonMethods.CRMCommonMethods;
import POM.CLPUtility;
import POM.CSPInternalGISDirect20Utility;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ExtentReport.ExtentReportClass;
import POM.DashBoardUtility;
import POM.LoginUtility;
import org.testng.asserts.SoftAssert;

public class DashBoard extends BrowsersInvoked{

	DashBoardUtility dashboard ;
	ExtentReportClass extentClass;
	ITestResult result;
	CRMCommonMethods crmCommonMethods;
	CLPUtility clpUtility;

	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		dashboard = new DashBoardUtility(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		clpUtility = new CLPUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

	
	

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
	
	
	
	  @Test(priority = 1, description = "Verify that Admin User is able to view the 'All Staff' Dashboard, on 'Dashboard' page.")
	 public  void tc_Dashboard_ViewAllStaffDashboard() throws InterruptedException {
	        
		  dashboard.tc_Dashboard_ViewAllStaffDashboard();
	      

	    }

	  @Test(priority = 2,description = " Verify that Admin User is able to view the 'User' Dashboard, on 'Dashboard' page. ")
	    public  void tc_Dashboard_ViewMeDashboard() throws InterruptedException {
	        
	       dashboard.tc_Dashboard_ViewMeDashboard();

	    }

	   
	  @Test(priority = 3, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases assigned to me' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_OpenCasesAssignedToMeLink() throws  InterruptedException{
	       
	       dashboard.tc_Dashboard_OpenCasesAssignedToMeLink();
	    }


		@Test(priority = 4 , description ="Verify that accurate count of cases appear on 'Dashboard' page for Escalated Notice For My Agency with respect to CLP.")
		public  void tc_Dashboard_EscalatedNoticesForMyAgency() throws  InterruptedException{
            // CDS-2920
			// the total for tile “X escalated notices for my agency” on the dashboard is wrong
			//* The dashboard in Henderson show “189 escalated notices for my agency”
			//** when you click on it, it only shows two cases
		//	driver.navigate().to(BrowsersInvoked.URLDashboard);
			crmCommonMethods.helper.navigateToURL(BrowsersInvoked.URLDashboard);
			dashboard.scrollIntoView(dashboard.escalatedNoticeLink);
			String countForEscalatedNotices = dashboard.getTextElement(dashboard.escalatedNoticsCount);
		    int expectedCount =	crmCommonMethods.extractedInteger(countForEscalatedNotices);
            dashboard.forcedWaitTime(3);
			dashboard.clickByJsExecuter(dashboard.escalatedNoticeLink);
			dashboard.waitForCurserRunning(3);
			int actualCasesCount = clpUtility.CLP_VerifyTotalCountOfCases();
		    SoftAssert st = new SoftAssert();
			st.assertEquals(actualCasesCount,expectedCount);
			st.assertAll();

		}

	    @Test(priority = 5, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases for my agency' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_OpenCasesForMyAgencyLink() {

	        dashboard.tc_Dashboard_OpenCasesForMyAgencyLink();
	    }

	    @Test(priority = 6, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Overdue Inspections' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_OverdueInspectionsLink() {
	       dashboard.tc_Dashboard_OverdueInspectionsLink();

	    }


	    @Test(priority = 7, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Inspections Due Today' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_InspectionsDueTodayLink() {
	      dashboard.tc_Dashboard_InspectionsDueTodayLink();

	    }


	    @Test(priority = 8, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_TotalInspectionsLink() {
	      dashboard.tc_Dashboard_TotalInspectionsLink();

	    }


	    @Test(priority = 9, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases for my agency' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_AllStaff_OpenCasesForMyAgency() throws InterruptedException {
	        dashboard.tc_Dashboard_AllStaff_OpenCasesForMyAgency();
	    }


	    @Test(priority = 10,description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Overdue Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_TotalcasesForMyAgencyLink() {

	      dashboard.tc_Dashboard_TotalcasesForMyAgencyLink();
	    }


	    @Test(priority = 11, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Inspections Due Today' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_AllStaff_OverdueInspections() {

	        dashboard.tc_Dashboard_AllStaff_OverdueInspections();
	    }

	    @Test(priority = 12, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public void tc_Dashboard_AllStaff_InspectionsDueToday() {
	       dashboard.tc_Dashboard_AllStaff_InspectionsDueToday();

	    }


	    @Test(priority = 13, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_AllStaff_TotalInspectionsLink() {

	       dashboard.tc_Dashboard_AllStaff_TotalInspectionsLink();
	    }


	    @Test(priority = 14, description = " Verify that '<Count> Total Inspections' popup opens up after clicking on the 'Show More' link under '<Count> Total Inspections' section, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void tc_Dashboard_OpenTotalInspectionPopup() {

	        dashboard.tc_Dashboard_OpenTotalInspectionPopup();

	    }


	    @Test(priority = 15, description = " Verify that accurate count of cases appear on 'Dashboard' page with respect to CLP. ")
	    public  void tc_Dashboard_CompareCountOfCasesWithCLP() throws InterruptedException {

	       dashboard.tc_Dashboard_CompareCountOfCasesWithCLP();
	    }


	    @Test(priority = 16, description = " Verify that 'Print Queue' popup opens up, when user clicks on '<count> notices in your print queue' link, on 'Dashboard' page. ")
	    public void tc_Dashboard_OpenPrintQueuePopup() throws InterruptedException {

	    	dashboard.tc_Dashboard_OpenPrintQueuePopup();



	    }

	
	
}
