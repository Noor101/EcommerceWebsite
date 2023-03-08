package com.qa.tispring.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tispring.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void ProductInfoSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyPageTitle_Mackbook() {
		accountsPage.doSearch("Macbook");
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		Assert.assertEquals(productInfoPage.getPageTitle("MacBook Pro"), "MacBook Pro");

	}

	@Test
	public void verifyProductInfoTest_MacBook() {
		String productName = "macbook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");

		Assert.assertTrue(productInfoPage.getProductImages() == 4);

		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);

		// {Brand=Apple, Availability=Out Of Stock, price=$2,000.00, name=MacBook Pro,
		// Product Code=Product 18, ex-Tax=$2,000.00, Reward Points=800

		Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");

	}
//	@Test(priority=3)
//	public void verifyAddToCartTest() {
//		String productName = "macbook";
//		Assert.assertTrue(accountsPage.doSearch(productName));
//		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
//		productInfoPage.selectQuantity("2");
//		productInfoPage.addToCart();
//		productInfoPage.clickOnItems();
//	}
}
