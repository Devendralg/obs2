package userModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.obs.generic.utilities.DatabaseUtils;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.JavaUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class FundTranferTest {

	public static void main(String[] args) throws IOException, InterruptedException
	{
	//	DatabaseUtils db = new DatabaseUtils();
		ExcelUtils ex = new ExcelUtils();
		FileUtilss fp = new FileUtilss();
		WebdriverUtils wd = new WebdriverUtils();
	//	JavaUtils j = new JavaUtils();

		//Launch Browser
		String Url = fp.readDataFromProperyFile("url");
		WebDriver driver = new FirefoxDriver();
		wd.maximizeWindow(driver);
		driver.get(Url);
		wd.waitForPageLoad(driver, 30);
		WebElement ft = driver.findElement(By.xpath("//li[text()='Fund Transfer']"));
		wd.scrollToElement(driver, ft);
		ft.click();
		String cid = ex.readDataFromExcelFile("Sheet2", 0, 1);
		String pwd = ex.readDataFromExcelFile("Sheet2", 1, 1);
		wd.enterData(driver, "//input[@name='customer_id']", cid);
		wd.enterData(driver, "//input[@name='password']", pwd);
		wd.clik(driver, "//input[@name='login-btn']");
		wd.clik(driver, "//li[text()='Fund Transfer']");
		wd.clik(driver, "//input[@name='add_beneficiary']");
		String name = ex.readDataFromExcelFile("Bd", 0, 0);
		String accN = ex.readDataFromExcelFile("Bd", 0, 2);
		String ifsc = ex.readDataFromExcelFile("Bd", 0, 9);
		
		wd.enterData(driver, "//input[@name='beneficiary_name']",name);
		wd.enterData(driver, "//input[@name='beneficiary_acno']",accN);
		wd.enterData(driver, "//input[@name='Ifsc_code']",ifsc);
		WebElement dd = driver.findElement(By.xpath("//select[@name='beneficiary_acc_type']"));
		wd.selectOption(dd, "Saving");
		wd.clik(driver, "//input[@name='add_beneficiary_btn']");
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		wd.acceptAlert(driver);
		wd.clik(driver, "//li[text()='Fund Transfer']");
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='beneficiary']"));
		wd.selectOption(dd2, " DevendraLG-1011541011891 ");
		wd.enterData(driver, "//input[@name='trnsf_amount']", "500");
		wd.enterData(driver, "//input[@name='trnsf_remark']", "Return madu bhai");
		wd.clik(driver, "//input[@name='fnd_trns_btn']");
	//	String alert2 = driver.switchTo().alert().getText();
	//	System.out.println(alert2);
	//	wd.acceptAlert(driver);
		String text2 = driver.findElement(By.xpath("//label[@class='OTP_msg']")).getText();
		System.out.println(text2);
		String[] otpf = text2.split(":");
		String otp1 = otpf[1];
		System.out.println(otp1);
		
		wd.enterData(driver, "//input[@name='otpcode']", otp1);
		wd.clik(driver, "//input[@name='verify-btn']");
		String alert2 = driver.switchTo().alert().getText();
		System.out.println(alert2);
		wd.acceptAlert(driver);
		
		wd.clik(driver, "//a[text()='Staff Login']");
		String sid = fp.readDataFromProperyFile("staffId");
		String spwd = fp.readDataFromProperyFile("Password");
		
		wd.enterData(driver, "//input[@name='staff_id']", sid);
		wd.enterData(driver, "//input[@name='password']", spwd);
		Thread.sleep(2000);
		wd.clik(driver, "//input[@name='staff_login-btn']");
		wd.clik(driver, "//input[@name='view_cust_by_ac']");
		
		String accNumber = ex.readDataFromExcelFile("Bd", 0, 2);
		wd.enterData(driver, "//input[@name='account_no']", accNumber);
		wd.clik(driver, "//input[@name='submit_view']");
		
		WebElement balance = driver.findElement(By.xpath("//label[contains(.,'Available Balance')]"));
		
		wd.scrollToElement(driver, balance);
		
		String currentBalance = balance.getText();
		System.out.println(currentBalance);
		driver.quit();
		

		
	}

}
