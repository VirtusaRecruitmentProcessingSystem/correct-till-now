package com.virtusa.services;


import java.util.Scanner;

import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.JobDAO;

public class AdminServicesImpl implements AdminServices{
	
	AdminDAO adminDAO=new AdminDAO();



	@Override
	public void rate_comment() {
		// TODO Auto-generated method stub
		//display all candidates one by one and give rating

		adminDAO.rate_comment();
	}

	@Override
	public void addJobPost() {
		// TODO Auto-generated method stub
		jobServices js=new JobServiceImpl();
		js.addJobPost();
	}

	@Override
	public void deleteJobPost() {
		// TODO Auto-generated method stub
		jobServices js=new JobServiceImpl();
		
		System.out.println("Enter jobPostID of JobPost to be deleted:");
		Scanner sx=new Scanner(System.in);
		int del=sx.nextInt();
		
		JobDAO delete=new JobDAO();
		delete.dropJobPost(del);
	}




	

}
