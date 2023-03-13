package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.service.BankServiceImpl;

public class App {

	public static void main(String[] args) {
		BankService<UserDTO, AccountDTO, TransactionDTO, String, String> service = new BankServiceImpl();

		Scanner sc = new Scanner(System.in);
		while (true) {
			UserDTO user = null;
			System.out.println("Login(l) or Register(r) Quit(q)...");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				break;
			} else if (cmd.equals("r")) {
				System.out.println("Register..");
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				String email = sc.next();
				String contact = sc.next();
				user = new UserDTO(id, pwd, name, email, contact);
				try {
					service.register(user);
					System.out.println("Welcome!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (cmd.equals("l")) {
				System.out.println("Login..");
				String id = sc.next();
				String pwd = sc.next();
				user = null;
				try {
					user = service.login(id, pwd);
					System.out.println(user);
					System.out.println("로그인 성공!");
					System.out.println(
							"------------------------------------------------------------------------------------");
					while (true) {
						System.out.println(
								"MakeAcc(m), Transaction(t), SelectAcc(a), userInfo(i) TransactionSelect(tr) Quit(e)");
						String cmn = sc.next();
						if (cmn.equals("e")) {
							break;
						} else if (cmn.equals("m")) {
							System.out.println("Make Account...");
							double balance = Double.parseDouble(sc.next());
							service.makeAccounnt(user.getId(), balance);
							System.out.println("MakeAccount Completed");
						} else if (cmn.equals("t")) {
							System.out.println("Transaction...");
							String sendAcc = sc.next();
							String receiveAcc = sc.next();
							double balance = Double.parseDouble(sc.next());
							String desc = sc.next();
							service.transaction(sendAcc, receiveAcc, balance, desc);
							System.out.println("Transaction Completed!!!");
						} else if (cmn.equals("a")) {
							System.out.println("Select Account...");
							List<AccountDTO> list = null;
							list = service.getAllAccount(user.getId());
							for (AccountDTO acc : list ) {
								System.out.println(acc);
							}
						} else if (cmn.equals("i")) {
							System.out.println("User Info...");
							UserDTO ruser = null;
							String rid = user.getId();
							ruser = (service.getUserInfo(rid));
							System.out.println(ruser);
							System.out.println("Userfo Completed");
						} else if (cmn.equals("tr")) {
							System.out.println("Select Transaction...");
							String accNo = sc.next();
							List<TransactionDTO> list = null;
							list = service.getAllTr(accNo);
							System.out.println(list);
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