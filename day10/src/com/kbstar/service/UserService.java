package com.kbstar.service;

import com.kbstar.dao.UserDao;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class UserService implements Service<String, UserDTO>{
	DAO<String, UserDTO> dao;
	
	public UserService() {
		dao = new UserDao();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		System.out.println("Security Checked...");
		try {
			dao.insert(v);
		} catch (Exception e) {
			throw e;
		}
		System.out.println("registered...");
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			dao.delete(k);
		} catch (Exception e) {
			//log가 한 번 찍히고 밑줄에서 app으로 exception 발생을 던짐! try,catch구문 밑의 sysout은 아예 실행되지 않음.
			throw e;//app까지 던지는 두가지 방법; 바로 코드 밖에 throws 하거나 try/catch해서 throw e; 하고 구문밖에 다시 throws
			//try,catch를 적고 throw를 하면 로그로 남기 때문에 대처나 해결에 용이하다. (이 방법이 정상적)
		}
		System.out.println("Removed...");
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			throw e;
		}
		System.out.println("Modification Success");

	}

}
