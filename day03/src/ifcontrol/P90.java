package ifcontrol;

public class P90 {

	public static void main(String[] args) {
		int a = 10;
		int b =	20;
		int c = 15;
		
		//  두 수의 최대 값과 최소 값을 구하시오.
		int max = 0;
		int min = 0;
		

		//max = (a > b)? a : b;
		//min = (a < b)? a : b;
		
		//max = (a > b)? (a > c)? a :(b > c)? b : c c;
		//min = (a < b)? (a < c)? a : (b < c)? b : c: c;
		
		max = ((a > b)? a : b ) > c? ((a > b)? a : b) : c;
		min = ((a < b)? a : b) < c? ((a < b)? a : b) : c;
		
		
		if(a > b) {
			max = Math.max(a, c);
			min = Math.min(b, c);
		}else {
			max = Math.max(b, c);
			min = Math.min(a, c);
		}
		
		
		
		/*if (a>b) {
			max = a;
			min = b;
			if(a < c) {
				max= c;
			}else {
				if (b>c) {
					min=c;
				}
			}
			
		}else {
			max =b;
			min = a;
			if (b<c) {
				max = c;
			}else {
				if(a>c) {
					min = c;
				}
			}
		}
		
		*/
		
		
		
		
		
		
		/*int max = a;
		if (b>max) max = b;
		if (c>max) max = c;

		int min = a;
		if (b<min) min = b;
		if (c<min) min = c;

		System.out.printf("MAX: %d, MIN: %d",max,min);
		*/
		
		
		
		System.out.printf("MAX: %d, MIN: %d", max, min);
		
		
		
	}

}
