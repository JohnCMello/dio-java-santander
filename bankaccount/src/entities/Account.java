package entities;

public class Account {
	private Integer number;
	private String agency;
	private String holder;
	private Double balance;

	public Account(String agency, Integer number, String holder, Double balance) {
		this.number = number;
		this.agency = agency;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public String getAgency() {
		return agency;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public String toString() {
		String formatAccount = this.number <10 ? "000" + this.number : this.number <100? "00" + this.number:this.number <1000?"0" + this.number: this.number.toString();
		
		return "Olá " + this.holder + ", obrigado por criar uma conta em nosso banco, sua agência é " + this.agency
				+ ", conta " + formatAccount + " e seu saldo " + String.format("%.2f",this.balance) + " já está disponível para saque.";
	}

}
