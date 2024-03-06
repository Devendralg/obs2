package com.OjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerProfilePage {
	@FindBy( xpath = "//li[text()='My Account']") private WebElement myAccBtn;
	@FindBy( xpath = "//li[text()='My Profile']") private WebElement myProfileBtn;
	@FindBy( xpath = "//li[text()='Change Password']") private WebElement changePwdBtn;
	@FindBy( xpath = "//li[text()='Fund Transfer']") private WebElement cusProfFundTxBtn;
	@FindBy( xpath = "//li[text()='Statement']") private WebElement statementBtn;
	@FindBy( name = "pass-chng") private WebElement changePBtn;
	@FindBy( xpath = "//input[@name='logout_btn']") private WebElement clogoutBtn;
	
	public CustomerProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getMyAccBtn() {
		return myAccBtn;
	}
	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}
	public WebElement getChangePwdBtn() {
		return changePwdBtn;
	}
	public WebElement getCusProfFundTxBtn() {
		return cusProfFundTxBtn;
	}
	public WebElement getStatementBtn() {
		return statementBtn;
	}
	public WebElement getChangePBtn() {
		return changePBtn;
	}
	public WebElement getLogoutBtn() {
		return clogoutBtn;
	}
	
	

}
