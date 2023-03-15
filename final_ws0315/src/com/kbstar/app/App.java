package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.CustDTO;
import com.kbstar.dto.TrDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;
import com.kbstar.service.BankServiceImpl;
import com.kbstar.service.CustService;
import com.kbstar.service.TrService;

public class App {

	public static void main(String[] args) {
		BankService<CustDTO> bankService = new BankServiceImpl();
		CRUDService<String, CustDTO> custService = new CustService();
		CRUDService<String, AccountDTO> accountService = new AccountService();
		CRUDService<String, TrDTO> trService = new TrService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			CustDTO cust = null;
			System.out.println("Login(l) or Register(r) Quit(q)...");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				break;
			} else if (cmd.equals("r")) {
				System.out.printf("디지캠 은행 가입자 정보 등록");
				System.out.println("사용하실 ID를 입력해주세요!");
				String id = sc.next();
				System.out.println("사용하실 비밀번호를 입력해주세요!");
				String pwd = sc.next();
				System.out.println("고객님의 성함을 입력해주세요!");
				String name = sc.next();
				System.out.println("연락 가능한 핸드폰번호를 입력해주세요!");
				String contact = sc.next();
				cust = new CustDTO(id, pwd, name, contact);
				try {
					custService.register(cust);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (cmd.equals("l")) {
				System.out.println("Login..");
				System.out.println("ID를 입력하세요!");
				String id = sc.next();
				System.out.println("비밀번호를 입력하세요!");
				String pwd = sc.next();
				cust = null;
				try {
					cust = bankService.login(id, pwd);
					System.out.println(cust);
					System.out.println(
							"------------------------------------------------------------------------------------");
					if (cust.getId().equals("admin")) {
						while (true) {
							System.out.println("디지캠은행 관리자모드로 접속하셨습니다!");
							System.out.println("AllCustInfo(c), AllAccountInfo(a), AllTransactionInfo(t), log-Out(o)");
							String admin = sc.next();
							if (admin.equals("o")) {
								break;
							} else if (admin.equals("c")) {
								List<CustDTO> list = null;
								System.out.println("디지캠은행 전체 고객 정보 조회 화면입니다!");
								list = custService.get();
								if (list.size() == 0) {
									System.out.println("현재 거래 중인 고객이 존재하지 않습니다!");
								} else {
									for (CustDTO client : list) {
										System.out.println(client);
									}
								}
							} else if (admin.equals("a")) {
								List<AccountDTO> list = null;
								System.out.println("디지캠은행 전체 계좌 조회 화면입니다!");
								list = accountService.get();
								if (list.size() == 0) {
									System.out.println("현재 거래 중인 계좌가 존재하지 않습니다!");
								} else {
									for (AccountDTO acc : list) {
										System.out.println(acc);
									}
								}
							} else if (admin.equals("t")) {
								List<TrDTO> list = null;
								System.out.println("디지캠은행 전체 거래내역 조회 화면입니다!");
								list = trService.get();
								if (list.size() == 0) {
									System.out.println("전행에 존재하는 거래내역이 없습니다!");
								} else {
									for (TrDTO tr : list) {
										System.out.println(tr);
									}
								}
							}
						}
					} else {
						while (true) {
							System.out.println(
									"MakeAcc(m), Transaction(t), SelectAcc(a), userInfo(i), infoUpdate(u), userClose(c), TransactionSelect(tr), Quit(e)");
							String cmn = sc.next();
							if (cmn.equals("e")) {
								break;
							} else if (cmn.equals("m")) {
								AccountDTO acc = null;
								System.out.println("계좌 개설을 시작합니다!");
								System.out.println("신규 입금 금액을 입력해주세요!");
								double balance = Double.parseDouble(sc.next());
								acc = new AccountDTO(balance, cust.getId());
								accountService.register(acc);
								System.out.println("MakeAccount Completed");
								System.out.println(acc);
							} else if (cmn.equals("t")) {
								System.out.println("송금하기 화면입니다!");
								System.out.println("출금 계좌를 선택해주세요!");
								String myAcc = sc.next();
								System.out.println("입금할 계좌 번호를 입력해주세요!");
								String opositAcc = sc.next();
								System.out.println("보내실 금액을 입력해주세요!");
								double amount = Double.parseDouble(sc.next());
								try {
									bankService.transaction(myAcc, opositAcc, amount);
									System.out.println("송금이 완료되었습니다!");
								} catch (Exception e10) {
									System.out.println(e10.getMessage());
								}
							} else if (cmn.equals("a")) {
								System.out.println("회원님의 모든 계좌를 불러 옵니다!");
								List<AccountDTO> myList = null;
								myList = accountService.find(cust.getId());
								if (myList.size() == 0) {
									System.out.println("회원님이 보유하신 활동 계좌가 없습니다!");
								} else {
									for (AccountDTO acc : myList) {
										System.out.println(acc);
									}
								}
							} else if (cmn.equals("i")) {
								System.out.println("회원 정보 조회 화면입니다.");
								String rid = cust.getId();
								custService.get(rid);
								System.out.println("회원 정보 조회 완료!");
							} else if (cmn.equals("u")) {
								System.out.println("회원 정보 변경 화면입니다.");
								System.out.println("새로운 비밀번호를 입력해주세요!");
								String newPwd = sc.next();
								System.out.println("새로운 연락처를 입력해주세요!");
								String newContact = sc.next();
								cust.setPwd(newPwd);
								cust.setContact(newContact);
								custService.modify(cust);
								System.out.println("회원 정보가 변경되었습니다!");
							} else if (cmn.equals("c")) {
								System.out.println("회원 탈퇴 화면입니다.");
								System.out.println("디지캠은행과 거래를 종료하시려면 회원님의 ID를 한 번 더 입력해주세요!");
								String delId = sc.next();
								custService.remove(delId);
								System.out.println("그동안의 거래 감사드립니다! 회원 탈퇴가 정상적으로 이루어졌습니다!");
							} else if (cmn.equals("tr")) {
								System.out.println("내 계좌 거래내역 조회 화면 입니다!");
								System.out.println("조회하실 계좌번호를 입력해주세요!");
								String accNo = sc.next();
								AccountDTO myAcc = null;
								myAcc = accountService.get(accNo);
								if (myAcc.getHolder_id().equals(cust.getId())) {
									List<TrDTO> myList = null;
									myList = trService.find(accNo);
									if (myList.size() == 0) {
										System.out.println("해당 계좌로 거래내역이 존재하지 않습니다!");
									} else {
										for (TrDTO tr : myList) {
											System.out.println(tr);
										}
									}
								} else {
									System.out.println("본인 계좌만 거래내역을 조회할 수 있습니다. 계좌 번호 확인 후 시도 부탁드립니다!");
								}

							}
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		sc.close();
	}
}