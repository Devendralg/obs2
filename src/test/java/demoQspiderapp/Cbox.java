package demoQspiderapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Cbox {
	@Test
	public void test() throws InterruptedException
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://demoapps.qspiders.com/ui/?scenario=1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[contains(@class,'pt')]/div[1]//li[7]")).click();
		Thread.sleep(2000);
		List<WebElement> cbox = driver.findElements(By.xpath("//form//main/div/input"));
		for(WebElement w : cbox)
		{
			w.click();
			Thread.sleep(2000);
		}
		List<WebElement> cboxn = driver.findElements(By.xpath("//form//main/div/span"));

		for(WebElement w:cboxn)
		{
			System.out.println(w.getText());
		}
	}

}
