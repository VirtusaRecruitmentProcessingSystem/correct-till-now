package com.virtusa.ui;
import java.util.Scanner;
import com.virtusa.view.AdminView;
import com.virtusa.view.EmployeeView;
import com.virtusa.view.JobseekerView;

public class VRPSHome
{

public static void main(String args[])
	{
			
	int  i;
	Scanner s=new Scanner(System.in);
	System.out.println("\n1.JobSeeker\n2.Employee\n3.Admin");
	
	i=s.nextInt();
	
	if(i==1)
	{
		JobseekerView jsview=new JobseekerView();
		
		
		jsview.mainMenu();
	}
	else if(i==2)
	{
		EmployeeView eview=new EmployeeView();
		eview.mainMenu();
	}
	else if(i==3)
	{
		AdminView aview=new AdminView();
		aview.mainMenu();
	}
	s.close();
	}

}

