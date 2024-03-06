package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	@FindBy( name = "Cust_ac_no") private WebElement custAccNoTxt;
	@FindBy( name = "Cust_ac_Id") private WebElement custAccIdTxt;
	@FindBy( name = "reason") private WebElement reasonTxt;
	@FindBy( name = "delete") private WebElement deleteBtn;
	
	public DeleteCustomerPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustAccNoTxt() {
		return custAccNoTxt;
	}

	public WebElement getCustAccIdTxt() {
		return custAccIdTxt;
	}

	public WebElement getReasonTxt() {
		return reasonTxt;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	//business logic
	public void deleteCustomer(String accNo,String cid, String reason)
	{
		custAccNoTxt.sendKeys(accNo);
		custAccIdTxt.sendKeys(cid);
		reasonTxt.sendKeys(reason);
		deleteBtn.click();
		
	}

}
