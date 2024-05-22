package bootcamp.entities;

abstract public class Content {

	protected String title;
	protected String description;
	int xpValue;

	public Content(String title, String description, int xpValue) {
		this.title = title;
		this.description = description;
		this.xpValue = xpValue;

	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getXpValue() {
		return xpValue;
	}

	public abstract int getXp();
}
