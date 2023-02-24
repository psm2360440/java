package whilecontrol;

public class P93 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오.

		System.out.println("Start...");
		int cnt = 0;
		int sum = 0;
		double avr = 0;
		for (int i = 1; i <= 138; i++) {
			sum += i;
			cnt++;
		}
		avr = sum / (cnt*1.0);			//실수로 만들기
		System.out.println(sum);
		System.out.println(avr);
		System.out.println("End..." + cnt);
	}

}