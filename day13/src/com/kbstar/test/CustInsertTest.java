package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();

		Cust cust = new Cust("id38", "pwd20", "tom", 20);
		Cust cust2 = new Cust("id29", "pwd21", "tom2", 35);
		Cust cust3 = new Cust("id89", "pwd21", "tom2", 35);
		Cust cust4 = new Cust("id91", "pwd21", "tom2", 35);
		Cust cust5 = new Cust("id17", "pwd19", "김보고", 33);

		try {
//			crudService.register(cust);
//			System.out.println("등록 성공");
//			crudService.modify(cust2);
//			System.out.println("변경 성공");
//			crudService.modify(cust3);
//			crudService.remove(cust2.getId());
//			System.out.println("삭제 성공");
//			crudService.remove(cust3.getId());
			crudService.get(cust5.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

}
