package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustSelectTest {

	public static void main(String[] args) {
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		Cust cust = null;
		Cust cust2 = new Cust("id00", "pwd00", "비욘세", 39);
		Cust cust3 = new Cust("id01", "pwd00", "비욘세", 39);
		Cust cust4 = new Cust("id02", "pwd00", "비욘세", 39);
		
		try {
			crudService.register(cust2);
			crudService.register(cust3);
			crudService.register(cust4);
//			crudService.remove("id00");
//			System.out.println("삭제성공");
//			cust = crudService.get("id00");
			crudService.get();
			System.out.println(cust);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
