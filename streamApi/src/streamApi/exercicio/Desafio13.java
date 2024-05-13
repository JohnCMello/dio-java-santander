package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio13 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		int limiteInferior = 3;
		int limiteSuperior = 8;
		List<Integer> numerosNoIntervalo = numeros.stream().filter(n -> n >= limiteInferior && n <= limiteSuperior)
				.collect(Collectors.toList());
		
		System.out.println(
				"Números no intervalo [" + limiteInferior + ", " + limiteSuperior + "]: " + numerosNoIntervalo);

	}

}
