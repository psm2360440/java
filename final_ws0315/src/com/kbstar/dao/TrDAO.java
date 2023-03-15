package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.TrDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class TrDAO implements DAO<String, TrDTO> {
	public TrDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void insert(TrDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.trInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getMyAcc());
			pstmt.setString(3, v.getOpositAcc());
			pstmt.setString(4, v.getType());
			pstmt.setDouble(5, v.getAmount());
			pstmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		System.out.println("삭제 불가능합니다.");// tr은 delete 안함

	}

	@Override
	public void update(TrDTO v) throws Exception {
		System.out.println("삭제 불가능합니다.");// tr은 update 안함

	}

	@Override
	public TrDTO select(String k) throws Exception {
		return null;
	}

	@Override
	public List<TrDTO> select() throws Exception {
		List<TrDTO> list = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.trSelectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					TrDTO tr = null;
					String db_id = rset.getString("id");
					String acc = rset.getString("myAcc");
					String oposit = rset.getString("opositAcc");
					String type = rset.getString("type");
					Double amount = rset.getDouble("amount");
					Date regdate = rset.getDate("regdate");
					tr = new TrDTO(db_id, acc, oposit, type, amount, regdate);
					list.add(tr);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public List<TrDTO> search(String k) throws Exception {
		List<TrDTO> myList = new ArrayList<TrDTO>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.trSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					TrDTO tr = null;
					String db_id = rset.getString("id");
					String acc = rset.getString("myAcc");
					String oposit = rset.getString("opositAcc");
					String type = rset.getString("type");
					Double amount = rset.getDouble("amount");
					Date regdate = rset.getDate("regdate");
					tr = new TrDTO(db_id, acc, oposit, type, amount, regdate);
					if ((tr.getMyAcc()).equals(k)) {
						myList.add(tr);
					}
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e4) {
			throw e4;
		}
		return myList;
	}
}