package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class AccountDAO implements DAO<String, AccountDTO> {

	public AccountDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void insert(AccountDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accInsertSql);) {
			pstmt.setString(1, v.getAccNo());
			pstmt.setDouble(2, v.getBalance());
			pstmt.setString(3, v.getHolder_id());
			if (v.getBalance() <= 0) {
				throw new Exception("초입금 금액 오류");
			} else {
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accDeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("계좌 없음 오류");
			}
		} catch (Exception e2) {
			throw e2;
		}
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accUpdateSql);) {
			pstmt.setDouble(1, v.getBalance());
			pstmt.setString(2, v.getAccNo());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("변경정보없음");
			}
		} catch (Exception e3) {
			throw e3;
		}
	}
	
	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO acc = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String accNo = rset.getString("accNo");
				Double balance = rset.getDouble("balance");
				Date regdate = rset.getDate("regdate");
				String holder_id = rset.getString("holder_id");
				acc = new AccountDTO(accNo, balance, regdate, holder_id);
			} catch (Exception e3) {
				throw new Exception("계좌번호를 확인 후 재시도 부탁드립니다!");
			}
		} catch (Exception e4) {
			throw e4;
		}
		return acc;
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		List<AccountDTO> accList = new ArrayList<AccountDTO>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accSelectAllSql);) {

			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					AccountDTO acc = null;
					String accNO = rset.getString("accNO");
					Double balance = rset.getDouble("balance");
					Date regdate = rset.getDate("regdate");
					String holder_id = rset.getString("holder_id");
					acc = new AccountDTO(accNO, balance, regdate, holder_id);
					accList.add(acc);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw e;
		}
		return accList;
	}

	@Override
	public List<AccountDTO> search(String k) throws Exception {
		List<AccountDTO> myList = new ArrayList<AccountDTO>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accSearchSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					AccountDTO acc = null;
					String accNO = rset.getString("accNO");
					Double balance = rset.getDouble("balance");
					Date regdate = rset.getDate("regdate");
					String holder_id = rset.getString("holder_id");
					acc = new AccountDTO(accNO, balance, regdate, holder_id);
					if ((acc.getHolder_id()).equals(k)) {
						myList.add(acc);
					}
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw e;
		}
		return myList;
	}
}