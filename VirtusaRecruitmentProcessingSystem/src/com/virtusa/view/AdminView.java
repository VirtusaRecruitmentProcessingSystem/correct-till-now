
package com.virtusa.view;


import java.util.List;
import java.util.Scanner;

import com.virtusa.controller.AdminController;
import com.virtusa.model.SessionForwading;
import com.virtusa.ui.VRPSHome;
import com.vrps.authentication.UserAuthentication;


public class AdminView {

	
	public void mainMenu() {
		System.out.println("------------  Admin  ------------\n1.Admin Login \n2.Back");
		Scanner sc=new Scanner(System.in);
		int y=sc.nextInt();
		
		if(y==1)
			main();
		else {
			VRPSHome back=new VRPSHome();
			back.main(null);
		}
	}
	
	
	public void main() 
	{

		AdminController adcontroller=new AdminController();

		Scanner scanner=new Scanner(System.in);
		System.out.println("---------Admin Login---------");
		AdminView admiView=new AdminView();



		System.out.print("Enter UserName:");
		String username=scanner.next();

		System.out.print("Enter Password:");
		String password=scanner.next();

		//Authentication replacement and Admin's Main menu formatting 	
		/* from here*/	    
		UserAuthentication AdminAuth=new UserAuthentication();



		SessionForwading sf=AdminAuth.Verification(username,password,3);
		/* to here*/		if(sf.isStatus()) {
			System.out.println("\n1.Add Job Post");
			System.out.println("2.delete job post");
			System.out.println("3.Give Rating and Comment");
			System.out.println("4.Shortlist Candidate Applications");
			//System.out.println("5.Add Technical or human resource");
			System.out.println("5.LogOut");
			int choice;
			do {
				System.out.println("\nEnter your choice:");
				choice=scanner.nextInt();

				switch(choice) {
				case 1:adcontroller.addJobPost();
				break;
				case 2:adcontroller.deleteJobPost();
				break;
				case 3:// display all applicants
					adcontroller.rate_comment();
					break;
				case 4:adcontroller.shortlistCandidates();
				break;
				////case 5:adcontroller.addResource();
				//break;
				case 5:mainMenu();
					break;
				}
			}
			while(choice!=5);
		}
	


}}