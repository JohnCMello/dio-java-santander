package application;

import java.util.ArrayList;
import java.util.List;

import entities.Candidate;
import utils.CanditateUtil;
import utils.ContactUtil;

public class Program {

	public static void main(String[] args) {

		Double baseSalary = 2000.00;

		List<Candidate> candidatesList = CanditateUtil.createCandidatesList();

		List<Candidate> selectedCanditatesList = CanditateUtil.selectCandidates(candidatesList,baseSalary);
		
		for(Candidate candidate: selectedCanditatesList) {
			ContactUtil.contactCandidate(candidate);
		}

	}



}
