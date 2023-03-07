package com.kbstar.service;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;

public class ItemService implements Service<Integer, ItemDTO>, SearchService{//자바는 단일상속이지만 인터페이스는 기능중심이므로 여러개 상속? 가능...
	DAO<Integer, ItemDTO> dao; //service 단에서 database로 DTO를 넘겨주기 위하여 생성.

	
	public ItemService() {
		dao = new ItemDAO();
		}
	
	
	@Override
	public void register(ItemDTO v) {
		System.out.println(v + " Data Checked...");
		dao.insert(v);
		System.out.println("Send SMS to Admin...");
	}

	@Override
	public void remove(Integer k) {
		System.out.println(k + " Data Checked...");
		dao.delete(k);
		System.out.println("Send SMS to Admin...");
	}

	@Override
	public void modify(ItemDTO v) {
		System.out.println(v + " Data Checked...");
		dao.update(v);
		System.out.println("Send SMS to Admin...");
	}


	@Override
	public void search() {
		System.out.println("Item Searching...");
	}
}