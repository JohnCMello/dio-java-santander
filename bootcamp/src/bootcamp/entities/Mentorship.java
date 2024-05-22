package bootcamp.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentorship extends Content {

	private LocalDate mentorshipDate;

	public Mentorship(String title, String description, String mentorshipDate, int xpValue) {
		super(title, description, xpValue);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.mentorshipDate = LocalDate.parse(mentorshipDate, formatter);
		;

	}

	@Override
	public String toString() {
		return "Mentorship [title=" + title + ", description=" + description + ", mentorshipDate=" + mentorshipDate
				+ ", xpValue=" + xpValue + "]";
	}

	public LocalDate getMentorshipDate() {
		return mentorshipDate;
	}

	@Override
	public int getXp() {
		return this.xpValue;
	}

}
