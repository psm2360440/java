package variable;

import java.util.Scanner;

public class P81 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Number..");
		int num = Integer.parseInt(sc.next());
		String result = (num > 10) ? "정상" : "비정상";
		System.out.println(result);
		sc.close();
	}
}
