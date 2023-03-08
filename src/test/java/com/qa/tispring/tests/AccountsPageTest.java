package com.qa.tispring.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tispring.base.BaseTest;
import com.qa.tispring.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp() {

		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Description("Verify Account page Title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyAccountPageTitle() {

		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Home Page Title is: " + title);
		Assert.assertEquals(title, Constants.Account_Page_Title);

	}

	@Description("Verify header value test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyHeaderValueTest() {
		String headerVal = accountsPage.getHeaderValue();
		System.out.println("The header is:" + headerVal);
		Assert.assertEquals(headerVal, Constants.Account_Page_Header_Value);
	}

	@Description("Verify account section test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyAccountSectionCount() {
		Assert.assertEquals(accountsPage.getAccountSectionCount(), Constants.Account_Header_Count);
	}

	@Description("Verify account section List test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyAccountSectionList() {
		Assert.assertEquals(accountsPage.getAccountSectionList(), Constants.getAccountSectionsList());

	}

	@Description("Verify account page search test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void verifySearchTest() {
		Assert.assertTrue(accountsPage.doSearch("iphone"));
	}

}
