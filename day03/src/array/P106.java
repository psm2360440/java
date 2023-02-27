package array;

import java.util.Arrays;
import java.util.Random;

public class P106 {

	public static void main(String[] args) {

		int arr[] = new int[10];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			int data = r.nextInt(99) + 1;
			arr[i] = data; // arr[i] = r.nextInt(99)+1; (배열의 선언과 대입을 동시에)
		}
		System.out.println(Arrays.toString(arr));  			//배열 정보 출력하기(대괄호'[]'안에 하나씩 출력 됨
		//배열에 홀수의 값들의 합과 평균을 구하시오!
		int sum  = 0;
		double avr = 0;
		int cnt = 0;
		for(int a:arr) {
			if(a % 2 == 1) {
				sum += a;
				cnt++;
			}
		}
		avr = sum*1.0 / cnt;
		System.out.println(sum);
		System.out.println(avr);
		System.out.printf("합은 %d, 평균은 %4.2f", sum, avr);
	}
}
