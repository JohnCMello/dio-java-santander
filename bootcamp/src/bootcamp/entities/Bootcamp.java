package bootcamp.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Bootcamp {
	private LocalDate startDate;
	private LocalDate finishDate;
	private String name;
	private String description;
	private Map<String, Dev> participants;
	private Map<String, Course> courses;

	public Bootcamp(LocalDate startDate, LocalDate finishDate, String name, String description) {
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.name = name;
		this.description = description;
		this.participants = new HashMap<>();
		this.courses = new HashMap<>();

	}

	public void addNewParticipant(Dev participant) {
		participants.put(participant.getEmail(), participant);
	}

	public void addNewCourse(Course course) {
		courses.put(course.getTitle(), course);
	}

	public LocalDate participants() {
		return startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
