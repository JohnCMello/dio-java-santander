package set.OperacoesBasicas;

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

	public static void main(String[] args) {
		ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\nSelecione a opção:");
			System.out.println("1. Adicionar palavra");
			System.out.println("2. Remover palavra");
			System.out.println("3. Verificar palavra");
			System.out.println("4. Exibir palavras únicas");
			System.out.println("0. Sair");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite a palavra a ser adicionada:");
				String palavraAdicionar = scanner.nextLine();
				conjuntoPalavras.adicionarPalavra(palavraAdicionar);
				break;
			case 2:
				System.out.println("Digite a palavra a ser removida:");
				String palavraRemover = scanner.nextLine();
				conjuntoPalavras.removerPalavra(palavraRemover);
				break;
			case 3:
				System.out.println("Digite a palavra a ser verificada:");
				String palavraVerificar = scanner.nextLine();
				if (conjuntoPalavras.verificarPalavra(palavraVerificar)) {
					System.out.println("A palavra '" + palavraVerificar + "' está presente no conjunto.");
				} else {
					System.out.println("A palavra '" + palavraVerificar + "' não está presente no conjunto.");
				}
				break;
			case 4:
				conjuntoPalavras.exibirPalavrasUnicas();
				break;
			case 0:
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("Opção inválida. Por favor, selecione novamente.");
			}
		} while (opcao != 0);

		scanner.close();
	}

}
