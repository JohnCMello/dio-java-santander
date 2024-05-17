package digitalbank.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import digitalbank.enums.AccountType;
import digitalbank.exceptions.AccountNotFoundException;
import digitalbank.exceptions.IdenticalAccountNumberException;
import digitalbank.exceptions.IdenticalAccountTypeException;
import digitalbank.exceptions.InsufficientBalanceException;
import digitalbank.exceptions.NoAccountsCreatedException;

public class Bank {

	private Map<String, Account> savingsAccounts;
	private Map<String, Account> checkingAccounts;

	public Bank() {
		savingsAccounts = new HashMap<>();
		checkingAccounts = new HashMap<>();
	}

	public void addAccount(String customerSocialNumber, Account account)
			throws IdenticalAccountTypeException, IdenticalAccountNumberException {
		if (account instanceof SavingsAccount) {
			checkAndAddAccount(savingsAccounts, customerSocialNumber, account);
		} else if (account instanceof CheckingAccount) {
			checkAndAddAccount(checkingAccounts, customerSocialNumber, account);
		}
	}

	public Account getAccountByCustomerSocialNumber(String customerSocialNumber, AccountType accountType)
			throws AccountNotFoundException {
		Map<String, Account> accountMap = getAccountMapByType(accountType);
		if (!accountMap.containsKey(customerSocialNumber)) {
			throw new AccountNotFoundException("Conta não encontrada para o CPF fornecido.");
		}
		return accountMap.get(customerSocialNumber);
	}

	public Account removeAccount(String customerSocialNumber, AccountType accountType) throws AccountNotFoundException {
		Map<String, Account> accountMap = getAccountMapByType(accountType);
		Account accountToBeRemoved = accountMap.get(customerSocialNumber);
		if (!accountMap.containsKey(customerSocialNumber)) {
			throw new AccountNotFoundException("O cliente não possui nenhuma conta do tipo especificado");
		}
		accountMap.remove(customerSocialNumber);
		return accountToBeRemoved;
	}

	public List<Account> getAllAccountsByType(AccountType accountType) throws NoAccountsCreatedException {
		if (savingsAccounts.size() == 0 && checkingAccounts.size() == 0) {
			throw new NoAccountsCreatedException("Nao existem contas deste tipo criadas.");
		}
		return accountType == AccountType.SAVINGS ? new ArrayList<>(savingsAccounts.values())
				: new ArrayList<>(checkingAccounts.values());
	}

	public List<Account> getAllAccountsBySocialNumber(String customerSocialNumber) throws NoAccountsCreatedException {
		List<Account> accounts = new ArrayList<>();

		if (!savingsAccounts.containsKey(customerSocialNumber) && !checkingAccounts.containsKey(customerSocialNumber)) {
			throw new NoAccountsCreatedException("Não existem contas para esse CPF");
		}
		if (savingsAccounts.containsKey(customerSocialNumber)) {
			accounts.add(savingsAccounts.get(customerSocialNumber));
		}
		if (checkingAccounts.containsKey(customerSocialNumber)) {
			accounts.add(checkingAccounts.get(customerSocialNumber));
		}
		return accounts;
	}

	public double getTotalBalance(String customerSocialNumber) {
		double totalBalance = 0;
		if (savingsAccounts.containsKey(customerSocialNumber)) {
			Account account = savingsAccounts.get(customerSocialNumber);
			totalBalance += account.getBalance();
		}
		if (checkingAccounts.containsKey(customerSocialNumber)) {
			Account account = checkingAccounts.get(customerSocialNumber);
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}

	public void transferFunds(Account sourceAccount, Account targetAccount, double amount)
			throws InsufficientBalanceException {
		if (!sourceAccount.hasSufficientFunds(amount)) {
			throw new InsufficientBalanceException("Saldo insuficiente na conta de origem");
		}
		 sourceAccount.transfer(targetAccount, amount);
	}

	private void checkAndAddAccount(Map<String, Account> accountMap, String customerSocialNumber, Account account)
			throws IdenticalAccountTypeException, IdenticalAccountNumberException {
		for (Account existingAccount : accountMap.values()) {
			if (existingAccount.getNumber() == account.getNumber()) {
				throw new IdenticalAccountNumberException("Já existe uma conta com o mesmo número");
			}
		}
		if (accountMap.containsKey(customerSocialNumber)) {
			Account existingAccount = accountMap.get(customerSocialNumber);
			if (existingAccount.getClass() == account.getClass()) {
				throw new IdenticalAccountTypeException("O cliente já possui uma conta do mesmo tipo");
			}
		}
		accountMap.put(customerSocialNumber, account);
	}

	private Map<String, Account> getAccountMapByType(AccountType accountType) {
		return accountType == AccountType.SAVINGS ? savingsAccounts : checkingAccounts;
	}

}
