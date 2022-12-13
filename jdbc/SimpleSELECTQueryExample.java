package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {

	public static void main(String[] args) {
		//This class name varies from DB to DB
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		//oracle.jdbc.OracleDriver
		//String connectionURL = "jdbc:mysql://localhost:3306/db1?autoReconnect=true&useSSL=false";
		String connectionURL = "jdbc:mysql://localhost:3306/db1";
		//jdbc:oracle:thin:@localhost:1521:xe
		String userId = "root";
		String password = "root";
		
		try {
			//Load the Driver
			Class.forName(driverClassName);
			System.out.println("Driver loaded.");
			
			//Establish Connection
			Connection conn =  DriverManager.getConnection(connectionURL, userId, password);
			System.out.println("Connected to DB");
			
			//Obtain the Statement
			Statement stmt = conn.createStatement();
			
			//Execute SQL Query
			String sqlQuery = 
					"select course_title, course_id, course_fees, course_duration from course_master";
			ResultSet recordSet = stmt.executeQuery(sqlQuery);
			
			//Navigating through the ResultSet: recordSet
			while(recordSet.next()) {
				String courseTitle = recordSet.getString(1);//Reads a String at column index 1 : Title
				String courseId = recordSet.getString(2);
				int courseFees = recordSet.getInt(3);
				int courseDuration = recordSet.getInt(4);
				System.out.println("ID: " + courseId + " --  Title: " + courseTitle + "-- Duration: " + courseDuration + "-- Fees: " + courseFees);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//This method is used to load the class explicitly
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
