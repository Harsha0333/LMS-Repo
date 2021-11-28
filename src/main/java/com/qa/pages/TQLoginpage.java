package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TQLoginpage extends BasePge{
	
	@FindBy(xpath="//img[@alt = 'Brand Logo']")
	WebElement tqtitle;
	
	@FindBy(xpath="//input[@id='usernameField']")
	WebElement loginpg;
	
	@FindBy(xpath="//input[@id='passwordField']")
	WebElement pswrdpg;
	
	@FindBy(xpath="(//a[@ng-class='getCssClasses()'])[1]")
	WebElement loginbtn;
	
	@FindBy(xpath="//i[@class='fa fa-cogs' and @title='Manage']")
	WebElement mngbtn;
	
	@FindBy(xpath="//a[@title='Courses']//parent::li//preceding-sibling::li")
	WebElement courselnk;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement srchbox;
	
	
	
	
	public boolean tqtitle(){
		return tqtitle.isDisplayed();
	}
		
	public TQLoginpage doLogin1(String Username, String Password){
		sendkeys(loginpg, Username);
		sendkeys(pswrdpg, Password);
		click(loginbtn);
		return new TQLoginpage();
		
		
		
		
	
	 
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
