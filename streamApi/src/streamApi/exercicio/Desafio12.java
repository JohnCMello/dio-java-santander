package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio12 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		long produto = numeros.stream().mapToLong(n -> n).reduce(1, (acc, curr) -> {
			return acc * curr;
		});
		
		System.out.println("Produto de todos os números: " + produto);

	}

}
