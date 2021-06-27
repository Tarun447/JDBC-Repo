package Mobile;
import java.sql.*;
import Connection.*;

public class MobileData {

	public static void main(String[] args) {
		try
		{
			Connection con = DAO.getConnection();
			// Prepared Statement
			PreparedStatement ps = con.prepareStatement("Select * from mobile");
			ResultSet rs = ps.executeQuery();
			System.out.println("========================================================");
			System.out.println("Company\t\tMobileName\t\tMobile Price");
			System.out.println("--------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
			}
			System.out.println("========================================================");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}

}
