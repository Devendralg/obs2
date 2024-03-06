package com.OjectRepository;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DebitCardFormPage {
	
	@FindBy( name = "dbt_crd_submit")private WebElement debitCardSubmitBtn;

	public DebitCardFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDebitCardSubmitBtn() {
		return debitCardSubmitBtn;
	}
	
	

}
