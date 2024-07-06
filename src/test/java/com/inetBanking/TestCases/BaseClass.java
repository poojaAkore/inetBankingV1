package com.inetBanking.TestCases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilites.Readconfig;


public class BaseClass {

	Readconfig ReadConfig=new Readconfig();
	public String BaseUrl=ReadConfig.getApplicationURl();
	public String Username=ReadConfig.getApplicationUsername();
	public String Password=ReadConfig.getApplicationPassword();
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("defaultBrowser") String br)
	{
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", ReadConfig.getApplicationChromePath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",ReadConfig.getApplicationEdgePath());
			driver=new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BaseUrl);
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot)driver;
		File source=tc.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") +"\\ScreenShot\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
		
	}
	
	public String randomstring()
	{
		String genratedstring=RandomStringUtils.randomAlphabetic(8);
		return(genratedstring);
	}
	public static String randomnum()
	{
		String genratedstring2=RandomStringUtils.randomAlphanumeric(4);
		return(genratedstring2);
	}
}
