package com.nit.jdbcapp4;

import java.sql.Connection;
import java.sql.Statement;

import com.nit.DBconnection.DBDAO;

public class DBCreate {

	public static void getTableCreate() throws Exception{
		
			Connection con = DBDAO.getDbCon();
			Statement smt  = con.createStatement();
			boolean val = smt.execute("create table employee (eid number(5),ename varchar2(20),esal number(7,2))");
			if(!val)
			{
				System.out.println("Sucessfully create a table");
			}
			else
			{
				System.out.println("something error happen");
			}
		
		

	}

}
