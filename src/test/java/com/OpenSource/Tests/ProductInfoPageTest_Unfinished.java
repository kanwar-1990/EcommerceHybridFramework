package com.OpenSource.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenSource.Base.BaseTest;

public class ProductInfoPageTest_Unfinished extends BaseTest {

	@BeforeClass
	public void productinfoSetup() {
		accountPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	/*
	 * Need to write Test case for adding the qauntity and addtoCart
	 * 
	 * After Add to cart we need to get the output on the success method we can
	 * create end to end from here add the values and check out
	 * 
	 * We can write multiple test cases, by testing product of electronics,garments
	 * etc
	 * 
	 */

	@Test(priority=1)
	public void getProductinfoPageTitleTest() {
		String productName = "MacBook Pro";

		accountPage.doSearch(productName);
		productinfoPage = accountPage.SelectProductFromResults(productName);

		Assert.assertEquals(productinfoPage.productinfoPagetitle(productName), "MacBook Pro");
	}

	@Test(priority = 2)
	public void verifyProductinfotest_MacBookPro() {
		String productName = "MacBook";
		Assert.assertTrue(accountPage.doSearch(productName));
		productinfoPage = accountPage.SelectProductFromResults("MacBook Pro");
		Assert.assertTrue(productinfoPage.getProductImages() == 3);

		Map<String, String> productinfo = productinfoPage.getProductInformation();
		System.out.println("Info on th product page is :" + productinfo);

		/*
		 * {Brand=Apple, Availability=In Stock, Price=$2,000.00, Ex tax=Ex Tax:
		 * $2,000.00, Product Code=Product 18, Reward Points=800, name =MacBook Pro}
		 */

		Assert.assertEquals(productinfo.get("Brand"), "Apple");
		Assert.assertEquals(productinfo.get("Availability"), "In Stock");
		Assert.assertEquals(productinfo.get("Price"), "$2,000.00");
		// Assert.assertEquals(productinfo.get("name"),"MacBook Pro");

	}

	@Test(enabled = false)
	public void verifyProductinfotest_IMAC() {
		String productName = "iMac";
		Assert.assertTrue(accountPage.doSearch(productName));
		productinfoPage = accountPage.SelectProductFromResults("iMac");
		Assert.assertTrue(productinfoPage.getProductImages() == 1);

		Map<String, String> productinfo = productinfoPage.getProductInformation();
		System.out.println("Info on th product page is :" + productinfo);

		/*
		
		
		*/
		Assert.assertEquals(productinfo.get("name "), "MacBook Pro");
		Assert.assertEquals(productinfo.get("Product Code"), "Product 18");
		Assert.assertEquals(productinfo.get("Price"), "$2,000.00");
		Assert.assertEquals(productinfo.get(" Reward Points=800"), "800");
		;

	}

}
