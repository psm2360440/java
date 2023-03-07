package p214;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		int num = 0;
		int result = 0;
		//자체적으로 scanner를 try/catch문 안에서 사용하면 try/catch문이 닫히면서 스캐너도 자동으로 클로즈된다!
		//단 자동으로 sc.close();되면서 추후 발생하는 예외사항에 대한 처리가 불가능하다.
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input Number...");
			num = Integer.parseInt(sc.next());
			result = 10 / num;
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
		System.out.println("End App!");
	}
}