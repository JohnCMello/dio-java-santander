package bootcamp.entities;

import java.util.HashMap;
import java.util.Map;

public class Dev {
	private String name;
	private String email;

	private Map<String, Mentorship> mentorshipProgramsEnrolled;
	private Map<String, Boolean> mentorshipProgramsFinished;

	private Map<String, Course> coursesEnrolled;
	private Map<String, Boolean> coursesFinished;

	private Map<String, Bootcamp> bootcampsEnrolled;
	private Map<String, Boolean> bootcampsFinished;

	public Dev(String name, String email) {

		this.name = name;
		this.email = email;
		this.mentorshipProgramsEnrolled = new HashMap<>();
		this.mentorshipProgramsFinished = new HashMap<>();
		this.coursesEnrolled = new HashMap<>();
		this.coursesFinished = new HashMap<>();
		this.bootcampsEnrolled = new HashMap<>();
		this.bootcampsFinished = new HashMap<>();

	}

	public void applyToBootcamp(Bootcamp bootcamp) {
		bootcampsEnrolled.put(bootcamp.getName(), bootcamp);
	}

	public void advance() {

	}

	public int calculateXpTotal() {
		return 0;

	}

	public void showCourses() {

	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Map<String, Mentorship> getMentorshipProgramsEnrolled() {
		return mentorshipProgramsEnrolled;
	}

	public Map<String, Boolean> getMentorshipProgramsFinished() {
		return mentorshipProgramsFinished;
	}

	public Map<String, Course> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public Map<String, Boolean> getCoursesFinished() {
		return coursesFinished;
	}

	public Map<String, Bootcamp> getBootcampsEnrolled() {
		return bootcampsEnrolled;
	}

	public Map<String, Boolean> getBootcampsFinished() {
		return bootcampsFinished;
	}

	

}
