package com.softserve.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.tools.ContextVisible;

public abstract class HomePage {
	private WebElement firstName;
	private WebElement lastName;
	private WebElement role;
	private WebElement logout;

	public HomePage() {
		firstName = ContextVisible.get().getVisibleWebElement(By
				.xpath("//td[text()='First name']/following-sibling::td"));
		lastName = ContextVisible.get().getVisibleWebElement(By
				.xpath("//td[text()='Last name']/following-sibling::td"));
		role = ContextVisible.get().getVisibleWebElement(By
				.xpath("//td[text()='Role']/following-sibling::td"));
		logout = ContextVisible.get().getVisibleWebElement(By.xpath("//a[@href='/OMS/logout.htm']"));
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

	public String getRole() {
		return role.getText();
	}

	public LoginPage logout() {
		logout.click();
		return new LoginPage();
	}
	
}
