package bootcamp.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dev {
	private String name;
	private String email;

	private int xp;

	private List<Mentorship> mentorshipProgramsEnrolled;
	private List<Bootcamp> bootcampsEnrolled;
	private List<Course> coursesEnrolled;

	public Dev(String name, String email) {
		this.name = name;
		this.email = email;
		this.bootcampsEnrolled = new ArrayList<>();
		this.coursesEnrolled = new ArrayList<>();

		this.mentorshipProgramsEnrolled = new ArrayList<>();

	}

	public void enrollBootcamp(Bootcamp bootcamp) {
		bootcampsEnrolled.add(bootcamp);
	}

	public void enrollCourse(Course course) {
		coursesEnrolled.add(course);
	}

	public void enrollMentorship(Mentorship mentorship) {
		mentorshipProgramsEnrolled.add(mentorship);
	}

	public int calculateTotalXp() {
		return xp;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Mentorship> getEnrolledMentorships() {
		return mentorshipProgramsEnrolled;
	}

	public List<Course> getEnrolledCourses() {
		return coursesEnrolled;
	}

	@Override
	public String toString() {
		return "Dev [name=" + name + ", email=" + email + ", xp=" + xp + ", mentorshipProgramsEnrolled="
				+ mentorshipProgramsEnrolled + ", bootcampsEnrolled=" + bootcampsEnrolled + ", coursesEnrolled="
				+ coursesEnrolled + "]";
	}

	public List<Bootcamp> getEnrolledBootcamps() {
		return bootcampsEnrolled;
	}

}
