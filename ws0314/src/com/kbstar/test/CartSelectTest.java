package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartSelectTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();		
		try {
			cart = cartService.get("2023314552100");
			System.out.println(cart);
		} catch (Exception e) {
			System.out.println(e.getMessage());	 
		}
	}
}