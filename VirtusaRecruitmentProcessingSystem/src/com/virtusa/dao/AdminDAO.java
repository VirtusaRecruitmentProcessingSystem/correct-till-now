package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.virtusa.entities.AdminEntity;
import com.virtusa.entities.JobEntity;
import com.virtusa.entities.shortlistEntity;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.view.TRView;


public class AdminDAO {
	
private List<AdminEntity> List=null;
AdminEntity admin=new AdminEntity();
JobDAO jobdao=new JobDAO();


public void rate_comment() {
	// TODO Auto-generated method stub
	String comment;
	int rating;
	boolean result=false;
	Scanner scan =new Scanner(System.in);
	
	try(Connection connection=ConnectionManager.openConnection();){
		//String query1="select REFERENCE_ID,JOBSEEKER_ID from applications";
		
		
		String st="select REFERENCE_ID,JOBSEEKER_ID from application_and_status where ADMIN_STATUS='yes' ";
		PreparedStatement rate=connection.prepareStatement(st);
		ResultSet rps=rate.executeQuery();
		
		if(rps.next()==false) {
			//	System.out.println(" Sorry,there are no Applications shorlisted by Admin\n Contact Admin or Please wait for further Instructions");
				result=false;
			}
		
		else {
			
		
		do {
			
			System.out.println("___________________________");
			System.out.println("|REFERENCE_ID|JOBSEEKER_ID|");
			System.out.println("___________________________");
			
			System.out.println(rps.getInt("REFERENCE_ID")+"\t|"+rps.getInt("JOBSEEKER_ID")+"\n");
			System.out.println("Enter Rating ( out of 5 ) for this candidate:");
			rating=scan.nextInt();
			System.out.println("Enter Comments on this candidate:");
			comment=scan.next();
			
			
			String setter="insert into RATING_COMMENT values(?,?,?,?,?,?,?)";
			PreparedStatement rate1=connection.prepareStatement(setter);
			rate1.setInt(1, rps.getInt("JOBSEEKER_ID"));
			rate1.setInt(2, rating);
			rate1.setString(3, comment);
			rate1.setInt(4,0);
			rate1.setString(5, "Not Selected");
			rate1.setInt(6,0);
			rate1.setString(7, "Not Selected");
			
			int r=rate1.executeUpdate();
			
			if(r>0) {
				System.out.println("Rating and Comment Successfully given by TR");
				
			}
			else {
				System.out.println("Problem at giving Rating and Comment by TR");
				
			}
		}while(rps.next());
		
		TRView backing=new TRView();
		backing.mainMenu();
	
		}
	}catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("Error at TR's Rating and Commenting Service");
}


}

	
	public void addJobPostDAO(JobEntity jentity) {
		jobdao.addJobPost(jentity);
	}
	
	public void deleteJobPost(int jobPost_id) {
		jobdao.dropJobPost(jobPost_id);
	}
	
	public boolean shortlistCandidatesDAO(shortlistEntity se) {
		// TODO Auto-generated method stub
		
		/*
		 * REFERENCE_ID NOT NULL NUMBER      
JOBSEEKER_ID          NUMBER      
JOBPOST_ID            NUMBER      
ADMIN_STATUS          VARCHAR2(3) 
TR_STATUS             VARCHAR2(3) 
HR_STATUS             VARCHAR2(3)
		 */
		
		boolean res=false;
		
		
		try(      Connection conn=ConnectionManager.openConnection();   )
		{
			String query="insert into application_and_status values(?,?,?,?,?,?)";
			PreparedStatement sp=conn.prepareStatement(query);
			sp.setInt(1, se.getRefID());
			sp.setInt(2,se.getJobseekerID());
			sp.setInt(3,se.getJobpostID());
			sp.setString(4,se.getAstatus());
			sp.setString(5,se.getTrstatus());
			sp.setString(6,se.getHrstatus());
			
			int ex=sp.executeUpdate();
			
			if(ex>0) {
				System.out.println("Admin Status Updated Successfully");
				res=true;
			}
			else {
				System.out.println("Admin Status couldn't be Updated");
				res=false;
			}
			
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return res;
		
}
}
