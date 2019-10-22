 package com.virtusa.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.virtusa.entities.JobseekerEntity;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.ASLModel;
import com.virtusa.model.JobseekerModel;
import com.virtusa.view.TRView;

public class TrDAOImp 
{
	Scanner wwe=new Scanner(System.in);
	
		public boolean  TrShortlist()
		{
			boolean result=false;
			try(Connection connection=ConnectionManager.openConnection();){
				String st="select REFERENCE_ID,JOBSEEKER_ID from application_and_status where ADMIN_STATUS='yes'";
				PreparedStatement ps=connection.prepareStatement(st);	
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()==false) {
					result=true;
				}
			
			else {
				
				do {
					System.out.println("REFERENCE_ID|JOBSEEKER_ID" );
					System.out.println(rs.getInt("REFERENCE_ID")+"\t"+rs.getInt("JOBSEEKER_ID"));
					System.out.println("Select this Candidate(Yes/No):");
					
					int REFERENCE_ID=rs.getInt("REFERENCE_ID");
					String stat=wwe.next();
					
					String set="update application_and_status set TR_STATUS='yes' where REFERENCE_ID=?";
					PreparedStatement ps11=connection.prepareStatement(set);
					ps11.setInt(1, REFERENCE_ID);
					
					
					int q=ps11.executeUpdate();
					if(q>0)
						System.out.println("TR Status succesfully updated for Applicant:"+rs.getInt("REFERENCE_ID"));
					else
						System.out.println("TR's Status updation failed:");
			
					}while(rs.next());
				
				result=true;
				}
			}
			catch(Exception e) {System.out.println("error at TrShortlist() in TrDAOImp");
			e.printStackTrace();}
			
			return result;
		
		}
			
		
		public List<ASLModel> getAllJobSeekers(){
		/*	
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
			 String uname;
			 String password;
			 List<String> skills;
		*/	
			 ASLModel jm;
			 List<ASLModel> data=new ArrayList<>();
				
				try(Connection connection=ConnectionManager.openConnection();){
					String st="select * from application_and_status where ADMIN_STATUS='yes'";
					PreparedStatement ps=connection.prepareStatement(st);				
					ResultSet rs=ps.executeQuery();
					//List<JobseekerModel> data=new ArrayList<>();
					if(rs.next()==false) {
						System.out.println(" Sorry,there are no Applications shorlisted by Admin\n Contact Admin or Please wait for further Instructions");
					}else //if(rs.next()==true)
					{
						jm=new ASLModel(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
						data.add(jm);
					}
					
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error at Viewing Applications List:");
				}
			return data;
		}
		
	
		
		public void rate_comment() {
			// TODO Auto-generated method stub
			String comment;
			int rating;

			
			try(Connection connection=ConnectionManager.openConnection();){
				
				
				//String query1="select REFERENCE_ID,JOBSEEKER_ID from applications";
				
				
				String st="select reference_id,jobseeker_id from application_and_status where ADMIN_STATUS='yes' ";
				PreparedStatement rate=connection.prepareStatement(st);
				ResultSet rps=rate.executeQuery();
				
				
				while(rps.next()) {
					
					System.out.println("___________________________");
					System.out.println("|REFERENCE_ID|JOBSEEKER_ID|");
					System.out.println("___________________________");
					
					System.out.println(rps.getInt("reference_id")+"\t|"+rps.getInt("jobseeker_id")+"\n");///////////////////////////
					
					
					System.out.println("Enter Rating ( out of 5 ) for this candidate:");
					rating=wwe.nextInt();
					System.out.println("Enter Comments on this candidate:");
					comment=wwe.next();
					
					
					String setter="update table RATING_COMMENT set TR_RATING=?,TR_RATING=? where JOBSEEKER_ID=?";
					PreparedStatement rate1=connection.prepareStatement(setter);
					rate1.setInt(3, rps.getInt("JOBSEEKER_ID"));
					rate1.setInt(1, rating);
					rate1.setString(2, comment);
					
					int r=rate1.executeUpdate();
					
					if(r>0) {
						System.out.println("Rating and Comment Successfully given by TR");
						
					}
					else {
						System.out.println("Problem at giving Rating and Comment by TR");
						
					}
				}
				
				TRView backing=new TRView();
				backing.mainMenu();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at TR's Rating and Commenting Service");
		}
		
		
		}

	}
		
	

