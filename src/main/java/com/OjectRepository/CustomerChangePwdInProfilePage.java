package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerChangePwdInProfilePage {
	@FindBy( name = "change_pass")private WebElement changePwdSubmitBtn;
	public CustomerChangePwdInProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getChangePwdSubmitBtn() {
		return changePwdSubmitBtn;
	}


}
