package com.qa.OpenSource.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.OpenSource.pages.AccountsPage;
import com.qa.OpenSource.pages.LoginPage;
import com.qa.OpenSource.pages.RegisterPage;
import com.qa.OpenSource.pages.productInfoPage;

public class BaseTest {

	public BasePage basepage;

	public Properties prop;

	public WebDriver driver;

	public LoginPage loginpage;

	public AccountsPage accountPage;

	public productInfoPage productinfoPage;
	
	public RegisterPage registerpage;

	@BeforeTest
	public void setup() {

		basepage = new BasePage();
		prop = basepage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		accountPage = new AccountsPage(driver);
		productinfoPage = new productInfoPage(driver);
		registerpage=new RegisterPage(driver);
	
	}

	@AfterTest
	public void Teardown() {
		// driver.quit();
	}

}
