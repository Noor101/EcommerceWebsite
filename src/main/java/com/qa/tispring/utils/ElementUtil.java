package com.qa.tispring.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.tispring.base.Basepage;

public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jsUtils;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtils = new JavaScriptUtil(this.driver);
	}

	/**
	 * This is the generic method to get webelement without Exceptional handling
	 * 
	 * @param locator
	 * @return
	 */
	// public WebElement getElement(By locator) {
	// WebElement element = driver.findElement(locator);
	// return element;
	// }
	//

	// Now using exceptional handling I'm writing the generic methods

	/**
	 * This is the generic method to get webelement using try and catch block
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if(Basepage.highlightElement.equals("true")) {
				jsUtils.flash(element);
			}
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This is the generic method to get the List<WebElement>
	 * 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElementsList(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	/**
	 * This is the generic method for waitforElement
	 * 
	 * @param locator
	 * @param timeout
	 */
	public void waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This is the generic method for sendkeys
	 * 
	 * @param locator
	 * @param Value
	 */
	public void doSendKeys(By locator, String Value) {
		try {
			getElement(locator).sendKeys(Value);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}

	}

	public void doClick(By locator) {
		try {

			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
	}

	public void doClickByWait(By locator) {
		try {
			waitForElementPresent(locator, 50);
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
	}

	public static void roomsList(WebDriver driver, String locator, String value) {

		WebDriverWait wait = new WebDriverWait(driver, 100);
		List<WebElement> list = driver.findElements(By.xpath(locator));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

		for (int i = 1; i < list.size(); i++) {
			String roomsName = list.get(i).getText();
			if (roomsName.equalsIgnoreCase(value)) {
				list.get(i).click();
				break;
			}
		}
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 0);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();

	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public void clearText(By locator) {
		driver.findElement(locator).clear();
	}
}
