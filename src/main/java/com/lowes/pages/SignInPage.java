package com.lowes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{
	
	By signUpNowLinkBy = By.id("createAccount");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public SignUpPage goToSignUpPage() {
		clickElement(signUpNowLinkBy, 5);
		return new SignUpPage(driver);
	}

}
