package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.generic.utilities.FileUtilss;

public class CustomerLoginPage {
	
	@FindBy(name = "customer_id")private WebElement customerIdTxt;
	@FindBy(name = "password")private WebElement customerPwdTxt;
	@FindBy(name = "login-btn")private WebElement customerLoginBtn;
	@FindBy(xpath = "//label[text()='FORGET PASSWORD ?']")private WebElement customerForgotPwdBtn;
	public CustomerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCustomerIdTxt() {
		return customerIdTxt;
	}
	public WebElement getCustomerPwdTxt() {
		return customerPwdTxt;
	}
	public WebElement getCustomerLoginBtn() {
		return customerLoginBtn;
	}
	public WebElement getCustomerForgotPwdBtn() {
		return customerForgotPwdBtn;
	}
	
	public void customerLogin(String customerID,String passord)
	{
		customerIdTxt.sendKeys(customerID);
		customerPwdTxt.sendKeys(passord);
		customerLoginBtn.click();
	}

}
