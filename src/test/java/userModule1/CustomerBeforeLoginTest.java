package userModule1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.DebitCardFormPage;
import com.OjectRepository.HomePage;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;

public class CustomerBeforeLoginTest {
	public int rownumber =32;
	
		@Test (invocationCount = 10)
		public void applyDebitCard() throws IOException
		{
			
			WebdriverUtils wLib = new WebdriverUtils();
			ExcelUtils eLib = new ExcelUtils();
		//Launch Browser
		WebDriver driver = new FirefoxDriver();
		WebdriverUtils wd = new WebdriverUtils();

		//Maximize browser
		wd.maximizeWindow(driver);
		//Url Launch
		FileUtilss f=new FileUtilss();
		driver.get(f.readDataFromProperyFile("url"));
		wd.waitForPageLoad(driver, 30);
		
		HomePage hp = new HomePage(driver);
		hp.getApplyDebitbtn().click();
		DebitCardFormPage df = new DebitCardFormPage(driver);
		List<WebElement> textfields = driver.findElements(By.xpath("//input"));
		
			
			for (int j = 0; j < 5; j++) 
			{
				WebElement textf = textfields.get(j);
				String data = eLib.readDataFromExcelFile("cd", rownumber, j);
				wLib.jsSendText(driver, textf, data);
			}
			df.getDebitCardSubmitBtn().click();
			try {
				String text = wLib.alertSwitch(driver).getText();
				Reporter.log(text, true);
				
				String debitcardNumber = wLib.extractDebitCardNumber(text);
				String pinNumber = wLib.extractPinNumber(text);
				
				System.out.println("Debit Card Number : "+debitcardNumber);
				System.out.println("Debit Pin : "+pinNumber);
				eLib.writeDebitPin("cd", rownumber, debitcardNumber, pinNumber);
				
				wLib.acceptAlert(driver);		
				rownumber++;
			}catch(NoAlertPresentException e)
			{
				e.printStackTrace();
			}
		
		}
		
		@Test
		public void eBankRegistration() throws IOException, InterruptedException
		{
			WebdriverUtils wLib = new WebdriverUtils();
			ExcelUtils eLib = new ExcelUtils();
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		WebdriverUtils wd = new WebdriverUtils();

		//Maximize browser
		wd.maximizeWindow(driver);
		//Url Launch
		FileUtilss f=new FileUtilss();
		driver.get(f.readDataFromProperyFile("url"));
		wd.waitForPageLoad(driver, 30);
		
		HomePage hp = new HomePage(driver);
		wLib.scrollToElement(driver, hp.getInternetBankingbtn());
		wLib.mouseOverOnElement(driver, hp.getInternetBankingbtn());
		wLib.mouseOverAndClickOnElement(driver, hp.getEbankRegister());
	//	wLib.mouseOverOnElement(driver, hp.getEbankRegister());
			
	//	List<WebElement> textfields = driver.findElements(By.xpath("//input"));
		
		

		
		

		}

}
