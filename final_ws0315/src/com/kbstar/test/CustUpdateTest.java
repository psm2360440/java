package com.kbstar.test;

import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustService;

public class CustUpdateTest {

	public static void main(String[] args) {
		
		CRUDService<String, CustDTO> custService = new CustService();
		CustDTO cust1 = new CustDTO("id08", "pwd01", "선미팕", "01079177197");
		
		try { 
			custService.modify(cust1);
			System.out.println("회원정보가 수정되었습니다!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}