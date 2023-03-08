package com.qa.tispring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tispring.base.Basepage;
import com.qa.tispring.utils.Constants;
import com.qa.tispring.utils.ElementUtil;

public class RegisterPage extends Basepage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");
	private By agreeCheckbox = By.name("agree");
	private By continuButton = By.xpath("//input[@type='submit' and @value ='Continue']");
	private By accountSuccessMessage = By.xpath("//div[@id='content']/h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public boolean accountRegistration(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {

		elementUtil.doSendKeys(firstName, firstname);
		elementUtil.doSendKeys(lastName, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);

		if (subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		} else
			elementUtil.doClick(subscribeNo);
		
		elementUtil.doClick(agreeCheckbox);
		elementUtil.doClick(continuButton);
		String text = elementUtil.doGetText(accountSuccessMessage);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MESSAGE)){
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}else {
			return false;
		}
	}

}
