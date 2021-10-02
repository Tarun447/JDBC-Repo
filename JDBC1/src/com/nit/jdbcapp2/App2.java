package com.nit.jdbcapp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Connection con = null;
		Scanner s = new Scanner(System.in);
	try
	{
		// load Driver
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   
	   // Create Connection
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##ORACLE","ORACLE");
		 
	// Prepare Statement
		 PreparedStatement ps = con.prepareStatement("insert into nit values(?,?,?)");
		 System.out.println("Enter number of record Inserted : ");
		 int a =Integer.parseInt(s.nextLine());
		 for(int i =1;i<=a;i++)
		 {
			 System.out.println("Enter Your Id : ");
			 int id = Integer.parseInt(s.nextLine());
			 System.out.println("Enter your name : ");
			 String name = s.nextLine();
			 System.out.println("Enter Your Course name : ");
			 String course = s.nextLine();
			 ps.setInt(1, id);
			 ps.setString(2, name);
			 ps.setString(3, course);
			int k =  ps.executeUpdate();
			 if(k>0)
			 {
				 System.out.println(i+ "Record Insterted");
			 }
		 }
		    
		
	}
	catch(Exception e)
	{
	     e.printStackTrace();	
	}
	finally 
	{
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}

}
