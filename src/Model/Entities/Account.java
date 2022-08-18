package Model.Entities;

import Model.Exception.DomainException;
import Model.Exception.WithdrawException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void setBalance() {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit() {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException, WithdrawException {
		if(withdrawLimit < amount) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
		}
		if(balance < amount) {
			throw new WithdrawException("Withdraw error: Not enough balance");
		}
		
		balance -= amount;
		 
	}
	
	

}
