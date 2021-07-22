package com.OpenSource.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OpenSource.Utils.Constants;
import com.qa.OpenSource.Base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void HomePageSetup() {
		accountPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)

	public void AccountPagetitleTest() {
		String title = accountPage.GetPageTittle();
		
		System.out.println("Accounts Page title is: "+title);
		
		Assert.assertEquals(title, Constants.Accounts_Page_Title);

	}

	@Test(priority = 2)

	public void getHeadervalueTest() {
		String Headervalue = accountPage.getHeadervalue();

     System.out.println("Accounts Page Header is :"+Headervalue);		
		Assert.assertEquals(Headervalue, Constants.Accounts_Page_Header);
	}

	@Test(priority = 3)

	public void getAccountsSectionCountTest()

	{
		Assert.assertTrue(accountPage.getAccountssectionCount() == Constants.Account_Sections_List);
	}

	@Test(priority = 4)

	public void getAccountSectionList() {
		Assert.assertEquals(accountPage.getAccountsSectionList(), Constants.getAccountSectionList());
	}

	@Test(priority = 5)

	public void dosearchTest() {

		Assert.assertTrue(accountPage.doSearch("imac"));

	}

}
