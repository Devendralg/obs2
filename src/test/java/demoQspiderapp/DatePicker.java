package demoQspiderapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DatePicker {
	static WebDriver driver;
	static String day="29";
	static String monthYear = "October 2024";


	public static void main(String[] args) throws InterruptedException, ParseException {
		FirefoxOptions opt= new FirefoxOptions();
		opt.addArguments("--start-maximized");
		driver = new FirefoxDriver(opt);
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	clik("//p[text()='UI Testing Concepts']");
		clik("//section[text()='Date & Time Picker']");
		Thread.sleep(1000);
		clik("//section[text()='Date Picker']");
		Thread.sleep(2000);
		clik("//input[@placeholder='Select A Date']");
		
//			Calendar calendar =Calendar.getInstance();
//			String currentMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM yyyy");
//			Date formatteddate = simpleDateFormat.parse(currentMonthYear);
//			calendar.setTime(formatteddate);
//			 int month = calendar.get(Calendar.MONTH);
//			 int year = calendar.get(Calendar.YEAR);
//			 
//			 System.out.println(month);
//			 System.out.println(year);

			 Calendar calendar = Calendar.getInstance();
			 String currentMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();

			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MON YYYY");
			 try {
			     Date formattedDate = simpleDateFormat.parse(currentMonthYear);
			     calendar.setTime(formattedDate);
			     calendar.setLenient(true);
			     int month = calendar.get(Calendar.MONTH);
			     int year = calendar.get(Calendar.YEAR);

			     System.out.println(month);
			     System.out.println(year);
			 } catch (ParseException e) {
			     System.err.println("Error parsing date: " + currentMonthYear);
			     e.printStackTrace();
			 }
	//a	clik("//div[text()='"+day+"']");
		
		
	}

	public static void clik(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		
	}

}
