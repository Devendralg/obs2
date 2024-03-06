package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustProfileFundTransferPage {
	@FindBy( name = "fnd_trns_btn")private WebElement custProfilefundTransferBtn;
	@FindBy( name = "add_beneficiary")private WebElement addBenificiaryBtn;
	@FindBy( name = "delete_beneficiary")private WebElement deleteBenificiaryBtn;
	@FindBy( name = "view_beneficiary")private WebElement viewBenificiaryBtn;
	public CustProfileFundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCustProfilefundTransferBtn() {
		return custProfilefundTransferBtn;
	}
	public WebElement getAddBenificiaryBtn() {
		return addBenificiaryBtn;
	}
	public WebElement getDeleteBenificiaryBtn() {
		return deleteBenificiaryBtn;
	}
	public WebElement getViewBenificiaryBtn() {
		return viewBenificiaryBtn;
	}
	
	


}
