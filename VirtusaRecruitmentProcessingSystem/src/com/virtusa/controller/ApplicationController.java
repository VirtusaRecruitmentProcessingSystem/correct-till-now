package com.virtusa.controller;

import com.virtusa.model.ApplicationModel;
import com.virtusa.model.SessionForwading;
import com.virtusa.services.ApplicationServices;

public class ApplicationController {
	//ApplicationModel application
	
	public boolean AppliedApplication(ApplicationModel application, SessionForwading sf) {
		ApplicationServices appservices=new ApplicationServices();
		boolean bx=appservices.AppliedApplicationService(application,sf);
		return bx;
	}
	
	public void AdminSLController() {
		ApplicationServices SLService=new ApplicationServices();
		SLService.AdminShortlistServices();//application
				
	}
	
	
	
	public void TRSLController() {
		ApplicationServices TRSLService=new ApplicationServices();
		TRSLService.AdminShortlistServices();
	}

	
public void HRSLController() {
	ApplicationServices HRSLService=new ApplicationServices();
	HRSLService.AdminShortlistServices();
}



}