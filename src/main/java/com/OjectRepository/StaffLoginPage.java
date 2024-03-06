package com.OjectRepository;
import com.obs.generic.utilities.FileUtilss;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage extends FileUtilss {
	
	
	@FindBy(name = "staff_id")private WebElement staff_idTxt;
	@FindBy(name = "password")private WebElement staffpwdTxt;
	@FindBy(name = "staff_login-btn")private WebElement staffLoginBtn;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaff_idTxt() {
		return staff_idTxt;
	}

	public WebElement getStaffpwdTxt() {
		return staffpwdTxt;
	}

	public WebElement getStaffLoginBtn() {
		return staffLoginBtn;
	}
	
	public void staffLogin() throws IOException
	{
		staff_idTxt.sendKeys(readDataFromProperyFile("staffId"));
		staffpwdTxt.sendKeys(readDataFromProperyFile("password"));
		staffLoginBtn.click();
	}
	

}
