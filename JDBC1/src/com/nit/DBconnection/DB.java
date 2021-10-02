package com.nit.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
private static  Connection con = null;
private static String url,name,pass;
public static Connection getDbCon() throws Exception
{
	// url 
	url = "jdbc:oracle:thin:@localhost:1521:orcl";
	name = "C##ORACLE";
	pass = "ORACLE";
	
	// load the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// Create Connection
	con = DriverManager.getConnection(url,name,pass);
	return con;
}
}
