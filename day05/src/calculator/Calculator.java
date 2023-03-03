package calculator;

public class Calculator {
	public int sum(int a, int b) {
		int result = 0;
		result = a + b;
		return result;
	}
	
	public void save (int a) { 			//void의 사용: 어떤 결과를 반환하지 않고 실행되는 메소드???
		//void를 사용하면 리턴할 값은 없지만 처리 중 저장이 제대로 되지 않았을 경우,
		//제대로 저장되지 않았다는 점을 Ui에 알리는 것을 예외처리의 일례라 할 수 있음;
	}
}
