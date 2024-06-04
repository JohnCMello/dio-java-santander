package map.exercicio.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

	Map<String, String> dicionario;

	public Dicionario() {
		this.dicionario = new HashMap<>();
	}

	public void adicionarPalavra(String palavra, String definicao) {
		dicionario.put(palavra, definicao);
	}

	public void removerPalavra(String palavra) {
		if (!dicionario.isEmpty()) {
			dicionario.remove(palavra);
		}
	}

	public void exibirPalavras() {
		System.out.println(dicionario);
	}

	public String pesquisarPorPalavra(String palavra) {
		String definicao = null;
		if (!dicionario.isEmpty()) {
			definicao = dicionario.get(palavra);
		}
		return definicao;
	}
}
