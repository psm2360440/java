package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectTest {

	public static void main(String[] args) {
		Item item = new Item();
		CRUDService<String, Item> itemService = new ItemCRUDServiceImpl();
		
		try {
			item = itemService.get("2023314245100");
			System.out.println(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());	 
		}
	}
}