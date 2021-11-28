package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.ExcelManager.TestDataProvider;
import com.qa.browser.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TQLoginpage;
import com.qa.reports.ExtentFactory;
import com.qa.utils.ReadProperty;

public class TQLoginTest extends BaseTest {
	
	@Parameters("Browser")
	@BeforeMethod(alwaysRun=true)
	public void setup(Method m, String Browser){
		test= ExtentFactory.extent.createTest(m.getName());
		try {
			DriverFactory.setupDriver(Browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test()
	public void verifyUsername1() throws InterruptedException{
		setTestDesc("Verify that UserName is displayed on Home Page");
		TQLoginpage tq = new TQLoginpage();
		Assert.assertFalse(tq.tqtitle());
		
	}
		
		
	@Test()
	public void verifyUsername2() throws InterruptedException{
		setTestDesc("Verify that UserName is displayed on Home Page");
		TQLoginpage tq = new TQLoginpage();
		tq.doLogin1("Sharma.R", "cD4)vH6c")	;
	}
	

	
		
		
	}
	
	
	
	
	
	
	


