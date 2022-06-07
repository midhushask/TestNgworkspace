package com.lowes.test.feedback;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lowes.enums.BrowserTypes;
import com.lowes.managers.WebDriverManager;
import com.lowes.pages.FeedbackPage;
import com.lowes.pages.HomePage;
import com.lowes.test.basetest.BaseTest;

public class FeedbackTest extends BaseTest{
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = WebDriverManager.launchDriver(BrowserTypes.CHROME);
		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage().goToFeedbackPage();
	}
	
	@Test
	public void submitFeedbackTest() throws Exception {
		FeedbackPage feedbackPage = new FeedbackPage(driver);
		feedbackPage.submitFeedback();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
