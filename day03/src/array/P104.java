package array;

import java.util.Arrays;
import java.util.Random;

public class P104 {

	public static void main(String[] args) {

		int arr[] = new int[10];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			int data = r.nextInt(99) + 1;
			arr[i] = data; // arr[i] = r.nextInt(99)+1; (배열의 선언과 대입을 동시에)
		}
		System.out.println(Arrays.toString(arr));  			//배열 정보 출력하기(대괄호'[]'안에 하나씩 출력 됨
		
		//for (int a : arr) {
		//	System.out.printf("%d \t \n", a);
		//}
		
		//배열의 합과 평균을 구하시오.
		int sum = 0;
		for (int a:arr) {
			sum +=a;
		}
		double avr = sum *1.0 / arr.length;
		System.out.println(sum);
		System.out.println(avr);
		
	}
}
