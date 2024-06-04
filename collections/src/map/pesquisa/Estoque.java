package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

	private Map<Long, Produto> produtos;

	public Estoque() {
		this.produtos = new HashMap<>();
	}

	public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
		produtos.put(cod, new Produto(nome, preco, quantidade));
	}
	
	public void exibirProdutos() {
		System.out.println(produtos);
	}
	
	public double calcularValorTotalEstoque() {
		double totalEstoque = 0.0;
		
		if(!produtos.isEmpty()) {
			for(Produto produto: produtos.values()) {
				totalEstoque += produto.getQuantidade() * produto.getPreco();
			}
			
		}
		return totalEstoque;
		
	}
	
	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		
		for(Produto produto: produtos.values()) {
			if(produto.getPreco() > maiorPreco) {
				produtoMaisCaro = produto;
				maiorPreco = produto.getPreco();
			}
		}
		
		return  produtoMaisCaro;
		
		
	}
	
	   public Produto obterProdutoMaisBarato() {
	        Produto produtoMaisBarato = null;
	        double menorPreco = Double.MAX_VALUE;

	        for (Produto produto : produtos.values()) {
	            if (produto.getPreco() < menorPreco) {
	                menorPreco = produto.getPreco();
	                produtoMaisBarato = produto;
	            }
	        }

	        return produtoMaisBarato;
	    }

	    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
	        Produto produtoMaiorQuantidadeValorTotal = null;
	        double maiorValorTotal = Double.MIN_VALUE;

	        for (Produto produto : produtos.values()) {
	            double valorTotal = produto.getPreco() * produto.getQuantidade();
	            if (valorTotal > maiorValorTotal) {
	                maiorValorTotal = valorTotal;
	                produtoMaiorQuantidadeValorTotal = produto;
	            }
	        }

	        return produtoMaiorQuantidadeValorTotal;
	    }
}
