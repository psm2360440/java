package array;

public class P102 {

	public static void main(String[] args) {
		
		//int arr[] = new int[3];
		/*int []arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;				//다양한 배열 선언 방법 
		arr[2] = 30;*/
		int arr[] = {10, 20, 30};
		
		
		System.out.println("Type 2 ");		
		for(int data:arr) {					//arr 배열 안의 int 값을 하나씩 찍어 줌;
			System.out.printf("%d \t", data);
		}
	}
}
