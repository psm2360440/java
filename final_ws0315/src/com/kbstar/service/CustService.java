package com.kbstar.service;

import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.CustDAO;
import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Msg;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

public class CustService implements CRUDService<String, CustDTO> {

	DAO<String, CustDTO> custDao;
	Notification notification;

	public CustService() {
		custDao = new CustDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(CustDTO v) throws Exception {
		// 비밀번호 암호화
		try {
			custDao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("");
			}
		}
		notification.sendSMS(v.getContact(), Msg.registerMsg1);
	}

	@Override
	public void remove(String k) throws Exception {
		CustDTO cust = null;
		try {
			cust = custDao.select(k);
			custDao.delete(k);
			notification.sendSMS(cust.getContact(), Msg.removeMsg1);
		} catch (Exception e4) {
			if (e4 instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("사용 중인 ID가 아닙니다!");
			}
		}
	}

	@Override
	public void modify(CustDTO v) throws Exception {
		try {
			custDao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("변경할 ID가 존재하지 않습니다!");
			}
		}
	}

	@Override
	public CustDTO get(String k) throws Exception {
		CustDTO cust = null;
		try {
			cust = custDao.select(k);
			System.out.println(cust);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("해당 ID가 존재하지 않습니다!");
			}
		}
		return cust;
	}

	@Override
	public List<CustDTO> get() throws Exception {
		List<CustDTO> list = null;
		try {
			list = custDao.select();
		} catch (Exception e) {
			throw new Exception("네트워크 오류 발생!");
		}
		return list;
	}

	@Override
	public List<CustDTO> find(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}