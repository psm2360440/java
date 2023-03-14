package com.kbstar.service;

import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.CartDaoImpl;
import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeItemNumber;

public class CartCRUDServiceImpl implements CRUDService<String, Cart> {

	DAO<String, String, Cart> dao;

	public CartCRUDServiceImpl() {
		dao = new CartDaoImpl();
	}

	@Override
	public void register(Cart v) throws Exception {
		try {
			String id = MakeItemNumber.makeCartNum();
			v.setId(id);
			dao.insert(v);
		} catch (Exception e) {
			throw new Exception("시스템 장애 발생! 잠시 후 다시 시도해주시기 바랍니다!");
		}
	}

	@Override
	public void modify(Cart v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("변경할 ID가 존재하지 않습니다!");
			}

		}
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			dao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도하시기 바랍니다!");
			}
		}
	}

	@Override
	public Cart get(String k) throws Exception {
		Cart cart = null;
		try {
			cart = dao.Select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("입력하신 카트에 해당하는 정보가 없습니다!");
			}
		}
		return cart;
	}

	@Override
	public List<Cart> get() throws Exception {
		List<Cart> list = null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {

				throw new Exception("네트워크 오류 발생!");
		}

		return list;
	}
}
