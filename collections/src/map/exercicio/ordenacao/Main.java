package map.exercicio.ordenacao;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Livraria livraria = new Livraria();
		livraria.adicionarLivro("link1", "Livro 1", "Autor 1", 30.0);
		livraria.adicionarLivro("link2", "Livro 2", "Autor 2", 20.0);
		livraria.adicionarLivro("link3", "Livro 3", "Autor 1", 25.0);

		System.out.println("Livros ordenados por preço:");
		livraria.exibirLivrosOrdenadosPorPreco();

		System.out.println("\nLivros do Autor 1:");
		List<Livro> livrosAutor1 = livraria.pesquisarLivrosPorAutor("Autor 1");
		for (Livro livro : livrosAutor1) {
			System.out.println(
					"Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Preço: " + livro.getPreco());
		}

		System.out.println("\nLivro mais caro:");
		Livro maisCaro = livraria.obterLivroMaisCaro();
		if (maisCaro != null) {
			System.out.println("Título: " + maisCaro.getTitulo() + ", Autor: " + maisCaro.getAutor() + ", Preço: "
					+ maisCaro.getPreco());
		}

		System.out.println("\nLivro mais barato:");
		Livro maisBarato = livraria.exibirLivroMaisBarato();
		if (maisBarato != null) {
			System.out.println("Título: " + maisBarato.getTitulo() + ", Autor: " + maisBarato.getAutor() + ", Preço: "
					+ maisBarato.getPreco());
		}
	}
}
