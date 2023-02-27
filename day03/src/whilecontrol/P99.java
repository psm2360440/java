package whilecontrol;

public class P99 {

	public static void main(String[] args) {
		myfor: 
		for (int i = 2; i < 10; i++) {
			System.out.printf("%d 단 \n", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d \t", i, j, (i * j));
				if ((i*j)==21) {
					
					//i = 11 
					break myfor; //for문의 scope를 정하여 탈출할 for문을 명시하여 줌.
				}
			}
			System.out.println("");
			
		}


		
	}
}
