package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartRemoveTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		try {
			cartService.remove("20233146210000");
			System.out.println("장바구니에서 삭제되었습니다!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}