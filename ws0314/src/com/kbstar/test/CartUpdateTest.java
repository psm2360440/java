package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartUpdateTest {
	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		Cart cart2 = new Cart("2023314552100", "bogo", "바람막이", 31, null);
		try {
			//cartService.modify(cart);
			cartService.modify(cart2);
			System.out.println("변경 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
