package testNGPractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TryAllAnnotation {
  
  @BeforeMethod
  public void beforeMethod()
  {
		 System.out.println("Common to All Methods before method Login"); 

  }

  @AfterMethod
  public void afterMethod()
  {
		 System.out.println("Common to All Methods After method Logout"); 
  
  }

  @BeforeClass
  public void beforeClass() 
  {
		 System.out.println("Common to All Classes Before class Launch Browser"); 

  }

  @AfterClass
  public void afterClass()
  {
		 System.out.println("Common to All Classes After Test quit Browser"); 

  }

  @BeforeTest
  public void beforeTest()
  {
		 System.out.println("Common to All Tests Before Test"); 
 
  }

  @AfterTest
  public void afterTest() 
  {
	 System.out.println("Common to All Tests After Test"); 
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("Common to All Suite Connect to DB before suite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("Common to All Suite Close DB After Suite");

  }

}
