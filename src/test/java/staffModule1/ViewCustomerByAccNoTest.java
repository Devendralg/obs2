package staffModule1;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.OjectRepository.ViewCustomerByAccountNumberPage;
import com.obs.generic.utilities.BaseClass;

public class ViewCustomerByAccNoTest extends BaseClass
{
	@Test (groups = "smoke",retryAnalyzer = com.obs.generic.utilities.IRetryAnalyzerImplimentationClass.class)
	public void viewCustomerByAccNo() throws EncryptedDocumentException, IOException
	{
		int rowNumber=1;
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getViewCustomerByAccBtn().click();
		ViewCustomerByAccountNumberPage vc = new ViewCustomerByAccountNumberPage(driver);
		String accNo = eLib.readDataFromExcelFile("AccountNumber", rowNumber, 0);
		vc.viewCustomer(accNo);
		fail();
		
	}
	
	@Test (groups = "smoke")
	public void viewActiveCustomer()
	{
		StaffHomePage sp = new StaffHomePage(driver);
		sp.getViewActiveCustomerBtn().click();
		
		
	}

}
