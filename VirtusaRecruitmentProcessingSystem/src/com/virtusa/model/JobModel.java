package com.virtusa.model;

import java.util.List;

/*
 * JOB_ID                NOT NULL NUMBER(10)   
DESIGNATION           NOT NULL VARCHAR2(40) 
REQUIRED_EXPERIENCE            NUMBER(2)    
REQUIRED_SKILLS                VARCHAR2(40) 
ELIGIBILITYPERCENTAGE          NUMBER(2,2) 
 */
public class JobModel {

	private int jobId;
	private String designation;
	private int experience;
	private double eligibilityPercentage;
	private List<String> skills;

	
	public JobModel() {}
	
	public JobModel(int jobId,  String designation,int experience, double eligibilityPercentage, List<String> skills) 
	{
		this.jobId = jobId;
		this.designation = designation;
		this.experience=experience;
		this.eligibilityPercentage = eligibilityPercentage;
		this.skills = skills;
	}

	
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String desgination) {
		this.designation = desgination;
	}
	public double geteligibilityPercentage() {
		return eligibilityPercentage;
	}
	public void seteligibilityPercentage(double eligibilityPercentage) {
		this.eligibilityPercentage = eligibilityPercentage;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	

}
