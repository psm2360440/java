package ifcontrol;

import java.util.Scanner;

public class P93 {

	public static void main(String[] args) {
		//4개의 2자리수를 입력 받는다.
		//만약 2자리수가 아니면 프로그램 종료
		Scanner sc = new Scanner(System.in);
		int ko = 0;
		int en = 0;
		int ma = 0;
		int si = 0;
		int sum = ko + en + ma + si;
		double aver = sum / 4;
		
		System.out.println("국어성적 입력:");
		ko = Integer.parseInt(sc.next());
		if ( ko < 10 || ko >= 100) {
			sc.close();
			return;
		}
		System.out.println("영어성적 입력:");//String 으로 입력됨.
		en = Integer.parseInt(sc.next());
		if ( en < 10 || en >= 100) {
			sc.close();			// sc는 return 앞에서 먼저 닫아줘야 함;;;
			return;
		}
		System.out.println("수학성적 입력:");
		ma = Integer.parseInt(sc.next());
		if ( ma < 10 || ma >= 100) {
			sc.close();
			return;
		}
		System.out.println("과학성적 입력:");
		si = Integer.parseInt(sc.next());
		if ( si < 10 || si >= 100) {
			sc.close();
			return;
		}
		
		//평균과 합계를 구합니다.



		System.out.println(sum);
		System.out.println(aver);


		//평균이 90이상이면  A
		//평균이 80이상이면  B
		//평균이 70이상이면  C
		//평균이 60이상이면  D
		//60미만이면 F
		
		//합계, 평균, 학점을 출력 하시오.     
		
		String grade = "";
		
		if ( aver >= 90) {
			grade = "A";
		}else if( aver >= 80 ) {
			grade = "B";
		}else if( aver >= 70 ) {
			grade = "C";
		}else if( aver >= 60 ) {
			grade = "D";
		}else {
			grade = "F";
		}
		System.out.println(grade);
		
		System.out.printf("%d, %f, %s", sum, aver, grade);

		
		
		sc.close();
		

	
	}
}



