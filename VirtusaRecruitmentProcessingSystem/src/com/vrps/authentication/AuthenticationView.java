package com.vrps.authentication;

import java.util.Scanner;

import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;


public class AuthenticationView {
	Scanner scanner1=new Scanner(System.in);
//public static void main(String[] args) {
	
	// try putting Login model for username,password and then retrieving data from it
		public SessionForwading main(int option) {
		// TODO Auto-generated method stub

		
		System.out.println();
		
		System.out.print("Enter UserName:");
		String username1=scanner1.next();
		System.out.print("Enter Password:");
		String password1=scanner1.next();
	

		LoginModel lm=new LoginModel(username1,password1);
		System.out.print(lm.getUsername()+"/-user-"+lm.getPassword()+"/paff-------auht view");
		
		UserAuthentication auth=new UserAuthentication();
		
		// boolean result;
		SessionForwading sf =auth.Verification(lm,option );
		 System.out.print("----result--"+sf.isStatus());
		 return sf;
	// System.out.print(result);
	}

}

