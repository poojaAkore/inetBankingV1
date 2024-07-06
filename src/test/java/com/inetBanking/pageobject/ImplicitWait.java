package com.inetBanking.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajinkya\\Desktop\\Grid\\chromedriver.exe");
		//step-1 Launch browser
		 WebDriver  driver=new ChromeDriver();
			
			//Step-2 Maximize window
			driver.manage().window().maximize();
			
			//step-3
			driver.get("https://opensource-demo.orangehrmlive.com/");
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
			

	}

}
