package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements IBrowser {
	
	public WebDriver getWebDriver() {
		return new FirefoxDriver();
	}

	public void quit() {
	}

}
