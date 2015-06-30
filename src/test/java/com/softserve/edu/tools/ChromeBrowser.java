package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements IBrowser {

	public WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		return new ChromeDriver();
	}

	public String getWebDriverName() {
		return this.getClass().getName();
		// return "ChromeBrowser";
	}

	public void quit() {
	}

}
