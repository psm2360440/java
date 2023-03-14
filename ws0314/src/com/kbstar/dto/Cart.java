package com.kbstar.dto;

import java.util.Date;

public class Cart {
	private String id;
	private String user_id;
	private String item_id;
	private int cnt;
	private Date regdate;


	public Cart() {
		super();
	}

	public Cart(String id, String user_id, String item_id, int cnt, Date regdate) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.cnt = cnt;
		this.regdate = regdate;
	}

	public Cart(String user_id, String item_id, int cnt) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
		this.cnt = cnt;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user_id=" + user_id + ", item_id=" + item_id + ", cnt=" + cnt + ", regdate="
				+ regdate + "]";
	}
	
}
