package com.virtusa.entities;

import java.time.LocalDate;
import java.util.List;

/*
 * FIRST_NAME       VARCHAR2(40) NOT NULL, 
MIDDLE_NAME      VARCHAR2(40) NOT NULL,
LAST_NAME        VARCHAR2(40) NOT NULL, 
DATE_OF_BIRTH    DATE NOT NULL ,         
PHONE_NUMBER             VARCHAR2(40), 
QUALIFICATION    VARCHAR2(40) NOT NULL,
EMAIL_ID         VARCHAR(40) NOT NULL,
YEAR_OF_PASSING  NUMBER(4) NOT NULL,
SKILLS VARCHAR2(40),
JS_ID VARCHAR2(40), 
 */


public class JobseekerEntity {

	private String first_name;
	private String middle_name;
	private String last_name;
	private LocalDate date_of_birth;
	private String emailid;
	private String phoneNumber;
	private String qualification;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String i) {
		this.first_name = i;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	
}
