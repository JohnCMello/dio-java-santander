package list.OperacoesBasicas;

public class OperacoesBasicas {

	public static void main(String[] args) {

		ListaTarefa listaTarefa = new ListaTarefa();
		
		System.out.println("### nenhuma tarefa adicionada\n");

		System.out.println("Total de tarefas: " + listaTarefa.obterTotalTarefas());
		
		System.out.println("\n### adiciona 5 tarefas\n");

		listaTarefa.adicionarTarefa("tarefa 1");
		listaTarefa.adicionarTarefa("tarefa 1");
		listaTarefa.adicionarTarefa("tarefa 2");
		listaTarefa.adicionarTarefa("tarefa 2");
		listaTarefa.adicionarTarefa("tarefa 3");
		
		listaTarefa.obterDescricoesTarefas();

		System.out.println("\nTotal de tarefas: " + listaTarefa.obterTotalTarefas());
		
		System.out.println("\n### remove 'tarefa 1', 2 ocorrencias\n");
		
		listaTarefa.removerTarefa("tarefa 1");
		
		listaTarefa.obterDescricoesTarefas();
		System.out.println("\nTotal de tarefas: " + listaTarefa.obterTotalTarefas());
		


		
		
	}

}
