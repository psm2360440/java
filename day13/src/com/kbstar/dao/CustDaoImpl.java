package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {
	public CustDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("로딩 성공");
	}

	@Override
	public void insert(Cust v) throws Exception {

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();
			System.out.println("결과:" + result);
		} catch (Exception e1) {
			if (e1 instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("id already exist");
			} else {
				System.out.println("system error");
			}
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.deleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			System.out.println("결과:" + result);
		} catch (SQLException e1) {
			System.out.println("실패");
			e1.getStackTrace();
		}
	}

	@Override
	public void update(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getAge());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();
			System.out.println("결과:" + result);
		} catch (SQLException e1) {
			System.out.println("실패");
			e1.getStackTrace();
		}
	}

	@Override
	public Cust Select(String k) throws Exception {
		Cust cust = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String id = rset.getString("id");// 테이블 컬럼 명. 숫자로도 가능. 그러나 컬럼 명이 더 가독성 좋음.
				String name = rset.getString("name");
				String pwd = rset.getString("pwd");
				int age = rset.getInt("age");
				cust = new Cust(id, pwd, name, age);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e1) {
			throw e1;
		}

		return cust;

	}

	@Override
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<Cust>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql)) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					Cust cust = null;
					String id = rset.getString("id");
					String pwd = rset.getString("pwd");
					String name = rset.getString("name");
					int age = rset.getInt("age");
					cust = new Cust(id, pwd, name, age);
					list.add(cust);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public List<Cust> search(String k) throws Exception {

		return null;
	}

}
