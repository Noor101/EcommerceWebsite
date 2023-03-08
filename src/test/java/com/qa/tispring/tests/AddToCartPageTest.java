package com.qa.tispring.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tispring.base.BaseTest;

public class AddToCartPageTest extends BaseTest{
	
	@BeforeClass
	public void AddToCartPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyProductNameTest() {
		accountsPage.doSearch("macbook");
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		productInfoPage.selectQuantity("2");
		productInfoPage.addToCart();
		addToCartpage = productInfoPage.clickOnItems();
		Assert.assertEquals(addToCartpage.getProductName("MacBook Pro"), "MacBook Pro");
	}
	
	

}
