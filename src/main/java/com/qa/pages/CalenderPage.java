package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalenderPage extends BasePge{
	
	@FindBy(xpath="//div[4]//div[2]//div[1]//div[3]")
	WebElement Twelve;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement Title;
	
	@FindBy(xpath="//div[@name='calendar']")
	WebElement Calender;
	
	@FindBy(xpath="//span[contains(text(),'Harish K R <harishkr755@gmail.com>')]")
	WebElement CalenderHarish;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement SaveButton;
	
	@FindBy(xpath="//div[@class='field']//div//div//span//p")
	WebElement TitleValue;
	
	@FindBy(xpath="//p[contains(text(),'The field Title is required')]")
	WebElement ErrorMssg1;
	
	@FindBy(xpath="//p[contains(text(),'The field Calendar is required')]")
	WebElement ErrorMssg2;
	
	@FindBy(xpath="//button[@class='ui red button']")
	WebElement ErrMsgOkButton;
	
	public String createCalender(String keysToSend) throws Exception{
		click(Twelve);
		sendkeys(Title, keysToSend);
		click(Calender);
		click(CalenderHarish);
		click(SaveButton);
		return TitleValue.getText();
	}
	
	public void clickTwelveandSave(){
		click(Twelve);
		click(SaveButton);
	} 
	
	public void clickonErrOk(){
		click(ErrMsgOkButton);
	}
	
	public boolean Err1displayed(){
		return ErrorMssg1.isDisplayed();
	}
	
	public boolean Err2displayed(){
		return ErrorMssg2.isDisplayed();
	}

}
