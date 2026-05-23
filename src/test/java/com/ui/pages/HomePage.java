package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);		//To call the parent class constructor to child class constructor
		//goToWebsite(PropertiesUtil.readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click action to go to Sign In page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
