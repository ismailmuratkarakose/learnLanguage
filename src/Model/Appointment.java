package Model;

public class Appointment {
	private String day;
	private String start;
	private String end;
	private String student;
	private String teacher;
	
	
	public Appointment(String day, String start, String end, String student, String teacher) {
		this.day = day;
		this.start = start;
		this.end = end;
		this.student = student;
		this.teacher = teacher;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public String getStudent() {
		return student;
	}


	public void setStudent(String student) {
		this.student = student;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	@Override
	public String toString() {
		return   day + "*" + start + "*" + end + "*" + student + "*"
				+ teacher;
	}
	
	
	

}
