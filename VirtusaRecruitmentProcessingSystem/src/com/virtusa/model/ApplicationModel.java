package com.virtusa.model;

import java.util.Date;
import java.util.List;

public class ApplicationModel {

	private String fname;
	private String mname;
	private String lname;
	private Date datex;
	private int passYear;
	private int experience;
	private String address;
	private String qualification;
	private String email;
	private String phone;
	private float percentage;
	private int jobpostId,jobseekerID,REFERENCE_ID;
	private List<String> skills;
	
	
	//firstName,mName,lName,datex,phone,qualification,email,passYear,jobId,percentage,experience,address,skills
	
	
	public ApplicationModel(String fname, String mname, String lname, Date datex, String phone,String qualification, String email, int passYear,int jobpostId,
			float percentage, int experience,String address,List<String> skills) {
		// TODO Auto-generated constructor stub
		this.fname=fname;
		this.mname=mname;
		this.address=address;
		this.datex=datex;
		this.email=email;
		this.experience=experience;
		this.lname=lname;
		this.jobpostId=jobpostId;
		this.phone=phone;
		this.qualification=qualification;
		this.skills=skills;
	}
	
	
	public ApplicationModel(int jobseekerID,String fname, String mname, String lname, Date datex, String phone,String qualification, String email,
			int passYear,int jobpostId,
			float percentage, int experience,String address,List<String> skills,int REFERENCE_ID) {
		// TODO Auto-generated constructor stub
		this.jobseekerID=jobseekerID;
		this.fname=fname;
		this.mname=mname;
		this.address=address;
		this.datex=datex;
		this.email=email;
		this.experience=experience;
		this.lname=lname;
		this.jobpostId=jobpostId;
		this.phone=phone;
		this.qualification=qualification;
		this.skills=skills;
		this.REFERENCE_ID=REFERENCE_ID;
		this.percentage=percentage;
		this.passYear=passYear;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public Date getDatex() {
		return datex;
	}


	public void setDatex(Date datex) {
		this.datex = datex;
	}


	public int getPassYear() {
		return passYear;
	}


	public void setPassYear(int passYear) {
		this.passYear = passYear;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public float getPercentage() {
		return percentage;
	}


	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}


	public int getJobpostId() {
		return jobpostId;
	}


	public void setJobpostId(int jobpostId) {
		this.jobpostId = jobpostId;
	}


	public int getJobseekerID() {
		return jobseekerID;
	}


	public void setJobseekerID(int jobseekerID) {
		this.jobseekerID = jobseekerID;
	}


	public int getREFERENCE_ID() {
		return REFERENCE_ID;
	}


	public void setREFERENCE_ID(int rEFERENCE_ID) {
		REFERENCE_ID = rEFERENCE_ID;
	}


	public List<String> getSkills() {
		return skills;
	}


	public void setSkills(List<String> skills) {
		this.skills = skills;
	}




	
	
	
}
