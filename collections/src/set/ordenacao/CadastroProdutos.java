package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
	
	Set<Produto> produtos;
	
	public CadastroProdutos() {
		this.produtos = new HashSet<>();
	}
	
	
	public Set<Produto> getProdutos() {
		return produtos;
	}


	public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
		produtos.add(new Produto(nome, cod, preco, quantidade));
	}
	
	public Set<Produto> exibirProdutosPorNome(){
		Set<Produto> produtosProNome = new TreeSet<>(produtos);
		return produtosProNome;
	}
	
	public Set<Produto>  exibirProdutosPorPreco(){
		Set<Produto> produtosProPreco = new TreeSet<>(new ComparatorPorPreco());
		produtosProPreco.addAll(produtos);
		return produtosProPreco;
	}
}
