package TestCases;

import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.DateAndTime;
import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import ExtentReport.ExtentReportClass;

import static POM.CloseCaseUtility.*;


public class CloseCase extends BrowsersInvoked {

	
	CloseCaseUtility closeCaseObj;
	ExtentReportClass extentClass;
	ITestResult result;
	CRMCommonMethods crmCommonMethods;
	CLPUtility clpUtility;
	PerformInspectionUtility performInspectionUtility;
	CSDPUtility csdp;
	DateAndTime dateAndTime;

	FinesUtility fines;
	CDP_Utility cdp;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
        closeCaseObj = new CloseCaseUtility(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		performInspectionUtility = new PerformInspectionUtility(getDriver());
		clpUtility = new CLPUtility(getDriver());
		csdp = new CSDPUtility(getDriver());
		dateAndTime = new DateAndTime(getDriver());
		fines = new FinesUtility(getDriver());
		cdp = new CDP_Utility(getDriver());
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
				System.out.println("logged in with "+BrowsersInvoked.AgencyCEUsername);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
			}
			else {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
			}

	}

	@Test(priority =1,description =" CloseCase_ConfirmationPopupForCloseCaseValidViolations " )
	public void CloseCase_PreRequisite() throws InterruptedException {
		closeCaseObj.CloseCase_PreRequisite();

	}


	
	@Test(priority =2,description = " Verify that 'Close Case' popup opens up, when user selects 'Close Case' option, after clicking on 'More' button, on CDP. ")
	public void CloseCase_OpenCloseCasePopup() throws InterruptedException {

		closeCaseObj.CloseCase_OpenCloseCasePopup();
		SoftAssert s135 = new SoftAssert();
		s135.assertEquals(CCPopupText, "Close Case");
		s135.assertAll();

	}



	@Test(priority =3,description =" Verify that 'Close Case' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Verify Violations' section. " )
	public void CloseCase_CloseCloseCasePopup() throws InterruptedException {

		closeCaseObj.CloseCase_CloseCloseCasePopup();

	}


	@Test(priority =4, description =" Verify that 'Voluntary' toggle button appears selected by default, on 'Close Case' popup. " )
	public void CloseCase_VerifyVoluntaryToggleBtnState() throws InterruptedException {

		closeCaseObj.CloseCase_VerifyVoluntaryToggleBtnState();

	}


	@Test(priority =5, description =" Verify that user is able to select 'Forced' toggle button, on 'Close Case' popup. " )
	public void CloseCase_SelectForcedToggleBtn() throws InterruptedException {
		closeCaseObj.CloseCase_SelectForcedToggleBtn();
	}


	

	@Test(priority =6,description =" Verify that 'Closed' status appears after Case gets closed, when user clicks on 'Close Case' button, on 'Close Case' popup. " )
	public void CloseCase_VerifyClosedStatus() throws InterruptedException {

		// closing an existing open case
		closeCaseObj.CloseCase_VerifyClosedStatus();
	}

	@Test(priority = 7, description = " CloseCase_ConfirmationPopupForCloseCaseValidViolations ")
	public void CloseCase_PreRequisiteCaseCreationForCloseCase() throws InterruptedException {
		closeCaseObj.CloseCase_PreRequisiteCaseCreationForCloseCase();
	}

	@Test(priority = 8, description = " Verify that confirmation popup opens up, when user clicks on 'Complete Inspection & Close Case' button for invalid violations, under 'Verify Violations' section. ")
	public void CloseCase_ConfirmationPopupForCloseCaseInvalidViolations() throws InterruptedException {

		closeCaseObj.CloseCase_ConfirmationPopupForCloseCaseInvalidViolations();

	}

	@Test(priority = 9, description = " Verify that confirmation popup gets closed, when user clicks on 'Cancel' button, under 'Verify Violations' section. ")
	public void CloseCase_CloseConfirmationPopupForCloseCase() throws InterruptedException {

		closeCaseObj.CloseCase_CloseConfirmationPopupForCloseCase();

	}

	@Test(priority = 10, description = " Verify that 'Closed' status appears after Case gets closed, when user clicks on 'Yes' button, on 'Close Case' popup. ")
	public void CloseCase_VerifyClosedStatusViaPerformInspection() throws InterruptedException {

		closeCaseObj.CloseCase_VerifyClosedStatusViaPerformInspection();
	}

	@Test(priority = 11, description = " Verify that user is able to close the case for valid violations, after clicking on 'Complete Inspection & Close Case' button > 'Close Case' button, on 'Close Case' popup. ")
	public void CloseCase_CloseCasewithValidViolations() throws InterruptedException {

		closeCaseObj.CloseCase_CloseCasewithValidViolations();

	}
	
	@Test(priority = 12 ,description = "Verify closed case is not displayed when filter is applied to display only opened cases")
	public void CloseCase_VerifyOpendStatusApplyFilter() throws InterruptedException {
		crmCommonMethods.clickCasesHeader();
		clpUtility.selectCaseStatusOnCLP("Open");
		clpUtility.waitUntilElementIsVisible(CSLPUtility.CSLPSearchField);
		clpUtility.sendKeysWithWait(CSLPUtility.CSLPSearchField,caseId1AfterExtraction);
		clpUtility.waitForCurserRunning(3);
		clpUtility.forcedWaitTime(3);
		SoftAssert st = new SoftAssert();
		st.assertEquals(clpUtility.getTextElement(CLPUtility.CLPmessage),"No cases to display");
		st.assertAll();
	}

	@Test(priority = 13, description= "To verify user is able to generate notice out of inspection on closed case")
	public void CloseCase_GenerateNoticeOnCloseCase()throws InterruptedException{
		//CloseCase_PreRequisiteCaseCreationForCloseCase();
		clpUtility.selectCaseStatusOnCLP("Open");
		clpUtility.forcedWaitTime(3);
		clpUtility.selectCaseStatusOnCLP("Close");
		clpUtility.forcedWaitTime(3);
		clpUtility.clickByJsExecuter(By.xpath("//div[normalize-space()='"+caseId1AfterExtraction+"']//a"));
		clpUtility.waitForCurserRunning(4);
		clpUtility.scrollIntoView(clpUtility.generateNoticeButton);
		clpUtility.waitUntilElementIsVisible(clpUtility.generateNoticeButton);
		clpUtility.clickByJsExecuter(clpUtility.generateNoticeButton);
		clpUtility.waitUntilElementIsVisible(clpUtility.continueNoticeButton);
		//Thread.sleep(2000);
		clpUtility.scrollIntoView(clpUtility.continueNoticeButton);
		clpUtility.clickOn(clpUtility.continueNoticeButton);
		clpUtility.waitForCurserRunning(3);
		fines.selectNoticeOnGenerateNoticeOutOfInspection("HTML Mandatory Notice");
        clpUtility.forcedWaitTime(3);
		String associatedFineActual = clpUtility.getTextElement(clpUtility.AssociatedFine);
		System.out.println(associatedFineActual);
		clpUtility.scrollIntoView(clpUtility.continueNoticeButton2);
		clpUtility.clickByJsExecuter(clpUtility.continueNoticeButton2);
        clpUtility.forcedWaitTime(2);
		clpUtility.scrollIntoView(clpUtility.continueNoticeButton3);
		clpUtility.clickByJsExecuter(clpUtility.continueNoticeButton3);
		clpUtility.waitForCurserRunning(3);
		clpUtility.clickByJsExecuter(performInspectionUtility.DoNotPrintBtn);
		clpUtility.clickByJsExecuter(clpUtility.genrateAndApplyNotices);
        clpUtility.waitForCurserRunning(3);
        


		SoftAssert st = new SoftAssert();
		st.assertEquals(associatedFineActual ,"HTML Mandatory Notice Fine");
		st.assertEquals(clpUtility.getTextElement(By.xpath("//h4[normalize-space()='HTML Mandatory Notice']")),"HTML Mandatory Notice");
        st.assertAll();
        cdp.clickByJsExecuter(cdp.crossIconCDP);
        cdp.waitForCurserRunning(5);
        Thread.sleep(5000);
	}


}
