package com.auto.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.base.TestBase;

public class Login_Page extends TestBase{
	// PageFactory : aka Object Repository:
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signInButton;
	
	// Initializing the page objects:
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	
	public Home_Page login(String un, String pwd) {
		userName.sendKeys(un);
		log.info("Entered "+un+" in UserName Field");
		password.sendKeys(pwd);
		log.info("Entered "+pwd+" in Password Field");
		signInButton.click();
		log.info("Clicked on Sign In Button");
		return new Home_Page();
	}
}
