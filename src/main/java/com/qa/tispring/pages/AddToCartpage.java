package com.qa.tispring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tispring.base.BaseTest;
import com.qa.tispring.utils.ElementUtil;

public class AddToCartpage extends BaseTest{
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By searchProductName = By.cssSelector("tbody:nth-child(2) .text-left > a");
	
	
	public AddToCartpage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getProductName(String productName) {
		String productNameTitle =  elementUtil.doGetText(searchProductName);
		System.out.println("The product name is" + productName);
		return productNameTitle;
	}

}
