package com.qa.tispring.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tispring.base.Basepage;
import com.qa.tispring.utils.Constants;
import com.qa.tispring.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage extends Basepage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo h1 a");
	private By accountHeader = By.cssSelector("div#content h2");
	private By searchBox = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemResult = By.cssSelector("div.product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	@Step("getting account page title")
	public String getAccountsPageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.Account_Page_Title, 5);
	}

	@Step("getting the header value")
	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	@Step("getting the Account section count")
	public int getAccountSectionCount() {
		return elementUtil.getElementsList(accountHeader).size();
	}

	@Step("getting the Account section List")
	public List<String> getAccountSectionList() {
		List<String> accountsList = new ArrayList<String>();
		List<WebElement> accSectionList = elementUtil.getElementsList(accountHeader);
		System.out.println(accountsList);
		for (WebElement e : accSectionList) {
			System.out.println(e.getText());
			accountsList.add(e.getText());

		}

		return accountsList;
	}

	@Step("Searching a product name : {0}")
	public boolean doSearch(String productName) {	
		
		elementUtil.getElement(searchBox).clear();
		elementUtil.doSendKeys(searchBox, productName);
		elementUtil.doClick(searchButton);

		if (elementUtil.getElementsList(searchItemResult).size() > 0) {
			return true;
		}
		return false;

	}

	@Step("Selecting a product with name : {0}")
	public ProductInfoPage selectProductFromResults(String productName) {

		List<WebElement> resultItemList = elementUtil.getElementsList(resultItems);
		System.out.println("total number of items displayed:" + resultItemList.size());
		for(WebElement e : resultItemList) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}

}
