package staffModule;

import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;

@Listeners(com.obs.generic.utilities.ItestListnerImplementationClass.class)
public class StaffCreditTest extends BaseClass
{
	@Test
	public void creditCustomer()
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getCreditCustomerBtn().click();
		Reporter.log("Clicked On Credit Customer Button", true);
		fail();
	}

}
