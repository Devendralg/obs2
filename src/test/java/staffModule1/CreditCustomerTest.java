package staffModule1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.CreditCustomerPage;
import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;

public class CreditCustomerTest extends BaseClass
{
	
	@Test //(groups = "smoke")
	public void creditCustomer() throws EncryptedDocumentException, IOException
	{
		int rowNumber=2;
		
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getCreditCustomerBtn().click();
		Reporter.log("Clicked On Credit Customer Button", true);
		
		CreditCustomerPage ccp = new CreditCustomerPage(driver);
		String getAccNo = eLib.readDataFromExcelFile("AccountNumber", rowNumber, 0);
		String getAmount = eLib.readDataFromExcelFile("AccountNumber", rowNumber, 1);
		System.out.println(getAccNo);
		System.out.println(getAmount);
		ccp.creditAmount(getAccNo, getAmount);
		try
		{
			String text = wLib.alertSwitch(driver).getText();
			Reporter.log(text, true);
			wLib.acceptAlert(driver);
			
		}catch(NoAlertPresentException e)
		{
			System.out.println(e.getMessage());
		}
		
		

	}
	
	
	
}
