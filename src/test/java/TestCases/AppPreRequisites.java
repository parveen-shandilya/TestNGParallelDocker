//package TestCases;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import BrowsersBase.BrowsersInvoked;
//import POM.AgencyCreationUtility;
//import POM.AppPreRequisiteUtility;
//import POM.CreateAndLinkCaseUtility;
//
//
//public class AppPreRequisites extends BrowsersInvoked {
//
//	public AppPreRequisiteUtility driver;
//	ITestResult result;
//	CreateAndLinkCaseUtility createLinkCase;
//	AppPreRequisiteUtility appPreRequisite;
//	AgencyCreationUtility acu;
////	AgencyCreationUtility agencyCreation;
//
//	@BeforeClass
//	public void setUp() {
//		driver = acu.returnDriver();
//		// extentClass = new ExtentReportClass(driver);
//		// createLinkCase = new CreateAndLinkCaseUtility(driver);
//		//appPreRequisite = new AppPreRequisiteUtility(driver);
//	}
//
//	@AfterClass
//	public void closeDriver() {
//		BrowsersInvoked.tearDown(driver);
//	}
//
////	@Test(priority = 0)
////	public void LoginAgency() throws InterruptedException {
////		appPreRequisite.LoginAgency();
////
////	}
//
//	@Test(priority = 4)
//	public  void AgencySetup_VerifyAppConfigurations() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyAppConfigurations(AgencyCreationUtility.RandomAgencyName);
//		
//	}
//
//	@Test(priority = 5)
//	public  void AgencySetup_VerifyUploadedMapLayer() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyUploadedMapLayer();
//		
//	}
//
//	@Test(priority = 6)
//	    public  void AgencySetup_VerifyUploadedAgencyBoundary() throws InterruptedException {
//
//	                appPreRequisite.AgencySetup_VerifyUploadedAgencyBoundary();
//	       
//	    }
//
//	@Test(priority = 7)
//	    public  void AgencySetup_VerifyUploadedAgencyParcelFile() throws InterruptedException {
//	                appPreRequisite.AgencySetup_VerifyUploadedAgencyParcelFile();
//	           }
//
//	@Test(priority = 8)
//	    public  void AgencySetup_VerifyCreationOfLCFs() throws InterruptedException {
//	                appPreRequisite.AgencySetup_VerifyCreationOfLCFs();
//	       
//	    }
//
//	@Test(priority = 9)
//	public  void AgencySetup_VerifyCreatedUser() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreatedUser();
//		
//	}
//
//	@Test(priority = 10)
//	public  void AgencySetup_VerifyAdditionOfFAActivity() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyAdditionOfFAActivity();
//		
//	}
//
//	@Test(priority = 11)
//	public  void AgencySetup_VerifyCreationOfMunicipalCode() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreationOfMunicipalCode();
//		
//	}
//
//	@Test(priority = 12)
//	public  void AgencySetup_VerifyCreationOfViolations() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyCreationOfViolations();
//		
//	}
//
//	@Test(priority = 13)
//	public  void AgencySetup_VerifyInvalidDispositionCreation() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyInvalidDispositionCreation();
//		
//	}
//
//	@Test(priority = 14)
//	public  void AgencySetup_VerifyCreationOfNonHTMLNotice() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyCreationOfNonHTMLNotice();
//		
//
//	}
//
//	@Test(priority = 15)
//	public  void AgencySetup_VerifyCreationOfHTMLNotice() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyCreationOfHTMLNotice();
//		
//	}
//
//	@Test(priority = 16)
//	public  void AgencySetup_AgencySetup_AgencySetup_VerifyCreationOfFADocument() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreationOfFADocument();
//	
//	}
//
//	@Test(priority = 17)
//	public  void AgencySetup_VerifyCreationOfCategories() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreationOfCategories();
//		
//	}
//
//	@Test(priority = 18)
//	public  void AgencySetup_VerifySavedSubmissionSettings() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifySavedSubmissionSettings();
//		
//	}
//
//	@Test(priority = 19)
//	public  void AgencySetup_VerifySuccessfulDirectionToCCP() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifySuccessfulDirectionToCCP();
//		
//	}
//
//	@Test(priority = 20)
//	public  void AgencySetup_VerifyCreationOf50PlusCases() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreationOf50PlusCases();
//		
//	}
//
//	@Test(priority = 21)
//	public  void AgencySetup_VerifyCreationOf50PlusSubmissions() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreationOf50PlusSubmissions();
//		
//	}
//
//	@Test(priority = 22)
//	public  void AgencySetup_VerifyCaseCreationWithEntityViolation() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCaseCreationWithEntityViolation();
//		
//	}
//
//	@Test(priority = 23)
//	public  void AgencySetup_VerifyCreateFinePopup() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyCreateFinePopup();
//		
//	}
//
//	@Test(priority = 24)
//	public  void AgencySetup_VerifyFlatFineCreationDoNotAttachedNotices() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyFlatFineCreationDoNotAttachedNotices();
//		
//	}
//
//	@Test(priority = 25)
//	public  void AgencySetup_VerifyFlatFineCreationAttachedNotices() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyFlatFineCreationAttachedNotices();
//		
//	}
//
//	@Test(priority = 26)
//	public  void AgencySetup_VerifyFlatFineEdit() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyFlatFineEdit();
//		
//	}
//
//	@Test(priority = 27)
//	public  void AgencySetup_VerifyInactivateActiveFines() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyInactivateActiveFines();
//
//		
//	}
//
//	@Test(priority = 28)
//	public  void AgencySetup_VerifyActivateInactiveFines() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyActivateInactiveFines();
//
//		
//	}
//
//	@Test(priority = 29)
//	public  void AgencySetup_VerifyOpenCloseCreateLateFeePopup() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyOpenCloseCreateLateFeePopup();
//
//		
//	}
//
//	@Test(priority = 30)
//	public  void AgencySetup_VerifyCreateFixedManualFlatFineLateFee() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyCreateFixedManualFlatFineLateFee();
//
//		
//	}
//
//	@Test(priority = 31)
//	public  void AgencySetup_VerifyCreateOutStdManualFlatFineLateFee() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyCreateOutStdManualFlatFineLateFee();
//
//		
//	}
//
//	@Test(priority = 32)
//	public  void AgencySetup_VerifyInactivateActiveLateFee() throws InterruptedException {
//		appPreRequisite.AgencySetup_VerifyInactivateActiveLateFee();
//
//		
//	}
//
//	@Test(priority = 33)
//	public  void AgencySetup_VerifyActivateInActiveLateFee() throws InterruptedException {
//
//		appPreRequisite.AgencySetup_VerifyActivateInActiveLateFee();
//
//		
//	}
//
//}
