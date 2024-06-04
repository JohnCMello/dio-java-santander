package map.exercicio.pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ContagemPalavras {
	private Map<String, Integer> palavras;

	public ContagemPalavras() {
		palavras = new HashMap<>();
	}

	public void adicionarPalavra(String palavra, Integer contagem) {
		palavras.put(palavra, contagem);
	}

	public void removerPalavra(String palavra) {
		palavras.remove(palavra);
	}

	public void exibirContagemPalavras() {
		int contagemTotal = 0;
		System.out.println("\n###############################");
		System.out.println("   *** Lista de palavras ***\n");
		for (Entry<String, Integer> palavra : palavras.entrySet()) {
			System.out.println(palavra.getKey() + " - Contagem: " + palavra.getValue());
		}
		System.out.println("###############################\n");
	}

	public void encontrarPalavraMaisFrequente() {
		String palavraMaisFrequente = null;
		int maiorContagem = Integer.MIN_VALUE;
		for (String palavra : palavras.keySet()) {
			int contagem = palavras.get(palavra);
			if (contagem > maiorContagem) {
				maiorContagem = contagem;
				palavraMaisFrequente = palavra;
			}
		}
		System.out.println("Palava mais frequente: " + palavraMaisFrequente + " - Contagem: " + maiorContagem);
	}
}
