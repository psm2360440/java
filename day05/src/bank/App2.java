package bank;

import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Account acc = null;				//reference타입은 "null"값으로 초기화; while문 밖에 변수로 선언함!!!
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input Command(c,w,d,s,q)..");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye...");
				break;
			}else if(cmd.equals("c")){
				System.out.println("Create Account:");
				System.out.println("Input Account Info[name, balance]");
				System.out.println("Your Name Here");
				String name = sc.next();
				System.out.println("Input Balance");
				double balance = Double.parseDouble(sc.next());
				acc = new Account(name, balance);
				System.out.println(acc);
			}else if(cmd.equals("w")){
				System.out.println("Withdraw:");
				System.out.println("Input money");
				double money = Double.parseDouble(sc.next());
				acc.withdarw(money);
				System.out.println(acc);
			}else if(cmd.equals("d")){
				System.out.println("Deposit:");
				System.out.println("Input money");
				double money = Double.parseDouble(sc.next());
				acc.deposit(money);
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
