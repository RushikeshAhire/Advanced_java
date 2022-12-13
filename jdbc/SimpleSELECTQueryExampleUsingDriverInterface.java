package example.jdbc;

import java.sql.Connection;
import java.sql.Driver;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Properties;

public class SimpleSELECTQueryExampleUsingDriverInterface {

	public static void main(String[] args) {
		//This class name varies from DB to DB
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		//oracle.jdbc.OracleDriver
		//String connectionURL = "jdbc:mysql://localhost:3306/db1?autoReconnect=true&useSSL=false";
		String connectionURL = "jdbc:mysql://localhost:3306/db1";
		//jdbc:oracle:thin:@localhost:1521:xe
		
		
		try {
			Driver dr = new com.mysql.cj.jdbc.Driver();
			
			Properties jdbcProps = new Properties();
			jdbcProps.put("user", "root");
			jdbcProps.put("password", "root");
			Connection conn = dr.connect(connectionURL, jdbcProps);
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
			
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
