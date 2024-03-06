package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//li[text()='Open Account']") private WebElement openAccountbtn;
	@FindBy(xpath = "//li[text()='Apply Debit Card']") private WebElement applyDebitbtn;
	@FindBy(className = "ebanking") private WebElement internetBankingbtn;
	@FindBy(xpath = "//li[text()='Fund Transfer']") private WebElement fundTransferbtn;
	@FindBy(xpath = "//div[@class='ebanking_options']//li[contains(.,'Login')]") private WebElement ebankLogin;
	@FindBy(xpath = "//div[@class='ebanking_options']//li[contains(.,'Register')]") private WebElement ebankRegister;
	@FindBy(xpath = "//a[text()='Staff Login']") private WebElement staffLoginBtn;
	@FindBy(xpath = "//a[text()='Home']") private WebElement HomeBtn;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpenAccountbtn() {
		return openAccountbtn;
	}

	public WebElement getApplyDebitbtn() {
		return applyDebitbtn;
	}

	public WebElement getInternetBankingbtn() {
		return internetBankingbtn;
	}

	public WebElement getFundTransferbtn() {
		return fundTransferbtn;
	}

	public WebElement getEbankLogin() {
		return ebankLogin;
	}

	public WebElement getEbankRegister() {
		return ebankRegister;
	}

	public WebElement getStaffLoginBtn() {
		return staffLoginBtn;
	}
	
	
	
	
	
	
	
	

}
