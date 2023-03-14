package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		
		Cart obj = new Cart("헤르미온느","버터맥주", 3);

		try {
			cartService.register(obj);
			System.out.println("장바구니 담기 완료!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
}