package test;

import java.sql.*;
import java.util.*;

public class Transaction {

	public static void main(String[] args) {
		try
		{
			Scanner s = new Scanner(System.in);
			// load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//create Connection
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "C##ORACLE";
			String pass = "ORACLE";
			Connection con = DriverManager.getConnection(url,user,pass);
			
			// Set AutoCommit false
			con.setAutoCommit(false);
			
			//set a savapoint
			Savepoint sp = con.setSavepoint();
			PreparedStatement ps = con.prepareStatement("select * from Bank31 where ACCNO=?");
			PreparedStatement ps1 = con.prepareStatement("update Bank31 set bal=bal+? where ACCNO=?");
			System.out.println("Entere your Account number");
			long yacc = s.nextLong();
			ps.setLong(1, yacc);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
			{
				float bal = rs1.getFloat(3);
				System.out.println("Entere Benifeciary Account number");
				long bacc = s.nextLong();
				ps.setLong(1, bacc);
				ResultSet rs2 = ps.executeQuery();
				if(rs2.next())
				{
					System.out.println("Enter Amount : ");
					float amt = s.nextFloat();
					if(amt<=bal)
					{
						ps1.setFloat(1, -amt);
						ps1.setLong(2, yacc);
						
						int k = ps1.executeUpdate();
						ps1.setFloat(1, amt);
						ps1.setLong(2, bacc);
						
						int j = ps1.executeUpdate();
						
						if(k==1 && j==1)
						{
							con.commit();
							System.out.println("Transaction successfully Done....");
							
						}
						else
						{
							con.rollback(sp);
							System.err.println("transaction is not Completed Due To technical Issue..pls try Again");
						}
						
					}
					else
					{
						System.err.println("Insufficent balance...");
					}
					
				}
				else
				{
					System.err.println("Benifeciary Account number does not match..");
				}
			}
			else
			{
				System.err.println("your Account Number does not match....");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
