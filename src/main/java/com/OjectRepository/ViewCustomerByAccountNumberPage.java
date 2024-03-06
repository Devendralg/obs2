package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccountNumberPage {
	@FindBy(name = "account_no")private WebElement accNoTxtField;
	@FindBy(name = "submit_view")private WebElement submitButton;
	
	public ViewCustomerByAccountNumberPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccNoTxtField() {
		return accNoTxtField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business Logic
	public void viewCustomer(String AccNo)
	{
		accNoTxtField.sendKeys(AccNo);
		submitButton.click();
	}


}
