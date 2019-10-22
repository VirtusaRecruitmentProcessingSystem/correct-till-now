package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.ASLModel;
import com.virtusa.model.ApplicationModel;
import com.virtusa.model.SessionForwading;

/*
 * Skeleton at Front End
 * ApplicationModel(String fname, String mname, String lname, Date datex, String phone,String qualification, String email, int passYear,int jobId,
			float percentage, int experience,String address,List<String> skills)
 */

/*
 * Schema at DB perspective
 * 
 * Name            Null     Type         
--------------- -------- ------------ 
REFERENCE_ID    NOT NULL NUMBER       
FIRST_NAME      NOT NULL VARCHAR2(40) 
MIDDLE_NAME     NOT NULL VARCHAR2(40) 
LAST_NAME       NOT NULL VARCHAR2(40) 
DATE_OF_BIRTH   NOT NULL DATE         
PHONE_NUMBER             VARCHAR2(40) 
ADDRESS                  VARCHAR2(40) 
QUALIFICATION   NOT NULL VARCHAR2(40) 
EMAIL_ID        NOT NULL VARCHAR2(40) 
YEAR_OF_PASSING NOT NULL NUMBER(4)    
PERCENTAGE               NUMBER(4,2)  
JOBSEEKER_ID             NUMBER       
EXPERIENCE               NUMBER 
 * 
 */

public class ApplicationDAO {

