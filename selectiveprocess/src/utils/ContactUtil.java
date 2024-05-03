package utils;

import entities.Candidate;

public class ContactUtil {

	public static void contactCandidate(Candidate candidate) {

		Integer tries = 1;
		boolean answered;

		do {
			answered = Candidate.answerThePhone();
			if (answered) {
				System.out.println(
						"Contato realizado com " + candidate.getName() + " sucesso após " + tries + " tentativas");
				return;
			} 
			tries++;
		} while (!answered && tries < 3);
		
		System.out.println(
				"Não conseguimos contato com " + candidate.getName() + " após " + tries + " tentativas");

	}
}
