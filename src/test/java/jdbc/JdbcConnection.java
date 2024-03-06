package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			// Register database
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			
			//Get connection for the database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ty", "root","root");
			
			 // Create Statement
			 Statement createStatement = con.createStatement();
			 String query="Select * from test1;";
			 
			 //Execute Statement
			 ResultSet result = createStatement.executeQuery(query);
			 while(result.next())
			 {
				 //System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3));
				 if(result.getString(2).contains("Devendra"))
				 {
					 System.out.println("Data is present");
					 break;
				 }
			 }
			 
			
				
			
		}catch(SQLException e) {
			con.close();
		}
		
	}

}
