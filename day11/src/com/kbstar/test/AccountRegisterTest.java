package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountRegisterTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> service = new AccountService();
		AccountDTO acc01 = new AccountDTO("111", 10000, "sunmi");
		AccountDTO acc02 = new AccountDTO("222", 20000, "sunmi2");
		AccountDTO acc03 = new AccountDTO("333", 30000, "sunmi3");
		AccountDTO acc04 = new AccountDTO("444", 40000, "sunmi4");
		
		//register
		System.out.println("register------------------------------------------");
		try {
			service.register(acc01);
			System.out.println(acc01);
			service.register(acc02);
			System.out.println(acc02);
			service.register(acc03);
			System.out.println(acc03);
			service.register(acc01);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//remove
		System.out.println("remove----------------------------------------------");
		try {
			service.remove("111");
			System.out.println("해지되었습니다.");
			service.remove("555");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//select
		System.out.println("select-----------------------------------------------");
		AccountDTO selectAcc = null;
		try {
			selectAcc = service.get("222");
			System.out.println(selectAcc);
			selectAcc = service.get("111");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//selectALL
		System.out.println("selectALL---------------------------------------------");
		List<AccountDTO> list = null;
		try {
			list = service.get();
			for(AccountDTO acc : list) {
				System.out.println(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("위는 SA 정상출력 테스트 아래는 SA 예외 테스트");
		try {
			service.remove("222");
			service.remove("333");
			list = service.get();
			for (AccountDTO acc2 : list) {
				System.out.println(acc2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//modify
		System.out.println("modify---------------------------------------------");
		try {
			service.modify(acc04);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
