package array;

import java.util.Arrays;
import java.util.Random;

public class P114 {

	public static void main(String[] args) {
		int arr[][] = new int[5][5];
		// int [][] arr,(O) int[]arr[](O)

		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = r.nextInt(9) + 1;
			}
		}

		
		 for(int[] a: arr) {
			 for(int b : a) {
				 System.out.printf("%d \t", b); }
		 System.out.println("\n"); }
		 

		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println("\n");
		}*/

		// 위의 내용을 for each

	}

}
