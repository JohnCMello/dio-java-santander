package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio19 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

		int soma = numeros.stream().filter(n -> n % 3 == 0 && n % 5 == 0).reduce(0, Integer::sum);

//		int soma = numeros.stream().filter(n -> n % 3 == 0 && n % 5 == 0).mapToInt(Integer::intValue).sum();

		System.out.println("Soma dos números divisíveis por 3 e 5: " + soma);

	}

}
