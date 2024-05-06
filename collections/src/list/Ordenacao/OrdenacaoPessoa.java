package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {

	private List<Pessoa> pessoasLista;

	public OrdenacaoPessoa() {
		this.pessoasLista = new ArrayList<>();
	}
	
	

	public List<Pessoa> getPessoasLista() {
		return pessoasLista;
	}



	public void adicionarPessoa(String nome, int idade, double altura) {
		pessoasLista.add(new Pessoa(nome, idade, altura));
	}

	public List<Pessoa> ordenarPorIdade() {
		List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoasLista);
		Collections.sort(pessoasPorIdade);
		return pessoasPorIdade;
	}

	public List<Pessoa> ordenarPorAltura() {
		List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoasLista);
		Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
		return pessoasPorAltura;
	}

}
