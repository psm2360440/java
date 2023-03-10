package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.TransactionDAO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

public class TransactionService implements CRUDService<String, TransactionDTO> {

	DAO<String, TransactionDTO> transDao;
	Notification notification;

	public TransactionService() {
		transDao = new TransactionDAO();
		notification = new NotificationImpl();
	}
	
	@Override
	public void register(TransactionDTO v) throws Exception {
		try {
			transDao.insert(v);
		} catch (Exception e) {
			throw new Exception("거래 내역 생성 실패 ERCode : ERROR000001");
		}
	}

	@Override
	public void remove(String k) throws Exception {

	}

	@Override
	public void modify(TransactionDTO v) throws Exception {

	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;
		try {
			obj = transDao.select(k);
			return obj;
		} catch (Exception e) {
			throw new Exception("입력하신 내용에 해당하는 정보가 없습니다. ERCode ERROR000003");
		}
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;
		try {
		list = transDao.select();
		return list;
		} catch (Exception e) {
			throw new Exception("거래내역 정보 테이블이 존재하지 않습니다. ERCode ERROR000004");
		}
	}
}