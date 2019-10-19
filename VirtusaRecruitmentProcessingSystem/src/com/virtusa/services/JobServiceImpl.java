package com.virtusa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtusa.dao.JobDAO;
import com.virtusa.entities.JobEntity;


/*
 * JOB_ID                NOT NULL NUMBER(10)   
DESIGNATION           NOT NULL VARCHAR2(40) 
REQUIRED_EXPERIENCE            NUMBER(2)    
REQUIRED_SKILLS                VARCHAR2(40) 
ELIGIBILITYPERCENTAGE          NUMBER(2,2) 
 */

public class JobServiceImpl implements jobServices {

	
	@Override
	public void viewjobPosts() {
		// TODO Auto-generated method stub

		JobDAO viewjobs=new JobDAO();
		viewjobs.viewallJobs();
		
		
	}

	@Override
	public void addJobPost() {
		
		
		// TODO Auto-generated method stub
		
		 int jobId;
		 String designation;
		 int experience;
		 double eligibilityPercentage;
		 List<String> skills;

			Scanner input=new Scanner(System.in);
			
			System.out.println("-------------------");
			System.out.println("  Adding Job Post  ");
			System.out.println("-------------------\n");
			System.out.println(" Enter Job ID:");
			jobId=input.nextInt();
			System.out.println(" Enter Job Role:");
			designation=input.nextLine();
			
			System.out.println("\n1.Java\n2.SQL\n3.Data Science\n4.Testing\n5.Exit");
			
			skills=new ArrayList<String>();
			
			int choice;
			
			
			do {
			System.out.println(" Enter Required Skills:");
			choice=input.nextInt();
			
			switch(choice) {
			case 1:skills.add("java");
					break;
			case 2:skills.add("sql");
					break;
			case 3:skills.add("data science");
					break;
			case 4:skills.add("testing");
					break;
			case 5: break;
			default:System.out.println("---*--- Enter Valid Skill Selection ---*---");
			//default:skills.add("c");
				}
			
			}while(choice!=5);

			
			System.out.println(" Enter Eligibility percentage:");
			eligibilityPercentage=input.nextDouble();
			System.out.println(" Enter years of experience:");
			experience=input.nextInt();
			
			

			JobEntity newjob=new JobEntity(jobId,designation,experience,eligibilityPercentage,skills);
			JobDAO addingJobPost=new JobDAO();
			addingJobPost.addJobPost(newjob);
	}

}
 
