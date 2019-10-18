package com.virtusa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.ApplicationDAO;
import com.virtusa.dao.TrDAOImp;
import com.virtusa.entities.shortlistEntity;
import com.virtusa.model.ASLModel;
import com.virtusa.model.ApplicationModel;
import com.virtusa.model.SessionForwading;

public class ApplicationServices {
//ApplicationModel application
	
	ApplicationDAO appDAO=new ApplicationDAO();
	
	
	
public boolean AppliedApplicationService(ApplicationModel application, SessionForwading sf) {
	
	boolean x=appDAO.ApplicationStorage(application,sf);
	return x;
	}

//ApplicationModel application

public List<ApplicationModel> getApplications() {
	
	List<ApplicationModel> datax=new ArrayList<>();
	datax=appDAO.retrieveAllApplications();
	
	return datax;
	
}



	public void AdminShortlistServices() {
		// TODO Auto-generated constructor stub
		List<ApplicationModel> dataSL=new ArrayList<>();
		dataSL=appDAO.retrieveAllApplications();
		
				Scanner scan=new Scanner(System.in);
		
		System.out.println("REFERENCE_ID	|	NAME	|	DATE_OF_BIRTH	|	QUALIFICATION	|		SKILLS		|YEAR_OF_PASSING|PERCENTAGE|EXPERIENCE|JOBPOST_ID");
		
		dataSL.forEach((o)->{
			
			String fullname=o.getFname()+o.getMname()+o.getLname();
			 String allSKills="";
			 
			List<String> skillDisplay=new ArrayList<>();
			
			skillDisplay=o.getSkills();
			for(int i=0;i<skillDisplay.size();i++)
				allSKills+=","+skillDisplay.get(i);

			System.out.println(o.getREFERENCE_ID()+"|"+fullname+"|"+o.getDatex()+"|"+o.getQualification()+"|"+allSKills+"|"+o.getPassYear()+"|"+o.getPercentage()+"|"+o.getExperience()+"|"+o.getJobpostId());
			System.out.println("Select this Candidate(Yes/No):");
			String status=scan.next();
			
			shortlistEntity slModel=new shortlistEntity(o.getREFERENCE_ID(),o.getJobseekerID(),o.getJobpostId(),status,null,null);
			
			AdminDAO aDAO=new AdminDAO();
			aDAO.shortlistCandidatesDAO(slModel);
			
		});
		
				
	}
	
}
