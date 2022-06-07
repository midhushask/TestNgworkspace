package com.lowes.test.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Connect to db");
		System.out.println("Load properties file");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Close db connection");
	}

}