	public boolean ApplicationStorage(ApplicationModel application, SessionForwading sf) {

		boolean boo=false;
		
		String Fname=application.getFname();
		String Mname=application.getMname();
		String Lname=application.getLname();
		Date datex=application.getDatex();
		String Phone=application.getPhone();
		String qualification=application.getQualification();
		String email=application.getEmail();
		int passYear=application.getPassYear();
		int jobpostId=application.getJobpostId();
		float percentage=application.getPercentage();
		int experience=application.getExperience();
		String address=application.getAddress();
		List<String> skills=application.getSkills();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		 String strDate = formatter.format(datex);
		 int	JOBSEEKER_ID=sf.getJobseeeker_id();
         int REFERENCE_ID=0;
		/*
		 * 
		 * REFERENCE_ID    int(6) AUTO_INCREMENT PRIMARY KEY ,
FIRST_NAME       VARCHAR(40) NOT NULL,
MIDDLE_NAME      VARCHAR(40) NOT NULL,
LAST_NAME        VARCHAR(40) NOT NULL,
DATE_OF_BIRTH    DATE NOT NULL ,        
PHONE_NUMBER     VARCHAR(40),
ADDRESS VARCHAR(40),
QUALIFICATION    VARCHAR(40) NOT NULL,
EMAIL_ID         VARCHAR(40) NOT NULL,
YEAR_OF_PASSING  NUMERIC(4) NOT NULL,
PERCENTAGE NUMERIC,
JOBSEEKER_ID int(6),
JOBPOST_ID int(10),
EXPERIENCE NUMERIC
		 */
		 /*
		  * REFERENCE_ID	int(6)
FIRST_NAME	varchar(40)
MIDDLE_NAME	varchar(40)
LAST_NAME	varchar(40)
DATE_OF_BIRTH	date
PHONE_NUMBER	varchar(40)
ADDRESS	varchar(40)
QUALIFICATION	varchar(40)
EMAIL_ID	varchar(40)
YEAR_OF_PASSING	decimal(4,0)
PERCENTAGE	decimal(2,0)
JOBSEEKER_ID	int(6)
JOBPOST_ID	int(6)
EXPERIENCE	int(2)
		  */
		
		try(      Connection conn=ConnectionManager.openConnection();   )
		{
			String query="insert into applications(FIRST_NAME,MIDDLE_NAME,LAST_NAME,"
					+ "DATE_OF_BIRTH,PHONE_NUMBER,ADDRESS,"
					+ "QUALIFICATION,EMAIL_ID,YEAR_OF_PASSING,"
					+ "PERCENTAGE,JOBSEEKER_ID,JOBPOST_ID,EXPERIENCE) "
					+ "values(?,?,?,"
					+ "?,?,?,"
					+ "?,?,?,"
					+ "?,?,?,?)";			
			PreparedStatement st=conn.prepareStatement(query);
			
			st.setString(1, Fname);
			st.setString(2,Mname );
			st.setString(3, Lname );
			st.setString(4,strDate);
			st.setString(5, Phone);
			st.setString(6, address);
			st.setString(7, qualification);
			st.setString(8, email);
			st.setInt(9,passYear);
			st.setFloat(10,percentage );
			st.setInt(11,JOBSEEKER_ID );
			st.setInt(12, jobpostId);
			st.setInt(13, experience);
			

			
			
			
			int response=st.executeUpdate();
			//////////////
			
			
			String tre="select REFERENCE_ID from applications where JOBSEEKER_ID=?";
            PreparedStatement staw=conn.prepareStatement(tre);
            
            staw.setInt(1,JOBSEEKER_ID);
            ResultSet asd=staw.executeQuery();
            

            
            while(asd.next())
            REFERENCE_ID=asd.getInt("REFERENCE_ID");
            
            
			//retrieve reference id from mysql
			
			//skills.forEach((o)->{
            for(int i=0;i<skills.size();i++) {
				try {
					String queryy="insert into application_skills values(?,?)";//cha
					PreparedStatement statee=conn.prepareStatement(queryy);
					statee.setInt(1,REFERENCE_ID);
					statee.setString(2,skills.get(i));
				
				
				int inside=statee.executeUpdate();
					if (inside>0) {
							System.out.println("appDAo-----Skills Added into DAO succesfully");
								}
					else
							System.out.println("appDAo-------Skil ls DAO not DAO going DAO yaaaaa");
				}
				catch(SQLException s) {
					System.out.println("Error at adding Skills");
					s.printStackTrace();
				}
            }
			//});
			////////
			
			if(response>0) {
				//System.out.println("DOne!! Applied SuccessFully-----Stored Succesfully");
				boo=true;
				System.out.println("Reference ID for your application is :->"+REFERENCE_ID);
		}
			else
				boo=false;
			}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println("appDAo fasakked at appliedDAO");
			e.printStackTrace();
		}
		return boo;
	}

	/*
	 *Applications table Schema 
	 * 		REFERENCE_ID    NOT NULL NUMBER       
			FIRST_NAME      NOT NULL VARCHAR2(40) 
			MIDDLE_NAME     NOT NULL VARCHAR2(40) 
			LAST_NAME       NOT NULL VARCHAR2(40) 
			DATE_OF_BIRTH   NOT NULL DATE         
			PHONE_NUMBER             VARCHAR2(40) 
			ADDRESS                  VARCHAR2(40) 
			QUALIFICATION   NOT NULL VARCHAR2(40) 
			EMAIL_ID        NOT NULL VARCHAR2(40) 
			YEAR_OF_PASSING NOT NULL NUMBER(4)    
			PERCENTAGE               NUMBER(4,2)  
			JOBSEEKER_ID             NUMBER       
			EXPERIENCE               NUMBER  
	 * 
	 */
	
	
	public List<ApplicationModel> retrieveAllApplications() {
		
		String fname;
		String mname;
		String lname;
		Date datex;
		int passYear;
		int experience;
		String address;
		String qualification;
		String email;
		String phone;
		float percentage;
		int jobpostId;
		int jobseekerID,REFERENCE_ID;
		List<String> skills=new ArrayList<String>();
		
		List<ApplicationModel> dataUntouched=new ArrayList<>();
		
		try(Connection retrieve=ConnectionManager.openConnection();)
	{
			
		String retrieveString="select * from applications";
		PreparedStatement retriveStatement=retrieve.prepareStatement(retrieveString);
		
		ResultSet retriveSet=retriveStatement.executeQuery();
		
		if(retriveSet.next() == false)
			System.out.println("Sorry, there are no applications to view\n");
		else {
			do
			 	{
			jobseekerID=retriveSet.getInt("JOBSEEKER_ID");
			fname=retriveSet.getString("FIRST_NAME");
			mname=retriveSet.getString("MIDDLE_NAME");
			lname=retriveSet.getString("LAST_NAME");
			datex=retriveSet.getDate("DATE_OF_BIRTH");
			passYear=retriveSet.getInt("YEAR_OF_PASSING");
			experience=retriveSet.getInt("EXPERIENCE");
			address=retriveSet.getString("ADDRESS");
			qualification=retriveSet.getString("QUALIFICATION");
			email=retriveSet.getString("EMAIL_ID");
			phone=retriveSet.getString("PHONE_NUMBER");
			percentage=retriveSet.getFloat("PERCENTAGE");
			jobpostId=retriveSet.getInt("JOBPOST_ID");
			REFERENCE_ID=retriveSet.getInt("REFERENCE_ID");
			
			/*
			
			String retrieveS="select skill from application_skills where REFERENCE_ID=?";
			retriveStatement=retrieve.prepareStatement(retrieveS);
			ResultSet skillResult=retriveStatement.executeQuery();
			
			while(skillResult.next()) {
				skills.add(skillResult.getString("SKILL"));
			}
			
			*/
			ApplicationModel appliedModel=new ApplicationModel(jobseekerID,fname, mname, lname, datex, phone,qualification, email, passYear,jobpostId,
					percentage, experience,address,skills,REFERENCE_ID);
			
			dataUntouched.add(appliedModel);

		}while( retriveSet.next() );
			
		}
	}
		catch(Exception e) {	System.out.println("error at Retrieving  Applications at retrieveAllApplications() \n");
		e.printStackTrace();
		}
		
		
		return dataUntouched;
}
	
	
	
}