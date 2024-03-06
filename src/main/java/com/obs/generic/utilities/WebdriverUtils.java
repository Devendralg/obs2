
package com.obs.generic.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class WebdriverUtils {
	WebDriver driver;
	public  Timeouts waitForPageLoad(WebDriver driver,int seconds)
	{
		Timeouts pageLoadTimeout = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
		return pageLoadTimeout;
	}
	
	public  void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public  void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public  WebDriverWait webDriverWaitObj(WebDriver driver,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait;
	}
	
	public  void waitUntilElementToBeClickable(WebDriver driver,int seconds,WebElement element) 
	{
		webDriverWaitObj(driver, seconds).until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public  void waitUntilElementToBeVisible(WebDriver driver,int seconds,WebElement element)
	{
		webDriverWaitObj(driver,seconds).until(ExpectedConditions.visibilityOf(element));
		
	}
	public  void alertIsPresent(WebDriver driver,int seconds) 
	{
		webDriverWaitObj(driver, seconds).until(ExpectedConditions.alertIsPresent());
	}
	public  Actions actionObj(WebDriver driver) 
	{
		Actions action = new Actions(driver);
		return action;
		
	}
	public  void dragAndDrop(WebDriver driver,WebElement source,WebElement destination) 
	{
		actionObj(driver).dragAndDrop(source, destination).perform();
	}
	public  void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		actionObj(driver).moveToElement(element).perform();
		
	}
	public  void mouseOverAndClickOnElement(WebDriver driver,WebElement element)

	{
		actionObj(driver).click(element).perform();
		
	}
	public  void rightClickOnElement(WebDriver driver,WebElement element) 
	{
		actionObj(driver).contextClick(element).perform();

	}
	
	public  Select selectClassObj(WebElement element) 
	{
		Select select = new Select(element);
		return select;
		
	}
	
	
	 public  Select selectOption(WebElement element, Object data)
	  {
		  Select select = selectClassObj(element);
		  if(data instanceof Integer)
		  {
			  select.selectByIndex((Integer)data);
		  }
		  else if(data instanceof String)
		  {
			  try
			  {
				  select.selectByValue((String)data);
			  }
			  catch(Exception e)
			  {
				  select.selectByVisibleText((String)data);
			  }
		  }
		  return select;
	  }
	 public  void deselectOption(WebElement element, Object data)
	 {
		 Select select = selectClassObj(element);
		 if(data instanceof Integer)
		 {
			 select.deselectByIndex((Integer)data);
		 }
		 else if(data instanceof String)
		 {
			 try
			 {
				 select.deselectByValue((String)data);
			 }
			 catch(Exception e)
			 {
				 select.deselectByVisibleText((String)data);
			 }
		 }
	 }
	 public  List<WebElement> selectAllOptions(WebElement element)
	 {
		 List<WebElement> options = selectClassObj(element).getOptions();
		 return options;
	 }
	 public void deselectAllOptions(WebElement element) 
	 {
		 selectClassObj(element).deselectAll();
		
	}
	 
	 public Robot robotClassObj() throws AWTException
	 {
		 Robot robot = new Robot();
		 return robot;		 
		
	}
	 public void enterKeyPressAndRelease() throws AWTException 
	 {
		 robotClassObj().keyPress(KeyEvent.VK_ENTER);
		 robotClassObj().keyRelease(KeyEvent.VK_ENTER);
		 
		
	}
	 public WebDriver switchToFrame(WebDriver driver,int index)
	 {
		 WebDriver frame = driver.switchTo().frame(index);
		 return frame;
		
	}
	 public WebDriver switchToFrame(WebDriver driver,String nameOrId)
	 {
		 WebDriver frame = driver.switchTo().frame(nameOrId);
		 return frame;
		 
	 }
	
	 public WebDriver switchToFrame(WebDriver driver,WebElement address)
	 {
		 WebDriver frame = driver.switchTo().frame(address);
		 return frame;
		 
	 }
	 public void acceptAlert(WebDriver driver)
	 {
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		
	}
	 public String getAlertText(WebDriver driver)
	 {
		 Alert alert = driver.switchTo().alert();
		 String text = alert.getText();
		 return text;
		 
	 }
	 
	 public void cancelAlert(WebDriver driver)
	 {
		 Alert alert = driver.switchTo().alert();
		 alert.dismiss();
		 
		 
	 }
	 public JavascriptExecutor jsObj(WebDriver driver) 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 return js;
		
	}
	 public void scrollToElement(WebDriver driver,WebElement element) 
	 {
		 Point location = element.getLocation();
			int x = location.getX();
			int y = location.getY();
			
			jsObj(driver).executeScript("window.scrollBy(" + x + "," + y + ")");
		 
	}
	 public void scrollXY(WebDriver driver,int x,int y)
	 {
			jsObj(driver).executeScript("window.scrollBy(" + x + "," + y + ")");

	 }
	 
	public void clik(WebDriver driver,String xpath) 
	{
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public void enterData(WebDriver driver,String xpath,String data)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}
	
