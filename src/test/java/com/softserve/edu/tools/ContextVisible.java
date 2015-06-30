package com.softserve.edu.tools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ContextVisible {
	private final String ERROR_NOT_FOUND = "WebElement was not found %s";
	private final String ERROR_STILL_VISIBLE = "WebElement is Still Visible %s";
	private static volatile ContextVisible instance = null;

	private ContextVisible() {
	}

	public static ContextVisible get() {
		if (instance == null) {
			synchronized (ContextVisible.class) {
				if (instance == null) {
					instance = new ContextVisible();
				}
			}
		}
		return instance;
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a
	 * page and visible.
	 */
	public WebElement getVisibleWebElement(By controlLocation) {
		WebElement webElement = null;
		try {
			webElement = new WebDriverWait(
					WebDriverUtils.get().getWebDriver(),
					WebDriverUtils.get().getImplicitlyWaitTimeout())
				.until(ExpectedConditions
					.visibilityOfElementLocated(controlLocation));
		} catch (Exception e) {
			throw new ScreenCapturingCustomException(String.format(ERROR_NOT_FOUND,
					controlLocation.toString()));
		}
		if (webElement == null) {
			throw new ScreenCapturingCustomException(String.format(ERROR_NOT_FOUND,
					controlLocation.toString()));
		}
		return webElement;
	}

	/**
	 * An expectation for checking that all elements present on the web page
	 * that match the locator are visible.
	 */
	public List<WebElement> getVisibleWebElements(By controlLocation) {
		List<WebElement> webElements = new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
			.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(controlLocation));
		if (webElements == null) {
			// TODO Develop My Exception
			throw new RuntimeException(String.format(ERROR_NOT_FOUND,
					controlLocation.toString()));
		}
		return webElements;
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a
	 * page. This does not necessarily mean that the element is visible.
	 */
	public WebElement getPresentWebElement(By controlLocation) {
		WebElement webElement = new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
			.until(ExpectedConditions
				.presenceOfElementLocated(controlLocation));
		if (webElement == null) {
			// TODO Develop My Exception
			throw new RuntimeException(String.format(ERROR_NOT_FOUND,
					controlLocation));
		}
		return webElement;
	}

	/**
	 * An expectation for checking that an element is either invisible or not
	 * present on the DOM.
	 */
	public boolean isInvisibleWebElement(By controlLocation) {
		Boolean invisibilityWebElement = new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
			.until(ExpectedConditions
				.invisibilityOfElementLocated(controlLocation));
		if (!invisibilityWebElement) {
			// TODO Develop My Exception
			throw new RuntimeException(String.format(ERROR_STILL_VISIBLE,
					controlLocation));
		}
		return invisibilityWebElement;
	}

	/**
	 * Wait until an element is no longer attached to the DOM.
	 * Do not mix implicit and explicit waits.
	 */
	public boolean isStalenessOfWebElement(WebElement webElement) {
		WebDriverUtils.get().setImplicitlyWaitTimeout(0L);
		Boolean stalenessOfWebElement = new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
			.until(ExpectedConditions.stalenessOf(webElement));
		if (!stalenessOfWebElement) {
			// TODO Develop My Exception
			throw new RuntimeException(String.format(ERROR_STILL_VISIBLE,
					webElement.getTagName()));
		}
		WebDriverUtils.get().setImplicitlyWaitTimeout(WebDriverUtils.get().getImplicitlyWaitTimeout());
		return stalenessOfWebElement;
	}
	
	public boolean isVisibleTitle(String title) {
		return new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
					.until(ExpectedConditions.titleContains(title));
	}

}
