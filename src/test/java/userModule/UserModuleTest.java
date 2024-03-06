package userModule;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.obs.generic.utilities.DatabaseUtils;
import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.FileUtilss;
import com.obs.generic.utilities.JavaUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class UserModuleTest
{
	static WebDriver driver;
	 


	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException, AWTException
	{
		DatabaseUtils db = new DatabaseUtils();
		ExcelUtils ex = new ExcelUtils();
		FileUtilss fp = new FileUtilss();
		WebdriverUtils wd = new WebdriverUtils();
		JavaUtils j = new JavaUtils();
		openAccount();
	//	Thread.sleep(2000);
		approveAccount();
	//	applyDebitCard();
		//fundTransfer();
	//	wd.acceptAlert(null);

	}

	public static void applyDebitCard() throws IOException, InterruptedException {
		
		Thread.sleep(1000);
		//scroll(driver, "Apply Debit Card");
		scrollXY(driver, 0, 250);
		clik("//li[text()='Apply Debit Card']");
		
		 WebElement dob = driver.findElement(By.name("dob"));
		 String dt = excelData("ApplyDebitDevendra",4,1);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]",dob,dt );
		
		
		  for(int i=0,tag=0; i<4; i++)
		  {
		  
		  String tname = excelData("ApplyDebitDevendra",i,tag);
		  WebElement txtf = driver.findElement(By.xpath("//input[@placeholder='"+tname+"']"));
		  
		  for (int j = 1; j <=1; j++) 
		  {
			  String dvalue = excelData("ApplyDebitDevendra",i,j);
			  txtf.sendKeys(dvalue); 
		     Thread.sleep(50);
		  		  
		  }
		  }
			scrollXY(driver, 0, 250);
			clik("//input[@name='dbt_crd_submit']");
			Alert alert = driver.switchTo().alert();
			String txt = alert.getText();
			String debitCardNumber="";
			int twelve=0;
			for (int i = 0; i <txt.length(); i++) {
				char ch =txt.charAt(i);
				if(Character.isDigit(ch))
				{
					twelve++;
					debitCardNumber=debitCardNumber+ch;
					if(twelve == 12)
					{
						break;
					}
				}
				
			}
			String DebitPin="";
			for (int i = 0; i <txt.length(); i++) {
				char ch =txt.charAt(i);
				if(Character.isDigit(ch))
				{
					twelve++;
					DebitPin=DebitPin+ch;
					
				}
				
			}
			String pin = DebitPin.substring(12);
			
			writeExcel("DebitCardDevendra", 0, 0, ""+debitCardNumber+"",pin );
			alert.accept();


		
		
	}

	private static void clik(String string) {
			driver.findElement(By.xpath(string)).click();
	}

	public static void fundTransfer() throws IOException {
			launchURL();
	}

	public static void approveAccount() throws IOException, InterruptedException {
		launchURL();
		 clik("//a[text()='Staff Login']");
		  String st_id = staffCred("staffId");
		  String st_pwd = staffCred("Password");
			 Thread.sleep(3000);
			  sendData("//input[@name='staff_id']", st_id);
			 Thread.sleep(1000);
		  sendData("//input[@name='password']",st_pwd);
			 Thread.sleep(1000);
			  scrollXY(driver,0,400);
				 Thread.sleep(1000);
		  clik("//input[@name='staff_login-btn']");
		  scrollXY(driver,0,400);
		  clik("//input[@name='apprvac']");
		  String ap = excelData("ApplicationNumber", 0, 1);
		//  System.out.println(ap);
		  sendData("//input[@name='application_no']",ap );
		  Thread.sleep(2000);
		  clik("//input[@name='search_application']");
		  scroll(driver, "//input[@name='approve_cust']");
		  clik("//input[@name='approve_cust']");
		  Alert alert = driver.switchTo().alert();
		  String text = alert.getText();
		  String accNo="";
		  for (int i = 0; i < text.length(); i++) {
			  	char ch=text.charAt(i);
			  	if(Character.isDigit(ch))
			  	{
			  		accNo=accNo + ch;
			  	}
		}
		  writeExcel("AcountNumber", 0, 0, "AccountNumber", accNo);
		System.out.println("Test Case is Passed: "+accNo);
		  alert.accept();
		  

	}

	public static void scrollXY(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	private static void sendData(String xpath,String data) {
		  driver.findElement(By.xpath(xpath)).sendKeys(data);

	}

	public static void openAccount() throws IOException, InterruptedException, AWTException
	{
		launchURL();
		Thread.sleep(2000);
		scroll(driver,"//li[text()='Open Account']");
		clik("//li[text()='Open Account']");
		
//		Calendar cal =  Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 16);
//		Date d=cal.getTime();
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
//		String customDate = sdf.format(d);
//		System.out.println(customDate);
//		
		 WebElement dob = driver.findElement(By.name("dob"));
		 String dt = excelData("x",19,1);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]",dob,dt );
		
		
		
		
//		  String dt = excelData("OpenAccountData",19,1);
//		  System.out.println(dt);
////		  WebElement date = driver.findElement(By.name("dob"));
////		  date.sendKeys(dt);
//		  
//		  WebElement dob = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
//		  dob.click();
//		  dob.sendKeys("1111", Keys.TAB,"1990");
//		  
		
     	  
		  for(int i=0,tag=0; i<=11; i++)
		  {
		  
		  String tname = excelData("x",i,tag);
		  WebElement txtf = driver.findElement(By.xpath("//input[@name='"+tname+"']"));
		  
		  for (int j = 1; j <=1; j++) 
		  {
			  String dvalue = excelData("x",i,j);
			  txtf.sendKeys(dvalue); 
		     Thread.sleep(50);
		  		  
		  }
		  }
		  for (int i = 13; i <=16 ; i++) 
		  {
			  String gd1 = excelData("x",i,0);
			  WebElement gd = driver.findElement(By.xpath("//select[@name='"+gd1+"']"));
			  for (int j = 1; j <=1; j++) {
				  String gd2 = excelData("x",i,j);
				  Thread.sleep(250);
				  dropdown(gd,gd2);
			
			}

			  
			
		}
		  Thread.sleep(2000);
		  
//		  ArrayList<String>appNum=new ArrayList<String>();
		  
		  scroll(driver, "//input[@name='submit']");
		  clik("//input[@name='submit']");
		  scroll(driver, "//input[@type='submit']");
		  clik("//input[@type='submit']");
		  Alert alert = driver.switchTo().alert();
		  String text = alert.getText();
		  String applicationNumber="";
		  for(int i=0; i<text.length();i++)
		  {
			  if(Character.isDigit(text.charAt(i)))
			  {
				  applicationNumber=applicationNumber+text.charAt(i);
			  }
		  }
		  alert.accept();
//		  appNum.add(applicationNumber);
		  System.out.println("Applicarion Number :"+applicationNumber);
		  int row=0;
		  writeExcel("xdata",row,0,"Application Number",applicationNumber);
		  System.out.println("TesCase is passed");
		  row++;
		  driver.close();
		  
		 		  
				  
		 
	}


	public static void writeExcel(String sheet,int row,int cell,String data,String nbr) throws IOException {
		
		FileOutputStream fout;
		 FileInputStream fis;
		 Workbook book=null;
	
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
			book = WorkbookFactory.create(fis);

		} catch (Exception e) {
		}
		org.apache.poi.ss.usermodel.Sheet sheet1 = book.createSheet(sheet);
		Row row1 = sheet1.createRow(row);
		Cell cell1 = row1.createCell(cell);
		cell1.setCellValue(data);
		Cell cell2 = row1.createCell(++cell);
		cell2.setCellValue(nbr);

		fout = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		book.write(fout);
	}

	private static String staffCred(String data) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String data1 = p.getProperty(data);
		return data1;
		
	}

	public static void dropdown(WebElement dd,String value) {
		Select sel = new Select(dd);
		sel.selectByValue(value);
	}

	public static void gender(WebElement gd,String data) {
		Select sel=new Select(gd);
		sel.selectByValue(data);
		
	}


	public static String excelData(String sheet, int row, int cell) {
		FileInputStream fis;
		Workbook book = null;
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
			book = WorkbookFactory.create(fis);

		} catch (Exception e) {

		}
		String value = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;

	}

	public static void launchURL() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	}


	public static void drop(WebElement dd, String vt) {
		driver.findElement(By.xpath(dd.getText()));
		Select sel = new Select(dd);
		sel.selectByVisibleText(vt);
	}

	public static WebElement enterData(String xpath) {
		WebElement data = driver.findElement(By.xpath(xpath));
		return data;
	}

	public static void scroll(WebDriver driver,String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Point location = ele.getLocation();
		int x = location.getX();
		int y = location.getY();
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

}
