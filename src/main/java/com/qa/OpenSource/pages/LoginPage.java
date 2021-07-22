package com.qa.OpenSource.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OpenSource.Utils.ElementsUtils;
import com.qa.OpenSource.Base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;// constructor is needed since this pointing to no body

	// By Locators

	private By UseremailId = By.id("input-email");
	private By Password = By.id("input-password");
	private By LoginBt = By.xpath("//input[@type='submit']");
	private By ForgotPwd = By.linkText("Forgotten Password");

	private By RegisterLink = By.linkText("Register");

	// 2) Constructor of the Page Class---constructor is needed since

	public LoginPage(WebDriver driver) {
		/*
		 * this: to refer current class instance variable. The this keyword can be used
		 * to refer current class instance variable. If there is ambiguity between the
		 * instance variables and parameters, this keyword resolves the problem of
		 * ambiguity.
		 */
		this.driver = driver;
	}

	// Page Actions : feature (Behaviours) of the page in the form methods
	public String PageTittle() {

		return driver.getTitle();
	}

	public boolean isForgotPwd() {
		return driver.findElement(ForgotPwd).isDisplayed();

	}

	public AccountsPage doLogin(String usr, String pwd) {
		System.out.println("Login with " + usr + " " + pwd);

		driver.findElement(UseremailId).sendKeys(usr);

		driver.findElement(Password).sendKeys(pwd);

		driver.findElement(LoginBt).click();

		//

		return new AccountsPage(driver);
	}

	// Since register option is in login Page we are creating a method here to click
	// on register
	public RegisterPage navigateToRegisterPage() {
		driver.findElement(RegisterLink).click();
		return new RegisterPage(driver);

	}

}
