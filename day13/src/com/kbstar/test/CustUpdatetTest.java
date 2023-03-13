package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustUpdatetTest {

	public static void main(String[] args) {
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();

		Cust cust = new Cust("id02", "pwd20", "tom", 20);
		Cust cust2 = new Cust("id29", "pwd21", "tom2", 35);
		Cust cust3 = new Cust("id89", "pwd21", "tom2", 35);
		Cust cust4 = new Cust("id91", "pwd21", "tom2", 35);

		try {
//			crudService.register(cust);
//			//System.out.println("등록 성공");
//			crudService.modify(cust);
//			System.out.println("변경 성공");
//			crudService.modify(cust3);
//			crudService.remove(cust2.getId());
//			System.out.println("삭제 성공");
//			crudService.remove(cust3.getId());
			crudService.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

}
