package ifcontrol;

public class P89 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 90.0;
		
		System.out.println("Start....");
		
		
		if(gender.equals("M")) {
			System.out.println("Male....");
		}else {
			System.out.println("Female....");
		}
		

		
		
		//if의 중첩
		if (gender.equals("M")){
			if(sum >= 90) {
				grade = "MVIP";
			}else if(sum >= 80 ) {
				grade = "MGOLD";
			}else { grade = "MNORMAL";
			}
		
		}else {
			if(sum >= 90) {
				grade = "FVIP";
			}else if(sum >= 80 ) {
				grade = "FGOLD";
			}else { grade = "FNORMAL";
			}
		
		}
		//grade = (sum >= 90.0 )?   "VIP" : (sum >70.0) ? "GOLD" : "SILVER";	
		
		
		//grade = (sum >= 90)? (gender.equals ("M"))? "MVIP" : "FVIP";
		
		grade = (gender.equals("M"))? ((sum>=90)? "MVIP" : (sum >= 80)? "MGOLD" : "MNORMAL") : ((sum>=90)? "FVIP" : (sum >= 80)? "FGOLD" : "FNORMAL");

		
		
		
		
		
		//switch 문
		switch(grade) {		//케이스 : 케이스 : ...케이스 : 다른 케이스 열거 후에 실행내용은 한 번에 적을 수 있음.
		case "FVIP" : 		//'관리자의 권한 부여'등과 같은 경우 switch 쓰면 유용. 
		case "MVIP" :
			sum += 100;
			break;
		case "FGOLD" :
		case "MGOLD" :
			sum += 90;
			break;
		default: 
			sum += 10; 		//마지막은 break; 안 써도 가능
		}
		
		
		
		
		

		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			//return;							//흐름이 진행되다가 현재 행에서 종료.
		}
		System.out.printf("%s, %s, %4.2f \n", grade, gender, sum);
		
		System.out.println("End....");

	}

}
