package digitalbank.utils;

import java.util.Scanner;

import digitalbank.entities.Customer;
import digitalbank.exceptions.InvalidMenuOptionException;
import digitalbank.exceptions.InvalidSocialNumberException;

public class Utils {

	public static final String SAVINGS_ACCOUNT_OPTION = "P";
	public static final String CHECKING_ACCOUNT_OPTION = "C";
	public static final String YES_OPTION = "S";
	public static final String NO_OPTION = "N";

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void displayMenu() {
		System.out.println("######################################");
		System.out.println("  ***  Bem-vindo ao nosso banco  ***");
		System.out.println("######################################\n");
		System.out.println(">>> Selecione uma opcao:\n");
		System.out.println("1 - Criar nova conta.");
		System.out.println("2 - Acessar uma conta.");
		System.out.println("3 - Remover uma conta.");
		System.out.println("4 - Verificar uma conta.");
		System.out.println("5 - Listar todas as contas");
		System.out.println("6 - Listar todas as contas de um cliente.");
		System.out.println("7 - Saldo total de um cliente.");
		System.out.println("8 - Transferir fundos.");
		System.out.println("0 - Encerrar programa.");
		System.out.println("\n######################################");
	}

	public static int getValidMenuOption(Scanner sc) throws InvalidMenuOptionException {
		System.out.print("Digite a opcao desejada: ");
		String input = sc.nextLine();

		try {
			int option = Integer.parseInt(input);
			if (option >= 0 && option <= 8) {
				return option;
			} else {
				throw new InvalidMenuOptionException("Opcao invalida. Por favor, selecione uma opcao entre 0 e 8.");
			}
		} catch (NumberFormatException e) {
			throw new InvalidMenuOptionException("Entrada invalida. Por favor, digite um numero.");
		}
	}

	public static Customer getCustomerData(Scanner sc) throws InvalidSocialNumberException {
		int socialNumberLength = 11;
		String name, socialNumber = null;
		boolean validSocialNumber = false;

		System.out.println("\nInforme os dados do cliente:\n");

		System.out.print("Nome completo do titular da conta: ");
		name = sc.nextLine();

		do {
			try {
				System.out.print("CPF do titular: ");
				socialNumber = sc.nextLine();

				if (socialNumber.length() != socialNumberLength || !socialNumber.matches("\\d+")) {
					throw new InvalidSocialNumberException(
							"CPF invalido: O CPF deve ter exatamente 11 digitos numericos.");
				}
				validSocialNumber = true;
			} catch (InvalidSocialNumberException e) {
				clearScreen();
				System.out.println(e.getMessage());
				System.out.println("Por favor, tente novamente.\n");
			}
		} while (!validSocialNumber);

		return new Customer(name, socialNumber);
	}

	public static String getCustomerSocialNumber(Scanner sc) {
		String socialNumber;
		do {
			System.out.println("CPF do titular - 11 numeros: ");
			socialNumber = sc.nextLine();
		} while (socialNumber.length() != 11 || !socialNumber.matches("\\d+"));

		return socialNumber;
	}

	public static String getAccountType(Scanner sc) throws InvalidMenuOptionException {
		String accountType = null;
		boolean isValidOption = false;
		do {
			try {
				System.out.println("\nQual o tipo da conta? Digite uma opcao.");
				System.out.println("P - Poupanca.");
				System.out.println("C - Corrente.");
				accountType = sc.nextLine().toUpperCase();

				if (!accountType.equals(CHECKING_ACCOUNT_OPTION) && !accountType.equals(SAVINGS_ACCOUNT_OPTION)) {
					throw new InvalidMenuOptionException(
							"Tipo de conta invalido, C para conta corrente ou P para conta poupanca");
				}

				isValidOption = true;
			} catch (InvalidMenuOptionException e) {
				clearScreen();
				System.out.println(e.getMessage());
				System.out.println("Por favor, tente novamente.\n");
			}
		} while (!isValidOption);

		return accountType;
	}

	public static double getInterestRate(Scanner sc) {
		double interestRate;
		System.out.println("\nDigite a taxa de juros:");
		interestRate = sc.nextDouble();
		sc.nextLine();
		return interestRate;
	}

	public static double getOverdraftLimit(Scanner sc) {
		double overdraftLimit;
		System.out.println("\nDigite o valor do limite do cheque especial:");
		overdraftLimit = sc.nextDouble();
		return overdraftLimit;
	}

	public static String getInitialDepositOption(Scanner sc) {
		String initialDepositOption;
		do {
			System.out.println("\nDeposito inicial? Digite uma opcao.");
			System.out.println("S - Sim.");
			System.out.println("N - Nao.");
			initialDepositOption = sc.nextLine().toUpperCase();
			if (initialDepositOption == NO_OPTION) {
				clearScreen();
				return initialDepositOption;

			}
		} while (!initialDepositOption.equals(YES_OPTION) && !initialDepositOption.equals(NO_OPTION));
		return initialDepositOption;
	}

	public static double getInitialDepositAmount(Scanner sc) {
		double initialDeposit;
		System.out.println("\nDigite o valor do deposito:");
		initialDeposit = sc.nextDouble();
		sc.nextLine();
		return initialDeposit;

	}

	public static boolean askToReturnToMainMenu(Scanner sc) {
		String returnToMenuOption;
		boolean returnToMainMenu = false;

		do {
			System.out.println("\nDeseja retornar ao menu principal? (S/N)");
			returnToMenuOption = sc.nextLine().toUpperCase();
			if (returnToMenuOption.equals(YES_OPTION)) {
				returnToMainMenu = true;
				break;
			}
		} while (!returnToMenuOption.equals(YES_OPTION) && !returnToMenuOption.equals(NO_OPTION));

		return returnToMainMenu;
	}

	public static void displayError(Exception e) {
		System.out.println("Erro: " + e.getMessage());
	}
}
