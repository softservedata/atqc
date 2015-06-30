package com.softserve.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.tools.ContextVisible;

public class CustomerHomePage extends HomePage {
	private WebElement ordering;

	public CustomerHomePage() {
		super();
		ordering = ContextVisible.get().getVisibleWebElement(By.partialLinkText("Ordering"));
	}

	// public OrderingPage navigateToAdministrationPage() {
	public void navigateToOrderingPage() {
		ordering.click();
		// return new OrderingPage();
	}

}