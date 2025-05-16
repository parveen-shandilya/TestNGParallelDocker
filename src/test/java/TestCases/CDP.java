package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import POM.CCPDirect20Utility;
import POM.CCPUtility;
import POM.CDP_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CDP_Utility;
import POM.LoginUtility;
import POM.NoticesUtility;
import org.testng.asserts.SoftAssert;

public class CDP extends BrowsersInvoked {

	
	ExtentReportClass extentClass;
	ITestResult result;
	CDP_Utility cdp;
	CCPUtility ccpUtility;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
        cdp = new CDP_Utility(getDriver());
		ccpUtility = new CCPUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }
	

	
	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
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
	 @Test(priority = 1, description = "Case Detail Page PreRequisite.")
	    public void cdp_CaseDetailPagePreRequisite() throws InterruptedException{

	        cdp.cdp_CaseDetailPagePreRequisite();
	        

	    }

		@Test(priority = 2 ,description = "Verify that user is able to Flaged the Location on CDP")
	 public void cdp_UserAbleToFlaggedLocation() throws InterruptedException {
		     //  This test case cover all 3 bugs (CDS-441, CDS-2103 , CDS-2897 )
			// You can’t unflag a location. There is no error the application does not seem to take the note. Case CE-23-6143
			cdp.waitForElementIsInteractable(ccpUtility.locationDropdown);
			cdp.clickOn(ccpUtility.locationDropdown);
			cdp.checkFlagOrNot();

//		cdp.clickOn(ccpUtility.locationDropdown);
		cdp.waitUntilElementIsVisible(ccpUtility.FlagToggle);
		try {
		cdp.clickOn(ccpUtility.FlagToggle);
		}
		catch(Exception e)
		{
			cdp.waitForElementIsInteractable(ccpUtility.FlagToggle);
			cdp.clickByJsExecuter(ccpUtility.FlagToggle);
		}
		cdp.sendKeysWithWait(ccpUtility.reasonForFlagging,"Flagged Location");
		cdp.waitForElementIsInteractable(ccpUtility.FlagAddressBtn);
		cdp.clickOn(ccpUtility.FlagAddressBtn);
		cdp.waitForCurserRunning(3);
		//checking the location is Flaaged or not .
		Boolean actualFlaaged = cdp.elementIsDisplayed(ccpUtility.flaggedChip);
		SoftAssert st = new SoftAssert() ;
		st.assertTrue(actualFlaaged);
		st.assertAll();
	}

		@Test(priority = 3 ,description = "Verify that user is able to unFlaged the Location on CDP ")
		//  This test case cover all 3 bugs (CDS-441, CDS-2103 , CDS-2897 )
		public void cdp_UserAbleToUnFlaggedLocation() throws InterruptedException {
		  cdp.waitUntilElementIsVisible(ccpUtility.FlagToggle);
		  cdp.clickOn(ccpUtility.FlagToggle);
		  cdp.sendKeysWithWait(ccpUtility.reasonForFlagging,"UnFlagged Location");
	      cdp.waitForElementIsInteractable(ccpUtility.unFlagAddressBtn);
		  cdp.clickOn(ccpUtility.unFlagAddressBtn);
		  cdp.waitForCurserRunning(3);
		   //checking the location is unFlaaged or not .

			SoftAssert st = new SoftAssert() ;
          Boolean flagged = cdp.findElementsSize(ccpUtility.flaggedChip)>0;
			System.out.println(flagged);
		    st.assertFalse(flagged);
			st.assertAll();
	 }






	    @Test(priority = 4, description = "Verify that user is able to change or update the assignee on CDP. ")
	    public void cdp_UserAbleToChangeAssignee() throws InterruptedException{

	        cdp.cdp_UserAbleToChangeAssignee();


	    }

	    @Test(priority = 5,description = "Verify that User gets directed to the Time Tracking popup after clicking on the 'Time Tracking' link under 'Hours logged' section on the CDP.")
	    public void cdp_VerifyUserDirectedToTimeTracking() throws InterruptedException{
	        cdp.cdp_VerifyUserDirectedToTimeTracking();


	    }


	    @Test(priority = 6, description = "Verify that User is able to add time log on the 'Time Tracking' popup.")
	    public void cdp_VerifyUserAbleToAddTimeLogOnTimeTracking() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleToAddTimeLogOnTimeTracking();


	    }

	    @Test(priority = 7, description = "Verify that User is able to delete added time log on the 'Time Tracking' popup.")
	    public void cdp_VerifyUserAbleToDeleteAddedLogTime() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleToDeleteAddedLogTime();


	    }

	    @Test(priority = 8,description = "Verify that the 'Abatement Activities' tile appears in expand view on opening the CDP.")
	    public void cdp_VerifyAbatementActivityTile() throws InterruptedException{
	    	cdp.cdp_VerifyAbatementActivityTile();


	    }

	    @Test(priority = 9,description = "Verify that Admin User is able to edit the contact after clicking the 'Edit' icon next to that contact under the 'Contacts' tile.")
	    public void cdp_VerifyUserAbletoEditContact() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoEditContact();


	    }

	    @Test(priority = 10, description = "Verify that User is able to delete the contact under the 'Contacts' tile.")
	    public void cdp_VerifyUserAbletoDeleteContact() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoDeleteContact();


	    }


	    @Test(priority = 11,description = "Verify that User is able to add new contact under the 'Contacts' tile.")
	    public void cdp_VerifyUserAbletoAddNewContact() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoAddNewContact();

	    }


