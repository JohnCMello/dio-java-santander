package set.exercicio.operacoesBasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

	private Set<String> conjunto;

	public ConjuntoPalavrasUnicas() {
		this.conjunto = new HashSet<>();
	}

	public void adicionarPalavra(String palavra) {
		if (!verificarPalavra(palavra)) {
			conjunto.add(palavra);
		} else {
			System.out.println("A palavra '" + palavra + "' já existe no conjunto.");
		}
	}

	public void removerPalavra(String palavra) {
		conjunto.remove(palavra);
	}

	public boolean verificarPalavra(String palavra) {
		return conjunto.contains(palavra);
	}

	public void exibirPalavrasUnicas() {
		for (String palavra : conjunto) {
			System.out.println(palavra);
		}
	}


}
