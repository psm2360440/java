package array;

public class P120 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		double avr = 0;
		int cnt = 0;
		for (int b : a) {
			sum += b;
			cnt++;
		}
		avr = sum * 1.0 / cnt;
		System.out.printf("총합은 %d, 평균은 %4.2f", sum, avr);

	}

}
