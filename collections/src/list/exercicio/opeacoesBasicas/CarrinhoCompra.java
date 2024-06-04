package list.exercicio.opeacoesBasicas;

import java.util.ArrayList;
import java.util.List;

import list.operacoesBasicas.Tarefa;

public class CarrinhoCompra {

	private List<Item> itemsLista;

	public CarrinhoCompra() {
		this.itemsLista = new ArrayList<>();
	}

	public void adicionarItem(String nome, double preco, int quantidade) {
		itemsLista.add(new Item(nome, preco, quantidade));
	}

	public void removerItem(String nome) {
		List<Item> itemsRemover = new ArrayList<>();

		for (Item item : itemsLista) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				itemsRemover.add(item);
			}
		}
		itemsLista.removeAll(itemsRemover);
	}

	public double calcularValorTotalCarrinho() {
        double total = 0.0;
        for (Item item : itemsLista) {
            total += item.calcularValorTotalItem();
        }
        return total;
    }

	public void exibirItens() {
		if(itemsLista.size() == 0) {
			System.out.println("Nenhum item na lista\n");
			return;
		}
		for (Item item: itemsLista) {
			System.out.println(item.toString() + " Total: $" + String.format("%.2f",item.calcularValorTotalItem()) +"\n");
		}
	}

}
