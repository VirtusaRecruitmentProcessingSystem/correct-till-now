package com.virtusa.entities;

public class HREntity {

	private String userName;
private String password;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "HREntity [userName=" + userName + ", password=" + password + "]";
}


	}


//