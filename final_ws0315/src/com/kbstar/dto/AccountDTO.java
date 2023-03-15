package com.kbstar.dto;

import java.util.Date;

public class AccountDTO {
	private String accNo;
	private double balance;
	private Date regdate;
	private String Holder_id;

	public AccountDTO() {
	}

	public AccountDTO(double balance, String holder_id) {
		super();
		this.balance = balance;
		this.Holder_id = holder_id;
	}

	public AccountDTO(String accNo, double balance, String holder_id) {
		this.accNo = accNo;
		this.balance = balance;
		Holder_id = holder_id;
	}

	public AccountDTO(String accNo, double balance, Date regdate, String holder_id) {
		this.accNo = accNo;
		this.balance = balance;
		this.regdate = regdate;
		Holder_id = holder_id;

	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getHolder_id() {
		return Holder_id;
	}

	public void setHolder_id(String holder_id) {
		Holder_id = holder_id;
	}

	@Override
	public String toString() {
		return "AccountDTO [accNo=" + accNo + ", balance=" + balance + ", Holder_id=" + Holder_id + "]";
	}
}