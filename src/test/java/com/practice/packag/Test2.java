package com.practice.packag;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void test2()
	{
		WebDriver driver = new ChromeDriver();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			List<WebElement> allLinks = driver.findElements(By.xpath("//a | //link"));
			System.out.println(allLinks.size());
			for(WebElement link : allLinks)
			{
				String urllink = link.getAttribute("href");
				URL url = null;
				int StatusCode = 0;
				try {
					url= new URL(urllink);
					HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
					 StatusCode = httpConn.getResponseCode();
					 if(StatusCode >= 400 && urllink != null )
					 {
						System.out.println(urllink+"---->"+StatusCode); 
					 }
				}catch(Exception e)
				{
								//System.out.println(urllink+"---->"+StatusCode); 

				}
			}
			
		

	}

}