//	    @Test(priority = 10,description ="Verify that Admin User is able to check the 'Bill To Contact' checkbox under the 'Contacts' tile on the CDP.")
//	    public void cdp_VerifyUserAbletoSelectetheContactAsBilltoContact() throws InterruptedException{
//	    	cdp.cdp_VerifyUserAbletoSelectetheContactAsBilltoContact();
//	    }
//
//	    @Test(priority = 11)
//	    public void cdp_VerifyUserAbletoUpdateCustomeTileFields() throws InterruptedException{
//	    	cdp.cdp_VerifyUserAbletoUpdateCustomeTileFields();
//
//
//	    }


	    @Test(priority = 12,description = "Verify that Admin User is able to add multiple photos and attachments under 'Photos & Attachments' section on the CDP.")
	    public void cdp_VerifyUserAbletoAddMultipleAttachment() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoAddMultipleAttachment();

	    }

	    @Test(priority = 13, description = "Verify that Admin User is able to delete the added images under 'Photos & Attachments' section.")
	    public void cdp_VerifyUserAbletoDeleteAttachment() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoDeleteAttachment();

	    }


	    @Test(priority = 14,description = "Verify that Admin User is able to print the added images under 'Photos & Attachments' section.")
	    public void cdp_VerifyUserAblePrintSelectedAttatchment() throws InterruptedException{
	    	cdp.cdp_VerifyUserAblePrintSelectedAttatchment();

	    }

	    @Test(priority = 15,description = "Verify that Admin User is able to download the added attachments under 'Photos & Attachments' section.")
	    public void cdp_VerifyUserAbleDownloadSelectedAttatchment() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleDownloadSelectedAttatchment();

	    }

	    @Test(priority = 16,description = "Verify that User is able to generate notice outside of inspection after clicking the 'Generate Notice' button on the CDP.")
	    public void cdp_VerifyUserAbleGenerateNoticeOutsideofInspection() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleGenerateNoticeOutsideofInspection();

	    }

	    @Test(priority = 17,description = "Verify that User is able to delete notice on the CDP.")
	    public void cdp_VerifyUserAbleToDeleteNotice() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleToDeleteNotice();

	    }


	    @Test(priority = 18,description = "Verify that User is able to 'Delete and Reissue' notice on the CDP.")
	    public void cdp_VerifyUserAbleToDeleteAndReissueNotice() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleToDeleteAndReissueNotice();

	    }

	    @Test(priority = 19,description = "Verify that User is able to apply outside inspection generated notice on the CDP.")
	    public void cdp_VerifyUserAbleApplyNoticeOutsideofInspection() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbleApplyNoticeOutsideofInspection();

	    }

	    @Test(priority = 20,description = "Verify Case history should be displayed after clicking on view case history on case summary header.")
	    public void cdp_VerifyCaseHistory() throws InterruptedException{
	    	cdp.cdp_VerifyCaseHistory();


	    }

	    @Test(priority = 21,description = "Verify that Admin User is able to print the case after clicking the 'Print' button on the CDP.")
	    public void cdp_VerifyPrintCaseDetailsPage() throws InterruptedException{
	    	cdp.cdp_VerifyPrintCaseDetailsPage();

	    }

	    @Test(priority = 22,description = "Verify that Admin User is able to edit the entity details of a violation after clicking on the 'Edit' icon next to that Entity under the 'Violations' tile.")
	    public void cdp_VerifyUserAbletoEditviolationsonCDP() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoEditviolationsonCDP();

	    }


	    @Test(priority = 23, description = "Veirfy add payment from fines & payment details.")
	    public void cdp_VerifyAddPaymentFromFineAndPaymentDetalis() throws InterruptedException{
	    	
	    	
	    	cdp.cdp_VerifyAddPaymentFromFineAndPaymentDetalis();

	    }

	    @Test(priority = 24,description = "Verify Overdue label for outstanding balance column.")
	    public void cdp_VerifyOverdueFinePayment() throws InterruptedException{
	    	cdp.cdp_VerifyOverdueFinePayment();

	    }


	    @Test(priority = 25,description = "Verify User Able to Make Fine As Void on CDP.")
	    public void cdp_VerifyUserAbletoMakeFineAsVoid() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoMakeFineAsVoid();

	    }

	    @Test(priority = 26,description = "Verify User Able to Make Fine As Waive on CDP.")
	    public void cdp_VerifyUserAbletoMakeFineAsWaive() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoMakeFineAsWaive();

	    }

	    @Test(priority = 27,description = "Verify User Able to Make Payment As Void on CDP.")
	    public void cdp_VerifyUserAbletoMakePaymentAsVoid() throws InterruptedException{
	    	cdp.cdp_VerifyUserAbletoMakePaymentAsVoid();

	    }


	    @Test(priority = 28,description = "Verify Oustanding balance on CDP is equal to Outstanding balance on CLP.")
	    public void cdp_VerifyOustandingBalWithCLP() throws InterruptedException{
	    	
	    	cdp.cdp_VerifyOustandingBalWithCLP();
	    }



}
