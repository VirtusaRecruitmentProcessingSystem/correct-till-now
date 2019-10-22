
package com.virtusa.view;


import java.util.List;
import java.util.Scanner;

import com.virtusa.controller.AdminController;
import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;
import com.virtusa.ui.VRPSHome;
import com.virtusa.validation.JobseekerValidation;
import com.vrps.authentication.UserAuthentication;


public class AdminView {

	Scanner scannerr=new Scanner(System.in);
	
	JobseekerValidation jv=new JobseekerValidation();
	public void mainMenu() {
		int y=0;
		boolean bill=false;
		String stre;
		
		do {
			System.out.println("------------  Admin  ------------\n[->]1.Admin Login \n[->]2.Back");
			System.out.print("Enter Choice:");
			stre=scannerr.next();
			bill=jv.validNumber(stre);
			if(!bill)
			y=Integer.parseInt(stre);	
		
		}while(bill);
		
		if(y==1)
			method();
		else {
			VRPSHome back=new VRPSHome();
			back.main(null);
		}
	}
	
	public void method() {

		System.out.println("---------Admin Login---------");
		AdminView admiView=new AdminView();

		System.out.print("Enter UserName:");
		String username=scannerr.next();

		System.out.print("Enter Password:");
		String password=scannerr.next();

		LoginModel lm=new LoginModel(username,password);
		//Authentication replacement and Admin's Main menu formatting 	
		/* from here*/	    
		UserAuthentication AdminAuth=new UserAuthentication();


		SessionForwading sf=AdminAuth.Verification(lm,3);
		if(sf.isStatus())
		main(sf);
		else
			mainMenu();
		
	
			
	}
	
	public void main(SessionForwading sf) 
	{

		AdminController adcontroller=new AdminController();
		String ss;
		boolean bill;
		

		if(sf.isStatus()) {
			/*
			System.out.println("\n1.Add Job Post");
			System.out.println("2.delete job post");
			System.out.println("3.Give Rating and Comment");
			System.out.println("4.Shortlist Candidate Applications");
			System.out.println("5.LogOut");
			*/
			int choice=0;
			do {
				//do {
				System.out.println("\n1.Add Job Post");
				System.out.println("2.delete job post");
				System.out.println("3.Give Rating and Comment");
				System.out.println("4.Shortlist Candidate Applications");
				System.out.println("5.LogOut");
				System.out.print("\nEnter your choice:");
				
				/*ss=scannerr.next();
					bill=jv.validNumber(ss);
					if(!bill)
						choice=Integer.parseInt(ss);
					
					}while(bill);
				*/
				 
				choice=scannerr.nextInt();
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
				default:System.out.print("Enter Valid Option\n");
				}
				
			}
			while(choice!=5);
		}
		
}
	
}