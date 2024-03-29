package com.virtusa.model;

import java.util.Date;
import java.util.List;

public class JobseekerModel {
	
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
	private String uname;
	private String password;
	private List<String> skills;

	
	public JobseekerModel(String fname, String mname, String lname,
			Date datex, int passYear, int experience,
			String address, String qualification, 
			String email, String phone, float percentage, 
			String uname,String password,
			List<String> skills) {
		// TODO Auto-generated constructor stub
		this.fname=fname;
		this.mname=mname;
		this.address=address;
		this.datex=datex;
		this.email=email;
		this.experience=experience;
		this.lname=lname;
		this.password=password;
		this.phone=phone;
		this.qualification=qualification;
		this.uname=uname;
		this.skills=skills;
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


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<String> getSkills() {
		return skills;
	}


	public void setSkills(List<String> skills) {
		this.skills = skills;
	}







}
