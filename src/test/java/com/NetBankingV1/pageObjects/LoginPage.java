package com.NetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement txtbtnLogin;

	@FindBy(linkText = "Log out")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsername(String uname) {
		txtUsername.sendKeys("mngr319640");
	}

	public void setPassword(String password) {
		txtPassword.sendKeys("YzAraru");
	}

	public void clickSubmit() {
		txtbtnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}
}
