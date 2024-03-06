package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateData{

	public static void main(String[] args) throws SQLException{
		Connection con =null;
		
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ty", "root", "root");
			Statement statement = con.createStatement();
			String query ="insert into test1 values(8,'Rakesh','hh');";
			int update = statement.executeUpdate(query);
			if(update > 0)
			{
				System.out.println("Updated");
			}
			
			
		}catch(SQLException e)
		{
			
		}finally
		{
			con.close();
		}
		
	}

}
