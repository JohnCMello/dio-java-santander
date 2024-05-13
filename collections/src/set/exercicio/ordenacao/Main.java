package set.exercicio.ordenacao;

public class Main {

	public static void main(String[] args) {

		GerenciadorAlunos gerenciador = new GerenciadorAlunos();

		gerenciador.adicionarAluno("Julia", 987654321L, 8.2);
		gerenciador.adicionarAluno("Cacau", 456789123L, 9.8);
		gerenciador.adicionarAluno("John", 123456789L, 7.5);

		
		gerenciador.exibirAlunosPorNome();
		
		gerenciador.exibirAlunosPorNota();
	
		gerenciador.exibirAlunos();
	}

}
