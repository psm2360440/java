package ifcontrole;

public class Ws {

	public static void main(String[] args) {
		System.out.println("Start...");
		int cnt = 0;
		int sum = 0;
		double avr = 0;
		int cnt4 = 0;
		int sum4 = 0;
		double avr4 = 0;
		int cnt7 = 0;
		int sum7 = 0;
		double avr7 = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
				cnt++;
			}

			if (i % 4 == 0) {
				sum4 += i;
				cnt4++;
			}

			if (i % 7 == 0) {
				sum7 += i;
				cnt7++;
			}
		}
		avr = sum / (cnt * 1.0); // 실수로 만들기 3배수
		System.out.printf(" %d, %f, %d\n", sum, avr, cnt);

		avr4 = sum4 / (cnt4 * 1.0); // 실수로 만들기 4배수
		System.out.printf(" %d, %f, %d\n", sum4, avr4, cnt4);

		avr7 = sum7 / (cnt7 * 1.0); // 실수로 만들기 7배수
		System.out.printf(" %d, %f, %d\n", sum7, avr7, cnt7);
	}
}

