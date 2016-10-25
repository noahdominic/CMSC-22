/*
 * author @noahdominic
 */

import java.util.*;
import java.lang.*;

public class Account {
	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	public void credit(double amount){
		if(amount < 0) {
			throw new IllegalArgumentException("Negative Money set.");
		}
		accountNumber += amount;
	}
	
	public void debit(double amount){
		if(amount < 0) {
			throw new IllegalArgumentException("Negatve Money set.");
		}
		if(balance >= amount){
			balance -= amount;
		}
		else{
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}
	
	public String toString(){
		return String.format("A/C no: %d, Balance = %.2f", accountNumber, balance);
	}
}
