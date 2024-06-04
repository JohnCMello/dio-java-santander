package map.exercicio.pesquisa;

public class Main {

	public static void main(String[] args) {
		ContagemPalavras contador = new ContagemPalavras();

		contador.adicionarPalavra("Java", 5);
		contador.adicionarPalavra("Python", 3);
		contador.adicionarPalavra("JavaScript", 8);
		contador.adicionarPalavra("C++", 4);
		contador.adicionarPalavra("Java", 2);

		contador.exibirContagemPalavras();

		contador.encontrarPalavraMaisFrequente();
		
		System.out.println("\n !!! Palavra removida - Python !!!");
		
		contador.removerPalavra("Python");

		contador.exibirContagemPalavras();

		contador.encontrarPalavraMaisFrequente();
		

	}

}
