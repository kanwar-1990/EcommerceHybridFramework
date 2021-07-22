package com.qa.OpenSource.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OpenSource.Utils.ElementsUtils;
import com.qa.OpenSource.Base.BasePage;

public class RegisterPage extends BasePage {

	// Step1: Creating By locators

	private WebDriver driver;

	private ElementsUtils elementsutil;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By Confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.cssSelector(".radio-inline:first-of-type input");
	private By subscribeno = By.cssSelector(".radio-inline:last-of-type input");
	private By agreecheckbox = By.name("agree");
	private By continueButton = By.cssSelector("[type='submit']");
	private By accountSuccessMesg = By.className("#content h1");
	private By Logoutlink = By.linkText("Logout");
	private By registerlink = By.linkText("Register");

	// .radio-inline:last-of-type input

	// step2: Creating class Constructor

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementsutil = new ElementsUtils(this.driver);
	}

	// Step3: Creating Page Actions

	public Boolean accountregistration(String firstname, String lastname, String email, String telephone,
			String password, String subsriber) {
		elementsutil.doSendKeys(this.firstname, firstname);
		elementsutil.doSendKeys(this.lastname, lastname);
		elementsutil.doSendKeys(this.email, email);
		elementsutil.doSendKeys(this.telephone, telephone);
		elementsutil.doSendKeys(this.password, password);
		elementsutil.doSendKeys(this.Confirmpassword, password);

		if (subsriber.contains("yes")) {
			elementsutil.doClick(subscribeYes);
		} else {
			elementsutil.doActionsClick(subscribeno);
		}

		elementsutil.doClick(agreecheckbox);
		elementsutil.doClick(continueButton);

		String text = elementsutil.doGetText(accountSuccessMesg);
		if (text.equalsIgnoreCase("Your Account has Been Created")) {
			elementsutil.doClick(Logoutlink);
			return true;
		}

		return false;

	}

}
