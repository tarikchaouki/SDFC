package com.sdfc.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.sdfc.qa.base.TestBase;


public class TestListenerUtil extends TestBase implements ITestListener {
	
	
   
	public void onTestStart(ITestResult result) {
		// before each test
		System.out.println("New Test Started " +  result.getName());
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successfully Finished" + result.getName());
		
	}
 
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed " +  result.getName());
		GetScreenshotAtEndTest(result.getMethod().getMethodName());
		
	}
 
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped " + result.getName());
		
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test Failed but within success percentage " + result.getName());
		
	}
 
	public void onStart(ITestContext context) {
		//setup method call 
		
		System.out.println("This is onStart method " + context.getOutputDirectory());
		extent =ExtentReportSetUp.SetUpExtentRep();
		
	}
 
	public void onFinish(ITestContext context) {
			//close extent 
		System.out.println("This is onFinish method" + context.getPassedTests());
		System.out.println("This is onFinish method" + context.getFailedTests());
		extent.flush();
	}
	
}
