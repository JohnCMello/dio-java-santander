package map.exercicio.ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Livraria {

	private Map<String, Livro> livraria;

	public Livraria() {
		this.livraria = new HashMap<>();
	}

	public void adicionarLivro(String link, String titulo, String autor, double preco) {
		Livro livro = new Livro(titulo, autor, preco);
		livraria.put(link, livro);
	}

	public void removerLivro(String titulo) {
		for (Iterator<Map.Entry<String, Livro>> iterator = livraria.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, Livro> entry = iterator.next();
			if (entry.getValue().getTitulo().equals(titulo)) {
				iterator.remove();
				break;
			}
		}
	}

	public void exibirLivrosOrdenadosPorPreco() {
		List<Livro> listaOrdenada = new ArrayList<>(livraria.values());
		listaOrdenada.sort(Comparator.comparingDouble(Livro::getPreco));
		for (Livro livro : listaOrdenada) {
			System.out.println(
					"Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Preço: " + livro.getPreco());
		}
	}

	public List<Livro> pesquisarLivrosPorAutor(String autor) {
		List<Livro> livrosAutor = new ArrayList<>();
		for (Livro livro : livraria.values()) {
			if (livro.getAutor().equals(autor)) {
				livrosAutor.add(livro);
			}
		}
		return livrosAutor;
	}

	public Livro obterLivroMaisCaro() {
		return livraria.values().stream().max(Comparator.comparingDouble(Livro::getPreco)).orElse(null);
	}

	public Livro exibirLivroMaisBarato() {
		return livraria.values().stream().min(Comparator.comparingDouble(Livro::getPreco)).orElse(null);
	}
}
