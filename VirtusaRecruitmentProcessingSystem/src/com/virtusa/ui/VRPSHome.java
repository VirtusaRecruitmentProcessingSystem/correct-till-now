package com.virtusa.ui;
import java.util.Scanner;
import com.virtusa.view.AdminView;
import com.virtusa.view.EmployeeView;
import com.virtusa.view.JobseekerView;

public class VRPSHome
{

public static void main(String args[])
	{
	System.out.println("<-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><->");
	System.out.println("|---------- VIRTUSA RECRUITMENT PROCESSING SYSTEM ----------|");
	System.out.println("<-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><->");
	
	int  i;
	Scanner s=new Scanner(System.in);
	System.out.println("\n1.JobSeeker\n2.Employee\n3.Admin");
	System.out.print("-:>Enter Your Choice:");
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

