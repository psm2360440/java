package com.kbstar.dto;

import java.util.Date;

public class CustDTO {
	private String id;
	private String pwd;
	private String name;
	private String contact;
	private Date regdate;
	
	public CustDTO() {
		super();
	}

	

	@Override
	public String toString() {
		return "CustDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", contact=" + contact + ", regdate=" + regdate
				+ "]";
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

	public CustDTO(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public CustDTO(String id, String pwd, String name, String contact) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.contact = contact;
	}
	
	public CustDTO(String id, String pwd, String name, String contact, Date regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.contact = contact;
		this.regdate = regdate;
	}


	
}

