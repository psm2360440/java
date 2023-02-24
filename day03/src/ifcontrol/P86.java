package ifcontrol;

public class P86 {

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
		
		
		/*if(sum >= 90.0) {
			grade = "VIP";
		}else if(sum >= 70.0) {
			grade = "GOLD";
		}else {
			grade = "SILVER";
		}*/
		
		grade = (sum >= 90.0 )?   "VIP" : (sum >70.0) ? "GOLD" : "SILVER";
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			//return;							//흐름이 진행되다가 현재 행에서 종료.
		}
		System.out.printf("%s, %s, %4.2f \n", grade, gender, sum);
		
		System.out.println("End....");

	}

}
