package com.softserve.edu.oms.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.softserve.edu.tools.GeneralCustomException;

public class PropertiesUser {
	public static enum UserPropertiesKeys {
		LOGIN_NAME("loginName"),
		FIRST_NAME("firstName"),
		LAST_NAME("lastName"),
		PASSWORD("password"),
		EMAIL("email"),
		ROLE("role");
		private String field;

		private UserPropertiesKeys(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private static final String USER_PROPERTIES_FILE_NAME = "/user.properties";
	private static final String PROPERTIES_EXCEPTION_READ = " File %s could not be read";
	private static final String PROPERTIES_EXCEPTION_CLOSE = " File %s could not be closed";

	public IUser getUser() {
		return getUser(this.getClass()
				.getResource(USER_PROPERTIES_FILE_NAME).getPath().substring(1));
	}

	public IUser getUser(String absoluteFilePath) {
		IUser user;
		Properties properties = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(absoluteFilePath);
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new GeneralCustomException(String.format(
					PROPERTIES_EXCEPTION_READ, absoluteFilePath), e);
		}
		user = User.get()
				.setFirstName(properties
						.getProperty(UserPropertiesKeys.FIRST_NAME.toString(), new String()))
				.setLastName(properties
						.getProperty(UserPropertiesKeys.LAST_NAME.toString(), new String()))
				.setLoginName(properties
						.getProperty(UserPropertiesKeys.LOGIN_NAME.toString(), new String()))
				.setPassword(properties
						.getProperty(UserPropertiesKeys.PASSWORD.toString(), new String()))
				.setEmail(properties
						.getProperty(UserPropertiesKeys.EMAIL.toString(), new String()))
				.setRole(properties
						.getProperty(UserPropertiesKeys.ROLE.toString(), new String()))
				.build();
		try {
			fileInputStream.close();
		} catch (IOException e) {
			throw new GeneralCustomException(
					String.format(PROPERTIES_EXCEPTION_CLOSE, absoluteFilePath), e);
		}
		return user;
	}
}
