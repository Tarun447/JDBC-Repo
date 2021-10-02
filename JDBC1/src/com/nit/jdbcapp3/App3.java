package com.nit.jdbcapp3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		try
		{
			con = DAO.getCon();
			
			// PrepareStatement
			PreparedStatement ps = con.prepareStatement("select * from nit where SID=?");
			System.out.println("Enter student id : ");
			int id =Integer.parseInt(s.nextLine());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Id : "+rs.getInt(1)+"\t"+"Name : "+rs.getString(2)+"\t"+"Course : "+rs.getString(3));
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
