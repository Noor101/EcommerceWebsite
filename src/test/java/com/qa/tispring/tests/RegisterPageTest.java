package com.qa.tispring.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tispring.base.BaseTest;
import com.qa.tispring.utils.Constants;
import com.qa.tispring.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetup() {
	 registerPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
		
	}
	@Test(dataProvider = "getRegisterData")
	public void userRegistration(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {
		//	registerPage.accountRegistration("Tom", "peter", "tom@gmail.com", "871478965", "Tom@123", "yes");
		registerPage.accountRegistration(firstname, lastname, email, telephone, password, subscribe);
	}
	
}
