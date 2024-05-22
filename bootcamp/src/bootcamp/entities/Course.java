package bootcamp.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course extends Content {
	private int totalHours;
	private LocalDate courseDate;
	
	public Course(String title, String description, int totalHours, String courseDate, int xpValue) {
		super(title, description, xpValue);
		this.totalHours = totalHours;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.courseDate = LocalDate.parse(courseDate, formatter);
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", description=" + description + ", totalHours=" + totalHours
				+ ", courseDate=" + courseDate + "]";
	}

	@Override
	public int getXp() {
		return xpValue;
	}
	public int getTotalHours() {
		return totalHours;
	}

	 public LocalDate getCourseDate() {
	        return courseDate;
	    }

}
