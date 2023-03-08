package com.qa.tispring.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tispring.base.Basepage;
import com.qa.tispring.utils.ElementUtil;

public class ProductInfoPage extends Basepage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li img");
	private By addToCartAlert = By.cssSelector("div.alert");
	private By cartButton = By.id("cart-total");
	private By viewCartLink = By.cssSelector(".text-right a:nth-child(1)");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public Map<String, String> getProductInformation() {

		Map<String, String> productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", elementUtil.doGetText(productNameHeader).trim());
		List<WebElement> productMetaDataList = elementUtil.getElementsList(productMetaData);

		for (WebElement e : productMetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());

		}

		List<WebElement> productPriceList = elementUtil.getElementsList(productPrice);
		productInfoMap.put("price", productPriceList.get(0).getText().trim());
		productInfoMap.put("ex-Tax", productPriceList.get(1).getText().split(":")[1].trim());

		return productInfoMap;

	}
	
	public void selectQuantity(String qty) {
		elementUtil.clearText(quantity);
		elementUtil.doSendKeys(quantity, qty);
	}
	
	public void addToCart(){
		elementUtil.doClick(addToCartButton);
	}

	public int getProductImages() {
		int imageCount =  elementUtil.getElementsList(productImages).size();
		System.out.println("Total number of images: " + imageCount);
		return imageCount;
	}

	public String getPageTitle(String productName) {
		return elementUtil.waitForTitlePresent(productName, 10);
		
	}
	
	public AddToCartpage clickOnItems() {
		elementUtil.getElement(cartButton).click();
		elementUtil.getElement(viewCartLink).click();
		
		return new AddToCartpage(driver);
	}
}
