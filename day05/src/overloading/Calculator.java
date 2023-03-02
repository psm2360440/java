package overloading;


// 함수명과 리턴값 형태는 같아도 아규먼트의 형태만 달라도 가능~
public class Calculator {
	public int sum(int a, int b) {
		int result = 0;		//생량가능
		result = a + b;		//생략가능
		return result;
	}
	public double sum(int a, double b) {
		double result = 0;		
		result = a + b;
		return result;
	}
	public int sum(int a, int b, int c) {
		int result = 0;
		result = a + b + c;	
		return result;
	}
	public int sum(int a, int b, int c, int d) {
		int result = 0;
		result = a + b + c + d;	
		return result;
	}

}