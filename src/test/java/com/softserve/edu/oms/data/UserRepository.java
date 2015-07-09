package com.softserve.edu.oms.data;

import java.util.List;

public class UserRepository {
	public static IUser getInvalidUser() {
		return User.get()
				.setFirstName("ivanka")
				.setLastName("horoshko")
				.setLoginName("iva")
				.setPassword("ytrewq")
				.setEmail("mail@gmail.com")
				.setRole("Administrator")
				.build();
	}

	public static IUser getAdminUser() {
		return User.get()
					.setFirstName("ivanka")
					.setLastName("horoshko")
					.setLoginName("iva")
					.setPassword("qwerty")
					.setEmail("mail@gmail.com")
					.setRole("Administrator")
					.build();
				//new User("ivanka", "horoshko", "iva", "qwerty", "mail@gmail.com", "Administrator");
	}

	public static IUser getCustomerUser() {
		return User.get()
					.setFirstName("firstName1")
					.setLastName("lastName1")
					.setLoginName("login1")
					.setPassword("qwerty")
					.setEmail("mail@gmail.com")
					.setRole("Customer")
					.build();
	}

	public static IUser getSearchUser() {
		return User.get()
					.setFirstName("a")
					.setLastName("a")
					.setLoginName("aaa")
					.setPassword("qwerty")
					.setEmail("mail@gmail.com")
					.setRole("Customer")
					.build();
	}

	public static List<IUser> getAllValidAdminUsersFormExcel() {
		return (new ExcelUsers()).getAllUsers(); 
	}

	public static List<IUser> getAllValidAdminUsersFormCSV() {
		return (new CSVUsers()).getAllUsers(); 
	}

	public static IUser getValidUserFormProperties() {
		return (new PropertiesUser()).getUser();
	}

}
