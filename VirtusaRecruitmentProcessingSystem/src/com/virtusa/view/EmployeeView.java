package com.virtusa.view;

import java.util.Scanner;

import com.virtusa.ui.VRPSHome;
import com.vrps.authentication.AuthenticationView;

public class EmployeeView {

	public void main() {
		
		System.out.println("\n---------Employee Login Module-------");
		
	//	UserAuthentication EmployeeAuth=new UserAuthentication();
		//EmployeeAuth.employeeAuth();
		
		AuthenticationView empAuth=new AuthenticationView();
		empAuth.main(2);
		
	}
	public void mainMenu() {
		System.out.println("------------Employee------------\n1.Employee Login \n2.Back");
		Scanner sc=new Scanner(System.in);
		int y=sc.nextInt();
		
		if(y==1)
			main();
		else {
			VRPSHome back=new VRPSHome();
			back.main(null);
		}
	}
}