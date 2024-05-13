package set.pesquisa;

import java.util.Objects;

import set.operacoesBasicas.Convidado;

public class Contato {

	private String nome;
	private int numero;

	public Contato(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return nome + " - " + numero ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contato contato))
			return false;
		return Objects.equals(getNome(), contato.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome());
	}

}
