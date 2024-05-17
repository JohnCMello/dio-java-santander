package digitalbank.entities;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import digitalbank.enums.AccountType;
import digitalbank.exceptions.AccountNotFoundException;
import digitalbank.exceptions.InvalidMenuOptionException;
import digitalbank.exceptions.InvalidSocialNumberException;

public class BankManager {
	private static final String SAVINGS_ACCOUNT_OPTION = "P";
	private static final String CHECKING_ACCOUNT_OPTION = "C";
	private static final String YES_OPTION = "S";
	private static final String NO_OPTION = "N";

	public void run() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		boolean isRunning = true;
		boolean isFirstLoad = true;
		int option;
	
		do {
			displayMenu();
			if(isFirstLoad) {
				isFirstLoad=false;
				clearScreen();
				displayMenu();
			}
			try {
				option = getValidMenuOption(sc);
			} catch (InvalidMenuOptionException e) {
				clearScreen();
				System.out.println(e.getMessage());
				option = -1;
			}

			switch (option) {
			case 1: {
				String accountType, initialDepositOption;
				boolean isSavingsAccount = false;
				boolean hasInitialDeposit = false;
				boolean returnToMainMenu = false;
				double initialDepositAmount = 0d;
				double interestRateValue = 0d;
				double overdraftLimit = 0d;

				Account account;
				Customer customer;
				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("   *** Criar uma conta Conta ***      ");
					System.out.println("######################################\n");

					customer = getCustomerData(sc);

					accountType = getAccountType(sc);

					if (accountType.equals(SAVINGS_ACCOUNT_OPTION)) {
						isSavingsAccount = true;
						interestRateValue = getInterestRate(sc);
					} else {
						overdraftLimit = getOverdraftLimit(sc);
						sc.nextLine();
					}

					initialDepositOption = getInitialDepositOption(sc);

					if (initialDepositOption.equals(YES_OPTION)) {
						hasInitialDeposit = true;
						initialDepositAmount = getInitialDepositAmount(sc);
					}

					if (isSavingsAccount) {
						account = hasInitialDeposit
								? new SavingsAccount(customer, initialDepositAmount, interestRateValue)
								: new SavingsAccount(customer, interestRateValue);
						bank.addAccount(customer.getSocialNumber(), account);

						System.out.println("\n######################################");
						System.out.println("   *** Conta criada com sucesso ***   ");
						System.out.println("######################################\n");

						returnToMainMenu = askToReturnToMainMenu(sc);

						if (returnToMainMenu) {
							clearScreen();
							break;
						}
					}

					account = hasInitialDeposit ? new CheckingAccount(customer, initialDepositAmount, overdraftLimit)
							: new CheckingAccount(customer, overdraftLimit);
					bank.addAccount(customer.getSocialNumber(), account);

					System.out.println("\n######################################");
					System.out.println("   *** Conta criada com sucesso ***   ");
					System.out.println("######################################\n");

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}

				} catch (Exception e) {
					displayError(e);
					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}
			}
			case 2: {
				String accountType, socialNumber;
				boolean isSavingsAccount = false;
				boolean returnToMainMenu = false;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("        *** Acessar Conta ***         ");
					System.out.println("######################################\n");

					accountType = getAccountType(sc);

					isSavingsAccount = accountType.equals(SAVINGS_ACCOUNT_OPTION);

					socialNumber = getCustomerSocialNumber(sc);

					Account account = bank.getAccountByCustomerSocialNumber(socialNumber,
							isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING);

					clearScreen();
					System.out.println("######################################");
					System.out.println("       *** Dados da Conta ***         ");
					System.out.println("######################################\n");
					System.out.println(account);

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}

				} catch (Exception e) {
					displayError(e);

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}
			}
			case 3: {
				String accountType, socialNumber, removeAccountConfirmationOption;
				boolean isSavingsAccount = false;
				boolean returnToMainMenu = false;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("        *** Remover Conta ***         ");
					System.out.println("######################################\n");

					accountType = getAccountType(sc);

					isSavingsAccount = accountType.equals(SAVINGS_ACCOUNT_OPTION);

					socialNumber = getCustomerSocialNumber(sc);

					clearScreen();

					do {
						System.out.println("\nConfirma remover conta? (S/N)");
						removeAccountConfirmationOption = sc.nextLine().toUpperCase();

						if (removeAccountConfirmationOption.equals(NO_OPTION)) {
							do {
								returnToMainMenu = askToReturnToMainMenu(sc);

							} while (!returnToMainMenu);

							if (returnToMainMenu)
								clearScreen();
								break;

						}
					} while (!removeAccountConfirmationOption.equals(YES_OPTION)
							&& !removeAccountConfirmationOption.equals(NO_OPTION));

					if (returnToMainMenu) {
						clearScreen();
						break;
					}

					Account removedAccount = bank.removeAccount(socialNumber,
							isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING);

					clearScreen();
					System.out.println("######################################");
					System.out.println(" *** Conta removida com sucesso  *** ");
					System.out.println("######################################\n");

					System.out.println(">>> Detalhes da conta: \n");
					System.out.println(removedAccount);

					returnToMainMenu = askToReturnToMainMenu(sc);
					if (returnToMainMenu) {
						clearScreen();
						break;
					}

				} catch (Exception e) {
					displayError(e);

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}

			}
			case 4: {
				boolean returnToMainMenu = false;
				String accountType;
				boolean isSavingsAccount = false;
				List<Account> accounts;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("        *** Listar Contas ***       ");
					System.out.println("######################################\n");

					accountType = getAccountType(sc);

					isSavingsAccount = accountType.equals(SAVINGS_ACCOUNT_OPTION);

					accounts = bank.getAllAccountsByType(isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING);

					if (accounts.size() == 0) {
						System.out.println(
								"\nTotals de contas " + (isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING)
										+ ": " + accounts.size());
						returnToMainMenu = askToReturnToMainMenu(sc);

						if (returnToMainMenu) {
							clearScreen();
							break;
						}
					}
					
					System.out.println(
							"\nTotals de contas " + (isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING)
									+ ": " + accounts.size());
					System.out.println("######################################\n");
					
					for (Account account : accounts) {
						System.out.println(account);
					}

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());

					returnToMainMenu = askToReturnToMainMenu(sc);
					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}
			}
			case 5: {
				String socialNumber;
				boolean returnToMainMenu = false;
				List<Account> customerAccounts;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("  *** Contas de um unico cliente ***  ");
					System.out.println("######################################\n");

					socialNumber = getCustomerSocialNumber(sc);

					customerAccounts = bank.getAllAccountsBySocialNumber(socialNumber);

					for (Account account : customerAccounts) {
						System.out.println(account);
					}

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				} catch (Exception e) {
					displayError(e);

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}
			}
			case 6: {
				String socialNumber;
				boolean returnToMainMenu = false;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("  *** Saldo total de um cliente ***   ");
					System.out.println("######################################\n");

					socialNumber = getCustomerSocialNumber(sc);

					double totalBalance = bank.getTotalBalance(socialNumber);
					List<Account> customerAccounts = bank.getAllAccountsBySocialNumber(socialNumber);

					Account accountData = customerAccounts.get(0);

					clearScreen();
					System.out.println(" >>> Dados da conta: \n");
					System.out.println("Titular: " + accountData.getCustomer().getName());
					System.out.println("CPF : " + accountData.getCustomer().getSocialNumber());
					System.out.println();
					System.out.println("Tipos de conta:");

					for (int i = 0; i < customerAccounts.size(); i++) {
						System.out.println("" + (i + 1) + " - " + customerAccounts.get(i).getType().toString());
					}

					System.out.println("\nSaldo Total nas duas contas R$: " + totalBalance + "\n");

					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}

				} catch (Exception e) {
					displayError(e);
					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}
			}
			case 7: {
				String sourceSocialNumber, targetSocialNumber, sourceAccountType, targetAccountType;
				boolean returnToMainMenu = false;
				boolean isSavingsAccount = false;
				double transferAmount = 0d;

				try {
					clearScreen();
					System.out.println("######################################");
					System.out.println("       *** Transferir fundos ***      ");
					System.out.println("######################################\n");

					System.out.println("Digite o CPF da conta de origem: ");

					sourceSocialNumber = getCustomerSocialNumber(sc);
					sourceAccountType = getAccountType(sc);
					isSavingsAccount = sourceAccountType.equals(SAVINGS_ACCOUNT_OPTION);

					Account sourceAccount = bank.getAccountByCustomerSocialNumber(sourceSocialNumber,
							isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING);

					System.out.println("Digite o CPF da conta de destino: ");
					targetSocialNumber = getCustomerSocialNumber(sc);
					targetAccountType = getAccountType(sc);
					isSavingsAccount = targetAccountType.equals(SAVINGS_ACCOUNT_OPTION);

					Account targetAccount = bank.getAccountByCustomerSocialNumber(targetSocialNumber,
							isSavingsAccount ? AccountType.SAVINGS : AccountType.CHECKING);

					System.out.println("Digite o valor da tranferencia:");
					transferAmount = sc.nextDouble();
					sc.nextLine();

					clearScreen();
					System.out.println("  *** Detalhes da transferencia ***\n");
					System.out.println("Depositante:");
					System.out.println("Conta do tipo: " + sourceAccountType);
					System.out.println("Titular: " + sourceAccount.getCustomer().getName());
					System.out.println();
					System.out.println("Beneficiario:");
					System.out.println("Conta do tipo: " + targetAccountType);
					System.out.println("Titular: " + targetAccount.getCustomer().getName());

					String confirmTranfer;
					do {
						System.out.println("\nConfirmar Transferencia?");
						System.out.println("S - Sim.");
						System.out.println("N - Nao.");
						confirmTranfer = sc.nextLine().toUpperCase();

					} while (!confirmTranfer.equals(YES_OPTION) && !confirmTranfer.equals(NO_OPTION));

					if (confirmTranfer == NO_OPTION) {
						returnToMainMenu = askToReturnToMainMenu(sc);
						if (returnToMainMenu) {
							clearScreen();
							break;
						}

					}

					bank.transferFunds(sourceAccount, targetAccount, transferAmount);

					returnToMainMenu = askToReturnToMainMenu(sc);
					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				} catch (Exception e) {
					displayError(e);
					returnToMainMenu = askToReturnToMainMenu(sc);

					if (returnToMainMenu) {
						clearScreen();
						break;
					}
				}

			}
			case 0: {
				isRunning = false;
				break;
			}

			}
		} while (isRunning);

	}

	static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static void displayMenu() {
		System.out.println("######################################");
		System.out.println("  ***  Bem-vindo ao nosso banco  ***");
		System.out.println("######################################\n");
		System.out.println(">>> Selecione uma opcao:\n");
		System.out.println("1 - Criar nova conta.");
		System.out.println("2 - Acessar uma conta.");
		System.out.println("3 - Remover uma conta.");
		System.out.println("4 - Listar todas as contas");
		System.out.println("5 - Listar todas as contas de um cliente.");
		System.out.println("6 - Saldo total de um cliente.");
		System.out.println("7 - Transferir fundos.");
		System.out.println("0 - Encerrar programa.");
		System.out.println("\n######################################");
	}

	static int getValidMenuOption(Scanner sc) throws InvalidMenuOptionException {
		System.out.print("Digite a opcao desejada: ");
		String input = sc.nextLine();

		try {
			int option = Integer.parseInt(input);
			if (option >= 0 && option <= 8) {
				return option;
			} else {
				throw new InvalidMenuOptionException("Opcao invalida. Por favor, selecione uma opcao entre 0 e 8.\n");
			}
		} catch (NumberFormatException e) {
			throw new InvalidMenuOptionException("Entrada invalida. Por favor, digite um numero.\n");
		}
	}

	private static Customer getCustomerData(Scanner sc) throws InvalidSocialNumberException {
		int socialNumberLength = 11;
		String name, socialNumber = null;
		boolean validSocialNumber = false;

		System.out.println("\nInforme os dados do cliente:");

		System.out.print("\nNome completo do titular da conta: ");
		name = sc.nextLine();

		do {
			try {
				System.out.print("\nCPF do titular: ");
				socialNumber = sc.nextLine();

				if (socialNumber.length() != socialNumberLength || !socialNumber.matches("\\d+")) {
					throw new InvalidSocialNumberException(
							"\nCPF invalido: O CPF deve ter exatamente 11 digitos numericos.");
				}
				validSocialNumber = true;
			} catch (InvalidSocialNumberException e) {
				System.out.println(e.getMessage());
				System.out.println("\nPor favor, tente novamente.");
			}
		} while (!validSocialNumber);

		return new Customer(name, socialNumber);
	}

	private String getCustomerSocialNumber(Scanner sc) {
		String socialNumber;
		do {
			System.out.println("CPF do titular - 11 numeros: ");
			socialNumber = sc.nextLine();
		} while (socialNumber.length() != 11 || !socialNumber.matches("\\d+"));

		return socialNumber;
	}

	static String getAccountType(Scanner sc) throws InvalidMenuOptionException {
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

	static double getInterestRate(Scanner sc) {
		double interestRate;
		System.out.println("\nDigite a taxa de juros:");
		interestRate = sc.nextDouble();
		sc.nextLine();
		return interestRate;
	}

	static double getOverdraftLimit(Scanner sc) {
		double overdraftLimit;
		System.out.println("\nDigite o valor do limite do cheque especial:");
		overdraftLimit = sc.nextDouble();
		return overdraftLimit;
	}

	static String getInitialDepositOption(Scanner sc) {
		String initialDepositOption;
		do {
			System.out.println("\nDeposito inicial? Digite uma opcao.");
			System.out.println("S - Sim.");
			System.out.println("N - Nao.");
			initialDepositOption = sc.nextLine().toUpperCase();
			if (initialDepositOption == NO_OPTION) {
				
				return initialDepositOption;

			}
		} while (!initialDepositOption.equals(YES_OPTION) && !initialDepositOption.equals(NO_OPTION));
		return initialDepositOption;
	}

	static double getInitialDepositAmount(Scanner sc) {
		double initialDeposit;
		System.out.println("\nDigite o valor do deposito:");
		initialDeposit = sc.nextDouble();
		sc.nextLine();
		return initialDeposit;

	}

	private static boolean askToReturnToMainMenu(Scanner sc) {
		System.out.println("\nPressione Enter para retornar ao menu principal...");
		sc.nextLine();
		return true;
	}

	private void displayError(Exception e) {
		System.out.println("Erro: " + e.getMessage());
	}
}
