package com.qa.OpenSource.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.OpenSource.Utils.OptionsManagers;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author knwrp
 *
 */
public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManagers optionsManager;
	public static String highlight; //to instialize flash highlight

	/**
	 * this method is used to intialize the browser on the basis of given
	 * browser....
	 * 
	 * @param browser
	 * @return this returns webdriver driver
	 */

	public WebDriver init_driver(String browser) {
		System.out.println(" browser value is  :" + browser);
		highlight = prop.getProperty("highlight"); // to use flash colour we need 

		
		
		optionsManager = new OptionsManagers(prop);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
			/**
			 * to run in HEADLESS mode and INCOGNITO Mode, we can change the value into true
			 * in properties file and run a test case
			 */

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * this method is used to load the properties from config.proprties file
	 * 
	 * @return it return properties prop reference
	 */

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/main/java/com/qa/OpenSource/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
