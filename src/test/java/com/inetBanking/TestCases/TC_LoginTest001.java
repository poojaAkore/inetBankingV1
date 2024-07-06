package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.loginpage;

public class TC_LoginTest001 extends BaseClass {
	
	@Test
	public void LoginTest()
	{
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		
		loginpage lp=new loginpage(driver);
		lp.setusername(Username);
		lp.setpassword(Password);
		lp.clicksubmit();
		
		String ActTitle=driver.getTitle();
		System.out.println(ActTitle);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}

}
