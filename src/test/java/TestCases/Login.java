package TestCases;
import BrowsersBase.BrowsersInvoked;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import POM.CaseAssignmentUtility;
import POM.GenerateNoticeOutOfInspectionUtility;
import POM.LoginUtility;

public class Login extends BrowsersInvoked{
	
	
	public LoginUtility log;
	
	

	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		log = new LoginUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}
	
	@Test(description = "Verify that user is able to log in with valid credentials.")
	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();
	}
	
	
	@Test(description = "Pre-requisite(Login)")
	public void LoginAdmin() throws InterruptedException {
		log.LoginAdmin();
	}
	
	
	

}
