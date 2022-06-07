package com.lowes.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	WebDriver driver;
	
	private WebElement waitForElementClickable(By locator, int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	private WebElement waitForElementClickable(WebElement element, int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private WebElement waitForVisibility(By locator, int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private WebElement waitForVisibility(WebElement element, int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAlertPresent(int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void clickElement(By locator, int numberOfSeconds) {
		waitForElementClickable(locator, numberOfSeconds).click();
	}
	
	public void clickElement(WebElement element, int numberOfSeconds) {
		waitForElementClickable(element, numberOfSeconds).click();
	}
	
	public String getTextFromElement(By locator, int numberOfSeconds) {
		return waitForVisibility(locator, numberOfSeconds).getText();
	}
	
	public String getTextFromElement(WebElement element, int numberOfSeconds) {
		return waitForVisibility(element, numberOfSeconds).getText();
	}
	
	public void enterTextInElement(By locator, String data, int numberOfSeconds) {
		waitForVisibility(locator, numberOfSeconds).clear();
		waitForVisibility(locator, numberOfSeconds).sendKeys(data);
	}
	
	public void enterTextInElement(WebElement element, String data, int numberOfSeconds) {
		waitForVisibility(element, numberOfSeconds).clear();
		waitForVisibility(element, numberOfSeconds).sendKeys(data);
	}
	
	public void switchToWindowByTitle(String title) throws Exception {
		Set<String> allWindows = driver.getWindowHandles();
		boolean switched = false;
		
		for(String windowHandle:allWindows) {
			driver.switchTo().window(windowHandle);
			System.out.println("Browser title -> " + driver.getTitle());
			if(driver.getTitle().contentEquals(title)) {
				switched=true;
				break;
			}
		}
		
		if(!switched) {
			throw new Exception("Window with the title - " + title + " not found");
		}
	}

}
