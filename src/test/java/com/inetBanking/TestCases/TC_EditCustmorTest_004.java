package com.inetBanking.TestCases;

import org.testng.annotations.Test;


import com.inetBanking.pageobject.EditCustmorPage;
import com.inetBanking.pageobject.loginpage;

public class TC_EditCustmorTest_004 extends BaseClass{
	
	@Test
	public void editcustmor() throws InterruptedException
	{
		loginpage lp=new loginpage(driver);
		lp.setusername(Username);
		lp.setpassword(Password);
		lp.clicksubmit();
		Thread.sleep(3000);
		
		EditCustmorPage editpage=new EditCustmorPage(driver);
		editpage.EditCustmor();
		
		editpage.custmorId("10424");
		editpage.Submit();
		Thread.sleep(3000);
		
		
		
		editpage.ChangeCity("Banglore");
		editpage.Updatebtn();
		
		
	}

}
