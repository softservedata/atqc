package com.softserve.edu.oms.data;

interface IFirstname {
	ILastName setFirstName(String firstName);
}

interface ILastName {
	ILoginName setLastName(String lastName);
}

interface ILoginName {
	IPassword setLoginName(String loginName);
}

interface IPassword {
	IEmail setPassword(String password);
}

interface IEmail {
	IRole setEmail(String email);
}

interface IRole {
	IBuild setRole(String role);
}

interface IBuild {
	IUser build();
}

public class User implements IFirstname, ILastName, ILoginName, IPassword,
		IEmail, IRole, IBuild, IUser {
	private String firstName;
	private String lastName;
	private String loginName;
	private String password;
	private String email;
	private String role;

	private User() {
	}

	private User(String firstName, String lastName, String loginName,
			String password, String email, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public static IFirstname get() {
		return new User();
	}

	public ILastName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ILoginName setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public IPassword setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public IEmail setPassword(String password) {
		this.password = password;
		return this;
	}

	public IRole setEmail(String email) {
		this.email = email;
		return this;
	}

	public IBuild setRole(String role) {
		this.role = role;
		return this;
	}

	public IUser build() {
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	// - - - - - - - - - - - - - - - - - - - -
}
