package project;

import java.sql.*;
import javax.servlet.*;
import Connection.*;

public class LoginDAO {
	private static String fname=null;
	public static String login(ServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getConn();
			
			// prepare Statement
			PreparedStatement ps = con.prepareStatement("Select * from Student31 where "
					+ "USERNAME=? and PASSWORD=?");
			ps.setString(1, req.getParameter("user"));
			ps.setString(2, req.getParameter("upass"));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				fname=rs.getString(3);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return fname;
	}

}
