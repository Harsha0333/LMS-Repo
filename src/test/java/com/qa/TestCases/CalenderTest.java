package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.browser.DriverFactory;
import com.qa.pages.CalenderPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.reports.ExtentFactory;
import com.qa.utils.SeleniumFunLibrary;

public class CalenderTest extends BaseTest {
	HomePage hp;
	CalenderPage cp;
	
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
	
	@Test
	public void verifythetAddcalenderTest() throws Exception{
		String title = SeleniumFunLibrary.getRandomtString(5);
		setTestDesc("Click on Calender, add an event, save it and verify that the added Calender is shown in Created Page");
		this.hp=new HomePage();
		this.cp=new CalenderPage();
		hp.clickonCalender();
		Assert.assertEquals(cp.createCalender(title), title);
	}
	
	@Test
	public void verifyErrorMsg(){
		setTestDesc("Try creating the an calender without any data, and verify the error messages");
		this.hp=new HomePage();
		this.cp=new CalenderPage();
		hp.clickonCalender();
		cp.clickTwelveandSave();
		Assert.assertTrue(cp.Err1displayed());
		Assert.assertTrue(cp.Err2displayed());
		cp.clickonErrOk();
	}
	
	
	

}
