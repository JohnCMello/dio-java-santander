package digitalbank.entities;

public class Customer {
	private String name;
	private String socialNumber;
	
	public Customer(String name, String socialNumber) {
		this.name = name;
		this.socialNumber = socialNumber;
	}

	public String getName() {
		return name;
	}

	public String getSocialNumber() {
		return socialNumber;
	}
	
}
