package list.pesquisas;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

	private List<Livro> listaLivros;

	public CatalogoLivros() {
		this.listaLivros = new ArrayList<>();
	}

	public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
		listaLivros.add(new Livro(titulo, autor, anoPublicacao));
	}

	public List<Livro> pesquisarPorAutor(String autor) {
		List<Livro> livrosPorAutor = new ArrayList<>();
		if (!listaLivros.isEmpty()) {
			for (Livro livro : listaLivros) {
				if (livro.getAutor().equalsIgnoreCase(autor)) {
					livrosPorAutor.add(livro);
				}
			}
		}
		return livrosPorAutor;
	}

	public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
		List<Livro> livrosEntrePeriodo = new ArrayList<>();
		if (!listaLivros.isEmpty()) {
			for (Livro livro : listaLivros) {
				if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
					livrosEntrePeriodo.add(livro);
				}
			}
		}
		return livrosEntrePeriodo;
	}

	public Livro pesquisarPorTitulo(String titulo) {
		Livro livroPorTitulo = null;
		if (!listaLivros.isEmpty()) {
			for (Livro livro : listaLivros) {
				if (livro.getTitulo().equalsIgnoreCase(titulo)) {
					livroPorTitulo = livro;
					break;
				}
			}
		}
		return livroPorTitulo;
	}

}
