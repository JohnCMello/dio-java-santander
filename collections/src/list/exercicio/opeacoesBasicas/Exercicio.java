package list.exercicio.opeacoesBasicas;

import java.util.Locale;

public class Exercicio {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.exibirItens();

		System.out.println("    *** ADICIONANDO ITEMS AO CARRINHO ***\n");

		carrinho.adicionarItem("Tênis Nike", 649.99, 2);
		carrinho.adicionarItem("Camiseta Adidas", 89.99, 3);
		carrinho.adicionarItem("Meia Cano Curto", 45.59, 4);
		carrinho.adicionarItem("Short Compressão", 199.00, 1);

		carrinho.exibirItens();

		System.out.println("Total do Carrinho: $" + String.format("%.2f",carrinho.calcularValorTotalCarrinho()));

		System.out.println("\n   *** REMOVENDO ITEMS DO CARRINHO ***\n");
		System.out.println("__ Tenis Nike / Meia Cano Curto Exercicio__ \n");

		carrinho.removerItem("Tênis Nike");
		carrinho.removerItem("Meia Cano Curto");

		carrinho.exibirItens();

		System.out.println("Total do Carrinho: $" + String.format("%.2f",carrinho.calcularValorTotalCarrinho()));

	}

}
