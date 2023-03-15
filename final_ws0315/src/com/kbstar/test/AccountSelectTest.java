package com.kbstar.test;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountSelectTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> accService = new AccountService();
		
		try {
			accService.get("015601-04-322005");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}