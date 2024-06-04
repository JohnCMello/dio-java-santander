package set.exercicio.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private long matricula;
	private double nota;

	public Aluno(String nome, long matricula, double nota) {
		this.nome = nome;
		this.matricula = matricula;
		this.nota = nota;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public long getMatricula() {
		return matricula;
	}

	@Override
	public int compareTo(Aluno aluno) {
		return nome.compareToIgnoreCase(aluno.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMatricula());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Aluno aluno))
			return false;
		return getMatricula() == aluno.getMatricula();
	}
	

}

class ComparatorPorNota implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return Double.compare(a1.getNota(), a2.getNota());
	}

}
