package com.kbstar.frame;

public class Sql {
	//Cust SQL
	public static String custInsertSql = "INSERT INTO cust VALUES(?,?,?,?,SYSDATE)";
	public static String CustDeleteSql = "DELETE FROM cust WHERE id=?";
	public static String CustUpdateSql = "UPDATE cust SET pwd=?, name=?, contact=? WHERE id=?";
	public static String CustSelectSql = "SELECT * FROM cust WHERE id=?";
	public static String CustSelectAllSql = "SELECT * FROM cust";
}