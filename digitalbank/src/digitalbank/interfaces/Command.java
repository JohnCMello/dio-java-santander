package digitalbank.interfaces;

import java.util.Scanner;

import digitalbank.entities.Bank;

public interface Command {
	void execute(Scanner sc, Bank bank);
}
