package com.kbstar.service;

import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccNumber;

public class AccountService implements CRUDService<String, AccountDTO> {

	DAO<String, AccountDTO> accDao;

	public AccountService() {
		accDao = new AccountDAO();
	}

	@Override
	public void register(AccountDTO v) throws Exception {
		try {
			String accNo = MakeAccNumber.makeAccNum();
			v.setAccNo(accNo);
			accDao.insert(v);
			System.out.println("계좌가 개설되었습니다.");
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("신규 입금 금액은 0원 이상입니다!");
			}
		}
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			accDao.delete(k);
			System.out.println("계좌가 정상적으로 해지되었습니다!");
		} catch (Exception e2) {
			if (e2 instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("존재하지 않는 계좌번호입니다! 확인 후 재시도 부탁드립니다!");
			}
		}
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		AccountDTO obj = null;
		try {
			obj = accDao.select(k);
			System.out.println(obj);
		} catch (Exception e3) {
			if (e3 instanceof SQLRecoverableException) {
				throw new Exception("네트워크 오류 발생!");
			} else {
				throw new Exception("존재하지 않는 계좌번호입니다! 확인 후 재시도 부탁드립니다!");
			}
		}
		return obj;
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		List<AccountDTO> list = null;
		try {
			list = accDao.select();
		} catch (Exception e4) {
			throw new Exception("네트워크 오류 발생!");
		}
		return list;
	}

	@Override
	public List<AccountDTO> find(String k) throws Exception {
		List<AccountDTO> myList = null;
		try {
			myList = accDao.search(k);
		} catch (Exception e5) {
			throw new Exception("네트워크 오류 발생!");
		}
		return myList;
	}
	
	@Override
	public void modify(AccountDTO v) throws Exception {
		accDao.update(v);
	}
}