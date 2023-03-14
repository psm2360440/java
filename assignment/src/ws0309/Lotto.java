package ws0309;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Lotto {

	HashSet<Integer> winningNum = new HashSet<Integer>();
	double prizeMoney = 0.0; // 총 당첨금
	int grade = 0; // 당첨 등수
	double money = 0.0; // 등수별 당첨금

	Random r = new Random();

	// 당첨 번호, 당첨금 생성 함수
	public void makeWinningNumberMoney() {
		while (winningNum.size() < 3) {
			int num = r.nextInt(25) + 1;
			winningNum.add(num);
		}
		prizeMoney = Double.parseDouble(r.nextInt(2000000000) + 1 + "");
		System.out.println("아래 당첨 정보는 관리자만 보입니다!");
		System.out.print("당첨 번호: " + winningNum + "\n");
		System.out.printf("총 당첨금: %10.0f원\n", prizeMoney);
	}

	// 당첨 확인 함수
	public int checkRanking(ArrayList<Integer> myNum) {
		int cnt = 0;
		for (int no : myNum) {
			if (winningNum.contains(no)) {
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("다음 기회에...이용해주셔서 감사합니다.");
		} else {
			switch (cnt) {
			case 3: {
				grade = 1;
				break;
			}
			case 2: {
				grade = 2;
				break;
			}
			case 1: {
				grade = 3;
				break;
			}
			}
			System.out.printf("축하합니다! %d등에 당첨되셨습니다.\n", grade);
		}
		return grade;
	}

	// 당첨 금액 확인 함수
	public double prizeMoney(int grade) {
		switch (grade) {
		case 1: {
			money = prizeMoney * 0.5;
			break;
		}
		case 2: {
			money = prizeMoney * 0.3;
			break;
		}
		case 3: {
			money = prizeMoney * 0.2;
			break;
		}
		}
		System.out.printf("%d등 실수령액은 %10.0f원 입니다. 축하합니다!\n", grade, money);
		return 0.0;
	}
}