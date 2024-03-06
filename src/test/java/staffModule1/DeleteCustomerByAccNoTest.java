package staffModule1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.DeleteCustomerPage;
import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;

public class DeleteCustomerByAccNoTest extends BaseClass
{
	@Test (groups = "smoke")
	public void deleteCustomerByAccNo() throws EncryptedDocumentException, IOException
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getDeleteCustomer().click();
		DeleteCustomerPage dc = new DeleteCustomerPage(driver);
		String accNo = eLib.readDataFromExcelFile("cd", 0, 4);
		String cid = eLib.readDataFromExcelFile("cd", 0, 5);
		
		
		dc.deleteCustomer(accNo, cid, "no need");
		try {
			String text = wLib.alertSwitch(driver).getText();
			Reporter.log(text, true);
			wLib.acceptAlert(driver);
		}catch(NoAlertPresentException e)
		{
			e.printStackTrace();
		}
	}
}
