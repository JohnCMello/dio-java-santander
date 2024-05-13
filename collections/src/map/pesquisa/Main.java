package map.pesquisa;

public class Main {

	public static void main(String[] args) {
		Estoque estoque = new Estoque();

        estoque.adicionarProduto(123L, "Produto A", 10, 25.0);
        estoque.adicionarProduto(456L, "Produto B", 5, 15.0);
        estoque.adicionarProduto(789L, "Produto C", 20, 10.0);

        System.out.println("Produtos no estoque:");
        estoque.exibirProdutos();

        double valorTotal = estoque.calcularValorTotalEstoque();
        System.out.println("\nValor total do estoque: " + valorTotal);
     
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("\nProduto mais caro: " + produtoMaisCaro.getNome() + " - Preço: " + produtoMaisCaro.getPreco());
   
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato.getNome() + " - Preço: " + produtoMaisBarato.getPreco());
     
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor total no estoque: " + produtoMaiorQuantidadeValorTotal.getNome() +
                " - Quantidade: " + produtoMaiorQuantidadeValorTotal.getQuantidade() +
                ", Valor total: " + produtoMaiorQuantidadeValorTotal.getPreco() * produtoMaiorQuantidadeValorTotal.getQuantidade());
    

	}

}
