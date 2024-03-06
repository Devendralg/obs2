package moneyControl;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoneyControl {
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		driver=new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		driver.manage().window().maximize();
//		driver.get("https://www.moneycontrol.com/");
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
//		clik("//button[text()='No thanks']");
//		
//		WebElement personalFinance = driver.findElement(By.xpath("//a[text()='Personal Finance ']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(personalFinance);
//		clik("//a[contains(.,'Provident Fund Calculator')]");
//		
//		
		
		
		
	}


	private static void clik(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		
	}

}
