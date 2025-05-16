package TestCases;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.SubmissionSettingsUtility;
import POM.UserManagementUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class UserManagement extends BrowsersInvoked {

	
	UserManagementUtility obj;
	ExtentReportClass extentClass;
	ITestResult result;
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		obj = new UserManagementUtility(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}
	
	
	
	@Test(priority = 0)
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
	
	

	public static String UserCreated(String username) {
		String xpath = "//div[contains(text(),'" + username + "')]";
		return xpath;
	}

	
	

	@Test(priority = 1)
	public  void UserManagement_OpenCreateUserPopup() throws InterruptedException {
		obj.UserManagement_OpenCreateUserPopup();
	}




	@Test(priority = 2)
	public  void UserManagement_VerifyUserGetsCreated() throws InterruptedException {
		obj.UserManagement_VerifyUserGetsCreated();

	}



	@Test(priority = 3)
	public  void UserManagement_VerifySearchUser() throws InterruptedException {

		obj.UserManagement_VerifySearchUser();
	}




	@Test(priority = 4)
	public  void UserManagement_OpenEditUserPopup() throws InterruptedException {

		obj.UserManagement_OpenEditUserPopup();
	}



	@Test(priority = 5)
	public  void UserManagement_VerifyUpdatedUserDetails() throws InterruptedException {
		obj.UserManagement_VerifyUpdatedUserDetails();

	}



//	@Test(priority = 6)
//	public  void UserManagement_VerifyResetMailReceived() throws AWTException, InterruptedException {
//		obj.UserManagement_VerifyResetMailReceived();
//
//	}
//
//
//
//	@Test(priority = 7)
//	public  void UserManagement_ResetPasswordForUser() throws InterruptedException {
//
//
//		obj.UserManagement_ResetPasswordForUser();
//	}



	@Test(priority = 8)
	public void UserManagement_VerifyCountOfUsers() throws InterruptedException {

		obj.UserManagement_VerifyCountOfUsers();
	}



	@Test(priority = 9)
	public void UserManagement_OpenCreateRolePopup() throws InterruptedException {
		obj.UserManagement_OpenCreateRolePopup();
	}



	@Test(priority = 10)
	public void UserManagement_VerifyRoleCreationWithoutProdSettings() throws InterruptedException {
		obj.UserManagement_VerifyRoleCreationWithoutProdSettings();

	}


	@Test(priority = 11)
	public  void UserManagement_VerifyRoleCreationWithProdSettings() throws InterruptedException {
		obj.UserManagement_VerifyRoleCreationWithProdSettings();

	}



	@Test(priority = 12)
	public  void UserManagement_OpenCreateGroupPopup() throws InterruptedException {

		obj.UserManagement_OpenCreateGroupPopup();
	}



	@Test(priority = 13)
	public  void UserManagement_VerifyGroupCreationWithoutProdSettings() throws InterruptedException {
		obj.UserManagement_VerifyGroupCreationWithoutProdSettings();

	}


	@Test(priority = 14,description = "the next screen would allow you to assign open cases to another user.")
	public void UserManagement_VerifyCaseAssignToNextUser() throws InterruptedException{
		obj.UserManagement_VerifyCaseAssignToNextUser();
		obj.UserManagement_VerifyCaseAssignToNextUserPopup("Amandeep Singh1");
	}
	

}
