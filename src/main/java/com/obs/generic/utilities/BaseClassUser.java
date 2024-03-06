package com.obs.generic.utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.OjectRepository.CustomerLoginPage;
import com.OjectRepository.CustomerProfilePage;
import com.OjectRepository.HomePage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClassUser 
{
	public DatabaseUtils dLib = new DatabaseUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public FileUtilss fLib = new FileUtilss();
	public JavaUtils jLib = new JavaUtils();
	public WebdriverUtils wLib = new WebdriverUtils();
	public WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() throws EncryptedDocumentException, IOException
  {
	 HomePage hp = new HomePage(driver);
	 wLib.mouseOverAndClickOnElement(driver, hp.getInternetBankingbtn());
	 hp.getEbankLogin().click();
	 CustomerLoginPage cl = new CustomerLoginPage(driver);
	 String cid = eLib.readDataFromExcelFile("customerLogin", 6, 0);
	 String cpwd = eLib.readDataFromExcelFile("customerLogin", 6, 1);
	 
	 cl.customerLogin(cid, cpwd);
	 
  }

  @AfterMethod
  public void afterMethod() 
  {
	 CustomerProfilePage cp = new CustomerProfilePage(driver);
	 cp.getLogoutBtn().click();
	 
  }

  @Parameters("browser")
  @BeforeClass (alwaysRun = true)
  public void beforeClass(String Browser) throws IOException 
  {
	String URL = fLib.readDataFromProperyFile("url");
	  
	if(Browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();

	}else if (Browser.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("edge"))
	{
		try {
		driver = new EdgeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}else
	{
		System.out.println("Invalid browser");
	}
	driver.get(URL);
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver, 30);
	  
  }

  @AfterClass (alwaysRun = true)
  public void afterClass() 
  {
	  driver.close();
	  Reporter.log("Browser Closed", true);

  }

   @BeforeSuite (alwaysRun = true)
  public void beforeSuite() throws SQLException 
  {
	  dLib.connectToDB();
	  Reporter.log("--Connect to DB", true);
  }

  @AfterSuite (alwaysRun = true)
  public void afterSuite() throws SQLException
  {
	  dLib.disconnectDB();
	  Reporter.log("--DisConnect to DB", true);

  }

}
