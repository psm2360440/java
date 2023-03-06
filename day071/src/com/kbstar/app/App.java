package com.kbstar.app;

import com.kbstar.dao.AccountMariaDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class App {

	public static void main(String[] args) {
		DAO dao = new AccountMariaDAO();
		AccountDTO account = new AccountDTO("100", "자유저축", 1000);
		dao.delete(account);
		
		
		
		
		//UserDTO user = new UserDTO("id01", "pwd01", "james");
		//dao.insert(user);
	}

}
