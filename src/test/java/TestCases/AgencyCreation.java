package TestCases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import POM.Department;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import POM.AgencyCreationUtility;
import POM.AppPreRequisiteUtility;

import POM.LocationManagmentUtility;
import POM.LoginUtility;
import POM.SupervisorUtility;

public class AgencyCreation extends BrowsersInvoked {

	
	ITestResult result;
	AgencyCreationUtility agencyCreation;
	AppPreRequisiteUtility appPreRequisite;
	Department department;
	public  String activeGroup;



	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext context) {
	    // Set the suite name for this test
	    BrowsersInvoked.suiteName = context.getSuite().getName();
	    
	    // Initialize the driver
	    Setup(); // sets driver for this thread
	    agencyCreation = new AgencyCreationUtility(getDriver());
	    appPreRequisite = new AppPreRequisiteUtility(getDriver());
	}

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }


	
	
	@BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        // Retrieve the groups this method belongs to
        activeGroup = String.join(", ", context.getCurrentXmlTest().getIncludedGroups());
        System.out.println(context.getSuite().getName());
    }

	@Test(priority = 0,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void LoginAdmin() throws InterruptedException {
		
//		agencyCreation.LoginAdmin();
		LoginUtility log = new LoginUtility(getDriver());
		log.LoginAdmin();

	}

	@Test(priority = 1,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencyCreation_OpenCreateAgencyPopup() throws InterruptedException {
		agencyCreation.agencyCreation_OpenCreateAgencyPopup();

	}

	@Test(priority = 2,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencyCreation_ConfigureCE() throws InterruptedException {
		agencyCreation.agencyCreation_ConfigureCE();

	}

	@Test(priority = 3,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencyCreation_ConfigureCRM() throws InterruptedException {
		agencyCreation.agencyCreation_ConfigureCRM();

	}

	@Test(priority = 4,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencyCreation_VerifyNewAgencyCreation() throws InterruptedException {
		agencyCreation.agencyCreation_VerifyNewAgencyCreation();

	}
	
	
	
	@Test(priority = 5,description = "Verify that user is able to Set Online Payment Portal.",groups = {"GISDirect20","Enterprise","Hosted20"})
	public void agencyCreation_setPaymentPortal() throws InterruptedException {
		if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			System.out.println("Passed.");
		}
		else {
		agencyCreation.agencyCreation_setPaymentPortal();
		}

	}
	
		

	@Test(priority = 6,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void VerifyActiveInactiveAgencyCount() throws InterruptedException {
		agencyCreation.verifyActiveInactiveAgencyCount();

	}

	@Test(priority = 7,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void VerifyCDBGfileandReplaceButton() throws InterruptedException {
		agencyCreation.verifyCDBGfileandReplaceButton();

	}

	@Test(priority = 8,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyAppConfigurations() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyAppConfigurations(AgencyCreationUtility.RandomAgencyName);

	}

	@Test(priority = 9,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyUploadedMapLayer() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyUploadedMapLayer();

	}

   @Test(priority = 10,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyUploadedAgencyBoundary() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyUploadedAgencyBoundary();

	}
   
   @Test(priority = 11,groups = {"GISDirect20","Enterprise","Hosted20"},description="Uploade parcel file and activate 2.0 for hosted only.")
	public void AgencySetup_VerifyUploadedAgencyParcelFile() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyUploadedAgencyParcelFile();
		
		if(activeGroup.equalsIgnoreCase("Hosted20")) {
			
			int tabscount;
			ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
			tabscount = tabs.size();
			System.out.println(tabscount);
			while (tabscount != 2) {
				tabs = new ArrayList<>(getDriver().getWindowHandles());
				tabscount = tabs.size();
			}
			System.out.println(tabscount);
			try {
				getDriver().switchTo().window((String) tabs.get(0));
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			
			// click on edit Agency Icon 
			agencyCreation.clickOnEditAgencyIcon();
			
			// click on Activation 2.0 toggle
			agencyCreation.clickonHosted20toggel();
		
			// Click on Save button on Edit Agency POp up
			agencyCreation.clickOnSaveAgencyButton();
			
		}
	}
   

	@Test(priority = 12,groups = "GISDirect20")
	public void AgencySetup_VerifySecuredLocationSettings() throws InterruptedException {
		
		LocationManagmentUtility locMan = new LocationManagmentUtility(getDriver());
		locMan.navigationToSecuredLocationSettings();
		locMan.SendServerURL();
		locMan.clickOnSaveChangesButton();
		
		//Assertion
		
		String actualURL = locMan.getGisServerURL();
		String expected = null;
		if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			expected = PropertiesUtils.getPropertyValue("GISServerURL_CI");
		}
		else {
			expected = PropertiesUtils.getPropertyValue("GISServerURL");
		}
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualURL, expected,"Both GIS server url are not Same.");
		softassert.assertAll();
		
	}
	
	

	@Test(priority = 13,groups = {"GISDirect20","Hosted20"})
	public void AgencySetup_VerifyfieldMapping() throws InterruptedException {

		 //Navigate To Location Management

		CRMCommonMethods crm = new CRMCommonMethods(getDriver());
		if(activeGroup.equalsIgnoreCase("Hosted20")) {
			appPreRequisite.AgencySetup_VerifyAppConfigurations(AgencyCreationUtility.RandomAgencyName);
		}
		 //Navigate To Agency Setup
		crm.navigateToAgencySetup();	
		
		//Navigate To Location Management 
		LocationManagmentUtility locMan = new LocationManagmentUtility(getDriver());
		locMan.navigationToLocationManagement();
		locMan.navigateToFieldMapping();
		
		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			
			locMan.mapfieldAddress();
			locMan.mapParcelAddress();
			locMan.mapOwnerInfo();
			locMan.mapownerAddress();
		}
		else if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			locMan.mapfieldAddressHosted20();
			locMan.mapAPNHosted20();
			locMan.mapOwnerInfoHosted20();			
		}
		
		locMan.checkAndSaveMapping();
	}
	
		
	
	@Test(priority = 14,groups = {"GISDirect20"},description="Set Agency as 2.0 only for GIS Direct.")
	public void AgencySetup_VerifySetGISDirect2O() throws InterruptedException {
		
		
		int tabscount;
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		tabscount = tabs.size();
		System.out.println(tabscount);
		while (tabscount != 2) {
			tabs = new ArrayList<>(getDriver().getWindowHandles());
			tabscount = tabs.size();
		}
		System.out.println(tabscount);
		try {
			getDriver().switchTo().window((String) tabs.get(0));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		// click on edit Agency Icon 
		agencyCreation.clickOnEditAgencyIcon();
		
		// click on Activation 2.0 toggle
		agencyCreation.clickOn2Odirecttoggle();
	
		// Click on Save button on Edit Agency POp up
		agencyCreation.clickOnSaveAgencyButton();
		
		
	}
	
	@Test(priority = 15,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfLCFs() throws InterruptedException { 
		
		System.out.print("Active group Name " + activeGroup);
		CRMCommonMethods crm = new CRMCommonMethods(getDriver());
		
		if(activeGroup.equalsIgnoreCase("GISDirect20")) {
			appPreRequisite.AgencySetup_VerifyAppConfigurations(AgencyCreationUtility.RandomAgencyName);
		}
		// Navigate To Agency Setup
		crm.navigateToAgencySetup();
		
		// Navigate To Location Management 
		LocationManagmentUtility locMan = new LocationManagmentUtility(getDriver());
		locMan.navigationToLocationManagement();
		locMan.navigationToLocationandMaps();
		
		
		appPreRequisite.AgencySetup_VerifyCreationOfLCFs();

	}
	
	
	@Test(priority = 16,groups = {"GISDirect20","Enterprise","Hosted20"},description = "Verify that user is able to Create Individual and Legal Contacts ")
   public void AgencySetup_VerifyContactCustomFields() throws InterruptedException {
        appPreRequisite.AgencySetup_VerifyContactCustomFields("IndiviualContact");
       appPreRequisite.AgencySetup_VerifyContactCustomFields("LegalContact");
      
    }
	
	
	@Test(priority = 17,description = "Verify that user is able to Create Roles.",groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_CreatedRoles() throws InterruptedException {
		appPreRequisite.createRoles();

	}
	

	@Test(priority = 18,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void createDepartments() throws InterruptedException {
		appPreRequisite.createDepartment();
	}


	@Test(priority = 19,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreatedUser() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreatedUser();

	}
	
	
	@Test(priority = 20,description = "Verify that user is able to Create Groups." ,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreateGroup() throws InterruptedException {
		appPreRequisite.createGroups();

	}
	

	@Test(priority = 21,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyAdditionOfFAActivity() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyAdditionOfFAActivity();

	}

	@Test(priority = 22,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfMunicipalCode() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreationOfMunicipalCode();

	}

	@Test(priority = 23,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfViolations() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyCreationOfViolations();

	}

	@Test(priority = 24,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyInvalidDispositionCreation() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyInvalidDispositionCreation();

	}

	@Test(priority = 25,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfHTMLNotice() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyCreationOfHTMLNotice();

	}

	@Test(priority = 26,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfNonHTMLNotice() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyCreationOfNonHTMLNotice();

	}

	@Test(priority = 27,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_AgencySetup_AgencySetup_VerifyCreationOfFADocument() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreationOfFADocument();

	}

	@Test(priority = 28,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationOfCategories() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreationOfCategories();

	}

	@Test(priority = 29,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifySavedSubmissionSettings() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifySavedSubmissionSettings();

	}

	@Test(priority = 30,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCaseAssignmentRules() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCaseAssignmentRules();

	}

	@Test(priority = 31,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifySubmissionAssignmentRules() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifySubmissionAssignmentRules();

	}

	@Test(priority = 32,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifySuccessfulDirectionToCCP() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifySuccessfulDirectionToCCP();

	}


	@Test(priority = 33, enabled = false) public void AgencySetup_VerifyCreationOf50PlusCases() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreationOf50PlusCases();
	}

	@Test(priority = 34, enabled = false) public void AgencySetup_VerifyCreationOf50PlusSubmissions() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreationOf50PlusSubmissions();
	}

	@Test(priority = 35,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCaseCreationWithEntityViolation() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCaseCreationWithEntityViolation();

	}

	@Test(priority = 36,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreateFinePopup() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyCreateFinePopup();

	}

	@Test(priority = 37,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyFlatFineCreationDoNotAttachedNotices() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyFlatFineCreationDoNotAttachedNotices();

	}

	@Test(priority = 38,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyFlatFineCreationAttachedNotices() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyFlatFineCreationAttachedNotices();

	}
	
	
	@Test(priority = 39,description = "Verify that user is able to Create violation specific fines.",groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreationViolationSpecificFine() throws InterruptedException {

		
		String violations = "Water";
		appPreRequisite.CreationViolationSpecificOnlyFine("Violation Specific Fine Linked To Violations Only","10000",false,true, null,violations);
		appPreRequisite.CreationViolationSpecificOnlyFine("Violation Specific Fine Linked To Notice Only","10000",true,false,"Notice For Violation Specific Fine Linked To Notice",null);

	}
	
	

	@Test(priority = 40,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyFlatFineEdit() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyFlatFineEdit();

	}

	@Test(priority = 41,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyInactivateActiveFines() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyInactivateActiveFines();

	}

	@Test(priority = 42,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyActivateInactiveFines() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyActivateInactiveFines();

	}

	@Test(priority = 43,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyOpenCloseCreateLateFeePopup() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyOpenCloseCreateLateFeePopup();

	}

	@Test(priority = 44,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreateFixedManualFlatFineLateFee() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyCreateFixedManualFlatFineLateFee();

	}

	@Test(priority = 45,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyCreateOutStdManualFlatFineLateFee() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyCreateOutStdManualFlatFineLateFee();

	}

	@Test(priority = 46,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyInactivateActiveLateFee() throws InterruptedException {
		appPreRequisite.AgencySetup_VerifyInactivateActiveLateFee();

	}

	@Test(priority = 47,groups = {"GISDirect20","Enterprise","Hosted20"})
	public void AgencySetup_VerifyActivateInActiveLateFee() throws InterruptedException {

		appPreRequisite.AgencySetup_VerifyActivateInActiveLateFee();

	}
	
	@Test(priority = 48,description = "Verify that user is able to delete Agency.",groups = {"GISDirect20","Enterprise","Hosted20"})

    public void deleteCreatedAgency() throws InterruptedException {
        agencyCreation.deleteCreatedAgency();
    }
	
   


}
