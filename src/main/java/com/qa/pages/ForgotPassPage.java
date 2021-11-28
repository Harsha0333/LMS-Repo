package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassPage extends BasePge {
	@FindBy(xpath="//h2[@class='ui blue header']")
	WebElement ForgotMy;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailText;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement ResetButton;

	@FindBy(xpath="//a[contains(text(),'Got an account? Log in here')]")
	WebElement LoginHere;
	
	public boolean verifyForgot(){
		return ForgotMy.isDisplayed();
	}
	
	public boolean verifyEmail(){
		return EmailText.isDisplayed();
	}
	
	public LoginPage clickLoginHere(){
		click(LoginHere);
		return new LoginPage();
	}
	
}
