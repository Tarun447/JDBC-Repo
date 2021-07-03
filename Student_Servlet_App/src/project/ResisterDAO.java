package project;

import java.sql.*;
import Connection.*;

public class ResisterDAO {
	private static int k =0;
	public static int Register(StudentBean sb) 
	
	{
		try
		{
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement("insert into student31 values(?,?,?,?,?,?)");
			ps.setString(1, sb.getuName());
			ps.setString(2, sb.getPass());
			ps.setString(3, sb.getFname());
			ps.setString(4, sb.getLname());
			ps.setLong(5, sb.getPhn());
			ps.setString(6, sb.getMid());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
