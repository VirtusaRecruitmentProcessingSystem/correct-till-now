package com.virtusa.services;

import com.virtusa.dao.JobseekerDAO;
import com.virtusa.model.JobseekerModel;

public class JobseekerServicesImpl implements JobseekerServices{
int jobs_id;
	@Override
	public int JobseekerRegistration(JobseekerModel model) {
		// TODO Auto-generated method stub
		JobseekerDAO jdao=new JobseekerDAO();
		jobs_id=jdao.addJobSeeker(model);
		return jobs_id;
		//System.out.println("Added Succesfully");
	}


	@Override
	public void viewStatus(int refId) {
		JobseekerDAO jdao=new JobseekerDAO();
		jdao.showStatus(refId);
	}
	
}
