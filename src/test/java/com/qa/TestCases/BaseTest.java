package com.qa.TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.ExcelManager.TestDataLoader;
import com.qa.browser.DriverFactory;
import com.qa.reports.ExtentFactory;
import com.qa.reports.Log4jProperties;
import com.qa.utils.Constants;
import com.qa.utils.ReadProperty;

public class BaseTest {
	public static ExtentTest test;
	public String testDesc;
	Logger log = Logger.getLogger(this.getClass());
	
	@BeforeTest(alwaysRun=true)
	public void startExtendReport() throws IOException{
		Log4jProperties.propertFileCreater();
		ExtentFactory.createReporter();
		log.info("Extent report configurtion is completed and setted date for log4j properties file");
	}
	
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result){
		log.info("Successfully completed Test case, so analysing the result");
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());
			test.log(Status.FAIL, "TestCase Description : " + getTestDesc());
			test.log(Status.FAIL, "Test failed with Exception : " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP, "TestCase Description : " + getTestDesc());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
			test.log(Status.PASS, "TestCase Description : " + getTestDesc());
		}
		log.info("Closing the browser instance");
		DriverFactory.quit();
	}
	
	@AfterTest(alwaysRun=true)
	public void flushReport(){
		log.info("Flushimg the results into Extent report");
		ExtentFactory.extent.flush();
	}
	
	private String getTestDesc() {
		return this.testDesc;
	}
	
	protected void setTestDesc(String testDesc){
		this.testDesc = testDesc;
	}
	
	public static String getLocString(String Key){
		Hashtable<String, String> ht =TestDataLoader.getLocalizedData(Constants.TESTDATA_DIR, ReadProperty.getProperty("Sheetname"), ReadProperty.getProperty("Languagename"));
		String retvalue = ht.get(Key);
		return retvalue;
	}

}
