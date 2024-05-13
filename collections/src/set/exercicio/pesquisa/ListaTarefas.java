package set.exercicio;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

	Set<Tarefa> tarefas = new HashSet<>();

	public void adicionarTarefa(String descricao) {
		tarefas.add(new Tarefa(descricao));
	}

	public Tarefa removerTarefa(String descricao) {
		Tarefa tarefaRemovida = null;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getDescricao() == descricao) {
				tarefaRemovida = tarefa;
				break;

			}
		}
		tarefas.remove(tarefaRemovida);
		return tarefaRemovida;
	}

	public void exibirTarefas() {
		if (!tarefas.isEmpty()) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			int listOrder = 1;
			for (Tarefa tarefa : tarefas) {
							System.out.println("#" + listOrder + " - " + tarefa.toString());
				System.out.println("_________________");

				listOrder++;
			}
			System.out.println("\nTotal de tarefas: " + this.contarTarefas());
			System.out.println("***********************************");
			
			System.out.println("\nTotal de tarefas concluídas: " + this.obterTarefasConcluidas().size());
			listOrder = 1;
			for (Tarefa tarefa : this.obterTarefasConcluidas()) {
			
				System.out.println("#" + listOrder + " - " + tarefa.toString());
				System.out.println("_________________");
				listOrder++;
			}

			System.out.println("***********************************");
			System.out.println("\nTotal de tarefas pendentes: " + this.obterTarefasPendentes().size());
			listOrder = 1;
			for (Tarefa tarefa : this.obterTarefasPendentes()) {
				
				System.out.println("#" + listOrder + " - " + tarefa.toString());
				System.out.println("_________________");
				listOrder++;
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			return;
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Nenhuma tafera");
		System.out.println("\nTotal de tarefas: " + this.contarTarefas());
		System.out.println("\nTotal de tarefas concluídas: " + this.obterTarefasConcluidas().size());
		System.out.println("\nTotal de tarefas pendentes: " + this.obterTarefasPendentes().size());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

	public int contarTarefas() {
		return tarefas.size();
	}

	public Set<Tarefa> obterTarefasConcluidas() {
		Set<Tarefa> tarefasConcluidas = new HashSet<>();

		for (Tarefa tarefa : tarefas) {
			if (tarefa.isConcluida()) {
				tarefasConcluidas.add(tarefa);
			}
		}
		return tarefasConcluidas;

	}

	public Set<Tarefa> obterTarefasPendentes() {
		Set<Tarefa> tarefasPendentes = new HashSet<>();

		for (Tarefa tarefa : tarefas) {
			if (!tarefa.isConcluida()) {
				tarefasPendentes.add(tarefa);
			}
		}
		return tarefasPendentes;

	}

	public Tarefa marcarTarefaConcluida(String descricao) {
		Tarefa tarefaConcluida = null;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getDescricao().contentEquals(descricao)) {
				tarefa.setConcluida(true);
				tarefaConcluida = tarefa;
				break;
			}
		}
		return tarefaConcluida;
	}

	public Tarefa marcarTarefaPendente(String descricao) {
		Tarefa tarefaPendente = null;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getDescricao().contentEquals(descricao) && tarefa.isConcluida()) {
				tarefa.setConcluida(false);
				tarefaPendente = tarefa;
				break;
			}
		}
		return tarefaPendente;
	}

	public void limparListaTarefas() {
		tarefas.removeAll(tarefas);
	}

}
