package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver ldriver;
	 public loginpage(WebDriver rdriver)
	{ 
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	@FindBy(name="uid")
	@CacheLookup
	
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement txtbtnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	public void setusername(String Uname)
	{
		txtusername.sendKeys(Uname);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		txtbtnlogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
