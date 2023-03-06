package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDao implements DAO<String, UserDTO>{
	
	DAO<String, UserDTO> dao;


	
	@Override
	public void insert(UserDTO v) {
		System.out.println(v.getId()+"님이 회원가입되었습니다.");
	}

	@Override
	public void delete(String k) {
		System.out.println(k + "님이 탈퇴하였습니다.");
		
	}

	@Override
	public void update(UserDTO v) {
		System.out.println(v.getId() + "님이 수정되었습니다.");
	}


}
