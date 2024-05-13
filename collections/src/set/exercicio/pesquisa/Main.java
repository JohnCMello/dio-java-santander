package set.exercicio;

public class Main {

	public static void main(String[] args) {

		ListaTarefas listaTarefas = new ListaTarefas();

		System.out.println("   *** 3 tarefas adicionadas ***\n");
		listaTarefas.adicionarTarefa("Ir ao supermercado");
		listaTarefas.adicionarTarefa("Estudar Java");
		listaTarefas.adicionarTarefa("Passear com a Cacau");

		listaTarefas.exibirTarefas();

		System.out.println("\n   *** Limpando as tarefas ***\n");
		listaTarefas.limparListaTarefas();

		listaTarefas.exibirTarefas();

		System.out.println("\n   *** 3 tarefas adicionadas novamente ***\n");
		listaTarefas.adicionarTarefa("Ir ao supermercado");
		listaTarefas.adicionarTarefa("Estudar Java");
		listaTarefas.adicionarTarefa("Passear com a Cacau");
		
		listaTarefas.exibirTarefas();

		System.out.println("\n   *** Editando Status de uma tarefa para concluída ***\n");

		listaTarefas.marcarTarefaConcluida("Estudar Java");

		listaTarefas.exibirTarefas();

		System.out.println("\n   *** Editando Status de outra tarefa para concluída ***\n");

		listaTarefas.marcarTarefaConcluida("Passear com a Cacau");
		
		listaTarefas.exibirTarefas();
		
		System.out.println("\n   *** Editando Status de uma tarefa para pendente ***\n");
		
		listaTarefas.marcarTarefaPendente("Estudar Java");

		listaTarefas.exibirTarefas();
	}

}
