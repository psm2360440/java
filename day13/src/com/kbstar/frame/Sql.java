package com.kbstar.frame;

public class Sql {
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String deleteSql = "DELETE FROM cust WHERE ID =?";
	public static String updateSql = "UPDATE cust SET pwd=?, name=?, age=? WHERE id=?";
	public static String selectSql = "SELECT * FROM cust WHERE id = ?";
	public static String selectAllSql = "SELECT * FROM cust ";
}
