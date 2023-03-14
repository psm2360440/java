package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Item> itemService = new ItemCRUDServiceImpl();
		
		Item obj = new Item("pants",10000,3.2);

		try {
			itemService.register(obj);
			System.out.println("등록 완료!");
		} catch (Exception e) {
			System.out.println(e.getMessage());	 
		}
	}
}