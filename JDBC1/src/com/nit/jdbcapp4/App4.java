package com.nit.jdbcapp4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.nit.DBconnection.DBDAO;

public class App4 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	try
	{
		// get Connection
		Connection con = DBDAO.getDbCon();
		DatabaseMetaData dmt = con.getMetaData();
		ResultSet tab = dmt.getTables(null, null, "employee",null);
	
		// check table is created or not 

		if(tab.next())
		{
			System.out.println("Table is not created");
			DBCreate.getTableCreate();
			
		}
		else
		{
			System.out.println("Enter Employee Id : ");
			int id = Integer.parseInt(s.nextLine());
			System.out.println("Enter Employee name : ");
			String name = s.nextLine();
			System.out.println("Enter employee Salary : ");
			float sal = Float.parseFloat(s.nextLine());
			
			// preparestatment
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, sal);
			int k = ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Record Store Successfully");
			}
			else
			{
				System.out.println("Record is not Store");
			}
			System.out.println("Do u want to see that Record yes/No : ");
			String ans = s.nextLine();
			if(ans.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter Employee Id : ");
			int eid = Integer.parseInt(s.nextLine());
			PreparedStatement ps1 = con.prepareStatement("select * from employee where eid = ?");
			ps.setInt(1, eid);
		    ResultSet rs = ps.executeQuery();
		   if(rs.next());
		   {
			   System.out.println("Employee id : "+"\t"+"Employee Name : "+"\t"+"Employee Salary : ");
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
		   }
			}
			else
			{
				System.out.println("Thank You ... Have a Nice Day");
			}
		}
			

		

	}
	catch(Exception e)
	{
	  e.printStackTrace();	
	}

	}

}
