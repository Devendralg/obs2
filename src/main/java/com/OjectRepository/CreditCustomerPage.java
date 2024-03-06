package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {
	@FindBy( name = "customer_account_no") private WebElement custAccNoCredTxt;
	@FindBy( name = "credit_amount") private WebElement amountCredTxt;
	@FindBy( name = "credit_btn") private WebElement creditBtn;
	public CreditCustomerPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCustAccNoCredTxt() {
		return custAccNoCredTxt;
	}
	public WebElement getAmountCredTxt() {
		return amountCredTxt;
	}
	public WebElement getCreditBtn() {
		return creditBtn;
	}
	
	public void creditAmount(String accNo,String Amount)
	{
		custAccNoCredTxt.sendKeys(accNo);
		amountCredTxt.sendKeys(Amount);
		creditBtn.click();
	}
					


}
