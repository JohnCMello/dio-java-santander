package list.Pesquisas;

public class Pesquisas {

	public static void main(String[] args) {
		CatalogoLivros catalogoLivros= new CatalogoLivros();
		
		catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
		catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
		catalogoLivros.adicionarLivro("Livro 2", "Autor 3", 2022);
		catalogoLivros.adicionarLivro("Livro 3", "Autor 1", 2023);
		catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 2010);
		catalogoLivros.adicionarLivro("Livro 5", "Autor 5", 2019);
		catalogoLivros.adicionarLivro("Livro 6", "Autor 6", 2005);
		
		System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
		System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2005,2020));
		System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
		
	}

}
