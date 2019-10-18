package com.virtusa.model;

public class ASLModel {
	private int jobseekerId;
	private  int jobpostId ;
	private String adminStatus;
	private String trStatus;
	private String hrStatus;
	
	public ASLModel(int jobseekerId,String adminStatus,String trStatus, String hrStatus) {
		this.adminStatus=adminStatus;
		this.jobseekerId = jobseekerId;
		this.trStatus = trStatus;
		this.hrStatus = hrStatus;
		
		
	}
	
	public ASLModel(int jobpostId,int jobseekerId,String adminStatus,String trStatus, String hrStatus) {
		this.adminStatus=adminStatus;
		this.jobseekerId = jobseekerId;
		this.trStatus = trStatus;
		this.hrStatus = hrStatus;
		this.jobpostId = jobpostId;
		
	}
	
	public int getJobseekerId() {
		return jobseekerId;
	}
	public void setJobseekerId(int jobseekerId) {
		this.jobseekerId = jobseekerId;
	}
	public int getJobpostId() {
		return jobpostId;
	}
	public void setJobpostId(int jobpostId) {
		this.jobpostId = jobpostId;
	}
	public String getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getTrStatus() {
		return trStatus;
	}
	public void setTrStatus(String trStatus) {
		this.trStatus = trStatus;
	}
	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}
	

	
}
