package whilecontrol;

public class P92 {

	public static void main(String[] args) {
		System.out.println("Start...");
		int i = 1;
		int sum = 0;
		double avr = 0.0;
		while(i <= 100) {
			sum += i;
			i++;
		}
		avr = sum / ((i-1) * 1.0);
		System.out.println(sum);
		System.out.println(avr);
		System.out.printf("%d, %f \n", sum, avr);
		System.out.println("End..."+i);
	}

}