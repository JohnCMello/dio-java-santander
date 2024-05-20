package digitalbank.entities;

import digitalbank.enums.AccountType;
import digitalbank.exceptions.InsufficientBalanceException;
import digitalbank.exceptions.InvalidAmountEcxeption;

public class CheckingAccount extends Account {
	private double overdraftLimitTotal;
	private double overdraftLimitInUse;

	public CheckingAccount(Customer customer, double overdraft) {
		super(customer, AccountType.CHECKING);
		this.overdraftLimitTotal = overdraft;
		this.overdraftLimitInUse = 0.0;
	}

	public CheckingAccount(Customer customer, double inicialDeposit, double overdraft) throws InvalidAmountEcxeption {
		super(customer, inicialDeposit, AccountType.CHECKING);
		if(inicialDeposit < 0) {
			throw new InvalidAmountEcxeption("O valor do deposito nao pode ser um numero negativo\n");
		}
		if(overdraftLimitTotal < 0) {
			throw new InvalidAmountEcxeption("O valor do cheque especial nao pode ser um numero negativo\n");
		}
		this.overdraftLimitTotal = overdraft;
		this.overdraftLimitInUse = 0.0;	}

	@Override
	public String toString() {
		StringBuilder account = new StringBuilder();

		account
			.append("\nTitular: " + customer.getName() + "\n")
			.append("Numero: " + getNumber() + " - Agencia: " + getAgency() + "\n")
			.append("Tipo da conta: Corrente\n")
			.append("Saldo em conta: " + String.format("%.2f", getBalance()) + "\n")
			.append("Limite do Cheque Especial: " + String.format("%.2f", overdraftLimitTotal) + "\n")
			.append("Limite restante: " + String.format("%.2f", overdraftLimitTotal - overdraftLimitInUse) +"\n");
		return account.toString();
	}

	@Override
	public void deposit(double amount) throws InvalidAmountEcxeption {
		if(amount < 0 ) {
			throw new InvalidAmountEcxeption("Não é possivel realizar o deposito de um numero negativo");
		}
		if (overdraftLimitInUse > 0) {
			updateBalanceAndOverdraft(amount);
		} else {
			balance += amount;
		}
	}

	@Override
	public void withdraw(double amount) throws InvalidAmountEcxeption, InsufficientBalanceException {
		if(amount < 0 ) {
			throw new InvalidAmountEcxeption("Não é possivel realizar o deposito de um numero negativo");
		}
		if (!hasSufficientFunds(amount)) {
            throw new InsufficientBalanceException("Saldo insuficiente");
        }
        double remainingBalance = balance - amount;
        if (remainingBalance < 0) {
            overdraftLimitInUse += Math.abs(remainingBalance);
            balance = 0;
        } else {
            balance = remainingBalance;
        }
	}

	@Override
	public void transfer(Account destination, double amount) throws InsufficientBalanceException, InvalidAmountEcxeption {
		withdraw(amount);
        destination.deposit(amount);
	}

	@Override
	public boolean hasSufficientFunds(double value) {
		double remainingLimit = Math.max(0, overdraftLimitTotal - overdraftLimitInUse);
		double totalBalance = balance + remainingLimit;
		return totalBalance >= value;
	}

	private void updateBalanceAndOverdraft(double amount) {
		double remainingOverdraft = overdraftLimitInUse - amount;
		if (remainingOverdraft < 0) {
			overdraftLimitInUse = 0;
			balance = Math.abs(remainingOverdraft);
		} else {
			overdraftLimitInUse = remainingOverdraft;
		}
	}
}
