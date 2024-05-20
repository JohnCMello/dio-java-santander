package bootcamp.entities;

import java.time.LocalDate;

import interfaces.CalculateXp;

public class Mentorship implements CalculateXp {
	private String title;
	private String description;
	private LocalDate mentorshipDate;
	private int xpValue;

	
	public Mentorship(String title, String description, int xpValue,LocalDate mentorshipDate) {
		this.title = title;
		this.description = description;
		this.mentorshipDate = mentorshipDate;
		this.xpValue = xpValue;
	}

	@Override
	public int calculateXp() {
		return 0;

	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getMentorshipDate() {
		return mentorshipDate;
	}

	public int getXpValue() {
		return xpValue;
	}

	
}
