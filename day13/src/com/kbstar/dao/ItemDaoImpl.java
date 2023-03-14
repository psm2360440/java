package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kbstar.dto.Item;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class ItemDaoImpl implements DAO<String, String, Item> {

	public ItemDaoImpl() {
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
	public void insert(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemDeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				System.out.println(k + "는 없는 id입니다.");
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void update(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemUpdateSql);) {
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setDouble(3, v.getRate());
			pstmt.setString(4, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// throw e;
			e.printStackTrace();
		}
	}

	@Override
	public List<Item> selectAll() throws Exception {
		List<Item> list = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					Item item = null;
					String id = rset.getString("id");
					String name = rset.getString("name");
					int price = rset.getInt("price");
					int rate = rset.getInt("rate");
					Date regdate = rset.getDate("regdate");
					item = new Item(id, name, price, rate, regdate);
					list.add(item);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public List<Item> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item Select(String k) throws Exception {
		Item item = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String db_id = rset.getString("id");
				String name = rset.getString("name");
				int price = rset.getInt("price");
				double rate = rset.getDouble("rate");
				Date regdate = rset.getDate("regdate");
				item = new Item(db_id, name, price, rate, regdate);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e4) {
			throw e4;
		}
		return item;
	}

}
