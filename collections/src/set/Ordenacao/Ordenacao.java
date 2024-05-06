package set.Ordenacao;

public class Ordenacao {

	public static void main(String[] args) {
		
		CadastroProdutos cadastroProdutos = new CadastroProdutos();
		
		cadastroProdutos.adicionarProduto(3L, "Produto 3", 8d, 25);
		cadastroProdutos.adicionarProduto(2L, "Produto 2", 5d, 10);
		cadastroProdutos.adicionarProduto(4L, "Produto 4", 7.5, 30);
		cadastroProdutos.adicionarProduto(2L, "Produto 5", 5.5, 20);
		cadastroProdutos.adicionarProduto(1L, "Produto 1", 10d, 5);
		
		System.out.println(cadastroProdutos.produtos);
		
		System.out.println(cadastroProdutos.exibirProdutosPorNome());
		
		System.out.println(cadastroProdutos.exibirProdutosPorPreco());
		
		
		

	}


}
