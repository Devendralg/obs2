package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	@FindBy(name = "viewdet")private WebElement viewActiveCustomerBtn;
	@FindBy(name = "view_cust_by_ac")private WebElement viewCustomerByAccBtn;
	@FindBy(name = "apprvac")private WebElement approvePendingAccountBtn;
	@FindBy(name = "del_cust")private WebElement deleteCustomerBtn;
	@FindBy(name = "credit_cust_ac")private WebElement creditCustomerBtn;
	@FindBy(name = "home")private WebElement staffHomeBtn;
	@FindBy(name = "logout_btn")private WebElement staffLogoutBtn;

	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getViewActiveCustomerBtn() {
		return viewActiveCustomerBtn;
	}

	public WebElement getViewCustomerByAccBtn() {
		return viewCustomerByAccBtn;
	}

	public WebElement getApprovePendingAccountBtn() {
		return approvePendingAccountBtn;
	}

	public WebElement getDeleteCustomer() {
		return deleteCustomerBtn;
	}

	public WebElement getCreditCustomerBtn() {
		return creditCustomerBtn;
	}

	public WebElement getStaffHomeBtn() {
		return staffHomeBtn;
	}

	public WebElement getStaffLogoutBtn() {
		return staffLogoutBtn;
	}
	
	
	
	
	
}
