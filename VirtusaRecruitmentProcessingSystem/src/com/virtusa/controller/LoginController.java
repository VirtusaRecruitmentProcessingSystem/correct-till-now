package com.virtusa.controller;

import com.virtusa.model.SessionForwading;
import com.vrps.authentication.UserAuthentication;

public class LoginController {
	
	public SessionForwading userAuthentication(String username,String password,int option) {
	UserAuthentication userAuth=new UserAuthentication();
	SessionForwading sf=userAuth.Verification(username, password,option);
	
		return sf;
	
	}
}
