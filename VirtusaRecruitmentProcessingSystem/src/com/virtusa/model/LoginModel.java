package com.virtusa.model;
import com.vrps.authentication.UserAuthentication;
public class LoginModel {
String username;
String password;

	public LoginModel(String username,String password) {
		this.username=username;
		this.password=password;
	//	userAuthentication(username,password);
	}

	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	
	}
	

}