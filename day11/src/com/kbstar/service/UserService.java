package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Msg;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class UserService implements CRUDService<String, UserDTO>{
	
	DAO<String, UserDTO> userDao;
	Notification notification;
	
	public UserService() {
		userDao = new UserDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		//비밀번호 암호화
		try {
		userDao.insert(v);
		} catch(Exception e) {
			throw new Exception ("회원가입에 실패하였습니다. (ERCode: ER0001)");
		}
		notification.sendEmail(v.getEmail(), Msg.registerMsg1);
		notification.sendSMS(v.getContact(), Msg.registerMsg2);
	}

	@Override
	public void remove(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		try {
			userDao.delete(k);
			notification.sendSMS(user.getContact(), Msg.removeMsg2);
			notification.sendEmail(user.getEmail(), Msg.removeMsg1);
		}catch(Exception e) {
			throw new Exception("회원 탈퇴가 처리되지 않았습니다.");
		}
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try{ 
			userDao.update(v);
		}catch(Exception e) {
			throw new Exception("회원정보 수정 오류입니다.");
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO obj = null;
		obj = userDao.select(k);
		return obj;
	}

	@Override
	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		try {
		list = userDao.select();
		} catch (Exception e) {
			throw new Exception("조회 결과가 없습니다!");
		}
		return list;
	}
}