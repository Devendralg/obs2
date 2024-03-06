package taskTy;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.DatabaseUtils;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.JavaUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class Amazon {

	public static void main(String[] args)
	{
		DatabaseUtils db = new DatabaseUtils();
		ExcelUtils ex = new ExcelUtils();
		FileUtilss fp = new FileUtilss();
		WebdriverUtils wd = new WebdriverUtils();
		JavaUtils j = new JavaUtils();
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		wd.waitForPageLoad(driver, 40);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		wd.enterData(driver, "//input[@id='twotabsearchtextbox']", "samsung phones");
		wd.clik(driver, "//input[@id='nav-search-submit-button']");
		
		LinkedHashMap<String, Integer>map = new LinkedHashMap<String, Integer>();
		
		
		List<WebElement> phones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(phones.size());
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(prices.size());
		
		for(int i=0; i<prices.size(); i++)
		{
			WebElement pr = prices.get(i);
			String ptext = pr.getText();
			int finalPrice = Integer.parseInt(ptext.replaceAll(",", ""));
		//	System.out.println(finalPrice);
			
		
			String name = phones.get(i).getText();
			
			//System.out.println(finalPrice);
			
			if(finalPrice < 20000 && name.contains("Samsung") )
			{
				
				System.out.println(finalPrice+"  " +name);
			}
			
			
			
			
		}
		
		
	
		

	}

}
