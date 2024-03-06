package com.obs.generic.utilities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	//Connection connection;
	
	public  Connection connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(IpathConstants.DbUrl, IpathConstants.DbUserName, IpathConstants.DbPassord);
		return connection;
	}
	
	public  String executeAndGetData(String query,int column_index,String ExpectedData) throws SQLException
	{
		Statement statement = connectToDB().createStatement();
		ResultSet result = statement.executeQuery(query);
		boolean flag = false;
		
		while(result.next())
		{
			String actualData = result.getString(column_index);
			if(actualData.equals(ExpectedData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("---Data is Present---");
			return ExpectedData;
		}else
		{
			System.out.println("--Data is Not Present---");
			return "";
		}
		
			
		
	}
	
	
	public  void disconnectDB() throws SQLException
	{
		connectToDB().close();
	}

	
	
	
	
	

}
