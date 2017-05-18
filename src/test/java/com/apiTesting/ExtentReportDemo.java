package com.apiTesting;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {

	public static ExtentReports extent;

	public static ExtentTest logger;

	@BeforeSuite

	 public void beforeSuite(){
	
	//Where to keep Report
	
	     extent = new ExtentReports(System.getProperty("user.dir")+"/surefire-reports/MyExtentReport.html",true);
	
	//Load Config File for Report
	
	     extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));  
	
	 }

	@BeforeMethod

	 public void beforeMethod(Method method){
	
	//Test starts here
	
		logger = extent.startTest((this.getClass().getSimpleName() + " :: "  +        method.getName()),method.getName());  
	
	//Author Name
	
		logger.assignAuthor("Arun");
	
	//Types of Test Category
	
		logger.assignCategory("SmokeReport–PROD");
	
	//Test Description
	
		logger.log(LogStatus.PASS, "Browser launched successfully");  

 }

	@Test
	public void passTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void failTest(){
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}

	// Test Suite Ends Here

	@AfterSuite

	public void afterSuite() {

		extent.flush();

		extent.close();

	}

}
