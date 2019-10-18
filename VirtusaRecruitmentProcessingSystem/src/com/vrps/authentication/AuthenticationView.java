package com.vrps.authentication;

import java.util.Scanner;

import com.virtusa.model.SessionForwading;


public class AuthenticationView {

//public static void main(String[] args) {
	
	// try putting Login model for username,password and then retrieving data from it
		public SessionForwading main(int option) {
		// TODO Auto-generated method stub

		String username=null;
		String password=null;
		System.out.println();
		Scanner scanner1=new Scanner(System.in);
		System.out.print("Enter UserName:");
		String username1=scanner1.next();
		System.out.print("Enter Password:");
		String password1=scanner1.next();
	
		UserAuthentication auth=new UserAuthentication();
		
		// boolean result;
		 SessionForwading sf =auth.Verification(username1,password1,option );
		 System.out.print("----result--"+sf.isStatus());
		 return sf;
	// System.out.print(result);
	}

}

