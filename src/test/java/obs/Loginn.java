package obs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginn {
	static WebDriver driver;
	@Test
	public void test()
	{
//		webTable();
//		radioButon();
		driver.findElement(By.xpath("//ul[contains(@class,'pt')]/div[1]//li[7]")).click();
		checkBox();
		
	}
	private void checkBox() {
		clickk("//ul[contains(@class,'pt')]/div[1]//li[7]");
	}
	@AfterMethod
	public void close()
	{
		//driver.close();
	}
	@BeforeMethod
	public void launchDemowebapp()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--start-maximized");
		driver=new ChromeDriver(opt);
		driver.get("https://demoapps.qspiders.com/ui/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	private void radioButon() {
		clickk("//section[text()='Radio Button']");
		clickk("//input[@value='Upi']");
		String value = driver.findElement(By.xpath("//input[@value='Upi']")).getAttribute("value");
		System.out.println(value);
		//checkbox
		clickk("//section[text()='Check Box']");
		
	}

	private void webTable() {
		clickk("//section[text()='Web Table']");
		List<WebElement> rowdata = driver.findElements(By.xpath("//tbody/tr[1]/td"));
		for(WebElement ele:rowdata)
		{
			System.out.println(ele.getText());
		}
		String text = driver.findElement(By.xpath("//tbody//tr[1]/th")).getText();
		System.out.println(text);
				
	}

	public static void clickk(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
}
