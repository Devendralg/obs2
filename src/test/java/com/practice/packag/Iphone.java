package com.practice.packag;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class Iphone {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		List<WebElement> name = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		
		ExcelUtils e = new ExcelUtils();
		for(int i=0; i<name.size(); i++)
		{
			String names = name.get(i).getText();
			String price = prices.get(i).getText();
			e.writeDataFlipkart("iphone", i, names, price);
					
		}
		
		
	}

}
