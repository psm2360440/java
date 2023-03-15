package com.kbstar.test;

import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustService;

public class CustSelectTest {

	public static void main(String[] args) {
		CRUDService<String, CustDTO> custService = new CustService();
		
		try {
			custService.get("id05");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}