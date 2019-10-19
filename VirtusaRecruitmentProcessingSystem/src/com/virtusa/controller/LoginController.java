package com.virtusa.controller;

import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;
import com.vrps.authentication.UserAuthentication;

public class LoginController {
	
	public SessionForwading userAuthentication(String username,String password,int option) {
	UserAuthentication userAuth=new UserAuthentication();
	LoginModel lm=new LoginModel(username,password);
	SessionForwading sf=userAuth.Verification(lm,option);
	
		return sf;
	
	
	}
}
