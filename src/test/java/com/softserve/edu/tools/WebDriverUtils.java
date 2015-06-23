package com.softserve.edu.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverUtils {
	private static volatile WebDriverUtils instance = null;
	private long implicitlyWaitTimeout = 20;
	private WebDriver driver;

	private WebDriverUtils() {
	}

	public static WebDriverUtils get() {
		if (instance == null) {
			synchronized (WebDriverUtils.class) {
				if (instance == null) {
					instance = new WebDriverUtils();
				}
			}
		}
		return instance;
	}

	public WebDriver getWebDriver() {
		if (driver == null) {
			synchronized (WebDriverUtils.class) {
				if (driver == null) {
					driver = new FirefoxDriver();
					driver.manage()
							.timeouts()
							.implicitlyWait(getImplicitlyWaitTimeout(),
									TimeUnit.SECONDS);
					driver.manage().window().maximize();
				}
			}
		}
		return driver;
	}

	public long getImplicitlyWaitTimeout() {
		return implicitlyWaitTimeout;
	}

	public void load(String path) {
		getWebDriver().get(path);
	}

	public void refresh() {
		getWebDriver().navigate().refresh();
	}

	public void stop() {
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	public void forwardPage() {
		// TODO Use try
		getWebDriver().navigate().forward();
	}

	public void previousPage() {
		// TODO Use try
		getWebDriver().navigate().back();
	}

	public String getCurrentUrl() {
		return getWebDriver().getCurrentUrl();
	}
	
}
