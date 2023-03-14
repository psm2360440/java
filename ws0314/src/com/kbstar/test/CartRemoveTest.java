package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartRemoveTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		try {
			cartService.remove("2023314261100");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
