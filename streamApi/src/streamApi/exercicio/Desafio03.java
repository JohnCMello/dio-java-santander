package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio03 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
//		List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		boolean todosPositivos = numeros.stream().allMatch(n-> n>0);
		if(todosPositivos) {
			System.out.println("Todos os números são positivos.");
			return;
		}
		System.out.println("Existe algum número negativo na lista");

	}

}
