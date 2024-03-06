package staffModule;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.OjectRepository.StaffLoginPage;
import com.obs.generic.utilities.BaseClass;

public class StaffApproveAndDeleteTest extends BaseClass
{
	@Test
	public void approvePending()
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getApprovePendingAccountBtn().click();
		 Reporter.log("Clicked On Approve Pending Button", true);

		
	}
	@Test
	public void deleteCustomer()
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getDeleteCustomer().click();
		 Reporter.log("Clicked On Delete Customer Button", true);

	}

}
