package com.OjectRepository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obs.generic.utilities.ExcelUtils;
import com.obs.generic.utilities.WebdriverUtils;

public class PendingCustomerPage {
@FindBy( name = "application_no") private WebElement applicationNumberTxtfield;
@FindBy( name = "search_application") private WebElement searchBtn;
@FindBy( name = "approve_cust") private WebElement approveBtn;

public PendingCustomerPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getApplicationNumberTxtfield() {
	return applicationNumberTxtfield;
}

public WebElement getSearchBtn() {
	return searchBtn;
}

public WebElement getApproveBtn() {
	return approveBtn;
}

public void approvePendingAcc(WebDriver driver,int row) throws EncryptedDocumentException, IOException, InterruptedException
{
	//boolean flag=false;
	WebdriverUtils wd = new WebdriverUtils();
	ExcelUtils ex = new ExcelUtils();
	String appNo = ex.readDataFromExcelFile("ApplicationNumber", row, 0);
	getApplicationNumberTxtfield().sendKeys(appNo);
	getSearchBtn().click();
		
		
		
		if(wd.isAlertPresent(driver))
		{
		String text = wd.alertSwitch(driver).getText();
		System.out.println("Test Case Pass \nAlready Approved\n----------------------");
		System.out.println(text);
		wd.acceptAlert(driver);
		driver.quit();
		}
		
}


}
