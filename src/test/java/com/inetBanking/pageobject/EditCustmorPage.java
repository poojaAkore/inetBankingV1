package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustmorPage {
	WebDriver ldriver;
	
	public EditCustmorPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement EditCustmor;
	
	@FindBy(how=How.NAME, using="cusid")
	@CacheLookup
	WebElement CustID;
	
	@FindBy(how=How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement changecity;
	
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement updatebtn;
	
	public void EditCustmor()
	{
		EditCustmor.click();
	}
	public void custmorId(String ID)
	{
		CustID.sendKeys(ID);
	}
	public void Submit()
	{
		btnsubmit.click();
	}
	
	public void ChangeCity(String cname)
	{
		changecity.clear();
		changecity.sendKeys(cname);
	}
	public void Updatebtn()
	{
		updatebtn.click();
	}
	

}
