package staffModule1;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;

@Listeners(com.obs.generic.utilities.ItestListnerImplementationClass.class)
public class ViewAtiveCustomerTest extends BaseClass
{
	@Test (groups = "regression")//retryAnalyzer = com.obs.generic.utilities.IRetryAnalyzerImplimentationClass.class)
	public void viewActiveCustomer()
	{
		StaffHomePage sp = new StaffHomePage(driver);
		sp.getViewActiveCustomerBtn().click();
		fail();
		
	}

}
