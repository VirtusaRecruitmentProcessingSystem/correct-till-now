package com.virtusa.view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.virtusa.controller.ApplicationController;
import com.virtusa.controller.JobseekerController;

import com.virtusa.model.ApplicationModel;
import com.virtusa.model.JobseekerModel;
import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;
import com.virtusa.ui.VRPSHome;

import com.virtusa.validation.JobseekerValidation;
import com.vrps.authentication.AuthenticationView;


/*
 * Name            Null     Type         
--------------- -------- ------------ 
FIRST_NAME      NOT NULL VARCHAR2(40) 
MIDDLE_NAME     NOT NULL VARCHAR2(40) 
LAST_NAME       NOT NULL VARCHAR2(40) 
DATE_OF_BIRTH   NOT NULL DATE         
PHONE_NUMBER             VARCHAR2(40) 
QUALIFICATION   NOT NULL VARCHAR2(40) 
EMAIL_ID        NOT NULL VARCHAR2(40) 
YEAR_OF_PASSING NOT NULL NUMBER(4)    
JOB_ID          NOT NULL NUMBER       
GRADPERCENTAGE  NOT NULL NUMBER(4,2)  
EXPERIENCE               NUMBER(2)
 */


public class JobseekerView {
//
	static boolean flag=false;
Scanner scanner=new Scanner(System.in);
	int jobs_id;
	String stre;
	boolean bill=false;
	JobseekerValidation jv=new JobseekerValidation();
	int option;
	VRPSHome back=new VRPSHome();
	
	public void mainMenu() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		do{
			System.out.println("\n[->]1.JobSeeker Registration\n[->]2.JobSeeker Login\n[->]3.Back");
			System.out.print("-:>Enter Your Choice:");
		
		String stre=s.next();
		bill=jv.validNumber(stre);
		if(!bill)
			option=Integer.parseInt(stre);
		}
		while(bill);
		
