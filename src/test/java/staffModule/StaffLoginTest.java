package staffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaffLoginTest {
	static WebDriver driver;
	public static void clik(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void main(String[] args) throws IOException {
		
		launchUrl();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String staffid = p.getProperty("staffId");
		String pwd = p.getProperty("password");
		driver.get(url);
		clik("//a[text()='Staff Login']");
		driver.findElement(By.className("customer_id")).sendKeys(staffid);
		driver.findElement(By.className("customer_id")).sendKeys(pwd,Keys.ENTER);
		
	}

	public static void launchUrl() {
		
	}

}
