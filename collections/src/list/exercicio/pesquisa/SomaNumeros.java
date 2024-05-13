package list.exercicio.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

	private List<Integer> numeros;

	public SomaNumeros() {
		this.numeros = new ArrayList<>();
	}

	public int adicionarNumero(int numero) {
		numeros.add(numero);
		return numeros.size();
	}

	public int calcularSoma() {
		int soma = 0;

		for (Integer numero : numeros) {
			soma += numero;
		}

		return soma;
	}

	public int encontrarMaiorNumero() {
		int maior = numeros.get(0);
		if (!numeros.isEmpty()) {
			for (int numero : numeros) {
				if (numero > maior) {
					maior = numero;
				}
			}
		}
		return maior;
	}

	public int encontrarMenorNumero() {
		int menor = numeros.get(0);
		for (int numero : numeros) {
			if (numero < menor) {
				menor = numero;
			}
		}
		return menor;
	}
	
	public List<Integer> exibirNumeros() {
        return new ArrayList<>(numeros);
    }

}
