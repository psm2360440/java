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
	public void register(UserDTO v) {
		System.out.println("Security Checked...");
		System.out.println("registered...");
	}

	@Override
	public void remove(String k) {
		System.out.println("Removed...");
	}

	@Override
	public void modify(UserDTO v) {
		System.out.println("Modification Success");

	}

}
