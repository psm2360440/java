package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartUpdateTest {
	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		Cart cart2 = new Cart("2023314408100", "최우식", "빨아쓰는행주", 10, null);
		try {
			cartService.modify(cart2);
			System.out.println("장바구니가 수정되었습니다!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}