package com.vrps.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.LoginModel;
import com.virtusa.model.SessionForwading;
import com.virtusa.view.AdminView;
import com.virtusa.view.HRView;
import com.virtusa.view.JobseekerView;
import com.virtusa.view.TRView;

public class UserAuthentication {


	
	public  SessionForwading Verification(LoginModel lm,int option){
		int jobsee=0;
  	  boolean result=false;
  	String username=lm.getUsername(), password=lm.getPassword();
		
		try (Connection con=ConnectionManager.openConnection();)
{   
	      if(option==1) {
	    	 
	    	  String queryx="SELECT USER_NAME,PASS_WORD,jobseeker_id  FROM credentials where USER_NAME=?";
	    	  String username1="",password1="";

	  		
	    	  PreparedStatement stt=con.prepareStatement(queryx);
			stt.setString(1, username);
		    ResultSet rsx = stt.executeQuery();
				
		    
			      while (rsx.next()) {
			            username1 = rsx.getString("USER_NAME");
			            password1 = rsx.getString("PASS_WORD");
			            jobsee =rsx.getInt("jobseeker_id");
			         	 System.out.println(username1+"------------- "+password1+"  -----");
			         	 
			         	  if((username1.equals(username))&&(password1.equals(password)))
					         {
						         System.out.println("User Authentication Successfull ");
						         result= true;
						      //   sf=new SessionForwading(jobsee,result);
						         break;
					         }	
			         	  else 
					         {
			         		  result=false;
			         		// sf=new SessionForwading(jobsee,result);
			         		  }
			      					}

	    	 		}
	      else if(option==2)
	      {
	    	 String username1="",password1="",job_role="";
	    	 
	    	  
	    	  String query="SELECT USER_NAME,PASS_WORD,job_role FROM employee_credentials where USER_NAME=?";
	    	 PreparedStatement  st=con.prepareStatement(query);
	    	  st.setString(1, username);
	    	  ResultSet rs = st.executeQuery();
					
				      while (rs.next()) 
				      {
				            username1 = rs.getString("USER_NAME");
				            password1 = rs.getString("PASS_WORD");
				            job_role=rs.getString("JOB_ROLE");
				         	 System.out.println(username1+"  is  \t"+password1+"  -----");
				         	 
				         	if((username1.equals(username)) && (password1.equals(password)) && (job_role.equals("tr"))  )
				         			{
						         System.out.println("tr\nEmployee Authentication Successfull ");
						         result= true;
						       //  sf=new SessionForwading(jobsee,result);
						         break;
				         			}	
			         	  else if((username1.equals(username)) && (password1.equals(password)) && (job_role.equals("hr"))  )
					         		{
			         		 System.out.println("hr\nEmployee Authentication Successful ");
					         result= true;
					        // sf=new SessionForwading(jobsee,result);
					         break;
					         		}
			         	  else
			         	  			{
			         		 System.out.println("Employee Authentication Failed");
			         		//sf=new SessionForwading(jobsee,result);
			         		  result=false;
			         		  break;
			         	  			}
				        
				     }
				      if(job_role.equals("tr") && result){
			         		
			         		TRView tview=new TRView();
			         		tview.mainMenu();
			         		
			         	}else if (job_role.equals("hr") && result) {
			         		HRView hview=new HRView();
			         		hview.mainMenu();

				      
			         	}
	      }
		else if(option==3) {
			
			  String username1="",password1="",job_role="";

			  String query="SELECT * FROM employee_credentials where USER_NAME=? and job_role='admin'";
	    	  
	    	  PreparedStatement st=con.prepareStatement(query);
				st.setString(1, username);
			  ResultSet   rs = st.executeQuery();
					
				      while (rs.next()) 
				      {
				            username1 = rs.getString("USER_NAME");
				            password1 = rs.getString("PASS_WORD");
				            job_role=rs.getString("job_role");
				         	 System.out.println(username1+"  is  \t"+password1+"  -----");
				         	 
				         	if((username1.equals(username)) && (password1.equals(password))  )// && (job_role.equalsIgnoreCase("admin"))
				         			{
						         System.out.println("Admin Authentication Successfull ");
						         result= true;
						     //    sf=new SessionForwading(jobsee,result);
						         break;
				         			}	
				           else
		         	  				{
				        	   System.out.println("Admin Authentication Failed");
				        	   result=false;
				        	 //  sf=new SessionForwading(jobsee,result);
				        	   break;
		         		  			}
				      }
				    //  return result;
				     // AdminView aview =new AdminView();
				      //aview.mainMenu();
	      }
	            
	
}catch(Exception e) {
			         System.out.println("SQL exception occured" );
			         e.printStackTrace();
		      }
		SessionForwading sf=new SessionForwading(jobsee,result);
		System.out.print("\n\n----result at  UserAuthentication--"+sf.isStatus()+"\n");
		return sf;	
		}


}