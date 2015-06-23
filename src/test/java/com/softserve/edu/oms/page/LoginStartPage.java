package com.softserve.edu.oms.page;

import com.softserve.edu.tools.WebDriverUtils;

public class LoginStartPage extends LoginPage {

	private LoginStartPage() {
		super();
	}

	public static LoginStartPage load(String url) {
		WebDriverUtils.get().load(url);
		return new LoginStartPage();
	}

}
