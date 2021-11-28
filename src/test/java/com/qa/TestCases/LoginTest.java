package com.qa.TestCases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.ExcelManager.TestDataProvider;
import com.qa.browser.DriverFactory;
import com.qa.pages.ForgotPassPage;
import com.qa.pages.LoginPage;
import com.qa.reports.ExtentFactory;
import com.qa.utils.ReadProperty;

public class LoginTest extends BaseTest{
	Logger log = Logger.getLogger(this.getClass());
	
	@Parameters("Browser")
	@BeforeMethod(alwaysRun=true)
	public void setup(Method m, String Browser){
		test= ExtentFactory.extent.createTest(m.getName());
		try {
			DriverFactory.setupDriver(Browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Browser lounched...! and url is hited");
	}
	
	@DataProvider
	public Object[][] getLogineCredensials() throws Exception{
		Object[][] data = TestDataProvider.getTestData(ReadProperty.getProperty("SheetNameforDP"));
		return data;
	}
	
	@Test(dataProvider="getLogineCredensials",priority=1, groups="Smoke")
	public void verifyLoginTest(String Email, String Password) throws Exception{
		setTestDesc("Verify that Home Page is diaplyed when loged into CRM application");
		LoginPage l= new LoginPage();
		l.doLogin(Email, Password);
	}
	
	@Test(priority=2)
	public void verifyPageTitle(){
		setTestDesc("Verify the Title of Login Page");
		LoginPage l= new LoginPage();
		l.getPateTitle();
		Assert.assertEquals(l.getPateTitle(), getLocString("LoginTitle"));
	}
	
	@Test(priority=3)
	public void verifyinvalidLoginLogout(){
		setTestDesc("Veify the taht when user try login with invalid credencials, error messg is displayed");
		LoginPage l= new LoginPage();
		l.verifyInvalid(getLocString("Email"), getLocString("Password"));
		Assert.assertTrue(l.VerifyIn());
		Assert.assertTrue(l.verifySomething());
	}
	
	@Test(priority=4)
	public void verifyForgotPass() throws InterruptedException{
		setTestDesc("Verify that Forgot Password page is displayed with email text box and Forgot text");
		LoginPage l= new LoginPage();
		ForgotPassPage fp = new ForgotPassPage();
		l.forgoPassowrd();
		Assert.assertTrue(fp.verifyEmail());
		Assert.assertTrue(fp.verifyForgot());
	}
	
	@Test(priority=5)
	public void verifyThatGoto() throws InterruptedException{
		setTestDesc("Verify that Login page is displayed when clicked on Go To Login Page from ForgotPage");
		LoginPage l= new LoginPage();
		ForgotPassPage fp = new ForgotPassPage();
		l.forgoPassowrd();
		fp.clickLoginHere();
		Assert.assertEquals(l.getPateTitle(), getLocString("LoginTitle"));
	}
	
}
