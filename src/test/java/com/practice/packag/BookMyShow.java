package com.practice.packag;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.obs.generic.utilities.ExcelUtils;

public class BookMyShow {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.bookmyshow.com/buytickets/dune-part-two-bengaluru/movie-bang-ET00331567-MT/20240305");
		driver.manage().window().maximize();
		
		List<WebElement> names = driver.findElements(By.xpath("//a[@class=\"__venue-name\"]"));
		List<WebElement> times = driver.findElements(By.xpath("//a[@class=\"__venue-name\"]/ancestor::li[@class=\"list\"]//div[@class=\"showtime-pill-wrapper\"]"));
		
		ExcelUtils e = new ExcelUtils();
		for (int i = 0; i < names.size(); i++) 
		{
			String name = names.get(i).getText();
			System.out.println(name);
			e.writeDataBookmyShow("BookMyShow", i, name);
			String time1 = times.get(i).getText();
			e.writeDataBookmyShowTimes("BookMyShow", i, 1, time1);
			
		}
		
	}

}
