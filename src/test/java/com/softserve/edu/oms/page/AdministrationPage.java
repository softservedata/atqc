package com.softserve.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.tools.ContextVisible;

public class AdministrationPage {
	public static enum AdministrationPageFields {
		ALL_COLUMNS("All Columns"),
		FIRST_NAME("First Name"),
		LAST_NAME("Last Name"),
		ROLE("Role"),
		LOGIN_NAME("Login Name");
		//
		private String field;

		private AdministrationPageFields(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	public static enum AdministrationPageConditions {
		EQUALS("equals"),
		NOT_EQUALS_TO("not equals to"),
		STARTS_WITH("starts with"),
		CONTAINS("contains"),
		DOES_NOT_CONTAIN("does not contain");
		//
		private String field;

		private AdministrationPageConditions(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	private class AdministrationPageIUMap {
		public final WebElement createNewUser;
		public final Select selectField;
		public final Select selectCondition;
		public final WebElement searchField;
		public final WebElement logout;

		public AdministrationPageIUMap() {
			this.createNewUser = ContextVisible.get().getVisibleWebElement(By
					.partialLinkText("Create New User"));
			this.selectField = new Select(ContextVisible.get().getVisibleWebElement(By
					.id("field")));
			this.selectCondition = new Select(ContextVisible.get().getVisibleWebElement(By
					.id("condition")));
			this.searchField = ContextVisible.get().getVisibleWebElement(By
					.id("searchField"));
			this.logout = ContextVisible.get().getVisibleWebElement(By.xpath("//a[@href='/OMS/logout.htm']"));
		}
	}
	
	private class AdministrationPageUIMapAjax {
		public final WebElement usersFound;
		public final WebElement firstName;
		public final WebElement lastName;
		public final WebElement login;
		public final WebElement delete;

		public AdministrationPageUIMapAjax() {
			this.usersFound = ContextVisible.get().getVisibleWebElement(By.id("usersFound"));
			if (Integer.parseInt(usersFound.getText()) > 0) {
				this.firstName = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody/tr[1]/td[1]"));
				this.lastName = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody/tr[1]/td[2]"));
				this.login = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody/tr[1]/td[3]"));
				this.delete = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody/tr[1]/td[7]/a"));
			} else {
				this.firstName = ContextVisible.get().getVisibleWebElement(By.xpath("//thead/tr[1]/th[1]"));
				this.lastName = ContextVisible.get().getVisibleWebElement(By.xpath("//thead/tr[1]/th[2]"));
				this.login = ContextVisible.get().getVisibleWebElement(By.xpath("//thead/tr[1]/th[3]"));
				this.delete = ContextVisible.get().getVisibleWebElement(By.xpath("//thead/tr[1]/th[1]"));
			}
		}

		public AdministrationPageUIMapAjax(String login) {
			this.usersFound = ContextVisible.get().getVisibleWebElement(By.id("usersFound"));
			//
			this.login = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody//td[3][text()='" + login + "']"));
			this.lastName = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[1]"));
			this.firstName = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[2]"));
			this.delete = ContextVisible.get().getVisibleWebElement(By.xpath("//tbody//td[3][text()='" + login + "']/following-sibling::td[4]/a"));
		}

	}
	
	private AdministrationPageIUMap controls;
	private AdministrationPageUIMapAjax controlsAjax;
	
	public AdministrationPage(){
		this.controls = new AdministrationPageIUMap();
		this.controlsAjax = new AdministrationPageUIMapAjax();
	}

    // getters controls

	public WebElement getCreateNewUser() {
		return this.controls.createNewUser;
	}

	public Select getField() {
		return this.controls.selectField;
	}

	public Select getCondition() {
		return this.controls.selectCondition;
	}

	public WebElement getSearchField() {
		return this.controls.searchField;
	}

	public WebElement getLogout() {
		return this.controls.logout;
	}

    // getters controlsAjax

	public WebElement getUsersFound() {
		return this.controlsAjax.usersFound;
	}

	public WebElement getFirstName() {
		return this.controlsAjax.firstName;
	}

	public WebElement getLastName() {
		return this.controlsAjax.lastName;
	}

	public WebElement getLogin() {
		return this.controlsAjax.login;
	}

	public WebElement getDelete() {
		return this.controlsAjax.delete;
	}

	// setters controls

	public void createNewUserClick() {
		this.controls.createNewUser.click();
	}

	public void selectColumnFields(AdministrationPageFields field) {
		this.controls.selectField.selectByVisibleText(field.toString());
	}

	public void selectMatchConditions(AdministrationPageConditions condition) {
		this.controls.selectCondition.selectByVisibleText(condition.toString());
	}

	public void searchFieldClear() {
		this.controls.searchField.clear();
	}

	public void searchFieldClick() {
		this.controls.searchField.click();
	}
	
	public void searchFieldSendKeys(String text) {
		this.controls.searchField.sendKeys(text);
	}

	public void logoutClick() {
		this.controls.logout.click();
	}
	
	// setters controlsAjax

	public void resetTable() {
		if (ContextVisible.get().isStalenessOfWebElement((this.controlsAjax.firstName))) {
			controlsAjax = new AdministrationPageUIMapAjax();
		}
	}
	
	public void resetTable(String login) {
		if (ContextVisible.get().isStalenessOfWebElement((this.controlsAjax.firstName))) {
			controlsAjax = new AdministrationPageUIMapAjax(login);
		}
	}

	public void deleteClick() {
		this.controlsAjax.delete.click();
		// this.controlsAlert = new Alert();
	}

	// business logic
	
	public void searchByLoginName(AdministrationPageFields field,
			AdministrationPageConditions condition, IUser user) {
		selectColumnFields(field);
		selectMatchConditions(condition);
		searchFieldSendKeys(user.getLoginName());
		// Initialize AJAX Elements
		resetTable(user.getLoginName());
	}

}
