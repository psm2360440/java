package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.CustDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDAO implements DAO<String, CustDTO> {

	public CustDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
			e.printStackTrace();
			return;
		}
		// System.out.println("DB Loaded!");
	}

	@Override
	public void insert(CustDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.custInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setString(4, v.getContact());
			pstmt.executeUpdate();
			System.out.println(v.getName() + "님의 가입을 환영합니다!");
		} catch (Exception e1) {
			if (e1 instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("이미 사용 중인 ID입니다!");
			} else if ( e1 instanceof SQLRecoverableException){
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("ID, Password, 이름 등의 길이가 입력 범위를 초과하였습니다!");
			}
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.CustDeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("삭제정보없음");
			}
		} catch (Exception e2) {
			throw e2;
		}
	}

	@Override
	public void update(CustDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.CustUpdateSql);) {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getContact());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("변경정보없음");
			}
		} catch (Exception e3) {
			throw e3;
		}
	}

	@Override
	public CustDTO select(String k) throws Exception {
		CustDTO cust = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.CustSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String cust_id = rset.getString("id");// 테이블 컬럼 명. 숫자로도 가능. 그러나 컬럼 명이 더 가독성 좋음.
				String name = rset.getString("name");
				String pwd = rset.getString("pwd");
				String contact = rset.getString("contact");
				cust = new CustDTO(cust_id, pwd, name, contact);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e1) {
			throw e1;
		}
		return cust;
	}

	@Override
	public List<CustDTO> select() throws Exception {
		List<CustDTO> list = new ArrayList<CustDTO>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.CustSelectAllSql)) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					CustDTO cust = null;
					String cust_id = rset.getString("id");
					String pwd = rset.getString("pwd");
					String name = rset.getString("name");
					String contact = rset.getString("contact");
					Date regdate = rset.getDate("regdate");
					cust = new CustDTO(cust_id, pwd, name, contact, regdate);
					list.add(cust);
				}
			} catch (Exception e5) {
				throw e5;
			}
		} catch (Exception e6) {
			throw e6;
		}
		return list;
	}

	@Override
	public List<CustDTO> search(String k) throws Exception {
		return null;
	}
}