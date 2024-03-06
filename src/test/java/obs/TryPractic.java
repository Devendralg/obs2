package obs;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OjectRepository.CustomerRegistrationFormPage;
import com.OjectRepository.HomePage;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.WebdriverUtils;

public class TryPractic {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new FirefoxDriver();
		WebdriverUtils wd=new WebdriverUtils();
		ExcelUtils ex=new ExcelUtils();
		HomePage h=new HomePage(driver);
		CustomerRegistrationFormPage r = new CustomerRegistrationFormPage(driver);
		FileUtilss fs = new FileUtilss();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		h.getOpenAccountbtn().click();
		r.customerRegistrationData(driver, "NewData1", 1,4);
		
		
		
	}

}
