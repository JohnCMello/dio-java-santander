package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

	private List<Tarefa> listaTarefas;

	public ListaTarefa() {
		this.listaTarefas = new ArrayList<>();
	}

	public void adicionarTarefa(String descricao) {
		listaTarefas.add(new Tarefa(descricao));
	}

	public void removerTarefa(String descricao) {
		List<Tarefa> tarefasRemover = new ArrayList<>();

		for (Tarefa tarefa : listaTarefas) {
			if (tarefa.getDescription().equalsIgnoreCase(descricao)) {
				tarefasRemover.add(tarefa);
			}
		}

		listaTarefas.removeAll(tarefasRemover);
	}
	
	public int obterTotalTarefas() {
		return listaTarefas.size();
	}
	
	public void obterDescricoesTarefas() {
		System.out.println(listaTarefas);
	}

}
