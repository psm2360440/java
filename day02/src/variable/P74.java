package variable;

import java.util.Random;
import java.util.Scanner;

public class P74 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 	//"화면에 입력한 값을 가지고 오겠다"
		System.out.println("숫자를 입력 하십시오(10~100)");
		String cmd = sc.next();
		//10에서 100사이의 정수를 입력 받는다.
		//1부터 입력 받은 숫자까지의 범위에서 랜덤한 숫자를 발생 하시오.
		int rndNum = Integer.parseInt(cmd);
		Random r = new Random();
		int run = r.nextInt(rndNum)+1;	 // 
		System.out.println(run);	
		sc.close();		//반드시 종료 해주어야 함.
		
		
		

	}

}
 
