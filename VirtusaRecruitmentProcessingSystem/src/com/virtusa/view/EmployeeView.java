package com.virtusa.view;

import java.util.Scanner;

import com.virtusa.model.SessionForwading;
import com.virtusa.ui.VRPSHome;
import com.vrps.authentication.AuthenticationView;

public class EmployeeView {
	Scanner sc=new Scanner(System.in);
	SessionForwading sf;
	
	public void main() {
		
		System.out.println("\n---------Employee Login Module-------");
		
	//	UserAuthentication EmployeeAuth=new UserAuthentication();
		//EmployeeAuth.employeeAuth();
		
		AuthenticationView empAuth=new AuthenticationView();
		sf=empAuth.main(2);
		if(!sf.isStatus()) {
			System.out.println("\nEmployee Authentication Failed");
			mainMenu();
		}
			
		
	}
	public void mainMenu() {
		System.out.println("------------Employee------------\n[->]1.Employee Login \n[->]2.Back");

		System.out.print("-:>Enter Your Choice:");
		
		int y=sc.nextInt();
		
		if(y==1)
			main();
		else {
			VRPSHome back=new VRPSHome();
			back.main(null);
		}
	}
}