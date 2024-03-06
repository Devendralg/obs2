package com.obs.generic.utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.OjectRepository.HomePage;
import com.OjectRepository.StaffHomePage;
import com.OjectRepository.StaffLoginPage;

import org.testng.annotations.AfterSuite;

public class BaseClass 
{
	public DatabaseUtils dLib = new DatabaseUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public FileUtilss fLib = new FileUtilss();
	public JavaUtils jLib = new JavaUtils();
	public WebdriverUtils wLib = new WebdriverUtils();
	public static WebDriver driver;
	
  @BeforeMethod (alwaysRun = true)
  public void beforeMethod() throws IOException 
  {
	  HomePage hp = new HomePage(driver);
	  hp.getStaffLoginBtn().click();
	  StaffLoginPage sl = new StaffLoginPage(driver);
	  sl.staffLogin();
	  Reporter.log("StaffLogin", true);
  }

  @AfterMethod (alwaysRun = true)
  public void afterMethod()
  {
	 StaffHomePage sh = new StaffHomePage(driver);
	 sh.getStaffLogoutBtn().click();
	  Reporter.log("StaffLogout", true);

  }
  
 // @Parameters("browser")
  @BeforeClass (alwaysRun = true)
  public void beforeClass() throws IOException 
  {
	String URL = fLib.readDataFromProperyFile("url");
	String Browser = fLib.readDataFromProperyFile("browser");
	  
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
