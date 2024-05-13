package map.exercicio.operacoesBasicas;

public class Main {

	public static void main(String[] args) {
		Dicionario dicionario = new Dicionario();

		dicionario.adicionarPalavra("Java", "Uma linguagem de programação");
		dicionario.adicionarPalavra("Python", "Outra linguagem de programação");
		dicionario.adicionarPalavra("HTML", "Linguagem de marcação");

		dicionario.exibirPalavras();

		String definicao = dicionario.pesquisarPorPalavra("Java");
		if (definicao != null) {
			System.out.println("\nDefinição de Java: " + definicao);
		} else {
			System.out.println("Palavra não encontrada no dicionário");
		}

		dicionario.removerPalavra("Python");
		System.out.println("\nDicionário após remover Python:");
		dicionario.exibirPalavras();

	}

}
