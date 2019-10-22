package com.virtusa.view;
//import java.util.List;
import java.util.Scanner;
import com.virtusa.controller.TRController;
import com.virtusa.dao.TrDAOImp;
//import com.virtusa.model.JobseekerModel;
//import com.virtusa.model.LoginModel;
import com.vrps.authentication.UserAuthentication;

public class TRView 
{		
	Scanner scan=new Scanner(System.in);
	
	public void mainMenu()
	{
		
		TrDAOImp trdao=new TrDAOImp();
		TRController trc=new TRController();
			
			System.out.println("1.View ShortListed Candidates");
			System.out.println("2.Shortlist Candidates ");
			System.out.println("3.Give Rating and Comment");
			System.out.println("4.LogOut");
			
			int choice=0;
			do {
				System.out.println("\nEnter your choice:");
				choice=scan.nextInt();
				switch(choice) {
				case 1:trc.getAllJobSeekers();
				break;
				case 2:trc.TrShortlist();
					break;
				case 3:trc.rate_comment();
						break;
				case 4:EmployeeView eview=new EmployeeView();
				eview.mainMenu();
				break;
				
				}
				
			}
			while(choice!=4);
		}


}





