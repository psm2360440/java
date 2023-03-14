package ws0309;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 로또 생성

		Lotto gameSet = new Lotto();
		while (true) {
			// 당첨 번호, 당첨 금액 생성
			gameSet.makeWinningNumberMoney();
			System.out.println("로또 당첨 번호와 당첨금이 생성되었습니다. 게임을 시작합니다!");

			// 번호 입력 받기
			System.out.println("첫번째 행운의 번호를 입력하세요!");
			int a = Integer.parseInt(sc.next());
			System.out.println("두번째 행운의 번호를 입력하세요!");
			int b = Integer.parseInt(sc.next());
			System.out.println("마지막 행운의 번호를 입력하세요!");
			int c = Integer.parseInt(sc.next());

			// 입력받은 번호로 리스트 생성
			ArrayList<Integer> myNum = new ArrayList<Integer>();
			myNum.add(a);
			myNum.add(b);
			myNum.add(c);

			// 일치하는 번호 비교
			gameSet.checkRanking(myNum);
			try {
				Thread.sleep(1000);
				System.out.println("당첨금 확인을 위하여 등수를 입력해주세요! (숫자만)");
			} catch (InterruptedException e) {
			}

			// 등수 입력 받기
			int grade = Integer.parseInt(sc.next());

			// 당첨 금액 출력
			gameSet.prizeMoney(grade);

			// 게임 반복
			System.out.println("종료하시려면 'q'를 눌러주세요!\n이외의 키를 누르면 새로운 게임이 시작됩니다!");
			String quit = sc.next();
			if (quit.equals("q")) {
				System.out.println("GOOD BYE");
				break;
			}
		}
		sc.close();
	}
}