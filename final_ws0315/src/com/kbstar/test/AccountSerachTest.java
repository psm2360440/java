package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountSerachTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> accService = new AccountService();
		List<AccountDTO> myList = null;
		try {
			myList = accService.find("id02");
			if(myList.size() == 0 ) {
				System.out.println("해당 ID로 활동 중인 계좌가 없습니다!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}