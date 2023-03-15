package com.kbstar.test;

import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustService;

public class CustInsertTest {

	public static void main(String[] args) {
		CRUDService<String, CustDTO> custService = new CustService();
		CustDTO cust1 = new CustDTO("id04", "pwd04", "신혜림", "01012341234");
		try {
			custService.register(cust1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
