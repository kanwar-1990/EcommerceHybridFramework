package com.OpenSource.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenSource.Base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void VerifyLoginPageTittleTest() {

		String title = loginpage.PageTittle();
		System.out.println("LoginPage: " + title);
		Assert.assertEquals(title, "Account Login");
	}
	@Test(priority = 2)
	public void ISForgotPasswordVisible() {
		Assert.assertTrue(loginpage.isForgotPwd());
	}
	@Test(priority = 3)
	public void doLoginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
