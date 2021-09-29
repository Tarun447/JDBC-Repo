package com.nit.jdbcapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App1 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Create Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##ORACLE","ORACLE");
			
			// Create Statement 
			Statement smt = con.createStatement();
			
			//ResultSet
			ResultSet rs = smt.executeQuery("select * from nit");
			
			while(rs.next())
			{
				System.out.println("Student id : "+rs.getInt("Sid")+"\t"+"Student Name : "+rs.getString("Sname")+"\t"+"Student Course : "+rs.getString("Course"));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
