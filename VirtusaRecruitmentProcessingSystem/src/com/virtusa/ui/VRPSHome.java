package com.virtusa.ui;
import java.util.Scanner;

import com.virtusa.validation.JobseekerValidation;
import com.virtusa.view.AdminView;
import com.virtusa.view.EmployeeView;
import com.virtusa.view.JobseekerView;

public class VRPSHome
{
	static Scanner swwe=new Scanner(System.in);
public static void main(String args[])
	{
	System.out.println("<-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><->");
	System.out.println("|---------- VIRTUSA RECRUITMENT PROCESSING SYSTEM ----------|");
	System.out.println("<-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><->");
	
	int  i=0;String ss;
	boolean bill=false;
	JobseekerValidation jv=new JobseekerValidation();

	
	
	do {
		System.out.println("\n[->]1.JobSeeker\n[->]2.Employee\n[->]3.Admin\n[->]4.Exit");
		System.out.print("-:>Enter Your Choice:");
		ss=swwe.next();
		bill=jv.validNumber(ss);
		if(!bill)
			i=Integer.parseInt(ss);
		
		}while(bill);
	
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
	else if(i==4)
	{
		System.exit(1);
	}

	}

}

