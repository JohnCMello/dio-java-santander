package utils;

import java.util.ArrayList;
import java.util.List;

import entities.Candidate;

public class CanditateUtil {

	public static List<Candidate> createCandidatesList() {

		String[] names = { "Emily", "Liam", "Olivia", "Noah", "Ava", "Ethan", "Sophia", "Mason", "Isabella",
				"Benjamin" };
		List<Candidate> candidates = new ArrayList<>();

		for (String name : names) {
			Candidate candidate = new Candidate(name);
			candidates.add(candidate);
		}

		return candidates;
	}

	public static List<Candidate> selectCandidates(List<Candidate> candidatesList, Double baseSalary) {
		List<Candidate> selectedCandidates = new ArrayList<>();
		int maxNumberOfCandidates = 5;

//		adiciona ate 5 candidatos com salario desejado menor ou igual ao salario base dentre toda a lista de candidatos.
		for (int i = 0; selectedCandidates.size() < maxNumberOfCandidates && i < candidatesList.size(); i++) {
	        if (baseSalary >= candidatesList.get(i).getDesiredSalary()) {
	            selectedCandidates.add(candidatesList.get(i));
	        }
	    }
		
//		adiciona todos os candidatos com salario desejado menor ou igual ao salario base dentre toda a lista de candidatos.
//		for (Candidate candidate : candidatesList) {
//			if (baseSalary > candidate.getDesiredSalary() || baseSalary == candidate.getDesiredSalary()) {
//				selectedCandidates.add(candidate);
//			}
//		}

		return selectedCandidates;

	}

//	public static void analizeCandidates(List<Candidate> candidatesList, Double baseSalary) {
//
//		for (Candidate candidate : candidatesList) {
//			if (baseSalary > candidate.getDesiredSalary()) {
//				System.out.println("Ligar para candidadto");
//				System.out.println(candidate.getName());
//				System.out.println("Salário base: " + baseSalary);
//				System.out.println("Salário pretendido: " + candidate.getDesiredSalary());
//				System.out.println();
//				continue;
//			}
//			if (baseSalary == candidate.getDesiredSalary()) {
//				System.out.println("Ligar para candidadto com contraproposta");
//				System.out.println(candidate.getName());
//				System.out.println("Salário base: " + baseSalary);
//				System.out.println();
//				continue;
//			}
//			System.out.println("Aguardadndo resultado de mais candidatos.");
//			System.out.println();
//
//		}
//
//	}

}
