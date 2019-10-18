package com.virtusa.model;

public class SessionForwading {
int jobseeeker_id;
boolean status=false;

public SessionForwading(int jobseeeker_id,boolean status) {
	this.jobseeeker_id=jobseeeker_id;
	this.status=status;
}

public int getJobseeeker_id() {
	return jobseeeker_id;
}

public void setJobseeeker_id(int jobseeeker_id) {
	this.jobseeeker_id = jobseeeker_id;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}




}
