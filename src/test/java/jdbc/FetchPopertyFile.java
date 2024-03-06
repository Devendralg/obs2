package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchPopertyFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		System.out.println(browser);
		String url = p.getProperty("url");
		System.out.println(url);
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		System.out.println(username);
		System.out.println(password);
		


		if(browser.contains("chrome"))
		{
			 driver = new ChromeDriver();
		}else if(browser.contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		
	}

}
