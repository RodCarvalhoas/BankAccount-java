package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Entities.Account;
import Model.Exception.DomainException;
import Model.Exception.WithdrawException;

public class Program {
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.next();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
			
		try {
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " + account.getBalance());
		}
		catch(DomainException e){
			System.out.println(e.getMessage());
		}
		catch(WithdrawException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
