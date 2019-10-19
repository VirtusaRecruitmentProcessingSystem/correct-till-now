package com.virtusa.model;

public class ASLModel {
	private int reference_id;
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
	
	public ASLModel(int reference_id,int jobseekerId,int jobpostId,String adminStatus,String trStatus, String hrStatus) {
		
		this.reference_id=reference_id;
		this.jobseekerId = jobseekerId;
		this.jobpostId = jobpostId;
		this.adminStatus=adminStatus;
		this.trStatus = trStatus;
		this.hrStatus = hrStatus;
	
	
	}

	public int getReference_id() {
		return reference_id;
	}

	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
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

	public String getHrStatus() {
		return hrStatus;
	}

	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}
	


	
}
