package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kbstar.dto.Cust;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {

	public CustDaoImpl() {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
	}

	public Connection getConnection() throws Exception {
		Connection con = null;

		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL");
		con = DriverManager.getConnection(url, id, pwd);
		return con;

	}

	@Override
	public void insert(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw e1;
			// e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.deleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception("삭제할 ID가 존재하지 않습니다!");
			}
		} catch (Exception e2) {
			throw e2;
			//e1.printStackTrace();
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
			if ( result == 0 ) {
				throw new Exception("변경할 ID가 존재하지 않습니다!");
			}
 		} catch (Exception e3) {
			throw e3;
			//e1.printStackTrace();
		}
	}



	@Override
	public List<Cust> selectAll() throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql);) {
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					String db_id = rset.getString(1);
					String db_pwd = rset.getString(2);
					String name = rset.getString(3);
					int age = rset.getInt(4);
					System.out.println(db_id+" "+name+" "+age);
				}
			}catch (Exception e) {
				throw new Exception("이것 또한 장애란다!");
				//e.printStackTrace();
			}
			
		} catch (Exception e5) {
			throw e5;
			//e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		
		return null;
	}

	@Override
	public Cust Select(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			try(ResultSet rset = pstmt.executeQuery()){
				rset.next(); //	한칸 이동시킴.
				String db_id = rset.getString(1);	// 1번째부터 자리 시작함
				String db_pwd = rset.getString(2);
				String name = rset.getString(3);
				int age = rset.getInt(4);
				System.out.println(db_id+" "+name+" "+age);
			}catch (Exception e) {
				throw new Exception("무슨장애니이게?");
				//e.printStackTrace();
			}
			
		} catch (Exception e4) {
			throw e4;
		}
		return null;
	}
}
