package bootcamp.entities;

import interfaces.CalculateXp;

public class Course implements CalculateXp {
	private String title;
	private String description;
	private int totalHours;

	public Course(String title, String description, int totalHours) {
		this.title = title;
		this.description = description;
		this.totalHours = totalHours;
	}

	@Override
	public int calculateXp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getTotalHours() {
		return totalHours;
	}

}
