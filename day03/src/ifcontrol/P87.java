package ifcontrol;

public class P87 {

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
		
		
		if (sum >= 90 && sum <=100) {
			grade = "VIP";
		}else if(sum >= 80) {
			grade = "GOLD";
		}else if(sum >= 70) {
			grade = "SILVER";
		}else if(sum >= 60) {
			grade = "BRONZE";
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
