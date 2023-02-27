package array;

import java.util.Scanner;

public class P122 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command[q,a1,a2,a3,a4]");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Quit...");
				break;
			} else if (cmd.equals("a1")) {

			} else if (cmd.equals("a2")) {

			} else if (cmd.equals("a3")) {
				
			} else if (cmd.equals("a4")) {

			} else {
				System.out.println("Invalid Command...");
				System.out.println("Try Again...");
			}
		}
		System.out.println("Bye...");

		sc.close(); // unreachable code : 무한반복으로 인하여 닿을 수 없는 코드 - 오류;
	}

}
