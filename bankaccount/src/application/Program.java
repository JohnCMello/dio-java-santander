package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Integer accountNumber;
		String accountAgency, accountHolder;
		Double accountInitialBalance;

		System.out.println("Bem vindo ao banco Santander\n");

		System.out.println("Por favor, digite o numero da agencia. (XXX-X)");
		accountAgency = sc.nextLine();

		System.out.println("Por favor, digite o numero da conta. (Entre 0001 e 9999)");
		accountNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("Por favor, digite o nome completo. (Ex: Maria da Silva)");
		accountHolder = sc.nextLine();
		
		System.out.println("Por favor, digite o saldo inicia com o valor do centavos (EX 500,00)");
		accountInitialBalance = sc.nextDouble();
		
		Account newAccount = new Account(accountAgency,accountNumber,accountHolder,accountInitialBalance);
		
		
		System.out.println("\n"+newAccount);
		
		sc.close();
	}

}
