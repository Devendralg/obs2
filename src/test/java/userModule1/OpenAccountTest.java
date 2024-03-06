package userModule1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.OjectRepository.CustomerRegisterConfirmPage;
import com.OjectRepository.CustomerRegistrationFormPage;
import com.OjectRepository.HomePage;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;


public class OpenAccountTest {

	@Test (invocationCount = 2)
	public void openAccount() throws IOException 
	{	FileUtilss fu = new FileUtilss();
		ExcelUtils eLib = new ExcelUtils();
		WebdriverUtils wLib = new WebdriverUtils();
		
		String sheetName ="D1";
		WebDriver driver = new FirefoxDriver();
		driver.get(fu.readDataFromProperyFile("url"));
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 30);
		//Click On Open Account
		HomePage hp = new HomePage(driver);
		hp.getOpenAccountbtn().click();
		
		//Enter Customer Details and submit
		CustomerRegistrationFormPage cr = new CustomerRegistrationFormPage(driver);
		cr.customerRegistrationData(driver, sheetName, 1, 4);
		cr.getRegisterFormSubmitBtn().click();
		
		//Verify Details And Confirm
		CustomerRegisterConfirmPage crc = new CustomerRegisterConfirmPage(driver);
		crc.getConfirmBtn().click();
		
		//Get Application Number Store it in Excel 
		String text = wLib.alertSwitch(driver).getText();
		String applicationNumber = crc.getApplicationNumber(text);
		
	//	org.testng.Assert.assertNotNull(applicationNumber, "Application should be Present");
		eLib.writeDataIntoExistingExcel("can", 0, applicationNumber);
	

		wLib.acceptAlert(driver);
		driver.close();
		
		
		
		
	}

}
