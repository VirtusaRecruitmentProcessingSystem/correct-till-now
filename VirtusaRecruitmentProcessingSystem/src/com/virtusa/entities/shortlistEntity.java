package com.virtusa.entities;

public class shortlistEntity {
	
/*	Name         Null     Type        
	------------ -------- ----------- 
	REFERENCE_ID NOT NULL NUMBER      
	JOBSEEKER_ID          NUMBER      
	JOBPOST_ID            NUMBER      
	ADMIN_STATUS          VARCHAR2(3) 
	TR_STATUS             VARCHAR2(3) 
	HR_STATUS             VARCHAR2(3) 
*/	

	int refID,jobseekerID,jobpostID;
	String astatus,trstatus,hrstatus;
	
	public shortlistEntity(int refID,int jobseekerID,int jobpostID,String astatus,String trstatus,String hrstatus) {
		this.astatus=astatus;
		this.hrstatus=hrstatus;
		this.trstatus=trstatus;
		this.jobpostID=jobpostID;
		this.jobseekerID=jobseekerID;
	}
	
	
	public int getRefID() {
		return refID;
	}
	public void setRefID(int refID) {
		this.refID = refID;
	}
	public int getJobseekerID() {
		return jobseekerID;
	}
	public void setJobseekerID(int jobseekerID) {
		this.jobseekerID = jobseekerID;
	}
	public int getJobpostID() {
		return jobpostID;
	}
	public void setJobpostID(int jobpostID) {
		this.jobpostID = jobpostID;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	public String getTrstatus() {
		return trstatus;
	}
	public void setTrstatus(String trstatus) {
		this.trstatus = trstatus;
	}
	public String getHrstatus() {
		return hrstatus;
	}
	public void setHrstatus(String hrstatus) {
		this.hrstatus = hrstatus;
	}
	
	
	
}
