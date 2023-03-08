package com.qa.tispring.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.qa.tispring.base.BaseTest;
import com.qa.tispring.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginPageTest extends BaseTest {
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Login Page Title Test")
	@Test(priority = 2)
	public void verifyPageTitleText() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is:" + title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify Forgot password link")
	@Test(priority = 1)
	public void verifyForGotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Login page test with username and password")
	@Test(priority = 4)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

}
