package com.softserve.edu.oms.data;

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

}
