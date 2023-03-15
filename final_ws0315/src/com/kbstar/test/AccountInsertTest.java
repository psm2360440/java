package com.kbstar.test;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountInsertTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> accService = new AccountService();
		AccountDTO acc1 = new AccountDTO("1", 30000, "id02");
		try {
			accService.register(acc1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}