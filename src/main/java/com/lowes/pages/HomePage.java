package com.lowes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.LINK_TEXT, using = "Feedback")
    public WebElement feedbackImage;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public HomePage goToHomePage() {
		driver.get("https://www.lowes.ca/");
		return this;
	}
	
	public FeedbackPage goToFeedbackPage() {
		clickElement(feedbackImage, 10);
		//switchToWindowByTitle("lowes.ca Study");
		return new FeedbackPage(driver);
	}
	
}
