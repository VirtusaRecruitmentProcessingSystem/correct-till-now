 package com.virtusa.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.virtusa.entities.JobseekerEntity;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.ASLModel;
import com.virtusa.view.TRView;

public class TrDAOImp 
{

		public void  TrShortlist()
		{
			try(Connection connection=ConnectionManager.openConnection();){
				//String query1="select REFERENCE_ID,JOBSEEKER_ID from applications";
				
				
				String st="select REFERENCE_ID,JOBSEEKER_ID from application_and_status where ADMIN_STATUS='yes'";
				PreparedStatement ps=connection.prepareStatement(st);				
				ResultSet rs=ps.executeQuery();
				
				System.out.println("REFERENCE_ID|JOBSEEKER_ID" );
				
				while(rs.next()) {
					System.out.println(rs.getInt("REFERENCE_ID")+"\t"+rs.getInt("JOBSEEKER_ID"));
					System.out.println("Select this Candidate(Yes/No):");
					Scanner s=new Scanner(System.in);
					String stat=s.next();
					
					String set="update application_and_status set TR_STATUS='yes' where REFERENCE_ID=?";
					PreparedStatement ps1=connection.prepareStatement(set);				
					int q=ps1.executeUpdate();
					if(q>0)
						System.out.println("TR Status succesfully updated for Applicant:"+rs.getInt("REFERENCE_ID"));
					else
						System.out.println("Status updation failed:");
							
				}
				
				
			}
			catch(Exception e) {}
				
		}	
			
		
		
		
	
		
		public void rate_comment() {
			// TODO Auto-generated method stub
			String comment;
			int rating;
			Scanner scan =new Scanner(System.in);
			
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
					rating=scan.nextInt();
					System.out.println("Enter Comments on this candidate:");
					comment=scan.next();
					
					
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
		
	

