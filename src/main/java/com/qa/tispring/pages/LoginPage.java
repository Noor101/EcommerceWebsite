package com.qa.tispring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tispring.base.Basepage;
import com.qa.tispring.utils.Constants;
import com.qa.tispring.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends Basepage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login' and @type='submit']");
	private By forgotPasswordLink = By.xpath("//a[text()='Forgotten Password']");
	private By registerLink = By.linkText("Register");

	// 2. Constructor of the page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page actions : feature of the page in the form of methods
	
	@Step("getting login page of the title")
	public String getLoginPageTitle() {

		return elementUtil.waitForTitlePresent(Constants.Login_Page_Title, 10);
	}

	@Step("Checking forgot password link exist")
	public boolean isForgotPasswordLinkExist() {
		//return  driver.findElement(forgotPasswordLink).isDisplayed();
		return elementUtil.doIsDisplayed(forgotPasswordLink);
		
	}

	@Step("login with username : {0} + password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with : " + un + "and" + pwd);
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);

		return new AccountsPage(driver);
	}
	
	@Step("Navigating to the register page")
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}