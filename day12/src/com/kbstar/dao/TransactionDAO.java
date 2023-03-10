package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;

public class TransactionDAO implements DAO<String, TransactionDTO>{
	
	HashMap<String, TransactionDTO> db;

	public TransactionDAO() {
		db = new HashMap<String, TransactionDTO>();
	}

	@Override
	public void insert(TransactionDTO v) throws Exception {
		if(db.containsKey(v.getDate())) {
			throw new Exception();
		}
		db.put(v.getDate(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		
	}

	@Override
	public void update(TransactionDTO v) throws Exception {
		
	}

	@Override
	public TransactionDTO select(String k) throws Exception {
		TransactionDTO obj = null;
		if(!db.containsKey(k)) {
			throw new Exception();
		}
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<TransactionDTO> select() throws Exception {
		ArrayList<TransactionDTO> list = new ArrayList<TransactionDTO> ();
		Collection<TransactionDTO> col =db.values();
		for ( TransactionDTO a : col) {
			list.add(a);
		}
		if(list.size()==0) {
			throw new Exception();
		}
		return list;
	}

	// 특정 계좌의 거래내역을 조회
	// obj : accNo.
	@Override
	public List<TransactionDTO> search(Object obj) throws Exception {
		return null;
	}
}
