package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbankingRegFormPage {
	
	@FindBy( name = "submit") private WebElement eBankSubmitBtn;

	public EbankingRegFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public WebElement geteBankSubmitBtn() {
		return eBankSubmitBtn;
	}
	
	

}
