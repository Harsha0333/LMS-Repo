package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.browser.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.reports.ExtentFactory;

public class HomeTest extends BaseTest{
	
	@Parameters("Browser")
	@BeforeMethod(alwaysRun=true)
	public void setup(Method m, String Browser){
		test= ExtentFactory.extent.createTest(m.getName());
		try {
			DriverFactory.setupDriver(Browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoginPage l= new LoginPage();
		l.doLogin(getLocString("Email1"), getLocString("Password1"));
	}
	
	@Test()
	public void verifyUsername() throws InterruptedException{
		setTestDesc("Verify that UserName Harish K R is displayed on Home Page");
		HomePage hp = new HomePage();
		Assert.assertTrue(hp.username());
	}
	
	}