		JobseekerView js_view=new JobseekerView();
		if(option==1) {
			js_view.registerJobSeeker();
		}
		else if(option==2)
		{
			js_view.loginJobSeeker();
		}
		else if(option==3)
			back.main(null);
	}
	
	public void registerJobSeeker() {
		JobseekerValidation validator=new JobseekerValidation(); 		
		
		//////////////////////
		String firstName;
		boolean validfirstName=false;
		do {
		System.out.print("First Name:");
		firstName=scanner.next();
		validfirstName=validator.validString(firstName);
		
		if(validfirstName==false)
		System.out.print("-------------Enter name in Alphabets only-------------\n");
		}
		while(!validfirstName);
		
		////////////////////////////
		String middleName;
		boolean validmiddleName=false;
		do {
		System.out.print("Middle Name:");
		middleName=scanner.next();
		validmiddleName=validator.validString(middleName);
		
		if(validmiddleName==false)
		System.out.print("-------------Enter name in Alphabets only-------------\n");
		}
		while(!validmiddleName);
		////////////////////////////
		
		
		String lastName;
		boolean validlastName=false;
		do {
		System.out.print("Last Name:");
		lastName=scanner.next();
		validlastName=validator.validString(lastName);
		
		if(validlastName==false)
		System.out.print("-------------Enter name in Alphabets only-------------\n");
		}
		while(!validlastName);
		
		
		////////////////////////////

		Date datex=null;		
		do {
		System.out.println("\nEnter DOB(yyyy-mm-dd):");
		String date=scanner.next();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");

		try {
			datex=dateFormat.parse(date);
			flag=false;
			}
		catch(ParseException e) {
			System.out.println("Enter valid Data in Specified Format");
		}
		}
		while(flag);
		////////
		int passYear=0;
		String passYearString="";
		boolean validyearofPass=false;
		do {
			try {
		System.out.println("Enter year of passing:");
		passYearString=scanner.next();
		validyearofPass=validator.validNumber(passYearString);
		passYear=Integer.parseInt(passYearString);
		}
			catch(Exception w) {			}
		}while(validyearofPass);
		//////
		String xp="";
		int experience=0;
		flag=false;
		do {
			try {
				
		System.out.println("Enter Years of Experience:");
		xp=scanner.next();
		flag=validator.validNumber(xp);
		experience=Integer.parseInt(xp);
			}
			catch(Exception exx) {
				
			}
		}while(flag);

		//
		System.out.println("Enter Address:");
		String address=scanner.next();
		
		System.out.println("Enter qualification:");
		String qualification=scanner.next();

		System.out.println("Enter Skills:");
		List<String> skills=new ArrayList<String>();
		
		String choice;
		int ichoice=0;
		boolean stat=false;
		System.out.println("\n1.Java\n2.SQL\n3.Data Science\n4.Testing\n5.Exit");
		do {
			
			do {
		choice=scanner.next();
			try {
				ichoice=Integer.parseInt(choice);
				//stat=false;
				}
			catch(Exception e) {
				stat=true;
				System.out.println("Invalid Option!!! \nSelect Valid SKill\nEnter Skills:");
				}
			   }while(stat);

		
		switch(ichoice) {
		case 1:skills.add("java");
				break;
		case 2:skills.add("sql");
				break;
		case 3:skills.add("data science");
				break;
		case 4:skills.add("testing");
				break;
		case 5: break;
			}
		
		}while(ichoice!=5);
		
		///////
		String email;
		
		do {
			
		System.out.println("Enter email:");
		email=scanner.next();
		flag=validator.validEmail(email);
		}
		while(!flag);
		///////////////
		
		System.out.println("Enter Phone Number:");
		String phone;
		phone=scanner.next();
		
		
		System.out.println("Enter graduation percentage:");
		String percString=scanner.next();
		float percentagef=Float.parseFloat(percString);
		//float percentage=scanner.nextFloat();
		
		System.out.println("Enter username:");
		String uname=scanner.next();
		
		System.out.println("Enter password:");
		String password=scanner.next();
		
		/*
		 * Jobseeker Table Schema
		 * 
		 * Name            Null     Type         
		--------------- -------- ------------ 
		FIRST_NAME      NOT NULL VARCHAR2(40) 
		MIDDLE_NAME     NOT NULL VARCHAR2(40) 
		LAST_NAME       NOT NULL VARCHAR2(40) 
		DATE_OF_BIRTH   NOT NULL DATE         
		PHONE_NUMBER             VARCHAR2(40) s
		QUALIFICATION   NOT NULL VARCHAR2(40) 
		EMAIL_ID        NOT NULL VARCHAR2(40) 
		YEAR_OF_PASSING NOT NULL NUMBER(4)    
		JOB_ID          NOT NULL NUMBER       
		GRADPERCENTAGE  NOT NULL NUMBER(4,2)  
		EXPERIENCE               NUMBER(2)
		 */

		JobseekerModel jmodel=new JobseekerModel(firstName,middleName,lastName,datex,passYear,experience,address,qualification,email,phone,percentagef,uname,password,skills);
		
		JobseekerController newjs=new JobseekerController();
		jobs_id=newjs.registerJobSeeker(jmodel);
		
		mainMenu();
		//loginJobSeeker();
		}
	
	public void loginJobSeeker() {

		
		AuthenticationView authView=new AuthenticationView();
		SessionForwading sf=authView.main(1);
		if(sf.isStatus())
			MenuAfterLogin(sf);
		else {
			System.out.println("\n Invalid UserName or Password \n Enter Valid Credentials:");
			loginJobSeeker();
		}
	}

	public void MenuAfterLogin(SessionForwading sf) {
		Scanner s=new Scanner(System.in);
		System.out.println("\n1.Apply for Job\n2.View Job Application Status\n3.log out");
		int choice=s.nextInt();
		switch(choice) {
		case 1:applyJob(sf);
				break;
		case 2:viewStatus();
				break;	
		case 3:VRPSHome homeObj=new VRPSHome();
				homeObj.main(null);
				break;
			
		default:System.out.println("----------Invalid Choice-------\n ----"
				+ ">>>> Enter a Valid Choice:------");
		}
		
	}
	
	public void applyJob(SessionForwading sf) {
		
		JobseekerValidation validator=new JobseekerValidation(); 
		
//////////////////////
String firstName;
boolean validfirstName=false;
do {
System.out.print("First Name:");
firstName=scanner.next();
validfirstName=validator.validString(firstName);

if(validfirstName==false)
System.out.print("-------------Enter name in Alphabets only-------------\n");
}
while(!validfirstName);

////////////////////////////
String middleName;
boolean validmiddleName=false;
do {
System.out.print("Middle Name:");
middleName=scanner.next();
validmiddleName=validator.validString(firstName);

if(validmiddleName==false)
System.out.print("-------------Enter name in Alphabets only-------------\n");
}
while(!validmiddleName);
////////////////////////////


String lastName;
boolean validlastName=false;
do {
System.out.print("Last Name:");
lastName=scanner.next();
validlastName=validator.validString(firstName);

if(validlastName==false)
System.out.print("-------------Enter name in Alphabets only-------------\n");
}
while(!validlastName);


////////////////////////////
Date datex=null;		
do {
System.out.println("\nEnter DOB(yyyy-mm-dd):");
String date=scanner.next();

SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");

try {
	datex=dateFormat.parse(date);
	flag=false;
	}
catch(ParseException e) {
	System.out.println("Enter valid Data in Specified Format");
	flag=true;
}
}
while(flag);
////////
		///////
int passYear=0;
String passYearString="";
boolean validyearofPass=false;
do {
	try {
System.out.println("Enter year of passing:");
passYearString=scanner.next();
validyearofPass=validator.validNumber(passYearString);
System.out.println(validyearofPass);
passYear=Integer.parseInt(passYearString);
}
	catch(Exception w) {
		//System.out.println("----Enter in Valid Format---");
	}
}while(validyearofPass);

//////

System.out.println("Years of Experience:");
int experience=scanner.nextInt();

System.out.println("Enter Address:");
String address=scanner.next();

System.out.println("Enter qualification:");
String qualification=scanner.next();

System.out.println("Enter Skills:");
List<String> skills=new ArrayList<String>();

String choice;
int ichoice=0;
boolean stat=false;
System.out.println("\n1.Java\n2.SQL\n3.Data Science\n4.Testing\n5.Exit");
do {
	
	do {
choice=scanner.next();
	try {
		ichoice=Integer.parseInt(choice);
		//stat=false;
		}
	catch(Exception e) {
		stat=true;
		System.out.println("Invalid Option!!! \nSelect Valid SKill\nEnter Skills:");
		}
	   }while(stat);


switch(ichoice) {
case 1:skills.add("java");
		break;
case 2:skills.add("sql");
		break;
case 3:skills.add("data science");
		break;
case 4:skills.add("testing");
		break;
case 5: break;
	}

}while(ichoice!=5);

///////
String email;

do {
	
System.out.println("Enter email:");
email=scanner.next();
flag=validator.validEmail(email);
}
while(!flag);
///////////////

System.out.println("Enter Phone Number:");
String phone;
phone=scanner.next();


System.out.println("Enter graduation percentage:");
String percString=scanner.next();
float percentagef=Float.parseFloat(percString);
//float percentage=scanner.nextFloat();
		System.out.println("Enter jobpostId:");
		int jobpostId=scanner.nextInt();
		
		ApplicationModel application=new ApplicationModel
				(firstName,middleName,lastName,datex,phone,qualification,email
						,passYear,jobpostId,percentagef,experience,address,skills);
		
		// passing Application to Admin, then forwaded to TR and then to HR
		// october 5,overriden above comment--------- store in DAO of applications and then view all applications to employee's for shortlisting
		
		//application
		//ApplicationShortlistController AdminObj=new ApplicationShortlistController();
		//AdminObj.AdminSLController();
		
		//ApplicationShortlist adminselection=new ApplicationShortlist();
		//adminselection.AdminShortList(application);
	
		ApplicationController app=new ApplicationController();
		boolean qwerty=app.AppliedApplication(application,sf);
	
	if(qwerty) {
		System.out.println("Applied SuccessFully-----\n");
		MenuAfterLogin(sf);
	}
	else {
		System.out.println("Application Process Failed Successfully\n\n");
		MenuAfterLogin(sf);
	}
	
	}
	
	
	public void viewStatus() {
		
		System.out.println("Enter Reference ID:");
		int refId=scanner.nextInt();
		JobseekerController jcontroller=new JobseekerController();
		jcontroller.viewStatus(refId);
		
		
	}
}
 