package ifcontrol;

public class P88 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 85.0;
		
		System.out.println("Start....");
		
		
		if(gender.equals("M")) {
			System.out.println("Male....");
		}else {
			System.out.println("Female....");
		}
		
		if((sum >=95 && sum <= 100) || (sum <= 90 && sum >= 85)){
			grade = "VIP";
		}else if( (sum <= 80 && sum >= 75) || (sum <= 65 && sum >= 60)) {
			grade = "GOLD";
		}else {
			grade = "NORMAL";
		}
		
		
		
		
		
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			//return;							//흐름이 진행되다가 현재 행에서 종료.
		}
		System.out.printf("%s, %s, %4.2f \n", grade, gender, sum);
		
		System.out.println("End....");

	}

}
