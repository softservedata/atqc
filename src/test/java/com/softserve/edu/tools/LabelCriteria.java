package com.softserve.edu.tools;

import org.openqa.selenium.WebElement;

public class LabelCriteria {
	private static final String WHEN_LABEL_NOT_VISIBLE = "Label it's not visible";
	private static final String TEXT_NOT_EQUAL = "Texts are not equal: Expected is [%s] Actual is: [%s]";
	private WebElement webElement;
	private AssertWrapper assertWrapper;

	private LabelCriteria(WebElement webElement, AssertWrapper assertWrapper) {
		this.webElement = webElement;
		this.assertWrapper = assertWrapper;
	}

	public static LabelCriteria get(WebElement webElement,
			AssertWrapper assertWrapper) {
		return new LabelCriteria(webElement, assertWrapper);
	}

	public LabelCriteria isVisible() {
		assertWrapper.verify(this.webElement.isDisplayed(),
				WHEN_LABEL_NOT_VISIBLE);
		return this;
	}

	public LabelCriteria isEqualText(String text) {
		assertWrapper.verify(this.webElement.getText().equals(text),
				String.format(TEXT_NOT_EQUAL, text, this.webElement.getText()));
		return this;
	}

	public LabelCriteria isExistText(String text) {
		assertWrapper.verify(this.webElement.getText().indexOf(text) >= 0,
				String.format(TEXT_NOT_EQUAL, text, this.webElement.getText()));
		return this;
	}

	public AssertWrapper next() {
		return assertWrapper;
	}

}
