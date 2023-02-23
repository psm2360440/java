package variable;

public class P79 {

	public static void main(String[] args) {
		
		int credit = 900;
		//System.out.println(a);	//변수 선언 후, 초기화되지 않았음 
		String grade = "";
		if(credit >= 800) {
			grade = "High";
		}else {
			grade = "Low";
	}
		System.out.println(grade);
	}
}
