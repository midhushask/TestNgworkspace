package com.lowes.test.createaccount;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lowes.enums.BrowserTypes;
import com.lowes.managers.WebDriverManager;
import com.lowes.pages.HeaderPage;
import com.lowes.pages.HomePage;
import com.lowes.pages.SignUpPage;
import com.lowes.test.basetest.BaseTest;

public class CreateAccountErrorMessageTest extends BaseTest{
	
	//driver
	
	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.launchDriver(BrowserTypes.CHROME);
		HomePage homePage = new HomePage(driver);
		HeaderPage headerPage = new HeaderPage(driver);
		homePage.goToHomePage();
		headerPage.goToSignInPage().goToSignUpPage();
	}
	
	@Test(priority=0)
	public void missingEmailId() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.createAccount("", "Summer69!", "Summer69!", "Sachin", "Tendulkar", "M1A2P7");
		Assert.assertEquals(signUpPage.getRequiredFieldErrorMessage(), "A required field is missing. Please fill out all required fields and try again.");
	}
	
	@Test(priority=1)
	public void missingFirstName() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.createAccount("abc@gmail.com", "Summer69!", "Summer69!", "", "Tendulkar", "M1A2P7");
		Assert.assertEquals(signUpPage.getRequiredFieldErrorMessage(), "A required field is missing. Please fill out all required fields and try again.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
