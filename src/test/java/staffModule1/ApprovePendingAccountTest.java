package staffModule1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OjectRepository.PendingCustomerPage;
import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;


public class ApprovePendingAccountTest extends BaseClass {
	int rowNumber =1;
	
	@Test (groups = "regression",invocationCount = 	2)
	public void approvePendingAccount() throws IOException, EncryptedDocumentException, InterruptedException
	{
		//int rowNumber = 1;

	
	
		//Approve pending account and getAccount Number
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getApprovePendingAccountBtn().click();
		Reporter.log("Clicked On Approve Pending Account ", true);

		PendingCustomerPage pc = new PendingCustomerPage(driver);

		//	pc.approvePendingAcc(driver, rowNumber);
		String appNo = eLib.readDataFromExcelFile("can", rowNumber, 0);
		Reporter.log("Got Application Number From Excel ", true);

		pc.getApplicationNumberTxtfield().sendKeys(appNo);
		pc.getSearchBtn().click();
		Reporter.log("Entered Application Number And Clicked On Search Button", true);

		
	// wd.isAlertPresent(driver);
		
		try
		{
			String text = wLib.alertSwitch(driver).getText();
		//	System.out.println(text);
			eLib.writeData("can", rowNumber, 1, "Approved");

			Assert.assertEquals(text, "Application not found", "Already approved application");
			wLib.acceptAlert(driver);
			rowNumber++;
			
			
			

		}catch(NoAlertPresentException e)
		{
			pc.getApproveBtn().click();
			
		}
		try {
			String alertText = wLib.alertSwitch(driver).getText();
			String accountNumber = wLib.getAlertNumber(alertText);
	
			//eLib.writeApproved("ApplicationNumber",rowNumber,"Approved");
			
			Assert.assertNotNull(accountNumber);
			eLib.writeData("can", rowNumber, 2, accountNumber);
			eLib.writeData("can", rowNumber, 1, "Approved");
			Reporter.log("Write Approved Infornt of Application Number", true);
		//	Assert.assertEqual("Account Number Should be Generated", accountNumber);
		//	Assert.assertNotNull(accountNumber, "Account Number Should be Present");
			wLib.acceptAlert(driver);
			rowNumber++;

		}catch(NoAlertPresentException e)
		{
			e.printStackTrace();
		}
			
		
		
		
		}
}
