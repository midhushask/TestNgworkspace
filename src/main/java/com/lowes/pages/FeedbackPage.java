package com.lowes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage extends BasePage {
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.ID, using = "TagId-91783")
    public WebElement praiseRadioButton;
    
    @FindBy(how = How.ID, using = "ItemId-107046-8")
    public WebElement overallExpButton;
    
    @FindBy(how = How.ID, using = "TagId-54891")
    public WebElement makePurchaseRadioButton;
    
    @FindBy(how = How.CLASS_NAME, using = "submitButton")
    public WebElement sendCommentButton;
    
    @FindBy(how = How.ID, using = "Finish")
    public WebElement closeWindowButton;
    
    public FeedbackPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(this.driver, this);
    }
    
    public void submitFeedback() throws Exception {
    	Thread.sleep(2000);
    	clickElement(praiseRadioButton, 5);
    	clickElement(overallExpButton, 5);
    	clickElement(makePurchaseRadioButton, 5);
    	clickElement(sendCommentButton, 5);
    	//clickElement(closeWindowButton, 5);
    	//switchToWindowByTitle("Lowe's Canada - Home Improvement, Renovation & Hardware Store");
    	//return new HomePage(driver);
    }

}
