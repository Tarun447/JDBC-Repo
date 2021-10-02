package com.nit.jdbcapp3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private static Connection con = null;
	private  static String url,user,pass;
	public static Connection getCon() throws Exception
	{
		// load the Driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Url 
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//Username 
		user = "C##ORACLE";
		
		// Password
		pass = "ORACLE";
		
		
		// Create a connection
		con = DriverManager.getConnection(url,user,pass);
		
		return con;
	}
	

}
