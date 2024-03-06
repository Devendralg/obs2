package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteRow {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ty", "root", "root");
			 
			 Statement createStatement = connection.createStatement();
			 
			 String query="delete from test1 where student_id =5;";
			 
			 int result = createStatement.executeUpdate(query);
			 
			while(result > 0)
			{
				System.out.println("Deleted");
				break;
			}
		}catch(SQLException e)
		{
			
		}finally {
			//connection.close();
		}
	}

}
