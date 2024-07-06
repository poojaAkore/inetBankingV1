package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustmorPage {
	WebDriver ldriver;
	
	public AddCustmorPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement clickAddNewCustmor;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtcustmorname;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGendr;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephonno;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@CacheLookup
	@FindBy(how=How.NAME, using="sub")
	WebElement btnsubmit;
	
	//create the methods
	public void clickaddnewcustmor()
	{
		clickAddNewCustmor.click();
		
	}
	
	public void custName(String cName)
	{
		txtcustmorname.sendKeys(cName);
	}
	
	public void custgender(String gname)
	{
		rdGendr.click();
	}
	public void custdob(String dd,String mm,String yy)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String cadd)
	{
		txtaddress.sendKeys(cadd);
	}
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void custState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno)
	{
		txtpinno.sendKeys(cpinno);
	}
	public void custTelephoneNo(String cphoneno)
	{
		txttelephonno.sendKeys(cphoneno);
	}
	public void custEmailID(String cemailid) {
	txtemailid.sendKeys(cemailid);
	}
	public void custpassword(String cpass)
	{
		txtpassword.sendKeys(cpass);
	}
	public void custsubmit()
	{
	btnsubmit.click();	
	}

}
