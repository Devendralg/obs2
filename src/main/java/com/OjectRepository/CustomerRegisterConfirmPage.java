package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisterConfirmPage {
	@FindBy(xpath = "//input[@name='cnfrm-submit']")private WebElement confirmBtn;
	@FindBy(xpath = "//input[@value='Go back']")private WebElement goBackBtn;
	public CustomerRegisterConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getConfirmBtn() {
		return confirmBtn;
	}
	public WebElement getGoBackBtn() {
		return goBackBtn;
	}
	
	public String getApplicationNumber(String text)
	{
		String apn = "";
		for(int i=0; i<text.length(); i++)
		{
			char ch =text.charAt(i);
			if(Character.isDigit(ch))
			{
				apn+=ch;
			}
		}
		return apn;
	}
	
	
	

}
