/**
 * 
 */
package com.kbstar.service;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dao.CustDAO;
import com.kbstar.dao.TrDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.CustDTO;
import com.kbstar.dto.TrDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

/**
 * @author psm23
 *
 */
public class BankServiceImpl implements BankService<CustDTO> {

	DAO<String, CustDTO> custDao;
	DAO<String, AccountDTO> accDao;
	DAO<String, TrDTO> trDao;
	Notification notification;

	public BankServiceImpl() {
		custDao = new CustDAO();
		accDao = new AccountDAO();
		trDao = new TrDAO();
		notification = new NotificationImpl();
	}

	@Override
	public CustDTO login(String id, String pwd) throws Exception {
		CustDTO cust = null;
		try {
			cust = custDao.select(id);
			if (cust != null) {
				if (cust.getPwd().equals(pwd)) {
					System.out.println(cust.getName() + "님이 로그인되었습니다!");
				} else {
					throw new Exception("ID 또는 PW가 일치하지 않습니다!");
				}
			}
		} catch (Exception e) {
			throw new Exception("ID 또는 PW가 일치하지 않습니다!");
		}
		return cust;
	}

	@Override
	public void register(CustDTO v) throws Exception {
		try {
			custDao.insert(v);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void transaction(String myAcc, String opositAcc, double amount) throws Exception {
		// 출금 계좌, 입금 계좌 각각 잔액을 수정하고 각 계좌에 대한 거래내역을 추가, SMS를 보낸다

		CustDTO sendCust = null; // 보내는 사람
		CustDTO counter = null; // 거래 상대방
		AccountDTO sendAcc = null; // 출금 계좌
		AccountDTO counterAcc = null; // 상대 계좌

		if (amount <= 0) {
			// 송금 금액이 0원 이하 작을 경우
			throw new Exception("송금 금액을 확인해주세요!");
		} else if (myAcc.equals(opositAcc)) {
			// 동일한 계좌 번호 입력할 경우
			throw new Exception("계좌 번호 확인 후 재시도 부탁드립니다!");
		} else {
			// 보낸 사람 잔액 수정
			sendAcc = accDao.select(myAcc);
			double newBalance = sendAcc.getBalance() - amount;
			sendAcc.setBalance(newBalance);
			accDao.update(sendAcc);
			// 받은 사람 잔액 수정
			counterAcc = accDao.select(opositAcc);
			double counterNewBalance = counterAcc.getBalance() + amount;
			counterAcc.setBalance(counterNewBalance);
			accDao.update(counterAcc);
			// 보낸 사람 거래 내역 추가
			TrDTO sendTr = new TrDTO(myAcc, opositAcc, "출금", amount);
			trDao.insert(sendTr);
			TrDTO counterTr = new TrDTO(opositAcc, "invisible", "입금", amount);
			trDao.insert(counterTr);
			// 보낸 사람 SMS전송
			String sendCustId = sendAcc.getHolder_id();
			sendCust = custDao.select(sendCustId);
			notification.sendSMS(sendCust.getContact(),
					myAcc + "계좌에서 " + opositAcc + "계좌로 " + amount + "원이 출금되었습니다!\n현재 잔액은 " + newBalance + "원 입니다!");
			// 받은 사람 SMS전송
			String counterPartyId = counterAcc.getHolder_id();
			counter = custDao.select(counterPartyId);
			notification.sendSMS(counter.getContact(),
					opositAcc + "계좌로 " + amount + "원이 입금되었습니다!\n현재 잔액은 " + counterNewBalance + "원 입니다!");
		}
	}
}