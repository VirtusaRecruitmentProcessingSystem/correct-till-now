package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*Name                  Null     Type         
--------------------- -------- ------------ 
JOB_ID                NOT NULL NUMBER(10)   
DESIGNATION           NOT NULL VARCHAR2(40) 
REQUIRED_EXPERIENCE            NUMBER(2)    
REQUIRED_SKILLS                VARCHAR2(40) 
ELIGIBILITYPERCENTAGE          NUMBER(2,2)  
*/


import com.virtusa.entities.JobEntity;
import com.virtusa.integrate.ConnectionManager;

/*
 * 	/*Name                  Null     Type         
	--------------------- -------- ------------ 
	JOB_ID                NOT NULL NUMBER(10)   
	DESIGNATION           NOT NULL VARCHAR2(40) 
	REQUIRED_EXPERIENCE            NUMBER(2)    
	REQUIRED_SKILLS                VARCHAR2(40) 
	ELIGIBILITYPERCENTAGE          NUMBER(2,2)  
	*/



public class JobDAO {

	String skillSet="";
	public void addJobPost(JobEntity jentity)
	{
		
		 int jobId=jentity.getJobId();
		 String designation=jentity.getDesignation();
		 int experience=jentity.getExperience();
		 double eligibiltyPer=jentity.geteligibilityPercentage();
		List<String> skills=jentity.getSkills();
		
		skills.forEach((o)->{
			skillSet+=o+" ";
		});

		
		
		try(Connection conn=ConnectionManager.openConnection();)
		{
			//(jobpost_id,designation,required_experience,REQUIRED_SKILLS,ELIGIBILITYPERCENTAGE )
		/*	jobpost_id	int(6)	NO	PRI	
			designation	varchar(40)	NO		
			required_experience	decimal(2,0)	YES		*/
			
			
			PreparedStatement st=conn.prepareStatement("insert into job_description values(?,?,?,?,?)");
			st.setInt(1, jobId);
			st.setString(2, designation);
			st.setInt(3,experience);
			st.setDouble(4, eligibiltyPer);
			st.setString(5, skillSet);
			
			int x=st.executeUpdate();
			if(x>0)
				System.out.println("--JobPOst added Succesfully");
			else
				System.out.println("--JobPOst was not added");
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
  }

	public void viewallJobs() {
		
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		}
		catch(Exception e) {}
		
		
		try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");)
		{
			PreparedStatement st=conn.prepareStatement("select * from job_description");
			ResultSet rs=st.executeQuery();
			System.out.println("=========================================");
			while(rs.next()) {
				int jobId=rs.getInt("JOB_ID");
				String designation=rs.getString("DESIGNATION");
				int experience=rs.getInt("REQUIRED_EXPERIENCE");
				double eligibiltyPer=rs.getDouble("ELIGIBILITYPERCENTAGE");
				String skills=rs.getString("REQUIRED_SKILLS");
				
				System.out.println("JobId :"+jobId+"\nDesignation: "+designation+"\neligibilty percentage: "+eligibiltyPer+"\nExperience: "+experience+"\nSkills: "+skills);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void dropJobPost(int jobId) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		}
		catch(Exception e) {}
		
		
		try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");)
		{
			PreparedStatement st=conn.prepareStatement("delete from job_description where JOB_ID=?");
			st.setInt(1, jobId);
			int rows=st.executeUpdate();
			if(rows>0) 
				System.out.println("deleted successfully");
			else
				System.out.println("deletion  UNsuccessful");
	}
		catch(SQLException e) {
		System.out.println("********************* Internal Crash*******");
		}
		
	
}
	
}