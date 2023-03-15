package com.kbstar.test;

import java.util.List;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountSelectAllTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> accService = new AccountService();
		List<AccountDTO> list = null;

		try {
			list = accService.get();
			if (list.size() == 0) {
				System.out.println("디지캠은행에 현재 활동 중인 계좌 정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}