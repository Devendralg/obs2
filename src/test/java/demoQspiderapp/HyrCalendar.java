package demoQspiderapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HyrCalendar {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
//		Calendar cal= Calendar.getInstance();
//		Date d=new Date();
//		System.out.println(d);

		
		driver.findElement(By.id("second_date_picker")).click();

		selectDate(driver,"11-Mar-2024","dd-MMM-yyy");
		
		}

	public static void selectDate(WebDriver driver,String targetDate,String format ) throws Exception {
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat targetDateFormat=new SimpleDateFormat(format);
		Date formattedTargetDate;
		
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			cal.setTime(formattedTargetDate);
			
			int tagetDay = cal.get(Calendar.DAY_OF_MONTH);
			int targetMonth = cal.get(Calendar.MONTH);
			int targetYear = cal.get(Calendar.YEAR);
			
			Thread.sleep(2000);
			String actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			cal.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
				
				int actualMonth = cal.get(Calendar.MONTH);
				int actualYear = cal.get(Calendar.YEAR);
				
				while(targetMonth < actualMonth || targetYear < actualYear)
				{
					driver.findElement(By.className("ui-datepicker-prev")).click();
					actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
					cal.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
					
					actualMonth = cal.get(Calendar.MONTH);
					actualYear = cal.get(Calendar.YEAR);
				}
			
				while(targetMonth > actualMonth || targetYear > actualYear)
				{
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
					cal.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
					
					actualMonth = cal.get(Calendar.MONTH);
					actualYear = cal.get(Calendar.YEAR);
				}
				
				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not (contains(@class,' ui-datepicker-other-month '))]/a[text()='"+tagetDay+"']")).click();
			
			
			
		
		}catch(ParseException e)
		{
			throw new Exception("Invalid date Input");
	    }

		
	}

}
