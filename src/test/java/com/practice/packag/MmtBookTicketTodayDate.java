package com.practice.packag;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MmtBookTicketTodayDate {
	static WebDriver driver;
	public static void clickk(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		Thread.sleep(5000);
		act.doubleClick().click().perform();
		Thread.sleep(2000);
		clickk("//span[text()='Buses']");
		clickk("//input[@id='travelDate']");
		calendar("June 2024",15 );
		
	
//		String MontAndYear="March 2024";
//		int day=15;
//		driver.findElement(By.xpath("//div[text()='"+MontAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+day+"']")).click();
//		
		
		
		
		
		
		}

	private static void calendar(String MontAndYear,int day) {
		 
	
		for(;;) 
		{
			try {
		driver.findElement(By.xpath("//div[text()='"+MontAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+day+"']")).click();
		break;
			}catch(Exception e)
			{
				clickk("//span[@aria-label='Next Month']");
			}
			
		}
		
		
		
		
	}

}
