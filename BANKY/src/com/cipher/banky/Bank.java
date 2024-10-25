package com.cipher.banky;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	private Map<String, Account> accounts;

	public Bank() {
		accounts = new HashMap<>();
	}

	// Create a new account
	public void createAccount(String accountNumber, String accountHolderName, double initialDeposit) {
		if (!accounts.containsKey(accountNumber)) {
			Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
			accounts.put(accountNumber, newAccount);
			System.out.println("Account created successfully for " + accountHolderName);
		} else {
			System.out.println("Account with this number already exists.");
		}
	}

	// Deposit money into an account
	public void deposit(String accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		if (account != null) {
			account.deposit(amount);
		} else {
			System.out.println("Account not found.");
		}
	}

	// Withdraw money from an account
	public void withdraw(String accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		if (account != null) {
			account.withdraw(amount);
		} else {
			System.out.println("Account not found.");
		}
	}

	// Transfer money between accounts
	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
		Account fromAccount = accounts.get(fromAccountNumber);
		Account toAccount = accounts.get(toAccountNumber);

		if (fromAccount != null && toAccount != null) {
			if (fromAccount.withdraw(amount)) {
				toAccount.deposit(amount);
				System.out.println(
						"Successfully transferred " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
			}
		} else {
			System.out.println("Invalid account number(s).");
		}
	}

	// Display account details
	public void displayAccount(String accountNumber) {
		Account account = accounts.get(accountNumber);
		if (account != null) {
			account.displayAccountInfo();
		} else {
			System.out.println("Account not found.");
		}
	}

	// Main menu for the bank
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nWelcome to Banky");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Funds");
			System.out.println("3. Withdraw Funds");
			System.out.println("4. Transfer Funds");
			System.out.println("5. View Account Details");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Account Number: ");
				String accNumber = scanner.nextLine();
				System.out.print("Enter Account Holder Name: ");
				String accHolder = scanner.nextLine();
				System.out.print("Enter Initial Deposit: ");
				double initialDeposit = scanner.nextDouble();
				bank.createAccount(accNumber, accHolder, initialDeposit);
				break;

			case 2:
				System.out.print("Enter Account Number: ");
				accNumber = scanner.nextLine();
				System.out.print("Enter Deposit Amount: ");
				double depositAmount = scanner.nextDouble();
				bank.deposit(accNumber, depositAmount);
				break;

			case 3:
				System.out.print("Enter Account Number: ");
				accNumber = scanner.nextLine();
				System.out.print("Enter Withdrawal Amount: ");
				double withdrawalAmount = scanner.nextDouble();
				bank.withdraw(accNumber, withdrawalAmount);
				break;

			case 4:
				System.out.print("Enter From Account Number: ");
				String fromAccNumber = scanner.nextLine();
				System.out.print("Enter To Account Number: ");
				String toAccNumber = scanner.nextLine();
				System.out.print("Enter Transfer Amount: ");
				double transferAmount = scanner.nextDouble();
				bank.transferFunds(fromAccNumber, toAccNumber, transferAmount);
				break;

			case 5:
				System.out.print("Enter Account Number: ");
				accNumber = scanner.nextLine();
				bank.displayAccount(accNumber);
				break;

			case 6:
				System.out.println("Thank you for using Banky. Goodbye!");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
