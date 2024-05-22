package bootcamp.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bootcamp {
	private LocalDate startDate;
	private LocalDate finishDate;
	private String title;
	private String description;
	private List<Dev> participants;
	private List<Course> courses;
	private List<Mentorship> mentorships;

	public Bootcamp(String startDate, String finishDate, String title, String description) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.startDate = LocalDate.parse(startDate, formatter);
		this.finishDate = LocalDate.parse(finishDate, formatter);
		this.title = title;
		this.description = description;
		this.participants = new ArrayList<>();
		this.courses = new ArrayList<>();
		this.mentorships = new ArrayList<>();
	}

	public void addParticipant(Dev participant) {
		participants.add(participant);
	}

	public void addCourse(Course course) {
		courses.add( course);
	}

	public void addMentorship(Mentorship mentorship) {
		mentorships.add(mentorship);
	}

	public List<Dev> getParticipants() {
		return new ArrayList<>(participants);
	}

	public List<Course> getCourses() {
		return new ArrayList<>(courses);
	}

	public List<Mentorship> getMentorships() {
		return new ArrayList<>(mentorships);
	}

	public void removeParticipant(Dev participant) {
		participants.remove(participant);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	public void removeMentorship(Mentorship mentorship) {
		mentorships.remove(mentorship);
	}

	@Override
	public String toString() {
		return "Bootcamp [startDate=" + startDate + ", finishDate=" + finishDate + ", title=" + title + ", description="
				+ description + ", participants=" + participants + ", courses=" + courses + ", mentorships="
				+ mentorships + "]";
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

}
