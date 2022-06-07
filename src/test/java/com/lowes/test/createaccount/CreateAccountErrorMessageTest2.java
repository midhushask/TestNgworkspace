package com.lowes.test.createaccount;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lowes.enums.BrowserTypes;
import com.lowes.managers.WebDriverManager;
import com.lowes.pages.HeaderPage;
import com.lowes.pages.HomePage;
import com.lowes.pages.SignUpPage;
import com.lowes.test.basetest.BaseTest;

public class CreateAccountErrorMessageTest2 extends BaseTest{
	
	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.launchDriver(BrowserTypes.CHROME);
		HomePage homePage = new HomePage(driver);
		HeaderPage headerPage = new HeaderPage(driver);
		homePage.goToHomePage();
		headerPage.goToSignInPage().goToSignUpPage();
	}
	
	@DataProvider(name="CreateAccountErrorMessageDataProvider")
	public Object[][] createAccountErrorMessageDataProvider() {
		String[][] createAccountDataProvider = new String[2][7];
		//Code to fetch data from properties file and initialize the variable createAccountDataProvider
		createAccountDataProvider[0][0] = "";
		createAccountDataProvider[0][1] = "Summer69!";
		createAccountDataProvider[0][2] = "Summer69!";
		createAccountDataProvider[0][3] = "Sachin";
		createAccountDataProvider[0][4] = "Tendulkar";
		createAccountDataProvider[0][5] = "M1A2P7";
		createAccountDataProvider[0][6] = "A required field is missing. Please fill out all required fields and try again.";
		createAccountDataProvider[1][0] = "abc@gmail.com";
		createAccountDataProvider[1][1] = "Summer69!";
		createAccountDataProvider[1][2] = "Summer69!";
		createAccountDataProvider[1][3] = "";
		createAccountDataProvider[1][4] = "Tendulkar";
		createAccountDataProvider[1][5] = "M1A2P7";
		createAccountDataProvider[1][6] = "A required field is missing. Please fill out all required fields and try again.";
		
		return createAccountDataProvider;
	}
	
	@Test(dataProvider="CreateAccountErrorMessageDataProvider")
	public void missingRequiredField(String emailId, String newPassword, String confirmPassword, String firstName, String lastName, String postalCode, String expectedErrorMessage) {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.createAccount(emailId, newPassword, confirmPassword, firstName, lastName, postalCode);
		Assert.assertEquals(signUpPage.getRequiredFieldErrorMessage(), expectedErrorMessage);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
