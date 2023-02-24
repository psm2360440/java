package whilecontrol;

public class P95 {

	public static void main(String[] args) {
		System.out.println("Start...");
		int i = 1;
		int cnt = 0;
		int sum = 0;
		double avr = 0.0;
		while (i <= 100) {
			if (i % 2 == 0) {
				sum += i;
				cnt++;
			}
			if (i == 8) {
				break;
			}
			i++;
		}
		avr = sum / (cnt * 1.0);
		System.out.println(sum);
		System.out.println(avr);
		System.out.printf("%d, %f \n", sum, avr);
		System.out.println("End..." + i);
	}

}