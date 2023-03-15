package com.kbstar.test;

import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustService;

public class CustDeleteTest {

	public static void main(String[] args) {
		CRUDService<String, CustDTO> custService = new CustService();
		try {
			custService.remove("id08");
			System.out.println("탈퇴가 완료되었습니다!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
