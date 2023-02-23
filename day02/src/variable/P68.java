package variable;

import java.util.Random; //랜덤패키지의 임포트, ctrl + shift + O

public class P68 {

	public static void main(String[] args) {
		String s1 = "10";
		int s2 = Integer.parseInt(s1);
		int a = 10;
		System.out.println(s1 + a); // 참조형과 일반형의 합은 강제로 일반형의 숫자 '10'을 문자로 바꾼다
		System.out.println(s2 + a);


		Random r = new Random();
		int rndNum = r.nextInt(45)+1;	 //<=, <
		System.out.println(rndNum);
	}
  
}
