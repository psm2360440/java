package whilecontrol;

public class P94 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오.
		// 짝수만 구하시오.
		System.out.println("Start...");
		int cnt = 0;
		int sum = 0;
		double avr = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
				cnt++;
				// continue; // 조건이 맞으면 넘어간다; 조건이 안 맞으면 내려가서 실행한다.
			}
			if (i == 8) {
				break; // 프로그램 종료는 return; for문 등의 반복의 종료는 break;
			}
		}
		avr = sum / (cnt * 1.0); // 실수로 만들기
		System.out.println(sum);
		System.out.println(avr);
		System.out.println("End..." + cnt);
	}

}