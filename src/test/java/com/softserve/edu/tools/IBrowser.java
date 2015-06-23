package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

	WebDriver getWebDriver();

	void quit();

}
