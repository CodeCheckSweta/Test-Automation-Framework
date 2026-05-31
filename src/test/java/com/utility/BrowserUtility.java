package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		// initialize the instance variable driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public BrowserUtility(Browser browserName, Boolean isHeadless) {
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			}
		} else {
			logger.error("Invalid browser name: " + browserName);
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info(" Element found and now performing click");
		element.click();
	}

	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info(" Element found and now performing click");
		element.click();
	}
	
	public void clickOn(WebElement element) {
		logger.info(" Element found and now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info(" Element found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By textboxLocator) {
		logger.info("Finding element with the locator " + textboxLocator);
		//WebElement element = driver.get().findElement(textboxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textboxLocator));
		logger.info(" Element found and now clear textbox field ");
		element.clear();
	}

	public void selectFromDropDown(By dropdownLocator, String optionToSelect) {
		logger.info("Finding element with the locator " + dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);

		logger.info("Element found and now select the option " + optionToSelect);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		   js.executeScript(
		            "for(let option of arguments[0].options) {" +
		            "   if(option.text === arguments[1]) {" +
		            "       arguments[0].value = option.value;" +
		            "       arguments[0].dispatchEvent(new Event('change'));" +
		            "       break;" +
		            "   }" +
		            "}",
		            element,
		            optionToSelect
		    );
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info(" Element found and now enter the special key " + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Returning the visible text" + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Element found and now returning the visible" + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now printing the list of elements");
		List<String> visibleTextList = new ArrayList<String>();

		for (WebElement element : elementList) {
			logger.info(getVisibleText(element));
			visibleTextList.add(element.getText());
		}
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now printing the list of elements");
		return elementList;
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timestamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		driver.get().quit();
	}

}
