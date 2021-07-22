package com.qa.OpenSource.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OpenSource.Utils.ElementsUtils;
import com.qa.OpenSource.Base.BasePage;

public class AccountsPage extends BasePage

{

	private WebDriver driver;
	private ElementsUtils elementsutil;
	// 1 -- Creating Private By Locators

	private By Header = By.cssSelector("div #logo");
	private By AccountsHeaders = By.cssSelector("div #content h2");
	private By SearchTest = By.cssSelector(".input-group input[type='text']");
	private By SearchBttn = By.cssSelector("div#search button[type='button']");
	private By SearchItemResult = By.cssSelector(".product-layout .product-thumb");
    private By resultsItems=By.cssSelector(".product-thumb h4 a");
	
	/*
	 * class in CSS can be called by . class name div #any other attribute can be
	 * called like this
	 * 
	 */
	// 2--Creating a clas constructor

	// We are doing encapsulaton-- we are using the private driver
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		 elementsutil=new ElementsUtils(driver);
		
	}

	// Creating By actions

	public String GetPageTittle() {
		return driver.getTitle();
	}

	public String getHeadervalue() {
		if (driver.findElement(Header).isDisplayed()) {
			return driver.findElement(Header).getText();
		}
		return null;
	}

	public int getAccountssectionCount() {
		return driver.findElements(AccountsHeaders).size();

	}

	public List<String> getAccountsSectionList() {

		List<String> AccountList = new ArrayList<String>();
		List<WebElement> AccountsSecList = driver.findElements(AccountsHeaders);

		for (WebElement e : AccountsSecList) {

			System.out.println(e.getText());
			AccountList.add(e.getText());
		}
		return AccountList;

	}

	public boolean doSearch(String ProductName) {

		driver.findElement(SearchTest).sendKeys(ProductName);
		driver.findElement(SearchBttn).click();

		if (driver.findElements(SearchItemResult).size() > 0) {
			return true;
		}
		return false;
	}
	
	
	public productInfoPage SelectProductFromResults(String ProductName) 	{
		

	List<WebElement>resultItems=elementsutil.getElements(resultsItems);

	for(WebElement e:resultItems)
	{
		if(e.getText().contains(ProductName))
		{
			e.click();
			break;
		}
	}
	// Page Chaining SInce from AccountPage to productinfoPage we need to go after the product is selected
	
	return new productInfoPage(driver);
	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
