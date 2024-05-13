package streamApi.exercicio;

import java.util.Arrays;
import java.util.List;

public class Desafio09 {

	public static void main(String[] args) {
//		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
        boolean saoDistintos = numeros.stream()
                                     .distinct()
                                     .count() == numeros.size();
        
        if(saoDistintos) {
        	System.out.println("Todos os números da lista são distintos");
        	return;
        }
        System.out.println("Algum número da lista se repete");

	}

}
