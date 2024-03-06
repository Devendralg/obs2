package taskTy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.WebdriverUtils;

public class CricBuzz {

	public static void main(String[] args) {
		WebdriverUtils wd = new WebdriverUtils();
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.cricbuzz.com");
		wd.waitForPageLoad(driver, 40);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		wd.clik(driver, "//a[@id='live-scores-link']");
		wd.clik(driver, "//div[contains(@class,'cb-rank-tabs') ]/div[1]//a[text()='Scorecard']");
		
		

	}

}
