package com.virtusa.controller;

import com.virtusa.model.ApplicationModel;
import com.virtusa.model.JobseekerModel;
import com.virtusa.services.JobServiceImpl;
import com.virtusa.services.JobseekerServicesImpl;

public class JobseekerController {

	int jobs_id;
public int registerJobSeeker(JobseekerModel model) {
	
	JobseekerServicesImpl register=new JobseekerServicesImpl();
 	jobs_id=register.JobseekerRegistration(model);
 	return jobs_id;
}


public void loginJobseeker(JobseekerModel model) {
	
	
	
}
public void jobApplication(ApplicationModel applicationModel) {
	JobServiceImpl jobobj=new JobServiceImpl(); 
	


}

public void viewStatus(int refId) {
	JobseekerServicesImpl statusServiceobj=new JobseekerServicesImpl();
	statusServiceobj.viewStatus(refId);
}

}
