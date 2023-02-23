package variable;

import java.util.Random;
import java.util.Scanner;

public class P75 {


	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		//a++;
		//++b;
		System.out.printf("%d, %d\n",a,b);
		
		int result = ++a + b++;	//현재 라인까지는 +되지 않음;
		System.out.printf("%d, %d\n",a,b);
		System.out.println(result);
		
		System.out.println(5 >= 3);
		
		int aa = 10;
		int bb = 10;
		System.out.println((aa++ >= 0) || (bb++ >= 0));
		System.out.printf("%d,%d\n",aa,bb);
	}
	
	
	

}
 
