package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CSDPUtility;
import POM.SLAUtility;
import POM.SupervisorUtility;

public class BasicSupervisor extends BrowsersInvoked{
	
	
	ExtentReportClass extentClass;
	ITestResult result;
	SupervisorUtility su;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
        su = new SupervisorUtility(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }

	

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		su.LoginSupervisor();

	}
	@Test(priority = 1)
	public void VerifySupervisorToggle() throws InterruptedException {
		su.verify_No_BasicSup_SupManager_IsDisplayed();
		

	}
	@Test(priority = 2)
	public void VerifyThatUserIsAbleToCreateARoleWithNoSupervisorPermission()
	{
		su.VerifyThatUserIsAbleToCreateARoleWithNoSupervisorPermission();
		
	}
	@Test(priority = 3)
	public void VerifyThatUserIsAbleToCreateARoleWithBasicSupervisorPermission()
	{
		su.VerifyThatUserIsAbleToCreateARoleWithBasicSupervisorPermission();
		
	}
	@Test(priority = 4)
	public void VerifyThatUserIsAbleToCreateARoleWithSupervisorManagerPermission()
	{
		su.VerifyThatUserIsAbleToCreateARoleWithSupervisorManagerPermission();
		
	}
	@Test(priority = 5)
	public void VerifyUserIsAbleToAssignRoleNoSupervisor() throws InterruptedException
	{
		su.VerifyUserIsAbleToAssignRoleNoSupervisor();
		
	}
	@Test(priority = 6)
	public void VerifyUserIsAbleToAssignRoleBasicSupervisor() throws InterruptedException
	{
		su.VerifyUserIsAbleToAssignRoleBasicSupervisor();
		
	}
	@Test(priority = 7)
	public void VerifyUserIsAbleToAssignRoleSupervisorManager() throws InterruptedException
	{
		su.VerifyUserIsAbleToAssignRoleSupervisorManager();
		
	}
	
	@Test(priority = 8)
	public void VerifyUserIsAbleToCreateGrpWith1BasicSupervisor() throws InterruptedException
	{
		su.VerifyUserIsAbleToCreateGrpWith1BasicSupervisor();
		
	}
	@Test(priority = 9)
	public void VerifyUserIsAbleToCreateGrpWith1SupervisorManager() throws InterruptedException
	{
		su.VerifyUserIsAbleToCreateGrpWith1SupervisorManager();
		
	}
	@Test(priority = 10)
	public void verifyUserIsAbleToEditCreatedGroupWithBasic() throws InterruptedException
	{
		su.verifyUserIsAbleToEditCreatedGroupWithBasic();
		
	}
	
	@Test(priority = 11)
	public void verifyUserIsAbleToEditCreatedGroupWithSupervisorManager() throws InterruptedException
	{
		su.verifyUserIsAbleToEditCreatedGroupWithSupervisorManager();
		
	}
	

}
