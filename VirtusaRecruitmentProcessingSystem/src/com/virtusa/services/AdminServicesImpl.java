package com.virtusa.services;


import java.util.Scanner;

import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.JobDAO;

public class AdminServicesImpl implements AdminServices{
	Scanner sx=new Scanner(System.in);
	AdminDAO adminDAO=new AdminDAO();

	public boolean AdminShortlistServices() {
		ApplicationServices admins=new 	ApplicationServices();
		boolean b=admins.AdminShortlistServices();
		return b;
	}

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

		int del=sx.nextInt();
		
		JobDAO delete=new JobDAO();
		delete.dropJobPost(del);
	}




	

}
