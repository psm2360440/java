package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserService;

public class UserRegisterTest {

	public static void main(String[] args) {
		CRUDService<String, UserDTO> service = new UserService();
		UserDTO obj = new UserDTO("id01", "pwd01", "james", "a@kbstar.com", "010-1004-1004");
		UserDTO obj2 = new UserDTO("id02", "pwd02", "james2", "a2@kbstar.com", "010-1004-1002");
		UserDTO obj3 = new UserDTO("id03", "pwd03", "james3", "a3@kbstar.com", "010-1004-1003");

		try {
			service.register(obj);
			service.register(obj2);
			service.register(obj3);
			service.register(obj);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("register------------------------------------------------------------");
		UserDTO selectUser = null;
		try {
			selectUser = service.get("id03");
			System.out.println(selectUser);	
			selectUser = service.get("id09");
			System.out.println(selectUser);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		System.out.println("get1-----------------------------------------------------------");
		List<UserDTO> list = null;
		try {
			list = service.get();
			for (UserDTO a : list) {
				System.out.println(a);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("getAll--------------------------------------------------------");
		try {
			service.remove("id09");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("remove-----------------------------------------------------------");
	}

}
