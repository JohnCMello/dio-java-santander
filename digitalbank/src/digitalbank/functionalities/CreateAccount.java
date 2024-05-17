package digitalbank.functionalities;

import java.util.Scanner;

import digitalbank.entities.Account;
import digitalbank.entities.Bank;
import digitalbank.entities.CheckingAccount;
import digitalbank.entities.Customer;
import digitalbank.entities.SavingsAccount;
import digitalbank.interfaces.Command;
import static digitalbank.utils.Utils.*;

public class CreateAccount implements Command {

	@Override
	public void execute(Scanner sc, Bank bank) {
		String accountType, initialDepositOption;
		boolean isSavingsAccount = false;
		boolean hasInitialDeposit = false;
		double initialDepositAmount = 0d;
		double interestRateValue = 0d;
		double overdraftLimit = 0d;

		Account account;
		Customer customer;
		try {
			clearScreen();
			System.out.println("######################################");
			System.out.println("   *** Criar uma Conta ***      ");
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
				account = hasInitialDeposit ? new SavingsAccount(customer, initialDepositAmount, interestRateValue)
						: new SavingsAccount(customer, interestRateValue);
				bank.addAccount(customer.getSocialNumber(), account);
			} else {
				account = hasInitialDeposit ? new CheckingAccount(customer, initialDepositAmount, overdraftLimit)
						: new CheckingAccount(customer, overdraftLimit);
				bank.addAccount(customer.getSocialNumber(), account);
			}

			clearScreen();
		} catch (Exception e) {
			displayError(e);
		}
	}

}
