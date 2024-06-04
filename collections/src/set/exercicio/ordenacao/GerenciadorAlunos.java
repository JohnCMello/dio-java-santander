package set.exercicio.ordenacao;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

	private Set<Aluno> alunos;

	public GerenciadorAlunos() {
		this.alunos = new LinkedHashSet<>();
	}

	public void exibirAlunos() {
		int ordemAlunos = 1;
		System.out.println("####################################");
		System.out.println("   *** Lista de alunos ***  ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		for (Aluno aluno : alunos) {
			System.out.print(" #" + ordemAlunos + " : " + aluno.getNome());
			System.out.println("\n_________________________");
			ordemAlunos++;
		}
		System.out.println("####################################\n\n");
	}

	public Aluno adicionarAluno(String nome, Long matricula, double nota) {
		Aluno aluno = new Aluno(nome, matricula, nota);
		alunos.add(aluno);
		return aluno;
	}

	public Aluno removerAluno(long matricula) {
		Aluno alunoRemover = null;

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula() == matricula) {
				alunoRemover = aluno;
				break;
			}
		}

		if (alunoRemover == null) {
			System.out.println("Matricula não encontrada");
			return null;
		}

		alunos.remove(alunoRemover);
		return alunoRemover;

	}

	public void exibirAlunosPorNome() {
		Set<Aluno> alunosOrdemAlfabetica = new TreeSet<>(alunos);

		int ordemAlunos = 1;
		System.out.println("####################################");
		System.out.println("   *** Lista de alunos em ordem alfabetica ***  ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		for (Aluno aluno : alunosOrdemAlfabetica) {
			System.out.print(" #" + ordemAlunos + " : " + aluno.getNome());
			System.out.println("\n_________________________");
			ordemAlunos++;
		}
		System.out.println("####################################\n\n");
	}

	public void exibirAlunosPorNota() {
		Set<Aluno> alunosOrdemNota = new TreeSet<>(new ComparatorPorNota());
		alunosOrdemNota.addAll(alunos);
		int ordemAlunos = 1;
		System.out.println("####################################");
		System.out.println("   *** Notas dos alunos ***  ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		for (Aluno aluno : alunosOrdemNota) {
			System.out.print(" #" + ordemAlunos + " : " + aluno.getNome());
			System.out.print("    " + aluno.getNota());
			System.out.println("\n_________________________");
			ordemAlunos++;
		}
		System.out.println("####################################\n\n");
	}

}
