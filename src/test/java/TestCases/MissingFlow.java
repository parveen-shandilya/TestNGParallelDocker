package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import ExtentReport.ExtentReportClass;

public class MissingFlow extends BrowsersInvoked{
	
	
	CaseAssignmentUtility obj ;
	ExtentReportClass extent;
	
	
	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		obj = new CaseAssignmentUtility(getDriver());
	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}
	
	@Test(priority = 0)
	public void LoginTest() throws InterruptedException {
		obj.LoginAgency();
	}

	

	
	

}
