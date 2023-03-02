package ws0302;

public class App {
	public static void main(String[] args) {
		
		//1. 6개의 Account 객체 배열을 입력
		Account acc[] = new Account[6];
		acc[0] = new Account("james1", 10000, 0.35, "VIP");
		acc[1] = new Account("james2", 10000, 0.45, "GOLD");
		acc[2] = new Account("james3", 10000, 0.55, "SIVER");
		acc[3] = new Account("james4", 10000, 0.15, "GOLD");
		acc[4] = new Account("james5", 10000, 0.28, "SIVER");
		acc[5] = new Account("james6", 10000, 0.31, "VIP");
		
		
		//2. 6개의 계좌 정보 출력
		for (Account a : acc) {
			System.out.println(a);
		}
		
		//3. 모든 계좌의 잔액과 현재 이자금액 출력
		for (Account a : acc) {
			System.out.printf("현재 잔액은 %6.2f원 입니다. 그리고 현재 이자 금액은 %6.2f원 입니다.\n", a.getBalance(), a.getInterest());
		}
		
		//4. VIP들의 잔액의 합과 평균(현재이자금액을 합산한 잔액으로 출력했습니다.)
		double vSum = 0.0;
		double vAvg = 0.0;
		int cnt = 0;
		for (Account a : acc) {
			if (a.getGrade().equals("VIP")) {
				vSum += (a.getBalance() + a.getInterest());
				cnt++;
			}
		}
		vAvg = (vSum * 1.0) / cnt;
		System.out.printf("우리 VIP고객님들의 잔액의 합은 %6.2f원이고 평균 잔액은 %6.2f원 입니다.\n", vSum, vAvg);
	}
}
