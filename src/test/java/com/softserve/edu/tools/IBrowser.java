package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

	WebDriver getWebDriver();

	String getWebDriverName();

	void quit();

}
