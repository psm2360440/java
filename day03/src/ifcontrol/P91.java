package ifcontrol;

public class P91 {

	public static void main(String[] args) {
		int a = 10;
		int b =	20;
		
		//  두 수의 최대 값과 최소 값을 구하시오.
		int max = 0;
		int min = 0;
		
		max = (a > b)? a : b;
		min = (a < b)? a : b;
		
		if (a > b) { 
			max = a;
			min = b;
		}else {
			max = b;
			min = a;
		}
		
		
		System.out.printf("MAX: %d, MIN: %d", max, min);
		
		
		
	}

}
