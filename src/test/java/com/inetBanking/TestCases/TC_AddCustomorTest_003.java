package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.AddCustmorPage;
import com.inetBanking.pageobject.loginpage;

public class TC_AddCustomorTest_003 extends BaseClass {
	@Test
	public void addNewCustmor() throws InterruptedException, IOException
	{
		loginpage lp=new loginpage(driver);
		lp.setusername(Username);
		lp.setpassword(Password);
		lp.clicksubmit();
		Thread.sleep(3000);
		
		AddCustmorPage addcust=new AddCustmorPage(driver);
		addcust.clickaddnewcustmor();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		addcust.custName("Ajinkya");
		addcust.custgender("male");
		addcust.custdob("22", "05", "1990");
		Thread.sleep(5000);
		addcust.custaddress("Mantri Nagar");
		addcust.custcity("pune");
		addcust.custState("Maharashtra");
		addcust.custpinno("413512");
		addcust.custTelephoneNo("0238523145");
		
		String email=randomstring()+"@gmail.com";
		addcust.custEmailID(email);
		
		addcust.custpassword("Ajinkya111");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			capturescreen(driver,"successfullyaddnewcustmor");
			Assert.assertTrue(true);
			
		}
		else
		{
			capturescreen(driver, "addNewCustmor");
			Assert.assertFalse(false);
			
		}
	}

}
