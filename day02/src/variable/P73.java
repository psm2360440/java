package variable;

import java.util.Scanner;

public class P73 {


	public static void main(String[] args) {
		int a = 10;
		String str = "";
		Scanner sc = new Scanner(System.in); 	//"화면에 입력한 값을 가지고 오겠다"
		System.out.println("명령어를 입력 하시오(q,i,d,s)");
		String cmd = sc.next();
		System.out.printf("%s를 입력 했습니다.", cmd);	//입력 후 출력되야 종료됨
		sc.close();		//반드시 종료 해주어야 함.
		
		
		

	}

}
