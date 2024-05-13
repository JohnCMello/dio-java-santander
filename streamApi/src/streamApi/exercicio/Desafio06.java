package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio06 {

	public static void main(String[] args) {
//		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 5, 4, 3);
		boolean contemMaiorQue10 = numeros.stream().anyMatch(n -> n > 10);

		if (contemMaiorQue10) {
			System.out.println("A lista contém algum número maior que 10.");
			return;
		}
		System.out.println("A lista não contém números maiores que 10.");

	}

}
