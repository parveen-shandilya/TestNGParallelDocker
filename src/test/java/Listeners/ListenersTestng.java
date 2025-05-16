package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;

public class ListenersTestng extends BrowsersInvoked implements ITestListener {
	
	ExtentReports extent= ExtentReportClass.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
        extent.setSystemInfo(context.getName(), getPassPercentage(context) + "%");
		extent.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().fail(result.getThrowable());
		
		String filePath=null;
		WebDriver driver = BrowsersInvoked.getDriver();
		System.out.println("Test Failed: " + result.getName());
		
//		try {
//			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		filePath= ExtentReportClass.getScreenshot(driver, result.getMethod().getMethodName());
		
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped: " + result.getName());

		//extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.SKIP, "I was skipped "+ result.getMethod().getMethodName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentTest.set(test);
		extentTest.get().assignCategory(result.getTestClass().getRealClass().getSimpleName());
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Passed: " + result.getName());

		extentTest.get().log(Status.PASS, "Test Passed "+ result.getMethod().getMethodName());
		extentTest.get().pass(result.getThrowable());

	}
	
	
	 private int getPassPercentage(ITestContext context) {
	        int totalTests = context.getAllTestMethods().length;
	        int passedTests = context.getPassedTests().size();
	        return (passedTests * 100) / totalTests;
	    }



}
