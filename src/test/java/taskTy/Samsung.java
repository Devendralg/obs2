package taskTy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.DatabaseUtils;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;

public class Samsung {

	public static void main(String[] args) {
		DatabaseUtils db = new DatabaseUtils();
		ExcelUtils ex = new ExcelUtils();
		FileUtilss fp = new FileUtilss();
		WebdriverUtils wd = new WebdriverUtils();
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		wd.waitForPageLoad(driver, 40);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		wd.enterData(driver, "//input[@id='twotabsearchtextbox']", "samsung phones");
		wd.clik(driver, "//input[@id='nav-search-submit-button']");


	}

}
