package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio08 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(123, 456, 789, 741, 852, 963);
		int somaDigitos = numeros.stream()
				.mapToInt(num -> Integer.toString(num).chars().map(Character::getNumericValue).sum()).sum();
		System.out.println("A soma dos dígitos de todos os números é: " + somaDigitos);
	}

}
