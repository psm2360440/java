package p214;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int num = 0;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Number...");
		try {
			num = Integer.parseInt(sc.next());
			result = 10 / num;
			System.out.println(result);
			// } catch (Exception e) { //Exception e = new 어쩌구저쩌구 exception; Exception은 최상위 예외 클래스이므로
		} catch(ArithmeticException e1) {
			System.out.println("Warning!!! '0' is not allowed");
			return;
		} catch(NumberFormatException e2) {
			System.out.println("Warning!!! Numbers only");
			// e.printStackTrace();
			return;
		}finally {
			System.out.println("반드시 실행!");
			sc.close();
		}
		System.out.println("End App!");
	}
}