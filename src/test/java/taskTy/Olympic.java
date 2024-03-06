package taskTy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.WebdriverUtils;

public class Olympic {

	public static void main(String[] args) 
	{
WebdriverUtils wd = new WebdriverUtils();
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.olympics.com");
		wd.waitForPageLoad(driver, 40);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		
	}

}
