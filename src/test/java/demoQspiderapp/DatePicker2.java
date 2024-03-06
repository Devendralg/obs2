package demoQspiderapp;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DatePicker2
{
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		FirefoxOptions opt=new FirefoxOptions();
		opt.addArguments("--start-maximized");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		
		clik("//input[@placeholder='Select A Date']");
		//String targetMonthYear ="June 2024";
		
		Calendar calendar = Calendar.getInstance();
		String targetDate ="12 June 2023";
		SimpleDateFormat targetDateFormat=new SimpleDateFormat();
		Date formatedDate ;
		try {
		targetDateFormat.setLenient(true);
		formatedDate = targetDateFormat.parse(targetDate);
		calendar.setTime(formatedDate);
		
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		
		System.out.println(targetDay);
		System.out.println(targetMonth);
		System.out.println(targetYear);
		
		String currentMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();
		calendar.setTime(new SimpleDateFormat().parse(currentMonthYear));
		 int actualMonth = calendar.get(Calendar.MONTH);
		 int actualYear = calendar.get(Calendar.YEAR);
		 
		 while(targetMonth < actualMonth || targetYear < actualYear)
		 {
			 currentMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();
				calendar.setTime(new SimpleDateFormat().parse(currentMonthYear));
				  actualMonth = calendar.get(Calendar.MONTH);
				 actualYear = calendar.get(Calendar.YEAR);
				 
				 clik("//button[@aria-label='Previous Month']");

		 }
		clik("//div[@class='react-datepicker__month']/*//div[not (contains(@class,'day--outside-month')) and text()='"+targetDay+"']");
		System.out.println(currentMonthYear);
		
		}catch(Exception e)
		{
			
		}
	}

	private static void clik(String xpath) 
	{			
		driver.findElement(By.xpath(xpath)).click();
	}

}
