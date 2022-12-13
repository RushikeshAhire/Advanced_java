package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.JdbcUtils;
import example.jdbc.entity.Course;

public class CourseDao implements IDao<Course, String> {

	@Override
	public void create(Course crs) {//This object will be stored as a record into the database table
		//Extract the data available in the Course object: crs using getters
		String id = crs.getCourseId();
		String title = crs.getCourseTitle();
		int duration = crs.getCourseDuration();
		int fees = crs.getCourseFees();
		
		String sqlQuery = "insert into course_master values(?,?,?,?)";
		try(Connection conn = JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setInt(3, duration);
			pstmt.setInt(4, fees);
			
			int insertCount = pstmt.executeUpdate();
			System.out.println("Record inserted. Count is " + insertCount);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Collection<Course> getAll() {
		Collection<Course> allCourses = new ArrayList<Course>();
		try(Connection conn = JdbcUtils.buildConnection();
				Statement stmt = conn.createStatement();
				ResultSet recordSet = stmt.executeQuery("select * from course_master")){
				while(recordSet.next()) {
					String courseTitle = recordSet.getString(2);//Reads a String at column index 1 : Title
					String courseId = recordSet.getString(1);
					int courseFees = recordSet.getInt(4);
					int courseDuration = recordSet.getInt(3);
					//Building a Course object based upon the data fetched from ResultSet
					Course crs = new Course(courseId, courseTitle, courseDuration, courseFees);
					//Adding the Course object into the Collection: allCourses
					allCourses.add(crs);
				}
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allCourses;
	}

	@Override
	public Course getOne(String courseId) {//Gets one course against Course ID
		Course foundCourse = null;
		String sqlQuery = "select * from course_master where course_id = ?";
		try(Connection conn = JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
				pstmt.setString(1, courseId);//Substituting the incoming courseId at position 1
				ResultSet recordSet = pstmt.executeQuery();
				if(recordSet.next()) {//Returns true if record is found
					String courseTitle = recordSet.getString(2);//Reads a String at column index 1 : Title
					
					int courseFees = recordSet.getInt(4);
					int courseDuration = recordSet.getInt(3);
					//Building a Course object based upon the data fetched from ResultSet
					foundCourse = new Course(courseId, courseTitle, courseDuration, courseFees);
				}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundCourse;
	}

	@Override
	public void update(Course t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOne(String key) {
		// TODO Auto-generated method stub
		
	}

}
