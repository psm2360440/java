package com.kbstar.dto;

import java.util.Date;

import com.kbstar.frame.MakeAccNumber;

public class TrDTO {
	private String id;
	private String myAcc;// 내계좌번호.
	private String opositAcc; // 거래구분. 상대계좌번호 | cash.
	private String type; // 거래구분. 입금/ 출금
	private Double amount;// 거래 금액
	private Date regdate; // 거래 일자.

	public TrDTO() {
		this.id = MakeAccNumber.makeTrNum();
	}

	public TrDTO(String myAcc, String opositAcc, String type, Double amount) {
		this();
		this.myAcc = myAcc;
		this.opositAcc = opositAcc;
		this.type = type;
		this.amount = amount;
	}
	

	public TrDTO(String id, String myAcc, String opositAcc, String type, Double amount) {
		this.id = id;
		this.myAcc = myAcc;
		this.opositAcc = opositAcc;
		this.type = type;
		this.amount = amount;
	}

	public TrDTO(String id, String myAcc, String opositAcc, String type, Double amount, Date regdate) {
		this.id = id;
		this.myAcc = myAcc;
		this.opositAcc = opositAcc;
		this.type = type;
		this.amount = amount;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMyAcc() {
		return myAcc;
	}

	public void setMyAcc(String myAcc) {
		this.myAcc = myAcc;
	}

	public String getOpositAcc() {
		return opositAcc;
	}

	public void setOpositAcc(String opositAcc) {
		this.opositAcc = opositAcc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "TrDTO [id=" + id + ", myAcc=" + myAcc + ", opositAcc=" + opositAcc + ", type=" + type + ", amount="
				+ amount + ", regdate=" + regdate + "]";
	}
}