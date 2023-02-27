package array;

public class P103 {

	public static void main(String[] args) {
		int a = 100; //기본자료형 정수형
		
		int arr[] = new int[3];	//참조자료형 정수배열
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		for(int i = 0; i< arr.length; i++) {
			System.out.printf("%d \t", arr[i]);
		}
		System.out.println("Type 2 ");		
		for(int data:arr) {					//arr 배열 안의 int 값을 하나씩 찍어 줌;
			System.out.printf("%d \t", data);
		}
	}
}
