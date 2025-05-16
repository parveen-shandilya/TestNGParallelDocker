package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.NoticesUtility;

public class Notices extends BrowsersInvoked{
	

	ExtentReportClass extentClass;
	ITestResult result;
	NoticesUtility notice;
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		notice = new NoticesUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
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
	
	@Test(priority = 1,description = "Verify that 'Create Non-HTML Notice' popup opens up, when user clicks on 'Create Non-HTML Notice' button, on 'Notices' page.")
    public void Notices_OpenCreateNonHtmlNoticePopup() throws InterruptedException {
    	notice.Notices_PreRequisite();
    	notice.Notices_OpenCreateNonHtmlNoticePopup(); 
    }
	
	@Test(priority = 2,description = "Verify that user is able to create a Non-HTML Notice, after entering data into all mandatory fields, on 'Notices' page.")
	public void Notices_CreateNonHTMLNotice() throws InterruptedException {
    	notice.Notices_CreateNonHTMLNotice();
    }
	
	@Test(priority = 3,description = "Verify that 'Create HTML Notice' popup opens up, when user clicks on 'Create HTML Notice' button, on 'Notices' page. ")
	public void Notices_OpenCreateHtmlNoticePopup() throws InterruptedException {
    	notice.Notices_OpenCreateHtmlNoticePopup();
    }
	
	@Test(priority = 4,description = "Verify that 'Add Merge Tables' popup opens up, when user clicks on 'Merge Tables' button, on 'Create HTML Notice' popup.")
	public void Notices_OpenAddMergeFieldsPopup() throws InterruptedException {
    	notice.Notices_OpenAddMergeFieldsPopup();
    }
    
	@Test(priority = 5,description = "Verify that user is able to apply filters from 'Category' dropdown list, on 'Add Merge Tables' popup.")
	public void Notices_ApplyCategoryOnMergeFields() throws InterruptedException {
    	notice.Notices_ApplyCategoryOnMergeFields();
    }
	
	@Test(priority = 6,description = "Verify that respective Merge Table gets added to the HTML editor, when user clicks on any Merge Tables link, on 'Add Merge Tables' popup. ")
	public void Notices_VerifyMergeFieldsOnHtmleditor() throws InterruptedException {
    	notice.Notices_VerifyMergeFieldsOnHtmleditor();
    }
	
	@Test(priority = 7,description = " Verify that user is able to Preview the data entered in the HTML editor, on 'Preview Notice' popup.")
	public void Notices_VerifyPreviewPopup() throws InterruptedException {
    	notice.Notices_VerifyPreviewPopup();
    }

	@Test(priority = 8,description = " Verify that user is able to create an HTML Notice of 'Case Notice' type, with a Violation type linked, on 'Notices' page.")
	public void Notices_CreateHtmlCaseNotice() throws InterruptedException {
    	notice.Notices_CreateHtmlCaseNotice();
    }
	
	@Test(priority = 9,description = "Verify that user is able to create an HTML Notice of  'FA Document' type, on 'Notices' page.")
	public void Notices_CreateFADocumentHtmlNotice() throws InterruptedException {
    	notice.Notices_CreateFADocumentHtmlNotice();
    }
    
	@Test(priority = 10,description = "Verify that user is able to edit the added Notices, on 'Notices' page.")
	public void Notices_VerifyEditNotices() throws InterruptedException {
    	notice.Notices_VerifyEditNotices();
    }
	
	@Test(priority = 11,description = "Verify that accurate count of Notices appear, on 'Notices' page.")
	public void Notices_VerifyCountOfNotices() throws InterruptedException {
    	notice.Notices_VerifyCountOfNotices();
    }
	
	@Test(priority = 12,description = "Verify that Notices linked to Violation Types get auto-populated while Performing Inspection.")
	public void Notices_VerifyAutoPopulationOfNotices() throws InterruptedException {
    	notice.Notices_VerifyAutoPopulationOfNotices();
    }
	

}
