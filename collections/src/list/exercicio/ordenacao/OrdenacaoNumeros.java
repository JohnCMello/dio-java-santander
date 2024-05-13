package list.exercicio.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrdenacaoNumeros {

	private List<Integer> numeros;

	public OrdenacaoNumeros() {
		this.numeros = new ArrayList<>();
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void adicionarNumero(int numero) {
		numeros.add(numero);
	}

	public List<Integer> ordenarAscendente() {
		List<Integer> numerosAscendente = new ArrayList<>(numeros);
		Collections.sort(numerosAscendente);
		return numerosAscendente;
	}

	public List<Integer> ordenarDescendente() {
		List<Integer> numerosDescendente = new ArrayList<>(numeros);
//		Collections.sort(numeros, Collections.reverseOrder());
		Collections.sort(numerosDescendente);
		return numerosDescendente.reversed();
	}

}
