package com.OpenSource.Utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManagers {

	private Properties prop;
	private ChromeOptions co;

	public OptionsManagers(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();

		// Properties class used to take key and value from properties file

		if (prop.getProperty("headless").trim().equals("true"))
			co.addArguments("--headless");
		if (prop.getProperty("incognito").trim().equals("true"))
			co.addArguments("--incognito");
		return co;

	}

	public FirefoxOptions getFirFoxOptions() {
		FirefoxOptions fo = new FirefoxOptions();
		if (prop.getProperty("headless").trim().equals("true"))
			fo.addArguments("--headless");
		if (prop.getProperty("incognito").trim().equals("true"))
			fo.addArguments("--incognito");
		return fo;

	}

}
