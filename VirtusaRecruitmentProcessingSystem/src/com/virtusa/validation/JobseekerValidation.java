
package com.virtusa.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.integrate.ConnectionManager;

public class JobseekerValidation {

public boolean validString(String val) {
		
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		
		for(char ch:chars) {
			if(alphabets.contains(ch))
				result=true;
			else if(!(alphabets.contains(ch)))
				result=false;
							}		
		
		
		return result;
	}

	public boolean validNumber(String number) {
		boolean result=false;
	//	String data=String.valueOf(number);
		
/*		if(data.matches(".*[0-9]")) 
			return false;
		else
			return true;
	*/
		try {
			int test=Integer.parseInt(number);
			result =false;
		}
		catch(NumberFormatException e)
		{
			System.out.println("-----------------Enter Input in Valid Number Format----------------\n");
			
			result=true;
		}
		
		return result;
	}
	
	public boolean validSalary(double salary) {
		boolean result=false;
		String salaryVal=String.valueOf((int)salary);
		if(salary>0 && salaryVal.length()<=5) {
			result=true;
		}
		return result;
}
	
	public boolean validEmail(String email) {
		boolean result=false;
		if(email.matches("^(.+)@(.+)$")) {
			result=true;
		}
		return result;
	}
	
	public boolean validPhoneNumber(String PhoneNo) {
		boolean lenValidity=false,typeValidity=false;
		
		if(PhoneNo.length()!=10) {
			System.out.println("-----Enter a Valid 10 Digit Mobile Number---\n");
			lenValidity=false;
		}
		else
			lenValidity=true;
		char ch;
		for(int i=0;i<PhoneNo.length();i++) {
			ch=PhoneNo.charAt(i);
			if(Character.isDigit(ch)!=true) 
				typeValidity=false;
			else
				typeValidity=true;
		}
		if(lenValidity && typeValidity)
			return true;
		else
			return false;
	}
	
	public boolean validJobPost(int jobPostID) {
		
		boolean result=false;
		
		try(Connection conn=ConnectionManager.openConnection();){
		String tre="select * from job_description where jobpost_id=?";
        PreparedStatement staw=conn.prepareStatement(tre);
        staw.setInt(1,jobPostID);
        
        boolean xx=staw.execute();
        if(xx)
        	result= true;
        else 
        	result= false;
        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
return result;
	}
	
}
