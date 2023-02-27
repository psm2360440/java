package array;

import java.util.Arrays;
import java.util.Random;

public class P105 {

	public static void main(String[] args) {

		int arr[] = new int[5];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			int data = r.nextInt(9) + 1;
			arr[i] = data; // arr[i] = r.nextInt(99)+1; (배열의 선언과 대입을 동시에)
		}
		System.out.println(Arrays.toString(arr));  			//배열 정보 출력하기(대괄호'[]'안에 하나씩 출력 됨
		
		//for (int a : arr) {
		//	System.out.printf("%d \t \n", a);
		//}
		
		//배열의 합과 평균을 구하시오.
		//홀수 번재의 합과 평균을 구하시오.
		int sum = 0;
		double avr = 0;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if (i % 2 == 1) {
				sum +=arr[i];
				cnt++;
			}
		}
		avr = sum*1.0 / cnt;
		System.out.println(sum);
		System.out.println(avr);
		System.out.printf("홀수번째의 합은 %d, 평균은 %4.2f", sum, avr);
	}
}
