package com.kbstar.dto;

public class AccountDTO {
	private String accNum;
	private String accName;
	private double balance;

	public AccountDTO() {
	}

	public AccountDTO(String accNum, String accName, double balance) {
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + "]";
	}

	public void withdarw(double money) {
		if (money <= 0) {
			System.out.println("출금 금액을 확인하세요!");
			return;
		}
		if (money > balance) {
			System.out.println("잔액이 부족합니다!");
			return;
		}
		this.balance -= money;
		// this.balance = this.balance - money;
	}

	public void deposit(double money) {
		if (money <= 0) {
			System.out.println("입금 금액을 확인하세요!");
			return;
		}
		this.balance += money;
		// this.balance = this.balance + money;
	}

	public double getBalance() {
		return balance;
	}
}
