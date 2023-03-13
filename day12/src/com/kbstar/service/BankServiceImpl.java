/**
 * 
 */
package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dao.TransactionDAO;
import com.kbstar.dao.UserDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

/**
 * @author psm23
 *
 */
public class BankServiceImpl implements BankService<UserDTO, AccountDTO, TransactionDTO, String, String> {
	
	DAO<String, AccountDTO> accountDao;
	DAO<String, UserDTO> userDao;
	DAO<String, TransactionDTO> transactionDao;
	Notification notification;

	public BankServiceImpl() {
		userDao = new UserDAO();
		notification = new NotificationImpl();
		accountDao = new AccountDAO();
		transactionDao = new TransactionDAO();

	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		} catch (Exception e) {
			throw new Exception("등록 오류");
		}
		notification.sendEmail(v.getEmail(), "축하합니다!");
		notification.sendSMS(v.getContact(), "축하합니다!");
	}

	@Override
	public UserDTO login(String k, String p) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		if (user != null) {
			if (user.getPwd().equals(p)) {
				System.out.println("LOGIN 성공");
			} else {
				throw new Exception("ID 또는 PW가 일치하지 않습니다!");
			}
		}else {
			throw new Exception("존재하지 않는 ID입니다!");
		}
		return user;
	}

	@Override
	public UserDTO getUserInfo(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		return user;
	}

	@Override
	public void makeAccounnt(String k, double balance) throws Exception {
		String accNo = MakeAccountNumber.makeAccNum();
		AccountDTO account = new AccountDTO(accNo, balance, k);
		accountDao.insert(account);
		UserDTO user = userDao.select(k);
		notification.sendEmail(user.getEmail(), accNo +"계좌 개설 감사합니다!");
		notification.sendSMS(user.getContact(), accNo +"계좌 개설 감사합니다!");
		
	}

	@Override
	public List<TransactionDTO> getAllTr(String acc) throws Exception {
		List<TransactionDTO> list = null;
		list = transactionDao.search(acc);
		return list;
	}

	@Override
	public void transaction(String sendACC, String receiveAcc, double balance, String desc) throws Exception {
		//계좌 정보 수정
		//계좌 잔액 정보를 조회하고 잔액에서 이체하는 금액을 차감한 잔액으로 수정
		UserDTO sendUser = null;
		AccountDTO send = null;
		send = accountDao.select(sendACC);
		double afterbal = send.getBalance() - balance;
		send.setBalance(afterbal);
		accountDao.update(send);
		//거래 내역 추가
		TransactionDTO senD = new TransactionDTO(MakeAccountNumber.makeTrNum(), sendACC, balance, "O", desc);
		transactionDao.insert(senD);
		// SMS, email전송
		String sendId = send.getHolder();
		sendUser = userDao.select(sendId);
		notification.sendEmail(sendUser.getEmail(), sendACC + "계좌에서 " + balance + "원이 출금되었습니다!");
		notification.sendSMS(sendUser.getContact(), sendACC + "계좌에서 " + balance + "원이 출금되었습니다!");
	}

	@Override
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		List<AccountDTO> list = null;
		list = accountDao.search(k);
		return list;
	}

}
