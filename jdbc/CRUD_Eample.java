package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.CourseDao;
import example.jdbc.dao.IDao;
import example.jdbc.entity.Course;

public class CRUD_Eample {
	
	private static void createNewCourse() {
		IDao<Course, String> idaoRef = new CourseDao();
		Course cr = new Course("ML", "Machine Learning", 5, 20000);
		idaoRef.create(cr);;
	}
	private static void showAllCourses() {
		//To show courses, it is necessary to obtain the collection from CourseDao through getAll()
		IDao<Course, String> idaoRef = new CourseDao();
		Collection<Course> courseList = idaoRef.getAll();
		for(Course cr : courseList)
			System.out.println(cr);
	}
	
	private static void showOneCourse() {
		IDao<Course, String> idaoRef = new CourseDao();
		Course foundCourse = idaoRef.getOne("ML");
		if(foundCourse != null)
			System.out.println("Found Course is " + foundCourse);
		else
			System.out.println("The course does not exist");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//showAllCourses();
		//showOneCourse();
		createNewCourse();

	}

}
