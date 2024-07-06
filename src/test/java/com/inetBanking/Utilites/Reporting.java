package com.inetBanking.Utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	   
		public ExtentSparkReporter htmlreporter;
	    public ExtentReports extent;
	    public ExtentTest logger;
	    
	    
	    public void onStart(ITestContext testcontext)
	    {
	    String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
	    String repname="Test-Report-"+timestamp+".html";
	    htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname);//specify location
	    try {
			htmlreporter.loadXMLConfig(System.getProperty("user.dir")+ "/inetbankingV1_extent-config.xml/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      extent = new ExtentReports();
	      extent.attachReporter(htmlreporter);
	      extent.setSystemInfo("Hostname", "Localhost");
	      extent.setSystemInfo("Environment", "QA");
	      extent.setSystemInfo("user", "Pooja");
	      
	      htmlreporter.config().setDocumentTitle("InetBanking TestProject");//title of report
	      htmlreporter.config().setReportName("Functional Test Name");//Test Name
	     // htmlreporter.config().setTestViewChartLocation(chartLocation.Top);//location of the chart
	      htmlreporter.config().setTheme(Theme.DARK);
	    }
	    
	    public void OnTestSuccess(ITestResult tr)
	    {
	    	logger=extent.createTest(tr.getName());//create new entry in the report
	    	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	    }
	    
	    public void OnTestFailure(ITestResult tr)
	    {
	    	logger=extent.createTest(tr.getName());//create new entry in the report
	    	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	    	
	    	String ScreenShotPath=System.getProperty("user.dir")+"\\ScreenShot\\"+tr.getName()+".png";
	    	File F=new File(ScreenShotPath);
	    	
	    	if(F.exists())
	    	{
	    		logger.fail("ScreenShot is below" + logger.addScreenCaptureFromPath(ScreenShotPath));
	    	}
	     }
	    
	    public void OnTestSkipped(ITestResult tr)
	    {
	    	logger=extent.createTest(tr.getName());//create new entry in the report
	    	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	    }
	    
	    public void OnFinish(ITestContext TestContext)
	    {
	    	extent.flush();
	    }

}
