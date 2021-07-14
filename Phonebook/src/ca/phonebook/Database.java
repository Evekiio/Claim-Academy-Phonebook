package ca.phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	
	//TODO: make this so it automatically finds local database file.
	static String jdbcUrl = "jdbc:sqlite:/C:\\Users\\sande\\Desktop\\GitHub\\Claim-Academy-Phonebook\\Phonebook\\data\\data.db";
	
	public static void databaseConnection() 
	{
		try
		{
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String sql = "SELECT * FROM Contacts";
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next())
		{
		String firstName = result.getString("firstName");
		String lastName = result.getString("lastName");
		
		System.out.println("The data from SQLite: \n-- First Name: " + firstName + "\n-- Last Name: " + lastName);
		}
		
		}
		catch (SQLException e)
		{
			System.out.println("Error connecting to SQLite database.");
			e.printStackTrace();;
		}	
	}
}
