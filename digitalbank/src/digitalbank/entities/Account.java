package digitalbank.entities;

import java.util.Random;

import digitalbank.enums.AccountType;
import digitalbank.exceptions.InsufficientBalanceException;

public abstract class Account {

	protected Customer customer;
	protected int number;
	protected int agency;
	protected double balance;
	protected AccountType type;

	public Account(Customer customer, AccountType type) {
		this.customer = customer;
		this.number = generateRandomNumber(11, 999999);
		this.agency = generateRandomNumber(1, 999);
		this.type = type;
	}

	public Account(Customer customer, double initialDeposit, AccountType type) {
		this.customer = customer;
		this.number = generateRandomNumber(11, 999999);
		this.agency = generateRandomNumber(1, 999);
		this.type = type;

		deposit(initialDeposit);
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount) throws InsufficientBalanceException;

	public abstract void transfer(Account target, double amount) throws InsufficientBalanceException;

	protected abstract boolean hasSufficientFunds(double amount);

	public double getBalance() {
		return balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getNumber() {
		return applyMaskNumber(number);
	}

	public String getAgency() {
		return applyMaskAgency(agency);
	}

	public AccountType getType() {
		return type;
	}

	private static int generateRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	private static String applyMaskNumber(int num) {
		String numStr = String.valueOf(num);
		if (numStr.length() < 6) {
			numStr = String.format("%06d", Integer.parseInt(numStr));
		}
		StringBuilder maskedNum = new StringBuilder(numStr.substring(0, numStr.length() - 2));
		maskedNum.append("-");
		maskedNum.append(numStr.charAt(numStr.length() - 2));
		return maskedNum.toString();
	}

	private static String applyMaskAgency(int num) {
		String numStr = String.valueOf(num);
		if (numStr.length() < 3) {
			numStr = String.format("%03d", Integer.parseInt(numStr));
		}
		StringBuilder maskedNum = new StringBuilder(numStr.substring(0, numStr.length() - 1));
		maskedNum.append("-");
		maskedNum.append(numStr.charAt(numStr.length() - 1));
		return maskedNum.toString();
	}
}
