package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerForgetPassFormPage {
	
	@FindBy( name = "sendotp")private WebElement forgotPassSubmitBtn;

	public CustomerForgetPassFormPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getforgotPassSubmitBtn()
	{
		return forgotPassSubmitBtn;
	}
	
	

}
