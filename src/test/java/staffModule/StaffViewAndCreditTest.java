package staffModule;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;

public class StaffViewAndCreditTest extends BaseClass
{
	@Test
	public void viewActiveCustomer()
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getViewActiveCustomerBtn().click();
		Reporter.log("Clicked On View Active Customer", true);
	}
	@Test
	public void viewCustByAccNo()
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getViewCustomerByAccBtn().click();
		Reporter.log("Clicked On View Customer Account Number", true);
	}

}
