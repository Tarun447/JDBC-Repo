package Connection;

import java.sql.*;
public class DBConnection {
	private static Connection con=null;
	private static String user,url,pass;
  static 
  {
	  try
	  {
		  // load driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		 //Create Connection
		  url="jdbc:oracle:thin:@localhost:1521:orcl";
		  user="C##ORACLE";
		  pass="ORACLE";
		  con = DriverManager.getConnection(url,user,pass);
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public static Connection getConn()
  {
	  return con;
  }

}
