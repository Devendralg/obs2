package staffModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class StaffModuleTest  {
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		creditCustomer();
		
	}

	public static void creditCustomer() throws IOException, InterruptedException
	{
		launchURL();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String staffid = p.getProperty("staffId");
		String pwd = p.getProperty("Password");

		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				Thread.sleep(2000);
		clik("//a[text()='Staff Login']");
		driver.findElement(By.className("customer_id")).sendKeys(staffid);
		driver.findElement(By.className("password")).sendKeys(pwd);
		clik("//input[@class='login-btn']");
		clik("//input[@name='credit_cust_ac']");
		String accN = excelData("Sheet1", 8,1);
		String amt = excelData("Sheet1", 8,3);
		driver.findElement(By.xpath("//input[@name='customer_account_no']")).sendKeys(accN);
		driver.findElement(By.xpath("//input[@name='credit_amount']")).sendKeys(amt);
		driver.findElement(By.name("credit_btn")).click();
		
		
		
		
	}
	public static void clik(String xpath) 
	{
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void scrollXY(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	private static void sendData(String xpath,String data) {
		  driver.findElement(By.xpath(xpath)).sendKeys(data);

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


}
