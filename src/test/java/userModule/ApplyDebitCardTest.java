package userModule;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;

public class ApplyDebitCardTest {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		ExcelUtils ex = new ExcelUtils();
		FileUtilss fp = new FileUtilss();
		WebdriverUtils wd = new WebdriverUtils();

		String Url = fp.readDataFromProperyFile("url");
		WebDriver driver = new FirefoxDriver();
		wd.maximizeWindow(driver);
		driver.get(Url);
		wd.waitForPageLoad(driver, 30);
		
		WebElement adc = wd.webElement(driver, "//li[text()='Apply Debit Card']");
		wd.scrollToElement(driver, adc);
		adc.click();
		
		
	List<WebElement> elements = driver.findElements(By.xpath("//form/input"));	
		for (int i = 0; i < elements.size()-1; i++) 
		{
			if(i==1)
			{
				WebElement ele = elements.get(i);
				String avalue = ele.getAttribute("name");
				WebElement eAdress = driver.findElement(By.name(avalue));

				String date = ex.readDataFromExcelFile("Ad", i, 0);
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value=arguments[1]",eAdress,date );
			}else 
			{
			WebElement ele = elements.get(i);
			String avalue = ele.getAttribute("name");
			WebElement text = driver.findElement(By.name(avalue));
			String data = ex.readDataFromExcelFile("Ad", i, 0);
			text.sendKeys(data);
			}
			
		}
		wd.clik(driver, "//input[@name='dbt_crd_submit']");
		String text = wd.alertSwitch(driver).getText();
		System.out.println(text);
		wd.acceptAlert(driver);
		driver.quit();
		

		
	}

}
