package com.qa.OpenSource.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OpenSource.Utils.ElementsUtils;
import com.qa.OpenSource.Base.BasePage;

public class productInfoPage extends BasePage {

	// Step1:Creating by locator

	private WebDriver driver;
	private ElementsUtils elementsutil;

	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productprice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addtoCart = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li a img");

	// step 2: Creating Constructor

	public productInfoPage(WebDriver driver) {
		this.driver = driver;
		elementsutil = new ElementsUtils(driver);

	}

	
	// step3: Creating Page Actions

	public Map<String, String> getProductInformation() {
		Map<String, String> productinfoMap = new HashMap<String, String>();
		productinfoMap.put("name ",elementsutil.doGetText(productNameHeader).trim());

		List<WebElement> productMetaDataList = elementsutil.getElements(productMetaData);
		for (WebElement e : productMetaDataList) {
			// Brand: Apple-- Spliting brand and Apple Seperate hence below logic is used
			productinfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}

		List<WebElement> productPriceList = elementsutil.getElements(productprice);
		productinfoMap.put("Price", productPriceList.get(0).getText().trim());
		productinfoMap.put("Ex tax", productPriceList.get(1).getText().trim());
		return productinfoMap;
	}

	public void selectQuantity(String qty) {
		elementsutil.doSendKeys(quantity, qty);
	}

	public void addtoCart() {
		elementsutil.doClick(addtoCart);
	}

	public int getProductImages() {
		int ImageSizeCount= elementsutil.getElements(productImages).size();
	System.out.println("Image Size Count is : "+ImageSizeCount);
	return ImageSizeCount;
	}


	public String productinfoPagetitle(String productname) {

		return elementsutil.waitForTitlePresent(productname,5);
		
		
	}

}
