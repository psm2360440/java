package variable;

import java.util.Random; //랜덤패키지의 임포트, ctrl + shift + O

public class P68 {

	public static void main(String[] args) {
		String s1 = "10";
		int s2 = Integer.parseInt(s1);
		int a = 10;
		System.out.println(s1 + a); // 참조형과 일반형의 합은 강제로 일반형의 숫자 '10'을 문자로 바꾼다
		System.out.println(s2 + a);

		int n1 = 10;
		String n2 = String.valueOf(n1); // string 으로 변환 String.valueOf
		// String n2 = n1+ ""; 가장 간단하게 string으로 바꾸는 방법
		System.out.println(n2); // java.lang 패키지는 가장 자주 쓰이기 때문에 굳이 쓰기로 선언을 하지 않아도 자동으로 import 된다

		Random r = new Random();
		int rndNum = r.nextInt(45)+1;	 //<=, <
		System.out.println(rndNum);
	}
  
}
