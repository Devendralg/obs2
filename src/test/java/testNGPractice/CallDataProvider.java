package testNGPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OjectRepository.CustomerLoginPage;
import com.OjectRepository.HomePage;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;

public class CallDataProvider {
	
	@Test (dataProvider = "data")
	public void login(String a,String b) throws IOException, InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		FileUtilss fp = new FileUtilss();
		String URL = fp.readDataFromProperyFile("url");
		WebdriverUtils wd = new WebdriverUtils();
		wd.maximizeWindow(driver);
		driver.get(URL);
		wd.waitForPageLoad(driver, 30);
		
		//Thread.sleep(500);
		HomePage hp = new HomePage(driver);
		hp.getInternetBankingbtn().click();
	//	wd.mouseOverOnElement(driver, hp.getInternetBankingbtn());
	//	wd.mouseOverOnElement(driver, );
		
		hp.getEbankLogin().click();
		CustomerLoginPage cl = new CustomerLoginPage(driver);
		cl.getCustomerIdTxt().sendKeys(a);
		cl.getCustomerPwdTxt().sendKeys(b);
		cl.getCustomerLoginBtn().click();
		
		try {
		Alert alertText = wd.alertSwitch(driver);
		System.out.println(alertText.getText());
		wd.acceptAlert(driver);
		driver.quit();
		}catch(NoAlertPresentException e)
		{
			String title = driver.getTitle();
			if(title.contains("My Profile"))
			{
				System.out.println("TC Pass");
				driver.quit();
			}else
			{
				System.out.println("TC Fail");
				driver.quit();
			}

		}
		
			
		
		
		
	}
	
		
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
		ExcelUtils ex = new ExcelUtils();
		Object[][] dataPrividertwoTwo = ex.dataPrividertwoTwo("customerLogin");
		return dataPrividertwoTwo;
	}

}
