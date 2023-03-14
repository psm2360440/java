package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartSelectAllTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		List<Cart> list = null;
		try {
			list = cartService.get();
			if (list.size() == 0) {
				System.out.println("카트 테이블정보가 존재하지 않습니다!");
			} else {
				for (Cart obj : list) {
					System.out.println(obj);
				}
			}
			System.out.println("등록된 Cart 정보수는 "+list.size()+"개 입니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}