//	public void dateSelect(WebDriver driver,String sheetName,int row,int cell)
//	{
//		 WebElement dob = driver.findElement(By.name("dob"));
//		 String dt = (sheetName,row,cell);
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].value=arguments[1]",dob,dt );
//		
//	}
	
	public WebElement webElement(WebDriver driver, String xpath)
	{
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
	}
	
	public Alert alertSwitch(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public void jsSendText(WebDriver driver,WebElement element,String text)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]",element,text );
	}
	 
	
	
	
	
	
	
	
	
	public void textFieldData(WebDriver driver,String xpath,String AT,String SheetName,int cell) throws EncryptedDocumentException, IOException
	{
		ExcelUtils ex = new ExcelUtils();
		List<WebElement> elements = driver.findElements(By.xpath(xpath));	
		for (int i = 0; i < elements.size(); i++) 
		{			
			if(i==1 || i==11 || i==12 || i==17)
			{
				WebElement ele = elements.get(i);
				String av = ele.getAttribute(AT);
				WebElement eAdress = driver.findElement(By.name(av));
				String data = ex.readDataFromExcelFile(SheetName, i, cell);
				eAdress.sendKeys(data);

			}else if(i==5)
			{
				WebElement ele = elements.get(i);
				String av = ele.getAttribute(AT);
				WebElement eAdress = driver.findElement(By.name(av));
				String data = ex.readDataFromExcelFile(SheetName, i, cell);
				eAdress.sendKeys(data);
			}else
			{
				WebElement ele = elements.get(i);
				String av = ele.getAttribute(AT);
				WebElement eAdress = driver.findElement(By.name(av));
				String data = ex.readDataFromExcelFile(SheetName, i, cell);
				eAdress.sendKeys(data);

			}
		}

	}
	public String getAlertNumber(String text)
	{
		String apn = "";
		for(int i=0; i<text.length(); i++)
		{
			char ch =text.charAt(i);
			if(Character.isDigit(ch))
			{
				apn+=ch;
			}
		}
		return apn;
	}
	
	public  boolean isAlertPresent(WebDriver driver) {
        try {
        	
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
            
            return true;
        } catch (NoAlertPresentException e) 
        {
            return false;
        }
    }
	
	public  String extractDebitCardNumber(String input) {
        Pattern pattern = Pattern.compile("Your Debit Card No is : (\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null; // Return null if not found
    }

    public String extractPinNumber(String input) {
        Pattern pattern = Pattern.compile("Pin is : (\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null; // Return null if not found
    }

	public List<WebElement> multipleValue(String xpath)
	{
		List<WebElement> textfields = driver.findElements(By.xpath(xpath));
		return textfields;

	}
	public  String passwordGenerator()
	{
		String s ="ASDFGHJKLZXVBNMQWERTYUIOPasdfghjklzxcvbnmqwertyuiop01234567890";
		String pwd = "";
		for (int i = 1; i <=8; i++) 
		{
			Random random = new Random();
			int r = random.nextInt(61);
			
			char character = s.charAt(r);
			String str = String.valueOf(character);
			
			pwd =pwd +str;
		}
		return pwd;
	}
public  String phoneNumberGenerator()
{
	String s ="1234567890";
	String pwd = "9960";
	for (int i = 1; i <=6; i++) 
	{
		Random random = new Random();
		int r = random.nextInt(10);
		
		char character = s.charAt(r);
		String str = String.valueOf(character);
		
		pwd =pwd +str;
	}
	return pwd;
}

public  String emailGenerator()
{
	String s ="asdfghjklzxcvbnmqwertyuiop";
	String pwd = "@gmail.com";
	for (int i = 1; i <=8; i++) 
	{
		Random random = new Random();
		int r = random.nextInt(s.length());
		
		char character = s.charAt(r);
		String str = String.valueOf(character);
		
		pwd = str+pwd;
	}
	return pwd;
}
public  String nameGenerator()
{
	String s ="asdfghjklzxcvbnmqwertyuiop";
	
	String pwd = "D";
	for (int i = 1; i <=8; i++) 
	{
		Random random = new Random();
		int r = random.nextInt(s.length());
		
		char character = s.charAt(r);
		String str = String.valueOf(character);
		
		pwd = pwd+str;
	}
	return pwd;
}
public  String panGenerator()
{
	String s ="ABCDEFGHIJKLMNOPQRSTUVWXYZasdfghjklzxcvbnmqwertyuiop0123456789";
	
	String pwd = "D";
	for (int i = 1; i <=6; i++) 
	{
		Random random = new Random();
		int r = random.nextInt(s.length());
		
		char character = s.charAt(r);
		String str = String.valueOf(character);
		
		pwd = pwd+str;
	}
	return pwd+18+"p";
}

public String getScreenShot(WebDriver driver,String methodname) throws IOException
{
	String path;
	JavaUtils j = new JavaUtils();
	String formattedDate = j.getSystemDateInFormat("MM-dd-yy-HH-mm");
	
	TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File("./defectscreenshot/"+methodname+"-"+formattedDate+".png");
	
		FileUtils.copyFile(src, dst);
		 path = dst.getAbsolutePath();
		 return path;
		
}




}
