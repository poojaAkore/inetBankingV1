package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilites.XLUtils;
import com.inetBanking.pageobject.loginpage;

public class TC_LoginDDTTest002  extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		loginpage lp=new loginpage(driver);
		lp.setusername(user);
		lp.setpassword(pwd);
		lp.clicksubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
		
		boolean isAlertPresent() {
			
			try {
			driver.switchTo().alert();
			return true ;
			}
			catch(NoAlertPresentException e)
			{
				return false ;
			}
		}
		
		@DataProvider(name="LoginData")
		String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		
		
	

}

	
}
