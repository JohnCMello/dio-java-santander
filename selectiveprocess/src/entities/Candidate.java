package entities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Candidate {
	private String name;
	private Double desiredSalary;
	public boolean teste;

	public Candidate(String name) {

		Random random = new Random();

		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##", symbols);

		this.name = name;
		this.desiredSalary = Double.parseDouble(df.format(1800 + random.nextDouble() * (2200 - 1800)));
		this.teste = answerThePhone();
		;

	}

	public String getName() {
		return name;
	}

	public Double getDesiredSalary() {
		return desiredSalary;
	}
	
	static public boolean answerThePhone() {
		return new Random().nextInt(3) == 1;
	}

}
