package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class AccountService implements CRUDService<String, AccountDTO>{
	
	DAO<String, AccountDTO> accDao;
	Notification notification;

	
	
	public AccountService() {
		accDao = new AccountDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(AccountDTO v) throws Exception {
		try {
		accDao.insert(v);
		} catch(Exception e) {
			throw new Exception("계좌 개설 거래 실패 ERCode : ERROR000001");
		}
	}

	@Override
	public void remove(String k) throws Exception {
		try {
		accDao.delete(k);
		} catch (Exception e) {
			throw new Exception("계좌 해지 거래 실패 ERCode : ERROR000002");
		}
	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		try {
			accDao.update(v);
		} catch(Exception e) {
			throw new Exception("수정할 계좌 정보가 존재하지 않습니다.");
		}
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		AccountDTO obj = null;
		try {
		obj = accDao.select(k);
		return obj;
		} catch (Exception e) {
			throw new Exception("입력하신 계좌 정보가 없습니다. ERCode ERROR000003");
		}
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		List<AccountDTO> list = null;
		try {
		list = accDao.select();
		return list;
		} catch (Exception e) {
			throw new Exception("계좌 정보 테이블이 존재하지 않습니다. ERCode ERROR000004");
		}
	}
	
}
