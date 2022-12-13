package example.jdbc.entity;

public class Course {
	private String courseId;
	private String courseTitle;
	private int courseDuration;
	private int courseFees;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseId, String courseTitle, int courseDuration, int courseFees) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public int getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + "]";
	}

}
