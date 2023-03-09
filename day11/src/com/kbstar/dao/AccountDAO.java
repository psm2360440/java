package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class AccountDAO implements DAO<String, AccountDTO>{

	HashMap<String, AccountDTO> db;
	
	
	
	public AccountDAO() {
		db = new HashMap<String, AccountDTO>();
	}

	@Override
	public void insert(AccountDTO v) throws Exception {
		if(db.containsKey(v.getAccNo())) {
			throw new Exception();
		}
		db.put(v.getAccNo(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception();
		}
		db.remove(k);
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		if(!db.containsKey(v.getAccNo())) {
			throw new Exception();
		}
		db.put(v.getAccNo(), v);

	}

	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO obj = null;
		if(!db.containsKey(k)) {
			throw new Exception();
		}
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		ArrayList<AccountDTO> list = new ArrayList<AccountDTO> ();
		Collection<AccountDTO> col =db.values();
		for ( AccountDTO a : col) {
			list.add(a);
		}
		if(list.size()==0) {
			throw new Exception();
		}
		return list;
	}
	
}
