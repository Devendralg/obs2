package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ty", "root", "root");
			 Statement state = connection.createStatement();
			 
			 String query="Create table test4 (id int(3) not null primary key,name varchar(25) not null);";
			 
			 int result = state.executeUpdate(query);
			 if(result ==0)
			 {System.out.println("Table created");
				 
			 }
			 
		}catch(SQLException e)
		{
			connection.close();
		}
	}

}
