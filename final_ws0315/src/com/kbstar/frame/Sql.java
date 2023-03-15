package com.kbstar.frame;

public class Sql {
	//Cust SQL
	public static String custInsertSql = "INSERT INTO cust VALUES(?,?,?,?,SYSDATE)";
	public static String CustDeleteSql = "DELETE FROM cust WHERE id=?";
	public static String CustUpdateSql = "UPDATE cust SET pwd=?, name=?, contact=? WHERE id=?";
	public static String CustSelectSql = "SELECT * FROM cust WHERE id=?";
	public static String CustSelectAllSql = "SELECT * FROM cust";
	
	//Account DML
	public static String accInsertSql = "INSERT INTO account VALUES(?,?,SYSDATE,?)";
	public static String accDeleteSql = "DELETE FROM account WHERE ACCNO = ?";
	public static String accUpdateSql = "UPDATE account SET balance=? WHERE accNo=?";
	public static String accSelectSql = "SELECT * FROM account where ACCNO = ?";
	public static String accSelectAllSql = "SELECT * FROM account order by ACCNO";
	public static String accSearchSql = "SELECT * FROM account WHERE Holder_id=?";
	
	// tr DML //거래내역 이므로 delete, update 없음.
	public static String trInsertSql = "INSERT INTO tr VALUES (?,?,?,?,?,SYSDATE)";
	public static String trSelectAllSql = "SELECT * FROM tr"; //전체 계좌의 전체 거래내역 조회하기
	public static String trSelectSql = "Select * FROM tr WHERE myAcc=?"; //내 계좌 거래내역 조회하기
}