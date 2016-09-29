package com.vikas.groundrun.tool.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class SignUpForm {
	@NotNull
	@Size(min=1, max=255)
	//@Pattern(regexp="[a-zA-Z0-9._%-+]+@([a-zA-Z0-9-.]+\\.([a-zA-Z]{2,5}")
	@Email
	String email;
	
	@NotNull
	@Size(min=1, max=100)
	String name;
	
	@NotNull
	@Size(min=6, max=15)
	String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SignUpForm [email=" + email + ", name=" + name + "]";
	}
}
