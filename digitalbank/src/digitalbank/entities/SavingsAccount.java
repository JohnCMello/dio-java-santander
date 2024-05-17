package digitalbank.entities;

import digitalbank.enums.AccountType;
import digitalbank.exceptions.InsufficientBalanceException;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(Customer customer, double interestRate) {
		super(customer, AccountType.SAVINGS);
		this.interestRate = interestRate;
	}

	public SavingsAccount(Customer customer, double initialDeposit, double interestRate) {
		super(customer, initialDeposit, AccountType.SAVINGS);
		this.interestRate = interestRate;
		
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("Taxa de juros não pode ser negativa");
		}
		this.interestRate = interestRate;
	}
	
	public String toString() {
		StringBuilder account = new StringBuilder();

		account

			.append("\nTitular: " + customer.getName() + "\n")
			.append("Numero: " + getNumber() + " - Agencia: " + getAgency() + "\n")
			.append("Tipo da conta: Poupanca\n")
			.append("Saldo em conta: " + String.format("%.2f", balance) + "\n")
			.append("Taxa de rendimentos: " + String.format("%.2f", interestRate)+ "% ao mes\n");
		return account.toString();
	}

	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Valor do depósito não pode ser negativo");
		}
		balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (!hasSufficientFunds(amount)) {
			throw new InsufficientBalanceException("Saldo insuficiente");
		}
		balance -= amount;
	}

	@Override
	public void transfer(Account target, double amount) throws InsufficientBalanceException {
		if (!hasSufficientFunds(amount)) {
			throw new InsufficientBalanceException("Saldo insuficiente");
		}
		balance -= amount;
		target.deposit(amount);
	}

	@Override
	public boolean hasSufficientFunds(double value) {
		return balance >= value;
	}

	public void applyInterest() {
		double interestAmount = balance * interestRate / 100.0;
		balance += interestAmount;
	}
}
