package com.OjectRepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.JavaUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class CustomerRegistrationFormPage 
{
	@FindBy( name = "submit")private WebElement registerFormSubmitBtn;

	public CustomerRegistrationFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterFormSubmitBtn() {
		return registerFormSubmitBtn;
	}

	public void customerRegistrationData(WebDriver driver,String SheetName,int Tcell,int dCell) throws EncryptedDocumentException, IOException
	{
	ExcelUtils ex = new ExcelUtils();
	List<WebElement> elements = driver.findElements(By.xpath("//form/input"));	
	List<WebElement> dropdown = driver.findElements(By.xpath("//select"));
	WebdriverUtils wLib = new WebdriverUtils();
	
	for (int i = 0; i < elements.size()-1; i++) 
	{				
		WebElement ele = elements.get(i);
		
		//TextField
		if(i==0)
		{
			wLib.jsSendText(driver, ele, wLib.nameGenerator());
		}else if(i==2)
		{
			wLib.jsSendText(driver, ele, wLib.phoneNumberGenerator());
		}else if(i==3)
		{
			wLib.jsSendText(driver, ele, wLib.emailGenerator());
		}else if(i==6)
		{
			wLib.jsSendText(driver, ele, wLib.panGenerator());
		}else
		{
			String data = ex.readDataFromExcelFile(SheetName, i, Tcell);
			wLib.jsSendText(driver, ele, data);
		}
		
	// Dropdown
	if(i < 4)
	{
		WebElement dAddress = dropdown.get(i);
		String dropValue = ex.readDataFromExcelFile(SheetName, i, dCell);
		wLib.jsSendText(driver, dAddress, dropValue);
	}
	}


	}


}
