package com.qa.tispring.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.qa.tispring.pages.AccountsPage;
import com.qa.tispring.pages.AddToCartpage;
import com.qa.tispring.pages.LoginPage;
import com.qa.tispring.pages.ProductInfoPage;
import com.qa.tispring.pages.RegisterPage;


public class BaseTest {

	public Basepage basepage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;
	public AddToCartpage addToCartpage;
	public Properties prop;
	public WebDriver driver;

	//@BeforeMethod
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {

		basepage = new Basepage();
		prop = basepage.init_prop();
		String browser = prop.getProperty("browser");
		if(browserName!=null) {
			browser = browserName;
		}
		driver = basepage.init_driver(browser);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));

	}
	
	//@AfterMethod
	@AfterTest
	public void tearDown() {
	driver.quit();
	}
}
