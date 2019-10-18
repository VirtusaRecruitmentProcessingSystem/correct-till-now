import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtusa.integrate.ConnectionManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try(Connection conn=ConnectionManager.openConnection();){
		String query="select * from sample";
		
		PreparedStatement ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
			System.out.println("id");
		while(rs.next()) {
			System.out.println(rs.getInt("id"));
		}
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}

	/*
public boolean validString(String val) {
		
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		
		for(char ch:chars) {
			if(alphabets.contains(ch)) {
				result=true;
			}else {
				result=false;
			}
		}
		return result;
	}

public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	
	Test t=new Test();
	System.out.println("----");
	String input=scan.next();
	boolean result=t.validString(input);
	if(result)
		System.out.println("True");
	else
		System.out.println("False");
	scan.close();
}
}
*/
	
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try(Connection conn=ConnectionManager.openConnection();){
		String query="insert into jobseeker values(?,?,?,TO_DATE(?,'dd-mm-yyyy'),?,?,?,?,?,JOBSEEKER_ID.nextval,?,?)";
	
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, "raju");
		ps.setString(2, "greek-u");
		ps.setString(3, "veerudu");
		
		ps.setString(4, "01-01-1990");
		ps.setString(5, "8989891234");
		ps.setString(6,"hyderabad");
		ps.setString(7,"btech");
		ps.setString(8,"cheeku@cheek.com");
		ps.setInt(9,2019 );
		String s="67.8";
		s+="f";
		ps.setFloat(10,Float.parseFloat(s));
		ps.setInt(11, 0);
		
		ps.executeUpdate();
		
		
		
		
		int x=ps.executeUpdate();
		if(x>0)
			System.out.println("Done fasakked");
		else
			System.out.println("____________ fasakked");
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
}
	*/
	