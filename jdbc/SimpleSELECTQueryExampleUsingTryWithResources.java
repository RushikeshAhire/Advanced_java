package example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleSELECTQueryExampleUsingTryWithResources {

	public static void main(String[] args) {
		String sqlQuery = 
				"select course_title, course_id, course_fees, course_duration from course_master";
		try(Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet recordSet = stmt.executeQuery(sqlQuery)
				){
				while(recordSet.next()) {
					String courseTitle = recordSet.getString(1);//Reads a String at column index 1 : Title
					String courseId = recordSet.getString(2);
					int courseFees = recordSet.getInt(3);
					int courseDuration = recordSet.getInt(4);
					System.out.println("ID: " + courseId + " --  Title: " + courseTitle + "-- Duration: " + courseDuration + "-- Fees: " + courseFees);
				}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
