package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePge  {
	@FindBy(xpath="//input[@placeholder='E-mail address']")
	WebElement EmailText;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement PasswordW;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Submit;
	
	@FindBy(xpath="//p[contains(text(),'Invalid login')]")
	WebElement InvalidLogin;
	
	@FindBy(xpath="//div[@class='header']")
	WebElement Something;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPaasword;
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement Calender;
	
	public HomePage doLogin(String Email, String Password){
		sendkeys(EmailText, Email);
		sendkeys(PasswordW, Password);
		click(Submit);
		return new HomePage();
	}
	
	public String getPateTitle(){
		return driver.getTitle();
	}
	
	public void verifyInvalid(String Email, String Password){
		sendkeys(EmailText, Email);
		sendkeys(PasswordW, Password);
		click(Submit);
	}
	
	public boolean VerifyIn(){
		return InvalidLogin.isDisplayed();
	}
	
	public boolean verifySomething(){
		return Something.isDisplayed();
	}
	
	public ForgotPassPage forgoPassowrd(){
		click(ForgotPaasword);
		return new ForgotPassPage();
	}
	
	public CalenderPage clickonCalender(){
		click(Calender);
		return new CalenderPage();
	}

}
