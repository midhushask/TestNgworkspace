package com.lowes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
	
	By requiredFieldMissingLabelBy = By.id("requiredFieldMissing");
	By emailIdTextboxBy = By.id("email");
	By newPasswordTextboxBy = By.id("newPassword");
	By confirmNewPasswordTextboxBy = By.id("reenterPassword");
	By firstNameTextboxBy = By.id("givenName");
	By lastNameTextboxBy = By.id("surname");
	By postalCodeTextboxBy = By.id("postalCode");
	By createButtonBy = By.id("continue");
	By signInLinkBy = By.id("cancel");
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage createAccount(String emailId, String newPassword, String confirmNewPassword, String firstName, String lastName, String postalCode) {
		enterTextInElement(emailIdTextboxBy, emailId, 5);
		enterTextInElement(newPasswordTextboxBy, newPassword, 5);
		enterTextInElement(confirmNewPasswordTextboxBy, confirmNewPassword, 5);
		enterTextInElement(firstNameTextboxBy, firstName, 5);
		enterTextInElement(lastNameTextboxBy, lastName, 5);
		enterTextInElement(postalCodeTextboxBy, postalCode, 5);
		clickElement(createButtonBy, 5);
		return new HomePage(driver);
	}
	
	public String getRequiredFieldErrorMessage() {
		return getTextFromElement(requiredFieldMissingLabelBy, 5);
	}

}
