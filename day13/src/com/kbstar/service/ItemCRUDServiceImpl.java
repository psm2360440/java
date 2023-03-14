package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.ItemDaoImpl;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeItemNumber;

public class ItemCRUDServiceImpl implements CRUDService<String, Item> {

	DAO<String, String, Item> dao;

	public ItemCRUDServiceImpl() {
		dao = new ItemDaoImpl();
	}

	@Override
	public void register(Item v) throws Exception {
		try {
			String id = MakeItemNumber.makeItemNum();
			v.setId(id);
			dao.insert(v);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("id가 중복되었습니다.");
			} else {
				throw new Exception("시스템 장애 입니다.");
			}
		}

	}

	@Override
	public void modify(Item v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("ID가 중복 되었습니다.");
			} else {
				throw new Exception("시스템 장애 입니다.");
			}
		}
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Item get(String k) throws Exception {
		Item item = null;
		try {
			item = dao.Select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("입력하신 ID에 해당하는 정보가 없습니다!");
			}
		}
		return item;
	}

	@Override
	public List<Item> get() throws Exception {
		List<Item> list = null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다. 잠시 후 재접속 바라요~");
			} else {
				throw new Exception("ID가 존재하지 않습니다.");
			}
		}
		return list;
	}

}
