package com.softserve.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.tools.ContextVisible;

public class AdministrationPage {
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

	private AdministrationPageIUMap controls;
	
	public AdministrationPage(){
		this.controls = new AdministrationPageIUMap();
	}
	
}
