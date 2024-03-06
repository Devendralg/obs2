package staffModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.OjectRepository.StaffHomePage;
import com.obs.generic.utilities.BaseClass;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.IpathConstants;

public class LoadDataIntoExcel extends BaseClass
{
	@Test
	public void getData() throws IOException
	{
		StaffHomePage sh = new StaffHomePage(driver);
		sh.getViewActiveCustomerBtn().click();
		
		List<WebElement> names = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> customerID = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> AccountNumber = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		List<WebElement> phoneNumber = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		List<WebElement> emailID = driver.findElements(By.xpath("//tbody/tr/td[6]"));
		List<WebElement> dob = driver.findElements(By.xpath("//tbody/tr/td[7]"));
		List<WebElement> PAN = driver.findElements(By.xpath("//tbody/tr/td[9]"));
		List<WebElement> DebitCardNumber = driver.findElements(By.xpath("//tbody/tr/td[11]"));
		
			
		for (int i = 0; i <=50; i++)
		{
			String name = names.get(i).getText();
			String Dob = dob.get(i).getText();
			String Pan = PAN.get(i).getText();
			String ph = phoneNumber.get(i).getText();
			String acn	 = AccountNumber.get(i).getText();
			String cid = customerID.get(i).getText();
			String dc = DebitCardNumber.get(i).getText();
			String email = emailID.get(i).getText();
			
			devLogicExcel("cd", name, Dob, Pan, ph, acn, cid, dc, email);
			
		}						
		
		
	}
	public void devLogicExcel(String sheetName,String name,String dob,String pan,String ph,String accNo,String cid,String Debit,String email) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.createRow(lastRowNum+1);
		row.createCell(0).setCellValue(name);
		row.createCell(1).setCellValue(dob);
		row.createCell(2).setCellValue(pan);
		row.createCell(3).setCellValue(ph);
		row.createCell(4).setCellValue(accNo);
		row.createCell(5).setCellValue(cid);
		row.createCell(6).setCellValue(Debit);
		row.createCell(7).setCellValue(email);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}


}
