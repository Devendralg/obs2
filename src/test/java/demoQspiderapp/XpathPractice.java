package demoQspiderapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		enterData("//input[@name='name' and @maxlength='10' ]","Devendra");
		enterData("//input[@name='name' and @maxlength='15' ]","LG");
		enterData("//label[text()='Email']/following-sibling::input[@type='text']","dev@gmailcom");
		enterData("//div[@class='container']/div[2]/input[@type='password']","12345");
		enterData("//label[text()='Repeat Password']/following-sibling::input[@type='password']","12345");
		clik("//button[text()='Register']");
	}

	private static void clik(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void enterData(String xpath,String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		
	}

}
