package com.practice.packag;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCommandTest {
	
	@Test
	public void readDataTest() throws InterruptedException
	{
		String url = System.getProperty("url");
		String uname = System.getProperty("uname");
		String pwd = System.getProperty("pwd");
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys(pwd,Keys.ENTER);
		driver.close();
		
	}
	@Test
	public void readDataTest2() throws InterruptedException
	{
		String url = System.getProperty("url");
		String uname = System.getProperty("uname");
		String pwd = System.getProperty("pwd");
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys(pwd,Keys.ENTER);
		driver.close();
		
	}

}
