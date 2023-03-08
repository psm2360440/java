package com.kbstar.dao;

import java.util.HashMap;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<Integer, ItemDTO>{
	
	HashMap<Integer, ItemDTO> db = null;
	
	public ItemDAO() {
		db = new HashMap<>();
	}

	@Override
	public void insert(ItemDTO v) throws Exception {
		if(v.getName().equals("입출식통장")) {
			throw new Exception("ER0007");
		}
		System.out.println(v);
		System.out.println("Inserted...");
		close();
	}

	@Override
	public void delete(Integer k) throws Exception {	//자바에서의 언박싱 자동변환 int값으로 입력된 것이
		if(k.equals(00001)) {
			throw new Exception("ER0008");
		}
		connect();
		System.out.println(k);
		System.out.println("Deleted...");
		close();
	}

	@Override
	public void update(ItemDTO v) throws Exception {
		if(v.getId()  == 00001) {
			throw new Exception("ER0009");
		}
		connect();
		System.out.println(v);
		System.out.println("Updated...");
		close();
	}
}
