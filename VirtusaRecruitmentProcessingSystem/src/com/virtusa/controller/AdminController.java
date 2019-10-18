package com.virtusa.controller;

import com.virtusa.model.LoginModel;
import com.virtusa.services.AdminServices;
import com.virtusa.services.AdminServicesImpl;
import com.virtusa.services.ApplicationServices;
import com.vrps.authentication.UserAuthentication;

public class AdminController {

	AdminServicesImpl adminservice=new AdminServicesImpl();
	ApplicationServices adminapp=new ApplicationServices();

	public void addJobPost() {
	adminservice.addJobPost();
}
public void deleteJobPost() {
	adminservice.deleteJobPost();
}

public void rate_comment() {
	adminservice.rate_comment();
}

public void shortlistCandidates() {
//	adminservice.shortlistCandidates();
	adminapp.AdminShortlistServices();
	
}

//public void addResource() {
	// TODO Auto-generated method stub
	//adminservice.addResource();
//}




}
