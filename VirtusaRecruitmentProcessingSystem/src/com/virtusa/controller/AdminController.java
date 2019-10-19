package com.virtusa.controller;

import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;
import com.virtusa.services.AdminServices;
import com.virtusa.services.AdminServicesImpl;
import com.virtusa.services.ApplicationServices;
import com.virtusa.view.AdminView;
import com.vrps.authentication.UserAuthentication;

public class AdminController {

	//boolean boot=false;
	AdminView av=new AdminView();
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

boolean b=adminservice.AdminShortlistServices();
SessionForwading sfx=new SessionForwading(0,true);
	if(b || !b)
	av.main(sfx);

	
}

//public void addResource() {
	// TODO Auto-generated method stub
	//adminservice.addResource();
//}




}
