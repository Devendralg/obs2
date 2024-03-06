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

public class InternetBankingRegisterTest 
{
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
		
		
		wd.scrollXY(driver, 0, 250);
		WebElement ibank = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		wd.mouseOverOnElement(driver, ibank);
		Thread.sleep(2000);
		WebElement ibankRegister = driver.findElement(By.xpath("//li[text()='Register']"));

		wd.mouseOverAndClickOnElement(driver, ibankRegister);
		Thread.sleep(1000);
		wd.scrollXY(driver, 0, 250);
		
		List<WebElement> tags = driver.findElements(By.xpath("//form/input"));
		
		for (int i = 0; i < 10; i++)
		{
			if(i == 6) {
				WebElement webElement = tags.get(i);
				String nameValue = webElement.getAttribute("name");
				WebElement textAddress = driver.findElement(By.name(nameValue));
				String date = ex.readDataFromExcelFile("Ib", i, 0);
				 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value=arguments[1]",textAddress,date );
			}else
			{
				WebElement webElement = tags.get(i);
				String nameValue = webElement.getAttribute("name");
				WebElement textAddress = driver.findElement(By.name(nameValue));
				String data = ex.readDataFromExcelFile("Ib", i, 0);
				textAddress.sendKeys(data);
		
			}
		}
		Thread.sleep(1000);
		wd.scrollXY(driver, 0, 150);
		wd.clik(driver, "//input[@value='Submit']");	

	}

}
