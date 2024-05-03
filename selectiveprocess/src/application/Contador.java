package application;

import java.util.Scanner;

import exceptions.ParametrosInvalidosException;

public class Contador {

	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();

		try {
			// chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);

		} catch (ParametrosInvalidosException exception) {
			System.out.println(exception.getMessage());
		}

	}

	static void contar(int parametroUm, int parametroDois) {
		// validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		if (parametroUm > parametroDois) {
			throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
		}
		int contagem = parametroDois - parametroUm;

//		realizar o for para imprimir os números com base na variável contagem
		for (int i = 0; i < contagem; i++) {
			System.out.println("Imprimindo o número " + (i + 1));
		}
	}

//		static void contar(int parametroUm, int parametroDois) {
////			validar se parametroUm é MAIOR que parametroDois e lançar a exceção
//			if (parametroUm > parametroDois) {
//				throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
//			}
//
//			
////			realizar o for para imprimir os números com base nas variáveis parametroUm e parametroDois
//			System.out.println("Imprimindo os numeros de " + parametroUm + " a " + parametroDois);
//			for (int i = parametroUm; i <= parametroDois; i++) {
//				System.out.println("Imprimindo o número " + (i));
//			}
//		
//		}

}
