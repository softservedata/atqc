package com.softserve.edu.tools;

public class TextCriteria {
	private static final String TEXT_NOT_EQUAL = "Texts are not equal: Expected is [%s] Actual is: [%s]";
	private String text;
	private AssertWrapper assertWrapper;

	private TextCriteria(String text, AssertWrapper assertWrapper) {
		this.text = text;
		this.assertWrapper = assertWrapper;
	}

	public static TextCriteria get(String text, AssertWrapper assertWrapper) {
		return new TextCriteria(text, assertWrapper);
	}

	public TextCriteria isEqualText(String text) {
		assertWrapper.verify(this.text.equals(text),
				String.format(TEXT_NOT_EQUAL, text, this.text));
		return this;
	}

	public TextCriteria isExistText(String text) {
		assertWrapper.verify(this.text.indexOf(text) >= 0,
				String.format(TEXT_NOT_EQUAL, text, this.text));
		return this;
	}

	public AssertWrapper next() {
		return assertWrapper;
	}

}
