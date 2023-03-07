package bank;

import java.util.Scanner;

public class App {
	//계좌 생성
	//계좌 정보 조회
	//계좌 입금
	//계좌 출금
	public static void main(String[] args) {
		Account acc = new Account();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input Command(c,w,d,s,q)..");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye...");
				break;
			}else if(cmd.equals("c")){
				System.out.println("Create Account:");
				System.out.println("Input Account Info[accHolder, balance]");
				System.out.println("Your Name Here");
				String accHolder = sc.next();
				System.out.println("Input Balance");
				double balance = Double.parseDouble(sc.next());
					try {
						acc = new Account(accHolder, balance);
					} catch (BelowZeroException e) {
						e.printStackTrace();
					}
				System.out.println(acc);
			}else if(cmd.equals("w")){
				System.out.println("Withdraw:");
				System.out.println("Input money");
				double money = Double.parseDouble(sc.next());
				try {
					acc.withdarw(money);
				} catch (BelowZeroException e) {
					e.printStackTrace();
				}
				System.out.println(acc);
			}else if(cmd.equals("d")){
				System.out.println("Deposit:");
				System.out.println("Input money");
				double money = Double.parseDouble(sc.next());
				try {
					acc.deposit(money);
				} catch (BelowZeroException e) {
					e.printStackTrace();
				}
				System.out.println(acc);
			}else if(cmd.equals("s")){
				System.out.println("Select:");
				System.out.println(acc);
			}else {
				System.out.println("입력 값을 확인하세요!");
			}
		}
		sc.close();
	}

}
