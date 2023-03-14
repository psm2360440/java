package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		
		Cart obj = new Cart("bogobogo","면도칼",17);

		try {
			cartService.register(obj);
			System.out.println("카트 담기 성공!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
}