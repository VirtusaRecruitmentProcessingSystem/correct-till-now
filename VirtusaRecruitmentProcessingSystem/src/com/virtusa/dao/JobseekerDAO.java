package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.JobseekerModel;


/*
 * 
 * Name         Null     Type        
------------ -------- ----------- 
REFERENCE_ID NOT NULL NUMBER      
JOBSEEKER_ID          NUMBER      
JOB_POST_ID           NUMBER      
ADMIN_STATUS          VARCHAR2(3) 
TR_STATUS             VARCHAR2(3) 
HR_STATUS             VARCHAR2(3) 
 * 
 */
public class JobseekerDAO {

public void showStatus(int refId) {
	

	try(Connection conn=ConnectionManager.openConnection();	)
	{
		
		String query="select * from applications where REFERENCE_ID=?";
		PreparedStatement statement=conn.prepareStatement(query);
		statement.setInt(1, refId);
		ResultSet rs=statement.executeQuery();
		System.out.println("|REFERENCE_ID|ADMIN_STATUS|TR_STATUS|HR_STATUS|");
		while(rs.next()) {
			System.out.println(rs.getInt(refId)+"\t"+rs.getString("ADMIN_STATUS")+"\t"+rs.getString("TR_STATUS")+"\t"+rs.getString("HR_STATUS"));
		}
		
		
	}
	catch(Exception e) { //e.printStackTrace();
		
		
		System.out.println("Error Retreiving Application with Reference ID-"+refId);
		
	}
	
}

public int addJobSeeker(JobseekerModel model) {
	 String fname=model.getFname();
	 String mname=model.getMname();
	 String lname=model.getLname();
	 Date datex=model.getDatex();
	 int passYear=model.getPassYear();
	 int experience=model.getExperience();
	 String address=model.getAddress();
	 String qualification=model.getQualification();
	 String email=model.getEmail();
	 String phone=model.getPhone();
	 float percentage=model.getPercentage();
	 String user_name1=model.getUname();
	 String pass_word1=model.getPassword();
	 int jobs_id=0;
	 List<String> skills=model.getSkills();
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	 String strDate = formatter.format(datex);  

		/*
		 * jobseeker(x

Name            Null     Type         
--------------- -------- ------------ 
FIRST_NAME      NOT NULL VARCHAR2(40) 
MIDDLE_NAME     NOT NULL VARCHAR2(40) 
LAST_NAME       NOT NULL VARCHAR2(40) 
DATE_OF_BIRTH   NOT NULL DATE         
PHONE_NUMBER             VARCHAR2(40) 
ADDRESS                  VARCHAR2(40) 
QUALIFICATION   NOT NULL VARCHAR2(40) 
EMAIL_ID        NOT NULL VARCHAR2(40) 
YEAR_OF_PASSING NOT NULL NUMBER(4)    
JOBSEEKER_ID    NOT NULL NUMBER       
PERCENTAGE               NUMBER(4,2)  
EXPERIENCE               NUMBER 
		 
		 */
	// boolean i=true;
	 
	 ResultSet rs;
	 int id=0;
	 //Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","vrps","vrps");
		try(Connection conn=ConnectionManager.openConnection();)
		{
			
			String query1="INSERT INTO JOBSEEKER(FIRST_NAME,MIDDLE_NAME,LAST_NAME,DATE_OF_BIRTH,PHONE_NUMBER,ADDRESS,QUALIFICATION,EMAIL_ID,YEAR_OF_PASSING,PERCENTAGE,EXPERIENCE) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stp=conn.prepareStatement(query1);
			stp.setString(1, fname);
			stp.setString(2,mname );
			stp.setString(3, lname );
			stp.setString(4,strDate);
			stp.setString(5, phone);
			stp.setString(6, address);
			stp.setString(7, qualification);
			stp.setString(8, email);
			stp.setInt(9,passYear);
			stp.setFloat(10,percentage );
			stp.setInt(11, experience);


			
			int i=stp.executeUpdate();
			int counter=0;
			
			/////////////////////////
			
			/*
			 * replace output descriptors with log4j after successful execution of code between "/////"
			 * 
			 * 
			 */
			int jobseekerID=0;
			
			String jobseekerIds="select max(JOBSEEKER_ID) AS JOBSEEKER_ID  from jobseeker";//
			PreparedStatement ps=conn.prepareStatement(jobseekerIds);

			ResultSet rs1=ps.executeQuery();
			
			while(rs1.next())
			jobseekerID=rs1.getInt("JOBSEEKER_ID");
			
			
			//skills.forEach((o)->{
				for(int z=0;z<skills.size();z++) {
					
				try {
					String query2="insert into jobseeker_skills values(?,?)";
					PreparedStatement state=conn.prepareStatement(query2);
					state.setInt(1,jobseekerID);	
				state.setString(2,skills.get(z));
				
				int inside=state.executeUpdate();
					if (inside>0) {
							System.out.println("Skills Added succesfully");

								}
					else
							System.out.println("Skills not going yaaaaa");
				
				}
				catch(SQLException s) {
					System.out.println("Error at adding Skills");
					s.printStackTrace();
				}
				}
		//	});

			
			////////////////////////////
		        if (i>0) {
		            System.out.println(" Jobseeker profile created succesfully");
		            String q="select max(JOBSEEKER_ID) AS JOBSEEKER_ID  from jobseeker";
		            PreparedStatement fk=conn.prepareStatement(q);
		            rs=fk.executeQuery();
		            
		            while(rs.next())
		            jobs_id=rs.getInt("JOBSEEKER_ID");
		            
		            System.out.println("JobSeeker ID:"+jobs_id);
		            
		            String fasak="insert into credentials values (?,?,?)";
		            
		            PreparedStatement fstp=conn.prepareStatement(fasak);
		            fstp.setString(1, user_name1);
		            fstp.setString(2, pass_word1);
		            fstp.setInt(3, jobs_id);
		            
		            
		            int bugga=fstp.executeUpdate();
		            
		            if(bugga>0)
		            {
		            	System.out.println("Credentials created successfully:");
		            }
		            else
		            {
		            	System.out.println("Credentials creation Failed");
		            }
		            
		        } else {
		            System.out.println("stuck somewhere");
		            
		        }
	 
		}catch(Exception s) {
			System.out.println(":-:-:-:-:-:-Error at backend Workstation:\n");
			s.printStackTrace();
		}
		return jobs_id;
}
}