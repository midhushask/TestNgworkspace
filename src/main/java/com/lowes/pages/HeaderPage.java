package com.lowes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{
	
	By signInLinkBy = By.xpath("//div[@id='headerApp']//button[text()='Sign In']");
	By signInButtonBy = By.xpath("//div[@id='popover-account']/div/a");
	
	public HeaderPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private void clickSignInLink() {
		clickElement(signInLinkBy, 5);
	}
	
	public SignInPage goToSignInPage() {
		clickSignInLink();
		//clickElement(signInButtonBy, 5);
		return new SignInPage(driver);
	}

}
