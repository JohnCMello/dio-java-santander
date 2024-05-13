package streamApi.functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ConsumerExample {

	public static void main(String[] args) {
// 		Criar uma lista de números inteiros
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// 		Usar o Consumer com expressão lambda para imprimir números pares
//		Consumer<Integer> imprimirNumeroPar = numero -> {
//			if (numero % 2 == 0) {
//				System.out.println(numero);
//			}
//		};

// 		Usar o Consumer para imprimir números pares no Stream
//		numeros.stream().forEach(imprimirNumeroPar);

//		numeros.stream().filter(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer n) {
//				return n % 2 == 0;
//			}
//
//		}).forEach(System.out::println);

		numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

	}

}
