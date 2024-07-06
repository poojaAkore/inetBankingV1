package com.inetBanking.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig  {
	
	Properties pro;
	
	public Readconfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			}catch(Exception e)
		{
				System.out.println("Exception is " + e.getMessage());
		}
		}
	
	
	public String getApplicationURl()
	{
		String url=pro.getProperty("BaseUrl");
		return url;
	}
	public String getApplicationUsername()
	{
		String username=pro.getProperty("USERNAME");
		return username;
	}
	
	public String getApplicationPassword()
	{
     String password=pro.getProperty("Password");
     return password;
	}
	public String getApplicationChromePath()
	{
	String Chrome=pro.getProperty("CHROMEPATH")	;
	return Chrome;
	}
	public String getApplicationEdgePath()
	{
	String Edgepath=pro.getProperty("EDGEPATH")	;
	return Edgepath;
	}
	
}
 