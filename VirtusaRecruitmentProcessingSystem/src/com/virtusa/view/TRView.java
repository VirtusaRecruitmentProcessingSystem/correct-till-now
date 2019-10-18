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
	public void mainMenu()
	{
		
		TrDAOImp trdao=new TrDAOImp();

			System.out.println("1.Shortlist Candidates ");
			System.out.println("2.Give Rating and Comment");
			System.out.println("3.LogOut");
			Scanner scan=new Scanner(System.in);
			int choice=scan.nextInt();
			do {
				System.out.println("\nEnter your choice:");
				
				switch(choice) {
				case 1:trdao.TrShortlist();
					break;
				case 2:trdao.rate_comment();
						break;
				case 3:EmployeeView eview=new EmployeeView();
				eview.mainMenu();
				break;
				
				}
				
			}
			while(choice!=3);
		}


}





